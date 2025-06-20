package com.entity;

import com.annotation.ColumnInfo;
import javax.validation.constraints.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;
import java.io.Serializable;
import java.util.*;
import org.apache.tools.ant.util.DateUtils;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.utils.DateUtil;


/**
 * 失物认领
 *
 * @author 
 * @email
 */
@TableName("shiwu_yuyue")
public class ShiwuYuyueEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public ShiwuYuyueEntity() {

	}

	public ShiwuYuyueEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    @ColumnInfo(comment="主键",type="int(11)")
    @TableField(value = "id")

    private Integer id;


    /**
     * 报名编号
     */
    @ColumnInfo(comment="报名编号",type="varchar(200)")
    @TableField(value = "shiwu_yuyue_uuid_number")

    private String shiwuYuyueUuidNumber;


    /**
     * 寻物启示
     */
    @ColumnInfo(comment="寻物启示",type="int(11)")
    @TableField(value = "shiwu_id")

    private Integer shiwuId;


    /**
     * 用户
     */
    @ColumnInfo(comment="用户",type="int(11)")
    @TableField(value = "yonghu_id")

    private Integer yonghuId;


    /**
     * 报名理由
     */
    @ColumnInfo(comment="报名理由",type="longtext")
    @TableField(value = "shiwu_yuyue_text")

    private String shiwuYuyueText;


    /**
     * 照片
     */
    @ColumnInfo(comment="照片",type="varchar(200)")
    @TableField(value = "shiwu_yuyue_photo")

    private String shiwuYuyuePhoto;


    /**
     * 寻物启示报名时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="寻物启示报名时间",type="timestamp")
    @TableField(value = "insert_time",fill = FieldFill.INSERT)

    private Date insertTime;


    /**
     * 报名状态
     */
    @ColumnInfo(comment="报名状态",type="int(11)")
    @TableField(value = "shiwu_yuyue_yesno_types")

    private Integer shiwuYuyueYesnoTypes;


    /**
     * 审核回复
     */
    @ColumnInfo(comment="审核回复",type="longtext")
    @TableField(value = "shiwu_yuyue_yesno_text")

    private String shiwuYuyueYesnoText;


    /**
     * 审核时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="审核时间",type="timestamp")
    @TableField(value = "shiwu_yuyue_shenhe_time")

    private Date shiwuYuyueShenheTime;


    /**
     * 创建时间  listShow
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="创建时间",type="timestamp")
    @TableField(value = "create_time",fill = FieldFill.INSERT)

    private Date createTime;


    /**
	 * 获取：主键
	 */
    public Integer getId() {
        return id;
    }
    /**
	 * 设置：主键
	 */

    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 获取：报名编号
	 */
    public String getShiwuYuyueUuidNumber() {
        return shiwuYuyueUuidNumber;
    }
    /**
	 * 设置：报名编号
	 */

    public void setShiwuYuyueUuidNumber(String shiwuYuyueUuidNumber) {
        this.shiwuYuyueUuidNumber = shiwuYuyueUuidNumber;
    }
    /**
	 * 获取：寻物启示
	 */
    public Integer getShiwuId() {
        return shiwuId;
    }
    /**
	 * 设置：寻物启示
	 */

    public void setShiwuId(Integer shiwuId) {
        this.shiwuId = shiwuId;
    }
    /**
	 * 获取：用户
	 */
    public Integer getYonghuId() {
        return yonghuId;
    }
    /**
	 * 设置：用户
	 */

    public void setYonghuId(Integer yonghuId) {
        this.yonghuId = yonghuId;
    }
    /**
	 * 获取：报名理由
	 */
    public String getShiwuYuyueText() {
        return shiwuYuyueText;
    }
    /**
	 * 设置：报名理由
	 */

    public void setShiwuYuyueText(String shiwuYuyueText) {
        this.shiwuYuyueText = shiwuYuyueText;
    }
    /**
	 * 获取：照片
	 */
    public String getShiwuYuyuePhoto() {
        return shiwuYuyuePhoto;
    }
    /**
	 * 设置：照片
	 */

    public void setShiwuYuyuePhoto(String shiwuYuyuePhoto) {
        this.shiwuYuyuePhoto = shiwuYuyuePhoto;
    }
    /**
	 * 获取：寻物启示报名时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }
    /**
	 * 设置：寻物启示报名时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 获取：报名状态
	 */
    public Integer getShiwuYuyueYesnoTypes() {
        return shiwuYuyueYesnoTypes;
    }
    /**
	 * 设置：报名状态
	 */

    public void setShiwuYuyueYesnoTypes(Integer shiwuYuyueYesnoTypes) {
        this.shiwuYuyueYesnoTypes = shiwuYuyueYesnoTypes;
    }
    /**
	 * 获取：审核回复
	 */
    public String getShiwuYuyueYesnoText() {
        return shiwuYuyueYesnoText;
    }
    /**
	 * 设置：审核回复
	 */

    public void setShiwuYuyueYesnoText(String shiwuYuyueYesnoText) {
        this.shiwuYuyueYesnoText = shiwuYuyueYesnoText;
    }
    /**
	 * 获取：审核时间
	 */
    public Date getShiwuYuyueShenheTime() {
        return shiwuYuyueShenheTime;
    }
    /**
	 * 设置：审核时间
	 */

    public void setShiwuYuyueShenheTime(Date shiwuYuyueShenheTime) {
        this.shiwuYuyueShenheTime = shiwuYuyueShenheTime;
    }
    /**
	 * 获取：创建时间  listShow
	 */
    public Date getCreateTime() {
        return createTime;
    }
    /**
	 * 设置：创建时间  listShow
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "ShiwuYuyue{" +
            ", id=" + id +
            ", shiwuYuyueUuidNumber=" + shiwuYuyueUuidNumber +
            ", shiwuId=" + shiwuId +
            ", yonghuId=" + yonghuId +
            ", shiwuYuyueText=" + shiwuYuyueText +
            ", shiwuYuyuePhoto=" + shiwuYuyuePhoto +
            ", insertTime=" + DateUtil.convertString(insertTime,"yyyy-MM-dd") +
            ", shiwuYuyueYesnoTypes=" + shiwuYuyueYesnoTypes +
            ", shiwuYuyueYesnoText=" + shiwuYuyueYesnoText +
            ", shiwuYuyueShenheTime=" + DateUtil.convertString(shiwuYuyueShenheTime,"yyyy-MM-dd") +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}
