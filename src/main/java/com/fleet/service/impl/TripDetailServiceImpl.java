package com.fleet.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fleet.model.TripDetail;
import com.fleet.service.TripDetailService;

@Service("TripDetailService")
@Transactional 
public class TripDetailServiceImpl extends CrudServiceImpl<TripDetail> implements TripDetailService{

}
