/**
 * 
 */
package com.fleet.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.security.authentication.AuthenticationTrustResolver;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.rememberme.PersistentTokenBasedRememberMeServices;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.fleet.model.User;
import com.fleet.model.Role;
import com.fleet.model.User;
import com.fleet.service.EmployeeService;
import com.fleet.service.RoleService;
import com.fleet.service.UserService;
import com.fleet.service.RolePrivilegeService;
import com.fleet.model.Client;
import com.fleet.service.ClientService;

@Controller
@RequestMapping("/")
@SessionAttributes("roles")
public class AppController {

  @Autowired
  RolePrivilegeService rolePrivilegeService;

  @Autowired
  UserService userService;

  @Autowired
  RoleService roleService;

  @Autowired
  EmployeeService service;

  @Autowired
  MessageSource messageSource;
  
  @Autowired
  private ClientService clientService;
  @Autowired
  PersistentTokenBasedRememberMeServices persistentTokenBasedRememberMeServices;

  @Autowired
  AuthenticationTrustResolver authenticationTrustResolver;

  private final Logger logger = LoggerFactory.getLogger(AppController.class);

  @RequestMapping(value = { "/", "/" }, method = RequestMethod.GET)
  public String login(HttpSession session, ModelMap model) {
    List<User> users = userService.findAll();
    model.addAttribute("users", users);
    model.addAttribute("loggedinuser", getPrincipal());
    return "list-default";
  }

  /*
   * This method will list all existing Users.
   */
  @RequestMapping(value = { "/list/user" }, method = RequestMethod.GET)
  public String listEmployees(HttpSession session,ModelMap model, Object Name) {
    // get client ID from Session
    Integer clientId = new Integer(java.sql.Types.NULL);
    logger.debug("Get Client Details:>>" +clientId);
   /*clientId = new Integer(2);*/
    clientId = (Integer) session.getAttribute("user.getClient");
    logger.debug("Get Current Client Details:>>" +clientId);
    List<User> users = userService.findAllByProperty("client.clientId", clientId);
    logger.debug("users : " + users);
       
      model.addAttribute("users", users);
      model.addAttribute("loggedinuser", getPrincipal());
    
    
   /* clientId = new Integer(2);// remove hard code
    List<User> users = userService.findAllByProperty("client.clientId", clientId);
    List<User> users=userService.findAll();
    logger.debug("users : " + users);
    model.addAttribute("users", users);
    model.addAttribute("loggedinuser", getPrincipal());*/
    return "list-users";
  }

  /**
   * This method will provide the medium to add a new user.
   */
  @RequestMapping(value = { "/new/user" }, method = RequestMethod.GET)
  public String newEmployee(ModelMap model) {
    User user = new User();
    model.addAttribute("user", user);
    model.addAttribute("edit", false);
    model.addAttribute("loggedinuser", getPrincipal());
    return "new-users";
  }

  /**
   * This method will be called on form submission, handling POST request for saving user in
   * database. It also validates the user input
   */
  @RequestMapping(value = { "/new/user" }, method = RequestMethod.POST)
  public String saveEmployee(@Valid User user, BindingResult result, ModelMap model) {

    if (result.hasErrors()) {
      return "redirect:/list/user";
    }
    /*
     * Preferred way to achieve uniqueness of field [sso] should be implementing custom @Unique
     * annotation and applying it on field [sso] of Model class [User].
     * 
     * Below mentioned peace of code [if block] is to demonstrate that you can fill custom errors
     * outside the validation framework as well while still using internationalized messages.
     */
    if (!userService.isUserSSOUnique(user.getId(), user.getSsoId())) {
      FieldError ssoError = new FieldError("user", "userId", messageSource.getMessage(
          "non.unique.ssoId", new String[] { user.getSsoId() }, Locale.getDefault()));
      result.addError(ssoError);
      return "new-users";
    }

    userService.save(user);

    model.addAttribute("success", "User " + user.getFirstName() + " " + user.getLastName()
        + " registered successfully");
    model.addAttribute("loggedinuser", getPrincipal());
    // return "success";
    return "redirect:/list/user";
  }

  /**
   * This method will provide the medium to update an existing user.
   */
  @RequestMapping(value = { "/edit/user/{ssoId}" }, method = RequestMethod.GET)
  public String editUser(@PathVariable String ssoId, ModelMap model) {
    User user = userService.findBySSO(ssoId);
    model.addAttribute("user", user);
    model.addAttribute("edit", true);
    model.addAttribute("loggedinuser", getPrincipal());
    return "new-users";
  }

  /**
   * This method will be called on form submission, handling POST request for updating user in
   * database. It also validates the user input
   */
  @RequestMapping(value = { "/edit/user/{ssoId}" }, method = RequestMethod.POST)
  public String updateUser(@Valid User user, BindingResult result, ModelMap model,
      @PathVariable String ssoId) {

    if (result.hasErrors()) {
      return "new-users";
    }

    /*
     * //Uncomment below 'if block' if you WANT TO ALLOW UPDATING SSO_ID in UI which is a unique key
     * to a User. if(!userService.isUserSSOUnique(user.getId(), user.getSsoId())){ FieldError
     * ssoError =new FieldError("user","ssoId",messageSource.getMessage("non.unique.ssoId", new
     * String[]{user.getSsoId()}, Locale.getDefault())); result.addError(ssoError); return
     * "registration"; }
     */

    userService.save(user);

    model.addAttribute("success", "User " + user.getFirstName() + " " + user.getLastName()
        + " updated successfully");
    model.addAttribute("loggedinuser", getPrincipal());
    return "redirect:/list/user";
  }

  /**
   * This method will delete an user by it's SSOID value.
   */
  @RequestMapping(value = { "/delete/user/{ssoId}" }, method = RequestMethod.GET)
  public String deleteUser(@PathVariable String ssoId) {
    User user = userService.findBySSO(ssoId);
    userService.remove(user);
    return "redirect:/list/user";
  }

  @RequestMapping(value = { "/delete-all/user/{rowCount}" }, method = RequestMethod.GET)
  public String deleteAll(@PathVariable Integer rowCount,
      final RedirectAttributes redirectAttributes, HttpServletRequest request, Integer id,
      ModelMap model) {
    logger.info("row count : " + rowCount);
    String checkBox = "";
    String userIdStr = "";
    Integer userId = new Integer(java.sql.Types.NULL);
    User user = null;
    List<User> users = new ArrayList<User>(0);
    for (int count = 1; count <= rowCount; count++) {
      checkBox = request.getParameter("checkbox" + count);
      logger.debug("count1 : " + count + " || checkBox : " + checkBox);

      if (checkBox == null) {
        checkBox = "";
      }

      if ("on".equals(checkBox)) {
        userIdStr = request.getParameter("userId" + count);
        logger.debug("count2 : " + count + " || checkBox : " + checkBox);

        if (userIdStr == null) {
          userIdStr = "";
        }

        if (!"".equals(userIdStr)) {

          // here check its number or not

          userId = new Integer(userIdStr);

          if (userId.intValue() > 0) {
            // here need to check exception
            try {
              logger.debug("Trying ISIT EMPTY 1st:- ");
              user = userService.findOne(userId);
              logger.debug("Trying ISIT EMPTY 2:- " + user.getFirstName());
            } catch (Exception e) {
              logger.debug("Exception in finding a user data :- " + e);
            }

          }
          if (user != null) {
            users.add(user);
          }
        }

      }

    }

    if (!users.isEmpty()) {
      // here need to check exception
      try {
        logger.debug("Trying ISIT EMPTY:- ");
        userService.remove(users);

        redirectAttributes.addFlashAttribute("success", "USERS DELETED");
      } catch (Exception e) {
        logger.debug("Exception in removing users data :- " + e);

        // here send success message to user

        model.addAttribute("success", "Users" + " deleted successfully");

        // otherwise send failure msg.
      }

    }

    return "redirect:/list/user";
  }

  /**
   * This method will provide UserProfile list to views
   */
  @ModelAttribute("roles")
  public List<Role> initializeProfiles() {
    return roleService.findAll();
  }

  /**
   * This method handles Access-Denied redirect.
   */
  @RequestMapping(value = "/Access_Denied", method = RequestMethod.GET)
  public String accessDeniedPage(ModelMap model) {
    model.addAttribute("loggedinuser", getPrincipal());
    return "accessDenied";
  }

  /**
   * This method handles login GET requests. If users is already logged-in and tries to goto login
   * page again, will be redirected to list page.
   */
  @RequestMapping(value = "/login", method = RequestMethod.GET)
  public String loginPage() {
    if (isCurrentAuthenticationAnonymous()) {
      return "login";
    } else {
      return "login";
    }
  }

  /**
   * @RequestMapping(value = "/login", method = RequestMethod.GET) public String
   *                       loginPage(@RequestParam(value = "error",required = false) String
   *                       error,ModelMap model,
   * @RequestParam(value = "logout", required = false) String logout) {
   * 
   * 
   *                     if (error != null) { model.addAttribute("error",
   *                     "Invalid Credentials provided."); }
   * 
   *                     if (logout != null) { model.addAttribute("message",
   *                     "Logged out from JournalDEV successfully."); }
   * 
   *                     return "redirect:/list"; }
   **/

  /*
   * @RequestMapping(value = "/login1", method = RequestMethod.POST) public String
   * loginPage1(ModelMap model) {
   * 
   * List<User> users = userService.findAll(); model.addAttribute("users", users);
   * model.addAttribute("loggedinuser",getPrincipal()); return "list-client"; }
   */
  /**
   * This method handles logout requests. Toggle the handlers if you are RememberMe functionality is
   * useless in your app.
   */
  @RequestMapping(value = "/logout", method = RequestMethod.GET)
  public String logoutSuccessfulPage(ModelMap model) {
    model.addAttribute("title", "Logout");
    return "redirect:/login?logout";
  }

  /*
   * @RequestMapping(value="/logout", method = RequestMethod.GET) public String logoutPage
   * (HttpServletRequest request, HttpServletResponse response){ Authentication auth =
   * SecurityContextHolder.getContext().getAuthentication(); if (auth != null){ //new
   * SecurityContextLogoutHandler().logout(request, response, auth);
   * persistentTokenBasedRememberMeServices.logout(request, response, auth);
   * SecurityContextHolder.getContext().setAuthentication(null); } return "redirect:/login?logout";
   * }
   * 
   * /** This method returns the principal[user-name] of logged-in user.
   */
  private String getPrincipal() {
    String userName = null;
    Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

    if (principal instanceof UserDetails) {
      userName = ((UserDetails) principal).getUsername();
    } else {
      userName = principal.toString();
    }
    return userName;
  }

  /**
   * This method returns true if users is already authenticated [logged-in], else false.
   **/
  private boolean isCurrentAuthenticationAnonymous() {
    final Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    return authenticationTrustResolver.isAnonymous(authentication);
  }

  /*
   * This method will list all existing employees.
   */
  /*
   * @RequestMapping(value = { "/", "/list1" }, method = RequestMethod.GET) public String
   * listEmployees(ModelMap model) {
   * 
   * List<Employee> employees = service.findAllEmployees(); model.addAttribute("employees",
   * employees); return "allemployees"; }
   * 
   * /* This method will provide the medium to add a new employee.
   */
  /*
   * @RequestMapping(value = { "/new" }, method = RequestMethod.GET) public String
   * newEmployee(ModelMap model) { Employee employee = new Employee();
   * model.addAttribute("employee", employee); model.addAttribute("edit", false); return
   * "registration"; }
   * 
   * /* This method will be called on form submission, handling POST request for saving employee in
   * database. It also validates the user input
   */
  /*
   * @RequestMapping(value = { "/new" }, method = RequestMethod.POST) public String
   * saveEmployee(@Valid Employee employee, BindingResult result, ModelMap model) {
   * 
   * if (result.hasErrors()) { return "registration"; }
   * 
   * /* Preferred way to achieve uniqueness of field [ssn] should be implementing custom @Unique
   * annotation and applying it on field [ssn] of Model class [Employee].
   * 
   * Below mentioned peace of code [if block] is to demonstrate that you can fill custom errors
   * outside the validation framework as well while still using internationalized messages.
   */
  /*
   * if(!service.isEmployeeSsnUnique(employee.getId(), employee.getSsn())){ FieldError ssnError =new
   * FieldError("employee","ssn",messageSource.getMessage("non.unique.ssn", new
   * String[]{employee.getSsn()}, Locale.getDefault())); result.addError(ssnError); return
   * "registration"; }
   * 
   * service.saveEmployee(employee);
   * 
   * model.addAttribute("success", "Employee " + employee.getName() + " registered successfully");
   * return "success"; }
   * 
   * 
   * /* This method will provide the medium to update an existing employee.
   */
  /*
   * @RequestMapping(value = { "/edit-{ssn}-employee" }, method = RequestMethod.GET) public String
   * editEmployee(@PathVariable String ssn, ModelMap model) { Employee employee =
   * service.findEmployeeBySsn(ssn); model.addAttribute("employee", employee);
   * model.addAttribute("edit", true); return "registration"; }
   * 
   * /* This method will be called on form submission, handling POST request for updating employee
   * in database. It also validates the user input
   */
  /*
   * @RequestMapping(value = { "/edit-{ssn}-employee" }, method = RequestMethod.POST) public String
   * updateEmployee(@Valid Employee employee, BindingResult result, ModelMap model, @PathVariable
   * String ssn) {
   * 
   * if (result.hasErrors()) { return "registration"; }
   * 
   * if(!service.isEmployeeSsnUnique(employee.getId(), employee.getSsn())){ FieldError ssnError =new
   * FieldError("employee","ssn",messageSource.getMessage("non.unique.ssn", new
   * String[]{employee.getSsn()}, Locale.getDefault())); result.addError(ssnError); return
   * "registration"; }
   * 
   * service.updateEmployee(employee);
   * 
   * model.addAttribute("success", "Employee " + employee.getName() + " updated successfully");
   * return "success"; }
   * 
   * 
   * /* This method will delete an employee by it's SSN value.
   */
  /*
   * @RequestMapping(value = { "/delete-{ssn}-employee" }, method = RequestMethod.GET) public String
   * deleteEmployee(@PathVariable String ssn) { service.deleteEmployeeBySsn(userssn); return
   * "redirect:/list1"; }
   */

}