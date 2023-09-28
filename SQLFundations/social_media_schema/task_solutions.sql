
    use SocialDB;
     
    -- Problem 1
    select UserName from UserProfile
    where UserProfileID in ( 
    	select UserTwo from UserConnections
            where UserOne = 1 
    );
     
    -- Problem 2
    create table Experience(
       ExperienceID integer primary key auto_increment,
       UserProfileID integer not null,
       CompanyName varchar(100) not null, 
       StartDate datetime not null, 
       EndDate datetime, 
       JobTitle varchar(100), 
       JD text,
       constraint fk_userprofileid_exp foreign key(UserProfileID) references UserProfile(UserProfileID)
    );
     
     
    create table Publication(
       PublicationID integer primary key auto_increment,
       UserProfileID integer not null,
       Url varchar(100), 
       PublishedDate date, 
       Title varchar(100) not null, 
       Description text,
       constraint fk_userprofileid_publication foreign key(UserProfileID) 
                  references UserProfile(UserProfileID)
    ); 
     
     
    create table Skill(
      SkillID integer primary key auto_increment,
      UserProfileID integer not null,
      SkillName varchar(50) not null,
      constraint fk_userprofileid_skill foreign key(UserProfileID) 
                                        references UserProfile(UserProfileID),
      constraint unq_userprofileid_skill unique(UserProfileID, SkillName)
    );
     
    create table SkillEndorsement(
        SkillEndorsementID integer primary key auto_increment,
        SkillID integer not null, 
        EndorsedBy integer not null,
        constraint fk_skill_id_endorsement foreign key(SkillID) 
                                           references Skill(SkillID),
        constraint fk_endorsedby_endorsement foreign key(EndorsedBy) 
                                             references UserProfile(UserProfileID),
        constraint unq_skill_endorsment unique(SkillID, EndorsedBy)
    );