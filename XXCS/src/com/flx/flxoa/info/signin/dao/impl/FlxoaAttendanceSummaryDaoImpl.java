package com.flx.flxoa.info.signin.dao.impl;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.flx.flxoa.info.signin.entity.FlxoaAttendanceSummary;
import com.flx.flxoa.info.signin.dao.FlxoaAttendanceSummaryDao;
import org.springframework.stereotype.Repository;
import com.flx.flxoa.common.hibernate3.HibernateBaseDao;
import com.flx.flxoa.common.util.CommonUtils;
import com.flx.flxoa.common.util.DateUtils;

/**
 *
 * 类名称：FlxoaAttendanceSummaryDaoImpl.java
 * 类描述：
 * 创建时间：2018-03-16, 下午02:52:37
 *
 * @version 1.0 
 * @since JDK版本1.7 
 * @author 张海英 
 */ 
@Repository
public class FlxoaAttendanceSummaryDaoImpl extends HibernateBaseDao<FlxoaAttendanceSummary, Integer> implements FlxoaAttendanceSummaryDao {
	/**
	 *添加FlxoaAttendanceSummary
	 */ 
	public boolean add(FlxoaAttendanceSummary flxoaAttendanceSummary) {
		return save(flxoaAttendanceSummary);
	}
	/**
	 *删除FlxoaAttendanceSummary
	 */ 
	public boolean delete(FlxoaAttendanceSummary flxoaAttendanceSummary) {
		flxoaAttendanceSummary.setDeleteFlag("1");
		return save(flxoaAttendanceSummary);
	}
	/**
	 *修改FlxoaAttendanceSummary
	 */ 
	public boolean update(FlxoaAttendanceSummary flxoaAttendanceSummary) {
		return modify(flxoaAttendanceSummary);
	}
	/**
	 *查询FlxoaAttendanceSummary列表
	 */ 
	public List<FlxoaAttendanceSummary> query(FlxoaAttendanceSummary flxoaAttendanceSummary,int pageNo,int pageSize) {
		String hql = "";
		if(flxoaAttendanceSummary.getCreateUserId() != null ){
			hql = " from FlxoaAttendanceSummary where delete_flag = '0' and create_user_id = '"+flxoaAttendanceSummary.getCreateUserId()+"'";
		
		}else{
			hql = " from FlxoaAttendanceSummary where delete_flag = '0' ";
			
		}
		//return getListByHQL(hql, null);
		return queryForPageByHQL(pageNo, pageSize, hql);
	}
	
	public Long queryCount(FlxoaAttendanceSummary flxoaAttendanceSummary){
		String hql = "";
		if(flxoaAttendanceSummary.getCreateUserId() != null ){
			hql = "select count(*) from FlxoaAttendanceSummary where delete_flag = '0' and create_user_id = '"+flxoaAttendanceSummary.getCreateUserId()+"'";
		}else{
			hql = "select count(*) from FlxoaAttendanceSummary where delete_flag = '0' ";
		}
		return countByHql(hql,null);
	}
	/**
	 *查询FlxoaAttendanceSummary ByID
	 */ 
	public FlxoaAttendanceSummary queryById(FlxoaAttendanceSummary flxoaAttendanceSummary) {
		return get(flxoaAttendanceSummary.getId());
	}
	
	@Override
	protected Class<FlxoaAttendanceSummary> getEntityClass() {
		return FlxoaAttendanceSummary.class;
	}
	@Override
	public List<FlxoaAttendanceSummary> querySql(FlxoaAttendanceSummary flxoaAttendanceSummary) {
		
		String sql ="SELECT * from flxoa_attendance_summary A" +
				" LEFT JOIN  flxoa_system_user B ON a.create_user_id = B.id " +
				"where B.real_name='任思颖' ";
		return querySQL(sql, null);
		
	} 
	
	public List<FlxoaAttendanceSummary> query(FlxoaAttendanceSummary flxoaAttendanceSummary){
		String hql=" from FlxoaAttendanceSummary where delete_flag = '0' ";
		if(!CommonUtils.isEmpty(flxoaAttendanceSummary.getSignStatus())){
			hql += "and sign_status = '"+flxoaAttendanceSummary.getSignStatus()+"' " ;
		}
		//根据时间查询
		/*if(!CommonUtils.isEmpty(flxoaAttendanceSummary.getSignData().toString())){
			hql += "and sign_data <'"+flxoaAttendanceSummary.getSignData()+"' and  and sign_data >'"+flxoaAttendanceSummary.getSignData()+"' " ;
		}*/
		
		return getListByHQL(hql,null);
	}
	/**
	 * 查询部门内员工的 考勤信息 根据userIDS
	 */
	public List<FlxoaAttendanceSummary> queryByUserIds(FlxoaAttendanceSummary flxoaAttendanceSummary,String deptIds) {
		String sql = " SELECT summary.id,sysuser.id as userid ,sysuser.real_name,dept.id,dept.name,summary.sign_data,summary.sign_earliest_time,summary.sign_earliest_type,summary.sign_earliest_comments," +
				"summary.sign_earliest_address,summary.sign_latest_time ,summary.sign_latest_type ,summary.sign_latest_comments ," +
				"summary.sign_latest_adress ,summary.leader_comments,summary.sign_status,sysuser.card_id from flxoa_attendance_summary summary ,flxoa_system_user sysuser, flxoa_system_department dept " +
				" where summary.create_user_id=sysuser.id AND summary.create_department_id=dept.id and summary.delete_flag = '0'   ";
		//查询条件
		if(flxoaAttendanceSummary.getRealname()!=null&&flxoaAttendanceSummary.getRealname()!=""){
			sql+= " and sysuser.real_name like '%"+flxoaAttendanceSummary.getRealname()+ "%' ";
		}
		if(flxoaAttendanceSummary.getDname()!=null&&flxoaAttendanceSummary.getDname()!=""){
			sql += " and dept.name ='"+flxoaAttendanceSummary.getDname()+"' "; 
		}
		if(!CommonUtils.isEmpty(flxoaAttendanceSummary.getSignStatus()) && !flxoaAttendanceSummary.getSignStatus().equals("10")){
			sql += " and summary.sign_status ='"+flxoaAttendanceSummary.getSignStatus()+"'";
		}
		if(flxoaAttendanceSummary.getStartDate()>0 && flxoaAttendanceSummary.getEndDate()==0){
			sql += " and summary.sign_data = "+flxoaAttendanceSummary.getStartDate()+"  ";
			
		}
		if(flxoaAttendanceSummary.getStartDate()>0 && flxoaAttendanceSummary.getEndDate()>0){
			sql += " and summary.sign_data >= "+flxoaAttendanceSummary.getStartDate()+"  and summary.sign_data <= "+flxoaAttendanceSummary.getEndDate()+" ";
		}if(!CommonUtils.isEmpty(flxoaAttendanceSummary.getLeaderComments())){
			if(flxoaAttendanceSummary.getLeaderComments().equals("1")){
				sql += " and  summary.leader_comments ='' ";
			}else{
				sql += " and summary.leader_comments >'' " ;
			}
		}
		//判断是我的签到
		if(flxoaAttendanceSummary.getCreateUserId()!=null &&flxoaAttendanceSummary.getCreateUserId() != 0){
			sql+= " and summary.create_user_id = "+flxoaAttendanceSummary.getCreateUserId()+ " ";
		}//部门签到
		else{
			//判断是否是一个部门
			String parm = " summary.create_department_id  ";//部门条件	
			if(deptIds.indexOf(",") >= 0){
				/*String [] deptids= deptIds.split(",");
				for(int i=0;i<deptids.length;i++){
					parm += " summary.create_department_id = "+deptids[i]+" or";				
				}		*/	
				//parm = parm.substring(0,parm.length()-2);
				parm+=" REGEXP '["+deptIds+"]' ";
			}
			else{
				parm = "  summary.create_department_id = "+deptIds+" ";			
			}
			sql+=" AND ("+parm+")  ";
		}
		sql += " order by summary.sign_data desc ";
		List<Object> list = querySQL(sql,null);
		List<FlxoaAttendanceSummary> fromlist = new ArrayList<FlxoaAttendanceSummary>();
		for(int i=0;i<list.size();i++){
			FlxoaAttendanceSummary summary = new FlxoaAttendanceSummary();
			Object[] listValue= (Object[]) list.get(i);
			summary.setId(Integer.valueOf(listValue[0].toString()));
			summary.setUserid(Integer.valueOf(listValue[1].toString()));
			summary.setRealname(listValue[2].toString());	
			summary.setCreateDepartmentId(Integer.valueOf(listValue[3].toString()));
			summary.setDname(listValue[4].toString());
			summary.setSignData(Integer.valueOf(listValue[5].toString()));
			summary.setSignEarliestTime(Integer.valueOf(listValue[6].toString()));
			summary.setSignEarliestType(listValue[7].toString());
			summary.setSignEarliestComments(listValue[8].toString());
			summary.setSignEarliestAddress(listValue[9].toString());
			summary.setSignLatestTime(Integer.valueOf(listValue[10].toString()));
			summary.setSignLatestType(listValue[11].toString());
			summary.setSignLatestComments(listValue[12].toString());
			summary.setSignLatestAdress(listValue[13].toString());
			summary.setLeaderComments(listValue[14].toString());
			summary.setSignStatus(CommonUtils.returnStr(listValue[15]));
			summary.setCardId(Integer.valueOf(listValue[16].toString()));
			fromlist.add(summary);			
		}
		
		return fromlist;
	}
	@Override
	public String queryForPage(int pageNo, int pageSize) {
		
		String hql=" from flxoa_attendance_summary summary ,flxoa_system_user sysuser, flxoa_system_department dept" +
				" where summary.create_user_id=sysuser.id AND summary.create_department_id=dept.id and summary.delete_flag = '0'  order by summary.sign_data asc ";
		String querySql=" SELECT summary.id,sysuser.id,sysuser.real_name,dept.id,dept.name,summary.sign_data,summary.sign_earliest_time," +
				"summary.sign_earliest_type,summary.sign_earliest_comments," +
				"summary.sign_earliest_address,summary.sign_latest_time ,summary.sign_latest_type ,summary.sign_latest_comments ,summary.sign_latest_adress ,summary.leader_comments,summary.sign_status,sysuser.card_id "+hql;
		String countSql="select count(*) "+hql;
		List list= queryListForPageBySQL(pageNo, pageSize, querySql);
		List<Map<String,String>> dataList=new ArrayList<Map<String,String>>();
		for(int i=0;i<list.size();i++){
			Map<String,String> dataMap=new HashMap<String,String>();
			Object[] obj=(Object[]) list.get(i);
			dataMap.put("id", String.valueOf(obj[0]));
			dataMap.put("userid", String.valueOf(obj[1]));
			dataMap.put("real_name", String.valueOf(obj[2]));
			dataMap.put("dept_id", String.valueOf(obj[3]));
			dataMap.put("dept_name", String.valueOf(obj[4]));
			dataMap.put("sign_data", String.valueOf(obj[5]));
			dataMap.put("sign_earliest_time", String.valueOf(obj[6]));
			dataMap.put("sign_earliest_type", String.valueOf(obj[7]));
			dataMap.put("sign_earliest_comments", String.valueOf(obj[8]));
			dataMap.put("sign_earliest_address", String.valueOf(obj[9]));
			dataMap.put("sign_latest_time", String.valueOf(obj[10]));
			dataMap.put("sign_latest_type", String.valueOf(obj[11]));
			dataMap.put("sign_latest_comments", String.valueOf(obj[12]));
			dataMap.put("sign_latest_adress", String.valueOf(obj[13]));
			dataMap.put("leader_comments", String.valueOf(obj[14]));
			dataMap.put("sign_status",  String.valueOf(obj[15]));
			dataMap.put("card_id", String.valueOf(obj[16]));
			dataList.add(dataMap);
		}
		Long totalCount= countBySql(countSql,null);
		return CommonUtils.getPageJson(pageNo,pageSize,"",totalCount,dataList,null);
	}
	/**
	 * 查询今天的手机汇总记录
	 */
	
	@Override
	public List<FlxoaAttendanceSummary> queryTodayRecord(FlxoaAttendanceSummary flxoaAttendanceSummary,String userIds,int morningTime) {
			String sql = "SELECT  E.id as userid,E.real_name,E.department_id,E.card_id,D.name,F.maxTime,F.zaoLocale,F.zaoComments,F.zaoSignType,F.minTime,F.wanLocale,F.wanComments,F.wanSigntype,E.card_id FROM flxoa_system_user E " +
					" LEFT JOIN (select A.CREATE_user_id ,A.create_department_id,A.maxTime,A.zaoLocale,A.zaoComments,A.zaoSignType,B.minTime,B.wanLocale,B.wanComments,B.wanSigntype FROM " +
					" (SELECT CREATE_user_id, create_department_id ,min(sign_time) maxTime,sign_locale zaoLocale, commens zaoComments,	 sign_type zaoSignType   FROM  flxoa_attendance_signdetails WHERE sign_time > "+morningTime+" GROUP BY CREATE_user_id)A left join " +
					" (SELECT CREATE_user_id,create_department_id,max(sign_time) minTime , sign_locale wanLocale ,commens wanComments,sign_type wanSigntype   FROM  flxoa_attendance_signdetails  WHERE sign_time > "+morningTime+" GROUP BY CREATE_user_id)B on A.CREATE_user_id=B.CREATE_user_id)F " +
					" on F.CREATE_user_id = E.id LEFT JOIN flxoa_system_department D ON E.department_id = D.id where  E.status='0' and  E.delete_flag='0'  " ;		
			if(!userIds.equals("") && userIds!=null){
				/*String [] userids=userIds.split(",");
				sql += " and ( ";
				for(int i=0;i<userids.length;i++)
				{
					sql += " E.id = ("+userids[i]+")  or";
				}
				sql = sql.substring(0,sql.length()-2);
				sql+= " )";	*/	
				//判断是否是一个部门
				String parm = " E.id  ";//人员条件	
				if(userIds.indexOf(",") >= 0){					
					parm+=" REGEXP '["+userIds+"]' ";
				}
				else{
					parm = " E.id = "+userIds+" ";			
				}
				sql+=" AND ("+parm+")  ";
			}
			if(flxoaAttendanceSummary.getRealname()!=null && flxoaAttendanceSummary.getRealname() !=""){
				sql+= "  and E.real_name like '%"+flxoaAttendanceSummary.getRealname()+ "%' ";
			}
			if(flxoaAttendanceSummary.getDname()!=null && flxoaAttendanceSummary.getDname()!= ""){
				sql += "  and D.name = '"+flxoaAttendanceSummary.getDname()+"'"; 
			}
			
			List<Object> list = querySQL(sql,null);
			List<FlxoaAttendanceSummary> fromlist = new ArrayList<FlxoaAttendanceSummary>();
			for(int i=0;i<list.size();i++){
				FlxoaAttendanceSummary summary = new FlxoaAttendanceSummary();
				Object[] listValue= (Object[]) list.get(i);
				summary.setUserid(Integer.valueOf(listValue[0].toString()));
				summary.setRealname(listValue[1].toString());	
				summary.setCreateDepartmentId(CommonUtils.returnInt(listValue[2]));
				summary.setCardId(CommonUtils.returnInt(listValue[3]));
				summary.setDname(CommonUtils.returnStr(listValue[4]));
				summary.setSignData(morningTime);
				summary.setSignEarliestTime(CommonUtils.returnInt(listValue[5]));
				summary.setSignEarliestAddress(CommonUtils.returnStr(listValue[6]));
				summary.setSignEarliestComments(CommonUtils.returnStr(listValue[7]));
				summary.setSignEarliestType(CommonUtils.returnStr(listValue[8]));
				summary.setSignLatestTime(CommonUtils.returnInt(listValue[9]));
				summary.setSignLatestAdress(CommonUtils.returnStr(listValue[10]));
				summary.setSignLatestComments(CommonUtils.returnStr(listValue[11]));
				summary.setSignLatestType(CommonUtils.returnStr(listValue[12]));
				summary.setCardId(CommonUtils.returnInt(listValue[13]));
				summary.setSignStatus("当天考勤");
				fromlist.add(summary);			
			}
			
			return fromlist;
		}
	/**
	 * 查询昨天的手机汇总记录
	 */
	
	@Override
	public List<FlxoaAttendanceSummary> queryYesterdayImport() {
		//获取前一天的开始时间
		int preStartTime =DateUtils.getPreStartTime();
		//获取前一天的结束时间
		int preEndTime =DateUtils.getPreEndTime();	
		
		String sql = "SELECT  E.id as userid,E.real_name,E.department_id,E.card_id,D.name,F.maxTime,F.zaoLocale,F.zaoComments,F.zaoSignType,F.minTime,F.wanLocale,F.wanComments,F.wanSigntype,E.card_id FROM flxoa_system_user E " +
					" LEFT JOIN (select A.CREATE_user_id ,A.create_department_id,A.maxTime,A.zaoLocale,A.zaoComments,A.zaoSignType,B.minTime,B.wanLocale,B.wanComments,B.wanSigntype FROM " +
					" (SELECT CREATE_user_id, create_department_id ,min(sign_time) maxTime,sign_locale zaoLocale, commens zaoComments,	 sign_type zaoSignType   FROM  flxoa_attendance_signdetails WHERE sign_time > '"+preStartTime+"'	AND sign_time < '"+preEndTime+"' GROUP BY CREATE_user_id)A left join " +
					" (SELECT CREATE_user_id,create_department_id,max(sign_time) minTime , sign_locale wanLocale ,commens wanComments,sign_type wanSigntype   FROM  flxoa_attendance_signdetails  WHERE sign_time > '"+preStartTime+"'	AND sign_time < '"+preEndTime+"'  GROUP BY CREATE_user_id)B on A.CREATE_user_id=B.CREATE_user_id)F " +
					" on F.CREATE_user_id = E.id LEFT JOIN flxoa_system_department D ON E.department_id = D.id where  E.status='0' and  E.delete_flag='0'  " ;		
			
			
			List<Object> list = querySQL(sql,null);
			List<FlxoaAttendanceSummary> fromlist = new ArrayList<FlxoaAttendanceSummary>();
			for(int i=0;i<list.size();i++){
				FlxoaAttendanceSummary summary = new FlxoaAttendanceSummary();
				Object[] listValue= (Object[]) list.get(i);
				summary.setUserid(Integer.valueOf(listValue[0].toString()));
				summary.setRealname(listValue[1].toString());	
				summary.setCreateDepartmentId(CommonUtils.returnInt(listValue[2]));
				summary.setCardId(CommonUtils.returnInt(listValue[3]));
				summary.setDname(CommonUtils.returnStr(listValue[4]));
				summary.setSignData(preStartTime);
				summary.setSignEarliestTime(CommonUtils.returnInt(listValue[5]));
				summary.setSignEarliestAddress(CommonUtils.returnStr(listValue[6]));
				summary.setSignEarliestComments(CommonUtils.returnStr(listValue[7]));
				summary.setSignEarliestType(CommonUtils.returnStr(listValue[8]));
				summary.setSignLatestTime(CommonUtils.returnInt(listValue[9]));
				summary.setSignLatestAdress(CommonUtils.returnStr(listValue[10]));
				summary.setSignLatestComments(CommonUtils.returnStr(listValue[11]));
				summary.setSignLatestType(CommonUtils.returnStr(listValue[12]));
				summary.setCardId(CommonUtils.returnInt(listValue[13]));
				summary.setSignStatus("当天考勤");
				fromlist.add(summary);			
			}
			
			return fromlist;
		}
	
}