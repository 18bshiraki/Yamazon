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
<script type="text/javascript"
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
<script type="text/javascript" src="js/yamazon.js"></script>
</head>
<body>
	<!-- header top section -->
	<section class="banner" role="banner">
		<header id="header">
			<div class="header-content clearfix">
				<a class="logo" href="menu"><img src="ロゴ.jpg"></a>
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
			<h2>商品更新入力</h2>
		</div>
		<div class="text-center" style="padding: 10px;">
			<h4>更新内容を右側の欄に入力・確認してください。</h4>
			<p>画像を変更しない場合はそのまま何もアップロードせず更新ボタンを押してください。</p>
			<c:if test="${not empty msg}">
				<h5>
					<span style="color: red;">${fn:escapeXml(msg)}</span>
				</h5>
			</c:if>
		</div>
	</section>

	<div class="text-center">
		<div class="container">
			<form action="goodsUpdateResult" enctype="multipart/form-data"
				method="post" style="color: black">
				<fieldset>
					<div style="padding: 10px; margin: 10px;">
						<label>商品ID</label> <input type="text" name="number"
							value="${fn:escapeXml(oldGoods.goodsNumber)}" readonly>
					</div>
				</fieldset>

				<ul class="foo">
					<li>
						<fieldset class="col" style="margin: 30px;">
							<legend>変更前</legend>
							<div class="row">
								<h5>商品名</h5>
								<div class="form-inline" style="padding: 8px;">
									<input type="text" class="form-control input-sm" name="name"
										size="45" value="${fn:escapeXml(oldGoods.goodsName)}" disabled>
								</div>
							</div>
							<div class="row">
								<h5>商品画像</h5>
								<div class="form-inline" style="padding: 8px;">
									<img src="${fn:escapeXml(sessionScope.goodsFile)}"
										style="width: 200px; height: auto;">
								</div>
							</div>
							<div class="row">
								<h5>商品説明</h5>
								<div class="form-inline" style="padding: 8px;">
									<textarea rows="5" cols="45" class="form-control input-sm"
										name="explain" disabled>${fn:escapeXml(oldGoods.goodsExplain)}</textarea>
								</div>
							</div>
							<div class="row">
								<h5>商品カテゴリー</h5>
								<div class="form-inline" style="padding: 8px;">
									<input type="text" class="form-control input-sm"
										name="category" size="15" value="${fn:escapeXml(oldGoods.category)}" disabled>
								</div>
							</div>
							<div class="row">
								<h5>商品数</h5>
								<div class="form-inline" style="padding: 8px;">
									<input type="text" class="form-control input-sm" name="stock"
										value="${fn:escapeXml(oldGoods.stock)}" size="20" disabled>個
								</div>
							</div>
							<div class="row">
								<h5>1個当たり単価(税抜き)</h5>
								<div class="form-inline" style="padding: 8px;">
									<input type="text" class="form-control input-sm" name="price"
										value="${fn:escapeXml(oldGoods.price)}" size="20" disabled>円
								</div>
							</div>
						</fieldset>
					</li>



					<li>
						<fieldset class="col label-110" style="margin: 30px;">
							<legend>変更後</legend>
							<div class="row">
								<h5>商品名</h5>
								<div class="form-inline" style="padding: 8px;">
									<input type="text" class="form-control input-sm" name="name"
										size="45" value="${fn:escapeXml(goods.goodsName)}">
								</div>
							</div>
							<div class="row">
								<h5>商品画像アップロード</h5>
								<div class="form-inline" style="padding: 8px;">
									<input type="file" class="form-control input-sm" name="file"
										size="45">
								</div>
								<div class="preview size"></div>
							</div>
							<div class="row">
								<h5>商品説明</h5>
								<div class="form-inline" style="padding: 8px;">
									<textarea rows="5" cols="45" class="form-control input-sm"
										name="explain">${fn:escapeXml(goods.goodsExplain)}</textarea>
								</div>
							</div>
							<div class="row">
								<h5>商品カテゴリー</h5>
								<div class="form-inline" style="padding: 8px;">
									<input type="text" class="form-control input-sm" name="category"
										size="45" value="${fn:escapeXml(goods.category)}">
								</div>
							</div>
							<div class="row">
								<h5>商品数</h5>
								<div class="form-inline" style="padding: 8px;">
									<input type="text" class="form-control input-sm" name="stock"
										size="20" value="${fn:escapeXml(goods.stock)}">個
								</div>
							</div>
							<div class="row">
								<h5>1個当たり単価(税抜き)</h5>
								<p>※数字のみで入力してください</p>
								<div class="form-inline" style="padding: 8px;">
									<input type="text" class="form-control input-sm" name="price"
										size="20" value="${fn:escapeXml(goods.price)}">円
								</div>
							</div>
						</fieldset>
					</li>
				</ul>
				<div class="text-center col-clear">
					<button type="submit" class="btn btn-success btn-xs">
						変更 <span class="glyphicon glyphicon-chevron-right"></span>
					</button>
				</div>
			</form>
			<form action="goodsSearchResult" method="post">
				<div class="text-center">
					<button type="submit" class="return btn-outline-dark"
						name="keyWord" value="${fn:escapeXml(keyWord)}">
						<span class="glyphicon glyphicon-chevron-left"></span>戻る
					</button>
				</div>
			</form>
		</div>
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
