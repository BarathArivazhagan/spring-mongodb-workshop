package com.barath.app.services;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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
		return this.playerRepository.addPlayer(player);
	}
	
	
	public Player readPlayer(long playerId){
		return this.playerRepository.readPlayer(playerId);
	}
	
	public Player readPlayerByName(String playerName){
		return this.playerRepository.readPlayerByName(playerName);
	}
	
	
	public Player updatePlayer(Player player){
		return this.playerRepository.updatePlayer(player);
	}
	
	
	public boolean deletePlayer( long playerId){
		return this.playerRepository.deletePlayer(playerId);
	}
	
	public boolean deletePlayerByName( String playerName){
		return this.playerRepository.deletePlayerByName(playerName);
	}
	
	public Set<Player> findAllPlayers(){	
		return this.playerRepository.findAllPlayers();
	}

}
