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
public class User {
    public int id=-1;
    public String email="";
    public String fName="";
    public String lName="";
    
    public boolean isValid(){
        return id!=-1;
    }
}
