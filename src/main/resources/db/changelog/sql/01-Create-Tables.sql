drop table employee;

CREATE TABLE `employee` (
  `ID` int NOT NULL,
  `FIRST_NAME` varchar(200) NOT NULL,
  `LAST_NAME` varchar(20) NOT NULL,
  `MANAGER` int DEFAULT NULL,
  `deparment_id` int NULL,
  PRIMARY KEY (`ID`)
)

ALTER TABLE `employee`
ADD COLUMN `department_id` INT NULL AFTER `MANAGER`,
ADD INDEX `fk_deparment_id_idx` (`department_id` ASC) VISIBLE
;
drop  table department;
CREATE TABLE `department` (
  `department_id` INT NOT NULL,
  `department_name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`department_id`),
  UNIQUE INDEX `department_id_UNIQUE` (`department_id` ASC) VISIBLE);

ALTER TABLE `test`.`employee`
ADD CONSTRAINT `fk_deparment_id`
  FOREIGN KEY (`department_id`)
  REFERENCES `test`.`department` (`department_id`)



