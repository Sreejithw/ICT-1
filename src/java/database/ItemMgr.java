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
import model.Item;

/**
 *
 * @author Fu
 */
public class ItemMgr {
    
    public static Item getItemByItemId(int item_id) throws SQLException, Exception {
        Connection conn = DBConn.getConn();
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        pstmt = conn.prepareStatement("SELECT * FROM `item_info` where item_id = ?");
        pstmt.setInt(1, item_id);
        rs = pstmt.executeQuery();

        Item i = new Item();

        if (rs.next()) {
            i.product_id = rs.getInt("product_id");
            i.item_id = rs.getInt("item_id");
            i.item_material = rs.getString("item_material");
            i.item_color = rs.getString("item_color");
            i.item_size = rs.getString("item_size");
            i.item_sample_pic = rs.getString("item_sample_pic");
            i.item_quantity = rs.getInt("item_quantity");
        }
        conn.close();
        return i;
    }
    
    public static ArrayList<Item> getItemByProductId(int product_id) throws SQLException, Exception {

        Connection conn = DBConn.getConn();
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        pstmt = conn.prepareStatement("SELECT * FROM `item_info` where product_id = ?");
        pstmt.setInt(1, product_id);
        rs = pstmt.executeQuery();

        ArrayList<Item> res = new ArrayList();

        while (rs.next()) {
            Item i = new Item();
            i.product_id = rs.getInt("product_id");
            i.item_id = rs.getInt("item_id");
            i.item_material = rs.getString("item_material");
            i.item_color = rs.getString("item_color");
            i.item_size = rs.getString("item_size");
            i.item_sample_pic = rs.getString("item_sample_pic");
            i.item_quantity = rs.getInt("item_quantity");
            res.add(i);
        }
        conn.close();
        return res;// get arreylist like get product but there are onty 1 product in list
    }
    
    public static void deleteItem(int product_id, int item_id) throws SQLException, Exception {

        Connection conn = DBConn.getConn();
        PreparedStatement pstmt = null;

        pstmt = conn.prepareStatement("DELETE FROM `item_info` where `product_id` = ? and `item_id` = ?");
        pstmt.setInt(1, product_id);
        pstmt.setInt(2, item_id);
        pstmt.executeUpdate();

    }
    
    public static void updateItem(int product_id, int item_id, String item_material, String item_color, String item_size, String item_sample_pic, int item_quantity) throws SQLException, Exception {

        Connection conn = DBConn.getConn();
        PreparedStatement pstmt = null;

        int cg = 0;

        if (cg == 0) {

            pstmt = conn.prepareStatement("UPDATE `item_info` SET `item_material`=? ,`item_color`=?,`item_size`=?,`item_sample_pic`=?,`item_quantity`=? WHERE `product_id`=? AND `item_id`=?");
            pstmt.setString(1, item_material);
            pstmt.setString(2, item_color);
            pstmt.setString(3, item_size);
            pstmt.setString(4, item_sample_pic);
            pstmt.setInt(5, item_quantity);
            pstmt.setInt(6, product_id);
            pstmt.setInt(7, item_id);
            pstmt.executeUpdate();
            //add done
        } else {
            throw new Exception("Can not add same product id");
            //add fail,already add product_id
        }
        conn.close();
    }
    
    public static void addItem(int product_id, String item_material, String item_color, String item_size, String item_sample_pic, int item_quantity) throws SQLException, Exception {

        Connection conn = DBConn.getConn();
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        int item_id = 0;

        pstmt = conn.prepareStatement("SELECT * FROM `product_list` where `product_id` = ?");
        pstmt.setInt(1, product_id);
        rs = pstmt.executeQuery();
        int cg = 0; //use to check that have product_id or not
        while (rs.next()) {
            cg = 1;
        }

        if (cg == 0) {

            pstmt = conn.prepareStatement("SELECT * FROM `item_info` where `product_id` = ?");
            pstmt.setInt(1, product_id);
            rs = pstmt.executeQuery();

            while (rs.next()) { //to get item_id
                item_id = rs.getInt("item_id");
            }
            item_id++;

            pstmt = conn.prepareStatement("insert into item_info values(?,?,?,?,?,?,?)");

            pstmt.setInt(1, product_id);
            pstmt.setInt(2, item_id);
            pstmt.setString(3, item_material);
            pstmt.setString(4, item_color);
            pstmt.setString(5, item_size);
            pstmt.setString(6, item_sample_pic);
            pstmt.setInt(7, item_quantity);
            pstmt.executeUpdate();
            //add done
        } else {
            throw new Exception("Can not add same product id");
            //add fail,already add product_id
        }
        conn.close();
    }
}
