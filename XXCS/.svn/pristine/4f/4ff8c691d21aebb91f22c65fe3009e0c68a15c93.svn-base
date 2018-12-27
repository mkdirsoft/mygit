/**
 * 修改入例框的编辑状态  开始
 * obj:需要改变编辑状态的入例框对象组
 * k:为true时入例框设为可编辑状态，为false时设为不可编辑 
 **/
function changeEdit(obj,k){
	for(var i=0;i<obj.length;i++){
		if(k){
			/* 入例框设为可编辑 */
			obj[i].key.removeAttr("disabled");
		}else{
			/* 设置入例框不可编辑 */
			obj[i].key.attr('disabled','disabled');
		}
	}
};
/* 修改入例框的编辑状态  结束 */
/*清空如例框中原有值  开始*/
function clearCaseBox(obj){
	for(var i=0;i<obj.length;i++){
		if(obj[i].key.get(0).nodeName=='INPUT'){
			obj[i].key.val('');
		}
		if(obj[i].key.get(0).nodeName=='SELECT'){
			obj[i].key.val(0);
		}
	}
	return obj;
};
/*清空如例框中原有值   结束*/
/*打开弹出层公共方法  开始*/
function openLayerByName(layername,layerid,layertitle,x,y){
	if(x==null||x==''||x=='undefined'){
		x=50;
	}
	if(y==null||y==''||y=='undefined'){
		y=55;
	}
	layername=layer.open({
		type: 1,
        area: [x+'%', y+'%'],
        shadeClose: true, //点击遮罩关闭
        scrollbar: false,
        maxmin: true,
        title: layertitle,
        content: $('#'+layerid)
	});
	return layername;
};
/*打开弹出层公共方法  开始*/

/**
 * 表格初始化公共函数  开始
 * tablename:要返回给调用者的datatable的名称
 * tableid:html页面中需要进行初始化的datatable的dom元素id
 * ajaxurl:需要获取数据的后台请求
 * ajaxpram:后台获取请求数据所需的查询参数
 * obj:用来初始化表格列的简单对象数组，顺序应与表格中显示的列的顺序一致
 * k:复选框列中隐藏域的命名关键字
 * cj:标记是否需要复选框 true:需要 false:不需要
 * ix:标记是否需要操作列 true:需要 false:不需要
 * */
function ownInitDatatable(tableid,ajaxurl,ajaxpram,obj,k,cj,ix){
	/*拼接数据列参数  开始*/
	var columnParam = [];
	//序号列
	var ggParm={
			"data": "",
			"render": function (data, type, row, meta) {
                return '<em>'+(parseInt(meta.row)+1)+'</em>';
            }
		};
	//客户列表复选框列
	var ccParm={
			"data": "id",
			"render": function (data, type, row, meta) {
                return '<input type="checkbox" name="'+k+'n" value="'+row.clientName+'" otdata="'+data+'" class="ptlayer-checkbox"/>';
            }
		};
	//联系人列表复选框列
	var conParm={
			"data": "id",
			"render": function (data, type, row, meta) {
                return '<input type="checkbox" name="'+k+'n" value="'+row.contact_name+'" otdata="'+data+','+row.contact_phone+','+row.contact_duty+','+row.contact_mail+'" class="ctlayer-checkbox"/>';
            }
		};
	//项目列表复选框列
	var projParm={
			"data": "id",
			"render": function (data, type, row, meta) {
				str='<span class="checkbox-sp"></span>';
				str02='<input type="checkbox" name="'+k+'n" value="'+row.projName+'" otdata="'+data+'"/>';
                return str02;
            }
		};
	//操作列
	var czParm={
			"data":"id",
			"render":function(data,type,row,meta){
				var str='<em class="em-id" style="display:none;">'+data+'</em>'+
                '<a href="javascript:void(0);" class="xmgl-check-btn" onclick="check'+k+'('+data+')"><i class="fa fa-eye" title="查看"></i></a>'+
                '<a href="javascript:void(0);" class="xmgl-check-btn" onclick="update'+k+'('+data+')"><i class="fa fa-pencil" title="修改"></i></a>'+
                '<a href="javascript:void(0);" class="xmgl-check-btn" onclick="delete'+k+'('+data+')"><i class="fa fa-trash" title="删除"></i></a>';
				return str;
			}
		};
	if(cj){
		if(k=='client'){
			columnParam.push(ccParm);
		}
		if(k=='contact'){
			columnParam.push(conParm);
		}
		if(k=='project'){
			columnParam.push(projParm);
		}
		columnParam.push(ggParm);
	}else{
		columnParam.push(ggParm);
	};
	//数据列样式可在此处for循环中进行处理
	for(var i=0;i<obj.length;i++){
		var columnObj={
			"data": obj[i].key,
			"render":function(data,type,row,meta){
				var str='<em>'+returnStrByLength(data,8)+'</em>'
				return str;
			}
		};
		columnParam.push(columnObj);
	};
	if(ix){
		columnParam.push(czParm);
	}
	/*拼接数据列参数  结束*/
	/*初始化表格  开始*/
	var tablename=$("#"+tableid).dataTable({
		language:{
			"url": "/view/flxoa/page/nk/public/resource/zh_CN.json"
		}, 
		//提示信息
		retrieve: true,
		//意思是如果已经初始化了，则继续使用之前的Datatables实例,相反如果你不想这样你需要使用 destroyOption 方法来销毁对象
		bSort: true,
		autoWidth: true,
		//操作后-停留当前页
		bStateSave:true,
		//禁用自动调整列宽
		stripeClasses: ["odd", "even"],
		//为奇偶行加上样式，兼容不支持CSS伪类的场合
		processing: true,
		//隐藏加载提示,自行处理
		serverSide: true,
		//启用服务器端分页
		searching: false,
		//是否禁用原生搜索(false为禁用,true为使用)
		orderMulti: false,
		//启用多列排序
		order: [],
		//取消默认排序查询,否则复选框一列会出现小箭头
		renderer: "bootstrap",
		//渲染样式：Bootstrap和jquery-ui
		pagingType: "full_numbers",
		//分页样式：simple,simple_numbers,full,full_numbers
		bScrollInfinite: true,
		aoColumnDefs: [ { "bSortable": false}],
		ajax: function(data, callback, settings) {
			//为请求参数添加表格共通参数
			ajaxpram.draw=data.draw;//统计表格绘制次数
			ajaxpram.length = data.length; //页面显示记录条数，在页面显示每页显示多少项的时候
			ajaxpram.start = data.start; //开始的记录序号
			ajaxpram.page = (data.start / data.length) + 1; //当前页码
			ajaxpram.search = data.search.value; //搜索条件
			if (data.order.length > 0) {
				param.order = data.columns[data.order[0].column].data;
				param.dir = data.order[0].dir;
			}
			//ajax请求数据
			$.ajax({
				type: "POST",
				url: ajaxurl,
				cache: false,
				//禁用缓存
				data: ajaxpram,
				//传入组装的参数
				dataType: "json",
				success: function(result) {
					//封装返回数据
					var returnData = {};
					returnData.draw = data.draw; //这里直接自行返回了draw计数器,应该由后台返回
					returnData.recordsTotal = result[0].totalCount; //返回数据全部记录
					returnData.recordsFiltered = result[0].totalCount; //后台不实现过滤功能，每次查询均视作全部结果
					returnData.data = result[0].data; //返回的数据列表
					//调用DataTables提供的callback方法，代表数据已封装完成并传回DataTables进行渲染
					//此时的数据需确保正确无误，异常判断应在执行此回调前自行处理完毕
					callback(returnData);
				}
			});
		},
		//列表表头字段
		columns:columnParam
	}).api();
	/*初始化表格  结束*/
	/*将成功初始化的表格返回*/
	return tablename;
}
/*表格初始化公共函数  结束*/
/*日期范围选择器  开始*/
function dateRangePicker(){
    $('#daterange-btn').daterangepicker({
    	ranges: {
    		//'全部': [moment(), moment().subtract(-1, 'days')],
    		'今天': [moment(), moment()],
    		'昨天': [moment().subtract(1, 'days'), moment().subtract(1, 'days')],
    		'过去7天': [moment().subtract(6, 'days'),moment()],
    		'过去30天': [moment().subtract(29, 'days'),moment()],
    		'过去60天': [moment().subtract(59, 'days'),moment()]
        },
        startDate: moment(),
        endDate: moment(),
        autoUpdateInput: false
    },function(start, end,label) {
    //label:通过它来知道用户选择的是什么，传给后台进行相应的展示
    	if(label=='全部'){
    		$('#daterange-btn span').html('全部');
        }else if(label=='今天'){
        	$('#daterange-btn span').html(end.format('YYYY/MM/DD'));
        }else if(label=='昨天'){
        	$('#daterange-btn span').html(start.format('YYYY/MM/DD'));
        }else if(label=='过去7天'){
        	$('#daterange-btn span').html(start.format('YYYY/MM/DD')+'-'+end.format('YYYY/MM/DD'));
        }else if(label=='过去30天'){
        	$('#daterange-btn span').html(start.format('YYYY/MM/DD')+'-'+end.format('YYYY/MM/DD'));
        }else if(label=='过去60天'){
        	$('#daterange-btn span').html(start.format('YYYY/MM/DD')+'-'+end.format('YYYY/MM/DD'));
        }
    });    
};             
/*日期范围选择器  结束*/
/*计算天数差的函数，通用  开始*/  
function  DateDiff(sDate1,  sDate2){    //sDate1和sDate2是2002-12-18格式  
   var  aDate,  oDate1,  oDate2,  iDays ; 
   aDate  =  sDate1.split("-");  
   oDate1  =  new  Date(aDate[1]  +  '-'  +  aDate[2]  +  '-'  +  aDate[0]);    //转换为12-18-2002格式  
   aDate  =  sDate2.split("-");
   oDate2  =  new  Date(aDate[1]  +  '-'  +  aDate[2]  +  '-'  +  aDate[0]);  
   iDays  =  parseInt(Math.abs(oDate1  -  oDate2)  /  1000  /  60  /  60  /24);    //把相差的毫秒数转换为天数  
   return  iDays;  
};
/*计算天数差的函数，通用  结束*/
/*获取当前系统日期yyyy-mm-dd，通用     开始*/  
function getNowFormatDate() {
    var date = new Date();
    var seperator1 = "-";
    var year = date.getFullYear();
    var month = date.getMonth() + 1;
    var strDate = date.getDate();
    if (month >= 1 && month <= 9) {
        month = "0" + month;
    }
    if (strDate >= 0 && strDate <= 9) {
        strDate = "0" + strDate;
    }
    var currentdate = year + seperator1 + month + seperator1 + strDate;
    return currentdate;
};
/*获取当前系统日期yyyy-mm-dd，通用     结束*/
/*处理签到日期，将时间戳转化为日期  开始*/
function formatDate(dates){
    var date = new Date();  
    date.setTime(dates * 1000);  
    var y = date.getFullYear();      
    var m = date.getMonth() + 1;      
    m = m < 10 ? ('0' + m) : m;      
    var d = date.getDate();      
    d = d < 10 ? ('0' + d) : d; 
    return y + '-' + m + '-' + d;
};
/*处理签到日期，将时间戳转化为日期  结束*/
/**
 * 描述：以日期范围作为查询条件时，处理入例框数据，分为开始日期和结束日期传给后台
 * obj:需要返回的包含开始结束日期数据的对象
 * f:日历插件标识
 */
function getDateRange(f){
	var obj={};
	var commDate = $('.search-wrap-fst '+f+' button span').html();      
    if(commDate.indexOf("按日期查询") >= 0){
    	commDate = "";
    }else{
        var reg=/\//g;                    
        commDate = commDate.replace(reg,'-'); 
    };                    
    commStartDate = commDate.substring(0,10);
    commEndDate = commDate.substring(11,21);
    obj.startDate=commStartDate;
    obj.endDate=commEndDate;	
    return obj;
}
/*数据验证  开始*/
//验证中文名称
function isChinaName(name) {
 var pattern = /^[\u4E00-\u9FA5]{1,6}$/;
 return pattern.test(name);
}
 
// 验证手机号
function isPhoneNo(phone) { 
 var pattern = /^1[34578]\d{9}$/; 
 return pattern.test(phone); 
}
 
// 验证身份证 
function isCardNo(card) { 
 var pattern = /(^\d{15}$)|(^\d{18}$)|(^\d{17}(\d|X|x)$)/; 
 return pattern.test(card); 
} 

// 验证邮箱
function isMail(mail){
	var pattern= /^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+((\.[a-zA-Z0-9_-]{2,3}){1,2})$/;
	return pattern.test(mail);
}

// 验证邮编
function isPostCode(postcode){
	var pattern=/^[1-9][0-9]{5}$/;
	return pattern.test(postcode);
}

//验证座机号
function isLandLine(pn){
	///^((0\d{2,3})-?)(\d{7,8})(-(\d{3,}))?$/; 
	var pattern=/^(?:(?:0\d{2,3})-)?(?:\d{7,8})(-(?:\d{3,}))?$/;
	return pattern.test(pn);
}

// 验证网址url
function isURL(url){
	var pattern=/http(s)?:\/\/([\w-]+\.)+[\w-]+(\/[\w- .\/?%&=]*)?/;
	return pattern.test(url);
}

/* 表单非空验证   开始*/
function formCheck(obj){
   var k=typeof(obj);
   console.log('验证数据！！！：==='+obj);
   console.log('数据类型：===='+k);
   var ckFlag=false;
   if(k='object'&&obj.constructor==Array){
	   for(var i=0;i<obj.length;i++){
		   if(obj[i].key===""||obj[i].key==null||obj[i].key=='undefined'){
			   layer.msg("请输入"+obj[i].value+"！");
			   ckFlag=false;
			   break;
			}else {
				if(obj[i].value=="预计合同额"){
					if(!isNaN(obj[i].key)&&obj[i].key.indexOf("-")==-1){
						ckFlag=true;
					}else{
						layer.msg("预计合同额只能是非负数字！");
					}
				}else{
					ckFlag=true;
				}
			}
	   } 
   }else{
	   if(k=='string'){
		   if(obj==null||obj==''||obj=='undefined'){
			   layer.msg('请输入相应信息！');
		   }else{
			   ckFlag=true;
		   }
	   }
   }
   return ckFlag;
};
/* 表单非空验证   结束*/

/*数据验证  开始*/

