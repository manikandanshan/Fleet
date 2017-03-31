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

import com.fleet.model.FuelType;
import com.fleet.service.FuelTypeService;

@Controller
public class FuelTypeController {

	@Autowired
	FuelTypeService fuelTypeService;

	@Autowired
	MessageSource messageSource;
	
	private final Logger logger = LoggerFactory
			   .getLogger(FuelTypeController.class);

	/*
	 * This method will list all existing fueltype.
	 */
	@RequestMapping(value = { "/list/fuel-type" }, method = RequestMethod.GET)
	public String listPage(ModelMap model) {

		List<FuelType> fuelTypes = fuelTypeService.findAll();
		model.addAttribute("fuelTypes", fuelTypes);
		return "list-fuel-type";
	}

	/*
	 * This method will provide the medium to add a new fueltype.
	 */

	@RequestMapping(value = { "/new/fuel-type" }, method = RequestMethod.GET)
	public String createPage(ModelMap model) {

		FuelType fuelType = new FuelType();
		model.addAttribute("fuelType", fuelType);
		model.addAttribute("edit", false);
		return "new-fuel-type";
	}

	/*
	 * This method will be called on form submission, handling POST request for
	 * saving fueltype in database. It also validates the user input
	 */
	@RequestMapping(value = { "/new/fuel-type" }, method = RequestMethod.POST)
	public String savePage(@Valid FuelType fuelType, final RedirectAttributes redirectAttributes, BindingResult result,
			ModelMap model) {

		if (result.hasErrors()) {
			return "new-fuel-type";
		}

		fuelTypeService.save(fuelType);
	
		model.addAttribute("success", "FuelType " + fuelType.getName()
				+ " registered successfully");
		//System.out.println("i am saved");
		redirectAttributes.addFlashAttribute("success",  "Added to FuelType  "  + fuelType.getName());

		return "redirect:/new/fuel-type";
		
		//return "update-fuel-type";
	}

	/*
	 * This method will provide the medium to update an existing fueltype.
	 */
	@RequestMapping(value = { "/edit/fuel-type/{id}" }, method = RequestMethod.GET)
	public String edit(@PathVariable Integer id, ModelMap model) {

		FuelType fuelType = fuelTypeService.findOne(id);
		model.addAttribute("fuelType", fuelType);
		model.addAttribute("edit", true);
		return "new-fuel-type";
	}

	/*
	 * This method will be called on form submission, handling POST request for
	 * updating fueltype in database. It also validates the user input
	 */
	@RequestMapping(value = { "/edit/fuel-type/{id}" }, method = RequestMethod.POST)
	public String update(@Valid FuelType fuelType,
			BindingResult result, ModelMap model,final RedirectAttributes redirectAttributes,  @PathVariable Integer id) {

		if (result.hasErrors()) {
			return "new-fuel-type";
		}

		

		fuelTypeService.save(fuelType);
		//redirectAttributes.addFlashAttribute("success", "Added to list");

		model.addAttribute("success", "FuelType " + fuelType.getName()
				+ " updated successfully");
		
		redirectAttributes.addFlashAttribute("success", "Updated to FuelType  "  + fuelType.getName());
		//return "update-fuel-type";
		return "redirect:/new/fuel-type";
	
	}

	/*
	 * This method will delete a Fuel Type by it's ID value.
	 */
	@RequestMapping(value = { "/delete/fuel-type/{id}" }, method = RequestMethod.GET)
	public String delete(@PathVariable Integer id) {
		FuelType fuelType = fuelTypeService.findOne(id);
		fuelTypeService.remove(fuelType);
		return "redirect:/list/fuel-type";
	}
	/**@RequestMapping(value = { "/delete/fuel-type/{id}" }, method = RequestMethod.GET)
	public String delete(@PathVariable Integer id, ModelMap model) {

		FuelType fuelType = fuelTypeService.findOne(id);
		model.addAttribute("fuelType", fuelType);
		model.addAttribute("delete", true);
		return "redirect:/list/fuel-type";
	}
	@RequestMapping(value = { "/delete/fuel-type/{id}" }, method = RequestMethod.POST)
	public String delete(@Valid FuelType fuelType,
			BindingResult result, ModelMap model,final RedirectAttributes redirectAttributes,  @PathVariable Integer id) {
		model.remove(id);
		fuelTypeService.remove(fuelType);
		return "redirect:/list/fuel-type";
	
	
	}**/
	@RequestMapping(value = { "/delete-all/fuelType/{rowCount}" }, method = RequestMethod.GET)
	public String deleteAll(@PathVariable Integer rowCount, final RedirectAttributes redirectAttributes, HttpServletRequest request,Integer id,ModelMap model) {
		logger.info("row count : " + rowCount);
		String checkBox="";
		String fuelTypeIdStr = "";
		Integer fuelTypeId = new Integer(java.sql.Types.NULL);
		FuelType fuelType = null;
		List<FuelType> fuelTypes = new ArrayList<FuelType>(0);
		for (int count=0; count<=rowCount; count++) {
			checkBox=request.getParameter("checkbox"+count);
			logger.debug("count : "+ count + " || checkBox : "+ checkBox);
			
			if(checkBox == null){
				checkBox = "";
			}
			
			if("on".equals(checkBox)){
				fuelTypeIdStr = request.getParameter("fuelTypeId" + count);
				logger.debug("count : "+ count + " || checkBox : "+ checkBox);
				
				if(fuelTypeIdStr == null){
					fuelTypeIdStr = "";
				}
				
				if(!"".equals(fuelTypeIdStr)){

					// here check its number or not
					
					fuelTypeId = new Integer(fuelTypeIdStr);
					
					if(fuelTypeId.intValue() > 0){
						// here need to check exception
						try {							
							fuelType = fuelTypeService.findOne(fuelTypeId);
						}
						catch(Exception e){
							logger.debug("Exception in finding a fuelType data :- " + e);
						}
							
						}
						if(fuelType != null){
							fuelTypes.add(fuelType);
						}
					}
					
				}

			}
			
			if(!fuelTypes.isEmpty()){
				// here need to check exception
				try{
					fuelTypeService.remove(fuelTypes);
					redirectAttributes.addFlashAttribute("success", "FUELTYPES DELETED");
				}
				catch(Exception e){
					logger.debug("Exception in removing fuelTypes data :- " + e);
					
				// here send success message to user
					
					model.addAttribute("success",   "FuelTypes"
							+ " deleted successfully");
				
				//otherwise send failure msg.
			}
			 
		}

		return "redirect:/list/fuel-type";
	}
}
