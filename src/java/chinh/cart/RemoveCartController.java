/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chinh.cart;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Admin
 */
public class RemoveCartController extends HttpServlet {

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
            List<Cart> cart = new ArrayList<Cart>();
            String courseID = request.getParameter("courseID");
            long id = Long.parseLong(courseID);

            if (action.equals("remove")) {
                cart = (List<Cart>) session.getAttribute("cart");
                for (Cart c : cart) {
                    if (String.valueOf(c.getCourse().getCourseID()).equals(String.valueOf(id))) {
                        cart.remove(c);
                        break;
                    }
                }

                int totalPrice = totalPrice(cart);
                session.setAttribute("totalPrice", totalPrice);// set tong tien
                session.setAttribute("cart", cart);
                if (cart.isEmpty()) {
                    cart = null;
                    session.setAttribute("cart", cart);
                    request.getRequestDispatcher("cart.jsp").forward(request, response);
                }
                request.getRequestDispatcher("cart.jsp").forward(request, response);
            } else {
                request.getRequestDispatcher("cart.jsp").forward(request, response);
            }
        }
    }

    private int isExisting(long courseID, List<Cart> cart) { // kiem tra xem 1 cuon sach co trong cart chua tra ve vi tri
        for (int i = 0; i < cart.size(); i++) {
            if (cart.get(i).getCourse().getCourseID() == courseID) {
                return i;
            }
        }
        return -1;
    }

    private int totalPrice(List<Cart> cart) { // tinh tong tien
        int totalPrice = 0;
        for (Cart c : cart) {
            totalPrice += c.getCourse().getTuitionFee() * c.getAmount();
        }
        return totalPrice;
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
