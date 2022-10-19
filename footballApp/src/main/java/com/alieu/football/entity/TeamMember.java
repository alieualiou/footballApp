package com.alieu.football.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name ="team_member")
public class TeamMember {

	@Id
	@Column(name="member_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "first_name")
	private String first_name;
	@Column(name ="last_name")
	private String last_name;
	@Column(name = "age")
	private String age;
	@Column(name = "nationality")
	private String nationality;
	@Column(name="id_no")
	private String idNo;
	@Column(name = "member_type")
	private String memberType;
	
	@ManyToOne
	@JoinColumn(name="team_id", nullable=false)
	private Team team;

	
	public TeamMember() {
		
	}
	
	public TeamMember(String first_name, String last_name, String age, String nationality, String idNo,
			String memberType, Team team) {
		this.first_name = first_name;
		this.last_name = last_name;
		this.age = age;
		this.nationality = nationality;
		this.idNo = idNo;
		this.memberType = memberType;
		this.team = team;
	}

		
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public String getIdNo() {
		return idNo;
	}

	public void setIdNo(String idNo) {
		this.idNo = idNo;
	}

	public String getMemberType() {
		return memberType;
	}

	public void setMemberType(String memberType) {
		this.memberType = memberType;
	}

	public Team getTeam() {
		return team;
	}

	public void setTeam(Team team) {
		this.team = team;
	}

	@Override
	public String toString() {
		return "TeamMember [id=" + id + ", first_name=" + first_name + ", last_name=" + last_name + ", age=" + age
				+ ", nationality=" + nationality + ", idNo=" + idNo + ", memberType=" + memberType + ", team=" + team
				+ "]";
	}


	
	
}
