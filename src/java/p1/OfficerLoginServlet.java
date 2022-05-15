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
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
/**
 *
 * @author TechNorider
 */
@WebServlet(name = "OfficerLoginServlet", urlPatterns = {"/OfficerLoginServlet"})
public class OfficerLoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
               PrintWriter out = response.getWriter();
        String caseid = request.getParameter("caseid");
        String officerid = request.getParameter("officerid");
        String password = request.getParameter("pass");
        response.setHeader("Cache-Control","no-cache,no-store,must-revalidate");
        response.setHeader("Pragma", "no-cache");
        response.setDateHeader("Expires", 0);
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/criminaldb", "criminal", "root");
            Statement stmt=con.createStatement();
            ResultSet rs=stmt.executeQuery("select caseid,officerid,password  from caseofficer where caseid="+caseid+"and officerid="+officerid+"and password='"+password+"'");
            if(rs.next()){
           HttpSession session=request.getSession(); 
           session.setAttribute("caseid",caseid);
            response.sendRedirect("officerhome.html");
             
        }else{
                out.println("<p style='text-align: center;background-color: white;color: red;font-family: Nunito Sans;font-size:20px;font-weight: bold;'>login failed!!<br>Check your details again!</p>");
                request.getRequestDispatcher("officer.html").include(request, response); 
            }  
        } catch (Exception e) {
            out.println("error " + e.getMessage());
        }
    }
    }


