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

import com.fleet.model.Service;
import com.fleet.service.ServiceService;

/**
 * @author shine
 *
 */
@Controller
public class ServiceController {
	@Autowired
	ServiceService serviceService;
	@Autowired
	MessageSource messageSource;
	
	private final Logger logger = LoggerFactory
			   .getLogger(ServiceController.class);
	
	/*
	 * This method will list all existing vehicles.
	 */
	@RequestMapping(value = { "/list/service" }, method = RequestMethod.GET)
	public String listPage(ModelMap model) {
		List<Service> services = serviceService.findAll();
		model.addAttribute("services", services);
		return "list-service";
	}

	/*
	 * This method will provide the medium to add a new service.
	 */
	@RequestMapping(value = { "/new/service" }, method = RequestMethod.GET)
	public String newPage(ModelMap model) {
		Service service = new Service();
		model.addAttribute("service", service);
		model.addAttribute("edit", false);
		return "new-service";
	}

	/*
	 * This method will be called on form submission, handling POST request for
	 * saving service in database. It also validates the user input
	 */
	@RequestMapping(value = { "/new/service" }, method = RequestMethod.POST)
	public String savePage(@Valid Service service,
			BindingResult result, ModelMap model) {

		if (result.hasErrors()) {
			return "list-service";
		}
			serviceService.save(service);
			model.addAttribute("success", " Service created on " + service.getCreatedOn() + " and entered on " + service.getEntryDate() + " is registered successfully");
			return "update-service";
	}
	
	/*
	  * This method will provide the medium to update an existing service.
	 */
	@RequestMapping(value = { "/edit/service/{id}" }, method = RequestMethod.GET)
	public String editPage (@PathVariable Integer id, ModelMap model) {
		Service service=serviceService.findOne(id);
		model.addAttribute("service", service);
		model.addAttribute("edit", true);
		return "new-service";
	}
	/*
	 * This method will be called on form submission, handling POST request for
	 * updating service in database. It also validates the user input
	 */
	@RequestMapping(value = { "/edit/service/{id}" }, method = RequestMethod.POST)
	public String updatePage(@Valid Service service, BindingResult result,
			ModelMap model, @PathVariable Integer id) {
		if (result.hasErrors()) {
			return "new-service";
		}
		serviceService.save(service);
		model.addAttribute("success", " Service created on " + service.getCreatedOn() + " and entered on " + service.getEntryDate() + " updated successfully");
		return "update-service";
	}
	/*
	 * This method will delete an service by it's id value.
	 */
	@RequestMapping(value = { "/delete/service/{id}" }, method = RequestMethod.GET)
	public String deletePage(@PathVariable Integer id) {
		Service service=serviceService.findOne(id);
		serviceService.remove(service);
		return "redirect:/list/service";
	}
	@RequestMapping(value = { "/delete-all/service/{rowCount}" }, method = RequestMethod.GET)
	public String deleteAll(@PathVariable Integer rowCount, final RedirectAttributes redirectAttributes, HttpServletRequest request,Integer id,ModelMap model) {
		logger.info("row count : " + rowCount);
		String checkBox="";
		String serviceIdStr = "";
		Integer serviceId = new Integer(java.sql.Types.NULL);
		Service service = null;
		List<Service> services = new ArrayList<Service>(0);
		for (int count=0; count<=rowCount; count++) {
			checkBox=request.getParameter("checkbox"+count);
			logger.debug("count : "+ count + " || checkBox : "+ checkBox);
			
			if(checkBox == null){
				checkBox = "";
			}
			
			if("on".equals(checkBox)){
				serviceIdStr = request.getParameter("serviceId" + count);
				logger.debug("count : "+ count + " || checkBox : "+ checkBox);
				
				if(serviceIdStr == null){
					serviceIdStr = "";
				}
				
				if(!"".equals(serviceIdStr)){

					// here check its number or not
					
					serviceId = new Integer(serviceIdStr);
					
					if(serviceId.intValue() > 0){
						// here need to check exception
						try {							
							service = serviceService.findOne(serviceId);
						}
						catch(Exception e){
							logger.debug("Exception in finding a service data :- " + e);
						}
							
						}
						if(service != null){
							services.add(service);
						}
					}
					
				}

			}
			
			if(!services.isEmpty()){
				// here need to check exception
				try{
					serviceService.remove(services);
					redirectAttributes.addFlashAttribute("success", "SERVICES DELETED");
				}
				catch(Exception e){
					logger.debug("Exception in removing services data :- " + e);
					
				// here send success message to user
					
					model.addAttribute("success",   "Services"
							+ " deleted successfully");
				
				//otherwise send failure msg.
			}
			 
		}

		return "redirect:/list/service";
	}
}
