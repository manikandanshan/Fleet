
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

import com.fleet.model.Branch;
import com.fleet.service.BranchService;

@Controller
public class BranchController {

	@Autowired
	BranchService branchService;

	@Autowired
	MessageSource messageSource;
	
	private final Logger logger = LoggerFactory
			   .getLogger(BranchController.class);

	/*
	 * This method will list all existing clients.
	 */
	@RequestMapping(value = { "/list/branch" }, method = RequestMethod.GET)
	public String listPage(ModelMap model) {

		List<Branch> branchs = branchService.findAll();
		model.addAttribute("branchs", branchs);
		return "list-branch";
	}

	/*
	 * This method will provide the medium to add a new client.
	 */

	@RequestMapping(value = { "/new/branch" }, method = RequestMethod.GET)
	public String createPage(ModelMap model) {

		Branch branch = new Branch();
		model.addAttribute("branch", branch);
		model.addAttribute("edit", false);
		return "new-branch";
	}

	/*
	 * This method will be called on form submission, handling POST request for
	 * saving client in database. It also validates the user input
	 */
	@RequestMapping(value = { "/new/branch" }, method = RequestMethod.POST)
	public String savePage(@Valid Branch branch, BindingResult result,
			ModelMap model) {

		if (result.hasErrors()) {
			return "new-branch";
		}
		branchService.save(branch);

		model.addAttribute("success", "Branch " + branch.getName()
				+ " registered successfully");
		return "update-branch";
	}

	/*
	 * This method will provide the medium to update an existing client.
	 */
	@RequestMapping(value = { "/edit/branch/{id}" }, method = RequestMethod.GET)
	public String edit(@PathVariable Integer id, ModelMap model) {

		Branch branch = branchService.findOne(id);
		model.addAttribute("branch", branch);
		model.addAttribute("edit", true);
		return "new-branch";
	}

	/*
	 * This method will be called on form submission, handling POST request for
	 * updating client in database. It also validates the user input
	 */
	@RequestMapping(value = { "/edit/branch/{id}" }, method = RequestMethod.POST)
	public String update(@Valid Branch branch, BindingResult result,
			ModelMap model, @PathVariable Integer id) {

		if (result.hasErrors()) {
			return "new-branch";
		}
          branchService.save(branch);

		model.addAttribute("success", "Branch " + branch.getName()
				+ " updated successfully");
		return "update-branch";
	}

	/*
	 * This method will delete a client by it's ID value.
	 */
	@RequestMapping(value = { "/delete/branch/{id}" }, method = RequestMethod.GET)
	public String delete(@PathVariable Integer id) {
		Branch branch = branchService.findOne(id);
		branchService.remove(branch);
		return "redirect:/list/branch";
	}
	
	@RequestMapping(value = { "/delete-all/branch/{rowCount}" }, method = RequestMethod.GET)
	public String deleteAll(@PathVariable Integer rowCount, final RedirectAttributes redirectAttributes,HttpServletRequest request,Integer id,ModelMap model) {
		logger.info("row count : " + rowCount);
		String checkBox="";
		String branchIdStr = "";
		Integer branchId = new Integer(java.sql.Types.NULL);
		Branch branch = null;
		List<Branch> branchs = new ArrayList<Branch>(0);
		for (int count=0; count<=rowCount; count++) {
			checkBox=request.getParameter("checkbox"+count);
			logger.debug("count : "+ count + " || checkBox : "+ checkBox);
			
			if(checkBox == null){
				checkBox = "";
			}
			
			if("on".equals(checkBox)){
				branchIdStr = request.getParameter("branchId" + count);
				logger.debug("count : "+ count + " || checkBox : "+ checkBox);
				
				if(branchIdStr == null){
					branchIdStr = "";
				}
				
				if(!"".equals(branchIdStr)){

					// here check its number or not
					
					branchId = new Integer(branchIdStr);
					
					if(branchId.intValue() > 0){
						// here need to check exception
						try {							
							branch = branchService.findOne(branchId);
						}
						catch(Exception e){
							logger.debug("Exception in finding a branch data :- " + e);
						}
							
						}
						if(branch != null){
							branchs.add(branch);
						}
					}
					
				}

			}
			
			if(!branchs.isEmpty()){
				// here need to check exception
				try{
					branchService.remove(branchs);
					
					redirectAttributes.addFlashAttribute("success", "BRENCHES DELETED");
				}
				catch(Exception e){
					logger.debug("Exception in removing branchs data :- " + e);
					
				// here send success message to user
					
					model.addAttribute("success",   "Branchs"
							+ " deleted successfully");
				
				//otherwise send failure msg.
			}
			 
		}

		return "redirect:/list/branch";
	}

}

