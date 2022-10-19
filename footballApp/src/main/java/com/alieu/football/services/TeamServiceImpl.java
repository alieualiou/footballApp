package com.alieu.football.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alieu.football.entity.Team;
import com.alieu.football.repository.TeamDAO;
import com.alieu.football.repository.TeamDAOImpl;

@Service
public class TeamServiceImpl implements TeamService {

	TeamDAO teamDAO;
	
	@Autowired
	public TeamServiceImpl(TeamDAO teamDAO) {
	
		this.teamDAO = teamDAO;
	}
	@Transactional
	@Override
	public List<Team> getTeams() {
		// TODO Auto-generated method stub
		return teamDAO.getTeams();
	}

	@Transactional
	@Override
	public int addTeam(Team team) {
		teamDAO.addTeam(team);
		return 0;
	}

	
	@Transactional
	@Override
	public List<Team> deleteTeam(int id) {
		// TODO Auto-generated method stub
		return teamDAO.deleteTeam(id);
	}

	@Transactional
	@Override
	public Team updateTeam(Team team) {
		// TODO Auto-generated method stub
		return teamDAO.updateTeam(team);
	}
	@Override
	public Team findById(int id) {
		// TODO Auto-generated method stub
		return teamDAO.findByID(id);
	}

}
