package com.flx.flxoa.info.system.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


import com.flx.flxoa.common.util.DateUtils;
import com.flx.flxoa.common.util.MD5Encode;
import com.flx.flxoa.common.util.Singleton;
import com.flx.flxoa.info.approve.entity.FlxoaApproveForm;
import com.flx.flxoa.info.projectmanagement.entity.FlxoaProjectInformation;
import com.flx.flxoa.info.system.comon.Permission;
import com.flx.flxoa.info.system.entity.DepartmentTree;
import com.flx.flxoa.info.system.entity.FlxoaSystemDepartment;
import com.flx.flxoa.info.system.entity.FlxoaSystemRole;
import com.flx.flxoa.info.system.entity.FlxoaSystemRoleFuncation;
import com.flx.flxoa.info.system.entity.FlxoaSystemSso;
import com.flx.flxoa.info.system.entity.FlxoaSystemUser;
import com.flx.flxoa.info.system.entity.FlxoaSystemUserRole;
import com.flx.flxoa.info.system.manager.FlxoaSystemDepartmentService;
import com.flx.flxoa.info.system.manager.FlxoaSystemRoleFuncationService;
import com.flx.flxoa.info.system.manager.FlxoaSystemRoleService;
import com.flx.flxoa.info.system.manager.FlxoaSystemSsoService;
import com.flx.flxoa.info.system.manager.FlxoaSystemUserRoleService;
import com.flx.flxoa.info.system.manager.FlxoaSystemUserService;

/**
 * @author 雷君
 * @version 创建时间：2018-3-29 下午2:25:35
 * 类说明
 */
@Controller
public class FlxoaSystemUserController {
	protected  FlxoaSystemUserService flxoaSystemUserService;
	protected  FlxoaSystemDepartmentService flxoaSystemDepartmentService;
	protected  FlxoaSystemUserRoleService flxoaSystemUserRoleService;
	protected  FlxoaSystemRoleService flxoaSystemRoleService;
	protected  FlxoaSystemSsoService flxoaSystemSsoService;
	@Autowired
	public void setSystemUserService(FlxoaSystemUserService flxoaSystemUserService) {
		this.flxoaSystemUserService = flxoaSystemUserService;
	}
	@Autowired
	public void setSystemDepartmentService(FlxoaSystemDepartmentService flxoaSystemDepartmentService) {
		this.flxoaSystemDepartmentService = flxoaSystemDepartmentService;
	}
	@Autowired
	public void setSystemUserRoleService(FlxoaSystemUserRoleService flxoaSystemUserRoleService) {
		this.flxoaSystemUserRoleService = flxoaSystemUserRoleService;
	}
	@Autowired
	public void setSystemRoleService(FlxoaSystemRoleService flxoaSystemRoleService) {
		this.flxoaSystemRoleService = flxoaSystemRoleService;
	}
	@Autowired
	public void setSystemSsoService(FlxoaSystemSsoService flxoaSystemSsoService) {
		this.flxoaSystemSsoService = flxoaSystemSsoService;
	}	
	/**
	 * @param request
	 * @param response
	 * @param model
	 * @return 前往用户管理页面
	 */
	@RequestMapping(value = "userList")
	public String userList(HttpServletRequest request,HttpServletResponse response, ModelMap model) {
		
		return "nk/pages/system/userManage";
	}
	/**
	 * @param request
	 * @param response
	 * @param model
	 * @return 前往用户授权页面
	 */
	@RequestMapping(value = "userAuthorization")
	public String userAuthorization(HttpServletRequest request,HttpServletResponse response, ModelMap model) {
		
		return "nk/pages/system/userManage";
	}
	/**
	 * @param request
	 * @param response
	 * @param model
	 * @return 前往销售经理页面
	 */
	@RequestMapping(value = "/gotomarketingmanager")
	public String gotomarketingmanager(HttpServletRequest request,HttpServletResponse response, ModelMap model) {
		
		return "nk/pages/approval/marketingmanager";
	}
	/**
	 * @param request
	 * @param response
	 * @param model
	 * @return 前往甲方名称页面
	 */
	@RequestMapping(value = "/gotoapprovalProjectManage")
	public String gotoapprovalProjectManage(HttpServletRequest request,HttpServletResponse response, ModelMap model) {
		
		return "nk/pages/approval/approvalProjectManage";
	}
	
	/**
	 * @param request
	 * @param response
	 * @param model
	 * @return 用户信息/详情
	 */
	@RequestMapping(value = "/flxoaSystemUserInif", produces = "text/html;charset=utf-8")
	@ResponseBody
	public String  flxoaSystemUserInif(HttpServletRequest request,
		HttpServletResponse response, FlxoaSystemUser model){
		HttpServletRequest req = (HttpServletRequest) request;
		
		String path =req.getServletPath()+req.getPathInfo();
		//获取当前登录用户ID
		int userId = Integer.parseInt(String.valueOf(req.getSession().getAttribute("userId")));
		//获取当前登录用户部门ID
		int deptId = Integer.parseInt(String.valueOf(req.getSession().getAttribute("departmentId")));
		Map<String,List<Integer>>  mapjur = Permission.getRolePermission(userId, path);
		//获取当前用户具备的权限
		String deptIds =  Permission.getDepartMentIds(mapjur);	
		String pageNo = request.getParameter("pageNo");
		String pageSize = request.getParameter("pageSize");
		String draw=request.getParameter("draw");//datatable绘制次数
		if (pageNo == "" || pageNo == null) {
			pageNo = "1";
		}
		if (pageSize == "" || pageSize == null) {
			pageSize = "10";
		}
		//用户名称
		model.setRealName(request.getParameter("realname"));
		//用户名
		model.setUserName(request.getParameter("username"));
		//部门名称
		model.setDepartmentName(request.getParameter("departmentname"));
		//在职状态
		model.setStatus(request.getParameter("userState"));
		
		return flxoaSystemUserService.queryForPage(Integer.valueOf(pageNo),Integer.valueOf(pageSize),draw,userId,deptIds,model);
	}
	/**
	 * @param request
	 * @param response
	 * @param model
	 * @return 用户管理查询
	 */
	@RequestMapping(value = "/flxoaSystemUserDemand", produces = "text/html;charset=utf-8")
	@ResponseBody
	public String  flxoaSystemUserDemand(HttpServletRequest request,
			HttpServletResponse response, FlxoaSystemUser model){
		//用户角色表FlxoaSystemUserRole
		FlxoaSystemUserRole  userrole =  new FlxoaSystemUserRole();
		// newjson對象
		JSONArray json = new JSONArray();
		// newMap集合存放返回前台页面的json
		Map<String, List> map = new HashMap<String, List>();
		//用户名称
		model.setRealName(request.getParameter("realname"));
		//用户名
		model.setUserName(request.getParameter("username"));
		//部门名称
		model.setDepartmentName(request.getParameter("departmentname"));
		//FlxoaSystemUser ID
		//model.setId(Integer.valueOf(request.getParameter("id")));
		//查询FlxoaSystemUser
		List<FlxoaSystemUser> rolelist = flxoaSystemUserService.query(model);
		map.put("usermessage", rolelist);
		JSONArray jsonMap = json.put(map);
		return json.toString();
	}
	/**
	 * @param request
	 * @param response
	 * @param model
	 * @return 查看
	 */
	@RequestMapping(value = "/flxoaSystemUserDemandId", produces = "text/html;charset=utf-8")
	@ResponseBody
	public String  flxoaSystemUserDemandId(HttpServletRequest request,
			HttpServletResponse response, FlxoaSystemUser model){
		//用户角色表FlxoaSystemUserRole
		FlxoaSystemUserRole  userrole =  new FlxoaSystemUserRole();
		// newjson對象
		JSONArray json = new JSONArray();
		// newMap集合存放返回前台页面的json
		Map<String, List> map = new HashMap<String, List>();
		//FlxoaSystemUser ID
		model.setId(Integer.valueOf(request.getParameter("id")));
		//查询FlxoaSystemUser
		List<FlxoaSystemUser> rolelist = flxoaSystemUserService.query(model);
		map.put("usermessage", rolelist);
		JSONArray jsonMap = json.put(map);
		return json.toString();
	}
	
	/**
	 * @param request
	 * @param response
	 * @param model
	 * @return 用户角色查询
	 */
	@RequestMapping(value = "/flxoaSystemUserRoleDemand", produces = "text/html;charset=utf-8")
	@ResponseBody
	public String  flxoaSystemUserRoleDemand(HttpServletRequest request,
			HttpServletResponse response, FlxoaSystemUserRole model){
		// newjson對象
		JSONArray json = new JSONArray();
		// newMap集合存放返回前台页面的json
		Map<String, List> map = new HashMap<String, List>();
		//用户名称
		//model.setUserName(request.getParameter("userName"));
		model.setUserName("超级管理员");
		//角色名称
		//model.setRoleName(request.getParameter("roleName"));
		//查询FlxoaSystemUser
		List<FlxoaSystemUserRole> rolelist = flxoaSystemUserRoleService.query(model);
		map.put("userRoleMessage", rolelist);
		JSONArray jsonMap = json.put(map);
		System.out.println("用户角色="+jsonMap);
		return json.toString();
	}

	/**
	 * @param request
	 * @param response
	 * @param model
	 * @return 角色树
	 */
	@RequestMapping(value = "/flxoaSystemRoleTreeInfoIrmation", produces = "text/html;charset=utf-8")
	@ResponseBody
	public String  flxoaSystemUserRoleInfoIrmation(HttpServletRequest request,
			HttpServletResponse response, FlxoaSystemRole model){
		// newjson對象
		JSONArray json = new JSONArray();
		//查询FlxoaSystemRole表
		List<FlxoaSystemRole> rolelist = flxoaSystemRoleService.queryRoleId(model);
		//遍历rolelist 取得角色ID和角色名称
		for(int i=0;i<rolelist.size();i++){
			Map<String,String> deptTree = new HashMap<String,String>();
			deptTree.put("id",String.valueOf(rolelist.get(i).getId()));
			deptTree.put("name",rolelist.get(i).getName());
			deptTree.put("pid", "0");
			json.put(deptTree);
		}
		return json.toString();
	}
	
	/**
	 * @param request
	 * @param response
	 * @param model
	 * @return 部门信息
	 */
	@RequestMapping(value = "/flxoaSystemUserDepartment", produces = "text/html;charset=utf-8")
	@ResponseBody
	public String  flxoaSystemUserDepartment(HttpServletRequest request,
			HttpServletResponse response, FlxoaSystemUser model){
			JSONArray json = new JSONArray();
			FlxoaSystemDepartment department = new FlxoaSystemDepartment();
			// newMap集合存放返回前台页面的json
			Map<String, List> map = new HashMap<String, List>();
			List<FlxoaSystemDepartment> role = flxoaSystemDepartmentService.query(department);
			map.put("departmentmessage", role);
			JSONArray jsonrole = json.put(map);
			return json.toString();
	}
	/**
	 * @param request
	 * @param response
	 * @param model
	 * @return 用户添加  前台输入userName 失去焦点时  验证
	 */
	@RequestMapping(value = "/flxoaSystemUserNamecheck", produces = "text/html;charset=utf-8")
	@ResponseBody
	public String  flxoaSystemUserNamecheck(HttpServletRequest request,
			HttpServletResponse response, FlxoaSystemUser model){
		String result = "";
		boolean username = flxoaSystemUserService.isExist(request.getParameter("user_name"));
		if (username) {
			result = "1";
		}else {
			result = "0";
		}
		return result;
	}
	
	/**
	 * @param request
	 * @param response
	 * @param model
	 * @return 修改用户信息
	 */
	@RequestMapping(value = "/flxoaSystemUserUpdate", produces = "text/html;charset=utf-8")
	@ResponseBody
	public String  flxoaSystemUserUpdate(HttpServletRequest request,
			HttpServletResponse response, FlxoaSystemUser model){
		//部门表FlxoaSystemDepartment
		FlxoaSystemDepartment department = new FlxoaSystemDepartment();
		//部门名称
		department.setName(request.getParameter("department_name"));
		//通过部门名称查询表FlxoaSystemDepartment：获取公司ID和部门ID
		List<FlxoaSystemDepartment> departmentdata = flxoaSystemDepartmentService.query(department);
		HttpServletRequest req = (HttpServletRequest)request;
		//FlxoaSystemDepartment companyid = null;
		//用户密码加密
		String Md5pass = MD5Encode.MD5("123456");
		//查询用户信息 true或false
		//boolean role = flxoaSystemUserService.isExist(request.getParameter("user_true_name"));
		String result = "0";
		model.setId(Integer.valueOf(request.getParameter("id")));
		FlxoaSystemUser flxoaSystemUser =  flxoaSystemUserService.queryById(model);
		//model.setId(3);
		//用户姓名
		flxoaSystemUser.setRealName(request.getParameter("user_true_name"));
		//出生日期
		//String birth_date = sdf.format(request.getParameter("birth_date"));
		flxoaSystemUser.setBirthday(String.valueOf(DateUtils.dateToTimestamp(request.getParameter("birth_date"))));
		//性别
		flxoaSystemUser.setGender(request.getParameter("sex"));
		//考勤卡ID
		if(request.getParameter("timecard_id") == "0" || request.getParameter("timecard_id") == null  || request.getParameter("timecard_id") == "") {
			flxoaSystemUser.setCardId(0);
		}else {
			flxoaSystemUser.setCardId(Integer.valueOf(request.getParameter("timecard_id")));
		}
		//删除标记
		flxoaSystemUser.setDeleteFlag("0");
		//邮箱
		flxoaSystemUser.setEmail(request.getParameter("email"));
		//聘用时间
		flxoaSystemUser.setEmploymentTime(Integer.valueOf(DateUtils.getSecondTimestamp(new Date())));
		//进入单位时间
		flxoaSystemUser.setEnterUnitTime(Integer.valueOf(DateUtils.dateToTimestamp(request.getParameter("enter_unit_time"))));
		//性别 男或女
		flxoaSystemUser.setGender(request.getParameter("sex"));
		//学历 博士以上，博士，硕士，学士，专科，专科以下
		flxoaSystemUser.setHighestDegreeEducation(request.getParameter("highest_education"));
		//证件号码
		flxoaSystemUser.setIdentificationNumber(request.getParameter("id_number"));
		//是否能用手机签到
		flxoaSystemUser.setIsPhoneSign(request.getParameter("is_phone_sign"));
		//密码
		flxoaSystemUser.setPassword(Md5pass);
		//手机号码
		flxoaSystemUser.setPhone(request.getParameter("phone_number"));
		//职位
		if(request.getParameter("position") == " " || request.getParameter("position") == null  || request.getParameter("position") == "") {
			flxoaSystemUser.setPosition("0");
		}else {
			flxoaSystemUser.setPosition(request.getParameter("position"));
		}
		//状态：在职，调出，离职，等
		flxoaSystemUser.setStatus(request.getParameter("status"));
		//人员类别 在职人员，离退人员，调转人员，待查人员，事业单位技术人员，机关工勤人员，临时人员，企业管理人员，其他人员，正式员工等
		flxoaSystemUser.setTypes("0");
		//所属单位名称
		flxoaSystemUser.setUnitName(request.getParameter("company_name"));
		//跟新人部门id
		flxoaSystemUser.setUpdateDepartmentId(Integer.parseInt(String.valueOf(req.getSession().getAttribute("departmentId"))));
		//跟新时间
		flxoaSystemUser.setUpdateTime(DateUtils.getSecondTimestamp(new Date()));
		//跟新人ID
		flxoaSystemUser.setUpdateUserId(Integer.parseInt(String.valueOf(req.getSession().getAttribute("userId"))));
		//用户名
		flxoaSystemUser.setUserName(request.getParameter("user_name"));
		//有效证件类别  居民身份证，军官证，士兵证，文职干部证，部队离退休证，香港特区护照/身份证，台湾居民来往大陆通行证，境外永久居住证，其他
		flxoaSystemUser.setValidDocumentCategory(request.getParameter("valid_document_category"));
		//微信ID
		//model.setWeixinId("12431231");
		//工作地点
		if(request.getParameter("work_place") == "0" || request.getParameter("work_place") == null  || request.getParameter("work_place") == "") {
			flxoaSystemUser.setWorkPlace("0");
		}else {
			flxoaSystemUser.setWorkPlace(request.getParameter("work_place"));
		}
		flxoaSystemUser.setCreateTime(DateUtils.getSecondTimestamp(new Date()));
		flxoaSystemUser.setCreateDepartmentId(Integer.parseInt(String.valueOf(req.getSession().getAttribute("departmentId"))));
		flxoaSystemUser.setCreateUserId(Integer.parseInt(String.valueOf(req.getSession().getAttribute("userId"))));
		//遍历获取部门ID和公司ID
		for(FlxoaSystemDepartment i : departmentdata) {
			flxoaSystemUser.setDepartmentId(i.getId());
			flxoaSystemUser.setCompanyId(i.getCompanyId());
		}
		boolean b = flxoaSystemUserService.update(flxoaSystemUser);
		if (b) {
			result = "1";
		}
		return result;
	}

	/**
	 * @param request
	 * @param response
	 * @param model
	 * @return 修改个人密码
	 */
	@RequestMapping(value = "/user/changepassword", produces = "text/html;charset=utf-8")
	@ResponseBody
	public String  changePassword(HttpServletRequest request,HttpServletResponse response, FlxoaSystemUser model){
			//用户密码加密
			String result = "0";
			String password = model.getPassword();
			String md5pass = MD5Encode.MD5(password);
			FlxoaSystemUser FlxoaSystemUser = flxoaSystemUserService.queryById(model);
			FlxoaSystemUser.setPassword(md5pass);
			boolean b = flxoaSystemUserService.update(FlxoaSystemUser);
			if (b) {
				result = "1";
			}
			return result;
	}	
	/**
	 * @param request
	 * @param response
	 * @param model
	 * @return 用户授权信息
	 */
	
	@RequestMapping(value = "/flxoaSystemUserAuthorization", produces = "text/html;charset=utf-8")
	@ResponseBody
	public String flxoaSystemUserAuthorization(HttpServletRequest request,
			HttpServletResponse response, FlxoaSystemUserRole model){
		HttpServletRequest req = (HttpServletRequest) request;
		String path =req.getServletPath()+req.getPathInfo();
		//获取当前登录用户ID
		int userId = Integer.parseInt(String.valueOf(req.getSession().getAttribute("userId")));
		//获取当前登录用户部门ID
		int deptId = Integer.parseInt(String.valueOf(req.getSession().getAttribute("departmentId")));
		Map<String,List<Integer>>  mapjur = Permission.getRolePermission(userId, path);
		//获取当前用户具备的权限
		String deptIds =  Permission.getDepartMentIds(mapjur);
		model.setUserName(request.getParameter("user_true_name"));
		model.setRoleName(request.getParameter("user_true_name_autho"));
		String pageNo = request.getParameter("pageNo");//数据起始（start）序号
		String pageSize = request.getParameter("pageSize");//数据长度（length）
		String draw=request.getParameter("draw");//datatable绘制次数
		System.out.println("起始数据就位置：===="+pageNo);
		System.out.println("数据长度+======="+pageSize);
		if (pageNo == "" || pageNo == null) {
			pageNo = "1";
		}
		if (pageSize == "" || pageSize == null) {
			pageSize = "10";
		}
		return flxoaSystemUserRoleService.queryForPage(Integer.valueOf(pageNo),Integer.valueOf(pageSize),draw,model);
	}
	/**
	 * @param request
	 * @param response
	 * @param model
	 * @return 用户角色授权
	 */
	@RequestMapping(value = "/flxoaSystemUserRoleAdd", produces = "text/html;charset=utf-8")
	@ResponseBody
	public String flxoaSystemUserRoleAdd(HttpServletRequest request,
			HttpServletResponse response,@RequestParam(value = "role_name[]") Integer[] role_name, @RequestParam(value = "manage_object_department[]") Integer[] manage_object_department,FlxoaSystemUserRole model){
		HttpServletRequest req =(HttpServletRequest)request;
		String result = "";
		int RoleId = 0 ;
		for(int i = 0; i < role_name.length; i++) {
			RoleId = role_name[i];
			for(int j = 0; j < manage_object_department.length; j++) {
				String userId = request.getParameter("id");
				FlxoaSystemUserRole  userRole = new FlxoaSystemUserRole();
				userRole.setRoleId(RoleId);
				userRole.setDepartmentId(manage_object_department[j]);
				userRole.setUserId(Integer.valueOf(userId));
				//跟新人部门id
				userRole.setUpdateDepartmentId(Integer.parseInt(String.valueOf(req.getSession().getAttribute("departmentId"))));
				//跟新时间
				userRole.setUpdateTime(DateUtils.getSecondTimestamp(new Date()));
				//跟新人ID
				userRole.setUpdateUserId(Integer.parseInt(String.valueOf(req.getSession().getAttribute("userId"))));
				//是否删除标记 0：否
				userRole.setDeleteFlag("0");
				boolean userrole = flxoaSystemUserRoleService.add(userRole);
				if(userrole) {
					result = "1";
				}else {
					result = "0";
				}					
			}
		}
		
		return result;
	}
	
	/**
	 * 用户角色批量授权授权
	 * 
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/system/flxoasystemuserrolebatchadd")
	@ResponseBody
	public String flxoaSystemUserRoleBatchAdd(HttpServletRequest request,HttpServletResponse response, ModelMap model) {
		HttpServletRequest req =(HttpServletRequest)request;
		String result = "";
		int RoleId = 0 ;
		//角色ids
		String role_names = request.getParameter("role_name");
		List<Integer> role_name = new ArrayList<Integer>();
		if(-1 != role_names.indexOf(",")){
			String [] temp = role_names.split(",");
			for (int i = 0; i < temp.length; i++) {
				role_name.add(Integer.parseInt(temp[i]));
			}
			
		}else{
			role_name.add(Integer.parseInt(role_names));
		}
		//部门ids
		String manage_object_departments = request.getParameter("manage_object_department");
		List<Integer> manage_object_department = new ArrayList<Integer>();
		if(-1 != manage_object_departments.indexOf(",")){
			String [] temp = manage_object_departments.split(",");
			for (int i = 0; i < temp.length; i++) {
				manage_object_department.add(Integer.parseInt(temp[i]));
			}
			
		}else{
			manage_object_department.add(Integer.parseInt(manage_object_departments));
		}
		//用户ids
		String ids = request.getParameter("id");
		List<Integer> id = new ArrayList<Integer>();
		if(-1 != ids.indexOf(",")){
			String [] temp = ids.split(",");
			for (int i = 0; i < temp.length; i++) {
				id.add(Integer.parseInt(temp[i]));
			}
			
		}else{
			id.add(Integer.parseInt(ids));
		}		

		for(int i = 0; i < role_name.size(); i++) {
			RoleId = role_name.get(i);
			for(int j = 0; j < manage_object_department.size(); j++) {
				String userId = request.getParameter("id");
				boolean flag = false;
				for (int k = 0; k < id.size(); k++) {
					FlxoaSystemUserRole  userRole = new FlxoaSystemUserRole();
					userRole.setRoleId(RoleId);
					userRole.setDepartmentId(manage_object_department.get(j));
					userRole.setUserId(id.get(k));
					boolean userrole = flxoaSystemUserRoleService.add(userRole);
					if(!userrole){
						flag = true;
					}
				}
				if(!flag){
					result = "1";
				}else{
					result = "0";
				}
			}
		}
		return result;
	}	
	
	/**
	 * @param request
	 * @param response
	 * @param model
	 * @return 用户角色删除
	 */
	@RequestMapping(value = "/system/flxoasystemuserroledelete")
	@ResponseBody
	public String flxoaSystemUserRoleDelete(HttpServletRequest request,
			HttpServletResponse response, FlxoaSystemUserRole model){
		String ids = request.getParameter("userroleid");
		boolean userrole = false;
		String result = "";
		if(-1 != ids.indexOf(",")){
			String [] temp = ids.split(",");
			boolean flag = false;
			for (int i = 0; i < temp.length; i++) {
				model.setId(Integer.valueOf(temp[i]));
				FlxoaSystemUserRole FlxoaSystemUserRole = flxoaSystemUserRoleService.queryById(model);
				userrole = flxoaSystemUserRoleService.delete(FlxoaSystemUserRole);
				if(!userrole){
					flag = true;
				}
			}
			if(!flag){
				userrole = true;
			}
		}else{
			model.setId(Integer.valueOf(ids));
			FlxoaSystemUserRole FlxoaSystemUserRole = flxoaSystemUserRoleService.queryById(model);
			userrole = flxoaSystemUserRoleService.delete(FlxoaSystemUserRole);
		}
		if (userrole) {
			result = "1";
		}
		return result;
	}
	
	
	/**
	 * @param request
	 * @param response
	 * @param model
	 * @return 用户删除
	 */
	@RequestMapping(value = "/flxoaSystemUserDelete", produces = "text/html;charset=utf-8")
	@ResponseBody
	public String flxoaSystemUserDelete(HttpServletRequest request,
			HttpServletResponse response, FlxoaSystemUser model){
		model.setId(Integer.valueOf(request.getParameter("userroleid")));
		String result = "";
		System.out.println("request.getParameter(\"userroleid\")="+request.getParameter("userroleid"));
		FlxoaSystemUser FlxoaSystemUser = flxoaSystemUserService.queryById(model);
		boolean userrole = flxoaSystemUserService.delete(FlxoaSystemUser);
		System.out.println(userrole);
		if (userrole) {
			result = "1";
		}
		return result;
	}
	/**
	 * 获取登录用户信息
	 * @param request
	 * @param response
	 * @param model
	 * @return User json
	 */
	@RequestMapping(value = "/user/getuser", produces = "text/html;charset=utf-8")
	@ResponseBody
	public String getLoginUser(HttpServletRequest request,
			HttpServletResponse response, FlxoaSystemUser model){
		FlxoaSystemUser user = new FlxoaSystemUser();
		user.setUserName(String.valueOf(request.getSession().getAttribute("userName")));
		user.setRealName(String.valueOf(request.getSession().getAttribute("realName")));
		user.setId(Integer.parseInt(String.valueOf(request.getSession().getAttribute("userId"))));
		user.setDepartmentName(String.valueOf(request.getSession().getAttribute("departmentName")));
		user.setCardId(Integer.parseInt(String.valueOf(request.getSession().getAttribute("cardId"))));
		//user.setToken(String.valueOf(request.getSession().getAttribute("token")));
		JSONObject json = JSONObject.fromObject(user);
		return json.toString();
	}
	
	/**
	 * 根据code获取accessToken
	 * @param request
	 * @param response
	 * @param model
	 * @return User json
	 */
	@RequestMapping(value = "/user/gettokenbycode",produces = "text/html;charset=utf-8")
	@ResponseBody
	public String getTokenByCode(HttpServletRequest request,
			HttpServletResponse response, FlxoaSystemUser model){
		//code
		String code = request.getParameter("code");
		//客户端id
//		String client_id = request.getParameter("client_id");
		//客户端密钥
//		String client_secret = request.getParameter("client_secret");
		//返回url
		String redirect_uri = request.getParameter("redirect_uri");
		//认证类型
//		String grant_type = request.getParameter("grant_type");
		//状态
		String state =  request.getParameter("state");		
		String accessToken = "";
		if(
			null != redirect_uri
//			&&null != client_secret
//			&&null != client_id
//			&&null != grant_type
			&&null != state
			&&null != code){
			//code认证
			if(!"".equals(code)){
				FlxoaSystemSso flxoaSystemSso = new FlxoaSystemSso();
//				flxoaSystemSso.setClientId(client_id);
//				flxoaSystemSso.setClientSecret(client_secret);
				flxoaSystemSso.setRedirectUri(redirect_uri);
				flxoaSystemSso.setState(state);
//				flxoaSystemSso.setGrantType(grant_type);
				FlxoaSystemSso queryFlxoaSystemSso = flxoaSystemSsoService.queryByPro(flxoaSystemSso);
				if(null != queryFlxoaSystemSso){
					Map<String,String> mapCode = Singleton.getInstance().getCodeToken();
					accessToken = mapCode.get(code);						
				}
			}
		}
		return accessToken;
	}
	
	/**
	 * 根据token获取登录用户信息
	 * @param request
	 * @param response
	 * @param model
	 * @return User json
	 */
	@RequestMapping(value = "/user/getuserbytoken", produces = "text/html;charset=utf-8")
	@ResponseBody
	public String getUserByToken(HttpServletRequest request,
			HttpServletResponse response, FlxoaSystemUser model){
		// 请求附带token参数
		String token = request.getParameter("accessToken");
		Map<String,String> mapAccessToken = Singleton.getInstance().getAccessTokenUser();
		String userJson = mapAccessToken.get(token);
		return userJson;
	}
	
	/**
	 * 保存其他子系统传入信息
	 * @param request
	 * @param response
	 * @param model
	 * @return User json
	 */
	@RequestMapping(value = "/user/savessoinfo", produces = "text/html;charset=utf-8")
	@ResponseBody
	public String saveSsoInfo(HttpServletRequest request,
			HttpServletResponse response, FlxoaSystemUser model){
		//客户端id
		String client_id = request.getParameter("client_id");
		request.getSession().setAttribute("client_id", client_id);
		//客户端密钥
//		String client_secret = request.getParameter("client_secret");
//		request.getSession().setAttribute("client_secret", client_secret);
		//返回url
		String redirect_uri = request.getParameter("redirect_uri");
		request.getSession().setAttribute("redirect_uri", redirect_uri);
		//请求类型
		String response_type = request.getParameter("response_type");
		request.getSession().setAttribute("response_type", response_type);
		//状态
		String state =  request.getParameter("state");
		request.getSession().setAttribute("state", state);
		return "";
	}	
}
