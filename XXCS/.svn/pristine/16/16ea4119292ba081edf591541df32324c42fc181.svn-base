package com.flx.flxoa.info.projectmanagement.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.Map.Entry;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadBase.FileSizeLimitExceededException;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FilenameUtils;
import org.apache.tomcat.util.http.fileupload.ProgressListener;
import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import com.flx.flxoa.common.util.DateUtils;
import com.flx.flxoa.common.util.FileUtils;
import com.flx.flxoa.info.projectmanagement.entity.FlxoaProjectBidInformation;
import com.flx.flxoa.info.projectmanagement.entity.FlxoaProjectBidRecord;
import com.flx.flxoa.info.projectmanagement.entity.FlxoaProjectInformation;
import com.flx.flxoa.info.projectmanagement.manager.FlxoaProjectBidInformationService;
import com.flx.flxoa.info.projectmanagement.manager.FlxoaProjectBidRecordService;
import com.flx.flxoa.info.projectmanagement.manager.FlxoaProjectInformationService;
import com.flx.flxoa.info.system.entity.FlxoaAccessory;

/**
 * @author 雷君
 * @version 创建时间：2018-3-22 上午11:28:48 类说明
 */
@Controller
public class FlxoaProjectBidRecordController extends HttpServlet {
	 private static final long serialVersionUID = 1L;
	 // 定义允许上传的文件扩展名
	    private String Ext_Name = "gif,jpg,jpeg,png,bmp,swf,flv,mp3,wav,wma,wmv,mid,avi,mpg,asf,rm,rmvb,doc,docx,xls,xlsx,ppt,htm,html,txt,zip,rar,gz,bz2";
	protected FlxoaProjectBidRecordService flxoaProjectBidRecordService;

	@Autowired
	public void setFlxoaProjectBidRecordService(
			FlxoaProjectBidRecordService flxoaProjectBidRecordService) {
		this.flxoaProjectBidRecordService = flxoaProjectBidRecordService;
	}
	protected FlxoaProjectBidInformationService flxoaProjectBidInformationService;
	@Autowired
	public void setFlxoaProjectBidInformationService(FlxoaProjectBidInformationService flxoaProjectBidInformationService) {
		this.flxoaProjectBidInformationService = flxoaProjectBidInformationService;
	}
	protected FlxoaProjectInformationService flxoaProjectInformationService;
	@Autowired
	public void setFlxoaProjectInformationService(
			FlxoaProjectInformationService flxoaProjectInformationService) {
		this.flxoaProjectInformationService = flxoaProjectInformationService;
	}
	/**
	 * @param 查看进度信息
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/flxoaProjectBidSchedule", produces = "text/html;charset=utf-8")
	@ResponseBody
	public String flxoaProjectBidSchedule(HttpServletRequest request,
			HttpServletResponse response, FlxoaProjectBidRecord model) {
		int uid =Integer.valueOf(request.getParameter("bidid")) ;
		JSONArray json = new JSONArray();
		model.setBidId(uid);
		List<FlxoaProjectBidRecord> list = flxoaProjectBidRecordService.query(model);
		// newjson對象
		JSONArray jsonList = json.put(list);
		return json.toString();
	}

	/**
	 * @param 填写进度信息
	 * @param response
	 * @param model
	 * @return 
	 */
	@RequestMapping(value = "/flxoaProjectBidAmend", produces = "text/html;charset=utf-8")
	@ResponseBody
	public String flxoaProjectBidAmend(HttpServletRequest request,
			HttpServletResponse response, FlxoaProjectBidRecord model) {
		FlxoaProjectBidInformation flxoaProjectInformation =new FlxoaProjectBidInformation();
		FlxoaProjectInformation flxoaProjectInformations = new FlxoaProjectInformation();
		HttpServletRequest req = (HttpServletRequest)request;
		//获取投标ID
		model.setBidId(Integer.valueOf(request.getParameter("bidid")));
		//进度名称
		model.setName(request.getParameter("bidProgress"));
		//进度值
		model.setNameValue(request.getParameter("tbglProgressValue"));
		
		//更新用户id
		model.setUpdateUserId(Integer.parseInt(String.valueOf(req.getSession().getAttribute("userId"))));
		//修改时间
		model.setUpdateTime(DateUtils.getSecondTimestamp(new Date()));
		//更新用户部门id
		model.setUpdateDepartmentId(Integer.parseInt(String.valueOf(req.getSession().getAttribute("departmentId"))));
		//未删除 0  已删除1
		model.setDeleteFlag("0");
		
		flxoaProjectInformation.setId(Integer.valueOf(request.getParameter("bidid")));
		flxoaProjectInformations.setId(Integer.valueOf(request.getParameter("projectid")));
		//查询投标信息
		FlxoaProjectBidInformation flxoaProjectBidInformation = flxoaProjectBidInformationService.queryById(flxoaProjectInformation);
		//查询项目信息
		FlxoaProjectInformation FlxoaProjectInformationUp = flxoaProjectInformationService.queryById(flxoaProjectInformations);
		if(request.getParameter("bidProgress").equals("指定投标负责人")) {
			
			//投标负责人
			flxoaProjectBidInformation.setBiddingDirector(request.getParameter("tbglProgressValue"));
			//修改投标准备进度状态
			flxoaProjectBidInformation.setProjectBiddingStatus("1");
			//修改投标信息表中投标进度状态为投标准备中
			flxoaProjectBidInformation.setBidSchedule("3");
			//修改项目信息中的  阶段状态  为投标准备中
			FlxoaProjectInformationUp.setProjState("3");
		}else if(request.getParameter("bidProgress").equals("写标书")){
			flxoaProjectBidInformation.setProjectBiddingStatus("4");
		}else if(request.getParameter("bidProgress").equals("确定投标时间")) {
			flxoaProjectBidInformation.setProjectBiddingStatus("5");
		}else if(request.getParameter("bidProgress").equals("申请保证金")) {
			flxoaProjectBidInformation.setProjectBiddingStatus("6");
		}
		boolean  BidInformation  = flxoaProjectBidInformationService.update(flxoaProjectBidInformation);
		boolean  b = flxoaProjectBidRecordService.add(model);
		String result = "0";
		if (b){
			result  ="1";
		}
		return null;
	}
	
	

    /**
     * @param files
     * @param request
     * @param model
     * @return 一次上传多文件
     */
    @RequestMapping("/threeFileUpload")  
    @ResponseBody
    public String threeFileUpload(HttpServletRequest request,HttpServletResponse response,String bidid,String bidProgress, ModelMap model) throws UnsupportedEncodingException{
    	FlxoaProjectBidInformation flxoaProjectInformation =new FlxoaProjectBidInformation();
		FlxoaProjectBidRecord bidRecord = new FlxoaProjectBidRecord();
		//上传文件
		List<FlxoaAccessory> list = FileUtils.fileUpload("bidRecord", request);  
		//更新投标信息表中的投标进度状态
		flxoaProjectInformation.setId(Integer.valueOf(request.getParameter("bidid")));
		FlxoaProjectBidInformation flxoaProjectBidInformation = flxoaProjectBidInformationService.queryById(flxoaProjectInformation);
		if(request.getParameter("bidProgress").equals("2")){
			flxoaProjectBidInformation.setProjectBiddingStatus("2");
		}else if(request.getParameter("bidProgress").equals("3")) {
			flxoaProjectBidInformation.setProjectBiddingStatus("3");
		}
		boolean  BidInformation  = flxoaProjectBidInformationService.update(flxoaProjectBidInformation);
		
		bidRecord.setDeleteFlag("0");
        bidRecord.setBidId(Integer.valueOf(request.getParameter("bidid")));
        if(request.getParameter("bidProgress").equals("2")){
        		bidRecord.setName("上传方案书");
		}else if(request.getParameter("bidProgress").equals("3")) {
			bidRecord.setName("上传标书");
		}
        String listName = "";
        String listNameValue = "";
        String listUrl = "";
        for (int i = 0; i < list.size(); i++) {
        	FlxoaAccessory accessory = list.get(i);
        	listName += accessory.getFileName()+",";
        	listNameValue += accessory.getFileRealName()+",";
        	listUrl += accessory.getFilePath()+",";
		}
        if(!"".equals(listName)){
        	listName = listName.substring(0, listName.length()-1);
        	listNameValue = listNameValue.substring(0, listNameValue.length()-1);
        	listUrl = listUrl.substring(0, listUrl.length()-1);
        }
        bidRecord.setUrl(listUrl);
		bidRecord.setNameValue(listName);
		bidRecord.setAccessoryName(listName);
		bidRecord.setAccessoryTrueName(listNameValue);
		boolean  d = flxoaProjectBidRecordService.add(bidRecord);
		String result = "0";
		if(d){
			result = "1";
		}
        return result;  
    }
 
 
	/**
	 * @param request
	 * @param response
	 * @return 附近下载
	 */
	@RequestMapping("/downFile")  
    public void downFile(HttpServletRequest request,  
            HttpServletResponse response) {  
        System.out.println("1");  
        // 得到要下载的文件名  
        String fileName = request.getParameter("filename");  
        System.out.println("2");  
        try {  
            fileName = new String(fileName.getBytes("iso8859-1"), "UTF-8");  
            System.out.println("3");  
            // 获取上传文件的目录  
            ServletContext sc = request.getSession().getServletContext();  
            System.out.println("4");  
            // 上传位置  
            String fileSaveRootPath = sc.getRealPath("/filesupload");   
              
            System.out.println(fileSaveRootPath + "\\" + fileName);  
            // 得到要下载的文件  
            File file = new File(fileSaveRootPath + "\\" + fileName);  
            // 如果文件不存在  
            if (!file.exists()) {  
                request.setAttribute("message", "您要下载的资源已被删除！！");  
                return;  
            }  
            // 处理文件名  
            String realname = fileName.substring(fileName.indexOf("_") + 1);  
            // 设置响应头，控制浏览器下载该文件  
            response.setHeader("content-disposition", "attachment;filename="  
                    + URLEncoder.encode(realname, "UTF-8"));  
            // 读取要下载的文件，保存到文件输入流  
            FileInputStream in = new FileInputStream(fileSaveRootPath + "\\" + fileName);  
            // 创建输出流  
            OutputStream out = response.getOutputStream();  
            // 创建缓冲区  
            byte buffer[] = new byte[1024];  
            int len = 0;  
            // 循环将输入流中的内容读取到缓冲区当中  
            while ((len = in.read(buffer)) > 0) {  
                // 输出缓冲区的内容到浏览器，实现文件下载  
                out.write(buffer, 0, len);  
            }  
            // 关闭文件输入流  
            in.close();  
            // 关闭输出流  
            out.close();  
        } catch (Exception e) {  
      
        }  
    }  
	
	
	

}
