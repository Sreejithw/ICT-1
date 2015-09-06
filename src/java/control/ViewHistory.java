/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import database.BillMgr;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.BillInfo;

/**
 *
 * @author hy
 */
public class ViewHistory extends HttpServlet {

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
        try {
            response.setContentType("text/html;charset=UTF-8");
            ArrayList<BillInfo> info = BillMgr.getBillInfo(Integer.parseInt(request.getParameter("id")));
            String type = request.getParameter("type");
            int shippingPrice = 0;
            if (type.equals("std")) {
                shippingPrice = 5;
            } else if (type.equals("express")) {
                shippingPrice = 10;
            }
            Logger.getLogger(ViewHistory.class.getName()).info(String.format("%s %d", type ,shippingPrice));
            StringBuilder res = new StringBuilder();
            int subtotal = 0;
            for (BillInfo i : info) {
                res.append("<tr>\n"
                        + "<td data-title=\"Product Name\">\n"
                        + "<p class=\"product_title\">" + i.product.name + "</p>\n"
                        + "<ul class=\"sc_product_info\">\n"
                        + "<li><b>Size:</b> " + i.item.item_size + "</li>\n"
                        + "<li><b>Color:</b> " + i.item.item_color + "</li>\n"
                        + "<li><b>Material:</b> " + i.item.item_material + "</li>\n"
                        + "</ul>\n"
                        + "</td>\n"
                        + "<td data-title=\"SKU\">" + i.item.item_id + "</td>\n"
                        + "<td data-title=\"Price\" class=\"subtotal\">$" + i.product.price + "</td>\n"
                        + "<td data-title=\"Quantity\">" + i.item.item_quantity + "</td>\n"
                        + "<td data-title=\"Total\" class=\"total\">$" + i.product.price * i.item.item_quantity + "</td>\n"
                        + "</tr>");
                subtotal += i.product.price * i.item.item_quantity;
            }
            request.setAttribute("row", res.toString());
            request.setAttribute("subtotal", String.format("$%d", subtotal));
            request.setAttribute("shipping", String.format("$%d", shippingPrice));
            request.setAttribute("total", String.format("$%d", subtotal+shippingPrice));
            request.getRequestDispatcher("/modals/view_order.ftl").forward(request, response);
        } catch (Exception ex) {
            Logger.getLogger(ViewHistory.class.getName()).log(Level.SEVERE, null, ex);
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
