Use demodb;
Create table person(
	name char(50),
    address char(200),
    dob date, 
    ownAHouse bit default 0
);
-- Displays the records from the Person table
-- There are not ordered, remember it is not even 
-- insertion order, database never guarantees insertion 
-- order.

insert into person values('A','Addr1','2023-07-26',1),('B','Addr2','2023-07-25',0),('C','Addr3','2023-07-24',1);

-- descending order.
select * from person order by dob desc;

-- Order by ownAHouse, then for equal values of 
-- ownAHouse, order by DOB. 
-- Think about language dictionary, words are arranged 
-- using first alphabet and with in second alphabet and so on.
select * from person order by ownAHouse,dob;

-- Order by 4th display column 
-- [note - it depends on column list in the select command]
select * from person order by 4;

     
-- Order by 2nd display column i.e. dob.
     
select `address`, `dob` from `Person` order by 2;

-- filtering
select * from person where ownAHouse=1;

-- any number of character
select * from person where name like 'A%';

-- one character
select * from person where name like 'A_';

-- sort of Regular expression
select * from person where name like '_B%';

select * from person where address='Addr1' or address='Addr3';
-- or, it is much handy
select * from person where address in('Addr1','Addr3');

-- the opposite
select * from person where address not in('Addr1','Addr3');

select * from person where dob between '2023-07-25' and '2023-07-26';

select * from person where ownAHouse = 1 and month(dob)=7


