package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;

public final class predict_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
ResultSet resultset =null;
      out.write("\n");
      out.write("\n");
      out.write("<HTML>\n");
      out.write("<HEAD>\n");
      out.write("       <title>Prediction Page</title>\n");
      out.write("    <link rel=\"stylesheet\" href=\"https://www.w3schools.com/w3css/4/w3.css\">\n");
      out.write("    <!-- Custom Theme files -->\n");
      out.write("<link href=\"css/style1.css\" rel=\"stylesheet\" type=\"text/css\" media=\"all\" />\n");
      out.write("<!-- //Custom Theme files -->\n");
      out.write("<!-- web font -->\n");
      out.write("<link href=\"//fonts.googleapis.com/css?family=Roboto:300,300i,400,400i,700,700i\" rel=\"stylesheet\">\n");
      out.write("<!-- //web font -->\n");
      out.write("</HEAD>\n");
      out.write("\n");
      out.write("<BODY>\n");
      out.write("\n");

    try{
//Class.forName("com.mysql.jdbc.Driver").newInstance();
Connection connection = 
         DriverManager.getConnection
            ("jdbc:derby://localhost:1527/criminaldb", "criminal", "root");

       Statement statement = connection.createStatement() ;

       resultset =statement.executeQuery("select * from addcase") ;

      out.write("\n");
      out.write("\n");
      out.write("<!-- main -->\n");
      out.write("\t<div class=\"main-w3layouts wrapper\">\n");
      out.write("\t\t<h1>Predict</h1>\n");
      out.write("\t\t<div class=\"main-agileinfo\">\n");
      out.write("\t\t\t<div class=\"agileits-top\">\t\t\t\t\n");
      out.write("                                    <form method=\"get\" action=\"PredictionServlet\">\n");
      out.write("                                        <input class=\"text\" type=\"text\" name=\"type\" list=\"type\" placeholder=\"Case-ID:\" required=\"\">\n");
      out.write("                                        <datalist id=\"type\">\n");
      out.write("                                                 ");
  while(resultset.next()){ 
      out.write("\n");
      out.write("            <option>");
      out.print( resultset.getString(1));
      out.write("</option>\n");
      out.write("        ");
 } 
      out.write("\n");
      out.write("    </datalist>\n");
      out.write("\n");
      out.write("                                       \n");
      out.write("\t\t\t\t\t\n");
      out.write("\t\t\t\t                                       \n");
      out.write("\t\t\t\t\t<div class=\"wthree-text\">\n");
      out.write("\t\t\t\t\t\n");
      out.write("\t\t\t\t\t\t<div class=\"clear\"> </div>\n");
      out.write("\t\t\t\t\t</div>\n");
      out.write("                                        <input type=\"submit\" value=\"submit\">\n");
      out.write("                                        <input type=\"reset\">\n");
      out.write("                                      \n");
      out.write("\t\t\t\t</form>\n");
      out.write("                            <Center><button style=\"alignment-adjust: central;color: green;background-color: black;\" onclick=\"window.location.href='adminhome.html'\">Home</button></center>\n");
      out.write("\t\t\t\t\n");
      out.write("\t\t\t</div>\n");
      out.write("\t\t</div>\n");
      out.write("\t\t\n");
      out.write("\t\t<ul class=\"colorlib-bubbles\">\n");
      out.write("\t\t\t<li></li>\n");
      out.write("\t\t\t<li></li>\n");
      out.write("\t\t\t<li></li>\n");
      out.write("\t\t\t<li></li>\n");
      out.write("\t\t\t<li></li>\n");
      out.write("\t\t\t<li></li>\n");
      out.write("\t\t\t<li></li>\n");
      out.write("\t\t\t<li></li>\n");
      out.write("\t\t\t<li></li>\n");
      out.write("\t\t\t<li></li>\n");
      out.write("\t\t</ul>\n");
      out.write("\t</div>\n");
      out.write("\t<!-- //main -->\n");
      out.write("      \n");
      out.write("        <script type=\"application/x-javascript\"> addEventListener(\"load\", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>\n");
      out.write("<footer><center>&COPY; 2022 Criminal Investigation. All rights reserved.</center></footer>  \n");

//**Should I input the codes here?**
        }
        catch(Exception e)
        {
             out.println("wrong entry"+e);
        }
     out.print("<a href='LogoutServlet'>Log Out</a>");

      out.write("\n");
      out.write("\n");
      out.write("</BODY>\n");
      out.write("</HTML>");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
