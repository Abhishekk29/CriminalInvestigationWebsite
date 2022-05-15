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
@WebServlet(name = "AddResultServlet", urlPatterns = {"/AddResultServlet"})
public class AddResultServlet extends HttpServlet {


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String caseid = request.getParameter("type");
        String suspectname = request.getParameter("type2");
        String note = request.getParameter("type3");       

        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/criminaldb", "criminal", "root");

            PreparedStatement ps = con.prepareStatement("insert into addresult values(?,?,?)");
            ps.setString(1, caseid);
            ps.setString(2, suspectname);
            ps.setString(3, note);
        

            ps.executeUpdate();
            out.println("<p style='text-align: center;background-color: white;color: MediumSeaGreen;font-family: Nunito Sans;font-size:25px;font-weight: bold;'>Result added Successfully!</p>");
            request.getRequestDispatcher("addresult.jsp").include(request, response);
        } catch (Exception e) {

             out.println("<p style='text-align: center; background-color: white;color: red;font-family: 'Nunito Sans';font-size:800px;font-weight: bold;'>failed!!<br>Please enter valid details!</p>"+"<br>"+e.getMessage());
                request.getRequestDispatcher("addresult.jsp").include(request, response); 

        }
    }

    public static addresult getResultByPk(String caseid, String suspectname, String note) {
        addresult e = new addresult();

        try {
            Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/criminaldb", "criminal", "root");
            PreparedStatement ps = con.prepareStatement("select * from criminal.addresult");
            ps.setString(1, caseid);
            ps.setString(2, suspectname);
            ps.setString(3, note);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                e.setCaseid(rs.getString(1));
                e.setSuspectName(rs.getString(2));
                e.setNote(rs.getString(3));
            }
            con.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return e;
    }

    public static List<addresult> getResultByPk() {
        List<addresult> list = new ArrayList<addresult>();

        try {
            Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/criminaldb", "criminal", "root");
            PreparedStatement ps = con.prepareStatement("select * from addresult");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                addresult e = new addresult();
                e.setCaseid(rs.getString(1));
                e.setSuspectName(rs.getString(2));
                e.setNote(rs.getString(3));
                list.add(e);
            }
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;

    }
}

        
    

 





