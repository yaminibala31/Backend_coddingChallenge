
package com.hexaware.cricket_team_management.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "Players_table")
public class Player {
	
	@Id
	private int playerId;
	@NotBlank(message = "player name is required")
    private String playerName;
	@Min(value = 1)
    private Integer jerseyNumber;
	private String role;
	private int totalMatches;
	private String teamName;
	
	private String state;
	private String description;
	
	public Player() {
		super();
		
	}
	
	public int getPlayerid() {
		return playerId;
	}
	public void setPlayerid(int playerId) {
		this.playerId = playerId;
	}
	
	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}
	public String getPlayername() {
		return playerName;
	}
	public void setPlayername(String playerName) {
		this.playerName = playerName;
	}
	public Integer getJerseyNumber() {
		return jerseyNumber;
	}
	public void setJerseyNumber(Integer jerseyNumber) {
		this.jerseyNumber = jerseyNumber;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public int getTotalMatches() {
		return totalMatches;
	}
	public void setTotalMatches(int totalMatches) {
		this.totalMatches = totalMatches;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

}
