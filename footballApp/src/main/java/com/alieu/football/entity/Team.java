package com.alieu.football.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "team")
public class Team {

	@Id
	@Column(name = "team_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int team_id;
	@Column(name = "team_name")
	private String team_name;
	@Column(name = "team_description")
	private String team_description;
	
	@OneToMany(mappedBy = "team")
	private List<TeamMember> members = new ArrayList<TeamMember>();
	
	
	public List<TeamMember> getMembers() {
		return members;
	}


	public void setMembers(List<TeamMember> members) {
		this.members = members;
	}


	public Team() {
		
	}
	
	
	public Team(String team_name, String team_description, List<TeamMember> members) {
		this.team_name = team_name;
		this.team_description = team_description;
		this.members = members;
	}

	public int getTeam_id() {
		return team_id;
	}
	public void setTeam_id(int team_id) {
		this.team_id = team_id;
	}
	public String getTeam_name() {
		return team_name;
	}
	public void setTeam_name(String team_name) {
		this.team_name = team_name;
	}
	public String getTeam_description() {
		return team_description;
	}
	public void setTeam_description(String team_description) {
		this.team_description = team_description;
	}

	
	@Override
	public String toString() {
		return "Team [team_id=" + team_id + ", team_name=" + team_name + ", team_description=" + team_description
				+ ", members=" + members + "]";
	}

	
}
