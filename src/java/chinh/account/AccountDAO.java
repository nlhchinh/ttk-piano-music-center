/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chinh.account;

import chinh.utils.DBUtils;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.xml.bind.DatatypeConverter;

/**
 *
 * @author Admin
 */
public class AccountDAO {

    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public AccountDTO login(String userID, String password) throws NoSuchAlgorithmException {

        String sql = " select  userID, userName, password, phoneNumber, email, role\n"
                + "from  tblAccount\n"
                + "where userID = ? and password = ? ";
        try {
            conn = new DBUtils().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, userID);
            ps.setString(2, password);
            rs = ps.executeQuery();
            while (rs.next()) {
                String userid = rs.getString(1).trim();
                String userName = rs.getString(2).trim();
                String pass = rs.getString(3).trim();
                long phoneNumber = rs.getLong(4);
                String email = rs.getString(5).trim();
                String role = rs.getString(6).trim();
                return new AccountDTO(userid, userName, pass, phoneNumber, email, role);
            }
        } catch (Exception e) {
        }

        return null;
    }

    public String checkRoleByUserID(String userID) throws SQLException {
        String sql = "select role\n"
                + "from tblAccount\n"
                + "where userID = ?";
        try {
            conn = new DBUtils().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, userID);
            rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getString(1);
            }
        } catch (Exception e) {
        }
        return null;
    }

    public String checkUserIdExist(String userID) throws SQLException {
        String sql = "select userID\n"
                + "from tblAccount\n"
                + "where userID = ?";
        try {
            conn = new DBUtils().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, userID);
            rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getString(1);
            }
        } catch (Exception e) {
        }
        return null;
    }

    public static void main(String[] args) throws NoSuchAlgorithmException, SQLException {
        AccountDAO dao = new AccountDAO();
        System.out.println(dao.checkUserIdExist("SE1405072"));
    }
}
