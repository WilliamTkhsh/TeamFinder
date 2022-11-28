package com.api.playerconnect.models;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "TEAM")
public class TeamModel implements Serializable{
	public enum Elo {UNRANKED, IRON, BRONZE, SILVER, GOLD, PLATINUM, DIAMOND, MASTER, GRANDMASTER, CHALLENGER}    
	public enum Role {TOP, JG, MID, ADC, SUP}
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID id;
	@Column(nullable = false)
	private int n_players;
	@Column(nullable = false)
	private String game_mode;
	@Column(nullable = false)
	private int average_elo;
	@Column(nullable = false)
	private int min_elo;
	@Column(nullable = false)
	private String status;
	@Column(nullable = true)
	private int player_top;
	@Column(nullable = true)
	private int player_jg;
	@Column(nullable = true)
	private int player_mid;
	@Column(nullable = true)
	private int player_adc;
	@Column(nullable = true)
	private int player_sup;
	@Column(nullable = true)
	private String description;
	@Column(nullable = false)
	private LocalDateTime createdDate;
	
	public UUID getId() {
		return id;
	}
	public void setId(UUID id) {
		this.id = id;
	}
	public int getN_players() {
		return n_players;
	}
	public void setN_players(int n_players) {
		this.n_players = n_players;
	}
	public String getGame_mode() {
		return game_mode;
	}
	public void setGame_mode(String game_mode) {
		this.game_mode = game_mode;
	}
	public int getAverage_elo() {
		return average_elo;
	}
	public void setAverage_elo(int average_elo) {
		this.average_elo = average_elo;
	}
	public int getMin_elo() {
		return min_elo;
	}
	public void setMin_elo(int min_elo) {
		this.min_elo = min_elo;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
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
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public LocalDateTime getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(LocalDateTime createdDate) {
		this.createdDate = createdDate;
	}
	
	
}
