package com.hexaware.cricket_team_management.service;

import java.util.List;

import org.springframework.data.repository.query.Param;

import com.hexaware.cricket_team_management.dto.PlayerDTO;
import com.hexaware.cricket_team_management.dto.ProductSummary;
import com.hexaware.cricket_team_management.entity.Player;

public interface IPlayerService {
	
	public List<Player> getAllPlayer();
	public Player getPlayerById(int playerId);
	
	public PlayerDTO getPlayerDtoById(int playerId);
	
	public Player addPlayer(PlayerDTO playerDTO);
	public Player updatePlayer(Player player);
	
	public String deletePlayerById(int pid );
	
	public int  updateByPlayerName(String role,String playerName);
	

	
	public List<ProductSummary> getMatchSummaries();
	

}
