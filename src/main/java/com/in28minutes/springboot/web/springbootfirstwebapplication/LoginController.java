package com.in28minutes.springboot.web.springbootfirstwebapplication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("name")
public class LoginController {

	@Autowired
    private LoginService service;
	
	@RequestMapping(value = "/login",method = RequestMethod.GET)
    public String showLogin(ModelMap model) {
        return "login";
    }
	@RequestMapping(value = "/login",method = RequestMethod.POST)
    public String showWelcome(ModelMap model , @RequestParam String name , @RequestParam String password) {
		   boolean isValidUser = service.validateUser(name, password);

	        if (isValidUser) {
	            model.put("name", name);
	            return "welcome";
	        } else {
	            model.put("errorMessage", "Invalid Credentials!!");
	            return "login";
	        }
    }
}
