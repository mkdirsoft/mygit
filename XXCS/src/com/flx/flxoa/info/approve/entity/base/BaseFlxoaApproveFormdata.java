package com.flx.flxoa.info.approve.entity.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the flxoa_approve_formdata table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="flxoa_approve_formdata"
 */

public abstract class BaseFlxoaApproveFormdata  implements Serializable {

	public static String REF = "FlxoaApproveFormdata";
	public static String PROP_FORM_ID = "FormId";
	public static String PROP_UPDATE_USER_ID = "UpdateUserId";
	public static String PROP_DATA_KEY = "DataKey";
	public static String PROP_CREATE_DEPARTMENT_ID = "CreateDepartmentId";
	public static String PROP_CREATE_TIME = "CreateTime";
	public static String PROP_DATA_DESCRIPTION = "DataDescription";
	public static String PROP_CREATE_USER_ID = "CreateUserId";
	public static String PROP_DELETE_FLAG = "DeleteFlag";
	public static String PROP_UPDATE_TIME = "UpdateTime";
	public static String PROP_ID = "Id";
	public static String PROP_UPDATE_DEPARTMENT_ID = "UpdateDepartmentId";
	public static String PROP_DATA_VALUE = "DataValue";


	// constructors
	public BaseFlxoaApproveFormdata () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseFlxoaApproveFormdata (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseFlxoaApproveFormdata (
		java.lang.Integer id,
		java.lang.String dataKey,
		java.lang.String dataValue,
		java.lang.String dataDescription,
		java.lang.Integer formId,
		java.lang.Integer createTime,
		java.lang.Integer updateTime,
		java.lang.String deleteFlag,
		java.lang.Integer createUserId,
		java.lang.Integer createDepartmentId,
		java.lang.Integer updateUserId,
		java.lang.Integer updateDepartmentId) {

		this.setId(id);
		this.setDataKey(dataKey);
		this.setDataValue(dataValue);
		this.setDataDescription(dataDescription);
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
	private java.lang.String dataKey;
	private java.lang.String dataValue;
	private java.lang.String dataDescription;
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
	 * Return the value associated with the column: data_key
	 */
	public java.lang.String getDataKey () {
		return dataKey;
	}

	/**
	 * Set the value related to the column: data_key
	 * @param dataKey the data_key value
	 */
	public void setDataKey (java.lang.String dataKey) {
		this.dataKey = dataKey;
	}



	/**
	 * Return the value associated with the column: data_value
	 */
	public java.lang.String getDataValue () {
		return dataValue;
	}

	/**
	 * Set the value related to the column: data_value
	 * @param dataValue the data_value value
	 */
	public void setDataValue (java.lang.String dataValue) {
		this.dataValue = dataValue;
	}



	/**
	 * Return the value associated with the column: data_description
	 */
	public java.lang.String getDataDescription () {
		return dataDescription;
	}

	/**
	 * Set the value related to the column: data_description
	 * @param dataDescription the data_description value
	 */
	public void setDataDescription (java.lang.String dataDescription) {
		this.dataDescription = dataDescription;
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
		if (!(obj instanceof com.flx.flxoa.info.approve.entity.FlxoaApproveFormdata)) return false;
		else {
			com.flx.flxoa.info.approve.entity.FlxoaApproveFormdata flxoaApproveFormdata = (com.flx.flxoa.info.approve.entity.FlxoaApproveFormdata) obj;
			if (null == this.getId() || null == flxoaApproveFormdata.getId()) return false;
			else return (this.getId().equals(flxoaApproveFormdata.getId()));
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