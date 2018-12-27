package com.flx.flxoa.info.approve.entity.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the flxoa_approve_form table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="flxoa_approve_form"
 */

public abstract class BaseFlxoaApproveForm  implements Serializable {

	public static String REF = "FlxoaApproveForm";
	public static String PROP_SUBMIT_TIME = "SubmitTime";
	public static String PROP_NOW_FORM_STATUS = "NowFormStatus";
	public static String PROP_CREATE_DEPARTMENT_ID = "CreateDepartmentId";
	public static String PROP_SUBMIT_STATUS = "SubmitStatus";
	public static String PROP_DELETE_FLAG = "DeleteFlag";
	public static String PROP_CREATE_USER_ID = "CreateUserId";
	public static String PROP_UPDATE_TIME = "UpdateTime";
	public static String PROP_UPDATE_DEPARTMENT_ID = "UpdateDepartmentId";
	public static String PROP_CHECK_USER_IDS = "CheckUserIds";
	public static String PROP_TEMPLATE_ID = "TemplateId";
	public static String PROP_STATUS = "Status";
	public static String PROP_WORKFLOW_ID = "WorkflowId";
	public static String PROP_UPDATE_USER_ID = "UpdateUserId";
	public static String PROP_CREATE_TIME = "CreateTime";
	public static String PROP_IS_READ = "IsRead";
	public static String PROP_ID = "Id";


	// constructors
	public BaseFlxoaApproveForm () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseFlxoaApproveForm (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseFlxoaApproveForm (
		java.lang.Integer id,
		java.lang.Integer templateId,
		java.lang.String status,
		java.lang.String submitStatus,
		java.lang.Integer submitTime,
		java.lang.Integer workflowId,
		java.lang.String checkUserIds,
		java.lang.String nowFormStatus,
		java.lang.String isRead,
		java.lang.Integer createTime,
		java.lang.Integer updateTime,
		java.lang.String deleteFlag,
		java.lang.Integer createUserId,
		java.lang.Integer createDepartmentId,
		java.lang.Integer updateUserId,
		java.lang.Integer updateDepartmentId) {

		this.setId(id);
		this.setTemplateId(templateId);
		this.setStatus(status);
		this.setSubmitStatus(submitStatus);
		this.setSubmitTime(submitTime);
		this.setWorkflowId(workflowId);
		this.setCheckUserIds(checkUserIds);
		this.setNowFormStatus(nowFormStatus);
		this.setIsRead(isRead);
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
	private java.lang.Integer templateId;
	private java.lang.String status;
	private java.lang.String submitStatus;
	private java.lang.Integer submitTime;
	private java.lang.Integer workflowId;
	private java.lang.String checkUserIds;
	private java.lang.String nowFormStatus;
	private java.lang.String isRead;
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
	 * Return the value associated with the column: template_id
	 */
	public java.lang.Integer getTemplateId () {
		return templateId;
	}

	/**
	 * Set the value related to the column: template_id
	 * @param templateId the template_id value
	 */
	public void setTemplateId (java.lang.Integer templateId) {
		this.templateId = templateId;
	}



	/**
	 * Return the value associated with the column: status
	 */
	public java.lang.String getStatus () {
		return status;
	}

	/**
	 * Set the value related to the column: status
	 * @param status the status value
	 */
	public void setStatus (java.lang.String status) {
		this.status = status;
	}



	/**
	 * Return the value associated with the column: submit_status
	 */
	public java.lang.String getSubmitStatus () {
		return submitStatus;
	}

	/**
	 * Set the value related to the column: submit_status
	 * @param submitStatus the submit_status value
	 */
	public void setSubmitStatus (java.lang.String submitStatus) {
		this.submitStatus = submitStatus;
	}



	/**
	 * Return the value associated with the column: submit_time
	 */
	public java.lang.Integer getSubmitTime () {
		return submitTime;
	}

	/**
	 * Set the value related to the column: submit_time
	 * @param submitTime the submit_time value
	 */
	public void setSubmitTime (java.lang.Integer submitTime) {
		this.submitTime = submitTime;
	}



	/**
	 * Return the value associated with the column: workflow_id
	 */
	public java.lang.Integer getWorkflowId () {
		return workflowId;
	}

	/**
	 * Set the value related to the column: workflow_id
	 * @param workflowId the workflow_id value
	 */
	public void setWorkflowId (java.lang.Integer workflowId) {
		this.workflowId = workflowId;
	}



	/**
	 * Return the value associated with the column: check_user_ids
	 */
	public java.lang.String getCheckUserIds () {
		return checkUserIds;
	}

	/**
	 * Set the value related to the column: check_user_ids
	 * @param checkUserIds the check_user_ids value
	 */
	public void setCheckUserIds (java.lang.String checkUserIds) {
		this.checkUserIds = checkUserIds;
	}



	/**
	 * Return the value associated with the column: now_form_status
	 */
	public java.lang.String getNowFormStatus () {
		return nowFormStatus;
	}

	/**
	 * Set the value related to the column: now_form_status
	 * @param nowFormStatus the now_form_status value
	 */
	public void setNowFormStatus (java.lang.String nowFormStatus) {
		this.nowFormStatus = nowFormStatus;
	}



	/**
	 * Return the value associated with the column: is_read
	 */
	public java.lang.String getIsRead () {
		return isRead;
	}

	/**
	 * Set the value related to the column: is_read
	 * @param isRead the is_read value
	 */
	public void setIsRead (java.lang.String isRead) {
		this.isRead = isRead;
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
		if (!(obj instanceof com.flx.flxoa.info.approve.entity.FlxoaApproveForm)) return false;
		else {
			com.flx.flxoa.info.approve.entity.FlxoaApproveForm flxoaApproveForm = (com.flx.flxoa.info.approve.entity.FlxoaApproveForm) obj;
			if (null == this.getId() || null == flxoaApproveForm.getId()) return false;
			else return (this.getId().equals(flxoaApproveForm.getId()));
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