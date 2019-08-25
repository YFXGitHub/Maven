<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>404</title>
<link href="/404_files/404.css" rel="stylesheet" type="text/css">
<script src="/404_files/jquery-1.10.2.js"></script><script src="/404_files/jquery.min.js"></script>
<script type="text/javascript">
	$(function() {
		var h = $(window).height();
		$('body').height(h);
		$('.mianBox').height(h);
		centerWindow(".tipInfo");
	});

	//2.将盒子方法放入这个方，方便法统一调用
	function centerWindow(a) {
		center(a);
		//自适应窗口
		$(window).bind('scroll resize',
				function() {
					center(a);
				});
	}

	//1.居中方法，传入需要剧中的标签
	function center(a) {
		var wWidth = $(window).width();
		var wHeight = $(window).height();
		var boxWidth = $(a).width();
		var boxHeight = $(a).height();
		var scrollTop = $(window).scrollTop();
		var scrollLeft = $(window).scrollLeft();
		var top = scrollTop + (wHeight - boxHeight) / 2;
		var left = scrollLeft + (wWidth - boxWidth) / 2;
		$(a).css({
			"top": top,
			"left": left
		});
	}
</script>
</head>
<body style="height: 637px;">
<div class="mianBox" style="height: 637px;">
<img src="/404_files/yun0.png" alt="" class="yun yun0">
<img src="/404_files/yun1.png" alt="" class="yun yun1">
<img src="/404_files/yun2.png" alt="" class="yun yun2">
<img src="/404_files/bird.png" alt="" class="bird">
<img src="/404_files/san.png" alt="" class="san">
<div class="tipInfo" style="top: 224.5px; left: 503px;">
<div class="in">
<div class="textThis">
<h2>当前用户没有访问权限 - 404！</h2>
<p><span>页面自动<a id="href" href="/home.jsp">跳转</a></span><span>等待<b id="wait">0</b>秒</span></p>
<script type="text/javascript">                            (function() {
						var wait = document.getElementById('wait'), href = document.getElementById('href').href;
						var interval = setInterval(function() {
							var time = --wait.innerHTML;
							if (time <= 0) {
								
								clearInterval(interval);
								//location.href = href;
								alert("开始跳转提示");
							}
							;
						}, 1000);
					})();
				</script>
</div>
</div>
</div>
</div>


</body></html>