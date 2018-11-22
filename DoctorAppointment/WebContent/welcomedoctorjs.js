onerror = errorHandler 
function errorHandler(message,url,line)
{
	  out="an error occured \n"
	  out+="Error : " + message + "\n"
	  out+="url : " + url + "\n"
	  out+="line : " + line + "\n"
	  alert(out)
	  return true
	  
}

function getpatientlist(doctorname){
	
	var params="docname=" + doctorname;
	var app = document.getElementById("appointments");
	var ourrequest= new XMLHttpRequest();
	ourrequest.open("POST","patientlistservlet",true);
	ourrequest.setRequestHeader("Content-type",
    "application/x-www-form-urlencoded")
  ourrequest.setRequestHeader("Content-length", params.length)
  ourrequest.setRequestHeader("Connection", "close")
  ourrequest.onload = function(){
		if(this.readyState == 4 && this.status ==200)
			{
				var ourdata = JSON.parse(ourrequest.responseText);
				var len = ourdata.length;
				var str="<table><tr><th> Patient's Name   </th><th>Date </th></tr>";
				//app.insertAdjacentHTML("beforeend","<table>");
				for(var i=0;i<len;i++)
					{
						str += "<tr>"+ "<td>"+ourdata[i].name +"</td><td>"+ourdata[i].date +"</td>" +"</tr>"
					}
				str += "</table>";
				
				app.insertAdjacentHTML("beforeend",str);
			}
	};
	ourrequest.send(params);
};
var docname ;
function getpreviouspatientlist(doctorname){
	window.docname = doctorname ;
	var params="docname=" + doctorname;
	var app = document.getElementById("previousappointments");
	var ourrequest= new XMLHttpRequest();
	ourrequest.open("POST","previouspatientlistservlet",true);
	ourrequest.setRequestHeader("Content-type",
    "application/x-www-form-urlencoded")
  ourrequest.setRequestHeader("Content-length", params.length)
  ourrequest.setRequestHeader("Connection", "close")
  ourrequest.onload = function(){
		if(this.readyState == 4 && this.status ==200)
			{
				var ourdata = JSON.parse(ourrequest.responseText);
				var len = ourdata.length;
				var str="<table><tr><th> Patient's Name   </th><th>Date </th></tr>";
				//app.insertAdjacentHTML("beforeend","<table>");
				for(var i=0;i<len;i++)
					{
						str += "<tr>"+ "<td>"+ourdata[i].name +"</td><td>"+ourdata[i].date +"</td>" +"</tr>"
					}
				str += "</table>";
				
				app.insertAdjacentHTML("beforeend",str);
			}
	};
	ourrequest.send(params);
};

function filllist(doc){
	window.docname = doc ;
	var btn = document.getElementById("list");
	var count = 0;
	var params="username=" + doc;
	var ourrequest = new XMLHttpRequest();
	ourrequest.open('POST','filllistservletdoc',true);
	ourrequest.setRequestHeader("Content-type",
    "application/x-www-form-urlencoded")
  ourrequest.setRequestHeader("Content-length", params.length)
  ourrequest.setRequestHeader("Connection", "close")
  ourrequest.onload = function(){

		if(this.readyState == 4 && this.status == 200){
			var ourdata = JSON.parse(ourrequest.responseText);
			var final = '<select id="tochatwith" name="tochatwith" onchange="bringchatwindow()">';
			final += "<option>Choose Patient</option>"
			for(var i=0;i<ourdata.length;i++)
				{
					final += "<option value=\""+ourdata[i] + "\">" + ourdata[i] + "</option>";
				}
			final += "</select><br><br>" ;
			document.getElementById("chatlist").insertAdjacentHTML("afterbegin",final) ;
		}
		
	};
	ourrequest.send(params);
	count++;
	if(count==1)
		btn.style.visibility = 'hidden';
};

function sendmsg(sender){
	//document.getElementById("test").innerHTML = "fine1";
	var receiver = document.getElementById('tochatwith').value;
	
	//document.getElementById("test").innerHTML = "fine2";
	var msg = document.getElementById('msg').value;
	//document.getElementById("test").innerHTML = "fine3";

	//document.getElementById("test").innerHTML = "fine4";

	var params = "receiver="+ receiver + "&sender=" + sender + "&message=" + msg ;
	//document.getElementById("test").innerHTML = "fine5";

	var ourrequest = new XMLHttpRequest();
	//document.getElementById("test").innerHTML = "fine6";

	ourrequest.open('POST','doctorsendmsgservlet',true);
	ourrequest.setRequestHeader("Content-type",
    "application/x-www-form-urlencoded")
  ourrequest.setRequestHeader("Content-length", params.length)
  ourrequest.setRequestHeader("Connection", "close")
  	//document.getElementById("test").innerHTML = "fine7";

  ourrequest.onload = function(){
	  
		//document.getElementById("test").innerHTML = "fine8";
		if(this.readyState == 4 && this.status == 200 )
			{
				document.getElementById('msg').value = '';
			}
		//document.getElementById("test").innerHTML = "fine9";
	};
	ourrequest.send(params);
	
};

function bringchatwindow(){
	//document.getElementById("test").innerHTML = 1 ;
	var receiver = document.getElementById('tochatwith').value;
	//document.getElementById("test").innerHTML = 2 ;
	var params = "sender=" + window.docname + "&receiver=" + receiver;
	//document.getElementById("test").innerHTML = 3 ;
	var ourrequest = new XMLHttpRequest();
	//document.getElementById("test").innerHTML = 4 ;
	ourrequest.open('POST','fillchatboxservlet',true);
	ourrequest.setRequestHeader("Content-type",
    "application/x-www-form-urlencoded")
    ourrequest.setRequestHeader("Content-length", params.length)
    ourrequest.setRequestHeader("Connection", "close");
	//document.getElementById("test").innerHTML = 5 ;
	ourrequest.onload = function(){
		//document.getElementById("test").innerHTML = 6 ;
		if( this.readyState == 4 && this.status == 200)
			{
			//document.getElementById("test").innerHTML = 7 ;
				var ourdata = JSON.parse(ourrequest.responseText);
			//document.getElementById("test").innerHTML = ourdata[0] ;
			
			var str = "";
			
			for(var i=0 ; i < ourdata.length ; i++)
				{
					str += ourdata[i][0] + " : " + ourdata[i][1] +"<br>" + ourdata[i][2] + "<br><br>";
				}
			
			document.getElementById("msgdisplay").innerHTML = str ;
				
			}
			
	};
	
	ourrequest.send(params);
	window.setInterval(bringchatwindow , 3000 );
};