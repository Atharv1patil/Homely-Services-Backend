package com.homely.homelyservices.controller;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import com.homely.homelyservices.model.User;
import com.homely.homelyservices.repository.UserRepository;
import com.homely.homelyservices.service.UserService;

@CrossOrigin ("*")
@RestController
@RequestMapping("/api")
public class UserController {
	
	Random random = new Random(10000);
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private UserRepository userRepository;

	@PostMapping("/registerUser")
	private String registerUser(@RequestBody User user) {

		userService.addUser(user);
		System.out.println("user Added");

		return "added successfully";

	}
	@GetMapping("/email/{name}")
    public String getEmailByUsername(@PathVariable String name) {
        User user = userRepository.findByname(name);
            return user.getEmail();
	}

	@GetMapping("/getUser")
	public List<User> getUser() {
		return userService.getUser();
	}

	
	 @PostMapping("/login") 
	 public User findUser(@RequestBody User user) {
	  
	  User userObj=userService.findUser(user);
	  return userObj;
	    
	  }
	 
	 @PostMapping("/checkEmail") 
	 public User findEmail(@RequestBody User user) {
	  
	  User userObj=userService.findEmail(user);
	  return userObj;
	    
	  }
	 
	 
	 @PostMapping("/getUserByRoleId")
	 public List<User> getUserByRoleId(@RequestBody User user) {
		 
		 return userService.findByRoleId(user);
	 }
	 
//	 @PutMapping("/updateUser")
//	 public String updateUser(@RequestBody User user)
//	 {
//	 System.out.print("fun call");
//	  userService.updateUser(user) ;
//	  return "Data is updated successfully";
//		}
	 @PutMapping("/updateUser")
	 public ResponseEntity<String> updateUser(@RequestBody User user) {
	     userService.updateUser(user);
	     return ResponseEntity.ok("User updated successfully");
	 }


	  
	  
	  
//		User tr = this.userService.findEmail(user);
//		if (tr != null) {
//			int otp = random.nextInt(999999);
//		
//			String subject = "Message from homely";
//			String message="" ;
//			if(user.getStatus().equals("InActive")) {
//			 message = "Because of some irrelevant activity from you so admin temporary block your"
//					+ " account for any queries contact admin admin@homely.com";
//			}else {
//				message = "admin unblock  your"
//						+ " account now you can access your account you email is :"+tr.getEmail()+" for any queries contact admin admin@homely";
//			}
//			String to = tr.getEmail();
////			otp1.setOtp(otp);
//
//			boolean flag = this.userService.sendEmail(subject, message, to);
//
//			if (flag == true) {
//				
////				otp1.setStatus("success");
//				return "success";
//			} else {
//
//			
//				
//				return "Something went wrong";
//			}
//		} else {
//
//			System.out.println("not successfull");
			
	

	  //return "Updated successfully";
	 

	 @PostMapping("/getUserByEmail")
	 public User getUserById(@RequestBody User user ) {
		 User userObj = userService.findEmail(user);
		 return userObj;
	 }

	 @PostMapping("/findUserById")
	 public User getUserByUserId(@RequestBody User user) {
		 
		 return userService.findByUserId(user.getUserid());
	 }

	 
	 @PostMapping("/forgetPass")
		public String findPassword(@RequestBody User user) {

			//OTP otp1 = new OTP();

			User tr = this.userService.findEmail(user);
			if (tr != null) {
				
				int otp = random.nextInt(999999);
			System.out.println("otp= "+ otp);
				String subject = "set password";
				String message = "Your password is = " + tr.getPassword() +" Please do no share with anyone";
				String to = tr.getEmail();
//				otp1.setOtp(otp);

				boolean flag = this.userService.sendEmail(subject, message, to);

				if (flag == true) {
					
//					otp1.setStatus("success");
					return "success";
				} else {

				
					
					return "Something went wrong";
				}
			} else {

				System.out.println("not successfull");
				return "Your email is not found";
			}

		}
	 
	 	 
}
