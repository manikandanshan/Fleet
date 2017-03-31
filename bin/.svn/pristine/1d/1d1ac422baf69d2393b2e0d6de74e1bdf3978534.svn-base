package com.fleet.dao;
import java.util.Date;

import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSet;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.fleet.model.Privilege;

public class PrivilegeDaoImplTest extends EntityDaoImplTest{

	@Autowired
	PrivilegeDao privilegeDao;

	@Override
	protected IDataSet getDataSet() throws Exception{
		IDataSet dataSet = new FlatXmlDataSet(this.getClass().getClassLoader().getResourceAsStream("Privilege.xml"));
		return dataSet;
	}
	
	@Test
	public void findById(){
		Assert.assertNotNull(privilegeDao.findOne(1));
		Assert.assertNull(privilegeDao.findOne(3));
	}

	
	@Test
	public void save(){
		privilegeDao.save(getSamplePrivilege());
		Assert.assertEquals(privilegeDao.findAll().size(), 3);
	}
	
	@Test
	public void delete(){
		Privilege privilege = privilegeDao.findOne(1);
		privilegeDao.remove(privilege);
		//privilegeDao.delete("Rajkumar");
		Assert.assertEquals(privilegeDao.findAll().size(), 1);
	}
	
	@Test
	public void deleteByInvalid(){
		Privilege privilege = privilegeDao.findOne(1);
		privilegeDao.remove(privilege);
		Assert.assertEquals(privilegeDao.findAll().size(), 2);
	}

	@Test
	public void findAllPrivilege(){
		Assert.assertEquals(privilegeDao.findAll().size(), 2);
	}
	
	/*@Test
	public void find(){
		Assert.assertNotNull(privilegeDao.find("Rajkumar"));
		Assert.assertNull(privilegeDao.find("Ramesh"));
	}
*/
	public Privilege getSamplePrivilege(){
		Privilege privilege = new Privilege();
		privilege.setName("Mani");
		//privilege.setCreatedBy(1234);
		privilege.setCreatedOn(new Date());
		privilege.setModifiedOn(new Date());
		return privilege;
	}

}