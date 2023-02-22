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
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class OrderDetailDAO {
    
    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    
    public List<OrderDetailDTO> getOrderDetailManage() {
        List<OrderDetailDTO> list = new ArrayList<>();
        String sql = " select od.orderDetailID, c.courseID, od.odetailQty, od.price, o.orderID\n"
                + "from ((tblOrderDetail od inner join tblOrder o on od.orderID=o.orderID)\n"
                + "inner join tblCourse c on c.courseID = od.courseID)";
        
        try {
            conn = new DBUtils().getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            
            while (rs.next()) {
                
                list.add(new OrderDetailDTO(rs.getInt(1),
                        rs.getLong(2),
                        rs.getInt(3),
                        rs.getInt(4),
                        rs.getInt(5)));
            }
        } catch (Exception e) {
        }
        return list;
    }
    
    public void addNewOrderDetail(int orderDetailID, long courseID, int orderDetailQty, int price, int orderID) throws NoSuchAlgorithmException {
        
        String sql = "insert into tblOrderDetail\n"
                + "values(?, ?, ?, ?, ?)";
        try {
            conn = new DBUtils().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, orderDetailID);
            ps.setLong(2, courseID);
            ps.setInt(3, orderDetailQty);
            ps.setInt(4, price);
            ps.setInt(5, orderID);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }
    
    public List<OrderDetailDTO> getOrderDetailManageByOrderID(String orderID) {
        List<OrderDetailDTO> list = new ArrayList<>();
        String sql = " select od.orderDetailID, c.courseID, od.odetailQty, od.price, o.orderID, c.courseName\n"
                + "from ((tblOrderDetail od inner join tblOrder o on od.orderID=o.orderID)\n"
                + "inner join tblCourse c on c.courseID = od.courseID)"
                + "where o.orderID = ? ";
        
        try {
            conn = new DBUtils().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, orderID);
            rs = ps.executeQuery();
            
            while (rs.next()) {               
                list.add(new OrderDetailDTO(rs.getInt(1),
                        rs.getLong(2),
                        rs.getInt(3),
                        rs.getInt(4),
                        rs.getInt(5),
                        rs.getString(6)));
            }
        } catch (Exception e) {
        }
        return list;
    }
    
    public static void main(String[] args) throws NoSuchAlgorithmException {
        OrderDetailDAO odetail = new OrderDetailDAO();
//        odao.addNewOrder(54322, "SE140506", "11-12-2022", "bbbb", "bbb", "bbb", "bbb", 3, 70000);
//    odetail.addNewOrderDetail(12331, "9780008483616", 3, 29000, 54321);
System.out.println(odetail.getOrderDetailManageByOrderID("54321"));

    }
}
