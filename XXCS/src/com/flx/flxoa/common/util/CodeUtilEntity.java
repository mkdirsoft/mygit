package com.flx.flxoa.common.util;

import java.io.File;

/**
 * 类名称：CodeUtilEntity.java
 * 类描述：
 * 创建时间：2018-3-10, 下午6:37:14
 * 
 * @version 1.0 
 * @since JDK版本 1.7
 * @author 刘凯 
 */
public class CodeUtilEntity {
    //domain目录 (实体类目录)
	private File domainDir;
    //service目录
	private File serviceDir;
	//dao目录
	private File daoDir;
	//实体类包名
	private String entityPackageName;
	//Dao类包名
	private String daoPackageName;
	//baseDao类路径（包含增删改查分页等等方法的实现）
	private String baseDaoPath;
	//系统版本
	private String version;
	//JDK版本
	private String since;
	//文件创建者
	private String author;
	public File getDomainDir() {
		return domainDir;
	}
	public void setDomainDir(File domainDir) {
		this.domainDir = domainDir;
	}
	public File getServiceDir() {
		return serviceDir;
	}
	public void setServiceDir(File serviceDir) {
		this.serviceDir = serviceDir;
	}
	public File getDaoDir() {
		return daoDir;
	}
	public void setDaoDir(File daoDir) {
		this.daoDir = daoDir;
	}
	public String getEntityPackageName() {
		return entityPackageName;
	}
	public void setEntityPackageName(String entityPackageName) {
		this.entityPackageName = entityPackageName;
	}
	public String getDaoPackageName() {
		return daoPackageName;
	}
	public void setDaoPackageName(String daoPackageName) {
		this.daoPackageName = daoPackageName;
	}
	public String getBaseDaoPath() {
		return baseDaoPath;
	}
	public void setBaseDaoPath(String baseDaoPath) {
		this.baseDaoPath = baseDaoPath;
	}
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	public String getSince() {
		return since;
	}
	public void setSince(String since) {
		this.since = since;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}

}
