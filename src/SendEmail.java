import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


public class SendEmail {
	private String username;
	private String password; 
	private String emailTo;
	private String subject;
	private String body;
	
	public SendEmail(String username, String password, String emailTo, String subject, String body) {
		super();
		this.username = username;
		this.password = password;
		this.emailTo = emailTo;
		this.subject = subject;
		this.body = body;
		
		try{
			Properties properties = System.getProperties();
			properties.setProperty("mail.smtp.host", "smtp.gmail.com");
			properties.put("mail.smtp.socketFactory.port", 465);
			properties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
			properties.put("mail.smtp.auth", "true"); 
			properties.put("mail.smtp.port", 465);
			
			Authenticator auth = new SMTPAuthenticator();
			Session session = Session.getDefaultInstance(properties, auth);
			MimeMessage message = new MimeMessage(session);
	
			message.setFrom(new InternetAddress(username));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(emailTo));
			message.setSubject(subject);
			message.setText(body);
			
			Transport.send(message);
			System.out.println("Your email has been sent!");
		}	
			
		catch (MessagingException e) {
			e.printStackTrace();}  

	}

	class SMTPAuthenticator extends javax.mail.Authenticator { 
		public PasswordAuthentication getPasswordAuthentication() { 
			return new PasswordAuthentication(username, password); 
			}
	}
}

/*
 * To begin the program, we have to initialize the properties of the System (Line 29). 
 * We include this in a try/catch so the program doesn't crash when a Messaging Exception occurs.
 * Line 30 - we set the property to the SMTP server (arg1), and the gmail server (arg2)
 * Line 31 - we use the SocketFactory to connect to port 465
 * Line 32 - here we define the class that implements the java.net.SocketFactory interface (arg1), and the import statement (arg2)
 * Line 33 - here we authenticate the user using the Authenticate method
 * Line 34 - we initialize the SMTP server for port 465
 * 
 * On line 36, we initialize a new instance of our class at the bottom. Since the PasswordAuthentication method is a 
 * 		subclass of Authenticator, we set the username and password in the method, so we can fulfill the 
 * 		parameters of the Session.getDefaultInstance, which are properties and authenticator.
 * 
 * On line 38, we initialize a new MimeMessage. This is a class with abstract methods that make it easy to format a message.
 * 		Notice how message.addRecipient's first argument is Message.RecipientType.TO, this defines whether you are setting an address in the 
 * 			TO, BCC, and CC sections of an email.
 * 
 * Finally, on line 45, we use the Transport class to send the message, using the function send, with our MimeMessage parameter.
 * 
 */ 
