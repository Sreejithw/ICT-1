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
import database.ProductMgr;

/**
 *
 * @author hy
 */
public class AddItem extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
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
        
        int item_id = Integer.parseInt(request.getParameter("item_id"));
        String item_name = request.getParameter("item_name");
        int item_price = Integer.parseInt(request.getParameter("item_price"));
        String item_gender = request.getParameter("item_gender");
        String item_category = request.getParameter("item_category");
        String item_manufacture = request.getParameter("item_manufacture");
        String item_info = request.getParameter("item_info");
        String item_description = request.getParameter("item_description");
        
        int item_discount = 0;
        
        try {
            ProductMgr.addProduct(item_id, item_name, item_price, item_discount, 
                    item_gender, item_category, item_manufacture, item_info, item_description);
            out.println("success");
        } catch (Exception ex) {
            Logger.getLogger(AddPic.class.getName()).log(Level.SEVERE, null, ex);
            out.print("Error");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.sendError(HttpServletResponse.SC_NOT_FOUND);
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
