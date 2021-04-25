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
    public ArrayList<Site> siteList = new ArrayList<Site>();
    private Site site;
    private Site currentSite;
    private SimpleEmail(){
        
    }
    private static SimpleEmail email;
    public static SimpleEmail getEmail() 
    {
        if (email == null)
            email = new SimpleEmail();
        return email;
    }
    public void AddSite(Site site){
        siteList.add(site);
        System.out.println("The site " + site.GetName() + " was added");
        
    }
    
    public void RemoveSite(Site site){
        siteList.remove(site);
        System.out.println("The site " + site.GetName() + " was removed");
    }
    
    public void SelectSite(Site site){
        currentSite = site;
        System.out.println("The site " + site.GetName() + " was selected");
    }
    
    
}
