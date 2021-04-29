/**
 * Class: User.java
 * Purpose: Models user in system.
 */
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

	// returns user name
	@Override
	public String toString() {
		return userName;
	}

	// returns username
	public String getUserName() {
		return this.userName;
	}

	// returns email address
	public String getEmailAddress() {
		return this.emailAddress;
	}

	// returns users site
	public String getSiteName() {
		return this.site.toString();
	}

	// returns users mailbox
	public Mailboxes getUserMailbox() {
		return this.userMailbox;
	}
}
