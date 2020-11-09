package com.projectpmdb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DetailTransaksiController {
	
	
	@RequestMapping("/transaksi/detail")
	public String index() {
		return ("pages/tables/sub");
	}
	
	

}
