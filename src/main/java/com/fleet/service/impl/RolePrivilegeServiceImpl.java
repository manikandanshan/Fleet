package com.fleet.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fleet.dao.RolePrivilegeDao;
import com.fleet.model.RolePrivilege;
import com.fleet.service.RolePrivilegeService;

@Service("rolePrivilegeService")
public class RolePrivilegeServiceImpl extends CrudServiceImpl<RolePrivilege> implements RolePrivilegeService{

	@Autowired
    private RolePrivilegeDao rolePrivilegeDAO;


	@Override
	@Transactional
	public List<RolePrivilege> getByRole(Integer roleId) {
		return rolePrivilegeDAO.getByRole(roleId);
	}
	
	@Override
	@Transactional
	public List<RolePrivilege> getByFeature(Integer featureId) {
		return rolePrivilegeDAO.getByFeature(featureId);
	}
	
	@Override
	@Transactional
	public List<RolePrivilege> getByPrivilege(Integer privilegeId) {
		return rolePrivilegeDAO.getByPrivilege(privilegeId);
	}
	
}
