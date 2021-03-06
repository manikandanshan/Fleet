package com.fleet.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fleet.model.InsuranceProvider;
import com.fleet.service.InsuranceProviderService;

@Service("InsuranceProviderService")
@Transactional 
public class InsuranceProviderServiceImpl extends CrudServiceImpl<InsuranceProvider> implements InsuranceProviderService {

}
