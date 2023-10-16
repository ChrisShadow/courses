
-- Transactions

-- Select the Database.

	USE DemoDB;

-- Create 

	CREATE TABLE Account(
		AccountID  	INT PRIMARY KEY IDENTITY(1,1),
        Name	  	VARCHAR(50)   NOT NULL,
		Balance	  	NUMERIC(10,2) NOT NULL
	);

-- Insert test data
    
    INSERT INTO Account(Name, Balance)
    VALUES('A', 2000 );

    INSERT INTO Account(Name, Balance)
    VALUES('B', 2000 );

	SELECT * FROM Account;

-- Transactions 

	-- Transfer amount from account 1 to 2.

	BEGIN TRANSACTION ; 

		UPDATE Account 
        SET Balance = Balance - 500 
        WHERE AccountID = 1;

        UPDATE Account 
        SET Balance = Balance + 500 
        WHERE AccountID = 2;

	ROLLBACK;
		
        -- OR

	COMMIT;
    
    SELECT * FROM Account;

-- Transactions with save point

	BEGIN TRANSACTION ;
	
	SAVE TRANSACTION point1;
        
        INSERT INTO Account(Name, Balance)
		VALUES('C', 2000 );

	SAVE TRANSACTION point2;

		UPDATE Account 
        SET Balance = Balance - 500 
        WHERE AccountID = 1;
        

        UPDATE Account 
        SET Balance = Balance + 500 
        WHERE AccountID = 2;

	ROLLBACK TRANSACTION point2;

        -- OR
        
	COMMIT;

-- Drop 

    DROP TABLE Account;