package com.flx.flxoa.info.projectmanagement.entity;


import com.flx.flxoa.info.projectmanagement.entity.base.BaseFlxoaProjectBidInformation;


public class FlxoaProjectBidInformation extends BaseFlxoaProjectBidInformation {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public FlxoaProjectBidInformation () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public FlxoaProjectBidInformation (java.lang.Integer id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public FlxoaProjectBidInformation (
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

		super (
			id,
			oldId,
			projectId,
			biddingDirector,
			biddingDate,
			followerId,
			oldFollowerName,
			projectBiddingStatus,
			biddingResults,
			createTime,
			updateTime,
			deleteFlag,
			createUserId,
			createDepartmentId,
			updateUserId,
			updateDepartmentId,
			bidSchedule,
			reason);
	}

	/*[CONSTRUCTOR MARKER END]*/
	//项目名称
	private String projName;
	//项目名称
	private String projNumber;
	//预计合同额
	private String predictContractMoney;
	//投标结果
	private String bidding_results_type;
	//投标准备进度
	private String project_bidding_status_type;
	//投标进度
	private String bid_schedule_type;
	//用户名称
	private String realname;
	//查询-投标开始时间
	private String startTime;
	//查询-投标结束时间
	private String endTime;

	public String getProjNumber() {
		return projNumber;
	}

	public void setProjNumber(String projNumber) {
		this.projNumber = projNumber;
	}

	public String getProjName() {
		return projName;
	}

	public void setProjName(String projName) {
		this.projName = projName;
	}

	public String getPredictContractMoney() {
		return predictContractMoney;
	}

	public void setPredictContractMoney(String predictContractMoney) {
		this.predictContractMoney = predictContractMoney;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public String getRealname() {
		return realname;
	}

	public void setRealname(String realname) {
		this.realname = realname;
	}

	public String getBidding_results_type() {
		return bidding_results_type;
	}

	public void setBidding_results_type(String bidding_results_type) {
		this.bidding_results_type = bidding_results_type;
	}

	public String getProject_bidding_status_type() {
		return project_bidding_status_type;
	}

	public void setProject_bidding_status_type(String project_bidding_status_type) {
		this.project_bidding_status_type = project_bidding_status_type;
	}

	public String getBid_schedule_type() {
		return bid_schedule_type;
	}

	public void setBid_schedule_type(String bid_schedule_type) {
		this.bid_schedule_type = bid_schedule_type;
	}

}