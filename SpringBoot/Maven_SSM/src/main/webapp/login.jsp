<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="zh-CN" class="translated-ltr">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="generator" content="Jekyll v3.8.5">
    <title>Login</title>
    <!-- Bootstrap core CSS -->
    <link href="${pageContext.request.contextPath}/login_files//bootstrap.min.css" rel="stylesheet" >

    <!-- Custom styles for this template -->
    <link href="${pageContext.request.contextPath}/login_files//signin.css" rel="stylesheet">
    <link type="text/css" rel="stylesheet" charset="UTF-8" href="${pageContext.request.contextPath}/login_files//translateelement.css"></head>
<body class="text-center">
    <form class="form-signin" action="${pageContext.request.contextPath}/user/findUserByName" method="post">
        <img class="mb-4" src="login_files//bootstrap-solid.svg" alt="" width="72" height="72">
        <h1 class="h3 mb-3 font-weight-normal"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">请登录</font></font></h1>
        <label for="inputEmail" class="sr-only"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">电子邮件地址</font></font></label>
        <input type="text" id="inputEmail" name="username" class="form-control" placeholder="UserName" required="" autofocus="">
        <label for="inputPassword" class="sr-only"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">密码</font></font></label>
        <input type="password" id="inputPassword" name="password" class="form-control" placeholder="Password" required="">
        <div class="checkbox mb-3">
            <label>
                <input type="checkbox" value="remember-me"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;"> 记住账号
            </font></font></label>
        </div>
        <button class="btn btn-lg btn-primary btn-block" type="submit"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">登入</font></font></button>
        <p class="mt-5 mb-3 text-muted"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">©2017-2019</font></font></p>
    </form>


    <div id="goog-gt-tt" class="skiptranslate" dir="ltr"><div style="padding: 8px;"><div><div class="logo"><img src="${pageContext.request.contextPath}/login_files//translate_24dp.png" width="20" height="20" alt="Google 翻译"></div></div></div><div class="top" style="padding: 8px; float: left; width: 100%;"><h1 class="title gray">原文</h1></div><div class="middle" style="padding: 8px;"><div class="original-text"></div></div><div class="bottom" style="padding: 8px;"><div class="activity-links"><span class="activity-link">提供更好的翻译建议</span><span class="activity-link"></span></div><div class="started-activity-container"><hr style="color: #CCC; background-color: #CCC; height: 1px; border: none;"><div class="activity-root"></div></div></div><div class="status-message" style="display: none;"></div></div>


<div class="goog-te-spinner-pos"><div class="goog-te-spinner-animation"><svg xmlns="http://www.w3.org/2000/svg" class="goog-te-spinner" width="96px" height="96px" viewBox="0 0 66 66"><circle class="goog-te-spinner-path" fill="none" stroke-width="6" stroke-linecap="round" cx="33" cy="33" r="30"></circle></svg></div></div>

</body></html>

