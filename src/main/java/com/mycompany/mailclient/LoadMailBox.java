/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.mailclient;

import com.mycompany.mailclient.utils.MailUtils;
import java.awt.Component;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JLabel;
import javax.swing.JList;

/**
 *
 * @author ESa10969
 */
public class LoadMailBox {
    public static void displayEmailList(JList messageList) {
        //Variable definition
        List<Message> emailList;
        
        emailList = MailUtils.receiveMails();
        messageList.setListData(new Vector<Message>(emailList));
        messageList.setCellRenderer(new DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                Component renderer = super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
                if (renderer instanceof JLabel && value instanceof Message) {
                    try {
                        // Here value will be of the Type 'CD'
                        ((JLabel) renderer).setText(((Message) value).getFrom()[0].toString() + " --> " + ((Message) value).getSubject());
                    } catch (MessagingException ex) {
                        Logger.getLogger(LoadMailBox.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                return renderer;
            }
        });
    }
}
