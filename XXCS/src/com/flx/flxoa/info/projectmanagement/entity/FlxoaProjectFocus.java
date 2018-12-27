package com.flx.flxoa.info.projectmanagement.entity;

import com.flx.flxoa.info.projectmanagement.entity.base.BaseFlxoaProjectFocus;



public class FlxoaProjectFocus extends BaseFlxoaProjectFocus {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public FlxoaProjectFocus () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public FlxoaProjectFocus (java.lang.Integer id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public FlxoaProjectFocus (
		java.lang.Integer id,
		java.lang.Integer projectId,
		java.lang.Integer createUserId,
		java.lang.Integer createTime,
		java.lang.Integer createDepartmentId,
		java.lang.Integer updateTime,
		java.lang.Integer updateUserId,
		java.lang.Integer updateDepartmentId,
		java.lang.String flag,
		java.lang.String deleteFlag) {

		super (
			id,
			projectId,
			createUserId,
			createTime,
			createDepartmentId,
			updateTime,
			updateUserId,
			updateDepartmentId,
			flag,
			deleteFlag);
	}

/*[CONSTRUCTOR MARKER END]*/


}