import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.Admin;

@WebFilter(urlPatterns = "/user")
public class Logger implements Filter{
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;
        
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        Admin admin = new Admin();
        if (username == admin.getUsername() && password == admin.getPassword()) {
            System.out.println("Admin");
            resp.sendRedirect("/overview-jsp/home/admin");
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
