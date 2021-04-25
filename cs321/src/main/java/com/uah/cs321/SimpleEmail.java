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
public class SimpleEmail {

	private static SimpleEmail simpleEmailInstance = null;

	private ArrayList<Site> siteList;
	private Site site;
	private Site currentSite;
	private SimpleEmail email;

	private SimpleEmail() {
		var siteList = new ArrayList<>();
	}

	public static SimpleEmail SimpleEmailInstance() {
		if (simpleEmailInstance == null) {
			simpleEmailInstance = new SimpleEmail();
		}

		return simpleEmailInstance;
	}

	public SimpleEmail getEmail() {
		if (email == null) {
			email = new SimpleEmail();
		}
		return email;
	}

	public void AddSite(Site site) {
		siteList.add(site);
		System.out.println("The site " + site.GetName() + " was added");

	}

	public void RemoveSite(Site site) {
		siteList.remove(site);
		System.out.println("The site " + site.GetName() + " was removed");
	}

	public void SelectSite(Site site) {
		currentSite = site;
		System.out.println("The site " + site.GetName() + " was selected");
	}

	public ArrayList<Site> getAllSites() {
		return this.siteList;
	}
}
