package com.flx.flxoa.info.system.entity;

import com.flx.flxoa.info.system.entity.base.BaseFlxoaSystemRole;



public class FlxoaSystemRole extends BaseFlxoaSystemRole {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public FlxoaSystemRole () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public FlxoaSystemRole (java.lang.Integer id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public FlxoaSystemRole (
		java.lang.Integer id,
		java.lang.String name,
		java.lang.Integer createTime,
		java.lang.Integer updateTime,
		java.lang.String deleteFlag,
		java.lang.Integer createUserId,
		java.lang.Integer createDepartmentId,
		java.lang.Integer updateUserId,
		java.lang.Integer updateDepartmentId) {

		super (
			id,
			name,
			createTime,
			updateTime,
			deleteFlag,
			createUserId,
			createDepartmentId,
			updateUserId,
			updateDepartmentId);
	}

/*[CONSTRUCTOR MARKER END]*/
	//角色id
	private String roid;
	//功能名称
	private String fun_name;
	//功能地址
	private String url;

	public String getRoid() {
		return roid;
	}

	public void setRoid(String roid) {
		this.roid = roid;
	}

	public String getFun_name() {
		return fun_name;
	}

	public void setFun_name(String fun_name) {
		this.fun_name = fun_name;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

}