package com.fleet.dao.impl;

import org.springframework.stereotype.Repository;
import com.fleet.dao.ProductVendorDao;
import com.fleet.model.ProductVendor;


@Repository("ProductVendorDao")
public class ProductVendorDaoImpl extends CrudDaoImpl<ProductVendor> implements ProductVendorDao{

}



