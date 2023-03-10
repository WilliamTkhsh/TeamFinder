package com.api.playerconnect.services;

import java.util.Optional;
import java.util.UUID;

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

	public Optional<PlayerModel> findById(Long id) {
		return playerRepository.findById(id);
	}

	@Transactional
	public void delete(PlayerModel playerModel) {
		playerRepository.delete(playerModel);
	}
}
