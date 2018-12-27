package com.flx.flxoa.info.system.dao.impl;


import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.flx.flxoa.info.approve.entity.FlxoaApproveForm;
import com.flx.flxoa.info.projectmanagement.entity.FlxoaProjectBidInformation;
import com.flx.flxoa.info.projectmanagement.entity.FlxoaProjectInformation;
import com.flx.flxoa.info.system.entity.FlxoaSystemUser;
import com.flx.flxoa.info.system.dao.FlxoaSystemUserDao;
import org.springframework.stereotype.Repository;
import com.flx.flxoa.common.hibernate3.HibernateBaseDao;
import com.flx.flxoa.common.util.CommonUtils;

/**
 *
 * 类名称：FlxoaSystemUserDaoImpl.java
 * 类描述：
 * 创建时间：2018-03-20, 下午06:22:03
 *
 * @version 1.0 
 * @since JDK版本1.7 
 * @author 张海英 
 */ 
@Repository
public class FlxoaSystemUserDaoImpl extends HibernateBaseDao<FlxoaSystemUser, Integer> implements FlxoaSystemUserDao {
	/**
	 *添加FlxoaSystemUser
	 */ 
	public boolean add(FlxoaSystemUser flxoaSystemUser) {
		return save(flxoaSystemUser);
	}
	/**
	 *删除FlxoaSystemUser
	 */ 
	public boolean delete(FlxoaSystemUser flxoaSystemUser) {
		flxoaSystemUser.setDeleteFlag("1");
		return save(flxoaSystemUser);
	}
	/**
	 *修改FlxoaSystemUser
	 */ 
	public boolean update(FlxoaSystemUser flxoaSystemUser) {
		return modify(flxoaSystemUser);
	}
	
	public String queryForPage(int pageNo,int pageSize,String draw,int userId, String deptIds,FlxoaSystemUser flxoaSystemUser) {
		String sql = "select"
				+ " u.real_name , "
				+ " u.user_name , "
				+ " flxoa_system_department. name company , "
				+ " dept. name dept , "
				+ " u.phone , "
				+ " u. status , "
				+ " u.gender , "
				+ " u.types , "
				+ " u.birthday , "
				+ " u.enter_unit_time , "
				+ " u.identification_number , "
				+ " u.unit_name , "
				+ " u.employment_time , "
				+ " u.valid_document_category , "
				+ " u.highest_degree_education , "
				+ " u.card_id , "
				+ " u.email , "
				+ " u.is_phone_sign , "
				+ " u.position , "
				+ " u.work_place , "
				+ " u.id "
				+ " from "
				+ " flxoa_system_user u left join flxoa_system_department dept on dept.id = u.department_id "
				+ " left join "
				+ " flxoa_system_department on flxoa_system_department.id = u.company_id "; 
		   sql += " where u.delete_flag = '0' ";
		if(flxoaSystemUser.getRealName() != null &&  !"".equals(flxoaSystemUser.getRealName())){
			sql += " and real_name  like '%"+flxoaSystemUser.getRealName()+"%'";
		}
		if(flxoaSystemUser.getStatus() != null &&  !"".equals(flxoaSystemUser.getStatus())) {
			sql += " and status  like '%"+flxoaSystemUser.getStatus()+"%'";
		}
		if(flxoaSystemUser.getDepartmentName() != null && !"".equals(flxoaSystemUser.getDepartmentName())){
			sql += " and dept.name  like '%"+flxoaSystemUser.getDepartmentName()+"%'";
		}
		if(flxoaSystemUser.getUserName() != null && !"".equals(flxoaSystemUser.getUserName())) {
			sql += " and  user_name like '%"+flxoaSystemUser.getUserName()+"%'";
		}
		if(flxoaSystemUser.getId() != null && !"".equals(flxoaSystemUser.getId())) {
			sql +=" and u.id ='"+flxoaSystemUser.getId()+"'";
		}
		if(flxoaSystemUser.getIds()!= null && !"".equals(flxoaSystemUser.getIds())){
			//用户ids
		String userIds = flxoaSystemUser.getIds();
		if(null != userIds){
			if(!"".equals(userIds)){				
				String parm = " u.id   ";//人员条件	
				if(userIds.indexOf(",") >= 0){					
					parm+=" REGEXP '["+userIds+"]' ";
				}
				else{
					parm = " u.id = "+userIds+" ";			
				}
				sql+=" AND ("+parm+")  ";				
			}
		}
	}
	List list = queryListForPageBySQL(pageNo, pageSize, sql);
	System.out.println("用户管理信息项Sql"+sql);
	String countsql = "select count(*) from ("+sql+") as count";
	Long totalCount= countBySql(countsql,null);
	List<Map<String,String>> formList = new ArrayList<Map<String,String>>();
	for (int i = 0; i < list.size(); i++) {
		Map<String,String> form = new HashMap<String,String>();
		Object[] objects = (Object[])list.get(i);
//		form.setRealName(String.valueOf(objects[0]));
//		form.setUserName(String.valueOf(objects[1]));
//		form.setCompanyName(String.valueOf(objects[2]));
//		form.setDepartmentName(String.valueOf(objects[3]));
//		form.setPhone(String.valueOf(objects[4]));
//		form.setStatus(String.valueOf(objects[5]));
//		form.setGender(String.valueOf(objects[6]));
//		form.setTypes(String.valueOf(objects[7]));
//		form.setBirthday(String.valueOf(objects[8]));
//		form.setEnterUnitTime((Integer) objects[9]);
//		form.setIdentificationNumber(String.valueOf(objects[10]));
//		form.setUnitName(String.valueOf(objects[11]));
//		form.setEmploymentTime((Integer)objects[12]);
//		form.setValidDocumentCategory(String.valueOf(objects[13]));
//		form.setHighestDegreeEducation(String.valueOf(objects[14]));
//		form.setCardId((Integer)objects[15]);
//		form.setEmail(String.valueOf(objects[16]));
//		form.setIsPhoneSign(String.valueOf(objects[17]));
//		form.setPosition(String.valueOf(objects[18]));
//		form.setWorkPlace(String.valueOf(objects[19]));
//		form.setId((Integer)objects[20]);
//		formList.add(form);
		form.put("realName", String.valueOf(objects[0]));
		form.put("userName", String.valueOf(objects[1]));
		form.put("companyName", String.valueOf(objects[2]));
		form.put("departmentName", String.valueOf(objects[3]));
		form.put("phone", String.valueOf(objects[4]));
		form.put("status", String.valueOf(objects[5]));
		form.put("gender", String.valueOf(objects[6]));
		form.put("types", String.valueOf(objects[7]));
		form.put("birthday", String.valueOf(objects[8]));
		form.put("enterUnitTime", String.valueOf(objects[9]));
		form.put("identificationNumber", String.valueOf(objects[10]));
		form.put("unitName", String.valueOf(objects[11]));
		form.put("employmentTime", String.valueOf(objects[12]));
		form.put("validDocumentCategory", String.valueOf(objects[13]));
		form.put("highestDegreeEducation", String.valueOf(objects[14]));
		form.put("cardId", String.valueOf(objects[15]));
		form.put("email", String.valueOf(objects[16]));
		form.put("isPhoneSign", String.valueOf(objects[17]));
		form.put("position", String.valueOf(objects[18]));
		form.put("workPlace", String.valueOf(objects[19]));
		form.put("id", String.valueOf(objects[20]));
		formList.add(form);
	}
		
		return CommonUtils.getPageJson(pageNo, pageSize, draw, totalCount, formList, null);
	}
	
	/**
	 *查询FlxoaProjectBidInformation数据条数 
	 */ 
	public Long queryCount(FlxoaSystemUser flxoaSystemUser) {
		String hql = "select count(*) from FlxoaSystemUser where delete_flag = '0' ";
		return countByHql(hql,null);
	}
	
	/**
	 *查询FlxoaSystemUser列表
	 */ 
	public List<FlxoaSystemUser> query(FlxoaSystemUser flxoaSystemUser) {
		String sql = "SELECT u.real_name , u.user_name , flxoa_system_department. NAME company , dept. NAME dept , u.phone , u. STATUS , u.gender , u.types , u.birthday , u.enter_unit_time , u.identification_number , u.unit_name , u.employment_time , u.valid_document_category , u.highest_degree_education , u.card_id , u.email , u.is_phone_sign , u.position , u.work_place , u.id FROM flxoa_system_user u LEFT JOIN flxoa_system_department dept ON dept.id = u.department_id LEFT JOIN flxoa_system_department ON flxoa_system_department.id = u.company_id "; 
			   sql += " where u.delete_flag = '0' ";
		if(flxoaSystemUser.getRealName() != null &&  !"".equals(flxoaSystemUser.getRealName())){
			sql += " and real_name  like '%"+flxoaSystemUser.getRealName()+"%'";
		}
		if(flxoaSystemUser.getDepartmentName() != null && !"".equals(flxoaSystemUser.getDepartmentName())){
			sql += " and dept.name  like '%"+flxoaSystemUser.getDepartmentName()+"%'";
		}
		if(flxoaSystemUser.getUserName() != null && !"".equals(flxoaSystemUser.getUserName())) {
			sql += " and  user_name like '%"+flxoaSystemUser.getUserName()+"%'";
		}
		if(flxoaSystemUser.getId() != null && !"".equals(flxoaSystemUser.getId())) {
			sql +=" and u.id ='"+flxoaSystemUser.getId()+"'";
		}
		if(flxoaSystemUser.getIds()!= null && !"".equals(flxoaSystemUser.getIds())){
			//用户ids
			String userIds = flxoaSystemUser.getIds();
			if(null != userIds){
				if(!"".equals(userIds)){
					if(userIds.indexOf(",") != -1){
						String [] temp = userIds.split(",");
						sql += " and (";
						//遍历map
						for (int i = 0; i < temp.length; i++) {
							sql += " u.id = "+temp[i]+ " or ";
						}
						sql = sql.substring(0, sql.length()-3);
						sql += ") ";					
					}else{
						sql += " and u.id = "+userIds;
					}
				}
			}
		}
		List list = getListBySQL(sql, null);
		List<FlxoaSystemUser> formList = new ArrayList<FlxoaSystemUser>();
		for (int i = 0; i < list.size(); i++) {
			FlxoaSystemUser form = new FlxoaSystemUser();
			Object[] objects = (Object[])list.get(i);
			form.setRealName(String.valueOf(objects[0]));
			form.setUserName(String.valueOf(objects[1]));
			form.setCompanyName(String.valueOf(objects[2]));
			form.setDepartmentName(String.valueOf(objects[3]));
			form.setPhone(String.valueOf(objects[4]));
			form.setStatus(String.valueOf(objects[5]));
			form.setGender(String.valueOf(objects[6]));
			form.setTypes(String.valueOf(objects[7]));
			form.setBirthday(String.valueOf(objects[8]));
			form.setEnterUnitTime((Integer) objects[9]);
			form.setIdentificationNumber(String.valueOf(objects[10]));
			form.setUnitName(String.valueOf(objects[11]));
			form.setEmploymentTime((Integer)objects[12]);
			form.setValidDocumentCategory(String.valueOf(objects[13]));
			form.setHighestDegreeEducation(String.valueOf(objects[14]));
			form.setCardId((Integer)objects[15]);
			form.setEmail(String.valueOf(objects[16]));
			form.setIsPhoneSign(String.valueOf(objects[17]));
			form.setPosition(String.valueOf(objects[18]));
			form.setWorkPlace(String.valueOf(objects[19]));
			form.setId((Integer)objects[20]);
			formList.add(form);
		}
		return formList;
		
	}
	@Override
	public boolean isExist(String username) {
		String hql="from FlxoaSystemUser where user_name='"+username+"' ";
		List list=queryByHQL(hql);
		if(list.size()<1){
			return true;
		}
		return false;
	} 
	/**
	 *查询FlxoaSystemUser ByID
	 */ 
	public FlxoaSystemUser queryById(FlxoaSystemUser flxoaSystemUser) {
		return get(flxoaSystemUser.getId());
	}
	/**
	 * 分页
	 */
	public List<FlxoaSystemUser> queryForPage(int pageNo,int pageSize){
		String hql=" from FlxoaSystemUser where delete_flag = '0'";
		return queryForPageByHQL(pageNo, pageSize, hql);
	}
	/** 
	 *查询所有
	 */ 
	public List<FlxoaSystemUser> queryAllUser(){
		//String hql = " from FlxoaSystemUser where status ='0' and delete_flag = '0' and user_name='xiagaicui' ";
		String hql = " from FlxoaSystemUser where status ='0' and delete_flag = '0' ";
		return getListByHQL(hql, null);
	}
	@Override
	protected Class<FlxoaSystemUser> getEntityClass() {
		return FlxoaSystemUser.class;
	} 

	/**
	 * 根据用户名查询用户
	 */
	@Override
	public FlxoaSystemUser findByUserName(String username){
		FlxoaSystemUser systemUser = findUniqueByPropery(FlxoaSystemUser.PROP_USER_NAME, username);
		
		return systemUser;
	}
	
	/**
	 * 根据用户属性查询用户详细信息
	 */
	public FlxoaSystemUser findUserDetialByUserName(FlxoaSystemUser flxoaSystemUser){
		String sql = "select u.real_name," +
				"u.user_name," +
				"company.name company," +
				"dept.name dept,u.phone," +
				"u.status," +
				"u.gender," +
				"u.types," +
				"u.birthday," +
				"u.enter_unit_time," +
				"u.identification_number," +
				"u.unit_name," +
				"u.employment_time," +
				"u.valid_document_category," +
				"u.highest_degree_education," +
				"u.card_id," +
				"u.email," +
				"u.is_phone_sign," +
				"u.position," +
				"u.work_place," +
				"u.id, " +
				"u.password, " +
				"u.department_id, " +
				"u.company_id, " +
				"u.phone_id " +
				"from flxoa_system_user u " +
				"left join (select id,name from flxoa_system_department where organization_type='0') company on u.company_id=company.id " +
				"left join (select id,name from flxoa_system_department where organization_type='1' ) dept on u.department_id=dept.id";
		sql += " where delete_flag = '0' ";
		if(flxoaSystemUser.getUserName() != null && !"".equals(flxoaSystemUser.getUserName())) {
			sql += " and  user_name = '"+flxoaSystemUser.getUserName()+"'";
		}
		if(flxoaSystemUser.getPhoneId() != null && !"".equals(flxoaSystemUser.getPhoneId())) {
			sql += " and  phone_id = '"+flxoaSystemUser.getPhoneId()+"'";
		}		
		List list = getListBySQL(sql, null);
		List<FlxoaSystemUser> formList = new ArrayList<FlxoaSystemUser>();
		for (int i = 0; i < list.size(); i++) {
			FlxoaSystemUser form = new FlxoaSystemUser();
			Object[] objects = (Object[])list.get(i);
			form.setRealName(String.valueOf(objects[0]));
			form.setUserName(String.valueOf(objects[1]));
			form.setCompanyName(String.valueOf(objects[2]));
			form.setDepartmentName(String.valueOf(objects[3]));
			form.setPhone(String.valueOf(objects[4]));
			form.setStatus(String.valueOf(objects[5]));
			form.setGender(String.valueOf(objects[6]));
			form.setTypes(String.valueOf(objects[7]));
			form.setBirthday(String.valueOf(objects[8]));
			form.setEnterUnitTime((Integer) objects[9]);
			form.setIdentificationNumber(String.valueOf(objects[10]));
			form.setUnitName(String.valueOf(objects[11]));
			form.setEmploymentTime((Integer)objects[12]);
			form.setValidDocumentCategory(String.valueOf(objects[13]));
			form.setHighestDegreeEducation(String.valueOf(objects[14]));
			form.setCardId((Integer)objects[15]);
			form.setEmail(String.valueOf(objects[16]));
			form.setIsPhoneSign(String.valueOf(objects[17]));
			form.setPosition(String.valueOf(objects[18]));
			form.setWorkPlace(String.valueOf(objects[19]));
			form.setId((Integer)objects[20]);
			form.setPassword(String.valueOf(objects[21]));
			form.setDepartmentId((Integer)objects[22]);
			form.setCompanyId((Integer)objects[23]);
			form.setPhoneId(String.valueOf(objects[24]));
			formList.add(form);
		}
		if(formList.size() == 1){
			return formList.get(0);  
		}else{
			return null;
		}
	}
	
	/**
	 * 根据用户id查询用户
	 */
	@Override
	public FlxoaSystemUser queryByUserId(FlxoaSystemUser flxoaSystemUser) {
		String hql = " from FlxoaSystemUser where delete_flag = '0' and create_user_id = '"+flxoaSystemUser.getCreateUserId()+"'";
		return getByHQL(hql);
	}
	
	/**
	 * 根据用户属性 查询用户权限
	 */
	@Override
	public List<FlxoaSystemUser> findUserPermisson(FlxoaSystemUser flxoaSystemUser){
		String sql = "select uid,uname,rname,did,fname,bid,url,rid,fid,isMenu,parentId,functionSort from (";
		//用户权限
		sql += "select " +
				" flxoa_system_user.id as uid," +
				" flxoa_system_user.user_name as uname," +
				" flxoa_system_role.name as rname," +
				" flxoa_system_user_role.department_id as did," +
				" flxoa_system_funcation.name as fname," +
				" flxoa_system_funcation.button_id as bid," +
				" flxoa_system_funcation.url as url," +
				" flxoa_system_role.id as rid," +
				" flxoa_system_funcation.id as fid," +
				" flxoa_system_funcation.is_menu as isMenu," +
				" flxoa_system_funcation.parent_id as parentId," +
				" flxoa_system_funcation.function_sort as functionSort" +
				//主表
				" from flxoa_system_user " +
				//从表
				" left join flxoa_system_user_role" +
				" on flxoa_system_user.id = flxoa_system_user_role.user_id" +
				" left join flxoa_system_role" +
				" on flxoa_system_user_role.role_id = flxoa_system_role.id" +
				" left join flxoa_system_role_funcation" +
				" on flxoa_system_role_funcation.role_id = flxoa_system_user_role.role_id" +
				" left join flxoa_system_funcation" +
				" on flxoa_system_role_funcation.funcation_id = flxoa_system_funcation.id";
		sql += " where 1=1 ";
		if(null != flxoaSystemUser.getId()){
			sql += "and flxoa_system_user.id = '"+flxoaSystemUser.getId()+"' AND flxoa_system_user.delete_flag=0 AND flxoa_system_user_role.delete_flag=0 AND "+
"flxoa_system_role.delete_flag=0 AND flxoa_system_role_funcation.delete_flag=0 and flxoa_system_funcation.delete_flag=0 ";
		}
//		sql += " union all ";
//		//用户组权限
//		sql += " select " +
//			" flxoa_system_user.id as uid, " +
//			" flxoa_system_user.user_name as uname, " +
//			" flxoa_system_role.name as rname," +
//			" flxoa_system_user_group_department.department_id as did," +
//			" flxoa_system_funcation.name as fname," +
//			" flxoa_system_funcation.button_id as bid," +
//			" flxoa_system_funcation.url as url," +
//			" flxoa_system_role.id as rid," +
//			" flxoa_system_funcation.id as fid," +
//			" flxoa_system_funcation.is_menu as isMenu," +
//			" flxoa_system_funcation.parent_id as parentId," +
//			" flxoa_system_funcation.function_sort as functionSort" +			
//			" from flxoa_system_user" +
//			" left join" +
//			" flxoa_system_user_group_user" +
//			" on flxoa_system_user.id = flxoa_system_user_group_user.user_id" +
//			" left join" +
//			" flxoa_system_user_group_role" +
//			" on flxoa_system_user_group_user.user_group_id = flxoa_system_user_group_role.user_group_id" +
//			" left join" +
//			" flxoa_system_user_group_department" +
//			" on flxoa_system_user_group_user.user_group_id = flxoa_system_user_group_department.user_group_id" +
//			" left join flxoa_system_role" +
//			" on flxoa_system_user_group_role.role_id = flxoa_system_role.id" +
//			" left join" +
//			" flxoa_system_role_funcation" +
//			" on flxoa_system_role_funcation.role_id = flxoa_system_user_group_role.role_id" +
//			" left join flxoa_system_funcation" +
//			" on flxoa_system_role_funcation.funcation_id = flxoa_system_funcation.id";
//		sql += " where 1=1 ";
//		if(null != flxoaSystemUser.getId()){
//			sql += "and flxoa_system_user.id = '"+flxoaSystemUser.getId()+"' ";
//		}		
		
		sql += ") permission  order by functionSort,rid ";
		System.out.println("权限查询sql："+sql);
		List list = getListBySQL(sql, null);
		List<FlxoaSystemUser> formList = new ArrayList<FlxoaSystemUser>();
		for (int i = 0; i < list.size(); i++) {
			FlxoaSystemUser form = new FlxoaSystemUser();
			Object[] objects = (Object[])list.get(i);
			form.setId((Integer)objects[0]);
			form.setUserName(String.valueOf(objects[1]));
			form.setRoleName(String.valueOf(objects[2]));
			form.setManageDepartmentId((Integer)objects[3]);
			form.setFunctionName(String.valueOf(objects[4]));
			form.setButtonId(String.valueOf(objects[5]));
			form.setUrl(String.valueOf(objects[6]));
			form.setFunctionId(String.valueOf(objects[8]));
			form.setIsMenu(String.valueOf(objects[9]));
			form.setFunctionParentId(String.valueOf(objects[10]));
			formList.add(form);
		}
		return formList;
	}
	
	@Override
	public List<FlxoaSystemUser> queryByUserIds(String userIds) {//在职人员
		String hql = " from FlxoaSystemUser where  status ='0' and delete_flag = '0' ";
		String [] userids=userIds.split(",");
		String parm = " id ";//人员条件	
		if(userIds.indexOf(",") >= 0){					
			parm+=" REGEXP '["+userIds+"]' ";
		}
		else{
			parm = " id = "+userIds+" ";			
		}
		hql += " AND ("+parm+")  ";	
		return getListByHQL(hql, null);
	}
	
	@Override
	public List<FlxoaSystemUser> queryCardIds(int userid,String deptid)
	{
		String hql ="";
		//userid=1时为admin，<1时为null，分别使用部门经理账号（department_id:16）和admin(department_id:7)账号登录显示的数据相同？
		if(userid <= 1 ){
			hql=" from FlxoaSystemUser where department_id in ("+deptid+") and status ='0' and delete_flag = '0'";			
		}
		else{			
			hql = " from FlxoaSystemUser where  id = "+userid+" and status ='0' and delete_flag ='0' ";				
		}	
				
		return getListByHQL(hql, null);	}
	/**
	 * 根据微信id查询用户
	 */
	@Override
	public FlxoaSystemUser getUserByWeixinId(FlxoaSystemUser flxoaSystemUser) {
		String hql = " from FlxoaSystemUser where delete_flag = '0' and weixin_id = '"+flxoaSystemUser.getWeixinId()+"'";
		return getByHQL(hql);
	}
}