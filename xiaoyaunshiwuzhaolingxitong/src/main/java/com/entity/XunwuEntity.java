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
 * 寻物启示
 *
 * @author 
 * @email
 */
@TableName("xunwu")
public class XunwuEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public XunwuEntity() {

	}

	public XunwuEntity(T t) {
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
     * 寻物名称
     */
    @ColumnInfo(comment="寻物名称",type="varchar(200)")
    @TableField(value = "xunwu_name")

    private String xunwuName;


    /**
     * 寻物编号
     */
    @ColumnInfo(comment="寻物编号",type="varchar(200)")
    @TableField(value = "xunwu_uuid_number")

    private String xunwuUuidNumber;


    /**
     * 寻物照片
     */
    @ColumnInfo(comment="寻物照片",type="varchar(200)")
    @TableField(value = "xunwu_photo")

    private String xunwuPhoto;


    /**
     * 时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="时间",type="timestamp")
    @TableField(value = "xunwu_time")

    private Date xunwuTime;


    /**
     * 寻物地点
     */
    @ColumnInfo(comment="寻物地点",type="varchar(200)")
    @TableField(value = "xunwu_address")

    private String xunwuAddress;


    /**
     * 寻物类型
     */
    @ColumnInfo(comment="寻物类型",type="int(11)")
    @TableField(value = "xunwu_types")

    private Integer xunwuTypes;


    /**
     * 申请状态
     */
    @ColumnInfo(comment="申请状态",type="int(11)")
    @TableField(value = "xunwu_yesno_types")

    private Integer xunwuYesnoTypes;


    /**
     * 审核意见
     */
    @ColumnInfo(comment="审核意见",type="longtext")
    @TableField(value = "xunwu_yesno_text")

    private String xunwuYesnoText;


    /**
     * 审核时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="审核时间",type="timestamp")
    @TableField(value = "xunwu_shenhe_time")

    private Date xunwuShenheTime;


    /**
     * 寻物介绍
     */
    @ColumnInfo(comment="寻物介绍",type="longtext")
    @TableField(value = "xunwu_content")

    private String xunwuContent;


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
    @TableField(value = "xunwu_delete")

    private Integer xunwuDelete;


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
	 * 获取：寻物名称
	 */
    public String getXunwuName() {
        return xunwuName;
    }
    /**
	 * 设置：寻物名称
	 */

    public void setXunwuName(String xunwuName) {
        this.xunwuName = xunwuName;
    }
    /**
	 * 获取：寻物编号
	 */
    public String getXunwuUuidNumber() {
        return xunwuUuidNumber;
    }
    /**
	 * 设置：寻物编号
	 */

    public void setXunwuUuidNumber(String xunwuUuidNumber) {
        this.xunwuUuidNumber = xunwuUuidNumber;
    }
    /**
	 * 获取：寻物照片
	 */
    public String getXunwuPhoto() {
        return xunwuPhoto;
    }
    /**
	 * 设置：寻物照片
	 */

    public void setXunwuPhoto(String xunwuPhoto) {
        this.xunwuPhoto = xunwuPhoto;
    }
    /**
	 * 获取：时间
	 */
    public Date getXunwuTime() {
        return xunwuTime;
    }
    /**
	 * 设置：时间
	 */

    public void setXunwuTime(Date xunwuTime) {
        this.xunwuTime = xunwuTime;
    }
    /**
	 * 获取：寻物地点
	 */
    public String getXunwuAddress() {
        return xunwuAddress;
    }
    /**
	 * 设置：寻物地点
	 */

    public void setXunwuAddress(String xunwuAddress) {
        this.xunwuAddress = xunwuAddress;
    }
    /**
	 * 获取：寻物类型
	 */
    public Integer getXunwuTypes() {
        return xunwuTypes;
    }
    /**
	 * 设置：寻物类型
	 */

    public void setXunwuTypes(Integer xunwuTypes) {
        this.xunwuTypes = xunwuTypes;
    }
    /**
	 * 获取：申请状态
	 */
    public Integer getXunwuYesnoTypes() {
        return xunwuYesnoTypes;
    }
    /**
	 * 设置：申请状态
	 */

    public void setXunwuYesnoTypes(Integer xunwuYesnoTypes) {
        this.xunwuYesnoTypes = xunwuYesnoTypes;
    }
    /**
	 * 获取：审核意见
	 */
    public String getXunwuYesnoText() {
        return xunwuYesnoText;
    }
    /**
	 * 设置：审核意见
	 */

    public void setXunwuYesnoText(String xunwuYesnoText) {
        this.xunwuYesnoText = xunwuYesnoText;
    }
    /**
	 * 获取：审核时间
	 */
    public Date getXunwuShenheTime() {
        return xunwuShenheTime;
    }
    /**
	 * 设置：审核时间
	 */

    public void setXunwuShenheTime(Date xunwuShenheTime) {
        this.xunwuShenheTime = xunwuShenheTime;
    }
    /**
	 * 获取：寻物介绍
	 */
    public String getXunwuContent() {
        return xunwuContent;
    }
    /**
	 * 设置：寻物介绍
	 */

    public void setXunwuContent(String xunwuContent) {
        this.xunwuContent = xunwuContent;
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
    public Integer getXunwuDelete() {
        return xunwuDelete;
    }
    /**
	 * 设置：逻辑删除
	 */

    public void setXunwuDelete(Integer xunwuDelete) {
        this.xunwuDelete = xunwuDelete;
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
        return "Xunwu{" +
            ", id=" + id +
            ", yonghuId=" + yonghuId +
            ", xunwuName=" + xunwuName +
            ", xunwuUuidNumber=" + xunwuUuidNumber +
            ", xunwuPhoto=" + xunwuPhoto +
            ", xunwuTime=" + DateUtil.convertString(xunwuTime,"yyyy-MM-dd") +
            ", xunwuAddress=" + xunwuAddress +
            ", xunwuTypes=" + xunwuTypes +
            ", xunwuYesnoTypes=" + xunwuYesnoTypes +
            ", xunwuYesnoText=" + xunwuYesnoText +
            ", xunwuShenheTime=" + DateUtil.convertString(xunwuShenheTime,"yyyy-MM-dd") +
            ", xunwuContent=" + xunwuContent +
            ", shangxiaTypes=" + shangxiaTypes +
            ", xunwuDelete=" + xunwuDelete +
            ", insertTime=" + DateUtil.convertString(insertTime,"yyyy-MM-dd") +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}
