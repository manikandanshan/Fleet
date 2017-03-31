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

import com.fleet.model.VehicleType;
import com.fleet.service.VehicleTypeService;

@Controller
public class VehicleTypeController {

	@Autowired
	VehicleTypeService vehicleTypeService;

	@Autowired
	MessageSource messageSource;
	
	private final Logger logger = LoggerFactory
			   .getLogger(VehicleTypeController.class);

	/*
	 * This method will list all existing vehicletype.
	 */
	@RequestMapping(value = { "/list/vehicle-type" }, method = RequestMethod.GET)
	public String listPage(ModelMap model) {

		List<VehicleType> vehicleTypes = vehicleTypeService.findAll();
		model.addAttribute("vehicleTypes", vehicleTypes);
		return "list-vehicle-type";
	}

	/*
	 * This method will provide the medium to add a new vehicletype.
	 */

	@RequestMapping(value = { "/new/vehicle-type" }, method = RequestMethod.GET)
	public String createPage(ModelMap model) {

		VehicleType vehicleType = new VehicleType();
		model.addAttribute("vehicleType", vehicleType);
		model.addAttribute("edit", false);
		return "new-vehicle-type";
	}

	/*
	 * This method will be called on form submission, handling POST request for
	 * saving vehicletype in database. It also validates the user input
	 */
	@RequestMapping(value = { "/new/vehicle-type" }, method = RequestMethod.POST)
	public String savePage(@Valid VehicleType vehicleType,
			BindingResult result, ModelMap model) {

		if (result.hasErrors()) {
			return "new-vehicle-type";
		}
		vehicleTypeService.save(vehicleType);

		model.addAttribute("success", "VehicleType " + vehicleType.getName()
				+ " registered successfully");
		return "update-vehicle-type";
	}

	/*
	 * This method will provide the medium to update an existing vehicletype.
	 */
	@RequestMapping(value = { "/edit/vehicle-type/{id}" }, method = RequestMethod.GET)
	public String editclient(@PathVariable Integer id, ModelMap model) {

		VehicleType vehicleType = vehicleTypeService.findOne(id);
		model.addAttribute("vehicleType", vehicleType);
		model.addAttribute("edit", true);
		return "new-vehicle-type";
	}

	/*
	 * This method will be called on form submission, handling POST request for
	 * updating vehicletype in database. It also validates the user input
	 */
	@RequestMapping(value = { "/edit/vehicle-type/{id}" }, method = RequestMethod.POST)
	public String updateVehicleType(@Valid VehicleType vehicleType,
			BindingResult result, ModelMap model, @PathVariable Integer id) {

		if (result.hasErrors()) {
			return "new-vehicle-type";
		}

		vehicleTypeService.save(vehicleType);

		model.addAttribute("success", "VehicleType "+ vehicleType.getName()
				+ " updated successfully");
		return "update-vehicle-type";
	}

	/*
	 * This method will delete a VehicleType by it's ID value.
	 */
	@RequestMapping(value = { "/delete/vehicle-type/{id}" }, method = RequestMethod.GET)
	public String deleteclient(@PathVariable Integer id) {
		VehicleType vehicleType = vehicleTypeService.findOne(id);
		vehicleTypeService.remove(vehicleType);
		return "redirect:/list/vehicle-type";
	}
	
	@RequestMapping(value = { "/delete-all/vehicleType/{rowCount}" }, method = RequestMethod.GET)
	public String deleteAll(@PathVariable Integer rowCount, final RedirectAttributes redirectAttributes, HttpServletRequest request,Integer id,ModelMap model) {
		logger.info("row count : " + rowCount);
		String checkBox="";
		String vehicleTypeIdStr = "";
		Integer vehicleTypeId = new Integer(java.sql.Types.NULL);
		VehicleType vehicleType = null;
		List<VehicleType> vehicleTypes = new ArrayList<VehicleType>(0);
		for (int count=0; count<=rowCount; count++) {
			checkBox=request.getParameter("checkbox"+count);
			logger.debug("count : "+ count + " || checkBox : "+ checkBox);
			
			if(checkBox == null){
				checkBox = "";
			}
			
			if("on".equals(checkBox)){
				vehicleTypeIdStr = request.getParameter("vehicleTypeId" + count);
				logger.debug("count : "+ count + " || checkBox : "+ checkBox);
				
				if(vehicleTypeIdStr == null){
					vehicleTypeIdStr = "";
				}
				
				if(!"".equals(vehicleTypeIdStr)){

					// here check its number or not
					
					vehicleTypeId = new Integer(vehicleTypeIdStr);
					
					if(vehicleTypeId.intValue() > 0){
						// here need to check exception
						try {							
							vehicleType = vehicleTypeService.findOne(vehicleTypeId);
						}
						catch(Exception e){
							logger.debug("Exception in finding a vehicleType data :- " + e);
						}
							
						}
						if(vehicleType != null){
							vehicleTypes.add(vehicleType);
						}
					}
					
				}

			}
			
			if(!vehicleTypes.isEmpty()){
				// here need to check exception
				try{
					vehicleTypeService.remove(vehicleTypes);
					redirectAttributes.addFlashAttribute("success", "VEHICLETYPES DELETED");
				}
				catch(Exception e){
					logger.debug("Exception in removing vehicleTypes data :- " + e);
					
				// here send success message to user
					
					model.addAttribute("success",   "VehicleTypes"
							+ " deleted successfully");
				
				//otherwise send failure msg.
			}
			 
		}

		return "redirect:/list/vehicle-type";
	}


}
