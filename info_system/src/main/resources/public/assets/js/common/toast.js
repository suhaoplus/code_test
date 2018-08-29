var toast = function(){
    var options={
        "closeButton": false,
        "debug": false,
        "positionClass": "toast-top-right",
        "onclick": null,
        "showDuration": "300",
        "hideDuration": "1000",
        "timeOut": "5000",
        "extendedTimeOut": "1000",
        "showEasing": "swing",
        "hideEasing": "linear",
        "showMethod": "fadeIn",
        "hideMethod": "fadeOut"
    };
    return {
        success:function(msg){
            msg =  msg || "操作成功！";
            toastr.options=options;
            toastr["success"](msg)
        },
        success_del:function(msg){
            msg =  msg || "清除成功！";
            toastr.options=options;
            toastr["success"](msg)
        },
        success_arragement:function(msg){
            msg =  msg || "操作成功！";
            toastr.options=options;
            toastr["success"](msg);
            window.location.reload()
        },
        success_addCommon:function(msg){
            msg =  msg || "已发送至常用文档！";
            toastr.options=options;
            toastr["success"](msg)
        },
        success_share:function(msg){
            msg =  msg || "共享成功！";
            toastr.options=options;
            toastr["success"](msg)
        },
        success_addArrangement:function(msg){
            msg =  msg || "恢复成功！";
            toastr.options=options;
            toastr["success"](msg)
        },
        info:function(msg){
            toastr.options=options;
            toastr["info"](msg)
        },
        warning:function(msg){
            toastr.options=options;
            toastr["warning"](msg)
        },
        error:function(msg){
            msg =  msg || "操作失败！";
            toastr.options=options;
            toastr["error"](msg)
        }
    }
}();