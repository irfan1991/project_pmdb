package com.projectpmdb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TransaksiController {
	
	@RequestMapping("/transaksi")
	public String index() {
		return "pages/tables/header";
	}
	
	
	@RequestMapping("/transaksi/add")
	public String add() {
		return "pages/forms/header";
	}

}
