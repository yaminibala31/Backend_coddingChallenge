package com.hexaware.cricket_team_management.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hexaware.cricket_team_management.dto.PlayerDTO;
import com.hexaware.cricket_team_management.dto.ProductSummary;
import com.hexaware.cricket_team_management.entity.Player;
import com.hexaware.cricket_team_management.repository.PlayerRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class PlayerServiceImpl implements IPlayerService{
	
	

	@Autowired
	PlayerRepository repo;
	
	
	@Override
	public List<Player> getAllPlayer() {
		
		return repo.findAll();
	}
	

	

	@Override
	public Player addPlayer(PlayerDTO playerDTO) {
		
		Player player = new Player();
		player.setPlayerid(playerDTO.getPlayerId());
		player.setPlayername(playerDTO.getPlayerName());
		player.setRole(playerDTO.getRole());
		player.setState(playerDTO.getState());
		player.setTotalMatches(playerDTO.getTotalMatches());
		player.setTeamName(playerDTO.getTeamName());
		player.setJerseyNumber(playerDTO.getJerseyNumber());
		player.setDescription(playerDTO.getDescription());
		
		return repo.save(player);
	}

	@Override
	public Player updatePlayer(Player player) {
		
		return repo.save(player);
	}

	@Override
	public String deletePlayerById(int pid) {
		repo.deleteById(pid);
		return "deleted the player with Id: "+pid;
	}


	@Override
	public PlayerDTO getPlayerDtoById(int playerId) {
		 Player player = getPlayerById(playerId);
		    return new PlayerDTO(
		        player.getPlayerid(),
		        player.getPlayername(),
		        player.getJerseyNumber(),
		        player.getRole()
		    );
	}




	@Override
	public Player getPlayerById(int playerId) {
		
		return repo.findById(playerId).orElse(null);
	}




	public static boolean validatePlayer(PlayerDTO playerDTO) {
	    if (playerDTO == null) {
	        return false;
	    }
	    return playerDTO.getPlayerId() > 0;
	}




	@Override
	public int updateByPlayerName(String role, String playerName) {
		
		return repo.updateByPlayerName(role, playerName);
	}




	public List<ProductSummary> getMatchSummaries() {
        return repo.getTotalMatchesGroupedByTeam();
    }
	




	





}
