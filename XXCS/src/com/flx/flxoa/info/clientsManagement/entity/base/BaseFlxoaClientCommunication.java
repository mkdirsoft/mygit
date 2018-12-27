package com.flx.flxoa.info.clientsManagement.entity.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the flxoa_client_communication table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="flxoa_client_communication"
 */

public abstract class BaseFlxoaClientCommunication  implements Serializable {

	public static String REF = "FlxoaClientCommunication";
	public static String PROP_COMM_PATTERN = "CommPattern";
	public static String PROP_CREATE_DEPARTMENT_ID = "CreateDepartmentId";
	public static String PROP_DELETE_FLAG = "DeleteFlag";
	public static String PROP_CREATE_USER_ID = "CreateUserId";
	public static String PROP_UPDATE_TIME = "UpdateTime";
	public static String PROP_COMM_MAIN_CONTENT = "CommMainContent";
	public static String PROP_UPDATE_DEPARTMENT_ID = "UpdateDepartmentId";
	public static String PROP_UPDATE_USER_ID = "UpdateUserId";
	public static String PROP_PROJ_ID = "ProjId";
	public static String PROP_CREATE_TIME = "CreateTime";
	public static String PROP_ID = "Id";
	public static String PROP_CONTACT_ID = "ContactId";
	public static String PROP_COMM_END_TIME = "CommEndTime";
	public static String PROP_COMM_START_TIME = "CommStartTime";


	// constructors
	public BaseFlxoaClientCommunication () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseFlxoaClientCommunication (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseFlxoaClientCommunication (
		java.lang.Integer id,
		java.lang.Integer projId,
		java.lang.Integer contactId,
		java.lang.Integer commStartTime,
		java.lang.Integer commEndTime,
		java.lang.Integer commPattern,
		java.lang.String commMainContent,
		java.lang.String deleteFlag,
		java.lang.Integer createUserId,
		java.lang.Integer createDepartmentId,
		java.lang.Integer createTime,
		java.lang.Integer updateUserId,
		java.lang.Integer updateDepartmentId,
		java.lang.Integer updateTime) {

		this.setId(id);
		this.setProjId(projId);
		this.setContactId(contactId);
		this.setCommStartTime(commStartTime);
		this.setCommEndTime(commEndTime);
		this.setCommPattern(commPattern);
		this.setCommMainContent(commMainContent);
		this.setDeleteFlag(deleteFlag);
		this.setCreateUserId(createUserId);
		this.setCreateDepartmentId(createDepartmentId);
		this.setCreateTime(createTime);
		this.setUpdateUserId(updateUserId);
		this.setUpdateDepartmentId(updateDepartmentId);
		this.setUpdateTime(updateTime);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.Integer projId;
	private java.lang.Integer contactId;
	private java.lang.Integer commStartTime;
	private java.lang.Integer commEndTime;
	private java.lang.Integer commPattern;
	private java.lang.String commMainContent;
	private java.lang.String deleteFlag;
	private java.lang.Integer createUserId;
	private java.lang.Integer createDepartmentId;
	private java.lang.Integer createTime;
	private java.lang.Integer updateUserId;
	private java.lang.Integer updateDepartmentId;
	private java.lang.Integer updateTime;



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
	 * Return the value associated with the column: proj_id
	 */
	public java.lang.Integer getProjId () {
		return projId;
	}

	/**
	 * Set the value related to the column: proj_id
	 * @param projId the proj_id value
	 */
	public void setProjId (java.lang.Integer projId) {
		this.projId = projId;
	}



	/**
	 * Return the value associated with the column: contact_id
	 */
	public java.lang.Integer getContactId () {
		return contactId;
	}

	/**
	 * Set the value related to the column: contact_id
	 * @param contactId the contact_id value
	 */
	public void setContactId (java.lang.Integer contactId) {
		this.contactId = contactId;
	}



	/**
	 * Return the value associated with the column: comm_start_time
	 */
	public java.lang.Integer getCommStartTime () {
		return commStartTime;
	}

	/**
	 * Set the value related to the column: comm_start_time
	 * @param commStartTime the comm_start_time value
	 */
	public void setCommStartTime (java.lang.Integer commStartTime) {
		this.commStartTime = commStartTime;
	}



	/**
	 * Return the value associated with the column: comm_end_time
	 */
	public java.lang.Integer getCommEndTime () {
		return commEndTime;
	}

	/**
	 * Set the value related to the column: comm_end_time
	 * @param commEndTime the comm_end_time value
	 */
	public void setCommEndTime (java.lang.Integer commEndTime) {
		this.commEndTime = commEndTime;
	}



	/**
	 * Return the value associated with the column: comm_pattern
	 */
	public java.lang.Integer getCommPattern () {
		return commPattern;
	}

	/**
	 * Set the value related to the column: comm_pattern
	 * @param commPattern the comm_pattern value
	 */
	public void setCommPattern (java.lang.Integer commPattern) {
		this.commPattern = commPattern;
	}



	/**
	 * Return the value associated with the column: comm_main_content
	 */
	public java.lang.String getCommMainContent () {
		return commMainContent;
	}

	/**
	 * Set the value related to the column: comm_main_content
	 * @param commMainContent the comm_main_content value
	 */
	public void setCommMainContent (java.lang.String commMainContent) {
		this.commMainContent = commMainContent;
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




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.flx.flxoa.info.clientsManagement.entity.FlxoaClientCommunication)) return false;
		else {
			com.flx.flxoa.info.clientsManagement.entity.FlxoaClientCommunication flxoaClientCommunication = (com.flx.flxoa.info.clientsManagement.entity.FlxoaClientCommunication) obj;
			if (null == this.getId() || null == flxoaClientCommunication.getId()) return false;
			else return (this.getId().equals(flxoaClientCommunication.getId()));
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