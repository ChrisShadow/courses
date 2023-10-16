-- SubQueries

-- Select the Database.

	USE DemoDB;

-- Create 

	CREATE TABLE Dept(
		DeptID INT IDENTITY(1,1) PRIMARY KEY,
		Name VARCHAR(50) NOT NULL,
		Location VARCHAR(50) NOT NULL
	); 

	CREATE TABLE Employee(
		EmpID INT IDENTITY(1,1) PRIMARY KEY,
		FirstName VARCHAR(50) NOT NULL,
		LastName  VARCHAR(50) NOT NULL,
		DeptID INT REFERENCES Dept,
		Salary NUMERIC(10,2) NOT NULL CHECK (Salary > 0)
	); 

-- INSERT 

	INSERT INTO Dept(Name,Location)
	VALUES('Inventory', 'Loc1');

	INSERT INTO Dept(Name,Location)
	VALUES('Sales', 'Loc2');

	INSERT INTO Dept(Name,Location)
	VALUES('HR', 'Loc2');

	INSERT INTO Employee(FirstName, LastName, DeptID, Salary)
	VALUES('A','A', (SELECT DeptID FROM Dept WHERE Name='Inventory'), 11000);

	INSERT INTO Employee(FirstName, LastName, DeptID, Salary)
	VALUES('B','B', (SELECT DeptID FROM Dept WHERE Name='Sales'), 12000);

	INSERT INTO Employee(FirstName, LastName, DeptID, Salary)
	VALUES('C','C', (SELECT DeptID FROM Dept WHERE Name='HR'), 21000);

	INSERT INTO Employee(FirstName, LastName, DeptID, Salary)
	VALUES('D','D', (SELECT DeptID FROM Dept WHERE Name='HR'), 22000);

-- Select

	SELECT * FROM Dept;
	SELECT * FROM Employee;

	-- Display employees who work for HR department

	SELECT * FROM Employee
	WHERE DeptID = (
		SELECT DeptID FROM Dept
		WHERE Name = 'HR' );

	-- Display employees whose department location is 'Loc2'

	SELECT * FROM Employee
	WHERE DeptID in (
		SELECT DeptID FROM Dept
		WHERE Location = 'Loc2' );

-- Drop

	DROP TABLE Employee;
	DROP TABLE Dept;
	