//表格-多选框点击事件【公共方法】
/*function tableCheckbox(tableEle){
	$(tableEle).each(function(){
	    var thCheckbox = $(this).find("thead tr th span");
	    var tdCheckbox = $(this).find("tbody tr td span");
	    var tdEle = $(this).find("tbody td");
	    var dataLength = $(this).find("tbody tr").length;
	    thCheckbox.click(function(){
	        if($(this).hasClass("selected")){
	            $(this).removeClass("selected");
	            tdCheckbox.removeClass("selected");
	        }else{
	            $(this).addClass("selected");
	            tdCheckbox.addClass("selected");
	        };
	    });
	    tdCheckbox.click(function(){	    	
	        if($(this).hasClass("selected")){
	            $(this).removeClass("selected");
	        }else{
	            $(this).addClass("selected");
	        };
	        var selectedLength = tdEle.find("span.selected").length;
	        if(dataLength === selectedLength){
	            thCheckbox.addClass("selected");
	        }else{
	            thCheckbox.removeClass("selected");
	        };
	    });
	});
};*/
function tableCheckbox(dom){
	var chk = $(dom).find(".checkbox");
	//var chk_all = $(dom).find(".checkbox:not(:first)");
		//chk_all.unbind().click({isFirst:"yes",table:dom},check);
		chk.eq(0).unbind().click({isFirst:"no",table:dom},check);
};

function checkChild(obj,dom,index){ 
	var this_  = $(obj),selval = this_.hasClass("selected"); 
	if(selval){
		//更新页面选择框class
		check_arr1(this_);
		//更新 datatable 选择框class
		var checkHtml = $(dom).DataTable().cell(index,0).data();
		//定义正则表达式 selected全部替换为空
		var re = new RegExp("selected","g"); 
		checkHtml = checkHtml.replace(re,"");
		$(dom).DataTable().cell(index,0).data(checkHtml).draw(false);
	}
	else{
		//更新页面选择框class
		check_arr2(this_);
		//更新 datatable 选择框class
		var checkHtml = $(dom).DataTable().cell(index,0).data();
		checkHtml = checkHtml.replace("checkbox","checkbox selected");
		$(dom).DataTable().cell(index,0).data(checkHtml).draw(false);
	}	
}

function check(e){ 
	var this_  = $(this),selval = this_.hasClass("selected"); 
	if(selval){
		check_arr1(this_);
		var dom = e.data.table;
		var chk_all = $(dom).find(".checkbox:not(:first)");
		//更新页面选择框class
		checkAll(chk_all,false);
		//更新 datatable 选择框class
		var i = 0
		for(i;i<chk_all.length;i++){
			//更新 datatable 选择框class
			var checkHtml = chk_all.eq(i).parent().html();
			//定义正则表达式 selected全部替换为空
			var re = new RegExp("selected","g"); 
			checkHtml = checkHtml.replace(re,"");
			//根据页面序号得出datatable 对应行的索引
			var index = chk_all.eq(i).parent().next().find(".em-number").eq(0).html() - 1;
			$(dom).DataTable().cell(index,0).data(checkHtml).draw(false);			
		}
	}
	else{
		check_arr2(this_);
		var dom = e.data.table;
		var chk_all = $(dom).find(".checkbox:not(:first)");
		//更新页面选择框class
		checkAll(chk_all,true);
		//更新 datatable 选择框class
		var i = 0
		for(i;i<chk_all.length;i++){
			//更新 datatable 选择框class
			var checkHtml = chk_all.eq(i).parent().html();
			checkHtml = checkHtml.replace("checkbox","checkbox selected");
			//根据页面序号得出datatable 对应行的索引
			var index = chk_all.eq(i).parent().next().find(".em-number").eq(0).html() - 1;
			$(dom).DataTable().cell(index,0).data(checkHtml).draw(false);			
		}		
	}	
}
function checkAll(chk_all,flag){ 
	if(flag){
		chk_all.addClass("selected");
	}else{
		chk_all.removeClass("selected");
	}
}	
function check_arr1(this_){ this_.removeClass("selected");}
function check_arr2(this_){ this_.addClass("selected");}  	
//单选按钮checked状态切换【公共方法】
$(".form-radio").each(function(){
    $(this).find(".radio label input").on("click",function(){
        $(this).attr("checked",true);
        $(this).parents(".radio").siblings().find("label input").attr("checked",false);
    });
});


//操作按钮悬浮文字提示效果【公共方法】
function selfTips(obj,txt){    
   	$(document).on("mouseover",obj,function(){            
        layer.tips(txt,this,{
            tips: [1, "#222"],
            time: 2000
        });
    });
};