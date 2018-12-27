package com.flx.flxoa.info.cashcollection.entity.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the flxoa_cashcollection_claim_affirm table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="flxoa_cashcollection_claim_affirm"
 */

public abstract class BaseFlxoaCashcollectionClaimAffirm  implements Serializable {

	public static String REF = "FlxoaCashcollectionClaimAffirm";
	public static String PROP_CREATE_DEPARTMENT_ID = "CreateDepartmentId";
	public static String PROP_DELETE_FLAG = "DeleteFlag";
	public static String PROP_CREATE_USER_ID = "CreateUserId";
	public static String PROP_UPDATE_TIME = "UpdateTime";
	public static String PROP_UPDATE_DEPARTMENT_ID = "UpdateDepartmentId";
	public static String PROP_CARO_ID = "CaroId";
	public static String PROP_STATUS = "Status";
	public static String PROP_UPDATE_USER_ID = "UpdateUserId";
	public static String PROP_CREATE_TIME = "CreateTime";
	public static String PROP_REVOCATION_REASON = "RevocationReason";
	public static String PROP_ID = "Id";
	public static String PROP_OPERATION_CONTENT = "OperationContent";
	public static String PROP_PROJECT_ID = "ProjectId";


	// constructors
	public BaseFlxoaCashcollectionClaimAffirm () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseFlxoaCashcollectionClaimAffirm (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseFlxoaCashcollectionClaimAffirm (
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

		this.setId(id);
		this.setCaroId(caroId);
		this.setProjectId(projectId);
		this.setCreateTime(createTime);
		this.setUpdateTime(updateTime);
		this.setDeleteFlag(deleteFlag);
		this.setCreateUserId(createUserId);
		this.setCreateDepartmentId(createDepartmentId);
		this.setUpdateUserId(updateUserId);
		this.setUpdateDepartmentId(updateDepartmentId);
		this.setStatus(status);
		this.setRevocationReason(revocationReason);
		this.setOperationContent(operationContent);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.Integer caroId;
	private java.lang.Integer projectId;
	private java.lang.Integer createTime;
	private java.lang.Integer updateTime;
	private java.lang.String deleteFlag;
	private java.lang.Integer createUserId;
	private java.lang.Integer createDepartmentId;
	private java.lang.Integer updateUserId;
	private java.lang.Integer updateDepartmentId;
	private java.lang.String status;
	private java.lang.String revocationReason;
	private java.lang.String operationContent;



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
	 * Return the value associated with the column: caro_id
	 */
	public java.lang.Integer getCaroId () {
		return caroId;
	}

	/**
	 * Set the value related to the column: caro_id
	 * @param caroId the caro_id value
	 */
	public void setCaroId (java.lang.Integer caroId) {
		this.caroId = caroId;
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
	 * Return the value associated with the column: revocation_reason
	 */
	public java.lang.String getRevocationReason () {
		return revocationReason;
	}

	/**
	 * Set the value related to the column: revocation_reason
	 * @param revocationReason the revocation_reason value
	 */
	public void setRevocationReason (java.lang.String revocationReason) {
		this.revocationReason = revocationReason;
	}



	/**
	 * Return the value associated with the column: operation_content
	 */
	public java.lang.String getOperationContent () {
		return operationContent;
	}

	/**
	 * Set the value related to the column: operation_content
	 * @param operationContent the operation_content value
	 */
	public void setOperationContent (java.lang.String operationContent) {
		this.operationContent = operationContent;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.flx.flxoa.info.cashcollection.entity.FlxoaCashcollectionClaimAffirm)) return false;
		else {
			com.flx.flxoa.info.cashcollection.entity.FlxoaCashcollectionClaimAffirm flxoaCashcollectionClaimAffirm = (com.flx.flxoa.info.cashcollection.entity.FlxoaCashcollectionClaimAffirm) obj;
			if (null == this.getId() || null == flxoaCashcollectionClaimAffirm.getId()) return false;
			else return (this.getId().equals(flxoaCashcollectionClaimAffirm.getId()));
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