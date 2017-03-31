package com.fleet.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fleet.model.FuelType;
import com.fleet.service.FuelTypeService;

@Service("FuelTypeService")
@Transactional 
public class FuelTypeServiceImpl extends CrudServiceImpl< FuelType> implements FuelTypeService {


}
