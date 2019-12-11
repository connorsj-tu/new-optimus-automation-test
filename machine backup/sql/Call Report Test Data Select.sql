BEGIN TRANSACTION;

declare @LoadId varchar(6);
declare @LoadId2 varchar(6);

set @LoadId = '202979';
set @LoadId2 = '202979';


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
select top 100 * from dbo.tblDomicile where ProcessId = 500048
select top 100 * from dbo.tblResidence where ProcessId = 500048
select top 100 * from dbo.tblAddressLink where ProcessId = 500048
select top 100 * from dbo.tblAddressLinkSource where ProcessId = 500048



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



SELECT count(*) FROM [Primary1].[dbo].tblPerson

SELECT TOP 100 * FROM [Primary1].[dbo].tblPerson
order by PersonId DESC

SELECT * FROM 
[Primary1].Matching.tblKey1
where ResidenceId = 219264187


SELECT TOP 10 * FROM [Primary1].[dbo].tblPerson
where Forename = 'OSCAR' and Surname = 'POODLE'


SELECT dom.HouseNum, dom.Street1, res.* FROM [Primary1].[dbo].tblResidence res
INNER JOIN [Primary1].[dbo].tblDomicile dom
	on res.DomicileId = dom.DomicileId
Where PersonId = 2147483054
and dom.HouseNum = 91

2147483054

SELECT als.Implied, als.DataOrigin, al.* FROM [Primary1].[dbo].tblAddressLinkSource als
INNER JOIN [Primary1].[dbo].tblAddressLink al
	on al.AddLinkId = als.AddLinkId
where al.ResId in
(124190188,
184275195,
184275198,
184275196,
2147483054)
or
al.LinkResId in 
(124190188,
184275195,
184275198,
184275196,
2147483054)

SELECT als.* FROM [Primary1].[dbo].tblAddressLinkSource als
INNER JOIN [Primary1].[dbo].tblAddressLink al
	on al.AddLinkId = als.AddLinkId
where al.ResId in
(124190188,
184275195,
184275198,
184275196,
2147483054)
or
al.LinkResId in 
(124190188,
184275195,
184275198,
184275196,
2147483054)

SELECT * FROM [Primary1].[dbo].tblAddressLink
where ResId in
(124190188,
184275195,
184275198,
184275196,
2147483054)
or
LinkResId in 
(124190188,
184275195,
184275198,
184275196,
2147483054)

[Primary1].[dbo].tblAddressLinkSource

SELECT TOP 10 * FROM [Primary1].[dbo].tblAddressLinkSource Where ProcessId LIKE @LoadId;
SELECT TOP 10 * FROM [Primary1].[dbo].tblAddressLink Where ProcessId LIKE @LoadId;
Where ProcessId LIKE @LoadId;
SELECT TOP 10 * FROM [Primary1].[dbo].tblPerson Where ProcessId LIKE @LoadId;
SELECT TOP 10 * FROM [Primary1].[dbo].tblIndividual Where ProcessId LIKE @LoadId;
SELECT TOP 10 * FROM [Primary1].[dbo].tblDomicile Where ProcessId LIKE @LoadId;
SELECT TOP 10 * FROM [Primary1].[dbo].tblLocality Where ProcessId LIKE @LoadId;



--select top 1000 * from [Primary1].[dbo].tblAddressLink where ProcessId like '500%'
--select distinct Member_PortId from [Primary1].[dbo].tblAddressLink where ProcessId like '500%'


select * from [Primary1].[dbo].tblResidence
where ULoadId = 395435

update [Primary1].[dbo].tblResidence
set DomicileId = 41198878 
, CLoadId = 395435
, ULoadId = 395435
, UProcId = 395435
where ResidenceId = 219263061


UPDATE [Primary1].[dbo].tblShAccHolder 
SET DtSrcForename = 'MEERA H'
WHERE DtSrcForename = 'MEERA'
AND ProcessId LIKE 202940;

UPDATE [Primary1].[dbo].tblPerson
SET Forename = 'MEERA H'
WHERE Forename = 'MEERA'
AND ProcessId LIKE 202940;*/


SELECT * FROM [Primary1].[dbo].tblShAccHolder where ProcessId LIKE 202979;
SELECT * FROM [Primary1].[dbo].tblPerson where ProcessId LIKE 202979;

select distinct TitleId from [Primary1].[dbo].tblPerson;


UPDATE [Primary1].[dbo].tblShAccHolder 
SET DtSrcTitle = ''
WHERE DtSrcTitle= 'MRS'
AND ProcessId LIKE 202979;




UPDATE [Primary1].[dbo].tblPerson
SET TitleId = 1
WHERE TitleId= 3
AND ProcessId LIKE 202979;


