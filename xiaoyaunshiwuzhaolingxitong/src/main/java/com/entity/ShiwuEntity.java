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
 * 失物招领
 *
 * @author 
 * @email
 */
@TableName("shiwu")
public class ShiwuEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public ShiwuEntity() {

	}

	public ShiwuEntity(T t) {
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
     * 用户
     */
    @ColumnInfo(comment="用户",type="int(11)")
    @TableField(value = "yonghu_id")

    private Integer yonghuId;


    /**
     * 失物名称
     */
    @ColumnInfo(comment="失物名称",type="varchar(200)")
    @TableField(value = "shiwu_name")

    private String shiwuName;


    /**
     * 失物编号
     */
    @ColumnInfo(comment="失物编号",type="varchar(200)")
    @TableField(value = "shiwu_uuid_number")

    private String shiwuUuidNumber;


    /**
     * 失物照片
     */
    @ColumnInfo(comment="失物照片",type="varchar(200)")
    @TableField(value = "shiwu_photo")

    private String shiwuPhoto;


    /**
     * 时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="时间",type="timestamp")
    @TableField(value = "shiwu_time")

    private Date shiwuTime;


    /**
     * 失物地点
     */
    @ColumnInfo(comment="失物地点",type="varchar(200)")
    @TableField(value = "shiwu_address")

    private String shiwuAddress;


    /**
     * 失物类型
     */
    @ColumnInfo(comment="失物类型",type="int(11)")
    @TableField(value = "shiwu_types")

    private Integer shiwuTypes;


    /**
     * 申请状态
     */
    @ColumnInfo(comment="申请状态",type="int(11)")
    @TableField(value = "shiwu_yesno_types")

    private Integer shiwuYesnoTypes;


    /**
     * 审核意见
     */
    @ColumnInfo(comment="审核意见",type="longtext")
    @TableField(value = "shiwu_yesno_text")

    private String shiwuYesnoText;


    /**
     * 审核时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="审核时间",type="timestamp")
    @TableField(value = "shiwu_shenhe_time")

    private Date shiwuShenheTime;


    /**
     * 失物介绍
     */
    @ColumnInfo(comment="失物介绍",type="longtext")
    @TableField(value = "shiwu_content")

    private String shiwuContent;


    /**
     * 是否上架
     */
    @ColumnInfo(comment="是否上架",type="int(11)")
    @TableField(value = "shangxia_types")

    private Integer shangxiaTypes;


    /**
     * 逻辑删除
     */
    @ColumnInfo(comment="逻辑删除",type="int(11)")
    @TableField(value = "shiwu_delete")

    private Integer shiwuDelete;


    /**
     * 录入时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="录入时间",type="timestamp")
    @TableField(value = "insert_time",fill = FieldFill.INSERT)

    private Date insertTime;


    /**
     * 创建时间
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
	 * 获取：失物名称
	 */
    public String getShiwuName() {
        return shiwuName;
    }
    /**
	 * 设置：失物名称
	 */

    public void setShiwuName(String shiwuName) {
        this.shiwuName = shiwuName;
    }
    /**
	 * 获取：失物编号
	 */
    public String getShiwuUuidNumber() {
        return shiwuUuidNumber;
    }
    /**
	 * 设置：失物编号
	 */

    public void setShiwuUuidNumber(String shiwuUuidNumber) {
        this.shiwuUuidNumber = shiwuUuidNumber;
    }
    /**
	 * 获取：失物照片
	 */
    public String getShiwuPhoto() {
        return shiwuPhoto;
    }
    /**
	 * 设置：失物照片
	 */

    public void setShiwuPhoto(String shiwuPhoto) {
        this.shiwuPhoto = shiwuPhoto;
    }
    /**
	 * 获取：时间
	 */
    public Date getShiwuTime() {
        return shiwuTime;
    }
    /**
	 * 设置：时间
	 */

    public void setShiwuTime(Date shiwuTime) {
        this.shiwuTime = shiwuTime;
    }
    /**
	 * 获取：失物地点
	 */
    public String getShiwuAddress() {
        return shiwuAddress;
    }
    /**
	 * 设置：失物地点
	 */

    public void setShiwuAddress(String shiwuAddress) {
        this.shiwuAddress = shiwuAddress;
    }
    /**
	 * 获取：失物类型
	 */
    public Integer getShiwuTypes() {
        return shiwuTypes;
    }
    /**
	 * 设置：失物类型
	 */

    public void setShiwuTypes(Integer shiwuTypes) {
        this.shiwuTypes = shiwuTypes;
    }
    /**
	 * 获取：申请状态
	 */
    public Integer getShiwuYesnoTypes() {
        return shiwuYesnoTypes;
    }
    /**
	 * 设置：申请状态
	 */

    public void setShiwuYesnoTypes(Integer shiwuYesnoTypes) {
        this.shiwuYesnoTypes = shiwuYesnoTypes;
    }
    /**
	 * 获取：审核意见
	 */
    public String getShiwuYesnoText() {
        return shiwuYesnoText;
    }
    /**
	 * 设置：审核意见
	 */

    public void setShiwuYesnoText(String shiwuYesnoText) {
        this.shiwuYesnoText = shiwuYesnoText;
    }
    /**
	 * 获取：审核时间
	 */
    public Date getShiwuShenheTime() {
        return shiwuShenheTime;
    }
    /**
	 * 设置：审核时间
	 */

    public void setShiwuShenheTime(Date shiwuShenheTime) {
        this.shiwuShenheTime = shiwuShenheTime;
    }
    /**
	 * 获取：失物介绍
	 */
    public String getShiwuContent() {
        return shiwuContent;
    }
    /**
	 * 设置：失物介绍
	 */

    public void setShiwuContent(String shiwuContent) {
        this.shiwuContent = shiwuContent;
    }
    /**
	 * 获取：是否上架
	 */
    public Integer getShangxiaTypes() {
        return shangxiaTypes;
    }
    /**
	 * 设置：是否上架
	 */

    public void setShangxiaTypes(Integer shangxiaTypes) {
        this.shangxiaTypes = shangxiaTypes;
    }
    /**
	 * 获取：逻辑删除
	 */
    public Integer getShiwuDelete() {
        return shiwuDelete;
    }
    /**
	 * 设置：逻辑删除
	 */

    public void setShiwuDelete(Integer shiwuDelete) {
        this.shiwuDelete = shiwuDelete;
    }
    /**
	 * 获取：录入时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }
    /**
	 * 设置：录入时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 获取：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }
    /**
	 * 设置：创建时间
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Shiwu{" +
            ", id=" + id +
            ", yonghuId=" + yonghuId +
            ", shiwuName=" + shiwuName +
            ", shiwuUuidNumber=" + shiwuUuidNumber +
            ", shiwuPhoto=" + shiwuPhoto +
            ", shiwuTime=" + DateUtil.convertString(shiwuTime,"yyyy-MM-dd") +
            ", shiwuAddress=" + shiwuAddress +
            ", shiwuTypes=" + shiwuTypes +
            ", shiwuYesnoTypes=" + shiwuYesnoTypes +
            ", shiwuYesnoText=" + shiwuYesnoText +
            ", shiwuShenheTime=" + DateUtil.convertString(shiwuShenheTime,"yyyy-MM-dd") +
            ", shiwuContent=" + shiwuContent +
            ", shangxiaTypes=" + shangxiaTypes +
            ", shiwuDelete=" + shiwuDelete +
            ", insertTime=" + DateUtil.convertString(insertTime,"yyyy-MM-dd") +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}
