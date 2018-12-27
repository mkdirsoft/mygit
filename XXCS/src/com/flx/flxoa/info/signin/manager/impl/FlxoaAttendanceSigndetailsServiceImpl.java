package com.flx.flxoa.info.signin.manager.impl;




import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.flx.flxoa.common.util.DateUtils;
import com.flx.flxoa.common.util.JdbcConn;
import com.flx.flxoa.info.signin.entity.DoorCard;
import com.flx.flxoa.info.signin.entity.FlxoaAttendanceSigndetails;
import com.flx.flxoa.info.signin.entity.FlxoaAttendanceSummary;
import com.flx.flxoa.info.signin.manager.FlxoaAttendanceSigndetailsService;
import com.flx.flxoa.info.signin.dao.FlxoaAttendanceSigndetailsDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * 类名称：FlxoaAttendanceSigndetailsServiceImpl.java
 * 类描述：
 * 创建时间：2018-03-16, 下午02:52:37
 *
 * @version 1.0 
 * @since JDK版本1.7 
 * @author 张海英 
 */ 
@Service
@Transactional
public class FlxoaAttendanceSigndetailsServiceImpl implements FlxoaAttendanceSigndetailsService {
	private FlxoaAttendanceSigndetailsDao dao;
	
	
	@Autowired
	public void setDao(FlxoaAttendanceSigndetailsDao dao) {
		this.dao = dao;
	}
	public FlxoaAttendanceSigndetailsDao getDao() {
		return dao;
	}
	/**
	 *添加FlxoaAttendanceSigndetails
	 */ 
	public boolean add(FlxoaAttendanceSigndetails flxoaAttendanceSigndetails) {
		boolean result = dao.add(flxoaAttendanceSigndetails);
		return result;
	}
	/**
	 *删除FlxoaAttendanceSigndetails
	 */ 
	public boolean delete(FlxoaAttendanceSigndetails flxoaAttendanceSigndetails) {
		boolean result = dao.delete(flxoaAttendanceSigndetails);
		return result;
	}
	/**
	 *修改FlxoaAttendanceSigndetails
	 */ 
	public boolean update(FlxoaAttendanceSigndetails flxoaAttendanceSigndetails) {
		boolean result = dao.update(flxoaAttendanceSigndetails);
		return result;
	}
	/**
	 *查询FlxoaAttendanceSigndetails列表
	 */ 
	public List<FlxoaAttendanceSigndetails> query(FlxoaAttendanceSigndetails flxoaAttendanceSigndetails) {
		List<FlxoaAttendanceSigndetails> list = dao.query(flxoaAttendanceSigndetails);
		return list;
	}
	/**
	 *查询FlxoaAttendanceSigndetails ByID
	 */ 
	public FlxoaAttendanceSigndetails queryById(FlxoaAttendanceSigndetails flxoaAttendanceSigndetails) {
		FlxoaAttendanceSigndetails result = dao.queryById(flxoaAttendanceSigndetails);
		return result;
	}
	/**
	 * 查询考勤明细
	 */
	@Override
	public List<FlxoaAttendanceSigndetails> querySignDetail(FlxoaAttendanceSigndetails flxoaAttendanceSigndetails) {
		List<FlxoaAttendanceSigndetails> returnList = new ArrayList<FlxoaAttendanceSigndetails>();
		//获取当天的凌晨时间  String类型
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String data = sdf.format(DateUtils.getStartTime());
		String data1= sdf.format(DateUtils.getEndTime());
		
		int  signDate = flxoaAttendanceSigndetails.getSignDate();		
		String signdate = DateUtils.timestampToDate(signDate);
		String carid = flxoaAttendanceSigndetails.getCard_id();		
		try{
			if(signdate.equals(data)){
				//无卡的情况
				if(flxoaAttendanceSigndetails.getCard_id().equals(0)){
					returnList = dao.querySignDetail(flxoaAttendanceSigndetails);
				}else{//有卡的情况
					returnList = dao.querySignDetail(flxoaAttendanceSigndetails);
					String sql ="select EmpCardId, CardDay as checktime from  NDr2_CardEvent where EMPCARDID = "+carid+"  and CardDay >'"+data+"' and CardDay <='"+data1+"' order by CardDay desc ";
					JdbcConn jdbcConn = new JdbcConn();
					List<DoorCard> sqlList = jdbcConn.getTodaySignDetail(sql);
					for(int i=0;i<sqlList.size();i++){
						FlxoaAttendanceSigndetails signdetails = new FlxoaAttendanceSigndetails();
						int signdat = DateUtils.getSecondTimestamp(sdf.parse(sqlList.get(i).getChecktime()));
						signdetails.setSignTime(signdat);
						signdetails.setRealname(flxoaAttendanceSigndetails.getRealname());
						signdetails.setCommens("");
						signdetails.setSignLocale("门禁刷卡");
						signdetails.setDname(flxoaAttendanceSigndetails.getDname());
						signdetails.setSignType("1");
						returnList.add(signdetails);
					 }
				 }				
			}else{//查询日期不为今天，直接查询详情表		
				returnList = dao.querySignDetail(flxoaAttendanceSigndetails);			
		}		
	}catch (Exception e) {
		e.printStackTrace();
		}
		return getSortList(returnList);
	
	}
	//对组合的List,按照属性值排序
	public static List<FlxoaAttendanceSigndetails> getSortList(List<FlxoaAttendanceSigndetails> list){
        Collections.sort(list, new Comparator<FlxoaAttendanceSigndetails>() {
            @Override
            public int compare(FlxoaAttendanceSigndetails o1, FlxoaAttendanceSigndetails o2) {
                if(o1.getSignTime()<o2.getSignTime()){
                    return 1;
                }
                if(o1.getSignTime()==o2.getSignTime()){
                    return 0;
                }
                return -1;
            }
        });
        return list;
    }
	
}