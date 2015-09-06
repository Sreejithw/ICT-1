/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Evilill
 */
public class Bill {
    public int bill_id=-1;
    public User user = new User();
    public int bill_state=-1;
    public long bill_done_date;
    public String bill_shipping_type=""; //type of shipping
    public int bill_shipping_price=-1; 

}
