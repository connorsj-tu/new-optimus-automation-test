/****** Script for SelectTopNRows command from SSMS  ******/
SELECT TOP (1000) [Id]
      ,[contactPreference]
      ,[dob]
      ,[emailAddress]
      ,[ident]
      ,[_stash_surrogateId]
      ,[residenceId]
  FROM [SmartAgent4].[Stash].[disputecase__consumer]
