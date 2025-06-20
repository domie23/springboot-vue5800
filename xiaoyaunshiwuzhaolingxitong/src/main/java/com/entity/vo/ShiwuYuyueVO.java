package com.entity.vo;

import com.entity.ShiwuYuyueEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 失物认领
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("shiwu_yuyue")
public class ShiwuYuyueVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 报名编号
     */

    @TableField(value = "shiwu_yuyue_uuid_number")
    private String shiwuYuyueUuidNumber;


    /**
     * 寻物启示
     */

    @TableField(value = "shiwu_id")
    private Integer shiwuId;


    /**
     * 用户
     */

    @TableField(value = "yonghu_id")
    private Integer yonghuId;


    /**
     * 报名理由
     */

    @TableField(value = "shiwu_yuyue_text")
    private String shiwuYuyueText;


    /**
     * 照片
     */

    @TableField(value = "shiwu_yuyue_photo")
    private String shiwuYuyuePhoto;


    /**
     * 寻物启示报名时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "insert_time")
    private Date insertTime;


    /**
     * 报名状态
     */

    @TableField(value = "shiwu_yuyue_yesno_types")
    private Integer shiwuYuyueYesnoTypes;


    /**
     * 审核回复
     */

    @TableField(value = "shiwu_yuyue_yesno_text")
    private String shiwuYuyueYesnoText;


    /**
     * 审核时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "shiwu_yuyue_shenhe_time")
    private Date shiwuYuyueShenheTime;


    /**
     * 创建时间 show3 listShow
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
	 * 设置：报名编号
	 */
    public String getShiwuYuyueUuidNumber() {
        return shiwuYuyueUuidNumber;
    }


    /**
	 * 获取：报名编号
	 */

    public void setShiwuYuyueUuidNumber(String shiwuYuyueUuidNumber) {
        this.shiwuYuyueUuidNumber = shiwuYuyueUuidNumber;
    }
    /**
	 * 设置：寻物启示
	 */
    public Integer getShiwuId() {
        return shiwuId;
    }


    /**
	 * 获取：寻物启示
	 */

    public void setShiwuId(Integer shiwuId) {
        this.shiwuId = shiwuId;
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
	 * 设置：报名理由
	 */
    public String getShiwuYuyueText() {
        return shiwuYuyueText;
    }


    /**
	 * 获取：报名理由
	 */

    public void setShiwuYuyueText(String shiwuYuyueText) {
        this.shiwuYuyueText = shiwuYuyueText;
    }
    /**
	 * 设置：照片
	 */
    public String getShiwuYuyuePhoto() {
        return shiwuYuyuePhoto;
    }


    /**
	 * 获取：照片
	 */

    public void setShiwuYuyuePhoto(String shiwuYuyuePhoto) {
        this.shiwuYuyuePhoto = shiwuYuyuePhoto;
    }
    /**
	 * 设置：寻物启示报名时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 获取：寻物启示报名时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 设置：报名状态
	 */
    public Integer getShiwuYuyueYesnoTypes() {
        return shiwuYuyueYesnoTypes;
    }


    /**
	 * 获取：报名状态
	 */

    public void setShiwuYuyueYesnoTypes(Integer shiwuYuyueYesnoTypes) {
        this.shiwuYuyueYesnoTypes = shiwuYuyueYesnoTypes;
    }
    /**
	 * 设置：审核回复
	 */
    public String getShiwuYuyueYesnoText() {
        return shiwuYuyueYesnoText;
    }


    /**
	 * 获取：审核回复
	 */

    public void setShiwuYuyueYesnoText(String shiwuYuyueYesnoText) {
        this.shiwuYuyueYesnoText = shiwuYuyueYesnoText;
    }
    /**
	 * 设置：审核时间
	 */
    public Date getShiwuYuyueShenheTime() {
        return shiwuYuyueShenheTime;
    }


    /**
	 * 获取：审核时间
	 */

    public void setShiwuYuyueShenheTime(Date shiwuYuyueShenheTime) {
        this.shiwuYuyueShenheTime = shiwuYuyueShenheTime;
    }
    /**
	 * 设置：创建时间 show3 listShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间 show3 listShow
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
