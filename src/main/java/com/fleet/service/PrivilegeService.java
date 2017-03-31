package com.fleet.service;

import java.util.List;

import com.fleet.model.Privilege;



public interface PrivilegeService  extends CrudService <Privilege> {
  public List<Privilege> getPrivileges(Integer roleId, Integer featureId);
}