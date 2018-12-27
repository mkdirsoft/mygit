package com.flx.flxoa.info.signin.manager.impl;

import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.SimpleFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.flx.flxoa.common.util.DateUtils;
import com.flx.flxoa.common.util.JdbcConn;
import com.flx.flxoa.info.signin.dao.FlxoaAttendanceSigndetailsDao;
import com.flx.flxoa.info.signin.dao.FlxoaAttendanceSigndetailsImportDao;
import com.flx.flxoa.info.signin.entity.DoorCard;
import com.flx.flxoa.info.signin.entity.FlxoaAttendanceSigndetails;
import com.flx.flxoa.info.signin.manager.FlxoaAttendanceSigndetailsImportService;
import com.flx.flxoa.info.system.dao.FlxoaSystemUserDao;
import com.flx.flxoa.info.system.entity.FlxoaSystemUser;

/**
 * 类名称：FlxoaAttendanceSigndetailsImportServiceImpl.java
 * 类描述：考勤详情数据库导入业务处理层(在flxoa_attendance_signdetails表中导入数据)
 * 创建时间：2018-3-21, 下午1:43:34
 * 
 * @version 1.0 
 * @since JDK版本 1.7
 * @author 张海英
 */
@Service
@Transactional
public class FlxoaAttendanceSigndetailsImportServiceImpl implements
		FlxoaAttendanceSigndetailsImportService {
	private FlxoaAttendanceSigndetailsImportDao dao;
	private FlxoaAttendanceSigndetailsDao signdetailsDao;
	private FlxoaSystemUserDao systemUserDao;
	@Autowired
	public void setDao(FlxoaAttendanceSigndetailsImportDao dao) {
		this.dao = dao;
	}
	public FlxoaAttendanceSigndetailsImportDao getDao() {
		return dao;
	}
	@Autowired
	public void setSigndetailsDao(FlxoaAttendanceSigndetailsDao signdetailsDao) {
		this.signdetailsDao = signdetailsDao;
	}
	public FlxoaAttendanceSigndetailsDao getSigndetailsDao() {
		return signdetailsDao;
	}
	@Autowired
	public void setSystemUserDao(FlxoaSystemUserDao systemUserDao) {
		this.systemUserDao = systemUserDao;
	}
	public FlxoaSystemUserDao getSystemUserDao() {
		return systemUserDao;
	}
	
	/*
	 * 考勤详情数据导入
	 * (non-Javadoc)
	 * @see com.flx.flxoa.info.signin.manager.FlxoaAttendanceSigndetailsImportService#signdetailsImport(com.flx.flxoa.info.signin.entity.DoorCard)
	 */
	@Override
	public void signdetailsImport(DoorCard doorCard) {
		List<DoorCard> list=dao.signdetailsImport(doorCard);
		List<FlxoaSystemUser> userList=systemUserDao.queryAllUser();
		try {// 同一卡号的人，id小的那个人考勤会出现异常 （管理员账号 admin、SA 不应该导入考勤信息）
			if(list.size()>0 && userList.size()>0){
				for(int i=0;i<list.size();i++){
					//获取门禁卡数据库中的card_id
					int card_id=list.get(i).getCardId();
					int createUserId=0;
					int createDepartmentId =0;					
					for(int j=0;j<userList.size();j++){
						//获取员工表中的card_id
						int card_id2=userList.get(j).getCardId();
						if(card_id2==card_id){
							createUserId=userList.get(j).getId();
							createDepartmentId =userList.get(j).getDepartmentId();
							FlxoaAttendanceSigndetails flxoaAttendanceSigndetails=new FlxoaAttendanceSigndetails();
							String checktime=list.get(i).getChecktime();
							int signTime=0;
							if(checktime==""||checktime==null){
								checktime="0";
							}else{
								signTime=DateUtils.getSecondTimestamp(DateUtils.parse(checktime,"yyyy-MM-dd HH:mm:ss"));
							}
							//签到时间
							flxoaAttendanceSigndetails.setSignTime(signTime);
							//签到日期
							String  signDate= DateUtils.timestampToDate(signTime);
							Date d = DateUtils.parse(signDate);
							int signDateNew = DateUtils.getSecondTimestamp(d);
							System.out.println("签到日期时间戳："+signDateNew);
							flxoaAttendanceSigndetails.setSignDate(signDateNew);
							//签到地点
							flxoaAttendanceSigndetails.setSignLocale("门禁卡刷卡");
							//签到点所在纬度
							flxoaAttendanceSigndetails.setSignLatitude("39.991575086304");
							//签到点所在经度
							flxoaAttendanceSigndetails.setSignLongitude("116.37157589793");
							//签到备注
							flxoaAttendanceSigndetails.setCommens("0");
							//签到类型，门禁刷卡（1）
							flxoaAttendanceSigndetails.setSignType("1");
							//创建时间与更新时间
							Date date = new Date();
							DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
							String time = format.format(date);
							flxoaAttendanceSigndetails.setCreateTime(DateUtils.getSecondTimestamp(DateUtils.parse(time,"yyyy-MM-dd HH:mm:ss")));
							flxoaAttendanceSigndetails.setUpdateTime(DateUtils.getSecondTimestamp(DateUtils.parse(time,"yyyy-MM-dd HH:mm:ss")));
							//删除标记,未删除（0）
							flxoaAttendanceSigndetails.setDeleteFlag("0");
							//创建userid
							flxoaAttendanceSigndetails.setCreateUserId(createUserId);
							//更新人id
							flxoaAttendanceSigndetails.setUpdateUserId(createUserId);
							//创建人所属部门id
							flxoaAttendanceSigndetails.setCreateDepartmentId(createDepartmentId);
							//更新人所属部门id
							flxoaAttendanceSigndetails.setUpdateDepartmentId(createDepartmentId);
							signdetailsDao.add(flxoaAttendanceSigndetails);
							break;
						}
					}
					
				}
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
}
