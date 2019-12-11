--CIGPLLFBDBBZDBI\BUSINESS

update [SearchHistory_Online].[dbo].[SearchHistory]
set SearchId = 'C5554AEB-C91E-449E-AB49-B210C83F16B9'
where SearchId = 'AB692219-4848-4E56-831A-931B9BFCB6C3'
  and Surname = 'HENRY'

update [SearchHistory_Online].[dbo].[SearchHistory]
set SearchId = 'F7C2A476-B715-42D9-93E1-34374DB8260C'
where SearchId = '5CD1525E-F3A2-4C38-A800-639BAC5182D0'
  and Surname = 'HENRY'

update [SearchHistory_Online].[dbo].[SearchHistory]
set SearchId = 'F7C2A476-B715-42D9-93E1-34374DB8260C'
where SearchId = '987C71D9-0876-4B87-8B7F-F991F06BEDA6'
  and Surname = 'MASS'




  /****** Script for SelectTopNRows command from SSMS  ******/
SELECT TOP (1000) *
  FROM [Audit].[dbo].[tblAuditCreditSearches]
where acsSearchID = '8C96B63F-CFCD-4FCF-A4F4-25D286FFB3B3'

/****** Script for SelectTopNRows command from SSMS  ******/
SELECT TOP (1000) *
  FROM [SearchHistory_Online].[dbo].[SearchHistory]
  where SearchId = '8C96B63F-CFCD-4FCF-A4F4-25D286FFB3B3'

'F7C2A476-B715-42D9-93E1-34374DB8260C'
'E0194962-AA2D-4F34-BF6B-7CC99C06DA22'
'9B7286BA-50D0-4D55-8746-62D319631F15'
'BCC2CA80-073E-4A33-872B-D4FDBE120A26'

SELECT *
  FROM [Audit].[dbo].[tblAuditCreditSearches]
where acsSearchID in
('F7C2A476-B715-42D9-93E1-34374DB8260C', 'E0194962-AA2D-4F34-BF6B-7CC99C06DA22', '9B7286BA-50D0-4D55-8746-62D319631F15', 'BCC2CA80-073E-4A33-872B-D4FDBE120A26')

SELECT *
  FROM [SearchHistory_Online].[dbo].[SearchHistory]
  where SearchId in
  ('F7C2A476-B715-42D9-93E1-34374DB8260C', 'E0194962-AA2D-4F34-BF6B-7CC99C06DA22', '9B7286BA-50D0-4D55-8746-62D319631F15', 'BCC2CA80-073E-4A33-872B-D4FDBE120A26')


  -- change '8C96B63F-CFCD-4FCF-A4F4-25D286FFB3B3' to 'F7C2A476-B715-42D9-93E1-34374DB8260C' for KELLY MASSEY

SELECT *
  FROM [SearchHistory_Online].[dbo].[SearchHistory]
  where SearchId = '8C96B63F-CFCD-4FCF-A4F4-25D286FFB3B3'
  and Surname = 'MASSEY'

update [SearchHistory_Online].[dbo].[SearchHistory]
set SearchId = 'F7C2A476-B715-42D9-93E1-34374DB8260C'
where SearchId = '8C96B63F-CFCD-4FCF-A4F4-25D286FFB3B3'
  and Surname = 'MASSEY'


SELECT TOP (1000) [SearchId]
      ,[AuditDateTime]
      ,[UserName]
      ,[CompanyName]
      ,[OrgUnitId]
      ,[OrgUnitType]
      ,[OrgUnitName]
      ,[SearchPurpose]
      ,[AccountType]
      ,[BalanceLimit]
      ,[LoanTerm]
      ,[JointApplication]
      ,[SecondarySearch]
      ,[TransientAssociation]
      ,[LinkType]
      ,[YourReference]
      ,[DoB]
      ,[TransactionalOptOut]
      ,[AbodeNo]
      ,[BuildingNo]
      ,[BuildingName]
      ,[Street1]
      ,[Street2]
      ,[SubLocality]
      ,[Locality]
      ,[Town]
      ,[PostCode]
      ,[DateMoveIn]
      ,[DateMoveOut]
      ,[Title]
      ,[Forename]
      ,[Othername]
      ,[Surname]
      ,[ResidenceId]
      ,[SearchSequenceNum]
  FROM [SearchHistory_Online].[dbo].[SearchHistory]
  --where SearchId = 'F7C2A476-B715-42D9-93E1-34374DB8260C'
  where ResidenceId = '219263446'

  insert into [SearchHistory_Online].[dbo].[SearchHistory] 
  (SearchId,AuditDateTime,UserName,CompanyName,OrgUnitId,OrgUnitType,OrgUnitName,SearchPurpose,LoanTerm,JointApplication,SecondarySearch,TransientAssociation,
  LinkType,YourReference,DoB,TransactionalOptOut,BuildingNo,PostCode,DateMoveIn,DateMoveOut,Forename,Surname,ResidenceId,SearchSequenceNum)

	values (
	'E0194962-AA2D-4F34-BF6B-7CC99C06DA22',
	'2019-08-13 13:13:13.330',
	'Optimus CR API CTest',
	'Optimus Disputes (CR)',
	'790AAF07-5F02-485E-ACAD-66563CC7BA34',
	'OF',
	'Optimus Disputes (CR)',
	'CL',
	'0',
	'0',
	'0',
	'0',
	'0',
	NULL,
	'1979-09-18 00:00:00.000',
	'0',
	'8',
	'HX1 2QA',
	NULL,
	NULL,
	'KELLY',
	'MASSEY',
	'219263446',
	'0'
	)

    select '66',FileDate,'1118','1111','1111','1111','ABCE1123456789012 1',AccountNumberStem,AccountNumberJointIdentifier,RolloverInd,CreditExtensionInd,AccountTypeId,StartDate,EndDate,BalanceAmount,CreditLimitAmount,RepaymentFrequencyId,NextPaymentAmount,AccountStatusId,OverduePayments,ChangeToPaymentTermsInd
	,'MR'
	,'RONALD',''
	,'RUGBY',NameSuffix
	,'1982-05-05 00:00:00.000'
	,'65 THE RIDGE'
	,'STOCKPORT','',''
	,'SK6 7ER','654321'
	,'169068273',SupplierName,SupplierTypeCode,SupplierTypeDescription
	,6
	from [Focus].[dbo].[Account] 
	where Forename like 'GLENDA' AND Surname like 'MANX';


update [SearchHistory_Online].[dbo].[SearchHistory]
set SearchId = 'F7C2A476-B715-42D9-93E1-34374DB8260C'
where SearchId = '5C2F08F2-37D2-4D51-8F96-D5B8E7D12375'
  and Surname = 'BOWES'

select * from [SearchHistory_Online].[dbo].[SearchHistory]
where Surname = 'BOWES'
and Forename = 'MARY'
and SearchPurpose <> 'CD'
and ResidenceId = '219263456'


update [SearchHistory_Online].[dbo].[SearchHistory]
set SearchId = 'F7C2A476-B715-42D9-93E1-34374DB8262B'
where Surname = 'BOWES'
and Forename = 'MARY'
and SearchPurpose <> 'CD'
and AuditDateTime = '2019-08-16 08:12:56.180'


update [SearchHistory_Online].[dbo].[SearchHistory]
set SearchId = 'F7C2A476-B715-42D9-93E1-34374DB8260C',
OrgUnitId = '790AAF07-5F02-485E-ACAD-66563CC7BA35',
SearchPurpose = 'CL'
where Surname = 'BOWES'
and Forename = 'MARY'
and AuditDateTime = '2019-08-13 13:53:58.613'


update [SearchHistory_Online].[dbo].[SearchHistory]
set YourReference = 'AAAA',
BuildingNo = '12',
CompanyName = 'Optimus Disputes (CR)',
SearchSequenceNum = 1
where Surname = 'BOWES'
and Forename = 'MARY'
and AuditDateTime = '2019-08-16 10:08:10.167'
and ResidenceId = '219263456'

'2019-08-16 06:56:32.217'
'2019-08-16 08:01:43.283'
'2019-08-16 08:12:15.787'
'2019-08-16 08:12:43.400'
'2019-08-16 08:12:50.477'
'2019-08-16 08:12:52.340'
'2019-08-16 08:12:54.300'
'2019-08-16 08:12:56.180'
'2019-08-16 08:12:57.853'
'2019-08-16 08:12:59.423'
'2019-08-16 08:13:11.797'
'2019-08-16 09:34:00.377'
'2019-08-16 09:43:54.990'
'2019-08-16 09:50:39.810'
'2019-08-16 09:55:04.043'
'2019-08-16 10:05:15.190'
'2019-08-16 10:07:08.630'
'2019-08-16 10:08:10.167'
'2019-08-16 10:09:56.977'

update [SearchHistory_Online].[dbo].[SearchHistory]
set SearchId = '367E4243-09B6-4615-A452-A2531C956A15'
where Surname = 'BOWES'
and Forename = 'MARY'
and AuditDateTime = '2019-08-16 10:08:10.167'
and ResidenceId = '219263456'


'ABA18CA3-E01F-49CA-833D-666C3F7B933C'
'FAE51D8B-FE98-48E9-A421-13D7E303423C'
'8DF22FFE-6D11-4AED-864C-393A39B8CE0E'
'A2C66C5D-ACF3-42F1-9DB3-3E44496E5AC2'
'239B5619-B766-4858-89F4-CE335CC8E07F'
'77D56F08-81DF-48E5-A15F-534FBD0B744E'
'C5554AEB-C91E-449E-AB49-B210C83F16B9'

'2019-08-16 10:09:56.977
'2019-08-16 10:07:08.630
'2019-08-16 10:05:15.190'
'2019-08-16 09:55:04.043'
'2019-08-16 09:50:39.810'
'2019-08-16 09:43:54.990'
'2019-08-16 09:34:00.377'

-- Note the search sproc gets data from [Audit].[dbo].[tblAuditCreditSearches] on CIGPLLFBDBBPTS\BureauPrimary

C5554AEB-C91E-449E-AB49-B210C83F16B9
77D56F08-81DF-48E5-A15F-534FBD0B744E
239B5619-B766-4858-89F4-CE335CC8E07F
A2C66C5D-ACF3-42F1-9DB3-3E44496E5AC2
8DF22FFE-6D11-4AED-864C-393A39B8CE0E
FAE51D8B-FE98-48E9-A421-13D7E303423C
367E4243-09B6-4615-A452-A2531C956A15
ABA18CA3-E01F-49CA-833D-666C3F7B933C

select * from [SearchHistory_Online].[dbo].[SearchHistory]
where 
Surname = 'BOWES'
and Forename = 'MARYX'

SearchId = '5101ABBD-BC44-43E3-A40E-B02B6D7D6A00'

update [SearchHistory_Online].[dbo].[SearchHistory]
set SearchId = 'ABA18CA3-E01F-49CA-833D-666C3F7B933C'
where SearchId = 'C28D8D2C-BBD9-4163-96AD-14F6006ED375'
and Surname = 'BOWES'
and Forename = 'MARYX'


from
'5101ABBD-BC44-43E3-A40E-B02B6D7D6A00'
'3FF8C1F7-C43A-4BE7-AD09-22EEDEB92C34'
'6FF34C1E-15AE-46DD-8A8C-D9B0FAD9ED76'
'CA81CF77-5436-424B-A0A2-6911821B1EF5'
'E9E1DD2E-F723-4234-8382-2D5B6F811CFF'
'16936E4A-5DB3-4642-ADDE-6BE074539B45'
'1778D32B-1246-4205-8D67-CBD371CAF94A'
'C28D8D2C-BBD9-4163-96AD-14F6006ED375'

to
'C5554AEB-C91E-449E-AB49-B210C83F16B9'
'77D56F08-81DF-48E5-A15F-534FBD0B744E'
'239B5619-B766-4858-89F4-CE335CC8E07F'
'A2C66C5D-ACF3-42F1-9DB3-3E44496E5AC2'
'8DF22FFE-6D11-4AED-864C-393A39B8CE0E'
'FAE51D8B-FE98-48E9-A421-13D7E303423C'
'367E4243-09B6-4615-A452-A2531C956A15'
'ABA18CA3-E01F-49CA-833D-666C3F7B933C'

update [SearchHistory_Online].[dbo].[SearchHistory]
set SearchId = 'F7C2A476-B715-42D9-93E1-34374DB8260C'
where SearchId = 'AF8A1AD0-629D-4213-9084-7484E3B77B76'
  and Surname = 'MASSEY'

update [SearchHistory_Online].[dbo].[SearchHistory]
set SearchId = 'F7C2A476-B715-42D9-93E1-34374DB8260C'
where SearchId = 'BB4C1E06-9665-4533-96E5-9D7C051B30E3'
  and Surname = 'BOWES'
