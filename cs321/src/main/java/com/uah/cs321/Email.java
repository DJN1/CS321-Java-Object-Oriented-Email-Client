package com.uah.cs321;

import java.util.Date;

/**
 *
 * @author David
 */
public class Email {

	private final String subject, body;
	private final Date timeStamp;
	private final User sender, recipient;

	public Email(String subject, String body, User sender, User recipient) {
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

	public User getSender() {
		return this.sender;
	}

	public User getRecipient() {
		return this.recipient;
	}

	public Date getTimeStamp() {
		return this.timeStamp;
	}

}
