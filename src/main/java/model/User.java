package model;

public class User {
    private int id;
    private static int count = 0;
    private String username;
    private String password;
    private String email;
    private String phone;

    public String getPhone() {
        return this.phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public User(int id, String username, String password, String email, String phone) {
        this.id = ++count;
        this.username = username;
        this.password = password;
        this.email = email;
        this.phone = phone;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String toString(){
        return "" + this.getId()
                + "\t" + this.getUsername()
                + "\t" + this.getPassword()
                + "\t" + this.getPhone()
          + "\t" + this.getEmail(); 
    }
}
