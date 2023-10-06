-- Problem - 2

-- Design tables for User Experience, Publications, Skills, Endorsements.
-- Experience(UserProfileID, CompanyName, StartDate, EndDate, JobTitle, JD )
-- Publication(UserProfileID, Url, PublishedDate, Title, Description)
-- Skill(UserProfileID, SkillName)
-- SkillEndorsement(SkilID, EndorsedBy)

use socialdb;
create table Experience(
       ExperienceID integer primary key auto_increment,
       UserProfileID integer not null,
       CompanyName varchar(100) not null, 
       StartDate datetime not null, 
       EndDate datetime, 
       JobTitle varchar(100), 
       JD text,
       constraint fk_userprofileid_exp foreign key(UserProfileID) references user_profile(user_id)
);

create table Publication(
       PublicationID integer primary key auto_increment,
       UserProfileID integer not null,
       Url varchar(100), 
       PublishedDate date, 
       Title varchar(100) not null, 
       Description text,
       constraint fk_userprofileid_publication foreign key(UserProfileID) 
                  references  user_profile(user_id)
);

create table Skill(
      SkillID integer primary key auto_increment,
      UserProfileID integer not null,
      SkillName varchar(50) not null,
      constraint fk_userprofileid_skill foreign key(UserProfileID) 
                                        references  user_profile(user_id),
      constraint unq_userprofileid_skill unique(UserProfileID, SkillName)
);

create table SkillEndorsement(
        SkillEndorsementID integer primary key auto_increment,
        SkillID integer not null, 
        EndorsedBy integer not null,
        constraint fk_skill_id_endorsement foreign key(SkillID) 
                                           references Skill(SkillID),
        constraint fk_endorsedby_endorsement foreign key(EndorsedBy) 
                                             references  user_profile(user_id),
        constraint unq_skill_endorsment unique(SkillID, EndorsedBy)
);

-- Problem - 3
/*1) Display the total likes for the posts posted by 'roqueL'
and
2) Display the PostID and Likes count for the posts posted by 'roqueL'*/

select * from user_profile;
select * from post;
select * from post_likes ;
select p.tittle as PostTittle , p.content as PostContent , up.user_name as PostedBy, 
up.user_name as LikedBy from post as p, user_profile as up 
inner join post_likes as pl on (p.post_id =pl.post_id) 
inner join user_profile as up on(p.posted_by=up.user_id)
inner join post_likes as pl on (up.user_id=pl.liked_by)
 ;
 select  count(*) quantity  from post_likes; 
 
 -- with gpt
 SELECT
    p.title AS PostTitle,
    p.content AS PostContent,
    posted_by.user_name AS PostedBy,
    liked_by.user_name AS LikedBy,
    COUNT(pl.post_id) AS LikesCount
FROM
    post AS p
INNER JOIN
    user_profile AS posted_by ON p.posted_by = posted_by.user_id
LEFT JOIN
    post_likes AS pl ON p.post_id = pl.post_id
INNER JOIN
    user_profile AS liked_by ON pl.liked_by = liked_by.user_id
GROUP BY
    p.post_id, p.title, p.content, posted_by.user_name, liked_by.user_name
ORDER BY
    p.title;

-- 3) Display the name of the user with maximum post likes.
-- with gpt
 SELECT
    p.title AS PostTitle,
    p.content AS PostContent,
    posted_by.user_name AS PostedBy,
    liked_by.user_name AS LikedBy,
    COUNT(pl.post_id) AS LikesCount
FROM
    post AS p
INNER JOIN
    user_profile AS posted_by ON p.posted_by = posted_by.user_id
LEFT JOIN
    post_likes AS pl ON p.post_id = pl.post_id
INNER JOIN
    user_profile AS liked_by ON pl.liked_by = liked_by.user_id
left join (
 SELECT
        p1.post_id AS PopularPostID
    FROM
        post AS p1
    LEFT JOIN
        post_likes AS pl1 ON p1.post_id = pl1.post_id
    GROUP BY
        p1.post_id
    ORDER BY
         count(pl1.post_id)
) AS popular_post ON p.post_id = popular_post.PopularPostID
GROUP BY
    p.post_id, p.title, p.content, posted_by.user_name, liked_by.user_name
ORDER BY
    LikesCount desc;

-- option 2
/*
more than one tuple when there are multiple posts that have the same maximum number of "likes". 
In that case, the subquery returns multiple results with the same maximum number of "likes", 
and each of those users is included in the result of the main query.
*/
SELECT
    p.title AS PostTitle,
    p.content AS PostContent,
    posted_by.user_name AS PostedBy,
    (
        SELECT user_name
        FROM user_profile AS popular_user
        WHERE popular_user.user_id = p.posted_by
        ORDER BY (
            SELECT COUNT(pl1.post_id)
            FROM post_likes AS pl1
            WHERE pl1.post_id = p.post_id
        ) DESC
        LIMIT 1
    ) AS MostLikedBy,
    COUNT(pl.post_id) AS LikesCount
FROM
    post AS p
INNER JOIN
    user_profile AS posted_by ON p.posted_by = posted_by.user_id
LEFT JOIN
    post_likes AS pl ON p.post_id = pl.post_id
GROUP BY
    p.post_id, p.title, p.content, posted_by.user_name, MostLikedBy
ORDER BY
    LikesCount desc;
    
-- option 3
SELECT
    p.title AS PostTitle,
    p.content AS PostContent,
    posted_by.user_name AS PostedBy,
    (
        SELECT user_name
        FROM user_profile AS popular_user
        WHERE popular_user.user_id = p.posted_by
        ORDER BY (
            SELECT max(pl1.post_id)
            FROM post_likes AS pl1
            WHERE pl1.post_id = p.post_id
        ) DESC
        LIMIT 1
    ) AS MostLikedBy,
     count(pl.post_id) AS LikesCount
FROM
    post AS p
INNER JOIN
    user_profile AS posted_by ON p.posted_by = posted_by.user_id
LEFT JOIN
    post_likes AS pl ON p.post_id = pl.post_id
GROUP BY
    p.post_id, p.title, p.content, posted_by.user_name, MostLikedBy
ORDER BY
    LikesCount desc;

select * from post_likes;
select * from post_comment;
select * from post;
select * from user_profile;

-- removing the content in
delete from post_likes where post_like_id between 4 and 13;

-- removing the check in post like
alter table post_likes
drop index unq_postid_likedby;

/*in order to cancel the uq
alter table post_likes
--drop constraint fk_postid;
drop constraint fk_liked_by;*/

/*after droping the uq, reset the constraints*/
alter table post_likes
add constraint foreign key fk_postid(post_id) references post(post_id);

alter table post_likes
add constraint foreign key fk_likedby(liked_by) references user_profile(user_id);

-- more content for post likes table
-- first, reseting the tuples
ALTER TABLE post_likes AUTO_INCREMENT = 1;

insert into post_likes (post_id, liked_by) 
values 
-- (1,5),(2,1),(5,1),(1,3),(2,1),(3,1),(4,1),(4,5),(4,3);
(4,1),(4,1),(4,1),(3,1),(2,1);


-- more content for post comment table
insert into post_comment(post_id,comment_for_comment_id,comment_text,commented_by) 
values
-- (5,default,'reliable source',1),(4,default,'this subject it is exactly what i was looking for',3),(3,default,'Isn there a new technique?',2);
(5,9,'Oracle always does give trustworthy info:',3),(4,10,'Hppe it could helps you',1),(3,11,'Yes, please mention that one and share us a little bit of your knowledge',5);

-- first, more content for post table
insert into post (title, content,posted_by) 
values 
('Prompt engeneering', 'GenerativeIA',5),
('Mathematics fundamentasl', 'Training the brain',2),
('How to colaborate in an uncertainty world', 'Best ERP softwares by oracle',3),
('How to eat healthy', 'Nutrition',2),
('How to eat healthy', 'Nutrition',3),
('How to eat healthy', 'Nutrition',3),
('How to eat healthy', 'Nutrition',3);



-- 4) Display the users with maximum posts*/
SELECT
    p.title AS PostTitle,
    p.content AS PostContent,
    posted_by.user_name AS PostedBy,
    (
        SELECT user_name
        FROM user_profile AS prolific_user
        WHERE prolific_user.user_id = (
            SELECT posted_by
            FROM post
            GROUP BY posted_by
            ORDER BY COUNT(post_id) DESC
            LIMIT 1
        )
    ) AS MostProlificUser,
    COUNT(pl.post_id) AS LikesCount
FROM
    post AS p
INNER JOIN
    user_profile AS posted_by ON p.posted_by = posted_by.user_id
LEFT JOIN
    post_likes AS pl ON p.post_id = pl.post_id
GROUP BY
    p.post_id, p.title, p.content, posted_by.user_name, MostProlificUser
ORDER BY
    LikesCount asc;

     
  