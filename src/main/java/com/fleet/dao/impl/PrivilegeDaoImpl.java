package com.fleet.dao.impl;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.fleet.dao.PrivilegeDao;
import com.fleet.model.Privilege;
import com.fleet.common.util.Constants;
@Repository("PrivilegeDao")
public class PrivilegeDaoImpl extends CrudDaoImpl<Privilege> implements PrivilegeDao {
  private final Logger logger = LoggerFactory
      .getLogger(PrivilegeDaoImpl.class);
  @Autowired
  private SessionFactory sessionFactory;
  
  @SuppressWarnings("unchecked")
  @Override
  public List<Privilege> getPrivileges(Integer roleId, Integer featureId) {
    @SuppressWarnings("unused")
    String funcName = "getPrivileges";
    logger.debug("PrivilegeDao Entering site:>>>");
    Session session = sessionFactory.getCurrentSession();
    List<Privilege> privilegeList = session.createQuery(Constants.PRIVILEGE_SELECT_BY_ROLE).setParameter("roleId", roleId).setParameter("featureId", featureId).list();
    logger.debug("PrivilegeDao Entering:>>>");
    logger.debug("PrivilegeDao Role and Feature :>>" +privilegeList);
   
    return privilegeList;
  }

}


