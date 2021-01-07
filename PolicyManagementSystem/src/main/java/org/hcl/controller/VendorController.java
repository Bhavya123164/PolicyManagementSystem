package org.hcl.controller;

import java.util.List;
import java.util.Random;

import org.hcl.model.Vendor;
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
public class VendorController {
	private static Logger log = Logger.getLogger(VendorController.class);
	@Autowired
	private PolicyService policyservice;

	@RequestMapping(value = "/vendorregpage", method = RequestMethod.GET)
	public String vendorRegistrationForm(ModelMap map) {
		log.info("Request inside VENDOR REGISTRATION FORM method");
		Vendor vendor = new Vendor();
		map.addAttribute("vendorForm", vendor);
		return "VendorRegister";
	}

	@RequestMapping(value = "/savevendor", method = RequestMethod.POST)
	public String saveVendor(@Validated @ModelAttribute("vendorForm") Vendor vendor, BindingResult result,
			ModelMap map) {
		String viewpage;
		if (result.hasErrors()) {
			log.info("Validation error occured");
			viewpage = "VendorRegister";
		} else {
			log.info("Invoking savevendor method");
			Random random = new Random();
			int id = random.nextInt(99999) + 10000;
			vendor.setId(id);
			policyservice.saveVendor(vendor);
			List<Vendor> vendorli = policyservice.fetchVendor();
			map.addAttribute("vendorList", vendorli);
			viewpage = "Vendorsuccess";
		}
		return viewpage;
	}

	@RequestMapping(value = "/vendorloginpage", method = RequestMethod.GET)
	public String vendorLoginForm(ModelMap map) {
		log.info("Request inside VENDOR LOGIN FORM method");
		Vendor vendor = new Vendor();
		map.addAttribute("vendorLogin", vendor);
		return "VendorLogin";
	}

	@RequestMapping(value = "/vendorsucess", method = RequestMethod.POST)
	public String VendorSuccess() {
		return "VendorLoginSuccess";
	}

}
