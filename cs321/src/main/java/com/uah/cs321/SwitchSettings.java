/*
 * Class: SwitchSettings.java
 * Purpose: Enables admin user to switch sites/users
 * Notes: In future iterations, these methods will take a parameter of type list (for users or sites) in order to make changes to "database". For now, the list is stuffed with hard-coded values.
 */
package com.uah.cs321;

import java.awt.event.ActionEvent;
import javax.swing.*;

/**
 *
 * @author Zach Walker
 */
public class SwitchSettings 
{
    // Displays JFrame that holds buttons for switching user/site
    public static void SwitchSettingsPanel()
    {
        JFrame ss = new JFrame("Switch User/Site");
        ss.setSize(400, 400);
        ss.setLocationRelativeTo(null);
        //mu.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        
        JPanel mainPanel = new JPanel();
        
        JButton switchUserBtn = new JButton("Switch User");
        switchUserBtn.addActionListener((ActionEvent e) -> {
            SwitchUser(ss);
        });

                
        JButton switchSiteBtn = new JButton("Switch Site");
        switchSiteBtn.addActionListener((ActionEvent e) -> {
            SwitchSite(ss);
        });
        
        mainPanel.add(switchUserBtn);
        mainPanel.add(switchSiteBtn);
        
        ss.setContentPane(mainPanel);
        ss.setVisible(true);
    }
    
    // Displays current user and list of users, prompting the admin user to switch users
    private static void SwitchUser(JFrame relativeWindow)
    {
        JFrame frame = new JFrame();
        
        frame.setSize(200, 200);
        frame.setLocationRelativeTo(relativeWindow);
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        Site site = SimpleEmail.getInstance().GetCurrentSite();
        if(site==null){
            JOptionPane.showConfirmDialog(frame, "You must select a site first.", "Warning", JOptionPane.DEFAULT_OPTION);
            return;
        }
        
        if(site.getUserList().isEmpty()){
            JOptionPane.showConfirmDialog(frame, "No users found.", "Warning", JOptionPane.DEFAULT_OPTION);
            return;
        }
        
        
        Object currentUser = site.GetCurrentUser();
        String panelText;
        if(currentUser!=null){
            panelText = "Current User: " + currentUser + "\n" + "\n" + "Users";
        }else{
            panelText = "Current User: No User Selected" + "\n" + "\n" + "Users";
        }
        Object[] userList = site.getUserList().toArray();

        User userToSwitchTo = (User)JOptionPane.showInputDialog(frame, panelText, "Switch User", JOptionPane.PLAIN_MESSAGE,
            null, userList, userList[0]);
        
        if (userToSwitchTo == null)
        {
            return; //null;
        }
        
        int result = 2;
        

        result = JOptionPane.showConfirmDialog(frame, "Are you sure you want to switch to the user: " + userToSwitchTo + "?", "Warning", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
      
        
        if (result == 0)
        {
            site.SelectUser(userToSwitchTo);
            JOptionPane.showMessageDialog(frame, "User successfully switched.", "Success", JOptionPane.DEFAULT_OPTION);
            //System.out.print(userToSwitchTo);
            //return userToDelete;
        }
//        else
//        {
//            System.out.print("No users have been selected.\n");
//        }
    }
    
    // Displays current user and list of users, prompting the admin user to switch sites
    private static void SwitchSite(JFrame relativeWindow)
    {
        JFrame frame = new JFrame();
        SimpleEmail email = SimpleEmail.getInstance();

        frame.setSize(200, 200);
        frame.setLocationRelativeTo(relativeWindow);
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        
        Site currentSite = email.GetCurrentSite();
        String panelText;
        if(currentSite!=null){
            panelText = "Current Site: " + currentSite + "\n" + "\n" + "Sites";
        }else{
            panelText = "Current Site: No Site Selected" + "\n" + "\n" + "Sites";
        }
        
        Object[] siteList = email.getAllSites().toArray();

        if(siteList.length == 0){
            JOptionPane.showConfirmDialog(frame, "No sites found.", "Warning", JOptionPane.DEFAULT_OPTION);
            return;
        }
        
        Site siteToSwitchTo = (Site)JOptionPane.showInputDialog(frame, panelText, "Switch Site", JOptionPane.PLAIN_MESSAGE,
            null, siteList, siteList[0]);
        
        if (siteToSwitchTo == null)
        {
            //System.out.print("No sites have been selected.\n");
            return; //null;
        }
        
        int result = 2;
        
        
        result = JOptionPane.showConfirmDialog(frame, "Are you sure you want to switch to the site: " + siteToSwitchTo + "?", "Warning", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
        
        
        if (result == 0)
        {
            email.SelectSite(siteToSwitchTo);
            JOptionPane.showMessageDialog(frame, "Site successfully switched.", "Success", JOptionPane.DEFAULT_OPTION);
            //System.out.print(siteToSwitchTo);
            //return siteToDelete;
        }
//        else
//        {
//            System.out.print("No sites have been selected.\n");
//        }
    }
}
