package com.fleet.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fleet.model.Feature;
import com.fleet.service.FeatureService;

@Service("FeatureService")
@Transactional 
public class FeatureServiceImpl  extends CrudServiceImpl<Feature> implements FeatureService{

}
