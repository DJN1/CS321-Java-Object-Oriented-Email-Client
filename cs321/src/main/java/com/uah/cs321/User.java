package com.uah.cs321;

/**
 *
 * @author Colin, Zach, Caleb, David
 */
public class User {

	private final String userName;
	private final String emailAddress;
	private final Site site;
	private final Mailboxes userMailbox;

	public User(String aUserName, Site site) {
		this.userName = aUserName;
		this.site = site;
		this.emailAddress = this.userName + "@" + this.site.GetFullName();
		this.userMailbox = new Mailboxes(this.emailAddress);
	}

	public String toString() {
		return userName;
	}

	public String getUserName() {
		return this.userName;
	}

	public String getEmailAddress() {
		return this.emailAddress;
	}

	public String getSiteName() {
		return this.site.toString();
	}

	public Mailboxes getUserMailbox() {
		return this.userMailbox;
	}
}
