-- MySQL dump 10.13  Distrib 8.0.21, for Win64 (x86_64)
--
-- Host: localhost    Database: atms
-- ------------------------------------------------------
-- Server version	8.0.21

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `atm_addresses`
--

DROP TABLE IF EXISTS `atm_addresses`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `atm_addresses` (
  `address_id` int NOT NULL AUTO_INCREMENT,
  `street` varchar(45) DEFAULT NULL,
  `housenumber` varchar(45) DEFAULT NULL,
  `postalcode` varchar(45) DEFAULT NULL,
  `city` varchar(45) DEFAULT NULL,
  `latitude` varchar(45) DEFAULT NULL,
  `longitude` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`address_id`),
  UNIQUE KEY `atm_id_UNIQUE` (`address_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `atm_addresses`
--

LOCK TABLES `atm_addresses` WRITE;
/*!40000 ALTER TABLE `atm_addresses` DISABLE KEYS */;
INSERT INTO `atm_addresses` VALUES (1,'Ringweg','32','2046 KK','Spaarndam','52.413217','4.684062'),(2,'Vromade','3','2411 LG','Bodegraven','52.076969','4.751357'),(3,'Pelsestraat','17','5256 AT','Bodegraven','52.076934','4.751890');
/*!40000 ALTER TABLE `atm_addresses` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `atm_details`
--

DROP TABLE IF EXISTS `atm_details`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `atm_details` (
  `atm_id` int NOT NULL AUTO_INCREMENT,
  `distance` int DEFAULT '0',
  `address_id` int DEFAULT NULL,
  `functionality` varchar(45) DEFAULT NULL,
  `type` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`atm_id`),
  UNIQUE KEY `atm_id_UNIQUE` (`atm_id`),
  KEY `address_id_fk_idx` (`address_id`),
  CONSTRAINT `address_id_fk` FOREIGN KEY (`address_id`) REFERENCES `atm_addresses` (`address_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `atm_details`
--

LOCK TABLES `atm_details` WRITE;
/*!40000 ALTER TABLE `atm_details` DISABLE KEYS */;
INSERT INTO `atm_details` VALUES (1,0,1,'Geldautomaat','GELDMAAT'),(3,3,2,'Geld storten en opnemen','GELDMAAT'),(4,5,3,'Geld storten en opnemen','GELDMAAT');
/*!40000 ALTER TABLE `atm_details` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `atm_operating_details`
--

DROP TABLE IF EXISTS `atm_operating_details`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `atm_operating_details` (
  `operating_id` int NOT NULL AUTO_INCREMENT,
  `atm_id` int DEFAULT NULL,
  `day_of_week` int DEFAULT NULL,
  `hour_from` varchar(45) DEFAULT NULL,
  `hour_to` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`operating_id`),
  UNIQUE KEY `operating_id_UNIQUE` (`operating_id`),
  KEY `atm_id_fk_idx` (`atm_id`),
  CONSTRAINT `atm_id_fk` FOREIGN KEY (`atm_id`) REFERENCES `atm_details` (`atm_id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `atm_operating_details`
--

LOCK TABLES `atm_operating_details` WRITE;
/*!40000 ALTER TABLE `atm_operating_details` DISABLE KEYS */;
INSERT INTO `atm_operating_details` VALUES (1,1,1,'07:00','23:00'),(2,1,2,'07:00','13:00'),(3,1,3,'07:00','23:00'),(4,1,4,'07:00','23:00'),(5,1,5,'07:00','23:00'),(6,1,6,'07:00','23:00'),(7,1,7,'07:00','23:00'),(8,1,2,'15:00','23:00'),(9,3,1,'10:00','18:00'),(10,3,2,'10:00','18:00'),(11,3,3,'10:00','18:00'),(12,3,4,'10:00','18:00'),(13,4,1,'08:00','19:00'),(14,4,2,'08:00','19:00'),(15,4,3,'08:00','19:00'),(16,4,4,'08:00','19:00');
/*!40000 ALTER TABLE `atm_operating_details` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-08-22 14:16:47
