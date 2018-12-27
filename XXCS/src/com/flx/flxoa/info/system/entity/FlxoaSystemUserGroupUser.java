package com.flx.flxoa.info.system.entity;

import com.flx.flxoa.info.system.entity.base.BaseFlxoaSystemUserGroupUser;



public class FlxoaSystemUserGroupUser extends BaseFlxoaSystemUserGroupUser {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public FlxoaSystemUserGroupUser () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public FlxoaSystemUserGroupUser (java.lang.Integer id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public FlxoaSystemUserGroupUser (
		java.lang.Integer id,
		java.lang.Integer userGroupId,
		java.lang.Integer userId,
		java.lang.Integer createTime,
		java.lang.Integer updateTime,
		java.lang.String deleteFlag,
		java.lang.Integer createUserId,
		java.lang.Integer createDepartmentId,
		java.lang.Integer updateUserId,
		java.lang.Integer updateDepartmentId) {

		super (
			id,
			userGroupId,
			userId,
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