package cn.itcast.eshop.user.entity;

public class User extends Person {

    private String username;

    private String password;

    private String role = "Normal";

    //访问器
    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    //修改器
    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
