package com.flx.flxoa.info.contractmanagement.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

import com.alibaba.fastjson.JSONObject;
import com.flx.flxoa.common.util.CommonUtils;
import com.flx.flxoa.common.util.DateUtils;
import com.flx.flxoa.info.contractmanagement.entity.FlxoaContractInformation;
import com.flx.flxoa.info.contractmanagement.manager.FlxoaContractInformationService;
import com.flx.flxoa.info.signin.entity.FlxoaAttendanceSummary;

/**
 * 类名称：FlxoaContractInformationController.java<br>
 * 类描述：<br>
 * 创建时间：2018-9-4, 上午10:20:33
 * 
 * @version 1.0 
 * @since JDK版本 1.7
 * @author 夏改翠 
 */
@Controller
public class FlxoaContractInformationController {

	protected FlxoaContractInformationService flxoaContractInformationService;


	@Autowired
	public void setFlxoaContractInformationService(
			FlxoaContractInformationService flxoaContractInformationService) {
		this.flxoaContractInformationService = flxoaContractInformationService;
	}
	@RequestMapping(value ="goshow/contractList")
	public String goList(HttpServletRequest request,HttpServletResponse response, ModelMap model){
		 return "nk/pages/contractManage/contractInfor";
	}
	/**
	 * 查询合同列表信息
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/flxoaContractManage",produces="text/html;charset=UTF-8")
	@ResponseBody
	public String showContractManage(HttpServletRequest request,HttpServletResponse response,FlxoaContractInformation model){
		 
		 String start = request.getParameter("pageNo"); 
		 String length = request.getParameter("pageSize");
		 String draw = request.getParameter("draw");
		 //查询条件
		 String contractType = request.getParameter("contractType");//合同类型
		 String contractNumber = request.getParameter("contractNumber");
		 String contractName = request.getParameter("contractName");
		 String contractAmountS = request.getParameter("contractAmountS");
		 String contractAmountE = request.getParameter("contractAmountE");
		 String contractDataStart = request.getParameter("contractDataStart");
		 String contractDataEnd = request.getParameter("contractDataEnd");
		 String projName = request.getParameter("projName");
		 String signatoryName = request.getParameter("signatoryName");
		 if (start==""||start==null){
			 start="0";
		 }
		 if(length==""||length==null){
			 length="10";
		 }		
		
		 Map<String,String> map = new HashMap<String,String>();
		 map.put("start", start);
		 map.put("length", length);
		 map.put("draw", draw);
		 map.put("contractType", contractType);
		 map.put("contractNumber", contractNumber);
		 map.put("contractName", contractName);
		 map.put("contractAmountS", contractAmountS);
		 map.put("contractAmountE", contractAmountE);
		 map.put("contractDataStart", contractDataStart);
		 map.put("contractDataEnd", contractDataEnd);
		 map.put("projName", projName);
		 map.put("signatoryName", signatoryName);

		 return flxoaContractInformationService.queryContractList(map);
	 }
	/**
	 * 根据id 查看合同的详细信息
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "contract/queryContractById" ,produces="text/html;charset=UTF-8")
	public String queryContractById(HttpServletRequest request,HttpServletResponse response,ModelMap model){
		String id = request.getParameter("Id");
		List<Map<String,String>> returnList = new ArrayList<Map<String,String>>();
		returnList = flxoaContractInformationService.queryContractById(Integer.valueOf(id));
		
		 //1、使用JSONArray
		JSONArray js =JSONArray.fromObject(returnList);
		return js.toString();
	}
	/**
	 * 插入合同
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="contract/insertContract",produces="text/html;charset=UTF-8")
	public String insertContract(HttpServletRequest request,HttpServletResponse response,ModelMap model){
		FlxoaContractInformation flxoaContractInformation = new FlxoaContractInformation();
		flxoaContractInformation.setProjectId(Integer.valueOf(request.getParameter("projId")));
		flxoaContractInformation.setFormId(Integer.valueOf(request.getParameter("form_id")));
		flxoaContractInformation.setContractAmount(request.getParameter("contract_amount"));//合同额
		flxoaContractInformation.setContractType(request.getParameter("contractType"));//合同类型
		flxoaContractInformation.setSalesContractNumber(request.getParameter("contractNumber"));//销售合同编号
		flxoaContractInformation.setSalesContractName(request.getParameter("contractName"));//销售合同名称
		flxoaContractInformation.setPurchaseContractNumber(request.getParameter("purchas_contract_number"));//采购合同编号
		flxoaContractInformation.setPurchaseContractName(request.getParameter("purchas_contract_name"));//采购合同名称
		flxoaContractInformation.setPartyA(request.getParameter("partyA"));//甲方名称
		flxoaContractInformation.setPartyB(request.getParameter("partyB"));//乙方名称
		flxoaContractInformation.setPartyC(request.getParameter("partyC"));//丙方名称
		flxoaContractInformation.setSignatoryId(Integer.valueOf(request.getParameter("signatory_id")));//签约人id
		flxoaContractInformation.setHandoverId(Integer.valueOf(request.getParameter("handover_id")));//移交人
		flxoaContractInformation.setTransferDate(DateUtils.dateToTimestamp(request.getParameter("transfer_date")));//移交日期
		flxoaContractInformation.setContractsNumber(Integer.valueOf(request.getParameter("contracts_number")));//原件分数
		flxoaContractInformation.setContractScanningcopy(request.getParameter("is_scanning_copy"));//是否有扫描件
		flxoaContractInformation.setContractData(DateUtils.dateToTimestamp(request.getParameter("contract_data")));//签订日期
		flxoaContractInformation.setStoragePosition(request.getParameter("storage_position"));//存放位置
		flxoaContractInformation.setRepayMethod(request.getParameter("repay_method"));//回付款方式
		flxoaContractInformation.setContractEndData(DateUtils.dateToTimestamp(request.getParameter("contractend_data")));//合同结束日期
		flxoaContractInformation.setWarrantyPeriod(request.getParameter("warranty_period"));//质保期
		flxoaContractInformation.setWarrantyMoney(request.getParameter("warranty_money"));//质保金
		flxoaContractInformation.setIsRegisterFlag(request.getParameter("IsRegisterFlag"));//是否登记 
		flxoaContractInformation.setComments(request.getParameter("comments"));//备注
		/*flxoaContractInformation.setCreateUserId(1);
		flxoaContractInformation.setCreateTime(124563367);
		flxoaContractInformation.setCreateDepartmentId(171);
		flxoaContractInformation.setUpdateDeptamentId(171);
		flxoaContractInformation.setUpdateTime(0);
		flxoaContractInformation.setUpdateUserId(1);
		flxoaContractInformation.setDeleteFlag("0");*/
		
		
		boolean flag = flxoaContractInformationService.add(flxoaContractInformation);
		
		//0失败 1成功
		String result="0";
		if (flag) {
					result = "1";
				}
				
		System.out.print(result);	
		
		return result;
	}
	/**
	 * 修改合同,登记合同
	 */
	@ResponseBody
	@RequestMapping(value="contract/updateContract",produces="text/html;charset=UTF-8")
	public String updateContract(HttpServletResponse response,HttpServletRequest request,ModelMap modle){
		String id = request.getParameter("Id");
		FlxoaContractInformation flxoaContractInformation = new FlxoaContractInformation();
		flxoaContractInformation.setId(Integer.valueOf(id));
		FlxoaContractInformation bean = flxoaContractInformationService.queryById(flxoaContractInformation);
		//接收修改的参数 放到bean中
		String handover_id = request.getParameter("handover_id");
		if(!CommonUtils.isEmpty(handover_id)){
			bean.setHandoverId(Integer.valueOf(handover_id));
		}else{
			bean.setHandoverId(0);
		}
		String contract_data = request.getParameter("contract_data");
		if(!CommonUtils.isEmpty(contract_data)){
			bean.setContractData(DateUtils.dateToTimestamp(contract_data));
		}else{
			bean.setContractData(0);
		}
		String transfer_date = request.getParameter("transfer_date");
		if(!CommonUtils.isEmpty(transfer_date)){
			bean.setTransferDate(DateUtils.dateToTimestamp(transfer_date));
		}else{
			bean.setTransferDate(0);
		}
		String contracts_number = request.getParameter("contracts_number");
		if(!CommonUtils.isEmpty(contracts_number)){
			bean.setContractsNumber(Integer.valueOf(contracts_number));
		}else{
			bean.setContractsNumber(0);
		}
		String is_scanning_copy = request.getParameter("is_scanning_copy");
		if(!CommonUtils.isEmpty(is_scanning_copy)){
			bean.setContractScanningcopy(is_scanning_copy);
		}else{
			bean.setContractScanningcopy("0");
		}
		String warranty_period = request.getParameter("warranty_period");
		if(!CommonUtils.isEmpty(warranty_period)){
			bean.setWarrantyPeriod(warranty_period);
		}else{
			bean.setWarrantyPeriod("");
		}
		String warranty_money = request.getParameter("warranty_money");
		if(!CommonUtils.isEmpty(warranty_money)){
			bean.setWarrantyMoney(warranty_money);
		}else{
			bean.setWarrantyMoney("");
		}
		String storage_position = request.getParameter("storage_position");
		if(!CommonUtils.isEmpty(storage_position)){
			bean.setStoragePosition(storage_position);
		}else{
			bean.setStoragePosition("");
		}
		String contractend_data = request.getParameter("contractend_data");
		if(!CommonUtils.isEmpty(contractend_data)){
			bean.setContractData(DateUtils.dateToTimestamp(contractend_data));
		}else{
			bean.setContractData(0);
		}
		String repay_method = request.getParameter("repay_method");
		if(!CommonUtils.isEmpty(repay_method)){
			bean.setRepayMethod(repay_method);
		}else{
			bean.setRepayMethod("");
		}
		String comments = request.getParameter("comments");
		if(!CommonUtils.isEmpty(comments)){
			bean.setComments(comments);
		}else{
			bean.setComments("");
		}
		
		String IsRegisterFlag = request.getParameter("IsRegisterFlag");
		if(!CommonUtils.isEmpty(IsRegisterFlag)){
			bean.setIsRegisterFlag(IsRegisterFlag);
		}
		
		boolean flag = flxoaContractInformationService.update(bean);
		
		//0失败 1成功
		String result="0";
		if (flag) {
					result = "1";
				}
				
		System.out.print(result);	
		
		return result;
		
	}
	/**
	 * 删除未登记的信息
	 */
	@ResponseBody
	@RequestMapping(value="contract/deleteContract",produces="text/html;charset=UTF-8")
	public String deleteContractNotRegister(HttpServletResponse response,HttpServletRequest request,ModelMap modle){
		String id = request.getParameter("Id");
		FlxoaContractInformation flxoaContractInformation = new FlxoaContractInformation();
		flxoaContractInformation.setId(Integer.valueOf(id));
		//根据id查询记录
		FlxoaContractInformation info = flxoaContractInformationService.queryById(flxoaContractInformation);
		
		info.setDeleteFlag("1");
		boolean flag = flxoaContractInformationService.update(info);
		//0失败 1成功
		String result="0";
		if (flag) {
					result = "1";
				}
				
		System.out.print(result);	
		
		return result;
	}
}
