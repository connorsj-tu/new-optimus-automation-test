/****** Script for SelectTopNRows command from SSMS  ******/
SELECT *
  FROM [Primary1].[dbo].[tblPersonAlias]-- order by 1 desc
  order by CreationDate
  where AliasId = 3464009

  update  [Primary1].[dbo].[tblPersonAlias]
  set CreationDate = '2004-01-01 00:00:00.000', UpdateDate = '2004-01-01 00:00:00.000'
   where AliasId = 3463982

   3463975
   3463973
   3463986
   3463982


     update  [Primary1].[dbo].[tblPersonAlias]
  set UpdateDate = '2004-01-01 00:00:00.000'
  where UpdateDate is NULL

  select count(*) from [Primary1].[dbo].[tblPersonAlias]
  where CreationDate is NULL