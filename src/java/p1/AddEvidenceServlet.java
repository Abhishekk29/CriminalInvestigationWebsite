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
@WebServlet(name = "AddEvidenceServlet", urlPatterns = {"/AddEvidenceServlet"})
public class AddEvidenceServlet extends HttpServlet {

  
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String caseid = request.getParameter("t1");
        String EvidenceType = request.getParameter("type");
        String Evidence = request.getParameter("t3");
        String SuspectName= request.getParameter("t4");  
        String Points= request.getParameter("points");
        String Note= request.getParameter("t5"); 
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/criminaldb", "criminal", "root");

            PreparedStatement ps = con.prepareStatement("insert into addevidence values(?,?,?,?,?,?)");
            ps.setString(1, caseid);        
            ps.setString(2, EvidenceType);
            ps.setString(3, Evidence);
            ps.setString(4, SuspectName);  
            ps.setString(5, Points);
            ps.setString(6, Note);
            ps.executeUpdate();
            out.println("<p style='text-align: center;background-color: white;color: MediumSeaGreen;font-family: Nunito Sans;font-size:25px;font-weight: bold;'>Evidence added Successfully!</p>");
            request.getRequestDispatcher("addevidence.html").include(request, response);
        } catch (Exception e) {

             out.println("<p style='text-align: center; background-color: white;color: red;font-family: 'Nunito Sans';font-size:800px;font-weight: bold;'>failed!!<br>Please check the details again!</p>"+"<br>"+e.getMessage());
                request.getRequestDispatcher("addevidence.html").include(request, response);
        }
    }
    public static addevidence getEviByPk(String caseid,String EvidenceType,String Evidence,String SuspectName,String Points,String Note) {
        addevidence e = new addevidence();
        try {
            Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/ejdb", "root", "root");
            PreparedStatement ps = con.prepareStatement("select * from criminal.addevidence");
            ps.setString(1, caseid);
            ps.setString(2, EvidenceType);
            ps.setString(3, Evidence);
            ps.setString(4, SuspectName);
            ps.setString(5, Points);
            ps.setString(6, Note);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                e.setCaseid(rs.getString(1));            
                e.setEvidenceType(rs.getString(2));   
                e.setEvidence(rs.getString(3)); 
                e.setSuspectName(rs.getString(4));
                e.setPoints(rs.getString(5));
                e.setNote(rs.getString(6)); 
          }
            con.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return e;
    }

    public static List<addevidence> getEviByPk() {
        List<addevidence> list = new ArrayList<addevidence>();

        try {
            Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/criminaldb", "criminal", "root");
            PreparedStatement ps = con.prepareStatement("select * from addevidence");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                addevidence e = new addevidence();
                e.setCaseid(rs.getString(1));            
                e.setEvidenceType(rs.getString(2));   
                e.setEvidence(rs.getString(3)); 
                e.setSuspectName(rs.getString(4));
                e.setPoints(rs.getString(5));
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




