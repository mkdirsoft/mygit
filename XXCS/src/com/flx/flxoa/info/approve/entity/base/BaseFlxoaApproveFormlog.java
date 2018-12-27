package com.flx.flxoa.info.approve.entity.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the flxoa_approve_formlog table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="flxoa_approve_formlog"
 */

public abstract class BaseFlxoaApproveFormlog  implements Serializable {

	public static String REF = "FlxoaApproveFormlog";
	public static String PROP_NEXT_STATUS = "NextStatus";
	public static String PROP_APPROVE_IDEA = "ApproveIdea";
	public static String PROP_CREATE_DEPARTMENT_ID = "CreateDepartmentId";
	public static String PROP_DELETE_FLAG = "DeleteFlag";
	public static String PROP_CREATE_USER_ID = "CreateUserId";
	public static String PROP_UPDATE_TIME = "UpdateTime";
	public static String PROP_UPDATE_DEPARTMENT_ID = "UpdateDepartmentId";
	public static String PROP_APPROVE_REMARK = "ApproveRemark";
	public static String PROP_FORM_ID = "FormId";
	public static String PROP_APPROVE_USER = "ApproveUser";
	public static String PROP_UPDATE_USER_ID = "UpdateUserId";
	public static String PROP_APPROVE_TIME = "ApproveTime";
	public static String PROP_CREATE_TIME = "CreateTime";
	public static String PROP_ID = "Id";
	public static String PROP_NOW_STATUS = "NowStatus";


	// constructors
	public BaseFlxoaApproveFormlog () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseFlxoaApproveFormlog (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseFlxoaApproveFormlog (
		java.lang.Integer id,
		java.lang.String nowStatus,
		java.lang.String approveUser,
		java.lang.Integer approveTime,
		java.lang.String nextStatus,
		java.lang.String approveRemark,
		java.lang.String approveIdea,
		java.lang.Integer formId,
		java.lang.Integer createTime,
		java.lang.Integer updateTime,
		java.lang.String deleteFlag,
		java.lang.Integer createUserId,
		java.lang.Integer createDepartmentId,
		java.lang.Integer updateUserId,
		java.lang.Integer updateDepartmentId) {

		this.setId(id);
		this.setNowStatus(nowStatus);
		this.setApproveUser(approveUser);
		this.setApproveTime(approveTime);
		this.setNextStatus(nextStatus);
		this.setApproveRemark(approveRemark);
		this.setApproveIdea(approveIdea);
		this.setFormId(formId);
		this.setCreateTime(createTime);
		this.setUpdateTime(updateTime);
		this.setDeleteFlag(deleteFlag);
		this.setCreateUserId(createUserId);
		this.setCreateDepartmentId(createDepartmentId);
		this.setUpdateUserId(updateUserId);
		this.setUpdateDepartmentId(updateDepartmentId);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String nowStatus;
	private java.lang.String approveUser;
	private java.lang.Integer approveTime;
	private java.lang.String nextStatus;
	private java.lang.String approveRemark;
	private java.lang.String approveIdea;
	private java.lang.Integer formId;
	private java.lang.Integer createTime;
	private java.lang.Integer updateTime;
	private java.lang.String deleteFlag;
	private java.lang.Integer createUserId;
	private java.lang.Integer createDepartmentId;
	private java.lang.Integer updateUserId;
	private java.lang.Integer updateDepartmentId;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="identity"
     *  column="id"
     */
	public java.lang.Integer getId () {
		return id;
	}

	/**
	 * Set the unique identifier of this class
	 * @param id the new ID
	 */
	public void setId (java.lang.Integer id) {
		this.id = id;
		this.hashCode = Integer.MIN_VALUE;
	}




	/**
	 * Return the value associated with the column: now_status
	 */
	public java.lang.String getNowStatus () {
		return nowStatus;
	}

	/**
	 * Set the value related to the column: now_status
	 * @param nowStatus the now_status value
	 */
	public void setNowStatus (java.lang.String nowStatus) {
		this.nowStatus = nowStatus;
	}



	/**
	 * Return the value associated with the column: approve_user
	 */
	public java.lang.String getApproveUser () {
		return approveUser;
	}

	/**
	 * Set the value related to the column: approve_user
	 * @param approveUser the approve_user value
	 */
	public void setApproveUser (java.lang.String approveUser) {
		this.approveUser = approveUser;
	}



	/**
	 * Return the value associated with the column: approve_time
	 */
	public java.lang.Integer getApproveTime () {
		return approveTime;
	}

	/**
	 * Set the value related to the column: approve_time
	 * @param approveTime the approve_time value
	 */
	public void setApproveTime (java.lang.Integer approveTime) {
		this.approveTime = approveTime;
	}



	/**
	 * Return the value associated with the column: next_status
	 */
	public java.lang.String getNextStatus () {
		return nextStatus;
	}

	/**
	 * Set the value related to the column: next_status
	 * @param nextStatus the next_status value
	 */
	public void setNextStatus (java.lang.String nextStatus) {
		this.nextStatus = nextStatus;
	}



	/**
	 * Return the value associated with the column: approve_remark
	 */
	public java.lang.String getApproveRemark () {
		return approveRemark;
	}

	/**
	 * Set the value related to the column: approve_remark
	 * @param approveRemark the approve_remark value
	 */
	public void setApproveRemark (java.lang.String approveRemark) {
		this.approveRemark = approveRemark;
	}



	/**
	 * Return the value associated with the column: approve_idea
	 */
	public java.lang.String getApproveIdea () {
		return approveIdea;
	}

	/**
	 * Set the value related to the column: approve_idea
	 * @param approveIdea the approve_idea value
	 */
	public void setApproveIdea (java.lang.String approveIdea) {
		this.approveIdea = approveIdea;
	}



	/**
	 * Return the value associated with the column: form_id
	 */
	public java.lang.Integer getFormId () {
		return formId;
	}

	/**
	 * Set the value related to the column: form_id
	 * @param formId the form_id value
	 */
	public void setFormId (java.lang.Integer formId) {
		this.formId = formId;
	}



	/**
	 * Return the value associated with the column: create_time
	 */
	public java.lang.Integer getCreateTime () {
		return createTime;
	}

	/**
	 * Set the value related to the column: create_time
	 * @param createTime the create_time value
	 */
	public void setCreateTime (java.lang.Integer createTime) {
		this.createTime = createTime;
	}



	/**
	 * Return the value associated with the column: update_time
	 */
	public java.lang.Integer getUpdateTime () {
		return updateTime;
	}

	/**
	 * Set the value related to the column: update_time
	 * @param updateTime the update_time value
	 */
	public void setUpdateTime (java.lang.Integer updateTime) {
		this.updateTime = updateTime;
	}



	/**
	 * Return the value associated with the column: delete_flag
	 */
	public java.lang.String getDeleteFlag () {
		return deleteFlag;
	}

	/**
	 * Set the value related to the column: delete_flag
	 * @param deleteFlag the delete_flag value
	 */
	public void setDeleteFlag (java.lang.String deleteFlag) {
		this.deleteFlag = deleteFlag;
	}



	/**
	 * Return the value associated with the column: create_user_id
	 */
	public java.lang.Integer getCreateUserId () {
		return createUserId;
	}

	/**
	 * Set the value related to the column: create_user_id
	 * @param createUserId the create_user_id value
	 */
	public void setCreateUserId (java.lang.Integer createUserId) {
		this.createUserId = createUserId;
	}



	/**
	 * Return the value associated with the column: create_department_id
	 */
	public java.lang.Integer getCreateDepartmentId () {
		return createDepartmentId;
	}

	/**
	 * Set the value related to the column: create_department_id
	 * @param createDepartmentId the create_department_id value
	 */
	public void setCreateDepartmentId (java.lang.Integer createDepartmentId) {
		this.createDepartmentId = createDepartmentId;
	}



	/**
	 * Return the value associated with the column: update_user_id
	 */
	public java.lang.Integer getUpdateUserId () {
		return updateUserId;
	}

	/**
	 * Set the value related to the column: update_user_id
	 * @param updateUserId the update_user_id value
	 */
	public void setUpdateUserId (java.lang.Integer updateUserId) {
		this.updateUserId = updateUserId;
	}



	/**
	 * Return the value associated with the column: update_department_id
	 */
	public java.lang.Integer getUpdateDepartmentId () {
		return updateDepartmentId;
	}

	/**
	 * Set the value related to the column: update_department_id
	 * @param updateDepartmentId the update_department_id value
	 */
	public void setUpdateDepartmentId (java.lang.Integer updateDepartmentId) {
		this.updateDepartmentId = updateDepartmentId;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.flx.flxoa.info.approve.entity.FlxoaApproveFormlog)) return false;
		else {
			com.flx.flxoa.info.approve.entity.FlxoaApproveFormlog flxoaApproveFormlog = (com.flx.flxoa.info.approve.entity.FlxoaApproveFormlog) obj;
			if (null == this.getId() || null == flxoaApproveFormlog.getId()) return false;
			else return (this.getId().equals(flxoaApproveFormlog.getId()));
		}
	}

	public int hashCode () {
		if (Integer.MIN_VALUE == this.hashCode) {
			if (null == this.getId()) return super.hashCode();
			else {
				String hashStr = this.getClass().getName() + ":" + this.getId().hashCode();
				this.hashCode = hashStr.hashCode();
			}
		}
		return this.hashCode;
	}


	public String toString () {
		return super.toString();
	}


}