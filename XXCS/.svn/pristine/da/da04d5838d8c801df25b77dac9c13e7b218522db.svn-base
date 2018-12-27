package com.flx.flxoa.info.signin.dao.impl;


import java.util.ArrayList;
import java.util.List;
import com.flx.flxoa.info.signin.entity.FlxoaAttendanceSigndetails;
import com.flx.flxoa.info.signin.dao.FlxoaAttendanceSigndetailsDao;
import org.springframework.stereotype.Repository;
import com.flx.flxoa.common.hibernate3.HibernateBaseDao;
import com.flx.flxoa.common.util.CommonUtils;

/**
 *
 * 类名称：FlxoaAttendanceSigndetailsDaoImpl.java
 * 类描述：
 * 创建时间：2018-03-16, 下午02:52:37
 *
 * @version 1.0 
 * @since JDK版本1.7 
 * @author 张海英 
 */ 
@Repository
public class FlxoaAttendanceSigndetailsDaoImpl extends HibernateBaseDao<FlxoaAttendanceSigndetails, Integer> implements FlxoaAttendanceSigndetailsDao {
	/**
	 *添加FlxoaAttendanceSigndetails
	 */ 
	public boolean add(FlxoaAttendanceSigndetails flxoaAttendanceSigndetails) {
		return save(flxoaAttendanceSigndetails);
	}
	/**
	 *删除FlxoaAttendanceSigndetails
	 */ 
	public boolean delete(FlxoaAttendanceSigndetails flxoaAttendanceSigndetails) {
		flxoaAttendanceSigndetails.setDeleteFlag("1");
		return save(flxoaAttendanceSigndetails);
	}
	/**
	 *修改FlxoaAttendanceSigndetails
	 */ 
	public boolean update(FlxoaAttendanceSigndetails flxoaAttendanceSigndetails) {
		return modify(flxoaAttendanceSigndetails);
	}
	/**
	 *查询FlxoaAttendanceSigndetails列表
	 */ 
	public List<FlxoaAttendanceSigndetails> query(FlxoaAttendanceSigndetails flxoaAttendanceSigndetails) {
		String hql = " from FlxoaAttendanceSigndetails where delete_flag = '0' ";
		return getListByHQL(hql, null);
	}
	/**
	 *查询FlxoaAttendanceSigndetails ByID
	 */ 
	public FlxoaAttendanceSigndetails queryById(FlxoaAttendanceSigndetails flxoaAttendanceSigndetails) {
		return get(flxoaAttendanceSigndetails.getId());
	}
	/**
	 * 查询今天的手机签到记录
	 */
	public List<FlxoaAttendanceSigndetails> queryTodayRecord(String userIds,int morningTime){
		String sql = "SELECT flxoa_system_user.id,flxoa_system_user.user_name,flxoa_system_user.real_name,flxoa_system_user.card_id,min(sign_time) maxTime,	max(sign_time) minTime FROM	flxoa_attendance_signdetails LEFT JOIN flxoa_system_user ON flxoa_attendance_signdetails.create_user_id = flxoa_system_user.id" +
				" where flxoa_system_user.status='0'  and sign_time>"+morningTime+"   " ;		
		
		String [] userids=userIds.split(",");
		String parm = " flxoa_attendance_signdetails.create_user_id ";//人员条件	
		if(userIds.indexOf(",") >= 0){					
			parm+=" REGEXP '["+userIds+"]' ";
		}
		else{
			parm = " flxoa_attendance_signdetails.create_user_id = "+userIds+" ";			
		}
		sql+=" AND ("+parm+")  ";		
		sql+=" GROUP BY flxoa_system_user.id ";
		return querySQL(sql,null);
	}
	
	@Override
	protected Class<FlxoaAttendanceSigndetails> getEntityClass() {
		return FlxoaAttendanceSigndetails.class;
	}
	/**
	 * 查询签到明细
	 */
	@Override
	public List<FlxoaAttendanceSigndetails> querySignDetail(FlxoaAttendanceSigndetails flxoaAttendanceSigndetails) {
		String sql ="SELECT A.id, B.id as userid,B.real_name,c.name as dname,sign_date,sign_time,sign_type,commens,sign_locale FROM flxoa_attendance_signdetails A" +
				" LEFT JOIN flxoa_system_user B on A.create_user_id=B.id LEFT JOIN flxoa_system_department C ON A.create_department_id = C.id  " +
				" WHERE B.status='0' and  A.create_user_id ="+flxoaAttendanceSigndetails.getCreateUserId() +"   and A.sign_date = "+flxoaAttendanceSigndetails.getSignDate()+" order by sign_time desc";
		List<Object> list= querySQL(sql);
		List<FlxoaAttendanceSigndetails> signdetailsList= new ArrayList<FlxoaAttendanceSigndetails>();
		for(int i=0;i<list.size();i++){
			FlxoaAttendanceSigndetails signdetails=new FlxoaAttendanceSigndetails();
			 Object[] tempObj = (Object[]) list.get(i);
			 signdetails.setId(CommonUtils.returnInt(tempObj[0]));
			 //签到创建人id
			 signdetails.setCreateUserId(CommonUtils.returnInt(tempObj[1]));
			 //签到人real_name
			 signdetails.setRealname(CommonUtils.returnStr(tempObj[2]));
			 //所在部门
			 signdetails.setDname(CommonUtils.returnStr(tempObj[3]));
			 //签到日期
			 signdetails.setSignDate(CommonUtils.returnInt(tempObj[4]));
			 //签到时间
			 signdetails.setSignTime(CommonUtils.returnInt(tempObj[5]));
			 //签到类型
			 signdetails.setSignType(CommonUtils.returnStr(tempObj[6]));
			 //签到备注
			 signdetails.setCommens(CommonUtils.returnStr(tempObj[7]));
			 //签到地点
			 signdetails.setSignLocale(CommonUtils.returnStr(tempObj[8]));
			 
			 signdetailsList.add(signdetails);
		}
		return signdetailsList;
	} 

}