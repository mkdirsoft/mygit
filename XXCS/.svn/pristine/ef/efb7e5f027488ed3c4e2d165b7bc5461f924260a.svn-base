//js  工具类(通用方法)

/*
返回字符串带省略号  有title
str 字符串   length截取长度
*/  
function returnStrByLength(str,length){
	if(null == str){
		return "";
	}
	var temp = str.length>length?str.substring(0,length)+'……':str;
	temp = "<font title='"+str+"'>"+temp+"</font>";
	return temp;
}

/*
返回字符串带省略号  无title
str 字符串   length截取长度
*/ 
function returnStrByLengthNoTitle(str,length){
	if(null == str){
		return "";
	}	
	var temp = str.length>=length?str.substring(0,length)+'……':str;
	return temp;	
}

/*
返回字符串 有title
str 字符串
*/  
function returnStrTitle(str){
	if(null == str){
		return "";
	}
	var temp = "<font title='"+str+"'>"+str+"</font>";
	return temp;
}


/*
根据参数 返回第一个参数之前的字符串
str 字符串   parameter参数
*/ 
function returnStrByParameter(str,parameter){
	if(null == str){
		return "";
	}	
	var temp = str;
	if(-1!= temp.indexOf(parameter)){
		temp = temp.substring(0,temp.indexOf(parameter));
	}
	return temp;
}

/*
(审批专用)根据参数 进行换行处理
str 字符串   parameter参数 replaceParameter替换参数 centerFlag是否居中
*/ 
function splitNewLineByStr(str,parameter,replaceParameter,centerFlag){
	if(null == str){
		return "";
	}
	var temps = str.split(parameter);
	var i = 0;
	var temp = "";
	for(i;i<temps.length;i++){
		temp += temps[i]+"<br>";
		if("" != replaceParameter){
			temp += replaceParameter+"<br>";				
			 
		}
	}
	if("" != replaceParameter){
		temp = temp.substring(0,temp.length-(replaceParameter.length+4));
	}
	if(centerFlag){
		temp = "<div style='text-align:center'>" + temp + "</div>";
	}
	return temp;
}



