package o2oboot.entity;

public class User {
    private Long userId;
    private String username;
    private String password;
    private String gender;
    private String email;
    private String birth;

    public User(Long userId, String username, String password, String gender, String email, String birth) {
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.gender = gender;
        this.email = email;
        this.birth = birth;
    }

    public User() {
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
