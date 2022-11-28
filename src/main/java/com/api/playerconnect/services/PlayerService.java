package com.api.playerconnect.services;

import org.springframework.stereotype.Service;

import com.api.playerconnect.models.PlayerModel;
import com.api.playerconnect.repositories.PlayerRepository;

import jakarta.transaction.Transactional;

@Service
public class PlayerService {
	
	final PlayerRepository playerRepository;
	
	public PlayerService(PlayerRepository playerRepository) {
		this.playerRepository = playerRepository;
	}
	
	@Transactional
	public PlayerModel save(PlayerModel playerModel) {
		return playerRepository.save(playerModel);
	}
}
