import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.annotation.WebServlet;
import java.sql.Connection;

@WebServlet(urlPatterns = {"/user"})
public class AddUser extends HttpServlet{
    
        @Override
        protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            // View users
            
        }
    
        @Override
        protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            // Add user
            String username = req.getParameter("username");
            String password = req.getParameter("password");
            String email = req.getParameter("email");

            Connection conn = DB_Connection.getConnection();
            if (!DB_Connection.isConnected(conn)) {
                resp.setStatus(500);
                resp.sendRedirect("/overview-jsp/error");
            }

        
        }
}
