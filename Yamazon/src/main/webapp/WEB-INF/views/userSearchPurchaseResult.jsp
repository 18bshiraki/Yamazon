<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

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
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
<style>
p{
margin: 20px
}
</style>
</head>
<body>
<!-- header top section -->
<section class="banner" role="banner">
 <header id="header">
    <div class="header-content clearfix"> <a class="logo" href="menu"><img src="ロゴ.jpg"></a>
      <nav class="navigation" role="navigation">
        <ul class="primary-nav">
          <li><a href="logout">Logout</a></li>
        </ul>
      </nav>
      <a href="#" class="nav-toggle">Menu<span></span></a> </div>
  </header>
</section>
<section id="hero" class="section">
<div class ="hero text-center">
<h2>
ユーザー購入履歴
</h2>
</div>
</section>
<div class ="text-center">
<div class="caption-content">

<h3>${sessionScope.userList.userName}さんの購入履歴</h3>

</div>
</div>
<div class="col-sm-3">
     <div class="caption-content">
     </div>
 </div>
<div class="container">
	<div class="col-sm-7">
	<div class="caption-content">
	<div class ="hero text-center">
	<form:form action = "purchaseResult" modelAttribute = "yamazon">
		<table class="table" style="color:black">
			<thead>
				<tr>
					<td><h5>購入日時</h5></td>
					<td><h5>購入した商品</h5></td>
					<td><h5>値段(税抜き)</h5></td>
				</tr>
			</thead>
			<tbody>
			<c:forEach var="purchase" items="${purchase}">
					<tr>
					<td>${purchase.purchaseHistory}</td>
					<td>${purchase.goodsName}</td>
					<td>${purchase.taxPrice}</td>
				</tr>
				</c:forEach>
			</tbody>
		</table>
		</form:form>
		</div>
		</div>
		</div>
		</div>

			<div class="text-center">
			<a href="userSearchResult"><button type="button" class="return btn-outline-dark">
					<span class="glyphicon glyphicon-chevron-left"></span>戻る
				</button>
			</a>
		</div>

		<div class="text-center">
			<a href="managerMenu"><button type="button" class="return btn-outline-dark">
					<span class="glyphicon glyphicon-chevron-left"></span>管理者メニュー
				</button>
			</a>
		</div>
	<section id="hero" class="section"></section>
<footer class="footer">
  <div class="container">
    <div class="col-md-6 left">
      <p>Yamazon運営チーム</p>
      <p>TEL:0120-117-117-828828</p>
    </div>
  </div>
</footer>



<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/jquery.fancybox.pack.js"></script>
<script src="js/retina.min.js"></script>
<script src="js/modernizr.js"></script>
<script src="js/main.js"></script>
</body>
</html>