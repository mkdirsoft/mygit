package com.flx.flxoa.info.signin.entity.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the flxoa_attendance_signdetails table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="flxoa_attendance_signdetails"
 */

public abstract class BaseFlxoaAttendanceSigndetails  implements Serializable {

	public static String REF = "FlxoaAttendanceSigndetails";
	public static String PROP_SIGN_TYPE = "SignType";
	public static String PROP_CREATE_DEPARTMENT_ID = "CreateDepartmentId";
	public static String PROP_CREATE_USER_ID = "CreateUserId";
	public static String PROP_DELETE_FLAG = "DeleteFlag";
	public static String PROP_SIGN_LOCALE = "SignLocale";
	public static String PROP_UPDATE_TIME = "UpdateTime";
	public static String PROP_COMMENS = "Commens";
	public static String PROP_UPDATE_DEPARTMENT_ID = "UpdateDepartmentId";
	public static String PROP_SIGN_DATE = "SignDate";
	public static String PROP_SIGN_TIME = "SignTime";
	public static String PROP_UPDATE_USER_ID = "UpdateUserId";
	public static String PROP_SIGN_LATITUDE = "SignLatitude";
	public static String PROP_CREATE_TIME = "CreateTime";
	public static String PROP_SIGN_LONGITUDE = "SignLongitude";
	public static String PROP_ID = "Id";


	// constructors
	public BaseFlxoaAttendanceSigndetails () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseFlxoaAttendanceSigndetails (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseFlxoaAttendanceSigndetails (
		java.lang.Integer id,
		java.lang.String commens,
		java.lang.Integer createDepartmentId,
		java.lang.Integer createTime,
		java.lang.Integer createUserId,
		java.lang.String deleteFlag,
		java.lang.Integer signDate,
		java.lang.String signLatitude,
		java.lang.String signLocale,
		java.lang.String signLongitude,
		java.lang.Integer signTime,
		java.lang.String signType,
		java.lang.Integer updateDepartmentId,
		java.lang.Integer updateTime,
		java.lang.Integer updateUserId) {

		this.setId(id);
		this.setCommens(commens);
		this.setCreateDepartmentId(createDepartmentId);
		this.setCreateTime(createTime);
		this.setCreateUserId(createUserId);
		this.setDeleteFlag(deleteFlag);
		this.setSignDate(signDate);
		this.setSignLatitude(signLatitude);
		this.setSignLocale(signLocale);
		this.setSignLongitude(signLongitude);
		this.setSignTime(signTime);
		this.setSignType(signType);
		this.setUpdateDepartmentId(updateDepartmentId);
		this.setUpdateTime(updateTime);
		this.setUpdateUserId(updateUserId);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String commens;
	private java.lang.Integer createDepartmentId;
	private java.lang.Integer createTime;
	private java.lang.Integer createUserId;
	private java.lang.String deleteFlag;
	private java.lang.Integer signDate;
	private java.lang.String signLatitude;
	private java.lang.String signLocale;
	private java.lang.String signLongitude;
	private java.lang.Integer signTime;
	private java.lang.String signType;
	private java.lang.Integer updateDepartmentId;
	private java.lang.Integer updateTime;
	private java.lang.Integer updateUserId;



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
	 * Return the value associated with the column: commens
	 */
	public java.lang.String getCommens () {
		return commens;
	}

	/**
	 * Set the value related to the column: commens
	 * @param commens the commens value
	 */
	public void setCommens (java.lang.String commens) {
		this.commens = commens;
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
	 * Return the value associated with the column: sign_date
	 */
	public java.lang.Integer getSignDate () {
		return signDate;
	}

	/**
	 * Set the value related to the column: sign_date
	 * @param signDate the sign_date value
	 */
	public void setSignDate (java.lang.Integer signDate) {
		this.signDate = signDate;
	}



	/**
	 * Return the value associated with the column: sign_latitude
	 */
	public java.lang.String getSignLatitude () {
		return signLatitude;
	}

	/**
	 * Set the value related to the column: sign_latitude
	 * @param signLatitude the sign_latitude value
	 */
	public void setSignLatitude (java.lang.String signLatitude) {
		this.signLatitude = signLatitude;
	}



	/**
	 * Return the value associated with the column: sign_locale
	 */
	public java.lang.String getSignLocale () {
		return signLocale;
	}

	/**
	 * Set the value related to the column: sign_locale
	 * @param signLocale the sign_locale value
	 */
	public void setSignLocale (java.lang.String signLocale) {
		this.signLocale = signLocale;
	}



	/**
	 * Return the value associated with the column: sign_longitude
	 */
	public java.lang.String getSignLongitude () {
		return signLongitude;
	}

	/**
	 * Set the value related to the column: sign_longitude
	 * @param signLongitude the sign_longitude value
	 */
	public void setSignLongitude (java.lang.String signLongitude) {
		this.signLongitude = signLongitude;
	}



	/**
	 * Return the value associated with the column: sign_time
	 */
	public java.lang.Integer getSignTime () {
		return signTime;
	}

	/**
	 * Set the value related to the column: sign_time
	 * @param signTime the sign_time value
	 */
	public void setSignTime (java.lang.Integer signTime) {
		this.signTime = signTime;
	}



	/**
	 * Return the value associated with the column: sign_type
	 */
	public java.lang.String getSignType () {
		return signType;
	}

	/**
	 * Set the value related to the column: sign_type
	 * @param signType the sign_type value
	 */
	public void setSignType (java.lang.String signType) {
		this.signType = signType;
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




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.flx.flxoa.info.signin.entity.FlxoaAttendanceSigndetails)) return false;
		else {
			com.flx.flxoa.info.signin.entity.FlxoaAttendanceSigndetails flxoaAttendanceSigndetails = (com.flx.flxoa.info.signin.entity.FlxoaAttendanceSigndetails) obj;
			if (null == this.getId() || null == flxoaAttendanceSigndetails.getId()) return false;
			else return (this.getId().equals(flxoaAttendanceSigndetails.getId()));
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