<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
			<h2>商品削除確認</h2>
		</div>
		<div class="text-center" style="padding: 10px;">
			<h4>こちらの内容を削除してもよろしいですか？</h4>
		</div>
	</section>
	<div class="text-center">
		<form action="goodsDeleteResult.html" method="post"
			style="color: black;">
			<div class="container">
				<div class="row">
					<h5>商品ID</h5>
					<div class="form-inline" style="padding: 8px;">
						<input type="text" class="form-control input-sm" id="id" size="45"
							value="00001" readonly>
					</div>
				</div>
				<div class="row">
					<h5>商品名</h5>
					<div class="form-inline" style="padding: 8px;">
						<p>コーヒーメーカー</p>
					</div>
				</div>
				<div class="row">
					<h5>商品画像</h5>
					<div class="form-inline" style="padding: 8px;">
						<img src="コーヒーメーカ(修正後).jpg" class="size">
					</div>
				</div>
				<div class="row">
					<h5>商品説明</h5>
					<p>コーヒーメーカーです。</p>
				</div>
				<div class="row">
					<h5>商品カテゴリー</h5>
					<div class="form-inline" style="padding: 8px;">
						<p>コーヒーメーカー</p>
					</div>
				</div>
				<div class="row">
					<h5>商品数</h5>
					<div class="form-inline" style="padding: 8px;">
						<p>
							20<span>個</span>
						</p>
					</div>
				</div>
				<div class="row">
					<h5>1個当たり単価(税抜き)</h5>
					<div class="form-inline" style="padding: 8px;">
						<p>
							50000<span>円</span>
						</p>
					</div>
				</div>
			</div>
			<div class="text-center">
				<button type="submit" class="btn btn-success btn-xs">
					削除<span class="glyphicon glyphicon-chevron-right"></span>
				</button>
			</div>
			<div class="text-center">
				<a href="goodsDelete.html"><button type="button"
						class="return btn-outline-dark">
						<span class="glyphicon glyphicon-chevron-left"></span>戻る
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
