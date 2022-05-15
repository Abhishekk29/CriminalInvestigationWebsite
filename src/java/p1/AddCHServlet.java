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
import java.util.ArrayList;
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
@WebServlet(name = "AddCHServlet", urlPatterns = {"/AddCHServlet"})
public class AddCHServlet extends HttpServlet {

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String caseid = request.getParameter("t1");
        String note = request.getParameter("t2");
       

        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/criminaldb", "criminal", "root");

            PreparedStatement ps = con.prepareStatement("insert into addcasehistory values(?,?)");
            ps.setString(1, caseid);        
            ps.setString(2, note);
           
            ps.executeUpdate();
            out.println("<p style='text-align: center;background-color: white;color: MediumSeaGreen;font-family: Nunito Sans;font-size:25px;font-weight: bold;'>Case added Successfully!</p>");
            request.getRequestDispatcher("addcasehistory.html").include(request, response);
        } catch (Exception e) {

             out.println("<p style='text-align: center; background-color: white;color: red;font-family: 'Nunito Sans';font-size:800px;font-weight: bold;'>failed!!<br>Please check your officer-id or case-id!</p>"+"<br>"+e.getMessage());
                request.getRequestDispatcher("addcasehistory.html").include(request, response); 

        }
    }

    public static addCH getCHByPk(String caseid,String note) {
        addCH e = new addCH();

        try {
            Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/ejdb", "root", "root");
            PreparedStatement ps = con.prepareStatement("select * from criminal.addcasehistory");
            ps.setString(1, caseid);
            ps.setString(2, note);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                e.setCaseid(rs.getString(1));            
                e.setNote(rs.getString(2));
                

            }
            con.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return e;
    }

    public static List<addCH> getCHByPk() {
        List<addCH> list = new ArrayList<addCH>();

        try {
            Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/criminaldb", "criminal", "root");
            PreparedStatement ps = con.prepareStatement("select * from addcasehistory");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                addCH e = new addCH();
                e.setCaseid(rs.getString(1));
                e.setNote(rs.getString(2));           
                list.add(e);
            }
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;

    }

}
