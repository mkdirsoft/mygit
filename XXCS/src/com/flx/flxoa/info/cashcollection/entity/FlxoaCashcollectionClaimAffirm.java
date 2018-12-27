package com.flx.flxoa.info.cashcollection.entity;

import com.flx.flxoa.info.cashcollection.entity.base.BaseFlxoaCashcollectionClaimAffirm;



public class FlxoaCashcollectionClaimAffirm extends BaseFlxoaCashcollectionClaimAffirm {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public FlxoaCashcollectionClaimAffirm () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public FlxoaCashcollectionClaimAffirm (java.lang.Integer id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public FlxoaCashcollectionClaimAffirm (
		java.lang.Integer id,
		java.lang.Integer caroId,
		java.lang.Integer projectId,
		java.lang.Integer createTime,
		java.lang.Integer updateTime,
		java.lang.String deleteFlag,
		java.lang.Integer createUserId,
		java.lang.Integer createDepartmentId,
		java.lang.Integer updateUserId,
		java.lang.Integer updateDepartmentId,
		java.lang.String status,
		java.lang.String revocationReason,
		java.lang.String operationContent) {

		super (
			id,
			caroId,
			projectId,
			createTime,
			updateTime,
			deleteFlag,
			createUserId,
			createDepartmentId,
			updateUserId,
			updateDepartmentId,
			status,
			revocationReason,
			operationContent);
	}

/*[CONSTRUCTOR MARKER END]*/


}