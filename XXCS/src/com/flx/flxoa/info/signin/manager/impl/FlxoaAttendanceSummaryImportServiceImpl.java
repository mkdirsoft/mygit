package com.flx.flxoa.info.signin.manager.impl;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.persistence.criteria.CriteriaBuilder.In;

import org.hibernate.mapping.Array;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.flx.flxoa.common.util.DateUtils;
import com.flx.flxoa.info.approve.dao.FlxoaApproveFormDao;
import com.flx.flxoa.info.signin.dao.FlxoaAttendanceHolidaysetDao;
import com.flx.flxoa.info.signin.dao.FlxoaAttendanceSpecialtimesetDao;
import com.flx.flxoa.info.signin.dao.FlxoaAttendanceSummaryDao;
import com.flx.flxoa.info.signin.dao.FlxoaAttendanceSummaryImportDao;
import com.flx.flxoa.info.signin.entity.FlxoaAttendanceHolidayset;
import com.flx.flxoa.info.signin.entity.FlxoaAttendanceSigndetails;
import com.flx.flxoa.info.signin.entity.FlxoaAttendanceSpecialtimeset;
import com.flx.flxoa.info.signin.entity.FlxoaAttendanceSummary;
import com.flx.flxoa.info.signin.manager.FlxoaAttendanceSummaryImportService;
import com.flx.flxoa.info.system.dao.FlxoaSystemUserDao;
import com.flx.flxoa.info.system.entity.FlxoaSystemUser;

/**
 * 类名称：FlxoaAttendanceSummaryImportServiceImpl.java
 * 类描述：考勤汇总数据库导入业务处理层(在flxoa_attendance_summary表中导入数据)
 * 创建时间：2018-3-22, 上午10:09:08
 * 
 * @version 1.0 
 * @since JDK版本 1.7
 * @author 张海英
 */
@Service
@Transactional
public class FlxoaAttendanceSummaryImportServiceImpl implements
		FlxoaAttendanceSummaryImportService {
	private FlxoaAttendanceSummaryImportDao dao;
	private FlxoaAttendanceSummaryDao summaryDao;
	private FlxoaAttendanceHolidaysetDao holidaysetDao;
	private FlxoaAttendanceSpecialtimesetDao specialtimesetDao;
	private FlxoaSystemUserDao flxoaSystemUserDao;
	private FlxoaApproveFormDao flxoaApproveFormDao;

	@Autowired
	public void setDao(FlxoaAttendanceSummaryImportDao dao) {
		this.dao = dao;
	}

	public FlxoaAttendanceSummaryImportDao getDao() {
		return dao;
	}
	
	public FlxoaAttendanceSummaryDao getSummaryDao() {
		return summaryDao;
	}
	@Autowired
	public void setSummaryDao(FlxoaAttendanceSummaryDao summaryDao) {
		this.summaryDao = summaryDao;
	}
	
	public FlxoaAttendanceHolidaysetDao getHolidaysetDao() {
		return holidaysetDao;
	}
	@Autowired
	public void setHolidaysetDao(FlxoaAttendanceHolidaysetDao holidaysetDao) {
		this.holidaysetDao = holidaysetDao;
	}

	public FlxoaAttendanceSpecialtimesetDao getSpecialtimesetDao() {
		return specialtimesetDao;
	}
	@Autowired
	public void setSpecialtimesetDao(
			FlxoaAttendanceSpecialtimesetDao specialtimesetDao) {
		this.specialtimesetDao = specialtimesetDao;
	}
	@Autowired
	public void setFlxoaSystemUserDao(FlxoaSystemUserDao flxoaSystemUserDao) {
		this.flxoaSystemUserDao = flxoaSystemUserDao;
	}
	public FlxoaApproveFormDao getFlxoaApproveFormDao() {
		return flxoaApproveFormDao;
	}
	@Autowired
	public void setFlxoaApproveFormDao(FlxoaApproveFormDao flxoaApproveFormDao) {
		this.flxoaApproveFormDao = flxoaApproveFormDao;
	}
	/*
	 * 考勤汇总数据导入
	 * (non-Javadoc)
	 * @see com.flx.flxoa.info.signin.manager.FlxoaAttendanceSummaryImportService#summaryImport()
	 */
	@Override
	public void summaryImport(){
		//获取人员表中的所有人员
		List<FlxoaSystemUser> userList=flxoaSystemUserDao.queryAllUser();
		//获取签到详情表中的数据的最早签到记录
		List<FlxoaAttendanceSigndetails> earlList = dao.querySignDetailsEarliest();
		//获取签到详情表中的数据的最晚签到记录
		List<FlxoaAttendanceSigndetails> lateList = dao.querySignDetailsLatest();
		//已经打卡的用户id
		List<Integer> userSignIds = new ArrayList<Integer>();
		//Map<Integer,Integer> userSignIds = new HashMap<Integer,Integer>();
		try {
			if(userList != null){
				//已打卡的用户插入数据库
				for(int i=0;i<earlList.size();i++){
					//获取最早签到时间
					int earlTime = earlList.get(i).getSignTime();
					//获取最早签到类型
					String earlSignType= earlList.get(i).getSignType();
					//获取最早签到备注
					String earlComments = earlList.get(i).getCommens();
					//获取最早签到地点
					String earlSignLocale = earlList.get(i).getSignLocale();
					//获取最早签到用户id
					int earlUserId = earlList.get(i).getCreateUserId();
					//签到人所属部门id
					int departmentId = earlList.get(i).getCreateDepartmentId();
					int lateSignTime =0;
					String lateSignType ="1";
					String lateComments = "";
					String lateSignLocale ="门禁卡刷卡";
					int lateUserId =0;
					for(int j=0;j<lateList.size();j++){
						//获取最晚签到用户id
						lateUserId = lateList.get(j).getCreateUserId();
						if(earlUserId == lateUserId){
							//获取最晚签到时间
							lateSignTime = lateList.get(j).getSignTime();
							//获取最晚签到类型
							lateSignType = lateList.get(j).getSignType();
							//获取最晚签到备注
							lateComments = lateList.get(j).getCommens();
							//获取最晚签到地点
							lateSignLocale = lateList.get(j).getSignLocale();
						}
					}
					//如果人员id等于签到详情表中创建人id时，插入状态为:0：正常 1：迟到   4：节假日加班 7：打卡异常8：早退9：迟到、早退	
					FlxoaAttendanceSummary flxoaAttendanceSummary = new FlxoaAttendanceSummary();
					boolean flag = false;
					for (int j = 0; j < userList.size(); j++) {
						if(userList.get(j).getId() == earlUserId || userList.get(j).getId() == lateUserId){
							userSignIds.add(userList.get(j).getId());
							//userSignIds.put(ids, userList.get(j).getId());
							flag = true;
						}
					}
					if(flag){
						//最早签到时间
						flxoaAttendanceSummary.setSignEarliestTime(earlTime);
						//最早签到类型
						flxoaAttendanceSummary.setSignEarliestType(earlSignType);
						//最早签到备注
						flxoaAttendanceSummary.setSignEarliestComments(earlComments);
						//最早签到地点
						flxoaAttendanceSummary.setSignEarliestAddress(earlSignLocale);
						//最晚签到时间
						flxoaAttendanceSummary.setSignLatestTime(lateSignTime);
						//最晚签到类型
						flxoaAttendanceSummary.setSignLatestType(lateSignType);
						//最晚签到备注
						flxoaAttendanceSummary.setSignLatestComments(lateComments);
						//最晚签到地点
						flxoaAttendanceSummary.setSignLatestAdress(lateSignLocale);
						//领导批注
						flxoaAttendanceSummary.setLeaderComments("");
						//领导备注时间
						flxoaAttendanceSummary.setCommetsTime(0);
						//创建时间与更新时间
						Date date = new Date();
						DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
						String time = format.format(date);
						flxoaAttendanceSummary.setCreateTime(DateUtils.getSecondTimestamp(DateUtils.parse(time,"yyyy-MM-dd HH:mm:ss")));
						flxoaAttendanceSummary.setUpdateTime(DateUtils.getSecondTimestamp(DateUtils.parse(time,"yyyy-MM-dd HH:mm:ss")));
						//删除标记,未删除（0）
						flxoaAttendanceSummary.setDeleteFlag("0");
						//创建userid
						flxoaAttendanceSummary.setCreateUserId(earlUserId);
						//更新人id
						flxoaAttendanceSummary.setUpdateUserId(earlUserId);
						//创建人所属部门id
						flxoaAttendanceSummary.setCreateDepartmentId(departmentId);
						//更新人所属部门id
						flxoaAttendanceSummary.setUpdateDepartmentId(departmentId);
						//签到日期
						String  signTime= DateUtils.timestampToDate(earlTime);
						Date d = DateUtils.parse(signTime);
						int signDateNew = DateUtils.getSecondTimestamp(d);
						System.out.println("签到日期时间戳："+signDateNew);
						flxoaAttendanceSummary.setSignData(signDateNew);
						//签到类型判断
						String dateNew = DateUtils.format(d);
						System.out.println("签到日期："+dateNew);
						//判断是否有特殊时间设定    主要针对特殊上班、下班时间的群体:0：个人1：部门 2：性别
						FlxoaSystemUser flxoaSystemUser = new FlxoaSystemUser();
						//flxoaSystemUser.setCreateUserId(earlUserId);
						flxoaSystemUser.setId(earlUserId);
						System.out.println("签到用户id:"+earlUserId);
						//FlxoaSystemUser flxoaSystemUsernew = flxoaSystemUserDao.queryByUserId(flxoaSystemUser);
						FlxoaSystemUser flxoaSystemUsernew = flxoaSystemUserDao.queryById(flxoaSystemUser);
						//获取该用户性别 性别:0：男 1：女
						String gender = flxoaSystemUsernew.getGender();
						List<String> statusList = new ArrayList<String>();
						statusList.add("0");//人员
						statusList.add("1");//部门
						statusList.add("2");//性别
						List<String> detailList = new ArrayList<String>();
						detailList.add(String.valueOf(earlUserId));//人员id
						detailList.add(String.valueOf(departmentId));//部门id
						if(gender.equals("0")){
							detailList.add("男");//性别 
						}else if(gender.equals("1")){
							detailList.add("女");//性别 
						}
						//调用特殊时间设置方法得出上下班时间
						String times = getTime(dateNew,statusList,detailList);
						String[] tempTime = times.split(",");
						//特殊时间点
						Calendar calendar = Calendar.getInstance();
						//上班时间
						String timeWork = tempTime[0];
						//比上班时间迟半小时
						Date dTimeBeLate = DateUtils.parse2(timeWork);
						calendar.setTime(dTimeBeLate);
						calendar.add(Calendar.MINUTE, 30);
						Date dtBeLate = calendar.getTime();
						String timeBeLate = DateUtils.format2(dtBeLate);
						System.out.println("比上班时间迟半小时的时间点："+timeBeLate);
						//下班时间
						String timeOffWork = tempTime[1];
						//比下班时间早半小时
						Date dTimeOffWork = DateUtils.parse2(timeOffWork);
						calendar.setTime(dTimeOffWork);
						calendar.add(Calendar.MINUTE, -30);
						Date dtOffWork = calendar.getTime();
						String timeLeaveEarly = DateUtils.format2(dtOffWork);
						System.out.println("比下班时间早半小时的时间点："+timeLeaveEarly);
						//将特殊时间点转换为时间戳
						//上班时间点
						int tWork = DateUtils.getSecondTimestamp(DateUtils.parse2(timeWork));//09:00:00
						//迟到时间点
						int tBeLate = DateUtils.getSecondTimestamp(DateUtils.parse2(timeBeLate));//09:30:00
						//下班时间点
						int tOffWork = DateUtils.getSecondTimestamp(DateUtils.parse2(timeOffWork));//如：18:00:00 或 17:00:00 等
						//早退时间点
						int tLeaveEarly = DateUtils.getSecondTimestamp(DateUtils.parse2(timeLeaveEarly));//如：17:30:00 或 16:30:00 等
						//获取签到日期
						FlxoaAttendanceHolidayset holiday = new FlxoaAttendanceHolidayset();
						holiday.setLegalHolidays(signDateNew);
						//holidayset.setLegalHolidays(12365489);
						//周末、节假日 有考勤记录的情况
						FlxoaAttendanceHolidayset flxoaAttendanceHolidayset = holidaysetDao.queryByLegalHolidays(holiday);
						//考勤状态标志有10种：0：正常 1：迟到  2：周末 3：节假日 4：节假日加班 5：请假 6：请假中7：打卡异常8：早退9：迟到、早退					
						if(flxoaAttendanceHolidayset != null){
							//类型：4：调休上班  0 周末 1 节假日 2 节假日加班
							//节假日设定表中，签到类型3表示节假日加班
							String type = flxoaAttendanceHolidayset.getTypes();
							if(type.equals("1") || type.equals("0")){
								flxoaAttendanceSummary.setSignStatus("4");
								System.out.println("节假日加班");
							}
						}						
						if(earlTime <= tWork && lateSignTime >= tOffWork){
							flxoaAttendanceSummary.setSignStatus("0");
						}
						else if((earlSignType.equals("3") && lateSignType.equals("4")) || (earlSignType.equals("4") && lateSignType.equals("3"))){
							//上午公出，下午出差 或上午出差 下午 公出 的情况
							flxoaAttendanceSummary.setSignStatus("0");
							System.out.println("正常");
						}
						else if((earlTime > tWork && earlTime <= tBeLate) && (lateSignTime >= tLeaveEarly && lateSignTime < tOffWork)){
							flxoaAttendanceSummary.setSignStatus("9");
							System.out.println("迟到、早退");
						}
						else if(earlSignType.equals("3") && lateSignTime >= tLeaveEarly && lateSignTime < tOffWork){
							flxoaAttendanceSummary.setSignStatus("8");//上午公出，下午早退
							System.out.println("早退");								
						}else if(earlSignType.equals("4") && lateSignTime >= tLeaveEarly && lateSignTime < tOffWork){
							flxoaAttendanceSummary.setSignStatus("8");//上午出差，下午公司打卡或手机签到，早退
							System.out.println("早退");
						}else if(earlSignType.equals("2") && lateSignTime >= tLeaveEarly && lateSignTime < tOffWork){
							flxoaAttendanceSummary.setSignStatus("8");//上午请假，下午早退							
						}else if(lateSignType.equals("2") && earlTime > tWork && earlTime <= tBeLate){
							flxoaAttendanceSummary.setSignStatus("1");//上午迟到，下午请假							
						}else if(lateSignTime >= tLeaveEarly && lateSignTime < tOffWork){
							flxoaAttendanceSummary.setSignStatus("8");//正常刷卡或手机打卡情况下判断早退
							System.out.println("早退");
						}else if(lateSignType.equals("3") && earlTime > tWork && earlTime <= tBeLate){
							flxoaAttendanceSummary.setSignStatus("1");//下午公出，上午迟到
							System.out.println("迟到");
						}else if(lateSignType.equals("4") && earlTime > tWork && earlTime <= tBeLate){
							flxoaAttendanceSummary.setSignStatus("1");//下午出差，上午公司打卡或手机签到，迟到
							System.out.println("迟到");
						}
						else if((earlTime > tWork && earlTime <= tBeLate)){//正常刷卡或手机打卡情况下判断迟到
							flxoaAttendanceSummary.setSignStatus("1");
							System.out.println("迟到");
						}						
						//根据 SignType 签到类型判断 是公出、出差还是打卡异常 3 公出 4出差 
						else{
							System.out.println("lateSignType=="+lateSignType);
							//最早打卡类型为公出，晚上为打卡或公出（一天公出，考勤为正常，上午公出，下午下班后打卡为正常，否则打卡异常）
							if((earlSignType.equals("3") && lateSignType.equals("3"))){								
								flxoaAttendanceSummary.setSignStatus("0");
								System.out.println("正常");
							}else if(earlSignType.equals("3") && lateSignTime >= tOffWork){
								flxoaAttendanceSummary.setSignStatus("0");
								System.out.println("正常");								
							}else if(lateSignType.equals("3") && earlTime <= tWork){
								flxoaAttendanceSummary.setSignStatus("0");								
								System.out.println("正常");
							}else if(earlSignType.equals("2") && lateSignType.equals("2") ){//正常上班的情况下，无记录								
								//类型：5：请假 6：请假中 
								//根据申请表类型（即请假申请表，form表中template_id=49）、用户id和前一天打卡日期查出这一天的考勤状态为请假或请假中
								//49表示申请表为请假申请表
								int templateId = 49;
								//int userIdss = 7;
								//根据用户id和表类型和时间查询请假记录
								List<Map<String,Object>> formList = flxoaApproveFormDao.queryLeaveRecord(earlUserId,templateId,signDateNew);
								Object value = null;
								if(formList != null){
									for(int s=0;s<formList.size();s++){
										Map<String,Object> formMap= formList.get(s);
										//遍历map
										if(formMap != null){
											Iterator iterator = formMap.keySet().iterator();
											 while(iterator.hasNext()){
												//获取key值
												String key = (String) iterator.next();
												//获取value值
												value = formMap.get(key);
												System.out.println("审核状态为："+value);
											 }
										}
									}
								}
								//判断value（即为提交状态：0未提交 1待审核 2审核中 3通过 4未通过）属于哪种状态
								if(value != null){
									if(value.equals("1") || value.equals("2")){
										//如果审核状态为0未提交 1待审核 2审核中，则考情状态为请假中
										flxoaAttendanceSummary.setSignStatus("6");
										System.out.println("请假中");
									}else if(value.equals("3")){
										//如果审核状态为3通过，则考情状态为请假
										flxoaAttendanceSummary.setSignStatus("5");
										System.out.println("请假");
									}else if(value.equals("0") || value.equals("4")){
										//如果审核状态为4未通过，则考情状态为打卡异常
										flxoaAttendanceSummary.setSignStatus("7");
										System.out.println("打卡异常");
									}
								}
								flxoaAttendanceSummary.setSignStatus("7");
								System.out.println("打卡异常");
							}
							else if(earlSignType.equals("4") && lateSignType.equals("4")){
								flxoaAttendanceSummary.setSignStatus("0");
								System.out.println("正常");
							}else if(earlSignType.equals("4") && lateSignTime >= tOffWork){
								flxoaAttendanceSummary.setSignStatus("0");
								System.out.println("正常");
							}else if(lateSignType.equals("4") && earlTime <= tWork){
								flxoaAttendanceSummary.setSignStatus("0");
								System.out.println("正常");
							}else{
								flxoaAttendanceSummary.setSignStatus("7");
								System.out.println("打卡异常");								
							}
						}
						System.out.println("上班日考情导入");
						//将数据导入汇总表
						summaryDao.add(flxoaAttendanceSummary);
					}
				}
				//未打卡的用户插入数据库
				for(int k=0;k<userList.size();k++ ){
					FlxoaAttendanceSummary flxoaAttendanceSummary2 = new FlxoaAttendanceSummary();
					//获取人员id
					int userIds = userList.get(k).getId();
					boolean temp = false;
					for (int m = 0; m < userSignIds.size(); m++) {
						if(userIds == userSignIds.get(m)){
							temp  = true;
						}
					}
					//插入数据库未打卡用户数据
					if(!temp){
						//如果人员id不等于签到详情表中创建人id时，插入状态为： 2：周末 3：节假日 5：请假 6：请假中  7:打卡异常
						//最早签到时间
						flxoaAttendanceSummary2.setSignEarliestTime(0);
						//最早签到类型
						flxoaAttendanceSummary2.setSignEarliestType("");
						//最早签到备注
						flxoaAttendanceSummary2.setSignEarliestComments("");
						//最早签到地点
						flxoaAttendanceSummary2.setSignEarliestAddress("");
						//最晚签到时间
						flxoaAttendanceSummary2.setSignLatestTime(0);
						//最晚签到类型
						flxoaAttendanceSummary2.setSignLatestType("");
						//最晚签到备注
						flxoaAttendanceSummary2.setSignLatestComments("");
						//最晚签到地点
						flxoaAttendanceSummary2.setSignLatestAdress("");
						//领导批注
						flxoaAttendanceSummary2.setLeaderComments("");
						//领导备注时间
						flxoaAttendanceSummary2.setCommetsTime(0);
						//创建时间与更新时间
						Date date = new Date();
						DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
						String time = format.format(date);
						flxoaAttendanceSummary2.setCreateTime(DateUtils.getSecondTimestamp(DateUtils.parse(time,"yyyy-MM-dd HH:mm:ss")));
						flxoaAttendanceSummary2.setUpdateTime(DateUtils.getSecondTimestamp(DateUtils.parse(time,"yyyy-MM-dd HH:mm:ss")));
						//删除标记,未删除（0）
						flxoaAttendanceSummary2.setDeleteFlag("0");
						//创建userid
						flxoaAttendanceSummary2.setCreateUserId(userIds);
						//更新人id
						flxoaAttendanceSummary2.setUpdateUserId(userIds);
						//创建人所属部门id
						flxoaAttendanceSummary2.setCreateDepartmentId(userList.get(k).getDepartmentId());
						//更新人所属部门id
						flxoaAttendanceSummary2.setUpdateDepartmentId(userList.get(k).getDepartmentId());
						//签到日期
						SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");  
				        Calendar calendar = Calendar.getInstance();  
				        calendar.setTime(date);  
				        calendar.add(Calendar.DAY_OF_MONTH, -1);  
				        date = calendar.getTime();  
				        System.out.println(sdf.format(date)); 
				        Date signdate =  DateUtils.parse(sdf.format(date));
				        //签到日期 取 9:00
				        int signDateNew = DateUtils.getSecondTimestamp(signdate);
						System.out.println("签到日期时间戳："+signDateNew);
						flxoaAttendanceSummary2.setSignData(signDateNew);
						//签到类型判断
						String dateNew = DateUtils.format(signdate);
						System.out.println("签到日期："+dateNew);
						//获取签到日期
						FlxoaAttendanceHolidayset holidayset = new FlxoaAttendanceHolidayset();
						holidayset.setLegalHolidays(signDateNew);
						//根据签到日期查询节假日设置记录
						FlxoaAttendanceHolidayset flxoaAttendanceHolidayset = holidaysetDao.queryByLegalHolidays(holidayset);
						if(flxoaAttendanceHolidayset != null){
							//类型：0：周末 1：节假日 
							String type = flxoaAttendanceHolidayset.getTypes();
							//节假日设定表中，签到类型0表示节周末
							if(type.equals("0")){
								flxoaAttendanceSummary2.setSignStatus("2");
								System.out.println("周末");
							//节假日设定表中，签到类型1表示节假日
							}else if(type.equals("1")){
								flxoaAttendanceSummary2.setSignStatus("3");
								System.out.println("节假日");
							}else if(type.equals("2")){//正常上班的情况下，无记录 节假日上班								
								//类型：5：请假 6：请假中 
								//根据申请表类型（即请假申请表，form表中template_id=49）、用户id和前一天打卡日期查出这一天的考勤状态为请假或请假中
								//49表示申请表为请假申请表
								int templateId = 49;
								//int userIdss = 7;
								//根据用户id和表类型和时间查询请假记录
								List<Map<String,Object>> formList = flxoaApproveFormDao.queryLeaveRecord(userIds,templateId,signDateNew);
								Object value = null;
								//如果 节假日 调休的 情况下 是否有请假 还是无故旷工‘打卡异常’
								if(formList.size()>0){
									for(int s=0;s<formList.size();s++){
										Map<String,Object> formMap= formList.get(s);
										//遍历map
										if(formMap != null){
											Iterator iterator = formMap.keySet().iterator();
											 while(iterator.hasNext()){
												//获取key值
												String key = (String) iterator.next();
												//获取value值
												value = formMap.get(key);
												System.out.println("审核状态为："+value);
											 }
										}
									}
									//判断value（即为提交状态：0未提交 1待审核 2审核中 3通过 4未通过）属于哪种状态
									if(value != null){
										if(value.equals("0") || value.equals("1") || value.equals("2")){
											//如果审核状态为0未提交 1待审核 2审核中，则考情状态为请假中
											flxoaAttendanceSummary2.setSignStatus("6");
											System.out.println("请假中");
										}else if(value.equals("3")){
											//如果审核状态为3通过，则考情状态为请假
											flxoaAttendanceSummary2.setSignStatus("5");
											System.out.println("请假");
										}else if(value.equals("4")){
											//如果审核状态为4未通过，则考情状态为打卡异常
											flxoaAttendanceSummary2.setSignStatus("7");
											System.out.println("打卡异常");
										}
									}
								}else{
									flxoaAttendanceSummary2.setSignStatus("7");
									System.out.println("打卡异常");								
								}
								
							}
							
						}else{
							//类型：5：请假 6：请假中 ，7：打卡异常
							//根据申请表类型（即请假申请表，form表中template_id=49）、用户id和前一天打卡日期查出这一天的考勤状态为请假或请假中
							//49表示申请表为请假申请表
							int templateId = 49;
							//int userIdss = 7;
							//根据用户id和表类型和时间查询请假记录
							List<Map<String,Object>> formList = flxoaApproveFormDao.queryLeaveRecord(userIds,templateId,signDateNew);
							Object value = null;
							if(formList.size()>0){
								for(int s=0;s<formList.size();s++){
									Map<String,Object> formMap= formList.get(s);
									//遍历map
									if(formMap != null){
										Iterator iterator = formMap.keySet().iterator();
										 while(iterator.hasNext()){
											//获取key值
											String key = (String) iterator.next();
											//获取value值
											value = formMap.get(key);
											System.out.println("审核状态为："+value);
										 }
									}
								}
								//判断value（即为提交状态：0未提交 1待审核 2审核中 3通过 4未通过）属于哪种状态
								if(value != null){
									if(value.equals("1") || value.equals("2")){
										//如果审核状态为0未提交 1待审核 2审核中，则考情状态为请假中
										flxoaAttendanceSummary2.setSignStatus("6");
										System.out.println("请假中");
									}else if(value.equals("3")){
										//如果审核状态为3通过，则考情状态为请假
										flxoaAttendanceSummary2.setSignStatus("5");
										System.out.println("请假");
									}else if(value.equals("0") || value.equals("4")){
										//如果审核状态为4未通过，则考情状态为打卡异常
										flxoaAttendanceSummary2.setSignStatus("7");
										System.out.println("打卡异常");
									}
								}
							}else{
								flxoaAttendanceSummary2.setSignStatus("7");
								System.out.println("打卡异常");
							}
						}
						System.out.println("周末、节假日、上班考勤导入");
						//将数据导入汇总表
						summaryDao.add(flxoaAttendanceSummary2);
					}
				}	
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
	/**
	 * 特殊时间设定
	 * @param dateNew
	 * @param statusList
	 * @param detailList
	 * @return
	 * @throws ParseException 
	 */
	private String getTime(String dateNew,List<String> statusList,List<String> detailList) throws ParseException{
		//上班时间
		String timeWork =dateNew + " 09:00:00";
		//下班时间
		String timeOffWork =dateNew + " 18:00:00";
		//签到日期
		Date d = DateUtils.parse(dateNew);
		int signDateNew = DateUtils.getSecondTimestamp(d);
		//判断是否有特殊时间设定，调用方法得出上下班时间
		List<FlxoaAttendanceSpecialtimeset> specialtimesetD = specialtimesetDao.queryToday(signDateNew, statusList, detailList);
		if(specialtimesetD != null){
			for(int i=0;i<specialtimesetD.size();i++){
				//获取设定的上班时间
				timeWork = dateNew +" " + specialtimesetD.get(i).getGotoworktime();
				//获取设定的下班时间
				timeOffWork = dateNew +" " + specialtimesetD.get(i).getAfterworktime();
			}
		}
		System.out.println("specialtimesetD:"+specialtimesetD);
		return timeWork+","+timeOffWork;
	}
	//查询公出出差的记录，（区分 上午、下午、全天）
	
}
