/**
 * Class: MailSender.java
 * Purpose: Handles sending and receiving emails.
 */
package com.uah.cs321;

import java.util.ArrayList;

/**
 *
 * @author Zach, Caleb, Colin, David
 */
public class MailSender {

	private static MailSender mailSenderInstance = null;

	private ArrayList<Site> siteList;

	private MailSender() {

	}

	public static MailSender getInstance() {
		if (mailSenderInstance == null) {
			mailSenderInstance = new MailSender();
		}
		return mailSenderInstance;
	}

	// public facing send message method
	public boolean sendMessage(User sender, String recepientEmailAddress, Email aEmail) {
		var recipient = getRecipient(recepientEmailAddress);
		if (!validateObject(recipient)) {
			System.out.println("Error: user does not exist.");
			return false;
		} else {
			var receiverInbox = recipient.getUserMailbox().getInbox();
			receiverInbox.add(0, aEmail);

			var senderSentBox = sender.getUserMailbox().getSentBox();
			senderSentBox.add(0, aEmail);

			return true;
		}
	}

	// get and validate recipient
	private User getRecipient(String emailAddress) {
		System.out.println("recipient address: " + emailAddress);
		var site = getSite(emailAddress);

		if (!validateObject(site)) {
			return null;
		} else {
			return site.getUserList().stream().filter(user -> {
				System.out.println("current address: " + user.getEmailAddress());
				return user.getEmailAddress().equals(emailAddress);
			}).findFirst().orElse(null);
		}
	}

	// get side from email address of recipient
	private Site getSite(String emailAddress) {
		var siteToValidate = parseEmailAddress(emailAddress);
		System.out.println("site to validate: " + siteToValidate);

		this.siteList = SimpleEmail.getInstance().getAllSites();

		return siteList.stream().filter(site -> {
			System.out.println(site.GetFullName());
			return site.GetFullName().equals(siteToValidate);
		}).findFirst().orElse(null);
	}

	// parse recipient email address
	private String parseEmailAddress(String emailAddress) {
		return emailAddress.substring(emailAddress.lastIndexOf("@") + 1);
	}

	// validate field inputs
	private boolean validateObject(Object o) {
		return o != null;
	}
}
