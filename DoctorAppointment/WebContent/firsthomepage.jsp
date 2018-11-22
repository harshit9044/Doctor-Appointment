
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="firsthomepage.css">
<title> LOGIN OR SIGNUP </title>
</head>
<body>
	<div class="header"><br><h1>DoctorAppointment Application</h1></div><br>
	<div class="block"><br>
	<h3> LOGIN AS PATIENT </h3><br>
	<form action="loginpatientservlet" method="post">
	Enter Username : <input type="text" name="pusername"><br><br>
	Enter Password : <input type="password" name="ppassword"><br><br>
	               <input type="submit" value="Login"><br><br>
	</form>
	OR<br><br>
	<a href="registerpatient.jsp">Register as Patient</a><br><br><br>
	</div><br>
	<div class="block"><br>
	<h3> LOGIN AS DOCTOR </h3><br><br>
	<form action="logindoctorservlet" method="post">
	Enter Username : <input type="text" name="dusername"><br><br>
	Enter Password : <input type="password" name="dpassword"><br><br>
	               <input type="submit" value="Login"><br><br>
	</form>
	OR<br><br>
	<a href="registerdoctor.jsp">Register as Doctor</a><br><br><br>
	</div>
</body>
</html>