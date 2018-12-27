package com.flx.flxoa.common.util;
import java.net.*;  
import java.io.*;  
import java.sql.*;  
import java.text.*;  
import java.lang.String;  

public class sql_inj{
	public   boolean  sql_inj(String  str) {
		 str = str.toLowerCase();//统一转为小写
		 String inj_str = "'|and|exec|execute|insert|select|delete|update|count|drop|*|%|chr|mid|master|truncate|" +
            "char|declare|sitename|net user|xp_cmdshell|;|or|-|+|,|like'|and|exec|execute|insert|create|drop|" +
            "table|from|grant|use|group_concat|column_name|" +
            "information_schema.columns|table_schema|union|where|select|delete|update|order|by|count|*|" +
            "chr|mid|master|truncate|char|declare|or|;|-|--|+|,|like|//|/|%|#";
			//过滤掉的sql关键字，可以手动添加
		String[] inj_stra=inj_str.split("\\|");
		for (int i=0 ; i < inj_stra.length ; i++ ){
			if (str.indexOf(inj_stra[i])>=0){
				return false;
			}
		}
		return true;
	}
}
