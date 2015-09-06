/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import database.ProductHighlightMgr;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Product;
import model.ProductBest;
import model.ProductDeal;
import model.ProductFeature;
import model.ProductNew;

/**
 *
 * @author hy
 */
public class Index extends HttpServlet {

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
        try {
            ArrayList<ProductNew> newList = ProductHighlightMgr.getProductNew();
            StringBuilder html = new StringBuilder();
            for (ProductNew i : newList) {
                Product j = i.productnew;
                j.defaultPic();
                html.append(arrivalFormat(j));
                //Logger.getLogger(Index.class.getName()).info(String.format("%d", i.productnew.id));
                request.setAttribute("arrival", html.toString());
            }
        } catch (Exception ex) {
            Logger.getLogger(Index.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            ArrayList<ProductDeal> dealList = ProductHighlightMgr.getProductDeal();
            StringBuilder html1 = new StringBuilder();
            for (ProductDeal i : dealList) {
                Product j = i.productdeal;
                j.defaultPic();
                html1.append(dealFormat(j));
                //Logger.getLogger(Index.class.getName()).info(String.format("%d", i.productnew.id));
                request.setAttribute("deals", html1.toString());
            }
        } catch (Exception ex) {
            Logger.getLogger(Index.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            ArrayList<ProductBest> dealList = ProductHighlightMgr.getProductBest();
            StringBuilder html1 = new StringBuilder();
            for (ProductBest i : dealList) {
                Product j = i.productbest;
                j.defaultPic();
                html1.append(bestFormat(j));
                //Logger.getLogger(Index.class.getName()).info(String.format("%d", i.productnew.id));
                request.setAttribute("bestsell", html1.toString());
            }
        } catch (Exception ex) {
            Logger.getLogger(Index.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            ArrayList<ProductFeature> dealList = ProductHighlightMgr.getProductFeature();
            StringBuilder html1 = new StringBuilder();
            for (ProductFeature i : dealList) {
                Product j = i.productfeature;
                j.defaultPic();
                html1.append(featuredHtml(j,i.product_state));
                //Logger.getLogger(Index.class.getName()).info(String.format("%d", i.productnew.id));
                request.setAttribute("feature", html1.toString());
            }
        } catch (Exception ex) {
            Logger.getLogger(Index.class.getName()).log(Level.SEVERE, null, ex);
        }
        request.getRequestDispatcher("/index.ftl").forward(request, response);
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

    private static String arrivalFormat(Product j) {
        return "<div class=\"product_item type_3\">\n"
                + "<div class=\"image_wrap\">\n"
                + "<img src=\""+j.profile_pic+"\" alt=\"\">\n"
                + "<div class=\"actions_wrap\">\n"
                + "<button onclick=\"icp.wish("+j.id+")\" class=\"button_dark_grey def_icon_btn middle_btn add_to_wishlist tooltip_container alignleft\"><span class=\"tooltip right\">Add to Wishlist</span></button>\n"
                + "<button class=\"button_black def_icon_btn middle_btn quick_view_product tooltip_container align_center\" data-modal-url=\"view?id="+j.id+"\"><span class=\"tooltip top\">Quick View</span></button>\n"
                + "<a href=\"product?id="+j.id+"\" class=\"button_blue def_icon_btn middle_btn add_to_cart tooltip_container alignright\"><span class=\"tooltip left\">Add to Cart</span></a>\n"
                + "</div>\n"
                + "</div>\n"
                + "<div class=\"label_new\">New</div>\n"
                + "<div class=\"description\">\n"
                + "<a href=\"product?id="+j.id+"\">"+j.name+"</a>\n"
                + "<div class=\"clearfix product_info\">\n"
                + "<p class=\"product_price alignleft\">"+discountHtml(j.price,j.discount)+"</p>\n"
                + "</div>\n"
                + "</div>\n"
                + "</div>";
    }

    private static String dealFormat(Product j) {
        return "<div class=\"product_item type_3\">\n"
                + "<div class=\"image_wrap\">\n"
                + "<img src=\""+j.profile_pic+"\" alt=\"\">\n"
                + "<div class=\"actions_wrap\">\n"
                + "<button onclick=\"icp.wish("+j.id+")\" class=\"button_dark_grey def_icon_btn add_to_wishlist tooltip_container alignleft\"><span class=\"tooltip right\">Add to Wishlist</span></button>\n"
                + "<button class=\"button_black def_icon_btn quick_view_product tooltip_container align_center\" data-modal-url=\"view?id="+j.id+"\"><span class=\"tooltip top\">Quick View</span></button>\n"
                + "<a href=\"product?id="+j.id+"\" class=\"button_blue def_icon_btn add_to_cart tooltip_container alignright\"><span class=\"tooltip left\">Add to Cart</span></a>\n"
                + "</div>\n"
                + "</div>\n"
                + "<div class=\"label_offer percentage\">\n"
                + discountHtml(j.discount)
                + "</div>\n"
                + "<div class=\"countdown\" data-year=\"2016\" data-month=\"11\" data-day=\"6\" data-hours=\"15\" data-minutes=\"0\" data-seconds=\"0\"></div>\n"
                + "<div class=\"description\">\n"
                + "<a href=\"product?id="+j.id+"\">"+j.name+"</a>\n"
                + "<div class=\"clearfix product_info\">\n"
                + "<p class=\"product_price alignleft\">"+discountHtml(j.price,j.discount)+"</p>\n"
                + "</div>\n"
                + "</div>\n"
                + "</div>";
    }

    private static String featuredHtml(Product j,String label) {
        return "<div class=\"product_item type_3\">\n"
                + "<div class=\"image_wrap\">\n"
                + "<img src=\""+j.profile_pic+"\" alt=\"\">\n"
                + "<div class=\"actions_wrap\">\n"
                + "<button onclick=\"icp.wish("+j.id+")\" class=\"button_dark_grey def_icon_btn middle_btn add_to_wishlist tooltip_container alignleft\"><span class=\"tooltip right\">Add to Wishlist</span></button>\n"
                + "<button class=\"button_black def_icon_btn middle_btn quick_view_product tooltip_container align_center\" data-modal-url=\"view?id="+j.id+"\"><span class=\"tooltip top\">Quick View</span></button>\n"
                + "<a href=\"product?id="+j.id+"\" class=\"button_blue def_icon_btn middle_btn add_to_cart tooltip_container alignright\"><span class=\"tooltip left\">Add to Cart</span></a>\n"
                + "</div>\n"
                + "</div>\n"
                + getTag(label)
                + "<div class=\"description\">\n"
                + "<a href=\"product?id="+j.id+"\">"+j.name+"</a>\n"
                + "<div class=\"clearfix product_info\">\n"
                + "<p class=\"product_price alignleft\">"+discountHtml(j.price,j.discount)+"</p>\n"
                + "</div>\n"
                + "</div>\n"
                + "</div>";
    }

    private static String bestFormat(Product j) {
        return "<div class=\"product_item type_3\">\n"
                + "<div class=\"image_wrap\">\n"
                + "<img src=\""+j.profile_pic+"\" alt=\"\">\n"
                + "<div class=\"actions_wrap\">\n"
                + "<button onclick=\"icp.wish("+j.id+")\" class=\"button_dark_grey def_icon_btn middle_btn add_to_wishlist tooltip_container alignleft\"><span class=\"tooltip right\">Add to Wishlist</span></button>\n"
                + "<button class=\"button_black def_icon_btn middle_btn quick_view_product tooltip_container align_center\" data-modal-url=\"view?id="+j.id+"\"><span class=\"tooltip top\">Quick View</span></button>\n"
                + "<a href=\"product?id="+j.id+"\" class=\"button_blue def_icon_btn middle_btn add_to_cart tooltip_container alignright\"><span class=\"tooltip left\">Add to Cart</span></a>\n"
                + "</div>\n"
                + "</div>\n"
                + "<div class=\"label_bestseller\">Bestseller</div>\n"
                + "<div class=\"description\">\n"
                + "<a href=\"product?id="+j.id+"\">"+j.name+"</a>\n"
                + "<div class=\"clearfix product_info\">\n"
                + "<p class=\"product_price alignleft\">"+discountHtml(j.price,j.discount)+"</p>\n"
                + "</div>\n"
                + "</div>\n"
                + "</div>";
    }

    private static String countdownHtml() {
        return "<div class=\"countdown\" data-year=\"2016\" data-month=\"11\" data-day=\"6\" data-hours=\"15\" data-minutes=\"0\" data-seconds=\"0\"></div>\n";
    }

    private static String discountHtml(int discount) {
        return "<div>" + discount + "%</div>OFF\n";
    }
    
    private static String discountHtml(int price,int discount) {
        return discount > 0 ? String.format("<s>$%d</s> <b class=\"theme_color\">$%d</b>",price,price*(100-discount)/100) : String.format("<b class=\"theme_color\">$%d</b>",price);
    }
    
    private static String getTag(String value) {
        switch (value){
            case "new": return "<div class=\"label_new\">New</div>\n";
            case "hot": return "<div class=\"label_hot\">Hot</div>";
        }
        return "";
    }

}
