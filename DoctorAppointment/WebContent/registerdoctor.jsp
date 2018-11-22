
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="register.css">
<title>Doctor Registration</title>
</head>
<body>
	<form action="registerdoctorservlet" method="post">
	 <h2> Sign Up as Doctor </h2><br><br>
	
	Enter username : <input type="text" name="dusername"><br><br>
 	Enter password : <input type="password" name = "dpassword" ><br><br>
 	Select Type :<br>
 	<select id="doctortype" name="doctortype">
	<option value="audiologist">Audiologist</option>
	<option value="cardiologist">Cardiologist</option>
	<option value="dentist">Dentist</option>
	<option value="ent specialist">ENT specialist</option>
	<option value="gynaecologist">Gynaecologist</option>
	<option value="psychiatrists">Psychiatrists</option>
	<option value="paediatrician">Paediatrician</option>
	</select><br><br>
         <input type = "submit" value= "REGISTER"><br>
	</form>
	
	
</body>
</html>