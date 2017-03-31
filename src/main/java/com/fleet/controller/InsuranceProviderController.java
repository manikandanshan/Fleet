package com.fleet.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.fleet.model.InsuranceProvider;
import com.fleet.service.InsuranceProviderService;

@Controller
public class InsuranceProviderController {

	@Autowired
	InsuranceProviderService insuranceProviderService;

	@Autowired
	MessageSource messageSource;
	private final Logger logger = LoggerFactory
			   .getLogger(InsuranceProviderController.class);

	/*
	 * This method will list all existing InsuranceProvider.
	 */
	@RequestMapping(value = { "/list/insurance-provider" }, method = RequestMethod.GET)
	public String listpage(ModelMap model) {

		List<InsuranceProvider> insuranceProviders = insuranceProviderService.findAll();
		model.addAttribute("insuranceProviders", insuranceProviders);
		return "list-insurance-provider";
	}

	/*
	 * This method will provide the medium to add a new Insurance Provider.
	 */

	@RequestMapping(value = { "/new/insurance-provider" }, method = RequestMethod.GET)
	public String createPage(ModelMap model) {

		InsuranceProvider insuranceProvider = new InsuranceProvider();
		model.addAttribute("insuranceProvider", insuranceProvider);
		model.addAttribute("edit", false);
		return "new-insurance-provider";
	}

	/*
	 * This method will be called on form submission, handling POST request for
	 * saving insuranceProvider in database. It also validates the user input
	 */
	@RequestMapping(value = { "/new/insurance-provider" }, method = RequestMethod.POST)
	public String save(@Valid InsuranceProvider insuranceProvider, BindingResult result,
			ModelMap model) {

		if (result.hasErrors()) {
			return "new-insurance-provider";
		}
		insuranceProviderService.save(insuranceProvider);

		model.addAttribute("success", "InsuranceProvider " + insuranceProvider.getName()
				+ " registered successfully");
		return "update-insurance-provider";
	}

	/*
	 * This method will provide the medium to update an existing insuranceProvider.
	 */
	@RequestMapping(value = { "/edit/insurance-provider/{id}" }, method = RequestMethod.GET)
	public String edit(@PathVariable Integer id, ModelMap model) {

		InsuranceProvider insuranceProvider = insuranceProviderService.findOne(id);
		model.addAttribute("insuranceProvider", insuranceProvider);
		model.addAttribute("edit", true);
		return "new-insurance-provider";
	}

	/*
	 * This method will be called on form submission, handling POST request for
	 * updating InsuranceProvider in database. It also validates the user input
	 */
	@RequestMapping(value = { "/edit/insurance-provider/{id}" }, method = RequestMethod.POST)
	public String update(@Valid InsuranceProvider insuranceProvider,
			BindingResult result, ModelMap model, @PathVariable Integer id) {

		if (result.hasErrors()) {
			return "new-insurance-provider";
		}

		insuranceProviderService.save(insuranceProvider);

		model.addAttribute("success", "InsuranceProvider " + insuranceProvider.getName()
				+ " updated successfully");
		return "update-insurance-provider";
	}

	/*
	 * This method will delete an InsuranceProvider by it's ID value.
	 */
	@RequestMapping(value = { "/delete/insurance-provider/{id}" }, method = RequestMethod.GET)
	public String delete(@PathVariable Integer id) {
		InsuranceProvider insuranceProvider = insuranceProviderService.findOne(id);
		insuranceProviderService.remove(insuranceProvider);
		return "redirect:/list/insurance-provider";
	}
	
	@RequestMapping(value = { "/delete-all/insuranceProvider/{rowCount}" }, method = RequestMethod.GET)
	public String deleteAll(@PathVariable Integer rowCount, final RedirectAttributes redirectAttributes, HttpServletRequest request,Integer id,ModelMap model) {
		logger.info("row count : " + rowCount);
		String checkBox="";
		String insuranceProviderIdStr = "";
		Integer insuranceProviderId = new Integer(java.sql.Types.NULL);
		InsuranceProvider insuranceProvider = null;
		List<InsuranceProvider> insuranceProviders = new ArrayList<InsuranceProvider>(0);
		for (int count=0; count<=rowCount; count++) {
			checkBox=request.getParameter("checkbox"+count);
			logger.debug("count : "+ count + " || checkBox : "+ checkBox);
			
			if(checkBox == null){
				checkBox = "";
			}
			
			if("on".equals(checkBox)){
				insuranceProviderIdStr = request.getParameter("insuranceProviderId" + count);
				logger.debug("count : "+ count + " || checkBox : "+ checkBox);
				
				if(insuranceProviderIdStr == null){
					insuranceProviderIdStr = "";
				}
				
				if(!"".equals(insuranceProviderIdStr)){

					// here check its number or not
					
					insuranceProviderId = new Integer(insuranceProviderIdStr);
					
					if(insuranceProviderId.intValue() > 0){
						// here need to check exception
						try {							
							insuranceProvider = insuranceProviderService.findOne(insuranceProviderId);
						}
						catch(Exception e){
							logger.debug("Exception in finding a fuelType data :- " + e);
						}
							
						}
						if(insuranceProvider != null){
							insuranceProviders.add(insuranceProvider);
						}
					}
					
				}

			}
			
			if(!insuranceProviders.isEmpty()){
				// here need to check exception
				try{
					insuranceProviderService.remove(insuranceProviders);
					redirectAttributes.addFlashAttribute("success", "INSURANCEPROVIDERS DELETED");
				}
				catch(Exception e){
					logger.debug("Exception in removing insuranceProviders data :- " + e);
					
				// here send success message to user
					
					model.addAttribute("success",   "InsuranceProviders"
							+ " deleted successfully");
				
				//otherwise send failure msg.
			}
			 
		}

		return "redirect:/list/insurance-provider";
	}

}
