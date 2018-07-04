<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
</head>
<body>
<!-- header top section -->
<section class="banner" role="banner">
 <header id="header">
    <div class="header-content clearfix"> <a class="logo" href="menu"><img src="ロゴ.jpg"></a>
      <nav class="navigation" role="navigation">
        <ul class="primary-nav">
         <li>山田造さん</li>
         <li><a href="account">Mypage</a></li>
          <li><a href="cart">Cart</a></li>
          <li><a href="login">Login</a></li>
          <li><a href="logout">Logout</a></li>
        </ul>
      </nav>
      <a href="#" class="nav-toggle">Menu<span></span></a> </div>
  </header>
</section>
<section id="hero" class="section ">
</section>
<div class="text-center">

          <h2>ユーザー更新画面</h2>
          <h3>山田造さん</h3>
  <section id="hero" class="section ">
</section>
 <div class="row">
    <h5>新しい電話番号</h5>
   <p> <h6><font color="red">※数字のみ入力してください（ハイフンなし）</h6></p>
    <div class="form-inline" style="padding: 8px;">
      <input type="text" class="form-control input-sm" id="phoneName" placeholder="新しい電話番号" size="45">
    </div>
  </div>
 <div class="row">
    <h5>新しい名前</h5>
    <div class="form-inline" style="padding: 8px;">
      <input type="text" class="form-control input-sm" id="userName" placeholder="新しい名前" size="45">
    </div>
  </div>
  <div class="row">
    <h5>新しい住所</h5>
    <div class="form-inline" style="padding: 8px;">
      <input type="text" class="form-control input-sm" id="address" placeholder="ご住所" size="45">
    </div>
  </div>
  <div class="row">
    <h5>新しいパスワード</h5>
    <div class="form-inline" style="padding: 8px;">
      <input type="password" class="form-control input-sm" placeholder="Password" size="45">
    </div>
    <h5>今までのパスワード</h5>
    <div class="form-inline" style="padding: 8px;">
      <input type="password" class="form-control input-sm" placeholder="Password" size="45">
    </div>
  </div>
  </div>
<div class="text-center">
    <button type="button" class="btn btn-success btn-xs" onclick="location.href='accountUpdateConfirm.html'; return false;">次へ <span class="glyphicon glyphicon-chevron-right"></span></button>
  </div>
<div class="text-center">
			<a href="account.html"><button type="button" class="return btn-outline-dark">
					<span class="glyphicon glyphicon-chevron-left"></span>戻る
				</button>
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
