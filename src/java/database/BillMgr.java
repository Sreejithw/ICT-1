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
import java.util.Calendar;
import model.Bill;
import model.BillAddress;
import model.BillInfo;
import model.BillSummery;
import model.Item;
import model.User;

/**
 *
 * @author Evilill
 */
public class BillMgr {
    
    public static void newBill(int user_id, int bill_shipping_price, String bill_shipping_type, ArrayList<Item> items, BillAddress info) throws Exception {
        int billId=addBill(user_id,bill_shipping_price,bill_shipping_type);
        
        for(Item i:items){
            addBillItem(billId,i.product_id,i.item_id,i.item_quantity);
        }
        
        addBillAddress(billId,info.bill_fname,info.bill_lname,info.bill_email,info.bill_address,info.bill_floor, info.bill_unit, info.bill_road, info.bill_country, info.bill_postcode, info.bill_tel);
    }
    
    
    public static int addBill(int user_id, int bill_shipping_price, String bill_shipping_type) throws SQLException, Exception {
        int bill_id= 0;
        int bill_state = 1;
        long bill_done_date = Calendar.getInstance().getTime().getTime();
        
        Connection conn=DBConn.getConn();
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        
        //get latest bill_id
        pstmt = conn.prepareStatement("SELECT * FROM `bill_list`");
        rs = pstmt.executeQuery(); 
        while (rs.next()) {
            bill_id = rs.getInt("bill_id");
        }
        
        //add new bill
        pstmt = conn.prepareStatement("insert into bill_list (`bill_id`, `user_id`, `bill_state`, `bill_done_date`, `bill_shipping_type`, `bill_shipping_price`) values(?,?,?,FROM_UNIXTIME(?),?,?)");
        bill_id++;
        pstmt.setInt(1, bill_id);
        pstmt.setInt(2, user_id);
        pstmt.setInt(3, bill_state);
        pstmt.setLong(4, bill_done_date);
        pstmt.setString(5, bill_shipping_type);
        pstmt.setInt(6, bill_shipping_price);
        
        pstmt.executeUpdate();
        
        return bill_id;
    }
    
    public static void addBillItem(int bill_id, int product_id, int item_id, int bill_quantity) throws SQLException, Exception {
        Connection conn=DBConn.getConn();
        PreparedStatement pstmt = null;
        
        pstmt = conn.prepareStatement("insert into bill_info values(?,?,?,?)");
        pstmt.setInt(1, bill_id);
        pstmt.setInt(2, product_id);
        pstmt.setInt(3, item_id);
        pstmt.setInt(4, bill_quantity);
        pstmt.executeUpdate();
    }
    
    public static void addBillAddress(int bill_id, String bill_fname, String bill_lname, String bill_email, String bill_address, String bill_floor, String bill_unit, String bill_road, String bill_country, int bill_postcode, int bill_tel) throws SQLException, Exception {
        Connection conn=DBConn.getConn();
        PreparedStatement pstmt = null;
        
        pstmt = conn.prepareStatement("insert into bill_address values(?,?,?,?,?,?,?,?,?,?,?)");
        pstmt.setInt(1, bill_id);
        pstmt.setString(2, bill_fname);
        pstmt.setString(3, bill_lname);
        pstmt.setString(4, bill_email);
        pstmt.setString(5, bill_address);
        pstmt.setString(6, bill_floor);
        pstmt.setString(7, bill_unit);
        pstmt.setString(8, bill_road);
        pstmt.setString(9, bill_country);
        pstmt.setInt(10, bill_postcode);
        pstmt.setInt(11, bill_tel);
        pstmt.executeUpdate();   
    }
    
    //state 1 mean not dinish yet
    public static void changeBillState(int bill_id, int bill_state, long bill_done_date) throws SQLException, Exception {
        Connection conn=DBConn.getConn();
        PreparedStatement pstmt = null;
        
        pstmt = conn.prepareStatement("UPDATE `bill_list` SET `bill_state`=?, `bill_done_date`=FROM_UNIXTIME(?) WHERE `bill_id`=?");
        pstmt.setInt(1, bill_state);
        pstmt.setLong(2, bill_done_date); 
        pstmt.setInt(3, bill_id);
        pstmt.executeUpdate();
        
        
    }
    
    //get all bill which in state 1
    public static ArrayList<Bill> getBillList() throws SQLException, Exception {
        Connection conn=DBConn.getConn();
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        pstmt = conn.prepareStatement("SELECT * FROM `bill_list`, `user_list` WHERE `bill_list`.`bill_state`= 1 and `bill_list`.`user_id`= `user_list`.`user_id`");
        rs = pstmt.executeQuery();

        ArrayList<Bill> res = new ArrayList();

        while (rs.next()) {
            Bill i = new Bill();
            i.bill_id = rs.getInt("bill_id");
            i.user.id = rs.getInt("user_id");
            i.user.fName = rs.getString("user_fname");
            i.user.lName = rs.getString("user_lname");
            i.user.email = rs.getString("user_email");
            i.bill_state = rs.getInt("bill_state");
            i.bill_done_date= rs.getTimestamp("bill_done_date").getTime();
            i.bill_shipping_type= rs.getString("bill_shipping_type");
            i.bill_shipping_price= rs.getInt("bill_shipping_price");
            res.add(i);
        }
        conn.close();
        return res;    

    }
    
    public static ArrayList<BillInfo> getBillInfo(int bill_id) throws SQLException, Exception {
        Connection conn=DBConn.getConn();
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        pstmt = conn.prepareStatement("SELECT * FROM `bill_info`, `item_info`, `product_list` WHERE `bill_info`.`bill_id`= ? and `bill_info`.`item_id` = `item_info`.`item_id` and `bill_info`.`product_id` = `product_list`.`product_id`");
        pstmt.setInt(1, bill_id);
        rs = pstmt.executeQuery();

        ArrayList<BillInfo> res = new ArrayList();

        while (rs.next()) {
            BillInfo i = new BillInfo();
            i.bill_id = rs.getInt("bill_id");
            i.product.id = rs.getInt("product_id");
            i.product.name = rs.getString("product_name");
            i.product.price = rs.getInt("product_price");
            i.product.discount = rs.getInt("product_discount");
            i.product.gender = rs.getString("product_gender");
            i.product.category = rs.getString("product_type");
            i.product.manufacture = rs.getString("product_manufacture");
            i.product.info = rs.getString("product_info");
            i.product.description = rs.getString("product_description");
            i.product.profile_pic = rs.getString("product_profile_pic");
            i.item.product_id = rs.getInt("product_id");
            i.item.item_id = rs.getInt("item_id");
            i.item.item_material = rs.getString("item_material");
            i.item.item_color = rs.getString("item_color");
            i.item.item_size = rs.getString("item_size");
            i.item.item_sample_pic = rs.getString("item_sample_pic");
            i.item.item_quantity = rs.getInt("bill_quantity");
            i.bill_quantity = rs.getInt("bill_quantity");
            res.add(i);
        }
        conn.close();
        return res; 

    }
    
    public static BillAddress getBillAddress(int bill_id) throws SQLException, Exception {
        Connection conn=DBConn.getConn();
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        
        pstmt = conn.prepareStatement("SELECT * FROM `bill_address` WHERE `bill_id`= ?");
        pstmt.setInt(1, bill_id);
        rs = pstmt.executeQuery();

        BillAddress i = new BillAddress();
        
        while (rs.next()) {

            i.bill_id = rs.getInt("bill_id");
            i.bill_address = rs.getString("bill_address");
            i.bill_floor = rs.getString("bill_floor");
            i.bill_unit = rs.getString("bill_unit");
            i.bill_road = rs.getString("bill_road");
            i.bill_country = rs.getString("bill_country");
            i.bill_postcode = rs.getInt("bill_postcode");
            i.bill_tel = rs.getInt("bill_tel");
            
        }
        conn.close();
        return i; 

    }
    
    public static ArrayList<Bill> getBillByUser(User user) throws SQLException, Exception {
        Connection conn=DBConn.getConn();
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        pstmt = conn.prepareStatement("SELECT * FROM `bill_list` WHERE `user_id`= ?");
        pstmt.setInt(1, user.id);
        rs = pstmt.executeQuery();

        ArrayList<Bill> res = new ArrayList();

        while (rs.next()) {
            Bill i = new Bill();
            i.bill_id = rs.getInt("bill_id");
            i.user = user;
            i.bill_state = rs.getInt("bill_state");
            i.bill_done_date= rs.getTimestamp("bill_done_date").getTime();
            i.bill_shipping_type= rs.getString("bill_shipping_type");
            i.bill_shipping_price= rs.getInt("bill_shipping_price");
            res.add(i);
        }
        conn.close();
        return res;    

    }
    
    public static ArrayList<BillSummery> getBillSummeries(User user) throws SQLException, Exception {
        ArrayList<BillSummery> res = new ArrayList();
        Connection conn=DBConn.getConn();
        PreparedStatement pstmt = conn.prepareStatement("SELECT bill_info.`bill_id` as bill_id, SUM(product_list.product_price*bill_info.bill_quantity) AS total, CONCAT_WS(' ',bill_address.bill_fname,bill_address.bill_lname) as name, bill_list.bill_shipping_type AS shipping_type, bill_list.bill_done_date AS date FROM `bill_info`,product_list,bill_address,bill_list WHERE product_list.product_id=bill_info.product_id and bill_address.bill_id=bill_info.bill_id and bill_list.bill_id=bill_info.bill_id and bill_list.user_id=? GROUP BY bill_info.`bill_id`");
        pstmt.setInt(1, user.id);
        
        ResultSet rs = pstmt.executeQuery();
        
        while (rs.next()) {
            BillSummery i=new BillSummery();
            i.billId=rs.getInt("bill_id");
            i.total=rs.getInt("total");
            i.name=rs.getString("name");
            i.shipping_type=rs.getString("shipping_type");
            i.date=rs.getTimestamp("date").getTime();
            res.add(i);
        }
        conn.close();
        return res;
    }
}
