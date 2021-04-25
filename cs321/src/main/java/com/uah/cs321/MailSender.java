package com.uah.cs321;

import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Zach
 */
public class MailSender {

	private final ArrayList<Site> siteList;

	public MailSender(SimpleEmail aSimpleEmail) {
		siteList = aSimpleEmail.getAllSites();
	}

	public boolean sendMessage(User sender, String recepientEmailAddress, Email aEmail) {
		var recipient = getRecipient(recepientEmailAddress);
		if (!validateObject(recipient)) {
			System.out.println("Error: user does not exist.");
			return false;
		} else {
			var receiverInbox = recipient.getUserMailbox().getInbox();
			receiverInbox.add(aEmail);

			var senderSentBox = sender.getUserMailbox().getSentBox();
			senderSentBox.add(aEmail);

			return true;
		}
	}

	private User getRecipient(String emailAddress) {
		var site = getSite(emailAddress);

		if (!validateObject(site)) {
			return null;
		} else {
			return site.getUserList().stream().filter(user -> user.getEmailAddress().equals(emailAddress)).findFirst().orElse(null);
		}
	}

	private Site getSite(String emailAddress) {
		var siteToValidate = parseEmailAddress(emailAddress);

		return siteList.stream().filter(site -> site.GetFullName().equals(siteToValidate)).findFirst().orElse(null);
	}

	private String parseEmailAddress(String emailAddress) {
		return emailAddress.substring(emailAddress.lastIndexOf("@") + 1);
	}

	private boolean validateObject(Object o) {
		return o != null;
	}
}
