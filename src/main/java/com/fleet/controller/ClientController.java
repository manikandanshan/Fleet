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
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.fleet.model.Client;
import com.fleet.model.Feature;
import com.fleet.model.Privilege;
import com.fleet.model.RolePrivilege;
import com.fleet.service.ClientService;
import com.fleet.service.RolePrivilegeService;
import com.fleet.service.UserService;


@Controller
public class ClientController {

	@Autowired
	ClientService clientService;
	
	@Autowired
	RolePrivilegeService rolePrivilegeService;
	
	@Autowired
  UserService userService;

	@Autowired
	MessageSource messageSource;
	
	private final Logger logger = LoggerFactory
			   .getLogger(ClientController.class);

	/*
	 * This method will list all existing clients.
	 */
	
	@RequestMapping(value = "/list/client", method = RequestMethod.GET)
  public ModelAndView listPage(ModelMap model, Integer clientId) {

    
    logger.debug("/list/client ENTERING...");
   
    List<Client> clients = clientService.findAll();
    
    model.addAttribute("clients", clients);
      
   /* List<RolePrivilege> rolePrivileges=rolePrivilegeService.getByRole(2);
    logger.debug("/list/client RolePrivilege : " + rolePrivileges);
    for (RolePrivilege rolePrivilege:rolePrivileges){
      Feature feature = rolePrivilege.getFeature();
      Privilege privilege = rolePrivilege.getPrivilege();
      logger.debug("RolePrivilege Element : " +feature.getName());
      logger.debug("RolePrivilege Element : " +privilege.getName());
    }*/
      
    
    //return "list-client";
    return new ModelAndView("list-client", model);  
  }
 
	/*@RequestMapping(value = "/list/client", method = RequestMethod.GET)
	public @ResponseBody ModelAndView getPrivilege(@RequestParam Integer roleId){
	  Map<String, Object> model = new HashMap<String, Object>();
	  List<RolePrivilege>  rolePrivileges=rolePrivilegeService.getByRole(roleId);
    logger.debug("/Identify Role Id of User: " + rolePrivileges);
    for (RolePrivilege rolePrivilege:rolePrivileges){
      Feature feature = rolePrivilege.getFeature();
      Privilege privilege = rolePrivilege.getPrivilege();
      logger.debug("RolePrivilege Element : " +feature.getName());
      logger.debug("RolePrivilege Element : " +privilege.getName());
	  	}
    return new ModelAndView("list-client", model);  
	}*/
	
	/*Updated code for role privileges*/
	/*@RequestMapping(value = "/list/client", method = RequestMethod.GET)
	public ModelAndView listPage(ModelMap model,@RequestParam(value="sso",required=false) String sso) {
	  
		logger.debug("/list/client ENTERING...");
		List<Client> clients = clientService.findAll();
		model.addAttribute("clients", clients);
		User user=userService.findBySSO(sso);
		User user = dao.findBySSO(sso);
    if(user!=null){
      Hibernate.initialize(user.getRoles());
    }
		logger.info("Client Controller user roles ::>>> " + user.getRoles());
		logger.info("user.getRoles() : " + user.getRoles());
		List<RolePrivilege>	rolePrivileges=rolePrivilegeService.getByRole(roleId);
		model.addAttribute("Role PrivilegeID:",rolePrivileges);
		logger.debug("Role ENTERING...:" +rolePrivileges);                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              
		for (RolePrivilege rolePrivilege:rolePrivileges){
		  Role role=rolePrivilege.getRole();                                                                                                                                                                                                                                                                                  
			Feature feature = rolePrivilege.getFeature();
			Privilege privilege = rolePrivilege.getPrivilege();
			logger.debug("RolePrivilege Element : " +role.getType());
			logger.debug("RolePrivilege Element : " +feature.getName());
			logger.debug("RolePrivilege Element : " +privilege.getName());
		}
			                                                              
		
		//return "list-client";
		return new ModelAndView("list-client", model);  
	}*/
	/*
	 * This method will provide the medium to add a new client.
	 */

	@RequestMapping(value = { "/new/client" }, method = RequestMethod.GET)
	public String createPage(ModelMap model) {

		Client client = new Client();
		model.addAttribute("client", client);
		model.addAttribute("edit", false);
		return "new-client";
	}

	/*
	 * This method will be called on form submission, handling POST request for
	 * saving client in database. It also validates the user input
	 */
	@RequestMapping(value = { "/new/client" }, method = RequestMethod.POST)
	public String savePage(@Valid Client client, final RedirectAttributes redirectAttributes, BindingResult result,
			ModelMap model) {

		if (result.hasErrors()) {
			return "new-client";
		}
		clientService.save(client);

		
		redirectAttributes.addFlashAttribute("success",  "CLIENT  "  + client.getName() + " ADDED");

		return "redirect:/new/client";
	}

	/*
	 * This method will provide the medium to update an existing client.
	 */
	@RequestMapping(value = { "/edit/client/{id}" }, method = RequestMethod.GET)
	public String editclient(@PathVariable Integer id, ModelMap model) {

		Client client = clientService.findOne(id);
		model.addAttribute("client", client);
		model.addAttribute("edit", true);
		return "new-client";
	}

	/*
	 * This method will be called on form submission, handling POST request for
	 * updating client in database. It also validates the user input
	 */
	@RequestMapping(value = { "/edit/client/{id}" }, method = RequestMethod.POST)
	public String updateClient(@Valid Client client, final RedirectAttributes redirectAttributes, BindingResult result,
			ModelMap model, @PathVariable Integer id) {

		if (result.hasErrors()) {
			return "new-client";
		}

		clientService.save(client);

		redirectAttributes.addFlashAttribute("success",  "UPDATED CLIENT  "  + client.getName());

		return "redirect:/new/client";
	}

	/*
	 * This method will delete a client by it's ID value.
*/
	@RequestMapping(value = { "/delete/client/{id}" }, method = RequestMethod.GET)
	public String deleteclient(@PathVariable Integer id) {
		Client client = clientService.findOne(id);
		clientService.remove(client);
		return "redirect:/list/client";
	}
	/*
	 * This method will deleteAll clients by it's ID value.
*/
	@RequestMapping(value = { "/delete-all/client/{rowCount}" }, method = RequestMethod.GET)
	public String deleteAll(@PathVariable Integer rowCount,HttpServletRequest request,
			final RedirectAttributes redirectAttributes, Integer id,ModelMap model) {
		logger.info("row count : " + rowCount);
		String checkBox="";
		String clientIdStr = "";
		Integer clinetId = new Integer(java.sql.Types.NULL);
		Client client = null;
		List<Client> clients = new ArrayList<Client>(0);
		for (int count=0; count<=rowCount; count++) {
			checkBox=request.getParameter("checkbox"+count);
			logger.debug("count : "+ count + " || checkBox : "+ checkBox);
			
			if(checkBox == null){
				checkBox = "";
			}
			
			if("on".equals(checkBox)){
				clientIdStr = request.getParameter("clientId" + count);
				logger.debug("count : "+ count + " || checkBox : "+ checkBox);
				
				if(clientIdStr == null){
					clientIdStr = "";
				}
				
				if(!"".equals(clientIdStr)){

					// here check its number or not
					
					clinetId = new Integer(clientIdStr);
					
					if(clinetId.intValue() > 0){
						// here need to check exception
						try {							
						client = clientService.findOne(clinetId);
						}
						catch(Exception e){
							logger.debug("Exception in finding a client data :- " + e);
						}
							
						}
						if(client != null){
							clients.add(client);
						}
					}
					
				}

			}
			
			if(!clients.isEmpty()){
				// here need to check exception
				try{
					clientService.remove(clients);
					
					
					
					redirectAttributes.addFlashAttribute("success", "CLIENTS DELETED");
					
					}
				catch(Exception e){
					logger.debug("Error in removing clients data :- ");
					
				// here send success message to user
					
								
				//otherwise send failure msg.
			}
					 
		}
			return "redirect:/list/client";	
		
	}
}
	