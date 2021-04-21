/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uah.cs321;

import java.util.ArrayList;

/**
 *
 * @author colin
 */
public class User {
    
    
    User(String name, Site constructorSite){
        userName = name;
        site = constructorSite;   
    }
        
    
    private String userName;
    private Site site;
    
    private ArrayList<String> trashBox = new ArrayList<String>();
    private ArrayList<String> inBox = new ArrayList<String>();
    private ArrayList<String> sentBox = new ArrayList<String>();

    

}
