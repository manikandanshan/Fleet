/**
 * 
 */
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

import com.fleet.model.AssociateType;
import com.fleet.service.AssociateTypeService;

/**
 * @author shine
 * 
 */
@Controller
public class AssociateTypeController {
  @Autowired
  AssociateTypeService associateTypeService;
  @Autowired
  MessageSource messageSource;

  private final Logger logger = LoggerFactory.getLogger(AssociateTypeController.class);

  /*
   * This method will list all existing associateTypes.
   */
  @RequestMapping(value = { "/list/associate-type" }, method = RequestMethod.GET)
  public String listPage(ModelMap model) {
    List<AssociateType> associateTypes = associateTypeService.findAll();
    model.addAttribute("associateTypes", associateTypes);
    return "list-associate-type";
  }

  /*
   * This method will provide the medium to add a new associateType.
   */
  @RequestMapping(value = { "/new/associate-type" }, method = RequestMethod.GET)
  public String newPage(ModelMap model) {
    AssociateType associateType = new AssociateType();
    model.addAttribute("associateType", associateType);
    model.addAttribute("edit", false);
    return "new-associate-type";
  }

  /*
   * This method will be called on form submission, handling POST request for saving associateType
   * in database. It also validates the user input
   */
  @RequestMapping(value = { "/new/associate-type" }, method = RequestMethod.POST)
  public String savePage(@Valid AssociateType associateType,
      final RedirectAttributes redirectAttributes, BindingResult result, ModelMap model) {

    if (result.hasErrors()) {
      return "new-associate-type";
    }
    associateTypeService.save(associateType);
    redirectAttributes.addFlashAttribute("success",
        "Associate Type  " + associateType.getName()+ " added successfully");
    return "redirect:/new/associate-type";
  }

  /*
   * This method will provide the medium to update an existing associateType.
   */
  @RequestMapping(value = { "/edit/associate-type/{id}" }, method = RequestMethod.GET)
  public String editPage(@PathVariable Integer id, ModelMap model) {
    AssociateType associateType = associateTypeService.findOne(id);
    model.addAttribute("associateType", associateType);
    model.addAttribute("edit", true);
    return "new-associate-type";
  }

  /*
   * This method will be called on form submission, handling POST request for updating associateType
   * in database. It also validates the user input
   */
  @RequestMapping(value = { "/edit/associate-type/{id}" }, method = RequestMethod.POST)
  public String updatePage(@Valid AssociateType associateType,
      final RedirectAttributes redirectAttributes, BindingResult result, ModelMap model,
      @PathVariable Integer id) {
    if (result.hasErrors()) {
      return "new-associate-type";
    }
    associateTypeService.save(associateType);
    redirectAttributes.addFlashAttribute("success",
        "Associate Type  " + associateType.getName()+ " updated successfully");
    return "redirect:/new/associate-type";
  }

  /*
   * This method will delete an associateType by it's id value.
   */
  @RequestMapping(value = { "/delete/associate-type/{id}" }, method = RequestMethod.GET)
  public String deletePage(@PathVariable Integer id) {
    AssociateType associateType = associateTypeService.findOne(id);
    associateTypeService.remove(associateType);
    return "redirect:/list/associate-type";
  }

  @RequestMapping(value = { "/delete-all/associateType/{rowCount}" }, method = RequestMethod.GET)
  public String deleteAll(@PathVariable Integer rowCount,
      final RedirectAttributes redirectAttributes, HttpServletRequest request, Integer id,
      ModelMap model) {
    logger.info("row count : " + rowCount);
    String checkBox = "";
    String associateTypeIdStr = "";
    Integer associateTypeId = new Integer(java.sql.Types.NULL);
    AssociateType associateType = null;
    List<AssociateType> associateTypes = new ArrayList<AssociateType>(0);
    for (int count = 0; count <= rowCount; count++) {
      checkBox = request.getParameter("checkbox" + count);
      logger.debug("count : " + count + " || checkBox : " + checkBox);

      if (checkBox == null) {
        checkBox = "";
      }

      if ("on".equals(checkBox)) {
        associateTypeIdStr = request.getParameter("associateTypeId" + count);
        logger.debug("count : " + count + " || checkBox : " + checkBox);

        if (associateTypeIdStr == null) {
          associateTypeIdStr = "";
        }

        if (!"".equals(associateTypeIdStr)) {

          // here check its number or not

          associateTypeId = new Integer(associateTypeIdStr);

          if (associateTypeId.intValue() > 0) {
            // here need to check exception
            try {
              associateType = associateTypeService.findOne(associateTypeId);
            } catch (Exception e) {
              logger.debug("Exception in finding a associateType data :- " + e);
            }

          }
          if (associateType != null) {
            associateTypes.add(associateType);
          }
        }

      }

    }

    if (!associateTypes.isEmpty()) {
      // here need to check exception
      try {
        associateTypeService.remove(associateTypes);
        redirectAttributes.addFlashAttribute("success", "Associate Types Deleted sucessfully");

      } catch (Exception e) {
        logger.debug("Exception in removing associateTypes data :- " + e);

        // here send success message to user
        // otherwise send failure msg.
      }

    }

    return "redirect:/list/associate-type";
  }
}
