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

import com.fleet.model.ServiceDetail;
import com.fleet.service.ServiceDetailService;

@Controller
public class ServiceDetailController {

	@Autowired
	ServiceDetailService serviceDetailService;

	@Autowired
	MessageSource messageSource;
	private final Logger logger = LoggerFactory
			   .getLogger(ServiceDetailController.class);

	/*
	 * This method will list all existing clients.
	 */
	@RequestMapping(value = { "/list/service-detail" }, method = RequestMethod.GET)
	public String listPage(ModelMap model) {
		List<ServiceDetail> serviceDetails = serviceDetailService.findAll();
		model.addAttribute("serviceDetails", serviceDetails);
		return "list-service-detail";
	}
	
	/*
	 * This method will provide the medium to add a new client.
	*/
	
	@RequestMapping(value = { "/new/service-detail" }, method = RequestMethod.GET)
	public String createPage(ModelMap model) {
		ServiceDetail serviceDetail= new ServiceDetail();
		model.addAttribute("serviceDetail",serviceDetail);
		model.addAttribute("edit", false);
		return "new-service-detail";
	}
	
	/*
	 * This method will be called on form submission, handling POST request for
	 * saving client in database. It also validates the user input
	 */
	@RequestMapping(value = {"/new/service-detail"}, method = RequestMethod.POST)
	public String savePage(@Valid ServiceDetail serviceDetail, BindingResult result,
			ModelMap model) {
		if (result.hasErrors()) {
			return "new-service-detail";
		}
		serviceDetailService.save(serviceDetail);
		
		model.addAttribute("success", "ServiceDetail " + serviceDetail.getActivity()	+ " updated successfully");
		return "update-service-detail";
	}
	
	/*
	 * This method will provide the medium to update an existing client.
	 */
	@RequestMapping(value = { "/edit/service-detail/{id}" }, method = RequestMethod.GET)
	public String edit(@PathVariable Integer id, ModelMap model) {
		ServiceDetail serviceDetail = serviceDetailService.findOne(id);
		model.addAttribute("serviceDetail", serviceDetail);
		model.addAttribute("edit", true);
		return "new-service-detail";
	}
	/*
	 * This method will be called on form submission, handling POST request for
	 * updating client in database. It also validates the user input
	 */
	@RequestMapping(value = { "/edit/service-detail/{id}" }, method = RequestMethod.POST)
	public String update(@Valid ServiceDetail serviceDetail , BindingResult result,
			ModelMap model, @PathVariable Integer id) {

		if (result.hasErrors()) {
			return "new-service-detail";    
		}

		serviceDetailService.save(serviceDetail);
		model.addAttribute("success", "ServiceDetail " + serviceDetail.getActivity()	+ " updated successfully");
		return "update-service-detail";
	}

	/*
	 * This method will delete an client by it's ID value.
	 */
	@RequestMapping(value = { "/delete/service-detail/{id}" }, method = RequestMethod.GET)
	public String delete(@PathVariable Integer id) {
		ServiceDetail serviceDetail = serviceDetailService.findOne(id);
		serviceDetailService.remove(serviceDetail);
		return "redirect:/list/service-detail";
	}
	@RequestMapping(value = { "/delete-all/serviceDetail/{rowCount}" }, method = RequestMethod.GET)
	public String deleteAll(@PathVariable Integer rowCount, final RedirectAttributes redirectAttributes, HttpServletRequest request,Integer id,ModelMap model) {
		logger.info("row count : " + rowCount);
		String checkBox="";
		String serviceDetailIdStr = "";
		Integer serviceDetailId = new Integer(java.sql.Types.NULL);
		ServiceDetail serviceDetail = null;
		List<ServiceDetail> serviceDetails = new ArrayList<ServiceDetail>(0);
		for (int count=0; count<=rowCount; count++) {
			checkBox=request.getParameter("checkbox"+count);
			logger.debug("count : "+ count + " || checkBox : "+ checkBox);
			
			if(checkBox == null){
				checkBox = "";
			}
			
			if("on".equals(checkBox)){
				serviceDetailIdStr = request.getParameter("serviceDetailId" + count);
				logger.debug("count : "+ count + " || checkBox : "+ checkBox);
				
				if(serviceDetailIdStr == null){
					serviceDetailIdStr = "";
				}
				
				if(!"".equals(serviceDetailIdStr)){

					// here check its number or not
					
					serviceDetailId = new Integer(serviceDetailIdStr);
					
					if(serviceDetailId.intValue() > 0){
						// here need to check exception
						try {							
							serviceDetail = serviceDetailService.findOne(serviceDetailId);
						}
						catch(Exception e){
							logger.debug("Exception in finding a serviceDetail data :- " + e);
						}
							
						}
						if(serviceDetail != null){
							serviceDetails.add(serviceDetail);
						}
					}
					
				}

			}
			
			if(!serviceDetails.isEmpty()){
				// here need to check exception
				try{
					serviceDetailService.remove(serviceDetails);
					redirectAttributes.addFlashAttribute("success", "SERVICEDETAILS DELETED");
				}
				catch(Exception e){
					logger.debug("Exception in removing serviceDetails data :- " + e);
					
				// here send success message to user
					
					model.addAttribute("success",   "ServiceDetails"
							+ " deleted successfully");
				
				//otherwise send failure msg.
			}
			 
		}

		return "redirect:/list/service-detail";
	}
}

