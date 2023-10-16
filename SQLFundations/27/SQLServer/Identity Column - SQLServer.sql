

-- Auto Increment Column

-- Select the Database.

	USE DemoDB;

-- Create  

	CREATE TABLE Course (
		CourseID INT IDENTITY(1,1) PRIMARY KEY,
		Name VARCHAR(50),
		Fee NUMERIC(10,2)
	); 

	-- Identity in the above example starts the count with 1 and increments by 1.

-- INSERT 

	INSERT INTO Course(Name, Fee)
	VALUES('A', 20);

	INSERT INTO Course(Name, Fee)
	VALUES('B', 30);
	
-- Select

	SELECT * FROM Course;

-- Drop 

	DROP TABLE Course;
