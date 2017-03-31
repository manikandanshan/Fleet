package com.fleet.dao;
import java.util.Date;

import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSet;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.fleet.model.Feature;

public class FeatureDaoImplTest extends EntityDaoImplTest{

	@Autowired
	FeatureDao featureDao;

	@Override
	protected IDataSet getDataSet() throws Exception{
		IDataSet dataSet = new FlatXmlDataSet(this.getClass().getClassLoader().getResourceAsStream("Feature.xml"));
		return dataSet;
	}
	
	@Test
	public void findById(){
		Assert.assertNotNull(featureDao.findOne(1));
		Assert.assertNull(featureDao.findOne(3));
	}

	
	@Test
	public void saveFeature(){
		featureDao.save(getSampleFeature());
		Assert.assertEquals(featureDao.findAll().size(), 3);
	}
	
	@Test
	public void deleteFeature(){
		//featureDao.deleteFeatureByName("Rajkumar");
		Feature feature = featureDao.findOne(1);
		featureDao.remove(feature);
		Assert.assertEquals(featureDao.findAll().size(), 1);
	}
	
	@Test
	public void deleteFeatureByInvalid(){
		Feature feature = featureDao.findOne(1);
		featureDao.remove(feature);
		Assert.assertEquals(featureDao.findAll().size(), 2);
	}

	@Test
	public void findAllFeatures(){
		Assert.assertEquals(featureDao.findAll().size(), 2);
	}
	
	@Test
	public void findFeatureByName(){
		Assert.assertNotNull(featureDao.findOne(1));
		Assert.assertNull(featureDao.findOne(2));
	}

	public Feature getSampleFeature(){
		Feature feature = new Feature();
		feature.setName("Mani");
		//feature.setCreatedBy(1234);
		feature.setCreatedOn(new Date());
		feature.setModifiedOn(new Date());
		return feature;
	}

}