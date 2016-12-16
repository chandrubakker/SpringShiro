package com.sorcererpaws.SpringShiro.web;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.sorcererpaws.SpringShiro.entity.User;

@Controller
public class AuthController {

	private static final Logger LOGGER = LoggerFactory.getLogger(AuthController.class);
	/*@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView loginPage(@RequestParam(value = "logout", required = false)String logout) {
		
		if(logout != null) {
			
			logout = "You Have Been Successfully Logged Out";
			return new ModelAndView("login").addObject("logout", logout);
		} else {
			
			return new ModelAndView("global/login");
		}
	}*/
	
	@RequestMapping(value = "/login", method = RequestMethod.GET) 
    public String login() { 
        if (null != SecurityUtils.getSubject() && null != SecurityUtils.getSubject().getSession()) { 
            SecurityUtils.getSubject().logout();
        } 
        return "login"; 
    }
	
	@RequestMapping(value = "/login", method = RequestMethod.POST) 
    public String fail(@RequestParam(FormAuthenticationFilter.DEFAULT_USERNAME_PARAM) 
    String userName, Model model) { 
        if (null != SecurityUtils.getSubject() && null != SecurityUtils.getSubject().getSession()) {
        	LOGGER.info("Login failed");
        	LOGGER.info("Logged in user: " + userName);
            SecurityUtils.getSubject().logout();
        } 
        model.addAttribute(FormAuthenticationFilter.DEFAULT_USERNAME_PARAM, userName); 
        return "login"; 
    }
	
	/*@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView loginPage() {
		
		return new ModelAndView("login");
	}*/
	
	@RequestMapping(value = "/success", method = RequestMethod.GET)
	public ModelAndView successPage() {
		Subject subject = SecurityUtils.getSubject();
		try {
			User user = (User) subject.getPrincipal();
			LOGGER.info("email: "+ user.getEmail());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		LOGGER.info("Login Success");
		LOGGER.info("subject.isAuthenticated(): " + subject.isAuthenticated());
		LOGGER.info("subject.getPrincipal().toString(): " + subject.getPrincipal().toString());
		LOGGER.info("subject.hasRole(\"admin\"): " + subject.hasRole("admin"));
		if(subject.hasRole("lab")) {
			LOGGER.info("Logged in user is lab");
			return new ModelAndView("redirect:/lab/dashboard");
		} else if(subject.hasRole("admin")) {
			LOGGER.info("Logged in user is admin");
			return new ModelAndView("redirect:/admin/dashboard");
		} else {
			LOGGER.info("Logged in user is unknown");
			return new ModelAndView("redirect:/login");
		}
	}
	
	@RequestMapping(value = "/lab/dashboard", method = RequestMethod.GET)
	public String labDashboard() {
		return "lab/dashboard";
	}
	
	@RequestMapping(value = "/admin/dashboard", method = RequestMethod.GET)
	public String adminDashboard() {
		return "admin/dashboard";
	}
	
	@RequestMapping(value = "/unauthorized", method = RequestMethod.GET)
	public ModelAndView unAuthorizedPage() {
		
		return new ModelAndView("global/unauthorized");
	}
}
