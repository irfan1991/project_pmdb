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

import com.projectpmdb.model.PartNumberModel;
import com.projectpmdb.model.SatuanModel;
import com.projectpmdb.service.SatuanService;

@Controller
public class SatuanController {
	
	@Autowired
	SatuanService satuanService;

	Logger logger = LoggerFactory.getLogger(SatuanController.class);
	 
	@RequestMapping("/satuan")
	public String index(Model model) {
		List<SatuanModel> satuans = satuanService.selectAllSatuan();
		model.addAttribute("satuans", satuans);
		return "pages/tables/satuan";
	}
	
	
	@RequestMapping("/satuan/add")
	public String add() {
		return "pages/forms/satuan";
	}
	
	@RequestMapping("/satuan/save")
	public String save(
			@RequestParam(value ="nama",required=false) String name,
			RedirectAttributes redirAttrs
			
			)  throws ParseException
	
	
	{
		 try {
			 SatuanModel satuanModel = new SatuanModel(0, name);
		        satuanService.addSatuan(satuanModel);
		       
		    }
		    catch (DataIntegrityViolationException e) {
		        System.out.println("history already exist");
		        logger.error("history already exist");
		        redirAttrs.addFlashAttribute("message", "Data already exist");
		        
		    } catch (Exception f) {
		    	 redirAttrs.addFlashAttribute("message", f.getMessage());
		    }
		 
		 redirAttrs.addFlashAttribute("message", "Success");

		
		
		return "redirect:/satuan";
	}
	
	
	@RequestMapping(value="/update/satuan", method=RequestMethod.POST)
	public String update(
			@RequestParam(value="name", required=false) String name,
			@RequestParam(value="id", required=false) int id,
			RedirectAttributes redirAttrs
			) throws ParseException
	{
		try {
			
			SatuanModel satuanModel = new SatuanModel(id,name);
			satuanService.updatedSatuan(satuanModel);
			
		}catch(DataIntegrityViolationException e) {
			 logger.error("history already exist");
		     redirAttrs.addFlashAttribute("message", "Data already exist");
		        
		}catch(Exception f) {
			redirAttrs.addFlashAttribute("message",f.getMessage());
		}
		
		return "redirect:/satuan";
	}
	
	
	
	@RequestMapping(value="/cari/satuan",method=RequestMethod.POST)
	public String cari(
			@RequestParam(value="cari", required=false)String cari,
			Model model
			) 
	{
	List<SatuanModel>satuans = satuanService.cariSatuan(cari);
	model.addAttribute("satuans", satuans);
	return "pages/tables/satuan";	
	}
	
	
	@RequestMapping("/edit/satuan/{id}")
	public String edit(@PathVariable(value="id") int id, Model model) {
		SatuanModel satuans = satuanService.getEdit(id);
		model.addAttribute("satuan", satuans);
		return "pages/forms/satuan-edit";
	}
	
	@RequestMapping("/delete/satuan/{id}")
	public String delete(@PathVariable(value="id")  int id) {
		satuanService.deleteSatuan(id);
		return "redirect:/satuan";
	}
	
	
	@RequestMapping("/view/satuan/{id}")
	public String view(@PathVariable(value="id") int id,Model model) {
		SatuanModel satuans = satuanService.getView(id);
		model.addAttribute("viewWebSatuan", satuans);
		return "pages/forms/satuan-view";
	}

}
