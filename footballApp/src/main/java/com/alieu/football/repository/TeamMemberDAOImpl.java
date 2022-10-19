package com.alieu.football.repository;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.alieu.football.entity.Team;
import com.alieu.football.entity.TeamMember;

@Repository
public class TeamMemberDAOImpl implements TeamMemberDAO{

	EntityManager eManager;
	
	@Autowired
	public TeamMemberDAOImpl(EntityManager eManager) {
		this.eManager=eManager;
	}
	
	@Override
	public List<TeamMember> getTeamMember() {
		Session session	=	eManager.unwrap(Session.class);
		org.hibernate.query.Query<TeamMember> query=	session.createQuery("from TeamMember",TeamMember.class);
		List<TeamMember> teamsmeMembers=	query.getResultList();
	
		return teamsmeMembers;
		
	}

	@Override
	public int addTeamMember(TeamMember team) {
		
		Session session	=	eManager.unwrap(Session.class);
		session.saveOrUpdate(team);
		
		return 0;
	}

	

	@Override
	public List<TeamMember> deleteTeamMember(int id) {
		Session session	=	eManager.unwrap(Session.class);
		org.hibernate.query.Query qryQuery=	session.createQuery("delete from TeamMember where id=:memberid");
		qryQuery.setParameter("memberid", id);
		qryQuery.executeUpdate();
		
		
		return getTeamMember();
	}

	@Override
	public TeamMember updateTeamMember(TeamMember team) {

		Session session	=	eManager.unwrap(Session.class);
		session.saveOrUpdate(team);

		return team;
	}

}
