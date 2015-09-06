/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author hy
 */
public class Product {

    public int id = -1;
    public String name = "";
    public int price = 0;
    public int discount = 0;
    public String gender = "";
    public String category = "";
    public String manufacture = "";
    public String info = "";
    public String description = "";
    public String profile_pic = "";
    final static public String default_pic="images/defaultProductPic.jpg";

    public boolean equals(Product i) {
        return this.id == i.id;
    }

    public void defaultPic() {
        if (this.profile_pic.replace(" ", "").equals("")) {
            this.profile_pic = default_pic;
        }
    }

}
