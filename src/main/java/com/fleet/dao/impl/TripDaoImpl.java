/**
 * 
 */
package com.fleet.dao.impl;

import org.springframework.stereotype.Repository;

import com.fleet.dao.TripDao;
import com.fleet.model.Trip;

/**
 * @author shine
 *
 */
@Repository("TripDao")
public class TripDaoImpl extends CrudDaoImpl< Trip> implements TripDao {


}
