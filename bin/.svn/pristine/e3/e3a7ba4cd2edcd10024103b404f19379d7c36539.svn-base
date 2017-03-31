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

import com.fleet.model.UserType;
import com.fleet.service.UserTypeService;

@Controller
public class UserTypeController {

	@Autowired
	UserTypeService userTypeService;

	@Autowired
	MessageSource messageSource;
	
	private final Logger logger = LoggerFactory
			   .getLogger(UserTypeController.class);

	/*
	 * This method will list all existing UserTypes.
	 */
	@RequestMapping(value = { "/list/user-type" }, method = RequestMethod.GET)
	public String listPage(ModelMap model) {

		List<UserType> userTypes = userTypeService.findAll();
		model.addAttribute("userTypes", userTypes);
		return "list-user-type";
	}

	/*
	 * This method will provide the medium to add a new UserType.
	 */

	@RequestMapping(value = { "/new/user-type" }, method = RequestMethod.GET)
	public String createPage(ModelMap model) {

		UserType userType = new UserType();
		model.addAttribute("userType", userType);
		model.addAttribute("edit", false);
		return "new-user-type";
	}

	/*
	 * This method will be called on form submission, handling POST request for
	 * saving UserType in database. It also validates the user input
	 */
	@RequestMapping(value = { "/new/user-type" }, method = RequestMethod.POST)
	public String savePage(@Valid UserType userType, BindingResult result,
			ModelMap model) {

		if (result.hasErrors()) {
			return "new-user-type";
		}
		userTypeService.save(userType);

		model.addAttribute("success", "UserType " + userType.getName()
				+ " registered successfully");
		return "update-user-type";
	}

	/*
	 * This method will provide the medium to update an existing UserType.
	 */
	@RequestMapping(value = { "/edit/user-type/{id}" }, method = RequestMethod.GET)
	public String edit(@PathVariable Integer id, ModelMap model) {

		UserType userType = userTypeService.findOne(id);
		model.addAttribute("userType", userType);
		model.addAttribute("edit", true);
		return "new-user-type";
	}

	/*
	 * This method will be called on form submission, handling POST request for
	 * updating UserType in database. It also validates the user input
	 */
	@RequestMapping(value = { "/edit/user-type/{id}" }, method = RequestMethod.POST)
	public String update(@Valid UserType userType, BindingResult result,
			ModelMap model, @PathVariable Integer id) {

		if (result.hasErrors()) {
			return "new-user-type";
		}

		userTypeService.save(userType);

		model.addAttribute("success", "UserType " + userType.getName()
				+ " updated successfully");
		return "update-user-type";
	}

	/*
	 * This method will delete a UserType by it's ID value.
	 */
	@RequestMapping(value = { "/delete/user-type/{id}" }, method = RequestMethod.GET)
	public String delete(@PathVariable Integer id) {
		UserType userType = userTypeService.findOne(id);
		userTypeService.remove(userType);
		return "redirect:/list/user-type";
	}
	
	@RequestMapping(value = { "/delete-all/userType/{rowCount}" }, method = RequestMethod.GET)
	public String deleteAll(@PathVariable Integer rowCount, final RedirectAttributes redirectAttributes, HttpServletRequest request,Integer id,ModelMap model) {
		logger.info("row count : " + rowCount);
		String checkBox="";
		String userTypeIdStr = "";
		Integer userTypeId = new Integer(java.sql.Types.NULL);
		UserType userType = null;
		List<UserType> userTypes = new ArrayList<UserType>(0);
		for (int count=0; count<=rowCount; count++) {
			checkBox=request.getParameter("checkbox"+count);
			logger.debug("count : "+ count + " || checkBox : "+ checkBox);
			
			if(checkBox == null){
				checkBox = "";
			}
			
			if("on".equals(checkBox)){
				userTypeIdStr = request.getParameter("userTypeId" + count);
				logger.debug("count : "+ count + " || checkBox : "+ checkBox);
				
				if(userTypeIdStr == null){
					userTypeIdStr = "";
				}
				
				if(!"".equals(userTypeIdStr)){

					// here check its number or not
					
					userTypeId = new Integer(userTypeIdStr);
					
					if(userTypeId.intValue() > 0){
						// here need to check exception
						try {							
							userType = userTypeService.findOne(userTypeId);
						}
						catch(Exception e){
							logger.debug("Exception in finding a userType data :- " + e);
						}
							
						}
						if(userType != null){
							userTypes.add(userType);
						}
					}
					
				}

			}
			
			if(!userTypes.isEmpty()){
				// here need to check exception
				try{
					userTypeService.remove(userTypes);
					redirectAttributes.addFlashAttribute("success", "USERTYPES DELETED");
				}
				catch(Exception e){
					logger.debug("Exception in removing userTypes data :- " + e);
					
				// here send success message to user
					
					model.addAttribute("success",   "userTypes"
							+ " deleted successfully");
				
				//otherwise send failure msg.
			}
			 
		}

		return "redirect:/list/user-type";
	}

}
