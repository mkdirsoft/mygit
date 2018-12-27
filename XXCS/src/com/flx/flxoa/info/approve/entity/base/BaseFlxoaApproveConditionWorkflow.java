package com.flx.flxoa.info.approve.entity.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the flxoa_approve_condition_workflow table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="flxoa_approve_condition_workflow"
 */

public abstract class BaseFlxoaApproveConditionWorkflow  implements Serializable {

	public static String REF = "FlxoaApproveConditionWorkflow";
	public static String PROP_CONDITION = "Condition";
	public static String PROP_PARENT_ID = "ParentId";
	public static String PROP_TYPE = "Type";
	public static String PROP_CREATE_DEPARTMENT_ID = "CreateDepartmentId";
	public static String PROP_CREATE_USER_ID = "CreateUserId";
	public static String PROP_DELETE_FLAG = "DeleteFlag";
	public static String PROP_ENUMERATION_NAME = "EnumerationName";
	public static String PROP_UPDATE_TIME = "UpdateTime";
	public static String PROP_UPDATE_DEPARTMENT_ID = "UpdateDepartmentId";
	public static String PROP_TEMPLATE_ID = "TemplateId";
	public static String PROP_WORKFLOW_ID = "WorkflowId";
	public static String PROP_UPDATE_USER_ID = "UpdateUserId";
	public static String PROP_CREATE_TIME = "CreateTime";
	public static String PROP_ID = "Id";
	public static String PROP_EXPRESSION = "Expression";
	public static String PROP_LEVEL = "Level";
	public static String PROP_FORMDATA_DATA_KEY = "FormdataDataKey";


	// constructors
	public BaseFlxoaApproveConditionWorkflow () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseFlxoaApproveConditionWorkflow (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseFlxoaApproveConditionWorkflow (
		java.lang.Integer id,
		java.lang.String formdataDataKey,
		java.lang.String type,
		java.lang.String enumerationName,
		java.lang.String expression,
		java.lang.String condition,
		java.lang.Integer level,
		java.lang.Integer workflowId,
		java.lang.Integer parentId,
		java.lang.Integer templateId,
		java.lang.Integer createTime,
		java.lang.Integer updateTime,
		java.lang.String deleteFlag,
		java.lang.Integer createUserId,
		java.lang.Integer createDepartmentId,
		java.lang.Integer updateUserId,
		java.lang.Integer updateDepartmentId) {

		this.setId(id);
		this.setFormdataDataKey(formdataDataKey);
		this.setType(type);
		this.setEnumerationName(enumerationName);
		this.setExpression(expression);
		this.setCondition(condition);
		this.setLevel(level);
		this.setWorkflowId(workflowId);
		this.setParentId(parentId);
		this.setTemplateId(templateId);
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
	private java.lang.String formdataDataKey;
	private java.lang.String type;
	private java.lang.String enumerationName;
	private java.lang.String expression;
	private java.lang.String condition;
	private java.lang.Integer level;
	private java.lang.Integer workflowId;
	private java.lang.Integer parentId;
	private java.lang.Integer templateId;
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
	 * Return the value associated with the column: formdata_data_key
	 */
	public java.lang.String getFormdataDataKey () {
		return formdataDataKey;
	}

	/**
	 * Set the value related to the column: formdata_data_key
	 * @param formdataDataKey the formdata_data_key value
	 */
	public void setFormdataDataKey (java.lang.String formdataDataKey) {
		this.formdataDataKey = formdataDataKey;
	}



	/**
	 * Return the value associated with the column: type
	 */
	public java.lang.String getType () {
		return type;
	}

	/**
	 * Set the value related to the column: type
	 * @param type the type value
	 */
	public void setType (java.lang.String type) {
		this.type = type;
	}



	/**
	 * Return the value associated with the column: enumeration_name
	 */
	public java.lang.String getEnumerationName () {
		return enumerationName;
	}

	/**
	 * Set the value related to the column: enumeration_name
	 * @param enumerationName the enumeration_name value
	 */
	public void setEnumerationName (java.lang.String enumerationName) {
		this.enumerationName = enumerationName;
	}



	/**
	 * Return the value associated with the column: expression
	 */
	public java.lang.String getExpression () {
		return expression;
	}

	/**
	 * Set the value related to the column: expression
	 * @param expression the expression value
	 */
	public void setExpression (java.lang.String expression) {
		this.expression = expression;
	}



	/**
	 * Return the value associated with the column: condition
	 */
	public java.lang.String getCondition () {
		return condition;
	}

	/**
	 * Set the value related to the column: condition
	 * @param condition the condition value
	 */
	public void setCondition (java.lang.String condition) {
		this.condition = condition;
	}



	/**
	 * Return the value associated with the column: level
	 */
	public java.lang.Integer getLevel () {
		return level;
	}

	/**
	 * Set the value related to the column: level
	 * @param level the level value
	 */
	public void setLevel (java.lang.Integer level) {
		this.level = level;
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
	 * Return the value associated with the column: parent_id
	 */
	public java.lang.Integer getParentId () {
		return parentId;
	}

	/**
	 * Set the value related to the column: parent_id
	 * @param parentId the parent_id value
	 */
	public void setParentId (java.lang.Integer parentId) {
		this.parentId = parentId;
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
		if (!(obj instanceof com.flx.flxoa.info.approve.entity.FlxoaApproveConditionWorkflow)) return false;
		else {
			com.flx.flxoa.info.approve.entity.FlxoaApproveConditionWorkflow flxoaApproveConditionWorkflow = (com.flx.flxoa.info.approve.entity.FlxoaApproveConditionWorkflow) obj;
			if (null == this.getId() || null == flxoaApproveConditionWorkflow.getId()) return false;
			else return (this.getId().equals(flxoaApproveConditionWorkflow.getId()));
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