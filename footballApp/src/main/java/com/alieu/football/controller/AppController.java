package com.alieu.football.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.alieu.football.entity.Team;
import com.alieu.football.entity.TeamMember;
import com.alieu.football.services.TeamMemberService;
import com.alieu.football.services.TeamService;

import antlr.collections.List;

@Controller
public class AppController {

	TeamService teamService;
	@Autowired
	TeamMemberService memberService;
	
	@Autowired
	public	AppController(TeamService teamService) {
		this.teamService=teamService;
	}
	
	@GetMapping("/")
	public String index(Model model) {
		Team team=new Team();
		model.addAttribute("team",team);
		ArrayList<Team> teamsList=(ArrayList<Team>) teamService.getTeams();
		model.addAttribute("teams",teamsList);
		return "index";
	}
	
	
	@GetMapping("/team")
	public String getTeam(Model model) {
		Team team=new Team();
		model.addAttribute("team",team);
		ArrayList<Team> teamsList=(ArrayList<Team>) teamService.getTeams();
		model.addAttribute("teams",teamsList);
		return "team";
	}
	
	
	@PostMapping("/register")
	public String submitForm(@ModelAttribute("team") Team team) {
	    teamService.addTeam(team);
	    return "redirect:team";
	}
	
	@RequestMapping("/teamDelete")
    public String teamDelete(@ModelAttribute(value="team2") Team team2, Model model) {
	   ArrayList<Team> teamsList =  (ArrayList<Team>) teamService.deleteTeam(team2.getTeam_id());
       model.addAttribute("teams",teamsList);
 
       return "redirect:team";   
    }
	
	    @RequestMapping(value="/updateEdit", method = RequestMethod.POST)
	    public String teamUpdateEdit(@ModelAttribute(value="editteam") Team editteam, Model model) {
	        model.addAttribute("editteam", editteam);
	        return "editteam"; 
	    }
	
	@RequestMapping(value="/updateTeam" , method = RequestMethod.POST)
	public String updateTeam(@ModelAttribute("editteam") Team editteam, Model model) {
		teamService.updateTeam(editteam);
		
		return "redirect:team";
	}

	 @RequestMapping(value="/updateTeamMemberEdit", method = RequestMethod.POST)
	    public String teamMemberUpdateEdit(@ModelAttribute(value="editteammember") TeamMember editteammember, Model model) {
	        model.addAttribute("editteammember", editteammember);
	        ArrayList<Team> teamsList=	(ArrayList<Team>) teamService.getTeams();
			model.addAttribute("teamsList", teamsList);
	        return "editteammember"; 
	    }
	
	 @RequestMapping(value="/updateTeamMemberEd" , method = RequestMethod.POST)
		public String updateTeamMember(@ModelAttribute("editteammember") TeamMember editteammember, Model model) {
	
				 Team team=	teamService.findById(editteammember.getTeam().getTeam_id());
				 editteammember.setTeam(team);
				 		memberService.updateTeamMember(editteammember);
			return "redirect:member";
		}
	 
	
	@PostMapping("/addMember")
	public String addMember(@ModelAttribute("teammember") TeamMember teammember) {
		
		Team team=	teamService.findById(teammember.getTeam().getTeam_id());
		teammember.setTeam(team);
		memberService.addTeamMember(teammember);
		
		return "redirect:member";
		
		
	}
	
	@GetMapping("/member")
	public String getMember(Model model) {
		TeamMember teamMember=new TeamMember();
		model.addAttribute("teammember",teamMember);
		ArrayList<Team> teamsList=	(ArrayList<Team>) teamService.getTeams();
		model.addAttribute("teamsList", teamsList);
		ArrayList<TeamMember> teammemberList=	(ArrayList<TeamMember>) memberService.getTeamMember();
		model.addAttribute("teammemberList", teammemberList);
		return "member";
		
	}

	@RequestMapping("/teamMemberDelete")
    public String teamMemberDelete(@ModelAttribute(value="teammember") TeamMember teammember, Model model) {
	  // ArrayList<Team> teamsList =  (ArrayList<Team>) teamService.deleteTeam(team2.getT);
      // model.addAttribute("teams",te+amsList);
		memberService.deleteTeamMember(teammember.getId());
       return "redirect:member";   
    }


}
