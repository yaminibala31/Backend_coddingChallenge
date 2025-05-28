package com.hexaware.cricket_team_management.dto;

public class ProductSummary {
	
	private String teamName;
    private int totalMatches;
    
	public ProductSummary(String teamName, int totalMatches) {
		super();
		this.teamName = teamName;
		this.totalMatches = totalMatches;
	}
	public String getTeamName() {
		return teamName;
	}
	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}
	public int getTotalMatches() {
		return totalMatches;
	}
	public void setTotalMatches(int totalMatches) {
		this.totalMatches = totalMatches;
	}

}
