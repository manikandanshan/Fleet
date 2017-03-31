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

import com.fleet.model.Associate;
import com.fleet.service.AssociateService;

@Controller
public class AssociateController {

	@Autowired
	AssociateService associateService;

	@Autowired
	MessageSource messageSource;
	
	private final Logger logger = LoggerFactory
			   .getLogger(AssociateController.class);

	/*
	 * This method will list all existing clients.
	 */
	@RequestMapping(value = { "/list/associate" }, method = RequestMethod.GET)
	public String listPage(ModelMap model) {
		List<Associate> associates = associateService.findAll();
		model.addAttribute("associates", associates);
		return "list-associate";
	}
	
	/*
	 * This method will provide the medium to add a new client.
	*/
	
	@RequestMapping(value = { "/new/associate" }, method = RequestMethod.GET)
	public String createPage(ModelMap model) {
		Associate associate = new Associate();
		model.addAttribute("associate",associate);
		model.addAttribute("edit", false);
		return "new-associate";
	}
	
	/*
	 * This method will be called on form submission, handling POST request for
	 * saving client in database. It also validates the user input
	 */
	@RequestMapping(value = {"/new/associate"}, method = RequestMethod.POST)
	public String savePage(@Valid Associate associate, BindingResult result,
			ModelMap model) {
		if (result.hasErrors()) {
			return "new-associate";
		}
		associateService.save(associate);
		
		model.addAttribute("success", "Associate " + associate.getFirstName()	+ " updated successfully");
		return "update-associate";
	}
	
	/*
	 * This method will provide the medium to update an existing client.
	 */
	@RequestMapping(value = { "/edit/associate/{id}" }, method = RequestMethod.GET)
	public String edit(@PathVariable Integer id, ModelMap model) {
		Associate associate = associateService.findOne(id);
		model.addAttribute("associate", associate);
		model.addAttribute("edit", true);
		return "new-associate";
	}
	/*
	 * This method will be called on form submission, handling POST request for
	 * updating client in database. It also validates the user input
	 */
	@RequestMapping(value = { "/edit/associate/{id}" }, method = RequestMethod.POST)
	public String update(@Valid Associate associate , BindingResult result,
			ModelMap model, @PathVariable Integer id) {

		if (result.hasErrors()) {
			return "new-associate";    
		}

		associateService.save(associate);
		model.addAttribute("success", "Associate " + associate.getFirstName()	+ " updated successfully");
		return "update-associate";
	}

	/*
	 * This method will delete an client by it's ID value.
	 */
	@RequestMapping(value = { "/delete/associate/{id}" }, method = RequestMethod.GET)
	public String delete(@PathVariable Integer id) {
		Associate associate = associateService.findOne(id);
		associateService.remove(associate);
		return "redirect:/list/associate";
	}
	@RequestMapping(value = { "/delete-all/associate/{rowCount}" }, method = RequestMethod.GET)
	public String deleteAll(@PathVariable Integer rowCount, final RedirectAttributes redirectAttributes,HttpServletRequest request,Integer id,ModelMap model) {
		logger.info("row count : " + rowCount);
		String checkBox="";
		String associateIdStr = "";
		Integer associateId = new Integer(java.sql.Types.NULL);
		Associate associate = null;
		List<Associate> associates = new ArrayList<Associate>(0);
		for (int count=0; count<=rowCount; count++) {
			checkBox=request.getParameter("checkbox"+count);
			logger.debug("count : "+ count + " || checkBox : "+ checkBox);
			
			if(checkBox == null){
				checkBox = "";
			}
			//System.out.println("i am after checkbox null");
			
			if("on".equals(checkBox)){
				associateIdStr = request.getParameter("associateId" + count);
				logger.debug("count : "+ count + " || checkBox : "+ checkBox);
				System.out.println("count : "+ count + " || checkBox : "+ checkBox);
				
				if(associateIdStr == null){
					associateIdStr = "";
				}
				System.out.println("i am after associateID null");
				
				if(!"".equals(associateIdStr)){

					// here check its number or not
					System.out.println("i am after associateIDstr null");
					
					associateId = new Integer(associateIdStr);
					
					if(associateId.intValue() > 0){
						// here need to check exception
						try {							
							associate = associateService.findOne(associateId);
						}
						catch(Exception e){
							logger.debug("Exception in finding a associate data :- " + e);
						}
						System.out.println("i am after try null");
						}
						if(associate != null){
							associates.add(associate);
						}
					}
					
				}

			}
			
			if(!associates.isEmpty()){
				// here need to check exception
				try{
					associateService.remove(associates);
					
					redirectAttributes.addFlashAttribute("success", "ASSOCIATES DELETED");
				}
				catch(Exception e){
					logger.debug("Exception in removing associates data :- " + e);
					
				// here send success message to user
					
					model.addAttribute("success",   "Associates"
							+ " deleted successfully");
				
				//otherwise send failure msg.
			}
			 
		}

		return "redirect:/list/associate";
	}
}


