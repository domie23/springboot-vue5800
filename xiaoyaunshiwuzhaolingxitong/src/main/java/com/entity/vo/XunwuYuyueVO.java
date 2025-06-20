package com.entity.vo;

import com.entity.XunwuYuyueEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 寻物认领
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("xunwu_yuyue")
public class XunwuYuyueVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 报名编号
     */

    @TableField(value = "xunwu_yuyue_uuid_number")
    private String xunwuYuyueUuidNumber;


    /**
     * 寻物启示
     */

    @TableField(value = "xunwu_id")
    private Integer xunwuId;


    /**
     * 用户
     */

    @TableField(value = "yonghu_id")
    private Integer yonghuId;


    /**
     * 报名理由
     */

    @TableField(value = "xunwu_yuyue_text")
    private String xunwuYuyueText;


    /**
     * 照片
     */

    @TableField(value = "xunwu_yuyue_photo")
    private String xunwuYuyuePhoto;


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

    @TableField(value = "xunwu_yuyue_yesno_types")
    private Integer xunwuYuyueYesnoTypes;


    /**
     * 审核回复
     */

    @TableField(value = "xunwu_yuyue_yesno_text")
    private String xunwuYuyueYesnoText;


    /**
     * 审核时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "xunwu_yuyue_shenhe_time")
    private Date xunwuYuyueShenheTime;


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
    public String getXunwuYuyueUuidNumber() {
        return xunwuYuyueUuidNumber;
    }


    /**
	 * 获取：报名编号
	 */

    public void setXunwuYuyueUuidNumber(String xunwuYuyueUuidNumber) {
        this.xunwuYuyueUuidNumber = xunwuYuyueUuidNumber;
    }
    /**
	 * 设置：寻物启示
	 */
    public Integer getXunwuId() {
        return xunwuId;
    }


    /**
	 * 获取：寻物启示
	 */

    public void setXunwuId(Integer xunwuId) {
        this.xunwuId = xunwuId;
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
    public String getXunwuYuyueText() {
        return xunwuYuyueText;
    }


    /**
	 * 获取：报名理由
	 */

    public void setXunwuYuyueText(String xunwuYuyueText) {
        this.xunwuYuyueText = xunwuYuyueText;
    }
    /**
	 * 设置：照片
	 */
    public String getXunwuYuyuePhoto() {
        return xunwuYuyuePhoto;
    }


    /**
	 * 获取：照片
	 */

    public void setXunwuYuyuePhoto(String xunwuYuyuePhoto) {
        this.xunwuYuyuePhoto = xunwuYuyuePhoto;
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
    public Integer getXunwuYuyueYesnoTypes() {
        return xunwuYuyueYesnoTypes;
    }


    /**
	 * 获取：报名状态
	 */

    public void setXunwuYuyueYesnoTypes(Integer xunwuYuyueYesnoTypes) {
        this.xunwuYuyueYesnoTypes = xunwuYuyueYesnoTypes;
    }
    /**
	 * 设置：审核回复
	 */
    public String getXunwuYuyueYesnoText() {
        return xunwuYuyueYesnoText;
    }


    /**
	 * 获取：审核回复
	 */

    public void setXunwuYuyueYesnoText(String xunwuYuyueYesnoText) {
        this.xunwuYuyueYesnoText = xunwuYuyueYesnoText;
    }
    /**
	 * 设置：审核时间
	 */
    public Date getXunwuYuyueShenheTime() {
        return xunwuYuyueShenheTime;
    }


    /**
	 * 获取：审核时间
	 */

    public void setXunwuYuyueShenheTime(Date xunwuYuyueShenheTime) {
        this.xunwuYuyueShenheTime = xunwuYuyueShenheTime;
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
