package model;

public class Admin {
    private Long id;
    private String email;
    private String username;
    private String password;
    private String phone;

    public Admin(Long id, String email, String username, String password, String phone) {
        this.id = id;
        this.email = email;
        this.username = username;
        this.password = password;
        this.phone = phone;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return this.phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }


    public String getUsername() {
        return this.username;
    }

    void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return this.password;
    }

    void setPassword(String password) {
        this.password = password;
    }
}
