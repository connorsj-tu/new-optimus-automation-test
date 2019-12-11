BEGIN TRANSACTION;

declare @LoadId varchar(6);
declare @LoadId2 varchar(6);

set @LoadId = '500046';
set @LoadId2 = '500046';


SELECT * FROM [Primary1].[dbo].tblShAccHolder Where ProcessId LIKE @LoadId;
SELECT * FROM [Primary1].[dbo].tblShAccFinancials Where ProcessId LIKE @LoadId;
SELECT * FROM [Primary1].[dbo].tblAccountHistory Where ProcessId LIKE @LoadId;
SELECT * FROM [Primary1].[dbo].tblSharedAccount Where ProcessId LIKE @LoadId;

SELECT * FROM [Primary1].[dbo].tblER Where ProcessId LIKE @LoadId;
SELECT * FROM [Primary1].[dbo].tblCCJ Where ProcessId LIKE @LoadId;
SELECT * FROM [Primary1].[dbo].tblCCJCasePerson Where ProcessId LIKE @LoadId;
SELECT * FROM [Primary1].[dbo].tblCCJCase Where ProcessId LIKE @LoadId;
SELECT * FROM [Primary1].[dbo].tblAssociationSource Where ProcessId LIKE @LoadId;
SELECT * FROM [Primary1].[dbo].tblAssociation Where ProcessId LIKE @LoadId;
SELECT * FROM [Primary1].[dbo].tblPersonAliasSource Where ProcessId LIKE @LoadId;
SELECT * FROM [Primary1].[dbo].tblPersonAlias Where ProcessId LIKE @LoadId;
SELECT * FROM [Primary1].[dbo].tblInsolvencyOrderPerson Where ProcessId LIKE @LoadId;
SELECT * FROM [Primary1].[dbo].tblInsolvencyOrderAddress Where ProcessId LIKE @LoadId;
SELECT * FROM [Primary1].[dbo].tblInsolvencyOrder Where ProcessId LIKE @LoadId;
SELECT * FROM [Primary1].[dbo].tblAddressLinkSource Where ProcessId LIKE @LoadId;
SELECT * FROM [Primary1].[dbo].tblAddressLink Where ProcessId LIKE @LoadId;
SELECT * FROM [Primary1].[dbo].tblResidence Where ProcessId LIKE @LoadId;
SELECT * FROM [Primary1].[dbo].tblPerson Where ProcessId LIKE @LoadId;
SELECT * FROM [Primary1].[dbo].tblIndividual Where ProcessId LIKE @LoadId;
SELECT * FROM [Primary1].[dbo].tblDomicile Where ProcessId LIKE @LoadId;
SELECT * FROM [Primary1].[dbo].tblLocality Where ProcessId LIKE @LoadId;


COMMIT;

/*

select * from dbo.tblAddressLinkSource
where ProcessId in (500045, 500036)

update dbo.tblAddressLinkSource
set DataOrigin = 1
where SourceId < 113638870
and ProcessId LIKE 500045

update dbo.tblAddressLinkSource
set DataOrigin = 0
where SourceId >= 113638870
and ProcessId LIKE 500045

*/