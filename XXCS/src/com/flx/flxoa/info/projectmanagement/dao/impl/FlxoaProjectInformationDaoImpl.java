package com.flx.flxoa.info.projectmanagement.dao.impl;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.flx.flxoa.info.projectmanagement.entity.FlxoaProjectBidInformation;
import com.flx.flxoa.info.projectmanagement.entity.FlxoaProjectInformation;
import com.flx.flxoa.info.projectmanagement.dao.FlxoaProjectInformationDao;

import org.springframework.stereotype.Repository;
import com.flx.flxoa.common.hibernate3.HibernateBaseDao;
import com.flx.flxoa.common.util.CommonUtils;
import com.flx.flxoa.common.util.DateUtils;

/**
 *
 * 类名称：FlxoaProjectInformationDaoImpl.java
 * 类描述：
 * 创建时间：2018-03-16, 下午03:28:25
 *
 * @version 1.0 
 * @since JDK版本1.7 
 * @author 雷君 
 */ 
@Repository
public  class FlxoaProjectInformationDaoImpl extends HibernateBaseDao<FlxoaProjectInformation, Integer> implements FlxoaProjectInformationDao {

	/**
	 *添加FlxoaProjectInformation
	 */ 
	public boolean add(FlxoaProjectInformation flxoaProjectInformation) {
		return save(flxoaProjectInformation);
	}
	/**
	 *删除FlxoaProjectInformation
	 */ 
	public boolean delete(FlxoaProjectInformation flxoaProjectInformation) {
		flxoaProjectInformation.setDeleteFlag("1");
		return save(flxoaProjectInformation);
	}

	/**
	 *修改FlxoaProjectInformation
	 */ 
	public boolean update(FlxoaProjectInformation flxoaProjectInformation) {
		return modify(flxoaProjectInformation);
	}
	@Override
	public boolean isExist(String projectName) {
		String hql="from FlxoaProjectInformation where proj_name='"+projectName+"' ";
		List list=queryByHQL(hql);
		if(list.size()<1){
			return true;
		}
		return false;
	}
	/**
	 *查询FlxoaProjectInformation列表
	 */ 
	public List<FlxoaProjectInformation> queryExcel(FlxoaProjectInformation flxoaProjectInformation,int userId,String deptIds) {
		
		/*String parm="";
		if(deptIds.indexOf(",") >= 0){
			String [] deptids= deptIds.split(",");
			for(int i=0;i<deptids.length;i++){
				parm += "  flxoa_project_information.create_department_id = "+deptids[i]+"  or";
			}
			parm = parm.substring(0,parm.length()-2);
		}
		else{
			parm = "  flxoa_project_information.create_department_id = "+deptIds+" ";
		}*/
		String parm="  flxoa_project_information.create_department_id in("+deptIds+")";
		if(deptIds.indexOf(",") <=0){
			parm="  flxoa_project_information.create_department_id = "+deptIds;
		}
		String sql=" select "
				+ "flxoa_project_information.id , "
				+ "flxoa_project_information.proj_number , "
				+ "flxoa_project_information.proj_name , "
				+ "flxoa_project_information.design_company , "
				+ "flxoa_project_information.create_time , "
				+ "flxoa_project_information.proj_end_time , "
				+ "flxoa_project_information.signatory , "
				+ "flxoa_project_information.signatory_name , "
				+ "flxoa_project_information.signatory_telephone , "
				+ "flxoa_project_information.delete_flag , "
				+ "flxoa_project_information.whether_follow , "
				+ "flxoa_project_information.client_name , "
				+ "flxoa_project_information.predict_contract_money , "
				+ "flxoa_project_information.predict_bids_time , "
				+ "flxoa_project_information.project_leader , "
				+ "proj_state.enumeration_value proj_state_type , "
				+ "proj_stage.enumeration_value proj_stage_type , "
				+ "proj_type.enumeration_value proj_type_type , "
				+ "proj_attribute.enumeration_value proj_attribute_type , "
				+ "design_company.enumeration_value designcompanys , "
				+ "flxoa_project_information.create_department_id , "
				+ "flxoa_project_information.create_user_id , "
				+ "flxoa_project_focus.flag , "
				+ "flxoa_project_focus.id foucsid "
				+ "from "
				+ "flxoa_project_information "
				+ "left join"
				+ "( "
				+ "select "
				+ "flxoa_system_enumeration.enumeration_value , "
				+ "flxoa_system_enumeration.enumeration_key "
				+ "from "
				+ "flxoa_system_enumeration "
				+ "where "
				+ "enumeration_name = 'proj_state'"
				+ ") "
				+ "proj_state on flxoa_project_information.proj_state = proj_state.enumeration_key "
				+ "left join"
				+ "( "
				+ "select "
				+ "flxoa_system_enumeration.enumeration_value , "
				+ "flxoa_system_enumeration.enumeration_key "
				+ "from "
				+ "flxoa_system_enumeration "
				+ "where "
				+ "enumeration_name = 'proj_stage'"
				+ ") "
				+ "proj_stage on flxoa_project_information.proj_state = proj_stage.enumeration_key "
				+ "left join"
				+ "( "
				+ "select "
				+ "flxoa_system_enumeration.enumeration_value , "
				+ "flxoa_system_enumeration.enumeration_key "
				+ "from "
				+ "flxoa_system_enumeration "
				+ "where "
				+ "enumeration_name = 'proj_type'"
				+ ") "
				+ "proj_type on flxoa_project_information.bus_classification = proj_type.enumeration_key "
				+ "left join"
				+ "( "
				+ "select "
				+ "flxoa_system_enumeration.enumeration_value , "
				+ "flxoa_system_enumeration.enumeration_key "
				+ "from "
				+ "flxoa_system_enumeration "
				+ "where "
				+ "enumeration_name = 'proj_attribute'"
				+ ") "
				+ "proj_attribute on "
				+ "flxoa_project_information.proj_attribute = proj_attribute.enumeration_key "
				+ "left join"
				+ "( "
				+ "select "
				+ "flxoa_system_enumeration.enumeration_value , "
				+ "flxoa_system_enumeration.enumeration_key "
				+ "from "
				+ "flxoa_system_enumeration "
				+ "where "
				+ "enumeration_name = 'designcompany'"
				+ ") "
				+ "design_company on flxoa_project_information.design_company = design_company.enumeration_key "
				+ "left join flxoa_project_focus on flxoa_project_information.id = flxoa_project_focus.project_id";
		sql += "  where flxoa_project_information.delete_flag = '0'  ";
		if(deptIds.length() > 1) {
			//sql += " and  ("+parm+") ";
			sql += " and  "+parm+" ";
		}else if(userId != 0){
			sql += " and  flxoa_project_information.create_user_id = ("+userId+")";
		}
		if(flxoaProjectInformation.getId() != null && !"".equals(flxoaProjectInformation.getId())){
			sql +=" and flxoa_project_information.id = '"+flxoaProjectInformation.getId()+"'";
		}
		if(flxoaProjectInformation.getProjName() != null && !"".equals(flxoaProjectInformation.getProjName())){
			sql +=" and flxoa_project_information.proj_name like '%"+flxoaProjectInformation.getProjName()+"%'";
		}
		if(flxoaProjectInformation.getProjNumber() != null && !"".equals(flxoaProjectInformation.getProjNumber())){
			sql +=" and flxoa_project_information.proj_number like '%"+flxoaProjectInformation.getProjNumber()+"%'";
		}
		if(null != flxoaProjectInformation.getSelectProjectNoHas() && !"".equals(flxoaProjectInformation.getSelectProjectNoHas())){
			if("0".equals(flxoaProjectInformation.getSelectProjectNoHas())){
				sql +=" and flxoa_project_information.proj_number = '' ";
			}else{
				sql +=" and flxoa_project_information.proj_number <> '' ";
			}
		}		

		List list = getListBySQL(sql);
		System.out.println(list);
		List<FlxoaProjectInformation> formList = new ArrayList<FlxoaProjectInformation>();
		for (int i = 0; i < list.size(); i++) {
			FlxoaProjectInformation form = new FlxoaProjectInformation();
			Object[] objects = (Object[])list.get(i);
			form.setId((Integer)objects[0]);
			form.setProjNumber(String.valueOf(objects[1]));
			form.setProjName(String.valueOf(objects[2]));
			form.setDesigncompanys(String.valueOf(objects[3]));
			form.setCreateTime((Integer)objects[4]);
			form.setProjEndTime((Integer)objects[5]);
			form.setSignatory(String.valueOf(objects[6]));
			form.setSignatoryName(String.valueOf(objects[7]));
			form.setSignatoryTelephone(String.valueOf(objects[8]));
			form.setDeleteFlag(String.valueOf(objects[9]));
			form.setWhetherFollow(String.valueOf(objects[10]));
			form.setClientName(String.valueOf(objects[11]));
			form.setPredictContractMoney(String.valueOf(objects[12]));
			form.setPredictBidsTime((Integer)objects[13]);
			form.setProjectLeader(String.valueOf(objects[14]));
			form.setProj_state_type(String.valueOf(objects[15]));
			form.setProj_stage_type(String.valueOf(objects[16]));
			form.setProj_type_type(String.valueOf(objects[17]));
			form.setProj_attribute_type(String.valueOf(objects[18]));
			form.setDesigncompanys(String.valueOf(objects[19]));
			form.setCreateDepartmentId((Integer)objects[20]);
			form.setCreateUserId((Integer)objects[21]);
			form.setFlag(String.valueOf(objects[22]));
			formList.add(form);
		}
		return formList;
	}
	/**
	 *查询FlxoaProjectInformation列表
	 */ 
	public  ConcurrentHashMap<String, Object> query(FlxoaProjectInformation flxoaProjectInformation,int userId,String deptIds,int start,int length) {
		
		/*String parm="";
		if(deptIds.indexOf(",") >= 0){
			String [] deptids= deptIds.split(",");
			for(int i=0;i<deptids.length;i++){
				parm += "  flxoa_project_information.create_department_id = "+deptids[i]+"  or";
			}
			parm = parm.substring(0,parm.length()-2);
		}
		else{
			parm = "  flxoa_project_information.create_department_id = "+deptIds+" ";
		}*/
		String parm="  flxoa_project_information.create_department_id in("+deptIds+")";
		if(deptIds.indexOf(",") <=0){
			parm="  flxoa_project_information.create_department_id = "+deptIds;
		}
		String sql=" select "
				+ "flxoa_project_information.id , "
				+ "flxoa_project_information.proj_number , "
				+ "flxoa_project_information.proj_name , "
				+ "flxoa_project_information.design_company , "
				+ "flxoa_project_information.create_time , "
				+ "flxoa_project_information.whether_follow , "
				+ "flxoa_project_information.signatory , "
				+ "flxoa_project_information.signatory_name , "
				+ "flxoa_project_information.signatory_telephone , "
				+ "flxoa_project_information.delete_flag , "
				+ "flxoa_project_information.client_name , "
				+ "flxoa_project_information.predict_contract_money , "
				+ "flxoa_project_information.predict_bids_time , "
				+ "flxoa_project_information.project_leader , "
				+ "proj_state.enumeration_value proj_state_type , "
				+ "proj_stage.enumeration_value proj_stage_type , "
				+ "proj_type.enumeration_value proj_type_type , "
				+ "proj_attribute.enumeration_value proj_attribute_type , "
				+ "design_company.enumeration_value designcompanys , "
				+ "flxoa_project_information.create_department_id , "
				+ "flxoa_project_information.create_user_id , "
				+ "flxoa_project_focus.flag , "
				+ "flxoa_project_focus.id foucsid "
				+ "from "
				+ "flxoa_project_information "
				+ "left join"
				+ "( "
				+ "select "
				+ "flxoa_system_enumeration.enumeration_value , "
				+ "flxoa_system_enumeration.enumeration_key "
				+ "from "
				+ "flxoa_system_enumeration "
				+ "where "
				+ "enumeration_name = 'proj_state'"
				+ ") "
				+ "proj_state on flxoa_project_information.proj_state = proj_state.enumeration_key "
				+ "left join"
				+ "( "
				+ "select "
				+ "flxoa_system_enumeration.enumeration_value , "
				+ "flxoa_system_enumeration.enumeration_key "
				+ "from "
				+ "flxoa_system_enumeration "
				+ "where "
				+ "enumeration_name = 'proj_stage'"
				+ ") "
				+ "proj_stage on flxoa_project_information.proj_state = proj_stage.enumeration_key "
				+ "left join"
				+ "( "
				+ "select "
				+ "flxoa_system_enumeration.enumeration_value , "
				+ "flxoa_system_enumeration.enumeration_key "
				+ "from "
				+ "flxoa_system_enumeration "
				+ "where "
				+ "enumeration_name = 'proj_type'"
				+ ") "
				+ "proj_type on flxoa_project_information.bus_classification = proj_type.enumeration_key "
				+ "left join"
				+ "( "
				+ "select "
				+ "flxoa_system_enumeration.enumeration_value , "
				+ "flxoa_system_enumeration.enumeration_key "
				+ "from "
				+ "flxoa_system_enumeration "
				+ "where "
				+ "enumeration_name = 'proj_attribute'"
				+ ") "
				+ "proj_attribute on "
				+ "flxoa_project_information.proj_attribute = proj_attribute.enumeration_key "
				+ "left join"
				+ "( "
				+ "select "
				+ "flxoa_system_enumeration.enumeration_value , "
				+ "flxoa_system_enumeration.enumeration_key "
				+ "from "
				+ "flxoa_system_enumeration "
				+ "where "
				+ "enumeration_name = 'designcompany'"
				+ ") "
				+ "design_company on flxoa_project_information.design_company = design_company.enumeration_key "
				+ "left join flxoa_project_focus on flxoa_project_information.id = flxoa_project_focus.project_id";
		sql += "  where flxoa_project_information.delete_flag = '0'  ";
		if(deptIds.length() > 1) {
			//sql += " and  ("+parm+") ";
			sql += " and  "+parm+" ";
		}else if(userId != 0){
			sql += " and  flxoa_project_information.create_user_id = ("+userId+")";
		}
		if(flxoaProjectInformation.getId() != null && !"".equals(flxoaProjectInformation.getId())){
			sql +=" and flxoa_project_information.id = '"+flxoaProjectInformation.getId()+"'";
		}
		if(flxoaProjectInformation.getProjName() != null && !"".equals(flxoaProjectInformation.getProjName())){
			sql +=" and flxoa_project_information.proj_name like '%"+flxoaProjectInformation.getProjName()+"%'";
		}
		if(flxoaProjectInformation.getProjNumber() != null && !"".equals(flxoaProjectInformation.getProjNumber())){
			sql +=" and flxoa_project_information.proj_number like '%"+flxoaProjectInformation.getProjNumber()+"%'";
		}
		if(null != flxoaProjectInformation.getSelectProjectNoHas() && !"".equals(flxoaProjectInformation.getSelectProjectNoHas())){
			if("0".equals(flxoaProjectInformation.getSelectProjectNoHas())){
				sql +=" and flxoa_project_information.proj_number = '' ";
			}else{
				sql +=" and flxoa_project_information.proj_number <> '' ";
			}
		}		

		List list = queryListForPageBySQL(start,length,sql);
		System.out.println(sql);
		String countsql = "select count(*) from ("+sql+") as count";
		long total = countBySql(countsql);
		List<FlxoaProjectInformation> formList = new ArrayList<FlxoaProjectInformation>();
		for (int i = 0; i < list.size(); i++) {
			FlxoaProjectInformation form = new FlxoaProjectInformation();
			Object[] objects = (Object[])list.get(i);
			form.setId((Integer)objects[0]);
			form.setProjNumber(String.valueOf(objects[1]));
			form.setProjName(String.valueOf(objects[2]));
			form.setDesigncompanys(String.valueOf(objects[3]));
			form.setCreateTime((Integer)objects[4]);
			form.setWhetherFollow(String.valueOf(objects[5]));
			form.setSignatory(String.valueOf(objects[6]));
			form.setSignatoryName(String.valueOf(objects[7]));
			form.setSignatoryTelephone(String.valueOf(objects[8]));
			form.setDeleteFlag(String.valueOf(objects[9]));
			form.setWhetherFollow(String.valueOf(objects[10]));
			form.setClientName(String.valueOf(objects[11]));
			form.setPredictContractMoney(String.valueOf(objects[12]));
			if(!"".equals(objects[13]) && null != objects[13]){
				form.setPredictBidsTime(Integer.parseInt(String.valueOf(objects[13])));
				

			}
			form.setProjectLeader(String.valueOf(objects[14]));
			form.setProj_state_type(String.valueOf(objects[15]));
			form.setProj_stage_type(String.valueOf(objects[16]));
			form.setProj_type_type(String.valueOf(objects[17]));
			form.setProj_attribute_type(String.valueOf(objects[18]));
			form.setDesigncompanys(String.valueOf(objects[19]));
			form.setCreateDepartmentId((Integer)objects[20]);
			form.setCreateUserId((Integer)objects[21]);
			form.setFlag(String.valueOf(objects[22]));
			formList.add(form);
		}
		ConcurrentHashMap<String, Object> map = new ConcurrentHashMap<String ,Object>();
		map.put("data", formList);
		map.put("total", total);
		return map;
	}

	/**
	 *查询FlxoaProjectInformation列表
	 */ 
	public List<FlxoaProjectInformation> querySql(FlxoaProjectInformation flxoaProjectInformation) {
		String //hql = " from FlxoaProjectInformation where delete_flag = '0' ";
		sql ="SELECT flxoa_system_enumeration.enumeration_value , flxoa_system_enumeration.enumeration_key , info.count counttype FROM flxoa_system_enumeration LEFT JOIN( SELECT proj_state , count(*) count FROM flxoa_project_information WHERE flxoa_project_information.delete_flag = '0' GROUP BY proj_state) info ON info.proj_state = flxoa_system_enumeration.enumeration_key WHERE enumeration_name = 'proj_state' ORDER BY enumeration_key"; 
		return querySQL(sql, null);
	}
	/**
	 *通过属性查询FlxoaProjectInformation列表
	 */ 
	public List<FlxoaProjectInformation> queryProperty(FlxoaProjectInformation flxoaProjectInformation) {
		String hql = " from FlxoaProjectInformation where delete_flag = '0' ";
		if(flxoaProjectInformation.getProjNumber() != null && !"".equals(flxoaProjectInformation.getProjNumber())){
			hql +=" and proj_number = '"+flxoaProjectInformation.getProjNumber()+"'";
		}
		if(flxoaProjectInformation.getProjStage() != null && !"".equals(flxoaProjectInformation.getProjStage())){
			hql +=" and proj_stage like '%"+flxoaProjectInformation.getProjStage()+"%'";
		}
		if(flxoaProjectInformation.getSignatoryName() !=null && !"".equals(flxoaProjectInformation.getSignatoryName())){
			hql +=" and signatory_name like '%"+flxoaProjectInformation.getSignatoryName()+"%'";
		}
		if(flxoaProjectInformation.getProjStartTime() != null && !"".equals(flxoaProjectInformation.getProjStartTime())){
			hql +=" and time between ' "+flxoaProjectInformation.getProjStartTime()+"' and '"+flxoaProjectInformation.getProjEndTime()+"'";
		}
		if(flxoaProjectInformation.getProjName() != null &&  !"".equals(flxoaProjectInformation.getProjName())){
			hql +=" and proj_name like '%" +flxoaProjectInformation.getProjName()+"%'";
		}
		if(flxoaProjectInformation.getClientName() != null && !"".equals(flxoaProjectInformation.getClientName())) {
			hql +=" and client_name like '%"+flxoaProjectInformation.getClientName()+"%'";
		}
		System.out.println(hql);
		return getListByHQL(hql, null);
	}
	/**
	 * 分页
	 */
	public String queryForPage(int start,int length,String draw,int userId,String deptIds,FlxoaProjectInformation flxoaProjectInformation,String myproj){
		Integer deptmentIDs=0;
		String parm="  flxoa_project_information.create_department_id" ;
		/*if(deptIds.indexOf(",") >= 0){
			String [] deptids= deptIds.split(",");
			for(int i=0;i<deptids.length;i++){
				parm += "  flxoa_project_information.create_department_id = "+deptids[i]+"  or";
			}
			parm = parm.substring(0,parm.length()-2);
		}
		else{
			parm = "  flxoa_project_information.create_department_id = "+deptIds+" ";
		}*/
		String projectFlag = flxoaProjectInformation.getFlag();
		String drawFocus = flxoaProjectInformation.getDrawFoucs();
		String sql=" from "
				+ "flxoa_project_information "
				+ "left join"
				+ "( select "
				+ "flxoa_system_enumeration.enumeration_value , "
				+ "flxoa_system_enumeration.enumeration_key "
				+ "from "
				+ "flxoa_system_enumeration "
				+ "where "
				+ "enumeration_name = 'proj_state'"
				+ ") "
				+ "proj_state on flxoa_project_information.proj_state = proj_state.enumeration_key "
				+ "left join"
				+ "( select "
				+ "flxoa_system_enumeration.enumeration_value , "
				+ "flxoa_system_enumeration.enumeration_key "
				+ "from "
				+ "flxoa_system_enumeration "
				+ "where enumeration_name = 'proj_stage'"
				+ ") "
				+ "proj_stage on flxoa_project_information.proj_state = proj_stage.enumeration_key "
				+ "left join"
				+ "( select "
				+ "flxoa_system_enumeration.enumeration_value , "
				+ "flxoa_system_enumeration.enumeration_key "
				+ "from "
				+ "flxoa_system_enumeration "
				+ "where enumeration_name = 'proj_type'"
				+ ") "
				+ "proj_type on flxoa_project_information.bus_classification = proj_type.enumeration_key "
				+ "left join"
				+ "( select "
				+ "flxoa_system_enumeration.enumeration_value , "
				+ "flxoa_system_enumeration.enumeration_key "
				+ "from flxoa_system_enumeration "
				+ "where "
				+ "enumeration_name = 'proj_attribute'"
				+ ") "
				+ "proj_attribute on flxoa_project_information.proj_attribute = proj_attribute.enumeration_key "
				+ "left join"
				+ "( select "
				+ "flxoa_system_enumeration.enumeration_value , "
				+ "flxoa_system_enumeration.enumeration_key "
				+ "from "
				+ "flxoa_system_enumeration "
				+ "where enumeration_name = 'designcompany'"
				+ ") "
				+ "design_company on flxoa_project_information.design_company = design_company.enumeration_key "
				+ "left join "
				+ "flxoa_project_focus on flxoa_project_information.id = flxoa_project_focus.project_id and flxoa_project_focus.create_user_id ="+userId+" "; 
			sql += "  where flxoa_project_information.delete_flag = '0'  ";
		String arry =flxoaProjectInformation.getProjState();
		System.out.println("部门id列表：===="+deptIds);
		
			if(userId!=1){
				
				if(deptIds.indexOf(",") <=0){
					deptmentIDs=Integer.parseInt(deptIds);
					parm+="="+deptmentIDs;
					sql += " and  flxoa_project_information.create_user_id = ("+userId+")";
				}else{
					//截取最后一位逗号
					String deptId = deptIds.substring(0, deptIds.length()-1);
					parm+=" REGEXP '"+deptId+"'";
					sql += " and  "+parm+"";
				}
				
				
				/*if(deptIds.length() > 1) {
					sql += " and  ("+parm+")  ";
				}else {
					sql += " and  flxoa_project_information.create_user_id = ("+userId+")";
				}*/
			}	
			
			if(flxoaProjectInformation.getFlag() != null && !"".equals(flxoaProjectInformation.getFlag()) && !"2".equals(flxoaProjectInformation.getFlag())) {
				sql +=" and flxoa_project_focus.flag = '"+flxoaProjectInformation.getFlag()+"'";
			}
			if("2".equals(flxoaProjectInformation.getFlag())) {
				sql +=" and flxoa_project_focus.flag is null";
			}
			if(flxoaProjectInformation.getId() != null && !"".equals(flxoaProjectInformation.getId())){
				sql +=" and flxoa_project_information.id = '"+flxoaProjectInformation.getId()+"'";
			}
			if(flxoaProjectInformation.getProjName()!=null&&!"".equals(flxoaProjectInformation.getProjName())&&flxoaProjectInformation.getProjNumber() != null && !"".equals(flxoaProjectInformation.getProjNumber())){
				sql +=" and flxoa_project_information.proj_number like '%"+flxoaProjectInformation.getProjNumber()+"%'"+
						" or flxoa_project_information.proj_name like '%"+flxoaProjectInformation.getProjName()+"%'";
			}else if(flxoaProjectInformation.getProjNumber() != null && !"".equals(flxoaProjectInformation.getProjNumber())){
				sql +=" and flxoa_project_information.proj_number like '%"+flxoaProjectInformation.getProjNumber()+"%'";
			}else if(flxoaProjectInformation.getProjName()!=null&&!"".equals(flxoaProjectInformation.getProjName())){
				sql +=" and flxoa_project_information.proj_name like '%"+flxoaProjectInformation.getProjName()+"%'";
			}
			if(flxoaProjectInformation.getProjectLeader() != null && !"".equals(flxoaProjectInformation.getProjectLeader())){
				sql +=" and flxoa_project_information.project_leader like '%"+flxoaProjectInformation.getProjectLeader()+"%'";
			}
			if(flxoaProjectInformation.getClientName() != null && !"".equals(flxoaProjectInformation.getClientName())) {
				sql +=" and flxoa_project_information.client_name like '%"+flxoaProjectInformation.getClientName()+"%'";
			}
			if(arry !=null && !"".equals(arry)) {
				sql += " and flxoa_project_information.proj_state in ("+arry+")";
			}
			if(!CommonUtils.isEmpty(flxoaProjectInformation.getProjStartDate()) && CommonUtils.isEmpty(flxoaProjectInformation.getProjEndDate())) {
				int  dey = Integer.valueOf(flxoaProjectInformation.getProjStartDate()) + 86400;
				sql+=" and flxoa_project_information.create_time >= '"+flxoaProjectInformation.getProjStartDate()+"' ";
				sql+=" and flxoa_project_information.create_time < '"+dey+"'";
			}
			if(!CommonUtils.isEmpty(flxoaProjectInformation.getProjStartDate()) && !CommonUtils.isEmpty(flxoaProjectInformation.getProjEndDate())){
				int  deyEnd = Integer.valueOf(flxoaProjectInformation.getProjEndDate()) + 86400;
				sql+=" and flxoa_project_information.create_time Between ";
				sql+=flxoaProjectInformation.getProjStartDate();
				sql+=" and ";
				sql+=deyEnd;
			}
			if(!CommonUtils.isEmpty(myproj)){
				sql+=" and flxoa_project_information.create_user_id = ";
				sql+=flxoaProjectInformation.getCreateUserId();
			}if(!CommonUtils.isEmpty(drawFocus)){
				sql+=" and flxoa_project_focus.create_user_id = ("+userId+") ";
			}
			sql += " order by flxoa_project_focus.flag desc, flxoa_project_information.create_time desc";
		String querySql="select "
				//字段说明  0：项目ID 1：项目编号 2：项目名称 3：设计单位 4：项目开始时间 5：项目结束时间 6：甲方/项目对接人邮箱 7：甲方/项目对接人姓名
				//         8：甲方/项目对接人电话 9：是否删除标记 10：是否关注标记 11：客户名称 12：预计合同额（合同额）13：预计招标时间 14：项目负责人
				//         15：项目阶段（十个阶段）16：项目阶段（三个阶段：前期设计等）17：项目类型 18：项目属性 19：设计单位 20：创建人部门ID
				//         21：创建人userID 22：是否关注标记 23：项目关注表ID
				+ "flxoa_project_information.id, "
				+ "flxoa_project_information.proj_number, "
				+ "flxoa_project_information.proj_name, "
				+ "flxoa_project_information.design_company, "
				+ "flxoa_project_information.create_time, "
				+ "flxoa_project_information.proj_end_time, "
				+ "flxoa_project_information.signatory, "
				+ "flxoa_project_information.signatory_name, "
				+ "flxoa_project_information.signatory_telephone, "
				+ "flxoa_project_information.delete_flag, "
				+ "flxoa_project_information.whether_follow, "
				+ "flxoa_project_information.client_name, "
				+ "flxoa_project_information.predict_contract_money, "
				+ "flxoa_project_information.predict_bids_time, "
				+ "flxoa_project_information.project_leader, "
				+ "proj_state.enumeration_value proj_state_type, "
				+ "proj_stage.enumeration_value proj_stage_type, "
				+ "proj_type.enumeration_value proj_type_type, "
				+ "proj_attribute.enumeration_value proj_attribute_type, "
				+ "design_company.enumeration_value designcompanys, "
				+ "flxoa_project_information.create_department_id, "
				+ "flxoa_project_information.create_user_id, "
				+ "flxoa_project_focus.flag, "
				+ "flxoa_project_focus.id foucsid "+sql;
		System.out.println("项目查询sql:----"+querySql);
		String countSql="select count(*) "+sql;
		List list= queryListForPageBySQL(start, length, querySql);
		List<Map<String,String>> dataList=new ArrayList<Map<String,String>>();
		List<Map<String,String>> otherDataList=new ArrayList<Map<String,String>>();
		for (int i = 0; i < list.size(); i++) {
			Map<String,String> dataMap=new HashMap<String,String>();
			Object[] obj = (Object[])list.get(i);
				dataMap.put("id", String.valueOf(obj[0]));
				dataMap.put("projNumber", String.valueOf(obj[1]));
				dataMap.put("projName", String.valueOf(obj[2]));
				dataMap.put("designCompany", String.valueOf(obj[3]));
				dataMap.put("createTime", String.valueOf(obj[4]));
				dataMap.put("projEndTime", String.valueOf(obj[5]));
				dataMap.put("signatory", String.valueOf(obj[6]));
				dataMap.put("signatoryName", String.valueOf(obj[7]));
				dataMap.put("signatoryTelephone", String.valueOf(obj[8]));
				dataMap.put("deleteFlag", String.valueOf(obj[9]));
				dataMap.put("whetherFollow", String.valueOf(obj[10]));
				dataMap.put("clientName", String.valueOf(obj[11]));
				dataMap.put("predictContractMoney", String.valueOf(obj[12]));
				dataMap.put("predictBidsTime", String.valueOf(obj[13]));
				dataMap.put("projectLeader", String.valueOf(obj[14]));
				dataMap.put("proj_state_type", String.valueOf(obj[15]));
				dataMap.put("proj_stage_type", String.valueOf(obj[16]));
				dataMap.put("proj_type_type", String.valueOf(obj[17]));
				dataMap.put("proj_attribute_type", String.valueOf(obj[18]));
				dataMap.put("designcompanys", String.valueOf(obj[19]));
				dataMap.put("createDepartmentId", String.valueOf(obj[20]));
				dataMap.put("createUserId", String.valueOf(obj[21]));
				dataMap.put("flag", String.valueOf(obj[22]));
				dataMap.put("foucsid", String.valueOf(obj[23]));
				//项目管理是否关注查询条件，0：全部，1：已关注，2：未关注
				//当projectFlag=2时不返回已关注的数据，
//				if("2".equals(projectFlag) && !"1".equals(String.valueOf(obj[22]))) {
//					dataList.add(dataMap);
//				}else if(!"2".equals(projectFlag) || projectFlag == "1" || projectFlag == null || projectFlag =="") {
//					dataList.add(dataMap);
//				}
				dataList.add(dataMap);
		}
		Long totalCount= countBySql(countSql,null);
		String stageSql = "";
		//首页-关注
		if(!CommonUtils.isEmpty(projectFlag)) {
			 stageSql ="select "
						+ "flxoa_system_enumeration.enumeration_value , "
						+ "flxoa_system_enumeration.enumeration_key , "
						+ "info.count counttype "
						+ "from "
						+ "flxoa_system_enumeration "
						+ "left join( "
						+ "select "
						+ "proj_state , "
						+ "flxoa_project_information.id , "
						+ "count(*) count "
						+ "from "
						+ "flxoa_project_information "
						+ "left join "
						+ "flxoa_project_focus on flxoa_project_information.id = flxoa_project_focus.project_id "
						+ "where "
						+ "flxoa_project_information.delete_flag = '0' "
						+ "and flxoa_project_focus.create_user_id = '"+userId+"' "
						+ "group by proj_state"
						+ ") info on info.proj_state = flxoa_system_enumeration.enumeration_key "
						+ "where "
						+ "flxoa_system_enumeration.enumeration_name = 'proj_state' "
						+ "group by "
						+ "flxoa_system_enumeration.enumeration_key"  ; 
		//首页-项目
		}else if(!CommonUtils.isEmpty(myproj)) {
			 	stageSql ="select "
			 			+ "flxoa_system_enumeration.enumeration_value , "
			 			+ "flxoa_system_enumeration.enumeration_key , "
			 			+ "info.count counttype "
			 			+ "from "
			 			+ "flxoa_system_enumeration "
			 			+ "left join"
			 			+ "( "
			 			+ "select "
			 			+ "proj_state , "
			 			+ "flxoa_project_information.id , "
			 			+ "count(*) count "
			 			+ "from "
			 			+ "flxoa_project_information "
			 			+ "where "
			 			+ "flxoa_project_information.delete_flag = '0' and flxoa_project_information.create_user_id = '"+userId+"'  "
			 			+ "group by "
			 			+ "proj_state"
			 			+ ") info on info.proj_state = flxoa_system_enumeration.enumeration_key "
			 			+ "where "
			 			+ "flxoa_system_enumeration.enumeration_name = 'proj_state' "
			 			+ "group by  flxoa_system_enumeration.enumeration_key"; 
		}else if(deptIds.indexOf(",") <=0 && userId != 1){
				stageSql ="select "
			 			+ "flxoa_system_enumeration.enumeration_value , "
			 			+ "flxoa_system_enumeration.enumeration_key , "
			 			+ "info.count counttype "
			 			+ "from "
			 			+ "flxoa_system_enumeration "
			 			+ "left join"
			 			+ "( "
			 			+ "select "
			 			+ "proj_state , "
			 			+ "flxoa_project_information.id , "
			 			+ "count(*) count "
			 			+ "from "
			 			+ "flxoa_project_information "
			 			+ "where "
			 			+ "flxoa_project_information.delete_flag = '0' and flxoa_project_information.create_user_id = '"+userId+"' "
			 			+ "group by "
			 			+ "proj_state"
			 			+ ") info on info.proj_state = flxoa_system_enumeration.enumeration_key "
			 			+ "where "
			 			+ "flxoa_system_enumeration.enumeration_name = 'proj_state' "
			 			+ "group by  flxoa_system_enumeration.enumeration_key"; 
		}else {
			stageSql ="select "
		 			+ "flxoa_system_enumeration.enumeration_value , "
		 			+ "flxoa_system_enumeration.enumeration_key , "
		 			+ "info.count counttype "
		 			+ "from "
		 			+ "flxoa_system_enumeration "
		 			+ "left join"
		 			+ "( "
		 			+ "select "
		 			+ "proj_state , "
		 			+ "flxoa_project_information.id , "
		 			+ "count(*) count "
		 			+ "from "
		 			+ "flxoa_project_information "
		 			+ "where "
		 			+ "flxoa_project_information.delete_flag = '0' and "+parm+" "
		 			+ "group by "
		 			+ "proj_state"
		 			+ ") info on info.proj_state = flxoa_system_enumeration.enumeration_key "
		 			+ "where "
		 			+ "flxoa_system_enumeration.enumeration_name = 'proj_state' "
		 			+ "group by  flxoa_system_enumeration.enumeration_key"; 
			
			
		}
		List listStatge= querySQL(stageSql, null);
		for (int i = 0; i < listStatge.size(); i++) {
			Map<String,String> dataMap=new HashMap<String,String>();
			Object[] obj = (Object[])listStatge.get(i);
			dataMap.put("enumeration_value", String.valueOf(obj[0]));
			dataMap.put("enumeration_key", String.valueOf(obj[1]));
			dataMap.put("counttype", String.valueOf(obj[2]));
			otherDataList.add(dataMap);
		}
		return CommonUtils.getPageJson(start, length,draw,totalCount,dataList,otherDataList);
	}
	/**
	 *查询FlxoaProjectInformation ByID
	 */ 
	public FlxoaProjectInformation queryById(FlxoaProjectInformation flxoaProjectInformation) {
		return get(flxoaProjectInformation.getId());
	}

	@Override
	protected Class<FlxoaProjectInformation> getEntityClass() {
		return FlxoaProjectInformation.class;
	}
	/*手机端项目搜索*/
	@Override
	public String queryProject(int start, int length, String draw, String searchInfo){
		  //查询hql语句
		  String hql="  FROM  flxoa_project_information info LEFT JOIN flxoa_system_enumeration ON enumeration_key = proj_state  " +
		  	" WHERE flxoa_system_enumeration.enumeration_name ='proj_state' AND info.proj_number is NOT NULL AND  info.proj_number <>'' AND info.delete_flag='0'  " ;
		  if(!CommonUtils.isEmpty(searchInfo)){
			  hql += " and ( info.proj_number like '%"+searchInfo+"%'  or info.proj_name like '%"+searchInfo+"%' ) ";
		  }
		  String querySql="SELECT info.proj_name,flxoa_system_enumeration.enumeration_value as state,info.id AS projId ,info.proj_number "+hql;
		  //求和查询sql
		  String countSql="select count(*) "+hql;
		  
		  List<Object> list= queryListForPageBySQL(start, length, querySql);
		  List<Map<String,String>> dataList=new ArrayList<Map<String,String>>();
		  List<Map<String,String>> otherDataList=new ArrayList<Map<String,String>>();
		  
		  for(int i=0;i<list.size();i++){
		   Map<String,String> map=new HashMap<String,String>();
		   Object[] obj=(Object[]) list.get(i);
		   map.put("projname", String.valueOf(obj[0]));
		   map.put("projstate", String.valueOf(obj[1]));
		   map.put("projId", String.valueOf(obj[2]));
		   map.put("projnumber", String.valueOf(obj[3]));
		   dataList.add(map);
		  }
		Long totalCount= countBySql(countSql,null);
		
		return CommonUtils.getPageJson(start,length,draw,totalCount,dataList,otherDataList);
	}

}