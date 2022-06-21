package by.academy.entity;

public class User {

    private int userId;

    private String userLogin;

    private String userPassword;

    private String userRole;


    public User() {
    }

    public User(int userId, String userLogin, String userPassword, String userRole) {
        this.userId = userId;
        this.userLogin = userLogin;
        this.userPassword = userPassword;
        this.userRole = userRole;
    }


    public User(String userLogin) {
        this.userLogin = userLogin;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserLogin(String userLogin) {
        this.userLogin = userLogin;
    }

    public String getUserLogin() {
        return userLogin;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public String getUserRole() {
        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }

    @Override
    public String toString() {
        return "Users{ "
                + "User ID: " + userId
                + ", User Login: " + userLogin
                + ", User Password: " + userPassword
                + " }";
    }
}
