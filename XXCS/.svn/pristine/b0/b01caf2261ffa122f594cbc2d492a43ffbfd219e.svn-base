/*****************************************公共方法  开始*****************************************/
//设置json数据到dom对象
var appSystem={
    setJsonDataToDom:function(domId,jsonData,domCon){
        var reg=/{{[0-9a-zA-Z]+}}/g;
        var arr=domCon.match(reg);
        var dom="";
        if(jsonData instanceof Array){
            for(var i=0;i<jsonData.length;i++){
                var newdomCon=domCon;
                for(var j=0;j<arr.length;j++){
                    //var arr[j]={{saleId}};
                    var param=arr[j].substring(2,arr[j].length-2);
                    var paramval=jsonData[i][param];
                    newdomCon=newdomCon.replace(arr[j],paramval);
                };
                dom=dom+newdomCon;
            };
        }else{
            var newdomCon=domCon;
            for(var j=0;j<arr.length;j++){
                //var arr[j]={{saleId}};
                var param=arr[j].substring(2,arr[j].length-2);
                var paramval=jsonData[param];
                newdomCon=newdomCon.replace(arr[j],paramval);
            };
            dom=dom+newdomCon;
        };
        var obj=document.getElementById(domId);
        //alert(dom);
        obj.innerHTML=dom;
    }
};
/*****************************************公共方法  结束*****************************************/