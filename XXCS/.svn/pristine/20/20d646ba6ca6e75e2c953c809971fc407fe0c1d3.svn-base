package com.flx.flxoa.info.statistical.dao.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.flx.flxoa.common.hibernate3.HibernateBaseDao;
import com.flx.flxoa.common.util.CommonUtils;
import com.flx.flxoa.common.util.DateUtils;
import com.flx.flxoa.info.projectmanagement.entity.FlxoaProjectInformation;
import com.flx.flxoa.info.statistical.dao.FlxoaStatisticalDao;

/**
 * 类名称：FlxoaStatisticalDaoImpl.java<br>
 * 类描述：<br>
 * 创建时间：2018-4-11, 下午7:34:47
 * 
 @version 1.0 
 * @since JDK版本 1.7
 * @author 夏改翠  
 **/
@Repository
public class FlxoaStatisticalDaoImpl extends HibernateBaseDao<FlxoaProjectInformation, Integer> implements FlxoaStatisticalDao{

	//当年时间开始的时间戳
	int getCurrYearFirst =  DateUtils.getSecondTimestamp(DateUtils.getCurrYearFirst());
	//本月开始的时间戳
	int getMonthFirst = DateUtils.getMonthStart();
	/**
	 * 首页部分 部门 项目的合同额、回款、费用、中标、储备 等金额的统计
	 */
	@Override
	public List<Map<String, Object>> queryByDeptid(String deptid) {
		//判断是否是一个部门
		String parm = "";//储备、中标、合同额 部门条件
		String parm1="";//回款 认领人部门
		String parm2="";// 费用 申请人部门条件
		String [] deptids= deptid.split(",");
		if(deptid.indexOf(",") >= 0){
				parm += "  info.create_department_id REGEXP '["+deptids+"]' ";
				parm1 +=" sysUser.department_id REGEXP '["+deptids+"]' ";
				parm2 +=" form.create_department_id REGEXP '["+deptids+"]' ";
			
		}
		else{
			parm = "  info.create_department_id = "+deptid+" ";
			parm1=" sysUser.department_id = "+deptid+" ";
			parm2=" form.create_department_id = "+deptid+"  ";
		}
		// 储备金 为 已立项的项目的合同额 除去 已申请合同结算表项目的合同额（合同登记表中的项目合同额）  中标金额 指的是中标结果为中标项目的合同额   合同额 指签订合同的项目的合同额
		//proj_state 项目状态 1 为已立项 6为签合同  5为投标结果
		String sql = " SELECT A.ALLCHUBEIMONEY,B.CHUBEIMONEY,	C.ALLZHONGBIAOMONEY,	D.ZHONGBIAOMONEY,	E.ALLHETONGMONEY,	F.HETONGMONEY,G.ALLHUIKUANMONEY,H.HUIKUANMONEY,J.ALLBAOXIAOMONEY,K.BAOXIAOMONEY FROM " +
				" (SELECT SUM(PREDICT_CONTRACT_MONEY) ALLCHUBEIMONEY FROM FLXOA_PROJECT_INFORMATION INFO WHERE PROJ_STATE IN (1,2,3,4)  AND ("+parm+") AND DELETE_FLAG = '0' AND INFO.CREATE_TIME >='"+getCurrYearFirst+"') A, " +
				" (SELECT SUM(PREDICT_CONTRACT_MONEY) CHUBEIMONEY FROM FLXOA_PROJECT_INFORMATION INFO WHERE PROJ_STATE IN (1,2,3,4) AND ("+parm+") AND DELETE_FLAG = '0' AND INFO.CREATE_TIME >= '"+getMonthFirst+"' ) B, " +
				" (SELECT SUM(PREDICT_CONTRACT_MONEY) ALLZHONGBIAOMONEY FROM	FLXOA_PROJECT_INFORMATION INFO LEFT JOIN FLXOA_PROJECT_BID_INFORMATION BID ON INFO.ID = BID.PROJECT_ID	WHERE	INFO.PROJ_STATE = '5' AND BID.BIDDING_RESULTS = '1'" +
				" AND ("+parm+") AND INFO.DELETE_FLAG = '0' AND BID.BIDDING_DATE >='"+getCurrYearFirst+"' ) C, " +
				" (SELECT SUM(PREDICT_CONTRACT_MONEY) ZHONGBIAOMONEY FROM	FLXOA_PROJECT_INFORMATION INFO LEFT JOIN FLXOA_PROJECT_BID_INFORMATION BID ON INFO.ID = BID.PROJECT_ID	WHERE	INFO.PROJ_STATE = '5' AND BID.BIDDING_RESULTS = '1' " +
				" AND ("+parm+") AND INFO.DELETE_FLAG = '0' AND BID.BIDDING_DATE >= '"+getMonthFirst+"'  ) D, " +
				" (SELECT SUM(CONTRACT_AMOUNT) ALLHETONGMONEY FROM FLXOA_CONTRACT_INFORMATION INFO WHERE "+parm+" AND DELETE_FLAG = '0' AND INFO.CREATE_TIME >='"+getCurrYearFirst+"') E, " +
				" (SELECT SUM(CONTRACT_AMOUNT) HETONGMONEY FROM FLXOA_CONTRACT_INFORMATION INFO WHERE "+parm+" AND DELETE_FLAG = '0' AND INFO.CREATE_TIME >= '"+getMonthFirst+"' ) F, " +
				" (SELECT SUM(CARO_MONEY) ALLHUIKUANMONEY FROM FLXOA_CASHCOLLECTION_RECORD INFO WHERE STATUS IN (1,3) AND  " +
				" PROJECT_ID IN (SELECT INFO.ID FROM FLXOA_PROJECT_INFORMATION INFO	LEFT JOIN FLXOA_SYSTEM_USER SYSUSER ON INFO.CREATE_USER_ID = SYSUSER.ID	WHERE "+parm1+" ) AND DELETE_FLAG = '0'	AND CREATE_TIME >='"+getCurrYearFirst+"') G, " +
				" (SELECT SUM(CARO_MONEY) HUIKUANMONEY FROM FLXOA_CASHCOLLECTION_RECORD INFO WHERE STATUS IN (1,3) AND " +
				" PROJECT_ID IN (SELECT INFO.ID FROM FLXOA_PROJECT_INFORMATION INFO	LEFT JOIN FLXOA_SYSTEM_USER SYSUSER ON INFO.CREATE_USER_ID = SYSUSER.ID	WHERE "+parm1+" ) AND DELETE_FLAG = '0'	AND CREATE_TIME >='"+getMonthFirst+"') H, " +
				" (SELECT SUM(FORMDATA.DATA_VALUE) ALLBAOXIAOMONEY FROM FLXOA_APPROVE_FORMDATA FORMDATA LEFT JOIN FLXOA_APPROVE_FORM FORM ON FORMDATA.FORM_ID = FORM.ID WHERE FORM.TEMPLATE_ID = '48' AND FORM.SUBMIT_STATUS = '3' AND FORMDATA.DATA_KEY = 'REIM_MONEY_SUM' " +
				" AND FORM.DELETE_FLAG = '0' AND FORM.CREATE_TIME >='"+getCurrYearFirst+"' and ("+parm2+")  )J, " +
				" (SELECT SUM(FORMDATA.DATA_VALUE) BAOXIAOMONEY FROM FLXOA_APPROVE_FORMDATA FORMDATA LEFT JOIN FLXOA_APPROVE_FORM FORM ON FORMDATA.FORM_ID = FORM.ID WHERE FORM.TEMPLATE_ID = '48' AND FORM.SUBMIT_STATUS = '3' AND FORMDATA.DATA_KEY = 'REIM_MONEY_SUM' " +
				"  AND FORM.DELETE_FLAG = '0' AND FORM.CREATE_TIME >='"+getMonthFirst+"' and ("+parm2+") ) K " ;
		
		
		List<Object> list=querySQL(sql,null);
		
		
		List<Map<String,Object>> mapList=new ArrayList<Map<String,Object>>();
		for(int i=0;i<list.size();i++){
			Map<String,Object> map=new HashMap<String,Object>();
			Object[] listValue= (Object[]) list.get(i);
			map.put("allChuBeiMoney", CommonUtils.returnStr(listValue[0]));
			map.put("chuBeiMoney", CommonUtils.returnStr(listValue[1]));
			map.put("allZhongBiaoMoney", CommonUtils.returnStr(listValue[2]));
			map.put("zhongBiaoMoney", CommonUtils.returnStr(listValue[3]));
			map.put("allHeTongMoney", CommonUtils.returnStr(listValue[4]));
			map.put("heTongMoney",CommonUtils.returnStr( listValue[5]));
			map.put("allHuiKuanMoney", CommonUtils.returnStr(listValue[6]));
			map.put("huiKuanMoney", CommonUtils.returnStr(listValue[7]));
			map.put("allBaoXiaoMoney", CommonUtils.returnStr(listValue[8]));
			map.put("baoXiaoMoney", CommonUtils.returnStr(listValue[9]));
			mapList.add(map);
		}
		return mapList;
	}

	@Override
	protected Class<FlxoaProjectInformation> getEntityClass() {
		return FlxoaProjectInformation.class;
	}
	//申请表审核中、待审核的记录
	@Override
	public String  queryFormNoApproval(int start,int length,String draw,String userid) {	
			//查询hql语句
			String hql=" FROM flxoa_approve_form form LEFT JOIN flxoa_approve_formtemplate formtem ON formtem.id=form.template_id " +
					" WHERE form.create_user_id= "+userid+" AND form.delete_flag='0' AND form.submit_status IN ('1','2') ";

			
			hql+=" ORDER BY form.create_time  DESC  ";
			//查询参数
			String querySql="SELECT form.create_user_id,formtem.name as fname,form.submit_status as submit_status, form.create_time as applytime "+hql;

			//求和查询sql
			String countSql="select count(*) "+hql;

			List list= queryListForPageBySQL(start, length, querySql);
			List<Map<String,String>> dataList=new ArrayList<Map<String,String>>();
			List<Map<String,String>> otherDataList=new ArrayList<Map<String,String>>();

			for(int i=0;i<list.size();i++){
				Map<String,String> map=new HashMap<String,String>();
				Object[] obj=(Object[]) list.get(i);
				map.put("userid", String.valueOf(obj[0]));
				map.put("fname", String.valueOf(obj[1]));
				map.put("submitstatus", String.valueOf(obj[2]));
				map.put("applytime", String.valueOf(obj[2]));			
				dataList.add(map);
			}
			Long totalCount= countBySql(countSql,null);
			
			return CommonUtils.getPageJson(start,length,draw,totalCount,dataList,otherDataList);
	}
	/**
	 * 我的项目
	 */
	public String queryMyProject(int start,int length,String draw,String userid){
		  //查询hql语句
		  String hql=" FROM (SELECT info.proj_name,flxoa_system_enumeration.enumeration_value as state,info.id AS projId  FROM " +
		    " flxoa_project_information info LEFT JOIN flxoa_system_enumeration ON enumeration_key = proj_state  WHERE info.create_user_id = "+userid+"  AND " +
		    "flxoa_system_enumeration.enumeration_name ='proj_state' AND info.delete_flag='0') as A LEFT JOIN flxoa_project_focus focus on A.projId = focus.project_id " ;

		 String querySql=" SELECT A.proj_name,A.state,A.projId,focus.flag   "+hql;
		  //求和查询sql
		  String countSql="select count(*) "+hql;
		  
		  List<Object> list= queryListForPageBySQL(start, length, querySql);
		  List<Map<String,String>> dataList=new ArrayList<Map<String,String>>();
		  List<Map<String,String>> otherDataList=new ArrayList<Map<String,String>>();
		  
		  for(int i=0;i<list.size();i++){
		   Map<String,String> map=new HashMap<String,String>();
		   Object[] obj=(Object[]) list.get(i);
		   map.put("projname", String.valueOf(obj[0]));
		   map.put("projstate", String.valueOf(obj[1]));
		   map.put("projId", String.valueOf(obj[2]));
		   map.put("flag", String.valueOf(obj[3]));
		   dataList.add(map);
		  }
		Long totalCount= countBySql(countSql,null);
		
		return CommonUtils.getPageJson(start,length,draw,totalCount,dataList,otherDataList);
	}
	/**
	 * 统计个人的考勤情况（迟到、异常、正常等次数）
	 */
	@Override
	public List<Map<String, Object>> querySumPerson(int userid) {
		String  sql ="   SELECT flxoa_system_user.real_name , flxoa_attendance_summary.create_user_id ,sign_status, COUNT(*) as cishu FROM flxoa_attendance_summary " +
				" LEFT JOIN flxoa_system_user ON flxoa_attendance_summary.create_user_id=flxoa_system_user.id  where flxoa_system_user.delete_flag = '0' and   flxoa_attendance_summary.create_user_id= "+userid+"  GROUP BY sign_status  ";
		
		List<Object> list=querySQL(sql,null);
		List<Map<String,Object>> mapList=new ArrayList<Map<String,Object>>();
		for(int i=0;i<list.size();i++){
			Map<String,Object> map=new HashMap<String,Object>();
			Object[] listValue= (Object[]) list.get(i);
			map.put("real_name", listValue[0].toString());
			map.put("create_user_id", listValue[1].toString());
			map.put("sign_status", listValue[2].toString());
			map.put("cishu", listValue[3].toString());
			mapList.add(map);
		}
		return mapList;
		
	}
	/**
	 * 首页我的考勤情况
	 */
	public String  queryPersonSign(int start,int length,String draw,String userid) {	
		//查询hql语句
		String hql=" from (SELECT flxoa_attendance_summary.id,flxoa_attendance_summary.sign_status, flxoa_attendance_summary.sign_data," +
				"flxoa_system_user.create_user_id, flxoa_system_user.real_name,flxoa_attendance_summary.create_department_id,enumeration_value as state " +
				" FROM flxoa_attendance_summary LEFT JOIN flxoa_system_user ON flxoa_attendance_summary.create_user_id = flxoa_system_user.id LEFT JOIN " +
				"flxoa_system_enumeration ON flxoa_attendance_summary.sign_status = flxoa_system_enumeration.enumeration_key WHERE	flxoa_system_user.delete_flag = '0' " +
				"AND flxoa_attendance_summary.create_user_id = "+userid+" and flxoa_system_enumeration.enumeration_name = 'sign_status' " +
				" and flxoa_attendance_summary.sign_data>="+getMonthFirst+" AND flxoa_attendance_summary.sign_status IN (1,5,7)  ) as A";// 
		//AND flxoa_attendance_summary.sign_status IN (1,5,7) -- 迟到、请假、打卡异常
		//求和查询sql   
		String countSql="select count(*) "+hql;
		
		hql+=" GROUP BY A.state  ";
		//查询参数
		String querySql=" SELECT A.state,count(*) "+hql;
		String sql="SELECT	B.state,COUNT(*) FROM ( SELECT DISTINCT(sign_date),	flxoa_system_enumeration.enumeration_value AS state	FROM flxoa_attendance_signdetails " +
				" LEFT JOIN flxoa_system_enumeration ON flxoa_attendance_signdetails.sign_type = flxoa_system_enumeration.enumeration_key " +
				" WHERE flxoa_attendance_signdetails.create_user_id = "+userid+" AND flxoa_system_enumeration.enumeration_name = 'sign_type'" +
				" AND flxoa_attendance_signdetails.sign_date >= "+getMonthFirst+" AND flxoa_attendance_signdetails.sign_type in (3,4) ) AS B GROUP BY  state " ;//

		List list= queryListForPageBySQL(start, length, querySql);
		
		List<Object> list2 = querySQL(sql,null);
		List<Map<String,String>> returnList=new ArrayList<Map<String,String>>();
		List<Map<String,String>> dataList=new ArrayList<Map<String,String>>();
		List<Map<String,String>> dataList2=new ArrayList<Map<String,String>>();

		List<Map<String,String>> otherDataList=new ArrayList<Map<String,String>>();

		for(int i=0;i<list.size();i++){
			Map<String,String> map=new HashMap<String,String>();
			Object[] obj=(Object[]) list.get(i);			
			map.put("name", String.valueOf(obj[0]));
			map.put("value", String.valueOf(obj[1]));			
			dataList.add(map);
		}
		for(int i=0;i<list2.size();i++){
			Map<String,String> map2=new HashMap<String,String>();
			Object[] obj2=(Object[]) list2.get(i);
			map2.put("name", String.valueOf(obj2[0]));
			map2.put("value", String.valueOf(obj2[1]));			
			dataList2.add(map2);
		}
		returnList.addAll(dataList);
		returnList.addAll(dataList2);
		Long totalCount= countBySql(countSql,null);
		
		return CommonUtils.getPageJson(start,length,draw,totalCount,returnList,otherDataList);
}
	/**
	 * 部门统计考勤
	 */
	@Override
	public String querySumDept(int start,int length,String draw,String deptid) {
		//判断是否是一个部门
		String parm = " flxoa_attendance_summary.create_department_id ";//部门条件	
		String [] deptids= deptid.split(",");
		if(deptid.indexOf(",") >= 0){
				parm += "  REGEXP '["+deptids+"]' ";				
		}
		else{
			parm = "  flxoa_attendance_summary.create_department_id = "+deptid+" ";			
		}
		//查询hql语句
		String hql=" FROM (SELECT flxoa_system_department.name as dname ,flxoa_attendance_summary.create_department_id as deptid,sign_status,COUNT(*) AS cishu FROM flxoa_attendance_summary LEFT JOIN flxoa_system_department" +
				" ON flxoa_attendance_summary.create_department_id= flxoa_system_department.id  WHERE flxoa_attendance_summary.delete_flag = '0' AND ("+parm+")	GROUP BY flxoa_attendance_summary.create_department_id,	sign_status) as A ";

		
		//查询参数
		String querySql=" SELECT a.dname,a.deptid,a.sign_status,a.cishu "+hql;

		//求和查询sql
		String countSql="select count(*) "+hql;

		List list= queryListForPageBySQL(start, length, querySql);
		List<Map<String,String>> dataList=new ArrayList<Map<String,String>>();
		List<Map<String,String>> otherDataList=new ArrayList<Map<String,String>>();

		for(int i=0;i<list.size();i++){
			Map<String,String> map=new HashMap<String,String>();
			Object[] obj=(Object[]) list.get(i);
			map.put("dname", String.valueOf(obj[0]));
			map.put("deptid", String.valueOf(obj[1]));	
			map.put("sign_status", String.valueOf(obj[2]));	
			map.put("cishu", String.valueOf(obj[3]));
			dataList.add(map);
		}
		Long totalCount= countBySql(countSql,null);
		
		return CommonUtils.getPageJson(start,length,draw,totalCount,dataList,otherDataList);
	}
	/**
	 * 我的关注项目
	 */
	@Override
	public String queryMyFocusProject(int start, int length, String draw,String userid) {
		//查询hql语句
		String hql="  from flxoa_project_focus  focus LEFT JOIN flxoa_project_information info ON focus.project_id= info.id LEFT JOIN flxoa_system_enumeration ON " +
				"enumeration_key = info.proj_state where  focus.create_user_id = "+userid+" AND flxoa_system_enumeration.enumeration_name ='proj_state' AND info.DELETE_flag = '0'  ";
		
		//查询参数
		String querySql=" SELECT  info.proj_name,flxoa_system_enumeration.enumeration_value,info.id,focus.id as fId  "+hql;
		//求和查询sql
		String countSql="select count(*) "+hql;
		List list= queryListForPageBySQL(start, length, querySql);
		List<Map<String,String>> dataList=new ArrayList<Map<String,String>>();
		List<Map<String,String>> otherDataList=new ArrayList<Map<String,String>>();

		for(int i=0;i<list.size();i++){
			Map<String,String> map=new HashMap<String,String>();
			Object[] obj=(Object[]) list.get(i);
			map.put("projname", String.valueOf(obj[0]));
			map.put("projstate", String.valueOf(obj[1]));
			map.put("projId", String.valueOf(obj[2]));
			map.put("fId", String.valueOf(obj[3]));
			dataList.add(map);
		}
		Long totalCount= countBySql(countSql,null);
		
		return CommonUtils.getPageJson(start,length,draw,totalCount,dataList,otherDataList);
	}
	/*
	 * 统计各部门的回款情况，首页柱形图
	 */
	@Override
	public List<Map<String, Object>> queryHuiKuan(String name,String deptid) {
		//判断是否是一个部门
		String parm = "";//部门条件	
		String [] deptids= deptid.split(",");
		if(deptid.indexOf(",") >= 0){
			 parm += " A.DEPTID REGEXP '["+deptids+"]' ";
		}else{
			parm = "  A.DEPTID = "+deptid+" ";			
		}
		String sql = " SELECT M.enumeration_value,HE FROM (SELECT YEAR(TT),MONTH(TT) AS MOUTH,SUM(CARO_MONEY) AS HE FROM ( " +
				" SELECT FLXOA_SYSTEM_DEPARTMENT.NAME,RECORD.UPDATE_DEPARTMENT_ID AS DEPTID,FLXOA_SYSTEM_DEPARTMENT.PARENT_ID PID," +
				"FLXOA_SYSTEM_DEPARTMENT.ORGANIZATION_TYPE TYPE,CARO_MONEY,DATE_FORMAT(FROM_UNIXTIME(RECORD.CREATE_TIME),'%Y-%m-%d') AS TT FROM " +
				"  FLXOA_CASHCOLLECTION_RECORD RECORD   LEFT JOIN FLXOA_SYSTEM_DEPARTMENT ON FLXOA_SYSTEM_DEPARTMENT.ID= RECORD.UPDATE_DEPARTMENT_ID WHERE STATUS='3'  " +
				") A WHERE  DATE_FORMAT(TT, '%Y')=(SELECT YEAR(NOW())) AND ( "+parm+" )  GROUP BY DATE_FORMAT(TT, '%Y-%m') ) AS B RIGHT JOIN " +
				" (SELECT enumeration_key,enumeration_value FROM flxoa_system_enumeration WHERE enumeration_name ='months'" +
				") AS M ON B.MOUTH=M.enumeration_key  ORDER BY CAST(M.enumeration_key AS DECIMAL) DESC " ;
		
		
		List<Object> list=querySQL(sql,null);	
		
		List<Map<String,Object>> mapList=new ArrayList<Map<String,Object>>();
		for(int i=0;i<list.size();i++){
			Map<String,Object> map = new HashMap<String,Object>();
			Object[] listValue= (Object[]) list.get(i);
			map.put("name", name);
			map.put("months", CommonUtils.returnStr(listValue[0]));
			if(CommonUtils.isEmpty(CommonUtils.returnStr(listValue[1]))){
				map.put("sun",0);
			}else{
				map.put("sun", CommonUtils.returnStr(listValue[1]));
			}
					
			mapList.add(map);
		}
		return mapList;
	}	
}

