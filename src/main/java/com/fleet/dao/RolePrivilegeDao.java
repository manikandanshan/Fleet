package com.fleet.dao;

import java.util.List;

import com.fleet.model.RolePrivilege;


public interface RolePrivilegeDao extends CrudDao<RolePrivilege> {
	
	
	public List<RolePrivilege> getByRole(Integer roleId);
	
	public List<RolePrivilege> getByFeature(Integer featureId);
	
	public List<RolePrivilege> getByPrivilege(Integer Id);
 /* public RolePrivilegeResponse getRolesPrivileges(Integer roleId);
  public List<FeatureForm> getFeatures(Integer roleId);
  List<String> getScreenAccesses(Integer userId, String screen);
  List<RolePrivilege> loadCurrentUserRolePrivileges();*/

}
