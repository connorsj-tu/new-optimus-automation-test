BEGIN TRANSACTION;

declare @LoadId varchar(6);
declare @LoadId2 varchar(6);

set @LoadId = '500200';
set @LoadId2 = '500200';

SELECT * FROM [CCRMain].[dbo].ERSrc WHERE LoadId LIKE @LoadId;
SELECT * FROM [CCRMain].[dbo].ER WHERE ULoadId LIKE @LoadId;
SELECT * FROM [CCRMain].[dbo].CCJ WHERE ULoadId LIKE @LoadId;
SELECT * FROM [CCRMain].[dbo].CCJCasePerson WHERE ULoadId LIKE @LoadId;
SELECT * FROM [CCRMain].[dbo].CCJCase WHERE ULoadId LIKE @LoadId;
SELECT * FROM [CCRMain].[dbo].AssociationSource WHERE ULoadId LIKE @LoadId;
SELECT * FROM [CCRMain].[dbo].Association WHERE ULoadId LIKE @LoadId;
SELECT * FROM [CCRMain].[dbo].PersonAliasSource WHERE ULoadId LIKE @LoadId;
SELECT * FROM [CCRMain].[dbo].PersonAlias WHERE ULoadId LIKE @LoadId;
SELECT * FROM [CCRMain].[dbo].InsolvencyOrderPerson WHERE ULoadId LIKE @LoadId;
SELECT * FROM [CCRMain].[dbo].InsolvencyOrderAddress WHERE ULoadId LIKE @LoadId;
SELECT * FROM [CCRMain].[dbo].InsolvencyOrder WHERE ULoadId LIKE @LoadId;
SELECT * FROM [CCRMain].[dbo].AddressLinkSource WHERE ULoadId LIKE @LoadId;
SELECT * FROM [CCRMain].[dbo].AddressLink WHERE ULoadId LIKE @LoadId;
SELECT * FROM [CCRMain].[dbo].Residence WHERE ULoadId LIKE @LoadId;
SELECT * FROM [CCRMain].[dbo].Person WHERE ULoadId LIKE @LoadId;
SELECT * FROM [CCRMain].[dbo].Individual WHERE ULoadId LIKE @LoadId;
SELECT * FROM [CCRMain].[dbo].Domicile WHERE ULoadId LIKE @LoadId;
SELECT * FROM [CCRMain].[dbo].Locality WHERE ULoadId LIKE @LoadId;

COMMIT;



UPDATE [CCRMain].[dbo].Person 
SET Forename = 'MEERA H'
WHERE Forename = 'MEERA'
AND ULoadId LIKE 202940;

UPDATE [PrimarySource].[dbo].tblShAccHolder 
SET DtSrcTitle = ''
WHERE DtSrcTitle= 'MRS'
AND ProcessId LIKE 202979;

select * from [PrimarySource].[dbo].tblShAccHolder 
where  ProcessId LIKE 202979;
/*
BEGIN TRANSACTION;

declare @LoadId varchar(6);
declare @LoadId2 varchar(6);

set @LoadId = '295499';
set @LoadId2 = '295499';
SELECT * FROM [CCRMain].[dbo].Person
WHERE Surname = 'BOTTLE'


*/

select top 100 * from  [CCRMain].dbo.Person
order by PersonId DESC

SET IDENTITY_INSERT [CCRMain].[dbo].Person ON
update [CCRMain].dbo.Person set PersonId = -1 where PersonId = 2147483647
SET IDENTITY_INSERT [CCRMain].[dbo].Person OFF


select * from CCRMain.dbo.Residence
--where ULoadId = 395435
where PersonId = 2147483644

select * from CCRMain.dbo.Domicile
where DomicileId = 41200175

select * from CCRMain.dbo.Address
--where ULoadId = 395435
where PersonId = 2147483644


update CCRMain.dbo.Residence
set DomicileId = 41198878
, CLoadId = 395435
, ULoadId = 395435
, UProcId = 395435
where ResidenceId = 219263061

Select TOP 100 * FROM [Matching].[Key1] 
where ResidenceId in (219263058,
219263059,
219263060,
219263061)
ORDER BY ResidenceId DESC

