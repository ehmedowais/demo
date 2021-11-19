CREATE TABLE `employee` (
  `ID` int NOT NULL,
  `FIRST_NAME` varchar(200) NOT NULL,
  `LAST_NAME` varchar(20) NOT NULL,
  `MANAGER` int DEFAULT NULL,
  `department_id` int DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `fk_deparment_id_idx` (`department_id`),
  CONSTRAINT `fk_deparment_id` FOREIGN KEY (`department_id`) REFERENCES `department` (`department_id`)
)
;