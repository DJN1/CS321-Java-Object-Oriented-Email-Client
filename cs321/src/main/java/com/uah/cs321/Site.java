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
public class Site {
    
    
    Site(String nameConstructor, String suffix){
        name = nameConstructor;
        domainSuffix = suffix;
    }
    
    
    public void AddUser(User user){
        userList.add(user);
    }
    
    public void RemoveUser(User user){
        userList.remove(user);
    }
    
    public void SelectUser(User user){
        activeUser = user;
    }
    
    
    private ArrayList<User> userList = new ArrayList<User>();
    private String name;
    private String domainSuffix;
    private User activeUser;

}
