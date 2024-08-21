
-- Alter table

-- Select the Database.

    USE DemoDB;

-- Create 

    CREATE TABLE UserProfile(
        UserProfileID   INT IDENTITY(1,1) PRIMARY KEY,
        Username      VARCHAR(50) NOT NULL,
        CompanyCode   VARCHAR(50) NOT NULL,
        Email             VARCHAR(50) NOT NULL,
        CreatedDTTM   DATETIME NOT NULL,
        CONSTRAINT unq_userprofile_usercompany  UNIQUE(UserName, CompanyCode),
        CONSTRAINT unq_userprofile_emailcompany UNIQUE(CompanyCode, Email)
    );

-- Test data
    
    INSERT INTO UserProfile(Username, CompanyCode, Email, CreatedDTTM)
    VALUES('A','C1', 'a@test.com', GETDATE() );
    
    INSERT INTO UserProfile(Username, CompanyCode, Email, CreatedDTTM)
    VALUES('A','C2', 'a@test.com', GETDATE() );

    SELECT * FROM UserProfile;
    
    SP_HELP UserProfile;

-- Alter table

    -- Adding column
    
        ALTER TABLE UserProfile
        ADD Active BIT NOT NULL DEFAULT 1;
        
    -- Modifying column
    
        ALTER TABLE UserProfile
        ALTER COLUMN Email VARCHAR(150) NOT NULL;
    
    -- Deleting column
    
        ALTER TABLE UserProfile
        DROP COLUMN Active;

-- Drop table 

    DROP TABLE UserProfile;