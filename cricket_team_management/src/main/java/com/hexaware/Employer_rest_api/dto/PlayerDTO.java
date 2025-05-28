package com.hexaware.Employer_rest_api.dto;

public class PlayerDTO {
	
	private int playerId;
	private String playerName;
	private int jerseyNumber;
	private String role;
	private int totalMatches;
	private String state;
	private String description;
	
	
	
	
	public PlayerDTO(int playerId, String playerName, int jerseyNumber, String role) {
		super();
		this.playerId = playerId;
		this.playerName = playerName;
		this.jerseyNumber = jerseyNumber;
		this.role = role;
	}
	public PlayerDTO() {
		super();
	}
	public int getPlayerId() {
		return playerId;
	}
	public void setPlayerId(int playerId) {
		this.playerId = playerId;
	}
	public String getPlayerName() {
		return playerName;
	}
	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}
	public int getJerseyNumber() {
		return jerseyNumber;
	}
	public void setJerseyNumber(int jerseyNumber) {
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
	@Override
	public String toString() {
		return "PlayerDTO [playerId=" + playerId + ", playerName=" + playerName + ", jerseyNumber=" + jerseyNumber
				+ ", role=" + role + ", totalMatches=" + totalMatches + ", state=" + state + ", description="
				+ description + "]";
	}
}
	
//	public PlayerDTO(int pid, String pname, int jerseyNumber, String role, int totalMatches, String state,
//			String description) {
//		super();
//		this.pid = pid;
//		this.pname = pname;
//		this.jerseyNumber = jerseyNumber;
//		this.role = role;
//		this.totalMatches = totalMatches;
//		this.state = state;
//		this.description = description;
//	}
	