

USE `powerhousing`;

--
-- Table structure for table `user_credentials`
--

DROP TABLE IF EXISTS `user_credentials`;

CREATE TABLE `user_credentials` (
  `email` varchar(100) NOT NULL,
  `password` varchar(45) NOT NULL,
  PRIMARY KEY (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;