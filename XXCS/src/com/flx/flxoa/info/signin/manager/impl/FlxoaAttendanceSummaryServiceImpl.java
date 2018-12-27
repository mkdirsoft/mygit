package com.flx.flxoa.info.signin.manager.impl;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.flx.flxoa.common.util.CommonUtils;
import com.flx.flxoa.common.util.DateUtils;
import com.flx.flxoa.common.util.JdbcConn;
import com.flx.flxoa.info.signin.manager.FlxoaAttendanceSummaryService;
import com.flx.flxoa.info.signin.dao.FlxoaAttendanceSummaryDao;
import com.flx.flxoa.info.signin.entity.DoorCard;
import com.flx.flxoa.info.signin.entity.FlxoaAttendanceSummary;
import com.flx.flxoa.info.system.entity.FlxoaSystemUser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * 类名称：FlxoaAttendanceSummaryServiceImpl.java
 * 类描述：
 * 创建时间：2018-03-16, 下午02:52:37
 *
 * @version 1.0 
 * @since JDK版本1.7 
 * @author 张海英 
 */ 
@Service
@Transactional
public class FlxoaAttendanceSummaryServiceImpl implements FlxoaAttendanceSummaryService {
	private FlxoaAttendanceSummaryDao dao;
	@Autowired
	public void setDao(FlxoaAttendanceSummaryDao dao) {
		this.dao = dao;
	}
	public FlxoaAttendanceSummaryDao getDao() {
		return dao;
	}
	/**
	 *添加FlxoaAttendanceSummary
	 */ 
	public boolean add(FlxoaAttendanceSummary flxoaAttendanceSummary) {
		boolean result = dao.add(flxoaAttendanceSummary);
		return result;
	}
	/**
	 *删除FlxoaAttendanceSummary
	 */ 
	public boolean delete(FlxoaAttendanceSummary flxoaAttendanceSummary) {
		boolean result = dao.delete(flxoaAttendanceSummary);
		return result;
	}
	/**
	 *修改FlxoaAttendanceSummary
	 */ 
	public boolean update(FlxoaAttendanceSummary flxoaAttendanceSummary) {
		boolean result = dao.update(flxoaAttendanceSummary);
		return result;
	}
	/**
	 *查询FlxoaAttendanceSummary列表
	 */ 
	public List<FlxoaAttendanceSummary> query(FlxoaAttendanceSummary flxoaAttendanceSummary,int pageNo,int pageSize) {
		List<FlxoaAttendanceSummary> list = dao.query(flxoaAttendanceSummary,pageNo, pageSize);
		return list;
	}
	/**
	 * 分页
	 */
	public String queryForPage(int pageNo,int pageSize){
		String pageJson = dao.queryForPage(pageNo, pageSize);
		return pageJson;
	}
	/**
	 *求和
	 */ 
	public Long queryCount(FlxoaAttendanceSummary flxoaAttendanceSummary){
		Long count = dao.queryCount(flxoaAttendanceSummary);
		return count;
	}
	/**
	 *查询FlxoaAttendanceSummary ByID
	 */ 
	public FlxoaAttendanceSummary queryById(FlxoaAttendanceSummary flxoaAttendanceSummary) {
		FlxoaAttendanceSummary result = dao.queryById(flxoaAttendanceSummary);
		return result;
	}
	/**
	 *查询FlxoaAttendanceSummary  导出
	 */ 
	public List<FlxoaAttendanceSummary> query(FlxoaAttendanceSummary flxoaAttendanceSummary) {
		List<FlxoaAttendanceSummary>  list  = dao.query(flxoaAttendanceSummary);
		return list;
	}
	
	public List<FlxoaAttendanceSummary> querySQL(FlxoaAttendanceSummary flxoaAttendanceSummary) {
		List<FlxoaAttendanceSummary>  list =  dao.querySql(flxoaAttendanceSummary);
		return list;
	}
	/**
	 * 查询部门内人员的考勤信息，根据userids
	 */
	public List<FlxoaAttendanceSummary> queryByUserIds(FlxoaAttendanceSummary flxoaAttendanceSummary,String deptIds) {
		List<FlxoaAttendanceSummary> list = dao.queryByUserIds(flxoaAttendanceSummary,deptIds);
		
		return list;
	}
	/**
	 * 对两个库数据进行分页
	 */
	public String queryPageSign(Map<String, String> map,List<FlxoaAttendanceSummary> dataList){
		int pageNo=Integer.valueOf(map.get("pageNo"));
		int pageSize=Integer.valueOf(map.get("pageSize"));
		String draw=map.get("draw");
		int size = dataList.size();
		Long totalCount = new Long((long)size);
		System.out.println("长度为======="+totalCount);
		List<Map<String,String>> otherDataList=new ArrayList<Map<String,String>>();
		List<Map<String,String>> returnList=new ArrayList<Map<String,String>>();
		for(FlxoaAttendanceSummary summary : dataList){
			Map<String,String> dataMap=new HashMap<String,String>();
			//Object[] obj=(Object[]) dataList.get(i);
			dataMap.put("id", String.valueOf(summary.getId()));
			dataMap.put("Userid", String.valueOf(summary.getUserid()));
			dataMap.put("realname", String.valueOf(summary.getRealname()));
			dataMap.put("deptid", String.valueOf(summary.getCreateDepartmentId()));
			dataMap.put("dname", String.valueOf(summary.getDname()));
			dataMap.put("signData", String.valueOf(summary.getSignData()));
			dataMap.put("signEarliestTime", String.valueOf(summary.getSignEarliestTime()));
			dataMap.put("signEarliestType", String.valueOf(summary.getSignEarliestType()));
			dataMap.put("signEarliestComments", String.valueOf(summary.getSignEarliestComments()));
			dataMap.put("signEarliestAddress", String.valueOf(summary.getSignEarliestAddress()));
			dataMap.put("signLatestTime", String.valueOf(summary.getSignLatestTime()));
			dataMap.put("signLatestType", String.valueOf(summary.getSignLatestType()));
			dataMap.put("signLatestComments", String.valueOf(summary.getSignLatestComments()));
			dataMap.put("signLatestAdress", String.valueOf(summary.getSignLatestAdress()));
			dataMap.put("leaderLomments", String.valueOf(summary.getLeaderComments()));
			dataMap.put("signStatus",  String.valueOf(summary.getSignStatus()));
			dataMap.put("cardid", String.valueOf(summary.getCardId()));
			returnList.add(dataMap);
		}
		//遍历returnList,组合符合条件的数据List,pageData
		List<Map<String,String>> pageData=new ArrayList<Map<String,String>>();
		//开始的第几条
		int ks = pageNo;//10
		//结束的条数，结束的数字，要小于等于returnList.size()		
		int js = pageNo+pageSize;//20
		if(js >= returnList.size()){
			js=returnList.size();
		}
		for(int i = ks;i < js;i++){
			Map<String, String> reMap = new HashMap<String,String>();			
			reMap = returnList.get(i);
			pageData.add(reMap);
		}
		return CommonUtils.getPageJson(pageNo, pageSize,draw,totalCount,pageData,otherDataList);
	}
	/**
	 * 查询员工当天考勤的汇总记录
	 */
	@Override
	public List<FlxoaAttendanceSummary> queryCurrentSign(FlxoaAttendanceSummary flxoaAttendanceSummary,String userIds,String cardId, List<FlxoaSystemUser> cardList) {
		//详情
		int getMorningTimestamp = DateUtils.getMorningTimestamp();
		List<FlxoaAttendanceSummary> list= dao.queryTodayRecord(flxoaAttendanceSummary,userIds,getMorningTimestamp);
		try {		
			//获取当天的凌晨时间  String类型
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String data = sdf.format(DateUtils.getStartTime());
			String data1= sdf.format(DateUtils.getEndTime());
			
			
			//String sql ="select a.EMPNAME as name,b.EmpCardId,b.CardDay as checktime from Hrms_Emp a,NDr2_CardEvent b where a.EMPID=b.EMPID and b.EmpCardId in ( "+cardId+") and b.CardDay >'"+data+"' and b.CardDay <'"+data1+"' order by CardDay desc ";
			String sql ="select b.EMPCARDID ,min(b.CardDay) as maxTime,max(b.CardDay) as minTime from Hrms_Emp a,NDr2_CardEvent b  where a.EMPID=b.EMPID AND  b.CardDay >'"+data+"' and b.CardDay <'"+data1+"'  ";
			sql += " and ( ";
			if(cardList==null){
				sql += " b.EMPCARDID = "+cardId+" ";
				}
			else{
				for(int i=0;i<cardList.size();i++){
					sql += " b.EMPCARDID = "+cardList.get(i).getCardId() +" or";				
				}
				sql = sql.substring(0,sql.length()-2);
			}
			sql+= " )";
			if(flxoaAttendanceSummary.getRealname()!=null && flxoaAttendanceSummary.getRealname() !=""){
				sql += " AND a.EmpName LIKE '%"+flxoaAttendanceSummary.getRealname()+"%' ";
			}
			
			sql+=" GROUP BY a.EMPName,b.EMPCARDID order by EmpCardId asc ";
			JdbcConn jdbcConn = new JdbcConn();
			List<DoorCard> sqlServerList=null;
			int max = 0;//最早时间（小）
			int min = 0;//最晚时间(大)			
			sqlServerList = jdbcConn.getTodaySignDetails(sql);
			
			//将门禁SqlServer中当天打卡的记录放入list中

			for(int i=0;i<sqlServerList.size();i++){				
				FlxoaAttendanceSummary summary=new FlxoaAttendanceSummary();
				int carId=sqlServerList.get(i).getCardId();
				//打卡的最早时间，最晚时间
				max = DateUtils.getSecondTimestamp(sdf.parse(sqlServerList.get(i).getMaxTime()));
				min = DateUtils.getSecondTimestamp(sdf.parse(sqlServerList.get(i).getMinTime()));
				
				for(int j=0;j<list.size();j++){
					summary=list.get(j);
					int carid=list.get(j).getCardId();
					//部门内所有人的当天考勤汇总记录得到最早时间、最晚时间					
					int  maxTime = 0;
					int  minTime = 0;		
					if(carId == carid){
						maxTime=list.get(j).getSignEarliestTime();//小
						minTime=list.get(j).getSignLatestTime();//大					
					//仅打卡的情况
					if(maxTime==0 && minTime==0){
						//有刷卡记录
						summary.setSignEarliestTime(max);
						summary.setSignLatestTime(min);
						summary.setSignEarliestType("1");
						summary.setSignLatestType("1");					
					}else{//既有打卡又有手机签到的情况 四个数比较大小
						if(max>maxTime){
							summary.setSignEarliestTime(maxTime);						
						}else{
							summary.setSignEarliestTime(max);
							summary.setSignEarliestType("1");
						}
						if(min>minTime){
							summary.setSignLatestTime(min);
							summary.setSignLatestType("1");
						}else{							
							summary.setSignLatestTime(minTime);
						}
						
					}
					summary.setSignStatus("当天考勤");
					list.set(j, summary);
					}
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
}