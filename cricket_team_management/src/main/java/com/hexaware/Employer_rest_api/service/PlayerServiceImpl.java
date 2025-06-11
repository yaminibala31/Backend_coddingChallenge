package com.hexaware.Employer_rest_api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hexaware.Employer_rest_api.dto.PlayerDTO;
import com.hexaware.Employer_rest_api.entity.Player;
import com.hexaware.Employer_rest_api.service.repository.PlayerRepository;

@Service
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
		player.setTotalMatches(playerDTO.getTotalMatches());
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
		Player player =new Player();
		boolean flag = false;
	
		if(player.getPlayerid()>0) {
			
			flag = true;
				
		}
	
		return flag;
		
	}

}
