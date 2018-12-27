package com.flx.flxoa.info.statistical.manager;

import java.util.List;
import java.util.Map;

/**
 * 类名称：FlxoaStatisticalService.java<br>
 * 类描述：<br>
 * 创建时间：2018-4-11, 下午7:36:14
 * 
 * @version 1.0 
 * @since JDK版本
 * @author Administrator 
 */
public interface FlxoaStatisticalService {
	public List<Map<String, Object>> queryByDeptid(String deptid);
	/**
	 *首页查询 统计 各中心 回款 金额
	 */ 
	public List<Map<String,Object>> queryHuiKuan(String name,String deptIds);
	/**
	 * 查询申请表中未审批的条目数
	 */
	public String queryFormNoApproval(int start,int length,String userid,String draw);
	/**
	 * 首页显示我的项目统计
	 */
	public String queryMyProject(int start,int length,String draw,String userid);
	/**
	 * 首页 求个人本月内的打卡情况（迟到，打卡异常，正常，请假）的次数
	 */
	public List<Map<String,Object>>  querySumPerson(int userid);
	public String  queryPersonSign(int start,int length,String draw,String userid);
	/**
	 * 首页 求部门经理，主管等权限人  部门的打卡情况（迟到，打卡异常，正常，请假）的次数
	 */
	public String querySumDept(int start,int length,String draw,String deptid);
	/**
	 * 首页我的关注
	 */
	public String queryMyFocusProject(int start, int length, String draw,String userid);
}

