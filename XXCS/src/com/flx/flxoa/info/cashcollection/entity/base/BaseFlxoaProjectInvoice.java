package com.flx.flxoa.info.cashcollection.entity.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the flxoa_project_invoice table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="flxoa_project_invoice"
 */

public abstract class BaseFlxoaProjectInvoice  implements Serializable {

	public static String REF = "FlxoaProjectInvoice";
	public static String PROP_INVOICE_TYPE = "InvoiceType";
	public static String PROP_UPDATE_USER_ID = "UpdateUserId";
	public static String PROP_CREATE_DEPARTMENT_ID = "CreateDepartmentId";
	public static String PROP_CREATE_TIME = "CreateTime";
	public static String PROP_CREATE_USER_ID = "CreateUserId";
	public static String PROP_DELETE_FLAG = "DeleteFlag";
	public static String PROP_UPDATE_TIME = "UpdateTime";
	public static String PROP_ACCESSORY_STATUS = "AccessoryStatus";
	public static String PROP_INVOICE_ID = "InvoiceId";
	public static String PROP_ID = "Id";
	public static String PROP_UPDATE_DEPARTMENT_ID = "UpdateDepartmentId";
	public static String PROP_ACCESSORY = "Accessory";


	// constructors
	public BaseFlxoaProjectInvoice () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseFlxoaProjectInvoice (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseFlxoaProjectInvoice (
		java.lang.Integer id,
		java.lang.Integer invoiceId,
		java.lang.String accessory,
		java.lang.String accessoryStatus,
		java.lang.String invoiceType,
		java.lang.Integer createTime,
		java.lang.Integer updateTime,
		java.lang.String deleteFlag,
		java.lang.Integer createUserId,
		java.lang.Integer createDepartmentId,
		java.lang.Integer updateUserId,
		java.lang.Integer updateDepartmentId) {

		this.setId(id);
		this.setInvoiceId(invoiceId);
		this.setAccessory(accessory);
		this.setAccessoryStatus(accessoryStatus);
		this.setInvoiceType(invoiceType);
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
	private java.lang.Integer invoiceId;
	private java.lang.String accessory;
	private java.lang.String accessoryStatus;
	private java.lang.String invoiceType;
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
	 * Return the value associated with the column: invoice_id
	 */
	public java.lang.Integer getInvoiceId () {
		return invoiceId;
	}

	/**
	 * Set the value related to the column: invoice_id
	 * @param invoiceId the invoice_id value
	 */
	public void setInvoiceId (java.lang.Integer invoiceId) {
		this.invoiceId = invoiceId;
	}



	/**
	 * Return the value associated with the column: accessory
	 */
	public java.lang.String getAccessory () {
		return accessory;
	}

	/**
	 * Set the value related to the column: accessory
	 * @param accessory the accessory value
	 */
	public void setAccessory (java.lang.String accessory) {
		this.accessory = accessory;
	}



	/**
	 * Return the value associated with the column: accessory_status
	 */
	public java.lang.String getAccessoryStatus () {
		return accessoryStatus;
	}

	/**
	 * Set the value related to the column: accessory_status
	 * @param accessoryStatus the accessory_status value
	 */
	public void setAccessoryStatus (java.lang.String accessoryStatus) {
		this.accessoryStatus = accessoryStatus;
	}



	/**
	 * Return the value associated with the column: invoice_type
	 */
	public java.lang.String getInvoiceType () {
		return invoiceType;
	}

	/**
	 * Set the value related to the column: invoice_type
	 * @param invoiceType the invoice_type value
	 */
	public void setInvoiceType (java.lang.String invoiceType) {
		this.invoiceType = invoiceType;
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
		if (!(obj instanceof com.flx.flxoa.info.cashcollection.entity.FlxoaProjectInvoice)) return false;
		else {
			com.flx.flxoa.info.cashcollection.entity.FlxoaProjectInvoice flxoaProjectInvoice = (com.flx.flxoa.info.cashcollection.entity.FlxoaProjectInvoice) obj;
			if (null == this.getId() || null == flxoaProjectInvoice.getId()) return false;
			else return (this.getId().equals(flxoaProjectInvoice.getId()));
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