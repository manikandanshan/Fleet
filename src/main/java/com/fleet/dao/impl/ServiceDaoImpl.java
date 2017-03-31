/**
 * 
 */
package com.fleet.dao.impl;

import org.springframework.stereotype.Repository;

import com.fleet.dao.ServiceDao;
import com.fleet.model.Service;

/**
 * @author shine
 *
 */

@Repository("ServiceDao")
public class ServiceDaoImpl extends CrudDaoImpl<Service> implements ServiceDao {


}
