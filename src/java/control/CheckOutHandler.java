/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import database.BillMgr;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.BillAddress;
import model.Cart;
import model.User;
import org.jboss.logging.Logger;

/**
 *
 * @author hy
 */
public class CheckOutHandler extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            Cart cart = (Cart) request.getSession().getAttribute("cart");
            User user = (User) request.getSession().getAttribute("user");
            if (cart == null) {
                out.println("empty cart");
                return;
            }
            if (user == null) {
                out.println("please login or register");
                return;
            }
            BillAddress address = new BillAddress();
            address.bill_fname = ParamUtil.getString(request, "fName");
            address.bill_lname = ParamUtil.getString(request, "lName");
            address.bill_email = ParamUtil.getString(request, "email");
            address.bill_tel = ParamUtil.getInteger(request, "phone", 0);
            address.bill_address = String.format("%s BLOCK %s", ParamUtil.getString(request, "street"), ParamUtil.getString(request, "blk"));
            address.bill_floor = ParamUtil.getString(request, "floor");
            address.bill_unit = ParamUtil.getString(request, "unit");
            address.bill_postcode = ParamUtil.getInteger(request, "zip", 0);
            address.bill_country = ParamUtil.getString(request, "country");
            String shipping = ParamUtil.getString(request, "shipping");
            int shippingPrice = 0;
            switch (shipping) {
                case "std":
                    shippingPrice = 5;
                    break;
                case "express":
                    shippingPrice = 15;
                    break;
            }
            //out.print("success");
            java.util.logging.Logger.getLogger(CheckOutHandler.class.getName()).info(String.format("%d",cart.itemList().size()));
            BillMgr.newBill(user.id, shippingPrice, shipping, cart.itemList(), address);
            response.sendRedirect("my_order.shtml");

        } catch (Exception ex) {
            java.util.logging.Logger.getLogger(CheckOutHandler.class.getName()).log(Level.SEVERE, null, ex);
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
    }
    
}
