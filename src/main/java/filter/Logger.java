package filter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import data_access.DB_Connection;
import model.Admin;

@WebFilter(urlPatterns = "/user")
public class Logger implements Filter{
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;
        
        String req_username = req.getParameter("username");
        String req_password = req.getParameter("password");

        Connection conn = DB_Connection.getConnection();
        if (!DB_Connection.isConnected(conn)) {
            resp.setStatus(500);
            resp.sendRedirect("/overview-jsp/error");
        }
        else {
            String tableName = "Admin";
            String cmd = "SELECT * FROM " + tableName;

            try {
                PreparedStatement stm = conn.prepareStatement(cmd);
                if (stm.execute()) {
                    ResultSet rs = stm.executeQuery();
                    List<Admin> listAdmins = new ArrayList<Admin>();

                    while (rs.next()) {
                        Long id = (Long) rs.getLong("a_id");
                        String usr = rs.getString("a_name");
                        String pss = rs.getString("a_pass");
                        String email = rs.getString("a_mail");
                        String phone = rs.getString("a_phone");
                        Admin admin = new Admin(id, email, usr, pss, phone);
                        listAdmins.add(admin);
                        System.out.println(admin);
                    }
                    
                    for (Admin adminn : listAdmins) {
                        if (adminn.getUsername() == req_username) {
                            if (adminn.getPassword() == req_password) {
                                Cookie user = new Cookie("username", adminn.getUsername());
                                Cookie pass = new Cookie("password", adminn.getPassword());
                                user.setMaxAge(100);
                                pass.setMaxAge(100);
                                resp.addCookie(user);
                                resp.addCookie(pass);

                                resp.setStatus(200);
                                RequestDispatcher rd = req.getRequestDispatcher("/admin/home.jsp");
                                rd.forward(request, response);
                            } else {
                                resp.sendError(401);
                            }
                        } else
                            resp.sendRedirect("https://google.com");
                    }
                    

                } else {
                    System.out.println("Exec failure");
                    resp.sendRedirect("/");
                }
            } catch (Exception e) {
                System.out.println("Create Statement Fail\n" + e);
            }
        }
        System.out.println("Filtered");
         
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        
    }

    @Override
    public void destroy() {
        
    }
}
