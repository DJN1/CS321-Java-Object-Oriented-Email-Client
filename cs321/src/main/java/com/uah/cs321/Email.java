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

	public String getSubject() {
		return this.subject;
	}

	public String getBody() {
		return this.body;
	}

	public Date getTimeStamp() {
		return this.timeStamp;
	}

	public String getRecipient() {
		return this.recipientName;
	}

	public User getSender() {
		return this.senderName;
	}
}
