-- MySQL dump 10.13  Distrib 5.7.12, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: fleet_management
-- ------------------------------------------------------
-- Server version	5.7.16-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `employee`
--

DROP TABLE IF EXISTS `employee`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `employee` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `joining_date` date NOT NULL,
  `salary` double NOT NULL,
  `ssn` varchar(30) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `ssn` (`ssn`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employee`
--

LOCK TABLES `employee` WRITE;
/*!40000 ALTER TABLE `employee` DISABLE KEYS */;
INSERT INTO `employee` VALUES (1,'hjk','2016-12-26',123,'123'),(2,'fdsg','2016-12-26',123,'456');
/*!40000 ALTER TABLE `employee` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `fm_associate`
--

DROP TABLE IF EXISTS `fm_associate`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `fm_associate` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `NUMBER` int(10) NOT NULL,
  `FIRST_NAME` varchar(25) NOT NULL,
  `LAST_NAME` varchar(25) NOT NULL,
  `PHONE_NO` varchar(15) NOT NULL,
  `MOBILE_NO` varchar(10) NOT NULL,
  `EMAIL` varchar(20) NOT NULL,
  `DOB` date NOT NULL,
  `LICENCE_NO` varchar(20) NOT NULL,
  `LICENCE_VALID_UPTO` date NOT NULL,
  `CLIENT_ID` int(11) DEFAULT NULL,
  `ADDRESS` varchar(1000) NOT NULL,
  `NOTES` varchar(5000) DEFAULT NULL,
  `ASSOCIATE_TYPE_ID` int(11) DEFAULT NULL,
  `STATUS` varchar(10) NOT NULL,
  `CREATED_ON` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `MODIFIED_ON` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `USER_ID` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `NUMBER_UNIQUE` (`NUMBER`),
  KEY `fm_associate_idx_3` (`CLIENT_ID`),
  KEY `fm_associate_idx_2` (`ASSOCIATE_TYPE_ID`),
  KEY `fm_associate_ibfk_4` (`USER_ID`),
  CONSTRAINT `fm_associate_ibfk_2` FOREIGN KEY (`ASSOCIATE_TYPE_ID`) REFERENCES `fm_associate_type` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fm_associate_ibfk_3` FOREIGN KEY (`CLIENT_ID`) REFERENCES `fm_client` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `fm_associate`
--

LOCK TABLES `fm_associate` WRITE;
/*!40000 ALTER TABLE `fm_associate` DISABLE KEYS */;
INSERT INTO `fm_associate` VALUES (1,173,'RAM','SAM','9842196458','9842198450','arameshce@gmail.com','2001-03-02','123456','2021-03-02',NULL,'nanmangalam','Associates',NULL,'Active',NULL,NULL,NULL),(2,278,'SAM','RAM','9842196458','9842198450','aramesh83@gmail.com','2001-03-02','123456','2021-03-02',NULL,'Namangalam','hidden',NULL,'OK',NULL,NULL,NULL),(3,1,'re','ddd','123123','123654','aramesh@gmail.com','2015-02-23','1457896','2015-11-20',NULL,'khgbhgjghbuy','jhbkjhbkjhk',NULL,'Active',NULL,NULL,NULL);
/*!40000 ALTER TABLE `fm_associate` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `fm_associate_type`
--

DROP TABLE IF EXISTS `fm_associate_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `fm_associate_type` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `CODE` varchar(20) NOT NULL,
  `NAME` varchar(20) NOT NULL,
  `STATUS` varchar(10) NOT NULL,
  `CREATED_ON` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `MODIFIED_ON` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `fm_associate_type`
--

LOCK TABLES `fm_associate_type` WRITE;
/*!40000 ALTER TABLE `fm_associate_type` DISABLE KEYS */;
INSERT INTO `fm_associate_type` VALUES (2,'777','RAM ASSOCIATE','OK','2017-01-03 13:11:44',NULL);
/*!40000 ALTER TABLE `fm_associate_type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `fm_branch`
--

DROP TABLE IF EXISTS `fm_branch`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `fm_branch` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `NAME` varchar(45) NOT NULL,
  `BRANCH_TYPE` varchar(45) NOT NULL,
  `ESTABLISHED_DATE` date NOT NULL,
  `ADDRESS_LINE1` varchar(1000) NOT NULL,
  `ADDRESS_LINE2` varchar(1000) DEFAULT NULL,
  `CITY` varchar(50) NOT NULL,
  `STATE` varchar(30) NOT NULL,
  `COUNTRY` varchar(45) NOT NULL,
  `ZIP_CODE` int(10) NOT NULL,
  `STD_CODE` int(10) NOT NULL,
  `CONTACT_NO1` varchar(15) NOT NULL,
  `CONTACT_NO2` varchar(15) NOT NULL,
  `FAX` varchar(30) DEFAULT NULL,
  `URL` varchar(45) NOT NULL,
  `EMAIL_ID` varchar(45) NOT NULL,
  `CREATED_ON` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `MODIFIED_ON` datetime DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `fm_branch`
--

LOCK TABLES `fm_branch` WRITE;
/*!40000 ALTER TABLE `fm_branch` DISABLE KEYS */;
INSERT INTO `fm_branch` VALUES (1,'RAMSAMBRANCH','MAIN','2017-01-03','Ambedkar st','Nanmangalam','Chennai','TN','India',625001,44,'9842198450','9842198654','12345678','www.RAMSAMBRANCH.COM','arameshce@gmail.com',NULL,NULL),(2,'SAMRAMBRANCH','SUBBRANCH','2017-01-03','KAMARAJAR ST','Nanmangalam','Chennai','TN','India',625001,44,'9842198450','9842198654','12345678','www.samrambranch.com','aramesh@gmail.com',NULL,NULL),(3,'rAM','RTY','2016-12-23','POIL','POIL','CHEN','TN','INDIA',625006,44,'321564','987654','123456','WWW.GOOGLE.COM','ARAMESH@GMAIL.COM',NULL,NULL);
/*!40000 ALTER TABLE `fm_branch` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `fm_client`
--

DROP TABLE IF EXISTS `fm_client`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `fm_client` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `CODE` varchar(45) NOT NULL,
  `NAME` varchar(45) NOT NULL,
  `PHONE_NO` varchar(10) NOT NULL,
  `MOBILE_NO` varchar(10) NOT NULL,
  `ADDRESS` varchar(1000) NOT NULL,
  `STATUS` varchar(10) NOT NULL,
  `CREATED_ON` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `MODIFIED_ON` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `CODE_UNIQUE` (`CODE`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `fm_client`
--

LOCK TABLES `fm_client` WRITE;
/*!40000 ALTER TABLE `fm_client` DISABLE KEYS */;
/*!40000 ALTER TABLE `fm_client` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `fm_company`
--

DROP TABLE IF EXISTS `fm_company`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `fm_company` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `NAME` varchar(45) NOT NULL,
  `COMPANY_TYPE` varchar(45) NOT NULL,
  `ESTABLISHED_DATE` date NOT NULL,
  `BRANCH_CODE` int(11) DEFAULT NULL,
  `ADDRESS_LINE1` varchar(1000) NOT NULL,
  `ADDRESS_LINE2` varchar(1000) DEFAULT NULL,
  `CITY` varchar(50) NOT NULL,
  `STATE` varchar(30) NOT NULL,
  `COUNTRY` varchar(45) NOT NULL,
  `ZIP_CODE` int(10) NOT NULL,
  `STD_CODE` int(10) NOT NULL,
  `CONTACT_NO1` varchar(15) NOT NULL,
  `CONTACT_NO2` varchar(15) NOT NULL,
  `FAX` varchar(30) DEFAULT NULL,
  `URL` varchar(45) NOT NULL,
  `EMAIL_ID` varchar(45) NOT NULL,
  `CREATED_ON` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `MODIFIED_ON` datetime DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `fm_company_idx_2` (`BRANCH_CODE`),
  CONSTRAINT `fm_company_ibfk_2` FOREIGN KEY (`BRANCH_CODE`) REFERENCES `fm_branch` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `fm_company`
--

LOCK TABLES `fm_company` WRITE;
/*!40000 ALTER TABLE `fm_company` DISABLE KEYS */;
INSERT INTO `fm_company` VALUES (1,'RAMSAM','SOLUTIONS','2017-01-03',NULL,'Ambedkar st','Nanmangalam','Chennai','TN','India',625001,44,'9842198450','9842198654','12345678','www.ramsam.com','arameshce@gmail.com',NULL,NULL),(2,'SAMRAM','DESIGNING','2017-01-03',NULL,'KAMARAJAR ST','Nanmangalam','Chennai','TN','India',625001,44,'9842198450','9842198654','12345678','www.samram.com','aramesh@gmail.com',NULL,NULL);
/*!40000 ALTER TABLE `fm_company` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `fm_company_branches`
--

DROP TABLE IF EXISTS `fm_company_branches`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `fm_company_branches` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `company_id` int(11) NOT NULL,
  `branch_code` int(11) NOT NULL,
  `created_on` timestamp(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6) ON UPDATE CURRENT_TIMESTAMP(6),
  `created_by` int(11) NOT NULL,
  `modified_on` datetime NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fm_company_branches_idx_1` (`created_by`),
  KEY `fm_company_branches_idx_2` (`company_id`),
  KEY `fm_company_branches_idx_3` (`branch_code`),
  CONSTRAINT `fm_company_branches_ibfk_1` FOREIGN KEY (`created_by`) REFERENCES `fm_associate` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fm_company_branches_ibfk_2` FOREIGN KEY (`company_id`) REFERENCES `fm_company` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fm_company_branches_ibfk_3` FOREIGN KEY (`branch_code`) REFERENCES `fm_branch` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `fm_company_branches`
--

LOCK TABLES `fm_company_branches` WRITE;
/*!40000 ALTER TABLE `fm_company_branches` DISABLE KEYS */;
/*!40000 ALTER TABLE `fm_company_branches` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `fm_features`
--

DROP TABLE IF EXISTS `fm_features`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `fm_features` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(25) NOT NULL,
  `created_on` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `modified_on` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `fm_features_unq_1` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `fm_features`
--

LOCK TABLES `fm_features` WRITE;
/*!40000 ALTER TABLE `fm_features` DISABLE KEYS */;
INSERT INTO `fm_features` VALUES (8,'RAM FEATURE',NULL,NULL),(9,'SAM FEATURE',NULL,NULL),(10,'ghhhhhh',NULL,NULL);
/*!40000 ALTER TABLE `fm_features` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `fm_fitness_certificate`
--

DROP TABLE IF EXISTS `fm_fitness_certificate`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `fm_fitness_certificate` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `VEHICLE_ID` int(11) DEFAULT NULL,
  `VALID_FROM` date NOT NULL,
  `AMOUNT` double(10,2) NOT NULL,
  `VALID_UPTO` date NOT NULL,
  `STATUS` varchar(10) NOT NULL,
  `CREATED_ON` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `MODIFIED_ON` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`ID`),
  KEY `fm_fitness_certificate_idx_2` (`VEHICLE_ID`),
  CONSTRAINT `fm_fitness_certificate_ibfk_2` FOREIGN KEY (`VEHICLE_ID`) REFERENCES `fm_vehicle` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `fm_fitness_certificate`
--

LOCK TABLES `fm_fitness_certificate` WRITE;
/*!40000 ALTER TABLE `fm_fitness_certificate` DISABLE KEYS */;
INSERT INTO `fm_fitness_certificate` VALUES (1,NULL,'2015-10-20',2000.00,'2021-10-19','APP',NULL,NULL),(2,NULL,'2001-12-20',4500.00,'2025-12-19','Active',NULL,NULL);
/*!40000 ALTER TABLE `fm_fitness_certificate` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `fm_fuel_station`
--

DROP TABLE IF EXISTS `fm_fuel_station`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `fm_fuel_station` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `CODE` varchar(20) NOT NULL,
  `NAME` varchar(25) NOT NULL,
  `PHONE_NO` varchar(15) NOT NULL,
  `MOBILE_NO` varchar(10) NOT NULL,
  `ADDRESS` varchar(1000) NOT NULL,
  `TYPES_OF_FUEL` varchar(2000) DEFAULT NULL,
  `STATUS` varchar(10) NOT NULL,
  `CREATED_ON` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `MODIFIED_ON` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `fm_fuel_station`
--

LOCK TABLES `fm_fuel_station` WRITE;
/*!40000 ALTER TABLE `fm_fuel_station` DISABLE KEYS */;
INSERT INTO `fm_fuel_station` VALUES (2,'111','FUELRAM','9842196458','9842198450','Namangalam','Diesel','Active',NULL,NULL),(3,'222','SAMRAT','9842196458','9842198450','AMBEDKAR ST','PETROL','Active',NULL,NULL);
/*!40000 ALTER TABLE `fm_fuel_station` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `fm_fuel_type`
--

DROP TABLE IF EXISTS `fm_fuel_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `fm_fuel_type` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `CODE` varchar(20) NOT NULL,
  `NAME` varchar(20) NOT NULL,
  `STATUS` varchar(10) NOT NULL,
  `CREATED_ON` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `MODIFIED_ON` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `fm_fuel_type`
--

LOCK TABLES `fm_fuel_type` WRITE;
/*!40000 ALTER TABLE `fm_fuel_type` DISABLE KEYS */;
INSERT INTO `fm_fuel_type` VALUES (2,'111','PETROL','AVAIL','2017-01-03 13:24:29',NULL);
/*!40000 ALTER TABLE `fm_fuel_type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `fm_insurance_provider`
--

DROP TABLE IF EXISTS `fm_insurance_provider`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `fm_insurance_provider` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `CODE` varchar(20) NOT NULL,
  `NAME` varchar(20) NOT NULL,
  `STATUS` varchar(10) NOT NULL,
  `CREATED_ON` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `MODIFIED_ON` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `fm_insurance_provider`
--

LOCK TABLES `fm_insurance_provider` WRITE;
/*!40000 ALTER TABLE `fm_insurance_provider` DISABLE KEYS */;
INSERT INTO `fm_insurance_provider` VALUES (2,'172','BAJAJ','ACTIV','2017-01-03 13:25:51',NULL),(3,'153','BIRLA','Active','2017-01-20 10:58:57',NULL);
/*!40000 ALTER TABLE `fm_insurance_provider` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `fm_privileges`
--

DROP TABLE IF EXISTS `fm_privileges`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `fm_privileges` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(10) NOT NULL,
  `created_on` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `modified_on` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `fm_privileges_unq_1` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `fm_privileges`
--

LOCK TABLES `fm_privileges` WRITE;
/*!40000 ALTER TABLE `fm_privileges` DISABLE KEYS */;
INSERT INTO `fm_privileges` VALUES (1,'ADMIN',NULL,NULL),(2,'MANAGE',NULL,NULL);
/*!40000 ALTER TABLE `fm_privileges` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `fm_product_vendor`
--

DROP TABLE IF EXISTS `fm_product_vendor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `fm_product_vendor` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `VENDOR_ID` int(10) DEFAULT NULL,
  `AVERAGE_LEAD_TIME` int(5) NOT NULL,
  `STANDARD_PRICE` double(10,2) NOT NULL,
  `LAST_RECEIPT_COST` double(10,2) NOT NULL,
  `LAST_RECEIPT_DATE` datetime NOT NULL,
  `MIN_ORDER_QTY` int(10) NOT NULL,
  `MAX_ORDER_QTY` int(10) NOT NULL,
  `ON_ORDER_QTY` int(10) NOT NULL,
  `UNIT_MEASURE_CODE` varchar(10) NOT NULL,
  `CREATED_ON` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `MODIFIED_ON` datetime DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `fm_product_vendor_idx_2` (`VENDOR_ID`),
  CONSTRAINT `fm_product_vendor_ibfk_2` FOREIGN KEY (`VENDOR_ID`) REFERENCES `fm_vendor_detail` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `fm_product_vendor`
--

LOCK TABLES `fm_product_vendor` WRITE;
/*!40000 ALTER TABLE `fm_product_vendor` DISABLE KEYS */;
INSERT INTO `fm_product_vendor` VALUES (1,NULL,2,5000.00,4950.00,'2016-12-25 00:00:00',10,100,50,'Package','2017-01-03 13:34:42',NULL),(2,NULL,5,5000.00,4950.00,'2016-12-25 00:00:00',10,100,50,'bundle','2017-01-20 11:17:14',NULL),(3,NULL,1,2.00,3.00,'2016-11-22 00:00:00',5,10,10,'lkimj','2017-01-24 09:40:44',NULL);
/*!40000 ALTER TABLE `fm_product_vendor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `fm_roles`
--

DROP TABLE IF EXISTS `fm_roles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `fm_roles` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `type` varchar(30) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `type` (`type`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `fm_roles`
--

LOCK TABLES `fm_roles` WRITE;
/*!40000 ALTER TABLE `fm_roles` DISABLE KEYS */;
INSERT INTO `fm_roles` VALUES (2,'ADMIN'),(3,'DBA'),(1,'USER');
/*!40000 ALTER TABLE `fm_roles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `fm_service`
--

DROP TABLE IF EXISTS `fm_service`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `fm_service` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `VEHICLE_ID` int(11) DEFAULT NULL,
  `SERVICE_STATION_ID` int(15) DEFAULT NULL,
  `ENTRY_DATE` datetime NOT NULL,
  `RELEASE_DATE` datetime NOT NULL,
  `AMOUNT` double(10,2) NOT NULL,
  `STATUS` varchar(10) NOT NULL,
  `CREATED_ON` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `MODIFIED_ON` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`ID`),
  KEY `fm_service_idx_2` (`VEHICLE_ID`),
  KEY `fm_service_idx_3` (`SERVICE_STATION_ID`),
  CONSTRAINT `fm_service_ibfk_2` FOREIGN KEY (`VEHICLE_ID`) REFERENCES `fm_vehicle` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fm_service_ibfk_3` FOREIGN KEY (`SERVICE_STATION_ID`) REFERENCES `fm_service_station` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `fm_service`
--

LOCK TABLES `fm_service` WRITE;
/*!40000 ALTER TABLE `fm_service` DISABLE KEYS */;
INSERT INTO `fm_service` VALUES (1,NULL,NULL,'2016-12-20 00:00:00','2017-12-20 00:00:00',300.00,'Active','2017-01-20 11:26:59',NULL);
/*!40000 ALTER TABLE `fm_service` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `fm_service_detail`
--

DROP TABLE IF EXISTS `fm_service_detail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `fm_service_detail` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `VEHICLE_SERVICE_ID` int(11) DEFAULT NULL,
  `ACTIVITY` varchar(2000) NOT NULL,
  `AMOUNT` double(10,2) NOT NULL,
  `VAT` double(10,2) NOT NULL,
  `TAX` double(10,2) NOT NULL,
  `STATUS` varchar(10) NOT NULL,
  `CREATED_ON` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `MODIFIED_ON` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`ID`),
  KEY `fm_service_detail_idx_2` (`VEHICLE_SERVICE_ID`),
  CONSTRAINT `fm_service_detail_ibfk_2` FOREIGN KEY (`VEHICLE_SERVICE_ID`) REFERENCES `fm_service` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `fm_service_detail`
--

LOCK TABLES `fm_service_detail` WRITE;
/*!40000 ALTER TABLE `fm_service_detail` DISABLE KEYS */;
INSERT INTO `fm_service_detail` VALUES (6,NULL,'ASP',124.00,12.00,11.00,'Active',NULL,NULL);
/*!40000 ALTER TABLE `fm_service_detail` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `fm_service_station`
--

DROP TABLE IF EXISTS `fm_service_station`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `fm_service_station` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `CODE` varchar(20) NOT NULL,
  `NAME` varchar(20) NOT NULL,
  `ADDRESS` varchar(1000) NOT NULL,
  `STATUS` varchar(10) NOT NULL,
  `CREATED_ON` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `MODIFIED_ON` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `fm_service_station`
--

LOCK TABLES `fm_service_station` WRITE;
/*!40000 ALTER TABLE `fm_service_station` DISABLE KEYS */;
INSERT INTO `fm_service_station` VALUES (1,'12','ram','uyigyuy','Active',NULL,NULL);
/*!40000 ALTER TABLE `fm_service_station` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `fm_trip`
--

DROP TABLE IF EXISTS `fm_trip`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `fm_trip` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `VEHICLE_ID` int(11) DEFAULT NULL,
  `ASSOCIATE_ID` int(11) DEFAULT NULL,
  `STATUS` varchar(10) NOT NULL,
  `CREATED_ON` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `MODIFIED_ON` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`ID`),
  KEY `fm_trip_idx_2` (`VEHICLE_ID`),
  KEY `fm_trip_idx_3` (`ASSOCIATE_ID`),
  CONSTRAINT `fm_trip_ibfk_2` FOREIGN KEY (`VEHICLE_ID`) REFERENCES `fm_vehicle` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fm_trip_ibfk_3` FOREIGN KEY (`ASSOCIATE_ID`) REFERENCES `fm_associate` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `fm_trip`
--

LOCK TABLES `fm_trip` WRITE;
/*!40000 ALTER TABLE `fm_trip` DISABLE KEYS */;
INSERT INTO `fm_trip` VALUES (3,NULL,NULL,'ABBB',NULL,NULL),(4,NULL,NULL,'Active',NULL,NULL);
/*!40000 ALTER TABLE `fm_trip` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `fm_trip_detail`
--

DROP TABLE IF EXISTS `fm_trip_detail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `fm_trip_detail` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `TRIP_ID` int(11) DEFAULT NULL,
  `FROM_ADDRESS` varchar(1000) NOT NULL,
  `TO_ADDRESS` varchar(1000) NOT NULL,
  `START_DATE` datetime NOT NULL,
  `END_DATE` datetime NOT NULL,
  `DISTANCE` int(10) NOT NULL,
  `TYPE_OF_GOOD` varchar(20) DEFAULT NULL,
  `ODOMETER_START_READING` int(10) NOT NULL,
  `ODOMETER_END_READING` int(10) NOT NULL,
  `FUEL_CONSUMPTION` int(6) NOT NULL,
  `AMOUNT` double(10,6) NOT NULL,
  `STATUS` varchar(10) NOT NULL,
  `CREATED_ON` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `MODIFIED_ON` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`ID`),
  KEY `fm_trip_detail_idx_2` (`TRIP_ID`),
  CONSTRAINT `fm_trip_detail_ibfk_2` FOREIGN KEY (`TRIP_ID`) REFERENCES `fm_trip` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `fm_trip_detail`
--

LOCK TABLES `fm_trip_detail` WRITE;
/*!40000 ALTER TABLE `fm_trip_detail` DISABLE KEYS */;
/*!40000 ALTER TABLE `fm_trip_detail` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `fm_user_role`
--

DROP TABLE IF EXISTS `fm_user_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `fm_user_role` (
  `user_id` int(11) NOT NULL,
  `role_id` int(11) NOT NULL,
  PRIMARY KEY (`user_id`,`role_id`),
  KEY `fm_user_role_idx_1` (`user_id`),
  KEY `fm_user_role_idx_2` (`role_id`),
  CONSTRAINT `fm_user_role_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `fm_users` (`id`),
  CONSTRAINT `fm_user_role_ibfk_2` FOREIGN KEY (`role_id`) REFERENCES `fm_roles` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `fm_user_role`
--

LOCK TABLES `fm_user_role` WRITE;
/*!40000 ALTER TABLE `fm_user_role` DISABLE KEYS */;
INSERT INTO `fm_user_role` VALUES (1,2),(2,2);
/*!40000 ALTER TABLE `fm_user_role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `fm_user_types`
--

DROP TABLE IF EXISTS `fm_user_types`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `fm_user_types` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(10) NOT NULL,
  `is_enabled` tinyint(1) NOT NULL,
  `created_on` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `modified_on` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `fm_user_types_unq_1` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `fm_user_types`
--

LOCK TABLES `fm_user_types` WRITE;
/*!40000 ALTER TABLE `fm_user_types` DISABLE KEYS */;
/*!40000 ALTER TABLE `fm_user_types` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `fm_users`
--

DROP TABLE IF EXISTS `fm_users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `fm_users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `sso_id` varchar(30) NOT NULL,
  `password` varchar(100) NOT NULL,
  `first_name` varchar(30) NOT NULL,
  `last_name` varchar(30) NOT NULL,
  `email` varchar(30) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `sso_id` (`sso_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `fm_users`
--

LOCK TABLES `fm_users` WRITE;
/*!40000 ALTER TABLE `fm_users` DISABLE KEYS */;
INSERT INTO `fm_users` VALUES (1,'mani','$2a$10$CGfgsHQ0YCpS12U3L8Kiq.woeG36fi1y57155BqF.zryz1WfU3kUK','mani','kandan','many@xyz.com'),(2,'7','password','ramesh','babu','aramesh83@gmail.com');
/*!40000 ALTER TABLE `fm_users` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `fm_vehicle`
--

DROP TABLE IF EXISTS `fm_vehicle`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `fm_vehicle` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `MAKE` varchar(50) NOT NULL,
  `MODEL` varchar(25) NOT NULL,
  `YEAR` int(4) NOT NULL,
  `COLOR` varchar(15) NOT NULL,
  `VIN` varchar(15) NOT NULL,
  `VEHICLE_TYPE_ID` int(11) NOT NULL,
  `FUEL_TYPE_ID` int(11) NOT NULL,
  `FUEL_CAPACITY` int(11) NOT NULL,
  `ENGINE_NO` varchar(25) NOT NULL,
  `ODOMETER_TYPE` varchar(5) NOT NULL,
  `DEPARTMENT_ID` int(11) NOT NULL,
  `NOTE` varchar(5000) DEFAULT NULL,
  `STATUS` varchar(10) NOT NULL,
  `CREATED_ON` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `MODIFIED_ON` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `fm_vehicle_unq_1` (`VIN`),
  KEY `fm_vehicle_idx_2` (`VEHICLE_TYPE_ID`),
  KEY `fm_vehicle_idx_3` (`FUEL_TYPE_ID`),
  CONSTRAINT `fm_vehicle_ibfk_2` FOREIGN KEY (`VEHICLE_TYPE_ID`) REFERENCES `fm_vehicle_type` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fm_vehicle_ibfk_3` FOREIGN KEY (`FUEL_TYPE_ID`) REFERENCES `fm_fuel_type` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `fm_vehicle`
--

LOCK TABLES `fm_vehicle` WRITE;
/*!40000 ALTER TABLE `fm_vehicle` DISABLE KEYS */;
/*!40000 ALTER TABLE `fm_vehicle` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `fm_vehicle_insurance`
--

DROP TABLE IF EXISTS `fm_vehicle_insurance`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `fm_vehicle_insurance` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `VEHICLE_ID` int(11) NOT NULL,
  `INSURANCE_POLICY_NUMBER` varchar(10) NOT NULL,
  `INSURANCE_PROVIDER_ID` int(11) NOT NULL,
  `VALID_FROM` date NOT NULL,
  `AMOUNT` double(10,2) NOT NULL,
  `VALID_UPTO` date NOT NULL,
  `STATUS` varchar(10) NOT NULL,
  `CREATED_ON` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `MODIFIED_ON` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`ID`),
  KEY `fm_vehicle_insurance_idx_2` (`VEHICLE_ID`),
  KEY `fm_vehicle_insurance_idx_3` (`INSURANCE_PROVIDER_ID`),
  CONSTRAINT `fm_vehicle_insurance_ibfk_2` FOREIGN KEY (`VEHICLE_ID`) REFERENCES `fm_vehicle` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fm_vehicle_insurance_ibfk_3` FOREIGN KEY (`INSURANCE_PROVIDER_ID`) REFERENCES `fm_insurance_provider` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `fm_vehicle_insurance`
--

LOCK TABLES `fm_vehicle_insurance` WRITE;
/*!40000 ALTER TABLE `fm_vehicle_insurance` DISABLE KEYS */;
/*!40000 ALTER TABLE `fm_vehicle_insurance` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `fm_vehicle_type`
--

DROP TABLE IF EXISTS `fm_vehicle_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `fm_vehicle_type` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `CODE` varchar(20) NOT NULL,
  `NAME` varchar(20) NOT NULL,
  `WEIGHT_RANGE` int(10) NOT NULL,
  `PURPOSE` varchar(500) DEFAULT NULL,
  `PERMIT_TYPE` varchar(300) NOT NULL,
  `STATUS` varchar(10) NOT NULL,
  `CREATED_ON` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `MODIFIED_ON` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `fm_vehicle_type`
--

LOCK TABLES `fm_vehicle_type` WRITE;
/*!40000 ALTER TABLE `fm_vehicle_type` DISABLE KEYS */;
INSERT INTO `fm_vehicle_type` VALUES (2,'1','ram',5,'for testing','sample','APP','2015-12-27 18:30:00','2016-12-29 00:00:00'),(3,'1','ram',5,'for testing','sample','APP','2016-12-27 18:30:00','2016-12-29 00:00:00'),(9,'123','mdh',5,'dhjd','ldjk','kjd','2015-12-25 18:30:00','2016-12-23 00:00:00'),(10,'222','MMMMM',5,'kljlhjl','kljjl','dgg','2016-12-25 18:30:00','2016-12-29 00:00:00');
/*!40000 ALTER TABLE `fm_vehicle_type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `fm_vendor_detail`
--

DROP TABLE IF EXISTS `fm_vendor_detail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `fm_vendor_detail` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `IDENTIFICATION_NO` varchar(15) NOT NULL,
  `NAME` varchar(30) NOT NULL,
  `PREFERED_VENDOR_STATUS` int(2) NOT NULL,
  `SERVICE_TYPE` varchar(20) NOT NULL,
  `ACTIVE_FLAG` int(2) NOT NULL,
  `CONTACT_PERSON_NAME` varchar(20) NOT NULL,
  `CONTACT_TYPE_ID` int(10) NOT NULL,
  `ADDRESS` varchar(30) NOT NULL,
  `URL` varchar(45) NOT NULL,
  `CREATED_ON` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `MODIFIED_ON` datetime DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `fm_vendor_detail`
--

LOCK TABLES `fm_vendor_detail` WRITE;
/*!40000 ALTER TABLE `fm_vendor_detail` DISABLE KEYS */;
/*!40000 ALTER TABLE `fm_vendor_detail` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `persistent_logins`
--

DROP TABLE IF EXISTS `persistent_logins`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `persistent_logins` (
  `username` varchar(64) NOT NULL,
  `series` varchar(64) NOT NULL,
  `token` varchar(64) NOT NULL,
  `last_used` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`series`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `persistent_logins`
--

LOCK TABLES `persistent_logins` WRITE;
/*!40000 ALTER TABLE `persistent_logins` DISABLE KEYS */;
/*!40000 ALTER TABLE `persistent_logins` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `role_privilege`
--

DROP TABLE IF EXISTS `role_privilege`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `role_privilege` (
  `role_id` int(11) NOT NULL,
  `privilege_id` int(11) NOT NULL,
  `feature_id` int(11) NOT NULL,
  `created_by` int(11) DEFAULT NULL,
  `is_enabled` tinyint(1) NOT NULL,
  `created_on` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `modified_on` datetime DEFAULT NULL,
  PRIMARY KEY (`role_id`,`privilege_id`,`feature_id`),
  KEY `fm_role_privilege_idx_1` (`feature_id`),
  KEY `fm_role_privilege_idx_2` (`privilege_id`),
  KEY `fm_role_privilege_idx_3` (`created_by`),
  KEY `fm_role_privilege_idx_4` (`role_id`),
  CONSTRAINT `role_privilege_ibfk_1` FOREIGN KEY (`feature_id`) REFERENCES `fm_features` (`id`),
  CONSTRAINT `role_privilege_ibfk_2` FOREIGN KEY (`privilege_id`) REFERENCES `fm_privileges` (`id`),
  CONSTRAINT `role_privilege_ibfk_3` FOREIGN KEY (`role_id`) REFERENCES `fm_roles` (`id`),
  CONSTRAINT `role_privilege_ibfk_4` FOREIGN KEY (`created_by`) REFERENCES `fm_users` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role_privilege`
--

LOCK TABLES `role_privilege` WRITE;
/*!40000 ALTER TABLE `role_privilege` DISABLE KEYS */;
/*!40000 ALTER TABLE `role_privilege` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'fleet_management'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-01-24 18:38:51



FOR CREATING ASSOCIATE_ID AS FOREIGNKEY IN USERS DATABASE

/*1. Create associate_id` column*/

ALTER TABLE `fleet_management`.`fm_users` 
ADD COLUMN `associate_id` INT(11) NULL AFTER `email`;


/*2.assign assciate id values for changing to not null (pls check atleast database has 2 users)*/

UPDATE `fleet_management`.`fm_users` SET `associate_id`='1' WHERE `id`='1';
UPDATE `fleet_management`.`fm_users` SET `associate_id`='2' WHERE `id`='2';

/*3.apply not null to associate_id`*/

ALTER TABLE `fleet_management`.`fm_users` 
CHANGE COLUMN `associate_id` `associate_id` INT(11) NOT NULL ;


/*4.create foreign key for associate_id` referencing Associate(id)*/

ALTER TABLE `fleet_management`.`fm_users` 
ADD INDEX `fm_users_ibfk_1_idx` (`associate_id` ASC);
ALTER TABLE `fleet_management`.`fm_users` 
ADD CONSTRAINT `fm_users_ibfk_1`
  FOREIGN KEY (`associate_id`)
  REFERENCES `fleet_management`.`fm_associate` (`ID`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;
  
  ADDED THE DETAILS FROM ASSOCIATE TABLE IN TO USERS
  
  /* RUN THE BELOW SCRIPT AFTER UPDATING VERSION 177*/

-- MySQL dump 10.13  Distrib 5.7.12, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: fleet_management
-- ------------------------------------------------------
-- Server version	5.7.16-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `fm_users`
--

DROP TABLE IF EXISTS `fm_users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `fm_users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `sso_id` varchar(30) NOT NULL,
  `password` varchar(100) NOT NULL,
  `first_name` varchar(30) NOT NULL,
  `last_name` varchar(30) NOT NULL,
  `email` varchar(30) NOT NULL,
  `ASSOCIATE_ID` int(11) NOT NULL,
  `ADDRESS` varchar(1000) NOT NULL,
  `CREATED_ON` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `NUMBER` int(11) NOT NULL,
  `MODIFIED_ON` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `DOB` date DEFAULT NULL,
  `LICENCE_NO` varchar(20) NOT NULL,
  `PHONE_NO` varchar(15) NOT NULL,
  `MOBILE_NO` varchar(10) NOT NULL,
  `LICENCE_VALID_UPTO` date NOT NULL,
  `NOTES` varchar(1000) NOT NULL,
  `STATUS` varchar(10) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `sso_id` (`sso_id`),
  KEY `fm_users_ibfk_1_idx` (`ASSOCIATE_ID`),
  CONSTRAINT `fm_users_ibfk_1` FOREIGN KEY (`ASSOCIATE_ID`) REFERENCES `fm_associate` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `fm_users`
--

LOCK TABLES `fm_users` WRITE;
/*!40000 ALTER TABLE `fm_users` DISABLE KEYS */;
INSERT INTO `fm_users` VALUES (1,'mani','abc125','mani','ram','arc@gmail.com',1,'sdfghjk','2017-01-27 07:43:44',123,'2017-01-27 13:13:44','2017-01-27','7894561','987654321654987','987654','2017-01-27','rtyuiovbnm,','active'),(2,'ram','abc125','ram','babu','arf@gmail.com',1,'fghjkl','2017-02-02 05:36:59',85,'2017-02-02 11:07:17','2017-01-27','8527413','98754','65558852','2017-01-27','wertyujk','active');
/*!40000 ALTER TABLE `fm_users` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'fleet_management'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-02-02 15:58:12
/* SQL to update user's table with ClientID */
ALTER TABLE `fleet-management`.`fm_users` 
ADD COLUMN `CLIENT_ID` INT(11) NULL AFTER `STATUS`;

ALTER TABLE `fleet-management`.`fm_users` 
ADD INDEX `fm_users_ibfk_2_idx` (`CLIENT_ID` ASC);
ALTER TABLE `fleet-management`.`fm_users` 
ADD CONSTRAINT `fm_users_ibfk_2`
  FOREIGN KEY (`CLIENT_ID`)
  REFERENCES `fleet-management`.`fm_client` (`ID`)
  ON DELETE CASCADE
  ON UPDATE CASCADE;
