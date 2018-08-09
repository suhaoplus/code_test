$(document).ready(function () {
        $('#example').DataTable({
            language: {
                "sProcessing": "处理中...",
                "sLengthMenu": "显示 _MENU_ 项结果",
                "sZeroRecords": "没有匹配结果",
                "sInfo": "显示第 _START_ 至 _END_ 项结果，共 _TOTAL_ 项",
                "sInfoEmpty": "显示第 0 至 0 项结果，共 0 项",
                "sInfoFiltered": "(由 _MAX_ 项结果过滤)",
                "sInfoPostFix": "",
                "sSearch": "搜索:",
                "sUrl": "",
                "sEmptyTable": "表中数据为空",
                "sLoadingRecords": "载入中...",
                "sInfoThousands": ",",
                "oPaginate": {
                    "sFirst": "首页",
                    "sPrevious": "上页",
                    "sNext": "下页",
                    "sLast": "末页"
                },
                "oAria": {
                    "sSortAscending": ": 以升序排列此列",
                    "sSortDescending": ": 以降序排列此列"
                }
            },
            "createdRow": function ( row) {
                $('td', row).eq(0).addClass('highlight');
            },
            "ajax": {
                "url": "/findAllUser",
                "dataSrc": ""
            },

            "columns": [
                {"data": "id"},
                {"data": "name"},
                {"data": "password"},
                {"data": "info"}
            ],


            "columnDefs": [
                {
                    "targets": 4,//操作按钮目标列
                    "data": null,
                    "render": function (data, type, row) {
                        var id = '"' + row.id + '"';
                        var name = '"' + row.name + '"';
                        var password = '"' + row.password + '"';
                        var info = '"' + row.info + '"';
                        var html = "<input type='button'  onclick='edit("+id+","+name+","+password+","+info+")' value='修改'  class='btn btn-info btn-sm'  ><i class='fa fa-times'></i>" +
                            "<input type='button'  onclick='delBefore("+id+")' value='删除'  class='btn btn-danger btn-sm'  ><i class='fa fa-times'></i>"
                        return html;

                    }
                },

                {
                    "targets":[0],
                    "visible":false,
                    "searchable":false
                },
                {
                    "targets":[2],
                    "visible":false,
                    "searchable":false
                }
            ]
        });
    }
);


function delBefore(id) {
    $("#del_id").val(id);
    $("#delModal").modal("show");
}
function del() {
    $.ajax({
        url:"/deleteUserInfo",
        data:{
            "id":$("#del_id").val()
        },success:function (data) {
            $('#example').DataTable().ajax.reload();
            console.log("删除成功" + data);
            $("#delModal").modal("hide");
            clear();
        }
    })
}
var editFlag;

function clear() {
    $("#id").val("");
    $("#name").val("");
    $("#password").val("");
    $("#info").val("");
    $("#del_id").val("")
    editFlag = false;
}

/**
 * 添加数据前的操作
 * 弹出模态框
 **/
function addBefore() {
    clear();
    $("#myModalLabel").text("新增");
    $("#myModal").modal("show");
}


function edit(id, name, password,info) {
    editFlag = true;
    $("#myModalLabel").text("修改");
    $("#id").val(id);
    $("#name").val(name);
    $("#password").val(password);
    $("#info").val(info);
    $("#myModal").modal("show");
}



function ajax(obj) {
    var url = "/insertUserInfo";
    if (editFlag) {
        url = "/updateUserInfo";
    }
    $.ajax({
        url: url,
        data: {
            "id":obj.id,
            "name": obj.name,
            "password": obj.password,
            "info": obj.info
        }, success: function (data) {
            $('#example').DataTable().ajax.reload();
            $("#myModal").modal("hide");
            $("#myModalLabel").text("新增");
            clear();
        }
    });
}



function add() {
    $('#form').bootstrapValidator({
        message: 'This value is not valid',
        feedbackIcons: {
            valid: 'glyphicon glyphicon-ok',
            invalid: 'glyphicon glyphicon-remove',
            validating: 'glyphicon glyphicon-refresh'
        },
        fields: {
            name: {
                validators: {
                    notEmpty: {
                        message: '用户名不能为空'
                    }
                }
            },
            password: {
                validators: {
                    notEmpty: {
                        message: '密码不能为空'
                    }
                }
            }
        }
    }).on('success.form.bv', function () {
        var addJson = {
            "id":$("#id").val(),
            "name": $("#name").val(),
            "password": $("#password").val(),
            "info": $("#info").val()
        };
        ajax(addJson);
    })
}


/**
 *  清除校验效果
 */
function closeWindow() {
    $("#form").data('bootstrapValidator').resetForm();
}