package com.alieu.football.services;

import java.util.List;

import com.alieu.football.entity.Team;

public interface TeamService {

	public List<Team> getTeams();
	public int addTeam(Team team);
	public List<Team> deleteTeam(int id);
	public Team updateTeam(Team team);
	public Team findById(int id);
}
