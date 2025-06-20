package com.dao;

import com.entity.ShiwuYuyueEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.ShiwuYuyueView;

/**
 * 失物认领 Dao 接口
 *
 * @author 
 */
public interface ShiwuYuyueDao extends BaseMapper<ShiwuYuyueEntity> {

   List<ShiwuYuyueView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
