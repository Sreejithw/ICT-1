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
import model.Product;

/**
 *
 * @author hy
 */
public class SearchHandler extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
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
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            ArrayList<Product> result;
            String keyWord = request.getParameter("keyword");
            StringBuilder res = new StringBuilder();
            if (keyWord != null) {
                try {
                    result = database.ProductMgr.getProductByKeyword(keyWord);
                    boolean isFirst = true;
                    for(Product i:result){
                        if (isFirst){
                            isFirst = false;
                        }else{
                            res.append("<hr class=\"big\">");
                        }
                        res.append("<div class=\"description\">"
                                + "  <div class=\"clearfix product_info\">"
                                + "    <div class=\"col-md-2\"><img src=\""+i.profile_pic+"\" alt=\"\"></div>"
                                + "    <div class=\"col-md-10\">"
                                + "      <a href=\"product?id="+i.id+"\">"+i.name+"</a>"
                                + "      <p class=\"product_price\"><b>Price: $"+i.price+"</b></p>"
                                + "    </div>"
                                + "  </div>"
                                + "</div>");
                    }
                } catch (Exception e) {
                    
                }
            } else {
                
            }
            request.setAttribute("products", res.toString());
            request.getRequestDispatcher("/search.ftl").forward(request, response);
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
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            ArrayList<Product> result;
            String keyWord = request.getParameter("keyword");
            if (keyWord != null) {
                try {
                    result = database.ProductMgr.getProductByKeyword(keyWord);
                    JSONPrinter.printProductJSON(result, out);
                } catch (Exception e) {
                    Logger.getLogger(AddPic.class.getName()).log(Level.SEVERE, null, e);
                    out.println("\u005B\u005D");
                }
            } else {
                out.println("\u005B\u005D");
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

}
