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
<%-- onclickした時の画面遷移と値の送信 --%>
<script type="text/javascript">
	function MoveCheck() {
		if (confirm("この商品を削除しますか？")) {
			document.submitInfo.submit();
			document.submitInfo.action = "goodsDeleteResult";
			return true;
		} else {
			return false;
		}
	}
</script>
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
			<h2>商品検索結果</h2>
		</div>
	</section>
	<div class="text-center" style="margin: 0px 0px 20px 0px">
		<form:form action="goodsUpdateConfirm" name="submitInfo" modelAttribute="yamazon" method="get">
		<input type="hidden" name="keyWord" value="${keyWord}">
			<table class="table table-hover"
				style="color: black; width: 90%; margin: auto;">
				<thead>
					<tr>
						<th><h5>商品ID</h5></th>
						<th><h5>商品画像</h5></th>
						<th><h5>商品名</h5></th>
						<th><h5>カテゴリ</h5></th>
						<th><h5>値段(税抜き)</h5></th>
						<th><h5>値段(税込み)</h5></th>
						<th><h5>在庫</h5></th>
						<th><h5>商品説明</h5></th>
						<th></th>
						<th></th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="goods" items="${goods}">
						<tr>
							<td>${goods.goodsNumber}</td>
							<td><img src="${goods.goodsImage}" width="100" height="120"></td>
							<td style="width: 120px; height: auto;">${goods.goodsName}</td>
							<td>${goods.category}</td>
							<td>${goods.CPrice}</td>
							<td>${goods.CTaxPrice}</td>
							<td>${goods.stock}点</td>
							<td style="width: 350px; height: auto;">${goods.goodsExplain}</td>
							<td><button type="submit" name="number"
									value="${goods.goodsNumber}">更新</button></td>
							<td><button type="submit" name="number"
									value="${goods.goodsNumber}" onclick="return MoveCheck();">削除</button></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</form:form>
		<div class="text-center">
			<a href="goodsSearch"><button type="button"
					class="return btn-outline-dark">
					<span class="glyphicon glyphicon-chevron-left"></span>戻る
				</button></a>
		</div>
		<div class="text-center">
			<a href="managerMenu"><button type="button"
					class="return btn-outline-dark">
					<span class="glyphicon glyphicon-chevron-left"></span>管理者メニュー
				</button></a>
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
