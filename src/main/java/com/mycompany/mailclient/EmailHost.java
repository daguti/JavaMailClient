/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.mailclient;

import java.util.Properties;

/**
 *
 * @author ESa10969
 */
public class EmailHost {
 
    public static Properties getPop3HostAndPort(String email) {
        //Variable definition
        Properties props = new Properties();
        
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        
        switch(email) {
            case "Gmail":
		props.put("mail.pop3s.host", "pop.gmail.com");
		props.put("mail.pop3s.port", "995");
            break;
            case "Hotmail":
                props.put("mail.pop3s.host", "pop3.live.com");
		props.put("mail.pop3s.port", "995");
            break;
            case "Yahoo":
                props.put("mail.pop3s.host", "pop.mail.yahoo.com");
		props.put("mail.pop3s.port", "995");
            break;
        }
        return props;
    }
    
    public static Properties getSmtpHostAndPort(String email) {
        //Variable definition
        Properties props = new Properties();
        
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        
        switch(email) {
            case "@gmail.com":
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");
            break;
            case "@hotmail.com":
                props.put("mail.smtp.host", "smtp.live.com");
		props.put("mail.smtp.port", "25");
            break;
            case "yahoo.com":
                props.put("mail.smtp.host", "smtp.mail.yahoo.com");
		props.put("mail.smtp.port", "25");
            break;
        }
        return props;
    }
}
