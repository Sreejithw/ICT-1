/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import database.ProductMgr;
import java.util.ArrayList;
import model.Product;
import model.ProductPic;

/**
 *
 * @author hy
 */
public class ViewItem extends HttpServlet {

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
            Product p = ProductMgr.getProductByProductId(Integer.parseInt(request.getParameter("id")));
            request.setAttribute("id", p.id);
            if (p.discount == 0) {
                request.setAttribute("price", String.format("<b class=\"theme_color\">$%d</b>", p.price));
            } else {
                request.setAttribute("price", String.format("<s>$%d</s> <b class=\"theme_color\">$%d</b>", p.price, p.price * (100 - p.discount) / 100));
            }
            request.setAttribute("manufacture", p.manufacture);
            request.setAttribute("name", p.name);
            request.setAttribute("info", p.info);
            request.setAttribute("gender", p.gender);
            request.setAttribute("category", p.category);
            ArrayList<ProductPic> productPic = ProductMgr.getProductPic(p.id);
            //size check
                request.setAttribute("flarge", productPic.get(0).largePic);
                request.setAttribute("fsmall", productPic.get(0).smallPic);
            //Logger.getLogger(ViewItem.class.getName()).info(imgHtml.toString());
            if (request.getServletPath().equals("/view")) {
                StringBuilder imgHtml = new StringBuilder();
                for (ProductPic i : productPic) {
                    imgHtml.append(
                            "<img src=\""+i.largePic+"\" data-large-image=\""+i.smallPic+"\" alt=\"\">");
                }
                request.setAttribute("img", imgHtml.toString());
                request.getRequestDispatcher("/modals/quick_view.ftl").forward(request, response);
            } else {
                //request.setAttribute("info", p.info);
                StringBuilder imgHtml = new StringBuilder();
                for (ProductPic i : productPic) {
                    imgHtml.append(
                            "<a href=\"#\" data-image=\"" + i.smallPic + "\" data-zoom-image=\"" + i.largePic + "\">\n"
                            + "  <img src=\"" + i.smallPic + "\" data-large-image=\"" + i.largePic + "\" alt=\"\">\n"
                            + "</a>");
                }
                request.setAttribute("img", imgHtml.toString());
                request.getRequestDispatcher("/product.ftl").forward(request, response);
            }
        } catch (Exception ex) {
            Logger.getLogger(ViewItem.class.getName()).log(Level.SEVERE, null, ex);
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
