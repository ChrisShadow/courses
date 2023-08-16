create schema SocialDB default character set 'utf8';
use socialdb;
create table user_profile(
	user_id integer primary key auto_increment,
    user_name varchar(20) unique not null,
	password varchar(20) not null,
    email varchar(20) unique not null,
    first_name varchar(20) 	not null,
    midd_name varchar(20) ,
    last_name varchar(20) not null,
    created_dttm datetime not null default now(),
    updated_dttm datetime,
	id_deleted bit not null default 0
);

insert into user_profile(user_name, password,email,first_name,midd_name,last_name)
values ('roqueL','1234O','roquecano@gmail.com','roque','david','cano');
insert into user_profile(user_name, password,email,first_name,midd_name,last_name)
values ('PerlaB','1234N','perlaBen@gmail.com','PERLA','Beln','Benitez');
insert into user_profile(user_name, password,email,first_name,midd_name,last_name)
values ('chrisBen','1234K','chrisdan@gmail.com','chris','daniel','bene');
insert into user_profile(user_name, password,email,first_name,midd_name,last_name)
values ('AugA','1234h','AugustoAl@gmail.com','Augusto','Alexis','Rolon');

select * from user_profile;

-- UserProfleExt <--1-1--> UserProfile
-- tinytext: 225, text: 64k, mediumtext: 16mb, longtext: 4gb
create table user_profile_ext(
	userpext_id integer primary key auto_increment,
    user_id	integer not null,
    -- blob,binary large object: doc, img 
    profile_image varchar(100),
	phone varchar(12),
    web_site varchar(100),
    head_line varchar(256),
    country	varchar(50),
    summary text,
    
    constraint fk_user_profile_id foreign key(user_id) references user_profile(user_id)
);

insert into user_profile_ext (user_id,profile_image,phone)
values (1,'C:\Users\chris\Desktop\new','982351533');
insert into user_profile_ext (user_id,profile_image,phone)
values (2,'C:\Users\chris\Desktop\new','981589566');
insert into user_profile_ext (user_id,profile_image,phone)
values (3,'C:\Users\chris\Desktop\new','983467894');
insert into user_profile_ext (user_id,profile_image,phone)
values (4,'C:\Users\chris\Desktop\new','992548357');

select * from user_profile_ext;

-- display the user info along with profile extensions.
select up.user_name, up.password,up.email,up.first_name,up.midd_name,up.last_name,
up.created_dttm,up.id_deleted,userpext_id,profile_image, phone  
from user_profile as up inner join  user_profile_ext as epext on (up.user_id=epext.userpext_id)	;