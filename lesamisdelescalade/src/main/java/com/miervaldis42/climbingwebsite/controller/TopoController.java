package com.miervaldis42.climbingwebsite.controller;

// Imports
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.beans.factory.annotation.Autowired;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

import com.miervaldis42.climbingwebsite.helper.ErrorHandler;

import com.miervaldis42.climbingwebsite.entity.Topo;
import com.miervaldis42.climbingwebsite.entity.User;
import com.miervaldis42.climbingwebsite.enums.Status;
import com.miervaldis42.climbingwebsite.service.TopoService;
import com.miervaldis42.climbingwebsite.service.UserService;



@Controller
@RequestMapping("/topos")
public class TopoController {
	String topoDir = "/topos/";

	// Variables for error handling
	ErrorHandler errorDetector = new ErrorHandler();
	String toastCode = ""; 
	
	@Autowired
	private TopoService topoService;
	@Autowired
	private UserService userService;



	@GetMapping("list")
	public String showTopoList(Model topoListModel, Model toastModel) {
		List<Topo> allAvailableTopos = topoService.getToposByStatus(Status.AVAILABLE);
		topoListModel.addAttribute("topoList", allAvailableTopos);
		
		if(allAvailableTopos != null && allAvailableTopos.size() > 0) {
			DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm");
			Map<Integer, String> availableTopoDates = new HashMap<Integer, String>();
			for(Topo t : allAvailableTopos) {
				availableTopoDates.put(t.getId(), formatter.format(t.getPublishedDate()));
			}
			
			topoListModel.addAttribute("toposDates", availableTopoDates);
		}
		
		if(toastCode.equals("200 - Topo booked")) {
			String message = errorDetector.displayToastMessage(toastCode);
			toastModel.addAttribute("success", message);
		}
		
		toastCode = "";
		
		return topoDir + "topos-page";
	}
	

	@GetMapping("bookTopo")
	public String bookTheTopo(@RequestParam("topoId") int id, @RequestParam("borrowerId") int borrower_id) {		
		Topo selectedTopo = topoService.getTopo(id);
		selectedTopo.setStatus(Status.PENDING);
		
		User borrower = userService.getUser(borrower_id);
		selectedTopo.setBorrower(borrower);
		
		topoService.saveTopo(selectedTopo);
		
		// Toast
		toastCode = "200 - Topo booked";
		
		return "redirect:/topos/list";
	}
	
}
