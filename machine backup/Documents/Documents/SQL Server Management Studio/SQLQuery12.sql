/****** Script for SelectTopNRows command from SSMS  ******/
SELECT TOP (1000) [CCJId]
      ,[JudgeDateAgeM]
      ,[JudgeDateAgeD]
      ,[SatCancDateAgeM]
      ,[SatCancDateAgeD]
  FROM [Primary1].[dbo].[tstCCJAging]
  where CCJId = 9100495

  insert into [Primary1].[dbo].[tstCCJAging]
  values (16072915, 24, 0, 3, 0)

  delete from [Primary1].[dbo].[tstCCJAging]
  where CCJId = 16072915