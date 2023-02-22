/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chinh.admin;

import chinh.account.AccountDTO;
import chinh.course.CourseDAO;
import chinh.course.CourseDTO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
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
public class AdminHomeController extends HttpServlet {

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
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            HttpSession session = request.getSession();
            AccountDTO dto = (AccountDTO) session.getAttribute("acc");
            if (dto == null) {
                request.getRequestDispatcher("login.jsp").forward(request, response);
            } else {
                if (dto.getRole().trim().equals("AD")) {
                    String index = request.getParameter("index");
                    if (index == null) {
                        int i = 1;
                        CourseDAO cdao = new CourseDAO();
                        int count = cdao.getTotalCourse();
                        int endPage = count / 3;
                        List<CourseDTO> listC = cdao.getAllCourse2(i);
                        request.setAttribute("listC", listC);
                        if (count % 3 != 0) {
                            endPage++;
                        }
                        request.setAttribute("endP", endPage);
                        request.getRequestDispatcher("adHome.jsp").forward(request, response);
                    } else {
                        int i = Integer.parseInt(index);
                        CourseDAO cdao = new CourseDAO();
                        int count = cdao.getTotalCourse();
                        int endPage = count / 3;
                        List<CourseDTO> listC = cdao.getAllCourse2(i);
                        request.setAttribute("listC", listC);
                        if (count % 3 != 0) {
                            endPage++;
                        }
                        request.setAttribute("endP", endPage);
                        request.getRequestDispatcher("adHome.jsp").forward(request, response);
                    }
                } else if (dto.getRole().trim().equals("US")) {
                    request.getRequestDispatcher("home").forward(request, response);
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
        } catch (SQLException ex) {
            Logger.getLogger(AdminHomeController.class.getName()).log(Level.SEVERE, null, ex);
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
        } catch (SQLException ex) {
            Logger.getLogger(AdminHomeController.class.getName()).log(Level.SEVERE, null, ex);
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
