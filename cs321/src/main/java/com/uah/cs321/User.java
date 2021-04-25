/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uah.cs321;

/**
 *
 * @author Zach
 */
public class User {

	private final String userName;
	private final String emailAddress;
	private final String siteName;
	private final Mailboxes userMailbox;

	public User(String aUserName, String aSiteName) {
		this.userName = aUserName;
		this.siteName = aSiteName;
		this.emailAddress = this.userName + "@" + this.siteName;
		this.userMailbox = new Mailboxes(this.emailAddress);
	}

	public String getUserName() {
		return this.userName;
	}

	public String getEmailAddress() {
		return this.emailAddress;
	}

	public String getSiteName() {
		return this.siteName;
	}

	public Mailboxes getUserMailbox() {
		return this.userMailbox;
	}
}
