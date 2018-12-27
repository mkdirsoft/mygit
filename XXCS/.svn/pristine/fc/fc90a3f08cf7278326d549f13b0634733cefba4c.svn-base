package com.flx.flxoa.common.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;

import com.flx.flxoa.info.signin.entity.DoorCard;
import com.mchange.v2.c3p0.ComboPooledDataSource;

/**
 * 类名称：JdbcConn.java
 * 类描述：门禁卡sqlserver数据库链接
 * 创建时间：2018-3-20, 上午11:41:55
 * 
 * @version 1.0 
 * @since JDK版本 1.7
 * @author 张海英
 */
public class JdbcConn {
	// 数据库驱动类名的字符串  com.microsoft.sqlserver.jdbc.SQLServerDriver
	String driver = "com.microsoft.jdbc.sqlserver.SQLServerDriver";  
	// 数据库地址 
    String url = "jdbc:sqlserver://192.168.0.165:1433;DatabaseName=AIO20171122105030";
    // 用户名  
    String username = "sa";  
    // 密码  
    String password = "Das123$%^";  
    Connection conn = null;  
    Statement stmt = null;  
    ResultSet rs = null;
    List<DoorCard> list = null;
	
	/*
	 * 门禁卡sqlserver数据库连接
	 * 查询前一天所有的签到详情
	 */
	@SuppressWarnings("rawtypes")
	public List<DoorCard> sqlserverConn(DoorCard doorCard) throws SQLException{
        try {
        	// 1、加载数据库驱动（ 成功加载后，会将Driver类的实例注册到DriverManager类中）  
			Class.forName(driver );
			// 2、获取数据库连接  
            conn = DriverManager.getConnection(url, username, password); 
            // 3、获取数据库操作对象  
            stmt = conn.createStatement();  
            // 4、定义操作的SQL语句  （查询刷卡用户名、卡id和刷卡时间）
            //获取开始时间
            String startTime = doorCard.getStartTime();
            //获取结束时间
            String endTime = doorCard.getEndTime();
            //String sql = "select a.EMPNAME as name,b.EmpCardId,b.CardDay as checktime from Hrms_Emp a,NDr2_CardEvent b where a.EMPID=b.EMPID and b.CardDay >= '"+startTime+"' and b.CardDay <='"+endTime+"' and b.EmpCardId='329' "; 
            String sql = "select a.EMPNAME as name,b.EmpCardId,b.CardDay as checktime from Hrms_Emp a,NDr2_CardEvent b where a.EMPID=b.EMPID and b.CardDay >= '"+startTime+"' and b.CardDay <='"+endTime+"'  "; 
            // 5、执行数据库操作  
            rs = stmt.executeQuery(sql);  
			list = new ArrayList();
            // 6、获取并操作结果集  
            while (rs.next()) {  
            	int cardId = rs.getInt("EmpCardId");
                String checktime = rs.getString("checktime"); 
                DoorCard card = new DoorCard();
                card.setCardId(cardId);
                card.setChecktime(checktime);
                list.add(card);
            } 
        } catch (Exception e) {
			e.printStackTrace();
		} finally{
			// 7、关闭对象，回收数据库资源 
			 if (rs != null) { //关闭结果集对象  
	                try {  
	                    rs.close();  
	                } catch (SQLException e) {  
	                    e.printStackTrace();  
	                }  
	            }  
			 if (stmt != null) { // 关闭数据库操作对象  
	                try {  
	                    stmt.close();  
	                } catch (SQLException e) {  
	                    e.printStackTrace();  
	                }  
	            }  
			 if (conn != null) { // 关闭数据库连接对象  
	                try {  
	                    if (!conn.isClosed()) {  
	                        conn.close();  
	                    }  
	                } catch (SQLException e) {  
	                    e.printStackTrace();  
	                }  
	            }  
		}
        return list;
	}
	
	/*
	 * 门禁卡sqlserver数据库连接
	 * 获取今天的考勤详情
	 */
	public List<DoorCard> getTodaySignDetails(String sql) throws SQLException{
        try {
        	// 1、加载数据库驱动（ 成功加载后，会将Driver类的实例注册到DriverManager类中）  
			//Class.forName(driver );
    		WebApplicationContext webApplicationContext = ContextLoader.getCurrentWebApplicationContext();		
    		ComboPooledDataSource dataSource = (ComboPooledDataSource)webApplicationContext.getBean("dataSource_s");        	
			// 2、获取数据库连接  
            //conn = DriverManager.getConnection(url, username, password); 
        	conn = dataSource.getConnection(); 
            // 3、获取数据库操作对象  
            stmt = conn.createStatement();  
            // 4、定义操作的SQL语句  （查询刷卡用户名、卡id和刷卡时间）
            //获取昨天的结束时间
            //String endTime = doorCard.getEndTime();
            //String sql = "select a.EMPNAME as name,b.EmpCardId,b.CardDay as checktime from Hrms_Emp a,NDr2_CardEvent b where a.EMPID=b.EMPID and b.CardDay > '"+endTime+"'"; 
            // 5、执行数据库操作  
            rs = stmt.executeQuery(sql);
			list = new ArrayList<DoorCard>();
            // 6、获取并操作结果集  
            while (rs.next()) {  
            	
                DoorCard card = new DoorCard();
                card.setCardId(rs.getInt("EmpCardId"));
                card.setMaxTime(rs.getString("maxTime"));
                card.setMinTime(rs.getString("minTime"));
                list.add(card);
            } 
        } catch (Exception e) {
			e.printStackTrace();
		} finally{
			// 7、关闭对象，回收数据库资源 
			 if (rs != null) { //关闭结果集对象  
	                try {  
	                    rs.close();  
	                } catch (SQLException e) {  
	                    e.printStackTrace();  
	                }  
	            }  
			 if (stmt != null) { // 关闭数据库操作对象  
	                try {  
	                    stmt.close();  
	                } catch (SQLException e) {  
	                    e.printStackTrace();  
	                }  
	            }  
			 if (conn != null) { // 关闭数据库连接对象  
	                try {  
	                    if (!conn.isClosed()) {  
	                        conn.close();  
	                    }  
	                } catch (SQLException e) {  
	                    e.printStackTrace();  
	                }  
	            }  
		}
        return list;
	}
	/*
	 * 门禁卡sqlserver数据库连接
	 * 获取今天的考勤详情
	 */
	public List<DoorCard> getTodaySignDetail(String sql) throws SQLException{

        try {
        	// 1、加载数据库驱动（ 成功加载后，会将Driver类的实例注册到DriverManager类中）  
        	WebApplicationContext webApplicationContext = ContextLoader.getCurrentWebApplicationContext();		
    		ComboPooledDataSource dataSource = (ComboPooledDataSource)webApplicationContext.getBean("dataSource_s"); 
			// 2、获取数据库连接  
            conn = DriverManager.getConnection(url, username, password); 
            // 3、获取数据库操作对象  
            stmt = conn.createStatement();  
            // 4、定义操作的SQL语句  （查询刷卡用户名、卡id和刷卡时间）
            //获取昨天的结束时间
            //String endTime = doorCard.getEndTime();
            //String sql = "select a.EMPNAME as name,b.EmpCardId,b.CardDay as checktime from Hrms_Emp a,NDr2_CardEvent b where a.EMPID=b.EMPID and b.CardDay > '"+endTime+"'"; 
            // 5、执行数据库操作  
            rs = stmt.executeQuery(sql);
			list = new ArrayList<DoorCard>();
            // 6、获取并操作结果集  
            while (rs.next()) {  
            	
                DoorCard card = new DoorCard();
                card.setCardId(rs.getInt("EmpCardId"));
                card.setChecktime(rs.getString("checktime"));
                //card.setMinTime(rs.getString("minTime"));
                list.add(card);
            } 
        } catch (Exception e) {
			e.printStackTrace();
		} finally{
			// 7、关闭对象，回收数据库资源 
			 if (rs != null) { //关闭结果集对象  
	                try {  
	                    rs.close();  
	                } catch (SQLException e) {  
	                    e.printStackTrace();  
	                }  
	            }  
			 if (stmt != null) { // 关闭数据库操作对象  
	                try {  
	                    stmt.close();  
	                } catch (SQLException e) {  
	                    e.printStackTrace();  
	                }  
	            }  
			 if (conn != null) { // 关闭数据库连接对象  
	                try {  
	                    if (!conn.isClosed()) {  
	                        conn.close();  
	                    }  
	                } catch (SQLException e) {  
	                    e.printStackTrace();  
	                }  
	            }  
		}
        return list;
	}
	
}
