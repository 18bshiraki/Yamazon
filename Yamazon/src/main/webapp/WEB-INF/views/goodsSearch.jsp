<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<!--[if lt IE 7]>      <html class="no-js lt-ie9 lt-ie8 lt-ie7" lang=""> <![endif]-->
<!--[if IE 7]>         <html class="no-js lt-ie9 lt-ie8" lang=""> <![endif]-->
<!--[if IE 8]>         <html class="no-js lt-ie9" lang=""> <![endif]-->
<!--[if gt IE 8]><!-->
<html class="no-js" lang="">
<!--<![endif]-->
<head>
<meta charset="utf-8">
<meta name="description" content="">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Yamazon</title>
<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" href="css/flexslider.css">
<link rel="stylesheet" href="css/jquery.fancybox.css">
<link rel="stylesheet" href="css/main.css">
<link rel="stylesheet" href="css/responsive.css">
<link rel="stylesheet" href="css/animate.min.css">
<link rel="stylesheet" href="css/font-icon.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
</head>
<body>
	<!-- header top section -->
	<section class="banner" role="banner">
		<header id="header">
			<div class="header-content clearfix">
				<a class="logo" href="menu"><img src="ロゴ.jpg"></a>
				<nav class="navigation" role="navigation">
					<ul class="primary-nav">
						<li><a href="logout">Logout</a></li>
					</ul>
				</nav>
				<a href="#" class="nav-toggle">Menu<span></span></a>
			</div>
		</header>
	</section>

	<section id="hero" class="section ">
		<div class="hero text-center">
			<h2>商品検索</h2>
		</div>
		<div class="text-center" style="padding: 10px;">
			<h4>商品のキーワードを入力してください。空欄で検索すると全件表示します。</h4>
		</div>
	</section>

	<form:form action="goodsSearchResult" method="post"
		style="color: black; margin: 40px;">
		<div class="text-center">
			<div class="container">
				<div class="input-group">
				<%-- キーワード検索をします --%>
					<form:input class="form-control" path="keyWord" modelAttribute="yamazon" placeholder="キーワードを入力してください" style="padding: 6px;" />
					<span class="input-group-btn">
						<button class="btn btn-default" type="submit"
							style="padding: 8px 15px 3px 15px; margin: 0px 2px 0px 9px; width: 50px;">
							<i class='glyphicon glyphicon-search'></i>
						</button>
					</span>
				</div>
			</div>
		</div>
		<section id="hero" class="section "></section>
		<div class="text-center">
			<a href="managerMenu"><button type="button"
					class="return btn-outline-dark">
					<span class="glyphicon glyphicon-chevron-left"></span>管理者メニュー
				</button></a>
		</div>
	</form:form>

	<footer class="footer">
		<div class="container">
			<div class="col-md-6 left">
				<p>Yamazon運営チーム</p>
				<p>TEL:0120-117-117-828828</p>
			</div>
		</div>
	</footer>
	<!-- portfolio grid section -->
	<!-- service section -->


	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script src="js/jquery.fancybox.pack.js"></script>
	<script src="js/retina.min.js"></script>
	<script src="js/modernizr.js"></script>
	<script src="js/main.js"></script>
</body>
</html>
