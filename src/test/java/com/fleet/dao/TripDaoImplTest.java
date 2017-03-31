package com.fleet.dao;

import java.util.Date;

import org.dbunit.dataset.CompositeDataSet;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSet;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.fleet.model.Associate;
import com.fleet.model.Trip;
import com.fleet.model.Vehicle;

public class TripDaoImplTest  extends EntityDaoImplTest {


	@Autowired
	TripDao tripDao;

	@Override
	protected IDataSet getDataSet() throws Exception{
		  IDataSet[] datasets = new IDataSet[] {
				  new FlatXmlDataSet(this.getClass().getClassLoader().getResourceAsStream("Client.xml")),
				  
	              new FlatXmlDataSet(this.getClass().getClassLoader().getResourceAsStream("Associate.xml")),
	              new FlatXmlDataSet(this.getClass().getClassLoader().getResourceAsStream("Vehicle.xml")),
	              new FlatXmlDataSet(this.getClass().getClassLoader().getResourceAsStream("Trip.xml")),
	              
	              new FlatXmlDataSet(this.getClass().getClassLoader().getResourceAsStream("TripDetail.xml")),
		  };
		  return new CompositeDataSet(datasets);
	}
	
	@Test
	public void find(){
		Assert.assertNotNull(tripDao.findOne(1));
		Assert.assertNull(tripDao.findOne(3));
	}
		
	@Test
	public void save(){
		tripDao.save(getSample());
		Assert.assertEquals(tripDao.findAll().size(), 3);
	}
	
	@Test
	public void delete(){
		Trip trip = tripDao.findOne(1);
		tripDao.remove(trip);
		//tripDao.delete(1);
		Assert.assertEquals(tripDao.findAll().size(), 1);
	}
	@Test
	public void deleteByInvalid(){
		Trip trip = tripDao.findOne(7);
		tripDao.remove(trip);
		//tripDao.delete(7);
		Assert.assertEquals(tripDao.findAll().size(), 2);
	}
	@Test
	public void findAll(){
		Assert.assertEquals(tripDao.findAll().size(), 2);
	}
	
		/**
		 * @return
		 */
		public Trip getSample(){
			Associate createdBy = new Associate();
			createdBy.setId(1);
			Associate associate = new Associate();
			associate.setId(1);
			Vehicle vehicle = new Vehicle();
			vehicle.setId(2);
			Trip trip = new Trip();
			trip.setStatus("enable");
			trip.setCreatedOn(new Date());
			trip.setModifiedOn(new Date());
			//trip.setCreatedBy(createdBy);
			trip.setVehicle(vehicle);
			trip.setAssociate(associate);
		    return trip;
		
		
	}
}

