package com.flx.flxoa;

import java.io.File;
import java.io.IOException;

import com.flx.flxoa.common.util.AutoGenerateCodeUtil;
import com.flx.flxoa.common.util.CodeUtilEntity;

/**
 * @author 刘凯
 * @date 2018-3-9 上午9:26:37
 * 描述：
 */
public class TestMain {

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		CodeUtilEntity codeUtilEntity = new CodeUtilEntity();
		
		//domain目录 (实体类目录)
		File domainDir = new File("//Users//leijun//eclipseworkspace//XXCS//src//com//flx//flxoa//info//market//entity");
		codeUtilEntity.setDomainDir(domainDir);
		//service目录
		File serviceDir = new File("//Users//leijun//eclipseworkspace//XXCS//src//com//flx//flxoa//info//market//manager");
		codeUtilEntity.setServiceDir(serviceDir);
		//dao目录
		File daoDir = new File("//Users//leijun//eclipseworkspace//XXCS//src//com//flx//flxoa//info//market//dao");
		codeUtilEntity.setDaoDir(daoDir);
		//实体类包名
		codeUtilEntity.setEntityPackageName("com.flx.flxoa.info.market.entity");
		//Dao类包名
		codeUtilEntity.setDaoPackageName("com.flx.flxoa.info.market.dao");
		//baseDao类路径（包含增删改查分页等等方法的实现）
		codeUtilEntity.setBaseDaoPath("com.flx.flxoa.common.hibernate3.HibernateBaseDao");
		//系统版本
		codeUtilEntity.setVersion("1.0");
		//JDK版本
		codeUtilEntity.setSince("1.7");
		//文件创建者
		codeUtilEntity.setAuthor("leijun");
		AutoGenerateCodeUtil u = new AutoGenerateCodeUtil();
		u.execute(codeUtilEntity);
	}

}
