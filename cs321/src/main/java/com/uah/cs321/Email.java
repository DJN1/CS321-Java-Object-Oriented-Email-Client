/**
 * Class: Email.java
 * Purpose: Models an email with sender, recipient, body, timestamp and subject.
 */
package com.uah.cs321;

import java.util.Date;

/**
 *
 * @author David, Zach, Caleb, Colin
 */
public class Email {

	private final String subject;
	private final String body;
	private final Date timeStamp;
	private final String recipientName;
	private final User senderName;

	/**
	 *
	 * @param aSubject subject of email
	 * @param aBody body of the email
	 * @param aSender User that sends email
	 * @param aRecipient email address of recipient
	 */
	public Email(String aSubject, String aBody, User aSender, String aRecipient) {
		this.subject = aSubject;
		this.body = aBody;
		this.timeStamp = new Date();
		this.recipientName = aRecipient;
		this.senderName = aSender;
	}

	// returns subject
	public String getSubject() {
		return this.subject;
	}

	// returns email body
	public String getBody() {
		return this.body;
	}

	// returns timestamp
	public Date getTimeStamp() {
		return this.timeStamp;
	}

	// returns recipient username
	public String getRecipient() {
		return this.recipientName;
	}

	// returns sender User object
	public User getSender() {
		return this.senderName;
	}
}
