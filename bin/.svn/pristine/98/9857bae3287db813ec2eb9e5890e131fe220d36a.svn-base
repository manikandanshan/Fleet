package com.fleet.dao;
import java.util.Date;

import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSet;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.fleet.model.UserRole;

public class UserRoleDaoImplTest extends EntityDaoImplTest{

	@Autowired
	UserRoleDao userRoleDao;

	@Override
	protected IDataSet getDataSet() throws Exception{
		IDataSet dataSet = new FlatXmlDataSet(this.getClass().getClassLoader().getResourceAsStream("UserRole.xml"));
		return dataSet;
	}
	
	@Test
	public void find(){
		Assert.assertNotNull(userRoleDao.findOne(1));
		Assert.assertNull(userRoleDao.findOne(3));
	}
		
	@Test
	public void save(){
		userRoleDao.save(getSample());
		Assert.assertEquals(userRoleDao.findAll().size(), 3);
	}
	
	@Test
	public void delete(){
		UserRole userRole = userRoleDao.findOne(1);
		userRoleDao.remove(userRole);
		//userRoleDao.delete(1);
		Assert.assertEquals(userRoleDao.findAll().size(), 1);
	}
	@Test
	public void deleteByInvalid(){
		UserRole userRole = userRoleDao.findOne(7);
		userRoleDao.remove(userRole);
		//userRoleDao.delete(7);
		Assert.assertEquals(userRoleDao.findAll().size(), 2);
	}
	@Test
	public void findAll(){
		Assert.assertEquals(userRoleDao.findAll().size(), 2);
	}
	
		/**
		 * @return
		 */
		public UserRole getSample(){
		UserRole userRole = new UserRole();
		//userRole.setRoleId(5);
		//userRole.setCreatedBy(123);
		userRole.setCreatedOn(new Date());
		userRole.setModifiedOn(new Date());
		return userRole;
		
		
	}

}