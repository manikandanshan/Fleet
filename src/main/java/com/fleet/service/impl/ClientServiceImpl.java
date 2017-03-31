package com.fleet.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fleet.model.Client;
import com.fleet.service.ClientService;
import com.fleet.dao.ClientDao;
import com.fleet.service.impl.ClientServiceImpl;

@Service("ClientService")
@Transactional 
public class ClientServiceImpl  extends CrudServiceImpl< Client> implements ClientService{

  @Autowired
  ClientDao clientDao;
  
  private final Logger logger = LoggerFactory.getLogger(ClientServiceImpl.class);
  
  @Override
  public Client getClient(Integer clientId) {
    
    logger.debug("Client ID of user>>>:" +clientDao.getClient(clientId));
    return clientDao.getClient(clientId);
    
    

  }
}
