/**
 * 
 */
package com.fleet.dao.impl;

import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.fleet.dao.ClientDao;
import com.fleet.model.Client;
import com.fleet.dao.impl.ClientDaoImpl;
@Repository("ClientDao")
public class ClientDaoImpl extends CrudDaoImpl< Client> implements ClientDao {
  @Autowired
  SessionFactory sessionFactory;
  
  private final Logger logger = LoggerFactory.getLogger(ClientDaoImpl.class);
  
  @Override
  @Transactional
  public Client getClient(Integer clientId) {
    return (Client) sessionFactory.getCurrentSession().createQuery("from Client where clientId = :clientId").setParameter("clientId", clientId).uniqueResult();
  }
}
