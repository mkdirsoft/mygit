package com.flx.flxoa.info.system.entity.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the flxoa_approve_workflow table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="flxoa_approve_workflow"
 */

public abstract class BaseFlxoaApproveWorkflow  implements Serializable {

	public static String REF = "FlxoaApproveWorkflow";
	public static String PROP_COMPANY_ID = "CompanyId";
	public static String PROP_WORKFLOW_JSON = "WorkflowJson";
	public static String PROP_CREATE_DEPARTMENT_ID = "CreateDepartmentId";
	public static String PROP_DELETE_FLAG = "DeleteFlag";
	public static String PROP_CREATE_USER_ID = "CreateUserId";
	public static String PROP_UPDATE_TIME = "UpdateTime";
	public static String PROP_UPDATE_DEPARTMENT_ID = "UpdateDepartmentId";
	public static String PROP_WORKFLOW_NAME = "WorkflowName";
	public static String PROP_TEMPLAGE_NAMES = "TemplageNames";
	public static String PROP_UPDATE_USER_ID = "UpdateUserId";
	public static String PROP_CREATE_TIME = "CreateTime";
	public static String PROP_ID = "Id";
	public static String PROP_TEMPLAGE_IDS = "TemplageIds";
	public static String PROP_DEPARTMENT_ID = "DepartmentId";


	// constructors
	public BaseFlxoaApproveWorkflow () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseFlxoaApproveWorkflow (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseFlxoaApproveWorkflow (
		java.lang.Integer id,
		java.lang.String workflowName,
		java.lang.String workflowJson,
		java.lang.Integer companyId,
		java.lang.Integer departmentId,
		java.lang.String templageIds,
		java.lang.String templageNames,
		java.lang.Integer createTime,
		java.lang.Integer updateTime,
		java.lang.String deleteFlag,
		java.lang.Integer createUserId,
		java.lang.Integer createDepartmentId,
		java.lang.Integer updateUserId,
		java.lang.Integer updateDepartmentId) {

		this.setId(id);
		this.setWorkflowName(workflowName);
		this.setWorkflowJson(workflowJson);
		this.setCompanyId(companyId);
		this.setDepartmentId(departmentId);
		this.setTemplageIds(templageIds);
		this.setTemplageNames(templageNames);
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
	private java.lang.String workflowName;
	private java.lang.String workflowJson;
	private java.lang.Integer companyId;
	private java.lang.Integer departmentId;
	private java.lang.String templageIds;
	private java.lang.String templageNames;
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
	 * Return the value associated with the column: workflow_name
	 */
	public java.lang.String getWorkflowName () {
		return workflowName;
	}

	/**
	 * Set the value related to the column: workflow_name
	 * @param workflowName the workflow_name value
	 */
	public void setWorkflowName (java.lang.String workflowName) {
		this.workflowName = workflowName;
	}



	/**
	 * Return the value associated with the column: workflow_json
	 */
	public java.lang.String getWorkflowJson () {
		return workflowJson;
	}

	/**
	 * Set the value related to the column: workflow_json
	 * @param workflowJson the workflow_json value
	 */
	public void setWorkflowJson (java.lang.String workflowJson) {
		this.workflowJson = workflowJson;
	}



	/**
	 * Return the value associated with the column: company_id
	 */
	public java.lang.Integer getCompanyId () {
		return companyId;
	}

	/**
	 * Set the value related to the column: company_id
	 * @param companyId the company_id value
	 */
	public void setCompanyId (java.lang.Integer companyId) {
		this.companyId = companyId;
	}



	/**
	 * Return the value associated with the column: department_id
	 */
	public java.lang.Integer getDepartmentId () {
		return departmentId;
	}

	/**
	 * Set the value related to the column: department_id
	 * @param departmentId the department_id value
	 */
	public void setDepartmentId (java.lang.Integer departmentId) {
		this.departmentId = departmentId;
	}



	/**
	 * Return the value associated with the column: templage_ids
	 */
	public java.lang.String getTemplageIds () {
		return templageIds;
	}

	/**
	 * Set the value related to the column: templage_ids
	 * @param templageIds the templage_ids value
	 */
	public void setTemplageIds (java.lang.String templageIds) {
		this.templageIds = templageIds;
	}



	/**
	 * Return the value associated with the column: templage_names
	 */
	public java.lang.String getTemplageNames () {
		return templageNames;
	}

	/**
	 * Set the value related to the column: templage_names
	 * @param templageNames the templage_names value
	 */
	public void setTemplageNames (java.lang.String templageNames) {
		this.templageNames = templageNames;
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
		if (!(obj instanceof com.flx.flxoa.info.system.entity.FlxoaApproveWorkflow)) return false;
		else {
			com.flx.flxoa.info.system.entity.FlxoaApproveWorkflow flxoaApproveWorkflow = (com.flx.flxoa.info.system.entity.FlxoaApproveWorkflow) obj;
			if (null == this.getId() || null == flxoaApproveWorkflow.getId()) return false;
			else return (this.getId().equals(flxoaApproveWorkflow.getId()));
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