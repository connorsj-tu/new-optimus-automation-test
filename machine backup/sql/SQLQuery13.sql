select * from dbo.tblLocality

where LocalityId  ='1014414'
order by 1 desc

select max(LocalityId) from dbo.tblLocality
select max(PersonId) from dbo.tblPerson
select max(InsolvencyOrderHistoryId) from dbo.tblInsolvencyOrderHistory
select max(CCJCaseId) from dbo.tblCCJCase
select max(CCJCasePerId) from dbo.tblCCJCasePerson
select max(CCJId) from dbo.tblCCJ


dbo.tblInsolvencyOrderHistory
InsolvencyOrderHistoryId

dbo.tblCCJCase
CCJCaseId

dbo.tblCCJCasePerson
CCJCasePerId


BEGIN TRANSACTION;

declare @LoadId varchar(6);
declare @LoadId2 varchar(6);

set @LoadId = '500020';
set @LoadId2 = '500020';


SELECT * FROM [dbo].tblShAccHolder Where ProcessId LIKE @LoadId;
SELECT * FROM [dbo].tblShAccFinancials Where ProcessId LIKE @LoadId;
SELECT * FROM [dbo].tblAccountHistory Where ProcessId LIKE @LoadId;
SELECT * FROM [dbo].tblSharedAccount Where ProcessId LIKE @LoadId;

SELECT * FROM [dbo].tblER Where ProcessId LIKE @LoadId;
SELECT * FROM [dbo].tblCCJ Where ProcessId LIKE @LoadId;
SELECT * FROM [dbo].tblCCJCasePerson Where ProcessId LIKE @LoadId;
SELECT * FROM [dbo].tblCCJCase Where ProcessId LIKE @LoadId;
SELECT * FROM [dbo].tblAssociationSource Where ProcessId LIKE @LoadId;
SELECT * FROM [dbo].tblAssociation Where ProcessId LIKE @LoadId;
SELECT * FROM [dbo].tblPersonAliasSource Where ProcessId LIKE @LoadId;
SELECT * FROM [dbo].tblPersonAlias Where ProcessId LIKE @LoadId;
SELECT * FROM [dbo].tblInsolvencyOrderPerson Where ProcessId LIKE @LoadId;
SELECT * FROM [dbo].tblInsolvencyOrderAddress Where ProcessId LIKE @LoadId;
SELECT * FROM [dbo].tblInsolvencyOrder Where ProcessId LIKE @LoadId;
SELECT * FROM [dbo].tblAddressLinkSource Where ProcessId LIKE @LoadId;
SELECT * FROM [dbo].tblAddressLink Where ProcessId LIKE @LoadId;
SELECT * FROM [dbo].tblResidence Where ProcessId LIKE @LoadId;
SELECT * FROM [dbo].tblPerson Where ProcessId LIKE @LoadId;
SELECT * FROM [dbo].tblIndividual Where ProcessId LIKE @LoadId;
SELECT * FROM [dbo].tblDomicile Where ProcessId LIKE @LoadId;
SELECT * FROM [dbo].tblLocality Where ProcessId LIKE @LoadId;

