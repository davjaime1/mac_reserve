-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: localhost    Database: mac_reserve
-- ------------------------------------------------------
-- Server version	8.0.17

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
-- Table structure for table `facilities`
--

DROP TABLE IF EXISTS `facilities`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `facilities` (
  `name` varchar(45) NOT NULL,
  `facilitytype` varchar(45) NOT NULL,
  `interval` varchar(45) NOT NULL,
  `duration` varchar(45) NOT NULL,
  `venue` varchar(45) NOT NULL,
  `deposit` varchar(3) NOT NULL,
  PRIMARY KEY (`name`),
  KEY `fk_facilitytype_idx` (`facilitytype`),
  KEY `fk_interval` (`interval`),
  KEY `fk_duration_idx` (`duration`),
  KEY `fk_venue_idx` (`venue`),
  CONSTRAINT `fk_duration` FOREIGN KEY (`duration`) REFERENCES `durations` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_facilitytype` FOREIGN KEY (`facilitytype`) REFERENCES `facilitytypes` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_interval` FOREIGN KEY (`interval`) REFERENCES `intervals` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_venue` FOREIGN KEY (`venue`) REFERENCES `venues` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `facilities`
--

LOCK TABLES `facilities` WRITE;
/*!40000 ALTER TABLE `facilities` DISABLE KEYS */;
INSERT INTO `facilities` VALUES ('BMC1','BMC','30M','SD','I','$25'),('BMC10','BMC','30M','SD','I','$25'),('BMC2','BMC','30M','SD','I','$25'),('BMC3','BMC','30M','SD','I','$25'),('BMC4','BMC','30M','SD','I','$25'),('BMC5','BMC','30M','SD','I','$25'),('BMC6','BMC','30M','SD','I','$25'),('BMC7','BMC','30M','SD','I','$25'),('BMC8','BMC','30M','SD','I','$25'),('BMC9','BMC','30M','SD','I','$25'),('CR1','CR','1H','SD','I','$50'),('CR2','CR','1H','SD','I','$50'),('CR3','CR','1H','SD','I','$50'),('CR4','CR','1H','SD','I','$50'),('CR5','CR','1H','SD','I','$50'),('IBBC1','IBBC','1H','SD','I','$25'),('IBBC2','IBBC','1H','SD','I','$25'),('IBBC3','IBBC','1H','SD','I','$25'),('IBBC4','IBBC','1H','SD','I','$25'),('IBBC5','IBBC','1H','SD','I','$25'),('IVBC1','IVBC','1H','SD','I','$25'),('IVBC2','IVBC','1H','SD','I','$25'),('IVBC3','IVBC','1H','SD','I','$25'),('IVBC4','IVBC','1H','SD','I','$25'),('IVBC5','IVBC','1H','SD','I','$25'),('IVBC6','IVBC','1H','SD','I','$25'),('IVBC7','IVBC','1H','SD','I','$25'),('IVBC8','IVBC','1H','SD','I','$25'),('IVBC9','IVBC','1H','SD','I','$25'),('MR1','MR','1H','SD','I','$50'),('MR2','MR','1H','SD','I','$50'),('MR3','MR','1H','SD','I','$50'),('MR4','MR','1H','SD','I','$50'),('OBBC1','OBBC','2H','7D','O','$100'),('OBBC2','OBBC','2H','7D','O','$100'),('OVBC1','OVBC','2H','7D','O','$100'),('OVBC2','OVBC','2H','7D','O','$100'),('RBC1','RBC','30M','SD','I','$25'),('RBC2','RBC','30M','SD','I','$25'),('RBC3','RBC','30M','SD','I','$25'),('RBC4','RBC','30M','SD','I','$25'),('RBC5','RBC','30M','SD','I','$25'),('SCG','SCG','2H','SD','I','$50'),('TT1','TT','30M','SD','I','$50');
/*!40000 ALTER TABLE `facilities` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `facilityreservation`
--

DROP TABLE IF EXISTS `facilityreservation`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `facilityreservation` (
  `reservationid` varchar(16) NOT NULL,
  `facilityname` varchar(45) NOT NULL,
  `facilitytype` varchar(45) NOT NULL,
  `venue` varchar(45) NOT NULL,
  `reservedUser` varchar(45) NOT NULL,
  `date` date NOT NULL,
  `to` datetime NOT NULL,
  `from` datetime NOT NULL,
  PRIMARY KEY (`reservationid`),
  KEY `fk_fr_facilityname_idx` (`facilityname`),
  KEY `fk_fr_facilitytype_idx` (`facilitytype`),
  KEY `fk_fr_venue_idx` (`venue`),
  KEY `fk_fr_reservedUser_idx` (`reservedUser`),
  CONSTRAINT `fk_fr_facilityname` FOREIGN KEY (`facilityname`) REFERENCES `facilities` (`name`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_fr_facilitytype` FOREIGN KEY (`facilitytype`) REFERENCES `facilitytypes` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_fr_reservedUser` FOREIGN KEY (`reservedUser`) REFERENCES `users` (`username`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_fr_venue` FOREIGN KEY (`venue`) REFERENCES `venues` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `facilityreservation`
--

LOCK TABLES `facilityreservation` WRITE;
/*!40000 ALTER TABLE `facilityreservation` DISABLE KEYS */;
/*!40000 ALTER TABLE `facilityreservation` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `facilitytypes`
--

DROP TABLE IF EXISTS `facilitytypes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `facilitytypes` (
  `id` varchar(45) NOT NULL,
  `name` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `facilitytypes`
--

LOCK TABLES `facilitytypes` WRITE;
/*!40000 ALTER TABLE `facilitytypes` DISABLE KEYS */;
INSERT INTO `facilitytypes` VALUES ('BMC','Badminton Court'),('CR','Conference Room'),('IBBC','Indoor Basketball Court'),('IVBC','Volleyball Court'),('MR','Multipurpose Room'),('OBBC','Outdoor Basketball Court'),('OVBC','Outdoor Volleyball Court'),('RBC','Racquetball Court'),('SCG','Indoor Soccer Gymnasium'),('TT','Table Tennis');
/*!40000 ALTER TABLE `facilitytypes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `intervals`
--

DROP TABLE IF EXISTS `intervals`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `intervals` (
  `id` varchar(45) NOT NULL,
  `name` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `intervals`
--

LOCK TABLES `intervals` WRITE;
/*!40000 ALTER TABLE `intervals` DISABLE KEYS */;
INSERT INTO `intervals` VALUES ('1H','1 hour'),('2H','2 hours'),('30M','30 min');
/*!40000 ALTER TABLE `intervals` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `roles`
--

DROP TABLE IF EXISTS `roles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `roles` (
  `id` varchar(45) NOT NULL,
  `name` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `roles`
--

LOCK TABLES `roles` WRITE;
/*!40000 ALTER TABLE `roles` DISABLE KEYS */;
INSERT INTO `roles` VALUES ('A','Admin'),('FM','Facility Manager'),('U','User');
/*!40000 ALTER TABLE `roles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `states`
--

DROP TABLE IF EXISTS `states`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `states` (
  `id` varchar(45) NOT NULL,
  `name` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `states`
--

LOCK TABLES `states` WRITE;
/*!40000 ALTER TABLE `states` DISABLE KEYS */;
INSERT INTO `states` VALUES ('AK','Alaska'),('AL','Alabama'),('AR','Arkansas'),('AZ','Arizona'),('CA','California'),('CO','Colorado'),('CT','Connecticut'),('DE','Delaware'),('FL','Florida'),('GA','Georgia'),('HI','Hawaii'),('IA','Iowa'),('ID','Idaho'),('IL','Illinois'),('IN','Indiana'),('KS','Kansas'),('KY','Kentucky'),('LA','Louisiana'),('MA','Massachusetts'),('MD','Maryland'),('ME','Maine'),('MI','Michigan'),('MN','Minnesota'),('MO','Missouri'),('MS','Mississippi'),('MT','Montana'),('NC','North Carolina'),('ND','North Dakota'),('NE','Nebraska'),('NH','New Hampshire'),('NJ','New Jersey'),('NM','New Mexico'),('NV','Nevada'),('NY','New York'),('OH','Ohio'),('OK','Oklahoma'),('OR','Oregon'),('PA','Pennsylvania'),('RI','Rhode Island'),('SC','South Carolina'),('SD','South Dakota'),('TN','Tennessee'),('TX','Texas'),('UT','Utah'),('VA','Virginia'),('VT','Vermont'),('WA','Washington'),('WI','Wisconsin'),('WV','West Virginia'),('WY','Wyoming');
/*!40000 ALTER TABLE `states` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `users` (
  `username` varchar(16) NOT NULL,
  `id` int(10) NOT NULL,
  `firstname` varchar(45) NOT NULL,
  `lastname` varchar(45) NOT NULL,
  `password` varchar(120) NOT NULL,
  `role` varchar(45) NOT NULL,
  `address` varchar(120) NOT NULL,
  `city` varchar(45) NOT NULL,
  `state` varchar(45) NOT NULL,
  `zip` varchar(5) NOT NULL,
  `phone` varchar(10) NOT NULL,
  `email` varchar(120) NOT NULL,
  PRIMARY KEY (`username`),
  KEY `fk_role_idx` (`role`),
  KEY `fk_state_idx` (`state`),
  CONSTRAINT `fk_role` FOREIGN KEY (`role`) REFERENCES `roles` (`id`),
  CONSTRAINT `fk_state` FOREIGN KEY (`state`) REFERENCES `states` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `venues`
--

DROP TABLE IF EXISTS `venues`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `venues` (
  `id` varchar(45) NOT NULL,
  `name` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `venues`
--

LOCK TABLES `venues` WRITE;
/*!40000 ALTER TABLE `venues` DISABLE KEYS */;
INSERT INTO `venues` VALUES ('I','Indoor'),('O','Outdoor');
/*!40000 ALTER TABLE `venues` ENABLE KEYS */;
UNLOCK TABLES;

/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-09-24  3:34:12
