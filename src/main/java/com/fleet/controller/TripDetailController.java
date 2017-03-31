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

import com.fleet.model.TripDetail;
import com.fleet.service.TripDetailService;

@Controller
public class TripDetailController {

	@Autowired
	TripDetailService tripDetailService;

	@Autowired
	MessageSource messageSource;
	
	private final Logger logger = LoggerFactory
			   .getLogger(TripDetailController.class);

	/*
	 * This method will list all existing clients.
	 */
	@RequestMapping(value = { "/list/trip-detail" }, method = RequestMethod.GET)
	public String listPage(ModelMap model) {

		List<TripDetail> tripDetails = tripDetailService.findAll();
		model.addAttribute("tripDetails", tripDetails);
		return "list-trip-detail";
	}

	/*
	 * This method will provide the medium to add a new client.
	 */

	@RequestMapping(value = { "/new/trip-detail" }, method = RequestMethod.GET)
	public String createPage(ModelMap model) {

		TripDetail tripDetail = new TripDetail();
		model.addAttribute("tripDetail", tripDetail);
		model.addAttribute("edit", false);
		return "new-trip-detail";
	}

	
	/*
	 * This method will be called on form submission, handling POST request for
	 * saving client in database. It also validates the user input
	 */
	@RequestMapping(value = { "/new/trip-detail" }, method = RequestMethod.POST)
	public String savePage(@Valid TripDetail tripDetail, BindingResult result,ModelMap model) {

		if (result.hasErrors()) {
			return "new-trip-detail";
		}
		System.out.println("before save");
		tripDetailService.save(tripDetail);
		System.out.println("after save");
		model.addAttribute("success", "TripDetail " + tripDetail.getDistance()
				+ " registered successfully");
		return "update-trip-detail";
	}

	
	/*
	 * This method will provide the medium to update an existing client.
	 */
	@RequestMapping(value = { "/edit/trip-detail/{id}" }, method = RequestMethod.GET)
	public String edit(@PathVariable Integer id, ModelMap model) {

		TripDetail tripDetail = tripDetailService.findOne(id);
		model.addAttribute("tripDetail", tripDetail);
		model.addAttribute("edit", true);
		return "new-trip-detail";
	}

	
	/*
	 * This method will be called on form submission, handling POST request for
	 * updating client in database. It also validates the user input
	 */
	@RequestMapping(value = { "/edit/trip-detail/{id}" }, method = RequestMethod.POST)
	public String update(@Valid TripDetail tripDetail, BindingResult result,
			ModelMap model, @PathVariable Integer id) {

		if (result.hasErrors()) {
			return "new-trip-detail";
		}

		tripDetailService.save(tripDetail);

		model.addAttribute("success", "TripDetail " + tripDetail.getDistance()
				+ " updated successfully");
		return "update-trip-detail";
	}

	
	/*
	 * This method will delete a client by it's ID value.
	 */
	@RequestMapping(value = { "/delete/trip-detail/{id}" }, method = RequestMethod.GET)
	public String delete(@PathVariable Integer id) {
		TripDetail tripDetail = tripDetailService.findOne(id);
		tripDetailService.remove(tripDetail);
		return "redirect:/list/trip-detail";
	}
	
	@RequestMapping(value = { "/delete-all/tripDetail/{rowCount}" }, method = RequestMethod.GET)
	public String deleteAll(@PathVariable Integer rowCount, final RedirectAttributes redirectAttributes, HttpServletRequest request,Integer id,ModelMap model) {
		logger.info("row count : " + rowCount);
		String checkBox="";
		String tripDetailIdStr = "";
		Integer tripDetailId = new Integer(java.sql.Types.NULL);
		TripDetail tripDetail = null;
		List<TripDetail> tripDetails = new ArrayList<TripDetail>(0);
		for (int count=0; count<=rowCount; count++) {
			checkBox=request.getParameter("checkbox"+count);
			logger.debug("count : "+ count + " || checkBox : "+ checkBox);
			
			if(checkBox == null){
				checkBox = "";
			}
			
			if("on".equals(checkBox)){
				tripDetailIdStr = request.getParameter("tripDetailId" + count);
				logger.debug("count : "+ count + " || checkBox : "+ checkBox);
				
				if(tripDetailIdStr == null){
					tripDetailIdStr = "";
				}
				
				if(!"".equals(tripDetailIdStr)){

					// here check its number or not
					
					tripDetailId = new Integer(tripDetailIdStr);
					
					if(tripDetailId.intValue() > 0){
						// here need to check exception
						try {							
							tripDetail = tripDetailService.findOne(tripDetailId);
						}
						catch(Exception e){
							logger.debug("Exception in finding a tripDetail data :- " + e);
						}
							
						}
						if(tripDetail != null){
							tripDetails.add(tripDetail);
						}
					}
					
				}

			}
			
			if(!tripDetails.isEmpty()){
				// here need to check exception
				try{
					tripDetailService.remove(tripDetails);
					redirectAttributes.addFlashAttribute("success", "TRIPDETAILS DELETED");
				}
				catch(Exception e){
					logger.debug("Exception in removing tripDetails data :- " + e);
					
				// here send success message to user
					
					model.addAttribute("success",   "TripDetails"
							+ " deleted successfully");
				
				//otherwise send failure msg.
			}
			 
		}

		return "redirect:/list/trip-detail";
	}


}
