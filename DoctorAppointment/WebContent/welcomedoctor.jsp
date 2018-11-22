
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="importer.patients" %>
<html>
<head>
<link rel="stylesheet" href="welcomedoctor.css">
<title>Insert title here</title>
</head>
<body>

<div id="left">
<%response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");

if(session.getAttribute("doctorusername")==null)
	response.sendRedirect("firsthomepage.jsp");
%>
<%
String st = (String)session.getAttribute("doctorusername");
%>
<h2> welcome <%=session.getAttribute("doctorusername") %></h2><br><br>
<h3> how was your day ...</h3>
<br>
<br><br>
<form action="logoutdoctorservlet" method = "post">
<input type="submit" value="logout">
</form><br><br>
</div>
<div id="right">
<button id="btn" onclick=getpatientlist("<%=st %>") >My APPOINTMENTS</button><br><br>
<div id="appointments">
</div><br><br>

</div>
<div id="bottom">
<button id="btn2" onclick=getpreviouspatientlist("<%=st %>")>Previous APPOINTMENTS</button><br><br>
<div id="previousappointments"></div>
</div>
<div id="bottomright"></div>

<div id="chatarea">
<form action="xxx">
Select Doctor : <br><br>

</form>

</div>
<br><br>
<div id="chatdiv">

<button id="list" onclick=filllist("<%= st %>")>
Select Patient to Chat With
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
<button onclick=sendmsg("<%= st %>")>SEND</button><br><br>

</div>

<script type="text/javascript" src="welcomedoctorjs.js"></script>
</body>
</html>