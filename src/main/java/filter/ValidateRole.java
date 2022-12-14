package filter;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DAO_Admin;
import dao.DAO_User;

@WebServlet(urlPatterns = {"/user/login"})
public class ValidateRole extends HttpServlet {
    
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
            resp.setContentType("text/html");
            PrintWriter printer = resp.getWriter();
            if (role.equals("user")) {
                if (DAO_User.validate(req_username, req_password)) {
                    resp.setStatus(200);
                    req.setAttribute("status_code", 200);
                    Cookie userCookie = new Cookie(req_username, req_password);
                    userCookie.setMaxAge(3600*24*365); // 1y
                    resp.addCookie(userCookie);
                    rd = req.getRequestDispatcher("/user/home.jsp");
                    rd.forward(req, resp);
                    
                }
                else {
                    resp.setStatus(403);
                    req.setAttribute("status_code", 403);
                    rd = req.getRequestDispatcher("/");
                    rd.forward(req, resp);
                }
               

                // writer.println("Request : " + req_username + "<br>" + req_password
                //         + "<br>");
                // writer.println("VAlidate : " + DAO_User.validate(req_username, req_password)
                //         + "<br>List User : ");
                // List<User> listUser = DAO_User.getListUser();
                // for (User user : listUser) {
                //     writer.println(user.toString());
                // }
            }
            else if (role.equals("admin")) {
                // rd = req.getRequestDispatcher("/admin/home.jsp");
                // rd.forward(req, resp);
            } else {
                printer.println("Login Error");
            }
        }
}
