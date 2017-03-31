package com.fleet.dao;

import java.util.Date;

import org.dbunit.dataset.CompositeDataSet;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSet;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.fleet.model.Associate;
import com.fleet.model.Client;

public class AssociateDaoImplTest extends EntityDaoImplTest {


	@Autowired
	AssociateDao associateDao;

	@Override
	protected IDataSet getDataSet() throws Exception{
		  IDataSet[] datasets = new IDataSet[] {
				  new FlatXmlDataSet(this.getClass().getClassLoader().getResourceAsStream("Client.xml")),
	              new FlatXmlDataSet(this.getClass().getClassLoader().getResourceAsStream("Associate.xml")),
				 // new FlatXmlDataSet(this.getClass().getClassLoader().getResourceAsStream("ServiceStation.xml")),
	              //new FlatXmlDataSet(this.getClass().getClassLoader().getResourceAsStream("ServiceDetail.xml")),
	              new FlatXmlDataSet(this.getClass().getClassLoader().getResourceAsStream("Vehicle.xml")),
	              new FlatXmlDataSet(this.getClass().getClassLoader().getResourceAsStream("Trip.xml")),
	              new FlatXmlDataSet(this.getClass().getClassLoader().getResourceAsStream("TripDetail.xml")),
		  };
		  return new CompositeDataSet(datasets);
	}
	
	@Test
	public void find(){
		Assert.assertNotNull(associateDao.findOne(1));
		Assert.assertNull(associateDao.findOne(3));
	}
		
	@Test
	public void save(){
		associateDao.save(getSample());
		Assert.assertEquals(associateDao.findAll().size(), 3);
	}
	
	@Test
	public void delete(){
		Associate associate = associateDao.findOne(1);
		associateDao.remove(associate);
		Assert.assertEquals(associateDao.findAll().size(), 1);
	}
	@Test
	public void deleteByInvalid(){
		//associateDao.delete(7);
		Associate associate = associateDao.findOne(7);
		associateDao.remove(associate);
		Assert.assertEquals(associateDao.findAll().size(), 2);
	}
	@Test
	public void findAll(){
		Assert.assertEquals(associateDao.findAll().size(), 2);
	}
	
		/**
		 * @return
		 */
		public Associate getSample(){
			Associate associate=new Associate();
			Client client=new Client();
			//client.setId(2);
	
			associate.setNumber(5);
			associate.setFirstName("Sat");
			associate.setLastName("Sat");
			associate.setPhoneNo("256461");
			associate.setMobileNo("01232165464");
			associate.setEmail("2fgfgj@gmgail.com");
			associate.setDob(new Date());
			associate.setLicenceNo("256461ads");
			associate.setLicenceValidUpto(new Date());
			associate.setAddress("chennai");
			associate.setNotes("i hate this");
			associate.setStatus("enable");
			associate.setCreatedOn(new Date());
			associate.setModifiedOn(new Date());
			//associate.setCreatedBy(createdBy);
		    return associate;
		
		
	}
	

}
