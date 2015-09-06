/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Item;

/**
 *
 * @author hy
 */
public class GetItem extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            ArrayList<Item> items;
            if (request.getParameter("product") != null) {
                try {
                    int productId = Integer.parseInt(request.getParameter("product"));
                    items = database.ItemMgr.getItemByProductId(productId);
                    out.print("\u005B");
                    String s = "";
                    for (Item i : items) {
                        out.print(s);
                        out.printf("\u005B%d,\"%s\",\"%s\",\"%s\",\"%s\"\u005D",
                                i.item_id, i.item_color, i.item_material, i.item_quantity, i.item_size);
                        s = ",";
                    }
                    out.print("\u005D");
                } catch (Exception e) {
                    Logger.getLogger(AddPic.class.getName()).log(Level.SEVERE, null, e);
                    out.println("\u005B\u005D");
                }
            } else {
                int itemId = Integer.parseInt(request.getParameter("item"));
                try {
                    Item i = database.ItemMgr.getItemByItemId(itemId);
                    out.printf("\u005B%d,\"%s\",\"%s\",\"%s\",\"%s\"\u005D",
                                i.item_id, i.item_color, i.item_material, i.item_quantity, i.item_size);
                } catch (Exception ex) {
                    Logger.getLogger(GetItem.class.getName()).log(Level.SEVERE, null, ex);
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
