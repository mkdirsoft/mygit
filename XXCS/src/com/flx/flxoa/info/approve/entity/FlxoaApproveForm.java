package com.flx.flxoa.info.approve.entity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.flx.flxoa.info.approve.entity.base.BaseFlxoaApproveForm;



public class FlxoaApproveForm extends BaseFlxoaApproveForm {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public FlxoaApproveForm () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public FlxoaApproveForm (java.lang.Integer id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public FlxoaApproveForm (
		java.lang.Integer id,
		java.lang.Integer templateId,
		java.lang.String status,
		java.lang.String submitStatus,
		java.lang.Integer submitTime,
		java.lang.Integer workflowId,
		java.lang.String checkUserIds,
		java.lang.String nowFormStatus,
		java.lang.String isRead,
		java.lang.Integer createTime,
		java.lang.Integer updateTime,
		java.lang.String deleteFlag,
		java.lang.Integer createUserId,
		java.lang.Integer createDepartmentId,
		java.lang.Integer updateUserId,
		java.lang.Integer updateDepartmentId) {

		super (
			id,
			templateId,
			status,
			submitStatus,
			submitTime,
			workflowId,
			checkUserIds,
			nowFormStatus,
			isRead,
			createTime,
			updateTime,
			deleteFlag,
			createUserId,
			createDepartmentId,
			updateUserId,
			updateDepartmentId);
	}

/*[CONSTRUCTOR MARKER END]*/
	//申请类型
	private String approveType;
	//申请时间
	private String approveTime;	
	//项目编号
	private String projNumber;
	//项目名称
	private String projName;
	//状态
	private String approveStatus;
	//审批进度
	private String approveProgress;
	//关键字
	private String keyword;
	//审批详细进度
	private String approveProgressDetail;
	//角色名称对应的工作流id和所在位置(审批进度)
	private List<FlxoaApproveForm> list;
	//登录者userId (获取权限用)
	private String loginUserId;
	//权限范围内可以查看的部门ids
	private String departmentIds;
	
	//开始时间
	private Integer startTime;
	//结束时间
	private Integer endTime;
	//申请人
	private String realName;
	
	//上一步审批人
	private String nowUser;
	//下一步审批人
	private String nextUser;

	//审批时间
	private String approveLogTime;
	//审批用户
	private String approveUser;
	//审批用户id
	private String approveUserId;	
	//审批意见
	private String approveIdea;
	//审批备注
	private String approveRemark;
	//当前提交状态
	private String nowStatus;
	//下一步提交状态
	private String nextStatus;
	
	//审批记录的formId，我的历史审批记录用
	private String formIds;
	
	//是否确认
	private String isCheck;
	
	//按哪个字段进行排序（默认没值 按申请时间排序）
	private String orderBy;
	
	//首頁 审批状态“未审批，审批中”
	private String states;
	//关键字检索英文名称
	private String keywordName;
	//关键字检索选择或者输入的值
	private String keywordValue;
	//关键字类型
	private String keywordType;
	//当前工作流节点名称
	private String nowFlowNodeName;
	
	public String getNowFlowNodeName() {
		return nowFlowNodeName;
	}

	public void setNowFlowNodeName(String nowFlowNodeName) {
		this.nowFlowNodeName = nowFlowNodeName;
	}

	public String getKeywordName() {
		return keywordName;
	}

	public void setKeywordName(String keywordName) {
		this.keywordName = keywordName;
	}

	public String getKeywordValue() {
		return keywordValue;
	}

	public void setKeywordValue(String keywordValue) {
		this.keywordValue = keywordValue;
	}

	public String getKeywordType() {
		return keywordType;
	}

	public void setKeywordType(String keywordType) {
		this.keywordType = keywordType;
	}

	public String getStates() {
		return states;
	}

	public void setStates(String states) {
		this.states = states;
	}

	public String getOrderBy() {
		return orderBy;
	}

	public void setOrderBy(String orderBy) {
		this.orderBy = orderBy;
	}

	public String getIsCheck() {
		return isCheck;
	}

	public void setIsCheck(String isCheck) {
		this.isCheck = isCheck;
	}

	public String getFormIds() {
		return formIds;
	}

	public void setFormIds(String formIds) {
		this.formIds = formIds;
	}

	public String getApproveUserId() {
		return approveUserId;
	}

	public void setApproveUserId(String approveUserId) {
		this.approveUserId = approveUserId;
	}

	public String getApproveLogTime() {
		return approveLogTime;
	}

	public void setApproveLogTime(String approveLogTime) {
		this.approveLogTime = approveLogTime;
	}

	public String getApproveUser() {
		return approveUser;
	}

	public void setApproveUser(String approveUser) {
		this.approveUser = approveUser;
	}

	public String getApproveIdea() {
		return approveIdea;
	}

	public void setApproveIdea(String approveIdea) {
		this.approveIdea = approveIdea;
	}

	public String getApproveRemark() {
		return approveRemark;
	}

	public void setApproveRemark(String approveRemark) {
		this.approveRemark = approveRemark;
	}

	public String getNowUser() {
		return nowUser;
	}

	public void setNowUser(String nowUser) {
		this.nowUser = nowUser;
	}

	public String getNextUser() {
		return nextUser;
	}

	public void setNextUser(String nextUser) {
		this.nextUser = nextUser;
	}

	public String getNowStatus() {
		return nowStatus;
	}

	public void setNowStatus(String nowStatus) {
		this.nowStatus = nowStatus;
	}

	public String getNextStatus() {
		return nextStatus;
	}

	public void setNextStatus(String nextStatus) {
		this.nextStatus = nextStatus;
	}

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public Integer getStartTime() {
		return startTime;
	}

	public void setStartTime(Integer startTime) {
		this.startTime = startTime;
	}

	public Integer getEndTime() {
		return endTime;
	}

	public void setEndTime(Integer endTime) {
		this.endTime = endTime;
	}

	public String getLoginUserId() {
		return loginUserId;
	}

	public void setLoginUserId(String loginUserId) {
		this.loginUserId = loginUserId;
	}

	public String getDepartmentIds() {
		return departmentIds;
	}

	public void setDepartmentIds(String departmentIds) {
		this.departmentIds = departmentIds;
	}

	public List<FlxoaApproveForm> getList() {
		return list;
	}

	public void setList(List<FlxoaApproveForm> list) {
		this.list = list;
	}

	public String getApproveProgressDetail() {
		return approveProgressDetail;
	}

	public void setApproveProgressDetail(String approveProgressDetail) {
		this.approveProgressDetail = approveProgressDetail;
	}

	public String getApproveType() {
		return approveType;
	}

	public void setApproveType(String approveType) {
		this.approveType = approveType;
	}

	public String getApproveTime() {
		return approveTime;
	}

	public void setApproveTime(String approveTime) {
		this.approveTime = approveTime;
	}

	public String getApproveStatus() {
		return approveStatus;
	}

	public void setApproveStatus(String approveStatus) {
		this.approveStatus = approveStatus;
	}

	public String getApproveProgress() {
		return approveProgress;
	}

	public void setApproveProgress(String approveProgress) {
		this.approveProgress = approveProgress;
	}	
	public String getProjNumber() {
		return projNumber;
	}

	public void setProjNumber(String projNumber) {
		this.projNumber = projNumber;
	}

	public String getProjName() {
		return projName;
	}

	public void setProjName(String projName) {
		this.projName = projName;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
}