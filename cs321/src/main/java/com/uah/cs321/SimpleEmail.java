/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uah.cs321;
import java.util.ArrayList;
/**
 *
 * @author Caleb
 */
public class SimpleEmail 
{
    public ArrayList<String> siteList = new ArrayList<String>();
    private String site;
    private String currentSite;
    private SimpleEmail(){
        
    }
    private static SimpleEmail email;
    public static SimpleEmail getEmail() 
    {
        if (email == null)
            email = new SimpleEmail();
        return email;
    }
    public void AddSite(String site){
        siteList.add(site);
        System.out.println("The site " + site + " was added");
        
    }
    
    public void RemoveSite(String site){
        siteList.remove(site);
        System.out.println("The site " + site + " was removed");
    }
    
    public void SelectSite(String site){
        currentSite = site;
        System.out.println("The site " + site + " was selected");
    }
    
    
}
