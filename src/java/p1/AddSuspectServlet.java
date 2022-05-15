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
@WebServlet(name = "AddSuspectServlet", urlPatterns = {"/AddSuspectServlet"})
public class AddSuspectServlet extends HttpServlet {

 

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String caseid = request.getParameter("t1");
        String SuspectName = request.getParameter("t2");
        String Mobno= request.getParameter("t3");
        String Address = request.getParameter("t4");
        String Relation = request.getParameter("t5");
        String note = request.getParameter("t6");
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/criminaldb", "criminal", "root");

            PreparedStatement ps = con.prepareStatement("insert into addsuspect values(?,?,?,?,?,?)");
            ps.setString(1, caseid);        
            ps.setString(2, SuspectName);
            ps.setString(3, Mobno);
            ps.setString(4, Address);
            ps.setString(5, Relation);
            ps.setString(6, note);
            
           
            ps.executeUpdate();
            out.println("<p style='text-align: center;background-color: white;color: MediumSeaGreen;font-family: Nunito Sans;font-size:25px;font-weight: bold;'>Suspect added Successfully!</p>");
            request.getRequestDispatcher("addsuspect.html").include(request, response);
        } catch (Exception e) {

             out.println("<p style='text-align: center; background-color: white;color: red;font-family: 'Nunito Sans';font-size:800px;font-weight: bold;'>failed!!<br>Please check the details again!</p>"+"<br>"+e.getMessage());
                request.getRequestDispatcher("addsuspect.html").include(request, response);

        }
    }

    public static addsuspect getSusByPk(String caseid,String SuspectName,String Mobno,String Address,String Relation,String note) {
        addsuspect e = new addsuspect();

        try {
            Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/ejdb", "root", "root");
            PreparedStatement ps = con.prepareStatement("select * from criminal.addsuspect");
            ps.setString(1, caseid);
            ps.setString(2, SuspectName);
            ps.setString(3, Mobno);
            ps.setString(4, Address);
            ps.setString(5, Relation);
            ps.setString(6, note);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                e.setCaseid(rs.getString(1));            
                e.setSuspectName(rs.getString(2));           
                e.setMobno(rs.getString(3));
                e.setAddress(rs.getString(4));
                e.setRelation(rs.getString(5));
                e.setNote(rs.getString(6));
                

            }
            con.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return e;
    }

    public static List<addsuspect> getSusByPk() {
        List<addsuspect> list = new ArrayList<addsuspect>();

        try {
            Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/criminaldb", "criminal", "root");
            PreparedStatement ps = con.prepareStatement("select * from addsuspect");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                addsuspect e = new addsuspect();
                e.setCaseid(rs.getString(1));
                e.setSuspectName(rs.getString(2));           
                e.setMobno(rs.getString(3));
                e.setAddress(rs.getString(4));
                e.setRelation(rs.getString(5));
                e.setNote(rs.getString(6));
                list.add(e);
            }
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;

    }

}
