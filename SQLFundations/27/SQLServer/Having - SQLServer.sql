
-- Having

-- Select the Database.

	USE DemoDB;

-- Create  

	CREATE TABLE Student (
		StudentID INT IDENTITY(1,1) PRIMARY KEY,
		Name      VARCHAR(50),
		Course    VARCHAR(10),
		Score     NUMERIC(5,2)
	); 

-- INSERT 

	INSERT INTO Student(Name, Course, Score)
	VALUES('A', 'CS', 80);

	INSERT INTO Student(Name, Course, Score)
	VALUES('B', 'CS', 60);

	INSERT INTO Student(Name, Course, Score)
	VALUES('C', 'IT', 70);

	INSERT INTO Student(Name, Course, Score)
	VALUES('D', 'IT', 85);

	INSERT INTO Student(Name, Course, Score)
	VALUES('E', 'ECE', 88);


-- Select

	SELECT * FROM Student;

	-- Display the Total Score, Average Score, Minimum, Maximum score for each group 
	-- whose Average score is greater than 75.


	SELECT
		Course,
		SUM(Score) AS 'Total Score',
		AVG(Score) AS Average,
		MIN(Score) AS Minimum,
		MAX(Score) AS Maximum
	FROM Student
	GROUP BY Course
	HAVING AVG(Score) > 75;
    

	-- Display the groups which are having 2 or more students.

	SELECT Course FROM Student
	GROUP BY Course
	HAVING COUNT(*) >= 2;

-- Drop 

	DROP TABLE Student;
