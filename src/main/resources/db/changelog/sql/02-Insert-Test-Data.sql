INSERT INTO `DEPARTMENT` values
(1,N'HR'),(2,N'Technology'),(3,N'Administration');

--truncate table employee;

insert into employee( ID, FIRST_NAME, LAST_NAME, MANAGER, department_id) values
(N'1',N'MUHAMMAD',N'AHMED', NULL,N'1'),
(N'2',N'TOM',N'TANG',N'1',N'2'),
(N'3',N'REHAN',N'FAROOQ',N'2',N'3'),
(N'4',N'ROB',N'TOPWOOD',N'3',N'1'),
(N'5',N'STEVE',N'INGRAHM',N'4',N'2'),
(N'6',N'JOSH',N'FIREMAN',N'5',N'3'),
(N'7',N'RAMA',N'GUPTA',N'6',N'1'),
(N'8',N'YASIR',N'MALIK',N'7',N'2'),
(N'9',N'SHIZA',N'RABBANI',N'8',N'3'),
(N'10',N'IJAZ',N'GABOOL',N'9',N'3');





