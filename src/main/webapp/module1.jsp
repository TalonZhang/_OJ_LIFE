<%@ page language="java" pageEncoding="utf-8" contentType="text/html;charset=utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>index</title>
	<base href=" <%=basePath%>">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">

    <!-- Le styles -->
    <link href="assets/bootstrap/css/bootstrap.min.css" rel="stylesheet">
	<!--<link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css">-->
    <!--<link href="css/bootstrap-responsive.css" rel="stylesheet">-->


	<!-- Extra Styles, not needed for Mega Menu or Boostrap -->
	<link href="assets/mstp_26_mega/css/style.css" rel="stylesheet">
	<link href="assets/css/module1.css" rel="stylesheet">
	
	<!-- Mega Menu Style, you kinda really need Bootstrap in order for this to work -->
	<link href="assets/mstp_26_mega/css/mega-menu.css" rel="stylesheet">
	
	<!-- Le Google font -->
	<link href='http://fonts.googleapis.com/css?family=Karla:s400,400italic,700,700italic' rel='stylesheet' type='text/css'>
	<link href='http://fonts.googleapis.com/css?family=Lato:400,300' rel='stylesheet' type='text/css'>
	
	<!-- You can delete this later -->
	<style>
      body {
        padding-top: 60px; /* 60px to make the container go all the way to the bottom of the topbar */
      }
    </style>

</head>
<body>
	
    <header class="container">

		<nav class="navbar navbar-inverse navbar-fixed-top">
			<div class="container">
				<!-- Brand and toggle get grouped for better mobile display -->
				<div class="navbar-header">
					<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
						<span class="sr-only">Toggle navigation</span>
						<span class="icon-bar"></span>
						<span class="icon-bar"></span>
						<span class="icon-bar"></span>
					</button>
				</div>

				<!-- Collect the nav links, forms, and other content for toggling -->
				<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
					<ul class="nav navbar-nav navbar-right">
						<li><a href="#">题目 </a></li>
						<li class="dropdown">
							<a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">排行榜 <span class="caret"></span></a>
							<ul class="dropdown-menu mega-menu-3 transition">
								<li><a href="#">天梯榜</a></li>
								<li><a href="#">英雄榜</a></li>
							</ul>
						</li>
						<li class="dropdown">
							<a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">帮助 <span class="caret"></span></a>
							<ul class="dropdown-menu mega-menu-3 transition">
								<li><a href="#">Help 1</a></li>
								<li><a href="#">Help 2</a></li>
							</ul>
						</li>
						<li class="dropdown">
							<a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">
								<span class="glyphicon glyphicon-user"></span><span class="caret"></span></a>
							<div class="dropdown-menu mega-menu-3 transition  eader-user">
								<ul>
									<li class="nav-title"></li>
									<li>
										<iframe src="http://player.vimeo.com/video/15069551?title=0&amp;byline=0&amp;portrait=0" width="128" height="128" frameborder="0" webkitAllowFullScreen mozallowfullscreen allowFullScreen></iframe>
									</li>
								</ul>
								<ul class="two-column">
									<li class="nav-title"></li>
									<li><a href="#" class="header-user">用户名</a></li>
									<li><a href="#" class="header-user">等级_称号</a></li>
									<li><a href="#" class="header-user">金币</a></li>
									<li><a href="#" class="header-user">威望值</a></li>
								</ul>
								<ul class="three-column"></ul>
								<ul>
									<li>
										<a href="#" class="btn">个人中心</a>
									</li>
								</ul>
								<ul>
									<li>
										<a href="#" class="btn">游戏商城</a>
									</li>
								</ul>
								<ul>
									<li>
										<a href="#" class="btn">注销登录</a>
									</li>
								</ul>
							</div>
						</li>
					</ul><!-- 2 Menu Examples Ends -->
				</div><!-- /.navbar-collapse -->
			</div><!-- /.container-fluid -->
		</nav>



	</header><!-- /container -->
	
	<section class="container">
		<div class="page-header">
			<h1 style="font-family: 华文行楷" id="chapter"><strong>第一章:沈鹏杰的身世之谜</strong></h1>
		</div>
		
		<p class="lead" id="description">沈鹏杰的身份一直是个谜，现在让我们来一起揭开沈鹏杰的身份之谜!</p>
		
		<section class="row" style="height: 400px">
			<ul class="list-group" style="width: 80%;margin: auto">
				<li class="list-group-item task-item" id="task-item0">
					<span class="badge">未完成</span>任务000：探秘萧山
				</li>
				<li class="list-group-item task-item" id="task-item1">
					<span class="badge">未完成</span>任务一：探秘萧山
				</li>
				<li class="list-group-item task-item" id="task-item2">
					<span class="badge">未完成</span>任务二：神秘的别墅
				</li>
				<li class="list-group-item task-item" id="task-item3">
					<span class="badge">未完成</span>任务三：三分之二个萧山
				</li>
				<li class="list-group-item task-item" id="task-item4">
					<span class="badge">未完成</span>任务四：别墅内的飞机场</li>
				<li class="list-group-item task-item" id="task-item5">
					<span class="badge">未完成</span>任务五：别墅内迷路
				</li>
				<li class="list-group-item task-item" id="task-item6">
					<span class="badge">未完成</span>任务一：探秘萧山</li>
				<li class="list-group-item task-item" id="task-item7">
					<span class="badge">未完成</span>任务一：探秘萧山
				</li>
				<li class="list-group-item task-item" id="task-item8">
					<span class="badge">未完成</span>任务一：探秘萧山
				</li>
				<li class="list-group-item task-item" id="task-item9">
					<span class="badge">未完成</span>任务一：探秘萧山
				</li>
			</ul>
		</section><!-- Row -->
	</section><!-- Container -->
	
	<hr class="container">
	
	<footer class="container">
		<p>嘻嘻啊哈哈红红哈哈嘿嘿 <a href="#" target="_blank">吼吼</a></p>
	</footer><!-- Footer -->
	
    <!-- Le javascript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="http://code.jquery.com/jquery-latest.js"></script>
	<script src="assets/mstp_26_mega/js/bootstrap.min.js"></script>
	<script src="assets/js/problems.js"></script>
	<script>
		$('.carousel').carousel()
	</script>
	
  </body>
</html>
