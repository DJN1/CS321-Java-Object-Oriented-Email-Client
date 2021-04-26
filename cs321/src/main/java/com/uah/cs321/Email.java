package com.uah.cs321;

import java.util.Date;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author David, Zach
 */
public class Email {

	private final String subject;
	private final String body;
	private final Date timeStamp;
	private final String recipientName;
	private final String senderName;

	public Email(String aSubject, String aBody, String aRecipient, String aSender) {
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

	public String getSender() {
		return this.senderName;
	}
}
