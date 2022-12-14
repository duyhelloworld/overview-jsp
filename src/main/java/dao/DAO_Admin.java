package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.Admin;

public class DAO_Admin {
    private List<Admin> listAdmins = new ArrayList<Admin>();

    public void setAdmins(Long id, String username, String password, String email, String phone) {
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

    public void save(Admin admin) {

    }
    
    public void update(Admin admin) {
        
    }

    public List<Admin> getListAdmins() {
        Connection conn = DAO.getConnection();

        if (!DAO.isConnected(conn)) {
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
                    this.setAdmins(id, usr, pss, email, phone);
                }
                return this.getListAdmins();
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
