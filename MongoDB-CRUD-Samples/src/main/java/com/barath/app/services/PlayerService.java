package com.barath.app.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.barath.app.model.Player;
import com.barath.app.repositories.PlayerRepository;


@Service
public class PlayerService {
	
	private PlayerRepository playerRepository;
	
	@Autowired
	public  PlayerService(PlayerRepository playerRepository) {
		this.playerRepository=playerRepository;
	}
	
	

	
	public Player addPlayer(Player player){
		
	}
	
	
	public Player readPlayer(long playerId){
		
	}
	
	public Player readPlayerByName(String playerName){
		
	}
	
	
	public Player updatePlayer(Player player){
		
	}
	
	
	public Player deletePlayer( long playerId){
	
	}
}
