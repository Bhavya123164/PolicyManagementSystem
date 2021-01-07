package org.hcl.controller;

import java.util.List;
import java.util.Random;

import org.hcl.model.User;
import org.hcl.services.PolicyService;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller

public class UserController {
	private static Logger log = Logger.getLogger(UserController.class);
	@Autowired
	private PolicyService policyservice;

	@RequestMapping(value = "/userreg", method = RequestMethod.GET)
	public String showForm(ModelMap theModel) {
		log.info("Request inside into the registeration");

		User user = new User();

		theModel.addAttribute("userpeople", user);
		return "user";
	}

	@RequestMapping(value = "/userloginsucess", method = RequestMethod.POST)
	public String UserSuccess() {
		return "userLoginsuccess";
	}

	@RequestMapping(value = "/usersearch", method = RequestMethod.GET)
	public String userSearch(ModelMap map) {
		log.info("User Search Policy method");
		return "searchPolicy";
	}

	@RequestMapping(value = "/userloginpage", method = RequestMethod.GET)
	public String UserRegistrationForm(ModelMap map) {
		log.info("Request inside USER REGISTRATION FORM method");
		User user = new User();
		map.addAttribute("UserForm", user);
		return "UserLogin";
	}

	@RequestMapping(value = "/registers", method = RequestMethod.POST)
	public String show(@Validated @ModelAttribute("userpeople") User user, BindingResult result, ModelMap map) {
		String page;
		if (result.hasErrors()) {
			log.info("method has some error");
			page = "user";
		} else {
			log.info("method has correct path way");
			Random random = new Random();
			int pid = random.nextInt(99999) + 10000;
			user.setId(pid);
			policyservice.show(user);
			List<User> uList = policyservice.fetchUser();
			map.addAttribute("userList", uList);
			page = "success";

		}
		return page;

	}
}
