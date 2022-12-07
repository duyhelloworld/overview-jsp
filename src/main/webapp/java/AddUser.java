import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.annotation.WebServlet;

@WebServlet(urlPatterns = {"/user"})
public class AddUser extends HttpServlet{
    
        
        @Override
        protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            // View all user
            resp.setContentType("text/html");
            PrintWriter printer = resp.getWriter();
            printer.println("");
        }
    
        @Override
        protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            // Add user
            String username = req.getParameter("username");
            String password = req.getParameter("password");
            String email = req.getParameter("email");


        }
}
