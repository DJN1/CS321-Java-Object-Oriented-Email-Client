/*
 * Class: ManageSettings.java
 * Purpose: Enables admin user to add/delete sites
 * Notes: In future iterations, these methods will take a parameter of type list (for users or sites) in order to make changes to "database". For now, the list is stuffed with hard-coded values.
 */
package com.uah.cs321;

import java.awt.event.ActionEvent;
import javax.swing.*;

/**
 *
 * @author Zach Walker
 */
public class ManageSites {

	// Displays JFrame that holds buttons for adding/deleting users
	public static void ManageSitesPanel() {
		JFrame ms = new JFrame("Manage Sites");

		ms.setSize(400, 400);
		ms.setLocationRelativeTo(null);
		//ms.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

		JPanel mainPanel = new JPanel();

		JButton addSiteBtn = new JButton("Add New Site");
		addSiteBtn.addActionListener((ActionEvent e) -> {
			AddSite(ms);
		});

		JButton delSiteBtn = new JButton("Delete Site");
		delSiteBtn.addActionListener((ActionEvent e) -> {
			DeleteSite(ms);
		});

		mainPanel.add(addSiteBtn);
		mainPanel.add(delSiteBtn);

		ms.setContentPane(mainPanel);
		ms.setVisible(true);
	}

	// Displays current list of sites. Allows admin user to select a site for deletion.
	private static void DeleteSite(JFrame relativeWindow) {
		JFrame frame = new JFrame();
		SimpleEmail email = SimpleEmail.getEmail();
		frame.setSize(200, 200);
		frame.setLocationRelativeTo(relativeWindow);
		frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

		//String[] siteList = {"--Select a Site to Remove--", "Site 1", "Site 2", "Site 3", "Site 4", "Site 5"};
		Object[] siteList = email.getAllSites().toArray();

		Object[] buttonOptions = {"Delete", "Cancel"};

		Site siteToDelete = (Site) JOptionPane.showInputDialog(frame, "Sites", "Remove a Site?", JOptionPane.YES_OPTION,
				null, siteList, buttonOptions);

		if (siteToDelete == null) {
			//System.out.print("No sites have been deleted.\n");
			return; //null;
		}

		int result = 2;

		if (!siteToDelete.equals(siteList[0])) {
			email.RemoveSite(siteToDelete);
			result = JOptionPane.showConfirmDialog(frame, "Are you sure you want to delete the site: " + siteToDelete + "?", "Warning", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
		}

		if (result == 0) {
			JOptionPane.showMessageDialog(frame, "Site successfully deleted.", "Successful delete", JOptionPane.DEFAULT_OPTION);
			//System.out.print(siteToDelete);
			//return siteToDelete;
		}
//        else
//        {
//            System.out.print("No sites have been deleted.\n");
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

	// Allows an admin user to add site
	private static void AddSite(JFrame relativeWindow) {
		JFrame frame = new JFrame();
		SimpleEmail email = SimpleEmail.getEmail();
		frame.setSize(200, 200);
		frame.setLocationRelativeTo(relativeWindow);
		frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

		String siteToAdd = JOptionPane.showInputDialog(frame, "Enter Site to Add", "Add Site", JOptionPane.PLAIN_MESSAGE);

		Site newSite = new Site(siteToAdd, "com");

		if (siteToAdd == null) {
			//System.out.print("No sites have been added.\n");
			return; //null;
		}

		if (!siteToAdd.isBlank()) {
			email.AddSite(newSite);
			JOptionPane.showMessageDialog(frame, "Site successfully added!", "Success", JOptionPane.DEFAULT_OPTION);
		} else {
			JOptionPane.showMessageDialog(frame, "Site was not added!", "Site Add Failed!", JOptionPane.ERROR_MESSAGE);
		}

//        if (siteToAdd.isBlank())
//        {
//            System.out.print("No sites have been added.\n");
//        }
//        else
//        {
//            System.out.print(siteToAdd);
//        }
	}
}
