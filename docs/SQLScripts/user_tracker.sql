CREATE DATABASE  IF NOT EXISTS `climbing_website_db`;
ALTER DATABASE `climbing_website_db` DEFAULT CHARACTER SET utf8mb4 DEFAULT COLLATE utf8mb4_unicode_ci;

SET NAMES utf8;
USE `climbing_website_db`;


--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;

CREATE TABLE `users` (
  `id` int NOT NULL AUTO_INCREMENT,
  `lastname` varchar(45) NOT NULL,
  `firstname` varchar(45) NOT NULL,
  `email` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `role` varchar(5) NOT NULL,
  `created_at` datetime NOT NULL,
  `updated_at` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1;



--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;

INSERT INTO `users` VALUES 
	(1, 'Fallacy', 'Hal', 'admin', 'fb48e040318246f34f2dda51cc4357c80de92011cdf9441e049b1bc006f11d498e5cd30e8f1acff6ee56c8bd80836878d29b821d2ba5e9d1ded54db357925a93', '0', '2020-01-01 10:10:10', null),
  (2, 'Fallacy', 'Sony', 'sony@gmail.com', 'ecfcf8d91c593f310b62402b702f6264a11672571b57729a6ead59c19860426e7a0fc0f211e906bd126fe507b1563392d02b90a051f5df23191a84a70d59dd3f', '1', '2020-01-01 10:10:10', null),
  (3, 'Cazet', 'Alix', 'alix@gmail.com', 'efdfa25e219d32b630b4234b29ab796f102880a908785fd9415a892230f81c7cce14b382bdf4b111a4019cc6130c4cb5d17c541f91f4542dac65520f9cd3b18c', '2', '2020-01-01 10:10:10', null);

UNLOCK TABLES;