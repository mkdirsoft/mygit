package com.flx.flxoa.info.contractmanagement.dao.impl;


import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.flx.flxoa.info.contractmanagement.entity.FlxoaContractLoanreturn;
import com.flx.flxoa.info.contractmanagement.dao.FlxoaContractLoanreturnDao;

import org.springframework.stereotype.Repository;
import com.flx.flxoa.common.hibernate3.HibernateBaseDao;
import com.flx.flxoa.common.util.CommonUtils;
import com.flx.flxoa.common.util.DateUtils;

/**
 *
 * 类名称：FlxoaContractLoanreturnDaoImpl.java
 * 类描述：
 * 创建时间：2018-09-04, 上午09:26:56
 *
 * @version 1.0 
 * @since JDK版本1.7 
 * @author 夏改翠 
 */ 
@Repository
public class FlxoaContractLoanreturnDaoImpl extends HibernateBaseDao<FlxoaContractLoanreturn, Integer> implements FlxoaContractLoanreturnDao {
	/**
	 *添加FlxoaContractLoanreturn
	 */ 
	public boolean add(FlxoaContractLoanreturn flxoaContractLoanreturn) {
		return save(flxoaContractLoanreturn);
	}
	/**
	 *删除FlxoaContractLoanreturn
	 */ 
	public boolean delete(FlxoaContractLoanreturn flxoaContractLoanreturn) {
		flxoaContractLoanreturn.setDeleteFlag("1");
		return save(flxoaContractLoanreturn);
	}
	/**
	 *修改FlxoaContractLoanreturn
	 */ 
	public boolean update(FlxoaContractLoanreturn flxoaContractLoanreturn) {
		return modify(flxoaContractLoanreturn);
	}
	/**
	 *查询FlxoaContractLoanreturn列表
	 */ 
	public List<FlxoaContractLoanreturn> query(FlxoaContractLoanreturn flxoaContractLoanreturn) {
		String hql = " from FlxoaContractLoanreturn where delete_flag = '0' ";
		return getListByHQL(hql, null);
	}
	/**
	 *查询FlxoaContractLoanreturn ByID
	 */ 
	public FlxoaContractLoanreturn queryById(FlxoaContractLoanreturn flxoaContractLoanreturn) {
		return get(flxoaContractLoanreturn.getId());
	}
	/**
	 *分页FlxoaContractLoanreturn pageNo 查询第几页数据  pageSize 每一页显示的数量 
	 */ 
	public List<FlxoaContractLoanreturn> queryForPage(int pageNo,int pageSize,FlxoaContractLoanreturn flxoaContractLoanreturn) {
		String hql = " from FlxoaContractLoanreturn where delete_flag = '0' ";
		return queryForPageByHQL(pageNo, pageSize, hql);
	}
	/**
	 *查询FlxoaContractLoanreturn数据条数 
	 */ 
	public Long queryCount(FlxoaContractLoanreturn flxoaContractLoanreturn) {
		String hql = "select count(*) from FlxoaContractLoanreturn where delete_flag = '0' ";
		return countByHql(hql,null);
	}
	
	@Override
	protected Class<FlxoaContractLoanreturn> getEntityClass() {
		return FlxoaContractLoanreturn.class;
	}
	//查询合同借出列表
	@Override
	public String queryPageContractLoan(Map<String, String> map) {
		//借出查询前，借出类型为扫描件，到预计归还时间时 ，借出状态自动改为 已归还
		//当前时间
		Date date=new Date();		
		String changeHql = " from FlxoaContractLoanreturn  WHERE loan_type=1 AND loan_status='1' AND estimate_return <="+DateUtils.getSecondTimestamp(date)+" ";
		
		List<FlxoaContractLoanreturn>  chList = getListByHQL(changeHql,null);
		if(chList.size()>0){
			//查询前先进行修改loan_status的值
			String updateSql="UPDATE flxoa_contract_loanreturn A ,flxoa_contract_loanreturn B SET A.loan_status='2',A.return_people=B.create_user_id," +
					"A.return_time=B.estimate_return,A.remarks='扫描件自动归还' " +
					" WHERE A.id=B.id AND A.loan_type=1 AND A.loan_status='1' AND A.estimate_return <="+DateUtils.getSecondTimestamp(date)+" ";
			executeSql(updateSql);
		}
		String hql =" FROM  flxoa_contract_loanreturn A LEFT JOIN flxoa_contract_information B ON A.contract_id=B.id " +
					" LEFT JOIN flxoa_system_user C ON A.create_user_id=C.id " +
					" LEFT JOIN flxoa_system_user D ON A.loan_people=D.id " +
					" LEFT JOIN flxoa_system_user E ON A.return_people=E.id " +
					" LEFT JOIN ( SELECT data_value AS projNumber ,form_id FROM flxoa_approve_formdata LEFT JOIN flxoa_approve_form  ON flxoa_approve_formdata.form_id=flxoa_approve_form.id " +
					" WHERE flxoa_approve_form.template_id='36' AND flxoa_approve_formdata.data_key='projNumber' ) AS F ON A.form_id = F.form_id " +
					" LEFT JOIN ( SELECT data_value as projName, form_id FROM flxoa_approve_formdata LEFT JOIN flxoa_approve_form  ON flxoa_approve_formdata.form_id=flxoa_approve_form.id " +
					" WHERE flxoa_approve_form.template_id='36' AND flxoa_approve_formdata.data_key='projName' ) AS G ON A.form_id = G.form_id " +
					" LEFT JOIN ( SELECT data_value as purpose, form_id FROM flxoa_approve_formdata LEFT JOIN flxoa_approve_form  ON flxoa_approve_formdata.form_id=flxoa_approve_form.id " +
					" WHERE flxoa_approve_form.template_id='36' AND flxoa_approve_formdata.data_key='purpose' ) AS H ON A.form_id = H.form_id " +
					" WHERE A.delete_flag='0' ";
		
		int start=Integer.valueOf(map.get("start"));
		int length=Integer.valueOf(map.get("length"));
		String draw = map.get("draw");
		//查询条件
		String loanStatus = map.get("loanStatus");
		String contractNumber = map.get("contractNumber");
		String contractName = map.get("contractName");
		String projNumber = map.get("projNumber");
		String contractDataStart = map.get("contractDataStart");
		String contractDataEnd = map.get("contractDataEnd");
		String sqrzName = map.get("sqrzName");
		if(!CommonUtils.isEmpty(loanStatus)){
			hql+=" and A.loan_status = '"+loanStatus+"' ";
		}if(!CommonUtils.isEmpty(contractNumber)){
			hql+=" and B.sales_contract_number like '%"+contractNumber+"%' ";
		}if(!CommonUtils.isEmpty(contractName)){
			hql+=" and B.sales_contract_name like '%"+contractName+"%' ";
		}if(!CommonUtils.isEmpty(contractDataStart)&&CommonUtils.isEmpty(contractDataEnd)){
			hql+=" and A.create_time ='"+DateUtils.dateToTimestamp(contractDataStart)+"' ";
		}if(!CommonUtils.isEmpty(contractDataStart)&&!CommonUtils.isEmpty(contractDataEnd)){
			hql+="  and A.create_time >'"+DateUtils.dateToTimestamp(contractDataStart)+"'  and A.create_time <='"+DateUtils.dateToTimestamp(contractDataEnd)+"'";
		}if(!CommonUtils.isEmpty(projNumber)){
			hql+=" and F.projNumber like '%"+projNumber+"%' ";
		}if(!CommonUtils.isEmpty(sqrzName)){
			hql+=" and C.real_name  like '%"+sqrzName+"%' ";
		}
		
		
		hql += " ORDER BY A.create_time DESC ";
		//查询sql
		String querySql = " SELECT A.id,A.contract_id,A.form_id,A.loan_type,A.estimate_return,A.loan_time,A.return_time,A.loan_status," +
				" A.create_time,C.real_name as sqr,D.real_name As jcr ,E.real_name as ghr ,F.projNumber,G.projName ,H.purpose,B.sales_contract_number,B.sales_contract_name,A.remarks "+hql; 
		//求和查询sql
		String countSql="select count(*) "+hql;
		//查询的List
		List list= queryListForPageBySQL(start, length, querySql);
		List<Map<String,String>> dataList=new ArrayList<Map<String,String>>();
		List<Map<String,String>> otherDataList=new ArrayList<Map<String,String>>();
		//遍历list 放入 dataList
		for(int i=0;i<list.size();i++){
			Map<String,String> dataMap = new HashMap<String,String>();
			Object[] obj=(Object[]) list.get(i);			
			dataMap.put("id", String.valueOf(obj[0]));
			dataMap.put("contractId", String.valueOf(obj[1]));
			dataMap.put("formId", String.valueOf(obj[2]));
			dataMap.put("loanType", String.valueOf(obj[3]));
			dataMap.put("estimateReturn", String.valueOf(obj[4]));
			dataMap.put("loanTime", String.valueOf(obj[5]));
			dataMap.put("returnTime", String.valueOf(obj[6]));
			dataMap.put("loanStatus", String.valueOf(obj[7]));//借出状态
			dataMap.put("createTime", String.valueOf(obj[8]));//申请时间			
			dataMap.put("sqrName", String.valueOf(obj[9]));//申请人name
			dataMap.put("jcrName", String.valueOf(obj[10]));//借出人name
			dataMap.put("ghrName", String.valueOf(obj[11]));//归还人name			
			dataMap.put("projNumber", String.valueOf(obj[12]));
			dataMap.put("projName", String.valueOf(obj[13]));
			dataMap.put("purpose", String.valueOf(obj[14]));//用途
			dataMap.put("sales_contract_number", String.valueOf(obj[15]));
			dataMap.put("sales_contract_name", String.valueOf(obj[16]));
			dataMap.put("remarks", String.valueOf(obj[17]));
			dataList.add(dataMap);
		}
		Long totalCount= countBySql(countSql,null);
		Map<String,String> otherDataMap=new HashMap<String,String>();
		return CommonUtils.getPageJson(start, length,draw,totalCount,dataList,otherDataList);
	} 

}