package com.entity.model;

import com.entity.XunwuYuyueEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 寻物认领
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class XunwuYuyueModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 报名编号
     */
    private String xunwuYuyueUuidNumber;


    /**
     * 寻物启示
     */
    private Integer xunwuId;


    /**
     * 用户
     */
    private Integer yonghuId;


    /**
     * 报名理由
     */
    private String xunwuYuyueText;


    /**
     * 照片
     */
    private String xunwuYuyuePhoto;


    /**
     * 寻物启示报名时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date insertTime;


    /**
     * 报名状态
     */
    private Integer xunwuYuyueYesnoTypes;


    /**
     * 审核回复
     */
    private String xunwuYuyueYesnoText;


    /**
     * 审核时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date xunwuYuyueShenheTime;


    /**
     * 创建时间 show3 listShow
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
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
	 * 获取：创建时间 show3 listShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间 show3 listShow
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
