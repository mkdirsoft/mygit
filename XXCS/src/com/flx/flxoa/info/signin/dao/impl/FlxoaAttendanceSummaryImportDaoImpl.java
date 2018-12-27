package com.flx.flxoa.info.signin.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.flx.flxoa.common.hibernate3.HibernateBaseDao;
import com.flx.flxoa.common.util.DateUtils;
import com.flx.flxoa.info.approve.entity.FlxoaApproveForm;
import com.flx.flxoa.info.signin.dao.FlxoaAttendanceSummaryImportDao;
import com.flx.flxoa.info.signin.entity.FlxoaAttendanceSigndetails;

/**
 * 类名称：FlxoaAttendanceSummaryImportDaoImpl.java
 * 类描述：考勤汇总数据库导入数据处理层
 * 创建时间：2018-3-22, 上午10:05:43
 * 
 * @version 1.0 
 * @since JDK版本 1.7
 * @author 张海英
 */
@Repository
public class FlxoaAttendanceSummaryImportDaoImpl extends HibernateBaseDao<FlxoaAttendanceSigndetails, Integer> implements
		FlxoaAttendanceSummaryImportDao {

	/*
	 * 查询签到详情表中的数据的最早签到记录
	 * (non-Javadoc)
	 * @see com.flx.flxoa.info.signin.dao.FlxoaAttendanceSummaryImportDao#querySignDetails()
	 */
	public List<FlxoaAttendanceSigndetails> querySignDetailsEarliest() {
		//获取前一天的开始时间
		int preStartTime =DateUtils.getPreStartTime();
		//获取前一天的结束时间
		int preEndTime =DateUtils.getPreEndTime();
		String sql="SELECT 	min(id),sign_time,sign_type,commens,sign_locale,B.create_user_id,create_department_id FROM	flxoa_attendance_signdetails B," +
				"	(SELECT create_user_id,min(sign_time) AS signTime	FROM flxoa_attendance_signdetails	WHERE	sign_time > '"+preStartTime+"'	AND sign_time < '"+preEndTime+"'	GROUP BY create_user_id	) A WHERE	" +
				"B.create_user_id = A.create_user_id and B.sign_time=A.signTime group by sign_time ,sign_type,commens,sign_locale,B.create_user_id,create_department_id ORDER BY B.create_user_id";
		//and B.create_user_id=5183  测试某个人的考勤导入
		List<Object> list= querySQL2(sql);
		List<FlxoaAttendanceSigndetails> signdetailsList= new ArrayList<FlxoaAttendanceSigndetails>();
		for(int i=0;i<list.size();i++){
			FlxoaAttendanceSigndetails flxoaAttendanceSigndetails=new FlxoaAttendanceSigndetails();
			 Object[] tempObj = (Object[]) list.get(i);
			 flxoaAttendanceSigndetails.setId(Integer.valueOf(tempObj[0].toString()));
			 //最早签到时间
			 flxoaAttendanceSigndetails.setSignTime(Integer.valueOf(tempObj[1].toString()));
			 //最早签到类型
			 flxoaAttendanceSigndetails.setSignType(tempObj[2].toString());
			 //最早签到备注
			 flxoaAttendanceSigndetails.setCommens(tempObj[3].toString());
			 //最早签到地点
			 flxoaAttendanceSigndetails.setSignLocale(tempObj[4].toString());
			 //最早创建人id
			 flxoaAttendanceSigndetails.setCreateUserId(Integer.valueOf(tempObj[5].toString()));
			 //最早签到部门id
			 flxoaAttendanceSigndetails.setCreateDepartmentId(Integer.valueOf(tempObj[6].toString()));
			 signdetailsList.add(flxoaAttendanceSigndetails);
		}
		return signdetailsList;
	}
	/*
	 * 查询签到详情表中的数据的最晚签到记录
	 * (non-Javadoc)
	 * @see com.flx.flxoa.info.signin.dao.FlxoaAttendanceSummaryImportDao#querySignDetails2()
	 */
	public List<FlxoaAttendanceSigndetails> querySignDetailsLatest() {
		//获取前一天的开始时间
		int preStartTime =DateUtils.getPreStartTime();
		//获取前一天的结束时间
		int preEndTime =DateUtils.getPreEndTime();
		String sql="SELECT 	max(id),sign_time,sign_type,commens,sign_locale,B.create_user_id,create_department_id FROM	flxoa_attendance_signdetails B," +
				"	(	SELECT create_user_id,max(sign_time) AS signTime	FROM flxoa_attendance_signdetails	WHERE	sign_time > '"+preStartTime+"'	AND sign_time < '"+preEndTime+"' " +
				"GROUP BY create_user_id	) A WHERE	B.create_user_id = A.create_user_id and B.sign_time=A.signTime group by sign_time ,sign_type,commens,sign_locale,B.create_user_id,create_department_id ORDER BY B.create_user_id";
		//AND B.create_user_id=5183  测试某个人的考勤导入
		List<Object> list= querySQL2(sql);
		List<FlxoaAttendanceSigndetails> signdetailsList= new ArrayList<FlxoaAttendanceSigndetails>();
		for(int i=0;i<list.size();i++){
			FlxoaAttendanceSigndetails flxoaAttendanceSigndetails=new FlxoaAttendanceSigndetails();
			 Object[] tempObj = (Object[]) list.get(i);
			 flxoaAttendanceSigndetails.setId(Integer.valueOf(tempObj[0].toString()));
			//最晚签到时间
			 flxoaAttendanceSigndetails.setSignTime(Integer.valueOf(tempObj[1].toString()));
			 //最晚签到类型
			 flxoaAttendanceSigndetails.setSignType(tempObj[2].toString());
			 //最晚签到备注
			 flxoaAttendanceSigndetails.setCommens(tempObj[3].toString());
			 //最晚签到地点
			 flxoaAttendanceSigndetails.setSignLocale(tempObj[4].toString());
			 //最晚签到创建人id
			 flxoaAttendanceSigndetails.setCreateUserId(Integer.valueOf(tempObj[5].toString()));
			 //最晚签到部门id
			 flxoaAttendanceSigndetails.setCreateDepartmentId(Integer.valueOf(tempObj[6].toString()));
			 signdetailsList.add(flxoaAttendanceSigndetails);
		}
		return signdetailsList;
	}
	
	

	@Override
	protected Class<FlxoaAttendanceSigndetails> getEntityClass() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
}
