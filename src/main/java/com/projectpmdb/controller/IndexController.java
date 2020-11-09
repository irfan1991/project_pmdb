package com.projectpmdb.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.projectpmdb.domain.UserPrincipal;
import com.projectpmdb.model.PartNumberModel;
import com.projectpmdb.model.SupplierModel;
import com.projectpmdb.service.PartNumberService;
import com.projectpmdb.service.SupplierService;

@Controller
public class IndexController {
	
	Logger logger = LoggerFactory.getLogger(IndexController.class);
	
	@Autowired
	PartNumberService partNumberService;
	
	@Autowired
	SupplierService supplierService;
	
//	@RequestMapping("/home")
//	public String index() {
//		return "index";
//	}
	
	 @GetMapping("home")
	    public ModelAndView home(){
	        ModelAndView modelAndView = new ModelAndView();
	        
	        List<PartNumberModel> partNumber = partNumberService.getCountPN();
	        List<SupplierModel> supplier = supplierService.getCountSupplier();
	        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	        UserPrincipal userPrincipal = (UserPrincipal) auth.getPrincipal();

	        System.out.println(userPrincipal.toString());

	        modelAndView.addObject("userName", "Welcome " + userPrincipal.getName() + " (" + userPrincipal.getId() + ")");
	        modelAndView.addObject("adminMessage","Content Available Only for Users with Admin Role");
	        modelAndView.addObject("partNumber", partNumber);
	        modelAndView.addObject("supplier", supplier);
	        modelAndView.setViewName("index");
	        return modelAndView;
	    }

	


}
