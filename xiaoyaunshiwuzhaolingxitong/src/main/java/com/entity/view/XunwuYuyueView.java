package com.entity.view;

import org.apache.tools.ant.util.DateUtils;
import com.annotation.ColumnInfo;
import com.entity.XunwuYuyueEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;
import com.utils.DateUtil;

/**
* 寻物认领
* 后端返回视图实体辅助类
* （通常后端关联的表或者自定义的字段需要返回使用）
*/
@TableName("xunwu_yuyue")
public class XunwuYuyueView extends XunwuYuyueEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	//当前表
	/**
	* 报名状态的值
	*/
	@ColumnInfo(comment="报名状态的字典表值",type="varchar(200)")
	private String xunwuYuyueYesnoValue;

	//级联表 寻物启示
					 
		/**
		* 寻物启示 的 用户
		*/
		@ColumnInfo(comment="用户",type="int(11)")
		private Integer xunwuYonghuId;
		/**
		* 寻物名称
		*/

		@ColumnInfo(comment="寻物名称",type="varchar(200)")
		private String xunwuName;
		/**
		* 寻物编号
		*/

		@ColumnInfo(comment="寻物编号",type="varchar(200)")
		private String xunwuUuidNumber;
		/**
		* 寻物照片
		*/

		@ColumnInfo(comment="寻物照片",type="varchar(200)")
		private String xunwuPhoto;
		/**
		* 时间
		*/
		@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
		@DateTimeFormat
		@ColumnInfo(comment="时间",type="timestamp")
		private Date xunwuTime;
		/**
		* 寻物地点
		*/

		@ColumnInfo(comment="寻物地点",type="varchar(200)")
		private String xunwuAddress;
		/**
		* 寻物类型
		*/
		@ColumnInfo(comment="寻物类型",type="int(11)")
		private Integer xunwuTypes;
			/**
			* 寻物类型的值
			*/
			@ColumnInfo(comment="寻物类型的字典表值",type="varchar(200)")
			private String xunwuValue;
		/**
		* 申请状态
		*/
		@ColumnInfo(comment="申请状态",type="int(11)")
		private Integer xunwuYesnoTypes;
			/**
			* 申请状态的值
			*/
			@ColumnInfo(comment="申请状态的字典表值",type="varchar(200)")
			private String xunwuYesnoValue;
		/**
		* 审核意见
		*/

		@ColumnInfo(comment="审核意见",type="longtext")
		private String xunwuYesnoText;
		/**
		* 审核时间
		*/
		@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
		@DateTimeFormat
		@ColumnInfo(comment="审核时间",type="timestamp")
		private Date xunwuShenheTime;
		/**
		* 寻物介绍
		*/

		@ColumnInfo(comment="寻物介绍",type="longtext")
		private String xunwuContent;
		/**
		* 逻辑删除
		*/

		@ColumnInfo(comment="逻辑删除",type="int(11)")
		private Integer xunwuDelete;
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



	public XunwuYuyueView() {

	}

	public XunwuYuyueView(XunwuYuyueEntity xunwuYuyueEntity) {
		try {
			BeanUtils.copyProperties(this, xunwuYuyueEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



	//当前表的
	/**
	* 获取： 报名状态的值
	*/
	public String getXunwuYuyueYesnoValue() {
		return xunwuYuyueYesnoValue;
	}
	/**
	* 设置： 报名状态的值
	*/
	public void setXunwuYuyueYesnoValue(String xunwuYuyueYesnoValue) {
		this.xunwuYuyueYesnoValue = xunwuYuyueYesnoValue;
	}


	//级联表的get和set 寻物启示
		/**
		* 获取：寻物启示 的 用户
		*/
		public Integer getXunwuYonghuId() {
			return xunwuYonghuId;
		}
		/**
		* 设置：寻物启示 的 用户
		*/
		public void setXunwuYonghuId(Integer xunwuYonghuId) {
			this.xunwuYonghuId = xunwuYonghuId;
		}

		/**
		* 获取： 寻物名称
		*/
		public String getXunwuName() {
			return xunwuName;
		}
		/**
		* 设置： 寻物名称
		*/
		public void setXunwuName(String xunwuName) {
			this.xunwuName = xunwuName;
		}

		/**
		* 获取： 寻物编号
		*/
		public String getXunwuUuidNumber() {
			return xunwuUuidNumber;
		}
		/**
		* 设置： 寻物编号
		*/
		public void setXunwuUuidNumber(String xunwuUuidNumber) {
			this.xunwuUuidNumber = xunwuUuidNumber;
		}

		/**
		* 获取： 寻物照片
		*/
		public String getXunwuPhoto() {
			return xunwuPhoto;
		}
		/**
		* 设置： 寻物照片
		*/
		public void setXunwuPhoto(String xunwuPhoto) {
			this.xunwuPhoto = xunwuPhoto;
		}

		/**
		* 获取： 时间
		*/
		public Date getXunwuTime() {
			return xunwuTime;
		}
		/**
		* 设置： 时间
		*/
		public void setXunwuTime(Date xunwuTime) {
			this.xunwuTime = xunwuTime;
		}

		/**
		* 获取： 寻物地点
		*/
		public String getXunwuAddress() {
			return xunwuAddress;
		}
		/**
		* 设置： 寻物地点
		*/
		public void setXunwuAddress(String xunwuAddress) {
			this.xunwuAddress = xunwuAddress;
		}
		/**
		* 获取： 寻物类型
		*/
		public Integer getXunwuTypes() {
			return xunwuTypes;
		}
		/**
		* 设置： 寻物类型
		*/
		public void setXunwuTypes(Integer xunwuTypes) {
			this.xunwuTypes = xunwuTypes;
		}


			/**
			* 获取： 寻物类型的值
			*/
			public String getXunwuValue() {
				return xunwuValue;
			}
			/**
			* 设置： 寻物类型的值
			*/
			public void setXunwuValue(String xunwuValue) {
				this.xunwuValue = xunwuValue;
			}
		/**
		* 获取： 申请状态
		*/
		public Integer getXunwuYesnoTypes() {
			return xunwuYesnoTypes;
		}
		/**
		* 设置： 申请状态
		*/
		public void setXunwuYesnoTypes(Integer xunwuYesnoTypes) {
			this.xunwuYesnoTypes = xunwuYesnoTypes;
		}


			/**
			* 获取： 申请状态的值
			*/
			public String getXunwuYesnoValue() {
				return xunwuYesnoValue;
			}
			/**
			* 设置： 申请状态的值
			*/
			public void setXunwuYesnoValue(String xunwuYesnoValue) {
				this.xunwuYesnoValue = xunwuYesnoValue;
			}

		/**
		* 获取： 审核意见
		*/
		public String getXunwuYesnoText() {
			return xunwuYesnoText;
		}
		/**
		* 设置： 审核意见
		*/
		public void setXunwuYesnoText(String xunwuYesnoText) {
			this.xunwuYesnoText = xunwuYesnoText;
		}

		/**
		* 获取： 审核时间
		*/
		public Date getXunwuShenheTime() {
			return xunwuShenheTime;
		}
		/**
		* 设置： 审核时间
		*/
		public void setXunwuShenheTime(Date xunwuShenheTime) {
			this.xunwuShenheTime = xunwuShenheTime;
		}

		/**
		* 获取： 寻物介绍
		*/
		public String getXunwuContent() {
			return xunwuContent;
		}
		/**
		* 设置： 寻物介绍
		*/
		public void setXunwuContent(String xunwuContent) {
			this.xunwuContent = xunwuContent;
		}

		/**
		* 获取： 逻辑删除
		*/
		public Integer getXunwuDelete() {
			return xunwuDelete;
		}
		/**
		* 设置： 逻辑删除
		*/
		public void setXunwuDelete(Integer xunwuDelete) {
			this.xunwuDelete = xunwuDelete;
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
		return "XunwuYuyueView{" +
			", xunwuYuyueYesnoValue=" + xunwuYuyueYesnoValue +
			", xunwuName=" + xunwuName +
			", xunwuUuidNumber=" + xunwuUuidNumber +
			", xunwuPhoto=" + xunwuPhoto +
			", xunwuTime=" + DateUtil.convertString(xunwuTime,"yyyy-MM-dd") +
			", xunwuAddress=" + xunwuAddress +
			", xunwuYesnoText=" + xunwuYesnoText +
			", xunwuShenheTime=" + DateUtil.convertString(xunwuShenheTime,"yyyy-MM-dd") +
			", xunwuContent=" + xunwuContent +
			", xunwuDelete=" + xunwuDelete +
			", yonghuUuidNumber=" + yonghuUuidNumber +
			", yonghuName=" + yonghuName +
			", yonghuPhone=" + yonghuPhone +
			", yonghuIdNumber=" + yonghuIdNumber +
			", yonghuPhoto=" + yonghuPhoto +
			", yonghuEmail=" + yonghuEmail +
			"} " + super.toString();
	}
}
