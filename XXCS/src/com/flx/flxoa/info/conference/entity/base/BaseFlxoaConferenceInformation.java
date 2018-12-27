package com.flx.flxoa.info.conference.entity.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the flxoa_conference_information table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="flxoa_conference_information"
 */

public abstract class BaseFlxoaConferenceInformation  implements Serializable {

	public static String REF = "FlxoaConferenceInformation";
	public static String PROP_CREATE_DEPARTMENT_ID = "CreateDepartmentId";
	public static String PROP_CONFERENCE_STATES = "ConferenceStates";
	public static String PROP_CREATE_TIME = "CreateTime";
	public static String PROP_CREATE_USER_ID = "CreateUserId";
	public static String PROP_CONFERENCE_NAME = "ConferenceName";
	public static String PROP_CONFERENCE_NUMBER = "ConferenceNumber";
	public static String PROP_DELETE_FLAG = "DeleteFlag";
	public static String PROP_CONFERENCE_SCALE = "ConferenceScale";
	public static String PROP_CONFERENCE_CONFIGURE = "ConferenceConfigure";
	public static String PROP_UPDATE_DEPARTMENT_ID = "UpdateDepartmentId";
	public static String PROP_CONFERENCE_REMARKS = "ConferenceRemarks";
	public static String PROP_UPDATE_TIME = "UpdateTime";
	public static String PROP_UPDATE_USER_ID = "UpdateUserId";
	public static String PROP_CONFERENCE_FLOOR = "ConferenceFloor";
	public static String PROP_ID = "Id";


	// constructors
	public BaseFlxoaConferenceInformation () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseFlxoaConferenceInformation (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseFlxoaConferenceInformation (
		java.lang.Integer id,
		java.lang.String conferenceNumber,
		java.lang.String conferenceName,
		java.lang.String conferenceFloor,
		java.lang.String conferenceScale,
		java.lang.String conferenceConfigure,
		java.lang.String conferenceRemarks,
		java.lang.String conferenceStates,
		java.lang.Integer updateTime,
		java.lang.Integer createUserId,
		java.lang.Integer createDepartmentId,
		java.lang.Integer updateUserId,
		java.lang.Integer updateDepartmentId,
		java.lang.String deleteFlag,
		java.lang.Integer createTime) {

		this.setId(id);
		this.setConferenceNumber(conferenceNumber);
		this.setConferenceName(conferenceName);
		this.setConferenceFloor(conferenceFloor);
		this.setConferenceScale(conferenceScale);
		this.setConferenceConfigure(conferenceConfigure);
		this.setConferenceRemarks(conferenceRemarks);
		this.setConferenceStates(conferenceStates);
		this.setUpdateTime(updateTime);
		this.setCreateUserId(createUserId);
		this.setCreateDepartmentId(createDepartmentId);
		this.setUpdateUserId(updateUserId);
		this.setUpdateDepartmentId(updateDepartmentId);
		this.setDeleteFlag(deleteFlag);
		this.setCreateTime(createTime);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String conferenceNumber;
	private java.lang.String conferenceName;
	private java.lang.String conferenceFloor;
	private java.lang.String conferenceScale;
	private java.lang.String conferenceConfigure;
	private java.lang.String conferenceRemarks;
	private java.lang.String conferenceStates;
	private java.lang.Integer updateTime;
	private java.lang.Integer createUserId;
	private java.lang.Integer createDepartmentId;
	private java.lang.Integer updateUserId;
	private java.lang.Integer updateDepartmentId;
	private java.lang.String deleteFlag;
	private java.lang.Integer createTime;



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
	 * Return the value associated with the column: conference_number
	 */
	public java.lang.String getConferenceNumber () {
		return conferenceNumber;
	}

	/**
	 * Set the value related to the column: conference_number
	 * @param conferenceNumber the conference_number value
	 */
	public void setConferenceNumber (java.lang.String conferenceNumber) {
		this.conferenceNumber = conferenceNumber;
	}



	/**
	 * Return the value associated with the column: conference_name
	 */
	public java.lang.String getConferenceName () {
		return conferenceName;
	}

	/**
	 * Set the value related to the column: conference_name
	 * @param conferenceName the conference_name value
	 */
	public void setConferenceName (java.lang.String conferenceName) {
		this.conferenceName = conferenceName;
	}



	/**
	 * Return the value associated with the column: conference_floor
	 */
	public java.lang.String getConferenceFloor () {
		return conferenceFloor;
	}

	/**
	 * Set the value related to the column: conference_floor
	 * @param conferenceFloor the conference_floor value
	 */
	public void setConferenceFloor (java.lang.String conferenceFloor) {
		this.conferenceFloor = conferenceFloor;
	}



	/**
	 * Return the value associated with the column: conference_scale
	 */
	public java.lang.String getConferenceScale () {
		return conferenceScale;
	}

	/**
	 * Set the value related to the column: conference_scale
	 * @param conferenceScale the conference_scale value
	 */
	public void setConferenceScale (java.lang.String conferenceScale) {
		this.conferenceScale = conferenceScale;
	}



	/**
	 * Return the value associated with the column: conference_configure
	 */
	public java.lang.String getConferenceConfigure () {
		return conferenceConfigure;
	}

	/**
	 * Set the value related to the column: conference_configure
	 * @param conferenceConfigure the conference_configure value
	 */
	public void setConferenceConfigure (java.lang.String conferenceConfigure) {
		this.conferenceConfigure = conferenceConfigure;
	}



	/**
	 * Return the value associated with the column: conference_remarks
	 */
	public java.lang.String getConferenceRemarks () {
		return conferenceRemarks;
	}

	/**
	 * Set the value related to the column: conference_remarks
	 * @param conferenceRemarks the conference_remarks value
	 */
	public void setConferenceRemarks (java.lang.String conferenceRemarks) {
		this.conferenceRemarks = conferenceRemarks;
	}



	/**
	 * Return the value associated with the column: conference_states
	 */
	public java.lang.String getConferenceStates () {
		return conferenceStates;
	}

	/**
	 * Set the value related to the column: conference_states
	 * @param conferenceStates the conference_states value
	 */
	public void setConferenceStates (java.lang.String conferenceStates) {
		this.conferenceStates = conferenceStates;
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




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.flx.flxoa.info.conference.entity.FlxoaConferenceInformation)) return false;
		else {
			com.flx.flxoa.info.conference.entity.FlxoaConferenceInformation flxoaConferenceInformation = (com.flx.flxoa.info.conference.entity.FlxoaConferenceInformation) obj;
			if (null == this.getId() || null == flxoaConferenceInformation.getId()) return false;
			else return (this.getId().equals(flxoaConferenceInformation.getId()));
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