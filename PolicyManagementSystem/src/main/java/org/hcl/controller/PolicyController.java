package org.hcl.controller;

import java.util.List;
import java.util.Random;

import org.hcl.model.Policy;
import org.hcl.services.PolicyService;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class PolicyController {

	private static Logger log = Logger.getLogger(PolicyController.class);
	@Autowired
	private PolicyService policyservice;

	@RequestMapping(value = "/policyreg", method = RequestMethod.GET)
	public String showPolicy(ModelMap theModel) {
		log.info("Request inside into the Policy Registeration");
		Policy policyregister = new Policy();
		theModel.addAttribute("policyform", policyregister);
		return "policyRegister";
	}

	@RequestMapping(value = "/fetchById/{id}")
	public String fetchPolicyById(@PathVariable("id") Integer polId, ModelMap map) {
		log.info("fetch the edit policy");
		Policy policyregister = policyservice.fetchPolicyById(polId);
		map.addAttribute("editPolicy", policyregister);
		return "policyUpdate";

	}

	@RequestMapping(value = "/editPol", method = RequestMethod.POST)
	public String updatePolicy(@Validated @ModelAttribute("editPolicy") Policy policy, BindingResult result,
			ModelMap map) {
		String editpage;
		if (result.hasErrors()) {
			log.info("the method edit page has some errors");
			editpage = "policyUpdate";
		} else {
			log.info("the method has correct path way");
			policyservice.updatePolicy(policy);
			List<Policy> policylist = policyservice.fetchPolicy();
			map.addAttribute("policylist", policylist);
			editpage = "policySuccess";
		}
		return editpage;

	}

	@RequestMapping(value = "/delete/{id}")
	public String deleteEmployee(@PathVariable("id") Integer polId, ModelMap map) {
		log.info("deleting policy based on policy id");
		policyservice.deletePolicy(polId);
		List<Policy> policy = policyservice.fetchPolicy();
		map.addAttribute("Policy1", policy);
		return "policySuccess";
	}

	@RequestMapping(value = "/savepolicy", method = RequestMethod.POST)
	public String savepolicy(@Validated @ModelAttribute("policyform") Policy policyregister, BindingResult result,
			ModelMap map) {
		String page;
		if (result.hasErrors()) {
			log.info("method has some error");
			page = "policyRegister";
		} else {
			log.info("method has correct path way");
			Random random = new Random();
			int pid = random.nextInt(99999) + 10000;
			policyregister.setId(pid);
			policyservice.savepolicy(policyregister);
			List<Policy> policylist = policyservice.fetchPolicy();
			map.addAttribute("policy", policylist);
			page = "policySuccess";
		}
		return page;
	}

	@RequestMapping(value = "/usepolicyid", method = RequestMethod.GET)
	public String searchpolicyid(ModelMap map) {
		log.info("User select to search the Policy BY POLICYID method");
		Policy policy = new Policy();
		map.addAttribute("getpolicy", policy);
		return "PolicyById";
	}

	@RequestMapping(value = "/pid", method = RequestMethod.POST)
	public String searchpid(@Validated @ModelAttribute("getpolicy") Policy policy, BindingResult result, ModelMap map) {
		log.info(" Invoking the Search Policy BY POLICYID method");
		Integer pid = policy.getId();
		System.out.println(pid);
		List<Policy> policy2 = policyservice.fetchpolicyId(pid);
		map.addAttribute("getpolicy", policy2);
		return "PolicyDetails";
	}

	@RequestMapping(value = "/modepay", method = RequestMethod.POST)
	public String paymentmodeForm(ModelMap map) {
		log.info("Request inside PAYMENT MODE method");
		return "ModePay";
	}

	@RequestMapping(value = "/modepays", method = RequestMethod.POST)
	public String paysuccess(ModelMap map) {
		log.info("Paymentsuccess method");
		return "PaymentSuccess";
	}

	@RequestMapping(value = "/paymentpage", method = RequestMethod.GET)
	public String paymentForm(ModelMap map) {
		log.info("Request inside PAYMENT FORM method");

		return "Payment";
	}
}
