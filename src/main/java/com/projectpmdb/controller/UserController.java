package com.projectpmdb.controller;

import java.text.ParseException;
import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.projectpmdb.domain.UserPrincipal;
import com.projectpmdb.model.PartNumberModel;
import com.projectpmdb.model.SatuanModel;
import com.projectpmdb.model.SupplierModel;
import com.projectpmdb.model.UserModel;
import com.projectpmdb.service.UserServiceDatabase;

@Controller
public class UserController {

	 @Autowired
	 private UserServiceDatabase userService;
	 

		Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@RequestMapping("/user")
	public String index(Model model) {
		List<UserModel>users= userService.selectAllUsers();
		model.addAttribute("users", users);
		return "pages/tables/user";
	}
	
	
	@RequestMapping(value="/cari/user",method=RequestMethod.POST)
	public String cari(
			@RequestParam(value="cari", required=false)String cari,
			Model model
			) 
	{
	List<UserModel>users = userService.cariNamaUser(cari);
	model.addAttribute("users", users);
	return "pages/tables/user";	
	}
	
	@RequestMapping("/user/delete/{id}")
	public String delete(@PathVariable(value="id")  int id) {
		userService.deleteUser(id);
		return "redirect:/user";
	}
	
	  @GetMapping(value = {"/", "login"})
	    public ModelAndView getLoginPage() {
	        ModelAndView modelAndView = new ModelAndView();
	        modelAndView.setViewName("login");
	        return modelAndView;
	    }

	    @GetMapping("/user/add")
	    public ModelAndView getRegistrationPage() {
	        ModelAndView modelAndView = new ModelAndView();
	        UserModel user = new UserModel();
	        modelAndView.addObject("user", user);
	        modelAndView.setViewName("pages/forms/user");

	        return modelAndView;
	    }

	    @PostMapping("/user/save")
	    public ModelAndView createNewUser(@Valid UserModel user, BindingResult bindingResult) {
	        ModelAndView modelAndView = new ModelAndView();

	        UserModel userExists = userService.findUserByLoginId(user.getLoginId());
	        if (userExists != null) {
	            bindingResult
	                .rejectValue("loginId", "error.loginId",
	                    "There is already a user registered with the loginId provided");
	        }

	        if (bindingResult.hasErrors()) {
	            modelAndView.addObject("user", new UserModel());
	            modelAndView.addObject("successMessage", "Any Something wrong ");
	            modelAndView.setViewName("pages/forms/user");
	        } else {
	            userService.saveUser(user);
	            modelAndView.addObject("successMessage", "User has been registered successfully");
	            modelAndView.addObject("user", new UserModel());
	            modelAndView.setViewName("pages/forms/user");
	        }

	        return modelAndView;
	    }

	   
	    @GetMapping("exception")
	    public ModelAndView getUserPermissionExceptionPage() {
	        ModelAndView mv = new ModelAndView();

	        mv.setViewName("404");

	        return mv;
	    }
	    
	    @RequestMapping("/edit/user/{id}")
		public String edit(@PathVariable(value="id")int id, Model model) {
			UserModel user = userService.getEdit(id);
			model.addAttribute("user", user);
			return "pages/forms/user-edit";
		}
	    
	    
	    @RequestMapping("/view/user/{id}")
		public String view(@PathVariable(value="id")int id, Model model) {
			UserModel user = userService.getView(id);
			model.addAttribute("user", user);
			return "pages/forms/user-view";
		}
	    
	    @RequestMapping(value="/user/update", method=RequestMethod.POST)
		public String update(
				@RequestParam(value="userName", required=false) String userName,
				@RequestParam(value="loginId", required=false) String loginId,
				@RequestParam(value="id", required=false) int id,
				@RequestParam(value="active", required=false) int active,
				@RequestParam(value="createdAt", required=false) String createdAt,
				RedirectAttributes redirAttrs
				) throws ParseException
		{
			try {
				
				UserModel userModel = new UserModel(id,userName,loginId,active,createdAt);
				userService.updateUser(userModel);
				
			}catch(DataIntegrityViolationException e) {
				 logger.error("history already exist");
			     redirAttrs.addFlashAttribute("message", "Data already exist");
			        
			}catch(Exception f) {
				redirAttrs.addFlashAttribute("message",f.getMessage());
			}
			
			return "redirect:/user";
		}
	    
	    @RequestMapping(value="/user/updatepassword", method=RequestMethod.POST)
		public String updatePassword(
				@RequestParam(value="password", required=false) String password,
				@RequestParam(value="id", required=false) int id,
				@RequestParam(value="createdAt", required=false) String createdAt,
				RedirectAttributes redirAttrs
				) throws ParseException
		{
			try {
				
				UserModel userModel = new UserModel(id,password,createdAt);
				userService.updatePassword(userModel);
				
			}catch(DataIntegrityViolationException e) {
				 logger.error("history already exist");
			     redirAttrs.addFlashAttribute("message", "Data already exist");
			        
			}catch(Exception f) {
				redirAttrs.addFlashAttribute("message",f.getMessage());
			}
			
			return "redirect:/user";
		}
	    
	   @RequestMapping("/changepass/user/{id}")
	   public String changePassword(@PathVariable(value="id") int id, Model model) {
		  UserModel user= userService.getEdit(id);
		  model.addAttribute("user", user);
		   return "pages/forms/user-change-password";
	   }
	   
	   
	   @RequestMapping(value="/searchdate/user",method=RequestMethod.POST)
		 public String search	(
				 @RequestParam(value = "createdAt", required = false) String createdAt,
		         @RequestParam(value = "createdAt2", required = false) String createdAt2,
		         Model model
		         
		) 
		{
			List<UserModel>  users = userService.searchDate(createdAt, createdAt2);
			model.addAttribute("users",users);
			return "pages/tables/user";
		}
		 
}
