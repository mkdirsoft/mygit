package com.flx.flxoa.info.system.entity;

import com.flx.flxoa.info.system.entity.base.BaseFlxoaSystemEnumeration;



public class FlxoaSystemEnumeration extends BaseFlxoaSystemEnumeration {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public FlxoaSystemEnumeration () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public FlxoaSystemEnumeration (java.lang.Integer id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public FlxoaSystemEnumeration (
		java.lang.Integer id,
		java.lang.String enumerationName,
		java.lang.String enumerationKey,
		java.lang.String enumerationValue,
		java.lang.String enumerationDescription,
		java.lang.Integer createTime,
		java.lang.Integer updateTime,
		java.lang.String deleteFlag,
		java.lang.Integer createUserId,
		java.lang.Integer createDepartmentId,
		java.lang.Integer updateUserId,
		java.lang.Integer updateDepartmentId) {

		super (
			id,
			enumerationName,
			enumerationKey,
			enumerationValue,
			enumerationDescription,
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