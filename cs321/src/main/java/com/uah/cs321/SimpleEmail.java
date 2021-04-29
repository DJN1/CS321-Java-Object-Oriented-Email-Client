/**
 * Class: SimpleEmail.java
 * Purpose: Main client of email system. Singleton Pattern.
 */
package com.uah.cs321;

import java.util.ArrayList;

/**
 *
 * @author Caleb, Zach, Colin, David
 */
public class SimpleEmail {

	private static SimpleEmail simpleEmailInstance = null;

	private final ArrayList<Site> siteList;
	private Site currentSite;

	private SimpleEmail() {
		siteList = new ArrayList<>();
	}

	// returns the private single instance of the class
	public static SimpleEmail getInstance() {
		if (simpleEmailInstance == null) {
			simpleEmailInstance = new SimpleEmail();
		}

		return simpleEmailInstance;
	}

	// add site to system
	public void AddSite(Site site) {
		siteList.add(site);
		System.out.println("The site " + site.GetName() + " was added");
	}

	// remove site from system
	public void RemoveSite(Site site) {
		siteList.remove(site);
		System.out.println("The site " + site.GetName() + " was removed");
	}

	// select site for system
	public void SelectSite(Site site) {
		currentSite = site;
		System.out.println("The site " + site.GetName() + " was selected");
	}

	// returns all sites
	public ArrayList<Site> getAllSites() {
		return this.siteList;
	}

	// returns current site
	public Site GetCurrentSite() {
		return this.currentSite;
	}
}
