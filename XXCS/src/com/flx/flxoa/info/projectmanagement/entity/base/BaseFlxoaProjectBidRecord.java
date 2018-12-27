package com.flx.flxoa.info.projectmanagement.entity.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the flxoa_project_bid_record table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="flxoa_project_bid_record"
 */

public abstract class BaseFlxoaProjectBidRecord  implements Serializable {

	public static String REF = "FlxoaProjectBidRecord";
	public static String PROP_ACCESSORY_TRUE_NAME = "AccessoryTrueName";
	public static String PROP_BID_ID = "BidId";
	public static String PROP_CREATE_DEPARTMENT_ID = "CreateDepartmentId";
	public static String PROP_DELETE_FLAG = "DeleteFlag";
	public static String PROP_CREATE_USER_ID = "CreateUserId";
	public static String PROP_UPDATE_TIME = "UpdateTime";
	public static String PROP_UPDATE_DEPARTMENT_ID = "UpdateDepartmentId";
	public static String PROP_ACCESSORY_NAME = "AccessoryName";
	public static String PROP_NAME = "Name";
	public static String PROP_NAME_VALUE = "NameValue";
	public static String PROP_URL = "Url";
	public static String PROP_UPDATE_USER_ID = "UpdateUserId";
	public static String PROP_CREATE_TIME = "CreateTime";
	public static String PROP_ID = "Id";


	// constructors
	public BaseFlxoaProjectBidRecord () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseFlxoaProjectBidRecord (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseFlxoaProjectBidRecord (
		java.lang.Integer id,
		java.lang.Integer bidId,
		java.lang.String name,
		java.lang.String nameValue,
		java.lang.Integer createTime,
		java.lang.Integer updateTime,
		java.lang.String deleteFlag,
		java.lang.Integer createUserId,
		java.lang.Integer createDepartmentId,
		java.lang.Integer updateUserId,
		java.lang.Integer updateDepartmentId) {

		this.setId(id);
		this.setBidId(bidId);
		this.setName(name);
		this.setNameValue(nameValue);
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
	private java.lang.Integer bidId;
	private java.lang.String name;
	private java.lang.String nameValue;
	private java.lang.Integer createTime;
	private java.lang.Integer updateTime;
	private java.lang.String deleteFlag;
	private java.lang.Integer createUserId;
	private java.lang.Integer createDepartmentId;
	private java.lang.Integer updateUserId;
	private java.lang.Integer updateDepartmentId;
	private java.lang.String url;
	private java.lang.String accessoryName;
	private java.lang.String accessoryTrueName;



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
	 * Return the value associated with the column: bid_id
	 */
	public java.lang.Integer getBidId () {
		return bidId;
	}

	/**
	 * Set the value related to the column: bid_id
	 * @param bidId the bid_id value
	 */
	public void setBidId (java.lang.Integer bidId) {
		this.bidId = bidId;
	}



	/**
	 * Return the value associated with the column: name
	 */
	public java.lang.String getName () {
		return name;
	}

	/**
	 * Set the value related to the column: name
	 * @param name the name value
	 */
	public void setName (java.lang.String name) {
		this.name = name;
	}



	/**
	 * Return the value associated with the column: name_value
	 */
	public java.lang.String getNameValue () {
		return nameValue;
	}

	/**
	 * Set the value related to the column: name_value
	 * @param nameValue the name_value value
	 */
	public void setNameValue (java.lang.String nameValue) {
		this.nameValue = nameValue;
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



	/**
	 * Return the value associated with the column: url
	 */
	public java.lang.String getUrl () {
		return url;
	}

	/**
	 * Set the value related to the column: url
	 * @param url the url value
	 */
	public void setUrl (java.lang.String url) {
		this.url = url;
	}



	/**
	 * Return the value associated with the column: accessory_name
	 */
	public java.lang.String getAccessoryName () {
		return accessoryName;
	}

	/**
	 * Set the value related to the column: accessory_name
	 * @param accessoryName the accessory_name value
	 */
	public void setAccessoryName (java.lang.String accessoryName) {
		this.accessoryName = accessoryName;
	}



	/**
	 * Return the value associated with the column: accessory_true_name
	 */
	public java.lang.String getAccessoryTrueName () {
		return accessoryTrueName;
	}

	/**
	 * Set the value related to the column: accessory_true_name
	 * @param accessoryTrueName the accessory_true_name value
	 */
	public void setAccessoryTrueName (java.lang.String accessoryTrueName) {
		this.accessoryTrueName = accessoryTrueName;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.flx.flxoa.info.projectmanagement.entity.FlxoaProjectBidRecord)) return false;
		else {
			com.flx.flxoa.info.projectmanagement.entity.FlxoaProjectBidRecord flxoaProjectBidRecord = (com.flx.flxoa.info.projectmanagement.entity.FlxoaProjectBidRecord) obj;
			if (null == this.getId() || null == flxoaProjectBidRecord.getId()) return false;
			else return (this.getId().equals(flxoaProjectBidRecord.getId()));
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