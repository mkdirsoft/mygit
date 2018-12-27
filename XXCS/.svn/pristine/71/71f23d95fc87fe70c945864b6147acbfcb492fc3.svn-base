package com.flx.flxoa.info.approve.entity;

import com.flx.flxoa.info.approve.entity.base.BaseFlxoaApproveConditionWorkflow;



public class FlxoaApproveConditionWorkflow extends BaseFlxoaApproveConditionWorkflow implements Comparable<FlxoaApproveConditionWorkflow>{
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public FlxoaApproveConditionWorkflow () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public FlxoaApproveConditionWorkflow (java.lang.Integer id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public FlxoaApproveConditionWorkflow (
		java.lang.Integer id,
		java.lang.String formdataDataKey,
		java.lang.String type,
		java.lang.String enumerationName,
		java.lang.String expression,
		java.lang.String condition,
		java.lang.Integer level,
		java.lang.Integer workflowId,
		java.lang.Integer parentId,
		java.lang.Integer templateId,
		java.lang.Integer createTime,
		java.lang.Integer updateTime,
		java.lang.String deleteFlag,
		java.lang.Integer createUserId,
		java.lang.Integer createDepartmentId,
		java.lang.Integer updateUserId,
		java.lang.Integer updateDepartmentId) {

		super (
			id,
			formdataDataKey,
			type,
			enumerationName,
			expression,
			condition,
			level,
			workflowId,
			parentId,
			templateId,
			createTime,
			updateTime,
			deleteFlag,
			createUserId,
			createDepartmentId,
			updateUserId,
			updateDepartmentId);
	}

	@Override
	public int compareTo(FlxoaApproveConditionWorkflow o) {
		 return this.getLevel().compareTo(o.getLevel());
	}

/*[CONSTRUCTOR MARKER END]*/
}