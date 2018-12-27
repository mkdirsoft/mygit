package com.flx.flxoa.info.cashcollection.manager.impl;


import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.flx.flxoa.common.util.CommonUtils;
import com.flx.flxoa.common.util.DateUtils;
import com.flx.flxoa.info.cashcollection.entity.FlxoaCashcollectionClaimAffirm;
import com.flx.flxoa.info.cashcollection.entity.FlxoaCashcollectionRecord;
import com.flx.flxoa.info.cashcollection.manager.FlxoaCashcollectionRecordService;
import com.flx.flxoa.info.cashcollection.dao.FlxoaCashcollectionClaimAffirmDao;
import com.flx.flxoa.info.cashcollection.dao.FlxoaCashcollectionRecordDao;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * 类名称：FlxoaCashcollectionRecordServiceImpl.java
 * 类描述：
 * 创建时间：2018-03-16, 下午06:54:26
 *
 * @version 1.0 
 * @since JDK版本1.7 
 * @author 赵鹏辉
 */ 
@Service
@Transactional
public class FlxoaCashcollectionRecordServiceImpl implements FlxoaCashcollectionRecordService {
	private FlxoaCashcollectionRecordDao dao;
	@Autowired
	public void setDao(FlxoaCashcollectionRecordDao dao) {
		this.dao = dao;
	}
	public FlxoaCashcollectionRecordDao getDao() {
		return dao;
	}
	private FlxoaCashcollectionClaimAffirmDao claimAffirmDao;
	@Autowired
	public void setClaimAffirmDao(FlxoaCashcollectionClaimAffirmDao claimAffirmDao) {
		this.claimAffirmDao = claimAffirmDao;
	}
	public FlxoaCashcollectionClaimAffirmDao getClaimAffirmDao() {
		return claimAffirmDao;
	}

	/**
	 *添加FlxoaCashcollectionRecord
	 */ 
	public boolean add(FlxoaCashcollectionRecord flxoaCashcollectionRecord) {
		boolean result = dao.add(flxoaCashcollectionRecord);
		return result;
	}
	/**
	 *删除FlxoaCashcollectionRecord
	 */ 
	public boolean delete(FlxoaCashcollectionRecord flxoaCashcollectionRecord) {
		boolean result = dao.delete(flxoaCashcollectionRecord);
		return result;
	}
	/**
	 *修改FlxoaCashcollectionRecord
	 */ 
	public boolean update(FlxoaCashcollectionRecord flxoaCashcollectionRecord) {
		boolean result = dao.update(flxoaCashcollectionRecord);
		return result;
	}
	/**
	 *查询FlxoaCashcollectionRecord列表
	 */ 
	public List<FlxoaCashcollectionRecord> query(FlxoaCashcollectionRecord flxoaCashcollectionRecord) {
		List<FlxoaCashcollectionRecord> list = dao.query(flxoaCashcollectionRecord);
		return list;
	}
	/**
	 *查询FlxoaCashcollectionRecord ByID
	 */ 
	public FlxoaCashcollectionRecord queryById(FlxoaCashcollectionRecord flxoaCashcollectionRecord) {
		FlxoaCashcollectionRecord result = dao.queryById(flxoaCashcollectionRecord);
		return result;
	}
	/**
	 * 分页
	 */
	public String queryForPage(Map<String,String> map){
		String pageJson = dao.queryForPage(map);
		return pageJson;
	}

	/**
	 * 分页
	 */
	public String view(int start,int length,String str,String draw){
		String pageJson = dao.view(start, length,str,draw);
		return pageJson;
	}

	public Long queryCount(){
		Long count = dao.queryCount();
		return count;
	}

	public boolean replaceModelByxls(List<List<String>> list){
		boolean flag=false;
		for(int i=0;i<list.size();i++){
			List<String> list1 =list.get(i);
			if(list1.size()>1){
				//回款单位名称
				String caroOrgName=list1.get(0);
				//回款金额
				String cacoMoney=list1.get(1);
				if(!CommonUtils.isEmpty(caroOrgName)&&!CommonUtils.isEmpty(cacoMoney)){
					BigDecimal cacoMoney2=new BigDecimal(cacoMoney);
					FlxoaCashcollectionRecord model=new FlxoaCashcollectionRecord();
					model.setFundSource("");
					model.setAccountNumber("");
					model.setCaroOrgName(caroOrgName);
					model.setCaroMoney(cacoMoney2);
					model.setCaroUse("");
					model.setAffirmId(0);
					model.setAffirmTime(0);
					model.setCaroType("");
					model.setClaimId(0);
					model.setClaimTime(0);
					model.setProjectId(0);
					model.setStatus("0");
					model.setPid(0);
					model.setIsshow("0");

					flag = add(model);
				}
			}
		}
		return flag;
	}

	public List<Map<String,String>> query(Map<String,String> map){
		List<Map<String,String>> list = dao.query(map);
		return list;
	}

	/**
	 * 根据pid查找
	 * @param pid
	 * @return
	 */
	public List<FlxoaCashcollectionRecord> queryByPId(String pid){
		List<FlxoaCashcollectionRecord> list = dao.queryByPId(pid);
		return list;
	}

	/**
	 * 认领
	 */
	public boolean renling(FlxoaCashcollectionRecord flxoaCashcollectionRecord,FlxoaCashcollectionClaimAffirm flxoaCashcollectionClaimAffirm) {
		boolean result=false;
		boolean caroResult = dao.update(flxoaCashcollectionRecord);
		boolean caroClaimAffirmResult = claimAffirmDao.add(flxoaCashcollectionClaimAffirm);
		if(caroResult&&caroClaimAffirmResult){
			result=true;
		}
		return result;
	}


	/**
	 * 审核
	 */
	public boolean shenhe(FlxoaCashcollectionRecord flxoaCashcollectionRecord,FlxoaCashcollectionClaimAffirm flxoaCashcollectionClaimAffirm) {
		boolean result=false;
		boolean caroResult = dao.update(flxoaCashcollectionRecord);
		boolean caroClaimAffirmResult = claimAffirmDao.add(flxoaCashcollectionClaimAffirm);
		if(caroResult&&caroClaimAffirmResult){
			result=true;
		}
		return result;
	}

	/**
	 * 认领记录
	 * @param projectId
	 * @return
	 */
	public List<FlxoaCashcollectionRecord> renlingRecord(String projectId){
		List<FlxoaCashcollectionRecord> list = dao.renlingRecord(projectId);
		return list;
	}

	/**
	 * 审核记录
	 * @param projectId
	 * @return
	 */
	public List<Map<String,String>> shenheRecord(String caroId){
		List<Map<String,String>> list = dao.shenheRecord(caroId);
		return list;
	}
	/**
	 * 拆分记录
	 * @param caroId
	 * @return
	 */
	public List<Map<String,String>> chaifenRecord(String caroId){
		List<Map<String,String>> list = dao.chaifenRecord(caroId);
		return list;
	}
	/**
	 * 拆分
	 */
	public boolean chaifen(
			FlxoaCashcollectionRecord oldFlxoaCashcollectionRecord,
			List<Map<String, String>> rsList,String roles,Integer userId,Integer nowTime) {
		boolean result=false;
		boolean newResult=false;
		boolean caroClaimAffirmResult =false;
		String role[]=roles.split(",");
		boolean renling=false;
		boolean shenhe=false;
		boolean caiwu=false;
		for(int i=0;i<role.length;i++){
			if(role[i].equals("回款认领")){
				renling=true;
			}else if(role[i].equals("回款审核")){
				shenhe=true;
			}else if(role[i].equals("财务回款")){
				caiwu=true;
			}
		}
		//当前数据库状态
		String oldStatus="";
		//新状态
		String status="";
		//是否显示
		String isshow="0";
		int affirmId=0;
		int affirmTime=0;
		int claimId=0;
		int claimTime=0;
		if(caiwu){
			oldStatus="4";
			status="0";
			isshow="0";
		}else{
			if(shenhe){
				oldStatus="6";
				status="6";
				affirmId=userId;
				affirmTime=nowTime;
				claimId=userId;
				claimTime=nowTime;
			}else if(renling){
				oldStatus="5";
				status="5";
				claimId=userId;
				claimTime=nowTime;
			}
			isshow="1";
		}

		oldFlxoaCashcollectionRecord.setStatus(oldStatus);
		oldFlxoaCashcollectionRecord.setCaroUse("");
		String chaifenMoney="";
		for(int i=0;i<rsList.size();i++){
			String caroMoney=rsList.get(i).get("caroMoney");
			if(CommonUtils.isEmpty(caroMoney)){
				caroMoney="0";
			}
			BigDecimal caroMoney2=new BigDecimal(caroMoney);
			chaifenMoney+=caroMoney2;
			if(i<rsList.size()-1){
				chaifenMoney+=", ";
			}
		}

		for(int i=0;i<rsList.size();i++){
			String createTime=rsList.get(i).get("createTime");
			String caroUse=rsList.get(i).get("caroUse");
			String caroOrgName=rsList.get(i).get("caroOrgName");
			String caroMoney=rsList.get(i).get("caroMoney");
			String projectId=rsList.get(i).get("projectId");
			String caroType=rsList.get(i).get("caroType");

			if(CommonUtils.isEmpty(caroMoney)){
				caroMoney="0";
			}
			BigDecimal caroMoney2=new BigDecimal(caroMoney);
			FlxoaCashcollectionRecord model=new FlxoaCashcollectionRecord();
			model.setFundSource("");
			model.setAccountNumber("");
			model.setCaroOrgName(CommonUtils.returnStr(caroOrgName));
			model.setCaroMoney(caroMoney2);
			model.setCaroUse(CommonUtils.returnStr(caroUse));
			model.setAffirmId(affirmId);
			model.setAffirmTime(affirmTime);
			model.setCaroType(CommonUtils.returnStr(caroType));
			model.setClaimId(claimId);
			model.setClaimTime(claimTime);
			if(CommonUtils.isEmpty(projectId)){
				model.setProjectId(0);
			}else{
				model.setProjectId(Integer.parseInt(projectId));
			}
			model.setStatus(status);
			model.setPid(oldFlxoaCashcollectionRecord.getId());
			model.setIsshow(isshow);
			if(CommonUtils.isEmpty(createTime)){
				model.setCreateTime(0);
			}else{
				model.setCreateTime(DateUtils.dateToTimestamp(createTime));
			}
			newResult = dao.add(model);

			FlxoaCashcollectionClaimAffirm flxoaCashcollectionClaimAffirm=new FlxoaCashcollectionClaimAffirm();
			flxoaCashcollectionClaimAffirm.setCaroId(model.getId());
			flxoaCashcollectionClaimAffirm.setStatus("3");
			flxoaCashcollectionClaimAffirm.setProjectId(0);
			flxoaCashcollectionClaimAffirm.setRevocationReason("");
			String operationContent="拆分前金额："+oldFlxoaCashcollectionRecord.getCaroMoney()+"； 拆分后金额："+chaifenMoney;
			flxoaCashcollectionClaimAffirm.setOperationContent(operationContent);
			caroClaimAffirmResult = claimAffirmDao.add(flxoaCashcollectionClaimAffirm);
		}

		boolean oldResult = dao.update(oldFlxoaCashcollectionRecord);
		FlxoaCashcollectionClaimAffirm flxoaCashcollectionClaimAffirm=new FlxoaCashcollectionClaimAffirm();
		flxoaCashcollectionClaimAffirm.setCaroId(oldFlxoaCashcollectionRecord.getId());
		flxoaCashcollectionClaimAffirm.setStatus("3");
		flxoaCashcollectionClaimAffirm.setProjectId(0);
		flxoaCashcollectionClaimAffirm.setRevocationReason("");
		String operationContent="拆分前金额："+oldFlxoaCashcollectionRecord.getCaroMoney()+"； 拆分后金额："+chaifenMoney;
		flxoaCashcollectionClaimAffirm.setOperationContent(operationContent);
		caroClaimAffirmResult = claimAffirmDao.add(flxoaCashcollectionClaimAffirm);
		if(oldResult&&newResult&&caroClaimAffirmResult){
			result=true;
		}
		return result;
	}
}