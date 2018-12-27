package com.flx.flxoa.info.contractmanagement.dao.impl;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.flx.flxoa.info.contractmanagement.entity.FlxoaContractInformation;
import com.flx.flxoa.info.contractmanagement.dao.FlxoaContractInformationDao;
import org.springframework.stereotype.Repository;
import com.flx.flxoa.common.hibernate3.HibernateBaseDao;
import com.flx.flxoa.common.util.CommonUtils;
import com.flx.flxoa.common.util.DateUtils;

/**
 *
 * 类名称：FlxoaContractInformationDaoImpl.java
 * 类描述：
 * 创建时间：2018-09-04, 上午09:26:56
 *
 * @version 1.0 
 * @since JDK版本1.7 
 * @author 夏改翠 
 */ 
@Repository
public class FlxoaContractInformationDaoImpl extends HibernateBaseDao<FlxoaContractInformation, Integer> implements FlxoaContractInformationDao {
	/**
	 *添加FlxoaContractInformation
	 */ 
	public boolean add(FlxoaContractInformation flxoaContractInformation) {
		return save(flxoaContractInformation);
	}
	/**
	 *删除FlxoaContractInformation
	 */ 
	public boolean delete(FlxoaContractInformation flxoaContractInformation) {
		flxoaContractInformation.setDeleteFlag("1");
		return save(flxoaContractInformation);
	}
	/**
	 *修改FlxoaContractInformation
	 */ 
	public boolean update(FlxoaContractInformation flxoaContractInformation) {
		return modify(flxoaContractInformation);
	}
	/**
	 *查询FlxoaContractInformation列表
	 */ 
	public List<FlxoaContractInformation> query(FlxoaContractInformation flxoaContractInformation) {
		String hql = " from FlxoaContractInformation where delete_flag = '0' ";
		return getListByHQL(hql, null);
	}
	/**
	 *查询FlxoaContractInformation ByID
	 */ 
	public FlxoaContractInformation queryById(FlxoaContractInformation flxoaContractInformation) {
		return get(flxoaContractInformation.getId());
	}
	/**
	 *分页FlxoaContractInformation pageNo 查询第几页数据  pageSize 每一页显示的数量 
	 */ 
	public List<FlxoaContractInformation> queryForPage(int pageNo,int pageSize,FlxoaContractInformation flxoaContractInformation) {
		String hql = " from FlxoaContractInformation where delete_flag = '0' ";
		return queryForPageByHQL(pageNo, pageSize, hql);
	}
	/**
	 *查询FlxoaContractInformation数据条数 
	 */ 
	public Long queryCount(FlxoaContractInformation flxoaContractInformation) {
		String hql = "select count(*) from FlxoaContractInformation where delete_flag = '0' ";
		return countByHql(hql,null);
	}
	
	@Override
	protected Class<FlxoaContractInformation> getEntityClass() {
		return FlxoaContractInformation.class;
	}
	/**
	 * 分页查询合同信息列表
	 */
	@Override
	public String queryContractList(Map<String, String> map) {
		
		String hql ="  FROM  flxoa_contract_information A LEFT JOIN flxoa_project_information B " +
				" ON A.project_id = B.id  LEFT JOIN flxoa_system_user C ON A.signatory_id = C.id where  A.delete_flag='0' ";
		int start=Integer.valueOf(map.get("start"));
		int length=Integer.valueOf(map.get("length"));
		String draw = map.get("draw");
		//查询条件
		String contractType = map.get("contractType");
		String contractNumber = map.get("contractNumber");
		String contractName = map.get("contractName");
		String contractAmountS = map.get("contractAmountS");
		String contractAmountE = map.get("contractAmountE");
		String contractDataStart = map.get("contractDataStart");
		String contractDataEnd = map.get("contractDataEnd");
		String projName = map.get("projName");
		String signatoryName = map.get("signatoryName");
		if(!CommonUtils.isEmpty(contractType)){
			hql+=" and A.contract_type = '"+contractType+"' ";
		}if(!CommonUtils.isEmpty(contractNumber)){
			hql+=" and A.sales_contract_number like '%"+contractNumber+"%' ";
		}if(!CommonUtils.isEmpty(contractName)){
			hql+=" and A.sales_contract_name like '%"+contractName+"%' ";
		}if(!CommonUtils.isEmpty(contractAmountS)&&CommonUtils.isEmpty(contractAmountE)){
			hql+=" and A.contract_amount ='"+contractAmountS+"' ";
		}if(!CommonUtils.isEmpty(contractAmountS)&&!CommonUtils.isEmpty(contractAmountE)){
			hql+="  and A.contract_amount >'"+contractAmountS+"'  and A.contract_amount <='"+contractAmountE+"'";
		}if(!CommonUtils.isEmpty(contractDataStart)&&CommonUtils.isEmpty(contractDataEnd)){
			hql+=" and A.contract_data ='"+DateUtils.dateToTimestamp(contractDataStart)+"' ";
		}if(!CommonUtils.isEmpty(contractDataStart)&&!CommonUtils.isEmpty(contractDataEnd)){
			hql+="  and A.contract_data >'"+DateUtils.dateToTimestamp(contractDataStart)+"'  and A.contract_data <='"+DateUtils.dateToTimestamp(contractDataEnd)+"'";
		}if(!CommonUtils.isEmpty(projName)){
			hql+=" and B.proj_number like '%"+projName+"%' ";
		}if(!CommonUtils.isEmpty(signatoryName)){
			hql+=" and C.real_name like '%"+signatoryName+"%' ";
		}
		
		
		//hql += " order by A.create";
		//查询sql
		String querySql = " SELECT 	A.id,A.contract_type," +
				"A.sales_contract_number,A.sales_contract_name,	" +
				"A.contract_amount,	B.proj_number,	A.party_A,	A.party_B,	A.contract_data," +
				"C.real_name,	A.storage_position,	A.is_register_flag "+hql; 
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
			dataMap.put("contractType", String.valueOf(obj[1]));
			dataMap.put("salesContractNumber", String.valueOf(obj[2]));
			dataMap.put("salesContractName", String.valueOf(obj[3]));
			dataMap.put("contractAmount", String.valueOf(obj[4]));
			dataMap.put("projNumber", String.valueOf(obj[5]));
			dataMap.put("partyA", String.valueOf(obj[6]));
			dataMap.put("partyB", String.valueOf(obj[7]));
			dataMap.put("contractData", String.valueOf(obj[8]));			
			dataMap.put("signatoryName", String.valueOf(obj[9]));
			dataMap.put("storagePosition", String.valueOf(obj[10]));
			dataMap.put("registerFlag", String.valueOf(obj[11]));			
			
			dataList.add(dataMap);
		}
		Long totalCount= countBySql(countSql,null);
		Map<String,String> otherDataMap=new HashMap<String,String>();
		return CommonUtils.getPageJson(start, length,draw,totalCount,dataList,otherDataList);
	} 

	public List<Map<String,String>> queryContractById(int id){
		
		String sql=" select A.id,A.project_id,B.proj_number,B.proj_name,A.contracts_number,A.is_register_flag,A.contract_type, " +
				"A.sales_contract_number,A.sales_contract_name,A.purchase_contract_number,A.purchase_contract_name,A.contract_amount," +
				" A.party_A,A.party_B,A.party_C,C.real_name AS signatoryName," +
				"D.real_name AS handoverName,A.contract_data,A.storage_position,A.repay_method,A.warranty_period,A.contract_end_data," +
				"A.comments,A.signatory_id,A.handover_id,A.form_id,A.transfer_date " +
				",A.contract_scanningcopy,A.warranty_money FROM flxoa_contract_information A  LEFT JOIN flxoa_project_information  B ON A.project_id=B.id " +
				" LEFT JOIN  flxoa_system_user C ON signatory_id = C.id " +
				" LEFT JOIN  flxoa_system_user D ON handover_id = D.id  where A.id='"+id+"' ";
		
		List<Object> list = querySQL(sql,null);		
		List<Map<String,String>> dataList = new ArrayList<Map<String,String>>();
		for(int i=0;i<list.size();i++){
			Object[] obj=(Object[]) list.get(i);
			Map<String,String> dataMap = new HashMap<String,String>();
			dataMap.put("id", String.valueOf(obj[0]));
			dataMap.put("projId", String.valueOf(obj[1]));
			dataMap.put("projNumber", String.valueOf(obj[2]));
			dataMap.put("projName", String.valueOf(obj[3]));
			dataMap.put("contractNumber", String.valueOf(obj[4]));//合同原件数
			dataMap.put("registerFlag", String.valueOf(obj[5]));//是否登记
			dataMap.put("contractType", String.valueOf(obj[6]));
			dataMap.put("salesContractNumber", String.valueOf(obj[7]));
			dataMap.put("salesContractName", String.valueOf(obj[8]));
			dataMap.put("purchaseContractNumber", String.valueOf(obj[9]));
			dataMap.put("purchaseContractName", String.valueOf(obj[10]));
			dataMap.put("contractAmount", String.valueOf(obj[11]));
			dataMap.put("partyA", String.valueOf(obj[12]));
			dataMap.put("partyB", String.valueOf(obj[13]));
			dataMap.put("partyC", String.valueOf(obj[14]));
			dataMap.put("signatoryName", String.valueOf(obj[15]));
			dataMap.put("handoverName", String.valueOf(obj[16]));
			dataMap.put("contractData", String.valueOf(obj[17]));			
			dataMap.put("storagePosition", String.valueOf(obj[18]));
			dataMap.put("repayMethod", String.valueOf(obj[19]));			
			dataMap.put("warrantyPeriod", String.valueOf(obj[20]));			
			dataMap.put("contractEndata", String.valueOf(obj[21]));			
			dataMap.put("comments", String.valueOf(obj[22]));			
			dataMap.put("signatoryId", String.valueOf(obj[23]));			
			dataMap.put("handoverId", String.valueOf(obj[24]));
			dataMap.put("formId", String.valueOf(obj[25]));
			dataMap.put("transferDate", String.valueOf(obj[26]));
			dataMap.put("contractScanningcopy",String.valueOf(obj[27]));//是否有扫描件
			dataMap.put("warrantyMoney", String.valueOf(obj[28]));
			dataList.add(dataMap);
		}
		
		return dataList;
	}
}