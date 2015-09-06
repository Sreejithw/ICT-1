
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
import model.ProductPic;
import model.Review;

/**
 *
 * @author Evilill
 */
public class ProductMgr {

    //add new product
    public static void addProduct(int product_id, String product_name, int product_price, int product_discount, String product_gender, String product_category, String product_manufacture, String product_info, String product_description) throws SQLException, Exception {

        Connection conn = DBConn.getConn();
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        String product_profile_pic = "";

        pstmt = conn.prepareStatement("SELECT * FROM `product_list` where `product_id` = ?");
        pstmt.setInt(1, product_id);
        rs = pstmt.executeQuery();
        int cg = 0; //use to check did product_id already have or not
        while (rs.next()) {
            cg++;
        }

        pstmt = conn.prepareStatement("insert into product_list values(?,?,?,?,?,?,?,?,?,?)");
        if (cg == 0) {
            pstmt.setInt(1, product_id);
            pstmt.setString(2, product_name);
            pstmt.setInt(3, product_price);
            pstmt.setInt(4, product_discount);
            pstmt.setString(5, product_gender);
            pstmt.setString(6, product_category);
            pstmt.setString(7, product_manufacture);
            pstmt.setString(8, product_info);
            pstmt.setString(9, product_description);
            pstmt.setString(10, product_profile_pic);
            pstmt.executeUpdate();
            //add done
        } else {
            throw new Exception("Can not add same product id");
            //add fail,already add product_id
        }
        conn.close();
    }

    public static void deleteProduct(int product_id) throws SQLException, Exception {

        Connection conn = DBConn.getConn();
        PreparedStatement pstmt = null;

        pstmt = conn.prepareStatement("DELETE FROM `product_list` where `product_id` = ?");
        pstmt.setInt(1, product_id);
        pstmt.executeUpdate();

        pstmt = conn.prepareStatement("DELETE FROM `item_info` where `product_id` = ?");
        pstmt.setInt(1, product_id);
        pstmt.executeUpdate();

    }

    public static void deleteProductPic(int product_id, int pic_num) throws SQLException, Exception {

        Connection conn = DBConn.getConn();
        PreparedStatement pstmt = null;

        pstmt = conn.prepareStatement("DELETE FROM `product_pic` where `product_id` = ? and `pic_num`= ?");
        pstmt.setInt(1, product_id);
        pstmt.setInt(2, pic_num);
        pstmt.executeUpdate();

    }

    //add picture
    public static void addProductPic(int product_id, String pic_location) throws SQLException, Exception {

        Connection conn = DBConn.getConn();
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        int pic_num = 0;

        pstmt = conn.prepareStatement("SELECT * FROM `product_list` where `product_id` = ?");
        pstmt.setInt(1, product_id);
        rs = pstmt.executeQuery();
        String ch = "can not found this product id"; //use to check that have product_id and location
        while (rs.next()) {
            ch = "ok";  //change to ok if find product in product_list
        }

        //get picture number
        pstmt = conn.prepareStatement("SELECT * FROM `product_pic` where `product_id` = ?");
        pstmt.setInt(1, product_id);
        rs = pstmt.executeQuery();
        while (rs.next()) {
            pic_num = rs.getInt("pic_num");
        }
        //add picture to data base
        pstmt = conn.prepareStatement("insert into product_pic values(?,?,?)");
        if (ch.equals("ok")) {
            pic_num++;
            pstmt.setInt(1, product_id);
            pstmt.setInt(2, pic_num);
            pstmt.setString(3, pic_location);
            pstmt.executeUpdate();
            //add done
        } else {
            throw new Exception(ch);
            //add fail
        }
        conn.close();
    }

    public static void productUpdate(int product_id, String product_name, int product_price, int product_discount, String product_gender, String product_type, String product_manufacture, String product_info, String product_description, String product_profile_pic) throws SQLException, Exception {
        Connection conn = DBConn.getConn();
        PreparedStatement pstmt = null;

        pstmt = conn.prepareStatement("UPDATE `product_list` SET `product_name`=?, `product_price`=?, `product_discount`=?, `product_gender`=?, `product_type`=?, `product_manufacture`=?, `product_info`=?, `product_description`=?, `product_profile_pic`=? WHERE  `product_id`=? ");
        pstmt.setString(1, product_name);
        pstmt.setInt(2, product_price);
        pstmt.setInt(3, product_discount);
        pstmt.setString(4, product_gender);
        pstmt.setString(5, product_type);
        pstmt.setString(6, product_manufacture);
        pstmt.setString(7, product_info);
        pstmt.setString(8, product_description);
        pstmt.setString(9, product_profile_pic);
        pstmt.setInt(10, product_id);
        pstmt.executeUpdate();

        conn.close();
    }

    public static ArrayList<Product> getProduct() throws SQLException, Exception {

        Connection conn = DBConn.getConn();
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        pstmt = conn.prepareStatement("SELECT * FROM `product_list`");
        rs = pstmt.executeQuery();
        ArrayList<Product> res = productListFromRs(rs);
        conn.close();
        return res;
    }
    
    public static ArrayList<String> getCategory() throws SQLException, Exception {

        Connection conn = DBConn.getConn();
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        pstmt = conn.prepareStatement("SELECT DISTINCT `product_type` FROM `product_list`");
        rs = pstmt.executeQuery();
        ArrayList<String> res = new ArrayList();
        while (rs.next()) {
            res.add(rs.getString("product_type"));
        }
        conn.close();
        return res;
    }
    
    public static ArrayList<String> getCategoryByGender(String gender) throws SQLException, Exception {

        Connection conn = DBConn.getConn();
        PreparedStatement pstmt = conn.prepareStatement("SELECT DISTINCT `product_type` FROM `product_list` WHERE `product_gender`=?");
        pstmt.setString(1, gender);
        ResultSet rs = pstmt.executeQuery();
        ArrayList<String> res = new ArrayList();
        while (rs.next()) {
            res.add(rs.getString("product_type"));
        }
        conn.close();
        return res;
    }
    
    public static ArrayList<Product> getProductByCategory(String category) throws SQLException, Exception {

        Connection conn = DBConn.getConn();
        PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM `product_list` WHERE product_type = ?");
        pstmt.setString(1, category);
        ResultSet rs = pstmt.executeQuery();
        ArrayList<Product> res = productListFromRs(rs);
        conn.close();
        return res;
    }
    
    public static ArrayList<Product> getProductByCategory(String gender, String category) throws SQLException, Exception {

        Connection conn = DBConn.getConn();
        PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM `product_list` WHERE `product_gender`=? AND product_type = ?");
        pstmt.setString(1, gender);
        pstmt.setString(2, category);
        ResultSet rs = pstmt.executeQuery();
        ArrayList<Product> res = productListFromRs(rs);
        conn.close();
        return res;
    }

    public static Product getProductByProductId(int product_id) throws SQLException, Exception {

        Connection conn = DBConn.getConn();
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        pstmt = conn.prepareStatement("SELECT * FROM `product_list` WHERE product_id = ?");
        pstmt.setInt(1, product_id);
        rs = pstmt.executeQuery();

        Product i = new Product();

        if (rs.next()) {
            getProductRs(i, rs);
        }
        conn.close();
        return i;// get arreylist like get product but there are onty 1 product in list
    }
    
    public static ArrayList<Product> getProductByKeyword(String key) throws SQLException, Exception {

        Connection conn = DBConn.getConn();
        PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM `product_list` WHERE LOWER(`product_name`) like LOWER(?)");
        pstmt.setString(1, "%" + key + "%");
        ResultSet rs = pstmt.executeQuery();
        ArrayList<Product> res = productListFromRs(rs);
        conn.close();
        return res;
    }


    public static ArrayList<ProductPic> getProductPic(int product_id) throws SQLException, Exception {

        Connection conn = DBConn.getConn();
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        pstmt = conn.prepareStatement("SELECT * FROM `product_pic`where `product_id` = ? ORDER BY `product_pic`.`product_id` ASC");
        pstmt.setInt(1, product_id);
        rs = pstmt.executeQuery();

        String[] pic = new String[300];//arrey that use to store picture location
        int n = 1;//use to locate picture in order

        while (rs.next()) {
            pic[n] = rs.getString("pic_location");
            n++;
            
        }
        
        n--;
        n = n/2;
        
        ArrayList<ProductPic> res =  new ArrayList<ProductPic>();
        for(int k= 1; k <= n ; k++){
            ProductPic i = new ProductPic();
            i.smallPic = pic[k];
            i.largePic = pic[(k+n)];
            res.add(i);
        }
        
        conn.close();
        return res;
    }


    private static ArrayList<Product> productListFromRs(ResultSet rs) throws SQLException {
        ArrayList<Product> res = new ArrayList<Product>();
        while (rs.next()) {
            res.add(getProductRs(new Product(), rs));
        }
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
