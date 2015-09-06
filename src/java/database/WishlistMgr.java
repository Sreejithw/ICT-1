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
import model.Product;

/**
 *
 * @author hy
 */
public class WishlistMgr {

    public static boolean addProduct(int user_id, int product_id) throws SQLException, Exception {
        Connection conn=DBConn.getConn();
        
        PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM `wishlist` where `user_id` = ?");
        pstmt.setInt(1, user_id);
        ResultSet rs = pstmt.executeQuery();
        
        boolean isexist=false;
        while (rs.next()) {
            if( rs.getInt("product_id") == product_id){
                isexist=true;
            }
        }
        
        if(!isexist){
            
            pstmt = conn.prepareStatement("insert into wishlist (`user_id`, `product_id`) values(?,?)");
            pstmt.setInt(1, user_id);
            pstmt.setInt(2, product_id);
            pstmt.executeUpdate();
            conn.close();
            return true;
            
        }else{
            conn.close();
            return false;
        }
        
    }
    
    public static void deleteProduct(int user_id, int product_id) throws SQLException, Exception {
        Connection conn=DBConn.getConn();
        
        PreparedStatement  pstmt = conn.prepareStatement("DELETE FROM `wishlist` where `user_id` = ? and `product_id` = ?");
        pstmt.setInt(1, user_id);
        pstmt.setInt(2, product_id);
        pstmt.executeUpdate();       
    }
    
    public static ArrayList<Product> getWishlist(int user_id) throws SQLException, Exception {

        Connection conn=DBConn.getConn();
        
        PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM `product_list` WHERE `product_id` IN (SELECT `product_id` FROM `wishlist` WHERE `user_id` = ?)");
        pstmt.setInt(1,user_id);
        ResultSet rs = pstmt.executeQuery();

        ArrayList<Product> res = new ArrayList();

        while (rs.next()) {
            Product i = new Product();
            i.id = rs.getInt("product_id");
            i.name = rs.getString("product_name");
            i.price = rs.getInt("product_price");
            i.discount = rs.getInt("product_discount");
            i.gender = rs.getString("product_gender");
            i.category = rs.getString("product_type");
            i.manufacture = rs.getString("product_manufacture");
            i.info = rs.getString("product_info");
            i.description = rs.getString("product_description");
            i.profile_pic = rs.getString("product_profile_pic");
            res.add(i);
        }
        conn.close();
        return res;
    }
    
    public static int getWishlistCount(int user_id) throws SQLException, Exception {

        Connection conn=DBConn.getConn();
        
        PreparedStatement pstmt = conn.prepareStatement("SELECT COUNT(`product_id`) AS COUNT FROM `wishlist` WHERE `user_id`=?");
        pstmt.setInt(1,user_id);
        ResultSet rs = pstmt.executeQuery();

        int res = 0;

        while (rs.next()) {
            res=rs.getInt("COUNT");
        }
        conn.close();
        return res;
    }
}
