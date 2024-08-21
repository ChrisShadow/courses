-- Update

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
	
-- Update

	-- Update course name for 'C' to 'C Language' and price to $50.

	Update Course
	SET Name = 'C Language' , Price = 50
	WHERE Name = 'C';
	
	-- Increase course price by 5% for all courses.

	Update Course
	SET Price = Price * 1.05;
	 

-- Drop 

	DROP TABLE Course;
