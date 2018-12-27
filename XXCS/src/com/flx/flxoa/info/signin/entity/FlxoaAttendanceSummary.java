package com.flx.flxoa.info.signin.entity;

import com.flx.flxoa.info.signin.entity.base.BaseFlxoaAttendanceSummary;



public class FlxoaAttendanceSummary extends BaseFlxoaAttendanceSummary {
	private int cardId;	
	public int getCardId() {
		return cardId;
	}

	public void setCardId(int cardId) {
		this.cardId = cardId;
	}
	private int userid;
	private String realname;
	private String dname;//
	private int startDate;
	private int endDate;
	public int getStartDate() {
		return startDate;
	}

	public void setStartDate(int startDate) {
		this.startDate = startDate;
	}

	public int getEndDate() {
		return endDate;
	}

	public void setEndDate(int endDate) {
		this.endDate = endDate;
	}
	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public String getRealname() {
		return realname;
	}

	public void setRealname(String realname) {
		this.realname = realname;
	}

	public String getDname() {
		return dname;
	}

	public void setDname(String dname) {
		this.dname = dname;
	}
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public FlxoaAttendanceSummary () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public FlxoaAttendanceSummary (java.lang.Integer id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public FlxoaAttendanceSummary (
		java.lang.Integer id,
		java.lang.String signStatus,
		java.lang.Integer signData,
		java.lang.Integer signEarliestTime,
		java.lang.String signEarliestType,
		java.lang.String signEarliestComments,
		java.lang.String signEarliestAddress,
		java.lang.Integer signLatestTime,
		java.lang.String signLatestType,
		java.lang.String signLatestComments,
		java.lang.String signLatestAdress,
		java.lang.String leaderComments,
		java.lang.Integer commetsTime,
		java.lang.Integer createTime,
		java.lang.Integer updateTime,
		java.lang.String deleteFlag,
		java.lang.Integer createUserId,
		java.lang.Integer createDepartmentId,
		java.lang.Integer updateUserId,
		java.lang.Integer updateDepartmentId) {

		super (
			id,
			signStatus,
			signData,
			signEarliestTime,
			signEarliestType,
			signEarliestComments,
			signEarliestAddress,
			signLatestTime,
			signLatestType,
			signLatestComments,
			signLatestAdress,
			leaderComments,
			commetsTime,
			createTime,
			updateTime,
			deleteFlag,
			createUserId,
			createDepartmentId,
			updateUserId,
			updateDepartmentId);
	}

/*[CONSTRUCTOR MARKER END]*/


}