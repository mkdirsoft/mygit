/**
 * 
 */
package com.flx.flxoa.common.util;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

/**
 * @author 赵鹏辉
 * @date 2018-3-28 上午11:37:07
 * 描述：公用utils
 */
public class CommonUtils {

	/**
	 * 获取TotalPage
	 * @param totalCount
	 * @param pageSize
	 * @return
	 */
	public static long getTotalPages(long totalCount,int pageSize){
		long totalPages=0; 
		if(totalCount>0){
			totalPages=((totalCount%pageSize==0)?totalCount/pageSize:(totalCount/pageSize+1));
		}
		return totalPages;
	}
	
	/**
	 * 分页json
	 * 
	 * @param pageNo
	 * @param pageSize
	 * @param totalCount
	 * @param map
	 * @return
	 */
	public static String getPageJson(int start,int length,String draw,long totalCount,List<Map<String,String>> dataList,List<Map<String,String>> otherDataList){
		Map<String,Object> map=new HashMap<String,Object>();
		List<Map<String,Object>> list=new ArrayList<Map<String,Object>>();
		long totalPages=0; 
		if(totalCount>0){
			totalPages=((totalCount%length==0)?totalCount/length:(totalCount/length+1));
		}
		map.put("data", dataList);
		map.put("start", start);
		map.put("length", length);
		map.put("draw", draw);
		map.put("totalCount", totalCount);
		map.put("totalPage", totalPages);
		map.put("otherData", otherDataList);
		list.add(map);
		JSONArray json=JSONArray.fromObject(list);
		return json.toString();
	}
	
	
	/**
	 * 分页json
	 * 
	 * @param pageNo
	 * @param pageSize
	 * @param totalCount
	 * @param map
	 * @return
	 */
	public static String getMarketPageJson(int start,int length,long totalCount,List<Map<String,String>> dataList){
		Map<String,Object> map=new HashMap<String,Object>();
		List<Map<String,Object>> list=new ArrayList<Map<String,Object>>();
		long totalPages=0; 
		if(totalCount>0){
			totalPages=((totalCount%length==0)?totalCount/length:(totalCount/length+1));
		}
		map.put("data", dataList);
		map.put("start", start);
		map.put("length", length);
		map.put("totalCount", totalCount);
		map.put("totalPage", totalPages);
		list.add(map);
		JSONArray json=JSONArray.fromObject(list);
		return json.toString();
	}
	
	/**
	 * 分页json
	 * 
	 * @param pageNo
	 * @param pageSize
	 * @param totalCount
	 * @param map
	 * @return
	 */
	public static String getStatisticsdataPageJson(int start,int length,long totalCount,List<Map<String,String>> dataList){
		Map<String,Object> map=new HashMap<String,Object>();
		List<Map<String,Object>> list=new ArrayList<Map<String,Object>>();
		long totalPages=0; 
		if(totalCount>0){
			totalPages=((totalCount%length==0)?totalCount/length:(totalCount/length+1));
		}
		map.put("data", dataList);
		map.put("start", start);
		map.put("length", length);
		map.put("totalCount", totalCount);
		map.put("totalPage", totalPages);
		list.add(map);
		JSONArray json=JSONArray.fromObject(list);
		return json.toString();
	}
	/**
	 * 图标json
	 * 
	 * @param pageNo
	 * @param pageSize
	 * @param totalCount
	 * @param map
	 * @return
	 */
	public static String getMarketPageIconJson(List<Map<String,String>> dataList){
		Map<String,Object> map=new HashMap<String,Object>();
		List<Map<String,Object>> list=new ArrayList<Map<String,Object>>();
		List listIconData = new ArrayList<>();
		List listIconPrice = new ArrayList<>();
		map.put("data", dataList);
		list.add(map);
		JSONArray json=JSONArray.fromObject(list);
		return json.toString();
	}
	
	/**
	 * 油脂油料-营养词料等热门品种
	 * 
	 * @param pageNo
	 * @param pageSize
	 * @param totalCount
	 * @param map
	 * @return
	 */
	public static String getCropCategoryJson(List<Map<String,String>> dataList,List<Map<String,String>> dataList1,List<Map<String,String>> dataList2){
		Map<String,Object> map=new HashMap<String,Object>();
		List<Map<String,Object>> list=new ArrayList<Map<String,Object>>();
		List listIconData = new ArrayList<>();
		List listIconPrice = new ArrayList<>();
		map.put("youzhiremen", dataList);
		map.put("youzhiyouchang", dataList1);
		map.put("yingyangremen", dataList2);
		list.add(map);
		JSONArray json=JSONArray.fromObject(list);
		return json.toString();
	}
	
	/**
	 * 判断字符串是否为空
	 * @param str
	 * @return
	 */
	public static boolean isEmpty(String str){
		if(str==""||str==null||str.length()==0){
			return true;
		}else{
			return false;
		}
	}
	
	public static String returnStr(Object str){
		if(str==""||str==null){
			return "";
		}else{
			return str.toString();
		}
	}
	
	public static int returnInt(Object str){
		String returnStr=returnStr(str);
		if(returnStr==""||str==null){
			return 0;
		}else{
			return Integer.valueOf(returnStr);
		}
	}
	
	public static String returnINSQL(String str){
		String returnSQL="";
		if(!isEmpty(str)){
			StringBuffer bf=new StringBuffer();
			String[] strs=str.split(",");
			for(int i=0;i<strs.length;i++){
				
			}
		}else{
			return returnSQL;
		}
		return returnSQL;
	}
	
	/**
     * 提供精确加法计算的add方法
     * @param value1 被加数
     * @param value2 加数
     * @return 两个参数的和
     */
    public static double add(double value1,double value2){
        BigDecimal b1 = new BigDecimal(Double.valueOf(value1));
        BigDecimal b2 = new BigDecimal(Double.valueOf(value2));
        return b1.add(b2).doubleValue();
    }
    
    /**
     * 提供精确减法运算的sub方法
     * @param value1 被减数
     * @param value2 减数
     * @return 两个参数的差
     */
    public static double sub(double value1,double value2){
        BigDecimal b1 = new BigDecimal(Double.valueOf(value1));
        BigDecimal b2 = new BigDecimal(Double.valueOf(value2));
        return b1.subtract(b2).doubleValue();
    }
    
    /**
     * 提供精确乘法运算的mul方法
     * @param value1 被乘数
     * @param value2 乘数
     * @return 两个参数的积
     */
    public static double mul(double value1,double value2){
        BigDecimal b1 = new BigDecimal(Double.valueOf(value1));
        BigDecimal b2 = new BigDecimal(Double.valueOf(value2));
        return b1.multiply(b2).doubleValue();
    }
    
    /**
     * 提供精确的除法运算方法div
     * @param value1 被除数
     * @param value2 除数
     * @param scale 精确范围
     * @return 两个参数的商
     * @throws IllegalAccessException
     */
    public static double div(double value1,double value2,int scale) throws IllegalAccessException{
        //如果精确范围小于0，抛出异常信息
        if(scale<0){         
            throw new IllegalAccessException("精确度不能小于0");
        }
        BigDecimal b1 = new BigDecimal(Double.valueOf(value1));
        BigDecimal b2 = new BigDecimal(Double.valueOf(value2));
        return b1.divide(b2, scale).doubleValue();    
    }
    
    //金额验证  
    public static boolean isNumber(String str){   
         Pattern pattern=Pattern.compile("^(([1-9]{1}\\d*)|([0]{1}))(\\.(\\d){0,2})?$"); // 判断小数点后2位的数字的正则表达式  
         Matcher match=pattern.matcher(str);   
         if(match.matches()==false){   
            return false;   
         }else{   
            return true;   
         }   
     }  
}
