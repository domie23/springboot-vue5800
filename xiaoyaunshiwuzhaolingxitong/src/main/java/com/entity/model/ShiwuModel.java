package com.entity.model;

import com.entity.ShiwuEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 失物招领
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class ShiwuModel implements Serializable {
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
     * 失物名称
     */
    private String shiwuName;


    /**
     * 失物编号
     */
    private String shiwuUuidNumber;


    /**
     * 失物照片
     */
    private String shiwuPhoto;


    /**
     * 时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date shiwuTime;


    /**
     * 失物地点
     */
    private String shiwuAddress;


    /**
     * 失物类型
     */
    private Integer shiwuTypes;


    /**
     * 申请状态
     */
    private Integer shiwuYesnoTypes;


    /**
     * 审核意见
     */
    private String shiwuYesnoText;


    /**
     * 审核时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date shiwuShenheTime;


    /**
     * 失物介绍
     */
    private String shiwuContent;


    /**
     * 逻辑删除
     */
    private Integer shiwuDelete;


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
