/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chinh.cart;

import chinh.account.AccountDAO;
import chinh.account.AccountDTO;
import chinh.course.CourseDAO;
import chinh.order.OrderDAO;
import chinh.order.OrderDTO;
import chinh.order.OrderDetailDAO;
import chinh.order.OrderDetailDTO;
import java.io.IOException;
import java.io.PrintWriter;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
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
public class CheckOutController extends HttpServlet {

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
            throws ServletException, IOException, NoSuchAlgorithmException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            List<Cart> cart = new ArrayList<Cart>();
            HttpSession session = request.getSession();
            cart = (List<Cart>) session.getAttribute("cart");
            AccountDTO dto = (AccountDTO) session.getAttribute("acc");
            String userID = request.getParameter("userID");
            AccountDAO adao = new AccountDAO();
            String checkRole = adao.checkRoleByUserID(userID);
            String checkUserID = adao.checkUserIdExist(userID);

            if (checkUserID != null) {
                if (dto == null || dto.getRole().trim().equals("US")) {
                    if (checkRole.trim().equals("US")) {
                        if (cart != null) {
                            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
                            LocalDateTime now = LocalDateTime.now();
                            String orderDate = dtf.format(now);
                            String address = request.getParameter("address");
                            String note = request.getParameter("note");
                            String paymentMethod = request.getParameter("payment");
                            String paymentStatus = "not yet";
                            int total = totalPrice(cart);

                            OrderDAO odao = new OrderDAO();
                            List<OrderDTO> list = odao.getOrderManage();
                            getLastOrderID(list);

                            int orderID = getLastOrderID(list);
                            if (note.equals("")) {
                                note = "(empty)";
                                odao.addNewOrder(orderID, userID, orderDate, address, note, paymentMethod, paymentStatus, total);
                            }
                            odao.addNewOrder(orderID, userID, orderDate, address, note, paymentMethod, paymentStatus, total);

                            for (Cart c : cart) {
                                OrderDetailDAO odetail = new OrderDetailDAO();
                                List<OrderDetailDTO> list2 = odetail.getOrderDetailManage();

                                int oDetailID = getLastOrderDetailID(list2);

                                long courseID = c.getCourse().getCourseID();

                                int orderDetailQty = c.getAmount();

                                int price = c.getCourse().getTuitionFee();

                                int quantityBookInCart = c.getAmount();

                                CourseDAO cdao = new CourseDAO();

                                int quanityBookAvailable = cdao.getQuantityByCourseID(courseID);

                                int quanityBookAvailableAfter = quanityBookAvailable - quantityBookInCart;

                                cdao.updateQuantityBookByBookCode(quanityBookAvailableAfter, courseID);

                                odetail.addNewOrderDetail(oDetailID, courseID, orderDetailQty, price, orderID);
                            }
                            // lam rong cart
                            cart = null;
                            // set cart lai
                            session.setAttribute("cart", cart);
                            request.getRequestDispatcher("trackorder").forward(request, response);
                        } else {
                            request.getRequestDispatcher("checkoutnav").forward(request, response);
                        }
                    } else if (checkRole.trim().equals("AD")) {
                        request.setAttribute("invalidID", "This userID does not have permission to checkout!!!We sorry for the inconvenient");
                        request.getRequestDispatcher("checkoutnav").forward(request, response);
                    }
                } else if (dto.getRole().trim().equals("AD")) {
                    request.setAttribute("invalidRole", "This account does not have permission to checkout!!!We sorry for the inconvenient");
                    request.getRequestDispatcher("checkoutnav").forward(request, response);
                }
            } else {
                request.setAttribute("existID", "This userID is not found in database. Please choose another ID.");
                request.getRequestDispatcher("checkoutnav").forward(request, response);
            }
        }
    }

    private int totalPrice(List<Cart> cart) { // tinh tong tien
        int totalPrice = 0;
        for (Cart c : cart) {
            totalPrice += c.getCourse().getTuitionFee() * c.getAmount();
        }
        return totalPrice;
    }

    private int getLastOrderID(List<OrderDTO> list) {
        if (list.size() > 0) {
            int lastOrderID;
            int sizeList = list.size() - 1;
            lastOrderID = (int) (list.get(sizeList).getOrderID() + 1);
            return lastOrderID;
        }
        return 1;
    }

    private int getLastOrderDetailID(List<OrderDetailDTO> list2) {
        if (list2.size() > 0) {
            int lastOrderDetailID;
            int sizeList2 = list2.size() - 1;
            lastOrderDetailID = (int) (list2.get(sizeList2).getOrderDetailID() + 1);
            return lastOrderDetailID;
        }
        return 1;
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
            Logger.getLogger(CheckOutController.class
                    .getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(CheckOutController.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(CheckOutController.class
                    .getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(CheckOutController.class.getName()).log(Level.SEVERE, null, ex);
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
