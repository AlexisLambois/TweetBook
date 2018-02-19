<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>TweetBook</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/login.css">
<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">

</head>
<body>
	<div class="cotn_principal">
		<div class="cont_centrar">

			<div class="cont_login">
				<div class="cont_info_log_sign_up">
					<div class="col_md_login">
						<div class="cont_ba_opcitiy">

							<h2>LOGIN</h2>
							<p>
								<br> <br>
							</p>
							<button class="btn_login" onclick="cambiar_login()">LOGIN
								!!!</button>
						</div>
					</div>
					<div class="col_md_sign_up">
						<div class="cont_ba_opcitiy">
							<h2>SIGN UP</h2>


							<p>
								It's FREE<br> <br>
							</p>

							<button class="btn_sign_up" onclick="cambiar_sign_up()">SIGN
								UP !!!</button>
						</div>
					</div>
				</div>


				<div class="cont_back_info">
					<div class="cont_img_back_grey">
						<img
							src="https://images.unsplash.com/42/U7Fc1sy5SCUDIu4tlJY3_NY_by_PhilippHenzler_philmotion.de.jpg?ixlib=rb-0.3.5&q=50&fm=jpg&crop=entropy&s=7686972873678f32efaf2cd79671673d"
							alt="" />
					</div>

				</div>
				<div class="cont_forms">
					<div class="cont_img_back_">
						<img
							src="https://images.unsplash.com/42/U7Fc1sy5SCUDIu4tlJY3_NY_by_PhilippHenzler_philmotion.de.jpg?ixlib=rb-0.3.5&q=50&fm=jpg&crop=entropy&s=7686972873678f32efaf2cd79671673d"
							alt="" />
					</div>
					<div class="cont_form_login">
						<a href="#" onclick="ocultar_login_sign_up()"><i
							class="material-icons">&#xE5C4;</i></a>
						<h2>LOGIN</h2>
						<form method="POST" action="j_security_check">
							<input type="text" placeholder="Email or Login" name="j_username"/>
							<input type="password" placeholder="Password" name="j_password"/>
							<input type="submit" value="LOGIN" class="btn_login" />
						</form>
					</div>

					<div class="cont_form_sign_up">
						<a href="#" onclick="ocultar_login_sign_up()"><i
							class="material-icons">&#xE5C4;</i></a>
						<h2>SIGN UP</h2>
						<form action="./../servlet/inscrp_user">
							<input type="email" autocomplete="on" placeholder="Email"
								name="email" required /> <input type="text" autocomplete="on"
								placeholder="Login" name="login" required /> <input type="text"
								autocomplete="on" placeholder="User Name" name="name" required />
							<input type="text" autocomplete="on" placeholder="User FirstName"
								name="firstname" required /> <input type="password"
								autocomplete="on" placeholder="Password" name="password"
								required /> <input type="password" autocomplete="on"
								placeholder="Confirm Password" name="password2" required /> <input
								class="btn_sign_up" type="submit" value="SIGN UP" />
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
	<script src="${pageContext.request.contextPath}/js/login.js"></script>
</body>
</html>