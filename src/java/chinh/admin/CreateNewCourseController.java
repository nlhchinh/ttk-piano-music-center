/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chinh.admin;

import chinh.account.AccountDTO;
import chinh.course.CourseDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.security.NoSuchAlgorithmException;
import java.sql.Date;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Admin
 */
public class CreateNewCourseController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, NoSuchAlgorithmException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String courseID = request.getParameter("courseID");
            long id = Long.parseLong(courseID);
            String imageLink = request.getParameter("image");
            String courseName = request.getParameter("courseName");
            String description = request.getParameter("description");
            String cmbCate = request.getParameter("cmbCate");
            String price = request.getParameter("price");
            int buyPrice = Integer.parseInt(price);
            String quanitty = request.getParameter("quanitty");
            int qty = Integer.parseInt(quanitty);
            String startDate = request.getParameter("startDate");
            String endDate = request.getParameter("endDate");
            String status = "active";
            CourseDAO cdao = new CourseDAO();
            HttpSession session = request.getSession();
            AccountDTO dto = (AccountDTO) session.getAttribute("acc");
            if (dto == null) {
                request.getRequestDispatcher("login.jsp").forward(request, response);
            } else {
                if (cdao.existCourseID(id) == null) {
                    LocalDate now = LocalDate.now();
                    Date today = Date.valueOf(now);
                    Date tmp1 = Date.valueOf(startDate);
                    Date tmp2 = Date.valueOf(endDate);
                    Calendar c = Calendar.getInstance();
                    Calendar c1 = Calendar.getInstance();
                    Calendar c2 = Calendar.getInstance();
                    c.setTime(today);
                    c1.setTime(tmp1);
                    c2.setTime(tmp2);
                    Long noDay1 = (c1.getTime().getTime() - c.getTime().getTime()) / (24 * 3600 * 1000);
                    Long noDay2 = (c2.getTime().getTime() - c.getTime().getTime()) / (24 * 3600 * 1000);
                    Long noDay3 = (c2.getTime().getTime() - c1.getTime().getTime()) / (24 * 3600 * 1000);
                    if (noDay1 >= 1 && noDay2 >= 1 && noDay3 >= 7) {
                        cdao.addNewCourse(courseID, courseName, imageLink, description, buyPrice, startDate, endDate, cmbCate, qty, status);
                        request.setAttribute("createSucess", "Create New Course Successfull");
                        request.getRequestDispatcher("adminhome").forward(request, response);
                    } else {
                        request.setAttribute("invalidDate", "Invalid Date!!! Read the note and try again!!!");
                        request.getRequestDispatcher("createnav").forward(request, response);
                    }
                } else {
                    request.setAttribute("duplicateCourseID", "CourseID is duplicated!! Please choose another id");
                    request.getRequestDispatcher("createnav").forward(request, response);
                }
            }
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(CreateNewCourseController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(CreateNewCourseController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
