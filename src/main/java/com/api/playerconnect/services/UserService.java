package com.api.playerconnect.services;

import java.time.LocalDateTime;
import java.util.UUID;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.api.playerconnect.models.ConfirmationTokenModel;
import com.api.playerconnect.models.UserModel;
import com.api.playerconnect.repositories.UserRepository;


@Service
public class UserService implements UserDetailsService {
	
	private final static String USER_NOT_FOUND_MSG = "user with email %s not found";
	private final UserRepository userRepository;
	private final BCryptPasswordEncoder bCryptPasswordEncoder;
	private final ConfirmationTokenService confirmationTokenService;
	
	public UserService(UserRepository userRepository, BCryptPasswordEncoder bCryptPasswordEncoder,
			ConfirmationTokenService confirmationTokenService) {
		super();
		this.userRepository = userRepository;
		this.bCryptPasswordEncoder = bCryptPasswordEncoder;
		this.confirmationTokenService = confirmationTokenService;
	}

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		return userRepository.findByEmail(email)
				.orElseThrow(() -> new UsernameNotFoundException(String.format(USER_NOT_FOUND_MSG, email)));
	}
	
	public String signUpUser(UserModel userModel) {
		boolean userExists = userRepository
				.findByEmail(userModel.getEmail())
				.isPresent();
		
		if (userExists) {
			throw new IllegalStateException("email already taken");
		}
		
		String encodedPassword = bCryptPasswordEncoder.encode(userModel.getPassword());
		
		userModel.setPassword(encodedPassword);
		
		userRepository.save(userModel);
		
		String token = UUID.randomUUID().toString();
		
		ConfirmationTokenModel confirmationToken = new ConfirmationTokenModel(
				token,
				LocalDateTime.now(),
				LocalDateTime.now().plusMinutes(15),
				userModel
				);
		
		confirmationTokenService.saveConfirmationToken(confirmationToken);
		
		return token;
	}
}
