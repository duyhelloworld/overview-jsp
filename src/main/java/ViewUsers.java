import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.User;

@WebServlet(urlPatterns = { "/user/view" })
public class ViewUsers extends HttpServlet {

    //     @Override
    //     protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    //         resp.setContentType("text/html");
    //         PrintWriter printer = resp.getWriter();
    //         printer.println("Only Admin can view all users");
    // }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Connection conn = DB_Connection.getConnection();
        if (!DB_Connection.isConnected(conn)) {
            resp.setStatus(500);
            resp.sendRedirect("/overview-jsp/error");
        }

        String tableName = "WebServlet";
        String cmd = "SELECT * FROM " + tableName;

        try {
            PreparedStatement stm = conn.prepareStatement(cmd);
            if (stm.execute()) {
                ResultSet rs = stm.executeQuery();
                List<User> listUsers = new ArrayList<User>();

                while (rs.next()) {
                    int id = rs.getInt("u_id");
                    String username = rs.getString("u_name");
                    String password = rs.getString("u_pass");
                    String email = rs.getString("u_email");
                    User user = new User(id, username, password, email);
                    listUsers.add(user);
                }
                int total = listUsers.size();
                
                // Return JSON
                resp.setContentType("text/json");
                PrintWriter printWriter = resp.getWriter();
                printWriter.println("[");
                for (User user : listUsers) {
                    printWriter.println("{" + "\"id\" : " + user.getId() + ",\n\"username\" : " + user.getUsername()
                            + ",\n\"password\" : " + user.getPassword() + ",\n\"email\" : " + user.getEmail() + "\n}");
                    printWriter.println(user.getId() < total ? ", " : "]");
                }
            } else {
                System.out.println("Exec failure");
                resp.sendRedirect("/");
            }
        } catch (SQLException e) {
            System.out.println("Create Statement Fail");
        }
        RequestDispatcher rd = req.getRequestDispatcher("/user/listUsers.jsp");
        rd.forward(req, resp);
    }
}
