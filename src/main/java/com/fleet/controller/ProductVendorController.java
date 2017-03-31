
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

import com.fleet.model.ProductVendor;
import com.fleet.service.ProductVendorService;

@Controller

public class ProductVendorController {

	@Autowired
	ProductVendorService productVendorService;

	@Autowired
	MessageSource messageSource;
	
	private final Logger logger = LoggerFactory
			   .getLogger(ProductVendorController.class);


	/*
	 * This method will list all existing clients.
	 */
	@RequestMapping(value = { "/list/product-vendor" }, method = RequestMethod.GET)
	public String listPage(ModelMap model) {

		List<ProductVendor> productVendors = productVendorService.findAll();
		model.addAttribute("productVendors", productVendors);
		return "list-product-vendor";
	}

	/*
	 * This method will provide the medium to add a new client.
	 */

	@RequestMapping(value = { "/new/product-vendor" }, method = RequestMethod.GET)
	public String createPage(ModelMap model) {

		ProductVendor productVendor = new ProductVendor();
		model.addAttribute("productVendor", productVendor);
		model.addAttribute("edit", false);
		return "new-product-vendor";
	}

	/*
	 * This method will be called on form submission, handling POST request for
	 * saving client in database. It also validates the user input
	 */
	@RequestMapping(value = { "/new/product-vendor" }, method = RequestMethod.POST)
	public String savePage(@Valid ProductVendor productVendor, BindingResult result,
			ModelMap model) {

		if (result.hasErrors()) {
			return "new-product-vendor";
		}
		productVendorService.save(productVendor);

		model.addAttribute("success", "ProductVendor " + productVendor.getAverageLeadTime()
				+ " registered successfully");
		return "update-product-vendor";
	}

	/*
	 * This method will provide the medium to update an existing client.
	 */
	@RequestMapping(value = { "/edit/product-vendor/{id}" }, method = RequestMethod.GET)
	public String edit(@PathVariable Integer id, ModelMap model) {

		ProductVendor productVendor = productVendorService.findOne(id);
		model.addAttribute("productVendor", productVendor);
		model.addAttribute("edit", true);
		return "new-product-vendor";
	}

	/*
	 * This method will be called on form submission, handling POST request for
	 * updating client in database. It also validates the user input
	 */
	@RequestMapping(value = { "/edit/product-vendor/{id}" }, method = RequestMethod.POST)
	public String update(@Valid ProductVendor productVendor, BindingResult result,
			ModelMap model, @PathVariable Integer id) {

		if (result.hasErrors()) {
			return "new-product-vendor";
		}
		productVendorService.save(productVendor);

		model.addAttribute("success", "ProductVendor " + productVendor.getAverageLeadTime()
				+ " updated successfully");
		return "update-product-vendor";
	}

	/*
	 * This method will delete a client by it's ID value.
	 */
	@RequestMapping(value = { "/delete/product-vendor/{id}" }, method = RequestMethod.GET)
	public String delete(@PathVariable Integer id) {
		ProductVendor productVendor = productVendorService.findOne(id);
		productVendorService.remove(productVendor);
		return "redirect:/list/product-vendor";
	}
	@RequestMapping(value = { "/delete-all/productVendor/{rowCount}" }, method = RequestMethod.GET)
	public String deleteAll(@PathVariable Integer rowCount, final RedirectAttributes redirectAttributes, HttpServletRequest request,Integer id,ModelMap model) {
		logger.info("row count : " + rowCount);
		String checkBox="";
		String productVendorIdStr = "";
		Integer productVendorId = new Integer(java.sql.Types.NULL);
		ProductVendor productVendor = null;
		List<ProductVendor> productVendors = new ArrayList<ProductVendor>(0);
		for (int count=0; count<=rowCount; count++) {
			checkBox=request.getParameter("checkbox"+count);
			logger.debug("count : "+ count + " || checkBox : "+ checkBox);
			
			if(checkBox == null){
				checkBox = "";
			}
			
			if("on".equals(checkBox)){
				productVendorIdStr = request.getParameter("productVendorId" + count);
				logger.debug("count : "+ count + " || checkBox : "+ checkBox);
				
				if(productVendorIdStr == null){
					productVendorIdStr = "";
				}
				
				if(!"".equals(productVendorIdStr)){

					// here check its number or not
					
					productVendorId = new Integer(productVendorIdStr);
					
					if(productVendorId.intValue() > 0){
						// here need to check exception
						try {							
							productVendor = productVendorService.findOne(productVendorId);
						}
						catch(Exception e){
							logger.debug("Exception in finding a productVendor data :- " + e);
						}
							
						}
						if(productVendor != null){
							productVendors.add(productVendor);
						}
					}
					
				}

			}
			
			if(!productVendors.isEmpty()){
				// here need to check exception
				try{
					productVendorService.remove(productVendors);
					redirectAttributes.addFlashAttribute("success", "PRODUCTVENDORS DELETED");
				}
				catch(Exception e){
					logger.debug("Exception in removing productVendors data :- " + e);
					
				// here send success message to user
					
					model.addAttribute("success",   "productVendors"
							+ " deleted successfully");
				
				//otherwise send failure msg.
			}
			 
		}

		return "redirect:/list/product-vendor";
	}

}

