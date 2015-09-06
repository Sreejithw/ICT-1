/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Cart;
import model.Item;
import model.Product;

/**
 *
 * @author hy
 */
public class CartHandler extends HttpServlet {

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
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        Cart cart = (Cart) request.getSession().getAttribute("cart");
        if (cart != null) {
            String act = request.getParameter("act");
            if (act != null && act.equals("view")) {
                printAll(out, cart);
            } else {
                printProducts(out, cart);
            }
        } else {
            out.println("\u005B\u005D");
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
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        Cart cart = (Cart) request.getSession().getAttribute("cart");
        if (cart == null) {
            cart = new Cart();
            request.getSession().setAttribute("cart", cart);
        }

        String act = request.getParameter("act");
        if (act != null && act.equals("clear")) {
            try {
                cart.clear();
                Logger.getLogger(CartHandler.class.getName()).info(act);
            } catch (Exception ex) {
                Logger.getLogger(CartHandler.class.getName()).log(Level.SEVERE, null, ex);
                out.println("invparam");
            }
        } else {
            try {
                int itemId = Integer.parseInt(request.getParameter("item"));
                int qty = Integer.parseInt(request.getParameter("qty"));
                Item item = database.ItemMgr.getItemByItemId(itemId);
                Product product = database.ProductMgr.getProductByProductId(item.product_id);
                if (!cart.add(item, product, qty)) {
                    out.println("invalid product");
                }
                //Logger.getLogger(CartHandler.class.getName()).info(String.format("param: %d %d", itemId, qty));
                //Logger.getLogger(CartHandler.class.getName()).info(String.format("size: %d", cart.size()));
                //Logger.getLogger(CartHandler.class.getName()).info(String.format("cart: %b", cart.product(itemId).equals(product)));
            } catch (Exception ex) {
                Logger.getLogger(CartHandler.class.getName()).log(Level.SEVERE, null, ex);
                out.println("invparam");
            }
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

    private void printProducts(PrintWriter out, Cart cart) {
        out.print("\u005B");
        String s = "";
        for (Integer i : cart.itemId()) {
            out.print(s);
            Product product=cart.product(i);
            out.printf("\u005B%d,\"%s\",%d,\"%s\",%d, %d, %d\u005D",
                    product.id,product.name,product.price,product.profile_pic,
                    i,product.discount,cart.qty(i));
            s = ",";
        }
        out.print("\u005D");
    }
    
    private void printAll(PrintWriter out, Cart cart) {
        out.print("\u005B");
        String s = "";
        for (Integer i : cart.itemId()) {
            out.print(s);
            Product product=cart.product(i);
            Item item=cart.item(i);
            out.printf("\u005B%d,\"%s\",\"%s\",\"%s\",\"%s\",%d,%d,\"%s\",%d,%d\u005D",
                    item.item_id, item.item_material,item.item_color,item.item_size,
                    product.name,product.id,product.price,product.profile_pic,
                    cart.qty(i),cart.total(i));
            s = ",";
        }
        out.print("\u005D");
    }
}