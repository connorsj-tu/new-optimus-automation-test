/****** Script for SelectTopNRows command from SSMS  ******/
SELECT TOP (1000) [Id]
      ,[dateCreated]
      ,[exceptionText]
      ,[systemName]
      ,[_stash_surrogateId]
      ,[disputecase_Id]
  FROM [SmartAgent4].[Stash].[disputecase__exceptions]
  where disputecase_Id = 13
  order by exceptionText

  