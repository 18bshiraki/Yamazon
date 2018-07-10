<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!doctype html>
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
<style>
p {
	margin: 20px
}
</style>
<script type="text/javascript">
	function MoveCheck() {
		if (confirm("この情報を削除しますか？")) {
			document.submitInfo.submit();
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
	<section id="hero" class="section ">
		<div class="hero text-center">
			<h2>管理者情報</h2>
		</div>
	</section>

	<section id="portfolio">
		<div class="text-center">
			<div class="container">
				<div class="col-md-6 col-md-offset-3">
					<c:if test="${not empty msg}">
						<h4>
							<span class="text-danger">${msg}</span>
						</h4>
					</c:if>
					<form:form action="managerDeleteResult" name="submitInfo"
						modelAttribute="yamazon" method="get">
						<table class="table" style="color: black">
							<tr>
								<td><h5>管理者番号</h5></td>
								<td><h5>名前</h5></td>
								<td><h5>パスワード</h5></td>
								<td></td>
							</tr>
							<c:forEach var="manager" items="${list}">
								<tr>
									<td>${fn:escapeXml(manager.managerId)}</td>
									<td>${fn:escapeXml(manager.managerName)}</td>
									<td>${fn:escapeXml(manager.managerPassword)}</td>
									<td><button type="submit" name="managerId"
											value="${fn:escapeXml(manager.managerId)}"
											onclick="return MoveCheck();">削除</button></td>
								</tr>
							</c:forEach>
						</table>
					</form:form>
				</div>
			</div>
		</div>
		<div class="text-center">
			<a href="managerMenu"><button type="button"
					class="return btn-outline-dark">
					<span class="glyphicon glyphicon-chevron-left"></span>管理者メニュー
				</button></a>
		</div>
	</section>
	<section id="hero" class="section "></section>
	<section id="hero" class="section "></section>
	<section id="hero" class="section "></section>
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
</html>