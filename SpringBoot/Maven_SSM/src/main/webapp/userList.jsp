<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en"><head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
    <meta name="generator" content="Jekyll v3.8.5">
    <title>User管理</title>

    <!-- Bootstrap core CSS            ${pageContext.request.contextPath}/   这是：jsp 的绝对路径 -->
    <link href="${pageContext.request.contextPath}/bootstrap_files/bootstrap.min.css" rel="stylesheet" >

    <!-- Custom styles for this template -->
    <link href="${pageContext.request.contextPath}/bootstrap_files/dashboard.css" rel="stylesheet">

    <!-- // 引入DataTables样式文件 -->
    <link rel="stylesheet"
          href="https://cdn.datatables.net/1.10.16/css/jquery.dataTables.min.css" />

    <style type="text/css">/* Chart.js */
    @-webkit-keyframes chartjs-render-animation{from{opacity:0.99}to{opacity:1}}@keyframes chartjs-render-animation{from{opacity:0.99}to{opacity:1}}.chartjs-render-monitor{-webkit-animation:chartjs-render-animation 0.001s;animation:chartjs-render-animation 0.001s;}</style></head>
<body>
<!-- 引入标题栏 -->
<jsp:include page="list_top.jsp" />

<div class="container-fluid">
    <div class="row">
        <!-- 引入 左侧菜单栏 -->
        <jsp:include page="list_left.jsp" />

        <main role="main" class="col-md-9 ml-sm-auto col-lg-10 px-4"><div class="chartjs-size-monitor" style="position: absolute; left: 0px; top: 0px; right: 0px; bottom: 0px; overflow: hidden; pointer-events: none; visibility: hidden; z-index: -1;"><div class="chartjs-size-monitor-expand" style="position:absolute;left:0;top:0;right:0;bottom:0;overflow:hidden;pointer-events:none;visibility:hidden;z-index:-1;"><div style="position:absolute;width:1000000px;height:1000000px;left:0;top:0"></div></div><div class="chartjs-size-monitor-shrink" style="position:absolute;left:0;top:0;right:0;bottom:0;overflow:hidden;pointer-events:none;visibility:hidden;z-index:-1;"><div style="position:absolute;width:200%;height:200%;left:0; top:0"></div></div></div>
            <h2><a href="${pageContext.request.contextPath}/user/findUserPage">User</a></h2>
            <div class="table-responsive">
                <table class="m-table m-table-rds" id="example2" style="text-align: center;">
                    <thead>
                    <tr>
                        <th>Name</th>
                        <th>Position</th>
                        <th>Office</th>
                        <th>Extn.</th>
                        <th>Start date</th>
                        <th>Salary</th>
                    </tr>
                    </thead>

                </table>
            </div>
        </main>
    </div>
</div>
<script src="${pageContext.request.contextPath}/bootstrap_files/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script>window.jQuery || document.write('<script src="/docs/4.3/assets/js/vendor/jquery-slim.min.js"><\/script>')</script><script src="${pageContext.request.contextPath}/bootstrap_files/bootstrap.bundle.min.js" integrity="sha384-xrRywqdh3PHs8keKZN+8zzc5TX0GRTLCcmivcbNJWm2rs5C8PRhcEn3czEjhAO9o" crossorigin="anonymous"></script>
<script src="${pageContext.request.contextPath}/bootstrap_files/feather.min.js"></script>
<script src="${pageContext.request.contextPath}/bootstrap_files/Chart.min.js"></script>
<script src="${pageContext.request.contextPath}/bootstrap_files/dashboard.js"></script>

<!-- // 引入 DataTables js文件 -->
<script type="text/javascript" charset="utf8" src="http://cdn.datatables.net/1.10.16/js/jquery.dataTables.js"></script>
<script>
    $(function(){
        $('#example2').DataTable( {
            "serverSide": true,
            "aLengthMenu":[7, 15, 30],
            'iDisplayLength': 7,
            'order' : [0,'desc'],
            searching: false,
            lengthChange: true,
            paging: true,
            pagingType:'full_numbers',
            scrollCollapse: true,
            serverSide: false,
            search: true,
            processing: true,
            /* scrollY: 500,   表格的高度限制*/
            scrollX: "99.9%",
            scrollXInner: "99.9%",
            scrollCollapse: true,
            jQueryUI: false,
            autoWidth: true,
            autoSearch: false,
            language: {
                "sProcessing": "处理中...",
                "sLengthMenu": "显示 _MENU_ 项搜索结果",
                "sZeroRecords": "没有匹配结果",
                "sInfo": "显示第 _START_ 至 _END_ 项结果，共 _TOTAL_ 条记录",
                "sInfoEmpty": "显示第 0 至 0 项结果，共 0 项",
                "sInfoFiltered": "(由 _MAX_ 项结果过滤)",
                "sInfoPostFix": "",
                "sSearch": "搜索:",
                "sUrl": "",
                "sEmptyTable": "未搜索到数据",
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
            ajax: {
                url: "${pageContext.request.contextPath}/user/findUserPage",
                dataSrc:'data',
                type:'get',
                error: function(data) {
                    console.log(data);
                }
            },

            "columns": [
                { "data": "uid" },
                { "data": "uname" },
                { "data": "pwd" },
                { "data": "usex" },
                { "data": "realName" },
                { "data": "state" }
            ]
        });

    });
</script>

</body></html>
