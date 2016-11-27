package com.barath.app.model;

public class Team {
	
	private long teamId;
	
	private String teamName;

	public long getTeamId() {
		return teamId;
	}

	public void setTeamId(long teamId) {
		this.teamId = teamId;
	}

	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	public Team(long teamId, String teamName) {
		super();
		this.teamId = teamId;
		this.teamName = teamName;
	}

	public Team() {
		super();
		
	}

	@Override
	public String toString() {
		return "Team [teamId=" + teamId + ", teamName=" + teamName + "]";
	}
	
	
	
	
	

}
