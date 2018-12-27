/*弹出层的上传附件函数*/
    function showUplaod(dom){
        if($(".jFiler-input-dragDrop").length > 0){
              $(".jFiler-input-dragDrop").remove();
        }

        $(dom).filer({
            changeInput: '<div class="jFiler-input-dragDrop"><div class="jFiler-input-inner"><div class="jFiler-input-icon"><i class="icon-jfi-folder"></i></div><div class="jFiler-input-text"><h3>点击选择文件</h3></div></div></div>',
            showThumbs: true,
            theme: "dragdropbox",
            templates: {
                box: '<ul class="jFiler-items-list jFiler-items-grid"></ul>',
                item: '<li class="jFiler-item">\
                    <div class="jFiler-item-container">\
                        <div class="jFiler-item-inner">\
                            <div class="jFiler-item-thumb">\
                                <div class="jFiler-item-status"></div>\
                                <div class="jFiler-item-info">\
                                    <span class="jFiler-item-title"><b title="{{fi-name}}">{{fi-name | limitTo: 25}}</b></span>\
                                    <span class="jFiler-item-others">{{fi-size2}}</span>\
                                </div>\
                                {{fi-image}}\
                            </div>\
                            <div class="jFiler-item-assets jFiler-row">\
                                <ul class="list-inline pull-left">\
                                    <li>{{fi-progressBar}}</li>\
                                </ul>\
                                <ul class="list-inline pull-right">\
                                    <li><a class="icon-jfi-trash jFiler-item-trash-action"></a></li>\
                                </ul>\
                            </div>\
                        </div>\
                    </div>\
                </li>',
                itemAppend: '<li class="jFiler-item">\
                        <div class="jFiler-item-container">\
                            <div class="jFiler-item-inner">\
                                <div class="jFiler-item-thumb">\
                                    <div class="jFiler-item-status"></div>\
                                    <div class="jFiler-item-info">\
                                        <span class="jFiler-item-title"><b title="{{fi-name}}">{{fi-name | limitTo: 25}}</b></span>\
                                        <span class="jFiler-item-others">{{fi-size2}}</span>\
                                    </div>\
                                    {{fi-image}}\
                                </div>\
                                <div class="jFiler-item-assets jFiler-row">\
                                    <ul class="list-inline pull-left">\
                                        <li><span class="jFiler-item-others">{{fi-icon}}</span></li>\
                                    </ul>\
                                    <ul class="list-inline pull-right">\
                                        <li><a class="icon-jfi-trash jFiler-item-trash-action"></a></li>\
                                    </ul>\
                                </div>\
                            </div>\
                        </div>\
                    </li>',
                itemAppendToEnd: false,
                removeConfirmation: true,
                _selectors: {
                    list: '.jFiler-items-list',
                    item: '.jFiler-item',
                    remove: '.jFiler-item-trash-action'
                }
            },
            captions:{
                removeConfirmation: "确定要删除吗?",
                button: "选择文件",
                feedback: "选择上传文件",
                errors: {
                    filesLimit: "不支持此文件格式",
                    filesType: "文件格式不正确",
                    filesSize: "选择文件太大",
                    filesSizeAll: "选择文件过大，请选择合适文件上传！"
                }

            }



        });

    }



function checckAdd(){

    /*拆分弹出层内复选框*/
    $('#split_list span.checkbox').unbind('click').on('click',function(){
        if($(this).hasClass("selected")){
            $(this).removeClass("selected");
           // $(this).removeClass("selected").parent().parent().parent().siblings().find(".checkbox").removeClass("selected");
        }else {
            $(this).addClass("selected");
           // $(this).addClass("selected").parent().parent().parent().siblings().find(".checkbox").removeClass("selected");
        }
    })
}



$(document).ready(function(){

});





