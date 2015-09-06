/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author hy
 */
public class Cart {

    private HashMap<Integer, Item> items;
    private HashMap<Integer, Product> products;
    //private HashMap<Integer, Integer> qty;

    public Cart() {
        items = new HashMap();
        //qty = new HashMap();
        products = new HashMap();
    }

    public Cart(HashMap items, HashMap products) {
        this.items = items;
        //this.qty = qty;
        this.products = products;
    }

    public boolean add(Item item, Product product, int qty) {
        if (item.item_id >= 0 && item.product_id == product.id) {
            if (qty > 0) {
                item.item_quantity=qty;
                items.put(item.item_id, item);
                products.put(item.item_id, product);
                //this.qty.put(item.item_id, qty);
            } else {
                remove(item.item_id);
            }
            return true;
        }
        return false;
    }

    public void remove(int id) {
        items.remove(id);
        products.remove(id);
    }

    public void remove(Item item) {
        remove(item.item_id);
    }

    public ArrayList<Item> itemList() {
        return new ArrayList(items.values());
    }

    public ArrayList<Product> ProductList() {
        return new ArrayList(products.values());
    }

    public ArrayList<Integer> itemId() {
        return new ArrayList(items.keySet());
    }

    public int qty(int id) {
        return item(id).item_quantity;//return qty.get(id);
    }

    public int price(int id) {
        return product(id).price;
    }
    
    public int total(int id) {
        return price(id)*qty(id);
    }

    public Product product(int id) {
        return products.get(id);
    }

    public Item item(int id) {
        return items.get(id);
    }

    public double total() {
        double res = 0;
        for (int i : itemId()) {
            res += price(i);
        }
        return res;
    }
    
    
    
    public void clear() {
        items.clear();
        products.clear();
    }

    public int size() {
        return items.size();
    }
}
