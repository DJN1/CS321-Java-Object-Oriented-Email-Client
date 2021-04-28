/*
 * Class: MainFrame.java
 * Purpose: This class is the base frame for the email client.
 *
 */
package com.uah.cs321;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.LayoutStyle;
import javax.swing.WindowConstants;

/**
 *
 * @author Colin O'Kain, david
 */
public class MainFrame extends JFrame {

	/**
	 * Creates new form MainFrame
	 */
	public MainFrame() {
            try {
                for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                        if ("Nimbus".equals(info.getName())) {
                            System.out.println("Here");
                                javax.swing.UIManager.setLookAndFeel(info.getClassName());
                                break;
                        }
                }
            } catch (ClassNotFoundException ex) {
                java.util.logging.Logger.getLogger(this.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            } catch (InstantiationException ex) {
                java.util.logging.Logger.getLogger(this.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            } catch (IllegalAccessException ex) {
                java.util.logging.Logger.getLogger(this.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            } catch (javax.swing.UnsupportedLookAndFeelException ex) {
                java.util.logging.Logger.getLogger(this.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            }

            this.emails = new ArrayList<>();
            this.currentMailBoxType = MailBoxType.INBOX;
            this.emailItemList = new ArrayList<>();
            this.emailBoxesLabel = new JLabel();
            this.settingsLabel = new JLabel();
            this.inboxLabel = new JLabel();
            this.accountLabel = new JLabel();
            this.createLabels();
            this.createButtons();
            this.updateUI();
	}

	private void populateEmailList() {
            this.emailItemList.clear();
            this.emails.forEach(email -> {
                this.emailItemList.add(new EmailListItem(email, currentMailBoxType));
            });

	}

	private void getEmails() {
		if (SimpleEmail.getInstance().GetCurrentSite() != null) {
			switch (this.currentMailBoxType) {
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
                

                if(this.emailListPanel != null){
                    this.emailListPanel.setVisible(false);
                    this.emailListScrollPane.setVisible(false);
                }

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

	private void addUIElements() {
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

		this.emailBoxesLabel.setFont(new Font("Segoe UI", 1, 14)); // NOI18N
		this.emailBoxesLabel.setText("Email Boxes");

		this.settingsLabel.setFont(new Font("Segoe UI", 1, 14)); // NOI18N
		this.settingsLabel.setText("Settings");

		this.inboxLabel.setFont(new Font("Segoe UI", 1, 18)); // NOI18N
		this.inboxLabel.setText("Inbox");
		this.accountLabel.setFont(new Font("Segoe UI", 1, 16)); // NOI18N
		this.accountLabel.setText("No Site/User Selected");
	}

	public void updateUI() {
		this.getEmails();
		System.out.println("number of emails: " + (this.emails.size() - 1));
		
		this.addEmails();
		System.out.println("added emails");
		this.addUIElements();
		System.out.println("added ui elements");
//		this.repaint();
		this.setLocationRelativeTo(null);
	}

	private void composeEmailButtonActionPerformed(ActionEvent evt) {
		new ComposeEmailDialog(this, this.rootPaneCheckingEnabled).setVisible(true);
	}

	private void inboxButtonActionPerformed(ActionEvent evt) {
		this.currentMailBoxType = MailBoxType.INBOX;
                this.updateUI();
		this.inboxLabel.setText("Inbox");
	}

	private void sentButtonActionPerformed(ActionEvent evt) {
		this.currentMailBoxType = MailBoxType.SENT;
		this.updateUI();
		this.inboxLabel.setText("Sent");
	}

	private void trashButtonActionPerformed(ActionEvent evt) {
		this.currentMailBoxType = MailBoxType.TRASH;
		this.updateUI();
		this.inboxLabel.setText("Trash");
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
            
            this.setVisible(true);
	}

	public void AddItemToList(String item, DefaultListModel model) {
		model.addElement(item);
	}

	public void UpdateActiveUserText() {
		Site activeSite = SimpleEmail.getInstance().GetCurrentSite();
		this.accountLabel.setText(activeSite.GetCurrentUser() + "@" + activeSite.GetFullName());
	}

	private ArrayList<Email> emails;
	private final ArrayList<EmailListItem> emailItemList;
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
	private GroupLayout emailListPanelLayout;
	private MailBoxType currentMailBoxType;
}
