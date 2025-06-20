
package com.controller;

import java.io.File;
import java.math.BigDecimal;
import java.net.URL;
import java.text.SimpleDateFormat;
import com.alibaba.fastjson.JSONObject;
import java.util.*;
import org.springframework.beans.BeanUtils;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.context.ContextLoader;
import javax.servlet.ServletContext;
import com.service.TokenService;
import com.utils.*;
import java.lang.reflect.InvocationTargetException;

import com.service.DictionaryService;
import org.apache.commons.lang3.StringUtils;
import com.annotation.IgnoreAuth;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.entity.*;
import com.entity.view.*;
import com.service.*;
import com.utils.PageUtils;
import com.utils.R;
import com.alibaba.fastjson.*;

/**
 * 失物招领
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/shiwu")
public class ShiwuController {
    private static final Logger logger = LoggerFactory.getLogger(ShiwuController.class);

    private static final String TABLE_NAME = "shiwu";

    @Autowired
    private ShiwuService shiwuService;


    @Autowired
    private TokenService tokenService;

    @Autowired
    private DictionaryService dictionaryService;//字典
    @Autowired
    private ForumService forumService;//论坛
    @Autowired
    private GonggaoService gonggaoService;//公告信息
    @Autowired
    private ShiwuYuyueService shiwuYuyueService;//失物认领
    @Autowired
    private XunwuService xunwuService;//寻物启示
    @Autowired
    private XunwuYuyueService xunwuYuyueService;//寻物认领
    @Autowired
    private YonghuService yonghuService;//用户
    @Autowired
    private UsersService usersService;//管理员


    /**
    * 后端列表
    */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("page方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永不会进入");
        else if("用户".equals(role))
            params.put("yonghuId",request.getSession().getAttribute("userId"));
        params.put("shiwuDeleteStart",1);params.put("shiwuDeleteEnd",1);
        CommonUtil.checkMap(params);
        PageUtils page = shiwuService.queryPage(params);

        //字典表数据转换
        List<ShiwuView> list =(List<ShiwuView>)page.getList();
        for(ShiwuView c:list){
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(c, request);
        }
        return R.ok().put("data", page);
    }

    /**
    * 后端详情
    */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("info方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        ShiwuEntity shiwu = shiwuService.selectById(id);
        if(shiwu !=null){
            //entity转view
            ShiwuView view = new ShiwuView();
            BeanUtils.copyProperties( shiwu , view );//把实体数据重构到view中
            //级联表 用户
            //级联表
            YonghuEntity yonghu = yonghuService.selectById(shiwu.getYonghuId());
            if(yonghu != null){
            BeanUtils.copyProperties( yonghu , view ,new String[]{ "id", "createTime", "insertTime", "updateTime", "username", "password", "newMoney", "yonghuId"});//把级联的数据添加到view中,并排除id和创建时间字段,当前表的级联注册表
            view.setYonghuId(yonghu.getId());
            }
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(view, request);
            return R.ok().put("data", view);
        }else {
            return R.error(511,"查不到数据");
        }

    }

    /**
    * 后端保存
    */
    @RequestMapping("/save")
    public R save(@RequestBody ShiwuEntity shiwu, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,shiwu:{}",this.getClass().getName(),shiwu.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");
        else if("用户".equals(role))
            shiwu.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));

        Wrapper<ShiwuEntity> queryWrapper = new EntityWrapper<ShiwuEntity>()
            .eq("yonghu_id", shiwu.getYonghuId())
            .eq("shiwu_name", shiwu.getShiwuName())
            .eq("shiwu_address", shiwu.getShiwuAddress())
            .eq("shiwu_types", shiwu.getShiwuTypes())
            .in("shiwu_yesno_types", new Integer[]{1,2})
            .eq("shangxia_types", shiwu.getShangxiaTypes())
            .eq("shiwu_delete", 1)
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        ShiwuEntity shiwuEntity = shiwuService.selectOne(queryWrapper);
        if(shiwuEntity==null){
            shiwu.setShiwuYesnoTypes(1);
            shiwu.setShangxiaTypes(1);
            shiwu.setShiwuDelete(1);
            shiwu.setInsertTime(new Date());
            shiwu.setCreateTime(new Date());
            shiwuService.insert(shiwu);
            return R.ok();
        }else {
            if(shiwuEntity.getShiwuYesnoTypes()==1)
                return R.error(511,"有相同的待审核的数据");
            else if(shiwuEntity.getShiwuYesnoTypes()==2)
                return R.error(511,"有相同的审核通过的数据");
            else
                return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody ShiwuEntity shiwu, HttpServletRequest request) throws NoSuchFieldException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        logger.debug("update方法:,,Controller:{},,shiwu:{}",this.getClass().getName(),shiwu.toString());
        ShiwuEntity oldShiwuEntity = shiwuService.selectById(shiwu.getId());//查询原先数据

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
//        else if("用户".equals(role))
//            shiwu.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
        if("".equals(shiwu.getShiwuPhoto()) || "null".equals(shiwu.getShiwuPhoto())){
                shiwu.setShiwuPhoto(null);
        }
        if("".equals(shiwu.getShiwuYesnoText()) || "null".equals(shiwu.getShiwuYesnoText())){
                shiwu.setShiwuYesnoText(null);
        }
        if("".equals(shiwu.getShiwuContent()) || "null".equals(shiwu.getShiwuContent())){
                shiwu.setShiwuContent(null);
        }

            shiwuService.updateById(shiwu);//根据id更新
            return R.ok();
    }


    /**
    * 审核
    */
    @RequestMapping("/shenhe")
    public R shenhe(@RequestBody ShiwuEntity shiwuEntity, HttpServletRequest request){
        logger.debug("shenhe方法:,,Controller:{},,shiwuEntity:{}",this.getClass().getName(),shiwuEntity.toString());

        ShiwuEntity oldShiwu = shiwuService.selectById(shiwuEntity.getId());//查询原先数据

//        if(shiwuEntity.getShiwuYesnoTypes() == 2){//通过
//            shiwuEntity.setShiwuTypes();
//        }else if(shiwuEntity.getShiwuYesnoTypes() == 3){//拒绝
//            shiwuEntity.setShiwuTypes();
//        }
        shiwuEntity.setShiwuShenheTime(new Date());//审核时间
        shiwuService.updateById(shiwuEntity);//审核

        return R.ok();
    }

    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids, HttpServletRequest request){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        List<ShiwuEntity> oldShiwuList =shiwuService.selectBatchIds(Arrays.asList(ids));//要删除的数据
        ArrayList<ShiwuEntity> list = new ArrayList<>();
        for(Integer id:ids){
            ShiwuEntity shiwuEntity = new ShiwuEntity();
            shiwuEntity.setId(id);
            shiwuEntity.setShiwuDelete(2);
            list.add(shiwuEntity);
        }
        if(list != null && list.size() >0){
            shiwuService.updateBatchById(list);
        }

        return R.ok();
    }


    /**
     * 批量上传
     */
    @RequestMapping("/batchInsert")
    public R save( String fileName, HttpServletRequest request){
        logger.debug("batchInsert方法:,,Controller:{},,fileName:{}",this.getClass().getName(),fileName);
        Integer yonghuId = Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId")));
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //.eq("time", new SimpleDateFormat("yyyy-MM-dd").format(new Date()))
        try {
            List<ShiwuEntity> shiwuList = new ArrayList<>();//上传的东西
            Map<String, List<String>> seachFields= new HashMap<>();//要查询的字段
            Date date = new Date();
            int lastIndexOf = fileName.lastIndexOf(".");
            if(lastIndexOf == -1){
                return R.error(511,"该文件没有后缀");
            }else{
                String suffix = fileName.substring(lastIndexOf);
                if(!".xls".equals(suffix)){
                    return R.error(511,"只支持后缀为xls的excel文件");
                }else{
                    URL resource = this.getClass().getClassLoader().getResource("static/upload/" + fileName);//获取文件路径
                    File file = new File(resource.getFile());
                    if(!file.exists()){
                        return R.error(511,"找不到上传文件，请联系管理员");
                    }else{
                        List<List<String>> dataList = PoiUtil.poiImport(file.getPath());//读取xls文件
                        dataList.remove(0);//删除第一行，因为第一行是提示
                        for(List<String> data:dataList){
                            //循环
                            ShiwuEntity shiwuEntity = new ShiwuEntity();
//                            shiwuEntity.setYonghuId(Integer.valueOf(data.get(0)));   //用户 要改的
//                            shiwuEntity.setShiwuName(data.get(0));                    //失物名称 要改的
//                            shiwuEntity.setShiwuUuidNumber(data.get(0));                    //失物编号 要改的
//                            shiwuEntity.setShiwuPhoto("");//详情和图片
//                            shiwuEntity.setShiwuTime(sdf.parse(data.get(0)));          //时间 要改的
//                            shiwuEntity.setShiwuAddress(data.get(0));                    //失物地点 要改的
//                            shiwuEntity.setShiwuTypes(Integer.valueOf(data.get(0)));   //失物类型 要改的
//                            shiwuEntity.setShiwuYesnoTypes(Integer.valueOf(data.get(0)));   //申请状态 要改的
//                            shiwuEntity.setShiwuYesnoText(data.get(0));                    //审核意见 要改的
//                            shiwuEntity.setShiwuShenheTime(sdf.parse(data.get(0)));          //审核时间 要改的
//                            shiwuEntity.setShiwuContent("");//详情和图片
//                            shiwuEntity.setShangxiaTypes(Integer.valueOf(data.get(0)));   //是否上架 要改的
//                            shiwuEntity.setShiwuDelete(1);//逻辑删除字段
//                            shiwuEntity.setInsertTime(date);//时间
//                            shiwuEntity.setCreateTime(date);//时间
                            shiwuList.add(shiwuEntity);


                            //把要查询是否重复的字段放入map中
                                //失物编号
                                if(seachFields.containsKey("shiwuUuidNumber")){
                                    List<String> shiwuUuidNumber = seachFields.get("shiwuUuidNumber");
                                    shiwuUuidNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> shiwuUuidNumber = new ArrayList<>();
                                    shiwuUuidNumber.add(data.get(0));//要改的
                                    seachFields.put("shiwuUuidNumber",shiwuUuidNumber);
                                }
                        }

                        //查询是否重复
                         //失物编号
                        List<ShiwuEntity> shiwuEntities_shiwuUuidNumber = shiwuService.selectList(new EntityWrapper<ShiwuEntity>().in("shiwu_uuid_number", seachFields.get("shiwuUuidNumber")).eq("shiwu_delete", 1));
                        if(shiwuEntities_shiwuUuidNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(ShiwuEntity s:shiwuEntities_shiwuUuidNumber){
                                repeatFields.add(s.getShiwuUuidNumber());
                            }
                            return R.error(511,"数据库的该表中的 [失物编号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        shiwuService.insertBatch(shiwuList);
                        return R.ok();
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            return R.error(511,"批量插入数据异常，请联系管理员");
        }
    }




    /**
    * 前端列表
    */
    @IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("list方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));

        CommonUtil.checkMap(params);
        PageUtils page = shiwuService.queryPage(params);

        //字典表数据转换
        List<ShiwuView> list =(List<ShiwuView>)page.getList();
        for(ShiwuView c:list)
            dictionaryService.dictionaryConvert(c, request); //修改对应字典表字段

        return R.ok().put("data", page);
    }

    /**
    * 前端详情
    */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Integer id, HttpServletRequest request){
        logger.debug("detail方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        ShiwuEntity shiwu = shiwuService.selectById(id);
            if(shiwu !=null){


                //entity转view
                ShiwuView view = new ShiwuView();
                BeanUtils.copyProperties( shiwu , view );//把实体数据重构到view中

                //级联表
                    YonghuEntity yonghu = yonghuService.selectById(shiwu.getYonghuId());
                if(yonghu != null){
                    BeanUtils.copyProperties( yonghu , view ,new String[]{ "id", "createTime", "insertTime", "updateTime", "username", "password", "newMoney", "yonghuId"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setYonghuId(yonghu.getId());
                }
                //修改对应字典表字段
                dictionaryService.dictionaryConvert(view, request);
                return R.ok().put("data", view);
            }else {
                return R.error(511,"查不到数据");
            }
    }


    /**
    * 前端保存
    */
    @RequestMapping("/add")
    public R add(@RequestBody ShiwuEntity shiwu, HttpServletRequest request){
        logger.debug("add方法:,,Controller:{},,shiwu:{}",this.getClass().getName(),shiwu.toString());
        Wrapper<ShiwuEntity> queryWrapper = new EntityWrapper<ShiwuEntity>()
            .eq("yonghu_id", shiwu.getYonghuId())
            .eq("shiwu_name", shiwu.getShiwuName())
            .eq("shiwu_uuid_number", shiwu.getShiwuUuidNumber())
            .eq("shiwu_address", shiwu.getShiwuAddress())
            .eq("shiwu_types", shiwu.getShiwuTypes())
            .in("shiwu_yesno_types", new Integer[]{1,2})
            .eq("shiwu_yesno_text", shiwu.getShiwuYesnoText())
            .eq("shangxia_types", shiwu.getShangxiaTypes())
            .eq("shiwu_delete", shiwu.getShiwuDelete())
//            .notIn("shiwu_types", new Integer[]{102})
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        ShiwuEntity shiwuEntity = shiwuService.selectOne(queryWrapper);
        if(shiwuEntity==null){
            shiwu.setShiwuYesnoTypes(1);
            shiwu.setShiwuDelete(1);
            shiwu.setInsertTime(new Date());
            shiwu.setCreateTime(new Date());
        shiwuService.insert(shiwu);

            return R.ok();
        }else {
            if(shiwuEntity.getShiwuYesnoTypes()==1)
                return R.error(511,"有相同的待审核的数据");
            else if(shiwuEntity.getShiwuYesnoTypes()==2)
                return R.error(511,"有相同的审核通过的数据");
            else
                return R.error(511,"表中有相同数据");
        }
    }

}

