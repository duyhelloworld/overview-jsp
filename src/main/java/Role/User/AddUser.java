package Role.User;
import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import data_access.DB_Connection;

@WebServlet(urlPatterns = {"/user/new"})
public class AddUser extends HttpServlet{
    
        @Override
        protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            // Cookie[] cookies = req.getCookies();
            // for (Cookie cookie : cookies) {
            //     if (cookie.getName() == "username") {
            //         String username = cookie.getValue();
                    

            //     }
            //     else {
            //         resp.sendRedirect("/overview-jsp/");
            //     }
            // }
        }
    
        @Override
        protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            // Add user
            // String username = req.getParameter("username");
            // String password = req.getParameter("password");
            // String email = req.getParameter("email");

            Connection conn = DB_Connection.getConnection();
            if (!DB_Connection.isConnected(conn)) {
                resp.setStatus(500);
                resp.sendRedirect("/overview-jsp/error");
            }

            // String username = req.getParameter("username");
            // String password = req.getParameter("password");
            // String email = req.getParameter("email");
            // String tableName = "WebServlet";

            // // String cmd = "INSERT INTO `" + tableName + "` VALUE (default," + username + ", " + password + ", " + email
            // //         + ") ";
            // String cmd = "";

            // try {
            //     PreparedStatement stm = conn.prepareStatement(cmd);
            //     if (stm.execute()) {
                    
            //         System.out.println("exec OK");
            //         resp.sendRedirect("http://google.com");
            //     } else {
            //         System.out.println("Exec failure");
            //         resp.sendRedirect("/");
            //     }
            // } catch (SQLException e) {
            //     System.out.println("Create Statement Fail");
            // }
        }
}
