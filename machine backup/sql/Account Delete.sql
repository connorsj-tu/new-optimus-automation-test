BEGIN TRANSACTION;

DELETE FROM [CCRAccount_412335].[dbo].ShAccHolderDetails 
WHERE CLoadId = '654321';

DELETE FROM [CCRAccount_412335].[dbo].ShAccHolder 
WHERE CLoadId = '654321';

DELETE FROM [CCRAccount_412335].[dbo].ShAccFinancials 
WHERE CLoadId = '654321';

DELETE FROM [CCRAccount_412335].[dbo].AccountHistory 
WHERE CLoadId = '654321';

DELETE FROM [CCRAccount_412335].[dbo].[SharedAccount] 
WHERE CLoadId = '654321';

COMMIT;