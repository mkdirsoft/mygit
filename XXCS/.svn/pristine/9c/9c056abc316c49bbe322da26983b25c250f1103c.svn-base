package com.flx.flxoa.info.system.dao.impl;


import java.util.List;
import com.flx.flxoa.info.system.entity.FlxoaSystemFuncation;
import com.flx.flxoa.info.system.dao.FlxoaSystemFuncationDao;
import org.springframework.stereotype.Repository;
import com.flx.flxoa.common.hibernate3.HibernateBaseDao;

/**
 *
 * 类名称：FlxoaSystemFuncationDaoImpl.java
 * 类描述：
 * 创建时间：2018-03-18, 下午03:46:59
 *
 * @version 1.0 
 * @since JDK版本1.7 
 * @author 刘凯 
 */ 
@Repository
public class FlxoaSystemFuncationDaoImpl extends HibernateBaseDao<FlxoaSystemFuncation, Integer> implements FlxoaSystemFuncationDao {
	/**
	 *添加FlxoaSystemFuncation
	 */ 
	public boolean add(FlxoaSystemFuncation flxoaSystemFuncation) {
		return save(flxoaSystemFuncation);
	}
	/**
	 *删除FlxoaSystemFuncation
	 */ 
	public boolean delete(FlxoaSystemFuncation flxoaSystemFuncation) {
		flxoaSystemFuncation.setDeleteFlag("1");
		return save(flxoaSystemFuncation);
	}
	/**
	 *修改FlxoaSystemFuncation
	 */ 
	public boolean update(FlxoaSystemFuncation flxoaSystemFuncation) {
		return modify(flxoaSystemFuncation);
	}
	/**
	 *查询FlxoaSystemFuncation列表
	 */ 
	public List<FlxoaSystemFuncation> query(FlxoaSystemFuncation flxoaSystemFuncation) {
		String hql = " from FlxoaSystemFuncation where delete_flag = '0' ";
		if(null != flxoaSystemFuncation){
			if(null != flxoaSystemFuncation.getIsMenu()){
				hql += " and is_menu = '"+flxoaSystemFuncation.getIsMenu()+"' ";
			}			
		}
		hql += " order by function_sort";
		return getListByHQL(hql, null);
	}
	/**
	 *查询FlxoaSystemFuncation ByID
	 */ 
	public FlxoaSystemFuncation queryById(FlxoaSystemFuncation flxoaSystemFuncation) {
		return get(flxoaSystemFuncation.getId());
	}
	
	/**
	 *根据url列表页  可以显示哪些菜单按钮
	 */		
	@Override
	public String queryButtonByPath(String listPath) {
		String hql = " from FlxoaSystemFuncation where delete_flag = '0' ";
		hql += " and url = '"+listPath+"' ";
		String buttonIds = "";
		List<FlxoaSystemFuncation> list = getListByHQL(hql, null);
		if(list.size() > 0)
		{
			int functionId = list.get(0).getId();
			hql = " from FlxoaSystemFuncation where delete_flag = '0' ";
			hql += " and parent_id = " + functionId+" and is_menu = '1' ";
			List<FlxoaSystemFuncation> listChild = getListByHQL(hql, null);
			if(listChild.size() > 0){
				for (int i = 0; i < listChild.size(); i++) {
					if(!"".equals(listChild.get(i).getButtonId())){
						buttonIds += listChild.get(i).getButtonId() + ",";
					}
				}
				if(!"".equals(buttonIds)){
					buttonIds = buttonIds.substring(0,buttonIds.length()-1);
				}
			}
		}
		return buttonIds;
	}
	
	@Override
	protected Class<FlxoaSystemFuncation> getEntityClass() {
		return FlxoaSystemFuncation.class;
	}
	@Override
	public int queryByMaxId() {
		String sql = "select Max(id) from flxoa_system_funcation";
		int maxId = 0;
		List list = getListBySQL(sql, null);
		if(list.size() > 0){
			maxId = (Integer)list.get(0);
		}
		return maxId;
	}


}