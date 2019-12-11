/****** Script for SelectTopNRows command from SSMS  ******/
SELECT TOP (1000) [LocalityId]
      ,[SubLocality]
      ,[Locality]
      ,[Town]
      ,[Deleted]
      ,[CLoadId]
      ,[ULoadId]
  FROM [CCRMain].[dbo].[Locality]
  ORDER BY 1 DESC

Select top (10) * from dbo.Locality order by 1 DESC

SELECT * FROM 
dbo.Locality
Where SubLocality = 'Leeds'
AND Locality = 'Leeds'

SELECT * FROM 
dbo.Locality
Where LocalityId = '1009952'

SELECT * FROM 
dbo.Locality L,
dbo.Domicile D,
dbo.Person P,
dbo.Residence R
Where L.ULoadId = 654321
OR L.ULoadId = 654321 OR D.ULoadId = 654321 OR P.ULoadId = 654321 or R.ULoadId = 654321

insert into dbo.CCJCase                                                                                                                                                                                                                                        
(CourtId,PersonsInvolved,CaseNumber,CCJTypeId,Country,Deleted,CLoadId,CSrcId,ULoadId,USrcId,UProcId,CaseKey,Displayed,HCJ)
VALUES ('123', 'S', 'ABC115', '1', '', 'false', '654321', '1', '654321', '1', NULL, '201801020000115', 'true', null)


Insert into dbo.Locality (SubLocality, Locality, Town, Deleted, CLoadId, ULoadId)
VALUES('Leeds', 'LEEDS', 'LEEDS', 0, 654321, 654321)
commit;

Insert into dbo.Domicile (PafStatus,POBox,Abode,HouseNum,HouseName,Street1,Street2,LocalityId,Postcode,csPostcode,DPS,BFPO,Deleted,CLoadId,CSrcId,ULoadId,USrcId,UProcId)
VALUES('PXYXXTA000A9', '', '', '7', '', 'DERBYSHIRE ROAD','','98573', 'M33 3EB', '1224815872', '1Y', '0', 'FALSE', '654321', '1', '654321', '1', NULL)


declare @LoadId varchar(6)
set @LoadId = '654321'

SELECT * FROM 
dbo.Locality
Where ULoadId = @LoadId

SELECT * FROM 
dbo.Domicile
Where ULoadId = @LoadId

SELECT * FROM 
dbo.Individual
Where ULoadId = @LoadId

SELECT * FROM 
dbo.Person P
Where ULoadId = @LoadId

SELECT * FROM 
dbo.Residence
Where ULoadId = @LoadId

SELECT * FROM 
dbo.AddressLink
Where ULoadId = @LoadId







##########


BEGIN TRANSACTION

declare @LoadId varchar(6)
declare @LoadId2 varchar(6)

set @LoadId = '654321'
set @LoadId2 = '654322'

UPDATE
dbo.AddressLinkSource
SET Deleted = 1, ULoadId = @LoadId2
Where ULoadId = @LoadId

UPDATE
dbo.AddressLink
SET Deleted = 1, ULoadId = @LoadId2
Where ULoadId = @LoadId

UPDATE
dbo.Residence
SET Deleted = 1, ULoadId = @LoadId2
Where ULoadId = @LoadId

UPDATE
dbo.Person
SET Deleted = 1, ULoadId = @LoadId2
Where ULoadId = @LoadId

UPDATE
dbo.Individual
SET Deleted = 1, ULoadId = @LoadId2
Where ULoadId = @LoadId

UPDATE
dbo.Domicile
SET Deleted = 1, ULoadId = @LoadId2
Where ULoadId = @LoadId

UPDATE
dbo.Locality
SET Deleted = 1, ULoadId = @LoadId2
Where ULoadId = @LoadId

commit



BEGIN TRANSACTION

DELETE FROM
dbo.AddressLinkSource
Where ULoadId = @LoadId2

DELETE FROM
dbo.AddressLink
Where ULoadId = @LoadId2

DELETE FROM
dbo.Residence
Where ULoadId = @LoadId2

DELETE FROM 
dbo.Person
Where ULoadId = @LoadId2

DELETE FROM
dbo.Individual
Where ULoadId = @LoadId2

DELETE FROM 
dbo.Domicile
Where ULoadId = @LoadId2

DELETE FROM 
dbo.Locality
Where ULoadId = @LoadId2

commit;




@@@@@@@@


BEGIN TRANSACTION

declare @LoadId varchar(6)
declare @LoadId2 varchar(6)

set @LoadId = '654321'
set @LoadId2 = '654322'

UPDATE dbo.Locality SET Deleted = 1, ULoadId = @LoadId2 Where ULoadId = @LoadId;
UPDATE dbo.Domicile SET Deleted = 1, ULoadId = @LoadId2 Where ULoadId = @LoadId;
UPDATE dbo.Person SET Deleted = 1, ULoadId = @LoadId2 Where ULoadId = @LoadId;
UPDATE dbo.Residence SET Deleted = 1, ULoadId = @LoadId2 Where ULoadId = @LoadId;
UPDATE dbo.AddressLink SET Deleted = 1, ULoadId = @LoadId2 Where ULoadId = @LoadId;
UPDATE dbo.AddressLinkSource SET Deleted = 1, ULoadId = @LoadId2 Where ULoadId = @LoadId;
UPDATE dbo.PersonAlias SET Deleted = 1, ULoadId = @LoadId2 Where ULoadId = @LoadId;
UPDATE  dbo.PersonAliasSource SET Deleted = 1, ULoadId = @LoadId2 Where ULoadId = @LoadId;
UPDATE dbo.Association SET Deleted = 1, ULoadId = @LoadId2 Where ULoadId = @LoadId;
UPDATE dbo.AssociationSource SET Deleted = 1, ULoadId = @LoadId2 Where ULoadId = @LoadId;
UPDATE dbo.CCJCase SET Deleted = 1, ULoadId = @LoadId2 Where ULoadId = @LoadId;
UPDATE  dbo.CCJCasePerson SET Deleted = 1, ULoadId = @LoadId2 Where ULoadId = @LoadId;
UPDATE dbo.CCJ SET Deleted = 1, ULoadId = @LoadId2 Where ULoadId = @LoadId;
UPDATE dbo.ER SET Deleted = 1, ULoadId = @LoadId2 Where ULoadId = @LoadId;

COMMIT;



SELECT * FROM dbo.Locality WHERE ULoadId like '65432%'