package com.uah.cs321;

/**
 *
 * @author David
 */
public class Tester {

	public static void test() {
		Site gmail = new Site("gmail", "com");
		Site yahoo = new Site("yahoo", "com");
		User user1 = new User("test1", gmail);
		User user2 = new User("test2", yahoo);
//		for (int i = 0; i < 10; i++) {
//			if (Math.random() > 0.5) {
//				MailSender.getInstance().sendMessage(user2, user1.getEmailAddress(), new Email("subject" + i, "testing123", user1.getUserName(), user2.getUserName()));
//			} else {
//				MailSender.getInstance().sendMessage(user1, user2.getEmailAddress(), new Email("subject" + i, "testing123", user2.getUserName(), user1.getUserName()));
//			}
//		}
		SimpleEmail.getInstance().AddSite(gmail);
		SimpleEmail.getInstance().AddSite(yahoo);
		SimpleEmail.getInstance().SelectSite(gmail);
		SimpleEmail.getInstance().GetCurrentSite().AddUser(user1);
		SimpleEmail.getInstance().SelectSite(yahoo);
		SimpleEmail.getInstance().GetCurrentSite().AddUser(user2);
		SimpleEmail.getInstance().SelectSite(gmail);
		SimpleEmail.getInstance().GetCurrentSite().SelectUser(user1);
		Email u1tou2 = new Email("u1tou2", "testing123", user2, user1.getUserName());
		MailSender.getInstance().sendMessage(user1, user2.getEmailAddress(), u1tou2);
	}
}
