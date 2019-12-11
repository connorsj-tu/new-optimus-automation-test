BEGIN TRANSACTION;

declare @LoadId varchar(6);
declare @LoadId2 varchar(6);

set @LoadId = '%65432';
set @LoadId2 = '%65432';


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

SELECT * FROM [Primary1].[dbo].tblAddressLink where ProcessId like '65432%' 

SELECT * FROM [Primary1].[dbo].tblAddressLink where ProcessId like '%5432%' 
UPDATE [Primary1].[dbo].tblAddressLink
SET CreationDate = '2018-08-24 00:00:00.000', UpdateDate = '2018-08-24 00:00:00.000'
where ProcessId = '165432' 

UPDATE [Primary1].[dbo].tblAssociation
SET CreationDate = '2018-08-24 00:00:00.000', UpdateDate = '2018-08-24 00:00:00.000'
where ProcessId = '165432' 

UPDATE [Primary1].[dbo].tblPersonAlias
SET CreationDate = '2018-08-24 00:00:00.000', UpdateDate = '2018-08-24 00:00:00.000'
where ProcessId = '165432' 


SELECT * FROM [Primary1].[dbo].tblLocality where ProcessId like '%5432%' 
SELECT * FROM [Primary1].[dbo].tblDomicile Where Postcode like 'SK6%' order by Postcode csPostcode = '1224815872'

SELECT * FROM [Primary1].[dbo].tblDomicile Where ProcessId like '%5432%' order by Postcode

SELECT * FROM [Primary1].[dbo].tblAssociation WHERE ProcessId = 654321 order by CreationDate ASC
SELECT * FROM [Primary1].[dbo].tblPersonAlias WHERE ProcessId = 654321 order by CreationDate ASC
SELECT * FROM [Primary1].[dbo].tblAddressLink WHERE ProcessId = 654321 order by CreationDate ASC


SELECT MAX(CreationDate) FROM [Primary1].[dbo].tblAssociation

UPDATE [Primary1].[dbo].tblAssociation 
SET CreationDate = '2018-08-24', UpdateDate = '2018-08-24'
WHERE ProcessId = 654321

UPDATE [Primary1].[dbo].tblPersonAlias 
SET CreationDate = '2018-08-24', UpdateDate = '2018-08-24'
WHERE ProcessId = 654321 

UPDATE [Primary1].[dbo].tblAddressLink
SET CreationDate = '2018-08-24', UpdateDate = '2018-08-24'
 WHERE ProcessId = 654321

===


update [Primary1].[dbo].tblAddressLinkSource set Member_PortId = '66' 
where ProcessId = @LoadId
and Member_PortId = 112

update [Primary1].[dbo].tblAddressLink set Member_PortId = '66' 
where ProcessId = @LoadId
and Member_PortId = 112

update [Primary1].[dbo].tblPersonAlias set Member_PortId = '66' 
where ProcessId = @LoadId
and Member_PortId = 112

update [Primary1].[dbo].tblAssociation set Member_PortId = '66' 
where ProcessId = @LoadId
and Member_PortId = 112

update [Primary1].[dbo].tblSharedAccount set Member_PortId = '66' 
where ProcessId = @LoadId
and Member_PortId = 112

update [Primary1].[dbo].tblAccountHistory set Member_PortId = '66' 
where ProcessId = @LoadId
and Member_PortId = 112

update [Primary1].[dbo].tblShAccFinancials set Member_PortId = '66' 
where ProcessId = @LoadId
and Member_PortId = 112

update [Primary1].[dbo].tblShAccHolder set Member_PortId = '66' 
where ProcessId = @LoadId
and Member_PortId = 112

commit;


SELECT * FROM [Primary1].[dbo].tblPersonAlias 
where ProcessId = @LoadId
and Member_PortId = 112




update [Primary1].[dbo].tblDomicile set HouseNum = '15', Street1 = 'UPPER HIBBER LANE', Postcode = 'SK6 7JQ'
WHERE DomicileId = '41123680'

update [Primary1].[dbo].tblDomicile set HouseNum = '61', Street1 = 'THE RIDGE', Postcode = 'SK6 7ER'
WHERE DomicileId = '41123680'

SELECT * FROM [Primary1].[dbo].tblDomicile 
WHERE DomicileId = '41123680'


update [Primary1].[dbo].tblAddressLink set LinkResId = '148488396' where ResId = '169068267'
update [Primary1].[dbo].tblAddressLink set LinkResId = '169068268' where ResId = '169068267'


