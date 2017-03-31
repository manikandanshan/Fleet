package com.fleet.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fleet.model.Associate;
import com.fleet.service.AssociateService;

@Service("associateService")
@Transactional 
public class AssociateServiceImpl extends CrudServiceImpl<Associate> implements AssociateService {
	
}