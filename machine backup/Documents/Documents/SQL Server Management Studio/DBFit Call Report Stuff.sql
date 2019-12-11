/****** Script for SelectTopNRows command from SSMS  ******/
SELECT TOP (1000) [LocalityId]
      ,[SubLocality]
      ,[Locality]
      ,[Town]
      ,[ProcessId]
  FROM [Primary1].[dbo].[tblLocality]


SELECT DISTINCT ProcessId
  FROM [Primary1].[dbo].[tblLocality]
  ORDER BY 1 DESC

-- #######

Insert into dbo.tblLocality (LocalityId, SubLocality, Locality, Town, ProcessId)
VALUES(654321, 'Leeds', 'LEEDS', 'LEEDS', 654321)

Insert into dbo.tblLocality (LocalityId, SubLocality, Locality, Town, ProcessId)
VALUES(654321, 'Leeds', 'LEEDS', 'LEEDS', 654321)


--#######

SELECT * FROM dbo.tblLocality 
WHERE ProcessId = 654321

SELECT * FROM dbo.tblDomicile
WHERE ProcessId = 654321

SELECT * FROM dbo.tblIndividual
WHERE ProcessId = 654321

SELECT * FROM dbo.tblPerson
WHERE ProcessId = 654321

SELECT * FROM dbo.tblResidence
WHERE ProcessId = 654321

SELECT * FROM dbo.tblAddressLink
WHERE ProcessId = 654321

SELECT * FROM dbo.tblAddressLinkSource
WHERE ProcessId = 654321
--#######

BEGIN TRANSACTION

DELETE FROM dbo.tblLocality 
WHERE ProcessId = 654321

DELETE FROM dbo.tblDomicile
WHERE ProcessId = 654321

DELETE FROM dbo.tblIndividual
WHERE ProcessId = 654321

DELETE FROM dbo.tblPerson
WHERE ProcessId = 654321

DELETE FROM dbo.tblResidence
WHERE ProcessId = 654321

DELETE FROM dbo.tblAddressLink
WHERE ProcessId = 654321

DELETE FROM dbo.tblAddressLinkSource
WHERE ProcessId = 654321
commit;
--#######





--#######





--#######