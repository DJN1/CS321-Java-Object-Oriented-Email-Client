/**
 * Class: Site.java
 * Purpose: Models site for system.
 */
package com.uah.cs321;

import java.util.ArrayList;

/**
 *
 * @author colin, caleb, zach, david
 */
public class Site {

	private final ArrayList<User> userList;
	private final String name;
	private final String domainSuffix;
	private final String fullName;
	private User activeUser;

	public Site(String nameConstructor, String suffix) {
		name = nameConstructor;
		domainSuffix = suffix;
		fullName = name + "." + domainSuffix;
		userList = new ArrayList<>();
	}

	// returns ame of site
	@Override
	public String toString() {
		return name;
	}

	// adds user to site
	public void AddUser(User user) {
		userList.add(user);
	}

	// removes user from site
	public void RemoveUser(User user) {
		userList.remove(user);
	}

	// selects user in site
	public void SelectUser(User user) {
		activeUser = user;
	}

	// get name of site
	public String GetName() {
		return name;
	}

	// get full name of site(name + suffix)
	public String GetFullName() {
		return fullName;
	}

	// returns current active user
	public User GetCurrentUser() {
		return activeUser;
	}

	// returns all users in list
	public ArrayList<User> getUserList() {
		return userList;
	}
}
