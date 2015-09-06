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
import model.ProductBest;
import model.ProductDeal;
import model.ProductFeature;
import model.ProductNew;

/**
 *
 * @author Fu
 */
public class ProductHighlightMgr {
    public static ArrayList<ProductBest> getProductBest() throws SQLException, Exception {

        Connection conn = DBConn.getConn();
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        pstmt = conn.prepareStatement("SELECT * FROM `product_best`, `product_list` WHERE `product_best`.`product_id` = `product_list`.`product_id`");
        rs = pstmt.executeQuery();
        ArrayList<ProductBest> res =  new ArrayList();
        while (rs.next()) {
            ProductBest i = new ProductBest(); 
            getProductRs(i.productbest,rs);
            res.add(i);
        }
        conn.close();
        return res;
    }
    
    public static ArrayList<ProductDeal> getProductDeal() throws SQLException, Exception {

        Connection conn = DBConn.getConn();
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        pstmt = conn.prepareStatement("SELECT * FROM `product_deal`, `product_list` WHERE `product_deal`.`product_id` = `product_list`.`product_id`");
        rs = pstmt.executeQuery();
        ArrayList<ProductDeal> res =  new ArrayList();
        while (rs.next()) {
            ProductDeal i = new ProductDeal(); 
            getProductRs(i.productdeal,rs);
            i.date_start= rs.getTimestamp("date_start").getTime();
            i.date_end = rs.getTimestamp("date_end").getTime();
            res.add(i);
        }
        conn.close();
        return res;
    }
    
    public static ArrayList<ProductFeature> getProductFeature() throws SQLException, Exception {

        Connection conn = DBConn.getConn();
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        pstmt = conn.prepareStatement("SELECT * FROM `product_feature`, `product_list` WHERE `product_feature`.`product_id` = `product_list`.`product_id`");
        rs = pstmt.executeQuery();
        ArrayList<ProductFeature> res =  new ArrayList();
        while (rs.next()) {
            ProductFeature i = new ProductFeature(); 
            getProductRs(i.productfeature,rs);
            i.product_state= rs.getString("product_state");

            res.add(i);
        }
        conn.close();
        return res;
    }
    
    public static ArrayList<ProductNew> getProductNew() throws SQLException, Exception {

        Connection conn = DBConn.getConn();
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        pstmt = conn.prepareStatement("SELECT * FROM `product_new`, `product_list` WHERE `product_new`.`product_id` = `product_list`.`product_id`");
        rs = pstmt.executeQuery();
        ArrayList<ProductNew> res =  new ArrayList();
        while (rs.next()) {
            ProductNew i = new ProductNew(); 
            getProductRs(i.productnew,rs);
            res.add(i);
        }
        conn.close();
        return res;
    }
    
    private static Product getProductRs(Product i, ResultSet rs) throws SQLException {
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
        return i;
    }
}
