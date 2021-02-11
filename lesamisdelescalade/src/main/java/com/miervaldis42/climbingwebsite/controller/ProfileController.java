package com.miervaldis42.climbingwebsite.controller;

// Imports
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpSession;

// Entities
import com.miervaldis42.climbingwebsite.entity.Topo;
import com.miervaldis42.climbingwebsite.entity.User;
import com.miervaldis42.climbingwebsite.service.SiteService;
import com.miervaldis42.climbingwebsite.service.TopoService;
import com.miervaldis42.climbingwebsite.service.UserService;
import com.miervaldis42.climbingwebsite.entity.Site;
import com.miervaldis42.climbingwebsite.entity.Status;



@Controller
@RequestMapping("/profile")
public class ProfileController {
	String profilePath = "profile/profile-page";
	
	@Autowired
	private TopoService topoService;
	@Autowired
	private SiteService siteService;
	@Autowired
	private UserService userService;
	
	
	
	// Profile page
	@GetMapping("infos")
	public String showProfilePage(Model displaySection) {
		displaySection.addAttribute("section", "infos");

		return profilePath;
	}
	
	
	
	// My Topos
	@GetMapping("myTopos")
	public String showMyToposSection(Model displaySection, HttpSession activeSession, Model ownerToposList) {		
		displaySection.addAttribute("section", "myTopos");
		
		List<Site> allSites = siteService.getSites();
		ownerToposList.addAttribute("allSites", allSites);

		int ownerId = (int) activeSession.getAttribute("id");
		List<Topo> allOwnerTopos = topoService.getToposByOwner(ownerId);
		ownerToposList.addAttribute("myTopos", allOwnerTopos);
		
		if(allOwnerTopos != null && allOwnerTopos.size() > 0) {
			DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy à HH:mm");
			Map<Integer, String> ownerTopoDates = new HashMap<Integer, String>();
			for(Topo t : allOwnerTopos) {
				ownerTopoDates.put(t.getId(), formatter.format(t.getPublishedDate()));
			}
			
			ownerToposList.addAttribute("myToposDates", ownerTopoDates);
		}

		return profilePath;
	}
	
	@PostMapping("addMyTopo")
	public String addMyTopo(
		@RequestParam("ownerId") int owner_id,
		@RequestParam("name") String topoName,
		@RequestParam("desc") String topoDesc,
		@RequestParam("site") int site_id) 
	{
		Topo newTopo = new Topo();
		
		User owner = userService.getUser(owner_id);
		newTopo.setOwner(owner);
		newTopo.setStatus(Status.AVAILABLE);
		
		if(!topoName.isEmpty() && !topoDesc.isEmpty()) {
			newTopo.setName(topoName);
			newTopo.setDescription(topoDesc);
		} else {
			newTopo.setName("X-Files n°" + owner_id);
			newTopo.setDescription("REDACTED");
		}
		
		Site topoSite = siteService.getSite(site_id);
		newTopo.setSite(topoSite);
		
		newTopo.setPublishedDate(new Date());
		
		topoService.saveTopo(newTopo);
		
		return "redirect:/profile/myTopos";
	}
	
	@GetMapping("reservation")
	public String manageReservation(@RequestParam("reservationStatus") String reservationStatus, @RequestParam("topoId") int id, Model displaySection) {
		Topo selectedTopo = topoService.getTopo(id);
		
		if(reservationStatus.equals("accept")) {
			selectedTopo.setStatus(Status.LENT);
		} else if(reservationStatus.equals("refuse")) {
			selectedTopo.setStatus(Status.AVAILABLE);
			selectedTopo.setBorrower(null);
		} else if(reservationStatus.equals("end")){
			selectedTopo.setStatus(Status.AVAILABLE);
			selectedTopo.setBorrower(null);
		}
		topoService.saveTopo(selectedTopo);
		
		displaySection.addAttribute("section", "myTopos");

		return "redirect:/profile/myTopos";
	}
	
	
	// Log out
	@GetMapping("logout")
	public String closeCurrentSession(HttpSession activeSession) {
		activeSession.invalidate();

		return "redirect:/sites";
	}

}
