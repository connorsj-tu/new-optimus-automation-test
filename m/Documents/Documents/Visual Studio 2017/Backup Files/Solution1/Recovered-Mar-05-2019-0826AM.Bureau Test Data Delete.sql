BEGIN TRANSACTION;

declare @LoadId varchar(6);
declare @LoadId2 varchar(6);

set @LoadId = '%65432';
set @LoadId2 = '765432';

UPDATE [CCRAccount_412335].[dbo].SharedAccount SET Deleted = 1, ULoadId = @LoadId2 Where ULoadId LIKE @LoadId;
UPDATE [CCRAccount_412335].[dbo].AccountHistory SET Deleted = 1, ULoadId = @LoadId2 Where ULoadId LIKE @LoadId;
UPDATE [CCRAccount_412335].[dbo].ShAccFinancials SET Deleted = 1, ULoadId = @LoadId2 Where ULoadId LIKE @LoadId;
UPDATE [CCRAccount_412335].[dbo].ShAccHolder SET Deleted = 1, ULoadId = @LoadId2 Where ULoadId LIKE @LoadId;
UPDATE [CCRAccount_412335].[dbo].ShAccHolderDetails SET Deleted = 1, ULoadId = @LoadId2 Where ULoadId LIKE @LoadId;

UPDATE [CCRMain].[dbo].ER SET Deleted = 1, ULoadId = @LoadId2 Where ULoadId LIKE @LoadId;
UPDATE [CCRMain].[dbo].CCJ SET Deleted = 1, ULoadId = @LoadId2 Where ULoadId LIKE @LoadId;
UPDATE [CCRMain].[dbo].CCJCasePerson SET Deleted = 1, ULoadId = @LoadId2 Where ULoadId LIKE @LoadId;
UPDATE [CCRMain].[dbo].CCJCase SET Deleted = 1, ULoadId = @LoadId2 Where ULoadId LIKE @LoadId;
UPDATE [CCRMain].[dbo].AssociationSource SET Deleted = 1, ULoadId = @LoadId2 Where ULoadId LIKE @LoadId;
UPDATE [CCRMain].[dbo].Association SET Deleted = 1, ULoadId = @LoadId2 Where ULoadId LIKE @LoadId;
UPDATE [CCRMain].[dbo].PersonAliasSource SET Deleted = 1, ULoadId = @LoadId2 Where ULoadId LIKE @LoadId;
UPDATE [CCRMain].[dbo].PersonAlias SET Deleted = 1, ULoadId = @LoadId2 Where ULoadId LIKE @LoadId;
UPDATE [CCRMain].[dbo].AddressLinkSource SET Deleted = 1, ULoadId = @LoadId2 Where ULoadId LIKE @LoadId;
UPDATE [CCRMain].[dbo].AddressLink SET Deleted = 1, ULoadId = @LoadId2 Where ULoadId LIKE @LoadId;
UPDATE [CCRMain].[dbo].Residence SET Deleted = 1, ULoadId = @LoadId2 Where ULoadId LIKE @LoadId;
UPDATE [CCRMain].[dbo].Person SET Deleted = 1, ULoadId = @LoadId2 Where ULoadId LIKE @LoadId;
UPDATE [CCRMain].[dbo].Individual SET Deleted = 1, ULoadId = @LoadId2 Where ULoadId LIKE @LoadId;
UPDATE [CCRMain].[dbo].Domicile SET Deleted = 1, ULoadId = @LoadId2 Where ULoadId LIKE @LoadId;
UPDATE [CCRMain].[dbo].Locality SET Deleted = 1, ULoadId = @LoadId2 Where ULoadId LIKE @LoadId;

COMMIT;

BEGIN TRANSACTION;

DELETE FROM [CCRAccount_412335].[dbo].ShAccHolderDetails WHERE ULoadId LIKE @LoadId;
DELETE FROM [CCRAccount_412335].[dbo].ShAccHolder WHERE ULoadId LIKE @LoadId;
DELETE FROM [CCRAccount_412335].[dbo].ShAccFinancials WHERE ULoadId LIKE @LoadId;
DELETE FROM [CCRAccount_412335].[dbo].AccountHistory WHERE ULoadId LIKE @LoadId;
DELETE FROM [CCRAccount_412335].[dbo].SharedAccount WHERE ULoadId LIKE @LoadId;

DELETE FROM [CCRMain].[dbo].ERSrc WHERE LoadId LIKE @LoadId;
DELETE FROM [CCRMain].[dbo].ER WHERE ULoadId LIKE @LoadId;
DELETE FROM [CCRMain].[dbo].CCJ WHERE ULoadId LIKE @LoadId;
DELETE FROM [CCRMain].[dbo].CCJCasePerson WHERE ULoadId LIKE @LoadId;
DELETE FROM [CCRMain].[dbo].CCJCase WHERE ULoadId LIKE @LoadId;
DELETE FROM [CCRMain].[dbo].AssociationSource WHERE ULoadId LIKE @LoadId;
DELETE FROM [CCRMain].[dbo].Association WHERE ULoadId LIKE @LoadId;
DELETE FROM [CCRMain].[dbo].PersonAliasSource WHERE ULoadId LIKE @LoadId;
DELETE FROM [CCRMain].[dbo].PersonAlias WHERE ULoadId LIKE @LoadId;
DELETE FROM [CCRMain].[dbo].InsolvencyOrderHistory WHERE ULoadId LIKE @LoadId;
DELETE FROM [CCRMain].[dbo].InsolvencyOrderPerson WHERE ULoadId LIKE @LoadId;
DELETE FROM [CCRMain].[dbo].InsolvencyOrderAddress WHERE ULoadId LIKE @LoadId;
DELETE FROM [CCRMain].[dbo].InsolvencyOrder WHERE ULoadId LIKE @LoadId;
DELETE FROM [CCRMain].[dbo].AddressLinkSource WHERE ULoadId LIKE @LoadId;
DELETE FROM [CCRMain].[dbo].AddressLink WHERE ULoadId LIKE @LoadId;
DELETE FROM [CCRMain].[dbo].Residence WHERE ULoadId LIKE @LoadId;
DELETE FROM [CCRMain].[dbo].Person WHERE ULoadId LIKE @LoadId;
DELETE FROM [CCRMain].[dbo].Individual WHERE ULoadId LIKE @LoadId;
DELETE FROM [CCRMain].[dbo].Domicile WHERE ULoadId LIKE @LoadId;
DELETE FROM [CCRMain].[dbo].Locality WHERE ULoadId LIKE @LoadId;

COMMIT;


--declare @LoadId varchar(6);
--set @LoadId = '654322';
--Select TOP 18 InsolvencyOrderId FROM [CCRMain].dbo.InsolvencyOrder WHERE CLoadId = @LoadId ORDER BY InsolvencyOrderId DESC 

DELETE FROM [CCRMain].[dbo].InsolvencyOrder
WHERE InsolvencyOrderId >= 1714924 

DELETE FROM [CCRMain].[dbo].InsolvencyOrderAddress
WHERE InsolvencyOrderId >= 1714924 

DELETE FROM [CCRMain].[dbo].InsolvencyOrderPerson
WHERE InsolvencyOrderId >= 1714924 

SELECT COUNT(*) FROM [CCRMain].[dbo].InsolvencyOrder
WHERE InsolvencyOrderId >= 1714924 

SELECT COUNT(*) FROM [CCRMain].[dbo].InsolvencyOrderAddress
WHERE InsolvencyOrderId >= 1714924 

SELECT COUNT(*) FROM [CCRMain].[dbo].InsolvencyOrderPerson
WHERE InsolvencyOrderId >= 1714924 

