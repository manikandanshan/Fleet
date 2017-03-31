package com.fleet.dao;
import java.util.Date;

import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSet;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.fleet.model.UserType;

public class UserTypeDaoImplTest extends EntityDaoImplTest{

	@Autowired
	UserTypeDao userTypeDao;

	@Override
	protected IDataSet getDataSet() throws Exception{
		IDataSet dataSet = new FlatXmlDataSet(this.getClass().getClassLoader().getResourceAsStream("UserType.xml"));
		return dataSet;
	}
	
	@Test
	public void find(){
		Assert.assertNotNull(userTypeDao.findOne(1));
		Assert.assertNull(userTypeDao.findOne(3));
	}
		
	@Test
	public void save(){
		userTypeDao.save(getSample());
		Assert.assertEquals(userTypeDao.findAll().size(), 3);
	}
	
	@Test
	public void delete(){
		UserType userType = userTypeDao.findOne(1);
		userTypeDao.remove(userType);
		//userTypeDao.delete(1);
		Assert.assertEquals(userTypeDao.findAll().size(), 1);
	}
	@Test
	public void deleteByInvalid(){
		UserType userType = userTypeDao.findOne(7);
		userTypeDao.remove(userType);
		//userTypeDao.delete(7);
		Assert.assertEquals(userTypeDao.findAll().size(), 2);
	}
	@Test
	public void findAll(){
		Assert.assertEquals(userTypeDao.findAll().size(), 2);
	}
	
		/**
		 * @return
		 */
		public UserType getSample(){
		UserType userType = new UserType();
		userType.setName("mani");
		userType.setIsEnabled(1);
		//userType.setCreatedBy(123);
		userType.setCreatedOn(new Date());
		userType.setModifiedOn(new Date());
		return userType;
		
		
	}

}
