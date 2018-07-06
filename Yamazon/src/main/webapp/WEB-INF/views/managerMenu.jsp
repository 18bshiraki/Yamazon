<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!doctype html>
<html class="no-js" lang="">

<head>
<meta charset="UTF-8">
<meta name="description" content="">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" href="css/flexslider.css">
<link rel="stylesheet" href="css/jquery.fancybox.css">
<link rel="stylesheet" href="css/main.css">
<link rel="stylesheet" href="css/responsive.css">
<link rel="stylesheet" href="css/animate.min.css">
<link rel="stylesheet" href="css/font-icon.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
<style>
h4 {
	margin: 20px
}
<<<<<<< HEAD
</style>
<title>管理者メニュー</title>

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
	<section id="hero" class="section "></section>

	<section id="menu" class="section">
		<div class="text-center">
			<div class="container">
				<div class="row">
					<div class="menu">
						<ul class="primary">
							<li><h4>
									<a href="userSearch">ユーザーの検索</a>
								</h4></li>
							<c:if test="${manager==1}">
								<li><h4>
										<a href="managerInsert">管理者の登録</a>
									</h4></li>
								<li><h4>
										<a href="managerSelect">管理者情報</a>
									</h4></li>
							</c:if>
							<c:if test="${manager==2}">
								<li><h4>
										<a href="managerUpdate">管理者情報の更新</a>
									</h4></li>
							</c:if>
							<li><h4>
									<a href="goodsInsert">商品の登録</a>
								</h4></li>
							<li><h4>
									<a href="goodsSearch">商品の検索</a>
								</h4></li>
						</ul>
					</div>
				</div>
			</div>
		</div>
	</section>


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
=======
</style>
<title>管理者メニュー</title>
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
	<section id="hero" class="section "></section>
	<section id="menu" class="section">
		<div class="text-center">
			<div class="container">
				<div class="row">
					<div class="menu">
						<ul class="primary">
							<li><h4>
									<a href="userSearch">ユーザーの検索</a>
								</h4></li>
							<c:if test="${manager==1}">
								<li><h4>
										<a href="managerInsert">管理者の登録</a>
									</h4>
								</li>
								<li><h4>
										<a href="managerSelect">管理者情報</a>
									</h4></li>
							</c:if>
							<c:if test="${manager==2}">
								<li><h4>
										<a href="managerUpdate">管理者情報の更新</a>
									</h4></li>
							</c:if>
							<li><h4>
									<a href="goodsInsert">商品の登録</a>
								</h4></li>

							<li><h4>
									<a href="goodsSearch">商品の検索</a>
								</h4></li>
						</ul>
					</div>
				</div>
			</div>
		</div>
	</section>


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
>>>>>>> branch 'master' of https://github.com/18bshiraki/Yamazon.git
</html>