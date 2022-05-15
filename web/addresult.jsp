<%@ page import="java.sql.*" %>
<%ResultSet resultset =null;%>
<%ResultSet resultset2 =null;%>
<HTML>
<HEAD>
       <title>Add result</title>
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
    <!-- Custom Theme files -->
<link href="css/style1.css" rel="stylesheet" type="text/css" media="all" />
<!-- //Custom Theme files -->
<!-- web font -->
<link href="//fonts.googleapis.com/css?family=Roboto:300,300i,400,400i,700,700i" rel="stylesheet">
<!-- //web font -->
</HEAD>
<BODY>
<%
    try{
//Class.forName("com.mysql.jdbc.Driver").newInstance();
Connection connection = 
         DriverManager.getConnection
            ("jdbc:derby://localhost:1527/criminaldb", "criminal", "root");
 String caseid=request.getParameter("type");
 String suspect=request.getParameter("type2");
       Statement statement = connection.createStatement() ;
       Statement statement2 = connection.createStatement() ;

       resultset =statement.executeQuery("select caseid from CRIMINAL.ADDCASE");
       resultset2 =statement2.executeQuery("select suspectname from CRIMINAL.ADDSUSPECT") ;
%>
<!-- main -->
	<div class="main-w3layouts wrapper">
		<h1>Add Result</h1>
		<div class="main-agileinfo">
		<div class="agileits-top">				
<form method="post" action="AddResultServlet">
 <input class="text" type="text" name="type" list="type" placeholder="Case-ID:" required="">
 <datalist id="type">
  <%  while(resultset.next()){ %>
  <option><%= resultset.getString(1)%></option>
  <% } %>
  </datalist>
    <input class="text" type="text" name="type2" list="type2" placeholder="Suspects:" required="">
                                        <datalist id="type2">
                                                 <%  while(resultset2.next()){ %>
            <option><%= resultset2.getString(1)%></option>
        <% } %>
    </datalist>        
    <input class="text" type="text" name="type3" placeholder="Note:" required="">
					<div class="wthree-text">					
						<div class="clear"> </div>
					</div>
                                        <input type="submit" value="submit">
                                        <input type="reset">                                      
				</form>
<Center><button style="alignment-adjust: central;color: green;background-color: black;" onclick="window.location.href='adminhome.html'">Home</button></center>				
			</div>
		</div>		
		<ul class="colorlib-bubbles">
			<li></li>
			<li></li>
			<li></li>
			<li></li>
			<li></li>
			<li></li>
			<li></li>
			<li></li>
			<li></li>
			<li></li>
		</ul>
	</div>
	<!-- //main -->    
        <script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<footer><center>&COPY; 2022 Criminal Investigation. All rights reserved.</center></footer>  
<%
//**Should I input the codes here?**
        }
        catch(Exception e)
        {
             out.println("wrong entry"+e);
        }
%>
</BODY>
</HTML>