package com.flx.flxoa.info.clientsManagement.entity.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the flxoa_client_contact table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="flxoa_client_contact"
 */

public abstract class BaseFlxoaClientContact  implements Serializable {

	public static String REF = "FlxoaClientContact";
	public static String PROP_CONTACT_NAME = "ContactName";
	public static String PROP_CREATE_DEPARTMENT_ID = "CreateDepartmentId";
	public static String PROP_DELETE_FLAG = "DeleteFlag";
	public static String PROP_CREATE_USER_ID = "CreateUserId";
	public static String PROP_UPDATE_TIME = "UpdateTime";
	public static String PROP_CONTACT_PHONE = "ContactPhone";
	public static String PROP_UPDATE_DEPARTMENT_ID = "UpdateDepartmentId";
	public static String PROP_CLIENT_ID = "ClientId";
	public static String PROP_CONTACT_GENDER = "ContactGender";
	public static String PROP_CONTACT_DUTY = "ContactDuty";
	public static String PROP_UPDATE_USER_ID = "UpdateUserId";
	public static String PROP_CREATE_TIME = "CreateTime";
	public static String PROP_ID = "Id";
	public static String PROP_CONTACT_MAIL = "ContactMail";


	// constructors
	public BaseFlxoaClientContact () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseFlxoaClientContact (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseFlxoaClientContact (
		java.lang.Integer id,
		java.lang.Integer clientId,
		java.lang.String contactName,
		java.lang.Integer contactGender,
		java.lang.String contactDuty,
		java.lang.String contactPhone,
		java.lang.String contactMail,
		java.lang.String deleteFlag,
		java.lang.Integer createUserId,
		java.lang.Integer createDepartmentId,
		java.lang.Integer createTime,
		java.lang.Integer updateUserId,
		java.lang.Integer updateDepartmentId,
		java.lang.Integer updateTime) {

		this.setId(id);
		this.setClientId(clientId);
		this.setContactName(contactName);
		this.setContactGender(contactGender);
		this.setContactDuty(contactDuty);
		this.setContactPhone(contactPhone);
		this.setContactMail(contactMail);
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
	private java.lang.Integer clientId;
	private java.lang.String contactName;
	private java.lang.Integer contactGender;
	private java.lang.String contactDuty;
	private java.lang.String contactPhone;
	private java.lang.String contactMail;
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
	 * Return the value associated with the column: client_id
	 */
	public java.lang.Integer getClientId () {
		return clientId;
	}

	/**
	 * Set the value related to the column: client_id
	 * @param clientId the client_id value
	 */
	public void setClientId (java.lang.Integer clientId) {
		this.clientId = clientId;
	}



	/**
	 * Return the value associated with the column: contact_name
	 */
	public java.lang.String getContactName () {
		return contactName;
	}

	/**
	 * Set the value related to the column: contact_name
	 * @param contactName the contact_name value
	 */
	public void setContactName (java.lang.String contactName) {
		this.contactName = contactName;
	}



	/**
	 * Return the value associated with the column: contact_gender
	 */
	public java.lang.Integer getContactGender () {
		return contactGender;
	}

	/**
	 * Set the value related to the column: contact_gender
	 * @param contactGender the contact_gender value
	 */
	public void setContactGender (java.lang.Integer contactGender) {
		this.contactGender = contactGender;
	}



	/**
	 * Return the value associated with the column: contact_duty
	 */
	public java.lang.String getContactDuty () {
		return contactDuty;
	}

	/**
	 * Set the value related to the column: contact_duty
	 * @param contactDuty the contact_duty value
	 */
	public void setContactDuty (java.lang.String contactDuty) {
		this.contactDuty = contactDuty;
	}



	/**
	 * Return the value associated with the column: contact_phone
	 */
	public java.lang.String getContactPhone () {
		return contactPhone;
	}

	/**
	 * Set the value related to the column: contact_phone
	 * @param contactPhone the contact_phone value
	 */
	public void setContactPhone (java.lang.String contactPhone) {
		this.contactPhone = contactPhone;
	}



	/**
	 * Return the value associated with the column: contact_mail
	 */
	public java.lang.String getContactMail () {
		return contactMail;
	}

	/**
	 * Set the value related to the column: contact_mail
	 * @param contactMail the contact_mail value
	 */
	public void setContactMail (java.lang.String contactMail) {
		this.contactMail = contactMail;
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
		if (!(obj instanceof com.flx.flxoa.info.clientsManagement.entity.FlxoaClientContact)) return false;
		else {
			com.flx.flxoa.info.clientsManagement.entity.FlxoaClientContact flxoaClientContact = (com.flx.flxoa.info.clientsManagement.entity.FlxoaClientContact) obj;
			if (null == this.getId() || null == flxoaClientContact.getId()) return false;
			else return (this.getId().equals(flxoaClientContact.getId()));
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