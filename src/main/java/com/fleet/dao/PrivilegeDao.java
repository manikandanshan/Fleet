package com.fleet.dao;

import java.util.List;

import com.fleet.model.Privilege;

/**
 * @author rameshbabu
 *
 */

public interface PrivilegeDao extends CrudDao< Privilege> {
	
  public List<Privilege> getPrivileges(Integer roleId, Integer featureId);
	
	

}

