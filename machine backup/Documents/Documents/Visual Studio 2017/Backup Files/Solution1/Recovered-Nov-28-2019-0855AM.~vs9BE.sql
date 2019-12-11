UPDATE [Primary1].[dbo].tblShAccHolder 
SET DtSrcTitle = ''
WHERE DtSrcTitle= 'MRS'
AND ProcessId LIKE 202979;

UPDATE [Primary1].[dbo].tblShAccHolder 
SET DtSrcTitle = ''
WHERE DtSrcForename = 'KELLY' 
and DtSrcSurname = 'MASSEY'

DtSrcTitle= 'MRS'
AND ProcessId LIKE 202979;


SELECT top 100 * FROM [Primary1].[dbo].tblShAccHolder 
WHERE DtSrcForename = 'KELLY' 
and DtSrcSurname = 'MASSEY'


SELECT top 10 * FROM [Primary1].[dbo].tblShAccHolder 
WHERE ProcessId LIKE 202979;

SET DtSrcTitle = ''
WHERE DtSrcTitle= 'MRS'
AND ProcessId LIKE 202979;