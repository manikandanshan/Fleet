package com.fleet.dao.impl;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fleet.dao.UserDao;
import com.fleet.model.User;
import com.fleet.service.UserService;
import com.fleet.model.Client;
@Repository("UserDao")
public class UserDaoImpl extends CrudDaoImpl< User> implements UserDao {
  
  private final Logger logger = LoggerFactory
      .getLogger(UserDaoImpl.class);
  @Autowired
  private SessionFactory sessionFactory;

  @Autowired
  UserService userService;
	public User findBySSO(String sso) {
		//logger.info("SSO : {}", sso);
		Criteria crit = createEntityCriteria();
		crit.add(Restrictions.eq("ssoId", sso));
		User user = (User)crit.uniqueResult();
		if(user!=null){
			Hibernate.initialize(user.getRoles());
			logger.debug("findBySSO username :>>" +user.getSsoId());
	    logger.debug("findBySSO username roles :>>" +user.getRoles());
		}
		
    return user;
		
	}
	/*@Override
  @Transactional
  public User getUser(Integer id) {
    return (User) sessionFactory.getCurrentSession()
        .createQuery("from User user where user.id=?")
        .setParameter(0, id).uniqueResult();
  }
	@Override
  public Integer getRoleId(Integer id) {
    Session session = HibernateUtil.getHibernateSession();
    User user = (User) session.load(User.class, userId);
    return user.getRoles().getRoleId();
	  return null;
  }
	@Override
  public Integer getClientId(Integer id) {
    Client client = (Client) sessionFactory
        .getCurrentSession()
        .createQuery(
            "select client from User user where user.id = :id")
        .setParameter("userId", id).uniqueResult();
    logger.debug("Get User ClientId>>>:" +client.getClientId());
    return client.getClientId();
   
  }
	
	@Override
  @SuppressWarnings("unchecked")
  @Transactional
  public List<User> loadUserByClient(Integer id) {
    List<User> users = new ArrayList<User>();
    try {

    
      Criteria criteria = sessionFactory.getCurrentSession()
          .createCriteria(User.class, "user");
      
      criteria.add(Restrictions.eq("user.client.clientId", id));
      users = criteria.list();
      
     
    } catch (Exception e) {
      logger.error("Error while loading Users : " + e);
    }
    return users;

  }*/
	public void deleteBySSO(String sso) {
		Criteria crit = createEntityCriteria();
		crit.add(Restrictions.eq("ssoId", sso));
		User user = (User)crit.uniqueResult();
		delete(user);
	}
  
	

	

	
}

