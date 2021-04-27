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
import javax.swing.LayoutStyle;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import javax.swing.JScrollPane;
import java.util.ArrayList;
import java.awt.Dimension;

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
		this.addEmails();
		this.addUI();
//		this.initComponents();
		this.setLocationRelativeTo(null);

	}

//	@SuppressWarnings("unchecked")
//	private void initComponents() {
//
//	}
	private void populateEmailList() {
		this.emails.forEach(email -> {
			this.emailItemList.add(new EmailListItem(email));
		});
		this.emailItemList.add(new EmailListItem(new Email("subject1", "body1", "rec1", "sender1")));
		this.emailItemList.add(new EmailListItem(new Email("subject2", "body2", "rec2", "sender2")));
		this.emailItemList.add(new EmailListItem(new Email("subject3", "body3", "rec3", "sender3")));
		this.emailItemList.add(new EmailListItem(new Email("subject4", "body4", "rec4", "sender4")));
		this.emailItemList.add(new EmailListItem(new Email("subject5", "body5", "rec5", "sender5")));
		this.emailItemList.add(new EmailListItem(new Email("subject6", "body6", "rec6", "sender6")));
		this.emailItemList.add(new EmailListItem(new Email("subject7", "body7", "rec7", "sender7")));
		this.emailItemList.add(new EmailListItem(new Email("subject8", "body8", "rec8", "sender8")));
		this.emailItemList.add(new EmailListItem(new Email("subject9", "body9", "rec9", "sender9")));
		this.emailItemList.add(new EmailListItem(new Email("subject10", "body10", "rec10", "sender10")));
		this.emailItemList.add(new EmailListItem(new Email("subject11", "body11", "rec11", "sender11")));
		this.emailItemList.add(new EmailListItem(new Email("subject12", "body12", "rec12", "sender12")));
		this.emailItemList.add(new EmailListItem(new Email("subject13", "body13", "rec13", "sender13")));
		this.emailItemList.add(new EmailListItem(new Email("subject14", "body14", "rec14", "sender14")));

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
		this.populateEmailList();

		this.emailListPanel = new JPanel();
		this.emailListPanelLayout = new GroupLayout(emailListPanel);
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

		emailListPanel.setBackground(new Color(153, 153, 153));
		emailListPanel.setForeground(new Color(204, 204, 204));

		emailListPanel.setLayout(emailListPanelLayout);
		GroupLayout.ParallelGroup horizontalParGroup = emailListPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING);
		GroupLayout.SequentialGroup horizontalSeqGroup = emailListPanelLayout.createSequentialGroup();

		GroupLayout.ParallelGroup verticalParGroup = emailListPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING);
		GroupLayout.SequentialGroup verticalSeqGroup = emailListPanelLayout.createSequentialGroup();

		horizontalSeqGroup.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE);

		GroupLayout.ParallelGroup emailGroup = emailListPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING);

		verticalSeqGroup.addContainerGap();

		for (int i = 0; i < this.emailItemList.size(); i++) {
			emailGroup.addComponent(emailItemList.get(i), GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE);
			verticalSeqGroup.addComponent(this.emailItemList.get(i), GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE);
			if (i != this.emailItemList.size() - 1) {
				verticalSeqGroup.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED);
			}
		}

		verticalSeqGroup.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE);
		verticalParGroup.addGroup(verticalSeqGroup);
		this.emailListPanelLayout.setVerticalGroup(verticalParGroup);

		horizontalSeqGroup.addGroup(emailGroup);
		horizontalSeqGroup.addContainerGap();
		horizontalParGroup.addGroup(horizontalSeqGroup);
		this.emailListPanelLayout.setHorizontalGroup(horizontalParGroup);

		this.emailListScrollPane = new JScrollPane(this.emailListPanel);
		this.emailListPanel.setAutoscrolls(true);
		this.emailListScrollPane.setPreferredSize(new Dimension(1000, 640));
	}

	private void addUI() {
		GroupLayout layout = new GroupLayout(this.getContentPane());

		this.getContentPane().setLayout(layout);

		layout.setHorizontalGroup(
				layout.createParallelGroup(GroupLayout.Alignment.LEADING)
						.addGroup(layout.createSequentialGroup()
								.addGap(44, 44, 44)
								.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
										.addComponent(this.accountLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(this.switchUserSiteButton)
										.addComponent(this.settingsLabel)
										.addComponent(this.composeEmailButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(this.emailBoxesLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(this.inboxButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(this.sentButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(this.trashButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(this.manageSitesButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(this.manageUsersButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
										.addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
												.addComponent(this.inboxLabel)
												.addGap(483, 483, 483))
										.addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
												.addComponent(this.emailListScrollPane, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
												.addGap(30, 30, 30))))
		);

		layout.setVerticalGroup(
				layout.createParallelGroup(GroupLayout.Alignment.LEADING)
						.addGroup(layout.createSequentialGroup()
								.addGap(12, 12, 12)
								.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
										.addComponent(this.inboxLabel)
										.addComponent(this.accountLabel))
								.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
								.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
										.addGroup(layout.createSequentialGroup()
												.addComponent(this.composeEmailButton, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
												.addGap(62, 62, 62)
												.addComponent(this.emailBoxesLabel)
												.addGap(27, 27, 27)
												.addComponent(this.inboxButton, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
												.addGap(18, 18, 18)
												.addComponent(this.sentButton, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
												.addGap(18, 18, 18)
												.addComponent(this.trashButton, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
												.addGap(94, 94, 94)
												.addComponent(this.settingsLabel)
												.addGap(18, 18, 18)
												.addComponent(this.manageSitesButton)
												.addGap(18, 18, 18)
												.addComponent(this.manageUsersButton)
												.addGap(46, 46, 46)
												.addComponent(this.switchUserSiteButton, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE))
										.addComponent(this.emailListScrollPane, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
								.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);

		this.pack();
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
	private JPanel emailListPanel;
	private JScrollPane emailListScrollPane;
	private JButton inboxButton;
	private JLabel inboxLabel;
	private JButton manageSitesButton;
	private JButton manageUsersButton;
	private JButton sentButton;
	private JLabel settingsLabel;
	private JButton switchUserSiteButton;
	private JButton trashButton;
	private DefaultListModel model;
	private GroupLayout emailListPanelLayout;
}
