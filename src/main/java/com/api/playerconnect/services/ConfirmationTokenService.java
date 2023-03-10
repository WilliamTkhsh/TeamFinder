package com.api.playerconnect.services;

import org.springframework.stereotype.Service;

import com.api.playerconnect.models.ConfirmationTokenModel;
import com.api.playerconnect.repositories.ConfirmationTokenRepository;

@Service
public class ConfirmationTokenService {
	
	private final ConfirmationTokenRepository confirmationTokenRepository;
	
	
	
	public ConfirmationTokenService(ConfirmationTokenRepository confirmationTokenRepository) {
		super();
		this.confirmationTokenRepository = confirmationTokenRepository;
	}

	public void saveConfirmationToken(ConfirmationTokenModel token) {
		confirmationTokenRepository.save(token);
	}
}
