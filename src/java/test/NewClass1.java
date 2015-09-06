/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import model.Cart;
import model.Item;
import model.Product;

/**
 *
 * @author hy
 */
public class NewClass1 {
    public static void main(String[] args) throws Exception {
        Item item = database.ItemMgr.getItemByItemId(1);
        Product product = database.ProductMgr.getProductByProductId(item.product_id);
        Cart cart=new Cart();
        cart.add(item, product, 1);
        cart.clear();
        System.out.println(cart.total());
    }
}
