CREATE DATABASE  IF NOT EXISTS `test` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `test`;
-- MySQL dump 10.13  Distrib 5.7.9, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: fleet_management
-- ------------------------------------------------------
-- Server version	5.6.25

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
DROP TABLE IF EXISTS `fm_users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;

CREATE TABLE `fm_users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  sso_id VARCHAR(30) NOT NULL,
   password VARCHAR(100) NOT NULL,
   first_name VARCHAR(30) NOT NULL,
   last_name  VARCHAR(30) NOT NULL,
   email VARCHAR(30) NOT NULL,
   PRIMARY KEY (id),
   UNIQUE (sso_id)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `fm_users`
--
INSERT INTO fm_users(sso_id, password, first_name, last_name, email)
VALUES ('mani','$2a$10$CGfgsHQ0YCpS12U3L8Kiq.woeG36fi1y57155BqF.zryz1WfU3kUK', 'mani','kandan','many@xyz.com');

 
LOCK TABLES `fm_users` WRITE;
/*!40000 ALTER TABLE `fm_users` DISABLE KEYS */;
/*!40000 ALTER TABLE `fm_users` ENABLE KEYS */;
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
   UNIQUE (type) 	
  )ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `fm_roles`
--
/* Populate fm_roles Table */
INSERT INTO fm_roles(type)
VALUES ('USER');
  
INSERT INTO fm_roles(type)
VALUES ('ADMIN');
  
INSERT INTO fm_roles(type)
VALUES ('DBA');
  
LOCK TABLES `fm_roles` WRITE;
/*!40000 ALTER TABLE `fm_roles` DISABLE KEYS */;
/*!40000 ALTER TABLE `fm_roles` ENABLE KEYS */;
UNLOCK TABLES;

DROP TABLE IF EXISTS `fm_user_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `fm_user_role` (
  `user_id` int(11) NOT NULL,
  `role_id` int(11) NOT NULL,
   PRIMARY KEY (`user_id`,`role_id`),
	KEY `fm_user_role_idx_1` (`user_id`),
	KEY `fm_user_role_idx_2` (`role_id`),
	CONSTRAINT `fm_user_role_ibfk_1` FOREIGN KEY (user_id) REFERENCES fm_users(id),
    CONSTRAINT `fm_user_role_ibfk_2` FOREIGN KEY(role_id) REFERENCES fm_roles(id)
     )ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `fm_user_role`
--

/* Populate JOIN Table */
INSERT INTO fm_user_role (user_id, role_id)
  SELECT user.id, roles.id FROM fm_users user, fm_roles roles
  where user.sso_id='mani' and roles.type='ADMIN';
  
  
LOCK TABLES `fm_user_role` WRITE;
/*!40000 ALTER TABLE `fm_user_role` DISABLE KEYS */;
/*!40000 ALTER TABLE `fm_user_role` ENABLE KEYS */;
UNLOCK TABLES;

DROP TABLE IF EXISTS `persistent_logins`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `persistent_logins` (
  `username` VARCHAR(64) NOT NULL,
  series VARCHAR(64) NOT NULL,
    token VARCHAR(64) NOT NULL,
    last_used TIMESTAMP NOT NULL,
    PRIMARY KEY (series)
  ) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `persistent_logins`
--

	LOCK TABLES `persistent_logins` WRITE;
/*!40000 ALTER TABLE `persistent_logins` DISABLE KEYS */;
/*!40000 ALTER TABLE `persistent_logins` ENABLE KEYS */;
UNLOCK TABLES;
