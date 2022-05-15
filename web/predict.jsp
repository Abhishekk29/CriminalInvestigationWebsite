<%-- 
    Document   : predict
    Created on : 3 Mar, 2022, 1:44:01 PM
    Author     : TechNorider
--%>

<%@ page import="java.sql.*" %>
<%ResultSet resultset =null;%>

<HTML>
<HEAD>
       <title>Prediction Page</title>
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

       Statement statement = connection.createStatement() ;

       resultset =statement.executeQuery("select * from addcase") ;
%>

<!-- main -->
	<div class="main-w3layouts wrapper">
		<h1>Predict</h1>
		<div class="main-agileinfo">
			<div class="agileits-top">				
                                    <form method="get" action="PredictionServlet">
                                        <input class="text" type="text" name="type" list="type" placeholder="Case-ID:" required="">
                                        <datalist id="type">
                                                 <%  while(resultset.next()){ %>
            <option><%= resultset.getString(1)%></option>
        <% } %>
    </datalist>

                                       
					
				                                       
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