package com.uah.cs321;

import java.util.Date;

/**
 *
 * @author David
 */
// SENDER AND RECIPIENT WILL BE USERS LATER
public class Email {

	private final String subject, body, sender, recipient;
	private final Date timeStamp;

	public Email(String subject, String body, String sender, String recipient) {
		this.subject = subject;
		this.body = body;
		this.sender = sender;
		this.recipient = recipient;
		this.timeStamp = new Date();
	}

	public void delete() {
		// deleteEmail(this);
	}

	public String getSubject() {
		return this.subject;
	}

	public String getBody() {
		return this.body;
	}

	public String getSender() {
		return this.sender;
	}

	public String getRecipient() {
		return this.recipient;
	}

	public Date getTimeStamp() {
		return this.timeStamp;
	}

}
