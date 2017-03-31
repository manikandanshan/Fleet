package com.fleet.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fleet.model.Privilege;
import com.fleet.service.PrivilegeService;
import com.fleet.dao.PrivilegeDao;

@Service("PrivilegeService")
@Transactional 
public class PrivilegeServiceImpl extends CrudServiceImpl< Privilege> implements PrivilegeService{
  @Autowired
  PrivilegeDao privilegeDao;

  @Override
  @Transactional
  public List<Privilege> getPrivileges(Integer roleId, Integer featureId) {
    return privilegeDao.getPrivileges(roleId, featureId);
  }

}
