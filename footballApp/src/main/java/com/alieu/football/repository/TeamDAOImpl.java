package com.alieu.football.repository;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.alieu.football.entity.Team;

@Repository
public class TeamDAOImpl implements TeamDAO {

	private EntityManager entityManager;
	
	@Autowired
	public	TeamDAOImpl(EntityManager entityManager){
		this.entityManager= entityManager;
	}
	
	
	@Override
	public List<Team> getTeams() {
		
		Session session	=	entityManager.unwrap(Session.class);
		org.hibernate.query.Query<Team> query=	session.createQuery("from Team",Team.class);
		List<Team> teams=	query.getResultList();
	
		return teams;
	}

	@Override
	public int addTeam(Team team) {
		
		Session session	=	entityManager.unwrap(Session.class);
		session.saveOrUpdate(team);
		return 0;
	}

	
	@Override
	public List<Team> deleteTeam(int id) {

		Session session	=	entityManager.unwrap(Session.class);
		org.hibernate.query.Query qryQuery=	session.createQuery("delete from TeamMember where team.team_id=:teamidd");
		qryQuery.setParameter("teamidd", id);
		qryQuery.executeUpdate();
		
		org.hibernate.query.Query qryQuery1=	session.createQuery("delete from Team where team_id=:teamid");
		qryQuery1.setParameter("teamid", id);
		qryQuery1.executeUpdate();
		
		return getTeams();
	}

	@Override
	public Team updateTeam(Team team) {
		Session session	=	entityManager.unwrap(Session.class);
		session.saveOrUpdate(team);
		return team;
	}


	@Override
	public Team findByID(int id) {
		Session session	=	entityManager.unwrap(Session.class);
		return session.get(Team.class,id);
	
	}

}
