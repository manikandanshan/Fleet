package com.fleet.dao;

import java.util.Date;

import org.dbunit.dataset.CompositeDataSet;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSet;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.fleet.model.Associate;
import com.fleet.model.ServiceStation;

public class ServiceStationDaoImplTest extends EntityDaoImplTest {


	@Autowired
	ServiceStationDao serviceStationDao;

	@Override
	protected IDataSet getDataSet() throws Exception{
		  IDataSet[] datasets = new IDataSet[] {
				  new FlatXmlDataSet(this.getClass().getClassLoader().getResourceAsStream("Client.xml")),
				  
	              new FlatXmlDataSet(this.getClass().getClassLoader().getResourceAsStream("Associate.xml")),
	              new FlatXmlDataSet(this.getClass().getClassLoader().getResourceAsStream("ServiceStation.xml")),
		  };
		  return new CompositeDataSet(datasets);
	}
	
	@Test
	public void find(){
		Assert.assertNotNull(serviceStationDao.findOne(1));
		Assert.assertNull(serviceStationDao.findOne(3));
	}
		
	@Test
	public void save(){
		serviceStationDao.save(getSample());
		Assert.assertEquals(serviceStationDao.findAll().size(), 3);
	}
	
	@Test
	public void delete(){
		ServiceStation serviceStation = serviceStationDao.findOne(1);
		serviceStationDao.remove(serviceStation);
		//serviceStationDao.delete(1);
		Assert.assertEquals(serviceStationDao.findAll().size(), 1);
	}
	@Test
	public void deleteByInvalid(){
		
		ServiceStation serviceStation = serviceStationDao.findOne(7);
		serviceStationDao.remove(serviceStation);
		//serviceStationDao.delete(7);
		Assert.assertEquals(serviceStationDao.findAll().size(), 2);
	}
	@Test
	public void findAll(){
		Assert.assertEquals(serviceStationDao.findAll().size(), 2);
	}
	
		/**
		 * @return
		 */
		public ServiceStation getSample(){
			Associate createdBy=new Associate();
			createdBy.setId(1);
			
			ServiceStation serviceStation = new ServiceStation();
			
		    serviceStation.setCode("5dfg");
			serviceStation.setName("Sat");
			serviceStation.setAddress("chennai");
			serviceStation.setStatus("enable");
			serviceStation.setCreatedOn(new Date());
			serviceStation.setModifiedOn(new Date());
			//serviceStation.setCreatedBy(createdBy);
		    return serviceStation;
		
		
	}
}
