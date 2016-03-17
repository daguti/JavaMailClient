/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.mailclient.utils;

import com.mycompany.mailclient.EmailHost;
import com.sun.mail.pop3.POP3Store;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;

/**
 *
 * @author ESa10969
 */
public class MailUtils {
    public  static Session   emailSession;
    private static POP3Store emailStore;
    private static String    eml, pass;
    
    public static Session login(String email, String password, String server) {
        try {
            emailSession = Session.getDefaultInstance(EmailHost.getPop3HostAndPort(server));
            emailStore   = (POP3Store) emailSession.getStore("pop3");
            emailStore.connect(email, password);
        } catch (MessagingException ex) {
            Logger.getLogger(MailUtils.class.getName()).log(Level.SEVERE, ex.getMessage(), ex);
            return null;
        }
        eml  = email;
        pass = password;
        return emailSession;
    }
    
    public static List<Message> receiveMails() {
        //Variable definition
        List<Message> emailList = new ArrayList<>();
        Folder emailFolder;
        Message[] messages;
        
        try {
            emailStore   = (POP3Store) emailSession.getStore("pop3");
            emailStore.connect(eml, pass);
            emailFolder = emailStore.getFolder("INBOX");
            emailFolder.open(Folder.READ_ONLY);
            
            messages = emailFolder.getMessages();
            
            emailList.addAll(Arrays.asList(messages));
            emailFolder.close(false);
            emailStore.close();
            
        } catch (MessagingException ex) {
            Logger.getLogger(MailUtils.class.getName()).log(Level.SEVERE, null, ex);
        }
        return emailList;
    }
}
