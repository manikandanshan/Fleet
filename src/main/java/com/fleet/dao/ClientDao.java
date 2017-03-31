package com.fleet.dao;

import com.fleet.model.Client;

/**
 * @author rameshbabu
 *
 */

public interface ClientDao extends CrudDao< Client> {
	
  Client getClient(Integer clientId);

	}

