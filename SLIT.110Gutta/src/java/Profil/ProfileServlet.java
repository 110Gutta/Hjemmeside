package Profil;
 
import DB.DataBase;
import java.io.IOException;  
import java.io.PrintWriter;  
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  
import javax.servlet.http.HttpSession;  
public class ProfileServlet extends HttpServlet { 
    
        DataBase db = new DataBase();
        Connection con = null;
        Statement st = null;
        ResultSet rs = null;
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response)  
                      throws ServletException, IOException {  
            try {
                response.setContentType("text/html;charset=UTF-8");
                PrintWriter out=response.getWriter();
                request.getRequestDispatcher("link.html").include(request, response);

                HttpSession session=request.getSession(false);
                if(session!=null){
                    String email=(String)session.getAttribute("email");
                    
                con = db.getCon();
                st = con.createStatement();
                
                String SQL = "SELECT fornavn, etternavn, email from bruker where email='"+email+"'";
                
                rs = st.executeQuery(SQL);
                    
                    if (rs.next()){
                    String fornavn = rs.getString("fornavn");
                    String etternavn = rs.getString("etternavn");
                    out.print(fornavn + " " + etternavn + " " + email);
                    }
                }
                else{
                    out.print("Please login first");
                    request.getRequestDispatcher("login.html").include(request, response);
                }  
                out.close();
            } catch (SQLException ex) {
                Logger.getLogger(ProfileServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
    }  
}