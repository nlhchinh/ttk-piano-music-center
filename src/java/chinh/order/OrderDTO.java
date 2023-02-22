/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chinh.order;

import java.sql.Date;

/**
 *
 * @author Admin
 */
public class OrderDTO {

    private int orderID;
    private String userID;
    private Date orderDate;
    private String address;
    private String note;
    private String paymentMethod;
    private String paymentStatus;
    private int total;

    public OrderDTO() {
    }

    public OrderDTO(int orderID, String userID, Date orderDate, String address, String note, String paymentMethod, String paymentStatus, int total) {
        this.orderID = orderID;
        this.userID = userID;
        this.orderDate = orderDate;
        this.address = address;
        this.note = note;
        this.paymentMethod = paymentMethod;
        this.paymentStatus = paymentStatus;
        this.total = total;
    }

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "OrderDTO{" + "orderID=" + orderID + ", userID=" + userID
                + ", orderDate=" + orderDate + ", address=" + address
                + ", note=" + note + ", paymentMethod=" + paymentMethod
                + ", paymentStatus=" + paymentStatus
                + ", total=" + total + '}' + '\n';
    }

}
