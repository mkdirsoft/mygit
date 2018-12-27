// var host = "http://192.168.112.133:8099";

//左侧导航菜单
var ico_Arr = ['ti-home', 'ti-layout', 'ti-view-grid', 'ti-receipt', 'ti-view-list-alt', 'ti-notepad', 'ti-direction-alt', 'ti-settings'];

function showAll(data, parent) {
	var activeId = "";
    if (data.subMenu.length == 0) {
		var classAttr = "pcoded-hasmenu";
		if("1" == data.isActive){
			classAttr = "active";
			activeId = 'menu_' + data.id;
		}		
        var subli = '<li id =menu_' + data.id + '  data-cid=' + data.id + ' data-weburl="' + data.url + '" class="" dropdown-icon="style3" subitem-icon="style7"><a id="a_' + data.id + '" href="#" onclick="gotoPage(this,menu_' + data.id + ');" url="' + data.url + '"  href="#"><span class="pcoded-mtext">' + data.name + '</span></a></li>';
        $(parent).append(subli);
	
    } else {
        $.each(data.subMenu, function(index, fatherLi) { //遍历数据集
			var classAttr = "pcoded-hasmenu";
			if("1" == fatherLi.isActive){
				activeId = 'menu_' + fatherLi.id;
				classAttr = "active";
			}
			var li1 = $('<li id =menu_' + fatherLi.id + '  data-cid=' + fatherLi.id + ' data-weburl="' + fatherLi.url + '" class="'+classAttr+'" dropdown-icon="style3" subitem-icon="style7"><a id="a_' + fatherLi.id + '" href="#" onclick="gotoPage(this,menu_' + fatherLi.id + ');" url="' + fatherLi.url + '" ><span class="pcoded-micon"><i class="' + ico_Arr[index] + '"></i><b>N</b></span><span class="pcoded-mtext">' + fatherLi.name + '</span><span class="pcoded-mcaret"></span></a></li>'); //没有children的初始li结构
			var li2 = $('<li id =menu_' + fatherLi.id + '  data-cid=' + fatherLi.id + ' data-weburl="' + fatherLi.url + '" class="'+classAttr+'" dropdown-icon="style3" subitem-icon="style7"><a href="#" onclick="showChild(this,event,menu_' + fatherLi.id + ');"><span class="pcoded-micon"><i class="' + ico_Arr[index] + '"></i><b>N</b></span><span class="pcoded-mtext">' + fatherLi.name + '</span><span class="pcoded-mcaret"></span></a><ul class="pcoded-submenu u_' + fatherLi.id + '"></ul></li>'); //有children的初始li结构
			
            if (fatherLi.subMenu.length > 0) { //如果有子节点，则遍历该子节点   
                $(li2).appendTo(parent); //将li的初始化选择好，并马上添加带类名的ul子节点，并且将这个li添加到父亲节点中
                for (var i = 0; i < fatherLi.subMenu.length; i++) {
                    showAll(fatherLi.subMenu[i], $(li2).children().eq(1)); //将空白的ul作为下一个递归遍历的父亲节点传入，递归调用showAll函数     
                }
            } else {
                $(li1).appendTo(parent); //如果该节点没有子节点，则直接将该节点li以及文本创建好直接添加到父亲节点中
            }
			
			// $("li[data-cid='"+fatherLi.id+"']").click(function() {
				// if (!$("li[data-cid='"+fatherLi.id+"']").hasClass("pcoded-trigger")) {
					// $("li[data-cid='"+fatherLi.id+"']").removeClass().addClass("pcoded-hasmenu active pcoded-trigger"); 
				// } else {
					// $("li[data-cid='"+fatherLi.id+"']").removeClass("pcoded-trigger");
				// }
			// })			
        });	
    }
	if("" != activeId){
		//展开当前父级菜单
		$("#"+activeId).parent().parent().removeClass().addClass("pcoded-hasmenu active pcoded-trigger");
		//展开父级以上的菜单
		openParent($("#"+activeId).parent().parent());
	}
}

//展开父级菜单   暂时注释掉  没发现此方法对功能的影响 待日后发现问题再来解决
function openParent(li){
//	if (!li.hasClass("pcoded-hasmenu")) {
//		alert(1);
//		li.removeClass().addClass("pcoded-hasmenu active pcoded-trigger");
//		alert(2);
//		openParent(li.parent().parent());
//		alert(3);
//	}
}


function showChild (obj,evt,li) {
	if (!$("#"+li.id).hasClass("pcoded-trigger")) {
		$("#"+li.id).removeClass().addClass("pcoded-hasmenu active pcoded-trigger");
	} else {
		$("#"+li.id).removeClass("pcoded-trigger");
	}
	
	var e=(evt)?evt:window.event;
	if (window.event) {
		e.cancelBubble=true;// ie下阻止冒泡
	} else {
		e.stopPropagation();// 其它浏览器下阻止冒泡
	}
}

//获取上一次点击的功能id,传入后台
var a_id = getCookie("menu_id"); 
$.ajax({
    type: "get",
    url: "/flxoa/function/getindexlist",
    data: {
		"id":a_id
	},
    dataType: "json",
    async: true,
    //默认是true  ajax请求是异步的
    success: function(data) {
        showAll(data, '#navi');

        // if ( !! localStorage.getItem("cur_index")) {
            // var curIndex = localStorage.getItem("cur_index");
            // $('#navi li.pcoded-hasmenu[data-cid=' + curIndex + ']').addClass("active");
        // }
        // $("#navi li.pcoded-hasmenu").click(function() {
            // $(this).addClass("active").siblings().removeClass("active");
			// localStorage.removeItem("cur_index");
            // localStorage.setItem("cur_index", $(this).attr("data-cid"));
        // });
        $("#menu_"+a_id).addClass("active");
    },
    error: function() {
        alert("网络繁忙，请稍后再试");
    }
});

//跳转页面前 先保存这次点击的功能id
function gotoPage(obj,li)
{
	sessionStorage.removeItem("approveStatus");
    sessionStorage.removeItem("stateId");
    sessionStorage.removeItem("myProjMore");
    sessionStorage.removeItem("flag");            
    sessionStorage.removeItem("more");  

	// var liId = li.id;
	var liId = $(li).attr("id");
	liId = liId.replace("menu_","");
	setCookie("menu_id",liId);
	window.location.href = $("#"+obj.id).attr("url");
}


function getCookie(c_name)
{
	if (document.cookie.length>0)
	{
	  c_start=document.cookie.indexOf(c_name + "=");
	  if (c_start!=-1)
		{ 
			c_start=c_start + c_name.length+1;
			c_end=document.cookie.indexOf(";",c_start);
			if (c_end==-1) c_end=document.cookie.length
				return unescape(document.cookie.substring(c_start,c_end));
		} 
	}
return "";
}

function setCookie(c_name,value,expiredays)
{
	var exdate=new Date();
	exdate.setDate(exdate.getDate()+expiredays);
	document.cookie=c_name+ "=" +escape(value)+
	((expiredays==null) ? ";path=/" : ";expires="+exdate.toGMTString()+";path=/");
}

function clearCookie(){ 
	var keys=document.cookie.match(/[^ =;]+(?=\=)/g); 
	if (keys) { 
		for (var i = keys.length; i--;){
			document.cookie=keys[i]+'=0;expires=' + new Date( 0).toUTCString();
		} 	
	} 
}


function getbuttonid(){
	var listPath = GetUrlRelativePath();
	var btnLength='';
	$.ajax({
		type: "post",
		url: "/flxoa/function/getbuttonid",
		data: {
			"listPath":listPath
		},
		timeout:1000,
		async: false,
		//默认是true  ajax请求是异步的
		success: function(data) {
			if("" != data){
				if(-1 != data.indexOf(",")){
					var temp = data.split(",");
					var i = 0;
					for(i;i<temp.length;i++){
						//$("#btnSave").css("visibility","hidden");
						//$("#"+temp[i]).css("visibility","visible");
						$(temp[i]).show();
					}
				}else{
					//$("#"+data).css("visibility","visible");
					$(data).show();
				}			
				btnLength=data;
			}
		},
		error: function() {
			
		}
	});
	return btnLength;
}

function GetUrlRelativePath()
{
	var url = document.location.toString();
	var arrUrl = url.split("//");

	var start = arrUrl[1].indexOf("/");
	var relUrl = arrUrl[1].substring(start);//stop省略，截取从start开始到结尾的所有字符

	if(relUrl.indexOf("?") != -1){
		relUrl = relUrl.split("?")[0];
	}
	relUrl = relUrl.replace("#","");
	return relUrl;
}

// getbuttonid();

//顶部导航加载
var topMenu = $("nav.navbar");
var user;
function getUser(){
	$.ajax({
		type: "post",
		url: "/flxoa/user/getuser",
		data: {
		},
		async: true,
		//默认是true  ajax请求是异步的
		success: function(data) {
			sessionStorage.setItem("userinfo",data);
			user = eval('(' + data + ')');
			//获取顶部导航
			getTopMenu(user);
		},
		error: function() {
			
		}
	});
}

getUser();


function getTopMenu(user){
	//清除静态页面子元素
	topMenu.html(); 
	var topMenuStr = "";
		topMenuStr	+= "	<div class='navbar-wrapper'>																																			"
					+ "		<div class='navbar-logo' logo-theme='theme6'>                                                                                                                       "
					+ "			<a class='mobile-menu' id='mobile-collapse' href='#'>                                                                                                "
					+ "				<i title='收缩左菜单' class='ti-menu'></i>                                                                                                                                     "
					+ "			</a>                                                                                                                                                            "
					+ "			<div class='mobile-search'>                                                                                                                                     "
					+ "				<div class='header-search'>                                                                                                                                 "
					+ "					<div class='main-search morphsearch-search'>                                                                                                            "
					+ "						<div class='input-group'>                                                                                                                           "
					+ "							<span class='input-group-addon search-close'><i class='ti-close'></i></span>                                                                    "
					+ "							<input type='text' class='form-control' placeholder='Enter Keyword'>                                                                            "
					+ "							<span class='input-group-addon search-btn'><i class='ti-search'></i></span>                                                                     "
					+ "						</div>                                                                                                                                              "
					+ "					</div>                                                                                                                                                  "
					+ "				</div>                                                                                                                                                      "
					+ "			</div>                                                                                                                                                          "
					+ "			<a href='/flxoa/index'>                                                                                                                                           "
					+ "				<img class='img-fluid' src='/view/flxoa/page/nk/files/assets/images/logo.png' alt='Theme-Logo' style='height: 32px;'>                                       "
					+ "			</a>                                                                                                                                                            "
					+ "			<a class='mobile-options'>                                                                                                                                      "
					+ "				<i class='ti-more'></i>                                                                                                                                     "
					+ "			</a>                                                                                                                                                            "
					+ "		</div>                                                                                                                                                              "
					+ "		<div class='navbar-container container-fluid'>                                                                                                                      "
					+ "			<ul class='nav-left'>                                                                                                                                           "
					+ "				<li>                                                                                                                                                        "
					+ "					<div class='sidebar_toggle'>                                                                                                                            "
					+ "						<a href='javascript:void(0)'><i  class='ti-menu'></i></a>                                                                                            "
					+ "					</div>                                                                                                                                                  "
					+ "				</li>                                                                                                                                                       "
					// + "				<li class='header-search'>                                                                                                                                  "
					// + "					<div class='main-search morphsearch-search'>                                                                                                            "
					// + "						<div class='input-group'>                                                                                                                           "
					// + "							<span class='input-group-addon search-close'><i class='ti-close'></i></span>                                                                    "
					// + "							<input type='text' class='form-control'>                                                                                                        "
					// + "							<span class='input-group-addon search-btn'><i class='ti-search'></i></span>                                                                     "
					// + "						</div>                                                                                                                                              "
					// + "					</div>                                                                                                                                                  "
					// + "				</li>                                                                                                                                                       "
					+ "				<li>                                                                                                                                                        "
					+ "					<a href='#' onclick='javascript:toggleFullScreen()'>                                                                                         "
					+ "						<i title='全屏/还原' class='ti-fullscreen'></i>                                                                                                                       "
					+ "					</a>                                                                                                                                                    "
					+ "				</li>                                                                                                                                                       "
					+ "			</ul>                                                                                                                                                           "
					+ "			<ul class='nav-right'>                                                                                                                                          "
					// + "				<li class='header-notification'>                                                                                                                            "
					// + "					<a href='#'>                                                                                                                                 "
					// + "						<i class='ti-bell'></i>                                                                                                                             "
					// + "						<span class='badge bg-c-pink'></span>                                                                                                               "
					// + "					</a>                                                                                                                                                    "
					// + "					<ul class='show-notification'>                                                                                                                          "
					// + "						<li>                                                                                                                                                "
					// + "							<h6>Notifications</h6>                                                                                                                          "
					// + "							<label class='label label-danger'>New</label>                                                                                                   "
					// + "						</li>                                                                                                                                               "
					// + "						<li>                                                                                                                                                "
					// + "							<div class='media'>                                                                                                                             "
					// + "								<img class='d-flex align-self-center img-radius' src='/view/flxoa/page/nk/files/assets/images/avatar-2.jpg' alt='Generic placeholder image'>"
					// + "								<div class='media-body'>                                                                                                                    "
					// + "									<h5 class='notification-user'>John Doe</h5>                                                                                             "
					// + "									<p class='notification-msg'>Lorem ipsum dolor sit amet, consectetuer elit.</p>                                                          "
					// + "									<span class='notification-time'>30 minutes ago</span>                                                                                   "
					// + "								</div>                                                                                                                                      "
					// + "							</div>                                                                                                                                          "
					// + "						</li>                                                                                                                                               "
					// + "						<li>                                                                                                                                                "
					// + "							<div class='media'>                                                                                                                             "
					// + "								<img class='d-flex align-self-center img-radius' src='/view/flxoa/page/nk/files/assets/images/avatar-4.jpg' alt='Generic placeholder image'>"
					// + "								<div class='media-body'>                                                                                                                    "
					// + "									<h5 class='notification-user'>Joseph William</h5>                                                                                       "
					// + "									<p class='notification-msg'>Lorem ipsum dolor sit amet, consectetuer elit.</p>                                                          "
					// + "									<span class='notification-time'>30 minutes ago</span>                                                                                   "
					// + "								</div>                                                                                                                                      "
					// + "							</div>                                                                                                                                          "
					// + "						</li>                                                                                                                                               "
					// + "						<li>                                                                                                                                                "
					// + "							<div class='media'>                                                                                                                             "
					// + "								<img class='d-flex align-self-center img-radius' src='/view/flxoa/page/nk/files/assets/images/avatar-3.jpg' alt='Generic placeholder image'>"
					// + "								<div class='media-body'>                                                                                                                    "
					// + "									<h5 class='notification-user'>Sara Soudein</h5>                                                                                         "
					// + "									<p class='notification-msg'>Lorem ipsum dolor sit amet, consectetuer elit.</p>                                                          "
					// + "									<span class='notification-time'>30 minutes ago</span>                                                                                   "
					// + "								</div>                                                                                                                                      "
					// + "							</div>                                                                                                                                          "
					// + "						</li>                                                                                                                                               "
					// + "					</ul>                                                                                                                                                   "
					// + "				</li>                                                                                                                                                       "
					// + "				<li class=''>                                                                                                                                               "
					// + "					<a href='#' class='displayChatbox'>                                                                                                                     "
					// + "						<i class='ti-comments'></i>                                                                                                                         "
					// + "						<span class='badge bg-c-green'></span>                                                                                                              "
					// + "					</a>                                                                                                                                                    "
					// + "				</li>                                                                                                                                                       "
					+ "				<li class='user-profile header-notification'>                                                                                                               "
					+ "					<a href='#'>                                                                                                                                 "
					+ "						<img src='/view/flxoa/page/nk/files/assets/images/avatar-4.jpg' class='img-radius' alt='User-Profile-Image'>                                        "
					+ "						<span>"+user.userName+"</span>                                                                                                                               "
					+ "						<i class='ti-angle-down'></i>                                                                                                                       "
					+ "					</a>                                                                                                                                                    "
					+ "					<ul class='show-notification profile-notification'>                                                                                                     "
					// + "						<li>                                                                                                                                                "
					// + "							<a href='index.html#!'>                                                                                                                         "
					// + "								<i class='ti-settings'></i> Settings                                                                                                        "
					// + "							</a>                                                                                                                                            "
					// + "						</li>                                                                                                                                               "
					// + "						<li>                                                                                                                                                "
					// + "							<a href='user-profile.html'>                                                                                                                    "
					// + "								<i class='ti-user'></i> Profile                                                                                                             "
					// + "							</a>                                                                                                                                            "
					// + "						</li>                                                                                                                                               "
					// + "						<li>                                                                                                                                                "
					// + "							<a href='email-inbox.html'>                                                                                                                     "
					// + "								<i class='ti-email'></i> My Messages                                                                                                        "
					// + "							</a>                                                                                                                                            "
					// + "						</li>                                                                                                                                               "
					// + "						<li>                                                                                                                                                "
					// + "							<a href='auth-lock-screen.html'>                                                                                                                "
					// + "								<i class='ti-lock'></i> Lock Screen                                                                                                         "
					// + "							</a>                                                                                                                                            "
					// + "						</li>                                                                                                                                               "
					+ "						<li>                                                                                                                                                "
					+ "							<a href='/flxoa/logout'>                                                                                                             "
					+ "								<i class='ti-layout-sidebar-left'></i> 退出                                                                                               "
					+ "							</a>                                                                                                                                            "
					+ "						</li>                                                                                                                                               "
					+ "						<li>                                                                                                                                                "
					+ "							<a href='#' onclick='showChangePassword("+user.id+")'>                                                                                                             "
					+ "								<i class='ti-settings'></i> 修改密码                                                                                               "
					+ "							</a>                                                                                                                                            "
					+ "						</li>                                                                                                                                               "					

					+ "					</ul>                                                                                                                                                   "
					+ "				</li>                                                                                                                                                       "
					+ "			</ul>                                                                                                                                                           "
					+ "		</div>                                                                                                                                                              "
					+ "	</div>                                                                                                                                                                  ";
	topMenu.html(topMenuStr); 
}

var changePasswordIndex;
function showChangePassword(id){
	var html ="<div>";
		html+=	"<div>";
		html+=		"<p>密码：<input type='password' id='myPassword'></p>";
		html+=	"</div>";
		html+=	"<div style='padding-left:100px;'>";
		html+=		"<input type='button' value='保存' onclick='changePassword("+id+")'>";
		html+=	"</div>";
		html+="</div>";
	changePasswordIndex = layer.open({ 
		type: 1,
		title:"修改个人密码",
		area:['250px', '150px'],
		content:html
	}); 
}

function changePassword(id){
	var pwd = $("#myPassword").val();
	$.ajax({
		type:"post",
		url:"/flxoa/user/changepassword",
		data:{
			"id":id,
			"password":pwd
		},
		success:function(data){
			var msg = "";
			if("1" == data){
				msg = "修改个人密码成功";
			}else{
				msg = "修改个人密码失败";
			}
			layer.msg(msg);
			layer.close(changePasswordIndex);
		},
		error:function(){
			layer.msg("网络繁忙，请稍后再试");
		}
	});
}


// 设置jQuery Ajax全局的参数
var loadIndexArray = new Array(); 
$.ajaxSetup({  
	type: "POST",  
	error: function(jqXHR, textStatus, errorThrown){  
		switch (jqXHR.status){  
			case(500):  
				layer.msg("服务器系统内部错误");  
				break;  
			case(401):  
				layer.msg("登录超时或未经授权访问,请重新登录或联系管理员");  
				break;  
			case(403):  
				layer.msg("无权限执行此操作");  
				break;
			case(404):  
				layer.msg("请求的页面不存在或链接错误");  
				break;  					
			case(408):  
				layer.msg("请求超时");  
				break;  
			default:  
				layer.msg("未知错误");  
		}  
	},
	beforeSend:function(){
		//layer.msg("加载开始");
		//loading层
		var loadIndex = layer.load(2, {
		  shade: [0.4,'#a0a0a0'] //0.4透明度的白色背景
		});
		loadIndexArray.push(loadIndex);
	},
	complete:function(XMLHttpRequest,textStatus){
		//layer.msg("加载结束");
		//一次只移除一个loading层
		layer.close(loadIndexArray[0]);
		loadIndexArray.splice(0,1);
	},	
});




	

	function apply(tid){ 
			$.ajax({
				url:"/flxoa/formtemplate/getbyid",
				type : "post",
				data : {
					"id":tid
				},
				success:function(data){
					var json = eval('(' + data + ')');  
					var jsonlayt = eval('(' + json.layout + ')');
					/*  执行初始化 table */ 
					initTable(jsonlayt.names,"app",json.name); 
					
$('#app').append('<input type="hidden" name="templateId" value="'+tid+'" />'); 
$('#app').append('<div class="text-center"> <button type="button" onclick=itemSubmit("app",true) class="btn btn-success btn-sm ">保 存</button> &nbsp; <button  onclick=itemSubmit("app",false) type="button" class="btn btn-primary btn-sm ">提 交</button></div>'); 
				}
			});

	}

	// var example = {"names":[{"key":"appl_date","name":"日期","iskeyword":"1","type":"3","binding_data":"2","enumeration_name":"","iseditable":"0","list_items":"","quoteid":"","return_value":""},{"key":"applicant","name":"姓名","iskeyword":"1","type":"0","binding_data":"0","enumeration_name":"","iseditable":"0","list_items":"","quoteid":"","return_value":""},{"key":"appl_department","name":"部门","iskeyword":"1","type":"0","binding_data":"1","enumeration_name":"","iseditable":"0","list_items":"","quoteid":"","return_value":""},{"key":"al_start_time","name":"请假开始时间","iskeyword":"1","type":"3","binding_data":"","enumeration_name":"","iseditable":"0","list_items":"","quoteid":"","return_value":""},{"key":"al_end_time","name":"请假结束时间","iskeyword":"1","type":"3","binding_data":"","enumeration_name":"","iseditable":"0","list_items":"","quoteid":"","return_value":""},{"key":"al_type","name":"请假类别","iskeyword":"1","type":"1","binding_data":"","enumeration_name":"al_type","iseditable":"0","list_items":"","quoteid":"","return_value":""},{"key":"al_types","name":"单选组","iskeyword":"1","type":"2","binding_data":"","enumeration_name":"al_types","iseditable":"0","list_items":"","quoteid":"","return_value":""},{"key":"al_reason","name":"请假事由","iskeyword":"0","type":"0","binding_data":"","enumeration_name":"","iseditable":"1","list_items":"","quoteid":"","return_value":""}]};

		// var optValArr = [{"createDepartmentId":0,"createTime":0,"createUserId":0,"deleteFlag":"0","enumerationDescription":"项目属性","enumerationKey":"0","enumerationName":"proj_attribute","enumerationValue":"会议","id":16,"updateDepartmentId":0,"updateTime":0,"updateUserId":0},{"createDepartmentId":0,"createTime":0,"createUserId":0,"deleteFlag":"0","enumerationDescription":"项目属性","enumerationKey":"1","enumerationName":"proj_attribute","enumerationValue":"弱电","id":17,"updateDepartmentId":0,"updateTime":0,"updateUserId":0},{"createDepartmentId":0,"createTime":0,"createUserId":0,"deleteFlag":"0","enumerationDescription":"项目属性","enumerationKey":"2","enumerationName":"proj_attribute","enumerationValue":"集成","id":18,"updateDepartmentId":0,"updateTime":0,"updateUserId":0},{"createDepartmentId":0,"createTime":0,"createUserId":0,"deleteFlag":"0","enumerationDescription":"项目属性","enumerationKey":"3","enumerationName":"proj_attribute","enumerationValue":"安防","id":19,"updateDepartmentId":0,"updateTime":0,"updateUserId":0},{"createDepartmentId":0,"createTime":0,"createUserId":0,"deleteFlag":"0","enumerationDescription":"项目属性","enumerationKey":"4","enumerationName":"proj_attribute","enumerationValue":"智慧城市","id":20,"updateDepartmentId":0,"updateTime":0,"updateUserId":0},{"createDepartmentId":0,"createTime":0,"createUserId":0,"deleteFlag":"0","enumerationDescription":"项目属性","enumerationKey":"5","enumerationName":"proj_attribute","enumerationValue":"软件销售","id":21,"updateDepartmentId":0,"updateTime":0,"updateUserId":0},{"createDepartmentId":0,"createTime":0,"createUserId":0,"deleteFlag":"0","enumerationDescription":"项目属性","enumerationKey":"6","enumerationName":"proj_attribute","enumerationValue":"软件开发","id":22,"updateDepartmentId":0,"updateTime":0,"updateUserId":0}]
 
//保存或者提交方法
	function itemSubmit(elm,flag){
		var index = layer.load(1, {
		  shade: [0.1,'#fff'] //0.1透明度的白色背景
		});
		var _self;
		var _this;
		if($("#"+elm).find("input[type=file]").length > 0){
			
			$("#"+elm).find("input[type=file]").each(function(index){
				//把file元素上的  需要上传的执行方法 文本拿出来 执行。
				// fileUpload()	附件先上传了。
				 _self = $(this).attr("id");
				 _this = $(this).attr("data-keys");
				
			});  
			fileUpload(_self,_this,elm,flag);
		}
		else{
			var abbr =  $("#form_"+elm).serialize();
			var postUrl = flag ? '/flxoa/approve/save' : '/flxoa/approve/submit';
			var msg = flag ? '保存成功！' : '提交成功！';
				
				$.ajax({
					url:postUrl,
					type : "post",
					data : abbr,
					async:false,
					success:function(data){
						layer.msg(msg); 
						setTimeout(function(){
							layer.closeAll();
						}, 2000);
					}

			});	
		
			layer.close(index);
		}

	}
 	function fileUpload(item,id,elm,flag){
		var index = layer.load(1, {
		  shade: [0.1,'#fff'] //0.1透明度的白色背景
		});
		
		$.ajaxFileUpload({
			url: '/flxoa/formtemplate/fileupload', 
			type: 'post',
			data : {
			},
			async: false,
			secureuri: false, //一般设置为false
			fileElementId: [item], // 上传文件的id、name属性名
			dataType: 'JSON', //返回值类型，一般设置为json、application/json  这里要用大写  不然会取不到返回的数据
			success: function(data, status){
				
				var s = decodeURIComponent(data);
				s = eval(s);
				var abbr =  $("#form_"+elm).serialize();
				var postUrl = flag ? '/flxoa/approve/save' : '/flxoa/approve/submit';
				var msg = flag ? '保存成功！' : '提交成功！';
					
					$.ajax({
						url:postUrl,
						type : "post",
						data : abbr,
						async:false,
						success:function(data){
							layer.msg(msg); 
							setTimeout(function(){
								layer.closeAll();
							}, 2000);
						}

				});	
			
				layer.close(index);
			},
			error: function(data, status, e) {  //提交失败自动执行的处理函数。
                console.error(e);
            }
		});	
	}
/**
 * 模板池
 * @param  res 是 ajax 返回的data   
 */
 function pkgInput(res,type){
 	var disabled_attr = "";
 	if(res.iseditable == "0" && res.key == "name"){ //不可编辑
 		disabled_attr = "readonly=readonly";
 		var userInfo = sessionStorage.userinfo;
 		userInfo = JSON.parse(userInfo); 
 		res.value=	userInfo.realName;
 	}else{	//可编辑
 		disabled_attr = "";
 	}
	if(null == res.value){
		res.value = "";
	}

 	var inputExample = {
 	'input': `<div class="form-group row">
		<label class="col-sm-2 col-form-label text-right" for="input01">${res.name}</label>
 		<div class="col-sm-10"><input id="${res.key}"  class="form-control" for="input01" type="text" ${disabled_attr} name="${res.key}"  value="${res.value}"></div>
 	</div>`,

 	'select': `<div class="form-group row">
				 	<label class="col-sm-2 col-form-label text-right" for="input02">${res.name}</label>
				 	<div class="col-sm-10"><select id="${res.key}" name="${res.key}" class="form-control" ${disabled_attr} for="input02" value="${res.value}">${res.name}</select></div>
				 </div>`,

 	'radio': `<div class="form-group row">
				 <label class="col-sm-2 col-form-label text-right" for="input03">${res.name}</label>
				 <div class="col-sm-10" id="${res.key}" for="input03"> </div>
				</div>`,
	'inputDate': `<div class="form-group row">
				<label class="col-sm-2 col-form-label text-right" for="input04">${res.name}</label>
				<div class="col-sm-10"><input for="input04" class="form-control" id="${res.key}" type="date" ${disabled_attr} name="${res.key}" value="${res.value}"/></div>
				</div>`,
	'inputItems':`<div class="form-group row">
                <label class="col-sm-2 col-form-label text-right" for="input05">${res.name}</label>
                <div class="col-sm-10 main-con-${res.key}">
                	<input id="${res.key}" type="hidden" class="form-control" name="${res.key}" />
                </div>
                </div>`,
	'detailList':`<div class="form-group row">
                <label class="col-sm-2 col-form-label text-right" for="input06">${res.name}</label>
                <div class="col-sm-10"><input class="form-control" for="input06" id="${res.key}" type="text" ${disabled_attr} name="${res.key}" value="${res.value}" data="res"/></div>
                </div>`,
    'popupList':`<div class="form-group row">
                <label class="col-sm-2 col-form-label text-right" for="input07">${res.name}</label>
                <div class="col-sm-10"><span class="form-control" for="input07" id="${res.key}" type="text" ${disabled_attr} name="${res.key}" value="${res.value}"></span></div>
                </div>`,
	'inputCheckBox':`<div class="form-group row">
                <label class="col-sm-2 col-form-label text-right" for="input05">${res.name}</label>
                <div class="col-sm-10 main-con-${res.key}">
                	<input id="${res.key}" type="hidden" class="form-control" name="${res.key}" />
                </div>
                </div>`,
'infoArea':`<div class="form-group row"> 
                <div class="col-sm-12 main-con-${res.key}">
                ${res.name}
                	<input id="${res.key}" type="hidden" class="form-control" name="${res.key}" value="${res.value}"/>
                </div>
                </div>`

};




var inputExample_Read = { 'input': `<div class="form-group row">
<label class="col-sm-2 col-form-label text-right"
	for="input01">${res.name}</label>             <div class="col-sm-10"><input
	id="${res.key}"  class="form-control" for="input01" type="text"
	${disabled_attr} value="${res.value}" name="${res.key}"  /></div>
	</div>`,

	    'select': `<div class="form-group row">         <label class="col-sm-2
	col-form-label text-right" for="input02">${res.name}</label>         <div
	class="col-sm-10"><select id="${res.key}" value="${res.value}" class="form-
	control" ${disabled_attr} for="input02">${res.name}</select></div>
	</div>`,

	    'radio': `<div class="form-group row">      <label class="col-sm-2 col-
	form-label text-right" for="input03">${res.name}</label>      <div class="col-
	sm-10" id="${res.key}"  for="input03"> </div>     </div>`,     'inputDate':
	`<div class="form-group row">     <label class="col-sm-2 col-form-label text-
	right" for="input04">${res.name}</label>     <div class="col-sm-10"><input
	for="input04"  value="${res.value}" class="form-control" id="${res.key}"
	${disabled_attr} type="date" name="${res.key}" /></div>     </div>`,
	'inputItems':`<div class="form-group row">     <label class="col-sm-2 col-
	form-label text-right" for="input05">${res.name}</label>     <div class="col-
	sm-10 main-con-${res.key}">     <input id="${res.key}" type="hidden" class
	="form-control" name="${res.key}" />     <div class="jFiler-items jFiler-row">
	<ul class="jFiler-items-list jFiler-items-default"
	id="jFiler_${res.key}"></ul>     </div>

	    </div>     </div>`,
	'detailList':`<div class="form-group row">
	<label class="col-sm-2 col-form-label text-right"
	for="input06">${res.name}</label>     <div class="col-sm-10"><input class
	="form-control" value="${res.value}" for="input06" id="${res.key}"
	${disabled_attr} type="text" name="${res.key}" data="res"/></div>     </div>`,
	'popupList':`<div class="form-group row">     <label class="col-sm-2 col-form-
	label text-right" for="input07">${res.name}</label>     <div class="col-
	sm-10"><span class="form-control" value="${res.value}" for="input07"
	id="${res.key}" ${disabled_attr} type="text" name="${res.key}" ></span></div>
	</div>`, 
	'inputCheckBox':`<div class="form-group row">     <label class
	="col-sm-2 col-form-label text-right" for="input05">${res.name}</label>
	<div class="col-sm-10 main-con-${res.key}">         <input id="${res.key}"
	type="hidden" class="form-control" name="${res.key}" />     </div>
	</div>`,     
	'infoArea':`<div class="form-group row">      <div class="col-
	sm-12 main-con-${res.key}">     ${res.name}         <input id="${res.key}"
	type="hidden" class="form-control" name="${res.key}" />     </div></div>`};



var inputExampleHTML= !!!type ? inputExample : inputExample_Read;

return inputExampleHTML;
}

var popIndex;
function popLayer(tit,id,are,url){ 	
	var cont =   !!url ?[url,'yes']:'<form id="form_'+id+'"><div class="card"><div class="card-block" id="'+id+'"></div></div></form>';
	    popIndex = layer.open({
	        type: !!url?2:1 ,//1 页面 2 iframe
	        maxmin: true,
	        title: tit,//标题
	        area: are,//弹出层大小
	        content: cont//内容
	    });  

}


function getPropertyByIndex(index) {
    let keys = Object.keys(this);
    let key = keys[index];
    return this[key];
}

function closeIframe(param){
		for(var i in  param){   
			var obj = param[i].split(":");     
		   $("input[name="+obj[0]+"]").val(obj[1]);
		}	 
	layer.close(popIndex);
}
//关闭二级菜单方法  传递内容及参数
function closeWind(param){  
	var pIndex = sessionStorage.popIndex;
}


function ajaxLib(){

}

function downFile(dname){
	$.ajax({
		url:"/flxoa/formtemplate/filedownload",
		type : "post",
		data : {
			"fileRealName":dname, 
		},
		success:function(data)
		{

		}
	});
}


function openFram(){
	popLayer(tit,id,['1200px', '680px']); 
}

function changSelect(div){
	 $("#sel_"+div).attr("readonly","readonly").val("");  
	 $("#selRi_"+div).removeAttr("checked");
	 $("#chren_"+div).attr("readonly","readonly").val("");  
	 $("#chrenRi_"+div).removeAttr("checked");
}
function disaSelect(div){
	$("#sel_"+div).removeAttr("readonly");  
	$("#rio_"+div).find("input[type=radio]").removeAttr("checked");
	$("#chrenSel_"+div).attr("readonly","readonly").val(""); 
	$("#chrenRi_"+div).removeAttr("checked");
}
function chrenSelect(div){
	$("#chrenSel_"+div).removeAttr("readonly");  
	 $("#sel_"+div).attr("readonly","readonly").val("");  
	$("#selRi_"+div).removeAttr("checked");
}

		//追加回款一项  来自于 input_items(id,inp,ex)
		function AddHk(doms){
			var indexI = $(doms).find("tr").length; indexI+=1;
			var colTXT = $(doms).find("tr:last").html();
			//复制最后一行 并且 把最后一行的所有id 加1 作为最新的一行
			colTXT = colTXT.replace(new RegExp("_dynamicList"+$(doms).find("tr").length,'g'), "_dynamicList"+indexI);
			var itemStr = $("<tr>"+colTXT+"</tr>");
			itemStr.find("input").val("");
			itemStr.find("td.firstNum").text(indexI);
			$(doms).append(itemStr);


		}	
		function DelHk(doms){
			 $(doms).find("tr.active").remove();
			 $(doms).find("tr").each(function(index)	{
			 	$(this).find("td:first").text(index+1);
			 });
		}

	 
$(document).on('click','.tabTbody tr',function(){  
				     $(this).addClass("active").css({"background":"#eee"}).siblings().removeClass("active").css({"background":"#fff"});  
				 })  
 $(document).on('blur','.tabTbody input',function(){  
 	var htmlChren = $("#table_"+ds);
 	htmlChren.find("tr").each(function(index){

 	}) 
		$(this).attr("value",$(this).val());
		var ds = $(this).data("blurid");
		$("#"+ds).val('<table id="table_'+ds+'" class="table table-xs table-bordered">'+$("#table_"+ds).html()+'</table>');
		
		//保存动态追加列表的json
		//定义json 数组
		var jsonStr="[]";  
		var jsonArray = eval('('+jsonStr+')');
		//求和
		var sumNumber = 0.00;
		//求和返回给那个控件
		var returnValue = "";
		$("#tbody_"+ds).find("tr").each(function(){
			var tdArr = $(this).children();
			//定义json 对象
			var json = {};
			for(var i = 0;i<tdArr.length;i++){
				//输入框对象
				var input = tdArr.eq(i).find('input');
				//下拉列表对象
				var selectInput = tdArr.eq(i).find('select');
				//文本域对象
				var textareaInput = tdArr.eq(i).find('textarea');
				var inputId = input.attr("id");
				var selectId = selectInput.attr("id");
				var textareaInputId = textareaInput.attr("id");
				if(null != inputId){
					var jsonAttrName = inputId.replace("data_","");
					json[jsonAttrName] = input.val();
					var is_sum = input.attr("is_sum");
					if("1" == is_sum){
						sumNumber = sumNumber + parseFloat(input.val());
						returnValue = input.attr("return_value");
					}
				}
				if(null != selectId){
					var jsonAttrName = selectId.replace("data_","");
					json[jsonAttrName] = selectInput.val();				
				}
				if(null != textareaInputId){
					var jsonAttrName = textareaInputId.replace("data_","");
					json[jsonAttrName] = textareaInput.val();
					var is_sum = textareaInput.attr("is_sum");
					if("1" == is_sum){
						sumNumber = sumNumber + parseFloat(textareaInput.val());
						returnValue = textareaInput.attr("return_value");
					}
					textareaInput.html(textareaInput.val());
				}				
			}
			//存放json 数组里面
			jsonArray.push(json);
		});
		if("" != returnValue){
			$("#"+returnValue).val(sumNumber);
		}
		//存放动态列json 数据用做后台统计等等
		$("#"+ds+"_in").val(JSON.stringify(jsonArray));
 });
   
//专门针对layer的 全屏调整  $(".layui-layer").css({"overflow":"auto"});
$(document).on('click','.layui-layer-max',function(){  
	    	var hgehit;
	    	 if(!$(this).hasClass("layui-layer-maxmin")){   
	    	 		$(".layui-layer-content").css({"height":hgehit});
	    	 		$(".layui-layer").css({"overflow":"auto"}); 
	    	 }else{
	    	 	hgehit = $(".layui-layer-content").height();
	    	 	$(".layui-layer-content").css({"height":"auto"}); 	
	    	 	$(".layui-layer").css({"overflow":"auto"});  
	    	 } 

	    });

//动态让下拉列表option 选中
function myOptionSelect(obj){
	var objValue = $("#"+obj.id).val();
	if(objValue != ""){
		$("#"+obj.id+" option").each(function() {
			if(objValue != $(this).val()){
				var optionSelected = $(this).attr("selected");
				if(null != optionSelected){
					$(this).removeAttr('selected');
				}			
			}
		});
		$("#"+obj.id).find("option[value='"+objValue+"']").attr("selected",true);
		//如果下拉列表为报销类型
		var oid = obj.id;
		if(-1 != oid.indexOf("data_reim_type")){
			var temp = oid.split("_");
			var dynamicListNo = temp[temp.length-1];
			var str = "";
			//交通费
			if("0" == objValue){
				str = `到xx出差/市内
x月x日  北京到大连（飞机、火车、打车、自驾）xx点到xx点
花销金额：xx
出差事由：xxxx
信用卡还款日期x月xx日
（如果未使用信用卡请删除信用卡还款日期）`;		
			}
			//个人餐费
			else if("2" == objValue){
				str = `餐费
x月x日 午餐  3人  杨xx，李xx，张xx
事由：xxxx
信用卡还款日期x月xx日
如果未使用信用卡请删除信用卡还款日期）`;					
			}
			//住宿费
			else if("3" == objValue){
				str = `x月x日到x月x日  
住宿地点：xxx
住宿天数： xx天
住宿人员：xx xx
事由：xxxx
信用卡还款日期x月xx日
（如果特殊情况，需在里面备注上，如果未使用信用卡请删除信用卡还款日期）`;					
			}
			//出差补助
			else if("4" == objValue){
				str = `x月x日到x月x日  出差天数：天 
出差地点：大连
出差事由：xxxx
信用卡还款日期x月xx日
（如果特殊情况，需在里面备注上，如，30天内差补超过1000元，报销后另附说明，如果未使用信用卡请删除信用卡还款日期）`;					
			}
			//5其他费用  7材料费  8工程服务费
			else if("5" == objValue || "7" == objValue ||"8" == objValue){
				str = `培训材料打印120份
信用卡还款日期x月xx日
（如果未使用信用卡请删除信用卡还款日期）`;					
			}
			//招待费
			else if("6" == objValue){
				str = `费用产生时间:xx
对方单位:
对方姓名及职务:
陪同人员:
拜访目的:
沟通内容:
沟通成效:
产生问题: `;					
			}
			$("#data_reim_reasons_"+dynamicListNo).val(str);
		}
	}		
}
//
/**
 * 初始化tab表格
 * @param  {exp} 接表单结构JSON串
 * @param  {id}  div表现层的id
 * * @param  {tit}  表名 
 * {type}  是否为只读  有值就是只读
 * {pid}    在我的审批中的弹出层里的id div元素
 */
 function initTable(exp,id,tit,type,pid) {
	// var  app = $('<div id="'+id+'"></div>'); 
	if(!!!pid) { 
		popLayer(tit,id,['1200px', '680px']); 
		id = '#'+id;
	}else{
		id = '#'+pid;	
	} 
	//创建input text
	
	function inputText(id,inp,ex){ 
		$(id).append(inp.input);  
		//飞利信支票领用单 合同额-累计已付款=款项余额
		if(ex.key === 'accu_payment'){
			$('input[name='+ex.key+']').keyup(function(){
				var subtrahend = $("#contr_amount").val();
				var minuend = $(this).val();
				var differ = Number(subtrahend)-Number(minuend);
				$("#balance_fund").val(differ);
			});
		}
		if(ex.key === 'gros_margin'){//项目投标审批表毛利率
			$('input[name='+ex.key+']').change(function(){
				var grossProfit = $(this).val();//毛利
				var predictContractMoney = $("#predictContractMoney").val();//合同额
				var grossProfitRate = Number(grossProfit)/Number(predictContractMoney);
				$("#gros_profit_rate").val(grossProfitRate+"%")//毛利率
				
			});
		}
		if(ex.key === ''){
			
		}
	}
	//创建input select
	function inputSelect(id,inp,ex){ 
		$(id).append(inp.select);
		var getVal;

		if('proj_type' === ex.key){//项目类型
			if('' == ex.value){ 
				getVal = getSeled(ex.enumeration_name);
				$(id).find("select[id="+ex.key+"]").append(getVal);
			}else{
				switch(ex.value){
					case '0':getVal = `<option value="0">直接用户</option>`;break;
					case '1':getVal = `<option value="1">渠道用户</option>`;break;
					case '2':getVal = `<option value="2">维保</option>`;break;
					case '3':getVal = `<option value="3">软件</option>`;break;
					case '4':getVal = `<option value="4">贝拉生产</option>`;break;
					case '5':getVal = `<option value="5">其他</option>`;break;
				}
				$(id).find("select[id="+ex.key+"]").append(getVal);
			}
			if('' != ex.key && '' != ex.value){ 
				switch(ex.value){
					case '0':getVal = `<option value="0">直接用户</option>`;break;
					case '1':getVal = `<option value="1">渠道用户</option>`;break;
					case '2':getVal = `<option value="2">维保</option>`;break;
					case '3':getVal = `<option value="3">软件</option>`;break;
					case '4':getVal = `<option value="4">贝拉生产</option>`;break;
					case '5':getVal = `<option value="5">其他</option>`;break;
				}
				
				var json_template = [
						`<option value="0">直接用户</option>`,
						`<option value="1">渠道用户</option>`,
						`<option value="2">维保</option>`,
						`<option value="3">软件</option>`,
						`<option value="4">贝拉生产</option>`,
						`<option value="5">其他</option>` 
				];
				
				
				var tempOldArr =  getNewList(json_template,json_template[ex.value]) ; //除了已经选择的option 现在这些是剩下没选的option
				
				 
				for(var i in tempOldArr){
					$(id).find("select[id="+ex.key+"]").append(tempOldArr[i]);
				} 
				$(id).find("option").click(function(){ 
					$(this).parent().attr("value",$(this).index());
				});
			}

		}
		if('al_type' === ex.key){//请假类别
			if('' == ex.value){ 
				getVal = getSeled(ex.enumeration_name);
				$(id).find("select[id="+ex.key+"]").append(getVal);
			}else{
				switch(ex.value){
					case '0':getVal = `<option value="0">事假</option>`;break;
					case '1':getVal = `<option value="1">病假</option>`;break;
					case '2':getVal = `<option value="2">婚假</option>`;break;
					case '3':getVal = `<option value="3">丧假</option>`;break;
					case '4':getVal = `<option value="4">年假</option>`;break;
					case '5':getVal = `<option value="5">其他</option>`;break;
				}
				$(id).find("select[id="+ex.key+"]").append(getVal);
			}
			if('' != ex.key && '' != ex.value){ 
				switch(ex.value){
				case '0':getVal = `<option value="0">事假</option>`;break;
				case '1':getVal = `<option value="1">病假</option>`;break;
				case '2':getVal = `<option value="2">婚假</option>`;break;
				case '3':getVal = `<option value="3">丧假</option>`;break;
				case '4':getVal = `<option value="4">年假</option>`;break;
				case '5':getVal = `<option value="5">其他</option>`;break;
				}
				
				var json_holiday = [
						`<option value="0">事假</option>`,
						`<option value="1">病假</option>`,
						`<option value="2">婚假</option>`,
						`<option value="3">丧假</option>`,
						`<option value="4">年假</option>`,
						`<option value="5">其他</option>` 
				];
				
				
				var tempNewArr =  getNewList(json_holiday,json_holiday[ex.value]) ; //除了已经选择的option 现在这些是剩下没选的option
				
				 
				for(var i in tempNewArr){
					$(id).find("select[id="+ex.key+"]").append(tempNewArr[i]);
				} 
				$(id).find("option").click(function(){ 
					$(this).parent().attr("value",$(this).index());
				});
			}
		}
		if('paym_method' === ex.key){//支付方式
			if('' == ex.value){ 
				getVal = getSeled(ex.enumeration_name);
				$(id).find("select[id="+ex.key+"]").append(getVal);
			}else{
				switch(ex.value){
				case '0':getVal = `<option value="0">现金</option>`;break;
				case '1':getVal = `<option value="1">信用卡</option>`;break;
				case '2':getVal = `<option value="2">差旅壹号</option>`;break;

				}
				$(id).find("select[id="+ex.key+"]").append(getVal);
			}
			if('' != ex.key && '' != ex.value){ 
				switch(ex.value){
				case '0':getVal = `<option value="0">现金</option>`;break;
				case '1':getVal = `<option value="1">信用卡</option>`;break;
				case '2':getVal = `<option value="2">差旅壹号</option>`;break;
				}
				
				var json_pay_method = [
				                    `<option value="0">现金</option>`,
				                    `<option value="1">信用卡</option>`,
				                    `<option value="2">差旅壹号</option>`
				                    ];
				
				
				var tempPayArr =  getNewList(json_pay_method,json_pay_method[ex.value]) ; //除了已经选择的option 现在这些是剩下没选的option
				
				
				for(var i in tempPayArr){
					$(id).find("select[id="+ex.key+"]").append(tempPayArr[i]);
				} 
				$(id).find("option").click(function(){ 
					$(this).parent().attr("value",$(this).index());
				});
			}
		}
		if('borr_type' === ex.key){//借款类型
			if('' == ex.value){ 
				getVal = getSeled(ex.enumeration_name);
				$(id).find("select[id="+ex.key+"]").append(getVal);
			}else{
				switch(ex.value){
				case '0':getVal = `<option value="0">---类别1---</option>`;break;
				case '1':getVal = `<option value="1">房屋押金</option>`;break;
				case '2':getVal = `<option value="2">安全保证金</option>`;break;
				case '3':getVal = `<option value="3">租赁押金</option>`;break;
				case '4':getVal = `<option value="4">履约保证金</option>`;break;
				case '5':getVal = `<option value="5">投标保证金</option>`;break;
				case '6':getVal = `<option value="6">质保金</option>`;break;
				case '7':getVal = `<option value="7">其他</option>`;break;
				case '8':getVal = `<option value="8">---类别2---</option>`;break;
				case '9':getVal = `<option value="9">租赁费</option>`;break;
				case '10':getVal = `<option value="10">房租</option>`;break;
				case '11':getVal = `<option value="11">材料费</option>`;break;
				case '12':getVal = `<option value="12">商务费</option>`;break;
				case '13':getVal = `<option value="13">临时用工费</option>`;break;
				case '14':getVal = `<option value="14">办公用品</option>`;break;
				case '15':getVal = `<option value="15">固定资产</option>`;break;
				case '16':getVal = `<option value="16">物流费</option>`;break;
				case '17':getVal = `<option value="17">其他</option>`;break;
				
				}
				$(id).find("select[id="+ex.key+"]").append(getVal);
			}
			if('' != ex.key && '' != ex.value){ 
				switch(ex.value){
				case '0':getVal = `<option value="0">---类别1---</option>`;break;
				case '1':getVal = `<option value="1">房屋押金</option>`;break;
				case '2':getVal = `<option value="2">安全保证金</option>`;break;
				case '3':getVal = `<option value="3">租赁押金</option>`;break;
				case '4':getVal = `<option value="4">履约保证金</option>`;break;
				case '5':getVal = `<option value="5">投标保证金</option>`;break;
				case '6':getVal = `<option value="6">质保金</option>`;break;
				case '7':getVal = `<option value="7">其他</option>`;break;
				case '8':getVal = `<option value="8">---类别2---</option>`;break;
				case '9':getVal = `<option value="9">租赁费</option>`;break;
				case '10':getVal = `<option value="10">房租</option>`;break;
				case '11':getVal = `<option value="11">材料费</option>`;break;
				case '12':getVal = `<option value="12">商务费</option>`;break;
				case '13':getVal = `<option value="13">临时用工费</option>`;break;
				case '14':getVal = `<option value="14">办公用品</option>`;break;
				case '15':getVal = `<option value="15">固定资产</option>`;break;
				case '16':getVal = `<option value="16">物流费</option>`;break;
				case '17':getVal = `<option value="17">其他</option>`;break;
				}
				
				var json_borr_method = [
				                       `<option value="0">---类别1---</option>`,
				                       `<option value="1">房屋押金</option>`,
				                       `<option value="2">安全保证金</option>`,
				                       `<option value="3">租赁押金</option>`,
				                       `<option value="4">履约保证金</option>`,
				                       `<option value="5">投标保证金</option>`,
				                       `<option value="6">质保金</option>`,
				                       `<option value="7">其他</option>`,
				                       `<option value="8">---类别2---</option>`,
				                       `<option value="9">租赁费</option>`,
				                       `<option value="10">房租</option>`,
				                       `<option value="11">材料费</option>`,
				                       `<option value="12">商务费</option>`,
				                       `<option value="13">临时用工费</option>`,
				                       `<option value="14">办公用品</option>`,
				                       `<option value="15">固定资产</option>`,
				                       `<option value="16">物流费</option>`,
				                       `<option value="17">其他</option>`
				                       ];
				
				
				var tempBorrArr =  getNewList(json_borr_method,json_borr_method[ex.value]) ; //除了已经选择的option 现在这些是剩下没选的option
				
				
				for(var i in tempBorrArr){
					$(id).find("select[id="+ex.key+"]").append(tempBorrArr[i]);
				} 
				$(id).find("option").click(function(){ 
					$(this).parent().attr("value",$(this).index());
				});
			}
		}
		if('certificate_name' === ex.key){
			if('' == ex.value){ 
				getVal = getSeled(ex.enumeration_name);
				$(id).find("select[id="+ex.key+"]").append(getVal);
			}else{
				switch(ex.value){
				case '0':getVal = `<option value="0">电子营业执照</option>`;break;
				case '1':getVal = `<option value="1">电子组织机构代码证</option>`;break;
				case '2':getVal = `<option value="2">电子税务登记证</option>`;break;
				case '3':getVal = `<option value="3">电子计算机信息系统集成企业资质证书</option>`;break;
				case '4':getVal = `<option value="4">电子安全生产许可证</option>`;break;
				case '5':getVal = `<option value="5">电子高新技术企业证书</option>`;break;

				
				}
				$(id).find("select[id="+ex.key+"]").append(getVal);
			}
			if('' != ex.key && '' != ex.value){ 
				switch(ex.value){
				case '0':getVal = `<option value="0">电子营业执照</option>`;break;
				case '1':getVal = `<option value="1">电子组织机构代码证</option>`;break;
				case '2':getVal = `<option value="2">电子税务登记证</option>`;break;
				case '3':getVal = `<option value="3">电子计算机信息系统集成企业资质证书</option>`;break;
				case '4':getVal = `<option value="4">电子安全生产许可证</option>`;break;
				case '5':getVal = `<option value="5">电子高新技术企业证书</option>`;break;

				}
				
				var json_certificate_method = [
				                        `<option value="0">电子营业执照</option>`,
				                        `<option value="1">电子组织机构代码证</option>`,
				                        `<option value="2">电子税务登记证</option>`,
				                        `<option value="3">电子计算机信息系统集成企业资质证书</option>`,
				                        `<option value="4">电子安全生产许可证</option>`,
				                        `<option value="5">电子高新技术企业证书</option>`
				                        ];
				
				
				var tempCertificateArr =  getNewList(json_certificate_method,json_certificate_method[ex.value]) ; //除了已经选择的option 现在这些是剩下没选的option
				
				
				for(var i in tempCertificateArr){
					$(id).find("select[id="+ex.key+"]").append(tempCertificateArr[i]);
				} 
				$(id).find("option").click(function(){ 
					$(this).parent().attr("value",$(this).index());
				});
			}
		}
		if('fund_purpose' === ex.key){
			if('' == ex.value){ 
				getVal = getSeled(ex.enumeration_name);
				$(id).find("select[id="+ex.key+"]").append(getVal);
			}else{
				switch(ex.value){
				case '0':getVal = `<option value="0">投标保证金</option>`;break;
				case '1':getVal = `<option value="1">采购用款</option>`;break;
				case '2':getVal = `<option value="2">中标服务费</option>`;break;
				case '3':getVal = `<option value="3">购买标书</option>`;break;
				case '4':getVal = `<option value="4">报名费</option>`;break;
				case '5':getVal = `<option value="5">标书打印费</option>`;break;
				case '6':getVal = `<option value="6">其他保证金（含押金）</option>`;break;
				case '7':getVal = `<option value="7">劳务费</option>`;break;
				case '8':getVal = `<option value="8">退款</option>`;break;
				case '9':getVal = `<option value="9">工资或五险一金</option>`;break;
				case '10':getVal = `<option value="10">异地税金</option>`;break;
				case '11':getVal = `<option value="11">其他</option>`;break;

				
				
				}
				$(id).find("select[id="+ex.key+"]").append(getVal);
			}
			if('' != ex.key && '' != ex.value){ 
				switch(ex.value){
				case '0':getVal = `<option value="0">投标保证金</option>`;break;
				case '1':getVal = `<option value="1">采购用款</option>`;break;
				case '2':getVal = `<option value="2">中标服务费</option>`;break;
				case '3':getVal = `<option value="3">购买标书</option>`;break;
				case '4':getVal = `<option value="4">报名费</option>`;break;
				case '5':getVal = `<option value="5">标书打印费</option>`;break;
				case '6':getVal = `<option value="6">其他保证金（含押金）</option>`;break;
				case '7':getVal = `<option value="7">劳务费</option>`;break;
				case '8':getVal = `<option value="8">退款</option>`;break;
				case '9':getVal = `<option value="9">工资或五险一金</option>`;break;
				case '10':getVal = `<option value="10">异地税金</option>`;break;
				case '11':getVal = `<option value="11">其他</option>`;break;
				
				}
				var json_certificate_method = [
				                               `<option value="0">投标保证金</option>`,
				                               `<option value="1">采购用款</option>`,
				                               `<option value="2">中标服务费</option>`,
				                               `<option value="3">购买标书</option>`,
				                               `<option value="4">报名费</option>`,
				                               `<option value="5">电子高新技术企业证书</option>`,
				                               `<option value="6">电子营业执照</option>`,
				                               `<option value="7">电子组织机构代码证</option>`,
				                               `<option value="8">电子税务登记证</option>`,
				                               `<option value="9">电子计算机信息系统集成企业资质证书</option>`,
				                               `<option value="10">电子安全生产许可证</option>`,
				                               `<option value="11">电子高新技术企业证书</option>`
				                               ];
				
				
				var tempCertificateArr =  getNewList(json_certificate_method,json_certificate_method[ex.value]) ; //除了已经选择的option 现在这些是剩下没选的option
				
				
				for(var i in tempCertificateArr){
					$(id).find("select[id="+ex.key+"]").append(tempCertificateArr[i]);
				} 
				$(id).find("option").click(function(){ 
					$(this).parent().attr("value",$(this).index());

				});
			}

		}
		
		
		
		if('company_name' === ex.key){//公司名称
			if('' == ex.value){ 
				getVal = getSeled(ex.enumeration_name);
				$(id).find("select[id="+ex.key+"]").append(getVal);
			}else{
				switch(ex.value){
				case '0':getVal = `<option value="0">飞利信电子</option>`;break;
				case '1':getVal = `<option value="1">飞利信科技</option>`;break;
				case '2':getVal = `<option value="2">子公司</option>`;break;

				
				
				
				}
				$(id).find("select[id="+ex.key+"]").append(getVal);
			}
			if('' != ex.key && '' != ex.value){ 
				switch(ex.value){
				case '0':getVal = `<option value="0">飞利信电子</option>`;break;
				case '1':getVal = `<option value="1">飞利信科技</option>`;break;
				case '2':getVal = `<option value="2">子公司</option>`;break;

				
				}
				
				var json_company_method = [
				                               `<option value="0">飞利信电子</option>`,
				                               `<option value="1">飞利信科技</option>`,
				                               `<option value="2">子公司</option>`,

				                               ];
				
				
				var tempCompanyArr =  getNewList(json_company_method,json_company_method[ex.value]) ; //除了已经选择的option 现在这些是剩下没选的option
				
				
				for(var i in tempCompanyArr){
					$(id).find("select[id="+ex.key+"]").append(tempCompanyArr[i]);
				} 
				$(id).find("option").click(function(){ 
					$(this).parent().attr("value",$(this).index());
				});
			}
		}
		if('stamper_purpose' === ex.key){//印章用途
			if('' == ex.value){ 
				getVal = getSeled(ex.enumeration_name);
				$(id).find("select[id="+ex.key+"]").append(getVal);
			}else{
				switch(ex.value){
				case '0':getVal = `<option value="0">销售合同</option>`;break;
				case '1':getVal = `<option value="1">采购合同</option>`;break;
				case '2':getVal = `<option value="2">澄清文件</option>`;break;
				case '3':getVal = `<option value="3">报名</option>`;break;
				case '4':getVal = `<option value="4">资格预审</option>`;break;
				case '5':getVal = `<option value="5">封标</option>`;break;
				case '6':getVal = `<option value="6">质疑函</option>`;break;
				case '7':getVal = `<option value="7">报价清单</option>`;break;
				case '8':getVal = `<option value="8">授权</option>`;break;
				case '9':getVal = `<option value="9">验收</option>`;break;
				case '10':getVal = `<option value="10">结算</option>`;break;
				case '11':getVal = `<option value="11">协议</option>`;break;
				case '12':getVal = `<option value="12">证明</option>`;break;
				case '13':getVal = `<option value="13">资质文件</option>`;break;
				case '14':getVal = `<option value="14">劳动合同</option>`;break;
				case '15':getVal = `<option value="15">介绍信</option>`;break;
				case '16':getVal = `<option value="16">其他</option>`;break;
				
				
				
				
				}
				$(id).find("select[id="+ex.key+"]").append(getVal);
			}
			if('' != ex.key && '' != ex.value){ 
				switch(ex.value){
				case '0':getVal = `<option value="0">销售合同</option>`;break;
				case '1':getVal = `<option value="1">采购合同</option>`;break;
				case '2':getVal = `<option value="2">澄清文件</option>`;break;
				case '3':getVal = `<option value="3">报名</option>`;break;
				case '4':getVal = `<option value="4">资格预审</option>`;break;
				case '5':getVal = `<option value="5">封标</option>`;break;
				case '6':getVal = `<option value="6">质疑函</option>`;break;
				case '7':getVal = `<option value="7">报价清单</option>`;break;
				case '8':getVal = `<option value="8">授权</option>`;break;
				case '9':getVal = `<option value="9">验收</option>`;break;
				case '10':getVal = `<option value="10">结算</option>`;break;
				case '11':getVal = `<option value="11">协议</option>`;break;
				case '12':getVal = `<option value="12">证明</option>`;break;
				case '13':getVal = `<option value="13">资质文件</option>`;break;
				case '14':getVal = `<option value="14">劳动合同</option>`;break;
				case '15':getVal = `<option value="15">介绍信</option>`;break;
				case '16':getVal = `<option value="16">其他</option>`;break;
				
				
				}
				
				var json_stamper_method = [
				                           `<option value="0">销售合同</option>`,
				                           `<option value="1">采购合同</option>`,
				                           `<option value="2">澄清文件</option>`,
				                           `<option value="3">报名</option>`,
				                           `<option value="4">资格预审</option>`,
				                           `<option value="5">封标</option>`,
				                           `<option value="6">质疑函</option>`,
				                           `<option value="7">报价清单</option>`,
				                           `<option value="8">授权</option>`,
				                           `<option value="9">验收</option>`,
				                           `<option value="10">结算</option>`,
				                           `<option value="11">协议</option>`,
				                           `<option value="12">证明</option>`,
				                           `<option value="13">资质文件</option>`,
				                           `<option value="14">劳动合同</option>`,
				                           `<option value="15">介绍信</option>`,
				                           `<option value="16">其他</option>`
				                           
				                           ];
				
				
				var tempStamperArr =  getNewList(json_stamper_method,json_stamper_method[ex.value]) ; //除了已经选择的option 现在这些是剩下没选的option
				
				
				for(var i in tempStamperArr){
					$(id).find("select[id="+ex.key+"]").append(tempStamperArr[i]);
				} 
				$(id).find("option").click(function(){ 
					$(this).parent().attr("value",$(this).index());
				});
			}
		}
		if('stamper_type' === ex.key){//印章使用类型
			if('' == ex.value){ 
				getVal = getSeled(ex.enumeration_name);
				$(id).find("select[id="+ex.key+"]").append(getVal);
			}else{
				switch(ex.value){
				case '0':getVal = `<option value="0">印章使用</option>`;break;
				case '1':getVal = `<option value="1">印章借用</option>`;break;
				}
				$(id).find("select[id="+ex.key+"]").append(getVal);
			}
			if('' != ex.key && '' != ex.value){ 
				switch(ex.value){
				case '0':getVal = `<option value="0">印章使用</option>`;break;
				case '1':getVal = `<option value="1">印章借用</option>`;break;
				}
				
				var json_stamper_type_method = [
				                           `<option value="0">印章使用</option>`,
				                           `<option value="1">印章借用</option>`
				                           
				                           ];
				
				
				var tempStamperTypeArr =  getNewList(json_stamper_type_method,json_stamper_type_method[ex.value]) ; //除了已经选择的option 现在这些是剩下没选的option
				
				
				for(var i in tempStamperTypeArr){
					$(id).find("select[id="+ex.key+"]").append(tempStamperTypeArr[i]);
				} 
				$(id).find("option").click(function(){ 
					$(this).parent().attr("value",$(this).index());
				});
			}
		}
		if('contr_type' === ex.key){//合同类型有问题  合同预算表
			if('' == ex.value){ 
				getVal = getSeled(ex.enumeration_name);
				$(id).find("select[id="+ex.key+"]").append(getVal);
			}else{
				switch(ex.value){
				case '0':getVal = `<option value="0">扫描版</option>`;break;
				case '1':getVal = `<option value="1">原件</option>`;break;
				}
				$(id).find("select[id="+ex.key+"]").append(getVal);
			}
			if('' != ex.key && '' != ex.value){ 
				switch(ex.value){
				case '0':getVal = `<option value="0">扫描版</option>`;break;
				case '1':getVal = `<option value="1">原件</option>`;break;
				}
				
				var json_contr_type_method = [
				                                `<option value="0">扫描版</option>`,
				                                `<option value="1">原件</option>`
				                                
				                                ];
				
				
				var tempContrTypeArr =  getNewList(json_contr_type_method,json_contr_type_method[ex.value]) ; //除了已经选择的option 现在这些是剩下没选的option
				
				
				for(var i in tempContrTypeArr){
					$(id).find("select[id="+ex.key+"]").append(tempContrTypeArr[i]);
				} 
				$(id).find("option").click(function(){ 
					$(this).parent().attr("value",$(this).index());
				});
			}
		}
		
		
	}
	
	
	//去除数组中的元素
	function getNewList(result, obj) {
	  var res = result;
	  var i = res.length;
	  while (i--) {
		if (res[i] == obj) {

		  res.splice(i, 1);
		}
	  }
	  return res;
	}
	  
	  
	//创建input radio
	function inputRadio(id,inp,ex){
		$(id).append(inp.radio);

		if(ex.name == "签约公司"){
 			var getValCate = getRadioCate(ex);
			$(id).find("div[id="+ex.key+"]").append(getValCate);
			return;
		}
		var getVal = getRadio(ex.enumeration_name);	

		$(id).find("div[id="+ex.key+"]").append(getVal);
		var proj_stage_name = document.getElementsByName("proj_stage");//项目阶段
		for(var i = 0 ; i < proj_stage_name.length;i++){
			if(ex.value == proj_stage_name[i].value){
				proj_stage_name[i].checked = true;
			}
		}
		var inten_dep_name = document.getElementsByName("inten_dep");//意向支持部门
		for(var i = 0 ; i < inten_dep_name.length;i++){
			if(ex.value == inten_dep_name[i].value){
				inten_dep_name[i].checked = true;
			}
		}
		var sign_company_name = document.getElementsByName("sign_company");//签约公司
		for(var i = 0 ; i < sign_company_name.length;i++){
			if(ex.value == sign_company_name[i].value){
				sign_company_name[i].checked = true;
			}
		}
		var proj_attribute_name = document.getElementsByName("proj_attribute");//项目属性
		for(var i = 0 ; i < proj_attribute_name.length;i++){
			if(ex.value == proj_attribute_name[i].value){
				proj_attribute_name[i].checked = true;
			}
		}
		var proj_type_name = document.getElementsByName("proj_type");//项目类型
		for(var i = 0 ; i < proj_type_name.length;i++){
			if(ex.value == proj_type_name[i].value){
				proj_type_name[i].checked = true;
			}
		}
		var contr_way_name = document.getElementsByName("contr_way");//合同方式
		for(var i = 0 ; i < contr_way_name.length;i++){
			if(ex.value == contr_way_name[i].value){
				contr_way_name[i].checked = true;
			}
		}

		var sign_company2_name = document.getElementsByName("sign_company2");//所借资质公司名称
		for(var i = 0 ; i < sign_company2_name.length;i++){
			if((ex.value == sign_company2_name[i].value) && (ex.key == 'cert_company_name')){
				sign_company2_name[i].checked = true;
			}
		}
		var cert_use_address_name = document.getElementsByName("cert_use_address");//资质使用地
		for(var i = 0 ; i < cert_use_address_name.length;i++){
			if((ex.value == cert_use_address_name[i].value) && (ex.key == 'cert_use_address')){
				cert_use_address_name[i].checked = true;
			}
		}
		var pack_type_name = document.getElementsByName("pack_type");//合同文件
		for(var i = 0 ; i < pack_type_name.length;i++){
			if((ex.value == pack_type_name[i].value) && (ex.key == 'contr_document')){
				pack_type_name[i].checked = true;
			}
		}
		var budget_type_name = document.getElementsByName("budget_type");//合同预算
		for(var i = 0 ; i < budget_type_name.length;i++){
			if((ex.value == budget_type_name[i].value) && (ex.key == 'contr_budget')){
				budget_type_name[i].checked = true;
			}
		}
		var tender_type_name = document.getElementsByName("tender_type");//投标文件
		for(var i = 0 ; i < tender_type_name.length;i++){
			if((ex.value == tender_type_name[i].value) && (ex.key == 'bid_doc')){
				tender_type_name[i].checked = true;
			}
		}
		var invite_type_name = document.getElementsByName("invite_type");//招标文件
		for(var i = 0 ; i < invite_type_name.length;i++){
			if((ex.value == invite_type_name[i].value) && (ex.key == 'cbid_doc')){
				invite_type_name[i].checked = true;
			}
		}
		var design_type_name = document.getElementsByName("design_type");//设计图
		for(var i = 0 ; i < design_type_name.length;i++){
			if((ex.value == design_type_name[i].value) && (ex.key == 'desi_drawing')){
				design_type_name[i].checked = true;
			}
		}
		var answer_type_name = document.getElementsByName("answer_type");//答疑文件
		for(var i = 0 ; i < answer_type_name.length;i++){
			if((ex.value == answer_type_name[i].value) && (ex.key == 'answ_file')){
				answer_type_name[i].checked = true;
			}
		}
		var yes_or_no_name = document.getElementsByName("yes_or_no");//后期是否签订合同
		for(var i = 0 ; i < yes_or_no_name.length;i++){
			if((ex.value == yes_or_no_name[i].value) && (ex.key == 'sign_contract')){
				yes_or_no_name[i].checked = true;
			}
		}
		var company_name_name = document.getElementsByName("company_name");//签约公司
		for(var i = 0 ; i < company_name_name.length;i++){
			if((ex.value == company_name_name[i].value) && (ex.key == 'company_name')){
				company_name_name[i].checked = true;
			}
		}
		var contr_source_type_name = document.getElementsByName("contr_source_type");//合同类型
		for(var i = 0 ; i < contr_source_type_name.length;i++){
			if((ex.value == contr_source_type_name[i].value) && (ex.key == 'contr_type')){
				contr_source_type_name[i].checked = true;
			}
		}
		var bill_type_name = document.getElementsByName("bill_type");//开票类型
		for(var i = 0 ; i < bill_type_name.length;i++){
			if((ex.value == bill_type_name[i].value) && (ex.key == 'bill_type')){
				bill_type_name[i].checked = true;
			}
		}
		var paym_method2_name = document.getElementsByName("paym_method2");//公司名称
		for(var i = 0 ; i < paym_method2_name.length;i++){
			if((ex.value == paym_method2_name[i].value) && (ex.key == 'paym_method')){
				paym_method2_name[i].checked = true;
			}
		}
		var auxiliary_invoice_name = document.getElementsByName("auxiliary_invoice");//附发票
		for(var i = 0 ; i < auxiliary_invoice_name.length;i++){
			if((ex.value == auxiliary_invoice_name[i].value) && (ex.key == 'auxiliary_invoice')){
				auxiliary_invoice_name[i].checked = true;
			}
		}
		var paym_method2_name = document.getElementsByName("paym_method2");//付款方式2
		for(var i = 0 ; i < paym_method2_name.length;i++){
			if((ex.value == paym_method2_name[i].value) && (ex.key == 'paym_method')){
				paym_method2_name[i].checked = true;
			}
		}
		var yes_or_noname = document.getElementsByName("yes_or_no");//采购清单
		for(var i = 0 ; i < yes_or_noname.length;i++){
			if((ex.value == yes_or_noname[i].value) && (ex.key == 'purc_detailed_list')){
				yes_or_noname[i].checked = true;
			}
		}
		var paym_method_name = document.getElementsByName("paym_method");//付款方式
		for(var i = 0 ; i < paym_method_name.length;i++){
			if((ex.value == paym_method_name[i].value) && (ex.key == 'paym_method')){
				paym_method_name[i].checked = true;
			}
		}
		var yes_or_noname2 = document.getElementsByName("yes_or_no");//付款方式
		for(var i = 0 ; i < yes_or_noname2.length;i++){
			if((ex.value == yes_or_noname2[i].value) && (ex.key == 'spec_brand_supplier')){
				yes_or_noname2[i].checked = true;
			}
		}
	}
	//创建input 时间选择
	function inputDates(id,inp,ex){ 
		$(id).append(inp.inputDate);
	}
	//创建 input checked  
	function inputCheck(id,inp,ex){
		$(id).append(inp.inputCheckBox);
		var chkVal = getCheck(ex);

		$(id).find(".main-con-"+ex.key).append(chkVal);  
		$(id).find(".main-con-"+ex.key).find("input[type=checkbox]").click(function(){
			$(this).parent().siblings().find("input[type=checkbox]").attr("checked",false);
			var v='';
			$(id).find(".main-con-"+ex.key).find("input[type=checkbox]:checked").each(function(){
				 v+= $(this).val()+",";
			});
			var reg=/,$/gi; 
				v=v.replace(reg,""); 
			$("#"+ex.key).val(v);   
		});

	}

	function input_items(id,inp,ex){
		//添加文件用
		function addFileBtn(ad){
			$(ad).append('<input id="file" type=file>');
		}
		

		
			$(id).append(inp.inputItems);
			var item_first_key = ex.list_items[0].key,
				item_first_name = ex.list_items[0].name,
				item_first_type = ex.list_items[0].type;


			//回款情况 那个追加功能组件
			if(item_first_key === "list_category" && item_first_name==="1" && item_first_type === "7"){ 
				var chi = ex.list_items;
				if(null != ex.value && "" != ex.value ){
					var tabDiv = $(ex.value);
					tabDiv.appendTo($(id).find(".main-con-"+ex.key));	
					$(id).find("#table_"+ex.key).before(`<div class="container"><div class="col-md-12 text-right" style="margin-bottom:10px;"><a href="javascript:;" class="label label-inverse-primary" onclick="AddHk('#tbody_${ex.key}');" >追加</a>&nbsp;&nbsp;&nbsp;<a class="label label-inverse-danger" href="javascript:;" onclick="DelHk('#tbody_${ex.key}');">删除</a></div></div>`);
					
					$("#"+ex.key).val(tabDiv.html());
					$("#clk_"+ex.key).hide();
				}else{	
					var tabDiv =$('<table id="table_'+ex.key+'" class="HK_append_table"></table>'); //table table-xs table-bordered
					var tabHead = $('<thead></thead>');
					var tabTR = $('<tr><th width="30"></th></tr>');
					var tabBody = $('<tbody class="tabTbody" id="tbody_'+ex.key+'"></tbody>');
					

					var tp  = ``;
					var tds_item=``;
					for(var i=0; i<chi.length;i++){
						//文本框
						if(chi[i].type === '0'){
							var money = "";
							if("reim_money_amount" == chi[i].key){
								money = "0";
							}
							tp += `<th id="input_${chi[i].key}_dynamicList1"> ${chi[i].name} </th> `; 	
							tds_item += `<td id="td_${chi[i].key}_dynamicList1"><input id="data_${chi[i].key}_dynamicList1" is_sum="${chi[i].is_sum}" return_value="${chi[i].return_value}" data-blurid="${ex.key}" class="form-control" type="text" value="${money}"/></td>`;
						}
						//下拉列表
						if(chi[i].type === '1'){
							tp += `<th id="input_${chi[i].key}_dynamicList1"> ${chi[i].name} </th> `;				
							var getVal = getSeled(chi[i].enumeration_name);
							tds_item += `<td id="td_${chi[i].key}_dynamicList1"><select id="data_${chi[i].key}_dynamicList1" data-blurid="${ex.key}" class="form-control" onchange="myOptionSelect(this)">`;
							tds_item +=getVal+`</select></td>`;						
						}
						//日期类型
						if(chi[i].type === '3'){
							tp += `<th id="input_${chi[i].key}_dynamicList1"> ${chi[i].name} </th> `; 
							tds_item += `<td id="td_${chi[i].key}_dynamicList1"><input id="data_${chi[i].key}_dynamicList1" data-blurid="${ex.key}" class="form-control" type="date" /></td>`;
						}
						//文本域
						if(chi[i].type === '10'){
							tp += `<th id="input_${chi[i].key}_dynamicList1"> ${chi[i].name} </th> `; 	
							tds_item += `<td id="td_${chi[i].key}_dynamicList1"><textarea id="data_${chi[i].key}_dynamicList1" is_sum="${chi[i].is_sum}" return_value="${chi[i].return_value}" data-blurid="${ex.key}" class="form-control"  style="height:230px;"></textarea></td>`;
						}						
					}

					var tds = $('<tr><td class="firstNum">1</td>'+tds_item+'</tr>');

					tabTR.append(tp);
					tabDiv.append(tabTR);
					tabHead.append(tabDiv);
					tabDiv.append(tabBody);   
					tabBody.append(tds);
					tabDiv.appendTo($(id).find(".main-con-"+ex.key));	
					$(id).find("#table_"+ex.key).before(`<div class="container"><div class="col-md-12 text-right" style="margin-bottom:10px;"><a href="javascript:;" class="label label-inverse-primary" onclick="AddHk('#tbody_${ex.key}');" >追加</a>&nbsp;&nbsp;&nbsp;<a class="label label-inverse-danger" href="javascript:;" onclick="DelHk('#tbody_${ex.key}');">删除</a></div></div>`);
					$("#"+ex.key).val(tabDiv.html());
					$("#clk_"+ex.key).hide();

				}
			}


			//项目投标成本
			if(item_first_key === "list_category" && item_first_name==="2" && item_first_type === "7"){ 
				var domDiv =  $(`<div id="sub_${ex.key}" style="border: 1px dashed  #b5b5b5;padding: 10px;"></div>`);
				var tpls = ``;
				var chn = ex.list_items;
				var temppath;
				for(var i=0; i<chn.length;i++){
					if(i>0){
					if(chn[i].type === '0'){
							if(chn[i].value === undefined){
								tpls += `
								<div class="form-group row">
					                <div class="col-sm-2 col-form-label text-right"><label for="input_${chn[i].key}"> ${chn[i].name}</label></div>
					                <div class="col-xs-10"><input id="${chn[i].key}"   for="input_${chn[i].key}" type="text" name="${chn[i].key}"/> </div>
					            </div>
					                `;  
							}else{
								tpls += `
								<div class="form-group row">
					                <div class="col-sm-2 col-form-label text-right"><label for="input_${chn[i].key}"> ${chn[i].name}</label></div>
					                <div class="col-xs-10"><input id="${chn[i].key}"   for="input_${chn[i].key}" type="text" name="${chn[i].key}" value="${chn[i].value}"/> </div>
					            </div>
					                `;  
							}
						}	
					}
					//支付方式的
					if(chn[i].type === '2'){
						if(chn[i].value === undefined){
							tpls += `
							<div class="form-group row">
				                <div class="col-sm-2 col-form-label text-right"><label for="input_${chn[i].key}"> ${chn[i].name}</label></div>
				                <div class="col-xs-10"><input id="${chn[i].key}"   for="input_${chn[i].key}" type="text" name="${chn[i].key}"/> </div>
				            </div>
				                `;  
						}else{
							tpls += `
							<div class="form-group row">
				                <div class="col-sm-2 col-form-label text-right"><label for="input_${chn[i].key}"> ${chn[i].name}</label></div>
				                <div class="col-xs-10"><input id="${chn[i].key}"   for="input_${chn[i].key}" type="text" name="${chn[i].key}" value="${chn[i].value}"/> </div>
				            </div>
				                `;  
						}
					}

					if(chn[i].type === '4'){  
						//如果是施工成本里的 
						if(chn[i].key === 'bc_construction_cost'){
							var ai;
							var build;
							var fire;
							var other;
							var othertext;
							var otherinput;
							if(undefined != chn[i].value &&	 '' != chn[i].value && null != chn[i].value){
								if(chn[i].value.indexOf(",") != -1){
									var arr  = chn[i].value.split(',');
									if(arr[0] == '0'){
										ai =`<input name="bc_construction_cost" type="radio" style="width: 20px; height: 20px; margin-top: -5px" title="智能会议音视频工程：8% " value="0" checked="checked"/>`;
									}else{
										ai = `<input name="bc_construction_cost" type="radio" style="width: 20px; height: 20px; margin-top: -5px" title="智能会议音视频工程：8% " value="0"/>`;
									}
									
									if(arr[0] == '1'){
										build = `<input value="1" name="bc_construction_cost" type="radio" style="width: 20px; height: 20px; margin-top: -5px" title="建筑智能化工程、轨道交通工程（指综合监控、电力监控、环境监控、安防系统）：12%" checked="checked"/>`;
									}else{										
										build = `<input value="1" name="bc_construction_cost" type="radio" style="width: 20px; height: 20px; margin-top: -5px" title="建筑智能化工程、轨道交通工程（指综合监控、电力监控、环境监控、安防系统）：12%"/>`;
									}
									if(arr[0] == '2'){
										fire = `<input  value="2" name="bc_construction_cost" type="radio" style="width: 20px; height: 20px; margin-top: -5px" title="消防工程、机电安装工程：25% ;平安城市工程：25% " checked="checked"/>`;
									}else{
										fire = `<input value="2" name="bc_construction_cost" type="radio" style="width: 20px; height: 20px; margin-top: -5px" title="消防工程、机电安装工程：25% ;平安城市工程：25% "/>`;
									}
									if(arr[0] == '3' ){
										other = `<input checked="checked" name="bc_construction_cost" type="radio" style="width: 20px; height: 20px; margin-top: -5px" title="其它 " value="${arr[0]}"/>`;
										othertext = `<span><input  type="text" name="bc_construction_cost" style="width: 60px; height: 20px;" title="其它" value="${arr[1]}" />%</span>`;
										otherinput =`<input  type="text" name="bc_construction_cost" style="width: 150px;" title="请输入选择其它的原因"  onfocus="if (value =='请输入选择其它的原因'){value =''}" onblur="if (value ==''){value='请输入选择其它的原因'}" value="${arr[2]}" />`;
									}else{
										othertext = `<span><input  type="text" name="bc_construction_cost" style="width: 40px; height: 20px;" title="其它"/>%</span>`;
										otherinput =`<input  type="text" name="bc_construction_cost" style="width: 170px;" title="请输入选择其它的原因" value="请输入选择其它的原因" onfocus="if (value =='请输入选择其它的原因'){value =''}" onblur="if (value ==''){value='请输入选择其它的原因'}"/>`;
										other = `<input name="bc_construction_cost" type="radio" style="width: 20px; height: 20px; margin-top: -5px" title="其它 " value="3"/>`;
									}
								}
							}else{
								ai = `<input name="bc_construction_cost" type="radio" style="width: 20px; height: 20px; margin-top: -5px" title="智能会议音视频工程：8% " value="0"/>`;
								build = `<input value="1" name="bc_construction_cost" type="radio" style="width: 20px; height: 20px; margin-top: -5px" title="建筑智能化工程、轨道交通工程（指综合监控、电力监控、环境监控、安防系统）：12%"/>`;
								fire = `<input value="2" name="bc_construction_cost" type="radio" style="width: 20px; height: 20px; margin-top: -5px" title="消防工程、机电安装工程：25% ;平安城市工程：25% "/>`;
								othertext = `<span><input  type="text" name="bc_construction_cost" style="width: 40px; height: 20px;" title="其它"/>%</span>`;
								otherinput =`<input  type="text" name="bc_construction_cost" style="width: 170px;" title="请输入选择其它的原因" value="请输入选择其它的原因" onfocus="if (value =='请输入选择其它的原因'){value =''}" onblur="if (value ==''){value='请输入选择其它的原因'}"/>`;
								other = `<input name="bc_construction_cost" type="radio" style="width: 20px; height: 20px; margin-top: -5px" title="其它 " value="3"/>`;
							}

							tpls+=`
							<div class="form-group row">
							<div class="col-sm-2 col-form-label text-right">
							<label>${chn[i].name}</label> 
							</div>

							<div class="col-xs-10">
								<div style="width: 60px; display: inline-table;">									
									${ai}
									<label style="width: 30px; float: right;" for="bc_construction_cost">
										8%
									</label>
								</div>
								<div style="width: 60px; display: inline-table;">
								${build}
									<label style="width: 30px; float: right;" for="bc_construction_cost">
										12%
									</label>
								</div>
								<div style="width: 60px; display: inline-table;">
								${fire}
									<label style="width: 30px; float: right;" for="bc_construction_cost">
										25%
									</label>
								</div>
								<div style="width: 150px; display: inline-table;">
								${other}
									<label style="width: 130px; float: right;" for="bc_construction_cost">
										其它
										${othertext}
									</label>
								</div>
								<div style="width: 150px; display: inline-table;">
									${otherinput}
								</div>
								</div>
							</div>
								`;
						}
						if(chn[i].key === 'bc_dl_equipment_cost' ){
							

							
							temppath = chn[i].key;
							var jtpl = ``; 
							var arrK = chn[i].value;
							if (!!arrK) {
								if('' != arrK){
									if(typeof(arrK == 'string')){
										if(arrK.indexOf(',') != -1){
											arrK = arrK.split(',');
											if(arrK.length > 0){
												for(var k = 0;k<arrK.length-1;k++){
													jtpl+=`<li class="jFiler-item fileItem" data-jfiler-index="${k}">
															<div class="jFiler-item-container">
																<div class="jFiler-item-inner">
																	<div class="jFiler-item-icon pull-left"><i class="icon-jfi-file-o jfi-file-type-image jfi-file-ext-png"></i></div>
																	<div class="jFiler-item-info pull-left">
																		<a target="_blank" href="/flxoa/formtemplate/filedownload?fileRealName=${arrK[k]}"><div class="jFiler-item-title" title="${arrK[k]}">${arrK[k]}</a>
																	</div>
																</div>
															</div>
														 </li>`; 
												} 
											}
											
										
										}
									}else{
										jtpl+=`<li class="jFiler-item fileItem" data-jfiler-index="${k}">
										<div class="jFiler-item-container">
											<div class="jFiler-item-inner">
												<div class="jFiler-item-icon pull-left"><i class="icon-jfi-file-o jfi-file-type-image jfi-file-ext-png"></i></div>
												<div class="jFiler-item-info pull-left">
													<a target="_blank" href="/flxoa/formtemplate/filedownload?fileRealName=${arrK}"><div class="jFiler-item-title" title="${arrK}">${arrK}</a>
												</div>
											</div>
										</div>
									 </li>`; 
									} 
									 
									
								}
							}


						if(domDiv.find(".fileItem").length <1){
							domDiv.append('<div class="jFiler-items jFiler-row">'+jtpl+'</div>');
							tpls += `
							<div class="form-group row"> 
								<div class="col-sm-2 col-form-label text-right"><label>${chn[i].name}</label> </div>
								<div class="col-xs-10">
								<input type="hidden" id="${chn[i].key}" name="${chn[i].key}"></input>
				                <input type="file" name="files[]" data-keys="${chn[i].key}" id="filer_input_${chn[i].key}"  class="filer_input" multiple="multiple" style="position: absolute; left: -9999px; top: -9999px; z-index: -9999;"/>
				            </div>    
				            </div>
				                `;  
							}
						}
						
						
						
						
						
					}
					

					//红色 提示字
					if(chn[i].type === '6'){
						tpls+=`<div class="form-group row"> 
										<div class="col-sm-12 col-form-label"><label style="color:red;">${chn[i].name}</label></div>
							 </div>`;
					} 
					
					
				}
				domDiv.append(tpls);
				domDiv.appendTo($(id).find(".main-con-"+ex.key));	
				showUploadFun("filer_input_"+temppath);	
			}


		for(var i=0; i<ex.list_items.length;i++){
			console.log(ex.list_items);
			var item_key = ex.list_items[i].key;
			var item_name = ex.list_items[i].name;
			var item_type = ex.list_items[i].type;
			var item_value = ex.list_items[i].value;

			//金额大小写
			if(item_key === "list_category" && item_name==="2"){ 
				// if(item_key === "money_capital" && item_name=="大写"){ 
				// 	$(id).find(".main-con-"+ex.key).append(`<div class="col-xs-6">${item_name}<input class="form-control" id="${item_key}" type="text" name="${item_key}"></div>`);
				// }
				// if(item_key === "money_capital" && item_name=="小写"){ 

				// }
			}

			//需要 列表弹出的地方
			if(item_key === "list_category" && item_name==="1"){ 
				//添加报销的
				$(id).find(".main-con-"+ex.key).append(`<a href='javascript:;' id="clk_${ex.key}" class='btn btn-primary btn-mini' onclick=popLayer('添加事项','${ex.key}',['640px','480px'],'/flxoa/approve/gotoexpenseaccount');>${ex.name}</a>`);
				//项目投标成本
				
				//判断 是回款类型的  把弹出层按钮隐藏。
				if(item_first_key === "list_category" && item_first_name==="1" && item_first_type === "7"){
					$("#clk_"+ex.key).hide();
				}
				//报销业务申请的
				// $(id).find(".main-con-"+ex.key).append(`<a href='javascript:;' class='btn btn-primary btn-mini' onclick=popLayer('添加业务招待','${ex.key}',['640px','480px'],'/flxoa/approve/gotobusinesshospitality');>${ex.name}</a>`);
				
			}

			
			//查看附件的时候，只读模式
			if(item_key === "list_category" && item_name==="0"){
				var jtpl = ``; 
				var arrK = ex.value;
				//此条件为  上传附件插件   新增的时候  
				if(!!!type){ 
					var htpl =`
					<input type="file" name="files[]" data-keys="${ex.key}" id="filer_input_${ex.key}" data-func="fileUpload('filer_input_${ex.key}','${ex.key}')" class="filer_input" multiple="multiple" style="position: absolute; left: -9999px; top: -9999px; z-index: -9999;">`;
					 $(id).find(".main-con-"+ex.key).append(htpl);
					 showUploadFun("filer_input_"+ex.key);
				} 

				if (!!arrK) {
					if(typeof(arrK == 'string')){
						if(arrK.indexOf(',') != -1){
							arrK = arrK.split(',');
							if(arrK.length > 0){
								for(var k = 0;k<arrK.length-1;k++){
									jtpl+=`<li class="jFiler-item" data-jfiler-index="${k}">
											<div class="jFiler-item-container">
												<div class="jFiler-item-inner">
													<div class="jFiler-item-icon pull-left"><i class="icon-jfi-file-o jfi-file-type-image jfi-file-ext-png"></i></div>
													<div class="jFiler-item-info pull-left">
														<a target="_blank" href="/flxoa/formtemplate/filedownload?fileRealName=${arrK[k]}"><div class="jFiler-item-title" title="${arrK[k]}">${arrK[k]}</a>
													</div>
												</div>
											</div>
										 </li>`; 
								} 
							}
							
						
						}
					}else{
						jtpl+=`<li class="jFiler-item" data-jfiler-index="${k}">
						<div class="jFiler-item-container">
							<div class="jFiler-item-inner">
								<div class="jFiler-item-icon pull-left"><i class="icon-jfi-file-o jfi-file-type-image jfi-file-ext-png"></i></div>
								<div class="jFiler-item-info pull-left">
									<a target="_blank" href="/flxoa/formtemplate/filedownload?fileRealName=${arrK}"><div class="jFiler-item-title" title="${arrK}">${arrK}</a>
								</div>
							</div>
						</div>
					 </li>`; 
					}
					$(id).find(".main-con-"+ex.key).append('<div class="jFiler-items jFiler-row">'+jtpl+'</div>'); 
				}
				
			} 
			//此条件为  时间区段选择   新增的时候
			if(item_key === "start_time" && item_name=="开始时间" && (type === undefined || "" == type)){ 			
				// //修改
				// if(null != item_value && "" != item_value ){
					// $(id).find("#"+item_key).attr("class","col-md-3 form-control").attr("type","date").val(item_value);
				// }else{
					// $(id).find("#"+item_key).attr("class","col-md-3 form-control").attr("type","date");
				// }
				//修改
				if(null != item_value && "" != item_value ){
					$(id).find("#"+ex.key).before(`<input id="${item_key}" type="date" class="col-md-3 form-control"  name="${item_key}" value="${item_value}"/>`);
				}else{
					$(id).find("#"+ex.key).before(`<input id="${item_key}" type="date" class="col-md-3 form-control"  name="${item_key}" />`);							
				}					
			}
			if(item_key === "start_time" && item_name=="开始时间" && type === 'look'){ 
//				$(id).find("#"+item_key).attr("class","col-md-3 form-control").attr("readonly","readonly").val(item_value); 
				$(id).find("#"+ex.key).before(`<input id="${item_key}" type="date" class="col-md-3 form-control"  name="${item_key}" value="${item_value}"/>`);
				$(id).find("#"+item_key).attr("readonly","readonly"); 			 
			}
			if(item_key === "end_time" && item_name=="结束时间" && (type === undefined || "" == type)){ 
				//修改
				if(null != item_value && "" != item_value ){
					$(id).find(".main-con-"+ex.key).append(`<input id="${item_key}" type="date" class="col-md-3 form-control"  name="${item_key}" value="${item_value}"/>`);
				}else{
					$(id).find(".main-con-"+ex.key).append(`<input id="${item_key}" type="date" class="col-md-3 form-control"  name="${item_key}" />`);							
				}	 
			}
			if(item_key === "end_time" && item_name=="结束时间" && type === 'look'){ 
				$(id).find(".main-con-"+ex.key).append(`<input id="${item_key}" type="date" class="col-md-3 form-control"  name="${item_key}" value="${item_value}"/>`);
				$(id).find("#"+item_key).attr("readonly","readonly"); 
			}


		} 
		if(ex.key === ""){}
	}

	//创建点击增加一行的那种 Item 
	function buildItem(id,inp,ex){
		var Tmp;
		// $(id)
		
	}


	//上传文件
	function showUploadFun(dom){
		var path = '';

        $("#"+dom).filer({
				    limit: 100,
				    maxSize: 100, 
				    changeInput: true,
				    showThumbs: true, 
				    captions:{
					    button: "选择文件",
					    feedback: "选择要上传的文件",
					    feedback2: "选择文件",
					    drop: "拖拽到这里进行上传",
					    removeConfirmation: "确实要删除此文件吗？",
					    errors: {
					        filesLimit: "只允许 {{fi-limit}} 个文件上传.",
					        filesType: "只允许图片类进行上传",
					        filesSize: "{{fi-name}} 文件超过 {{fi-maxSize}} MB.",
					        filesSizeAll: "文件过大 {{fi-maxSize}} MB."
					    }
					},
			        uploadFile: {  
			            url: '/flxoa/formtemplate/fileupload',   
			            data: {},  
			            type: 'POST',  
			            enctype: 'multipart/form-data',  
			            success: function(data, el){
							var s = decodeURIComponent(data);
							s = eval(s);
							var id = dom.substr(12);
							for(var i = 0 ; i < s.length;i++){
								path+=s[i].fileRealName+',';
							}
							$("#"+id).val(path);
			            }
			        }
		 }); 
	}

	//说明信息
	function inputInfoArea(id,inp,ex){
		$(id).append(inp.infoArea); 
	}

	//创建项目弹出列表
    function inputDetial(id,inp,ex){

        $(id).append(inp.detailList); 
        $(id).find("input[id="+ex.key+"]").on('click',function(){  
        	var tmpval = $("[name=templateId]").val();
        	var url = "/flxoa/approve/gotoprojectinfo?returnVal="+ex.return_value+"&templateid="+tmpval;
        	popLayer(tit,ex.key,['640px', '480px'],url);
            var returnValue = ex.return_value;  //获取弹出层之后 点击项目之后 success的值 都要赋予谁。

            var html_tmp = getTab_data(ex.key);
            $("#"+ex.key).append(html_tmp); 
        }); 


    } 
    //创建销售人员弹出列表
    function inputmarkmanage(id,inp,ex){
    	
    	$(id).append(inp.detailList); 
    	$(id).find("input[id="+ex.key+"]").on('click',function(){  
    		var tmpval = $("[name=templateId]").val();
    		var url = "/flxoa/gotomarketingmanager?returnVal="+ex.return_value+"&templateid="+tmpval;
    		popLayer(tit,ex.key,['640px', '480px'],url);
    		var returnValue = ex.return_value;  //获取弹出层之后 点击项目之后 success的值 都要赋予谁。
    		var html_tmp = getTab_data(ex.key);
    		$("#"+ex.key).append(html_tmp); 
    	}); 
    	
    } 
    //创建甲方名称弹出列表
    function inputfirstparty(id,inp,ex){
    	
    	$(id).append(inp.detailList); 
    	$(id).find("input[id="+ex.key+"]").on('click',function(){  
    		var tmpval = $("[name=templateId]").val();
    		var url = "/flxoa/gotoapprovalProjectManage?returnVal="+ex.return_value+"&templateid="+tmpval;
    		popLayer(tit,ex.key,['640px', '480px'],url);
    		var returnValue = ex.return_value;  //获取弹出层之后 点击项目之后 success的值 都要赋予谁。
    		var html_tmp = getTab_data(ex.key);
    		$("#"+ex.key).append(html_tmp); 
    	}); 
    	
    } 

    
    //生成 hidden 控件  
    function inputHidden(id,inp,ex){ 
			$(id).append(`<input type="hidden" id="${ex.key}" name="${ex.key}" value='${ex.value}'>`);
    }

    //获取 详细列表内容
    function getTab_data(query){
        var res = ''; 
        return res;
    }

    //获取checked
	function getCheck(ex){
		var check_item="";
		$.ajax({
				url:'/flxoa/approve/getenumeration',
				type : "post",
				data : {enumerationName:ex.enumeration_name},
				async:false,
				dataType:"json",
				success:function(data){ 
					//按不同的分组 进行 创建div  虽然写的比较low  但是快，能用 稳定。
					var grop = $('<div class="ckgrop"></div>')
					var chkDiv_1 = $('<ul class="ckList"></ul>');
					var chkDiv_2 = $('<ul class="ckList"></ul>');
					var chkDiv_3 = $('<ul class="ckList"></ul>');
					for(var i=0; i<data.length; i++){
						var desc = data[i].enumerationDescription;
						//修改或者查看
						if(null != ex.value && "" != ex.value){
							if(-1 != ex.value.indexOf(",")){
								var temp = ex.value.split(",");
								var flag = false;
								for(var j=0;j<temp.length;j++){
									if(data[i].enumerationKey == temp[j]){
										flag = true;
										//有被选择属性
										check_item= `<input type="checkbox" name="${data[i].enumerationKey}" value="${data[i].enumerationKey}" checked="checked"/>${data[i].enumerationValue} &nbsp;`; 
									}									
								}
								if(!flag){
									//无被选择属性
									check_item= `<input type="checkbox" name="${data[i].enumerationKey}" value="${data[i].enumerationKey}" />${data[i].enumerationValue} &nbsp;`; 
								}
							}else{
								if(data[i].enumerationKey == ex.value){
									//有被选择属性
									check_item= `<input type="checkbox" name="${data[i].enumerationKey}" value="${data[i].enumerationKey}" checked="checked"/>${data[i].enumerationValue} &nbsp;`; 
								}else{
									//无被选择属性
									check_item= `<input type="checkbox" name="${data[i].enumerationKey}" value="${data[i].enumerationKey}" />${data[i].enumerationValue} &nbsp;`; 
								}
							}
						}else{
							//无被选择属性
							check_item= `<input type="checkbox" name="${data[i].enumerationKey}" value="${data[i].enumerationKey}" />${data[i].enumerationValue} &nbsp;`; 
						}				
						if(desc.indexOf("1")>0){	
							chkDiv_1.append(check_item);
						}
						if(desc.indexOf("2")>0){
							chkDiv_2.append(check_item);
						}
						if(desc.indexOf("3")>0){
							chkDiv_3.append(check_item);
						}  
					} 

					grop.append(chkDiv_1).append(chkDiv_2).append(chkDiv_3);
					check_item = grop.html();
				}
		});  
		return check_item;
	}

	//获取seled的val
	function getSeled(ex){	
		var radio_item="";
		
		$.ajax({
				url:'/flxoa/approve/getenumeration',
				type : "post",
				data : {enumerationName:ex},
				async:false,
				dataType:"json",
				success:function(data){
					for(var i=0; i<data.length; i++){
						radio_item+= `<option value="${data[i].enumerationKey}">${data[i].enumerationValue}</option>`; 
					}
				}
		});  

		return radio_item;
	}
	//获取单选集合的val
	function getRadio(ex){
		// $.ajax
		var v= "";
		$.ajax({
				url:'/flxoa/approve/getenumeration',
				type : "post",
				data : {enumerationName:ex},
				async:false,
				dataType:"json",
				success:function(data){
					for(var i=0; i<data.length; i++){ 
		v+= `<label class="radio"><input type="radio" name="${data[i].enumerationName}" value="${data[i].enumerationKey}">${data[i].enumerationValue}</label> `;
					} 
				}
		});  
	return v;
	}

	//获取单选集合的val
	function getRadioCate(ex){ 


		
		var template="";
		var v= "";
		var cate_1 = "";
		$.ajax({
				url:'/flxoa/approve/getenumeration',
				type : "post",
				data : {enumerationName:ex.key},
				async:false,
				dataType:"json",
				success:function(data){    
				for(var i=0; i<data.length; i++){ 
						if(i<2){   //电子公司  科技公司 
							cate_1+=`<label class="radio"><input onclick="changSelect('${ex.key}')" type="radio" name="${data[i].enumerationName}" value="${data[i].enumerationKey}">${data[i].enumerationValue}</label> `;
						}else{     //分公司 
							v+=  `<option value="${data[i].enumerationKey}">${data[i].enumerationValue}</option>`; 	
						}
					} 
				}
		}); 

		var childGS = `<div id="chren_${ex.key}"><input id="chrenRi_${ex.key}" onclick="chrenSelect('${ex.key}')" type="radio" /> <select  id="chrenSel_${ex.key}"><option> &nbsp;</option></select>子公司</div>`;  //子公司 
		template = `<div id="rio_${ex.key}"> ${cate_1}</div><div><input id="selRi_${ex.key}" type="radio" onclick="disaSelect('${ex.key}')" /> <select id="sel_${ex.key}">${v}</select>分公司</div>`;
		return template+childGS;
	}




for(var i=0; i<exp.length; i++){ 
	var inp = pkgInput(exp[i],type);
	switch  (exp[i].type){

		case "0": 
		inputText(id,inp,exp[i]);   
		break;
		case "1":
		inputSelect(id,inp,exp[i]);
		break;
		case "2":
		inputRadio(id,inp,exp[i]);
		break;
		case "3":
		inputDates(id,inp,exp[i]); 
		break;
		case "4":
		input_items(id,inp,exp[i]); //附件
		break;
		case "5":
        inputDetial(id,inp,exp[i]);//详细信息 
        break;
        case "6":
        inputInfoArea(id,inp,exp[i]); //文本域
        break;
        case "7":
        inputHidden(id,inp,exp[i]);
        break;
        case "8":
        inputCheck(id,inp,exp[i]);
        break;
        case "9":
        inputmarkmanage(id,inp,exp[i]);//销售经理
        break;
        case "10":
    	inputfirstparty(id,inp,exp[i]);//甲方名称
    	break;

	} 


		//0：用户名  1：部门  2：当前时间
		var userInfo = sessionStorage.userinfo;
		userInfo = JSON.parse(userInfo);  
		if(exp[i].binding_data == "0"){
			if(!!userInfo){
				$("#"+exp[i].key).attr("readonly","readonly").attr("value",userInfo.realName);	
			}
		}

		if(exp[i].binding_data == "1"){
			if(!!userInfo){
				$("#"+exp[i].key).attr("readonly","readonly").attr("value",userInfo.departmentName);	
			}
		}

		if(exp[i].binding_data == "2"){
			if(!!userInfo){
				var today = new Date();
				$("#"+exp[i].key).attr("readonly","readonly").attr("value",today.format("yyyy-MM-dd"));	
			}
		}

		//属性为不可编辑
		if(exp[i].iseditable == "0"){
			$("#"+exp[i].key).attr("readonly","readonly");	
		}	

}	



} 

Date.prototype.format = function(fmt) {   
     var o = {   
        "M+" : this.getMonth()+1,                 //月份   
        "d+" : this.getDate(),                    //日   
        "h+" : this.getHours(),                   //小时   
        "m+" : this.getMinutes(),                 //分   
        "s+" : this.getSeconds(),                 //秒   
        "q+" : Math.floor((this.getMonth()+3)/3), //季度   
        "S"  : this.getMilliseconds()             //毫秒   
    };   
    if(/(y+)/.test(fmt)) {  
            fmt=fmt.replace(RegExp.$1, (this.getFullYear()+"").substr(4 - RegExp.$1.length));   
    }  
     for(var k in o) {  
        if(new RegExp("("+ k +")").test(fmt)){  
             fmt = fmt.replace(RegExp.$1, (RegExp.$1.length==1) ? (o[k]) : (("00"+ o[k]).substr((""+ o[k]).length)));  
         }  
     }  
    return fmt;   
}  
