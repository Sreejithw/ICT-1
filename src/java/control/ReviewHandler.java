/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Review;
import model.User;

/**
 *
 * @author hy
 */
public class ReviewHandler extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            ArrayList<Review> items;
            try {
                items = database.ReviewMgr.getReview(Integer.parseInt(request.getParameter("item")));
                out.print("\u005B");
                String s = "";
                for (Review i : items) {
                    out.print(s);
                    out.printf("\u005B%d,\"%s\",\"%s\",\"%s\",%d,%d,%d,\"%s\"\u005D",
                            i.product_id, i.user.email, i.review_title, new SimpleDateFormat("yyyy-MM-dd HH:mm").format(new Date(i.review_time)),
                            i.review_price, i.review_value, i.review_quality,
                            i.review_text.replace("\r", "").replace("\n", "<br />"));
                    s = ",";
                }
                out.print("\u005D");
            } catch (Exception ex) {
                out.println(ex);
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /*
        
             User user = (User) request.getSession().getAttribute("user");
             out.println(user.id+request.getParameter("item")+request.getParameter("title")+request.getParameter("value_rate")+request.getParameter("price_rate")+request.getParameter("quality_rate")+request.getParameter("content"));
             }
             */
            User user = (User) request.getSession().getAttribute("user");
            if (user == null) {
                out.print("invuser");
                return;
            }
            int item_id = Integer.parseInt(request.getParameter("item"));
            int user_id = user.id;
            String review_title = request.getParameter("title");
            long review_time = Calendar.getInstance().getTime().getTime();
            int review_value = 0;
            int review_price = 0;
            int review_quality = 0;
            try{
                review_value = Integer.parseInt(request.getParameter("value_rate"));
                review_price = Integer.parseInt(request.getParameter("price_rate"));
                review_quality = Integer.parseInt(request.getParameter("quality_rate"));
            }catch(NumberFormatException e){
                out.print("invrate");
                return;
            }
            String review_text = request.getParameter("content");
            if (review_text == null || review_text.replaceAll("[\n\t ]","").equals("")){
                out.print("invtext");
                return;
            }
            if (review_title == null || review_title.replaceAll("[\n\t ]","").equals("")){
                out.print("invtitle");
                return;
            }
            database.ReviewMgr.addReview(item_id, user_id, review_title, review_time, review_value, review_price, review_quality, review_text);
        } catch (Exception ex) {
            Logger.getLogger(ReviewHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
