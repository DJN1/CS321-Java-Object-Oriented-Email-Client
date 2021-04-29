package com.uah.cs321;

import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JDialog;
import javax.swing.JOptionPane;

/**
 *
 * @author David, Zach, Caleb, Colin
 */
public class ComposeEmailDialog extends JDialog {

	/**
	 * Creates new form CompoeseEmailDialog
	 *
	 * @param parent parent of dialog
	 * @param modal is modal
	 */
	public ComposeEmailDialog(Frame parent, boolean modal) {
		super(parent, modal);
		initComponents();
		this.setLocationRelativeTo(null);
	}

	@SuppressWarnings("unchecked")
	private void initComponents() {

		recipientTextField = new javax.swing.JTextField();
		recipientLabel = new javax.swing.JLabel();
		subjectTextField = new javax.swing.JTextField();
		subjectLabel = new javax.swing.JLabel();
		bodyTextScrollContainer = new javax.swing.JScrollPane();
		bodyTextArea = new javax.swing.JTextArea();
		sendEmailButton = new javax.swing.JButton();

		setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
		setTitle("Compose Email");
		setPreferredSize(new java.awt.Dimension(720, 480));
		setSize(new java.awt.Dimension(720, 480));

		recipientTextField.setToolTipText("Recipient of the Email");

		recipientLabel.setText("Recipient:");

		subjectTextField.setToolTipText("Recipient of the Email");

		subjectLabel.setText("Subject:");

		bodyTextArea.setColumns(20);
		bodyTextArea.setRows(5);
		bodyTextScrollContainer.setViewportView(bodyTextArea);

		sendEmailButton.setBackground(new java.awt.Color(0, 255, 0));
		sendEmailButton.setText("Send Email");
		sendEmailButton.addActionListener(new ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				sendEmailButtonActionPerformed(evt);
			}
		});

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(layout.createSequentialGroup()
								.addContainerGap()
								.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
										.addGroup(layout.createSequentialGroup()
												.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
														.addComponent(recipientLabel)
														.addComponent(subjectLabel))
												.addGap(18, 18, 18)
												.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
														.addComponent(subjectTextField)
														.addComponent(recipientTextField)))
										.addComponent(bodyTextScrollContainer, javax.swing.GroupLayout.DEFAULT_SIZE, 388, Short.MAX_VALUE)
										.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
												.addGap(0, 0, Short.MAX_VALUE)
												.addComponent(sendEmailButton)))
								.addContainerGap())
		);
		layout.setVerticalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(layout.createSequentialGroup()
								.addContainerGap()
								.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
										.addComponent(recipientTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
										.addComponent(recipientLabel))
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
										.addComponent(subjectTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
										.addComponent(subjectLabel))
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
								.addComponent(bodyTextScrollContainer, javax.swing.GroupLayout.DEFAULT_SIZE, 198, Short.MAX_VALUE)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(sendEmailButton)
								.addContainerGap())
		);

		pack();
	}

	private void sendEmailButtonActionPerformed(ActionEvent evt) {

		var subject = subjectTextField.getText();
		var recipient = recipientTextField.getText();
		var body = bodyTextArea.getText();
		var sender = SimpleEmail.getInstance().GetCurrentSite().GetCurrentUser();

		if (!validateFields(subject)) {
			JOptionPane.showMessageDialog(this, "Subject is required.", "Error", JOptionPane.ERROR_MESSAGE);
			return;
		} else if (!validateFields(recipient)) {
			JOptionPane.showMessageDialog(this, "Recipient is required.", "Error", JOptionPane.ERROR_MESSAGE);
			return;
		} else if (!validateFields(body)) {
			JOptionPane.showMessageDialog(this, "Email body can not be empty.", "Error", JOptionPane.ERROR_MESSAGE);
			return;
		} else {
			var newlyCreatedEmail = new Email(subject, body, sender, recipient);

			if (!MailSender.getInstance().sendMessage(sender, recipient, newlyCreatedEmail)) {
				JOptionPane.showMessageDialog(this, "Email could not be sent.", "Error", JOptionPane.ERROR_MESSAGE);
				return;
			} else {
				JOptionPane.showMessageDialog(this, "Email sent!", "Success!", JOptionPane.PLAIN_MESSAGE);
			}
		}

		this.dispose();
	}

	private boolean validateFields(Object o) {
		return !o.equals("");
	}

	private javax.swing.JTextArea bodyTextArea;
	private javax.swing.JLabel recipientLabel;
	private javax.swing.JLabel subjectLabel;
	private javax.swing.JScrollPane bodyTextScrollContainer;
	private javax.swing.JTextField recipientTextField;
	private javax.swing.JButton sendEmailButton;
	private javax.swing.JTextField subjectTextField;
}
