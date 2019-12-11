/****** Script for SelectTopNRows command from SSMS  ******/
SELECT *
  FROM [Focus].[dbo].[Account]

SELECT *
  FROM [Focus].[dbo].[Account]
  WHERE Member_PortId = 112

UPDATE [Focus].[dbo].[Account]
SET DateOfBirth = '1979-09-18 00:00:00.000'
  WHERE Member_PortId = 112


  UPDATE [Focus].[dbo].[Account]
  SET EndDate = '2019-09-27 00:00:00.000'
  WHERE Member_PortId = 66

UPDATE [Focus].[dbo].[Account]
  SET SupplierName = 'Wonga'
  WHERE Forename like 'GLENDA' AND Surname like 'MANX'

DELETE
  FROM [Focus].[dbo].[Account]
  WHERE Member_PortId = 66
  AND CreateLoadId Like '111%'

SELECT *
  FROM	
  WHERE Forename like 'GLENDA' AND Surname like 'MANX'


insert into [Focus].[dbo].[Account] (Member_PortId,FileDate,CreateLoadId,CreateSourceId,LastUpdateLoadId,LastUpdateSourceId,AccountNumber,AccountNumberStem,AccountNumberJointIdentifier,RolloverInd,CreditExtensionInd,AccountTypeId,StartDate,EndDate,BalanceAmount,CreditLimitAmount,RepaymentFrequencyId,NextPaymentAmount,AccountStatusId,OverduePayments,ChangeToPaymentTermsInd,Title,Forename,Othername,Surname,NameSuffix,DateOfBirth,AddressLine1,AddressLine2,AddressLine3,AddressLine4,Postcode,ProcessId,ResidenceId,SupplierName,SupplierTypeCode,SupplierTypeDescription,AccountId)
    select '66',FileDate,'1118','1111','1111','1111','ABCE1123456789012 1',AccountNumberStem,AccountNumberJointIdentifier,RolloverInd,CreditExtensionInd,AccountTypeId,StartDate,EndDate,BalanceAmount,CreditLimitAmount,RepaymentFrequencyId,NextPaymentAmount,AccountStatusId,OverduePayments,ChangeToPaymentTermsInd,'MR','RONALD','','RUGBY',NameSuffix,'1982-05-05 00:00:00.000','65 THE RIDGE','STOCKPORT','','','SK6 7ER','654321','169068273',SupplierName,SupplierTypeCode,SupplierTypeDescription,6
	from [Focus].[dbo].[Account] 
	where Forename like 'GLENDA' AND Surname like 'MANX';

insert into [Focus].[dbo].[Account] (Member_PortId,FileDate,CreateLoadId,CreateSourceId,LastUpdateLoadId,LastUpdateSourceId,AccountNumber,AccountNumberStem,AccountNumberJointIdentifier,RolloverInd,CreditExtensionInd,AccountTypeId,StartDate,EndDate,BalanceAmount,CreditLimitAmount,RepaymentFrequencyId,NextPaymentAmount,AccountStatusId,OverduePayments,ChangeToPaymentTermsInd,Title,Forename,Othername,Surname,NameSuffix,DateOfBirth,AddressLine1,AddressLine2,AddressLine3,AddressLine4,Postcode,ProcessId,ResidenceId,SupplierName,SupplierTypeCode,SupplierTypeDescription,AccountId)
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


insert into [Focus].[dbo].[Account] (Member_PortId,FileDate,CreateLoadId,CreateSourceId,LastUpdateLoadId,LastUpdateSourceId,AccountNumber,AccountNumberStem,AccountNumberJointIdentifier,RolloverInd,CreditExtensionInd,AccountTypeId,StartDate,EndDate,BalanceAmount,CreditLimitAmount,RepaymentFrequencyId,NextPaymentAmount,AccountStatusId,OverduePayments,ChangeToPaymentTermsInd,Title,Forename,Othername,Surname,NameSuffix,DateOfBirth,AddressLine1,AddressLine2,AddressLine3,AddressLine4,Postcode,ProcessId,ResidenceId,SupplierName,SupplierTypeCode,SupplierTypeDescription,AccountId)
    select 
	'66',FileDate,
	'1119','1111','1111','1111',
	'ABCE2123456789012 1',AccountNumberStem,AccountNumberJointIdentifier,RolloverInd,CreditExtensionInd,AccountTypeId,StartDate,EndDate,BalanceAmount,CreditLimitAmount,RepaymentFrequencyId,NextPaymentAmount,AccountStatusId,OverduePayments,ChangeToPaymentTermsInd
	,'MR'
	,'TOM',''
	,'HOOVER',NameSuffix
	,'1981-04-09 00:00:00.000'
	,'61 THE RIDGE'
	,'STOCKPORT','',''
	,'SK6 7ER','654321'
	,'169068277',SupplierName,SupplierTypeCode,SupplierTypeDescription
	,7
	from [Focus].[dbo].[Account] 
	where Forename like 'GLENDA' AND Surname like 'MANX';



insert into [Focus].[dbo].[Account] (Member_PortId,FileDate,CreateLoadId,CreateSourceId,LastUpdateLoadId,LastUpdateSourceId,AccountNumber,AccountNumberStem,AccountNumberJointIdentifier,RolloverInd,CreditExtensionInd,AccountTypeId,StartDate,EndDate,BalanceAmount,CreditLimitAmount,RepaymentFrequencyId,NextPaymentAmount,AccountStatusId,OverduePayments,ChangeToPaymentTermsInd,Title,Forename,Othername,Surname,NameSuffix,DateOfBirth,AddressLine1,AddressLine2,AddressLine3,AddressLine4,Postcode,ProcessId,ResidenceId,SupplierName,SupplierTypeCode,SupplierTypeDescription,AccountId)
    select '66',FileDate,
	'1120','1111','1111','1111',
	'ABCE3123456789012 1',AccountNumberStem,AccountNumberJointIdentifier,RolloverInd,CreditExtensionInd,AccountTypeId,StartDate,EndDate,BalanceAmount,CreditLimitAmount,RepaymentFrequencyId,NextPaymentAmount,AccountStatusId,OverduePayments,ChangeToPaymentTermsInd
	,'MR'
	,'COLIN',''
	,'HOTPOINT',NameSuffix
	,'1965-11-12 00:00:00.000'
	,'63 THE RIDGE'
	,'STOCKPORT','',''
	,'SK6 7ER','654321'
	,'169068278',SupplierName,SupplierTypeCode,SupplierTypeDescription
	,8
	from [Focus].[dbo].[Account] 
	where Forename like 'GLENDA' AND Surname like 'MANX';

insert into [Focus].[dbo].[Account] (Member_PortId,FileDate,CreateLoadId,CreateSourceId,LastUpdateLoadId,LastUpdateSourceId,AccountNumber,AccountNumberStem,AccountNumberJointIdentifier,RolloverInd,CreditExtensionInd,AccountTypeId,StartDate,EndDate,BalanceAmount,CreditLimitAmount,RepaymentFrequencyId,NextPaymentAmount,AccountStatusId,OverduePayments,ChangeToPaymentTermsInd,Title,Forename,Othername,Surname,NameSuffix,DateOfBirth,AddressLine1,AddressLine2,AddressLine3,AddressLine4,Postcode,ProcessId,ResidenceId,SupplierName,SupplierTypeCode,SupplierTypeDescription,AccountId)
    select '66',FileDate,
	'1121','1111','1111','1111',
	'ABCE4123456789012 1',AccountNumberStem,AccountNumberJointIdentifier,RolloverInd,CreditExtensionInd,AccountTypeId,StartDate,EndDate,BalanceAmount,CreditLimitAmount,RepaymentFrequencyId,NextPaymentAmount,AccountStatusId,OverduePayments,ChangeToPaymentTermsInd
	,'MRS'
	,'EMMA',''
	,'INDESIT',NameSuffix
	,'1979-07-27 00:00:00.000'
	,'61 THE RIDGE'
	,'STOCKPORT','',''
	,'SK6 7ER','654321'
	,'169068280',SupplierName,SupplierTypeCode,SupplierTypeDescription
	,9
	from [Focus].[dbo].[Account] 
	where Forename like 'GLENDA' AND Surname like 'MANX';

insert into [Focus].[dbo].[Account] (Member_PortId,FileDate,CreateLoadId,CreateSourceId,LastUpdateLoadId,LastUpdateSourceId,AccountNumber,AccountNumberStem,AccountNumberJointIdentifier,RolloverInd,CreditExtensionInd,AccountTypeId,StartDate,EndDate,BalanceAmount,CreditLimitAmount,RepaymentFrequencyId,NextPaymentAmount,AccountStatusId,OverduePayments,ChangeToPaymentTermsInd,Title,Forename,Othername,Surname,NameSuffix,DateOfBirth,AddressLine1,AddressLine2,AddressLine3,AddressLine4,Postcode,ProcessId,ResidenceId,SupplierName,SupplierTypeCode,SupplierTypeDescription,AccountId)
    select '66',FileDate,
	'1122','1111','1111','1111',
	'ABCE5123456789012 1',AccountNumberStem,AccountNumberJointIdentifier,RolloverInd,CreditExtensionInd,AccountTypeId,StartDate,EndDate,BalanceAmount,CreditLimitAmount,RepaymentFrequencyId,NextPaymentAmount,AccountStatusId,OverduePayments,ChangeToPaymentTermsInd
	,'MRS'
	,'DEBBIE',''
	,'BOSCH',NameSuffix
	,'1990-01-03 00:00:00.000'
	,'63 THE RIDGE'
	,'STOCKPORT','',''
	,'SK6 7ER','654321'
	,'169068281',SupplierName,SupplierTypeCode,SupplierTypeDescription
	,10
	from [Focus].[dbo].[Account] 
	where Forename like 'GLENDA' AND Surname like 'MANX';

insert into [Focus].[dbo].[Account] (Member_PortId,FileDate,CreateLoadId,CreateSourceId,LastUpdateLoadId,LastUpdateSourceId,AccountNumber,AccountNumberStem,AccountNumberJointIdentifier,RolloverInd,CreditExtensionInd,AccountTypeId,StartDate,EndDate,BalanceAmount,CreditLimitAmount,RepaymentFrequencyId,NextPaymentAmount,AccountStatusId,OverduePayments,ChangeToPaymentTermsInd,Title,Forename,Othername,Surname,NameSuffix,DateOfBirth,AddressLine1,AddressLine2,AddressLine3,AddressLine4,Postcode,ProcessId,ResidenceId,SupplierName,SupplierTypeCode,SupplierTypeDescription,AccountId)
    select '66',FileDate,
	'1123','1111','1111','1111',
	'ABCE6123456789012 1',AccountNumberStem,AccountNumberJointIdentifier,RolloverInd,CreditExtensionInd,AccountTypeId,StartDate,EndDate,BalanceAmount,CreditLimitAmount,RepaymentFrequencyId,NextPaymentAmount,AccountStatusId,OverduePayments,ChangeToPaymentTermsInd
	,'MR'
	,'ALAN',''
	,'LOGIK',NameSuffix
	,'1972-04-16 00:00:00.000'
	,'65 THE RIDGE'
	,'STOCKPORT','',''
	,'SK6 7ER','654321'
	,'169068282',SupplierName,SupplierTypeCode,SupplierTypeDescription
	,11
	from [Focus].[dbo].[Account] 
	where Forename like 'GLENDA' AND Surname like 'MANX';


	-- NEW 15/08/2019


insert into [Focus].[dbo].[Account] (Member_PortId,FileDate,CreateLoadId,CreateSourceId,LastUpdateLoadId,LastUpdateSourceId,AccountNumber,AccountNumberStem,
AccountNumberJointIdentifier,RolloverInd,CreditExtensionInd,AccountTypeId,StartDate,EndDate,BalanceAmount,CreditLimitAmount,RepaymentFrequencyId,NextPaymentAmount,
AccountStatusId,OverduePayments,ChangeToPaymentTermsInd,Title,Forename,Othername,Surname,NameSuffix,DateOfBirth,AddressLine1,AddressLine2,AddressLine3,AddressLine4,
Postcode,ProcessId,ResidenceId,SupplierName,SupplierTypeCode,SupplierTypeDescription,AccountId)
	VALUES(
	'112',
	'2018-02-15 00:00:00.000',
	'1111',
	'1111',
	'1111',
	'1111',
	'ABCE6123456789012 1',
	'AWC01933567890123',
	'1',
	'1',
	'1',
	'11',
	'2018-02-15 00:00:00.000',
	'2016-04-14 15:20:58.240',
	'100',
	'10000',
	'2',
	'12',
	'2',
	'1',
	'1',
	'MRS', 
	'KELLY',
	NULL,
	'MASSEY',
	NULL,
	'1979-01-18 00:00:00.000',
	'8 CLARE COURT',
	'',
	'',
	'',
	'HX1 2QA',
	'500001',
	'219263446',
	'Wonga',
	'FN',
	'Finance House',
	'1')


insert into [Focus].[dbo].[Account] (Member_PortId,FileDate,CreateLoadId,CreateSourceId,LastUpdateLoadId,LastUpdateSourceId,AccountNumber,AccountNumberStem,
AccountNumberJointIdentifier,RolloverInd,CreditExtensionInd,AccountTypeId,StartDate,EndDate,BalanceAmount,CreditLimitAmount,RepaymentFrequencyId,NextPaymentAmount,
AccountStatusId,OverduePayments,ChangeToPaymentTermsInd,Title,Forename,Othername,Surname,NameSuffix,DateOfBirth,AddressLine1,AddressLine2,AddressLine3,AddressLine4,
Postcode,ProcessId,ResidenceId,SupplierName,SupplierTypeCode,SupplierTypeDescription,AccountId)
	VALUES(
	'112',
	'2018-02-15 00:00:00.000',
	'1119',
	'1111',
	'1111',
	'1111',
	'ABCE6123456789012 7',
	'AWC01933567890123',
	'1',
	'1',
	'1',
	'11',
	'2018-02-15 00:00:00.000',
	'2016-04-14 15:20:58.240',
	'100',
	'10000',
	'2',
	'12',
	'2',
	'1',
	'1',
	'MRS', 
	'BECKY',
	NULL,
	'BOTTLE',
	NULL,
	'1998-12-18 00:00:00.000',
	'1 TELFORD ROAD',
	'',
	'',
	'',
	'SK6 7LG',
	'500001',
	'219263058',
	'Wonga',
	'FN',
	'Finance House',
	'2')

UPDATE [Focus].[dbo].[Account]
SET
--DateOfBirth = '1979-09-18 00:00:00.000'
--AddressLine1 = '8 CLARE COURT, PRESCOTT STREET'
--AddressLine2 = 'CHESHIRE',
--AddressLine3 = NULL,
--AddressLine4 = NULL
--FileDate = '2018-02-15 00:00:00.000'
FileDate = '2019-06-01 00:00:00.000'
  WHERE Member_PortId = 112
  --AND Surname = 'BOTTLE'



UPDATE [Focus].[dbo].[Account]
SET
--DateOfBirth = '1979-09-18 00:00:00.000'
--AddressLine1 = '8 CLARE COURT, PRESCOTT STREET'
AddressLine2 = 'STOCKPORT',
--AddressLine3 = '',
--AddressLine4 = '',
AddressLine3 = NULL,
AddressLine4 = NULL,
FileDate = '2019-07-01 00:00:00.000',
StartDate = '2020-06-24 00:00:00.000',
EndDate = NULL,
AccountNumberJointIdentifier = 0,
CreateSourceId = 1119,
LastUpdateLoadId = 1119,
LastUpdateSourceId = 1119,
AccountNumber = 'AWC11933567890123 1',
AccountNumberStem = 'AWC11933567890123',
ProcessId = '395435',
--AccountId = '9'
Member_PortId = 61
  WHERE Member_PortId = 66
  AND Surname = 'BOTTLE'

  select * from [Focus].[dbo].[Account]
where Member_PortId = 112


SELECT *
  FROM [Focus].[dbo].[VW_Account]