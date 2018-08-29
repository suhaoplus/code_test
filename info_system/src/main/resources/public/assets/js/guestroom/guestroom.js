$(document).ready(function () {
    $.fn.dataTable.ext.errMode = 'none';
        var type_id = GetQueryString("id");
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
                "url": "/findGuestRoomById?type_id="+type_id,
                "dataSrc": ""
            },

            "columnDefs" : [

                {
                    "targets": 4,//操作按钮目标列
                    "data": null,
                    "render": function (data, type, row) {
                        var state = row.state;
                        var guest_room_id = '"'+row.guest_room_id+'"';
                        if(state == 0){
                            var html = "<input type='button'  onclick='find("+guest_room_id+","+type_id+")' value='住房情况'  class='btn btn-info btn-sm'  ><i class='fa fa-times'></i>"
                        }
                        if(state == 1){
                            var html = "<input type='button' disabled='true'  onclick='find()' value='暂空'  class='btn btn-info btn-sm'  ><i class='fa fa-times'></i>"
                        }
                        return html;

                    }
                },
                {
                    "targets":[1],
                    "visible":false,
                    "searchable":false
                },
                {
                    "targets":[2],
                    "visible":false,
                    "searchable":false
                },
                {
                    "targets":[3],
                    "visible":false,
                    "searchable":false
                }

            ],

            "columns": [
                {"data": "guest_room_id"},
                {"data": "type_id"},
                {"data": "state"},
                {"data": "remarks"}
            ]
        });
    }
);
function find(guest_room_id,type_id) {
    window.location.href = "../customer_info/customer_info.html?guest_room_id="+guest_room_id+"&type_id="+type_id;
}