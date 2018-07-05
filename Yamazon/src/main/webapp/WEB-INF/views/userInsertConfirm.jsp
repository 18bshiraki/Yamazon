<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!doctype html>

<html class="no-js" lang="">
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
</head>
<body>
<!-- header top section -->
<section class="banner" role="banner">
 <header id="header">
    <div class="header-content clearfix"> <a class="logo" href="menu"><img src="ロゴ.jpg"></a>
      <nav class="navigation" role="navigation">
        <ul class="primary-nav">
          <li><a href="login">Login</a></li>
        </ul>
      </nav>
      <a href="#" class="nav-toggle">Menu<span></span></a> </div>
  </header>
</section>

<section id="hero" class="section ">
 <div class="hero text-center">
          <h2>ユーザー登録確認</h2>
        </div>
</section>
<form:form action="userInsertResult" method="post" modelAttribute="yamazon">
<div class="text-center">
<div class="container">
  <div class="row">
    <h4>ユーザー名</h4>
    <div class="form-inline" style="padding: 5px;">
      <form:input type="text" class="form-control input-sm" placeholder="お名前" size="45" path="name" readonly="true" />
    </div>
  </div>
  <div class="row">
    <h4>電話番号<small><font color="red">※数字のみ入力してください</font></small></h4>
    <div class="form-inline" style="padding: 5px;">
      <form:input type="text" class="form-control input-sm" placeholder="電話番号" size="45" path="tel" readonly="true" />
    </div>
  </div>
  <div class="row">
    <h4>住所</h4>
    <div class="form-inline" style="padding: 5px;">
      <form:input type="text" class="form-control input-sm" placeholder="住所" size="45" path="address" readonly="true" />
    </div>
  </div>
  <div class="row">
    <h4>パスワード</h4>
    <div class="form-inline" style="padding: 5px;">
      <form:input type="text" class="form-control input-sm" placeholder="Password" size="45" path="pass" readonly="true" />
    </div>
  </div>
</div>
  <div class="text-center">
    <form:button class="btn btn-success btn-xs">登録<span class="glyphicon glyphicon-chevron-right"></span></form:button>
  </div>
</div>
  </form:form>
		<div class="text-center">
			<a href="userback"><button type="button" class="return btn-outline-dark">
				<span class="glyphicon glyphicon-chevron-left"></span>戻る</button>
			</a>
		</div>

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