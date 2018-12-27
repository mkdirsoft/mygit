package com.flx.flxoa.info.cashcollection.entity;

import com.flx.flxoa.info.cashcollection.entity.base.BaseFlxoaCashcollectionRecord;



public class FlxoaCashcollectionRecord extends BaseFlxoaCashcollectionRecord {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public FlxoaCashcollectionRecord () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public FlxoaCashcollectionRecord (java.lang.Integer id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public FlxoaCashcollectionRecord (
		java.lang.Integer id,
		java.lang.String fundSource,
		java.lang.String accountNumber,
		java.lang.String caroOrgName,
		java.math.BigDecimal caroMoney,
		java.lang.String caroUse,
		java.lang.String caroType,
		java.lang.Integer projectId,
		java.lang.Integer claimId,
		java.lang.Integer claimTime,
		java.lang.Integer affirmId,
		java.lang.Integer affirmTime,
		java.lang.String status,
		java.lang.Integer pid,
		java.lang.String isshow,
		java.lang.Integer createTime,
		java.lang.Integer updateTime,
		java.lang.String deleteFlag,
		java.lang.Integer createUserId,
		java.lang.Integer createDepartmentId,
		java.lang.Integer updateUserId,
		java.lang.Integer updateDepartmentId) {

		super (
			id,
			fundSource,
			accountNumber,
			caroOrgName,
			caroMoney,
			caroUse,
			caroType,
			projectId,
			claimId,
			claimTime,
			affirmId,
			affirmTime,
			status,
			pid,
			isshow,
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