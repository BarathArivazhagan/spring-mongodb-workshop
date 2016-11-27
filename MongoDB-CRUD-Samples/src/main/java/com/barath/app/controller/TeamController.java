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
import com.barath.app.services.TeamService;

@RestController
public class TeamController {
	

	@Autowired
	private TeamService teamService;
	
	
	@PostMapping("/team/add")
	public Team addTeam(@RequestBody Team team){
		return teamService.addTeam(team);
	}
	
	@GetMapping("/team/read")
	public Team readTeam(@RequestParam Long teamId){
		return teamService.readTeam(teamId);
	}
	
	@GetMapping("/team/name")
	public Team readTeamByName(@RequestParam String teamName){
		return teamService.readTeamByName(teamName);
	}
	
	@PostMapping("/team/update")
	public Team updateTeam(@RequestBody Team team){
		return teamService.updateTeam(team);
	}
	
	@DeleteMapping("/team/delete")
	public String deleteTeam(@RequestParam Long teamId){		
		
		boolean result=teamService.deleteTeam(teamId);
		if(result){
			return "Team is  deleted successfully ";
		}
		return "Team is not deleted ";
	}
	
	@GetMapping("/team/all")
	public Set<Team> findAllTeams(){
		return teamService.findAllTeams();
	}

}
