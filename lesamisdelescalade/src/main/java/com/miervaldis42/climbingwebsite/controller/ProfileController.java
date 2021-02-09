package com.miervaldis42.climbingwebsite.controller;

// Imports
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.List;
import javax.servlet.http.HttpSession;

import com.miervaldis42.climbingwebsite.entity.Topo;
import com.miervaldis42.climbingwebsite.service.TopoService;




@Controller
@RequestMapping("/profile")
public class ProfileController {
	String profilePath = "profile/profile-page";
	
	@Autowired
	private TopoService topoService;

	
	// Profile page
	@GetMapping("infos")
	public String showProfilePage(Model displaySection) {
		displaySection.addAttribute("section", "infos");

		return profilePath;
	}
	
	// My topos
	@GetMapping("myTopos")
	public String showMyToposSection(Model displaySection, HttpSession activeSession, Model ownerToposList) {		
		displaySection.addAttribute("section", "myTopos");
		
		int ownerId = (int) activeSession.getAttribute("id");
		List<Topo> allOwnerTopos = topoService.getToposByOwner(ownerId);
		ownerToposList.addAttribute("myTopos", allOwnerTopos);

		return profilePath;
	}
	
	
	
	// Log out
	@GetMapping("logout")
	public String closeCurrentSession(HttpSession activeSession) {
		activeSession.invalidate();

		return "redirect:/sites";
	}

}
