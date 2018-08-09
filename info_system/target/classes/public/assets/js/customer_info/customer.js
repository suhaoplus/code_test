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
                "url": "/customer",
                "dataSrc": ""
            },
            "columnDefs":[
                {
                    "targets":[0],
                    "visible":false,
                    "searchable":false
                },
                {
                    "targets":[6],
                    "visible":false,
                    "searchable":false
                },
                {
                    "targets": 7,//操作按钮目标列
                    "data": null,
                    "render": function (data, type, row) {
                        var customer_id = '"'+row.customer_id+'"';
                        var html = "<input type='button'  onclick='delBefore("+customer_id+")' value='删除'  class='btn btn-danger btn-sm'  ><i class='fa fa-times'></i>"
                        return html;
                    }
                }
            ],


            "columns": [
                {"data": "customer_id"},
                {"data": "customer_name"},
                {"data": "sex"},
                {"data": "birthday"},
                {"data": "id"},
                {"data": "tel"},
                {"data": "remarks"},
            ]
        });
    }


);
var editFlag;
function clear() {
    $("#customer_id").val("");
    $("#customer_name").val("");
    $("#sex").val("");
    $("#birthday").val("");
    $("#id").val("");
    $("#tel").val("")
    $("#remarks").val("")
    editFlag = false;
}
function delBefore(id) {
    $("#del_id").val(id);
    $("#delModal").modal("show");
}
function del() {
    $.ajax({
        url:"/deleteCustomer",
        data:{
            "customer_id":$("#del_id").val()
        },success:function (data) {
            $('#example').DataTable().ajax.reload();
            console.log("删除成功" + data);
            $("#delModal").modal("hide");
            clear();
        }
    })
}
