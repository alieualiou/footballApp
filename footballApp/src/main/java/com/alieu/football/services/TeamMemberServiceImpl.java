package com.alieu.football.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alieu.football.entity.Team;
import com.alieu.football.entity.TeamMember;
import com.alieu.football.repository.TeamMemberDAO;

@Service
public class TeamMemberServiceImpl implements TeamMemberService {

	TeamMemberDAO teamMemberDAO;
	
	@Autowired
	public TeamMemberServiceImpl(TeamMemberDAO teamMemberDAO) {
		this.teamMemberDAO = teamMemberDAO;
	}
	

	@Transactional
	@Override
	public List<TeamMember> getTeamMember() {
		// TODO Auto-generated method stub
		return teamMemberDAO.getTeamMember();
	}

	@Transactional
	@Override
	public int addTeamMember(TeamMember team) {
		
		return teamMemberDAO.addTeamMember(team);
	}

	

	@Transactional
	@Override
	public List<TeamMember> deleteTeamMember(int id) {
		// TODO Auto-generated method stub
		return teamMemberDAO.deleteTeamMember(id);
	}


	@Transactional
	@Override
	public TeamMember updateTeamMember(TeamMember team) {
		// TODO Auto-generated method stub
		return teamMemberDAO.updateTeamMember(team);
	}

}
