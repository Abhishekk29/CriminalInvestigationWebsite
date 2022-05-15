/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p1;
import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(name = "ViewCaseServlet", urlPatterns = {"/ViewCaseServlet"})
public class ViewCaseServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html"); 
               PrintWriter out=response.getWriter();                                 
        List<addcase> list=CaseServlet.getCaseByPk();                           
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
"      <h2 style="+"font-size:40px;"+"class=\"mb-5\">Case Details</h2>\n" +
"      \n" +
"\n" +
"\n" +
"        <table class=\"table custom-table\">\n" +
"          <thead>\n" +
"            <tr>  \n" +
"\n" +
"              \n" +
"              <th scope=\"col\">Case-ID</th>\n" +
"              <th scope=\"col\">Case Name</th>\n" +
"              <th scope=\"col\">Officer-ID</th>\n" +
"              <th scope=\"col\">Officer Name</th>\n" +
"              <th scope=\"col\">Note</th>\n" +
"            </tr>\n" +
"          </thead>\n" +
"          <tbody>\n" +
"            <tr>\n" );
for(addcase e:list){out.println(
"              <td>\n" +e.getCaseid()+
"              </td>\n" +
"              <td>"+e.getCasename()+"</td>\n" +
"              <td>\n" +e.getOfficerid()+
"              </td>\n" +
"              <td>\n" +e.getOfficername()+
"              <td>\n" +e.getNote()+
"      </tr>\n"+                
"          </tbody>\n" +
"\n" +
"\n" +
"\n" +
"    \n" +
"    \n" +
"\n" +
"  </body>\n" +
"</html>");};
out.print("</table>");                          
        out.close(); 
    }
}
