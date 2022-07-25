package com.gustavo.hroauth.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gustavo.hroauth.entities.User;
import com.gustavo.hroauth.feignclient.UserFeignClint;

@Service
public class UserService {
	
	private static Logger logger = LoggerFactory.getLogger(UserService.class);
	
	@Autowired
	private UserFeignClint userFeignClint;
	
	public User findByEmail(String email) {
		User user  = userFeignClint.findByEmail(email).getBody();
		if(user == null) {
			logger.error("Email not found: " + email);
			throw new IllegalArgumentException("Email not found");
		}
		logger.info("Email found: " + email);
		return user;
	}

}
