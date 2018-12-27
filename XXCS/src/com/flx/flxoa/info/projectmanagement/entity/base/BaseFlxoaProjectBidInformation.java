package com.flx.flxoa.info.projectmanagement.entity.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the flxoa_project_bid_information table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="flxoa_project_bid_information"
 */

public abstract class BaseFlxoaProjectBidInformation  implements Serializable {

	public static String REF = "FlxoaProjectBidInformation";
	public static String PROP_CREATE_DEPARTMENT_ID = "CreateDepartmentId";
	public static String PROP_DELETE_FLAG = "DeleteFlag";
	public static String PROP_CREATE_USER_ID = "CreateUserId";
	public static String PROP_UPDATE_TIME = "UpdateTime";
	public static String PROP_UPDATE_DEPARTMENT_ID = "UpdateDepartmentId";
	public static String PROP_BIDDING_RESULTS = "BiddingResults";
	public static String PROP_BIDDING_DATE = "BiddingDate";
	public static String PROP_UPDATE_USER_ID = "UpdateUserId";
	public static String PROP_CREATE_TIME = "CreateTime";
	public static String PROP_PROJECT_BIDDING_STATUS = "ProjectBiddingStatus";
	public static String PROP_ID = "Id";
	public static String PROP_BIDDING_DIRECTOR = "BiddingDirector";
	public static String PROP_FOLLOWER_ID = "FollowerId";
	public static String PROP_PROJECT_ID = "ProjectId";
	public static String PROP_REASON = "Reason";
	public static String PROP_BID_SCHEDULE = "BidSchedule";


	// constructors
	public BaseFlxoaProjectBidInformation () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseFlxoaProjectBidInformation (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseFlxoaProjectBidInformation (
		java.lang.Integer id,
		java.lang.String oldId,
		java.lang.Integer projectId,
		java.lang.String biddingDirector,
		java.lang.Integer biddingDate,
		java.lang.Integer followerId,
		java.lang.String oldFollowerName,
		java.lang.String projectBiddingStatus,
		java.lang.String biddingResults,
		java.lang.Integer createTime,
		java.lang.Integer updateTime,
		java.lang.String deleteFlag,
		java.lang.Integer createUserId,
		java.lang.Integer createDepartmentId,
		java.lang.Integer updateUserId,
		java.lang.Integer updateDepartmentId,
		java.lang.String bidSchedule,
		java.lang.String reason) {

		this.setId(id);
		this.setOldId(oldId);
		this.setProjectId(projectId);
		this.setBiddingDirector(biddingDirector);
		this.setBiddingDate(biddingDate);
		this.setFollowerId(followerId);
		this.setOldFollowerName(oldFollowerName);
		this.setProjectBiddingStatus(projectBiddingStatus);
		this.setBiddingResults(biddingResults);
		this.setCreateTime(createTime);
		this.setUpdateTime(updateTime);
		this.setDeleteFlag(deleteFlag);
		this.setCreateUserId(createUserId);
		this.setCreateDepartmentId(createDepartmentId);
		this.setUpdateUserId(updateUserId);
		this.setUpdateDepartmentId(updateDepartmentId);
		this.setBidSchedule(bidSchedule);
		this.setReason(reason);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;
	private java.lang.String oldId;
	private java.lang.String oldFollowerName;
	// fields
	private java.lang.Integer projectId;
	private java.lang.String biddingDirector;
	private java.lang.Integer biddingDate;
	private java.lang.Integer followerId;
	private java.lang.String projectBiddingStatus;
	private java.lang.String biddingResults;
	private java.lang.Integer createTime;
	private java.lang.Integer updateTime;
	private java.lang.String deleteFlag;
	private java.lang.Integer createUserId;
	private java.lang.Integer createDepartmentId;
	private java.lang.Integer updateUserId;
	private java.lang.Integer updateDepartmentId;
	private java.lang.String bidSchedule;
	private java.lang.String reason;



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
	 * Return the value associated with the column: bidding_director
	 */
	public java.lang.String getBiddingDirector () {
		return biddingDirector;
	}

	/**
	 * Set the value related to the column: bidding_director
	 * @param biddingDirector the bidding_director value
	 */
	public void setBiddingDirector (java.lang.String biddingDirector) {
		this.biddingDirector = biddingDirector;
	}



	/**
	 * Return the value associated with the column: bidding_date
	 */
	public java.lang.Integer getBiddingDate () {
		return biddingDate;
	}

	/**
	 * Set the value related to the column: bidding_date
	 * @param biddingDate the bidding_date value
	 */
	public void setBiddingDate (java.lang.Integer biddingDate) {
		this.biddingDate = biddingDate;
	}



	/**
	 * Return the value associated with the column: follower_id
	 */
	public java.lang.Integer getFollowerId () {
		return followerId;
	}

	/**
	 * Set the value related to the column: follower_id
	 * @param followerId the follower_id value
	 */
	public void setFollowerId (java.lang.Integer followerId) {
		this.followerId = followerId;
	}



	/**
	 * Return the value associated with the column: project_bidding_status
	 */
	public java.lang.String getProjectBiddingStatus () {
		return projectBiddingStatus;
	}

	/**
	 * Set the value related to the column: project_bidding_status
	 * @param projectBiddingStatus the project_bidding_status value
	 */
	public void setProjectBiddingStatus (java.lang.String projectBiddingStatus) {
		this.projectBiddingStatus = projectBiddingStatus;
	}



	/**
	 * Return the value associated with the column: bidding_results
	 */
	public java.lang.String getBiddingResults () {
		return biddingResults;
	}

	/**
	 * Set the value related to the column: bidding_results
	 * @param biddingResults the bidding_results value
	 */
	public void setBiddingResults (java.lang.String biddingResults) {
		this.biddingResults = biddingResults;
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
	 * Return the value associated with the column: bid_schedule
	 */
	public java.lang.String getBidSchedule () {
		return bidSchedule;
	}

	/**
	 * Set the value related to the column: bid_schedule
	 * @param bidSchedule the bid_schedule value
	 */
	public void setBidSchedule (java.lang.String bidSchedule) {
		this.bidSchedule = bidSchedule;
	}



	/**
	 * Return the value associated with the column: reason
	 */
	public java.lang.String getReason () {
		return reason;
	}

	/**
	 * Set the value related to the column: reason
	 * @param reason the reason value
	 */
	public void setReason (java.lang.String reason) {
		this.reason = reason;
	}




	public java.lang.String getOldId() {
		return oldId;
	}

	public void setOldId(java.lang.String oldId) {
		this.oldId = oldId;
	}

	public java.lang.String getOldFollowerName() {
		return oldFollowerName;
	}

	public void setOldFollowerName(java.lang.String oldFollowerName) {
		this.oldFollowerName = oldFollowerName;
	}

	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.flx.flxoa.info.projectmanagement.entity.FlxoaProjectBidInformation)) return false;
		else {
			com.flx.flxoa.info.projectmanagement.entity.FlxoaProjectBidInformation flxoaProjectBidInformation = (com.flx.flxoa.info.projectmanagement.entity.FlxoaProjectBidInformation) obj;
			if (null == this.getId() || null == flxoaProjectBidInformation.getId()) return false;
			else return (this.getId().equals(flxoaProjectBidInformation.getId()));
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