use socialdb;
select * from post_likes; 

-- Post Comment: 1 post has many comments and many comments has 0, 1 or other comments
create table post_comment(
	post_comment_id integer primary key auto_increment,
    post_id integer not null,
    comment_for_comment_id integer, -- recursivity
    commented_by integer not null,
    commented_dttm datetime not null default now(),
    
    constraint fk_postid_postcomment foreign key(post_id) references post(post_id),
    constraint fk_commentedby foreign key(commented_by) references user_profile(user_id), 
    constraint fk_commentforcomment foreign key (comment_for_comment_id) references post_comment(post_comment_id)
);

alter table  post_comment
add column comment_text text not null;

select * from post;
select * from user_profile;

insert into post_comment(post_id, comment_text,commented_by) 
values
(1,'Python is the best PL ',3),(2,'great job as usual ',2),(1,'nothing better tha happy coding',1),(2,'pleas do not stop of sharing us your projects',1);

select * from post_comment;

insert into post_comment(post_id,comment_for_comment_id,comment_text,commented_by) 
values
(1,1,'sure!',1),(2,2,'Thanks!',2),(1,1,'exactly!',5),(2,2,'anytime, for sure!',2);

-- retrieve the posts posted by roqueL
select * from post 
where posted_by =(select user_id from user_profile where user_name='PerlaB');

-- retrieve the numbers of likes for post_id - 2
select * from post_likes ;
select  count(*) quantity  from post_likes  where post_id=2;

-- tasks: 
   /* create schema SocialDB default character set 'utf8';
     
    use SocialDB;
     
    -- USER
     
    create table UserProfile (
        UserProfileID  integer PRIMARY KEY AUTO_INCREMENT,
        UserName	   varchar(20) UNIQUE not null,
        Password	   varchar(20) not null,
        Email          varchar(40) unique not null,
        FirstName	   varchar(20) not null,
        MiddleName	   varchar(20),
        LastName	   varchar(20) not null,
        CreatedDTTM    datetime	not null default now(),
        UpdatedDTTM	   datetime,
        IsDeleted	   bit not null default 0
    );
     
    insert into UserProfile(UserName, Password, Email, FirstName, LastName)
    values('a','a','a@test.com','a','a');
     
    insert into UserProfile(UserName, Password, Email, FirstName, LastName)
    values('b','b','b@test.com','b','b');
     
    insert into UserProfile(UserName, Password, Email, FirstName, LastName)
    values('c','c','c@test.com','c','c');
     
    insert into UserProfile(UserName, Password, Email, FirstName, LastName)
    values('d','d','d@test.com','d','d');
     
    select * from UserProfile;
     
    -- UserProfileExt <-- 1-1 --> UserProfile
    -- tinytext - 255, text - 64k, mediumtext - 16mb, longtext - 4gb
     
    create table UserProfileExt (
        UserProfileExtID  integer primary key AUTO_INCREMENT,
        UserProfileID     integer unique not null,
        ProfileImage      varchar(100),
        Phone 	      varchar(12),
        Website	      varchar(100),
        HeadLine	      varchar(256),
        Country	      varchar(50),
        Summary 	      text,
        constraint fk_userprofileid  foreign key(UserProfileID) references UserProfile(UserProfileID)
    );
     
    insert into UserProfileExt(UserProfileID, ProfileImage, Phone)
    values(1, '/storage/1/image.png', '1234');
     
    select * from UserProfileExt;
     
    -- Display the user info along with profile extensions.
     
    select * from UserProfile;
     
    select * from UserProfile as u
    left outer join UserProfileExt as upe on (u.UserProfileID = upe.UserProfileID);
     
    -- User Connections
    -- Many users can get connected with many users.
    -- Many users can follow many users.
     
    create table UserConnection (
        UserOne  integer not null,
        UserTwo  integer not null,
        IsConnection bit not null,
        IsFollower bit not null,
        ConnectedDTTM datetime not null default now(),
        constraint fk_userone_userprofileid foreign key(UserOne) references UserProfile(UserProfileID),
        constraint fk_usertwo_userprofileid foreign key(UserTwo) references UserProfile(UserProfileID)
    );
     
    -- a connected with b
    -- (a, b) and (b, a)
     
    insert into UserConnection values(1, 2, 1, 0, now());
    insert into UserConnection values(2, 1, 1, 0, now());
     
     
    -- (a, c) and (c, a)
     
    insert into UserConnection values(1, 3, 1, 0, now());
    insert into UserConnection values(3, 1, 1, 0, now());
     
    -- (a, d) d follows a 
     
    insert into UserConnection values(1, 4, 0, 1, now());
     
    select * from UserConnection;
     
    -- Get the connections of a.
     
    -- Solved using subqueries.
     
    select UserName from UserProfile
    Where UserProfileID IN (
        select UserTwo from UserConnection
        where UserOne = (select UserProfileID from UserProfile where UserName = 'a')
        and IsConnection = 1
    );
     
    -- using joins
     
    select UserName from UserProfile as u
    inner join UserConnection as uc 
    on (u.UserProfileID = uc.UserTwo 
        and uc.UserOne = (select UserProfileID from UserProfile where UserName = 'a')
        and uc.IsConnection = 1);
     
     
    -- Problem-1 : Write a query to retreive all the followers of 'a'
    --             Note:- followers includes connections + only followers.
     
     
    -- User Posts
    -- One user can post many posts.
     
    create table Post (
        PostID   integer primary key AUTO_INCREMENT,
        Title    varchar(200) not null,
        Content  text not null,
        PostedBy integer not null,
        PostedDTTM datetime not null default now(),
        constraint fk_postedby foreign key(PostedBy) references UserProfile(UserProfileID)
    );
     
    insert into Post(Title, Content, PostedBy)
    values('SamplePost','Sample Post Content', 1);
     
    select * from Post;
     
    -- Post likes
     
    create table PostLike (
        PostLikeID integer primary key AUTO_INCREMENT,
        PostID     integer not null,
        LikedBy    integer not null,
        ActionDTTM datetime not null default now(),
        constraint fk_postid foreign key(PostID) references Post(PostID),
        constraint fk_likedby foreign key(LikedBy) references UserProfile(UserProfileID),
        constraint unq_postid_likedby unique(PostID, LikedBy)
    );
     
    insert into PostLike(PostID, LikedBy)
    values(1, 2);
     
    insert into PostLike(PostID, LikedBy)
    values(1, 3);
     
    select * from PostLike;
     
     
    -- Post Comment
     
    create table PostComment (
        PostCommentID integer primary key AUTO_INCREMENT,
        PostID        integer not null,
        CommentForCommentID  integer,
        CommentText   text not null,
        CommentedBy   integer not null,
        CommentedDTTM datetime not null default now(),
        constraint fk_postid_postcomment foreign key(PostID) references Post(PostID),
        constraint fk_commentedby foreign key(CommentedBy) references UserProfile(UserProfileID),
        constraint fk_comment_for_comment foreign key(CommentForCommentID) 
                                          references PostComment(PostCommentID) 
    );
     
    insert into PostComment(PostID, CommentText, CommentedBy)
    values(1, 'good post', 2);
     
    insert into PostComment(PostID, CommentForCommentID, CommentText, CommentedBy)
    values(1, 1, 'well said', 3);
     
    select * from PostComment;
     
    -- retrieve the posts posted by 'a'
     
    select * from Post
    where PostedBy = (select UserProfileID from UserProfile where username = 'a');
     
    -- retrieve the no of likes for postID - 1
     
    select count(*) from PostLike 
    where PostID = 1;
     
     
    -- Problem - 2
     
    -- Design tables for User Experience, Publications, Skills, Endorsements.
     
    -- Experience(UserProfileID, CompanyName, StartDate, EndDate, JobTitle, JD )
    -- Publication(UserProfileID, Url, PublishedDate, Title, Description)
    -- Skill(UserProfileID, SkillName)
    -- SkillEndorsement(SkilID, EndorsedBy)
     
    -- Problem - 3
     
    -- 1) Display the total likes for the posts posted by 'a'
    -- 2) Display the PostID and Likes count for the posts posted by 'a'
    -- 3) Display the name of the user with maximum post likes.
    -- 4) Display the users with maximum posts*/
 