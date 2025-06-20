package com.entity.model;

import com.entity.XunwuEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 寻物启示
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class XunwuModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 用户
     */
    private Integer yonghuId;


    /**
     * 寻物名称
     */
    private String xunwuName;


    /**
     * 寻物编号
     */
    private String xunwuUuidNumber;


    /**
     * 寻物照片
     */
    private String xunwuPhoto;


    /**
     * 时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date xunwuTime;


    /**
     * 寻物地点
     */
    private String xunwuAddress;


    /**
     * 寻物类型
     */
    private Integer xunwuTypes;


    /**
     * 申请状态
     */
    private Integer xunwuYesnoTypes;


    /**
     * 审核意见
     */
    private String xunwuYesnoText;


    /**
     * 审核时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date xunwuShenheTime;


    /**
     * 寻物介绍
     */
    private String xunwuContent;


    /**
     * 逻辑删除
     */
    private Integer xunwuDelete;


    /**
     * 录入时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date insertTime;


    /**
     * 创建时间  show1 show2 photoShow
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
	 * 获取：创建时间  show1 show2 photoShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间  show1 show2 photoShow
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
