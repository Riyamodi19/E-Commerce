package com.grownited.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class MailService {
	@Autowired
	JavaMailSender mailSender;

	public void sendWelcomeMail(String email, String firstName) {
		String subject = "Welcome to E-Commerce";
		String body = "Hey " + firstName
				+ ", We're excited to have you on board. If you have any questions, feel free to reach out – we’re here to help!";
		String from = "rmodi6128@gmail.com";

		// logic
		SimpleMailMessage message = new SimpleMailMessage();

		message.setFrom(from);
		message.setTo(email);
		message.setSubject(subject);
		message.setText(body);

		mailSender.send(message);

	}
	public void sendOtpForForgetPassword(String email, String firstName,String otp) {
		String subject = "OTP for Resetpassword";
		String body = "Hey " + firstName
				+ ", It seems you have request for forget password, please use below otp for reset password. If not then simply ignore the message!OTP:"+otp;
		String from = "rmodi6128@gmail.com";

		// logic
		SimpleMailMessage message = new SimpleMailMessage();

		message.setFrom(from);
		message.setTo(email);
		message.setSubject(subject);
		message.setText(body);

		mailSender.send(message);

	}
	public void sendPaymentStatusMail(String email, String firstName, Double amount, String last4Digits) {
		 
			String subject = "MRSH Ashion Payment Confirmation";

		    String body = "Hey " + firstName
		            + ",\n\nYour payment of ₹" + amount + " was successfully processed."
		            + "\nCard Ending With: **** **** **** " + last4Digits
		            + "\n\nThank you for booking your Order with MRSH Ashion!"
		            + "\n\nWe’re here to help if you need any further assistance."
		            + "\n\n\nBest regards,\nMRSH ashoin Team";

		    String from = "rmodi6128@gmail.com";

		    SimpleMailMessage message = new SimpleMailMessage();

		    message.setFrom(from);  // This line should be setFrom, not setText
		    message.setTo(email);
		    message.setSubject(subject);
		    message.setText(body);

		    mailSender.send(message);
			
		}

}
