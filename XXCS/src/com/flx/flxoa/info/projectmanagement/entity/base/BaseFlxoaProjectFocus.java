package com.flx.flxoa.info.projectmanagement.entity.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the flxoa_project_focus table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="flxoa_project_focus"
 */

public abstract class BaseFlxoaProjectFocus  implements Serializable {

	public static String REF = "FlxoaProjectFocus";
	public static String PROP_FLAG = "Flag";
	public static String PROP_UPDATE_USER_ID = "UpdateUserId";
	public static String PROP_CREATE_DEPARTMENT_ID = "CreateDepartmentId";
	public static String PROP_CREATE_TIME = "CreateTime";
	public static String PROP_DELETE_FLAG = "DeleteFlag";
	public static String PROP_CREATE_USER_ID = "CreateUserId";
	public static String PROP_UPDATE_TIME = "UpdateTime";
	public static String PROP_ID = "Id";
	public static String PROP_UPDATE_DEPARTMENT_ID = "UpdateDepartmentId";
	public static String PROP_PROJECT_ID = "ProjectId";


	// constructors
	public BaseFlxoaProjectFocus () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseFlxoaProjectFocus (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseFlxoaProjectFocus (
		java.lang.Integer id,
		java.lang.Integer projectId,
		java.lang.Integer createUserId,
		java.lang.Integer createTime,
		java.lang.Integer createDepartmentId,
		java.lang.Integer updateTime,
		java.lang.Integer updateUserId,
		java.lang.Integer updateDepartmentId,
		java.lang.String flag,
		java.lang.String deleteFlag) {

		this.setId(id);
		this.setProjectId(projectId);
		this.setCreateUserId(createUserId);
		this.setCreateTime(createTime);
		this.setCreateDepartmentId(createDepartmentId);
		this.setUpdateTime(updateTime);
		this.setUpdateUserId(updateUserId);
		this.setUpdateDepartmentId(updateDepartmentId);
		this.setFlag(flag);
		this.setDeleteFlag(deleteFlag);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.Integer projectId;
	private java.lang.Integer createUserId;
	private java.lang.Integer createTime;
	private java.lang.Integer createDepartmentId;
	private java.lang.Integer updateTime;
	private java.lang.Integer updateUserId;
	private java.lang.Integer updateDepartmentId;
	private java.lang.String flag;
	private java.lang.String deleteFlag;



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
	 * Return the value associated with the column: project_id
	 */
	public java.lang.Integer getProjectId () {
		return projectId;
	}

	/**
	 * Set the value related to the column: project_id
	 * @param projectId the project_id value
	 */
	public void setProjectId (java.lang.Integer projectId) {
		this.projectId = projectId;
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
	 * Return the value associated with the column: flag
	 */
	public java.lang.String getFlag () {
		return flag;
	}

	/**
	 * Set the value related to the column: flag
	 * @param flag the flag value
	 */
	public void setFlag (java.lang.String flag) {
		this.flag = flag;
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




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.flx.flxoa.info.projectmanagement.entity.FlxoaProjectFocus)) return false;
		else {
			com.flx.flxoa.info.projectmanagement.entity.FlxoaProjectFocus flxoaProjectFocus = (com.flx.flxoa.info.projectmanagement.entity.FlxoaProjectFocus) obj;
			if (null == this.getId() || null == flxoaProjectFocus.getId()) return false;
			else return (this.getId().equals(flxoaProjectFocus.getId()));
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