-- Transaction
---	Fund Transfer
--		Start transaction
-- 			Debit
--			Credit
--		Commit/rollback

use deomdb;
-- due to absece of the table
/*
select * from account;

start transaction;

update account
set balance -= 500
where account_id=1;

update account
set balance += 500
where account_id=2;

rollback; this reverts back all the changes after the beginning of the transacction
commit; this will maje the changes permanent, whereas rollback will revert them

-- save points enable to roll back a portion of the transaction instead  of rolling back the entire one

*/

