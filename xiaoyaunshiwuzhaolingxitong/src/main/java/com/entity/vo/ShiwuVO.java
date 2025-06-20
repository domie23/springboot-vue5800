package com.entity.vo;

import com.entity.ShiwuEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 失物招领
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("shiwu")
public class ShiwuVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 用户
     */

    @TableField(value = "yonghu_id")
    private Integer yonghuId;


    /**
     * 失物名称
     */

    @TableField(value = "shiwu_name")
    private String shiwuName;


    /**
     * 失物编号
     */

    @TableField(value = "shiwu_uuid_number")
    private String shiwuUuidNumber;


    /**
     * 失物照片
     */

    @TableField(value = "shiwu_photo")
    private String shiwuPhoto;


    /**
     * 时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "shiwu_time")
    private Date shiwuTime;


    /**
     * 失物地点
     */

    @TableField(value = "shiwu_address")
    private String shiwuAddress;


    /**
     * 失物类型
     */

    @TableField(value = "shiwu_types")
    private Integer shiwuTypes;


    /**
     * 申请状态
     */

    @TableField(value = "shiwu_yesno_types")
    private Integer shiwuYesnoTypes;


    /**
     * 审核意见
     */

    @TableField(value = "shiwu_yesno_text")
    private String shiwuYesnoText;


    /**
     * 审核时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "shiwu_shenhe_time")
    private Date shiwuShenheTime;


    /**
     * 失物介绍
     */

    @TableField(value = "shiwu_content")
    private String shiwuContent;


    /**
     * 逻辑删除
     */

    @TableField(value = "shiwu_delete")
    private Integer shiwuDelete;


    /**
     * 录入时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "insert_time")
    private Date insertTime;


    /**
     * 创建时间  show1 show2 photoShow
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "create_time")
    private Date createTime;


    /**
	 * 设置：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 获取：主键
	 */

    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 设置：用户
	 */
    public Integer getYonghuId() {
        return yonghuId;
    }


    /**
	 * 获取：用户
	 */

    public void setYonghuId(Integer yonghuId) {
        this.yonghuId = yonghuId;
    }
    /**
	 * 设置：失物名称
	 */
    public String getShiwuName() {
        return shiwuName;
    }


    /**
	 * 获取：失物名称
	 */

    public void setShiwuName(String shiwuName) {
        this.shiwuName = shiwuName;
    }
    /**
	 * 设置：失物编号
	 */
    public String getShiwuUuidNumber() {
        return shiwuUuidNumber;
    }


    /**
	 * 获取：失物编号
	 */

    public void setShiwuUuidNumber(String shiwuUuidNumber) {
        this.shiwuUuidNumber = shiwuUuidNumber;
    }
    /**
	 * 设置：失物照片
	 */
    public String getShiwuPhoto() {
        return shiwuPhoto;
    }


    /**
	 * 获取：失物照片
	 */

    public void setShiwuPhoto(String shiwuPhoto) {
        this.shiwuPhoto = shiwuPhoto;
    }
    /**
	 * 设置：时间
	 */
    public Date getShiwuTime() {
        return shiwuTime;
    }


    /**
	 * 获取：时间
	 */

    public void setShiwuTime(Date shiwuTime) {
        this.shiwuTime = shiwuTime;
    }
    /**
	 * 设置：失物地点
	 */
    public String getShiwuAddress() {
        return shiwuAddress;
    }


    /**
	 * 获取：失物地点
	 */

    public void setShiwuAddress(String shiwuAddress) {
        this.shiwuAddress = shiwuAddress;
    }
    /**
	 * 设置：失物类型
	 */
    public Integer getShiwuTypes() {
        return shiwuTypes;
    }


    /**
	 * 获取：失物类型
	 */

    public void setShiwuTypes(Integer shiwuTypes) {
        this.shiwuTypes = shiwuTypes;
    }
    /**
	 * 设置：申请状态
	 */
    public Integer getShiwuYesnoTypes() {
        return shiwuYesnoTypes;
    }


    /**
	 * 获取：申请状态
	 */

    public void setShiwuYesnoTypes(Integer shiwuYesnoTypes) {
        this.shiwuYesnoTypes = shiwuYesnoTypes;
    }
    /**
	 * 设置：审核意见
	 */
    public String getShiwuYesnoText() {
        return shiwuYesnoText;
    }


    /**
	 * 获取：审核意见
	 */

    public void setShiwuYesnoText(String shiwuYesnoText) {
        this.shiwuYesnoText = shiwuYesnoText;
    }
    /**
	 * 设置：审核时间
	 */
    public Date getShiwuShenheTime() {
        return shiwuShenheTime;
    }


    /**
	 * 获取：审核时间
	 */

    public void setShiwuShenheTime(Date shiwuShenheTime) {
        this.shiwuShenheTime = shiwuShenheTime;
    }
    /**
	 * 设置：失物介绍
	 */
    public String getShiwuContent() {
        return shiwuContent;
    }


    /**
	 * 获取：失物介绍
	 */

    public void setShiwuContent(String shiwuContent) {
        this.shiwuContent = shiwuContent;
    }
    /**
	 * 设置：逻辑删除
	 */
    public Integer getShiwuDelete() {
        return shiwuDelete;
    }


    /**
	 * 获取：逻辑删除
	 */

    public void setShiwuDelete(Integer shiwuDelete) {
        this.shiwuDelete = shiwuDelete;
    }
    /**
	 * 设置：录入时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 获取：录入时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 设置：创建时间  show1 show2 photoShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间  show1 show2 photoShow
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
