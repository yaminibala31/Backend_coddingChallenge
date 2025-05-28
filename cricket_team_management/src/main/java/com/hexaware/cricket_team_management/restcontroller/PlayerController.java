package com.hexaware.cricket_team_management.restcontroller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hexaware.cricket_team_management.dto.PlayerDTO;
import com.hexaware.cricket_team_management.dto.ProductSummary;
import com.hexaware.cricket_team_management.entity.Player;
import com.hexaware.cricket_team_management.exception.PlayerNotFoundException;
import com.hexaware.cricket_team_management.service.PlayerServiceImpl;




@RestController
@RequestMapping("/api/players")
public class PlayerController {

	@Autowired
	PlayerServiceImpl service;
	
	Logger  logger =	LoggerFactory.getLogger(PlayerController.class);
	

	@PostMapping("/add")
	public Player addPlayer(@RequestBody PlayerDTO playerDTO) {
		
		boolean  isValid =	PlayerServiceImpl.validatePlayer(playerDTO);
		logger.info("Playercontroller is working");
		
		Player player = null;
		
			if(isValid) {
				player = service.addPlayer(playerDTO);
				logger.warn("Player object is not null in RestController");
			}
			
			
			logger.debug("debugging from RestController");

		return player;

	}
	
	@PutMapping("/update")
	public Player  updatePlayer(@RequestBody  Player player) {

		logger.info("player updated...");
		return service.updatePlayer(player);

	}

	
	@GetMapping("/get/{PlayerId}") 
	public PlayerDTO   getPlayerById(@PathVariable int PlayerId) throws PlayerNotFoundException {
		
		Player player = service.getPlayerById(PlayerId);

	    if (player == null) {
	        throw new PlayerNotFoundException();
	    }

	    return new PlayerDTO(
	        player.getPlayerid(),
	        player.getPlayername(),
	        player.getJerseyNumber(),
	        player.getRole()
	    );
		
	}
	
	@GetMapping("/getall")
	public List<Player>  getAllPlayer(){
		
		
		return service.getAllPlayer();
		
	}
	
	
	@DeleteMapping("/delete/{PlayerId}") 
	public String  deleteById(@PathVariable int PlayerId) {
		
		return  service.deletePlayerById(PlayerId);
		
	}

	
	@PutMapping("/update-by-id/{playerId}/{role}")
	int  updateByPlayerId(String role,String playerName) {
		
		return service.updateByPlayerName(role, playerName);
	}
	
	@GetMapping("/summary")
    public ResponseEntity<List<ProductSummary>> getMatchSummary() {
        List<ProductSummary> summary = service.getMatchSummaries();
        return ResponseEntity.ok(summary); 
	}
}
