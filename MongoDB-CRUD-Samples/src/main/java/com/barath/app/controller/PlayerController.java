package com.barath.app.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.barath.app.model.Player;
import com.barath.app.model.Team;
import com.barath.app.services.PlayerService;

@RestController
public class PlayerController {
	
	
	@Autowired
	private PlayerService playerService;
	
	
	@PostMapping("/player/add")
	public Player addPlayer(@RequestBody Player player){
		return playerService.addPlayer(player);
	}
	
	@GetMapping("/player/read")
	public Player readPlayer(@RequestParam Long playerId){
		return playerService.readPlayer(playerId);
	}
	
	@GetMapping("/player/name")
	public Player readPlayerByName(@RequestParam String playerName){
		return playerService.readPlayerByName(playerName);
	}
	
	@PostMapping("/player/update")
	public Player updatePlayer(@RequestBody Player player){
		return playerService.updatePlayer(player);
	}
	
	@DeleteMapping("/player/delete")
	public String deletePlayer(@RequestParam Long playerId){		
		
		boolean result=playerService.deletePlayer(playerId);
		if(result){
			return "Player is  deleted successfully ";
		}
		return "Player is not deleted ";
	}
	
	@GetMapping("/player/all")
	public Set<Player> findAllPlayers(){
		return playerService.findAllPlayers();
	}

}
