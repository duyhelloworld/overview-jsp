package Role.Admin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import data_access.DB_Connection;
import model.Admin;

public class ListAdmins {
    private static List<Admin> listAdmins = new ArrayList<Admin>();

    public ListAdmins() {
        listAdmins = getListAdmins();
    }

    public static void setAdmins(Long id, String username, String password, String email, String phone) {
        Admin admin = new Admin(id, email, username, password, phone);
        listAdmins.add(admin);
    }

    public boolean isAdmin(String req_user, String req_pass) {
        for (Admin admin : listAdmins) {
            if (admin.getUsername() == req_user && admin.getPassword() == req_pass) {
                return true;
            }
        }
        return false;
    }

    public static List<Admin> getListAdmins() {
        Connection conn = DB_Connection.getConnection();

        if (!DB_Connection.isConnected(conn)) {
            System.out.println("Not connected");
            return null;
        }

        String tableName = "Admin";
        String cmd = "SELECT * FROM " + tableName;
        System.out.println("Connected");
        try (PreparedStatement stm = conn.prepareStatement(cmd)) {
            if (stm.execute()) {
                ResultSet rs = stm.executeQuery();

                while (rs.next()) {
                    Long id = (Long) rs.getLong("a_id");
                    String usr = rs.getString("a_name");
                    String pss = rs.getString("a_pass");
                    String email = rs.getString("a_mail");
                    String phone = rs.getString("a_phone");
                    ListAdmins.setAdmins(id, usr, pss, email, phone);
                }
                return ListAdmins.getListAdmins();
            } else {
                System.out.println("Execute failure!");
                return null;
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }
}
