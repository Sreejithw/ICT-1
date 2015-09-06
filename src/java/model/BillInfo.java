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
public class BillInfo {
    public int bill_id=-1;
    public Product  product = new Product();
    public Item  item = new Item();
    public int item_price=-1;
    public int item_discount=-1;
    public int bill_quantity=-1;
}
