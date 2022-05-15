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

@WebServlet(name = "CaseServlet", urlPatterns = {"/CaseServlet"})
public class CaseServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String caseid = request.getParameter("t1");
        String casename = request.getParameter("t2");
        String officerid = request.getParameter("t3");
        String officername = request.getParameter("t4");
        String note = request.getParameter("t5");
       

        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/criminaldb", "criminal", "root");

            PreparedStatement ps = con.prepareStatement("insert into addcase values(?,?,?,?,?)");
            ps.setString(1, caseid);
            ps.setString(2, casename);
            ps.setString(3, officerid);
            ps.setString(4, officername);
            ps.setString(5, note);
           

            ps.executeUpdate();
            out.println("<p style='text-align: center;background-color: white;color: MediumSeaGreen;font-family: Nunito Sans;font-size:25px;font-weight: bold;'>Case added Successfully!</p>");
            request.getRequestDispatcher("addcase.html").include(request, response);
        } catch (Exception e) {

             out.println("<p style='text-align: center; background-color: white;color: red;font-family: 'Nunito Sans';font-size:800px;font-weight: bold;'>failed!!<br>Please check your officer-id or case-id!</p>"+"<br>"+e.getMessage());
                request.getRequestDispatcher("addcase.html").include(request, response); 

        }
    }

    public static addcase getCaseByPk(String caseid,String casename,String officerid,String officername,String note) {
        addcase e = new addcase();

        try {
            Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/ejdb", "root", "root");
            PreparedStatement ps = con.prepareStatement("select * from criminal.addcase");
            ps.setString(1, caseid);
            ps.setString(2, casename);
            ps.setString(3, officerid);
            ps.setString(4, officername);
            ps.setString(5, note);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                e.setCaseid(rs.getString(1));
                e.setCasename(rs.getString(2));
                e.setOfficerid(rs.getString(3));
                e.setOfficername(rs.getString(4));
                e.setNote(rs.getString(5));
                

            }
            con.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return e;
    }

    public static List<addcase> getCaseByPk() {
        List<addcase> list = new ArrayList<addcase>();

        try {
            Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/criminaldb", "criminal", "root");
            PreparedStatement ps = con.prepareStatement("select * from addcase");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                addcase e = new addcase();
                e.setCaseid(rs.getString(1));
                e.setCasename(rs.getString(2));
                e.setOfficerid(rs.getString(3));
                e.setOfficername(rs.getString(4));
                e.setNote(rs.getString(5));           
                list.add(e);
            }
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;

    }
}
