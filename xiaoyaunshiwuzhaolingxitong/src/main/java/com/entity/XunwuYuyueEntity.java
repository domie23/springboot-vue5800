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
 * 寻物认领
 *
 * @author 
 * @email
 */
@TableName("xunwu_yuyue")
public class XunwuYuyueEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public XunwuYuyueEntity() {

	}

	public XunwuYuyueEntity(T t) {
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
    @TableField(value = "xunwu_yuyue_uuid_number")

    private String xunwuYuyueUuidNumber;


    /**
     * 寻物启示
     */
    @ColumnInfo(comment="寻物启示",type="int(11)")
    @TableField(value = "xunwu_id")

    private Integer xunwuId;


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
    @TableField(value = "xunwu_yuyue_text")

    private String xunwuYuyueText;


    /**
     * 照片
     */
    @ColumnInfo(comment="照片",type="varchar(200)")
    @TableField(value = "xunwu_yuyue_photo")

    private String xunwuYuyuePhoto;


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
    @TableField(value = "xunwu_yuyue_yesno_types")

    private Integer xunwuYuyueYesnoTypes;


    /**
     * 审核回复
     */
    @ColumnInfo(comment="审核回复",type="longtext")
    @TableField(value = "xunwu_yuyue_yesno_text")

    private String xunwuYuyueYesnoText;


    /**
     * 审核时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="审核时间",type="timestamp")
    @TableField(value = "xunwu_yuyue_shenhe_time")

    private Date xunwuYuyueShenheTime;


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
    public String getXunwuYuyueUuidNumber() {
        return xunwuYuyueUuidNumber;
    }
    /**
	 * 设置：报名编号
	 */

    public void setXunwuYuyueUuidNumber(String xunwuYuyueUuidNumber) {
        this.xunwuYuyueUuidNumber = xunwuYuyueUuidNumber;
    }
    /**
	 * 获取：寻物启示
	 */
    public Integer getXunwuId() {
        return xunwuId;
    }
    /**
	 * 设置：寻物启示
	 */

    public void setXunwuId(Integer xunwuId) {
        this.xunwuId = xunwuId;
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
    public String getXunwuYuyueText() {
        return xunwuYuyueText;
    }
    /**
	 * 设置：报名理由
	 */

    public void setXunwuYuyueText(String xunwuYuyueText) {
        this.xunwuYuyueText = xunwuYuyueText;
    }
    /**
	 * 获取：照片
	 */
    public String getXunwuYuyuePhoto() {
        return xunwuYuyuePhoto;
    }
    /**
	 * 设置：照片
	 */

    public void setXunwuYuyuePhoto(String xunwuYuyuePhoto) {
        this.xunwuYuyuePhoto = xunwuYuyuePhoto;
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
    public Integer getXunwuYuyueYesnoTypes() {
        return xunwuYuyueYesnoTypes;
    }
    /**
	 * 设置：报名状态
	 */

    public void setXunwuYuyueYesnoTypes(Integer xunwuYuyueYesnoTypes) {
        this.xunwuYuyueYesnoTypes = xunwuYuyueYesnoTypes;
    }
    /**
	 * 获取：审核回复
	 */
    public String getXunwuYuyueYesnoText() {
        return xunwuYuyueYesnoText;
    }
    /**
	 * 设置：审核回复
	 */

    public void setXunwuYuyueYesnoText(String xunwuYuyueYesnoText) {
        this.xunwuYuyueYesnoText = xunwuYuyueYesnoText;
    }
    /**
	 * 获取：审核时间
	 */
    public Date getXunwuYuyueShenheTime() {
        return xunwuYuyueShenheTime;
    }
    /**
	 * 设置：审核时间
	 */

    public void setXunwuYuyueShenheTime(Date xunwuYuyueShenheTime) {
        this.xunwuYuyueShenheTime = xunwuYuyueShenheTime;
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
        return "XunwuYuyue{" +
            ", id=" + id +
            ", xunwuYuyueUuidNumber=" + xunwuYuyueUuidNumber +
            ", xunwuId=" + xunwuId +
            ", yonghuId=" + yonghuId +
            ", xunwuYuyueText=" + xunwuYuyueText +
            ", xunwuYuyuePhoto=" + xunwuYuyuePhoto +
            ", insertTime=" + DateUtil.convertString(insertTime,"yyyy-MM-dd") +
            ", xunwuYuyueYesnoTypes=" + xunwuYuyueYesnoTypes +
            ", xunwuYuyueYesnoText=" + xunwuYuyueYesnoText +
            ", xunwuYuyueShenheTime=" + DateUtil.convertString(xunwuYuyueShenheTime,"yyyy-MM-dd") +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}
