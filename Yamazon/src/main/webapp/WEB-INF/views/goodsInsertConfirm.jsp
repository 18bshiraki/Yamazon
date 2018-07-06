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
<link href="css/yamazon.css" rel="stylesheet">
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


	<!-- header top section -->
	<!-- header content section -->

	<!-- footer section -->

	<!-- JS FILES -->

	<section id="hero" class="section ">
		<div class="hero text-center">
			<h2>商品登録確認</h2>
		</div>
		<div class="text-center" style="padding: 10px;">
			<h4>こちらの内容で登録してもよろしいですか？</h4>
		</div>
	</section>
	<div class="text-center">
		<form:form action="goodsInsertResult" modelAttribute="yamazon" enctype="multipart/form-data"
			method="get" style="color: black">
			<div class="container">
				<div class="row">
					<h5>商品名</h5>
					<div class="form-inline" style="padding: 8px;">
						<input type="text" class="form-control input-sm" name="name"
							size="45" value="${goods.goodsName}" readonly>
					</div>
				</div>
				<div class="row">
					<h5>商品画像アップロード</h5>
					<div class="form-inline" style="padding: 8px;">
						<img src="コーヒーメーカ(修正後).jpg" class="size">
					</div>
				</div>
				<div class="row">
					<h5>商品説明</h5>
					<div class="form-inline" style="padding: 8px;">
						<textarea rows="5" cols="45" class="form-control input-sm"
							name="explain" readonly>コーヒーメーカーです</textarea>
					</div>
				</div>
				<div class="row">
					<h5>商品カテゴリー</h5>
					<div class="form-inline" style="padding: 8px;">
						<input type="text" class="form-control input-sm" name="category"
							size="15" value="コーヒーメーカー" readonly>
					</div>
				</div>
				<div class="row">
					<h5>商品数</h5>
					<div class="form-inline" style="padding: 8px;">
						<input type="text" class="form-control input-sm" name="stock"
							value="20" size="20" readonly>個
					</div>
				</div>
				<div class="row">
					<h5>1個当たり単価(税抜き)</h5>
					<p>※数字のみで入力してください</p>
					<div class="form-inline" style="padding: 8px;">
						<input type="text" class="form-control input-sm" name="price"
							value="50000" size="20" readonly>円
					</div>
				</div>
				<div class="row">
						<h5>1個当たり単価(税込み)</h5>
						<p>※自動算出です</p>
						<div class="form-inline" style="padding: 8px;">
							<input type="text" class="form-control input-sm" name="taxPrice"
								value="54000" size="20" readonly>円
						</div>
				</div>
			</div>
			<div class="text-center">
				<button type="submit" class="btn btn-success btn-xs">
					登録 <span class="glyphicon glyphicon-chevron-right"></span>
				</button>
			</div>
			<div class="text-center">
				<a href="goodsInsert"><button type="button"
						class="return btn-outline-dark">
						<span class="glyphicon glyphicon-chevron-left"></span>戻る
					</button></a>
			</div>
		</form:form>
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
