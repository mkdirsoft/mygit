/**
 * 
 */
package com.flx.flxoa.common.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map.Entry;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.util.MultiValueMap;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.flx.flxoa.info.system.entity.FlxoaAccessory;

/**
 * @author 赵鹏辉
 * @date 2018-3-26 下午2:16:41
 * 描述：
 */
public class FileUtils {

	/**
	 * 文件上传
	 * dirName 目录名称
	 * request
	 * return List<FlxoaAccessory>
	 * */
	public static List<FlxoaAccessory> fileUpload(String dirName,HttpServletRequest request){
		List<FlxoaAccessory> list = new ArrayList<FlxoaAccessory>();
		int nowTime = DateUtils.getSecondTimestamp(new Date());
		// 获得项目的路径  
		ServletContext sc = request.getSession().getServletContext();  
		// 上传位置  
		String path = sc.getRealPath("/filesupload") + "/"+dirName+"/"; // 设定文件保存的目录  
		File f = new File(path);  
		if (!f.exists()){  
			f.mkdirs();  
		}
        MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
        MultiValueMap<String, MultipartFile> map = multipartRequest.getMultiFileMap();
		//遍历map
		for (Entry<String, List<MultipartFile>> entry : map.entrySet()) {
			List<MultipartFile> listMult = entry.getValue();
			for (int i = 0; i < listMult.size(); i++) {
				MultipartFile mFile = listMult.get(i);
		        //获得原始文件名  
		        String fileName = mFile.getOriginalFilename();
	            //新文件名  
	            String fileRealName = nowTime +"_"+fileName;
	            //完整路径
	            String filePath = path + fileRealName;
	            if (!mFile.isEmpty()) {  
	                try {  
	                    FileOutputStream fos = new FileOutputStream(path  
	                            + fileRealName);  
	                    InputStream in = mFile.getInputStream();  
	                    int b = 0;  
	                    while ((b = in.read()) != -1) {  
	                        fos.write(b);  
	                    }  
	                    fos.close();  
	                    in.close();
	                    FlxoaAccessory file = new FlxoaAccessory();
	                    file.setFileName(fileName);
	                    file.setFileRealName(fileRealName);
	                    file.setFilePath(filePath);
	                    list.add(file);
	                } catch (Exception e) {  
	                    e.printStackTrace();  
	                }  
	            }				
			}

		}  
//		for (int i = 0; i < files.length; i++) {
//	        //获得原始文件名  
//	        String fileName = files[i].getOriginalFilename();
//            //新文件名  
//            String fileRealName = nowTime +"_"+fileName;
//            //完整路径
//            String filePath = path + fileRealName;
//            if (!files[i].isEmpty()) {  
//                try {  
//                    FileOutputStream fos = new FileOutputStream(path  
//                            + fileRealName);  
//                    InputStream in = files[i].getInputStream();  
//                    int b = 0;  
//                    while ((b = in.read()) != -1) {  
//                        fos.write(b);  
//                    }  
//                    fos.close();  
//                    in.close();
//                    FlxoaAccessory file = new FlxoaAccessory();
//                    file.setFileName(fileName);
//                    file.setFileRealName(fileRealName);
//                    file.setFilePath(filePath);
//                    list.add(file);
//                } catch (Exception e) {  
//                    e.printStackTrace();  
//                }  
//            }              
//		}
		return list;
	}
	
	/**
	 * 文件下载
	 * fileRealName 真实文件名
	 * dirName 目录名称
	 * request
	 * response
	 * */	
	public static void downLoadFile(String fileRealName,String dirName,HttpServletRequest request,HttpServletResponse response){
        // 获取上传文件的目录  
        ServletContext sc = request.getSession().getServletContext();
		// 上传位置  
		String path = sc.getRealPath("/filesupload") + "/"+dirName+"/"; // 设定文件保存的目录  
        // 得到要下载的文件  
        File file = new File(path + "/" + fileRealName);
        FileInputStream in = null;
        OutputStream out = null;
        // 如果文件不存在  
        if (!file.exists()) {  
            request.setAttribute("message", "您要下载的资源已被删除！！");  
            System.out.println("您要下载的资源已被删除！！");  
            return;  
        }
        try {
            // 处理文件名  
            String fileName = fileRealName.substring(fileRealName.indexOf("_") + 1);  
            // 设置响应头，控制浏览器下载该文件  
            response.setHeader("content-disposition", "attachment;filename="  
                    + URLEncoder.encode(fileName, "UTF-8"));  
            // 读取要下载的文件，保存到文件输入流  
            in = new FileInputStream(file);
            // 创建输出流  
            out = response.getOutputStream();  
            // 创建缓冲区  
            byte buffer[] = new byte[1024];  
            int len = 0;  
            // 循环将输入流中的内容读取到缓冲区当中  
            while ((len = in.read(buffer)) > 0) {  
                // 输出缓冲区的内容到浏览器，实现文件下载  
                out.write(buffer, 0, len);  
            }  			
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			if(null != in){
		        // 关闭文件输入流  
		        try {
					in.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}  				
			}
			if(null != out){
		        // 关闭输出流  
		        try {
					out.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 				
			}
		}
	}
}
