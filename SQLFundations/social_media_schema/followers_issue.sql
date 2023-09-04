use socialdb;
-- Problem-1: Write a query to retreive all the followers of roqueL
-- Note: -followers includes connections + only followers


-- User posts
-- One user can post many posts
create table post(
	post_id integer primary key auto_increment,
    title varchar(200) not null,
    content text not null,
    posted_by integer not null, 
    posted_dttm datetime not null default now(),
    constraint fk_postedby foreign key(posted_by) references user_profile(user_id)
);

insert into post (title, content,posted_by) values ('Chat bot with Python', 'Pythons content',3);
update post set posted_by=2 where post_id =2;
select * from post_likes;

-- post likes
create table post_likes(
	post_like_id integer primary key auto_increment,
    post_id integer not null,
    liked_by integer not null,
    action_dttm datetime not null default now(),
    
    constraint fk_postid foreign key(post_id) references post(post_id),
    constraint fk_likedby foreign key(liked_by) references user_profile(user_id),
    -- not a sigle column, a combination indeed
    constraint unq_postid_likedby unique(post_id,liked_by)
);

insert into post_likes (post_id, liked_by) values (1,5);
insert into post_likes (post_id, liked_by) values (2,1);

-- 