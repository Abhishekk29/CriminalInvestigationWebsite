/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p1;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author TechNorider
 */
@WebServlet(name = "PredictionServlet", urlPatterns = {"/PredictionServlet"})
public class PredictionServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         response.setContentType("text/html");
              PrintWriter out = response.getWriter();     
             
               List<addevidence> list=AddEvidenceServlet.getEviByPk();
              String caseid=request.getParameter("type");                          
              try{
                      Class.forName("org.apache.derby.jdbc.ClientDriver");

                     Connection con=DriverManager.getConnection("jdbc:derby://localhost:1527/criminaldb", "criminal", "root");               

                     PreparedStatement ps=con.prepareStatement("select * from criminal.addevidence where caseid=? ORDER BY points DESC");

                     ps.setString(1,caseid);                   

                     ResultSet rs=ps.executeQuery();                
 
   
                     /* Printing column names */

                    /* ResultSetMetaData rsmd=rs.getMetaData();*/
 out.print("<table width=25% border=1>");
                     while(rs.next())
                       {    
                           int current_row_number = rs.getRow();
 out.print("<table>");                
out.print("<!doctype html>\n" +
"<html lang=\"en\">\n" +
"  <head>\n" +
"    <!-- Required meta tags -->\n" +
"    <meta charset=\"utf-8\">\n" +
"    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1, shrink-to-fit=no\">\n" +
"    <link href=\"https://fonts.googleapis.com/css?family=Roboto:300,400&display=swap\" rel=\"stylesheet\">\n" +
"\n" +
"    <link rel=\"stylesheet\" href=\"fonts/icomoon/style.css\">\n" +
"\n" +
"    <link rel=\"stylesheet\" href=\"css/owl.carousel.min.css\">\n" +
"\n" +
"    <!-- Bootstrap CSS -->\n" +
"    <link rel=\"stylesheet\" href=\"css/bootstrap.min.css\">\n" +
"    \n" +
"    <!-- Style -->\n" +
"    <link rel=\"stylesheet\" href=\"css/styletable.css\">\n" +
"\n" +
"    <title></title>\n" +
"  </head>\n" +
"  <body>\n" +
"  \n" +
"\n" +
"      <h2 style="+"font-size:40px;"+"class=\"mb-5\">Prediction</h2>\n" +"<h2>"+"Rank: "+current_row_number+"</h2>"+
"      \n" +
"\n" +
"\n" +
"        <table class=\"table custom-table\">\n" +
"          <thead>\n" +
"            <tr>  \n" +
"\n" +
"              \n" +
"              <th scope=\"col\">Case-ID</th>\n" +
"              <th scope=\"col\">Evidence Type</th>\n" +
"              <th scope=\"col\">Evidence</th>\n" +
"              <th scope=\"col\">Suspect Name</th>\n" +
"              <th scope=\"col\">Points</th>\n" +
"              <th scope=\"col\">Note</th>\n" +
"            </tr>\n" +
"          </thead>\n" +
"          <tbody>\n" +
"            <tr>\n" );

out.print("<td>\n"+rs.getString(1)+"</td>\n"+"<td>\n"+rs.getString(2)+"</td>\n"+"<td>\n"+rs.getString(3)+"</td>\n"+"<td>\n"+rs.getString(4)+"</td>\n"+"<td>\n"+rs.getString(5)+"</td>\n"+"<td>\n"+rs.getString(6)+"</td>\n"+"</tr>\n"+                
"</tbody>\n" +
"\n" +
"\n" +
"\n" +
"\n" +
"\n" +
"\n" +
"</body>\n" +
"</html>");
                   }
                       out.print("</table>");
              }catch (Exception e)
                {               
                    out.println("<p style='text-align: center; background-color: white;color: red;font-family: 'Nunito Sans';font-size:800px;font-weight: bold;'>failed!!<br>Please check the details again!</p>"+"<br>"+e.getMessage());
                request.getRequestDispatcher("predict.jsp").include(request, response);

                }

              finally{out.close();

                }

       }


    }
        
    

 

