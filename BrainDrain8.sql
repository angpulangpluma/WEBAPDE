CREATE DATABASE  IF NOT EXISTS `brainstorm` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `brainstorm`;
-- MySQL dump 10.13  Distrib 5.6.17, for Win32 (x86)
--
-- Host: 127.0.0.1    Database: brainstorm
-- ------------------------------------------------------
-- Server version	5.6.21

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
-- Table structure for table `comment`
--

DROP TABLE IF EXISTS `comment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `comment` (
  `commentID` int(11) NOT NULL AUTO_INCREMENT,
  `userID` int(11) DEFAULT NULL,
  `postID` int(11) DEFAULT NULL,
  `comment` mediumtext,
  `timestamp` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`commentID`)
) ENGINE=InnoDB AUTO_INCREMENT=37 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `comment`
--

LOCK TABLES `comment` WRITE;
/*!40000 ALTER TABLE `comment` DISABLE KEYS */;
INSERT INTO `comment` VALUES (1,1,1,'i am commenting','2015-04-03 14:08:07'),(2,2,1,'WHAT THE!?','2015-04-03 16:03:42'),(3,1,1,'THE HECK!?','2015-04-03 16:53:31'),(4,1,1,'NOOO','2015-04-03 16:58:10'),(5,1,1,'DUUDE','2015-04-03 17:12:23'),(6,1,1,'YESS !!!','2015-04-03 17:12:30'),(7,1,1,'HEHEHEHHE','2015-04-03 17:13:36'),(8,1,1,'LOL','2015-04-03 17:18:16'),(9,1,6,'JEJEJE','2015-04-03 17:29:34'),(10,1,20,'Nigger!!!','2015-04-06 03:35:07'),(11,1,28,'What theeee','2015-04-10 09:42:53'),(12,1,28,'why no work','2015-04-10 09:44:27'),(13,1,28,'vuiufwhefuiwhe','2015-04-10 09:54:46'),(14,1,28,'vuiufwhefuiwhe','2015-04-10 09:54:48'),(15,1,28,'vuiufwhefuiwhe','2015-04-10 09:54:50'),(16,1,28,'vuiufwhefuiwhe','2015-04-10 09:54:51'),(17,1,28,'vuiufwhefuiwhe','2015-04-10 09:54:51'),(18,1,28,'vuiufwhefuiwhe','2015-04-10 09:55:06'),(19,1,28,'vuiufwhefuiwhe','2015-04-10 09:55:06'),(20,1,28,'vuiufwhefuiwhe','2015-04-10 09:55:06'),(21,1,28,'vuiufwhefuiwhe','2015-04-10 09:55:06'),(22,1,28,'vuiufwhefuiwhe','2015-04-10 09:55:07'),(23,1,28,'vuiufwhefuiwhe','2015-04-10 09:55:07'),(24,1,28,'vuiufwhefuiwhe','2015-04-10 09:55:07'),(25,1,28,'vuiufwhefuiwhe','2015-04-10 09:55:07'),(26,1,28,'Why','2015-04-10 09:55:13'),(27,1,28,'Why','2015-04-10 09:55:18'),(28,1,28,'Work','2015-04-10 09:55:55'),(29,1,30,'work','2015-04-10 09:58:26'),(30,1,21,'COMMENT BRO','2015-04-10 10:09:18'),(31,1,30,'MEMMEMMEMEBRS','2015-04-10 10:10:45'),(32,1,30,'fart','2015-04-10 10:12:12'),(33,1,36,'comment bro','2015-04-10 10:23:19'),(34,1,34,'Comment hehe','2015-04-10 10:24:34'),(35,1,25,'Hey bro','2015-04-10 11:19:24'),(36,2,25,'Hey there','2015-04-10 11:19:55');
/*!40000 ALTER TABLE `comment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `groupmembers`
--

DROP TABLE IF EXISTS `groupmembers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `groupmembers` (
  `groupID` int(11) DEFAULT NULL,
  `userID` varchar(45) DEFAULT NULL,
  `entryNum` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`entryNum`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `groupmembers`
--

LOCK TABLES `groupmembers` WRITE;
/*!40000 ALTER TABLE `groupmembers` DISABLE KEYS */;
INSERT INTO `groupmembers` VALUES (1,'1',1),(2,'1',2),(3,'1',3),(2,'2',4),(3,'3',5),(4,'1',6),(6,'1',7),(7,'1',8),(8,'1',9),(9,'1',10),(10,'1',11),(11,'1',12),(12,'1',13),(13,'1',14),(14,'1',15),(15,'1',16),(16,'1',17),(17,'1',18),(18,'2',19),(19,'1',20),(20,'1',21),(21,'1',22),(22,'1',23),(23,'1',24),(24,'1',25);
/*!40000 ALTER TABLE `groupmembers` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `groups`
--

DROP TABLE IF EXISTS `groups`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `groups` (
  `groupID` int(11) NOT NULL,
  `groupName` varchar(45) DEFAULT 'Brain Group',
  `leaderID` int(11) DEFAULT NULL,
  PRIMARY KEY (`groupID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `groups`
--

LOCK TABLES `groups` WRITE;
/*!40000 ALTER TABLE `groups` DISABLE KEYS */;
INSERT INTO `groups` VALUES (1,'Team Nerd',1),(2,'Team CoC',1),(3,'One D',1),(4,'Two D',1),(5,'name',1),(6,'Dude what',1),(7,'hehe',1),(8,'NOOOO',1),(9,'GRRRRR',1),(10,'Wiggle',1),(11,'Son of a',1),(12,'please',1),(13,'Pleaseeeeeeeeeee',1),(14,'WORK PEASE',1),(15,'WHYY',1),(16,'Please',1),(17,'die die die',1),(18,'I am a group',2),(19,'My Group',1),(20,'The Group of jet',1),(21,'work please',1),(22,'Oh noes2',1),(23,'Heheeeeeeee',1),(24,'Marines',1);
/*!40000 ALTER TABLE `groups` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `idea`
--

DROP TABLE IF EXISTS `idea`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `idea` (
  `ideaID` int(11) NOT NULL AUTO_INCREMENT,
  `topicID` int(11) DEFAULT NULL,
  `userID` int(11) DEFAULT NULL,
  `idea` mediumtext,
  `time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`ideaID`)
) ENGINE=InnoDB AUTO_INCREMENT=37 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `idea`
--

LOCK TABLES `idea` WRITE;
/*!40000 ALTER TABLE `idea` DISABLE KEYS */;
INSERT INTO `idea` VALUES (1,1,1,'HELLLOO','2015-04-02 19:32:38'),(2,2,1,'DOH NO!','2015-04-02 19:32:38'),(3,2,1,'GEGE','2015-04-02 21:07:26'),(4,2,1,'GEGE','2015-04-02 21:07:29'),(5,2,1,'GEGE','2015-04-02 21:07:33'),(6,1,1,'OH NO','2015-04-02 21:23:59'),(7,1,1,'HIP HIP HORRAYY','2015-04-02 21:24:16'),(8,1,1,'oh nooo','2015-04-03 07:09:05'),(9,1,1,'I am a topic','2015-04-03 12:11:14'),(10,7,1,'electrix','2015-04-03 12:23:43'),(11,7,1,'boom','2015-04-03 12:26:44'),(12,7,1,'oh noo','2015-04-03 12:28:50'),(13,7,1,'Hell nooo','2015-04-03 12:30:35'),(14,8,1,'tutututudun','2015-04-03 12:32:19'),(15,3,1,'LOL RITE','2015-04-03 20:34:24'),(16,3,1,'OHHH NOO!','2015-04-03 20:55:02'),(17,5,1,'Whatbthe hell!','2015-04-04 07:14:58'),(18,9,1,'So good','2015-04-05 10:18:53'),(19,10,1,'Gotta catch em all','2015-04-05 10:40:19'),(20,11,1,'Woah der','2015-04-06 03:34:59'),(21,11,1,'lawl','2015-04-07 19:09:44'),(22,12,1,'HEHE','2015-04-07 19:10:24'),(23,13,1,'','2015-04-09 19:08:40'),(24,14,1,'Sucks','2015-04-09 19:13:17'),(25,15,1,'Holy no!','2015-04-09 19:16:02'),(26,16,1,'Awesome','2015-04-09 19:29:46'),(27,17,1,'','2015-04-09 19:31:27'),(28,18,1,'Notif','2015-04-09 19:32:22'),(29,16,1,'A srs idea','2015-04-10 09:05:08'),(30,15,1,'lol','2015-04-10 09:58:17'),(31,15,1,'lolol','2015-04-10 10:01:25'),(32,16,1,'LOLOL','2015-04-10 10:03:31'),(33,15,2,'SHHH','2015-04-10 10:04:22'),(34,15,2,'WOAAAH','2015-04-10 10:05:31'),(35,15,2,'yuhrfiurefiuhuihIHUI','2015-04-10 10:07:26'),(36,15,1,'Ngiiigss','2015-04-10 10:23:11');
/*!40000 ALTER TABLE `idea` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `notification`
--

DROP TABLE IF EXISTS `notification`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `notification` (
  `notifID` int(11) NOT NULL AUTO_INCREMENT,
  `notif` mediumtext,
  `link` varchar(45) DEFAULT NULL,
  `goingTo` int(11) DEFAULT NULL,
  `time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `from` int(11) DEFAULT NULL,
  PRIMARY KEY (`notifID`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `notification`
--

LOCK TABLES `notification` WRITE;
/*!40000 ALTER TABLE `notification` DISABLE KEYS */;
INSERT INTO `notification` VALUES (1,'Jet is number 1',NULL,1,'2015-03-07 16:00:00',2),(2,'Hi there',NULL,1,'2015-04-07 18:05:11',2),(3,'posted a new idea',NULL,2,'2015-04-09 19:16:03',1),(4,'posted a new idea',NULL,2,'2015-04-09 19:32:22',1),(5,'posted a new idea under project Black Project',NULL,2,'2015-04-10 09:05:08',1),(6,'posted a new idea under project Black Project',NULL,2,'2015-04-10 10:03:31',1),(7,'posted a new idea under project Project Manhattan',NULL,1,'2015-04-10 10:07:26',2),(8,'posted a new idea under project Project Manhattan',NULL,2,'2015-04-10 10:23:11',1),(9,'posted a new comment under project  and topic ',NULL,2,'2015-04-10 10:23:19',1),(10,'posted a new comment under project Project Manhattan and topic Add me please',NULL,2,'2015-04-10 10:24:34',1),(11,'posted a new comment under project Project Manhattan and topic Add me please',NULL,2,'2015-04-10 11:19:24',1),(12,'posted a new comment under project Project Manhattan and topic Add me please',NULL,1,'2015-04-10 11:19:55',2);
/*!40000 ALTER TABLE `notification` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `project`
--

DROP TABLE IF EXISTS `project`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `project` (
  `projectID` int(11) NOT NULL AUTO_INCREMENT,
  `groupID` int(11) DEFAULT NULL,
  `projectname` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`projectID`)
) ENGINE=InnoDB AUTO_INCREMENT=3341 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `project`
--

LOCK TABLES `project` WRITE;
/*!40000 ALTER TABLE `project` DISABLE KEYS */;
INSERT INTO `project` VALUES (0,1,'Jet Project'),(1,3,'White Project'),(2,1,'Project Jet'),(3,1,'Project Hannah'),(4,1,'Project Marine'),(5,2,'Project Manhattan'),(6,2,'Black Project'),(3334,1,'I AM A SUPER PROJECT'),(3335,1,'HEHEHHEHEHE'),(3336,1,'WHAT INNN'),(3337,1,'BEST PROJECT EVER'),(3338,1,'nice one'),(3339,1,'hoho'),(3340,6,'I am projectdss');
/*!40000 ALTER TABLE `project` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rating`
--

DROP TABLE IF EXISTS `rating`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `rating` (
  `ratingid` int(11) NOT NULL AUTO_INCREMENT,
  `userid` int(11) DEFAULT NULL,
  `topicid` int(11) DEFAULT NULL,
  `rating` smallint(6) DEFAULT NULL,
  PRIMARY KEY (`ratingid`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rating`
--

LOCK TABLES `rating` WRITE;
/*!40000 ALTER TABLE `rating` DISABLE KEYS */;
INSERT INTO `rating` VALUES (1,1,1,0),(6,2,1,1),(7,1,6,1),(8,1,7,0),(9,1,15,0),(10,1,9,0),(11,1,2,1),(12,1,17,1),(13,1,20,0),(14,1,21,-1),(15,1,25,0);
/*!40000 ALTER TABLE `rating` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `topic`
--

DROP TABLE IF EXISTS `topic`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `topic` (
  `topicID` int(11) NOT NULL AUTO_INCREMENT,
  `projectID` int(11) DEFAULT NULL,
  `topicname` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`topicID`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `topic`
--

LOCK TABLES `topic` WRITE;
/*!40000 ALTER TABLE `topic` DISABLE KEYS */;
INSERT INTO `topic` VALUES (1,1,'Topic 1'),(2,1,'Topic 2'),(3,2,'Topic 1'),(4,2,'Topic 2'),(5,3,'Topic 1'),(6,3,'Topic 2'),(7,1,'Topic Jet'),(8,1,'i am harrypotter'),(9,3334,'I am a cool topic'),(10,3339,'Pokemon'),(11,0,'I am a topic'),(12,0,'NEWWW'),(13,0,'What in heavens'),(14,4,'Oh no sucksss'),(15,5,'Add me please'),(16,6,'No man'),(17,2,'pshhh'),(18,5,'Look Sibayan');
/*!40000 ALTER TABLE `topic` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `userID` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `firstname` varchar(45) DEFAULT NULL,
  `lastname` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`userID`),
  UNIQUE KEY `username_UNIQUE` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'jet','321','heheh','virt'),(2,'hannah','321','hannah','sibayan'),(3,'marine','321','marine','lopez');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2015-04-10 19:22:59
