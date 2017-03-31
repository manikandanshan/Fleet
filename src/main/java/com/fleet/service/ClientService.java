package com.fleet.service;

import com.fleet.model.Client;



public interface ClientService extends CrudService <Client>{
  Client getClient(Integer clientId);
}
