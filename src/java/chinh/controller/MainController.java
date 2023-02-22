/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chinh.controller;

import chinh.account.AccountDTO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Admin
 */
public class MainController extends HttpServlet {

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
            String action = request.getParameter("action");
            HttpSession session = request.getSession();
            AccountDTO dto = (AccountDTO) session.getAttribute("acc");

            if (action == null) {
                request.getRequestDispatcher("404.html").forward(request, response);
            } else if (action.equals("login")) {
                request.getRequestDispatcher("login").forward(request, response);
            } else if (action.equals("logout")) {
                request.getRequestDispatcher("logout").forward(request, response);
            } else if (action.equals("search")) {
                request.getRequestDispatcher("search").forward(request, response);
            } else if (action.equals("addToCart")) {
                request.getRequestDispatcher("addtocart").forward(request, response);
            } else if (action.equals("update")) {
                request.getRequestDispatcher("updatecart").forward(request, response);
            } else if (action.equals("remove")) {
                request.getRequestDispatcher("removecart").forward(request, response);
            } else if (action.equals("confirm")) {
                request.getRequestDispatcher("checkout").forward(request, response);
            } else if (action.equals("Update Course")) {
                request.getRequestDispatcher("updatecourse").forward(request, response);
            } else if (action.equals("Create Course")) {
                request.getRequestDispatcher("createnewcourse").forward(request, response);
            } else if (action.equals("Search Course")) {
                request.getRequestDispatcher("searchadmin").forward(request, response);
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
