package org.hcl.controller;

import java.util.List;

import java.util.Random;

import org.hcl.model.Admin;
import org.hcl.services.PolicyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sun.istack.logging.Logger;

@Controller
public class AdminController {

	private static Logger log = Logger.getLogger(AdminController.class);
	@Autowired
	private PolicyService policyservice;

	@RequestMapping(value = "/adminreg", method = RequestMethod.GET)
	public String showForm(ModelMap theModel) {
		log.info("Request inside into the registeration");

		Admin admin = new Admin();

		theModel.addAttribute("adminpeople", admin);
		return "admin";
	}

	@RequestMapping(value = "/adminloginsucess", method = RequestMethod.POST)
	public String AdminSuccess() {
		return "adminLoginsucess";
	}

	@RequestMapping(value = "/adminloginpage", method = RequestMethod.GET)
	public String AdminRegistrationForm(ModelMap map) {
		log.info("Request inside Admin REGISTRATION FORM method");
		Admin admin = new Admin();
		map.addAttribute("AdminForm", admin);
		return "adminlogin";
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String show(@Validated @ModelAttribute("adminpeople") Admin admin, BindingResult result, ModelMap map) {
		String page;
		if (result.hasErrors()) {
			log.info("method has some error");
			page = "admin";
		} else {
			log.info("method has correct path way");
			Random random = new Random();
			int pid = random.nextInt(99999) + 10000;
			admin.setId(pid);
			policyservice.showadmin(admin);
			List<Admin> aList = policyservice.fetchAdmin();
			map.addAttribute("adminList", aList);
			page = "adminsuccess";

		}
		return page;

	}

}
