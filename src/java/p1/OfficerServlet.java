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

@WebServlet(name = "OfficerServlet", urlPatterns = {"/OfficerServlet"})
public class OfficerServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String officerid = request.getParameter("t1");
        String fullname = request.getParameter("t2");
        String mobno = request.getParameter("t3");
        String address = request.getParameter("t4");
        String email = request.getParameter("t5");
        String area = request.getParameter("t6");

        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/criminaldb", "criminal", "root");

            PreparedStatement ps = con.prepareStatement("insert into addofficer values(?,?,?,?,?,?)");
            ps.setString(1, officerid);
            ps.setString(2, fullname);
            ps.setString(3, mobno);
            ps.setString(4, address);
            ps.setString(5, email);
            ps.setString(6, area);

            ps.executeUpdate();
            out.println("<p style='text-align: center;background-color: white;color: MediumSeaGreen;font-family: Nunito Sans;font-size:25px;font-weight: bold;'>Officer added Successfully!</p>");
            request.getRequestDispatcher("addofficer.html").include(request, response);
        } catch (Exception e) {

             out.println("<p style='text-align: center; background-color: white;color: red;font-family: 'Nunito Sans';font-size:800px;font-weight: bold;'>failed!!<br>Please change your OfficerId!</p>"+"<br>"+e.getMessage());
                request.getRequestDispatcher("addofficer.html").include(request, response); 

        }
    }

    public static addofficer getOfficerByPk(String officerid, String fullname, String mobno,String address,String email,String area) {
        addofficer e = new addofficer();

        try {
            Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/criminaldb", "criminal", "root");
            PreparedStatement ps = con.prepareStatement("select * from criminal.addcase");
            ps.setString(1, officerid);
            ps.setString(2, fullname);
            ps.setString(3, mobno);
            ps.setString(4, address);
            ps.setString(5, email);
            ps.setString(6, area);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                e.setOfficerid(rs.getString(1));
                e.setFullname(rs.getString(2));
                e.setMobno(rs.getString(3));
                e.setAddress(rs.getString(4));
                e.setEmail(rs.getString(5));
                e.setArea(rs.getString(6));
            }
            con.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return e;
    }

    public static List<addofficer> getOfficerByPk() {
        List<addofficer> list = new ArrayList<addofficer>();

        try {
            Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/criminaldb", "criminal", "root");
            PreparedStatement ps = con.prepareStatement("select * from addofficer");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                addofficer e = new addofficer();
                e.setOfficerid(rs.getString(1));
                e.setFullname(rs.getString(2));
                e.setMobno(rs.getString(3));
                e.setAddress(rs.getString(4));
                e.setEmail(rs.getString(5));
                e.setArea(rs.getString(6));
                list.add(e);
            }
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;

    }
}
