package com.fleet.dao;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSet;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.fleet.model.Role;

public class RoleDaoImplTest extends EntityDaoImplTest{

	@Autowired
	RoleDao roleDao;

	@Override
	protected IDataSet getDataSet() throws Exception{
		IDataSet dataSet = new FlatXmlDataSet(this.getClass().getClassLoader().getResourceAsStream("Role.xml"));
		return dataSet;
	}
	
	@Test
	public void find(){
		Assert.assertNotNull(roleDao.findOne(1));
		Assert.assertNull(roleDao.findOne(3));
	}

	
	@Test
	public void save(){
		roleDao.save(getSampleRole());
		Assert.assertEquals(roleDao.findAll().size(), 3);
	}
	
	@Test
	public void delete(){
		Role role = roleDao.findOne(1);
		roleDao.remove(role);
		//roleDao.delete(1234);
		Assert.assertEquals(roleDao.findAll().size(), 1);
	}
	@Test
	public void deleteByInvalidCode(){
		Role role = roleDao.findOne(124);
		roleDao.remove(role);
		Assert.assertEquals(roleDao.findAll().size(), 2);
	}
	@Test
	public void findAll(){
		Assert.assertEquals(roleDao.findAll().size(), 2);
	}
	
		/**
		 * @return
		*/
		public Role getSampleRole(){
		Role role = new Role();
		/*role.setCode("6789");
		role.setName("Raj");
		role.setIsEnabled(12);*/
		//role.setCreatedBy(123);
		//role.setCreatedOn(new Date());
		//role.setModifiedOn(new Date());
		return role;
		}
		
	}
