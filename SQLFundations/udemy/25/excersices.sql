use demodb;
select * from student;
update student set score=24
where student_id=5;
CREATE TABLE `Grade`(
    `start`  INT NOT NULL,
    `end`    INT NOT NULL,
    `grade`  CHAR(1)
);

-- start and end inclusive for grade.
insert into `Grade` values(40, 60, 'D');
insert into `Grade` values(61, 70, 'C');
insert into `Grade` values(71, 80, 'B');
insert into `Grade` values(81, 100, 'A');

-- Using the above schema
-- 1:Display the student details along with their grade.
select name, score, grade from student as st inner join grade as gr on (st.score <=gr.end and st.score>=gr.start);
-- 2:Display the list of students who got grade 'C'.
select name, score, grade from student as st inner join grade as gr on (st.score <=gr.end and st.score>=gr.start and gr.grade='C');
-- 3: Display the list of students who did not get any grade.
select * from student where score <40;
select name, score, grade from student as st left outer join grade as gr on (st.score <=gr.end and st.score>=gr.start) where gr.grade is null;
-- 4:Display the average, minimum and maximum score of all the students.
select min(score) as minumum from student;
select max(score) as maximum from student;
select avg(score) as average from student;