/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.io.PrintWriter;
import java.util.ArrayList;
import model.Product;

/**
 *
 * @author hy
 */
public class JSONPrinter {
    static void printProductJSON(ArrayList<Product> items, PrintWriter out) {
        out.print("\u005B");
        String s = "";
        for (Product i : items) {
            out.print(s);
            i.defaultPic();
            out.printf("\u005B%d,\"%s\",%d,\"%s\",\"%s\",\"%s\"\u005D",
                    i.id, i.name, i.price, i.profile_pic, i.manufacture, i.description);
            s = ",";
        }
        out.print("\u005D");
    }
}
