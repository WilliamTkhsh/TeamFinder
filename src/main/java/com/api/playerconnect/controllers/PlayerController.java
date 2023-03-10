package com.api.playerconnect.controllers;

import java.time.LocalDateTime;
import java.time.ZoneId;
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

import com.api.playerconnect.dtos.PlayerDto;
import com.api.playerconnect.dtos.TeamDto;
import com.api.playerconnect.models.PlayerModel;
import com.api.playerconnect.models.TeamModel;
import com.api.playerconnect.services.PlayerService;

import jakarta.validation.Valid;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/player")
public class PlayerController {
	
	final PlayerService playerService;
	
	public PlayerController(PlayerService playerService) {
		this.playerService = playerService;
	}
	
	@PostMapping
	public ResponseEntity<Object> savePlayer(@RequestBody @Valid PlayerDto playerDto) {
		var playerModel = new PlayerModel();
		BeanUtils.copyProperties(playerDto, playerModel);
		playerModel.setCreatedDate(LocalDateTime.now(ZoneId.of("UTC")));
		playerModel.setStatus("Procurando Time");
		return ResponseEntity.status(HttpStatus.CREATED).body(playerService.save(playerModel));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Object> getPlayer(@PathVariable(value = "id") Long id){
		Optional<PlayerModel> playerOptional = playerService.findById(id);
		if(!playerOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Player não encontrado.");
		}
		return ResponseEntity.status(HttpStatus.OK).body(playerOptional.get());
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deletePlayer(@PathVariable(value = "id") Long id){
		Optional<PlayerModel> playerOptional = playerService.findById(id);
		if(!playerOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Player não encontrado.");
		}
		playerService.delete(playerOptional.get());
		return ResponseEntity.status(HttpStatus.OK).body("Player deletado com sucesso!");
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Object> updatePlayer(@PathVariable(value = "id") Long id, 
											@RequestBody @Valid PlayerDto playerDto){
		Optional<PlayerModel> playerOptional = playerService.findById(id);
		if(!playerOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Player não encontrado.");
		}
		var playerModel = playerOptional.get();
		
		playerModel.setNickname(playerDto.getNickname());
		playerModel.setElo(playerDto.getElo());
		playerModel.setGame_mode(playerDto.getGame_mode());
		playerModel.setPosition_1(playerDto.getPosition_1());
		playerModel.setPosition_2(playerDto.getPosition_2());
		playerModel.setDescription(playerDto.getDescription());
		
		return ResponseEntity.status(HttpStatus.OK).body(playerService.save(playerModel));
	}
	
}
