package com.bannershallmark.bean;

import java.util.List;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
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

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;

@Controller
public class SendMail {
	
	private String techEmails;
	
    public  void sendMail(String fromEmail,String frompassword,String toEmail ,String randomId,String smtp,String port,String status) {
	
    	 /*System.out.println("fromgmail="+fromEmail);
    	 System.out.println("frompassword="+frompassword);	
    	 System.out.println("smtp="+smtp);
    	 System.out.println("port="+port);
    	 System.out.println("status="+status);*/
    	 
    	 
        // Recipient's email ID needs to be mentioned.
         String to = toEmail;
        // Sender's email ID needs to be mentioned
        String from = fromEmail;

        // Assuming you are sending email from through gmails smtp
      //  String host = "smtp.gmail.com";
        // Get system properties
        Properties properties = System.getProperties();
        // Setup mail server
        properties.put("mail.smtp.host",smtp);
        properties.put("mail.smtp.port", port);
        properties.put("mail.smtp.starttls.enable",status);
        properties.put("mail.smtp.auth",status);

        // Get the Session object.// and pass username and password
        Session session = Session.getInstance(properties, new javax.mail.Authenticator() {

            protected PasswordAuthentication getPasswordAuthentication() {

                return new PasswordAuthentication(fromEmail,frompassword);

            }

        });
        // Used to debug SMTP issues
      //  session.setDebug(true);
        try {
            // Create a default MimeMessage object.
            MimeMessage message = new MimeMessage(session);

            // Set From: header field of the header.
            message.setFrom(new InternetAddress(from));

            // Set To: header field of the header.
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
            
            // Set Subject: header field
            message.setSubject("Reset password requested - Banners Hallmark");

           // Now set the actual message               
//            message.setContent(
//                    "<h2>Reset password request </h2>" + 
//                    "<h3> Plaese click on the Blue Link to reset password \n </h3> "+
//                    " <a  href='http://localhost:8080/Bannershallmark/resetPassword/"+randomId+"'>" +"Reset your password</a>" + randomId,
//                    "text/html; charset=utf-8");
//            
            // Now set the actual message               
            message.setContent(
                    
                    "<h3> Plaese click on the link below to reset password \n </h3> "+
//                    "<a href='https://hallmark.swizznet.com/Bannershallmark/users/reset/resetPassword/"+randomId+"'>https://hallmark.swizznet.com/Bannershallmark/users/reset/resetPassword/"+randomId+"</a>",
//						"<a href='http://localhost:8080/Bannershallmark/users/reset/resetPassword/"+randomId+"'>http://localhost:8080/Bannershallmark/users/reset/resetPassword/"+randomId+"</a>",
						"<a href='http://webapp.bannershallmark.com/LiveTest/users/reset/resetPassword/"+randomId+"'>http://webapp.bannershallmark.com/LiveTest/users/reset/resetPassword/"+randomId+"</a>",
                    "text/html; charset=utf-8");
            System.out.println("sending...");
            // Send message
            Transport.send(message);
            System.out.println("Sent message successfully....");
        } catch (MessagingException mex) {
            mex.printStackTrace();
        }

    }
    
    
    
   public void sendMailWithAttachment(String fromEmail,String frompassword,String toEmail ,String randomId,String smtp,String port,String status,DataSource attachment,String fileName) {
	   
	   // Recipient's email ID needs to be mentioned.
       String to = toEmail;
      // Sender's email ID needs to be mentioned
      String from = fromEmail;

      // Assuming you are sending email from through gmails smtp
    //  String host = "smtp.gmail.com";
      // Get system properties
      Properties properties = System.getProperties();
      // Setup mail server
      properties.put("mail.smtp.host",smtp);
      properties.put("mail.smtp.port", port);
      properties.put("mail.smtp.starttls.enable",status);
      properties.put("mail.smtp.auth",status);

      // Get the Session object.// and pass username and password
      Session session = Session.getInstance(properties, new javax.mail.Authenticator() {

          protected PasswordAuthentication getPasswordAuthentication() {

              return new PasswordAuthentication(fromEmail,frompassword);

          }

      });
      // Used to debug SMTP issues
    //  session.setDebug(true);
      try {
          // Create a default MimeMessage object.
          MimeMessage message = new MimeMessage(session);

          // Set From: header field of the header.
          message.setFrom(new InternetAddress(from));

          // Set To: header field of the header.
          message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
          
          // Set Subject: header field
          message.setSubject("Evaluation Result");

          // Inserting Attachments  

          MimeBodyPart mbp1 = new MimeBodyPart(); 
          mbp1.setContent("<h3> Employee's Evaluation Result </h3>", "text/html; charset=utf-8");
          MimeBodyPart mbp2 = new MimeBodyPart();
          mbp2.setDataHandler(new DataHandler(attachment));   
          mbp2.setFileName(fileName); 

         
          // Set the Date: header  
          message.setSentDate(new java.util.Date()); 
          
          // Now set the actual message               
          /*message.setContent(
                  "<h3> Employee's Evaluation Result </h3> \\n ",
                  "text/html; charset=utf-8");*/
          
          Multipart mp = new MimeMultipart();
          mp.addBodyPart(mbp1);   
          mp.addBodyPart(mbp2);   
          message.setContent(mp);   
          //message.saveChanges(); 
          
          System.out.println("sending...");
          // Send message
          Transport.send(message);
          System.out.println("Sent message successfully....");
      } catch (MessagingException mex) {
          mex.printStackTrace();
      }
	   
   }
		 

}