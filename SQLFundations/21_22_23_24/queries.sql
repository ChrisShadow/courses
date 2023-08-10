use demodb;
select * from employee;
select * from dept;

-- Cartesian Product - 
-- Consider two tables A(X, Y) and B(Y, Z) and
-- A = { (a, 1), (c, 3) }  and B = { (1, p), (2, q) }
-- A x B = { ((a, 1), (1, p)) , ((a, 1), (2, q)), ((c, 3), (1, p)), ((c, 3), (2, q)) }
-- The above will be the result of the command select * from A, B;
-- Now in order to filter only those records with match the Y attribute value i.e. A.Y  = B.Y
-- select * from A, B where A.Y = B.Y;
-- Then this picks only one record from the above.
-- { ((a, 1), (1, p)) }
-- This is referred to as CROSS JOIN and A.Y = B.Y is referred to as JOIN CONDITION.

-- JOIN
-- Is the process of combining the information from multiple tables based on some condition( i.e. join condition). 
-- Consider two tables A(X, Y) and B(Y, Z) and  JOINED over Y on equality of Y i.e. A.Y = B.Y, 
-- A = { (a, 1), (c, 3) }  and B = { (1, p), (2, q) }

-- INNER JOIN
-- Picking only those records which match the JOIN condition is called INNER JOIN.
-- A INNER JOIN B => bring all the records from A and B which match the JOIN CONDITION.
-- i.e. { ((a, 1), (1, p)) }
-- But there may be some records which might not be selected as they did not satisfy the JOIN condition what about them? In order bring those records we need to use OUTER JOIN.

-- OUTER JOIN
-- Includes those records which did not meet the JOIN condition.
-- A LEFT OUTER JOIN B => bring all the records from A even there is no matching records in B
-- i.e. { ((a, 1), (1, p)), ((c, 3), (null, null)) }
-- A RIGHT OUTER JOIN B => bring all the records from B even there is no matching records in A
-- i.e. { ((a, 1), (1, p)), ((null, null), (2, q)) }

-- A FULL OUTER JOIN B => bring all the records from both A and B even when the condition did not match. It is nothing but the UNION Of the above two.
-- i.e. { ((a, 1), (1, p)), ((c, 3), (null, null)), ((null, null), (2, q)) }

	
-- Cartesian product
select * from employee, dept;
-- Cross Join to pick only those records whose DeptID matches and with alias
select * from employee as emp, dept as dep where emp.dept_id=dep.dept_id;
-- Same is achieved through INNER JOIN, retrieves only matching Employee and Dept records
select emp_id, first_name, last_name, emp.dept_id, salary, name , location from
employee as emp inner join dept as dep on (emp.dept_id=dep.dept_id);

-- Left Outer join: left-hand group, retrieves all employees irrespective of whether they have a matching 
select emp_id, first_name, last_name, emp.dept_id, salary, name , location from
employee as emp left outer join dept as dep on (emp.dept_id=dep.dept_id);
-- Right Outer join: right-hand group, retrieves all department records irrespective of whether they have a matching 
select emp_id, first_name, last_name, emp.dept_id, salary, name , location from
employee as emp right outer join dept as dep on (emp.dept_id=dep.dept_id);
-- Full Outer join: the hole universe
-- Below query is valid in MS Sql Server; but not in MySql
-- SELECT * FROM Employee as e
-- FULL JOIN Dept as d ON (e.DeptID = d.DeptID);
        
-- Full Join Simulation in MySQL
select emp_id, first_name, last_name, emp.dept_id, salary, name , location from
employee as emp left outer join dept as dep on (emp.dept_id=dep.dept_id)
union
select emp_id, first_name, last_name, emp.dept_id, salary, name , location from
employee as emp right outer join dept as dep on (emp.dept_id=dep.dept_id);

-- subqueries
-- Subquery is a query written inside another query. The outcome of the inner query is used as an 
-- input to the outer query.
select * from dept where name ='Proi';
select * from employee where dept_id=102;
select * from employee where dept_id=(select dept_id from dept where name ='Proi');
select * from employee where dept_id=(select dept_id from dept where location='Av. Sacramento');
-- if there are more than 1 tuple: 
select * from employee where dept_id in (select dept_id from dept where location='Av. Sacramento');
select emp.* from employee as emp inner join dept as dep on (emp.dept_id =dep.dept_id and dep.name='Proi');

-- Below insert command is very useful in SQL in Project
-- When you are inserting master data and if you do not know 
-- the generated ID then the query could be used to get the 
-- generated ID and given as input to the insert.
-- Here the output of the select command is given as input for 
-- DeptID column value.
-- NOTE - You need to make sure that it only retrieves one value
-- if it retrieves multiple values then it lead to failure.
 
-- INSERT INTO `Employee`(`FirstName`, `LastName`, `DeptID`, `Salary`)
-- VALUES('A','A', (SELECT `DeptID` FROM `Dept` WHERE `Name`='Inventory'), 11000);
-- INSERT INTO `Employee`(`FirstName`, `LastName`, `DeptID`, `Salary`)
-- VALUES('B','B', (SELECT `DeptID` FROM `Dept` WHERE `Name`='Sales'), 12000);
-- INSERT INTO `Employee`(`FirstName`, `LastName`, `DeptID`, `Salary`)
-- VALUES('C','C', (SELECT `DeptID` FROM `Dept` WHERE `Name`='HR'), 21000);
-- INSERT INTO `Employee`(`FirstName`, `LastName`, `DeptID`, `Salary`)
-- VALUES('D','D', (SELECT `DeptID` FROM `Dept` WHERE `Name`='HR'), 22000);

-- corraleted subqueries: sligthly efficient, a subquery is said to be correlated if it refers to the columns of the outer query.
select * from employee as emp where exists (select * from dept where dept_id = emp.dept_id and name='Proi');
-- Most of the times JOIN might turns out to be a better option.
select emp.* from employee as emp inner join dept  as dep on (emp.dept_id=dep.dept_id and name='Proi');