/**
 * Class: Tester.java
 * Purpose: Adds users, emails, and emails to test the system.
 */
package com.uah.cs321;

/**
 *
 * @author David, Caleb, Colin, Zach
 */
public class Tester {

	public static void test() {
		Site gmail = new Site("gmail", "com");
		Site uah = new Site("uah", "edu");
		SimpleEmail.getInstance().AddSite(gmail);
		SimpleEmail.getInstance().AddSite(uah);
		User rng = new User("random.user", gmail);
		User zwu = new User("zmw0002", uah);
		User dnu = new User("dn0039", uah);
		User ccu = new User("cco0012", uah);
		User cwu = new User("ckw0013", uah);
		SimpleEmail.getInstance().SelectSite(gmail);
		SimpleEmail.getInstance().GetCurrentSite().AddUser(rng);
		SimpleEmail.getInstance().SelectSite(uah);
		SimpleEmail.getInstance().GetCurrentSite().AddUser(zwu);
		SimpleEmail.getInstance().GetCurrentSite().AddUser(dnu);
		SimpleEmail.getInstance().GetCurrentSite().AddUser(ccu);
		SimpleEmail.getInstance().GetCurrentSite().AddUser(cwu);
		Email dnu2zwu = new Email("final project", "Hey, can we work on the project tonight?\nDavid", dnu, zwu.getUserName());
		MailSender.getInstance().sendMessage(dnu, zwu.getEmailAddress(), dnu2zwu);
		Email ccu2cwu = new Email("design docs", "Hey,\n What's the status of the design documents?\nColin", ccu, cwu.getUserName());
		MailSender.getInstance().sendMessage(ccu, cwu.getEmailAddress(), ccu2cwu);
		Email spam = new Email("You are Millionare", "Hello Good Sir,\n I am nigerian prince and need your help.\nI have $50 millions dollares cash that I help to get to American.\nYou paypal me $100 dollares and I send you %10($5 millions) for your help.\nEmail me if you interested.\n\nPrince Neil of Nigeria", rng, dnu.getUserName()
		);
		MailSender.getInstance().sendMessage(rng, dnu.getEmailAddress(), spam);
	}
}
