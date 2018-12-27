package com.flx.flxoa.common.hibernate3;

import static org.hibernate.EntityMode.POJO;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.sql.Types;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;

import org.hibernate.Criteria;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.ScrollableResults;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.hibernate.jdbc.Work;
import org.hibernate.metadata.ClassMetadata;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

import com.flx.flxoa.common.util.CommonUtils;
import com.flx.flxoa.common.util.MyBeanUtils;
import com.flx.flxoa.info.signin.entity.FlxoaAttendanceSigndetails;

/**
 * hibernate DAO基类
 * 
 * 提供hql分页查询，拷贝更新等一些常用功能。
 * 
 * @author Yu Haidong
 *
 * @param <T>
 * @param <ID>
 */
public abstract class HibernateBaseDao<T, ID extends Serializable> extends
HibernateSimpleDao {

	/**
	 * @see Session.get(Class,Serializable)
	 * @param id
	 * @return 持久化对象
	 */
	protected T get(ID id) {
		return get(id, false);
	}

	/**
	 * @see Session.get(Class,Serializable,LockMode)
	 * @param id
	 *            对象ID
	 * @param lock
	 *            是否锁定，使用LockMode.UPGRADE
	 * @return 持久化对象
	 */
	@SuppressWarnings("unchecked")
	protected T get(ID id, boolean lock) {
		T entity;
		if (lock) {
			entity = (T) getSession().get(getEntityClass(), id,
					LockMode.UPGRADE);
		} else {
			entity = (T) getSession().get(getEntityClass(), id);
		}
		return entity;
	}

	/**
	 * 按属性查找对象列表
	 */
	@SuppressWarnings("unchecked")
	protected List<T> findByProperty(String property, Object value) {
		Assert.hasText(property);
		return createCriteria(Restrictions.eq(property, value)).list();
	}

	/**
	 * 按属性查找唯一对象
	 */
	@SuppressWarnings("unchecked")
	public T findUniqueByPropery(String property, Object value) {
		Assert.hasText(property);
		Assert.notNull(value);

		return (T) createCriteria(Restrictions.eq(property, value))
				.uniqueResult();
	}

	/**
	 * 通过Updater更新对象
	 * 
	 * @param updater
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public T updateByUpdater(Updater<T> updater) {
		ClassMetadata cm = sessionFactory.getClassMetadata(getEntityClass());
		T bean = updater.getBean();
		T po = (T) getSession().get(getEntityClass(),
				cm.getIdentifier(bean, POJO));
		updaterCopyToPersistentObject(updater, po, cm);
		return po;
	}

	/**
	 * 将更新对象拷贝至实体对象，并处理many-to-one的更新。
	 * 
	 * @param updater
	 * @param po
	 */
	private void updaterCopyToPersistentObject(Updater<T> updater, T po,
			ClassMetadata cm) {
		String[] propNames = cm.getPropertyNames();
		String identifierName = cm.getIdentifierPropertyName();
		T bean = updater.getBean();
		Object value;
		for (String propName : propNames) {
			if (propName.equals(identifierName)) {
				continue;
			}
			try {
				value = MyBeanUtils.getSimpleProperty(bean, propName);
				if (!updater.isUpdate(propName, value)) {
					continue;
				}
				cm.setPropertyValue(po, propName, value, POJO);
			} catch (Exception e) {
				throw new RuntimeException(
						"copy property to persistent object failed: '"
								+ propName + "'", e);
			}
		}
	}

	/**
	 * 根据Criterion条件创建Criteria,后续可进行更多处理,辅助函数.
	 */
	public Criteria createCriteria(Criterion... criterions) {
		Criteria criteria = getSession().createCriteria(getEntityClass());

		for (Criterion c : criterions) {
			criteria.add(c);
		}

		return criteria;
	}

	/**
	 * <保存实体>
	 * <完整保存实体>
	 * @param t 实体参数
	 * @see com.itv.launcher.util.IBaseDao#save(java.lang.Object)
	 */
	public boolean save(T t) {
		try {
			super.getSession().save(t);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;	
	}

	/**
	 * <保存或者更新实体>
	 * @param t 实体
	 * @see com.itv.launcher.util.IBaseDao#saveOrUpdate(java.lang.Object)
	 */
	public void saveOrUpdate(T t) {
		super.getSession().saveOrUpdate(t);
	}

	/**
	 * <load>
	 * <加载实体的load方法>
	 * @param id 实体的id
	 * @return 查询出来的实体
	 * @see com.itv.launcher.util.IBaseDao#load(java.io.Serializable)
	 */
	public T load(ID id) {
		T load = (T) super.getSession().load(getEntityClass(), id);
		return load;
	}


	/**
	 * <contains>
	 * @param t 实体
	 * @return 是否包含
	 * @see com.itv.launcher.util.IBaseDao#contains(java.lang.Object)
	 */
	public boolean contains(T t) {
		return super.getSession().contains(t);
	}

	/**
	 * <delete>
	 * <删除表中的t数据>
	 * @param t 实体
	 * @see com.itv.launcher.util.IBaseDao#delete(java.lang.Object)
	 */
	public boolean del(T t) {
		try {
			super.getSession().delete(t);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;	    	
	}

	/**
	 * <根据ID删除数据>
	 * @param Id 实体id
	 * @return 是否删除成功
	 * @see com.itv.launcher.util.IBaseDao#deleteById(java.io.Serializable)
	 */
	public boolean deleteById(ID Id) {
		T t = get(Id);
		if(t == null){
			return false;
		}
		try {
			del(t);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}         
		return true;
	}

	/**
	 * <删除所有>
	 * @param entities 实体的Collection集合
	 * @see com.itv.launcher.util.IBaseDao#deleteAll(java.util.Collection)
	 */
	public void deleteAll(Collection<T> entities) {
		for(Object entity : entities) {
			super.getSession().delete(entity);
		}
	}

	/**
	 * <执行Hql语句>
	 * @param hqlString hql
	 * @param values 不定参数数组
	 * @see com.itv.launcher.util.IBaseDao#queryHql(java.lang.String, java.lang.Object[])
	 */
	public void queryHql(String hqlString, Object... values) {
		Query query = super.getSession().createQuery(hqlString);
		if (values != null)
		{
			for (int i = 0; i < values.length; i++)
			{
				query.setParameter(i, values[i]);
			}
		}
		query.executeUpdate();
	}



	/**
	 * <根据HQL语句查找唯一实体>
	 * @param hqlString HQL语句
	 * @param values 不定参数的Object数组
	 * @return 查询实体
	 * @see com.itv.launcher.util.IBaseDao#getByHQL(java.lang.String, java.lang.Object[])
	 */
	public T getByHQL(String hqlString, Object... values) {
		Query query = super.getSession().createQuery(hqlString);
		if (values != null)
		{
			for (int i = 0; i < values.length; i++)
			{
				query.setParameter(i, values[i]);
			}
		}
		return (T) query.uniqueResult();
	}

	/**
	 * <根据SQL语句查找唯一实体>
	 * @param sqlString SQL语句
	 * @param values 不定参数的Object数组
	 * @return 查询实体
	 * @see com.itv.launcher.util.IBaseDao#getBySQL(java.lang.String, java.lang.Object[])
	 */
	public T getBySQL(String sqlString, Object... values) {
		Query query = super.getSession().createSQLQuery(sqlString);
		if (values != null)
		{
			for (int i = 0; i < values.length; i++)
			{
				query.setParameter(i, values[i]);
			}
		}
		return (T) query.uniqueResult();
	}

	/**
	 * <根据HQL语句，得到对应的list>
	 * @param hqlString HQL语句
	 * @param values 不定参数的Object数组
	 * @return 查询多个实体的List集合
	 * @see com.itv.launcher.util.IBaseDao#getListByHQL(java.lang.String, java.lang.Object[])
	 */
	public List<T> getListByHQL(String hqlString, Object... values) {
		Query query = super.getSession().createQuery(hqlString);
		if (values != null)
		{
			for (int i = 0; i < values.length; i++)
			{
				query.setParameter(i, values[i]);
			}
		}
		return query.list();
	}

	/**
	 * <根据SQL语句，得到对应的list>
	 * @param sqlString HQL语句
	 * @param values 不定参数的Object数组
	 * @return 查询多个实体的List集合
	 * @see com.itv.launcher.util.IBaseDao#getListBySQL(java.lang.String, java.lang.Object[])
	 */
	public List<T> getListBySQL(String sqlString, Object... values ) {
		Query query = super.getSession().createSQLQuery(sqlString);
		if (values != null)
		{
			for (int i = 0; i < values.length; i++)
			{
				query.setParameter(i, values[i]);
			}
		}
		return query.list();
	}

	/**
	 * 根据SQL返回List
	 * @author 
	 * 
	 */
	public List querySQL(String sql, Object... values){
		Session session = getSession();
		Query query = session.createSQLQuery(sql);
		if (values != null)
		{
			for (int i = 0; i < values.length; i++)
			{
				query.setParameter(i, values[i]);
			}
		}
		List list = query.list();
		System.out.println(list);
		return list;
	}

	public List querySQL2(String sql, Object... values){
		Session session = getSession();
		Query query = session.createSQLQuery(sql);
		if (values != null)
		{
			for (int i = 0; i < values.length; i++)
			{
				query.setParameter(i, values[i]);
			}
		}
		List list = query.list();
		System.out.println(list);
		return list;
	}
	/**
	 * 根据HQL返回List
	 * @author 
	 *
	 */
	@SuppressWarnings("unchecked")
	public List queryByHQL(String hql){
		Session session = getSession();
		Query query = session.createQuery(hql);
		List list = query.list();
		return list;
	}

	/**
	 * @param 执行sql语句
	 */
	public void executeSql(String sql, Object... values){
		Session session = getSession();
		SQLQuery query=session.createSQLQuery(sql);
		if (values != null)
		{
			for (int i = 0; i < values.length; i++)
			{
				query.setParameter(i, values[i]);
			}
		}
		query.executeUpdate();
	}
	/**
	 * 由sql语句得到List
	 * @param sql
	 * @param map
	 * @param values
	 * @return List
	 * @see com.itv.launcher.util.IBaseDao#findListBySql(java.lang.String, com.itv.launcher.util.RowMapper, java.lang.Object[])
	 */
	public List findListBySql(final String sql, final RowMapper map, final Object... values) {
		final List list = new ArrayList();
		// 执行JDBC的数据批量保存
		Work jdbcWork = new Work()
		{
			public void execute(Connection connection)
					throws SQLException
					{

				PreparedStatement ps = null;
				ResultSet rs = null;
				try
				{
					ps = connection.prepareStatement(sql);
					for (int i = 0; i < values.length; i++)
					{
						setParameter(ps, i, values[i]);

					}

					rs = ps.executeQuery();
					int index = 0;
					while (rs.next())
					{
						Object obj = map.mapRow(rs, index++);
						list.add(obj);

					}
				}
				finally
				{
					if (rs != null)
					{
						rs.close();

					}
					if (ps != null)
					{
						ps.close();
					}
				}
					}
		};
		super.getSession().doWork(jdbcWork);
		return list;
	}

	/**
	 * <refresh>
	 * @param t 实体
	 * @see com.itv.launcher.util.IBaseDao#refresh(java.lang.Object)
	 */
	public void refresh(T t) {
		super.getSession().refresh(t);
	}

	/**
	 * <update>
	 * @param t 实体
	 * @return 
	 * @see com.itv.launcher.util.IBaseDao#update(java.lang.Object)
	 */
	public boolean modify(T t) {
		try {
			super.getSession().update(t);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	/**
	 * <HQL分页查询>
	 * @param hql HQL语句
	 * @param countHql 查询记录条数的HQL语句
	 * @param pageNo 下一页
	 * @param pageSize 一页总条数
	 * @param values 不定Object数组参数
	 * @return PageResults的封装类，里面包含了页码的信息以及查询的数据List集合
	 * @see com.itv.launcher.util.IBaseDao#findPageByFetchedHql(java.lang.String, java.lang.String, int, int, java.lang.Object[])
	 */
	public PageResults<T> findPageByFetchedHql(String hql, String countHql,
			int pageNo, int pageSize, Object... values) {
		PageResults<T> retValue = new PageResults<T>();
		Query query = super.getSession().createQuery(hql);
		if(values != null){
			for(int i = 0; i < values.length; i++) {
				query.setParameter(i, values[i]);
			}
		}
		int currentPage = pageNo > 1 ? pageNo : 1;
		retValue.setCurrentPage(currentPage);
		retValue.setPageSize(pageSize);
		if (countHql == null)
		{
			ScrollableResults results = query.scroll();
			results.last();
			retValue.setTotalCount(results.getRowNumber() + 1);// 设置总记录数
		}
		else
		{
			Long count = countByHql(countHql, values);
			retValue.setTotalCount(count.intValue());
		}
		retValue.resetPageNo();
		List<T> itemList = query.setFirstResult((currentPage - 1) * pageSize).setMaxResults(pageSize).list();
		if (itemList == null)
		{
			itemList = new ArrayList<T>();
		}
		retValue.setResults(itemList);

		return retValue;
	}

	/**
	 * 
	 * 设置每行批处理参数
	 * 
	 * @param ps
	 * @param pos ?占位符索引，从0开始
	 * @param data
	 * @throws SQLException
	 * @see [类、类#方法、类#成员]
	 */
	private void setParameter(PreparedStatement ps, int pos, Object data)
			throws SQLException
			{
		if (data == null)
		{
			ps.setNull(pos + 1, Types.VARCHAR);
			return;
		}
		Class dataCls = data.getClass();
		if (String.class.equals(dataCls))
		{
			ps.setString(pos + 1, (String)data);
		}
		else if (boolean.class.equals(dataCls))
		{
			ps.setBoolean(pos + 1, ((Boolean)data));
		}
		else if (int.class.equals(dataCls))
		{
			ps.setInt(pos + 1, (Integer)data);
		}
		else if (double.class.equals(dataCls))
		{
			ps.setDouble(pos + 1, (Double)data);
		}
		else if (Date.class.equals(dataCls))
		{
			Date val = (Date)data;
			ps.setTimestamp(pos + 1, new Timestamp(val.getTime()));
		}
		else if (BigDecimal.class.equals(dataCls))
		{
			ps.setBigDecimal(pos + 1, (BigDecimal)data);
		}
		else
		{
			// 未知类型
			ps.setObject(pos + 1, data);
		}

			}

	public List<T> queryForPageByHQL(int pageNo, int pageSize,String hql) {
		// TODO Auto-generated method stub
		List<T> entitylist=null;
		try{
			if(pageNo<2){
				pageNo=1;
			}
			Query query = getSession().createQuery(hql);
			query.setFirstResult((pageNo-1)*pageSize);
			query.setMaxResults(pageSize);
			entitylist = query.list();
		}catch(RuntimeException re){
			throw re;
		}
		return entitylist;
	}
	
	/**
	 * 根据sql分页
	 * @param pageNo
	 * @param pageSize
	 * @param sql
	 * @param values
	 * @return
	 */
	public List<T> queryForPageBySQL(int pageNo, int pageSize,String sql, Object... values){
		List<T> entitylist=null;
		try{
			if(pageNo<2){
				pageNo=1;
			}
			Session session = getSession();
			Query query = session.createSQLQuery(sql);
			query.setFirstResult((pageNo-1)*pageSize);
			query.setMaxResults(pageSize);
			if (values != null)
			{
				for (int i = 0; i < values.length; i++)
				{
					query.setParameter(i, values[i]);
				}
			}
			entitylist=query.list();
		}catch(RuntimeException re){
			throw re;
		}
		return entitylist;
	}
	
	/**
	 * 根据sql分页
	 * @param pageNo
	 * @param pageSize
	 * @param sql
	 * @param values
	 * @return
	 */
	public List queryListForPageBySQL(int start, int length,String sql, Object... values){
		List entitylist=null;
		try{
			Session session = getSession();
			Query query = session.createSQLQuery(sql);
			query.setFirstResult(start);
			query.setMaxResults(length);
			if (values != null)
			{
				for (int i = 0; i < values.length; i++)
				{
					query.setParameter(i, values[i]);
				}
			}
			entitylist=query.list();
		}catch(RuntimeException re){
			throw re;
		}
		return entitylist;
	}
	
	/**
	 * 图标
	 * @param pageNo
	 * @param pageSize
	 * @param sql
	 * @param values
	 * @return
	 */
	public List queryListForPageIconBySQL(String sql, Object... values){
		List entitylist=null;
		try{
			Session session = getSession();
			Query query = session.createSQLQuery(sql);
			if (values != null)
			{
				for (int i = 0; i < values.length; i++)
				{
					query.setParameter(i, values[i]);
				}
			}
			entitylist=query.list();
		}catch(RuntimeException re){
			throw re;
		}
		return entitylist;
	}
	
	
	/**
	 * 根据sql分页
	 * @param pageNo
	 * @param pageSize
	 * @param sql
	 * @param values
	 * @return
	 */
	public List queryListMarketForPageBySQL(String sql, Object... values){
		List entitylist=null;
		try{
			Session session = getSession();
			Query query = session.createSQLQuery(sql);
			if (values != null)
			{
				for (int i = 0; i < values.length; i++)
				{
					query.setParameter(i, values[i]);
				}
			}
			entitylist=query.list();
		}catch(RuntimeException re){
			throw re;
		}
		return entitylist;
	}
	/**
	 * <根据HQL得到记录数>
	 * @param hql HQL语句
	 * @param values 不定参数的Object数组
	 * @return 记录总数
	 * @see com.itv.launcher.util.IBaseDao#countByHql(java.lang.String, java.lang.Object[])
	 */
	public Long countByHql(String hql, Object... values) {
		Query query = super.getSession().createQuery(hql);
		if(values != null){
			for(int i = 0; i < values.length; i++) {
				query.setParameter(i, values[i]);
			}
		}
		return (Long) query.uniqueResult();
	}
	/**
	 * 根据sql查询记录数
	 * @param sql
	 * @param values
	 * @return
	 */
	public Long countBySql(String sql, Object... values) {
		Query query = super.getSession().createSQLQuery(sql);
		if(values != null){
			for(int i = 0; i < values.length; i++) {
				query.setParameter(i, values[i]);
			}
		}
		return Long.valueOf(query.uniqueResult().toString());
	}
	/**
	 * 求和
	 * @param sql
	 * @param values
	 * @return
	 */
	public String sumBySql(String sql, Object... values) {
		Query query = super.getSession().createSQLQuery(sql);
		if(values != null){
			for(int i = 0; i < values.length; i++) {
				query.setParameter(i, values[i]);
			}
		}
		return CommonUtils.returnStr(query.uniqueResult());
	}
	
	/**
	 * 获得Dao对于的实体类
	 * 
	 * @return
	 */
	protected abstract Class<T> getEntityClass();
}
