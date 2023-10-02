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
-- 1) Display the total likes for the posts posted by 'roqueL'
select * from user_profile;
select * from post;
select * from post_likes ;
select p.tittle as PostTittle , p.content as PostContent , up.user_name as PostedBy, 
up.user_name as LikedBy from post as p, user_profile as up 
inner join post_likes as pl on (p.post_id =pl.post_id) 
inner join user_profile as up on(p.posted_by=up.user_id)
inner join post_likes as pl on (up.user_id=pl.liked_by)
 ;
 select  count(*) quantity  from post_likes  where post_id=2; 
 
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


-- 2) Display the PostID and Likes count for the posts posted by 'a'
-- 3) Display the name of the user with maximum post likes.
-- 4) Display the users with maximum posts*/


     
  