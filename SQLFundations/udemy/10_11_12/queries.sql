use demodb;
drop table Person;
-- Constraints -

-- Allows us to impose constraints over a column or a set of columns.
-- UNIQUE - Does not allow duplicates but allows NULL values.
-- NOT NULL - Does not allow NULL values.

create table person(
	name char(50) unique not null,
    address char(200),
    dob date not null);
insert into person values('CC','PYG','2023-07-31');
insert into person(address, dob) values('PYG','2023-07-31');
select * from person order by 3;

-- Identity and auto_incremente columns
-- Also called as a surrogate key, plays critical role in foreign key relationships, 
-- you can think of it as a sequence number associated with the record. Usually selected 
-- for auto_increment. 
create table `course` ( 
	`id` int unique auto_increment,
    `name` varchar (100)
);
insert into `course`(`name`) values ('A');
insert into `course`(`name`) values ('B');
select * from `course`;
alter table `course` auto_increment=50;

-- Primary Key

create table user_profile(
	first_name int unique not null auto_increment,
    last_name varchar(50) not null ,
    midd_name varchar(50) not null,
    user_name varchar(50) unique not null ,
    password varchar(50),
    email varchar(50) unique not null,
    is_active bit not null default 1,
    is_locked bit not null default 0,
    created_DTTM datetime default now(), -- current date and time
    last_modified_DTTM datetime
);
desc user_profile;

-- Keys
--   1. userProfileID 
--   2. userName
--   3. email
-- Usually identity column is selected for primary key i.e. userProfileID
-- in this case. Identity column is the one which is not impacted by the
-- change in the business rules because it is not a business column.
-- Others such as userName and email are business columns and today 
-- they may be unique, but may not be at later point of time,
-- for example business rule might change to only email is unique. 
-- So, in order to avoid the impact, the surrogate key
-- i.e. the identity column is normally 
-- selected for primary key.



