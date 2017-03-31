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

import com.fleet.model.FuelStation;
import com.fleet.service.FuelStationService;

@Controller
public class FuelStationController {

	@Autowired
	FuelStationService fuelStationService;

	@Autowired
	MessageSource messageSource;
	
	private final Logger logger = LoggerFactory
			   .getLogger(FuelStationController.class);
	
	

	/*
	 * This method will list all existing FuelStations.
	 */
	@RequestMapping(value = { "/list/fuel-station" }, method = RequestMethod.GET)
	public String listPage(ModelMap model) {

		List<FuelStation> fuelStations = fuelStationService.findAll();
		model.addAttribute("fuelStations", fuelStations);
		return "list-fuel-station";
	}

	/*
	 * This method will provide the medium to add a new fuel station.
	 */

	@RequestMapping(value = { "/new/fuel-station" }, method = RequestMethod.GET)
	public String createPage(ModelMap model) {
		FuelStation fuelStation = new FuelStation();
		model.addAttribute("fuelStation", fuelStation);
		model.addAttribute("edit", false);
		return "new-fuel-station";
	}

	/*
	 * This method will be called on form submission, handling POST request for
	 * saving FuelStation in database. It also validates the user input
	 */
	@RequestMapping(value = { "/new/fuel-station" }, method = RequestMethod.POST)
	public String savePage(@Valid FuelStation fuelStation,
			BindingResult result, ModelMap model) {

		if (result.hasErrors()) {
			return "new-fuel-station";
		}
		fuelStationService.save(fuelStation);

		model.addAttribute("success", "FuelStation " + fuelStation.getName()
				+ " registered successfully");
		return "update-fuel-station";
	}

	/*
	 * This method will provide the medium to update an existing FuelStation.
	 */
	@RequestMapping(value = { "/edit/fuel-station/{id}" }, method = RequestMethod.GET)
	public String edit(@PathVariable Integer id, ModelMap model) {

		FuelStation fuelStation = fuelStationService.findOne(id);
		model.addAttribute("fuelStation", fuelStation);
		model.addAttribute("edit", true);
		return "new-fuel-station";
	}

	/*
	 * This method will be called on form submission, handling POST request for
	 * updating FuelStation in database. It also validates the user input
	 */
	@RequestMapping(value = { "/edit/fuel-station/{id}" }, method = RequestMethod.POST)
	public String update(@Valid FuelStation fuelStation, BindingResult result,
			ModelMap model, @PathVariable Integer id) {

		if (result.hasErrors()) {
			return "new-fuel-station";
		}

		fuelStationService.save(fuelStation);

		model.addAttribute("success", "FuelStation " + fuelStation.getName()
				+ " updated successfully");
		return "update-fuel-station";
	}

	/*
	 * This method will delete a fuel station by it's ID value.
	 */
	@RequestMapping(value = { "/delete/fuel-station/{id}" }, method = RequestMethod.GET)
	public String delete(@PathVariable Integer id) {
		FuelStation fuelStation = fuelStationService.findOne(id);
		fuelStationService.remove(fuelStation);
		return "redirect:/list/fuel-station";
	}
	
	@RequestMapping(value = { "/delete-all/fuelStation/{rowCount}" }, method = RequestMethod.GET)
	public String deleteAll(@PathVariable Integer rowCount, final RedirectAttributes redirectAttributes, HttpServletRequest request,Integer id,ModelMap model) {
		logger.info("row count : " + rowCount);
		String checkBox="";
		String fuelStationIdStr = "";
		Integer fuelStationId = new Integer(java.sql.Types.NULL);
		FuelStation fuelStation = null;
		List<FuelStation> fuelStations = new ArrayList<FuelStation>(0);
		for (int count=0; count<=rowCount; count++) {
			checkBox=request.getParameter("checkbox"+count);
			logger.debug("count : "+ count + " || checkBox : "+ checkBox);
			
			if(checkBox == null){
				checkBox = "";
			}
			
			if("on".equals(checkBox)){
				fuelStationIdStr = request.getParameter("fuelStationId" + count);
				logger.debug("count : "+ count + " || checkBox : "+ checkBox);
				
				if(fuelStationIdStr == null){
					fuelStationIdStr = "";
				}
				
				if(!"".equals(fuelStationIdStr)){

					// here check its number or not
					
					fuelStationId = new Integer(fuelStationIdStr);
					
					if(fuelStationId.intValue() > 0){
						// here need to check exception
						try {							
							fuelStation = fuelStationService.findOne(fuelStationId);
						}
						catch(Exception e){
							logger.debug("Exception in finding a fuelStation data :- " + e);
						}
							
						}
						if(fuelStation != null){
							fuelStations.add(fuelStation);
						}
					}
					
				}

			}
			
			if(!fuelStations.isEmpty()){
				// here need to check exception
				try{
					fuelStationService.remove(fuelStations);
					redirectAttributes.addFlashAttribute("success", "FUELSTATIONS DELETED");
				}
				catch(Exception e){
					logger.debug("Exception in removing fuelStations data :- " + e);
					
				// here send success message to user
					
					model.addAttribute("success",   "FuelStations"
							+ " deleted successfully");
				
				//otherwise send failure msg.
			}
			 
		}

		return "redirect:/list/fuel-station";
	}

}
