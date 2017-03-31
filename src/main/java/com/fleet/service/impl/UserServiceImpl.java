package com.fleet.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fleet.dao.UserDao;
import com.fleet.model.User;
import com.fleet.service.UserService;

@Service("UserService")
@Transactional
public class UserServiceImpl extends CrudServiceImpl<User> implements UserService{
  @Autowired
  private UserDao dao;

  @Autowired
    private PasswordEncoder passwordEncoder;
  public User findBySSO(String sso) {
    User user = dao.findBySSO(sso);
    return user;
  }
  /*
   * Since the method is running with Transaction, No need to call hibernate update explicitly.
   * Just fetch the entity from db and update it with proper values within transaction.
   * It will be updated in db once transaction ends. 
   */
  public void updateUser(User user) {
    User entity = dao.findOne(user.getId());
    if(entity!=null){
      entity.setSsoId(user.getSsoId());
      if(!user.getPassword().equals(entity.getPassword())){
        entity.setPassword(passwordEncoder.encode(user.getPassword()));
      }
      entity.setFirstName(user.getFirstName());
      entity.setLastName(user.getLastName());
      entity.setEmail(user.getEmail());
      entity.setRoles(user.getRoles());
    }
  }

  
  public void deleteUserBySSO(String sso) {
    dao.deleteBySSO(sso);
  }
  public boolean isUserSSOUnique(Integer id, String sso) {
    User user = findBySSO(sso);
    return ( user == null || ((id != null) && (user.getId() == id)));
  }
}
