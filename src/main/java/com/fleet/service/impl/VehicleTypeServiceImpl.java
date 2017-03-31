package com.fleet.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fleet.model.VehicleType;
import com.fleet.service.VehicleTypeService;

@Service("VehicleTypeService")
@Transactional
public class VehicleTypeServiceImpl extends CrudServiceImpl< VehicleType> implements VehicleTypeService{

}
