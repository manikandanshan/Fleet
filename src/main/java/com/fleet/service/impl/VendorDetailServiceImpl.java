/**
 * 
 */
package com.fleet.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fleet.model.VendorDetail;
import com.fleet.service.VendorDetailService;

/**
 * @author shine
 *
 */
@Service("VendorDetailService")
@Transactional
public class VendorDetailServiceImpl extends CrudServiceImpl< VendorDetail> implements VendorDetailService{

}
