package com.alieu.football.repository;

import java.util.List;

import com.alieu.football.entity.Team;

public interface TeamDAO {

		public List<Team> getTeams();
		public int addTeam(Team team);
		public Team findByID(int id);
		public List<Team> deleteTeam(int id);
		public Team updateTeam(Team team);
		
}
