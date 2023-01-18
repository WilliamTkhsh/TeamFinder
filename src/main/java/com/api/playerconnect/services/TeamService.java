package com.api.playerconnect.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.api.playerconnect.models.PlayerModel;
import com.api.playerconnect.models.TeamModel;
import com.api.playerconnect.repositories.TeamRepository;

import jakarta.transaction.Transactional;

@Service
public class TeamService {

	final TeamRepository teamRepository;
	
	public TeamService(TeamRepository teamRepository) {
		this.teamRepository = teamRepository;
	}
	
	@Transactional
	public TeamModel save(TeamModel teamModel) {
		return teamRepository.save(teamModel);
	}

	public List<TeamModel> findAll() {
		return teamRepository.findAll();
	}

	@Transactional
	public void delete(TeamModel teamModel) {
		teamRepository.delete(teamModel);
	}
	
	public Optional<TeamModel> findById(UUID id) {
		return teamRepository.findById(id);
	}


}
