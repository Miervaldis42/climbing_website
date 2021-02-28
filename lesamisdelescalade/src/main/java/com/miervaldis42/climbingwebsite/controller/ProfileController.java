package com.miervaldis42.climbingwebsite.controller;

// Imports
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpSession;

// Entities
import com.miervaldis42.climbingwebsite.entity.Topo;
import com.miervaldis42.climbingwebsite.entity.User;
import com.miervaldis42.climbingwebsite.enums.Role;
import com.miervaldis42.climbingwebsite.enums.Status;
import com.miervaldis42.climbingwebsite.helper.DateFormatter;
import com.miervaldis42.climbingwebsite.service.LengthService;
import com.miervaldis42.climbingwebsite.service.RouteService;
import com.miervaldis42.climbingwebsite.service.SectorService;
import com.miervaldis42.climbingwebsite.service.SiteService;
import com.miervaldis42.climbingwebsite.service.TopoService;
import com.miervaldis42.climbingwebsite.service.UserService;
import com.miervaldis42.climbingwebsite.entity.Site;



@Controller
@RequestMapping("/profile")
public class ProfileController {
	String profilePath = "profile/profile-page";
	
	DateFormatter dateFormatter = new DateFormatter();
	
	@Autowired
	private TopoService topoService;
	@Autowired
	private SiteService siteService;
	@Autowired
	private SectorService sectorService;
	@Autowired
	private RouteService routeService;
	@Autowired
	private LengthService lengthService;
	@Autowired
	private UserService userService;
	
	
	
	// Profile page
	@GetMapping("infos")
	public String showProfilePage(Model sectionModel) {
		sectionModel.addAttribute("section", "infos");

		return profilePath;
	}
	
	
	
	// Dashboard
	@GetMapping("dashboard")
	public String showAdminDashboard(Model sectionModel, Model dashModel, Model KPIModel) {
		sectionModel.addAttribute("section", "dashboard");
		dashModel.addAttribute("dashSection", "keyInfo");
		
		/* Users */
		List<User> allUsers = userService.getUsers();
		List<User> admins = new ArrayList<User>();
		List<User> members = new ArrayList<User>();
		List<User> subscribers = new ArrayList<User>();
		
		for(User u : allUsers) {
			if(u.getRole() == Role.ADMIN) {
				admins.add(u);
			} else if(u.getRole() == Role.MEMBER) {
				members.add(u);
			} else {
				subscribers.add(u);
			}
		}
		
		KPIModel.addAttribute("users", allUsers.size());
		KPIModel.addAttribute("admins", admins.size());
		KPIModel.addAttribute("members", members.size());
		KPIModel.addAttribute("subscribers", subscribers.size());
		
		
		/* Sites */
		int allSites = siteService.getSites() != null ? siteService.getSites().size() : 0;
		int allSectors = sectorService.getSectors() != null ? sectorService.getSectors().size() : 0;
		int allRoutes = routeService.getRoutes() != null ? routeService.getRoutes().size() : 0;
		int allLengths = lengthService.getLengths() != null ? lengthService.getLengths().size() : 0;
		
		KPIModel.addAttribute("sites", allSites);
		KPIModel.addAttribute("sectors", allSectors);
		KPIModel.addAttribute("routes", allRoutes);
		KPIModel.addAttribute("lengths", allLengths);
		
		
		/* Topos */
		int allTopos = topoService.getTopos() != null ? topoService.getTopos().size() : 0;
		KPIModel.addAttribute("topos", allTopos);

		return profilePath; 
	}
	
	
	
	// My Topos
	@GetMapping("myTopos")
	public String showMyToposSection(Model sectionModel, HttpSession activeSession, Model ownerToposList) {		
		// Indicate which tab in Profile the user goes
		sectionModel.addAttribute("section", "myTopos");
		

		// My Topos list
		int ownerId = (int) activeSession.getAttribute("id");
		List<Topo> allOwnerTopos = topoService.getToposByOwner(ownerId);
		ownerToposList.addAttribute("myTopos", allOwnerTopos);
		
		if(allOwnerTopos != null && allOwnerTopos.size() > 0) {
			Map<Integer, String> ownerTopoDates = dateFormatter.formatDate(allOwnerTopos);
			ownerToposList.addAttribute("myToposDates", ownerTopoDates);
		}
		
		// Sites for "add topo" form
		List<Site> allSites = siteService.getSites();
		ownerToposList.addAttribute("allSites", allSites);
		
		
		
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
	
	@GetMapping("changeMyTopoStatus")
	public String changeTopoStatus(@RequestParam("topoId") int id) {
		Topo selectedTopo = topoService.getTopo(id);
		
		if(selectedTopo.getStatus().equals(Status.WITHHELD)) {
			selectedTopo.setStatus(Status.AVAILABLE);
			selectedTopo.setBorrower(null);
		} else {
			selectedTopo.setStatus(Status.WITHHELD);
			selectedTopo.setBorrower(null);
		}

		topoService.saveTopo(selectedTopo);
		
		return "redirect:/profile/myTopos";
	}
	
	@GetMapping("reservation")
	public String manageReservation(@RequestParam("reservationStatus") String reservationStatus, @RequestParam("topoId") int id, Model sectionModel) {
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
		
		sectionModel.addAttribute("section", "myTopos");

		return "redirect:/profile/myTopos";
	}
	
	
	// Log out
	@GetMapping("logout")
	public String closeCurrentSession(HttpSession activeSession) {
		activeSession.invalidate();

		return "redirect:/sites";
	}

}
