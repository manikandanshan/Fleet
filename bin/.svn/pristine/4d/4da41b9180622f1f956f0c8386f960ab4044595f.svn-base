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

import com.fleet.model.Trip;
import com.fleet.service.TripService;

@Controller
public class TripController {

	@Autowired
	TripService tripService;

	@Autowired
	MessageSource messageSource;
	private final Logger logger = LoggerFactory
			   .getLogger(TripController.class);

	/*
	 * This method will list all existing Trips.
	 */
	@RequestMapping(value = { "/list/trip" }, method = RequestMethod.GET)
	public String listPage(ModelMap model) {

		List<Trip> trips = tripService.findAll();
		model.addAttribute("trips", trips);
		return "list-trip";
	}

	/*
	 * This method will provide the medium to add a new Trip.
	 */

	@RequestMapping(value = { "/new/trip" }, method = RequestMethod.GET)
	public String createPage(ModelMap model) {

		Trip trip = new Trip();
		model.addAttribute("trip", trip);
		model.addAttribute("edit", false);
		return "new-trip";
	}

	/*
	 * This method will be called on form submission, handling POST request for
	 * saving Trip in database. It also validates the user input
	 */
	@RequestMapping(value = { "/new/trip" }, method = RequestMethod.POST)
	public String savePage(@Valid Trip trip, BindingResult result,
			ModelMap model) {

		if (result.hasErrors()) {
			return "new-trip";
		}
		tripService.save(trip);

		model.addAttribute("success", "Trip " + trip.getStatus()
				+ " registered successfully");
		return "update-trip";
	}

	/*
	 * This method will provide the medium to update an existing Trip.
	 */
	@RequestMapping(value = { "/edit/trip/{id}" }, method = RequestMethod.GET)
	public String edit(@PathVariable Integer id, ModelMap model) {

		Trip trip = tripService.findOne(id);
		model.addAttribute("trip", trip);
		model.addAttribute("edit", true);
		return "new-trip";
	}

	/*
	 * This method will be called on form submission, handling POST request for
	 * updating Trip in database. It also validates the user input
	 */
	@RequestMapping(value = { "/edit/trip/{id}" }, method = RequestMethod.POST)
	public String update(@Valid Trip trip, BindingResult result,
			ModelMap model, @PathVariable Integer id) {

		if (result.hasErrors()) {
			return "new-trip";
		}

		tripService.save(trip);

		model.addAttribute("success", "Trip " + trip.getStatus()
				+ " updated successfully");
		return "update-trip";
	}

	/*
	 * This method will delete a Trip by it's ID value.
	 */
	@RequestMapping(value = { "/delete/trip/{id}" }, method = RequestMethod.GET)
	public String delete(@PathVariable Integer id) {
		Trip trip = tripService.findOne(id);
		tripService.remove(trip);
		return "redirect:/list/trip";
	}
	@RequestMapping(value = { "/delete-all/trip/{rowCount}" }, method = RequestMethod.GET)
	public String deleteAll(@PathVariable Integer rowCount, final RedirectAttributes redirectAttributes, HttpServletRequest request,Integer id,ModelMap model) {
		logger.info("row count : " + rowCount);
		String checkBox="";
		String tripIdStr = "";
		Integer tripId = new Integer(java.sql.Types.NULL);
		Trip trip = null;
		List<Trip> trips = new ArrayList<Trip>(0);
		for (int count=0; count<=rowCount; count++) {
			checkBox=request.getParameter("checkbox"+count);
			logger.debug("count : "+ count + " || checkBox : "+ checkBox);
			
			if(checkBox == null){
				checkBox = "";
			}
			
			if("on".equals(checkBox)){
				tripIdStr = request.getParameter("tripId" + count);
				logger.debug("count : "+ count + " || checkBox : "+ checkBox);
				
				if(tripIdStr == null){
					tripIdStr = "";
				}
				
				if(!"".equals(tripIdStr)){

					// here check its number or not
					
					tripId = new Integer(tripIdStr);
					
					if(tripId.intValue() > 0){
						// here need to check exception
						try {							
							trip = tripService.findOne(tripId);
						}
						catch(Exception e){
							logger.debug("Exception in finding a trip data :- " + e);
						}
							
						}
						if(trip != null){
							trips.add(trip);
						}
					}
					
				}

			}
			
			if(!trips.isEmpty()){
				// here need to check exception
				try{
					tripService.remove(trips);
					redirectAttributes.addFlashAttribute("success", "TRIPS DELETED");
				}
				catch(Exception e){
					logger.debug("Exception in removing trips data :- " + e);
					
				// here send success message to user
					
					model.addAttribute("success",   "Trips"
							+ " deleted successfully");
				
				//otherwise send failure msg.
			}
			 
		}

		return "redirect:/list/trip";
	}

}
