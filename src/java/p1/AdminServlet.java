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
@WebServlet(name = "AdminServlet", urlPatterns = {"/AdminServlet"})
public class AdminServlet extends HttpServlet {

 
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
               PrintWriter out = response.getWriter();            
        String uname = request.getParameter("uname");
        String pwd = request.getParameter("pass");
        response.setHeader("Cache-Control","no-cache,no-store,must-revalidate");    
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/criminaldb", "criminal", "root");
            Statement stmt=con.createStatement();
            ResultSet rs=stmt.executeQuery("select username,password from adminlogin where username='"+uname+"'and password='"+pwd+"'");
          response.setHeader("Cache-Control","no-cache,no-store,must-revalidate");       
            if(rs.next()){

            HttpSession session=request.getSession();
            session.setAttribute("username", uname);
            response.sendRedirect("adminhome.html");
        }else{
                 
                 
       
                out.println("<p style='text-align: center;background-color: white;color: red;font-family: Nunito Sans;font-size:20px;font-weight: bold;animation: 2s shake infinite alternate;'>login failed!!<br>Check your username or password again!</p>");
                request.getRequestDispatcher("Admin.html").include(request, response); 
            }  
        } 
        catch (Exception e) {
            out.println("error " + e.getMessage());
        }
    }
    }


