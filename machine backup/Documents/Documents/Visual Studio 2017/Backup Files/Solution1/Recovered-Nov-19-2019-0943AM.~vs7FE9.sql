/****** Script for SelectTopNRows command from SSMS  ******/
SELECT *
  FROM [Primary1].[dbo].[tblAllDisputesAndCorrection]
  Where NoticeType = 2
  and NoticeDataType = 11
  ORDER BY Surname, Forename


  select * from dbo.tblShAccHolder
where ProcessId = 
202835  
and AccountId = 100001924



update dbo.tblShAccHolder
set DateOfBirth = '1987-08-16 00:00:00.000'
where ProcessId = 
202835  
and AccountId = 100001924