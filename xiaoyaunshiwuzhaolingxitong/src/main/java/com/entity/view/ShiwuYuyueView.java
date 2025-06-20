package com.entity.view;

import org.apache.tools.ant.util.DateUtils;
import com.annotation.ColumnInfo;
import com.entity.ShiwuYuyueEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;
import com.utils.DateUtil;

/**
* 失物认领
* 后端返回视图实体辅助类
* （通常后端关联的表或者自定义的字段需要返回使用）
*/
@TableName("shiwu_yuyue")
public class ShiwuYuyueView extends ShiwuYuyueEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	//当前表
	/**
	* 报名状态的值
	*/
	@ColumnInfo(comment="报名状态的字典表值",type="varchar(200)")
	private String shiwuYuyueYesnoValue;

	//级联表 失物招领
					 
		/**
		* 失物招领 的 用户
		*/
		@ColumnInfo(comment="用户",type="int(11)")
		private Integer shiwuYonghuId;
		/**
		* 失物名称
		*/

		@ColumnInfo(comment="失物名称",type="varchar(200)")
		private String shiwuName;
		/**
		* 失物编号
		*/

		@ColumnInfo(comment="失物编号",type="varchar(200)")
		private String shiwuUuidNumber;
		/**
		* 失物照片
		*/

		@ColumnInfo(comment="失物照片",type="varchar(200)")
		private String shiwuPhoto;
		/**
		* 时间
		*/
		@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
		@DateTimeFormat
		@ColumnInfo(comment="时间",type="timestamp")
		private Date shiwuTime;
		/**
		* 失物地点
		*/

		@ColumnInfo(comment="失物地点",type="varchar(200)")
		private String shiwuAddress;
		/**
		* 失物类型
		*/
		@ColumnInfo(comment="失物类型",type="int(11)")
		private Integer shiwuTypes;
			/**
			* 失物类型的值
			*/
			@ColumnInfo(comment="失物类型的字典表值",type="varchar(200)")
			private String shiwuValue;
		/**
		* 申请状态
		*/
		@ColumnInfo(comment="申请状态",type="int(11)")
		private Integer shiwuYesnoTypes;
			/**
			* 申请状态的值
			*/
			@ColumnInfo(comment="申请状态的字典表值",type="varchar(200)")
			private String shiwuYesnoValue;
		/**
		* 审核意见
		*/

		@ColumnInfo(comment="审核意见",type="longtext")
		private String shiwuYesnoText;
		/**
		* 审核时间
		*/
		@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
		@DateTimeFormat
		@ColumnInfo(comment="审核时间",type="timestamp")
		private Date shiwuShenheTime;
		/**
		* 失物介绍
		*/

		@ColumnInfo(comment="失物介绍",type="longtext")
		private String shiwuContent;
		/**
		* 逻辑删除
		*/

		@ColumnInfo(comment="逻辑删除",type="int(11)")
		private Integer shiwuDelete;
	//级联表 用户
		/**
		* 用户编号
		*/

		@ColumnInfo(comment="用户编号",type="varchar(200)")
		private String yonghuUuidNumber;
		/**
		* 用户姓名
		*/

		@ColumnInfo(comment="用户姓名",type="varchar(200)")
		private String yonghuName;
		/**
		* 用户手机号
		*/

		@ColumnInfo(comment="用户手机号",type="varchar(200)")
		private String yonghuPhone;
		/**
		* 用户身份证号
		*/

		@ColumnInfo(comment="用户身份证号",type="varchar(200)")
		private String yonghuIdNumber;
		/**
		* 用户头像
		*/

		@ColumnInfo(comment="用户头像",type="varchar(200)")
		private String yonghuPhoto;
		/**
		* 用户邮箱
		*/

		@ColumnInfo(comment="用户邮箱",type="varchar(200)")
		private String yonghuEmail;



	public ShiwuYuyueView() {

	}

	public ShiwuYuyueView(ShiwuYuyueEntity shiwuYuyueEntity) {
		try {
			BeanUtils.copyProperties(this, shiwuYuyueEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



	//当前表的
	/**
	* 获取： 报名状态的值
	*/
	public String getShiwuYuyueYesnoValue() {
		return shiwuYuyueYesnoValue;
	}
	/**
	* 设置： 报名状态的值
	*/
	public void setShiwuYuyueYesnoValue(String shiwuYuyueYesnoValue) {
		this.shiwuYuyueYesnoValue = shiwuYuyueYesnoValue;
	}


	//级联表的get和set 失物招领
		/**
		* 获取：失物招领 的 用户
		*/
		public Integer getShiwuYonghuId() {
			return shiwuYonghuId;
		}
		/**
		* 设置：失物招领 的 用户
		*/
		public void setShiwuYonghuId(Integer shiwuYonghuId) {
			this.shiwuYonghuId = shiwuYonghuId;
		}

		/**
		* 获取： 失物名称
		*/
		public String getShiwuName() {
			return shiwuName;
		}
		/**
		* 设置： 失物名称
		*/
		public void setShiwuName(String shiwuName) {
			this.shiwuName = shiwuName;
		}

		/**
		* 获取： 失物编号
		*/
		public String getShiwuUuidNumber() {
			return shiwuUuidNumber;
		}
		/**
		* 设置： 失物编号
		*/
		public void setShiwuUuidNumber(String shiwuUuidNumber) {
			this.shiwuUuidNumber = shiwuUuidNumber;
		}

		/**
		* 获取： 失物照片
		*/
		public String getShiwuPhoto() {
			return shiwuPhoto;
		}
		/**
		* 设置： 失物照片
		*/
		public void setShiwuPhoto(String shiwuPhoto) {
			this.shiwuPhoto = shiwuPhoto;
		}

		/**
		* 获取： 时间
		*/
		public Date getShiwuTime() {
			return shiwuTime;
		}
		/**
		* 设置： 时间
		*/
		public void setShiwuTime(Date shiwuTime) {
			this.shiwuTime = shiwuTime;
		}

		/**
		* 获取： 失物地点
		*/
		public String getShiwuAddress() {
			return shiwuAddress;
		}
		/**
		* 设置： 失物地点
		*/
		public void setShiwuAddress(String shiwuAddress) {
			this.shiwuAddress = shiwuAddress;
		}
		/**
		* 获取： 失物类型
		*/
		public Integer getShiwuTypes() {
			return shiwuTypes;
		}
		/**
		* 设置： 失物类型
		*/
		public void setShiwuTypes(Integer shiwuTypes) {
			this.shiwuTypes = shiwuTypes;
		}


			/**
			* 获取： 失物类型的值
			*/
			public String getShiwuValue() {
				return shiwuValue;
			}
			/**
			* 设置： 失物类型的值
			*/
			public void setShiwuValue(String shiwuValue) {
				this.shiwuValue = shiwuValue;
			}
		/**
		* 获取： 申请状态
		*/
		public Integer getShiwuYesnoTypes() {
			return shiwuYesnoTypes;
		}
		/**
		* 设置： 申请状态
		*/
		public void setShiwuYesnoTypes(Integer shiwuYesnoTypes) {
			this.shiwuYesnoTypes = shiwuYesnoTypes;
		}


			/**
			* 获取： 申请状态的值
			*/
			public String getShiwuYesnoValue() {
				return shiwuYesnoValue;
			}
			/**
			* 设置： 申请状态的值
			*/
			public void setShiwuYesnoValue(String shiwuYesnoValue) {
				this.shiwuYesnoValue = shiwuYesnoValue;
			}

		/**
		* 获取： 审核意见
		*/
		public String getShiwuYesnoText() {
			return shiwuYesnoText;
		}
		/**
		* 设置： 审核意见
		*/
		public void setShiwuYesnoText(String shiwuYesnoText) {
			this.shiwuYesnoText = shiwuYesnoText;
		}

		/**
		* 获取： 审核时间
		*/
		public Date getShiwuShenheTime() {
			return shiwuShenheTime;
		}
		/**
		* 设置： 审核时间
		*/
		public void setShiwuShenheTime(Date shiwuShenheTime) {
			this.shiwuShenheTime = shiwuShenheTime;
		}

		/**
		* 获取： 失物介绍
		*/
		public String getShiwuContent() {
			return shiwuContent;
		}
		/**
		* 设置： 失物介绍
		*/
		public void setShiwuContent(String shiwuContent) {
			this.shiwuContent = shiwuContent;
		}

		/**
		* 获取： 逻辑删除
		*/
		public Integer getShiwuDelete() {
			return shiwuDelete;
		}
		/**
		* 设置： 逻辑删除
		*/
		public void setShiwuDelete(Integer shiwuDelete) {
			this.shiwuDelete = shiwuDelete;
		}
	//级联表的get和set 用户

		/**
		* 获取： 用户编号
		*/
		public String getYonghuUuidNumber() {
			return yonghuUuidNumber;
		}
		/**
		* 设置： 用户编号
		*/
		public void setYonghuUuidNumber(String yonghuUuidNumber) {
			this.yonghuUuidNumber = yonghuUuidNumber;
		}

		/**
		* 获取： 用户姓名
		*/
		public String getYonghuName() {
			return yonghuName;
		}
		/**
		* 设置： 用户姓名
		*/
		public void setYonghuName(String yonghuName) {
			this.yonghuName = yonghuName;
		}

		/**
		* 获取： 用户手机号
		*/
		public String getYonghuPhone() {
			return yonghuPhone;
		}
		/**
		* 设置： 用户手机号
		*/
		public void setYonghuPhone(String yonghuPhone) {
			this.yonghuPhone = yonghuPhone;
		}

		/**
		* 获取： 用户身份证号
		*/
		public String getYonghuIdNumber() {
			return yonghuIdNumber;
		}
		/**
		* 设置： 用户身份证号
		*/
		public void setYonghuIdNumber(String yonghuIdNumber) {
			this.yonghuIdNumber = yonghuIdNumber;
		}

		/**
		* 获取： 用户头像
		*/
		public String getYonghuPhoto() {
			return yonghuPhoto;
		}
		/**
		* 设置： 用户头像
		*/
		public void setYonghuPhoto(String yonghuPhoto) {
			this.yonghuPhoto = yonghuPhoto;
		}

		/**
		* 获取： 用户邮箱
		*/
		public String getYonghuEmail() {
			return yonghuEmail;
		}
		/**
		* 设置： 用户邮箱
		*/
		public void setYonghuEmail(String yonghuEmail) {
			this.yonghuEmail = yonghuEmail;
		}


	@Override
	public String toString() {
		return "ShiwuYuyueView{" +
			", shiwuYuyueYesnoValue=" + shiwuYuyueYesnoValue +
			", shiwuName=" + shiwuName +
			", shiwuUuidNumber=" + shiwuUuidNumber +
			", shiwuPhoto=" + shiwuPhoto +
			", shiwuTime=" + DateUtil.convertString(shiwuTime,"yyyy-MM-dd") +
			", shiwuAddress=" + shiwuAddress +
			", shiwuYesnoText=" + shiwuYesnoText +
			", shiwuShenheTime=" + DateUtil.convertString(shiwuShenheTime,"yyyy-MM-dd") +
			", shiwuContent=" + shiwuContent +
			", shiwuDelete=" + shiwuDelete +
			", yonghuUuidNumber=" + yonghuUuidNumber +
			", yonghuName=" + yonghuName +
			", yonghuPhone=" + yonghuPhone +
			", yonghuIdNumber=" + yonghuIdNumber +
			", yonghuPhoto=" + yonghuPhoto +
			", yonghuEmail=" + yonghuEmail +
			"} " + super.toString();
	}
}
