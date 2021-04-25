package com.mycompany.groupproject3.zachwalker;


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
public class Mailboxes {
    
    private final String mailboxUserEmailAddress;
    private final ArrayList<Email> sentBox;
    private final ArrayList<Email> inbox;
    private final ArrayList<Email> trashBox;
    
    public Mailboxes(String emailAddress)
    {
        this.mailboxUserEmailAddress = emailAddress;
        this.sentBox = new ArrayList<>();
        this.inbox = new ArrayList<>();
        this.trashBox = new ArrayList<>();
    }
    
    public String getMailboxUserEmailAddress()
    {
        return this.mailboxUserEmailAddress;
    }
    
    public ArrayList<Email> getSentBox()
    {
        return this.sentBox;
    }
    
    public ArrayList<Email> getInbox()
    {
        return this.inbox;
    }
    
    public ArrayList<Email> getTrashBox()
    {
        return this.trashBox;
    }
    
    public void sendEmailToTrash(Email aEmail)
    {
        var emailToMove = getEmailFromBox(aEmail, this.inbox);
        
        this.trashBox.add(emailToMove);
        
        removeEmailFromBox(aEmail, this.inbox);
    }
    
    public void deleteEmailFromTrash(Email aEmail)
    {
        removeEmailFromBox(aEmail, this.trashBox);
    }
    
    public void emptyTrash()
    {
        this.trashBox.clear();
    }
    
    public void removeEmailFromBox(Email aEmail, ArrayList<Email> emailBox)
    {
        var emailToRemove = emailBox.indexOf(getEmailFromBox(aEmail, emailBox));
        emailBox.remove(emailToRemove);
    }
        
    private Email getEmailFromBox(Email aEmail, ArrayList<Email> emailBox)
    {
        return emailBox.stream().filter(email -> email.getSubject().equals(aEmail.getSubject())).findFirst().orElse(null);
    }
}
