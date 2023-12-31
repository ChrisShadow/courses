
-- Delete

-- Select the Database.

	USE DemoDB;

-- Create  

	CREATE TABLE Course (
		CourseID INT IDENTITY(1,1) PRIMARY KEY,
		Name   VARCHAR(50),
		Price NUMERIC(10,2)
	); 

-- INSERT 

	INSERT INTO Course(Name, Price)
	VALUES('Java', 40);

	INSERT INTO Course(Name, Price)
	VALUES('SQL', 40);

	INSERT INTO Course(Name, Price)
	VALUES('C', 20);
    
    INSERT INTO Course(Name, Price)
	VALUES('C++', 30);
	
-- Select

	SELECT * FROM Course;
	
-- Delete
	
	-- Delete CourseID 3

	DELETE FROM Course
	WHERE CourseID = 3;


	-- Delete all Course records

	DELETE FROM Course;
		

-- Drop 

	DROP TABLE Course;
