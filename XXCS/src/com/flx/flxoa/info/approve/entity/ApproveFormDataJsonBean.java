package com.flx.flxoa.info.approve.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * 类名称：ApproveFormDataJsonBean.java
 * 类描述：
 * 创建时间：2018-4-27, 下午3:26:08
 * 
 * @version 1.0 
 * @since JDK版本 1.7
 * @author 刘凯 
 */
public class ApproveFormDataJsonBean {

	//英文缩写
	private String key;
	//中文字段
	private String name;
	//是否关键字
	private String iskeyword;
	//页面显示类型
	private String type;
	//用户登录，自动带入的绑定数据
	private String binding_data;
	//type值为1、2时对应枚举类型
	private String enumeration_name;
	//是否可编辑
	private String iseditable;
	//该字段有固定子集字段：“list_category”,用来标识“明细列”类型数据页面显示。
	private List<ApproveFormDataJsonBean> list_items = new ArrayList<ApproveFormDataJsonBean>();
	//type选5时，标识所要引用的页面的“请求”关键字
	private String quoteid;
	//弹框请求页面所要返回到申请表单页面的需求值
	private String return_value;
	//求和
	private String is_sum;
	//给页面返回json模板同时  formData数据放入value里面
	private String value;
	
	public String getIs_sum() {
		return is_sum;
	}
	public void setIs_sum(String is_sum) {
		this.is_sum = is_sum;
	}
	public List<ApproveFormDataJsonBean> getList_items() {
		return list_items;
	}
	public void setList_items(List<ApproveFormDataJsonBean> list_items) {
		this.list_items = list_items;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getIskeyword() {
		return iskeyword;
	}
	public void setIskeyword(String iskeyword) {
		this.iskeyword = iskeyword;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getBinding_data() {
		return binding_data;
	}
	public void setBinding_data(String binding_data) {
		this.binding_data = binding_data;
	}
	public String getEnumeration_name() {
		return enumeration_name;
	}
	public void setEnumeration_name(String enumeration_name) {
		this.enumeration_name = enumeration_name;
	}
	public String getIseditable() {
		return iseditable;
	}
	public void setIseditable(String iseditable) {
		this.iseditable = iseditable;
	}
	public String getQuoteid() {
		return quoteid;
	}
	public void setQuoteid(String quoteid) {
		this.quoteid = quoteid;
	}
	public String getReturn_value() {
		return return_value;
	}
	public void setReturn_value(String return_value) {
		this.return_value = return_value;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	
}
