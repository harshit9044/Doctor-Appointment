<%@ taglib prefix="sq" uri="http://java.sun.com/jsp/jstl/sql"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="welcomepatient.css">
<title>Patient's Homepage</title>
</head>
<body>

<%
	response.setHeader("Cache-Control","no-cache,no-store,must-revalidate");
if(session.getAttribute("patientusername")==null)
	response.sendRedirect("firsthomepage.jsp");
%>
<% String username = (String) session.getAttribute("patientusername"); %>
<br>
<h2> welcome <%=username %><br>
how was your day ...</h2>
<br>
<br>
<br>
<%@ page import="java.util.*"%>
<%@ page import="java.text.SimpleDateFormat"%>
<%
	Date objdate =new Date();
	out.println(objdate.toString());
	Calendar calendar = Calendar.getInstance();
	calendar.setTime(objdate);
	
	SimpleDateFormat simpledate = new SimpleDateFormat("dd-MM-yyyy");
	String day0 = simpledate.format(objdate);
	
	calendar.add(Calendar.DATE,1);
	objdate = calendar.getTime();
	String day1=simpledate.format(objdate);
	
	calendar.add(Calendar.DATE,1);
	objdate=calendar.getTime();
	String day2=simpledate.format(objdate);
	
	calendar.add(Calendar.DATE,1);
	objdate=calendar.getTime();
	String day3=simpledate.format(objdate);
	
	calendar.add(Calendar.DATE,1);
	objdate = calendar.getTime();
	String day4=simpledate.format(objdate);
	
	calendar.add(Calendar.DATE,1);
	objdate = calendar.getTime();
	String day5=simpledate.format(objdate);
	
	calendar.add(Calendar.DATE,1);
	objdate=calendar.getTime();
	String day6=simpledate.format(objdate);
	
%>
<br><br>
<div id="2"><br>
<form action="patientappointmentservlet" method="post">
	Enter Patient's name :<br>
	<input type="text" name="patientname"><br><br>
	
	Select doctor field:<br>
	<select id="doctortype" name="doctortype" onchange="populate(this.id,'doctorname')">
	<option >Select doctor type</option>
	<option value="audiologist">Audiologist</option>
	<option value="cardiologist">Cardiologist</option>
	<option value="dentist">Dentist</option>
	<option value="ent specialist">ENT specialist</option>
	<option value="gynaecologist">Gynaecologist</option>
	<option value="psychiatrists">Psychiatrists</option>
	<option value="paediatrician">Paediatrician</option>
	</select><br><br>
	Select doctor :<br>
	<select id="doctorname" name="doctorname"></select><br><br>
    Select the appointment day:<br>
	<select id="date" name="date">
	<option value="<%=day0 %>"><%=day0 %></option>
	<option value="<%=day1 %>"><%=day1 %></option>
	<option value="<%=day2 %>"><%=day2 %></option>
	<option value="<%=day3 %>"><%=day3 %></option>
	<option value="<%=day4 %>"><%=day4 %></option>
	<option value="<%=day5 %>"><%=day5 %></option>
	<option value="<%=day6 %>"><%=day6 %></option>
	</select><br><br>
	<input type="submit" value="Get Appointment">
	
</form>

<form action="logoutpatientservlet" method="post">
<input type="submit" value="logout">
</form>
</div>
<br><br>
<div id="chatdiv">

<button id="list" onclick=filllist("<%= username %>")>
Select Doctor to Chat With
</button><br><br>
<div id="chatlist">

</div>
<div id="msgdisplay" >


Play with different overflow property values.

To demonstrate the different property values, this text is repeated several times.

Play with different overflow property values.

To demonstrate the different property values, this text is repeated several times.

Play with different overflow property values.

To demonstrate the different property values, this text is repeated several times.

Play with different overflow property values.

To demonstrate the different property values, this text is repeated several times.



Play with different overflow property values.

To demonstrate the different property values, this text is repeated several times.

Play with different overflow property values.

To demonstrate the different property values, this text is repeated several times.

Play with different overflow property values.

To demonstrate the different property values, this text is repeated several times.

Play with different overflow property values.

To demonstrate the different property values, this text is repeated several times.


Play with different overflow property values.

To demonstrate the different property values, this text is repeated several times.

Play with different overflow property values.

To demonstrate the different property values, this text is repeated several times.

Play with different overflow property values.

To demonstrate the different property values, this text is repeated several times.

Play with different overflow property values.

To demonstrate the different property values, this text is repeated several times.

</div><br>
<textarea rows="3" cols="30" id="msg"></textarea><br><br>
<button onclick=sendmsg("<%= username %>")>SEND</button><br><br>

</div>




<div id="test">kk</div>
<script type="text/javascript" src="welcomepatientjs.js"></script>
</body>
</html>