BEGIN TRANSACTION;

declare @LoadId varchar(6);
declare @LoadId2 varchar(6);

set @LoadId = '765432';
set @LoadId2 = '765432';
SELECT * FROM [Primary1].[dbo].tblDomicile Where ProcessId = @LoadId;

SELECT * FROM [Primary1].[dbo].tblPerson 
WHERE Surname = 'ALDER' and Forename = 'BECKY'

SELECT * FROM [Primary1].[dbo].tblPerson 
WHERE Surname = 'MARS' and Forename = 'BECKY'	

SELECT * FROM [Primary1].[dbo].tblPerson 
WHERE Surname = 'MARS' and Forename = 'BECKY'
AND ProcessId like '%65432'
AND ProcessId != '654321'

SELECT * FROM [Primary1].[dbo].tblPerson 
WHERE ProcessId like '%65432'
AND ProcessId != '654321'


SELECT * FROM [Primary1].[dbo].tblResidence Where ProcessId = @LoadId;
SELECT * FROM [Primary1].[dbo].tblPerson Where ProcessId = @LoadId;
SELECT * FROM [Primary1].[dbo].tblIndividual Where ProcessId = @LoadId;
SELECT * FROM [Primary1].[dbo].tblAddressLinkSource Where ProcessId = @LoadId;
SELECT * FROM [Primary1].[dbo].tblAddressLink Where ProcessId = @LoadId;

SELECT * FROM [Primary1].[dbo].tblDomicile Where ProcessId = @LoadId;
SELECT * FROM [Primary1].[dbo].tblResidence Where ProcessId = @LoadId;
SELECT * FROM [Primary1].[dbo].tblLocality Where ProcessId = @LoadId;

update [Primary1].[dbo].tblAddressLink set LinkResId = '148488396' where ResId = '169068267'
update [Primary1].[dbo].tblAddressLink set LinkResId = '169068268' where ResId = '169068267'

select * from [Primary1].[dbo].tblAddressLink where ResId = '169068267'

update [Primary1].[dbo].tblAddressLink set LinkResId = '169068268'
select * from [Primary1].[dbo].tblAddressLink where ProcessId = '965432'


SELECT * FROM [Primary1].[dbo].tblAddressLink where ResId = '168488976'
SELECT * FROM [Primary1].[dbo].tblAddressLink where ResId = '169068267'

select * from [Primary1].[dbo].tblDomicile where DomicileId in(
SELECT * FROM [Primary1].[dbo].tblResidence Where  ResidenceId in(

168488977,
168488978,
168488975,
168488973,
168488971,
168488974,
168488972,
168488979)
)

SELECT * FROM [Primary1].[dbo].tblDomicile Where Postcode = 'SK6 7ER';
SELECT * FROM [Primary1].[dbo].tblResidence Where DomicileId = '35241397';

SELECT * FROM [Primary1].[dbo].tblResidence Where  ProcessId = '654321';

SELECT * FROM [Primary1].[dbo].tblResidence Where ProcessId = @LoadId;

SELECT * FROM [Primary1].[dbo].tblAddressLinkSource Where ProcessId = @LoadId;
SELECT * FROM [Primary1].[dbo].tblAddressLink Where ProcessId = @LoadId;

SELECT * FROM [Primary1].[dbo].tblShAccHolder Where ProcessId LIKE @LoadId;
SELECT * FROM [Primary1].[dbo].tblShAccFinancials Where ProcessId LIKE @LoadId;
SELECT * FROM [Primary1].[dbo].tblAccountHistory Where ProcessId LIKE @LoadId;
SELECT * FROM [Primary1].[dbo].tblSharedAccount Where ProcessId LIKE @LoadId;

SELECT * FROM [Primary1].[dbo].tblER Where ProcessId = @LoadId;
SELECT * FROM [Primary1].[dbo].tblCCJ Where ProcessId = @LoadId;
SELECT * FROM [Primary1].[dbo].tblCCJCasePerson Where ProcessId = @LoadId;
SELECT * FROM [Primary1].[dbo].tblCCJCase Where ProcessId = @LoadId;
SELECT * FROM [Primary1].[dbo].tblAssociationSource Where ProcessId = @LoadId;
SELECT * FROM [Primary1].[dbo].tblAssociation Where ProcessId = @LoadId;
SELECT * FROM [Primary1].[dbo].tblPersonAliasSource Where ProcessId = @LoadId;
SELECT * FROM [Primary1].[dbo].tblPersonAlias Where ProcessId = @LoadId;
SELECT * FROM [Primary1].[dbo].tblInsolvencyOrderPerson Where ProcessId = @LoadId;
SELECT * FROM [Primary1].[dbo].tblInsolvencyOrderAddress Where ProcessId = @LoadId;
SELECT * FROM [Primary1].[dbo].tblInsolvencyOrder Where ProcessId = @LoadId;
SELECT * FROM [Primary1].[dbo].tblAddressLinkSource Where ProcessId = @LoadId;
SELECT * FROM [Primary1].[dbo].tblAddressLink Where ProcessId = @LoadId;
SELECT * FROM [Primary1].[dbo].tblResidence Where ProcessId = @LoadId;
SELECT * FROM [Primary1].[dbo].tblPerson Where ProcessId = @LoadId;
SELECT * FROM [Primary1].[dbo].tblIndividual Where ProcessId = @LoadId;
SELECT * FROM [Primary1].[dbo].tblDomicile Where ProcessId = @LoadId;
SELECT * FROM [Primary1].[dbo].tblLocality Where ProcessId = @LoadId;


COMMIT;

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