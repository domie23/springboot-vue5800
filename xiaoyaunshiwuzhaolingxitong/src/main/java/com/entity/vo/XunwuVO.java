package com.entity.vo;

import com.entity.XunwuEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 寻物启示
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("xunwu")
public class XunwuVO implements Serializable {
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
     * 寻物名称
     */

    @TableField(value = "xunwu_name")
    private String xunwuName;


    /**
     * 寻物编号
     */

    @TableField(value = "xunwu_uuid_number")
    private String xunwuUuidNumber;


    /**
     * 寻物照片
     */

    @TableField(value = "xunwu_photo")
    private String xunwuPhoto;


    /**
     * 时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "xunwu_time")
    private Date xunwuTime;


    /**
     * 寻物地点
     */

    @TableField(value = "xunwu_address")
    private String xunwuAddress;


    /**
     * 寻物类型
     */

    @TableField(value = "xunwu_types")
    private Integer xunwuTypes;


    /**
     * 申请状态
     */

    @TableField(value = "xunwu_yesno_types")
    private Integer xunwuYesnoTypes;


    /**
     * 审核意见
     */

    @TableField(value = "xunwu_yesno_text")
    private String xunwuYesnoText;


    /**
     * 审核时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "xunwu_shenhe_time")
    private Date xunwuShenheTime;


    /**
     * 寻物介绍
     */

    @TableField(value = "xunwu_content")
    private String xunwuContent;


    /**
     * 逻辑删除
     */

    @TableField(value = "xunwu_delete")
    private Integer xunwuDelete;


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
	 * 设置：寻物名称
	 */
    public String getXunwuName() {
        return xunwuName;
    }


    /**
	 * 获取：寻物名称
	 */

    public void setXunwuName(String xunwuName) {
        this.xunwuName = xunwuName;
    }
    /**
	 * 设置：寻物编号
	 */
    public String getXunwuUuidNumber() {
        return xunwuUuidNumber;
    }


    /**
	 * 获取：寻物编号
	 */

    public void setXunwuUuidNumber(String xunwuUuidNumber) {
        this.xunwuUuidNumber = xunwuUuidNumber;
    }
    /**
	 * 设置：寻物照片
	 */
    public String getXunwuPhoto() {
        return xunwuPhoto;
    }


    /**
	 * 获取：寻物照片
	 */

    public void setXunwuPhoto(String xunwuPhoto) {
        this.xunwuPhoto = xunwuPhoto;
    }
    /**
	 * 设置：时间
	 */
    public Date getXunwuTime() {
        return xunwuTime;
    }


    /**
	 * 获取：时间
	 */

    public void setXunwuTime(Date xunwuTime) {
        this.xunwuTime = xunwuTime;
    }
    /**
	 * 设置：寻物地点
	 */
    public String getXunwuAddress() {
        return xunwuAddress;
    }


    /**
	 * 获取：寻物地点
	 */

    public void setXunwuAddress(String xunwuAddress) {
        this.xunwuAddress = xunwuAddress;
    }
    /**
	 * 设置：寻物类型
	 */
    public Integer getXunwuTypes() {
        return xunwuTypes;
    }


    /**
	 * 获取：寻物类型
	 */

    public void setXunwuTypes(Integer xunwuTypes) {
        this.xunwuTypes = xunwuTypes;
    }
    /**
	 * 设置：申请状态
	 */
    public Integer getXunwuYesnoTypes() {
        return xunwuYesnoTypes;
    }


    /**
	 * 获取：申请状态
	 */

    public void setXunwuYesnoTypes(Integer xunwuYesnoTypes) {
        this.xunwuYesnoTypes = xunwuYesnoTypes;
    }
    /**
	 * 设置：审核意见
	 */
    public String getXunwuYesnoText() {
        return xunwuYesnoText;
    }


    /**
	 * 获取：审核意见
	 */

    public void setXunwuYesnoText(String xunwuYesnoText) {
        this.xunwuYesnoText = xunwuYesnoText;
    }
    /**
	 * 设置：审核时间
	 */
    public Date getXunwuShenheTime() {
        return xunwuShenheTime;
    }


    /**
	 * 获取：审核时间
	 */

    public void setXunwuShenheTime(Date xunwuShenheTime) {
        this.xunwuShenheTime = xunwuShenheTime;
    }
    /**
	 * 设置：寻物介绍
	 */
    public String getXunwuContent() {
        return xunwuContent;
    }


    /**
	 * 获取：寻物介绍
	 */

    public void setXunwuContent(String xunwuContent) {
        this.xunwuContent = xunwuContent;
    }
    /**
	 * 设置：逻辑删除
	 */
    public Integer getXunwuDelete() {
        return xunwuDelete;
    }


    /**
	 * 获取：逻辑删除
	 */

    public void setXunwuDelete(Integer xunwuDelete) {
        this.xunwuDelete = xunwuDelete;
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
