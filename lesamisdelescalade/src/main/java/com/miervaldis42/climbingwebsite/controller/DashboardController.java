package com.miervaldis42.climbingwebsite.controller;

// Imports
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;

// Entities
import com.miervaldis42.climbingwebsite.entity.Comment;
import com.miervaldis42.climbingwebsite.entity.Length;
import com.miervaldis42.climbingwebsite.entity.Role;
import com.miervaldis42.climbingwebsite.entity.Route;
import com.miervaldis42.climbingwebsite.entity.Sector;
import com.miervaldis42.climbingwebsite.entity.Site;
import com.miervaldis42.climbingwebsite.entity.Topo;
import com.miervaldis42.climbingwebsite.entity.User;
import com.miervaldis42.climbingwebsite.service.CommentService;
import com.miervaldis42.climbingwebsite.service.LengthService;
import com.miervaldis42.climbingwebsite.service.RouteService;
import com.miervaldis42.climbingwebsite.service.SectorService;
import com.miervaldis42.climbingwebsite.service.SiteService;
import com.miervaldis42.climbingwebsite.service.TopoService;
import com.miervaldis42.climbingwebsite.service.UserService;



@Controller
@RequestMapping("/dashboard")
public class DashboardController {
	String profilePath = "profile/profile-page";
	
	@Autowired
	private UserService userService;
	@Autowired
	private SiteService siteService;
	@Autowired
	private SectorService sectorService;
	@Autowired
	private RouteService routeService;
	@Autowired
	private LengthService lengthService;
	@Autowired
	private CommentService commentService;
	@Autowired
	private TopoService topoService;


	/*
	 * Users tab
	 */
	@GetMapping("users")
	public String showUsersTab(Model sectionModel, Model dashModel, Model dataModel, @RequestParam("userId") Optional<Integer> id) {
		sectionModel.addAttribute("section", "dashboard");
		dashModel.addAttribute("dashSection", "users");
		
		List<User> allUsers = userService.getUsers();
		dataModel.addAttribute("users", allUsers);
		dataModel.addAttribute("roles", Role.ADMIN.values());
		
		if(id.isPresent()) {
			User selectedUser = userService.getUser(id.get());
			List<Topo> allUserTopos = topoService.getToposByOwner(id.get());
			List<Comment> allUserComments = commentService.getCommentsByUser(id.get());
			
			dataModel.addAttribute("user", selectedUser);
			dataModel.addAttribute("userTopos", allUserTopos);
			dataModel.addAttribute("userComments", allUserComments);
		}

		return profilePath;
	}
	
	@PostMapping("editUser")
	public String editUser(
		@RequestParam("userId") int id,
		@RequestParam("role") Role role,
		@RequestParam("lastname") String lastname,
		@RequestParam("firstname") String firstname,
		@RequestParam("email") String email) 
	{
		User selectedUser = userService.getUser(id);
		selectedUser.setRole(role);
		selectedUser.setLastname(lastname);
		selectedUser.setFirstname(firstname);
		selectedUser.setEmail(email);
		selectedUser.setUpdatedAt(new Date());
		userService.saveUser(selectedUser);
		
		return "redirect:/dashboard/users";
	}
	
	@GetMapping("deleteUser")
	public String deleteUser(@RequestParam("userId") int id) {
		userService.deleteUser(id);
		
		return "redirect:/dashboard/users";
	}
	
	
	
	/*
	 * Sites tab
	 */
	@GetMapping("sites")
	public String showSitesTab(Model sectionModel, Model dashModel, Model dataModel, @RequestParam("siteId") Optional<Integer> siteId) {
		sectionModel.addAttribute("section", "dashboard");
		dashModel.addAttribute("dashSection", "sites");
		
		List<Site> allSites = siteService.getSites();
		dataModel.addAttribute("sites", allSites);
		
		if(siteId.isPresent()) {
			Site selectedSite = siteService.getSite(siteId.get());
			List<Sector> allSiteSectors = sectorService.getSectors(siteId.get());
			List<Route> allSiteRoutes = routeService.getRoutesBySite(siteId.get());
			List<Length> allSiteLengths = lengthService.getLengthsBySite(siteId.get());
			List<Topo> allSiteTopos = topoService.getToposBySite(siteId.get());
			
			dataModel.addAttribute("site", selectedSite);
			dataModel.addAttribute("siteSectors", allSiteSectors);
			dataModel.addAttribute("siteRoutes", allSiteRoutes);
			dataModel.addAttribute("siteLengths", allSiteLengths);
			dataModel.addAttribute("siteTopos", allSiteTopos);
		}

		return profilePath;
	}
	
	@PostMapping("editSite")
	public String editSite(
		@RequestParam("siteId") int id,
		@RequestParam("tag") Boolean tag,
		@RequestParam("name") String name,
		@RequestParam("location") String location,
		@RequestParam("desc") String desc)
	{
		Site selectedSite = siteService.getSite(id);
		selectedSite.setTag(tag);
		selectedSite.setName(name);
		selectedSite.setLocation(location);
		selectedSite.setDescription(desc);
		siteService.saveSite(selectedSite);
		
		return "redirect:/dashboard/sites";
	}
	
	@GetMapping("deleteSite")
	public String deleteSite(@RequestParam("siteId") int id) {
		siteService.deleteSite(id);
		
		return "redirect:/dashboard/sites";
	}

}