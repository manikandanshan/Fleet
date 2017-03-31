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

import com.fleet.model.VehicleInsurance;
import com.fleet.service.VehicleInsuranceService;

/**
 * @author shine
 *
 */
@Controller
public class VehicleInsuranceController {
	@Autowired
	VehicleInsuranceService vehicleInsuranceService;
	@Autowired
	MessageSource messageSource;
	private final Logger logger = LoggerFactory
			   .getLogger(VehicleInsuranceController.class);

	/*
	 * This method will list all existing vehicles.
	 */
	@RequestMapping(value = { "/list/vehicle-insurance" }, method = RequestMethod.GET)
	public String listPage(ModelMap model) {
		List<VehicleInsurance> vehicleInsurances = vehicleInsuranceService.findAll();
		model.addAttribute("vehicleInsurances", vehicleInsurances);
		return "list-vehicle-insurance";
	}

	/*
	 * This method will provide the medium to add a new vehicleInsurance.
	 */
	@RequestMapping(value = { "/new/vehicle-insurance" }, method = RequestMethod.GET)
	public String newPage(ModelMap model) {
		VehicleInsurance vehicleInsurance = new VehicleInsurance();
		model.addAttribute("vehicleInsurance", vehicleInsurance);
		model.addAttribute("edit", false);
		return "new-vehicle-insurance";
	}

	/*
	 * This method will be called on form submission, handling POST request for
	 * saving vehicleInsurance in database. It also validates the user input
	 */
	@RequestMapping(value = { "/new/vehicle-insurance" }, method = RequestMethod.POST)
	public String savePage(@Valid VehicleInsurance vehicleInsurance,
			BindingResult result, ModelMap model) {

		if (result.hasErrors()) {
			return "list-vehicle-insurance";
		}
			vehicleInsuranceService.save(vehicleInsurance);
			model.addAttribute("success"," Vehicle Insurance with policy number  " + vehicleInsurance.getInsurancePolicyNumber()+ " registered successfully");
			return "update-vehicle-insurance";
	}
	
	/*
	  * This method will provide the medium to update an existing vehicleInsurance.
	 */
	@RequestMapping(value = { "/edit/vehicle-insurance/{id}" }, method = RequestMethod.GET)
	public String editPage (@PathVariable Integer id, ModelMap model) {
		VehicleInsurance vehicleInsurance=vehicleInsuranceService.findOne(id);
		model.addAttribute("vehicleInsurance", vehicleInsurance);
		model.addAttribute("edit", true);
		return "new-vehicle-insurance";
	}
	/*
	 * This method will be called on form submission, handling POST request for
	 * updating vehicleInsurance in database. It also validates the user input
	 */
	@RequestMapping(value = { "/edit/vehicle-insurance/{id}" }, method = RequestMethod.POST)
	public String updatePage(@Valid VehicleInsurance vehicleInsurance, BindingResult result,
			ModelMap model, @PathVariable Integer id) {
		if (result.hasErrors()) {
			return "new-vehicle-insurance";
		}
		vehicleInsuranceService.save(vehicleInsurance);
		model.addAttribute("success", " Vehicle Insurance with policy number " + vehicleInsurance.getInsurancePolicyNumber()+ " updated successfully");
		return "update-vehicle-insurance";
	}
	/*
	 * This method will delete an vehicleInsurance by it's id value.
	 */
	@RequestMapping(value = { "/delete/vehicle-insurance/{id}" }, method = RequestMethod.GET)
	public String deletePage(@PathVariable Integer id) {
		VehicleInsurance vehicleInsurance=vehicleInsuranceService.findOne(id);
		vehicleInsuranceService.remove(vehicleInsurance);
		return "redirect:/list/vehicle-insurance";
	}
	
	@RequestMapping(value = { "/delete-all/vehicleInsurance/{rowCount}" }, method = RequestMethod.GET)
	public String deleteAll(@PathVariable Integer rowCount, final RedirectAttributes redirectAttributes, HttpServletRequest request,Integer id,ModelMap model) {
		logger.info("row count : " + rowCount);
		String checkBox="";
		String vehicleInsuranceIdStr = "";
		Integer vehicleInsuranceId = new Integer(java.sql.Types.NULL);
		VehicleInsurance vehicleInsurance = null;
		List<VehicleInsurance> vehicleInsurances = new ArrayList<VehicleInsurance>(0);
		for (int count=0; count<=rowCount; count++) {
			checkBox=request.getParameter("checkbox"+count);
			logger.debug("count : "+ count + " || checkBox : "+ checkBox);
			
			if(checkBox == null){
				checkBox = "";
			}
			
			if("on".equals(checkBox)){
				vehicleInsuranceIdStr = request.getParameter("vehicleInsuranceId" + count);
				logger.debug("count : "+ count + " || checkBox : "+ checkBox);
				
				if(vehicleInsuranceIdStr == null){
					vehicleInsuranceIdStr = "";
				}
				
				if(!"".equals(vehicleInsuranceIdStr)){

					// here check its number or not
					
					vehicleInsuranceId = new Integer(vehicleInsuranceIdStr);
					
					if(vehicleInsuranceId.intValue() > 0){
						// here need to check exception
						try {							
							vehicleInsurance = vehicleInsuranceService.findOne(vehicleInsuranceId);
						}
						catch(Exception e){
							logger.debug("Exception in finding a vehicleInsurance data :- " + e);
						}
							
						}
						if(vehicleInsurance != null){
							vehicleInsurances.add(vehicleInsurance);
						}
					}
					
				}

			}
			
			if(!vehicleInsurances.isEmpty()){
				// here need to check exception
				try{
					vehicleInsuranceService.remove(vehicleInsurances);
					redirectAttributes.addFlashAttribute("success", "vehicleInsuranceS DELETED");
				}
				catch(Exception e){
					logger.debug("Exception in removing vehicleInsurances data :- " + e);
					
				// here send success message to user
					
					model.addAttribute("success",   "VehicleInsurances"
							+ " deleted successfully");
				
				//otherwise send failure msg.
			}
			 
		}

		return "redirect:/list/vehicle-insurance";
	}



}
