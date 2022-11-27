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
	public static final int UNRANKED = 0;
	public static final int IRON = 1;
	public static final int BRONZE = 2;
	public static final int SILVER = 3;
	public static final int GOLD = 4;
	public static final int PLATINUM = 5;
	public static final int DIAMOND = 6;
	public static final int MASTER = 7;
	public static final int GRANDMASTER = 8;
	public static final int CHALLENGER = 9;
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID id;
	@Column(nullable = false, unique = true)
	private String nickname;
	@Column(nullable = false)
	private int elo;
	@Column(nullable = false)
	private String game_type;
	@Column(nullable = false)
	private String position_1;
	@Column(nullable = true)
	private String position_2;
	@Column(nullable = false)
	private int status;
	@Column(nullable = true)
	private TeamModel team_id;
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
	public String getGame_type() {
		return game_type;
	}
	public void setGame_type(String game_type) {
		this.game_type = game_type;
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
	public TeamModel getTeam_id() {
		return team_id;
	}
	public void setTeam_id(TeamModel team_id) {
		this.team_id = team_id;
	}
	public LocalDateTime getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(LocalDateTime createdDate) {
		this.createdDate = createdDate;
	}
	
	
	
	
	
	
	
}
