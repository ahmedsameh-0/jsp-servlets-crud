package entity;

public class User {

    private int id;
    private String fullName;
    private int phoneNo;
    private String address;
    private String email;
    private String password;

    public User(int id, String fullName, int phoneNo, String email,  String password, String address) {
        this.id = id;
        this.fullName = fullName;
        this.phoneNo = phoneNo;
        this.email = email;
        this.password = password;
        this.address = address;
    }

    public User(String fullName, int phoneNo, String email, String password, String address) {
        this.fullName = fullName;
        this.phoneNo = phoneNo;
        this.email = email;
        this.password = password;
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(int phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    
    
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
