package com.homely.homelyservices.service;

import javax.mail.PasswordAuthentication;
import java.util.List;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.homely.homelyservices.model.User;
import com.homely.homelyservices.repository.UserRepository;

import jakarta.persistence.EntityNotFoundException;

@CrossOrigin("*")
@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepository userRepository;

	//registration
		@Override
		public void addUser(User user) {
			// TODO Auto-generated method stub
			
			userRepository.save(user);
			
		}

		
		//get all users
		@Override
		public List<User> getUser() {
			// TODO Auto-generated method stub
			return userRepository.findAll();
		}

		
		//for user login
		@Override
		public User findUser(User user) {
			
			return userRepository.findByEmailAndPassword(user.getEmail(), user.getPassword());
		}

		
		//send email to user
		@Override
		public User findEmail(User user) {
			// TODO Auto-generated method stub
			return userRepository.findByEmail(user.getEmail());
		}
		
		
		//find user on basis of role
		@Override
		public List<User> findByRoleId(User user) {
			
			return userRepository.findByRoleId(user.getRoleId());
		}

		
		// update user block unblock him
//		@Override
//		public void updateUser(User user) {
//			// TODO Auto-generated method stub
//			
//			userRepository.save(user);
//			
//		}
//		@Override
//		public void updateUser(User user) {
//		    User existingUser = userRepository.findById(user.getUserid())
//		            .orElseThrow(() -> new EntityNotFoundException("User not found"));
//		    existingUser.setName(user.getName());
//		    // Update other fields as needed
//		    userRepository.save(existingUser);
//		}
		@Override
		public void updateUser(User user) {
		    userRepository.findById(user.getUserid()).ifPresentOrElse(
		        existingUser -> {
		            existingUser.setName(user.getName());
		            existingUser.setStatus(user.getStatus()); // Update the status field
		            // Update other fields as needed
		            userRepository.save(existingUser);
		        },
		        () -> {
		            throw new EntityNotFoundException("User not found");
		        }
		    );
		}



		
		//find user on basis on role
		@Override
		public User findByUserId(int userId) {
			// TODO Auto-generated method stub
			return userRepository.findByUserid(userId);
		}


		
		//Email Implementation
		@Override
		public boolean sendEmail(String subject, String message, String to)
		{
			boolean bool=false;
			String from="1605.sainya@gmail.com";
			String host="smtp.gmail.com";
			
			//get system property
			Properties properties=System.getProperties();
			System.out.println("PROPERTIES "+properties);
			
			//host set
			
			properties.put("mail.smtp.host",host);
			properties.put("mail.smtp.port","465");
			properties.put("mail.smtp.ssl.enable","true");
			properties.put("mail.smtp.auth","true");
			
			//step1: to get the session object
			
			Session session=Session.getInstance(properties,new Authenticator() {
				@Override
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication("1605.sainya@gmail.com","Pass@123");
				}}
				);
			
			session.setDebug(true);
			
			MimeMessage m=new MimeMessage(session);
			
			try {
				
				m.setFrom(from);
				
				m.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
				
				m.setSubject(subject);
				
				//adding text
				m.setText(message);
				
				//step3 send the message 
				Transport.send(m);
				System.out.println("sent success......");
				bool=true;
				
				
			}catch(Exception e) 
			{
				e.printStackTrace();
			}
			
			return bool;
		}
}
