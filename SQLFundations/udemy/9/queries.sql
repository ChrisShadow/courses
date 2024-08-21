-- Delete -
-- Delete deletes the records from the table, if there is no where clause then it deletes all the records. 
-- But delete gives us the option to rollback (you will understand this during transaction control)  i.e. 
-- in short it allows us to revert the deletion and bring back the deleted records when a transaction is 
-- active. Where as truncate doesn't give us this option, and moreover truncate doesn't support where clause.

-- Update
-- Update allows us to update the field values, like delete, if there is no 
-- where clause it updates all the records otherwise it will only update those
-- records which match the where condition.

Use demodb;
select * from person;
select * from person order by 3;
-- This only for my sql when it does change every record
set SQL_SAFE_UPDATES=0;
update person set ownAHouse=1;

-- the difference between truncated and delete is that with the second one we have the rollback option during 
-- transaction control commands. The first one doesn't have at all and erases all the data.

-- A specific tuple
update person set address ='Addr0'
where name='B';
insert into person(name,address,ownAHouse)  values('D','Addr4',0);
-- incorrect mode
update person set dob ='2023-07-27'
where dob = null;
-- correct mode
update person set dob ='2023-07-27'
where dob is null;

delete from person
where dob = '2023-07-25';