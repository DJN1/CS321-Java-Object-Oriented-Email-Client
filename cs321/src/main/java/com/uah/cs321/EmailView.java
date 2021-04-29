/**
 * Class: EmailView.java
 * Purpose: Displays emails in any of the mailboxes.
 */
package com.uah.cs321;

import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.WindowConstants;

/**
 *
 * @author David, Zach, Colin, Caleb
 */
public class EmailView extends javax.swing.JDialog {

	/**
	 * Creates new form EmailView
	 *
	 * @param parent parent
	 * @param modal is modal
	 * @param email email to display
	 * @param currentMailBoxType current mailbox type
	 */
	public EmailView(Frame parent, boolean modal, Email email, MailBoxType currentMailBoxType) {
		super(parent, modal);
		this.email = email;
		this.currentMailBoxType = currentMailBoxType;
		initComponents();
		this.setLocationRelativeTo(null);
	}

	// creates the UI
	private void initComponents() {

		this.senderFieldLabel = new JLabel();
		this.subjectFieldLabel = new JLabel();
		this.bodyScrollContainer = new JScrollPane();
		this.bodyField = new JTextArea();
		this.senderField = new JTextField();
		this.subjectField = new JTextField();
		this.deleteButton = new JButton();
		this.restoreButton = new JButton();

		if (this.currentMailBoxType == MailBoxType.TRASH) {
			restoreButton.setVisible(true);
		} else {
			restoreButton.setVisible(false);
		}

		this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		this.setTitle("View Email");

		this.senderFieldLabel.setFont(new Font("Segoe UI", 0, 14)); // NOI18N
		this.senderFieldLabel.setText("From:");

		this.subjectFieldLabel.setFont(new Font("Segoe UI", 0, 14)); // NOI18N
		this.subjectFieldLabel.setText("Subject:");

		this.bodyField.setEditable(false);
		this.bodyField.setColumns(20);
		this.bodyField.setRows(5);
		this.bodyField.setText(this.email.getBody());
		this.bodyScrollContainer.setViewportView(bodyField);

		this.senderField.setEditable(false);
		this.senderField.setText(this.email.getSender().getEmailAddress());

		this.subjectField.setEditable(false);
		this.subjectField.setText(this.email.getSubject());

		this.deleteButton.setBackground(new Color(255, 0, 0));
		this.deleteButton.setText("Delete");
		this.deleteButton.addActionListener((ActionEvent evt) -> {
			sendDeleteButtonActionPerformed(evt);
		});

		this.restoreButton.setBackground(new Color(255, 0, 0));
		this.restoreButton.setText("Restore Email");
		this.restoreButton.addActionListener((ActionEvent evt) -> {
			restoreButtonActionPerformed(evt);
		});

		GroupLayout layout = new GroupLayout(getContentPane());
		this.getContentPane().setLayout(layout);
		layout.setHorizontalGroup(
				layout.createParallelGroup(GroupLayout.Alignment.LEADING)
						.addGroup(layout.createSequentialGroup()
								.addContainerGap()
								.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
										.addGroup(layout.createSequentialGroup()
												.addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
														.addComponent(subjectFieldLabel)
														.addComponent(senderFieldLabel))
												.addGap(18, 18, 18)
												.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
														.addComponent(senderField)
														.addComponent(subjectField)))
										.addComponent(bodyScrollContainer, GroupLayout.DEFAULT_SIZE, 595, Short.MAX_VALUE).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
										.addGap(0, 0, Short.MAX_VALUE).addComponent(this.restoreButton)
										.addGap(0, 0, Short.MAX_VALUE).addComponent(this.deleteButton)
								))
								.addContainerGap())
		);
		layout.setVerticalGroup(
				layout.createParallelGroup(GroupLayout.Alignment.LEADING)
						.addGroup(layout.createSequentialGroup()
								.addContainerGap()
								.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
										.addComponent(senderFieldLabel)
										.addComponent(senderField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
										.addComponent(subjectFieldLabel)
										.addComponent(subjectField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(bodyScrollContainer, GroupLayout.DEFAULT_SIZE, 198, Short.MAX_VALUE)
								.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.restoreButton)
								.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.deleteButton)
								.addContainerGap())
		);

		pack();
	}

	// Delete button handler
	private void sendDeleteButtonActionPerformed(ActionEvent evt) {
		System.out.println("clicked delete to delete this email");
		if (this.currentMailBoxType == MailBoxType.TRASH) {
			SimpleEmail.getInstance().GetCurrentSite().GetCurrentUser().getUserMailbox().deleteEmailFromTrash(this.email);
		} else {
			SimpleEmail.getInstance().GetCurrentSite().GetCurrentUser().getUserMailbox().sendEmailToTrash(this.email, this.currentMailBoxType);
		}

		JOptionPane.showMessageDialog(this, "Email deleted.", "Successful delete", JOptionPane.DEFAULT_OPTION);
		Main.simpleEmailFrame.updateUI();
		this.dispose();
	}

	// Restore button handler
	private void restoreButtonActionPerformed(ActionEvent evt) {
		SimpleEmail.getInstance().GetCurrentSite().GetCurrentUser().getUserMailbox().restoreEmailFromTrash(this.email);
		JOptionPane.showMessageDialog(this, "Email restored from trash.", "Email restored.", JOptionPane.DEFAULT_OPTION);
		Main.simpleEmailFrame.updateUI();
		this.dispose();
	}

	// set body of emailview
	public void setBody(String text) {
		this.bodyField.setText(text);
	}

	private final Email email;
	private final MailBoxType currentMailBoxType;
	private JButton deleteButton;
	private JButton restoreButton;
	private JLabel senderFieldLabel;
	private JLabel subjectFieldLabel;
	private JScrollPane bodyScrollContainer;
	private JTextArea bodyField;
	private JTextField senderField;
	private JTextField subjectField;
}
