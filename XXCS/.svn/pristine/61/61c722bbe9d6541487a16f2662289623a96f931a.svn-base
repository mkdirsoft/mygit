package com.flx.flxoa.info.contractmanagement.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.flx.flxoa.common.util.CommonUtils;
import com.flx.flxoa.common.util.DateUtils;
import com.flx.flxoa.info.contractmanagement.entity.FlxoaContractLoanreturn;
import com.flx.flxoa.info.contractmanagement.manager.FlxoaContractLoanreturnService;
/**
 * 类名称：FlxoaContractLoanRenturnController.java<br>
 * 类描述：<br>
 * 创建时间：2018-9-4, 上午10:20:33
 * 
 * @version 1.0 
 * @since JDK版本 1.7
 * @author 夏改翠 
 */
@Controller
public class FlxoaContractLoanRenturnController {
	
	protected FlxoaContractLoanreturnService flxoaContractLoanreturnService;

	
	@Autowired
	public void setFlxoaContractLoanreturnService(
			FlxoaContractLoanreturnService flxoaContractLoanreturnService) {
		this.flxoaContractLoanreturnService = flxoaContractLoanreturnService;
	}
	@RequestMapping(value ="contract/contractLoanList")
	public String goList(HttpServletRequest request,HttpServletResponse response, ModelMap model){
		 return "nk/pages/contractManage/contractRecord";
	}
	@ResponseBody
	@RequestMapping(value = "contract/loanDetils",produces="text/html;charset=UTF-8")
	public String showContractLoanDetils(HttpServletRequest request,HttpServletResponse response,FlxoaContractLoanreturn model){
		String start = request.getParameter("pageNo"); 
		String length = request.getParameter("pageSize");
		String draw = request.getParameter("draw");
		//查询条件
		String sqrzName = request.getParameter("sqrzName");//合同类型
		String contractNumber = request.getParameter("contractNumber");
		String contractName = request.getParameter("contractName");
		String loanStatus = request.getParameter("loanStatus");
		String projNumber = request.getParameter("projNumber");
		String contractDataStart = request.getParameter("contractDataStart");
		String contractDataEnd = request.getParameter("contractDataEnd");
		
		Map<String,String> map = new HashMap<String,String>();
		map.put("start", start);
		map.put("length", length);
		map.put("draw", draw);
		map.put("sqrzName", sqrzName);
		map.put("contractNumber", contractNumber);
		map.put("contractName", contractName);
		map.put("loanStatus", loanStatus);
		map.put("projNumber", projNumber);
		map.put("contractDataStart", contractDataStart);
		map.put("contractDataEnd", contractDataEnd);
		return flxoaContractLoanreturnService.queryPageContractLoan(map);
	}
	/**
	 * 借出操作，归还操作
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "contract/UpdateLoan",produces="text/html;charset=UTF-8")
	public String LoanContteact(HttpServletRequest request,HttpServletResponse response,FlxoaContractLoanreturn model){
		String id = request.getParameter("Id");
		model.setId(Integer.valueOf(id));
		FlxoaContractLoanreturn bean = flxoaContractLoanreturnService.queryById(model);
		String flg = request.getParameter("flag");
		Date date = new Date();		
		if(flg.equals("1")){//借出
			bean.setLoanStatus("1");
			bean.setLoanTime(DateUtils.getSecondTimestamp(date));
			bean.setLoanPeople(Integer.valueOf(request.getSession().getAttribute("userId").toString()));			
		}else{//归还
			String comments = request.getParameter("comments");
			bean.setLoanStatus("2");
			bean.setReturnTime(DateUtils.getSecondTimestamp(date));
			bean.setRemarks(comments);//归还时的备注
			bean.setReturnPeople(Integer.valueOf(request.getSession().getAttribute("userId").toString()));
		}
		boolean flag = flxoaContractLoanreturnService.update(bean);
		//0失败 1成功
		String result="0";
		if (flag){
					result = "1";
		}
		return result;
	}
	/**
	 * 批量借出、归还
	 */
	@ResponseBody
	@RequestMapping(value ="contract/UpdateLoans",produces="text/html;charset=UTF-8")
	public String LoanContteactS(HttpServletRequest request,HttpServletResponse response,FlxoaContractLoanreturn model){
		String Ids = request.getParameter("Ids");
		String[] ids = Ids.split(",");
		FlxoaContractLoanreturn bean=new FlxoaContractLoanreturn();
		boolean flag=false;
		for(int i=0;i<ids.length;i++){
			model.setId(Integer.valueOf(ids[i]));
			System.out.println(Ids);
			bean = flxoaContractLoanreturnService.queryById(model);
			
			String flg = request.getParameter("flag");
			Date date = new Date();		
			if(flg.equals("1")){//借出
				bean.setLoanStatus("1");
				bean.setLoanTime(DateUtils.getSecondTimestamp(date));
				bean.setLoanPeople(Integer.valueOf(request.getSession().getAttribute("userId").toString()));			
			}else{//归还
				String comments = request.getParameter("comments");
				if(CommonUtils.isEmpty(comments)){//为空时
					bean.setRemarks("");//归还时的备注					
				}else{
					bean.setRemarks(comments);//归还时的备注
				}
				bean.setLoanStatus("2");
				bean.setReturnTime(DateUtils.getSecondTimestamp(date));
				bean.setReturnPeople(Integer.valueOf(request.getSession().getAttribute("userId").toString()));
			}
			 flag = flxoaContractLoanreturnService.update(bean);
		}
		//0失败 1成功
		String result="0";
		if (flag){
					result = "1";
		}
		return result;
	}
}
