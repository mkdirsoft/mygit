package com.flx.flxoa.info.contractmanagement.entity.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the flxoa_contract_loanreturn table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="flxoa_contract_loanreturn"
 */

public abstract class BaseFlxoaContractLoanreturn  implements Serializable {

	public static String REF = "FlxoaContractLoanreturn";
	public static String PROP_CREATE_DEPARTMENT_ID = "CreateDepartmentId";
	public static String PROP_LOAN_TYPE = "LoanType";
	public static String PROP_LOAN_SCAN = "LoanScan";
	public static String PROP_CREATE_TIME = "CreateTime";
	public static String PROP_LOAN_STATUS = "LoanStatus";
	public static String PROP_CREATE_USER_ID = "CreateUserId";
	public static String PROP_CONTRACT_ID = "ContractId";
	public static String PROP_ESTIMATE_RETURN = "EstimateReturn";
	public static String PROP_DELETE_FLAG = "DeleteFlag";
	public static String PROP_LOAN_NUMBER = "LoanNumber";
	public static String PROP_UPDATE_DEPARTMENT_ID = "UpdateDepartmentId";
	public static String PROP_LOAN_TIME = "LoanTime";
	public static String PROP_RETURN_PEOPLE = "ReturnPeople";
	public static String PROP_REMARKS = "Remarks";
	public static String PROP_RETURN_TIME = "ReturnTime";
	public static String PROP_UPDATE_TIME = "UpdateTime";
	public static String PROP_UPDATE_USER_ID = "UpdateUserId";
	public static String PROP_FORM_ID = "FormId";
	public static String PROP_ID = "Id";
	public static String PROP_LOAN_PEOPLE = "LoanPeople";


	// constructors
	public BaseFlxoaContractLoanreturn () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseFlxoaContractLoanreturn (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseFlxoaContractLoanreturn (
		java.lang.Integer id,
		java.lang.Integer contractId,
		java.lang.Integer formId,
		java.lang.String loanType,
		java.lang.Integer estimateReturn,
		java.lang.Integer loanTime,
		java.lang.Integer returnTime,
		java.lang.String loanStatus,
		java.lang.Integer loanNumber,
		java.lang.String loanScan,
		java.lang.Integer loanPeople,
		java.lang.Integer returnPeople,
		java.lang.Integer createUserId,
		java.lang.Integer createTime,
		java.lang.Integer createDepartmentId,
		java.lang.Integer updateUserId,
		java.lang.Integer updateTime,
		java.lang.Integer updateDepartmentId,
		java.lang.String deleteFlag,
		java.lang.String remarks) {

		this.setId(id);
		this.setContractId(contractId);
		this.setFormId(formId);
		this.setLoanType(loanType);
		this.setEstimateReturn(estimateReturn);
		this.setLoanTime(loanTime);
		this.setReturnTime(returnTime);
		this.setLoanStatus(loanStatus);
		this.setLoanNumber(loanNumber);
		this.setLoanScan(loanScan);
		this.setLoanPeople(loanPeople);
		this.setReturnPeople(returnPeople);
		this.setCreateUserId(createUserId);
		this.setCreateTime(createTime);
		this.setCreateDepartmentId(createDepartmentId);
		this.setUpdateUserId(updateUserId);
		this.setUpdateTime(updateTime);
		this.setUpdateDepartmentId(updateDepartmentId);
		this.setDeleteFlag(deleteFlag);
		this.setRemarks(remarks);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.Integer contractId;
	private java.lang.Integer formId;
	private java.lang.String loanType;
	private java.lang.Integer estimateReturn;
	private java.lang.Integer loanTime;
	private java.lang.Integer returnTime;
	private java.lang.String loanStatus;
	private java.lang.Integer loanNumber;
	private java.lang.String loanScan;
	private java.lang.Integer loanPeople;
	private java.lang.Integer returnPeople;
	private java.lang.Integer createUserId;
	private java.lang.Integer createTime;
	private java.lang.Integer createDepartmentId;
	private java.lang.Integer updateUserId;
	private java.lang.Integer updateTime;
	private java.lang.Integer updateDepartmentId;
	private java.lang.String deleteFlag;
	private java.lang.String remarks;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="identity"
     *  column="id"
     */
	public java.lang.Integer getId () {
		return id;
	}

	/**
	 * Set the unique identifier of this class
	 * @param id the new ID
	 */
	public void setId (java.lang.Integer id) {
		this.id = id;
		this.hashCode = Integer.MIN_VALUE;
	}




	/**
	 * Return the value associated with the column: contract_id
	 */
	public java.lang.Integer getContractId () {
		return contractId;
	}

	/**
	 * Set the value related to the column: contract_id
	 * @param contractId the contract_id value
	 */
	public void setContractId (java.lang.Integer contractId) {
		this.contractId = contractId;
	}



	/**
	 * Return the value associated with the column: form_id
	 */
	public java.lang.Integer getFormId () {
		return formId;
	}

	/**
	 * Set the value related to the column: form_id
	 * @param formId the form_id value
	 */
	public void setFormId (java.lang.Integer formId) {
		this.formId = formId;
	}



	/**
	 * Return the value associated with the column: loan_type
	 */
	public java.lang.String getLoanType () {
		return loanType;
	}

	/**
	 * Set the value related to the column: loan_type
	 * @param loanType the loan_type value
	 */
	public void setLoanType (java.lang.String loanType) {
		this.loanType = loanType;
	}



	/**
	 * Return the value associated with the column: estimate_return
	 */
	public java.lang.Integer getEstimateReturn () {
		return estimateReturn;
	}

	/**
	 * Set the value related to the column: estimate_return
	 * @param estimateReturn the estimate_return value
	 */
	public void setEstimateReturn (java.lang.Integer estimateReturn) {
		this.estimateReturn = estimateReturn;
	}



	/**
	 * Return the value associated with the column: loan_time
	 */
	public java.lang.Integer getLoanTime () {
		return loanTime;
	}

	/**
	 * Set the value related to the column: loan_time
	 * @param loanTime the loan_time value
	 */
	public void setLoanTime (java.lang.Integer loanTime) {
		this.loanTime = loanTime;
	}



	/**
	 * Return the value associated with the column: return_time
	 */
	public java.lang.Integer getReturnTime () {
		return returnTime;
	}

	/**
	 * Set the value related to the column: return_time
	 * @param returnTime the return_time value
	 */
	public void setReturnTime (java.lang.Integer returnTime) {
		this.returnTime = returnTime;
	}



	/**
	 * Return the value associated with the column: loan_status
	 */
	public java.lang.String getLoanStatus () {
		return loanStatus;
	}

	/**
	 * Set the value related to the column: loan_status
	 * @param loanStatus the loan_status value
	 */
	public void setLoanStatus (java.lang.String loanStatus) {
		this.loanStatus = loanStatus;
	}



	/**
	 * Return the value associated with the column: loan_number
	 */
	public java.lang.Integer getLoanNumber () {
		return loanNumber;
	}

	/**
	 * Set the value related to the column: loan_number
	 * @param loanNumber the loan_number value
	 */
	public void setLoanNumber (java.lang.Integer loanNumber) {
		this.loanNumber = loanNumber;
	}



	/**
	 * Return the value associated with the column: loan_scan
	 */
	public java.lang.String getLoanScan () {
		return loanScan;
	}

	/**
	 * Set the value related to the column: loan_scan
	 * @param loanScan the loan_scan value
	 */
	public void setLoanScan (java.lang.String loanScan) {
		this.loanScan = loanScan;
	}



	/**
	 * Return the value associated with the column: loan_people
	 */
	public java.lang.Integer getLoanPeople () {
		return loanPeople;
	}

	/**
	 * Set the value related to the column: loan_people
	 * @param loanPeople the loan_people value
	 */
	public void setLoanPeople (java.lang.Integer loanPeople) {
		this.loanPeople = loanPeople;
	}



	/**
	 * Return the value associated with the column: return_people
	 */
	public java.lang.Integer getReturnPeople () {
		return returnPeople;
	}

	/**
	 * Set the value related to the column: return_people
	 * @param returnPeople the return_people value
	 */
	public void setReturnPeople (java.lang.Integer returnPeople) {
		this.returnPeople = returnPeople;
	}



	/**
	 * Return the value associated with the column: create_user_id
	 */
	public java.lang.Integer getCreateUserId () {
		return createUserId;
	}

	/**
	 * Set the value related to the column: create_user_id
	 * @param createUserId the create_user_id value
	 */
	public void setCreateUserId (java.lang.Integer createUserId) {
		this.createUserId = createUserId;
	}



	/**
	 * Return the value associated with the column: create_time
	 */
	public java.lang.Integer getCreateTime () {
		return createTime;
	}

	/**
	 * Set the value related to the column: create_time
	 * @param createTime the create_time value
	 */
	public void setCreateTime (java.lang.Integer createTime) {
		this.createTime = createTime;
	}



	/**
	 * Return the value associated with the column: create_department_id
	 */
	public java.lang.Integer getCreateDepartmentId () {
		return createDepartmentId;
	}

	/**
	 * Set the value related to the column: create_department_id
	 * @param createDepartmentId the create_department_id value
	 */
	public void setCreateDepartmentId (java.lang.Integer createDepartmentId) {
		this.createDepartmentId = createDepartmentId;
	}



	/**
	 * Return the value associated with the column: update_user_id
	 */
	public java.lang.Integer getUpdateUserId () {
		return updateUserId;
	}

	/**
	 * Set the value related to the column: update_user_id
	 * @param updateUserId the update_user_id value
	 */
	public void setUpdateUserId (java.lang.Integer updateUserId) {
		this.updateUserId = updateUserId;
	}



	/**
	 * Return the value associated with the column: update_time
	 */
	public java.lang.Integer getUpdateTime () {
		return updateTime;
	}

	/**
	 * Set the value related to the column: update_time
	 * @param updateTime the update_time value
	 */
	public void setUpdateTime (java.lang.Integer updateTime) {
		this.updateTime = updateTime;
	}



	/**
	 * Return the value associated with the column: update_department_id
	 */
	public java.lang.Integer getUpdateDepartmentId () {
		return updateDepartmentId;
	}

	/**
	 * Set the value related to the column: update_department_id
	 * @param updateDepartmentId the update_department_id value
	 */
	public void setUpdateDepartmentId (java.lang.Integer updateDepartmentId) {
		this.updateDepartmentId = updateDepartmentId;
	}



	/**
	 * Return the value associated with the column: delete_flag
	 */
	public java.lang.String getDeleteFlag () {
		return deleteFlag;
	}

	/**
	 * Set the value related to the column: delete_flag
	 * @param deleteFlag the delete_flag value
	 */
	public void setDeleteFlag (java.lang.String deleteFlag) {
		this.deleteFlag = deleteFlag;
	}



	/**
	 * Return the value associated with the column: remarks
	 */
	public java.lang.String getRemarks () {
		return remarks;
	}

	/**
	 * Set the value related to the column: remarks
	 * @param remarks the remarks value
	 */
	public void setRemarks (java.lang.String remarks) {
		this.remarks = remarks;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.flx.flxoa.info.contractmanagement.entity.FlxoaContractLoanreturn)) return false;
		else {
			com.flx.flxoa.info.contractmanagement.entity.FlxoaContractLoanreturn flxoaContractLoanreturn = (com.flx.flxoa.info.contractmanagement.entity.FlxoaContractLoanreturn) obj;
			if (null == this.getId() || null == flxoaContractLoanreturn.getId()) return false;
			else return (this.getId().equals(flxoaContractLoanreturn.getId()));
		}
	}

	public int hashCode () {
		if (Integer.MIN_VALUE == this.hashCode) {
			if (null == this.getId()) return super.hashCode();
			else {
				String hashStr = this.getClass().getName() + ":" + this.getId().hashCode();
				this.hashCode = hashStr.hashCode();
			}
		}
		return this.hashCode;
	}


	public String toString () {
		return super.toString();
	}


}