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
import com.fleet.model.TripDetail;

public class TripDetailDaoImplTest extends EntityDaoImplTest {


	@Autowired
	TripDetailDao tripDetailDao;

	@Override
	protected IDataSet getDataSet() throws Exception{
		  IDataSet[] datasets = new IDataSet[] {
				  new FlatXmlDataSet(this.getClass().getClassLoader().getResourceAsStream("Client.xml")),
				  
	              new FlatXmlDataSet(this.getClass().getClassLoader().getResourceAsStream("Associate.xml")),
	              //new FlatXmlDataSet(this.getClass().getClassLoader().getResourceAsStream("ServiceStation.xml")),
	              new FlatXmlDataSet(this.getClass().getClassLoader().getResourceAsStream("Vehicle.xml")),
	              new FlatXmlDataSet(this.getClass().getClassLoader().getResourceAsStream("Trip.xml")),
	              new FlatXmlDataSet(this.getClass().getClassLoader().getResourceAsStream("TripDetail.xml")),
	              
		  };
		  return new CompositeDataSet(datasets);
	}
	
	
	
	@Test
	public void find(){
		Assert.assertNotNull(tripDetailDao.findOne(1));
		Assert.assertNull(tripDetailDao.findOne(3));
	}
		
	@Test
	public void save(){
		tripDetailDao.save(getSample());
		Assert.assertEquals(tripDetailDao.findAll().size(), 3);
	}
	
	@Test
	public void delete(){
		TripDetail tripDetail = tripDetailDao.findOne(1);
		tripDetailDao.remove(tripDetail);
		//tripDetailDao.delete(1);
		Assert.assertEquals(tripDetailDao.findAll().size(), 1);
	}
	@Test
	public void deleteByInvalid(){
		TripDetail tripDetail = tripDetailDao.findOne(7);
		tripDetailDao.remove(tripDetail);
		//tripDetailDao.delete(7);
		Assert.assertEquals(tripDetailDao.findAll().size(), 2);
	}
	@Test
	public void findAll(){
		Assert.assertEquals(tripDetailDao.findAll().size(), 2);
	}
	
		/**
		 * @return
		 */
		public TripDetail getSample(){
			Associate createdBy=new Associate();
			createdBy.setId(1);
			Trip trip=new Trip();
			trip.setId(1);
			TripDetail tripDetail = new TripDetail();
			tripDetail.setFromAddress("SASGD");
			tripDetail.setToAddress("FBGJFB");
			tripDetail.setStartDate(new Date());
			tripDetail.setEndDate(new Date());
			tripDetail.setDistance(436);
			tripDetail.setTypeOfGood("fhgdcxghc");
			tripDetail.setOdometerStartReading(5463);
			tripDetail.setOdometerEndReading(5677);
			tripDetail.setFuelConsumption(647);
			tripDetail.setAmount(654);
			tripDetail.setStatus("enable");
			tripDetail.setCreatedOn(new Date());
			tripDetail.setModifiedOn(new Date());
			//tripDetail.setCreatedBy(createdBy);
			tripDetail.setTrip(trip);
		    return tripDetail;
		
		
	}
}

