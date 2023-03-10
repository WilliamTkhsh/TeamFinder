package com.api.playerconnect.models;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;


@Entity
@Table(name = "PLAYER")
public class PlayerModel implements Serializable{
	public enum Elo {UNRANKED, IRON, BRONZE, SILVER, GOLD, PLATINUM, DIAMOND, MASTER, GRANDMASTER, CHALLENGER};
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(nullable = false, unique = true)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@OneToOne
	private UserModel user;
	
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
	private String status;
	
	@Column(nullable = true)
	@OneToMany(mappedBy = "player")
	private List<TeamModel> teamCreated;
	
	@Column(nullable = false)
	private String description;
	
	@Column(nullable = false)
	private LocalDateTime createdDate;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public void setUser(UserModel user) {
		this.user = user;
	}
	public UserModel getUser() {
		return user;
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
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	public List<TeamModel> getTeamCreated() {
		return teamCreated;
	}
	public void setTeamCreated(List<TeamModel> teamCreated) {
		this.teamCreated = teamCreated;
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