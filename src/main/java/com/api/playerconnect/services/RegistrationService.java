package com.api.playerconnect.services;

import org.springframework.stereotype.Service;

import com.api.playerconnect.models.AppUserRole;
import com.api.playerconnect.models.UserModel;

@Service
public class RegistrationService {
	
	private final UserService userService;
	private final EmailValidator emailValidator;
	
	public RegistrationService(UserService userService, EmailValidator emailValidator) {
		super();
		this.userService = userService;
		this.emailValidator = emailValidator;
	}

	public String register(RegistrationRequest request) {
		boolean isValidEmail = emailValidator.test(request.getEmail());
		
		if (!isValidEmail) {
			throw new IllegalStateException("Email not Valid");
		}
		
		return userService.signUpUser(
				new UserModel(
						request.getEmail(),
						request.getPassword(),
						AppUserRole.USER
						)
				);
	}
}
