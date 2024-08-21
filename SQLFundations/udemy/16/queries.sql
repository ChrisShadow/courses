Use demodb;
-- Constraints over multiple columns
create table user_prof(
	user_profile_id int primary key not null auto_increment,
    user_name varchar(50) not null, 
    company_code varchar(50) not null,
    email varchar(50) not null,
    created_dtm datetime not null,
    constraint uq_user_prof_user_comp UNIQUE(user_name, company_code)
);

-- Success
INSERT INTO `UserProfile`(`Username`, `CompanyCode`, `Email`, `CreatedDTTM`)
VALUES('A','COMPANY1', 'a@test.com', NOW() );
 
-- Success; because here the company code is COMPANY2 hence unique constraint is not violated.
INSERT INTO `UserProfile`(`Username`, `CompanyCode`, `Email`, `CreatedDTTM`)
VALUES('A','COMPANY2', 'a@test.com', NOW() );
    
-- Fails; because ('A','COMPANY1') already exists in the table.
INSERT INTO `UserProfile`(`Username`, `CompanyCode`, `Email`, `CreatedDTTM`)
VALUES('A','COMPANY1', 'x@test.com', NOW() );
    
-- Fails; because ('COMPANY1','a@test.com') already exists in the table.
INSERT INTO `UserProfile`(`Username`, `CompanyCode`, `Email`, `CreatedDTTM`)
VALUES('B','COMPANY1', 'a@test.com', NOW() );
