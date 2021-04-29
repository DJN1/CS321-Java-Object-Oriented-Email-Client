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

	Site(String nameConstructor, String suffix) {
		name = nameConstructor;
		domainSuffix = suffix;
		fullName = name + "." + domainSuffix;
		userList = new ArrayList<>();
	}

	@Override
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

	public User GetCurrentUser() {
		return activeUser;
	}

	public ArrayList<User> getUserList() {
		return userList;
	}
}
