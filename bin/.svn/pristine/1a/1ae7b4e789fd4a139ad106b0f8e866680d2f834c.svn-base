package com.fleet.service;

import com.fleet.model.User;

public interface UserService extends CrudService <User>{
	User findBySSO(String sso);
	void deleteUserBySSO(String sso);
	boolean isUserSSOUnique(Integer id, String sso);
	void updateUser(User user);
}
