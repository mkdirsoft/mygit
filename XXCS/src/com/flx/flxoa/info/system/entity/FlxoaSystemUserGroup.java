package com.flx.flxoa.info.system.entity;

import com.flx.flxoa.info.system.entity.base.BaseFlxoaSystemUserGroup;



public class FlxoaSystemUserGroup extends BaseFlxoaSystemUserGroup {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public FlxoaSystemUserGroup () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public FlxoaSystemUserGroup (java.lang.Integer id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public FlxoaSystemUserGroup (
		java.lang.Integer id,
		java.lang.String name,
		java.lang.Integer createTime,
		java.lang.Integer updateTime,
		java.lang.String deleteFlag,
		java.lang.Integer createUserId,
		java.lang.Integer createDepartmentId,
		java.lang.Integer updateUserId,
		java.lang.Integer updateDepartmentId) {

		super (
			id,
			name,
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