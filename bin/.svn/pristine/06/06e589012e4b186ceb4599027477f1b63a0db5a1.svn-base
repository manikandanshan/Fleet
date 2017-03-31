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

import com.fleet.model.Vehicle;
import com.fleet.service.VehicleService;

/**
 * @author shine
 *
 */
@Controller
public class VehicleController {
	@Autowired
	VehicleService vehicleService;
	@Autowired
	MessageSource messageSource;
	
	private final Logger logger = LoggerFactory
			   .getLogger(VehicleController.class);

	/*
	 * This method will list all existing vehicles.
	 */
	@RequestMapping(value = { "/list/vehicle" }, method = RequestMethod.GET)
	public String listPage(ModelMap model) {
		List<Vehicle> vehicles = vehicleService.findAll();
		model.addAttribute("vehicles", vehicles);
		return "list-vehicle";
	}

	/*
	 * This method will provide the medium to add a new vehicle.
	 */
	@RequestMapping(value = { "/new/vehicle" }, method = RequestMethod.GET)
	public String newPage(ModelMap model) {
		Vehicle vehicle = new Vehicle();
		model.addAttribute("vehicle", vehicle);
		model.addAttribute("edit", false);
		return "new-vehicle";
	}

	/*
	 * This method will be called on form submission, handling POST request for
	 * saving vehicle in database. It also validates the user input
	 */
	@RequestMapping(value = { "/new/vehicle" }, method = RequestMethod.POST)
	public String savePage(@Valid Vehicle vehicle,
			BindingResult result, ModelMap model) {

		if (result.hasErrors()) {
			return "list-vehicle";
		}
			vehicleService.save(vehicle);
			model.addAttribute("success"," Vehicle  " + vehicle.getVin()+ " registered successfully");
			return "update-vehicle";
	}
	
	/*
	  * This method will provide the medium to update an existing vehicle.
	 */
	@RequestMapping(value = { "/edit/vehicle/{id}" }, method = RequestMethod.GET)
	public String editPage (@PathVariable Integer id, ModelMap model) {
		Vehicle vehicle=vehicleService.findOne(id);
		model.addAttribute("vehicle", vehicle);
		model.addAttribute("edit", true);
		return "new-vehicle";
	}
	/*
	 * This method will be called on form submission, handling POST request for
	 * updating vehicle in database. It also validates the user input
	 */
	@RequestMapping(value = { "/edit/vehicle/{id}" }, method = RequestMethod.POST)
	public String updatePage(@Valid Vehicle vehicle, BindingResult result,
			ModelMap model, @PathVariable Integer id) {
		if (result.hasErrors()) {
			return "new-vehicle";
		}
		vehicleService.save(vehicle);
		model.addAttribute("success", " Vehicle " + vehicle.getModel()+ " updated successfully");
		return "update-vehicle";
	}
	/*
	 * This method will delete an vehicle by it's id value.
	 */
	@RequestMapping(value = { "/delete/vehicle/{id}" }, method = RequestMethod.GET)
	public String deletePage(@PathVariable Integer id) {
		Vehicle vehicle=vehicleService.findOne(id);
		vehicleService.remove(vehicle);
		return "redirect:/list/vehicle";
	}
	
	@RequestMapping(value = { "/delete-all/vehicle/{rowCount}" }, method = RequestMethod.GET)
	public String deleteAll(@PathVariable Integer rowCount, final RedirectAttributes redirectAttributes, HttpServletRequest request,Integer id,ModelMap model) {
		logger.info("row count : " + rowCount);
		String checkBox="";
		String vehicleIdStr = "";
		Integer vehicleId = new Integer(java.sql.Types.NULL);
		Vehicle vehicle = null;
		List<Vehicle> vehicles = new ArrayList<Vehicle>(0);
		for (int count=0; count<=rowCount; count++) {
			checkBox=request.getParameter("checkbox"+count);
			logger.debug("count : "+ count + " || checkBox : "+ checkBox);
			
			if(checkBox == null){
				checkBox = "";
			}
			
			if("on".equals(checkBox)){
				vehicleIdStr = request.getParameter("vehicleId" + count);
				logger.debug("count : "+ count + " || checkBox : "+ checkBox);
				
				if(vehicleIdStr == null){
					vehicleIdStr = "";
				}
				
				if(!"".equals(vehicleIdStr)){

					// here check its number or not
					
					vehicleId = new Integer(vehicleIdStr);
					
					if(vehicleId.intValue() > 0){
						// here need to check exception
						try {							
							vehicle = vehicleService.findOne(vehicleId);
						}
						catch(Exception e){
							logger.debug("Exception in finding a vehicle data :- " + e);
						}
							
						}
						if(vehicle != null){
							vehicles.add(vehicle);
						}
					}
					
				}

			}
			
			if(!vehicles.isEmpty()){
				// here need to check exception
				try{
					vehicleService.remove(vehicles);
					redirectAttributes.addFlashAttribute("success", "vehicleS DELETED");
				}
				catch(Exception e){
					logger.debug("Exception in removing vehicles data :- " + e);
					
				// here send success message to user
					
					model.addAttribute("success",   "Vehicles"
							+ " deleted successfully");
				
				//otherwise send failure msg.
			}
			 
		}

		return "redirect:/list/vehicle";
	}

}
