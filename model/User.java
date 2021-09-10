package product.model;

public class User {
    private String username;
    private String password;
    private String role;
    private String Id;

    public User(String username, String password, String role, String id) {
        this.username = username;
        this.password = password;
        this.role = role;
        Id = id;
    }

    public User(int i) {
    }

    public User(String username, String password) {

    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", role='" + role + '\'' +
                ", Id='" + Id + '\'' +
                '}';
    }
}
