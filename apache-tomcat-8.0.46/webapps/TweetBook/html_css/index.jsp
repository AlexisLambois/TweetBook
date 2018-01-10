<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>TweetBook</title>
	<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
	<script type="text/javascript" src="main.js"></script>
	<link href="style.css" rel="stylesheet">
</head>
<body>

	<div class="cont_principal">
  		<div class="cont_centrar">
  			<div class="cont_login">
  				<form action="">
    				<div class="cont_tabs_login">
      					<ul class='ul_tabs'>
        					<li class="active">
        						<a href="#" onclick="sign_in()">SIGN IN</a>
        						<span class="linea_bajo_nom"></span>
       						</li>
        					<li>
        						<a href="#up" onclick="sign_up()">SIGN UP</a>
        						<span class="linea_bajo_nom"></span>
        					</li>
      					</ul>
      				</div>
 					<div class="cont_text_inputs">
 						
      					<input type="text" class="input_form_sign " placeholder="LOGIN" name="login" />
    					<input type="text" class="input_form_sign d_block active_inp" placeholder="EMAIL" name="email" />
    					
						<input type="password" class="input_form_sign d_block  active_inp" placeholder="PASSWORD" name="pass_us" />
						<input type="password" class="input_form_sign" placeholder="CONFIRM PASSWORD" name="conf_pass_us" />
						<input type="text" class="input_form_sign " placeholder="FIRSTNAME" name="firstname" />
 						<input type="text" class="input_form_sign " placeholder="NAME" name="name" />
						
    					<a href="#" class="link_forgot_pass d_block" >Forgot Password ?</a>    
						<div class="terms_and_cons d_none">
    						<p><input type="checkbox" name="terms_and_cons"/> <label for="terms_and_cons">I'm not Robot</label></p>
						</div>
					</div>
					<div class="cont_btn">
						<button class="btn_sign">SIGN IN</button>
					</div>
    			</form>
    		</div>
    	</div>
    </div>
	
	<script language="JavaScript">
		
	</script>
</body>
</html>