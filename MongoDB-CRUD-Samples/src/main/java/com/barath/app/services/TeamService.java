package com.barath.app.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.barath.app.model.Team;
import com.barath.app.repositories.TeamRepository;


@Service
public class TeamService {
	
	private TeamRepository teamRepository;
	
	@Autowired
	public  TeamService(TeamRepository teamRepository) {
		this.teamRepository=teamRepository;
	}
	
	

	
	public Team addTeam(Team team){
		return this.teamRepository.addTeam(team);
	}
	
	
	public Team readTeam(long teamId){
		return this.teamRepository.readTeam(teamId);
	}
	
	public Team readTeamByName(String teamName){
		return this.teamRepository.readTeamByName(teamName);
	}
	
	
	public Team updateTeam(Team team){
		return this.teamRepository.updateTeam(team);
	}
	
	
	public boolean deleteTeam( long teamId){
		return this.teamRepository.deleteTeam(teamId);
	}
	
	public boolean deleteTeamByName( String teamName){
		return this.teamRepository.deleteTeamByName(teamName);
	}

}
