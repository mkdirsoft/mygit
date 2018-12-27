package com.flx.flxoa.info.signin.entity;

import com.flx.flxoa.info.signin.entity.base.BaseFlxoaAttendanceSigndetails;



public class FlxoaAttendanceSigndetails extends BaseFlxoaAttendanceSigndetails {
	private String realname;
	private String dname;
	private String card_id;


	public String getRealname() {
		return realname;
	}

	public void setRealname(String realname) {
		this.realname = realname;
	}

	public String getCard_id() {
		return card_id;
	}

	public void setCard_id(String card_id) {
		this.card_id = card_id;
	}

	public String getDname() {
		return dname;
	}

	public void setDname(String dname) {
		this.dname = dname;
	}
	
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public FlxoaAttendanceSigndetails () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public FlxoaAttendanceSigndetails (java.lang.Integer id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public FlxoaAttendanceSigndetails (
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

		super (
			id,
			commens,
			createDepartmentId,
			createTime,
			createUserId,
			deleteFlag,
			signDate,
			signLatitude,
			signLocale,
			signLongitude,
			signTime,
			signType,
			updateDepartmentId,
			updateTime,
			updateUserId);
	}

/*[CONSTRUCTOR MARKER END]*/


}