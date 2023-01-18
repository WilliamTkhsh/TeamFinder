package com.api.playerconnect.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class TeamDto {
	
	@NotNull
	private int n_players;
	@NotBlank
	private String team_name;
	@NotBlank
	private String game_mode;
	@NotNull
	private int min_elo;
	@NotNull
	private int player_top;
	@NotNull
	private int player_jg;
	@NotNull
	private int player_mid;
	@NotNull
	private int player_adc;
	@NotNull
	private int player_sup;
	@Size(max = 30)
	private String description;

	
	public int getN_players() {
		return n_players;
	}
	public void setN_players(int n_players) {
		this.n_players = n_players;
	}
	public String getTeam_name() {
		return team_name;
	}
	public void setTeam_name(String team_name) {
		this.team_name = team_name;
	}
	public String getGame_mode() {
		return game_mode;
	}
	public void setGame_mode(String game_mode) {
		this.game_mode = game_mode;
	}
	public int getMin_elo() {
		return min_elo;
	}
	public void setMin_elo(int min_elo) {
		this.min_elo = min_elo;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getPlayer_top() {
		return player_top;
	}
	public void setPlayer_top(int player_top) {
		this.player_top = player_top;
	}
	public int getPlayer_jg() {
		return player_jg;
	}
	public void setPlayer_jg(int player_jg) {
		this.player_jg = player_jg;
	}
	public int getPlayer_mid() {
		return player_mid;
	}
	public void setPlayer_mid(int player_mid) {
		this.player_mid = player_mid;
	}
	public int getPlayer_adc() {
		return player_adc;
	}
	public void setPlayer_adc(int player_adc) {
		this.player_adc = player_adc;
	}
	public int getPlayer_sup() {
		return player_sup;
	}
	public void setPlayer_sup(int player_sup) {
		this.player_sup = player_sup;
	}

	

	
}
