<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home</title>
<!-- Favicon icon -->
    <link rel="icon" type="image/png" sizes="16x16" href="assets/images/favicon.png">
    <title>Home</title>
    <!-- Bootstrap Core CSS -->
    <link href="/login_files/css/bootstrap.min.css" rel="stylesheet">
    <!-- Custom CSS -->
    <link href="/login_files/css/style.css" rel="stylesheet">
    <link href="/login_files/css/blue.css" id="theme" rel="stylesheet">
    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    
<![endif]-->
</head>

<body class="fix-header fix-sidebar card-no-border">
	
    <!-- ============================================================== -->
    <div class="preloader">
        <svg class="circular" viewBox="25 25 50 50">
            <circle class="path" cx="50" cy="50" r="20" fill="none" stroke-width="2" stroke-miterlimit="10" /> </svg>
    </div>
    <!-- ============================================================== -->
    <!-- Main wrapper - style you can find in pages.scss -->
    <!-- ============================================================== -->
    <div id="main-wrapper">
    
        <!-- Topbar 引入头部标题栏 -->
        <jsp:include page="home_top.jsp" />
        
        <!-- Left Sidebar 引入左侧边栏  -->
       	<jsp:include page="home_left.jsp" />
       	
        <!-- Page wrapper  -->
        <div class="page-wrapper">
            <!-- Container fluid  -->
            <div class="container-fluid">
                
                <!-- Row -->
                <div class="row">
                    <div class="col-sm-12">
                        <div class="card">
                            <div class="card-block">
                              
                                <h4 class="card-title">Projects of the Month</h4>
                                <div class="table-responsive m-t-40">
                                      <c:if test="${empty userList}">
                                	<h1>暂时没有数据！</h1>
                                </c:if>
                                <c:if test="${not empty userList}">
                                	<table class="table stylish-table">
                                        <thead>
                                            <tr>
                                                <th>ID</th>
                                                <th>Name</th>
                                                <th>PWD</th>
                                                <th>SALT</th>
                                                <th>操作</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                        	<c:forEach items="${userList}" var="user">
                                        		<tr>
	                                               <td>${user.id}</td>
	                                               <td>${user.name}</td>
	                                               <td>${user.password}</td>
	                                               <td>${user.salt}</td>
	                                               <td>
	                                               	
	                                               			<!-- bootstarp 按钮颜色 btn btn-sm btn btn-danger  文字颜色 text-white  -->
	                                               			<a href="/user/userUpdate" class="btn btn-sm btn btn-danger text-white">修改</a> · 
	                                               			<a href="/user/userDelete" class="btn btn-sm btn btn-primary text-white">删除</a>
	                                               </td>
                                            	</tr>
                                        	</c:forEach>
                                        </tbody>
                                    </table>
                                </c:if>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <!-- Row -->
               
            </div>
            <!-- footer -->
            <footer class="footer text-center">
                Copyright &copy; 2019.Company name All rights reserved.
            </footer>
            <!-- End footer -->
        </div>
        <!-- End Page wrapper  -->
    </div>
    <!-- End Wrapper -->
    <!-- All Jquery -->
    <script src="/login_files/js/jquery.min.js"></script>
    <!-- Bootstrap tether Core JavaScript -->
    <script src="/login_files/js/tether.min.js"></script>
    <script src="/login_files/js/bootstrap.min.js"></script>
    <!-- slimscrollbar scrollbar JavaScript -->
    <script src="/login_files/js/jquery.slimscroll.js"></script>
    <!--Wave Effects -->
    <script src="/login_files/js/waves.js"></script>
    <!--Menu sidebar -->
   
    <!--stickey kit -->
    <script src="/login_files/js/sticky-kit.min.js"></script>
    <!--Custom JavaScript -->
    <script src="/login_files/js/custom.min.js"></script>
    <!-- This page plugins -->
    <!-- Flot Charts JavaScript -->
    <script src="/login_files/js/jquery.flot.js"></script>
    
    <script src="/login_files/js/flot-data.js"></script>
    <!-- Style switcher -->
   
</body>

</html>