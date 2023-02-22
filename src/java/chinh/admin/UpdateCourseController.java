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
import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Admin
 */
public class UpdateCourseController extends HttpServlet {

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
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String imageLink = request.getParameter("image");
            String courseName = request.getParameter("courseName");
            String description = request.getParameter("description");
            String cmbCateUp = request.getParameter("cmbCateUp");
            String category = request.getParameter("category");
            String tuitionFee = request.getParameter("tuitionFee");
            int price = Integer.parseInt(tuitionFee);
            String startDate = request.getParameter("startDate");
            String endDate = request.getParameter("endDate");
            String courseID = request.getParameter("courseID");
            String quantity = request.getParameter("quantity");
            int qty = Integer.parseInt(quantity);
            String cmbStatus = request.getParameter("cmbStatus");
            String status = request.getParameter("status");
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

            CourseDAO cdao = new CourseDAO();
            HttpSession session = request.getSession();
            AccountDTO dto = (AccountDTO) session.getAttribute("acc");
            if (dto == null) {
                request.getRequestDispatcher("login.jsp").forward(request, response);
            } else {
                if (noDay1 >= 1 && noDay2 >= 1 && noDay3 >= 7) {
                    if (cmbStatus.equals("none")) {
                        if (cmbCateUp.equals("none")) {
                            cdao.updateCourse(courseName.trim(), imageLink.trim(), description.trim(), price, startDate.trim(), endDate.trim(), category.trim(), qty, status.trim(), courseID.trim());
                            request.getRequestDispatcher("updatenav?courseID=" + courseID).forward(request, response);
                        } else {
                            cdao.updateCourse(courseName.trim(), imageLink.trim(), description.trim(), price, startDate.trim(), endDate.trim(), cmbCateUp.trim(), qty, status.trim(), courseID.trim());
                            request.getRequestDispatcher("updatenav?courseID=" + courseID).forward(request, response);
                        }
                    } else if (cmbStatus.equals("active")) {
                        if (cmbCateUp.equals("none")) {
                            cdao.updateCourse(courseName.trim(), imageLink.trim(), description.trim(), price, startDate.trim(), endDate.trim(), category.trim(), qty, cmbStatus.trim(), courseID.trim());
                            request.getRequestDispatcher("updatenav?courseID=" + courseID).forward(request, response);
                        } else {
                            cdao.updateCourse(courseName.trim(), imageLink.trim(), description.trim(), price, startDate.trim(), endDate.trim(), cmbCateUp.trim(), qty, cmbStatus.trim(), courseID.trim());
                            request.getRequestDispatcher("updatenav?courseID=" + courseID).forward(request, response);
                        }
                    } else if (cmbStatus.equals("close")) {
                        if (cmbCateUp.equals("none")) {
                            cdao.updateCourse(courseName.trim(), imageLink.trim(), description.trim(), price, startDate.trim(), endDate.trim(), category.trim(), qty, cmbStatus.trim(), courseID.trim());
                            request.getRequestDispatcher("updatenav?courseID=" + courseID).forward(request, response);
                        } else {
                            cdao.updateCourse(courseName.trim(), imageLink.trim(), description.trim(), price, startDate.trim(), endDate.trim(), cmbCateUp.trim(), qty, cmbStatus.trim(), courseID.trim());
                            request.getRequestDispatcher("updatenav?courseID=" + courseID).forward(request, response);
                        }
                    }
                } else {
                    request.setAttribute("invalidDate", "Invalid date!!! Please read the note and try again.");
                    request.getRequestDispatcher("updatenav?courseID=" + courseID).forward(request, response);
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
        processRequest(request, response);
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
        processRequest(request, response);
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
