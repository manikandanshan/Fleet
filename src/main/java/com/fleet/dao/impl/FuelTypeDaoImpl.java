/**
 * 
 */
package com.fleet.dao.impl;

import org.springframework.stereotype.Repository;

import com.fleet.dao.FuelTypeDao;
import com.fleet.model.FuelType;

/**
 * @author shine
 *
 */

@Repository("FuelTypeDao")
public class FuelTypeDaoImpl extends CrudDaoImpl< FuelType> implements FuelTypeDao {

}
