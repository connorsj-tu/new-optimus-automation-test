UPDATE [CCRMain].[dbo].Person 
SET TitleId = 1
WHERE TitleId= 3
AND ULoadId LIKE 202979;


UPDATE [CCRAccount_412335].[dbo].ShAccHolderDetails 
SET SrcTitle = ''
WHERE SrcTitle= 'MRS'
AND ULoadId LIKE 202979;


