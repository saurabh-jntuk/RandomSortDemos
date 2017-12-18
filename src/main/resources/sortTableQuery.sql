
CREATE DATABASE IF NOT EXISTS test;

CREATE TABLE `sort` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `inputSequence` varchar(1000) NOT NULL DEFAULT '',
  `sortedSequence` varchar(1000) DEFAULT NULL,
  `swapCount` varchar(20) DEFAULT NULL,
  `timeTaken` varchar(250) DEFAULT NULL,  
  PRIMARY KEY (`id`)
);