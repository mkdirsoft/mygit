package com.flx.flxoa.common.util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * @author 刘凯
 * @date 2018-3-9 上午9:22:37
 * 描述：自动生成service和dao类代码的工具类
 */
public class AutoGenerateCodeUtil {  
    
    /** 
     * 执行方法 
     * @param domainDir domain目录 (实体类目录)
     * @param serviceDir service目录 
     * @param daoDir dao目录 
     * @param entityPackageName 实体类包名
     * @param entityPackageName Dao类包名
     * @param baseDaoPath baseDao类路径（包含增删改查分页等等方法的实现）
     * @throws IOException 
     */  
    public static void execute(CodeUtilEntity codeUtilEntity) throws IOException{  
          
    	File domainDir = codeUtilEntity.getDomainDir();
    	File serviceDir = codeUtilEntity.getServiceDir();
    	File daoDir = codeUtilEntity.getDaoDir();
    	String entityPackageName = codeUtilEntity.getEntityPackageName();
    	String daoPackageName = codeUtilEntity.getDaoPackageName();
    	String baseDaoPath = codeUtilEntity.getBaseDaoPath();
    	String version = codeUtilEntity.getVersion();
    	String since = codeUtilEntity.getSince();
    	String author = codeUtilEntity.getAuthor();
    	// 检查目录是否为空  
        if( domainDir == null || serviceDir == null || daoDir == null )   
            throw new RuntimeException(" no such file ");  
          
        // 检查domain目录下是否有文件  
        File[] domain_Files = domainDir.listFiles();  
        if( domain_Files.length == 0 )  
            throw new RuntimeException(" no file in the domain dir ");  
          
          
        for( File domain_File :domain_Files ){  
              
            // 创建service接口和实现类  
            create_interface_and_class_File(domain_File,serviceDir,"service",entityPackageName,daoPackageName,baseDaoPath,version,since,author);  
              
            // 创建dao接口和实现类  
            create_interface_and_class_File(domain_File,daoDir,"dao",entityPackageName,daoPackageName,baseDaoPath,version,since,author);  
        }  
          
    }  
  
      
    /** 
     * 在指定的目录下创建domain相应的接口和实现类 
     * @param domain_class_File  
     * @param targetDir 
     * @param type 分为service和dao两种 
     * @throws IOException 
     */  
    private static void create_interface_and_class_File(File domain_class_File,  
            File targetDir,String type,String entityPackageName,String daoPackageName,String baseDaoPath,String version,String since,String author) throws IOException {  
          
        String interface_file_suffix_Name = null;  
        String interface_impl_file_suffix_Name = null;  
          
        if( "service".equals(type)){  
            interface_file_suffix_Name = "Service.java";  
            interface_impl_file_suffix_Name = "ServiceImpl.java";  
        } else if("dao".equals(type)){  
            interface_file_suffix_Name = "Dao.java";  
            interface_impl_file_suffix_Name = "DaoImpl.java";  
        }  
          
          
        // 检查impl目录是否在，若不存在则创建该目录  
        File implDir = null;  
        for( File temp : targetDir.listFiles()){  
            if( temp != null && "impl".equals(temp.getName())){  
                implDir = temp;  
                break;  
            }  
        }  
          
        if( implDir == null ){  
            implDir = new File(targetDir,"impl");  
            implDir.mkdir();  
        }  
        
        if(domain_class_File.getName().indexOf(".") != -1)
        {
        	//interface文件 或者 class文件 
        	String interfaceOrClass = "";
        	//实体类名称
        	String entityName = domain_class_File.getName()  
                    .substring(0, domain_class_File.getName().indexOf(".")) ;
        	if(!"".equals(entityName))
        	{
                // 创建接口文件  
                String domain_interface_file_Name = entityName + interface_file_suffix_Name;
                File domain_interface_File = new File(targetDir,domain_interface_file_Name);
                //文件不存在 才创建接口文件
                if (!domain_interface_File.exists()) {
                    domain_interface_File.createNewFile();  
                    
                    // 输入接口文件内容  
                    BufferedWriter interfaceWriter  = new BufferedWriter(  
                            new FileWriter(domain_interface_File));  
                      
                    String interfacePackageInfo = StringUtil.getPackageInfo(domain_interface_File);
                    interfaceOrClass = "interface";
                    String interfaceImportInfo = StringUtil.getImportInfo(domain_interface_File,entityPackageName,entityName,type,interfaceOrClass,daoPackageName,baseDaoPath);  
                    String interfaceInfo = StringUtil.getInterfaceInfo(domain_interface_File,entityName,version,since,author);  
                      
                    interfaceWriter.write(interfacePackageInfo);  
                    interfaceWriter.write(interfaceImportInfo);  
                    interfaceWriter.write(interfaceInfo);  
                      
                    interfaceWriter.flush();  
                    interfaceWriter.close();            	
                }
                  
                // 创建实现类文件  
                String domain_interface_impl_file_Name = entityName + interface_impl_file_suffix_Name;  
                  
                File domain_interface_impl_file = new File(implDir,domain_interface_impl_file_Name);
                //文件不存在 才创建类文件
                if (!domain_interface_impl_file.exists()) {            
    	            domain_interface_impl_file.createNewFile();  
    	              
    	            // 输入实现类文件内容  
    	            BufferedWriter implWriter  = new BufferedWriter(  
    	                    new FileWriter(domain_interface_impl_file));  
    	              
    	            String classPackageInfo =  StringUtil.getPackageInfo(domain_interface_impl_file);
    	            interfaceOrClass = "class";
    	            String importInfo = StringUtil.getImportInfo(domain_interface_File,entityPackageName,entityName,type,interfaceOrClass,daoPackageName,baseDaoPath);  
    	            String classInfo = StringUtil.getClassInfo(domain_interface_impl_file,domain_interface_File,entityName,type,baseDaoPath,version,since,author);  
    	              
    	            implWriter.write(classPackageInfo);  
    	            implWriter.write(importInfo);  
    	            implWriter.write(classInfo);  
    	            implWriter.flush();  
    	            implWriter.close();
                }       		
        	}

        }

    }  
      
}  
  
  
class StringUtil {  
      
    /** 定义一个类Java文件的包信息 **/  
    public static String getPackageInfo( File javaFile){  
        StringBuilder sb = new StringBuilder();  
        sb.append("package ");  
          
        String parentFilePath = javaFile.getParentFile().getPath();  
        String packageStr = parentFilePath.substring(parentFilePath.indexOf("src\\")+4,  
                parentFilePath.length());  
        sb.append(packageStr.replace('\\', '.'));  
          
        sb.append(";");  
        sb.append("\n\n\n");  
          
        return sb.toString();  
    }  
      
      
    /** 定义一个接口文件的接口信息 **/  
    public static String getInterfaceInfo( File domain_interface_File,String entityName ,String version,String since,String author){
    	//首字母小写
    	String lowerEntityName = toLowerCaseFirstOne(entityName);
        StringBuilder sb = new StringBuilder(); 
        String interface_Name = domain_interface_File.getName()  
              .substring(0,domain_interface_File.getName().indexOf("."));
        sb.append("/**\n");
        sb.append(" *\n");
        sb.append(" * 类名称："+interface_Name+".java\n");
        sb.append(" * 类描述：\n");
        sb.append(" * 创建时间："+new SimpleDateFormat("yyyy-MM-dd, ahh:mm:ss").format(new Date())+"\n");
        sb.append(" *\n");
        sb.append(" *@version "+version+" \n");
        sb.append(" *@since JDK版本"+since+" \n");
        sb.append(" *@author "+author+" \n");
        sb.append(" */ \n");
        sb.append("public interface ");  
        sb.append(interface_Name);
        sb.append(" {");
        sb.append("\n");
        sb.append("	/**\n");
        sb.append("	 *添加"+entityName+"\n");
        sb.append("	 */ \n");
        sb.append("	public boolean add("+entityName+" "+lowerEntityName+");\n");
        sb.append("	/**\n");
        sb.append("	 *删除"+entityName+"\n");
        sb.append("	 */ \n");        
        sb.append("	public boolean delete("+entityName+" "+lowerEntityName+");\n");
        sb.append("	/**\n");
        sb.append("	 *修改"+entityName+"\n");
        sb.append("	 */ \n");        
        sb.append("	public boolean update("+entityName+" "+lowerEntityName+");\n");
        sb.append("	/**\n");
        sb.append("	 *查询"+entityName+"列表\n");
        sb.append("	 */ \n");        
        sb.append("	public List<"+entityName+"> query("+entityName+" "+lowerEntityName+");\n");
        sb.append("	/**\n");
        sb.append("	 *查询"+entityName+" ByID\n");
        sb.append("	 */ \n");        
        sb.append("	public "+entityName+" queryById("+entityName+" "+lowerEntityName+");\n");        
        sb.append("	/**\n");
        sb.append("	 *分页"+entityName+" pageNo 查询第几页数据  pageSize 每一页显示的数量 \n");
        sb.append("	 */ \n");        
        sb.append("	public List<"+entityName+"> queryForPage(int pageNo,int pageSize,"+entityName+" "+lowerEntityName+");\n");       
        sb.append("	/**\n");
        sb.append("	 *查询"+entityName+"数据条数\n");
        sb.append("	 */ \n");        
        sb.append("	public Long queryCount("+entityName+" "+lowerEntityName+");\n");
        sb.append("\n");
        sb.append(" }");
        return sb.toString();  
    }  
      
    /** 定义一个类文件的类信息 **/  
    public static String getClassInfo( File domain_interface_impl_File,File domain_interface_File,String entityName,String type,String baseDaoPath,String version,String since,String author){
    	//首字母小写
    	String lowerEntityName = toLowerCaseFirstOne(entityName);
    	String dao = entityName+"Dao";
    	String baseDaoName = baseDaoPath.substring(baseDaoPath.lastIndexOf(".")+1);
    	String class_Name = domain_interface_impl_File.getName()  
              .substring(0,domain_interface_impl_File.getName().indexOf("."));      	
        StringBuilder sb = new StringBuilder("");
        sb.append("/**\n");
        sb.append(" *\n");
        sb.append(" * 类名称："+class_Name+".java\n");
        sb.append(" * 类描述：\n");
        sb.append(" * 创建时间："+new SimpleDateFormat("yyyy-MM-dd, ahh:mm:ss").format(new Date())+"\n");
        sb.append(" *\n");
        sb.append(" * @version "+version+" \n");
        sb.append(" * @since JDK版本"+since+" \n");
        sb.append(" * @author "+author+" \n");
        sb.append(" */ \n");        
        if( "service".equals(type)){
        	sb.append("@Service\n");
        	sb.append("@Transactional\n");
        } else if("dao".equals(type)){
        	sb.append("@Repository\n");
        }         
        sb.append("public class ");  
        sb.append(class_Name);  
        if("dao".equals(type)){
        	sb.append(" extends "+baseDaoName+"<"+entityName+", Integer>");
        }  
          
        sb.append(" implements ");  
          
        String interface_Name = domain_interface_File.getName()  
                .substring(0,domain_interface_File.getName().indexOf("."));  
        sb.append(interface_Name);  
          
        sb.append(" {\n");
        if( "service".equals(type)){
        	sb.append("	private "+dao+" dao;\n");
        	sb.append("	@Autowired\n");
        	sb.append("	public void setDao("+dao+" dao) {\n");
        	sb.append("		this.dao = dao;\n");
        	sb.append("	}\n");
        	sb.append("	public "+dao+" getDao() {\n");
        	sb.append("		return dao;\n");
        	sb.append("	}\n");
            sb.append("	/**\n");
            sb.append("	 *添加"+entityName+"\n");
            sb.append("	 */ \n");        	
        	sb.append("	public boolean add("+entityName+" "+lowerEntityName+") {\n");
        	sb.append("		boolean result = dao.add("+lowerEntityName+");\n");
        	sb.append("		return result;\n");
        	sb.append("	}\n");
            sb.append("	/**\n");
            sb.append("	 *删除"+entityName+"\n");
            sb.append("	 */ \n");          	
        	sb.append("	public boolean delete("+entityName+" "+lowerEntityName+") {\n");
        	sb.append("		boolean result = dao.delete("+lowerEntityName+");\n");
        	sb.append("		return result;\n");
        	sb.append("	}\n");
            sb.append("	/**\n");
            sb.append("	 *修改"+entityName+"\n");
            sb.append("	 */ \n");         	
        	sb.append("	public boolean update("+entityName+" "+lowerEntityName+") {\n");
        	sb.append("		boolean result = dao.update("+lowerEntityName+");\n");
        	sb.append("		return result;\n");
        	sb.append("	}\n");
            sb.append("	/**\n");
            sb.append("	 *查询"+entityName+"列表\n");
            sb.append("	 */ \n");         	
        	sb.append("	public List<"+entityName+"> query("+entityName+" "+lowerEntityName+") {\n");
        	sb.append("		List<"+entityName+"> list = dao.query("+lowerEntityName+");\n");
        	sb.append("		return list;\n");
        	sb.append("	}\n");          	
            sb.append("	/**\n");
            sb.append("	 *查询"+entityName+" ByID\n");
            sb.append("	 */ \n");         	
        	sb.append("	public "+entityName+" queryById("+entityName+" "+lowerEntityName+") {\n");
        	sb.append("		"+entityName+" result = dao.queryById("+lowerEntityName+");\n");
        	sb.append("		return result;\n");
        	sb.append("	}\n");
            sb.append("	/**\n");
            sb.append("	 *分页"+entityName+" pageNo 查询第几页数据  pageSize 每一页显示的数量 \n");
            sb.append("	 */ \n");         	
        	sb.append("	public List<"+entityName+"> queryForPage(int pageNo,int pageSize,"+entityName+" "+lowerEntityName+") {\n");
        	sb.append("		List<"+entityName+"> list = dao.queryForPage(pageNo,pageSize,"+lowerEntityName+");\n");
        	sb.append("		return list;\n");
        	sb.append("	}\n"); 
            sb.append("	/**\n");
            sb.append("	 *查询"+entityName+"数据条数\n");
            sb.append("	 */ \n");         	
        	sb.append("	public Long queryCount("+entityName+" "+lowerEntityName+") {\n");
        	sb.append("		Long result = dao.queryCount("+lowerEntityName+");\n");
        	sb.append("		return result;\n");
        	sb.append("	}\n");         	
        } else if("dao".equals(type)){
            sb.append("	/**\n");
            sb.append("	 *添加"+entityName+"\n");
            sb.append("	 */ \n");           	
        	sb.append("	public boolean add("+entityName+" "+lowerEntityName+") {\n");
        	sb.append("		return save("+lowerEntityName+");\n");
        	sb.append("	}\n");
            sb.append("	/**\n");
            sb.append("	 *删除"+entityName+"\n");
            sb.append("	 */ \n");         	
        	sb.append("	public boolean delete("+entityName+" "+lowerEntityName+") {\n");
        	sb.append("		"+lowerEntityName+".setDeleteFlag(\"1\");\n");
        	sb.append("		return save("+lowerEntityName+");\n");
        	sb.append("	}\n");
            sb.append("	/**\n");
            sb.append("	 *修改"+entityName+"\n");
            sb.append("	 */ \n");         	
        	sb.append("	public boolean update("+entityName+" "+lowerEntityName+") {\n");
        	sb.append("		return modify("+lowerEntityName+");\n");
        	sb.append("	}\n");
            sb.append("	/**\n");
            sb.append("	 *查询"+entityName+"列表\n");
            sb.append("	 */ \n");         	
        	sb.append("	public List<"+entityName+"> query("+entityName+" "+lowerEntityName+") {\n");
        	sb.append("		String hql = \" from "+entityName+" where delete_flag = '0' \";\n");
        	sb.append("		return getListByHQL(hql, null);\n");
        	sb.append("	}\n");
            sb.append("	/**\n");
            sb.append("	 *查询"+entityName+" ByID\n");
            sb.append("	 */ \n");         	
        	sb.append("	public "+entityName+" queryById("+entityName+" "+lowerEntityName+") {\n");
        	sb.append("		return get("+lowerEntityName+".getId());\n");
        	sb.append("	}\n");
            sb.append("	/**\n");
            sb.append("	 *分页"+entityName+" pageNo 查询第几页数据  pageSize 每一页显示的数量 \n");
            sb.append("	 */ \n");         	
        	sb.append("	public List<"+entityName+"> queryForPage(int pageNo,int pageSize,"+entityName+" "+lowerEntityName+") {\n");
        	sb.append("		String hql = \" from "+entityName+" where delete_flag = '0' \";\n");
        	sb.append("		return queryForPageByHQL(pageNo, pageSize, hql);\n");
        	sb.append("	}\n");
            sb.append("	/**\n");
            sb.append("	 *查询"+entityName+"数据条数 \n");
            sb.append("	 */ \n");         	
        	sb.append("	public Long queryCount("+entityName+" "+lowerEntityName+") {\n");
        	sb.append("		String hql = \"select count(*) from "+entityName+" where delete_flag = '0' \";\n");
        	sb.append("		return countByHql(hql,null);\n");
        	sb.append("	}\n");        	
        	sb.append("	\n");
        	sb.append("	@Override\n");
        	sb.append("	protected Class<"+entityName+"> getEntityClass() {\n");
        	sb.append("		return "+entityName+".class;\n");
        	sb.append("	} \n");
        }          
        sb.append("\n}");  
          
        return sb.toString();  
    }  
      
      
    /** 定义一个类文件文件的import信息 **/  
    public static String getImportInfo(File domain_interface_File,String entityPackageName,String entityName,String type,String interfaceOrClass,String daoPackageName,String baseDaoName){
    	StringBuilder sb = new StringBuilder("");
		sb.append("import java.util.List;");
		sb.append("\n");
		sb.append("import "+entityPackageName+"."+entityName+";\n");
    	if( "interface".equals(interfaceOrClass)){

    	}else if("class".equals(interfaceOrClass)){
            sb.append("import ");  
            String importStr = getPackageInfo(domain_interface_File).substring( getPackageInfo(domain_interface_File).indexOf("package")+8,getPackageInfo(domain_interface_File).indexOf(";"))  
                    +"."  
                    +domain_interface_File.getName().substring(0,domain_interface_File.getName().indexOf("."));  
            sb.append(importStr);  
            sb.append(";");
            sb.append("\n");
            if( "service".equals(type)){
            	sb.append("import "+daoPackageName+"."+entityName+"Dao;\n");
            	sb.append("import org.springframework.beans.factory.annotation.Autowired;\n");
            	sb.append("import org.springframework.stereotype.Service;\n");
            	sb.append("import org.springframework.transaction.annotation.Transactional;\n");
            } else if("dao".equals(type)){
            	sb.append("import org.springframework.stereotype.Repository;\n");
            	sb.append("import "+baseDaoName+";\n");
            }             
        }          	
        sb.append("\n");  
      
        return sb.toString();  
          
    }  
    
    //首字母转小写
    public static String toLowerCaseFirstOne(String s){
      if(Character.isLowerCase(s.charAt(0)))    
    	return s;  
      else  
    	return (new StringBuilder()).append(Character.toLowerCase(s.charAt(0))).append(s.substring(1)).toString();
    }
  
}  
