package com.dao;

import com.entity.XunwuYuyueEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.XunwuYuyueView;

/**
 * 寻物认领 Dao 接口
 *
 * @author 
 */
public interface XunwuYuyueDao extends BaseMapper<XunwuYuyueEntity> {

   List<XunwuYuyueView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
