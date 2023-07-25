-- Projections
USE demodb;

SELECT * FROM  employee;

SELECT FirstN, LastN, Salary from employee;

-- First and last name combinated along salary with 2 col
SELECT CONCAT(FirstN, CONCAT(' ',LastN)) AS `NAME`, Salary FROM employee;
-- OR, by avoiding duplicates
SELECT distinct Salary from employee;

-- INSERT
USE DemoDB;
DROP TABLE employee;
Create Table employee(
	EmpId INT,
    FirstN Varchar(50),
    LastN Varchar(50),
    Salary Numeric(10,2),
    CreatedDTTM Datetime Default NOW()
);
INSERT INTO employee Values (1,'B','C',120,Now());

-- Inserting Multiple records
Create table UserProfile(
	ProfId INT,
    FirsN varchar(50),
    LastN varchar(50),
    email varchar(50)
);
Create table UserProfile(
	ProfId INT,
    FirsN varchar(50),
    LastN varchar(50),
    email varchar(50)
);
Create table contact (
	ContactId INT,
	FirsN varchar(50),
    LastN varchar(50),
    email varchar(50)
);
INSERT INTO UserProfile Values (1,'B','C','@gmail.lop');
INSERT INTO UserProfile Values (1,'C','B','@gmail.lop');
INSERT INTO UserProfile Values (1,'C','D','@gmail.lop');
INSERT INTO UserProfile Values (1,'C','D','@gmail.lop');
INSERT INTO UserProfile Values (1,'W','U','@gmail.lop');
INSERT INTO UserProfile Values (1,'L','P','@gmail.lop');
Select * From UserProfile;
SELECT CONCAT(FirsN, CONCAT(' ',LastN)) AS `NAME`, email FROM UserProfile;

INSERT INTO contact Values (1,'B','C','@gmail.lop');
INSERT INTO contact Values (1,'C','B','@gmail.lop');
INSERT INTO contact Values (1,'C','D','@gmail.lop');
INSERT INTO contact Values (1,'C','D','@gmail.lop');
INSERT INTO contact Values (1,'W','U','@gmail.lop');
INSERT INTO contact Values (1,'L','P','@gmail.lop');
Select * From contact;
SELECT CONCAT(FirsN, CONCAT(' ',LastN)) AS `NAME`, email FROM contact;
-- Bulk Insert -
-- Output of a query could be given as an input to the INSERT command and this is possible if 
-- the output structure of the query matches with the expected input or insert structure. 
-- This command is normally used in data migrations from one table to another.

INSERT INTO contact
SELECT * From UserProfile;
