Use demodb;
create table student(
	student_id int primary key not null auto_increment,
    name varchar(50) not null,
    course_id int,
    score numeric(10,2),
    constraint fk_courseid foreign key (course_id) references course(id)
);
select * from student;
insert into `student`(`name`, `course_id`,`score`) values ('Marce', 50,8.3);
insert into `student`(`name`, `course_id`,`score`) values ('Ale', 1,9.3);
insert into `student`(`name`, `course_id`,`score`) values ('Gorge', 50,7.3);
insert into `student`(`name`, `course_id`,`score`) values ('Kevin', 2,5.3);
insert into `student`(`name`, `course_id`,`score`) values ('Violet', 2,8.3);
insert into `student`(`name`, `course_id`,`score`) values ('Spencer', 51,8.3);
alter table `student` auto_increment=10;

-- Aggretate functions
-- sum() - to calculate the sum of values.
-- min() - to find the minimum value.
-- max() - for getting the maximum value.
-- avg() - for getting the average value.
-- count() - for counting the records.

select sum(score) as total from student;
select min(score) as minumum from student;
select max(score) as maximum from student;
select avg(score) as average from student;
select count(*) as totalstudent from student;

-- Using GROUP BY in Query
-- Group by helps us to group records in the table based on the selected fields. 
-- The equal values for the selected fields will form a group. And if the aggregate functions 
-- such as SUM, MIN, MAX etc. are used along with GROUP BY they perform the corresponding 
-- operation on each group instead of entire table.
-- Note that while using GROUP BY, the display column list can only contain the grouped 
-- columns along with aggregate operations or pseudo columns such as direct values.

select course_id, sum(score) as total from student group by course_id; 

-- HAVING clause
-- HAVING clause allows us to further filter the records obtained as a result of GROUP BY 
-- and helps us further filter the groups.
select  course_id, avg(score) as average from student group by course_id having avg(score) >8;

-- this returns which course has at least 2 or more students
-- COUNT(*) returns the number of records present in that group 
-- and >= 2 ensures that there are at least there are two or more records.
select course_id from student group by course_id having count(*)>=2;

