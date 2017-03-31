/**
 * 
 */
package com.fleet.dao.impl;

import org.springframework.stereotype.Repository;

import com.fleet.dao.VehicleDao;
import com.fleet.model.Vehicle;

/**
 * @author shine
 *
 */
@Repository("VehicleDao")
public class VehicleDaoImpl extends CrudDaoImpl< Vehicle> implements VehicleDao {

	
}
