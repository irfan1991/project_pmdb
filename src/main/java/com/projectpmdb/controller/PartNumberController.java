package com.projectpmdb.controller;

import java.text.ParseException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.projectpmdb.domain.UserPrincipal;
import com.projectpmdb.model.PartNumberModel;
import com.projectpmdb.model.SatuanModel;
import com.projectpmdb.service.PartNumberService;
import com.projectpmdb.service.SatuanService;




@Controller
public class PartNumberController {

	
	@Autowired
	PartNumberService partNumberService ;
	
	@Autowired
	SatuanService satuanService;
	
	 Logger logger = LoggerFactory.getLogger(PartNumberController.class);
	 
	 
	  
      
	 
	 @RequestMapping("/partnumber")
		public String index(Model model) {
		 List<PartNumberModel> partNumbers = partNumberService.selectAll();
		 model.addAttribute("parts", partNumbers);
		 Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	       UserPrincipal userPrincipal = (UserPrincipal) auth.getPrincipal();

		 model.addAttribute("userName", "Welcome " + userPrincipal.getName() + " (" + userPrincipal.getId() + ")");
			return "pages/tables/partnumber";
		}
		
	 
	 @RequestMapping("/add/partnumber")
	 public String add(Model model) {
		 List<SatuanModel> satuans = satuanService.selectAllSatuan();
		 model.addAttribute("satuans", satuans);
		 return "pages/forms/partnumber";
	 }
	 
	 
	 @RequestMapping("/save/partnumber")
	 public String save(
	
			 	@RequestParam(value = "part_number", required = false) String part_number,
	            @RequestParam(value = "part_name", required = false) String part_name,
	            @RequestParam(value = "part_stock", required = false) int part_stock,
	            @RequestParam(value = "part_uom", required = false) int part_uom,
	            @RequestParam(value = "part_date", required = false) String part_date,
	            RedirectAttributes redirAttrs
			 
	 ) throws ParseException
	 
	 {

		 try {
			 PartNumberModel partNumberModel = new PartNumberModel(0, part_number, part_name, part_stock, part_uom,part_date);
		        partNumberService.addPartNumber(partNumberModel);
		    }
		    catch (DataIntegrityViolationException e) {
		        System.out.println("history already exist");
		        logger.error("history already exist");
		        redirAttrs.addFlashAttribute("message", "Data already exist");
		        
		    } catch (Exception f) {
		    	 redirAttrs.addFlashAttribute("message", f.getMessage());
		    }
		 
		 redirAttrs.addFlashAttribute("message", "Success");

		 return "redirect:/partnumber";
	 }
	 
	 
	 @RequestMapping("/edit/partnumber/{id}")
	 public String edit(@PathVariable(value="id") int id, Model model) {
		 List<SatuanModel> satuans = satuanService.selectAllSatuan();
		 PartNumberModel getView = partNumberService.selectView(id);
		 model.addAttribute("satuans", satuans);
		 model.addAttribute("partnumber", getView);
		 return "pages/forms/partnumber-edit";
	 }
	 
	 
	 @RequestMapping("/view/partnumber/{id}")
	 public String view(@PathVariable(value="id") int id,Model model) {
		 PartNumberModel getView = partNumberService.getView(id);
		 model.addAttribute("partnumber", getView);
		 return "pages/forms/partnumber-view";
	 }
	 
	 @RequestMapping(value="/update/partnumber",method=RequestMethod.POST)
		public String updateData
		(
				 @RequestParam(value = "id", required = false) int id,
				 @RequestParam(value = "part_number", required = false) String part_number,
		         @RequestParam(value = "part_name", required = false) String part_name,
		         @RequestParam(value = "part_stock", required = false) int part_stock,
		         @RequestParam(value = "part_uom", required = false) int part_uom,
		         @RequestParam(value = "part_date", required = false) String part_date,
		         RedirectAttributes redirAttrs
		) throws ParseException
		{
		 try {
			PartNumberModel nilaiUpdate  = new PartNumberModel(id,part_number,part_name,part_stock,part_uom,part_date);
			partNumberService.updatePartNumber(nilaiUpdate);
		  }
		    catch (DataIntegrityViolationException e) {
		        System.out.println("history already exist");
		        logger.error("history already exist");
		        redirAttrs.addFlashAttribute("message", "Data already exist");
		        
		    } catch (Exception f) {
		    	 redirAttrs.addFlashAttribute("message", f.getMessage());
		    }
		 
			return "redirect:/partnumber";	
		}
	 
	 
	 @RequestMapping("/delete/partnumber/{id}")
	 public String delete(@PathVariable(value="id")int id) {
		 
		 partNumberService.deletePartNumber(id);
		 return "redirect:/partnumber";
	 }
	 
	 
	 @RequestMapping(value="/search/partnumber",method=RequestMethod.POST)
	 public String search	(
			 @RequestParam(value = "date1", required = false) String part_date,
	         @RequestParam(value = "date2", required = false) String part_date2,
	         Model model
	         
	) 
	{
		List<PartNumberModel>  partNumbers = partNumberService.selectByDate(part_date,part_date2);
		model.addAttribute("parts",partNumbers);
		return "pages/tables/partnumber";
	}
	 
	 @RequestMapping(value="/cari/partnumber", method=RequestMethod.POST)
	 public String cari(
			 
			 @RequestParam(value = "part_name", required = false) String part_name,
			 Model mode
			 
			 )
	 		
	 		
	 {
		 List<PartNumberModel> partNumbers = partNumberService.getCariBarang(part_name);
		 mode.addAttribute("parts", partNumbers);
		 return "pages/tables/partnumber";
	 }
}
