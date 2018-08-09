function GetQueryString(str){
    var reg = new RegExp("(^|&)"+str+"=([^&]*)(&|$)");
    var result = window.location.search.substr(1).match(reg);
    return result?decodeURIComponent(result[2]):null;
}

function typeList() {
    window.location.href = "../type/type.html";
}

function roomList() {
    var type_id = GetQueryString("type_id");
    window.location.href = "../guestroom/guestroomlist.html?id="+type_id;
}


function getLoginname() {
    var loginname;
    $.ajax({
        type: "GET",
        url: "/getLoginname",
        dataType: "text",
        async:false,
        success: function (data) {
            loginname=data;

        },
        error: function () {
            alert("error");
        }
    });
    return loginname;
}