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

import com.fleet.model.ServiceStation;
import com.fleet.service.ServiceStationService;

@Controller
public class ServiceStationController {

	@Autowired
	ServiceStationService serviceStationService;

	@Autowired
	MessageSource messageSource;
	
	private final Logger logger = LoggerFactory
			   .getLogger(ServiceStationController.class);

	/*
	 * This method will list all existing ServiceStations.
	 */
	@RequestMapping(value = { "/list/service-station" }, method = RequestMethod.GET)
	public String listPage(ModelMap model) {

		List<ServiceStation> serviceStations = serviceStationService.findAll();
		model.addAttribute("serviceStations", serviceStations);
		return "list-service-station";
	}

	/*
	 * This method will provide the medium to add a new ServiceStation.
	 */

	@RequestMapping(value = { "/new/service-station" }, method = RequestMethod.GET)
	public String createPage(ModelMap model) {

		ServiceStation serviceStation=new ServiceStation();
		model.addAttribute("serviceStation", serviceStation);
		model.addAttribute("edit", false);
		return "new-service-station";
	}

	/*
	 * This method will be called on form submission, handling POST request for
	 * saving ServiceStation in database. It also validates the user input
	 */
	@RequestMapping(value = { "/new/service-station" }, method = RequestMethod.POST)
	public String savePage(@Valid ServiceStation serviceStation, BindingResult result,
			ModelMap model) {

		if (result.hasErrors()) {
			return "new-service-station";
		}
		serviceStationService.save(serviceStation);

		model.addAttribute("success", "ServiceStation " + serviceStation.getName()
				+ " registered successfully");
		return "update-service-station";
	}

	/*
	 * This method will provide the medium to update an existing ServiceStation.
	 */
	@RequestMapping(value = { "/edit/service-station/{id}" }, method = RequestMethod.GET)
	public String edit(@PathVariable Integer id, ModelMap model) {

		ServiceStation serviceStation = serviceStationService.findOne(id);
		model.addAttribute("serviceStation", serviceStation);
		model.addAttribute("edit", true);
		return "new-service-station";
	}

	/*
	 * This method will be called on form submission, handling POST request for
	 * updating ServiceStation in database. It also validates the user input
	 */
	@RequestMapping(value = { "/edit/service-station/{id}" }, method = RequestMethod.POST)
	public String update(@Valid ServiceStation serviceStation, BindingResult result,
			ModelMap model, @PathVariable Integer id) {

		if (result.hasErrors()) {
			return "new-service-station";
		}

		serviceStationService.save(serviceStation);

		model.addAttribute("success", "ServiceStation " + serviceStation.getName()
				+ " updated successfully");
		return "update-service-station";
	}

	/*
	 * This method will delete a ServiceStation by it's ID value.
	 */
	@RequestMapping(value = { "/delete/service-station/{id}" }, method = RequestMethod.GET)
	public String delete(@PathVariable Integer id) {
		ServiceStation serviceStation = serviceStationService.findOne(id);
		serviceStationService.remove(serviceStation);
		return "redirect:/list/service-station";
	}
	
	@RequestMapping(value = { "/delete-all/serviceStation/{rowCount}" }, method = RequestMethod.GET)
	public String deleteAll(@PathVariable Integer rowCount, final RedirectAttributes redirectAttributes, HttpServletRequest request,Integer id,ModelMap model) {
		logger.info("row count : " + rowCount);
		String checkBox="";
		String serviceStationIdStr = "";
		Integer serviceStationId = new Integer(java.sql.Types.NULL);
		ServiceStation serviceStation = null;
		List<ServiceStation> serviceStations = new ArrayList<ServiceStation>(0);
		for (int count=0; count<=rowCount; count++) {
			checkBox=request.getParameter("checkbox"+count);
			logger.debug("count : "+ count + " || checkBox : "+ checkBox);
			
			if(checkBox == null){
				checkBox = "";
			}
			
			if("on".equals(checkBox)){
				serviceStationIdStr = request.getParameter("serviceStationId" + count);
				logger.debug("count : "+ count + " || checkBox : "+ checkBox);
				
				if(serviceStationIdStr == null){
					serviceStationIdStr = "";
				}
				
				if(!"".equals(serviceStationIdStr)){

					// here check its number or not
					
					serviceStationId = new Integer(serviceStationIdStr);
					
					if(serviceStationId.intValue() > 0){
						// here need to check exception
						try {							
							serviceStation = serviceStationService.findOne(serviceStationId);
						}
						catch(Exception e){
							logger.debug("Exception in finding a serviceStation data :- " + e);
						}
							
						}
						if(serviceStation != null){
							serviceStations.add(serviceStation);
						}
					}
					
				}

			}
			
			if(!serviceStations.isEmpty()){
				// here need to check exception
				try{
					serviceStationService.remove(serviceStations);
					redirectAttributes.addFlashAttribute("success", "SERVICESTATIONS DELETED");
				}
				catch(Exception e){
					logger.debug("Exception in removing serviceStations data :- " + e);
					
				// here send success message to user
					
					model.addAttribute("success",   "ServiceStations"
							+ " deleted successfully");
				
				//otherwise send failure msg.
			}
			 
		}

		return "redirect:/list/service-station";
	}

}
