var basePath = (function() {
    var url = window.location + "";
    var h = url.split("//");
    var x = h[1].split("/");
    return h[0] + "//" + window.location.host + "/" + x[1] + "/";
})();
function formSub(){
    var $form = $("form");
    if($form.size()==0){
        $("body").wrap('<form method="post"></form>');
        $form = $("form");
    }
    switch (arguments.length){
        case 0:
            $form.attr("method","post").submit();
            break;
        case 1:
            $form.attr("method","post").attr("action",arguments[0]).submit();
            break;
        case 2:
            arguments[0].attr("method","post").attr("action",arguments[1]).submit();
            break;
    }
}
var requestMethod = {
    GET:"GET",
    POST:"POST",
    PUT:"PUT",
    DELETE:"DELETE"
};
$(function(){
    $.ajaxSetup({
        cache: false,
        error: doError,
        dataType: "json"
    })
});

function doError(data){
    if(data.status==404){
        toast.error("未找到请求地址!");
        return
    }
    if(data.status==400){
        toast.error("请登录后再试!");
        return
    }
    if(data.statusText.indexOf("Failure")!=-1){
        toast.error("操作超时，请检查网络连接");
        return
    }
    if(data.statusText=="timeout"){
        toast.error("操作超时，请检查网络连接");
    }else{
        toast.error(data.responseText);
    }
}
function onSortColumnDefault(sortColumn, sortDirection) {
    return {
        sortColumn:sortColumn,
        sortDirection:sortDirection
    }
}
