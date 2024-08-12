USE `powerhousing`;

DROP TABLE IF EXISTS `users`;

--
-- Table structure for table `members`
--

CREATE TABLE `users` (
  `username` varchar(50) NOT NULL,
  `password` char(69) NOT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Inserting data for table `members`
--
-- NOTE: The passwords are encrypted using BCrypt
--
-- A generation tool is avail at: https://www.luv2code.com/generate-bcrypt-password
--
-- Default passwords here are: fun123
--

INSERT INTO `users`
VALUES
('csmith3723','{bcrypt}$2a$12$vLK.EbdBq4dF3ykfdza5MeRoV6v3rz7/F2nnGU.ZH7rsQlohq0Lfa');

