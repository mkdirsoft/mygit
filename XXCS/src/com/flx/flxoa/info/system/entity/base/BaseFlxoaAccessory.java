package com.flx.flxoa.info.system.entity.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the flxoa_accessory table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="flxoa_accessory"
 */

public abstract class BaseFlxoaAccessory  implements Serializable {

	public static String REF = "FlxoaAccessory";
	public static String PROP_CREATE_DEPARTMENT_ID = "CreateDepartmentId";
	public static String PROP_DELETE_FLAG = "DeleteFlag";
	public static String PROP_CREATE_USER_ID = "CreateUserId";
	public static String PROP_UPDATE_TIME = "UpdateTime";
	public static String PROP_UPDATE_DEPARTMENT_ID = "UpdateDepartmentId";
	public static String PROP_FILE_PATH = "FilePath";
	public static String PROP_SOURCE_ID = "SourceId";
	public static String PROP_FILE_REAL_NAME = "FileRealName";
	public static String PROP_ACCESSORY_SOURCE = "AccessorySource";
	public static String PROP_FILE_NAME = "FileName";
	public static String PROP_UPDATE_USER_ID = "UpdateUserId";
	public static String PROP_CREATE_TIME = "CreateTime";
	public static String PROP_ID = "Id";


	// constructors
	public BaseFlxoaAccessory () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseFlxoaAccessory (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseFlxoaAccessory (
		java.lang.Integer id,
		java.lang.String fileName,
		java.lang.String fileRealName,
		java.lang.String filePath,
		java.lang.Integer createTime,
		java.lang.Integer updateTime,
		java.lang.String deleteFlag,
		java.lang.Integer createUserId,
		java.lang.Integer createDepartmentId,
		java.lang.Integer updateUserId,
		java.lang.Integer updateDepartmentId,
		java.lang.String accessorySource,
		java.lang.Integer sourceId) {

		this.setId(id);
		this.setFileName(fileName);
		this.setFileRealName(fileRealName);
		this.setFilePath(filePath);
		this.setCreateTime(createTime);
		this.setUpdateTime(updateTime);
		this.setDeleteFlag(deleteFlag);
		this.setCreateUserId(createUserId);
		this.setCreateDepartmentId(createDepartmentId);
		this.setUpdateUserId(updateUserId);
		this.setUpdateDepartmentId(updateDepartmentId);
		this.setAccessorySource(accessorySource);
		this.setSourceId(sourceId);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String fileName;
	private java.lang.String fileRealName;
	private java.lang.String filePath;
	private java.lang.Integer createTime;
	private java.lang.Integer updateTime;
	private java.lang.String deleteFlag;
	private java.lang.Integer createUserId;
	private java.lang.Integer createDepartmentId;
	private java.lang.Integer updateUserId;
	private java.lang.Integer updateDepartmentId;
	private java.lang.String accessorySource;
	private java.lang.Integer sourceId;



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
	 * Return the value associated with the column: file_name
	 */
	public java.lang.String getFileName () {
		return fileName;
	}

	/**
	 * Set the value related to the column: file_name
	 * @param fileName the file_name value
	 */
	public void setFileName (java.lang.String fileName) {
		this.fileName = fileName;
	}



	/**
	 * Return the value associated with the column: file_real_name
	 */
	public java.lang.String getFileRealName () {
		return fileRealName;
	}

	/**
	 * Set the value related to the column: file_real_name
	 * @param fileRealName the file_real_name value
	 */
	public void setFileRealName (java.lang.String fileRealName) {
		this.fileRealName = fileRealName;
	}



	/**
	 * Return the value associated with the column: file_path
	 */
	public java.lang.String getFilePath () {
		return filePath;
	}

	/**
	 * Set the value related to the column: file_path
	 * @param filePath the file_path value
	 */
	public void setFilePath (java.lang.String filePath) {
		this.filePath = filePath;
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
	 * Return the value associated with the column: accessory_source
	 */
	public java.lang.String getAccessorySource () {
		return accessorySource;
	}

	/**
	 * Set the value related to the column: accessory_source
	 * @param accessorySource the accessory_source value
	 */
	public void setAccessorySource (java.lang.String accessorySource) {
		this.accessorySource = accessorySource;
	}



	/**
	 * Return the value associated with the column: source_id
	 */
	public java.lang.Integer getSourceId () {
		return sourceId;
	}

	/**
	 * Set the value related to the column: source_id
	 * @param sourceId the source_id value
	 */
	public void setSourceId (java.lang.Integer sourceId) {
		this.sourceId = sourceId;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.flx.flxoa.info.system.entity.FlxoaAccessory)) return false;
		else {
			com.flx.flxoa.info.system.entity.FlxoaAccessory flxoaAccessory = (com.flx.flxoa.info.system.entity.FlxoaAccessory) obj;
			if (null == this.getId() || null == flxoaAccessory.getId()) return false;
			else return (this.getId().equals(flxoaAccessory.getId()));
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