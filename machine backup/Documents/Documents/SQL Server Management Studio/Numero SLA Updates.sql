/****** Script for SelectTopNRows command from SSMS  ******/
SELECT TOP (1000) [Id]
      ,[alertDate]
      ,[disputeCaseId]
      ,[ETag]
      ,[isProcessed]
      ,[_stash_changeTime]
      ,[RulesetVersion]
  FROM [Stash].[slanotifications]
  WHERE disputeCaseId in (5875, 5829, 5831)

  WHERE disputeCaseId = 1122

  -- note - db time is 1hr behind
  UPDATE [Stash].[slanotifications]
  SET alertDate ='2019-10-02T11:52:00.0000000'
  WHERE disputeCaseId in (5956, 5957, 5958) 

  WHERE disputeCaseId = 1122

  SELECT DATEADD(minute, 2, GETDATE())

  SELECT GETDATE()
  SELECT * 
  FROM [Stash].[slanotifications]
    WHERE disputeCaseId = 265
  ORDER BY 1 DESC

  select * from Stash.disputecase__exceptions where disputecase_Id = 115
  

  select * from Stash.disputetypes