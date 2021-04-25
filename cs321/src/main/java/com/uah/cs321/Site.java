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

	private ArrayList<User> userList;
	private String name;
	private String domainSuffix;
	private String fullName;
	private User activeUser;

	Site(String nameConstructor, String suffix) {
		name = nameConstructor;
		domainSuffix = suffix;
		fullName = name + domainSuffix;
		userList = new ArrayList<>();
	}

	public String toString() {
		return name;
	}

	public void AddUser(User user) {
		userList.add(user);
	}

	public void RemoveUser(User user) {
		userList.remove(user);
	}

	public void SelectUser(User user) {
		activeUser = user;
	}

	public String GetName() {
		return name;
	}

	public String GetFullName() {
		return fullName;
	}

	public ArrayList<User> getUserList() {
		return userList;
	}
}
