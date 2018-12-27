package com.flx.flxoa.info.clientsManagement.entity.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the flxoa_client_information table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="flxoa_client_information"
 */

public abstract class BaseFlxoaClientInformation  implements Serializable {

	public static String REF = "FlxoaClientInformation";
	public static String PROP_CLIENT_BUSINESS = "ClientBusiness";
	public static String PROP_COMMENTS = "Comments";
	public static String PROP_CLIENT_FAX = "ClientFax";
	public static String PROP_CLIENT_RANK = "ClientRank";
	public static String PROP_CLIENT_SITEURL = "ClientSiteurl";
	public static String PROP_CREATE_DEPARTMENT_ID = "CreateDepartmentId";
	public static String PROP_CREATE_USER_ID = "CreateUserId";
	public static String PROP_DELETE_FLAG = "DeleteFlag";
	public static String PROP_UPDATE_TIME = "UpdateTime";
	public static String PROP_UPDATE_DEPARTMENT_ID = "UpdateDepartmentId";
	public static String PROP_CLIENT_ADDRESS = "ClientAddress";
	public static String PROP_CLIENT_MAIL = "ClientMail";
	public static String PROP_CLIENT_SALESMAN = "ClientSalesman";
	public static String PROP_CLIENT_POSTCODE = "ClientPostcode";
	public static String PROP_UPDATE_USER_ID = "UpdateUserId";
	public static String PROP_CLIENT_CELLPHONE = "ClientCellphone";
	public static String PROP_CREATE_TIME = "CreateTime";
	public static String PROP_CLIENT_NAME = "ClientName";
	public static String PROP_ID = "Id";
	public static String PROP_CLIENT_PHONE = "ClientPhone";
	public static String PROP_CLIENT_TRADE = "ClientTrade";


	// constructors
	public BaseFlxoaClientInformation () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseFlxoaClientInformation (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseFlxoaClientInformation (
		java.lang.Integer id,
		java.lang.String clientName,
		java.lang.Integer clientRank,
		java.lang.Integer clientBusiness,
		java.lang.Integer clientTrade,
		java.lang.String clientAddress,
		java.lang.String clientSalesman,
		java.lang.String clientSiteurl,
		java.lang.String clientPhone,
		java.lang.String clientMail,
		java.lang.String clientCellphone,
		java.lang.String clientPostcode,
		java.lang.String clientFax,
		java.lang.String comments,
		java.lang.String deleteFlag,
		java.lang.Integer createUserId,
		java.lang.Integer createDepartmentId,
		java.lang.Integer createTime,
		java.lang.Integer updateUserId,
		java.lang.Integer updateDepartmentId,
		java.lang.Integer updateTime) {

		this.setId(id);
		this.setClientName(clientName);
		this.setClientRank(clientRank);
		this.setClientBusiness(clientBusiness);
		this.setClientTrade(clientTrade);
		this.setClientAddress(clientAddress);
		this.setClientSalesman(clientSalesman);
		this.setClientSiteurl(clientSiteurl);
		this.setClientPhone(clientPhone);
		this.setClientMail(clientMail);
		this.setClientCellphone(clientCellphone);
		this.setClientPostcode(clientPostcode);
		this.setClientFax(clientFax);
		this.setComments(comments);
		this.setDeleteFlag(deleteFlag);
		this.setCreateUserId(createUserId);
		this.setCreateDepartmentId(createDepartmentId);
		this.setCreateTime(createTime);
		this.setUpdateUserId(updateUserId);
		this.setUpdateDepartmentId(updateDepartmentId);
		this.setUpdateTime(updateTime);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String clientName;
	private java.lang.Integer clientRank;
	private java.lang.Integer clientBusiness;
	private java.lang.Integer clientTrade;
	private java.lang.String clientAddress;
	private java.lang.String clientSalesman;
	private java.lang.String clientSiteurl;
	private java.lang.String clientPhone;
	private java.lang.String clientMail;
	private java.lang.String clientCellphone;
	private java.lang.String clientPostcode;
	private java.lang.String clientFax;
	private java.lang.String comments;
	private java.lang.String deleteFlag;
	private java.lang.Integer createUserId;
	private java.lang.Integer createDepartmentId;
	private java.lang.Integer createTime;
	private java.lang.Integer updateUserId;
	private java.lang.Integer updateDepartmentId;
	private java.lang.Integer updateTime;



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
	 * Return the value associated with the column: client_name
	 */
	public java.lang.String getClientName () {
		return clientName;
	}

	/**
	 * Set the value related to the column: client_name
	 * @param clientName the client_name value
	 */
	public void setClientName (java.lang.String clientName) {
		this.clientName = clientName;
	}



	/**
	 * Return the value associated with the column: client_rank
	 */
	public java.lang.Integer getClientRank () {
		return clientRank;
	}

	/**
	 * Set the value related to the column: client_rank
	 * @param clientRank the client_rank value
	 */
	public void setClientRank (java.lang.Integer clientRank) {
		this.clientRank = clientRank;
	}



	/**
	 * Return the value associated with the column: client_business
	 */
	public java.lang.Integer getClientBusiness () {
		return clientBusiness;
	}

	/**
	 * Set the value related to the column: client_business
	 * @param clientBusiness the client_business value
	 */
	public void setClientBusiness (java.lang.Integer clientBusiness) {
		this.clientBusiness = clientBusiness;
	}



	/**
	 * Return the value associated with the column: client_trade
	 */
	public java.lang.Integer getClientTrade () {
		return clientTrade;
	}

	/**
	 * Set the value related to the column: client_trade
	 * @param clientTrade the client_trade value
	 */
	public void setClientTrade (java.lang.Integer clientTrade) {
		this.clientTrade = clientTrade;
	}



	/**
	 * Return the value associated with the column: client_address
	 */
	public java.lang.String getClientAddress () {
		return clientAddress;
	}

	/**
	 * Set the value related to the column: client_address
	 * @param clientAddress the client_address value
	 */
	public void setClientAddress (java.lang.String clientAddress) {
		this.clientAddress = clientAddress;
	}



	/**
	 * Return the value associated with the column: client_salesman
	 */
	public java.lang.String getClientSalesman () {
		return clientSalesman;
	}

	/**
	 * Set the value related to the column: client_salesman
	 * @param clientSalesman the client_salesman value
	 */
	public void setClientSalesman (java.lang.String clientSalesman) {
		this.clientSalesman = clientSalesman;
	}



	/**
	 * Return the value associated with the column: client_siteURL
	 */
	public java.lang.String getClientSiteurl () {
		return clientSiteurl;
	}

	/**
	 * Set the value related to the column: client_siteURL
	 * @param clientSiteurl the client_siteURL value
	 */
	public void setClientSiteurl (java.lang.String clientSiteurl) {
		this.clientSiteurl = clientSiteurl;
	}



	/**
	 * Return the value associated with the column: client_phone
	 */
	public java.lang.String getClientPhone () {
		return clientPhone;
	}

	/**
	 * Set the value related to the column: client_phone
	 * @param clientPhone the client_phone value
	 */
	public void setClientPhone (java.lang.String clientPhone) {
		this.clientPhone = clientPhone;
	}



	/**
	 * Return the value associated with the column: client_mail
	 */
	public java.lang.String getClientMail () {
		return clientMail;
	}

	/**
	 * Set the value related to the column: client_mail
	 * @param clientMail the client_mail value
	 */
	public void setClientMail (java.lang.String clientMail) {
		this.clientMail = clientMail;
	}



	/**
	 * Return the value associated with the column: client_cellphone
	 */
	public java.lang.String getClientCellphone () {
		return clientCellphone;
	}

	/**
	 * Set the value related to the column: client_cellphone
	 * @param clientCellphone the client_cellphone value
	 */
	public void setClientCellphone (java.lang.String clientCellphone) {
		this.clientCellphone = clientCellphone;
	}



	/**
	 * Return the value associated with the column: client_postcode
	 */
	public java.lang.String getClientPostcode () {
		return clientPostcode;
	}

	/**
	 * Set the value related to the column: client_postcode
	 * @param clientPostcode the client_postcode value
	 */
	public void setClientPostcode (java.lang.String clientPostcode) {
		this.clientPostcode = clientPostcode;
	}



	/**
	 * Return the value associated with the column: client_fax
	 */
	public java.lang.String getClientFax () {
		return clientFax;
	}

	/**
	 * Set the value related to the column: client_fax
	 * @param clientFax the client_fax value
	 */
	public void setClientFax (java.lang.String clientFax) {
		this.clientFax = clientFax;
	}



	/**
	 * Return the value associated with the column: comments
	 */
	public java.lang.String getComments () {
		return comments;
	}

	/**
	 * Set the value related to the column: comments
	 * @param comments the comments value
	 */
	public void setComments (java.lang.String comments) {
		this.comments = comments;
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




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.flx.flxoa.info.clientsManagement.entity.FlxoaClientInformation)) return false;
		else {
			com.flx.flxoa.info.clientsManagement.entity.FlxoaClientInformation flxoaClientInformation = (com.flx.flxoa.info.clientsManagement.entity.FlxoaClientInformation) obj;
			if (null == this.getId() || null == flxoaClientInformation.getId()) return false;
			else return (this.getId().equals(flxoaClientInformation.getId()));
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