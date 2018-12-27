package com.flx.flxoa.common.util;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import com.flx.flxoa.info.projectmanagement.entity.FlxoaProjectInformation;
import com.flx.flxoa.info.signin.entity.FlxoaAttendanceSummary;

/**
 * @author 雷君
 * @version 创建时间：2018-3-21 上午9:08:50
 * 类说明
 */
public class ExcelExport {
private static SimpleDateFormat formattime = new SimpleDateFormat("yyyy年MM月dd日");
	
	@SuppressWarnings("deprecation")
	public static boolean excelExport(List<FlxoaProjectInformation> list,HttpServletResponse response) {
		try {
			 // 第一步，创建一个webbook，对应一个Excel文件  
	        HSSFWorkbook wb = new HSSFWorkbook();  
	        // 第二步，在webbook中添加一个sheet,对应Excel文件中的sheet  
	        HSSFSheet sheet = wb.createSheet("项目信息表");  
	       // 第三步，在sheet中添加表头第0行,注意老版本poi对Excel的行数列数有限制short  
	        HSSFRow row = sheet.createRow((int) 0);  
	        // 第四步，创建单元格，并设置值表头 设置表头居中  
	        HSSFCellStyle style = wb.createCellStyle();  
	        style.setAlignment(HSSFCellStyle.ALIGN_CENTER); // 创建一个居中格式  
	        HSSFCell cell = row.createCell((short) 0);
	        cell.setCellValue("序号");  
	        cell.setCellStyle(style); 
	        cell = row.createCell((short) 1);  
	        cell.setCellValue("项目编号");  
	        cell.setCellStyle(style); 
	        cell = row.createCell((short) 2);  
	        cell.setCellValue("项目名称");  
	        cell.setCellStyle(style);  
	        cell = row.createCell((short) 3);  
	        cell.setCellValue("客户名称");  
	        cell.setCellStyle(style); 
	        cell = row.createCell((short) 4);  
	        cell.setCellValue("预计合同额");  
	        cell.setCellStyle(style); 
	        cell = row.createCell((short) 5);  
	        cell.setCellValue("项目阶段");  
	        cell.setCellStyle(style);
	        cell = row.createCell((short) 6);  
	        cell.setCellValue("项目属性");  
	        cell.setCellStyle(style); 
	        cell = row.createCell((short) 7);  
	        cell.setCellValue("项目开始时间");  
	        cell.setCellStyle(style);  
	        cell = row.createCell((short) 8);  
	        cell.setCellValue("项目结束时间");  
	        cell.setCellStyle(style); 
	        cell = row.createCell((short) 9);  
	        cell.setCellValue("项目负责人");  
	        cell.setCellStyle(style); 
	        cell = row.createCell((short) 10);  
	        cell.setCellValue("项目对接人姓名");  
	        cell.setCellStyle(style); 
	        cell = row.createCell((short) 11);  
	        cell.setCellValue("项目对接人电话");  
	        cell.setCellStyle(style); 
	        cell = row.createCell((short) 12);  
	        cell.setCellValue("项目对接人邮箱");  
	        cell.setCellStyle(style); 
	       
	        // 第五步，写入实体数据 实际应用中这些数据从数据库得到，
	        for (int i = 0; i < list.size(); i++){
		        row = sheet.createRow((int) i + 1);  
		        FlxoaProjectInformation user = (FlxoaProjectInformation) list.get(i);  
		        // 第四步，创建单元格，并设置值  
		        row.createCell((short) 0).setCellValue((i));  
		        row.createCell((short) 1).setCellValue((user.getProjNumber()));  
		        row.createCell((short) 2).setCellValue((user.getProjName())); 
		        row.createCell((short) 3).setCellValue((user.getClientName())); 
		        row.createCell((short) 4).setCellValue((user.getPredictContractMoney())); 
		        row.createCell((short) 5).setCellValue((user.getProj_state_type())); 
		        row.createCell((short) 6).setCellValue((user.getProj_attribute_type())); 
		        if(user.getProjStartTime() > 0 ) {
		        		String start = DateUtils.timestampDate(user.getProjStartTime());
		        		row.createCell((short) 7).setCellValue((start)); 
		        }else {
		        		row.createCell((short) 7).setCellValue(" "); 
		        }
		        
		        if(user.getProjEndTime() > 0) {
	        			String end = DateUtils.timestampDate(user.getProjEndTime());
			        row.createCell((short) 8).setCellValue((end)); 
		        }else {
		        		row.createCell((short) 8).setCellValue(""); 
		        }
		       
		        row.createCell((short) 9).setCellValue((user.getProjectLeader())); 
		        row.createCell((short) 10).setCellValue((user.getSignatory())); 
		        row.createCell((short) 11).setCellValue((user.getSignatoryTelephone())); 
		        row.createCell((short) 12).setCellValue((user.getSignatoryName())); 
	        }
	        String fileName = "项目信息列表.xls";  
			fileName = new String(fileName.getBytes("UTF-8"), "iso8859-1");
	        response.reset();  
			response.setHeader("Content-Disposition", "attachment;filename="  
			      + fileName);// 指定下载的文件名  
			response.setContentType("application/vnd.ms-excel");  
			response.setHeader("Pragma", "no-cache");  
			response.setHeader("Cache-Control", "no-cache");  
			response.setDateHeader("Expires", 0);  
	        OutputStream output = response.getOutputStream();  
			BufferedOutputStream bufferedOutPut = new BufferedOutputStream(output);  
	        // 第六步，将文件存到指定位置  
			FileOutputStream fout = new FileOutputStream("D:/项目"); 
			wb.write(bufferedOutPut);
			bufferedOutPut.flush();
	        bufferedOutPut.close();
	        
	        output.flush();
	        output.close();
	        
	        fout.flush();
	        fout.close();
	        return true;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("异常出现在ExcelExport.jsva");
			return false;
		}
	}  
	public static boolean excelExportSign(List<FlxoaAttendanceSummary> list,HttpServletResponse response) {
		try {
			 // 第一步，创建一个webbook，对应一个Excel文件  
	        HSSFWorkbook wb = new HSSFWorkbook();  
	        // 第二步，在webbook中添加一个sheet,对应Excel文件中的sheet  
	        HSSFSheet sheet = wb.createSheet("考勤信息");  
	       // 第三步，在sheet中添加表头第0行,注意老版本poi对Excel的行数列数有限制short  
	        HSSFRow row = sheet.createRow((int) 0);  
	        // 第四步，创建单元格，并设置值表头 设置表头居中  
	        HSSFCellStyle style = wb.createCellStyle();  
	        style.setAlignment(HSSFCellStyle.ALIGN_CENTER); // 创建一个居中格式  
	        HSSFCell cell = row.createCell((short) 0);
	        cell.setCellValue("姓名");  
	        cell.setCellStyle(style);  
	        cell = row.createCell((short) 1);  
	        cell.setCellValue("所属部门");  
	        cell.setCellStyle(style);  
	        cell = row.createCell((short) 2);  
	        cell.setCellValue("签到日期");  
	        cell.setCellStyle(style);  
	        cell = row.createCell((short) 3);  
	        cell.setCellValue("最早签到时间");  
	        cell.setCellStyle(style); 
	        cell = row.createCell((short) 4);  
	        cell.setCellValue("最早签到类型");  
	        cell.setCellStyle(style); 
	        cell = row.createCell((short) 5);  
	        cell.setCellValue("最早签到地点");  
	        cell.setCellStyle(style); 
	        cell = row.createCell((short) 6);  
	        cell.setCellValue("最早签到备注");  
	        cell.setCellStyle(style);  
	        cell = row.createCell((short) 7);  
	        cell.setCellValue("最晚签到时间");  
	        cell.setCellStyle(style);  
	        cell = row.createCell((short) 8);  
	        cell.setCellValue("最晚签到类型");  
	        cell.setCellStyle(style); 
	        cell = row.createCell((short) 9);  
	        cell.setCellValue("最晚签到地点");  
	        cell.setCellStyle(style); 
	        cell = row.createCell((short) 10);  
	        cell.setCellValue("最晚签到备注");  
	        cell.setCellStyle(style); 
	        cell = row.createCell((short) 11);  
	        cell.setCellValue("签到状态");  
	        cell.setCellStyle(style);  
	        cell = row.createCell((short) 12);  
	        cell.setCellValue("领导批注");  
	        cell.setCellStyle(style);  
	        
	        // 第五步，写入实体数据 实际应用中这些数据从数据库得到，  
	        for (int i = 0; i < list.size(); i++){
		        row = sheet.createRow((int) i + 1);  
		        FlxoaAttendanceSummary  sign = (FlxoaAttendanceSummary) list.get(i);  
		        // 第四步，创建单元格，并设置值  
		        row.createCell((short) 0).setCellValue((sign.getRealname()));
		        row.createCell((short) 1).setCellValue((sign.getDname()));
		        if(sign.getSignData() == 0){
		        	row.createCell((short) 2).setCellValue("");
		        }
		        else{
		        	row.createCell((short) 2).setCellValue((DateUtils.timestampDate(sign.getSignData()))); //签到日期		        	
		        }
		        if(sign.getSignEarliestTime() == 0){
		        	row.createCell((short) 3).setCellValue("");
		        }
		        else{
		        	row.createCell((short) 3).setCellValue((DateUtils.timestampTime(sign.getSignEarliestTime())));//最早签到时间		        	
		        }
		        if(sign.getSignEarliestType().equals("0")){
		        	row.createCell((short) 4).setCellValue("手机签到");
		        }else if(sign.getSignEarliestType().equals("1")){
		        	row.createCell((short) 4).setCellValue("门禁刷卡");
		        }else if(sign.getSignEarliestType().equals("2")){
		        	row.createCell((short) 4).setCellValue("请假");
		        }else if(sign.getSignEarliestType().equals("3")){
		        	row.createCell((short) 4).setCellValue("公出");
		        }else if(sign.getSignEarliestType().equals("4")){
		        	row.createCell((short) 4).setCellValue("出差");
		        }		        
		        row.createCell((short) 5).setCellValue((sign.getSignEarliestAddress()));
		        if((sign.getSignEarliestComments()).equals("0")){
		        	row.createCell((short) 6).setCellValue("");
		        }else{
		        	row.createCell((short) 6).setCellValue((sign.getSignEarliestComments()));		        	
		        }
		        if(sign.getSignLatestTime() == 0){
		        	row.createCell((short) 7).setCellValue("");
		        }
		        else{
		        	row.createCell((short) 7).setCellValue((DateUtils.timestampTime(sign.getSignLatestTime())));//最晚签到时间		        	
		        }
		        if(sign.getSignLatestType().equals("0")){
		        	row.createCell((short) 8).setCellValue("手机签到");
		        }else if(sign.getSignLatestType().equals("1")){
		        	row.createCell((short) 8).setCellValue("门禁刷卡");
		        }else if(sign.getSignLatestType().equals("2")){
		        	row.createCell((short) 8).setCellValue("请假");
		        }else if(sign.getSignLatestType().equals("3")){
		        	row.createCell((short) 8).setCellValue("公出");
		        }else if(sign.getSignLatestType().equals("4")){
		        	row.createCell((short) 8).setCellValue("出差");
		        }
		        row.createCell((short) 9).setCellValue((sign.getSignLatestAdress()));
		        if((sign.getSignLatestComments()).equals("0")){
		        	row.createCell((short) 6).setCellValue("");
		        }else{
		        	row.createCell((short) 10).setCellValue((sign.getSignLatestComments())); 
		        }
		        if(sign.getSignStatus().equals("0")){
		        	row.createCell((short) 11).setCellValue("正常"); //考勤状态
		        }else if(sign.getSignStatus().equals("1")){
		        	row.createCell((short) 11).setCellValue("迟到"); //考勤状态
		        }else if(sign.getSignStatus().equals("2")){
		        	row.createCell((short) 11).setCellValue("周末"); //考勤状态
		        }else if(sign.getSignStatus().equals("3")){
		        	row.createCell((short) 11).setCellValue("节假日"); //考勤状态
		        }else if(sign.getSignStatus().equals("4")){
		        	row.createCell((short) 11).setCellValue("节假日加班"); //考勤状态
		        }else if(sign.getSignStatus().equals("5")){
		        	row.createCell((short) 11).setCellValue("请假"); //考勤状态
		        }else if(sign.getSignStatus().equals("6")){
		        	row.createCell((short) 11).setCellValue("请假中"); //考勤状态
		        }else if(sign.getSignStatus().equals("7")){
		        	row.createCell((short) 11).setCellValue("打卡异常"); //考勤状态
		        }else if(sign.getSignStatus().equals("8")){
		        	row.createCell((short) 11).setCellValue("早退"); //考勤状态
		        }else if(sign.getSignStatus().equals("9")){
		        	row.createCell((short) 11).setCellValue("迟到、早退"); //考勤状态
		        }else{
		        	row.createCell((short) 11).setCellValue("当天考勤"); //考勤状态
		        }
		        
		        row.createCell((short) 12).setCellValue((sign.getLeaderComments()));//领导批注 
		        
	        }
	        String fileName = "考勤信息表.xls";  
			fileName = new String(fileName.getBytes("UTF-8"), "iso8859-1");
	        response.reset();  
			response.setHeader("Content-Disposition", "attachment;filename="  
			      + fileName);// 指定下载的文件名  
			response.setContentType("application/vnd.ms-excel");  
			response.setHeader("Pragma", "no-cache");  
			response.setHeader("Cache-Control", "no-cache");  
			response.setDateHeader("Expires", 0);  
	        OutputStream output = response.getOutputStream();  
			BufferedOutputStream bufferedOutPut = new BufferedOutputStream(output);  
	        // 第六步，将文件存到指定位置  
			FileOutputStream fout = new FileOutputStream("D:/考勤"); 
			wb.write(bufferedOutPut);
			bufferedOutPut.flush();
	        bufferedOutPut.close();
	        
	        output.flush();
	        output.close();
	        
	        fout.flush();
	        fout.close();
	        return true;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("异常出现在ExcelExport.jsva");
			return false;
		}
	}  
}
