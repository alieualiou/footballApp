package com.alieu.football.services;

import java.util.List;

import com.alieu.football.entity.Team;
import com.alieu.football.entity.TeamMember;

public interface TeamMemberService {
	
	public List<TeamMember> getTeamMember();
	public int addTeamMember(TeamMember team);
	public List<TeamMember> deleteTeamMember(int id);
	public TeamMember updateTeamMember(TeamMember team);



}
