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

import com.fleet.model.Feature;
import com.fleet.service.FeatureService;

@Controller
public class FeatureController {

	@Autowired
	FeatureService featureService;

	@Autowired
	MessageSource messageSource;
	
	private final Logger logger = LoggerFactory
			   .getLogger(FeatureController.class);


	/*
	 * This method will list all existing Features.
	 */
	@RequestMapping(value = { "/list/feature" }, method = RequestMethod.GET)
	public String listPage(ModelMap model) {

		List<Feature> features = featureService.findAll();
		model.addAttribute("features", features);
		return "list-feature";
	}

	/*
	 * This method will provide the medium to add a new Feature.
	 */

	@RequestMapping(value = { "/new/feature" }, method = RequestMethod.GET)
	public String createPage(ModelMap model) {

		Feature feature = new Feature();
		model.addAttribute("feature", feature);
		model.addAttribute("edit", false);
		return "new-feature";
	}

	/*
	 * This method will be called on form submission, handling POST request for
	 * saving feature in database. It also validates the user input
	 */
	@RequestMapping(value = { "/new/feature" }, method = RequestMethod.POST)
	public String savePage(@Valid Feature feature, BindingResult result,
			ModelMap model) {

		if (result.hasErrors()) {
			return "new-feature";
		}
		featureService.save(feature);

		model.addAttribute("success", "Feature " + feature.getName()
				+ " registered successfully");
		return "update-feature";
	}

	/*
	 * This method will provide the medium to update an existing feature.
	 */
	@RequestMapping(value = { "/edit/feature/{id}" }, method = RequestMethod.GET)
	public String edit(@PathVariable Integer id, ModelMap model) {

		Feature feature = featureService.findOne(id);
		model.addAttribute("feature", feature);
		model.addAttribute("edit", true);
		return "new-feature";
	}

	/*
	 * This method will be called on form submission, handling POST request for
	 * updating Feature in database. It also validates the user input
	 */
	@RequestMapping(value = { "/edit/feature/{id}" }, method = RequestMethod.POST)
	public String update(@Valid Feature feature, BindingResult result,
			ModelMap model, @PathVariable Integer id) {

		if (result.hasErrors()) {
			return "new-feature";
		}

		featureService.save(feature);

		model.addAttribute("success", "Feature " + feature.getName()
				+ " updated successfully");
		return "update-feature";
	}

	/*
	 * This method will delete a feature by it's ID value.
	 */
	@RequestMapping(value = { "/delete/feature/{id}" }, method = RequestMethod.GET)
	public String delete(@PathVariable Integer id) {
		Feature feature = featureService.findOne(id);
		featureService.remove(feature);
		return "redirect:/list/feature";
	}
	@RequestMapping(value = { "/delete-all/feature/{rowCount}" }, method = RequestMethod.GET)
	public String deleteAll(@PathVariable Integer rowCount, final RedirectAttributes redirectAttributes, HttpServletRequest request,Integer id,ModelMap model) {
		logger.info("row count : " + rowCount);
		String checkBox="";
		String featureIdStr = "";
		Integer featureId = new Integer(java.sql.Types.NULL);
		Feature feature = null;
		List<Feature> features = new ArrayList<Feature>(0);
		for (int count=0; count<=rowCount; count++) {
			checkBox=request.getParameter("checkbox"+count);
			logger.debug("count : "+ count + " || checkBox : "+ checkBox);
			
			if(checkBox == null){
				checkBox = "";
			}
			
			if("on".equals(checkBox)){
				featureIdStr = request.getParameter("featureId" + count);
				logger.debug("count : "+ count + " || checkBox : "+ checkBox);
				
				if(featureIdStr == null){
					featureIdStr = "";
				}
				
				if(!"".equals(featureIdStr)){

					// here check its number or not
					
					featureId = new Integer(featureIdStr);
					
					if(featureId.intValue() > 0){
						// here need to check exception
						try {							
							feature = featureService.findOne(featureId);
						}
						catch(Exception e){
							logger.debug("Exception in finding a feature data :- " + e);
						}
							
						}
						if(feature != null){
							features.add(feature);
						}
					}
					
				}

			}
			
			if(!features.isEmpty()){
				// here need to check exception
				try{
					featureService.remove(features);
					redirectAttributes.addFlashAttribute("success", "FEATURES DELETED");
				}
				catch(Exception e){
					logger.debug("Exception in removing features data :- " + e);
					
				// here send success message to user
					
					model.addAttribute("success",   "Features"
							+ " deleted successfully");
				
				//otherwise send failure msg.
			}
			 
		}

		return "redirect:/list/feature";
	}

}
