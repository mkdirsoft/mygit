package com.flx.flxoa.info.system.entity;

import com.flx.flxoa.info.system.entity.base.BaseFlxoaSystemRoleFuncation;



public class FlxoaSystemRoleFuncation extends BaseFlxoaSystemRoleFuncation {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public FlxoaSystemRoleFuncation () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public FlxoaSystemRoleFuncation (java.lang.Integer id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public FlxoaSystemRoleFuncation (
		java.lang.Integer id,
		java.lang.Integer roleId,
		java.lang.Integer funcationId,
		java.lang.Integer createTime,
		java.lang.Integer updateTime,
		java.lang.String deleteFlag,
		java.lang.Integer createUserId,
		java.lang.Integer createDepartmentId,
		java.lang.Integer updateUserId,
		java.lang.Integer updateDepartmentId) {

		super (
			id,
			roleId,
			funcationId,
			createTime,
			updateTime,
			deleteFlag,
			createUserId,
			createDepartmentId,
			updateUserId,
			updateDepartmentId);
	}
	//角色名称
	private String roleName;
	//功能名称
	private String functionName;
/*[CONSTRUCTOR MARKER END]*/

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getFunctionName() {
		return functionName;
	}

	public void setFunctionName(String functionName) {
		this.functionName = functionName;
	}

}