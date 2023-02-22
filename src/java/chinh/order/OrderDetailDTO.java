/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chinh.order;

/**
 *
 * @author Admin
 */
public class OrderDetailDTO {

    private int orderDetailID;
    private long courseID;
    private int orderDetailQty;
    private int price;
    private int orderID;
    private String courseName;

    public OrderDetailDTO() {
    }

    public OrderDetailDTO(int orderDetailID, long courseID, int orderDetailQty, int price, int orderID) {
        this.orderDetailID = orderDetailID;
        this.courseID = courseID;
        this.orderDetailQty = orderDetailQty;
        this.price = price;
        this.orderID = orderID;
    }

    public OrderDetailDTO(int orderDetailID, long courseID, int orderDetailQty, int price, int orderID, String courseName) {
        this.orderDetailID = orderDetailID;
        this.courseID = courseID;
        this.orderDetailQty = orderDetailQty;
        this.price = price;
        this.orderID = orderID;
        this.courseName = courseName;
    }
      

    public int getOrderDetailID() {
        return orderDetailID;
    }

    public void setOrderDetailID(int orderDetailID) {
        this.orderDetailID = orderDetailID;
    }

    public long getCourseID() {
        return courseID;
    }

    public void setCourseID(long courseID) {
        this.courseID = courseID;
    }

    public int getOrderDetailQty() {
        return orderDetailQty;
    }

    public void setOrderDetailQty(int orderDetailQty) {
        this.orderDetailQty = orderDetailQty;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    @Override
    public String toString() {
        return "OrderDetailDTO{" + "orderDetailID=" + orderDetailID + ", courseID=" + courseID + ", orderDetailQty=" + orderDetailQty + ", price=" + price + ", orderID=" + orderID + ", courseName=" + courseName + '}';
    }
}
