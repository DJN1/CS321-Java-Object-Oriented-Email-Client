/*
 * Class: MainFrame.java
 * Purpose: This class is the base frame for the email client.
 *
 */
package com.uah.cs321;

import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;
import javax.swing.DefaultListModel;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.WindowConstants;
import java.util.ArrayList;

/**
 *
 * @author Colin O'Kain, david
 */
public class MainFrame extends JFrame {

	/**
	 * Creates new form MainFrame
	 */
	public MainFrame() {
		this.emails = new ArrayList<>();
		this.getEmails(MailBoxType.INBOX);
		this.emailItemList = new ArrayList<>();
		this.createButtons();
		this.createLabels();
		this.initComponents();
		this.emailListPanelLayout = new GroupLayout(emailListPanel);
		this.setLocationRelativeTo(null);

	}

	@SuppressWarnings("unchecked")
	private void initComponents() {
		jScrollPane1 = new JScrollPane();
		jScrollPane2 = new JScrollPane();
		this.emailListPanel = new JPanel();

		jScrollPane1.setBackground(new Color(187, 187, 187));

		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

		emailListPanel.setBackground(new Color(153, 153, 153));
		emailListPanel.setForeground(new Color(204, 204, 204));

		emailListPanel.setLayout(emailListPanelLayout);
//		emailListPanelLayout.setHorizontalGroup(
//				emailListPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//						.addGroup(emailListPanelLayout.createSequentialGroup()
//								.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
//								.addGroup(emailListPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//										.addComponent(emailListItem10, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
//										.addComponent(emailListItem11, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
//										.addComponent(emailListItem12, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
//										.addComponent(emailListItem13, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
//										.addComponent(emailListItem14, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
//										.addComponent(emailListItem15, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
//										.addComponent(emailListItem16, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
//										.addComponent(emailListItem17, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
//								.addContainerGap())
//		);
//		emailListPanelLayout.setVerticalGroup(
//				emailListPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//						.addGroup(emailListPanelLayout.createSequentialGroup()
//								.addContainerGap()
//								.addComponent(emailListItem10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
//								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
//								.addComponent(emailListItem11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
//								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
//								.addComponent(emailListItem12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
//								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
//								.addComponent(emailListItem13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
//								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
//								.addComponent(emailListItem14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
//								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
//								.addComponent(emailListItem15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
//								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
//								.addComponent(emailListItem16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
//								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
//								.addComponent(emailListItem17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
//								.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
//		);

		System.out.println("Pre layout");

		GroupLayout layout = new GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(
				layout.createParallelGroup(GroupLayout.Alignment.LEADING)
						.addGroup(layout.createSequentialGroup()
								.addGap(44, 44, 44)
								.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
										.addComponent(accountLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(switchUserSiteButton)
										.addComponent(settingsLabel)
										.addComponent(this.composeEmailButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(emailBoxesLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(inboxButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(sentButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(trashButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(manageSitesButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(manageUsersButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
										.addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
												.addComponent(inboxLabel)
												.addGap(483, 483, 483))
										.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
												.addComponent(emailListPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
												.addGap(30, 30, 30))))
		);
		layout.setVerticalGroup(
				layout.createParallelGroup(GroupLayout.Alignment.LEADING)
						.addGroup(layout.createSequentialGroup()
								.addGap(12, 12, 12)
								.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
										.addComponent(inboxLabel)
										.addComponent(accountLabel))
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
								.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
										.addGroup(layout.createSequentialGroup()
												.addComponent(this.composeEmailButton, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
												.addGap(62, 62, 62)
												.addComponent(emailBoxesLabel)
												.addGap(27, 27, 27)
												.addComponent(inboxButton, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
												.addGap(18, 18, 18)
												.addComponent(sentButton, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
												.addGap(18, 18, 18)
												.addComponent(trashButton, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
												.addGap(94, 94, 94)
												.addComponent(settingsLabel)
												.addGap(18, 18, 18)
												.addComponent(manageSitesButton)
												.addGap(18, 18, 18)
												.addComponent(manageUsersButton)
												.addGap(46, 46, 46)
												.addComponent(switchUserSiteButton, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE))
										.addComponent(emailListPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
								.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);

		pack();
	}

	private void populateEmailList() {
		this.emails.forEach(email -> {
			this.emailItemList.add(new EmailListItem(email));
		});
	}

	private void getEmails(MailBoxType mailBoxType) {
		this.emails.clear();
		if (SimpleEmail.getInstance().GetCurrentSite() != null) {
			switch (mailBoxType) {
				case INBOX:
					this.emails = SimpleEmail.getInstance().GetCurrentSite().GetCurrentUser().getUserMailbox().getInbox();
					break;
				case SENT:
					this.emails = SimpleEmail.getInstance().GetCurrentSite().GetCurrentUser().getUserMailbox().getSentBox();
					break;
				default:
					this.emails = SimpleEmail.getInstance().GetCurrentSite().GetCurrentUser().getUserMailbox().getTrashBox();
					break;
			}
		}
	}

	private void addEmails() {

	}

	private void createButtons() {
		this.composeEmailButton = new JButton();
		this.inboxButton = new JButton();
		this.sentButton = new JButton();
		this.trashButton = new JButton();
		this.manageSitesButton = new JButton();
		this.manageUsersButton = new JButton();
		this.switchUserSiteButton = new JButton();

		this.composeEmailButton.setBackground(new Color(153, 204, 255));
		this.composeEmailButton.setFont(new Font("Segoe UI", 1, 14)); // NOI18N
		this.composeEmailButton.setText("Compose Email");
		this.composeEmailButton.addActionListener((ActionEvent evt) -> {
			this.composeEmailButtonActionPerformed(evt);
		});

		this.inboxButton.setBackground(new Color(153, 204, 255));
		this.inboxButton.setFont(new Font("Segoe UI", 0, 14)); // NOI18N
		this.inboxButton.setText("Inbox");
		this.inboxButton.setToolTipText("");
		this.inboxButton.setMaximumSize(new java.awt.Dimension(72, 22));
		this.inboxButton.setMinimumSize(new java.awt.Dimension(72, 22));
		this.inboxButton.setPreferredSize(new java.awt.Dimension(72, 22));
		this.inboxButton.addActionListener((ActionEvent evt) -> {
			this.inboxButtonActionPerformed(evt);
		});

		this.sentButton.setBackground(new Color(153, 204, 255));
		this.sentButton.setText("Sent");
		this.sentButton.addActionListener((ActionEvent evt) -> {
			this.sentButtonActionPerformed(evt);
		});

		this.trashButton.setBackground(new Color(153, 204, 255));
		this.trashButton.setText("Trash");
		this.trashButton.addActionListener((ActionEvent evt) -> {
			this.trashButtonActionPerformed(evt);
		});

		this.manageSitesButton.setBackground(new Color(153, 204, 255));
		this.manageSitesButton.setText("Manage Sites");
		this.manageSitesButton.addActionListener((ActionEvent evt) -> {
			this.manageSitesButtonActionPerformed(evt);
		});

		this.manageUsersButton.setBackground(new Color(153, 204, 255));
		this.manageUsersButton.setText("Manage Users");
		this.manageUsersButton.addActionListener((ActionEvent evt) -> {
			this.manageUsersButtonActionPerformed(evt);
		});

		this.switchUserSiteButton.setBackground(new Color(153, 204, 255));
		this.switchUserSiteButton.setText("<html>&nbsp Switch <br> User/Site </html>");
		this.switchUserSiteButton.addActionListener((ActionEvent evt) -> {
			this.switchUserSiteButtonActionPerformed(evt);
		});
	}

	private void createLabels() {
		this.emailBoxesLabel = new JLabel();
		this.settingsLabel = new JLabel();
		this.inboxLabel = new JLabel();
		this.accountLabel = new JLabel();

		this.emailBoxesLabel.setFont(new Font("Segoe UI", 1, 14)); // NOI18N
		this.emailBoxesLabel.setText("Email Boxes");

		this.settingsLabel.setFont(new Font("Segoe UI", 1, 14)); // NOI18N
		this.settingsLabel.setText("Settings");

		this.inboxLabel.setFont(new Font("Segoe UI", 1, 18)); // NOI18N
		this.inboxLabel.setText("Inbox");
		this.accountLabel.setFont(new Font("Segoe UI", 1, 16)); // NOI18N
		this.accountLabel.setText("No Site/User Selected");
	}

	private void composeEmailButtonActionPerformed(ActionEvent evt) {
		new ComposeEmailDialog(this, rootPaneCheckingEnabled).setVisible(true);
	}

	private void inboxButtonActionPerformed(ActionEvent evt) {
		inboxLabel.setText("Inbox");
	}

	private void sentButtonActionPerformed(ActionEvent evt) {
		inboxLabel.setText("Sent");
	}

	private void trashButtonActionPerformed(ActionEvent evt) {
		inboxLabel.setText("Trash");
	}

	private void manageSitesButtonActionPerformed(ActionEvent evt) {
		ManageSites.ManageSitesPanel();
	}

	private void manageUsersButtonActionPerformed(ActionEvent evt) {
		ManageUsers.ManageUsersPanel();
	}

	private void switchUserSiteButtonActionPerformed(ActionEvent evt) {
		SwitchSettings.SwitchSettingsPanel();
	}

	public void openWindow() {
		/* Set the Nimbus look and feel */
		//<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
		/* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
		 */
		try {
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException ex) {
			java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		}
		//</editor-fold>

		/* Create and display the form */
		java.awt.EventQueue.invokeLater(() -> {
			new MainFrame().setVisible(true);
		});
	}

	public void AddItemToList(String item, DefaultListModel model) {
		model.addElement(item);
	}

	public void UpdateActiveUserText() {
		Site activeSite = SimpleEmail.getInstance().GetCurrentSite();
		accountLabel.setText(activeSite.GetCurrentUser() + "@" + activeSite.toString());
	}

	private ArrayList<Email> emails;
	private ArrayList<EmailListItem> emailItemList;
	private JLabel accountLabel;
	private JButton composeEmailButton;
	private JLabel emailBoxesLabel;
	private EmailListItem emailListItem1;
	private EmailListItem emailListItem10;
	private EmailListItem emailListItem11;
	private EmailListItem emailListItem12;
	private EmailListItem emailListItem13;
	private EmailListItem emailListItem14;
	private EmailListItem emailListItem15;
	private EmailListItem emailListItem16;
	private EmailListItem emailListItem17;
	private JPanel emailListPanel;
	private JButton inboxButton;
	private JLabel inboxLabel;
	private JScrollPane jScrollPane1;
	private JScrollPane jScrollPane2;
	private JButton manageSitesButton;
	private JButton manageUsersButton;
	private JButton sentButton;
	private JLabel settingsLabel;
	private JButton switchUserSiteButton;
	private JButton trashButton;
	private DefaultListModel model;
	private GroupLayout emailListPanelLayout;
}
