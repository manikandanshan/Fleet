/**
 * 
 */
package com.fleet.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.fleet.model.Privilege;
import com.fleet.service.PrivilegeService;
import com.fleet.service.RolePrivilegeService;

@Controller
public class PrivilegeController {
	@Autowired
	PrivilegeService privilegeService;
	
	@Autowired
  RolePrivilegeService rolePrivilegeService;
	
	@Autowired
	MessageSource messageSource;
	
	private final Logger logger = LoggerFactory
			   .getLogger(PrivilegeController.class);

	@RequestMapping(value = { "/list/privilege" }, method = RequestMethod.GET)
	public @ResponseBody ModelAndView getPrivilege(
	    @RequestParam Integer roleId,
	    @RequestParam Integer featureId){
Map<String, Object> model = new HashMap<String, Object>();
    logger.info("Privilege List Feature and Role Entering: ");
    List<Privilege> privilegeList = privilegeService.getPrivileges(roleId, featureId);
    model.put("privilegeList", privilegeList);
    logger.info("Privilege List Feature and Role ::>>> " + privilegeList);
    return new ModelAndView("viewpage",model);
    
  }
}