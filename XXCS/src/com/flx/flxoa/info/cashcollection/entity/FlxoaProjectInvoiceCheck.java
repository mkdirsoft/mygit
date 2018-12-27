package com.flx.flxoa.info.cashcollection.entity;

import com.flx.flxoa.info.cashcollection.entity.base.BaseFlxoaProjectInvoiceCheck;



public class FlxoaProjectInvoiceCheck extends BaseFlxoaProjectInvoiceCheck {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public FlxoaProjectInvoiceCheck () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public FlxoaProjectInvoiceCheck (java.lang.Integer id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public FlxoaProjectInvoiceCheck (
		java.lang.Integer id,
		java.lang.Integer invoiceManagerId,
		java.lang.String remark,
		java.lang.String isReceive,
		java.lang.Integer createTime,
		java.lang.Integer updateTime,
		java.lang.String deleteFlag,
		java.lang.Integer createUserId,
		java.lang.Integer createDepartmentId,
		java.lang.Integer updateUserId,
		java.lang.Integer updateDepartmentId) {

		super (
			id,
			invoiceManagerId,
			remark,
			isReceive,
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