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
<script type="text/javascript"
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
<script type="text/javascript" src="js/yamazon.js"></script>
</head>
<body>
	<!-- header top section -->
	<section class="banner" role="banner">
		<header id="header">
			<div class="header-content clearfix">
				<a class="logo" href="menu.html"><img src="ロゴ.jpg"></a>
				<nav class="navigation" role="navigation">
					<ul class="primary-nav">
						<li><a href="logout.html">Logout</a></li>
					</ul>
				</nav>
				<a href="#" class="nav-toggle">Menu<span></span></a>
			</div>
		</header>
	</section>


	<!-- header top section -->
	<!-- header content section -->

	<!-- footer section -->

	<!-- JS FILES -->

	<section id="hero" class="section ">
		<div class="hero text-center">
			<h2>商品登録</h2>
		</div>
		<div class="text-center" style="padding: 10px;">
			<h4>登録内容を入力してください</h4>
		</div>
	</section>
	<div class="text-center">
		<form action="goodsInsertConfirm.html" enctype="multipart/form-data"
			method="post">
			<div class="container">
				<div class="row">
					<h5>商品名</h5>
					<div class="form-inline" style="padding: 8px;">
						<input type="text" class="form-control input-sm" id="name"
							placeholder="商品名" size="45" value="コーヒーメーカー">
					</div>
				</div>
				<div class="row">
					<h5>商品画像アップロード</h5>
					<div class="form-inline" style="padding: 8px;">
						<input type="file" class="form-control input-sm" id="file"
							size="45">
					</div>
					<div class="preview"></div>
				</div>
				<div class="row">
					<h5>商品説明</h5>
					<div class="form-inline" style="padding: 8px;">
						<textarea rows="5" cols="45" class="form-control input-sm"
							id="description">コーヒーメーカーです</textarea>
					</div>
				</div>
				<div class="row">
					<h5>商品カテゴリー</h5>
					<div class="form-inline" style="padding: 8px;">
						<select class="form-control input-sm" id="category">
							<option value="1">コーヒーメーカ－</option>
							<option value="2">炊飯器</option>
							<option value="3">ホットプレート</option>
						</select>
					</div>
				</div>
				<div class="row">
					<h5>商品数</h5>
					<div class="form-inline" style="padding: 8px;">
						<input type="text" class="form-control input-sm" id="stock"
							placeholder="商品数" size="20" value="20">個
					</div>
				</div>
				<div class="row">
					<h5>1個当たり単価(税抜き)</h5>
					<p>※数字のみで入力してください</p>
					<div class="form-inline" style="padding: 8px;">
						<input type="text" class="form-control input-sm" id="unitPrice"
							placeholder="単価" size="20" value="50000">円
					</div>
				</div>
			</div>
			<div class="text-center">
				<button type="submit" class="btn btn-success btn-xs">
					登録確認<span class="glyphicon glyphicon-chevron-right"></span>
				</button>
			</div>
			<div class="text-center">
				<a href="managerMenu.html"><button type="button"
						class="return btn-outline-dark">
						<span class="glyphicon glyphicon-chevron-left"></span>管理者メニュー
					</button></a>
			</div>
		</form>
	</div>
<footer class="footer">
  <div class="container">
    <div class="col-md-6 left">
      <p>Yamazon運営チーム</p>
      <p>TEL:0120-117-117-828828</p>
    </div>
  </div>
</footer>

	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script src="js/jquery.fancybox.pack.js"></script>
	<script src="js/retina.min.js"></script>
	<script src="js/modernizr.js"></script>
	<script src="js/main.js"></script>
</body>
</html>
