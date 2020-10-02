<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<link rel="stylesheet" type="text/css" href="./css/main.css">
<link rel="stylesheet" type="text/css" href="./css/util.css">
<link rel="stylesheet" type="text/css" href="./vendor/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="./vendor/animate/animate.css">
<link rel="stylesheet" type="text/css" href="./vendor/css-hamburgers/hamburgers.min.css">
<link rel="stylesheet" type="text/css" href="./vendor/animsition/css/animsition.min.css">
<link rel="stylesheet" type="text/css" href="./vendor/select2/select2.min.css">
<link rel="stylesheet" type="text/css" href="./vendor/daterangepicker/daterangepicker.css">
<title>LOGIN</title>
<style type="text/css">
/*본문의 배경 그림을 지정한다.*/
body{
background-image: url("resources/img/backg1.jpg");
background-size: cover;
}
</style>
</head>
<body>

<!-- <h1>Login Page</h1> -->
<!-- 	<form action="./Login" method="post"> -->
<!-- 	<table>
	<tr>
	<td width="70">
	아이디
	</td>
	<td width="35">
	<input type="text" name="m_id">
	</td>
	<td rowspan="2" >
	<input type="submit" value="로그인" style="height: 50px">
	</td>
	</tr>
	<tr>
	<td>
	비밀번호
	</td>
	<td>
	<input ortype="passwd" name="m_password">
	</td>
	</tr>
	</table> -->
<div class="limiter">
		<div class="container-login100">
			<div class="wrap-login100"> 
				<form class="login100-form validate-form"action="./Login" method="post">
					
					<span class="login100-form-title p-b-26">
						Welcome
					</span>
					<span class="login100-form-title p-b-48">
						<i class="zmdi zmdi-font"></i>
					</span>

					<div class="wrap-input100 validate-input">
						<input class="input100" type="text" name="m_id" required>
						<span class="focus-input100" data-placeholder="ID"></span>
					</div>

					<div class="wrap-input100 validate-input">
						<span class="btn-show-pass">
							<i class="zmdi zmdi-eye"></i>
						</span>
						<input class="input100" type="password" name="m_password" required>
						<span class="focus-input100" data-placeholder="Password"></span>
					</div>
	
	<div class="container-login100-form-btn">
						<div class="wrap-login100-form-btn">
							<div class="login100-form-bgbtn"></div>
							<button class="login100-form-btn" type="submit">
								Login
							</button>
						</div>
					</div>
	</form>				
<!-- 	<input type="button" onclick="location.href='http://localhost:8088/spring/productlist'"  value = "회원가입"/>  -->
		<div class="text-center p-t-115">
						<span class="txt1">
							Don’t have an account?
						</span>
						

						<a class="txt2" href="./minsert">
							Sign Up
						</a>
					</div>
			</div>
		</div>
	</div>
	<div id="dropDownSelect1"></div>
	
<!--===============================================================================================-->
	<script src="./vendor/jquery/jquery-3.2.1.min.js"></script>
<!--===============================================================================================-->
	<script src="./vendor/animsition/js/animsition.min.js"></script>
<!--===============================================================================================-->
	<script src="./vendor/bootstrap/js/popper.js"></script>
	<script src="./vendor/bootstrap/js/bootstrap.min.js"></script>
<!--===============================================================================================-->
	<script src="./vendor/select2/select2.min.js"></script>
<!--===============================================================================================-->
	<script src="./vendor/daterangepicker/moment.min.js"></script>
	<script src="./vendor/daterangepicker/daterangepicker.js"></script>
<!--===============================================================================================-->
	<script src="./vendor/countdowntime/countdowntime.js"></script>
<!--===============================================================================================-->
	<script src="./js/main.js"></script>
</body>
</html>