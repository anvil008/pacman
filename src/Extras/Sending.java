package Extras;

import java.util.Properties;
import javax.activation.*;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.Message;

public class Sending{

 /*	Method to send the Email
  * requires: valid variables (from, to, password, subject, content)
  * ensures:  establishes a connection to the email address and sends the desired email
  */
 public static void Send(String from,String password,String to, String CC,String subject,String content,String filepath){
	 final String username = from;
	 final String pass = password;
	 Properties props = new Properties();
	    props.put("mail.smtp.auth", true);
	    props.put("mail.smtp.starttls.enable", true);
	    props.put("mail.smtp.host", "smtp.gmail.com");
	    props.put("mail.smtp.port", "587");


	    Session session = Session.getInstance(props,
	            new javax.mail.Authenticator() {
	                protected PasswordAuthentication getPasswordAuthentication() {
	                    return new PasswordAuthentication(username, pass);
	                }
	            });

	    /* builds the message
	     * requires: all the variables (from, password, to, subject and content) to be valid
	     * ensures:  that you can send a message to desired email without attatchment
	     */
	    try {
	        String fileName = (filepath.substring(filepath.lastIndexOf("\\") + 1));
	        Message message = new MimeMessage(session);
	        message.setFrom(new InternetAddress(from));
	        message.setRecipients(Message.RecipientType.TO,
	                InternetAddress.parse(to));
	        message.setSubject(subject);
	        message.setText(content);
	        message.addRecipients(Message.RecipientType.CC, InternetAddress.parse(CC));

	        props.put("mail.smtp.auth", true);
		    props.put("mail.smtp.starttls.enable", true);
		    props.put("mail.smtp.host", "smtp.gmail.com");
		    props.put("mail.smtp.port", "587");
	        /* adds the attachment if the filepath is not empty
	         * requires: a variable called filepath
	         * ensures:  that if there is a non-empty filepath then it is added to the message
	         */
	        if (!filepath.isEmpty()){
	        MimeBodyPart messageBodyPart = new MimeBodyPart();

	        Multipart multipart = new MimeMultipart();
	        {messageBodyPart = new MimeBodyPart();
	        String file = filepath;
	        DataSource source = new FileDataSource(file);
	        messageBodyPart.setDataHandler(new DataHandler(source));
	        messageBodyPart.setFileName(fileName);
	        multipart.addBodyPart(messageBodyPart);
	        message.setContent(multipart);
	        }

	        }


	        /* sends the message built and lets user know what is happening
	         * requires: a variable called message
	         * ensures:  message is sent and that before it is sent the word "Sending" is printed and after it is sent "Done" is printed
	         */
	        System.out.println("Sending");
	        Transport.send(message);
	        System.out.println("Done");

	    } catch (MessagingException e) {
	        e.printStackTrace();
	    }
	  }


}
