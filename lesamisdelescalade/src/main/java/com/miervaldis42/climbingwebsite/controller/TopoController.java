package com.miervaldis42.climbingwebsite.controller;

// Imports
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.*;

// Entities
import com.miervaldis42.climbingwebsite.helper.DateFormatter;
import com.miervaldis42.climbingwebsite.helper.ToastHandler;
import com.miervaldis42.climbingwebsite.enums.Status;
import com.miervaldis42.climbingwebsite.enums.Code;

import com.miervaldis42.climbingwebsite.entity.Topo;
import com.miervaldis42.climbingwebsite.entity.User;
import com.miervaldis42.climbingwebsite.service.TopoService;
import com.miervaldis42.climbingwebsite.service.UserService;



@Controller
@RequestMapping("/topos")
public class TopoController {
	String topoDir = "/topos/";

	DateFormatter dateFormatter = new DateFormatter();
	ToastHandler paperBoy = new ToastHandler();
	Code toastCode = null; 
	
	@Autowired
	private TopoService topoService;
	@Autowired
	private UserService userService;



	@GetMapping("list")
	public String showTopoList(Model topoListModel, Model toastModel) {
		List<Topo> allAvailableTopos = topoService.getToposByStatus(Status.AVAILABLE);
		topoListModel.addAttribute("topoList", allAvailableTopos);
		
		if(allAvailableTopos != null && allAvailableTopos.size() > 0) {
			Map<Integer, String> availableTopoDates = dateFormatter.formatDate(allAvailableTopos);
			topoListModel.addAttribute("toposDates", availableTopoDates);
		}
		
		if(toastCode != null && toastCode.equals(Code.TOPO_BOOKED)) {
			String toastStatus = paperBoy.throwToastStatus(toastCode);
			String toastMessage = paperBoy.throwToastMessage(toastCode);
			
			toastModel.addAttribute(toastStatus, toastMessage);
			toastCode = null;
		}
		
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
		toastCode = Code.TOPO_BOOKED;
		
		return "redirect:/topos/list";
	}
	
}
