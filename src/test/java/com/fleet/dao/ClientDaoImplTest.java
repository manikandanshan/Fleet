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

public class ClientDaoImplTest extends EntityDaoImplTest {


	@Autowired
	 ClientDao  clientDao;

	@Override
	protected IDataSet getDataSet() throws Exception{
		  IDataSet[] datasets = new IDataSet[] {
				  new FlatXmlDataSet(this.getClass().getClassLoader().getResourceAsStream("Client.xml")),
				  new FlatXmlDataSet(this.getClass().getClassLoader().getResourceAsStream("Associate.xml")),
				  
				  

		  };
		  return new CompositeDataSet(datasets);
	}
	
	@Test
	public void find(){
		Assert.assertNotNull(clientDao.findOne(1));
		Assert.assertNull(clientDao.findOne(3));
	}
		
	@Test
	public void save(){
		clientDao.save(getSample());
		Assert.assertEquals(clientDao.findAll().size(), 3);
	}
	
	@Test
	public void delete(){
		Client client = clientDao.findOne(1);
		clientDao.remove(client);
		Assert.assertEquals(clientDao.findAll().size(), 1);
	}
	@Test
	public void deleteByInvalid(){
		//clientDao.delete(7);
		Client client = clientDao.findOne(1);
		clientDao.remove(client);
		Assert.assertEquals(clientDao.findAll().size(), 2);
	}
	@Test
	public void findAll(){
		Assert.assertEquals(clientDao.findAll().size(), 2);
	}
	
		/**
		 * @return
		 */
		public Client getSample(){
			Associate createdBy = new Associate();
			createdBy.setId(2);
			
			Client client = new Client();
			client.setCode("5");
			client.setName("Sat");
			client.setPhoneNo("256461");
			client.setMobileNo("01232165464");
			client.setAddress("chennai");
			client.setStatus("enable");
			client.setCreatedOn(new Date());
			client.setModifiedOn(new Date());
			//client.setCreatedBy(createdBy);
		    return client;
		
		
	}
}
