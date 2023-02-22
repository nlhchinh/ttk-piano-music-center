/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chinh.cart;

import chinh.course.CourseDTO;

/**
 *
 * @author Admin
 */
public class Cart {
    private CourseDTO course;
    private int amount;

    public Cart() {
    }

    public Cart(CourseDTO course, int amount) {
        this.course = course;
        this.amount = amount;
    }

    public CourseDTO getCourse() {
        return course;
    }

    public void setCourse(CourseDTO course) {
        this.course = course;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }


    @Override
    public String toString() {
        return "Cart{" + "course=" + course + ", amount=" + amount + '}' + '\n';
    }
    
    
    
}
