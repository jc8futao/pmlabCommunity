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


        $("body").on('click','#queryActivity',function(){

            var searchName=$("#searchName").val();
            var state=$("#state").val();
            grid.getDataTable().ajax.url(domain+"activity/list?searchName="+searchName+"&state="+state).load();
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

    jQuery.validator.addMethod("activityName", function(value, element, param) {
        var tel =/^[\u4E00-\u9FA5A-Za-z0-9]+$/;
        return this.optional(element) || (tel.test(value));
    }, $.validator.format("只能输入汉字、数字或字母"));

    var validation = function(id){
        var form1 = $('#'+id);
        var error1 = $('.alert-danger', form1);
        var success1 = $('.alert-success', form1);

        form1.validate({
            errorPlacement: function(error, element) {
                element.parent().next().html(error);
            },
            //errorElement: 'span', //default input error message container
            errorClass: 'help-block help-block-error', // default input error message class
            focusInvalid: false, // do not focus the last invalid input
            ignore: "",  // validate all fields including form hidden input
            messages: {
                select_multi: {
                    maxlength: jQuery.validator.format("Max {0} items allowed for selection"),
                    minlength: jQuery.validator.format("At least {0} items must be selected")
                }
            },
            rules: {
                activityName: {
                    maxlength: 30,
                    required: true,
                    activityName:true
                },
                activityDate: {
                    required: true
                },
                enrollEndtime: {
                    required: true
                },
                activityMaxnum: {
                    required: true,
                    number: true
                },
                activityLocation: {
                    required: true
                },
                activityInstruction:{
                    required: true
                },
                activityPic:{
                    required: true
                }
            },
            messages:{
                activityName:{
                    maxlength: '不能超过30个字符',
                    required: '活动标题必填'
                },
                activityDate: {
                    required: '活动时间不能为空'
                },
                enrollEndtime: {
                    required: '活动结束时间不能为空'
                },
                activityMaxnum: {
                    required: '最大参与人数不能为空',
                    number: '必须是数字'
                },
                activityLocation: {
                    required: '活动地点不能为空'
                },
                activityInstruction:{
                    required: '活动说明不能为空'
                },
                activityPic:{
                    required: '活动图片不能为空'
                }
            },
            invalidHandler: function (event, validator) { //display error alert on form submit
                success1.hide();
                error1.show();
                Metronic.scrollTo(error1, -200);
            },

            highlight: function (element) { // hightlight error inputs
                $(element)
                    .closest('.form-group').addClass('has-error'); // set error class to the control group
            },

            unhighlight: function (element) { // revert the change done by hightlight
                $(element)
                    .closest('.form-group').removeClass('has-error'); // set error class to the control group
            },

            success: function (label) {
                label
                    .closest('.form-group').removeClass('has-error'); // set success class to the control group
            },

            submitHandler: function (form) {
                success1.show();
                error1.hide();
                form.submit();
            }
        });

    }

    return {

        //main function to initiate the module
        init: function (id) {
            handleRecords();
            datepicker();
            validation(id);
        },
        validation:function(id){
            validation(id);
        }

    };

}();