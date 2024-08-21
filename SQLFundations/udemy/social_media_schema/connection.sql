use socialdb;
-- User Connections: many users can get connected with many users. Many users can fallow many users.
create table user_connections(
	user_one integer not null,
    user_two integer not null,
    is_connected bit not null,
    is_followed bit not null, 
    connected_dttm datetime not null default now(),
    
    constraint fk_user_one_userprofileid foreign key (user_one) references user_profile(user_id),
	constraint fk_user_two_userprofileid foreign key (user_two) references user_profile(user_id)
);

-- roqueL connected 	with chrisBen
-- (roqueL, chrisBen) and (chrisBen,roqueL)
insert into user_connections values (3,1,1,0,now());
insert into user_connections values (1,3,1,0,now());

-- roqueL connected 	with PerlaB
-- (roqueL, PerlaB) and (PerlaB,roqueL)
insert into user_connections values (1,2,1,0,now());
insert into user_connections values (2,1,1,0,now());

-- (roqueL,AugA) AugA follows roqueL
insert into user_connections values (1,5,0,1,now());

select * from user_connections;

-- getting the connections of roqueL by using subqueries
select user_name from user_profile
where user_id in(
	select user_two from user_connections
    where user_one = (
    select user_id from user_profile where user_name='roqueL') and is_connected=1
);
-- same case by joinnig
select user_name from user_profile as un 
inner join user_connections uc on (
	un.user_id = uc.user_two  and 
    uc.user_one = 1 and uc.is_connected=1 
) ;


select * from user_profile;
select up.user_name, up.password,up.email,up.first_name,up.midd_name,up.last_name,
up.created_dttm,up.id_deleted,userpext_id,profile_image, phone  
from user_profile as up inner join  user_profile_ext as epext on (up.user_id=epext.userpext_id);

