
-- Basics

-- Create Database 

	CREATE DATABASE [DemoDB];
	

-- Select the database.

	USE [DemoDB];

-- Create  
    	 
	CREATE TABLE Employee(
		EmpID  		INT,
		FirstName	VARCHAR(50),
		LastName    VARCHAR(50),
		Salary      NUMERIC(20,2)
	);


-- Insert 

   INSERT INTO Employee
   VALUES (1, 'A', 'A', 1000);

   INSERT INTO Employee 
   VALUES (2, 'B', 'B', 2000);
   
-- Select 

	SELECT * FROM Employee;

-- Drop 

	DROP TABLE Employee;