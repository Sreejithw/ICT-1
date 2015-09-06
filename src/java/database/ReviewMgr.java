/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Review;

/**
 *
 * @author Fu
 */
public class ReviewMgr {
    
    public static ArrayList<Review> getReview(int product_id) throws SQLException, Exception {

        Connection conn = DBConn.getConn();
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        pstmt = conn.prepareStatement("SELECT * FROM `product_review`,`user_list` WHERE `product_review`.`product_id`=? and `product_review`.`user_id`=`user_list`.`user_id`");
        pstmt.setInt(1, product_id);
        rs = pstmt.executeQuery();

        ArrayList<Review> res = new ArrayList();

        while (rs.next()) {
            Review i = new Review();
            i.product_id = rs.getInt("product_id");
            i.user.id = rs.getInt("user_id");
            i.user.email = rs.getString("user_email");
            i.user.fName = rs.getString("user_fname");
            i.user.lName = rs.getString("user_lname");
            i.review_time = rs.getTimestamp("review_date").getTime();
            i.review_title = rs.getString("review_title");
            i.review_value = rs.getInt("review_value");
            i.review_price = rs.getInt("review_price");
            i.review_quality = rs.getInt("review_quality");
            i.review_text = rs.getString("review_text");
            res.add(i);
        }
        conn.close();
        return res;
    }
    
    public static boolean addReview(int product_id, int user_id, String review_title, long review_time, int review_value, int review_price, int review_quality, String review_text) throws SQLException, Exception {

        Connection conn = DBConn.getConn();
        String ch = "ok";
        PreparedStatement pstmt = conn.prepareStatement("INSERT INTO `product_review` (`product_id`, `user_id`, `review_title`, `review_date`, `review_value`, `review_price`, `review_quality`, `review_text`) VALUES (?,?,?,FROM_UNIXTIME(?),?,?,?,?)");
        if (ch.equals("ok")) {
            pstmt.setInt(1, product_id);
            pstmt.setInt(2, user_id);
            pstmt.setString(3, review_title);
            pstmt.setLong(4, review_time);
            pstmt.setInt(5, review_value);
            pstmt.setInt(6, review_price);
            pstmt.setInt(7, review_quality);
            pstmt.setString(8, review_text);
            pstmt.executeUpdate();
            conn.close();
            return true;
        } else {
            conn.close();
            return false;
        }
    }
}
