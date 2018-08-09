$(document).ready(function () {
        $.fn.dataTable.ext.errMode = 'none';
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
                "url": "/findAllStaff",
                "dataSrc": ""
            },

            "columnDefs" : [

                {
                    "targets": 7,//操作按钮目标列
                    "data": null,
                    "render": function (data, type, row) {
                        var staff_id = '"' + row.staff_id + '"';
                        var staff_name = '"' + row.staff_name + '"';
                        var sex = '"' + row.sex + '"';
                        var birthday = '"' + row.birthday + '"';
                        var years = '"' + row.years + '"';
                        var tel = '"' + row.tel + '"';
                        var html = "<input type='button'  onclick='edit("+staff_id+","+staff_name+","+sex+","+birthday+","+years+","+tel+")' value='修改'  class='btn btn-info btn-sm'  ><i class='fa fa-times'></i>" +
                            "<input type='button'  onclick='delBefore("+staff_id+")' value='删除'  class='btn btn-danger btn-sm'  ><i class='fa fa-times'></i>"
                        return html;

                    }
                },
                {
                    "targets":[0],
                    "visible":false,
                    "searchable":false
                },
                {
                    "targets":[6],
                    "visible":false,
                    "searchable":false
                }

            ],

            "columns": [
                {"data": "staff_id"},
                {"data": "staff_name"},
                {"data": "sex"},
                {"data": "birthday"},
                {"data": "years"},
                {"data": "tel"},
                {"data": "remarks"}
            ]
        });
    }
);

function closeWindow() {
    $("#form").data('bootstrapValidator').resetForm();
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
            staff_name: {
                validators: {
                    notEmpty: {
                        message: '姓名不能为空'
                    }
                }
            },
            sex: {
                validators: {
                    notEmpty: {
                        message: '性别不能为空'
                    }
                }
            },
            years: {
                validators: {
                    notEmpty: {
                        message: '工龄不能为空'
                    }
                }
            },
            tel: {
                validators: {
                    notEmpty: {
                        message: '电话能为空'
                    }
                }
            }
        }
    }).on('success.form.bv', function () {
        var addJson = {
            "staff_id":$("#staff_id").val(),
            "staff_name": $("#staff_name").val(),
            "sex": $("#sex").val(),
            "birthday": $("#birthday").val(),
            "years": $("#years").val(),
            "tel": $("#tel").val()
        };
        ajax(addJson);
    })
}

function ajax(obj) {
    var url = "/insertStaffInfo";
    if (editFlag) {
        url = "/updateStaffInfo";
    }
    $.ajax({
        url: url,
        data: {
            "staff_id":obj.staff_id,
            "staff_name": obj.staff_name,
            "sex": obj.sex,
            "birthday": obj.birthday,
            "years":obj.years,
            "tel":obj.tel,
        }, success: function (data) {
            $('#example').DataTable().ajax.reload();
            $("#myModal").modal("hide");
            $("#myModalLabel").text("新增");
            clear();
        }
    });
}

function addBefore() {
    clear();
    $("#myModalLabel").text("新增");
    $("#myModal").modal("show");
}
var editFlag;
function clear() {
    $("#staff_name").val("");
    $("#sex").val("");
    $("#birthday").val("");
    $("#years").val("");
    $("#tel").val("")
    editFlag = false;
}

function edit(staff_id, staff_name, sex,birthday,years,tel) {
    editFlag = true;
    $("#myModalLabel").text("修改");
    $("#staff_id").val(staff_id);
    $("#staff_name").val(staff_name);
    $("#sex").val(sex);
    $("#birthday").val(birthday);
    $("#years").val(years);
    $("#tel").val(tel);
    $("#myModal").modal("show");
}


function delBefore(id) {
    $("#del_id").val(id);
    $("#delModal").modal("show");
}

function del() {
    $.ajax({
        url:"/deleteStaffInfo",
        data:{
            "staff_id":$("#del_id").val()
        },success:function (data) {
            $('#example').DataTable().ajax.reload();
            console.log("删除成功" + data);
            $("#delModal").modal("hide");
            clear();
        }
    })
}