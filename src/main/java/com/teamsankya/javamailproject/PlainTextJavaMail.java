package com.teamsankya.javamailproject;


import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class PlainTextJavaMail 
{
    public static void main( String[] args )
    {
    	 Properties props = new Properties();  
    	 props.put("mail.smtp.auth", "true"); 
    	 props.put("mail.smtp.starttls.enable", "false");  
    	 props.put("mail.smtp.host", "mail.teamsankya.com");  
    	 props.put("mail.smtp.port", "587");
    	 
    	 // Get the Session object.   
    	 Session session = Session.getInstance(props, new javax.mail.Authenticator()
    	 { 
    		 @Override
    		 protected PasswordAuthentication getPasswordAuthentication()
    		 {                
    			 return new PasswordAuthentication(Constant.EMAILID,Constant.PSWRD);    
    			 }   
    		 });       
    	 try
    	 {    
    		 // Create a default MimeMessage object.    
    		 Message message = new MimeMessage(session); 
    		 // Set From: header field of the header. 
    		 message.setFrom(new InternetAddress("jasmine.pb@teamsankya.com"));
    		  // Set To: header field of the header.   
    		 message.setRecipients(Message.RecipientType.TO,
    				 InternetAddress.parse("samarpita.das@teamsankya.com")); 
    		 message.setRecipients(Message.RecipientType.TO,
    				 InternetAddress.parse("jashmipaare@gmail.com"));
    		  // Set Subject: header field  
    		 message.setSubject("Testing Subject");  
    		 // Now set the actual message   
    		 message.setText("Hello, this is sample for to check send using JavaMailAPI "); 
    		  // Send message   
    		 Transport.send(message); 
    		 System.out.println("Sent message successfully...."); 
    		 } 
    	      catch (MessagingException e) 
    	 {   
    	    	  e.printStackTrace(); 
    	    	  
    	 }   
    	 } 
    } 
    		 
    		 
    		 