package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.User;

public class DAO_User {
    private static List<User> listUser = new ArrayList<User>();
    private static String tableName = "User";

    public static String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        DAO_User.tableName = tableName;
    }

    public static void setUser(int id, String username, String pass, String email, String phone) {
        User user = new User(id, username, pass, email, phone);
        listUser.add(user);
    }

    public static List<User> getListUser() {
        Connection conn = DAO.getConnection();

        if (!DAO.isConnected(conn)) {
            return null;
        }

        String cmd = "SELECT * FROM " + DAO_User.getTableName();
        try (PreparedStatement stm = conn.prepareStatement(cmd)) {
            if (stm.execute()) {
                ResultSet rs = stm.executeQuery();

                while (rs.next()) {
                    int id = rs.getInt("u_id");
                    String usr = rs.getString("u_name");
                    String pss = rs.getString("u_pass");
                    String email = rs.getString("u_mail");
                    String phone = rs.getString("u_phone");
                    DAO_User.setUser(id, usr, pss, email, phone);
                }
                return listUser;
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return listUser;
    }

    public static Boolean validate(String username, String password) {
        boolean status = false;
        String cmd = "SELECT * FROM " + DAO_User.getTableName() + " WHERE u_name=? + u_pass=?";
        try {
            PreparedStatement stm = DAO.getConnection().prepareStatement(cmd);
            stm.setString(1, username);
            stm.setString(2, password);
            ResultSet rs = stm.executeQuery();
            status = rs.next();
        }catch(Exception e){
            System.out.println(e);
        }
        return status;
    }
}
