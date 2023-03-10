package com.api.playerconnect.controllers;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.playerconnect.dtos.TeamDto;
import com.api.playerconnect.models.PlayerModel;
import com.api.playerconnect.models.TeamModel;
import com.api.playerconnect.services.TeamService;

import jakarta.validation.Valid;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/team")
public class TeamController {
	final TeamService teamService;
	
	public TeamController(TeamService teamService) {
		this.teamService = teamService;
	}
	
	@PostMapping
	public ResponseEntity<Object> saveTeam(@RequestBody @Valid TeamDto teamDto) {
		var teamModel = new TeamModel();
		BeanUtils.copyProperties(teamDto, teamModel);
		teamModel.setCreatedDate(LocalDateTime.now(ZoneId.of("UTC")));
		teamModel.setStatus("Buscando Player");
		teamModel.setAverage_elo(calcularMedia(teamModel.getPlayer_top(), teamModel.getPlayer_jg(),teamModel.getPlayer_mid(),teamModel.getPlayer_adc(),teamModel.getPlayer_sup()));
		return ResponseEntity.status(HttpStatus.CREATED).body(teamService.save(teamModel));
	}
	
	@GetMapping
	public ResponseEntity<List<TeamModel>> getAllParkingSpots(){
		return ResponseEntity.status(HttpStatus.OK).body(teamService.findAll());
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deleteTeam(@PathVariable(value = "id") UUID id){
		Optional<TeamModel> teamOptional = teamService.findById(id);
		if(!teamOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Time não encontrado.");
		}
		teamService.delete(teamOptional.get());
		return ResponseEntity.status(HttpStatus.OK).body("Time deletado com sucesso!");
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Object> updateTeam(@PathVariable(value = "id") UUID id, 
											@RequestBody @Valid TeamDto teamDto){
		Optional<TeamModel> teamOptional = teamService.findById(id);
		if(!teamOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Time não encontrado.");
		}
		var teamModel = teamOptional.get();
		
		teamModel.setTeam_name(teamDto.getTeam_name());
		teamModel.setGame_mode(teamDto.getGame_mode());
		teamModel.setMin_elo(teamDto.getMin_elo());
		teamModel.setPlayer_top(teamDto.getPlayer_top());
		teamModel.setPlayer_jg(teamDto.getPlayer_jg());
		teamModel.setPlayer_mid(teamDto.getPlayer_mid());
		teamModel.setPlayer_adc(teamDto.getPlayer_adc());
		teamModel.setPlayer_sup(teamDto.getPlayer_sup());
		teamModel.setDescription(teamDto.getDescription());
		teamModel.setAverage_elo(calcularMedia(teamModel.getPlayer_top(), teamModel.getPlayer_jg(),teamModel.getPlayer_mid(),teamModel.getPlayer_adc(),teamModel.getPlayer_sup()));
		
		return ResponseEntity.status(HttpStatus.OK).body(teamService.save(teamModel));
	}
	
	
	public int calcularMedia(int elo_top, int elo_jg, int elo_mid, int elo_adc, int elo_sup) {
		return (elo_top + elo_jg + elo_mid + elo_adc + elo_sup)/5; 
	}
}
