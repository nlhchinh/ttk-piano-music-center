/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chinh.account;

/**
 *
 * @author Admin
 */
public class AccountDTO {
    private String userID;
    private String userName;
    private String password;
    private long phoneNumber;
    private String email;
    private String role;

    public AccountDTO() {
    }

    public AccountDTO(String userID, String userName, String password, long phoneNumber, String email, String role) {
        this.userID = userID;
        this.userName = userName;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.role = role;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "AccountDTO{" + "userID=" + userID + ", userName=" + userName + ", password=" + password + ", phoneNumber=" + phoneNumber + ", email=" + email + ", role=" + role + '}' + "\n";
    }
    
    
}
