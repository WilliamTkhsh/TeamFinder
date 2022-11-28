package com.api.playerconnect.controllers;

import java.time.LocalDateTime;
import java.time.ZoneId;

import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.playerconnect.dtos.PlayerDto;
import com.api.playerconnect.models.PlayerModel;
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
		return ResponseEntity.status(HttpStatus.CREATED).body(playerService.save(playerModel));
	}
}
