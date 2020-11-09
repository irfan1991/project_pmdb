package com.projectpmdb.controller;

import java.text.ParseException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.projectpmdb.model.SatuanModel;
import com.projectpmdb.model.SupplierModel;
import com.projectpmdb.service.SupplierService;

@Controller
public class SupplierController {
	
	
	@Autowired
	SupplierService supplierService;

	Logger logger = LoggerFactory.getLogger(SupplierController.class);
	 
	@RequestMapping("/suplier")	
	public String index(Model model) {
		List<SupplierModel> suppliers = supplierService.selectAllSupplier();
		model.addAttribute("suppliers", suppliers);
		return "pages/tables/suplier";
	}
	
	
	@RequestMapping("/suplier/add")
	public String add() {
		return "pages/forms/suplier";
	}
	
	
	@RequestMapping("/suplier/save")
	public String save(
			@RequestParam(value="nama", required=false) String nama,
			@RequestParam(value="alamat", required=false)String alamat,
			@RequestParam(value="no_tel", required=false)String no_tel,
			RedirectAttributes redirAttrs
			) throws ParseException
	{
		try {
			
		SupplierModel supplierModel = new SupplierModel(0,nama,alamat,no_tel);
		supplierService.addSupplier(supplierModel);
			
		} catch (DataIntegrityViolationException e) {
			
		     System.out.println("history already exist");
		        logger.error("history already exist");
		        redirAttrs.addFlashAttribute("message", "Data already exist");
		        
		    } catch (Exception f) {
		    	 redirAttrs.addFlashAttribute("message", f.getMessage());
		    }
		return "redirect:/suplier";
	}
	
	@RequestMapping("/delete/supplier/{id}")
	public String delete(@PathVariable(value="id")  int id) {
		supplierService.deleteSupplier(id);
		return "redirect:/suplier";
	}
	
	
	@RequestMapping("/view/supplier/{id}")
	public String view(@PathVariable(value="id") int id,Model model) {
		SupplierModel supplier = supplierService.getView(id);
		model.addAttribute("supplier", supplier);
		return "pages/forms/suplier-view";
	}
	
	@RequestMapping("/edit/supplier/{id}")
	public String edit(@PathVariable(value="id")int id, Model model) {
		SupplierModel supplier = supplierService.getEdit(id);
		model.addAttribute("supplier", supplier);
		return "pages/forms/suplier-edit";
	}
	
	
	@RequestMapping(value="/update/supplier", method=RequestMethod.POST)
	public String update(
			@RequestParam(value="nama", required=false) String nama,
			@RequestParam(value="alamat", required=false) String alamat,
			@RequestParam(value="no_tel", required=false) String no_tel,
			@RequestParam(value="id", required=false) int id,
			RedirectAttributes redirAttrs
			) throws ParseException
	{
		try {
			
			SupplierModel supplierModel = new SupplierModel(id,nama,alamat,no_tel);
			supplierService.updateSupplier(supplierModel);
			
		}catch(DataIntegrityViolationException e) {
			 logger.error("history already exist");
		     redirAttrs.addFlashAttribute("message", "Data already exist");
		        
		}catch(Exception f) {
			redirAttrs.addFlashAttribute("message",f.getMessage());
		}
		
		return "redirect:/suplier";
	}
	
	
	@RequestMapping(value="/cari/suplier",method=RequestMethod.POST)
	public String cari
	(
			@RequestParam(value="cari", required=false)String cari,
			Model model	
	) 
	
	{
		List<SupplierModel> supliers = supplierService.cariSupplier(cari);
		model.addAttribute("suppliers", supliers);
		return "pages/tables/suplier";
	}
	
	
}
