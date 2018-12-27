package com.flx.flxoa.common.util;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

import com.flx.flxoa.info.cashcollection.entity.FlxoaCashcollectionRecord;
import com.flx.flxoa.info.projectmanagement.entity.FlxoaProjectInformation;

public class PoiUtil {
	
	public static List<List<String>> replaceModelByxls1(
			InputStream in) throws Exception  { 
		 List<List<String>> list = new ArrayList<List<String>>();
		    try {
				POIFSFileSystem poifsFileSystem = new POIFSFileSystem(in);
				HSSFWorkbook hssfWorkbook =  new HSSFWorkbook(poifsFileSystem);
				HSSFSheet hssfSheet = hssfWorkbook.getSheetAt(0);
				int rowEnd = hssfSheet.getLastRowNum();
				for(int i=3;i<=rowEnd;i++){
					List<String> excel = new ArrayList<String>();
					List<String> exce2 = new ArrayList<String>();
				    HSSFRow row = hssfSheet.getRow(i);
				    if(null == row) continue;
				    int cellStart = row.getFirstCellNum();
				 //   int cellEnd = row.getLastCellNum();
				    for(int k=cellStart+6;k<=7;k++)
				    {
				        HSSFCell cell = row.getCell(k);
				        int sd =3;
				        if(null==cell) {
				        	sd=sd;
				        }else{
				        	sd =cell.getCellType();
				        }
				        String s1 =null;
				        String s2= null;
				        switch (sd)
				        {  
				        case HSSFCell.CELL_TYPE_BLANK:  //空值读取
				        	 break; 
				        case HSSFCell.CELL_TYPE_ERROR:  //错误读取
				        	 break; 
				        case HSSFCell.CELL_TYPE_FORMULA:  //公式读取
				        	 double s3= cell.getNumericCellValue();
				                s1=Double.toString(s3);
				                break; 
				            case HSSFCell.CELL_TYPE_NUMERIC: // 数字
				                double s= cell.getNumericCellValue();
				                s1=Double.toString(s);
				                break;
				            case HSSFCell.CELL_TYPE_STRING: // 字符串
				            	s2 = cell.getStringCellValue();
				            	if(s2.substring(0, 1).equals("收")){
				            		s1=s2.substring(0,s2.length()-1);
				            	}
				                break;
				        }
				        	excel.add(s1);
				    }
				    
				   
				    for(int k=cellStart+8;k<=9;k++)
				    {
				        HSSFCell cell = row.getCell(k);
				        int sd =3;
				        if(null==cell) {
				        	sd=sd;
				        }else{
				        	sd =cell.getCellType();
				        }
				        String s3 =null;
				        String s4= null;
				        switch (sd)
				        {
				        case HSSFCell.CELL_TYPE_BLANK:  //空值读取
				        	 break; 
				        case HSSFCell.CELL_TYPE_ERROR:  //错误读取
//				        	 break; 
				        case HSSFCell.CELL_TYPE_FORMULA:  //公式读取
				        	 double s5= cell.getNumericCellValue();
				                s3=Double.toString(s5);
				                break; 
				            case HSSFCell.CELL_TYPE_NUMERIC: // 数字
				                double s= cell.getNumericCellValue();
				                s3=Double.toString(s);
				                break;
				            case HSSFCell.CELL_TYPE_STRING: // 字符串
				            	s4 = cell.getStringCellValue();
				            	if(s4.contains("收")){
					            	if(s4.substring(0, 1).equals("收")){
					            		s3=s4.substring(0,s4.length()-1);
					            	}
				            	}
				                break;
				        }
				        	exce2.add(s3);
				    }
				    if( excel.size()>0){
				    	System.out.println(excel.get(0)+"wang1");
				    	 list.add(excel);
				    }
				    
				    if( exce2.size()>0){
				    	System.out.println(exce2.get(0)+"wang2");
				    	 list.add(exce2);
				    }
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				 return list=null;
			}finally{
				in.close();
			}
		   return list;
	}
	
	
	public static boolean excelExport(List<Map<String,String>> list,HttpServletResponse response) {
		try {
			 // 第一步，创建一个webbook，对应一个Excel文件  
	        HSSFWorkbook wb = new HSSFWorkbook();  
	        // 第二步，在webbook中添加一个sheet,对应Excel文件中的sheet  
	        HSSFSheet sheet = wb.createSheet("回款信息表");  
	       // 第三步，在sheet中添加表头第0行,注意老版本poi对Excel的行数列数有限制short  
	        HSSFRow row = sheet.createRow((int) 0);  
	        // 第四步，创建单元格，并设置值表头 设置表头居中  
	        HSSFCellStyle style = wb.createCellStyle();  
	        style.setAlignment(HSSFCellStyle.ALIGN_CENTER); // 创建一个居中格式  
	        HSSFCell cell = row.createCell((short) 0);
	        cell.setCellValue("");  
	        cell.setCellStyle(style);  
	        cell = row.createCell((short) 1);  
	        cell.setCellValue("");  
	        cell.setCellStyle(style);  
	        cell = row.createCell((short) 2);  
	        cell.setCellValue("");  
	        cell.setCellStyle(style);  
	        cell = row.createCell((short) 3);  
	        cell.setCellValue("");  
	        cell.setCellStyle(style); 
	        cell = row.createCell((short) 4);  
	        cell.setCellValue("");  
	        cell.setCellStyle(style); 
	        cell = row.createCell((short) 5);  
	        cell.setCellValue("");  
	        cell.setCellStyle(style);
	        cell = row.createCell((short) 6);  
	        cell.setCellValue("");  
	        cell.setCellStyle(style);
	        cell = row.createCell((short) 7);  
	        cell.setCellValue("");  
	        cell.setCellStyle(style);
	        cell = row.createCell((short) 8);  
	        cell.setCellValue("");  
	        cell.setCellStyle(style);
	        cell = row.createCell((short) 9);  
	        cell.setCellValue("");  
	        cell.setCellStyle(style);
	        cell = row.createCell((short) 10);  
	        cell.setCellValue("");  
	        cell.setCellStyle(style);
	        cell = row.createCell((short) 11);  
	        cell.setCellValue("");  
	        cell.setCellStyle(style);
	        cell = row.createCell((short) 12);  
	        cell.setCellValue("");  
	        cell.setCellStyle(style);
	    
	        row = sheet.createRow((int) 0); 
	        row.createCell((short) 0).setCellValue("编号");  
	        row.createCell((short) 1).setCellValue("入账时间"); 
	        row.createCell((short) 2).setCellValue("单位名称"); 
	        row.createCell((short) 3).setCellValue("回款金额"); 
	        row.createCell((short) 4).setCellValue("项目编号"); 
	        row.createCell((short) 5).setCellValue("项目名称");
	        row.createCell((short) 6).setCellValue("立项人");
	        row.createCell((short) 7).setCellValue("认领人员");
	        row.createCell((short) 8).setCellValue("认领时间");
	        row.createCell((short) 9).setCellValue("审核人");
	        row.createCell((short) 10).setCellValue("审核时间");
	        row.createCell((short) 11).setCellValue("回款类别");
	        row.createCell((short) 12).setCellValue("用途");
	        // 第五步，写入实体数据 实际应用中这些数据从数据库得到，  
	        for (int i = 0; i < list.size(); i++){
		        row = sheet.createRow((int) i + 1);
		        Map<String,String> huikuan=list.get(i);  
		        // 第四步，创建单元格，并设置值  
		        row.createCell((short) 0).setCellValue(i);  
		        row.createCell((short) 1).setCellValue(huikuan.get("createTime")); 
		        row.createCell((short) 2).setCellValue(huikuan.get("caroOrgName")); 
		        row.createCell((short) 3).setCellValue(huikuan.get("caroMoney")); 
		        row.createCell((short) 4).setCellValue(huikuan.get("projNumber")); 
		        row.createCell((short) 5).setCellValue(huikuan.get("projName"));
		        row.createCell((short) 6).setCellValue(huikuan.get("lixiangName")); 
		        row.createCell((short) 7).setCellValue(huikuan.get("claimUserName")); 
		        row.createCell((short) 8).setCellValue(huikuan.get("claimTime")); 
		        row.createCell((short) 9).setCellValue(huikuan.get("affirmUserName")); 
		        row.createCell((short) 10).setCellValue(huikuan.get("affirmTime")); 
		        row.createCell((short) 11).setCellValue(huikuan.get("caroType")); 
		        row.createCell((short) 12).setCellValue(huikuan.get("caroUse")); 
	        }
	        String fileName = "回款信息表.xls";  
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
			FileOutputStream fout = new FileOutputStream("D:/回款信息表.xls"); 
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
			return false;
		}
	} 
	
}
