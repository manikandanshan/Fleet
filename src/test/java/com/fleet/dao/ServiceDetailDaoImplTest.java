package com.fleet.dao;

import java.util.Date;

import org.dbunit.dataset.CompositeDataSet;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSet;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.fleet.model.Associate;
import com.fleet.model.Service;
import com.fleet.model.ServiceDetail;

public class ServiceDetailDaoImplTest extends EntityDaoImplTest {


	@Autowired
	ServiceDetailDao serviceDetailDao;

	@Override
	protected IDataSet getDataSet() throws Exception{
		  IDataSet[] datasets = new IDataSet[] {
				  new FlatXmlDataSet(this.getClass().getClassLoader().getResourceAsStream("Client.xml")),
				  
				  new FlatXmlDataSet(this.getClass().getClassLoader().getResourceAsStream("Associate.xml")),
				  new FlatXmlDataSet(this.getClass().getClassLoader().getResourceAsStream("Service.xml")),
				  new FlatXmlDataSet(this.getClass().getClassLoader().getResourceAsStream("ServiceStation.xml")),
	              new FlatXmlDataSet(this.getClass().getClassLoader().getResourceAsStream("ServiceDetail.xml")),
	              
		  };
		  return new CompositeDataSet(datasets);
	}
	
	@Test
	public void find(){
		Assert.assertNotNull(serviceDetailDao.findOne(1));
		Assert.assertNull(serviceDetailDao.findOne(3));
	}
		
	@Test
	public void save(){
		serviceDetailDao.save(getSample());
		Assert.assertEquals(serviceDetailDao.findAll().size(), 3);
	}
	
	@Test
	public void delete(){
		ServiceDetail serviceDetail = serviceDetailDao.findOne(1);
		serviceDetailDao.remove(serviceDetail);
		//serviceDetailDao.delete(1);
		Assert.assertEquals(serviceDetailDao.findAll().size(), 1);
	}
	@Test
	public void deleteByInvalid(){
		ServiceDetail serviceDetail = serviceDetailDao.findOne(7);
		serviceDetailDao.remove(serviceDetail);
		//serviceDetailDao.delete(7);
		Assert.assertEquals(serviceDetailDao.findAll().size(), 2);
	}
	@Test
	public void findAll(){
		Assert.assertEquals(serviceDetailDao.findAll().size(), 2);
	}
	
		/**
		 * @return
		 */
		public ServiceDetail getSample(){
			Associate createdBy =new Associate();
			createdBy.setId(1);
			Service service =new Service();
			service.setId(1);
			ServiceDetail serviceDetail = new ServiceDetail();
			serviceDetail.setActivity("5");
			serviceDetail.setAmount(1000.00);
			serviceDetail.setVat(10.00);
			serviceDetail.setTax(100.00);
			serviceDetail.setStatus("enable");
			serviceDetail.setCreatedOn(new Date());
			serviceDetail.setModifiedOn(new Date());
		  //  serviceDetail.setCreatedBy(createdBy);
		    serviceDetail.setService(service);
		    return serviceDetail;
		
		
	}
	


}
