/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chinh.order;

import chinh.utils.DBUtils;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import static javafx.scene.input.KeyCode.O;

/**
 *
 * @author Admin
 */
public class OrderDAO {

    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public List<OrderDTO> getOrderManage() {
        List<OrderDTO> list = new ArrayList<>();
        String sql = " select o.orderID, ac.userID, o.orderDate, o.address, o.note, o.paymentMethod, o.paymentStatus, o.total\n"
                + "from (tblOrder o inner join tblAccount ac on ac.userID=o.userID)";

        try {
            conn = new DBUtils().getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {

                list.add(new OrderDTO(rs.getInt(1), //orderID
                        rs.getString(2).trim(), // userID
                        rs.getDate(3), //orderDate
                        rs.getString(4).trim(),//adress
                        rs.getString(5).trim(),//note
                        rs.getString(6).trim(), //paymentmed
                        rs.getString(7).trim(),//paymentsta
                        rs.getInt(8)));//total
            }
        } catch (Exception e) {
        }
        return list;
    }

    public void addNewOrder(int orderID, String userID, String orderDate, String address, String note, String paymentMethod, String paymentStatus, int total) throws NoSuchAlgorithmException {
        String sql = " insert into tblOrder(orderID, userID, orderDate, address, note, paymentMethod, paymentStatus, total)\n"
                + "values(?, ?, ?, ?, ?, ?, ?, ?) ";
        try {
            conn = new DBUtils().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, orderID);
            ps.setString(2, userID);
            ps.setString(3, orderDate);
            ps.setString(4, address);
            ps.setString(5, note);
            ps.setString(6, paymentMethod);
            ps.setString(7, paymentStatus);
            ps.setInt(8, total);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    public List<OrderDTO> getOrderManageByUserID(String userID) {
        List<OrderDTO> list = new ArrayList<>();
        String sql = " select o.orderID, ac.userID, o.orderDate, o.address, o.note, o.paymentMethod, o.paymentStatus, o.total\n"
                + "from (tblOrder o inner join tblAccount ac on ac.userID=o.userID)"
                + "where o.userID = ? ";

        try {
            conn = new DBUtils().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, userID);
            rs = ps.executeQuery();

            while (rs.next()) {

                list.add(new OrderDTO(rs.getInt(1), //orderID
                        rs.getString(2).trim(), // userID
                        rs.getDate(3), //orderDate
                        rs.getString(4).trim(),//adress
                        rs.getString(5).trim(),//note
                        rs.getString(6).trim(), //paymentmed
                        rs.getString(7).trim(),//paymentsta
                        rs.getInt(8)));//total
            }
        } catch (Exception e) {
        }
        return list;
    }
    

    public static void main(String[] args) throws NoSuchAlgorithmException {
        OrderDAO odao = new OrderDAO();
        System.out.println(odao.getOrderManage());

    }
}
