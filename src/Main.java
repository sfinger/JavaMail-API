/*
 * Programmer: Sylvia Finger
 * 
 * Using the JavaMail API, create an application that sends an email. 
 * Find an email server you can connect to (such as gmail) and use it 
 * to test your program. Include a short paragraph about how your program
 *  works to demonstrate your understanding of the underlying code. 
 *  (10 pts)
 * 
 * Resources: 
 * 		https://www.tutorialspoint.com/javamail_api/javamail_api_core_classes.htm
 */


import java.util.Scanner;
import javax.mail.MessagingException;
//Paragraph is on the SendEmail script at the bottom

public class Main {
	
	public static void main(String[] args) throws MessagingException {
		Scanner oScan = new Scanner(System.in);
		
		System.out.println("Enter your gmail: ");
		String username = oScan.nextLine();
		
		System.out.println("Enter your password: ");
		String password = oScan.nextLine();
		
		System.out.println("Enter the email address of the recipient: ");
		String emailTo = oScan.nextLine();
		
		System.out.println("Enter the subject of the email: ");
		String subject = oScan.nextLine();
		
		System.out.println("Enter the body of the email: ");
		String body = oScan.nextLine();
		
		new SendEmail(username, password, emailTo, subject, body);
		
		oScan.close();
	
	}
}
