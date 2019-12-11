BEGIN TRANSACTION;

declare @LoadId varchar(6);
declare @LoadId2 varchar(6);

set @LoadId = '500050';
set @LoadId2 = '500050';

--select top 100 * FROM [Primary1].[dbo].tblDomicile Where ProcessId LIKE '5000%';


UPDATE [Primary1].[dbo].tblER SET Deleted = 1 Where ProcessId LIKE @LoadId;
UPDATE [Primary1].[dbo].tblAssociationSource SET Deleted = 1 Where ProcessId LIKE @LoadId;
UPDATE [Primary1].[dbo].tblAssociation SET Deleted = 1 Where ProcessId LIKE @LoadId;
UPDATE [Primary1].[dbo].tblPersonAliasSource SET Deleted = 1 Where ProcessId LIKE @LoadId;
UPDATE [Primary1].[dbo].tblPersonAlias SET Deleted = 1 Where ProcessId LIKE @LoadId;
UPDATE [Primary1].[dbo].tblAddressLinkSource SET Deleted = 1 Where ProcessId LIKE @LoadId;
UPDATE [Primary1].[dbo].tblAddressLink SET Deleted = 1 Where ProcessId LIKE @LoadId;
UPDATE [Primary1].[dbo].tblResidence SET Deleted = 1 Where ProcessId LIKE @LoadId;

COMMIT;

BEGIN TRANSACTION;



DELETE FROM [Primary1].[dbo].tblShAccHolder Where ProcessId LIKE @LoadId;
DELETE FROM [Primary1].[dbo].tblShAccFinancials Where ProcessId LIKE @LoadId;
DELETE FROM [Primary1].[dbo].tblAccountHistory Where ProcessId LIKE @LoadId;
DELETE FROM [Primary1].[dbo].tblSharedAccount Where ProcessId LIKE @LoadId;

DELETE FROM [Primary1].[dbo].tblER Where ProcessId LIKE @LoadId;
DELETE FROM [Primary1].[dbo].tblCCJ Where ProcessId LIKE @LoadId;
DELETE FROM [Primary1].[dbo].tblCCJCasePerson Where ProcessId LIKE @LoadId;
DELETE FROM [Primary1].[dbo].tblCCJCase Where ProcessId LIKE @LoadId;
DELETE FROM [Primary1].[dbo].tblAssociationSource Where ProcessId LIKE @LoadId;
DELETE FROM [Primary1].[dbo].tblAssociation Where ProcessId LIKE @LoadId;
DELETE FROM [Primary1].[dbo].tblPersonAliasSource Where ProcessId LIKE @LoadId;
DELETE FROM [Primary1].[dbo].tblPersonAlias Where ProcessId LIKE @LoadId;
DELETE FROM [Primary1].[dbo].tblInsolvencyOrderHistory Where ProcessId LIKE @LoadId;
DELETE FROM [Primary1].[dbo].tblInsolvencyOrderPerson Where ProcessId LIKE @LoadId;
DELETE FROM [Primary1].[dbo].tblInsolvencyOrderAddress Where ProcessId LIKE @LoadId;
DELETE FROM [Primary1].[dbo].tblInsolvencyOrder Where ProcessId LIKE @LoadId;
DELETE FROM [Primary1].[dbo].tblAddressLinkSource Where ProcessId LIKE @LoadId;
DELETE FROM [Primary1].[dbo].tblAddressLink Where ProcessId LIKE @LoadId;
DELETE FROM [Primary1].[dbo].tblResidence Where ProcessId LIKE @LoadId;
DELETE FROM [Primary1].[dbo].tblPerson Where ProcessId LIKE @LoadId;
DELETE FROM [Primary1].[dbo].tblIndividual Where ProcessId LIKE @LoadId;
DELETE FROM [Primary1].[dbo].tblDomicile Where ProcessId LIKE @LoadId;
DELETE FROM [Primary1].[dbo].tblLocality Where ProcessId LIKE @LoadId;

--MODA
DELETE FROM [Focus].[dbo].[Account] Where CreateLoadId LIKE @LoadId;

COMMIT;



--select max(PersonId) from  [Primary1].[dbo].tblPerson