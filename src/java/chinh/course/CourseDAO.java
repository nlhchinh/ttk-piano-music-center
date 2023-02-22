/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chinh.course;

import chinh.account.AccountDTO;
import chinh.order.OrderDTO;
import chinh.utils.DBUtils;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.naming.NamingException;

/**
 *
 * @author Admin
 */
public class CourseDAO {

    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public List<CourseDTO> getAllCourse(int index) {
        List<CourseDTO> list = new ArrayList<>();
        String sql = "select courseID, courseName, image, description, tuitionFee, startDate, endDate, category, quantity, status\n"
                + "from tblCourse\n"
                + "where status = 'active'\n"
                + "order by startDate\n"
                + "offset ? rows fetch next 4 rows only";
        try {
            conn = new DBUtils().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, (index - 1) * 3);
            rs = ps.executeQuery();

            while (rs.next()) {
                list.add(new CourseDTO(
                        rs.getLong(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getInt(5),
                        rs.getDate(6),
                        rs.getDate(7),
                        rs.getString(8),
                        rs.getInt(9),
                        rs.getString(10)));
            }
        } catch (Exception e) {
        }
        return list;
    }
    
    public List<CourseDTO> getAllCourse2(int index) {
        List<CourseDTO> list = new ArrayList<>();
        String sql = "select courseID, courseName, image, description, tuitionFee, startDate, endDate, category, quantity, status\n"
                + "from tblCourse\n"
                + "where status = 'active' or status = 'close'\n"
                + "order by startDate\n"
                + "offset ? rows fetch next 4 rows only";
        try {
            conn = new DBUtils().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, (index - 1) * 3);
            rs = ps.executeQuery();

            while (rs.next()) {
                list.add(new CourseDTO(
                        rs.getLong(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getInt(5),
                        rs.getDate(6),
                        rs.getDate(7),
                        rs.getString(8),
                        rs.getInt(9),
                        rs.getString(10)));
            }
        } catch (Exception e) {
        }
        return list;
    }

    public int getTotalCourse() throws SQLException {
        String sql = "select count(*) from tblCourse";
        try {
            conn = new DBUtils().getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (Exception e) {
        }
        return 0;
    }

    public List<CourseDTO> getCourseBySearch(String courseName, String category) {
        List<CourseDTO> list = new ArrayList<>();
        String sql = "select courseID, courseName, image, description, tuitionFee, startDate, endDate, category, quantity, status\n"
                + "from tblCourse\n"
                + "where status = 'active' and courseName like ? and category = ?\n"
                + "order by startDate";
        try {
            conn = new DBUtils().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, "%" + courseName + "%");
            ps.setString(2, category);
            rs = ps.executeQuery();

            while (rs.next()) {
                list.add(new CourseDTO(
                        rs.getLong(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getInt(5),
                        rs.getDate(6),
                        rs.getDate(7),
                        rs.getString(8),
                        rs.getInt(9),
                        rs.getString(10)));
            }
        } catch (Exception e) {
        }
        return list;
    }

    public CourseDTO getCourseByID(String courseID) {
        String sql = "select courseID, courseName, image, description, tuitionFee, startDate, endDate, category, quantity, status\n"
                + "from tblCourse\n"
                + "where status = 'active' or status = 'close' and courseID = ?";
        try {
            conn = new DBUtils().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, courseID.trim());
            rs = ps.executeQuery();

            while (rs.next()) {
                return new CourseDTO(
                        rs.getLong(1),
                        rs.getString(2).trim(),
                        rs.getString(3).trim(),
                        rs.getString(4).trim(),
                        rs.getInt(5),
                        rs.getDate(6),
                        rs.getDate(7),
                        rs.getString(8).trim(),
                        rs.getInt(9),
                        rs.getString(10).trim());
            }
        } catch (Exception e) {
        }
        return null;
    }
    
    public CourseDTO getCourseByID2(String courseID) {
        String sql = "select courseID, courseName, image, description, tuitionFee, startDate, endDate, category, quantity, status\n"
                + "from tblCourse\n"
                + "where courseID = ?";
        try {
            conn = new DBUtils().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, courseID.trim());
            rs = ps.executeQuery();

            while (rs.next()) {
                return new CourseDTO(
                        rs.getLong(1),
                        rs.getString(2).trim(),
                        rs.getString(3).trim(),
                        rs.getString(4).trim(),
                        rs.getInt(5),
                        rs.getDate(6),
                        rs.getDate(7),
                        rs.getString(8).trim(),
                        rs.getInt(9),
                        rs.getString(10).trim());
            }
        } catch (Exception e) {
        }
        return null;
    }

    public int getQuantityByCourseID(long courseID) {
        String sql = " select quantity\n"
                + "from tblCourse\n"
                + "where courseID = ? ";
        try {
            conn = new DBUtils().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setLong(1, courseID);
            rs = ps.executeQuery();
            while (rs.next()) {
                int qty = rs.getInt(1);
                return qty;
            }
        } catch (Exception e) {
        }
        return 0;
    }

    public void updateQuantityBookByBookCode(int quantity, long courseID) {
        String sql = " update tblCourse \n"
                + "set quantity = ?\n"
                + "where courseID = ? ";
        try {
            conn = new DBUtils().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, quantity);
            ps.setLong(2, courseID);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    public void updateCourse(String courseName, String image, String description, int tuitionFee, String startDate, String endDate, String category, int quanity, String status, String courseID) {
        String sql = "update tblCourse \n"
                + "set courseName = ?, image = ?, description = ?, tuitionFee = ?, startDate = ?, endDate = ?, category = ?, quantity = ?, status = ?\n"
                + "where courseID = ?";
        try {
            conn = new DBUtils().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, courseName);
            ps.setString(2, image);
            ps.setString(3, description);
            ps.setInt(4, tuitionFee);
            ps.setString(5, startDate);
            ps.setString(6, endDate);
            ps.setString(7, category);
            ps.setInt(8, quanity);
            ps.setString(9, status);
            ps.setString(10, courseID);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    public void updateCourseWithoutStatus(String courseName, String image, String description, int tuitionFee, String startDate, String endDate, String category, int quanity, String courseID) {
        String sql = "update tblCourse \n"
                + "set courseName = ?, image = ?, description = ?, tuitionFee = ?, startDate = ?, endDate = ?, category = ?, quantity = ?\n"
                + "where courseID = ?";
        try {
            conn = new DBUtils().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, courseName);
            ps.setString(2, image);
            ps.setString(3, description);
            ps.setInt(4, tuitionFee);
            ps.setString(5, startDate);
            ps.setString(6, endDate);
            ps.setString(7, category);
            ps.setInt(8, quanity);
            ps.setString(9, courseID);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    public void updateCourseWithoutStatusAndCate(String courseName, String image, String description, int tuitionFee, String startDate, String endDate, int quanity, String courseID) {
        String sql = "update tblCourse \n"
                + "set courseName = ?, image = ?, description = ?, tuitionFee = ?, startDate = ?, endDate = ?, quantity = ?\n"
                + "where courseID = ?";
        try {
            conn = new DBUtils().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, courseName);
            ps.setString(2, image);
            ps.setString(3, description);
            ps.setInt(4, tuitionFee);
            ps.setString(5, startDate);
            ps.setString(6, endDate);
            ps.setInt(7, quanity);
            ps.setString(8, courseID);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    public CourseDTO existCourseID(long courseID) {

        String sql = " select courseID, courseName, image, description, tuitionFee, startDate, endDate, category, quantity, status\n"
                + "from tblCourse\n"
                + "where courseID = ? ";
        try {
            conn = new DBUtils().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setLong(1, courseID);
            rs = ps.executeQuery();
            while (rs.next()) {
                long id = rs.getLong(1);
                String courseName = rs.getString(2).trim();
                String image = rs.getString(3).trim();
                String description = rs.getString(4).trim();
                int tuitionFee = rs.getInt(5);
                Date startDate = rs.getDate(6);
                Date endDate = rs.getDate(7);
                String category = rs.getString(8).trim();
                int quantity = rs.getInt(9);
                String status = rs.getString(10).trim();

                return new CourseDTO(id, courseName, image, description, tuitionFee, startDate, endDate, category, quantity, status);
            }
        } catch (Exception e) {
        }

        return null;
    }

    public void addNewCourse(String courseID, String courseName, String image, String description,
            int tuitionFee, String startDate, String endDate, String category, int quantity, String status) throws NoSuchAlgorithmException {
        String sql = " insert into tblCourse(courseID, courseName, image, description, tuitionFee, startDate, endDate, category, quantity, status)\n"
                + "values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?) ";
        try {
            conn = new DBUtils().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, courseID);
            ps.setString(2, courseName);
            ps.setString(3, image);
            ps.setString(4, description);
            ps.setInt(5, tuitionFee);
            ps.setString(6, startDate);
            ps.setString(7, endDate);
            ps.setString(8, category);
            ps.setInt(9, quantity);
            ps.setString(10, status);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    public List<CourseDTO> getCourseBySearchAd(String courseName, String category, String status) {
        List<CourseDTO> list = new ArrayList<>();
        String sql = "select courseID, courseName, image, description, tuitionFee, startDate, endDate, category, quantity, status\n"
                + "from tblCourse\n"
                + "where status = ? and courseName like ? and category = ?\n"
                + "order by startDate";
        try {
            conn = new DBUtils().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, status.trim());
            ps.setString(2, "%" + courseName.trim() + "%");
            ps.setString(3, category.trim());
            rs = ps.executeQuery();

            while (rs.next()) {
                list.add(new CourseDTO(
                        rs.getLong(1),
                        rs.getString(2).trim(),
                        rs.getString(3).trim(),
                        rs.getString(4).trim(),
                        rs.getInt(5),
                        rs.getDate(6),
                        rs.getDate(7),
                        rs.getString(8).trim(),
                        rs.getInt(9),
                        rs.getString(10).trim()));
            }
        } catch (Exception e) {
        }
        return list;
    }

    public int getQuantityByCourseID2(String courseID) {
        String sql = " select quantity\n"
                + "from tblCourse\n"
                + "where courseID = ? ";
        try {
            conn = new DBUtils().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, courseID.trim());
            rs = ps.executeQuery();
            while (rs.next()) {
                int qty = rs.getInt(1);
                return qty;
            }
        } catch (Exception e) {
        }
        return 0;
    }

    public static void main(String[] args) throws SQLException, NoSuchAlgorithmException {
        CourseDAO cdao = new CourseDAO();
//        String id = "9780008483616";
//        long ID = Long.parseLong(id);
        System.out.println(cdao.getCourseBySearch("as","guitar"));

    }
}
