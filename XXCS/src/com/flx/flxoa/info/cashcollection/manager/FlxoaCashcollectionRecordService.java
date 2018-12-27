package com.flx.flxoa.info.cashcollection.manager;


import java.io.OutputStream;
import java.util.List;
import java.util.Map;

import com.flx.flxoa.info.cashcollection.entity.FlxoaCashcollectionClaimAffirm;
import com.flx.flxoa.info.cashcollection.entity.FlxoaCashcollectionRecord;

/**
 *
 * 类名称：FlxoaCashcollectionRecordService.java
 * 类描述：
 * 创建时间：2018-03-16, 下午06:54:26
 *
 *@version 1.0 
 *@since JDK版本1.7 
 *@author 赵鹏辉
 */ 
public interface FlxoaCashcollectionRecordService {
	/**
	 *添加FlxoaCashcollectionRecord
	 */ 
	public boolean add(FlxoaCashcollectionRecord flxoaCashcollectionRecord);
	/**
	 *删除FlxoaCashcollectionRecord
	 */ 
	public boolean delete(FlxoaCashcollectionRecord flxoaCashcollectionRecord);
	/**
	 *修改FlxoaCashcollectionRecord
	 */ 
	public boolean update(FlxoaCashcollectionRecord flxoaCashcollectionRecord);
	/**
	 *查询FlxoaCashcollectionRecord列表
	 */ 
	public List<FlxoaCashcollectionRecord> query(FlxoaCashcollectionRecord flxoaCashcollectionRecord);
	/**
	 *查询FlxoaCashcollectionRecord ByID
	 */ 
	public FlxoaCashcollectionRecord queryById(FlxoaCashcollectionRecord flxoaCashcollectionRecord);
	/**
	 * 根据pid查找
	 * @param pid
	 * @return
	 */
	public List<FlxoaCashcollectionRecord> queryByPId(String pid);
	/**
	 * 分页
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	public String queryForPage(Map<String,String> map);
	/**
	 * 查看
	 * @param pageNo
	 * @param pageSize
	 * @param str
	 * @return
	 */
	public String view(int start,int length,String str,String draw);
	/**
	 * 求和
	 * @return
	 */
	public Long queryCount();
	
	/**
	 * 导入
	 * @param list
	 * @return
	 */
	public boolean replaceModelByxls(List<List<String>> list);
	/**
	 * 查询
	 * @param caro_org_name
	 * @param project_name
	 * @param proj_number
	 * @param start_time
	 * @param end_time
	 * @param dept_id
	 * @param claim_name
	 * @param affirm_name
	 * @param caro_money
	 * @param caro_type
	 * @return
	 */
	public List<Map<String,String>> query(Map<String,String> map);
	/**
	 * 认领
	 * @param flxoaCashcollectionRecord
	 * @return
	 */
	public boolean renling(FlxoaCashcollectionRecord flxoaCashcollectionRecord,FlxoaCashcollectionClaimAffirm flxoaCashcollectionClaimAffirm);
	/**
	 * 审核
	 * @param flxoaCashcollectionRecord
	 * @param flxoaCashcollectionClaimAffirm
	 * @param shenheStatus
	 * @return
	 */
	public boolean shenhe(FlxoaCashcollectionRecord flxoaCashcollectionRecord,FlxoaCashcollectionClaimAffirm flxoaCashcollectionClaimAffirm);
	/**
	 * 认领记录
	 * @param projectId
	 * @return
	 */
	public List<FlxoaCashcollectionRecord> renlingRecord(String projectId);
	/**
	 * 审核记录
	 * @param caroId
	 * @return
	 */
	public List<Map<String,String>> shenheRecord(String caroId);
	/**
	 * 拆分记录
	 * @param projectId
	 * @return
	 */
	public List<Map<String,String>> chaifenRecord(String caroId);
	/**
	 * 拆分
	 * @param oldFlxoaCashcollectionRecord
	 * @param model
	 * @return
	 */
	public boolean chaifen(FlxoaCashcollectionRecord oldFlxoaCashcollectionRecord,List<Map<String, String>> modelList,String roles,Integer userId,Integer nowTime);
}