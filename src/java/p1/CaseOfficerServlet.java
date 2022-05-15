package p1;

import java.util.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "CaseOfficerServlet", urlPatterns = {"/CaseOfficerServlet"})
public class CaseOfficerServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String caseid = request.getParameter("t1");      
        String officerid = request.getParameter("t3");       
        String password = request.getParameter("t5");
       

        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/criminaldb", "criminal", "root");

            PreparedStatement ps = con.prepareStatement("insert into caseofficer values(?,?,?)");
            ps.setString(1, caseid);       
            ps.setString(2, officerid);     
            ps.setString(3, password);
           

            ps.executeUpdate();
            out.println("<p style='text-align: center;background-color: white;color: MediumSeaGreen;font-family: Nunito Sans;font-size:25px;font-weight: bold;'>Password generated Successfully!</p>");
            request.getRequestDispatcher("addcaseofficer.html").include(request, response);
        } catch (Exception e) {

             out.println("<p style='text-align: center; background-color: white;color: red;font-family: 'Nunito Sans';font-size:800px;font-weight: bold;'>failed!!</p>"+"<br>"+e.getMessage());
                request.getRequestDispatcher("addcaseofficer.html").include(request, response); 

        }
    }


}
