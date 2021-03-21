/*
 * Class: ManageUsers.java
 * Purpose: Enables admin user to add/delete users
 * Notes: In future iterations, these methods will take a parameter of type list (for users or sites) in order to make changes to "database". For now, the list is stuffed with hard-coded values.
 */
package com.uah.cs321;

import java.awt.event.ActionEvent;
import javax.swing.*;

/**
 *
 * @author Zach Walker
 */
public class ManageUsers 
{
    // Displays JFrame that holds buttons for adding/deleting users
    public static void ManageUsersPanel()
    {
        JFrame mu = new JFrame("Manage Users");
        mu.setSize(400, 400);
        mu.setLocationRelativeTo(null);
        //mu.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        
        JPanel mainPanel = new JPanel();
        
        JButton addUserBtn = new JButton("Add New User");
        addUserBtn.addActionListener((ActionEvent e) -> {
            AddUser(mu);
        });

                
        JButton delUserBtn = new JButton("Delete User");
        delUserBtn.addActionListener((ActionEvent e) -> {
            DeleteUser(mu);
        });
        
        mainPanel.add(addUserBtn);
        mainPanel.add(delUserBtn);
        
        mu.setContentPane(mainPanel);
        mu.setVisible(true);
    }
    
    // Displays current list of users. Allows admin user to select a user for deletion.
    private static void DeleteUser(JFrame relativeWindow)
    {
        JFrame frame = new JFrame();
        
        frame.setSize(200, 200);
        frame.setLocationRelativeTo(relativeWindow);
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        
        Object[] userList = {"--Select a User to Remove--", "User 1", "User 2", "User 3", "User 4", "User 5"};
        Object[] buttonOptions = {"Delete", "Cancel"};

        String userToDelete = (String)JOptionPane.showInputDialog(frame, "Users", "Remove a User?", JOptionPane.YES_OPTION,
            null, userList, buttonOptions);
        
        if (userToDelete == null)
        {
            //System.out.print("No users have been deleted.\n");
            return; //null;
        }
        
        int result = 2;
        
        if (!userToDelete.equals(userList[0]))
        {
            result = JOptionPane.showConfirmDialog(frame, "Are you sure you want to delete the user: " + userToDelete + "?", "Warning", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
        }
        
        if (result == 0)
        {
            JOptionPane.showMessageDialog(frame, "User successfully deleted.", "Successful delete", JOptionPane.DEFAULT_OPTION);
            //System.out.print(userToDelete);
            //return userToDelete;
        }
//        else
//        {
//            System.out.print("No users have been deleted.\n");
//        }
        
//        return null;

//        if (siteToDelete == null)
//        {
//            System.out.print("No sites have been deleted.\n");
//        }
//        else
//        {
//            System.out.print(siteToDelete);
//        }
    }
    
    // Allows an admin user to add user
    private static void AddUser(JFrame relativeWindow)
    {
        JFrame frame = new JFrame();
        
        frame.setSize(200, 200);
        frame.setLocationRelativeTo(relativeWindow);
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        
        String userToAdd = JOptionPane.showInputDialog(frame, "Enter name of user to add", "Add User", JOptionPane.PLAIN_MESSAGE);
        
        if (userToAdd == null)
        {
            //System.out.print("No users have been added.\n");
            return; //null;
        }
                
        if (!userToAdd.isBlank())
        {
            JOptionPane.showMessageDialog(frame, "User successfully added!", "Success", JOptionPane.DEFAULT_OPTION);
        }
        else
        {
            JOptionPane.showMessageDialog(frame, "User was not added!", "Site Add Failed!", JOptionPane.ERROR_MESSAGE);
        }
        
//        if (userToAdd.isBlank())
//        {
//            System.out.print("No users have been added.\n");
//        }
//        else
//        {
//            System.out.print(userToAdd);
//        }
    }
}
