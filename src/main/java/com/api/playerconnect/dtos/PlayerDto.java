package com.api.playerconnect.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class PlayerDto {

	@NotBlank
	private String nickname;
	@NotNull
	private int elo;
	@NotBlank
	private String game_mode;
	@NotNull
	private int position_1;
	@Size(max = 30)
	private String description;
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public int getElo() {
		return elo;
	}
	public void setElo(int elo) {
		this.elo = elo;
	}
	public String getGame_mode() {
		return game_mode;
	}
	public void setGame_mode(String game_mode) {
		this.game_mode = game_mode;
	}
	public int getPosition_1() {
		return position_1;
	}
	public void setPosition_1(int position_1) {
		this.position_1 = position_1;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	


}
