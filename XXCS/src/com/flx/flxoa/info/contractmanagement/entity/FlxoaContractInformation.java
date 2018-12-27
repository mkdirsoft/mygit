package com.flx.flxoa.info.contractmanagement.entity;

import com.flx.flxoa.info.contractmanagement.entity.base.BaseFlxoaContractInformation;



public class FlxoaContractInformation extends BaseFlxoaContractInformation {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public FlxoaContractInformation () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public FlxoaContractInformation (java.lang.Integer id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public FlxoaContractInformation (
		java.lang.Integer id,
		java.lang.Integer projectId,
		java.lang.Integer formId,
		java.lang.String contractAmount,
		java.lang.String contractType,
		java.lang.String salesContractNumber,
		java.lang.String salesContractName,
		java.lang.String purchaseContractNumber,
		java.lang.String purchaseContractName,
		java.lang.String partyA,
		java.lang.String partyB,
		java.lang.String partyC,
		java.lang.Integer signatoryId,
		java.lang.Integer handoverId,
		java.lang.Integer transferDate,
		java.lang.Integer contractsNumber,
		java.lang.String contractScanningcopy,
		java.lang.Integer contractData,
		java.lang.String storagePosition,
		java.lang.String repayMethod,
		java.lang.String warrantyPeriod,
		java.lang.Integer contractEndData,
		java.lang.String warrantyMoney,
		java.lang.String comments,
		java.lang.String isRegisterFlag,
		java.lang.Integer createUserId,
		java.lang.Integer createTime,
		java.lang.Integer createDepartmentId,
		java.lang.Integer updateUserId,
		java.lang.Integer updateTime,
		java.lang.Integer updateDepartmentId,
		java.lang.String deleteFlag) {

		super (
			id,
			projectId,
			formId,
			contractAmount,
			contractType,
			salesContractNumber,
			salesContractName,
			purchaseContractNumber,
			purchaseContractName,
			partyA,
			partyB,
			partyC,
			signatoryId,
			handoverId,
			transferDate,
			contractsNumber,
			contractScanningcopy,
			contractData,
			storagePosition,
			repayMethod,
			warrantyPeriod,
			contractEndData,
			warrantyMoney,
			comments,
			isRegisterFlag,
			createUserId,
			createTime,
			createDepartmentId,
			updateUserId,
			updateTime,
			updateDepartmentId,
			deleteFlag);
	}

/*[CONSTRUCTOR MARKER END]*/


}