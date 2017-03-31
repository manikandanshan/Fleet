package com.fleet.dao;

import java.util.List;

import com.fleet.model.User;

/**
 * @author rameshbabu
 *
 */


public interface UserDao extends CrudDao< User>{
	
	User findBySSO(String sso);
	/*User getUser(Integer id);
	Integer getRoleId(Integer id);
  Integer getClientId(Integer id);
  List<User> loadUserByClient(Integer clientId);*/
	void deleteBySSO(String sso);
	}

