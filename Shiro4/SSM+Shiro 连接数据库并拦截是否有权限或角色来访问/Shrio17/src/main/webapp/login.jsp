<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>大气简洁登录</title> 
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<script type="text/javascript" src="/login_files/js/jquery-1.9.0.min.js"></script>

<link href="/login_files/css/login2.css" rel="stylesheet" type="text/css" />
</head>
<body>
<h1>Login<sup>V2019</sup></h1>

<div class="login" style="margin-top:50px;">
    
    <div class="header">
        <div class="switch" id="switch"><a class="switch_btn_focus" id="switch_qlogin" href="javascript:void(0);" tabindex="7">快速登录</a>
			<a class="switch_btn" id="switch_login" href="register.jsp" tabindex="8">快速注册</a><div class="switch_bottom" id="switch_bottom" style="position: absolute; width: 64px; left: 0px;"></div>
        </div>
    </div>    
  
    
    <div class="web_qr_login" id="web_qr_login" style="display: block; height: 235px;">    

            <!--登录-->
            <div class="web_login" id="web_login">
               
               <div class="login-box">
    
			<div class="login_form">
				<form action="login" name="loginform" accept-charset="utf-8" id="login_form" class="loginForm" method="post">
	               	
	                <div class="uinArea" id="uinArea">
		                <label class="input-tips" for="u">帐号：</label>
		                <div class="inputOuter" id="uArea">
		                    
		                    <input type="text" id="u" name="username" class="inputstyle" required/>
		                </div>
	                </div>
	                <div class="pwdArea" id="pwdArea">
		               <label class="input-tips" for="p">密码：</label> 
		               <div class="inputOuter" id="pArea">
		                    
		                    <input type="password" id="p" name="password" class="inputstyle" required/>
		                </div>
	                </div>
               
	                <div style="padding-left:50px;margin-top:20px;">
						<input type="submit" value="登 录" style="width:150px;" class="button_blue"/>
					</div>
              </form>
           </div>
           
            	</div>
               
            </div>
            <!--登录end-->
  </div>

</div>
<div class="jianyi">*推荐使用ie8或以上版本ie浏览器或Chrome内核浏览器访问本站</div>
</body></html>