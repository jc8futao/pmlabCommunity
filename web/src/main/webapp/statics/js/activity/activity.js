var activity = function () {



    var handleRecords = function () {

        var activityState = ["报名中","报名待确认","进行中","已结束"];
        var grid = new Datatable();

        grid.init({
            src: $("#activityTable"),
            onSuccess: function (grid) {
                // execute some code after table records loaded
            },
            onError: function (grid) {
                // execute some code on network or other general error
            },
            onDataLoad: function(grid) {
                // execute some code on ajax data load
            },
            loadingMessage: '加载中...',
            dataTable: {
                "dom": "<'row' <'col-md-12'>><'row'<'col-md-6 col-sm-12'l><'col-md-6 col-sm-12'>r><'table-scrollable't><'row'<'col-md-5 col-sm-12'i><'col-md-7 col-sm-12'p>>", // horizobtal scrollable datatable
                columns: [
                    { data: 'activityName' },
                    { data: 'activityDate' },
                    { data: 'enrollEndtime' },
                    { data: 'activityEnrollnum' },
                    { data: 'activityState' },
                    { data: 'id' },
                ],
                columnDefs:[{
                    "targets": [1],
                    "render":function(data, type, full){
                        return new Date(data).Format("yyyy-MM-dd");
                    }
                },{
                    "targets": [2],
                    "render":function(data, type, full){
                        return new Date(data).Format("yyyy-MM-dd");
                    }
                },{
                    //（0：报名中 1：报名待确认 2：进行中 3：已结束）
                    "targets": [4],
                    "render":function(data, type, full){
                        return activityState[data];
                    }
                },{
                    //（0：报名中 1：报名待确认 2：进行中 3：已结束）
                    "targets": [5],
                    "render":function(data, type, full){
                        var html="<a href='"+domain+"activity/"+data+"' data-target='#showActivity' data-toggle='modal'>查看</a>|<a href='"+domain+"activity/modify/"+data+"' data-target='#modifyActivity' data-toggle='modal'>修改</a>|<a href='####'>参与人员</a>";
                        return html;
                    }
                }],
                "bStateSave": true, // save datatable state(pagination, sort, etc) in cookie.
                "pageLength": 10, // default record count per page
                "pagingType": "full_numbers",
                "language": { // language settings
                    "metronicAjaxRequestGeneralError": "请联系管理员",
                    // data tables spesific
                    "lengthMenu": "",
                    "info": "共 _TOTAL_ 条数据",
                    "infoEmpty": "无数据",
                    "emptyTable": "无数据",
                    "zeroRecords": "无数据",
                    "paginate": {
                        "previous": "<",
                        "next": ">",
                        "last": ">>",
                        "first": "<<",
                        "page": "Page",
                        "pageOf": "of"
                    }
                },
                "ajax": {
                    "url":domain+"activity/list", // ajax source
                },
                "deferRender": true,
                "order": [
                    [1, "asc"]
                ]// set first column as a default sort by asc
            }
        });


    }

    var datepicker=function () {
        if (jQuery().datepicker) {

            $('.date-picker').datepicker({
                rtl: Metronic.isRTL(),
                orientation: "left",
                autoclose: true,
                format:"yyyy-mm-dd",
                language:"zh-CN"
            });
        }
    }

    return {

        //main function to initiate the module
        init: function () {
            handleRecords();
            datepicker();
        }

    };

}();