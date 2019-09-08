<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Smooth Sliding</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<!-- Custom Theme files -->
<link href="/login_files/css/style.css" rel="stylesheet" type="text/css" media="all" />
<!-- //Custom Theme files -->

<!-- font-awesome icons -->
<link href="/login_files/css/font-awesome.css" rel="stylesheet"> 
<!-- //font-awesome icons -->

<!-- web font -->
<!--<link href="//fonts.googleapis.com/css?family=Cormorant+Unicase:300,400,500,600,700" rel="stylesheet">-->
<!-- //web font -->
</head>
<body>
	<!-- main -->
	<div class="main agileits-w3layouts">
		<h1>同城配送管理平台</h1>
		<div class="main-agileinfo"> 
			<div class="agileui-forms">
				<div class="container-form">
					<div class="form-item log-in"><!-- login form-->
						<div class="w3table agileinfo"> 
							<div class="w3table-cell register"> 
								<div class="w3table-tophead">
									<h2>登录</h2>
								</div>
								<form id="loginForm" action="/user/login" method="post"> 
									<div class="fields-grid">
										<div class="styled-input agile-styled-input-top">
											<input type="text" name="username" required> 
											<label>Username</label>
											<span></span>
										</div>
										<div class="styled-input">
											<input type="Password" name="password" required>
											<label>Password</label>
											<span></span>
										</div>
										<a href="#">forgot password?</a>										
										<input type="submit" id="loginButton" value="Sign in"> 
									</div>
									<div class="social-grids">
										<div class="social-text">
											<p>Or Sign in with</p>
										</div>
										<div class="social-icons">
											<ul>
												<li><a href="#"><i class="fa fa-facebook"></i></a></li>
												<li><a href="#"><i class="fa fa-twitter"></i></a></li>
												<li><a href="#"><i class="fa fa-rss"></i></a></li>
											</ul>
										</div>
										<div class="clear"> </div>
									</div>

								</form>  
							</div>
						</div>
					</div>
					<div class="form-item sign-up"><!-- sign-up form-->
						<div class="w3table w3-agileits">
							<div class="w3table-cell register">   
									<h3>注册</h3>
								<form action="/user/register" method="post">
									<div class="fields-grid">
										<div class="styled-input agile-styled-input-top">
											<input type="text" name="uname" required> 
											<label>First name</label>
											<span></span>
										</div>
										<div class="styled-input">
											<input type="email" name="emial" required>
											<label>Email</label>
											<span></span>
										</div>
										<div class="styled-input">
											<input type="tel" name="phone" required>
											<label>Phone Number</label>
											<span></span>
										</div>
										<div class="styled-input">
											<input type="password" name="upwd" required>
											<label>Password</label>
											<span></span>
										</div>
										<div class="clear"> </div>
										 <label class="checkbox"><input type="checkbox" name="checkbox" checked><i></i>I agree to the <a href="#">Terms and Conditions</a></label>
									</div>
									<input type="submit" value="Sign up">
								</form>

							</div>
						</div>
					</div>
				</div>
				<div class="container-info">
					<div class="info-w3lsitem">
						<div class="w3table">
							<div class="w3table-cell">
								<p> Have an account? </p>
								<div class="btn"> Sign in </div>
							</div>
						</div>
					</div>
					<div class="info-w3lsitem">
						<div class="w3table">
							<div class="w3table-cell">
								<p> Dont have an account?</p>
								<div class="btn">Sign up</div>
							</div>
						</div>
					</div>
					<div class="clear"> </div>
				</div> 
				
				
			</div> 
		</div>	
	</div>   
	<!-- //main -->
	<!-- copyright -->
	<div class="copyw3-agile">
		<p> © 2017 Smooth Sliding Forms . All rights reserved | Design by <a href="http://w3layouts.com/" target="_blank">W3layouts.</a></p>
	</div>
	<!-- //copyright --> 
	<!-- js -->  
	<script  src="/login_files/js/jquery-1.12.3.min.js"></script> 
	<script>
		$(".info-w3lsitem .btn").click(function() {
			  $(".main-agileinfo").toggleClass("log-in");
			});
		$(".container-form .btn").click(function() {
			  $(".main-agileinfo").addClass("active");
		});
		
		//登录提交
		/*
			$("#loginButton").click(function(){
			var url = $("#loginForm").attr("action");
			var data = $("#loginForm").serialize();
			$ajax({
				url:url,
				type:'post',
				data:data,
				dataType: 'text',
				success: function(data){
					alert(data);
				},
				error: function(){
					alert('登录失败！');
				}
				
			})
		});
		*/
	</script>
	<!-- //js --> 
</body>
</html>