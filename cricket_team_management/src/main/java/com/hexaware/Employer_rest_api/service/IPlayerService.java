package com.hexaware.Employer_rest_api.service;

import java.util.List;

import com.hexaware.Employer_rest_api.dto.PlayerDTO;
import com.hexaware.Employer_rest_api.entity.Player;

public interface IPlayerService {
	
	public List<Player> getAllPlayer();
	public Player getPlayerById(int playerId);
	
	public PlayerDTO getPlayerDtoById(int playerId);
	
	public Player addPlayer(PlayerDTO playerDTO);
	public Player updatePlayer(Player player);
	
	public String deletePlayerById(int pid );
	

}
