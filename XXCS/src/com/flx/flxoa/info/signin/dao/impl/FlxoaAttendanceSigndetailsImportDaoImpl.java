package com.flx.flxoa.info.signin.dao.impl;

import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.flx.flxoa.common.util.JdbcConn;
import com.flx.flxoa.info.signin.dao.FlxoaAttendanceSigndetailsImportDao;
import com.flx.flxoa.info.signin.entity.DoorCard;
import com.flx.flxoa.info.signin.entity.FlxoaAttendanceSigndetails;

/**
 * 类名称：FlxoaAttendanceSigndetailsImportDaoImpl.java
 * 类描述：考勤详情数据库导入数据处理层
 * 创建时间：2018-3-21, 下午7:05:30
 * 
 * @version 1.0 
 * @since JDK版本 1.7
 * @author 张海英
 */

@Repository
public class FlxoaAttendanceSigndetailsImportDaoImpl implements
		FlxoaAttendanceSigndetailsImportDao {

	@Override
	public List<DoorCard> signdetailsImport(DoorCard doorCard) {
		List<DoorCard> list=new ArrayList<DoorCard>();
		try {
			//连接门禁卡sqlserver数据库
			JdbcConn jdbcConn = new JdbcConn();
			list = jdbcConn.sqlserverConn(doorCard);
			System.out.println("前一天打卡数："+ list.size());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
		
	}

}
