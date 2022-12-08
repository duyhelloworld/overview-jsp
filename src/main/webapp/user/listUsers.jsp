<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
    <head><title>List User</title></head>
<>
    <h1>List Users</h1>
    <s%
        Connection conn = DB_Connection.getConnection();
            if (!DB_Connection.isConnected(conn)) {
                resp.setStatus(500);
                resp.sendRedirect("/overview-jsp/error");
            }

            String tableName = "WebServlet";

            String cmd = "SELECT * FROM `" + tableName + "`";

            try {
                PreparedStatement stm = conn.prepareStatement(cmd);
                if (stm.execute()) {
                  
                } else {
                    System.out.println("Exec failure");
                    resp.sendRedirect("/");
                }
            } catch (SQLException e) {
                System.out.println("Create Statement Fail");
            }
    %>
</body>
</html>