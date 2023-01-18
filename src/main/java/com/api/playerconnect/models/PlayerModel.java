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
@Table(name = "PLAYER")
public class PlayerModel implements Serializable{
	public enum Elo {UNRANKED, IRON, BRONZE, SILVER, GOLD, PLATINUM, DIAMOND, MASTER, GRANDMASTER, CHALLENGER}    
	public enum Role {TOP, JG, MID, ADC, SUP}
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID id;
	@Column(nullable = false, unique = true)
	private String nickname;
	@Column(nullable = false)
	private int elo;
	@Column(nullable = false)
	private String game_mode;
	@Column(nullable = false)
	private String position_1;
	@Column(nullable = true)
	private String position_2;
	@Column(nullable = false)
	private int status;
	@Column(nullable = true)
	private TeamModel team;
	@Column(nullable = false)
	private String description;
	@Column(nullable = false)
	private LocalDateTime createdDate;
	
	public UUID getId() {
		return id;
	}
	public void setId(UUID id) {
		this.id = id;
	}
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
	public String getPosition_1() {
		return position_1;
	}
	public void setPosition_1(String position_1) {
		this.position_1 = position_1;
	}
	public String getPosition_2() {
		return position_2;
	}
	public void setPosition_2(String position_2) {
		this.position_2 = position_2;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public TeamModel getTeam() {
		return team;
	}
	public void setTeam_id(TeamModel team) {
		this.team = team;
	}
	public LocalDateTime getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(LocalDateTime createdDate) {
		this.createdDate = createdDate;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
	
	
	
	
}