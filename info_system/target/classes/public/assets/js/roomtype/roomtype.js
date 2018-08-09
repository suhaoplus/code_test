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
                "url": "/findAllStyle",
                "dataSrc": ""
            },

            "columnDefs" : [

                {
                    "targets": 5,//操作按钮目标列
                    "data": null,
                    "render": function (data, type, row) {
                        var id = '"' + row.style_id + '"';
                        var html = "<input type='button'  onclick='find("+id+")' value='详细信息'  class='btn btn-info btn-sm'  ><i class='fa fa-times'></i>"
                        return html;

                    }
                },
                {
                    "targets":[0],
                    "visible":false,
                    "searchable":false
                }

            ],

            "columns": [
                {"data": "style_id"},
                {"data": "style_name"},
                {"data": "cost"},
                {"data": "total"},
                {"data": "rest"},
               /* {"data": "remarks"}*/
            ]
        });
    }


);
function find(id) {
    window.location.href = "../guestroom/guestroomlist.html?id="+id;
}