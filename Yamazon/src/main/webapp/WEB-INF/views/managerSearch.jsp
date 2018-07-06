<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
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
<script type="text/javascript">
	function MoveCheck() {
		if (confirm("この情報を削除しますか？")) {
			window.location.href = "managerDeleteResult";
		}
	}
</script>
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
<section id="hero" class="section ">
  <div class ="hero text-center">
    <h2>管理者情報</h2>
  </div>
</section>

<section id="portfolio">
  <div class="text-center">
    <div class="container">
      <div class="col-md-6 col-md-offset-3">
        <table class="table" style="color:black">
      <tr>
        <td><h5>管理者番号</h5></td><td><h5>名前</h5></td><td><h5>パスワード</h5></td><td></td>
      </tr>
      <tr>
        <td>2</td><td>佐藤</td><td>2400368866</td><td><button type="submit" value="" onclick="MoveCheck();">削除</button></td>
      </tr>
      <tr>
         <td>3</td><td>鈴木</td><td>4583658436</td><td><button type="submit" value="" onclick="MoveCheck();">削除</button></td>
      </tr>
      </table>
      </div>
    </div>
  </div>
<div class="text-center">
    <a href = "managerMenu"><button type="button" class="return btn-outline-dark"><span class="glyphicon glyphicon-chevron-left"></span>管理者メニュー</button></a>
</div>
</section>
<section id="hero" class="section ">
</section>
<section id="hero" class="section ">
</section>
<section id="hero" class="section ">
</section>
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