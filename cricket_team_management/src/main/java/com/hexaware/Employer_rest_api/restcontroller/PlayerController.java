package com.hexaware.Employer_rest_api.restcontroller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hexaware.Employer_rest_api.dto.PlayerDTO;
import com.hexaware.Employer_rest_api.entity.Player;
import com.hexaware.Employer_rest_api.exception.PlayerNotFoundException;
import com.hexaware.Employer_rest_api.service.PlayerServiceImpl;


import jakarta.validation.Valid;

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
	public Player  updatePlayer(@RequestBody @Valid Player player) {

		logger.info("player updated...");
		return service.updatePlayer(player);

	}

	
	@GetMapping("/get/{eid}") 
	public Player   getPlayerById(@PathVariable int PlayerId) throws PlayerNotFoundException {
		
		Player player =  service.getPlayerById(PlayerId);
			if(player == null) {
				
				throw  new PlayerNotFoundException();	
			}
			return player;
		
	}
	
	@GetMapping("/getall")
	public List<Player>  getAllPlayer(){
		
		
		return service.getAllPlayer();
		
	}
	
	
	@DeleteMapping("/delete/{eid}") 
	public String  deleteById(@PathVariable int PlayerId) {
		
		return  service.deletePlayerById(PlayerId);
		
	}

}
