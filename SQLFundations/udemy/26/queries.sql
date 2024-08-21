-- alter
use socialdb;
desc user_profile;

alter table user_profile
add column active bit not null;

alter table user_profile
modify column email varchar(150) not null;

alter table user_profile
drop column id_deleted;

-- views: either virtual or logical table
select * from user_profile;
select * from user_profile
where user_id =3;

create or replace view ActiveUsersView
as 
select * from user_profile
where user_id =2;

select * from ActiveUsersView;

-- drop view ActiveUsersView

-- index: it optimize the record search throgh query. The default ones are both pk and uq
create index IX_USEREMAIL on user_profile(user_name,email);
alter table user_profile
auto_increment=6;

alter table user_profile
change column password  pass varchar(50);

insert into 
user_profile(user_name,pass,email,first_name,midd_name,last_name,created_dttm,updated_dttm, active)
values
('PedroSh','klklk','p@outlook.com','Pedro','Pedroso','Coronel',now(),now(),1);

-- drop index IX_USEREMAIL on user_profile;



