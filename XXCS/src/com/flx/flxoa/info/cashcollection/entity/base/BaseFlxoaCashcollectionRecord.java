package com.flx.flxoa.info.cashcollection.entity.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the flxoa_cashcollection_record table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="flxoa_cashcollection_record"
 */

public abstract class BaseFlxoaCashcollectionRecord  implements Serializable {

	public static String REF = "FlxoaCashcollectionRecord";
	public static String PROP_CLAIM_TIME = "ClaimTime";
	public static String PROP_ACCOUNT_NUMBER = "AccountNumber";
	public static String PROP_CARO_MONEY = "CaroMoney";
	public static String PROP_CLAIM_ID = "ClaimId";
	public static String PROP_CREATE_DEPARTMENT_ID = "CreateDepartmentId";
	public static String PROP_CREATE_USER_ID = "CreateUserId";
	public static String PROP_DELETE_FLAG = "DeleteFlag";
	public static String PROP_UPDATE_TIME = "UpdateTime";
	public static String PROP_FUND_SOURCE = "FundSource";
	public static String PROP_UPDATE_DEPARTMENT_ID = "UpdateDepartmentId";
	public static String PROP_CARO_USE = "CaroUse";
	public static String PROP_CARO_ORG_NAME = "CaroOrgName";
	public static String PROP_AFFIRM_ID = "AffirmId";
	public static String PROP_AFFIRM_TIME = "AffirmTime";
	public static String PROP_STATUS = "Status";
	public static String PROP_ISSHOW = "Isshow";
	public static String PROP_UPDATE_USER_ID = "UpdateUserId";
	public static String PROP_CARO_TYPE = "CaroType";
	public static String PROP_CREATE_TIME = "CreateTime";
	public static String PROP_ID = "Id";
	public static String PROP_PID = "Pid";
	public static String PROP_PROJECT_ID = "ProjectId";


	// constructors
	public BaseFlxoaCashcollectionRecord () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseFlxoaCashcollectionRecord (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseFlxoaCashcollectionRecord (
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

		this.setId(id);
		this.setFundSource(fundSource);
		this.setAccountNumber(accountNumber);
		this.setCaroOrgName(caroOrgName);
		this.setCaroMoney(caroMoney);
		this.setCaroUse(caroUse);
		this.setCaroType(caroType);
		this.setProjectId(projectId);
		this.setClaimId(claimId);
		this.setClaimTime(claimTime);
		this.setAffirmId(affirmId);
		this.setAffirmTime(affirmTime);
		this.setStatus(status);
		this.setPid(pid);
		this.setIsshow(isshow);
		this.setCreateTime(createTime);
		this.setUpdateTime(updateTime);
		this.setDeleteFlag(deleteFlag);
		this.setCreateUserId(createUserId);
		this.setCreateDepartmentId(createDepartmentId);
		this.setUpdateUserId(updateUserId);
		this.setUpdateDepartmentId(updateDepartmentId);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String fundSource;
	private java.lang.String accountNumber;
	private java.lang.String caroOrgName;
	private java.math.BigDecimal caroMoney;
	private java.lang.String caroUse;
	private java.lang.String caroType;
	private java.lang.Integer projectId;
	private java.lang.Integer claimId;
	private java.lang.Integer claimTime;
	private java.lang.Integer affirmId;
	private java.lang.Integer affirmTime;
	private java.lang.String status;
	private java.lang.Integer pid;
	private java.lang.String isshow;
	private java.lang.Integer createTime;
	private java.lang.Integer updateTime;
	private java.lang.String deleteFlag;
	private java.lang.Integer createUserId;
	private java.lang.Integer createDepartmentId;
	private java.lang.Integer updateUserId;
	private java.lang.Integer updateDepartmentId;



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
	 * Return the value associated with the column: fund_source
	 */
	public java.lang.String getFundSource () {
		return fundSource;
	}

	/**
	 * Set the value related to the column: fund_source
	 * @param fundSource the fund_source value
	 */
	public void setFundSource (java.lang.String fundSource) {
		this.fundSource = fundSource;
	}



	/**
	 * Return the value associated with the column: account_number
	 */
	public java.lang.String getAccountNumber () {
		return accountNumber;
	}

	/**
	 * Set the value related to the column: account_number
	 * @param accountNumber the account_number value
	 */
	public void setAccountNumber (java.lang.String accountNumber) {
		this.accountNumber = accountNumber;
	}



	/**
	 * Return the value associated with the column: caro_org_name
	 */
	public java.lang.String getCaroOrgName () {
		return caroOrgName;
	}

	/**
	 * Set the value related to the column: caro_org_name
	 * @param caroOrgName the caro_org_name value
	 */
	public void setCaroOrgName (java.lang.String caroOrgName) {
		this.caroOrgName = caroOrgName;
	}



	/**
	 * Return the value associated with the column: caro_money
	 */
	public java.math.BigDecimal getCaroMoney () {
		return caroMoney;
	}

	/**
	 * Set the value related to the column: caro_money
	 * @param caroMoney the caro_money value
	 */
	public void setCaroMoney (java.math.BigDecimal caroMoney) {
		this.caroMoney = caroMoney;
	}



	/**
	 * Return the value associated with the column: caro_use
	 */
	public java.lang.String getCaroUse () {
		return caroUse;
	}

	/**
	 * Set the value related to the column: caro_use
	 * @param caroUse the caro_use value
	 */
	public void setCaroUse (java.lang.String caroUse) {
		this.caroUse = caroUse;
	}



	/**
	 * Return the value associated with the column: caro_type
	 */
	public java.lang.String getCaroType () {
		return caroType;
	}

	/**
	 * Set the value related to the column: caro_type
	 * @param caroType the caro_type value
	 */
	public void setCaroType (java.lang.String caroType) {
		this.caroType = caroType;
	}



	/**
	 * Return the value associated with the column: project_id
	 */
	public java.lang.Integer getProjectId () {
		return projectId;
	}

	/**
	 * Set the value related to the column: project_id
	 * @param projectId the project_id value
	 */
	public void setProjectId (java.lang.Integer projectId) {
		this.projectId = projectId;
	}



	/**
	 * Return the value associated with the column: claim_id
	 */
	public java.lang.Integer getClaimId () {
		return claimId;
	}

	/**
	 * Set the value related to the column: claim_id
	 * @param claimId the claim_id value
	 */
	public void setClaimId (java.lang.Integer claimId) {
		this.claimId = claimId;
	}



	/**
	 * Return the value associated with the column: claim_time
	 */
	public java.lang.Integer getClaimTime () {
		return claimTime;
	}

	/**
	 * Set the value related to the column: claim_time
	 * @param claimTime the claim_time value
	 */
	public void setClaimTime (java.lang.Integer claimTime) {
		this.claimTime = claimTime;
	}



	/**
	 * Return the value associated with the column: affirm_id
	 */
	public java.lang.Integer getAffirmId () {
		return affirmId;
	}

	/**
	 * Set the value related to the column: affirm_id
	 * @param affirmId the affirm_id value
	 */
	public void setAffirmId (java.lang.Integer affirmId) {
		this.affirmId = affirmId;
	}



	/**
	 * Return the value associated with the column: affirm_time
	 */
	public java.lang.Integer getAffirmTime () {
		return affirmTime;
	}

	/**
	 * Set the value related to the column: affirm_time
	 * @param affirmTime the affirm_time value
	 */
	public void setAffirmTime (java.lang.Integer affirmTime) {
		this.affirmTime = affirmTime;
	}



	/**
	 * Return the value associated with the column: status
	 */
	public java.lang.String getStatus () {
		return status;
	}

	/**
	 * Set the value related to the column: status
	 * @param status the status value
	 */
	public void setStatus (java.lang.String status) {
		this.status = status;
	}



	/**
	 * Return the value associated with the column: Pid
	 */
	public java.lang.Integer getPid () {
		return pid;
	}

	/**
	 * Set the value related to the column: Pid
	 * @param pid the Pid value
	 */
	public void setPid (java.lang.Integer pid) {
		this.pid = pid;
	}



	/**
	 * Return the value associated with the column: isshow
	 */
	public java.lang.String getIsshow () {
		return isshow;
	}

	/**
	 * Set the value related to the column: isshow
	 * @param isshow the isshow value
	 */
	public void setIsshow (java.lang.String isshow) {
		this.isshow = isshow;
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




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.flx.flxoa.info.cashcollection.entity.FlxoaCashcollectionRecord)) return false;
		else {
			com.flx.flxoa.info.cashcollection.entity.FlxoaCashcollectionRecord flxoaCashcollectionRecord = (com.flx.flxoa.info.cashcollection.entity.FlxoaCashcollectionRecord) obj;
			if (null == this.getId() || null == flxoaCashcollectionRecord.getId()) return false;
			else return (this.getId().equals(flxoaCashcollectionRecord.getId()));
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