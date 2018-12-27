package com.flx.flxoa.info.system.manager;


import java.util.List;

import com.flx.flxoa.info.projectmanagement.entity.FlxoaProjectBidInformation;
import com.flx.flxoa.info.projectmanagement.entity.FlxoaProjectInformation;
import com.flx.flxoa.info.system.entity.FlxoaSystemUser;

/**
 *
 * 类名称：FlxoaSystemUserService.java
 * 类描述：
 * 创建时间：2018-03-20, 下午06:22:03
 *
 *@version 1.0 
 *@since JDK版本1.7 
 *@author 张海英 
 */ 
public interface FlxoaSystemUserService {
	/**
	 *添加FlxoaSystemUser
	 */ 
	public boolean add(FlxoaSystemUser flxoaSystemUser);
	/**
	 *删除FlxoaSystemUser
	 */ 
	public boolean delete(FlxoaSystemUser flxoaSystemUser);
	/**
	 *修改FlxoaSystemUser
	 */ 
	public boolean update(FlxoaSystemUser flxoaSystemUser);
	/**
	 *查询FlxoaSystemUser列表
	 */ 
	public List<FlxoaSystemUser> query(FlxoaSystemUser flxoaSystemUser);
	/**
	 *查询FlxoaSystemRole
	 */ 
	public boolean isExist(String username);
	/**
	 *查询FlxoaSystemUser ByID
	 */ 
	public FlxoaSystemUser queryById(FlxoaSystemUser flxoaSystemUser);
	/**
	 * 分页
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	public List<FlxoaSystemUser> queryForPage(int pageNo,int pageSize);
	/**
	 * 根据用户名查询
	 * @param username
	 * @return
	 */
	public FlxoaSystemUser findByUserName(String username);
	
	/**
	 * 根据用户属性查询用户详细信息
	 */
	public FlxoaSystemUser findUserDetialByUserName(FlxoaSystemUser flxoaSystemUser);	
	/**
	 * 根据用户id查询用户
	 * @param userId
	 */
	public FlxoaSystemUser queryByUserId(FlxoaSystemUser flxoaSystemUser );
	
	/**
	 * 根据用户属性 查询用户权限
	 */	
	public List<FlxoaSystemUser> findUserPermisson(FlxoaSystemUser flxoaSystemUser);
	/**
	 * 根据userids,deptids 查询部门内所有人员username,cardid
	*/
	public List<FlxoaSystemUser> queryCardIds(int userid,String deptid);
	/**
	 *分页FlxoaProjectBidInformation pageNo 查询第几页数据  pageSize 每一页显示的数量 
	 */ 
	public String queryForPage(int pageNo,int pageSize,String draw,int userId, String deptIds,FlxoaSystemUser flxoaSystemUser);
	
	/**
	 * 查询所有人员
	 */
	public List<FlxoaSystemUser> queryAllUser();
	/**
	 * 根据微信id查询用户
	 * @param flxoaSystemUser
	 * @return
	 */
	public FlxoaSystemUser getUserByWeixinId(FlxoaSystemUser flxoaSystemUser);

}