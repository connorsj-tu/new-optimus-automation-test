/****** Script for SelectTopNRows command from SSMS  ******/
SELECT TOP (1000) [Member_PortId]
      ,[MemberNumber]
      ,[PortfolioNumber]
      ,[Description]
      ,[ExSourceCode]
      ,[ExPortfolioName]
      ,[EqCompId]
      ,[EqCompTyp]
      ,[MemberStatId]
      ,[Compliancedate]
      ,[DataContent]
      ,[MISReport]
      ,[OnlineSuppressed]
      ,[Deleted]
      ,[CLoadId]
      ,[ULoadId]
      ,[ReviewThresholdCount]
      ,[ReviewThresholdPC]a
      ,[UProcId]
      ,[Enabled]
      ,[APACSupplier]
      ,[TPDValidationSettingId]
  FROM [CCRTracking].[dbo].[Portfolio]
    order by MemberNumber, PortfolioNumber