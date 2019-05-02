package com.teamsankya.javamailproject;

import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class AttachmentJavaMail 
{
	public static void main( String[] args )
    {
    	 Properties props = new Properties();  
    	 props.put("mail.smtp.auth", "true"); 
    	 props.put("mail.smtp.starttls.enable", "false");  
    	 props.put("mail.smtp.host","mail.teamsankya.com");  
    	 props.put("mail.smtp.port","587");
    	 
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
    		 // Create the message part and set actual message      
    		 BodyPart messageBodyPart = new MimeBodyPart();      
    		 messageBodyPart.setText("This is message body"); 
    		 // Create a multipar message and set text message part     
    		 Multipart multipart = new MimeMultipart();       
    		 multipart.addBodyPart(messageBodyPart); 
    		 // Part two is attachment    
    		 messageBodyPart = new MimeBodyPart();  
    		 DataSource source = new FileDataSource("C:\\Tools\\Notes\\DesignPattern\\DesignPattern.pdf");       
    		 messageBodyPart.setDataHandler(new DataHandler(source));    
    		 messageBodyPart.setFileName("C:\\Tools\\Notes\\DesignPattern\\DesignPattern.pdf");       
    		 multipart.addBodyPart(messageBodyPart); 
    		 // Send the complete message parts        
    		 message.setContent(multipart);        
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


