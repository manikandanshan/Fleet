package com.fleet.dao;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSet;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.fleet.model.User;

public class UserDaoImplTest extends EntityDaoImplTest{

	@Autowired
	UserDao userDao;

	@Override
	protected IDataSet getDataSet() throws Exception{
		IDataSet dataSet = new FlatXmlDataSet(this.getClass().getClassLoader().getResourceAsStream("User.xml"));
		return dataSet;
	}
	
	@Test
	public void find(){
		Assert.assertNotNull(userDao.findOne(1));
		Assert.assertNull(userDao.findOne(3));
	}

	
	/*@Test
	public void save(){
		userDao.save(getSample());
		Assert.assertEquals(userDao.findAll().size(), 3);
	}*/
	
	@Test
	public void delete(){
		User user = userDao.findOne(1);
		userDao.remove(user);
		//userDao.delete(1);
		Assert.assertEquals(userDao.findAll().size(), 1);
	}
	@Test
	public void deleteByInvalidCode(){
		User user = userDao.findOne(7);
		userDao.remove(user);
		//userDao.delete(5678);
		Assert.assertEquals(userDao.findAll().size(), 2);
	}
	@Test
	public void findAll(){
		Assert.assertEquals(userDao.findAll().size(), 2);
	}
	
		/**
		 * @return
		
		public User getSample(){
		User user = new User();
		user.setFirstName("mani");
		user.setMiddleName("kandan");
		user.setLastName("shan");
		user.setUserName("manishan");
		user.setPassword("12345");
		user.setCreatedOn(new Date());
		user.setModifiedOn(new Date());
		user.setCreatedBy(123);
		user.setIsAccountNonExpired(1);
		user.setIsAccountNonLocked(2);
		user.setIsCredentialsNonExpired(3);
		user.setUserTypeId(10);
		return user;
		 */
		
	}

