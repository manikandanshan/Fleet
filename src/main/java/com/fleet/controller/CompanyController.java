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

import com.fleet.model.Company;
import com.fleet.service.CompanyService;

@Controller
public class CompanyController {

	@Autowired
	CompanyService companyService;

	@Autowired
	MessageSource messageSource;
	
	private final Logger logger = LoggerFactory
			   .getLogger(CompanyController.class);

	/*
	 * This method will list all existing clients.
	 */
	@RequestMapping(value = { "/list/company" }, method = RequestMethod.GET)
	public String listPage(ModelMap model) {

		List<Company> companys = companyService.findAll();
		model.addAttribute("companys", companys);
		return "list-company";
	}

	/*
	 * This method will provide the medium to add a new client.
	 */

	@RequestMapping(value = { "/new/company" }, method = RequestMethod.GET)
	public String createPage(ModelMap model) {

		Company company = new Company();
		model.addAttribute("company", company);
		model.addAttribute("edit", false);
		return "new-company";
	}

	/*
	 * This method will be called on form submission, handling POST request for
	 * saving client in database. It also validates the user input
	 */
	@RequestMapping(value = { "/new/company" }, method = RequestMethod.POST)
	public String savePage(@Valid Company company, BindingResult result,
			ModelMap model) {

		if (result.hasErrors()) {
			return "new-company";
		}
		companyService.save(company);

		model.addAttribute("success", "Company " + company.getName()
				+ " registered successfully");
		return "update-company";
	}

	/*
	 * This method will provide the medium to update an existing client.
	 */
	@RequestMapping(value = { "/edit/company/{id}" }, method = RequestMethod.GET)
	public String edit(@PathVariable Integer id, ModelMap model) {

		Company company = companyService.findOne(id);
		model.addAttribute("company", company);
		model.addAttribute("edit", true);
		return "new-company";
	}

	/*
	 * This method will be called on form submission, handling POST request for
	 * updating client in database. It also validates the user input
	 */
	@RequestMapping(value = { "/edit/company/{id}" }, method = RequestMethod.POST)
	public String update(@Valid Company company, BindingResult result,
			ModelMap model, @PathVariable Integer id) {

		if (result.hasErrors()) {
			return "new-company";
		}

		companyService.save(company);

		model.addAttribute("success", "Company " + company.getName()
				+ " updated successfully");
		return "update-company";
	}

	/*
	 * This method will delete a client by it's ID value.
	 */
	@RequestMapping(value = { "/delete/company/{id}" }, method = RequestMethod.GET)
	public String delete(@PathVariable Integer id) {
		Company company = companyService.findOne(id);
		companyService.remove(company);
		return "redirect:/list/company";
	}
	@RequestMapping(value = { "/delete-all/company/{rowCount}" }, method = RequestMethod.GET)
	public String deleteAll(@PathVariable Integer rowCount, final RedirectAttributes redirectAttributes, HttpServletRequest request,Integer id,ModelMap model) {
		logger.info("row count : " + rowCount);
		String checkBox="";
		String companyIdStr = "";
		Integer companyId = new Integer(java.sql.Types.NULL);
		Company company = null;
		List<Company> companys = new ArrayList<Company>(0);
		for (int count=0; count<=rowCount; count++) {
			checkBox=request.getParameter("checkbox"+count);
			logger.debug("count : "+ count + " || checkBox : "+ checkBox);
			
			if(checkBox == null){
				checkBox = "";
			}
			
			if("on".equals(checkBox)){
				companyIdStr = request.getParameter("companyId" + count);
				logger.debug("count : "+ count + " || checkBox : "+ checkBox);
				
				if(companyIdStr == null){
					companyIdStr = "";
				}
				
				if(!"".equals(companyIdStr)){

					// here check its number or not
					
					companyId = new Integer(companyIdStr);
					
					if(companyId.intValue() > 0){
						// here need to check exception
						try {							
							company = companyService.findOne(companyId);
						}
						catch(Exception e){
							logger.debug("Exception in finding a company data :- " + e);
						}
							
						}
						if(company != null){
							companys.add(company);
						}
					}
					
				}

			}
			
			if(!companys.isEmpty()){
				// here need to check exception
				try{
					companyService.remove(companys);
					redirectAttributes.addFlashAttribute("success", "COMPANIES DELETED");
				}
				catch(Exception e){
					logger.debug("Exception in removing companys data :- " + e);
					
				// here send success message to user
					
					model.addAttribute("success",   "Companys"
							+ " deleted successfully");
				
				//otherwise send failure msg.
			}
			 
		}

		return "redirect:/list/company";
	}

}

