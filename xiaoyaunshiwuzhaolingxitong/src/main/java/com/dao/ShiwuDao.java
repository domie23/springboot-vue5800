package com.dao;

import com.entity.ShiwuEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.ShiwuView;

/**
 * 失物招领 Dao 接口
 *
 * @author 
 */
public interface ShiwuDao extends BaseMapper<ShiwuEntity> {

   List<ShiwuView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
