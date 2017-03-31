

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

import com.fleet.model.VendorDetail;
import com.fleet.service.VendorDetailService;

@Controller
public class VendorDetailController {

	@Autowired
	VendorDetailService vendorDetailService;

	@Autowired
	MessageSource messageSource;
	
	private final Logger logger = LoggerFactory
			   .getLogger(VendorDetailController.class);

	/*
	 * This method will list all existing clients.
	 */
	@RequestMapping(value = { "/list/vendor-detail" }, method = RequestMethod.GET)
	public String listPage(ModelMap model) {

		List<VendorDetail> vendorDetails = vendorDetailService.findAll();
		model.addAttribute("vendorDetails", vendorDetails);
		return "list-vendor-detail";
	}

	/*
	 * This method will provide the medium to add a new client.
	 */

	@RequestMapping(value = { "/new/vendor-detail" }, method = RequestMethod.GET)
	public String createPage(ModelMap model) {

		VendorDetail vendorDetail = new VendorDetail();
		model.addAttribute("vendorDetail", vendorDetail);
		model.addAttribute("edit", false);
		return "new-vendor-detail";
	}

	/*
	 * This method will be called on form submission, handling POST request for
	 * saving client in database. It also validates the user input
	 */
	@RequestMapping(value = { "/new/vendor-detail" }, method = RequestMethod.POST)
	public String savePage(@Valid VendorDetail vendorDetail, BindingResult result,
			ModelMap model) {

		if (result.hasErrors()) {
			return "new-vendor-detail";
		}
		vendorDetailService.save(vendorDetail);

		model.addAttribute("success", "VendorDetail " + vendorDetail.getName()
				+ " registered successfully");
		return "update-vendor-detail";
	}

	/*
	 * This method will provide the medium to update an existing client.
	 */
	@RequestMapping(value = { "/edit/vendor-detail/{id}" }, method = RequestMethod.GET)
	public String edit(@PathVariable Integer id, ModelMap model) {

		VendorDetail vendorDetail = vendorDetailService.findOne(id);
		model.addAttribute("vendorDetail", vendorDetail);
		model.addAttribute("edit", true);
		return "new-vendor-detail";
	}

	/*
	 * This method will be called on form submission, handling POST request for
	 * updating client in database. It also validates the user input
	 */
	@RequestMapping(value = { "/edit/vendor-detail/{id}" }, method = RequestMethod.POST)
	public String update(@Valid VendorDetail vendorDetail, BindingResult result,
			ModelMap model, @PathVariable Integer id) {

		if (result.hasErrors()) {
			return "new-vendor-detail";
		}
		vendorDetailService.save(vendorDetail);

		model.addAttribute("success", "VendorDetail " + vendorDetail.getName()
				+ " updated successfully");
		return "update-vendor-detail";
	}

	/*
	 * This method will delete a client by it's ID value.
	 */
	@RequestMapping(value = { "/delete/vendor-detail/{id}" }, method = RequestMethod.GET)
	public String delete(@PathVariable Integer id) {
		VendorDetail vendorDetail = vendorDetailService.findOne(id);
		vendorDetailService.remove(vendorDetail);
		return "redirect:/list/vendor-detail";
	}
	
	@RequestMapping(value = { "/delete-all/vendorDetail/{rowCount}" }, method = RequestMethod.GET)
	public String deleteAll(@PathVariable Integer rowCount, final RedirectAttributes redirectAttributes, HttpServletRequest request,Integer id,ModelMap model) {
		logger.info("row count : " + rowCount);
		String checkBox="";
		String vendorDetailIdStr = "";
		Integer vendorDetailId = new Integer(java.sql.Types.NULL);
		VendorDetail vendorDetail = null;
		List<VendorDetail> vendorDetails = new ArrayList<VendorDetail>(0);
		for (int count=0; count<=rowCount; count++) {
			checkBox=request.getParameter("checkbox"+count);
			logger.debug("count : "+ count + " || checkBox : "+ checkBox);
			
			if(checkBox == null){
				checkBox = "";
			}
			
			if("on".equals(checkBox)){
				vendorDetailIdStr = request.getParameter("vendorDetailId" + count);
				logger.debug("count : "+ count + " || checkBox : "+ checkBox);
				
				if(vendorDetailIdStr == null){
					vendorDetailIdStr = "";
				}
				
				if(!"".equals(vendorDetailIdStr)){

					// here check its number or not
					
					vendorDetailId = new Integer(vendorDetailIdStr);
					
					if(vendorDetailId.intValue() > 0){
						// here need to check exception
						try {							
							vendorDetail = vendorDetailService.findOne(vendorDetailId);
						}
						catch(Exception e){
							logger.debug("Exception in finding a vendorDetail data :- " + e);
						}
							
						}
						if(vendorDetail != null){
							vendorDetails.add(vendorDetail);
						}
					}
					
				}

			}
			
			if(!vendorDetails.isEmpty()){
				// here need to check exception
				try{
					vendorDetailService.remove(vendorDetails);
					redirectAttributes.addFlashAttribute("success", "VENDORDETAILS DELETED");
				}
				catch(Exception e){
					logger.debug("Exception in removing vendorDetails data :- " + e);
					
				// here send success message to user
					
					model.addAttribute("success",   "VendorDetails"
							+ " deleted successfully");
				
				//otherwise send failure msg.
			}
			 
		}

		return "redirect:/list/vendor-detail";
	}

}

