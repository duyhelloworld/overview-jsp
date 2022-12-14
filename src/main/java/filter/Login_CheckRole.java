package filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DAO_User;

@WebServlet(urlPatterns = {"/user/login"})
public class Login_CheckRole extends HttpServlet {
    
        RequestDispatcher rd = null;
        
        @Override
        protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            rd = req.getRequestDispatcher("/login.jsp");
            rd.forward(req, resp);
        }

        @Override
        protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            String role = req.getParameter("role");
            String req_username = req.getParameter("username");
            String req_password = req.getParameter("password");
            String message = "Password is wrong!";
            if (role.equals("user")) {
                if (DAO_User.validate(req_username, req_password)) {
                    rd = req.getRequestDispatcher("/");
                    rd.forward(req, resp);
                }
                else {
                    PrintWriter printWriter = resp.getWriter();
                    printWriter.println("<script>alert(" + message + ")</script>");
                    rd = req.getRequestDispatcher("/login.jsp");
                    rd.include(req, resp);
                }
            }
            else if (role.equals("admin")) {
                rd = req.getRequestDispatcher("/admin/home.jsp");
                rd.forward(req, resp);
            } else {
                resp.setContentType("text/html");
                PrintWriter printer = resp.getWriter();
                printer.println("Login Error");
            }
        }
}
