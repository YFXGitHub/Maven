<html>
<head>
    <title>使用Data Tables 分页插件 实现分页效果</title>

    <!--或者下载到本地，下面有下载地址   data Tables 插件网址：http://www.datatables.club/example/#ajax-->
    <!-- DataTables CSS -->
    <link rel="stylesheet" type="text/css" href="http://netdna.bootstrapcdn.com/bootstrap/3.0.3/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="http://cdn.datatables.net/plug-ins/28e7751dbec/integration/bootstrap/3/dataTables.bootstrap.css">
    <!-- jQuery -->
    <script type="text/javascript" charset="utf8" src="https://code.jquery.com/jquery-3.3.1.js"></script>
    <!-- DataTables -->
    <script type="text/javascript" charset="utf8" src="https://cdn.datatables.net/1.10.19/js/jquery.dataTables.min.js"></script>
    <script type="text/javascript" charset="utf8" src="http://cdn.datatables.net/plug-ins/28e7751dbec/integration/bootstrap/3/dataTables.bootstrap.js"></script>

</head>
<body>

<table id="example" class="display" cellspacing="0" width="100%">
    <thead>
    <tr>
        <th>id</th>
        <th>name</th>
        <th>sex</th>
        <th>age</th>
    </tr>
    </thead>

    <script>

        $(document).ready(function() {
            $('#example').DataTable( {
                "ajax": "test",
                "columns": [
                    { "data": "id" },
                    { "data": "name" },
                    { "data": "sex" },
                    { "data": "age" }
                ]
            } );

        } );
    </script>

</table>
</body>
</html>
