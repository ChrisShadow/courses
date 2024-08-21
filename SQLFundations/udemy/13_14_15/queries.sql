use demodb;
Create table dept(
	dept_id INT primary KEY NOT NULL auto_increment,
    name varchar(50),
    location varchar(50)
);
drop table userprofile;
create table employee(
	emp_id INT primary KEY NOT NULL auto_increment ,
    first_name varchar(50),
    last_name varchar(50),
    dept_id INT,
    salary numeric(10,2),
    CONSTRAINT fk_deptid FOREIGN KEY (dept_id) REFERENCES dept(dept_id)
);
alter table `dept` auto_increment= 101;
insert into `dept`(`name`,`location`) values('Pro','Av. Sacramento');
insert into `dept`(`name`,`location`) values('Proi','Av. Artigas');
select * from dept where dept_id=102;
insert into `employee`(`first_name`,`last_name`,`dept_id`,`salary`) values('Ben', 'Daniels',102,10000);
select * from employee;
-- Can be settled with null value, in the event that an employee does not belong to any dept
insert into `employee`(`first_name`,`last_name`,`dept_id`,`salary`) values('Oliv', 'Ruther',null,10000);
-- If there is a need to restrict NULL values then you 
-- can apply NOT NULL constraint for DeptID column in Employee. 
-- While dropping tables or deleting records, we first need to 
-- delete the referencing entries before deleting the referred entries.
-- Hence first Employee then Dept.

-- MANY TO MANY
create table course(
	course_id int primary key not null auto_increment,
    name varchar(50) not null,
    fee numeric(10,2) not null
);
create table student (
	student_id int primary key not null auto_increment,
    first_name varchar(50) not null,
    last_name varchar(50) not null
);
create table course_enrollments(
	course_id int not null references course, 
    student_id int not null references student
);

-- Relationship Cardinality:

-- Cardinality of relationship represents the number of entities participate in the relation. 
-- It could be categorized into three types

-- one-to-one: If you apply UNIQUE constraint on a FOREIGN KEY, that makes it a one-to-one 
-- relation. This is normally used for creating extension tables with additional attributes 
-- with one-to-one relation with a record in main table.

-- one-to-many (or) many-to-one: This is the natural cardinality achieved through simple 
-- foreign key relation. For example consider the employee and department relation where 
-- many employees work for a department. This itself if many-to-one.

-- many-to-many: For example consider student and course relation, a student can join many 
-- courses and a course can have many students which makes it a many-to-many relation. 
-- This relation is captured using a junction table as shown in the below example.