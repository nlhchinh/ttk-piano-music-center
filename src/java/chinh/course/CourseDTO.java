/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chinh.course;

import java.sql.Date;

/**
 *
 * @author Admin
 */
public class CourseDTO {
    private long courseID;
    private String courseName;
    private String image;
    private String description;
    private int tuitionFee;
    private Date startDate;
    private Date endDate;
    private String category;
    private int quantity;
    private String status;

    public CourseDTO() {
    }

    public CourseDTO(long courseID, String courseName, String image, String description, int tuitionFee, Date startDate, Date endDate, String category, int quantity, String status) {
        this.courseID = courseID;
        this.courseName = courseName;
        this.image = image;
        this.description = description;
        this.tuitionFee = tuitionFee;
        this.startDate = startDate;
        this.endDate = endDate;
        this.category = category;
        this.quantity = quantity;
        this.status = status;
    }

    public long getCourseID() {
        return courseID;
    }

    public void setCourseID(long courseID) {
        this.courseID = courseID;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getTuitionFee() {
        return tuitionFee;
    }

    public void setTuitionFee(int tuitionFee) {
        this.tuitionFee = tuitionFee;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "CourseDTO{" + "courseID=" + courseID + ", courseName=" + courseName + ", image=" + image + ", description=" + description + ", tuitionFee=" + tuitionFee 
                + ", startDate=" + startDate + ", endDate=" + endDate + ", category=" + category + ", quantity=" + quantity + ", status=" + status + '}' + '\n';
    }

    
    
    
}
