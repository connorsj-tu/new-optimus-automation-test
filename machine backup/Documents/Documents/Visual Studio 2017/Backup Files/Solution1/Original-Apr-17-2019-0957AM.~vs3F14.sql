/****** Script for SelectTopNRows command from SSMS  ******/
SELECT TOP (1000) [Id]
      ,[ETag]
      ,[scopeType]
      ,[memberPortId]
      ,[memberPortfolioNumber]
      ,[memberPortfolioName]
      ,[organisationName]
      ,[organisationUnitName]
      ,[supplierId]
      ,[isActive]
      ,[_stash_changeTime]
      ,[RulesetVersion]
      ,[idAsInteger]
      ,[organisationId]
      ,[organisationUnitId]
  FROM [SmartAgent4].[Stash].[datascopes]