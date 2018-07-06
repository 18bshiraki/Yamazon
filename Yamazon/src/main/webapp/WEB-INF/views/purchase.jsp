<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
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
						<li><a href="menu">Mypage</a></li>
						<li><a href="cart">Cart</a></li>
						<li><a href="login">Login</a></li>
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
			<h2>商品購入</h2>
		</div>
	</section>
	<div class="text-center" style="margin: 0px 0px 100px 0px">
		<form:form modelAttribute="yamazon" action="buy">
			<div class="container">
				<div class="caption-content">
					<h4 class="text-left">お届け先住所</h4>
					<h5 class="text-left">
						<c:out value="${sessionScope.user.address}" />
					</h5>
					<br> <br>
				</div>
				<div class="col-sm-9">
					<table class="table table-striped" style="color: black">
						<tr>
							<td>商品名</td>
							<td>金額</td>
						</tr>

						<c:forEach var="goods" items="${goods}">
							<tr>
								<td><h5>${fn:escapeXml(goods.goodsName)}</h5></td>
								<td><h5>${fn:escapeXml(goods.taxPrice)}</h5></td>
							</tr>
						</c:forEach>
						<tr>
							<th></th>
							<th>合計</th>
						</tr>
						<tr>
							<td></td>
							<td>${sum}<form:hidden path="sum" value="${sum}" /></td>
						</tr>
						<tr>

							<th></th>
							<th>5%引き</th>
						</tr>
						<tr>
							<td></td>
							<td>${sum5}<form:hidden path="sum5" value="${sum5}" /></td>
						</tr>

					</table>
				</div>

				<div>
					<form:button class="btn btn-success">
					購入<span class="glyphicon glyphicon-chevron-right"></span>
					</form:button>
				</div>

			</div>
		</form:form>
		<div class="text-center">
			<a href="cart"><button type="button"
					class="return btn-outline-dark">
					<span class="glyphicon glyphicon-chevron-left"></span>戻る
				</button></a>
		</div>
		<div class="col-sm-2">
			<div class="caption-content"></div>
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