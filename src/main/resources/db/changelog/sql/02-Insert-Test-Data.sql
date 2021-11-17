INSERT INTO `DEPARTMENT` values
(1,'HR'),(2,'Technology'),(3,'Administration');

truncate table employee;
INSERT INTO `EMPLOYEE` (`ID`, `FIRST_NAME`, `LAST_NAME`,`MANAGER`, `department_id`)
    VALUES (1, 'MUHAMMAD', 'AHMED',null,1),
           (2, 'TOM', 'TANG',1,2),
           (3, 'REHAN', 'FAROOQ',2,3),
           (4, 'ROB', 'TOPWOOD',3,1),
           (5, 'STEVE', 'INGRAHM',4,2),
           (6, 'JOSH', 'FIREMAN',5,3),
           (7, 'RAMA', 'GUPTA',6,1),
           (8, 'YASIR', 'MALIK',7,2),
           (9, 'SHIZA', 'RABBANI',8,3),
           (10, 'IJAZ', 'GABOOL',9,3);


