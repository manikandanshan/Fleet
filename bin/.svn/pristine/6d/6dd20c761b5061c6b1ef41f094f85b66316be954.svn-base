/**
 * 
 */
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

import com.fleet.model.FitnessCertificate;
import com.fleet.service.FitnessCertificateService;

/**
 * @author shine
 *
 */
@Controller
public class FitnessCertificateController {
	@Autowired
	FitnessCertificateService fitnessCertificateService;
	@Autowired
	MessageSource messageSource;
	
	private final Logger logger = LoggerFactory
			   .getLogger(FitnessCertificateController.class);
	
	/*
	 * This method will list all existing vehicles.
	 */
	@RequestMapping(value = { "/list/fitness-certificate" }, method = RequestMethod.GET)
	public String listPage(ModelMap model) {
		List<FitnessCertificate> fitnessCertificates = fitnessCertificateService.findAll();
		model.addAttribute("fitnessCertificates", fitnessCertificates);
		return "list-fitness-certificate";
	}

	/*
	 * This method will provide the medium to add a new fitnessCertificate.
	 */
	@RequestMapping(value = { "/new/fitness-certificate" }, method = RequestMethod.GET)
	public String newPage(ModelMap model) {
		FitnessCertificate fitnessCertificate = new FitnessCertificate();
		model.addAttribute("fitnessCertificate", fitnessCertificate);
		model.addAttribute("edit", false);
		return "new-fitness-certificate";
	}

	/*
	 * This method will be called on form submission, handling POST request for
	 * saving fitnessCertificate in database. It also validates the user input
	 */
	@RequestMapping(value = { "/new/fitness-certificate" }, method = RequestMethod.POST)
	public String savePage(@Valid FitnessCertificate fitnessCertificate,
			BindingResult result, ModelMap model) {
		if (result.hasErrors()) {
			return "list-fitness-certificate";
		}
			fitnessCertificateService.save(fitnessCertificate);
			model.addAttribute("success"," Fitness Certificate for Rs.  " + fitnessCertificate.getAmount() + " is registered successfully");
			return "update-fitness-certificate";
	}
	
	/*
	  * This method will provide the medium to update an existing fitnessCertificate.
	 */
	@RequestMapping(value = { "/edit/fitness-certificate/{id}" }, method = RequestMethod.GET)
	public String editPage (@PathVariable Integer id, ModelMap model) {
		FitnessCertificate fitnessCertificate=fitnessCertificateService.findOne(id);
		model.addAttribute("fitnessCertificate", fitnessCertificate);
		model.addAttribute("edit", true);
		return "new-fitness-certificate";
	} 
	/*
	 * This method will be called on form submission, handling POST request for
	 * updating fitnessCertificate in database. It also validates the user input
	 */
	@RequestMapping(value = { "/edit/fitness-certificate/{id}" }, method = RequestMethod.POST)
	public String updatePage(@Valid FitnessCertificate fitnessCertificate, BindingResult result,
			ModelMap model, @PathVariable Integer id) {
		if (result.hasErrors()) {
			return "new-fitness-certificate";
		}
		fitnessCertificateService.save(fitnessCertificate);
		model.addAttribute("success", " Fitness Certificate for Rs. " + fitnessCertificate.getAmount() + " is updated successfully");
		return "update-fitness-certificate";
	}
	/*
	 * This method will delete an fitnessCertificate by it's id value.
	 */
	@RequestMapping(value = { "/delete/fitness-certificate/{id}" }, method = RequestMethod.GET)
	public String deletePage(@PathVariable Integer id) {
		FitnessCertificate fitnessCertificate=fitnessCertificateService.findOne(id);
		fitnessCertificateService.remove(fitnessCertificate);
		return "redirect:/list/fitness-certificate";
	}
	@RequestMapping(value = { "/delete-all/fitnessCertificate/{rowCount}" }, method = RequestMethod.GET)
	public String deleteAll(@PathVariable Integer rowCount, final RedirectAttributes redirectAttributes, HttpServletRequest request,Integer id,ModelMap model) {
		logger.info("row count : " + rowCount);
		String checkBox="";
		String fitnessCertificateIdStr = "";
		Integer fitnessCertificateId = new Integer(java.sql.Types.NULL);
		FitnessCertificate fitnessCertificate = null;
		List<FitnessCertificate> fitnessCertificates = new ArrayList<FitnessCertificate>(0);
		for (int count=0; count<=rowCount; count++) {
			checkBox=request.getParameter("checkbox"+count);
			logger.debug("count : "+ count + " || checkBox : "+ checkBox);
			
			if(checkBox == null){
				checkBox = "";
			}
			
			if("on".equals(checkBox)){
				fitnessCertificateIdStr = request.getParameter("fitnessCertificateId" + count);
				logger.debug("count : "+ count + " || checkBox : "+ checkBox);
				
				if(fitnessCertificateIdStr == null){
					fitnessCertificateIdStr = "";
				}
				
				if(!"".equals(fitnessCertificateIdStr)){

					// here check its number or not
					
					fitnessCertificateId = new Integer(fitnessCertificateIdStr);
					
					if(fitnessCertificateId.intValue() > 0){
						// here need to check exception
						try {							
							fitnessCertificate = fitnessCertificateService.findOne(fitnessCertificateId);
						}
						catch(Exception e){
							logger.debug("Exception in finding a fitnessCertificate data :- " + e);
						}
							
						}
						if(fitnessCertificate != null){
							fitnessCertificates.add(fitnessCertificate);
						}
					}
					
				}

			}
			
			if(!fitnessCertificates.isEmpty()){
				// here need to check exception
				try{
					fitnessCertificateService.remove(fitnessCertificates);
					redirectAttributes.addFlashAttribute("success", "FITNESSCERTIFICATES DELETED");
				}
				catch(Exception e){
					logger.debug("Exception in removing fitnessCertificates data :- " + e);
					
				// here send success message to user
					
					model.addAttribute("success",   "fitnessCertificates"
							+ " deleted successfully");
				
				//otherwise send failure msg.
			}
			 
		}

		return "redirect:/list/fitness-certificate";
	}


}
