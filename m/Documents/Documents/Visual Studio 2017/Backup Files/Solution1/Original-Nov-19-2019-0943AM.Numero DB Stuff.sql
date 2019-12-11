--Numero DB is 1hr behing BST

select count(*)
from stash.disputecase 
ORDER BY 1 DESC


select * from stash.disputecase__exceptions
--where disputecase_Id in ('5995','6003','6004')
where disputecase_Id in (6055, 6056, 6057, 6058)

select distinct systemName from stash.disputecase__exceptions

select * from stash.disputecase 
ORDER BY 1 DESC

select * from stash.disputecase 
--where numeroCustomerRef = 6001
where numeroCustomerRef = 3001
ORDER BY 1 DESC


select dccn.forename, dccn.surname, dcc.dob, dcc.residenceId, dc.* from stash.disputecase dc
INNER JOIN [Stash].[disputecase__consumer] dcc
	on dc.Id = dcc._stash_surrogateId

INNER JOIN [Stash].[disputecase__consumer__names] dccn
	on dc.Id = dccn.disputecase__consumer_id
--where dcc.residenceId = 2147483054
where dccn.forename = 'REENA' and dccn.surname = 'BLUE'
and caseStateDescription not like '%omplete%'
and caseStateDescription not like '%eject%'
ORDER BY Id DESC

select dccn.forename, dccn.surname, dcc.dob, dcc.residenceId, dc.* from stash.disputecase dc
INNER JOIN [Stash].[disputecase__consumer] dcc
	on dc.Id = dcc._stash_surrogateId

INNER JOIN [Stash].[disputecase__consumer__names] dccn
	on dc.Id = dccn.disputecase__consumer_id
--where dcc.residenceId = 2147483054
where dccn.forename = 'JAMES' and dccn.surname = 'MODAAPISIXA'
and caseStateDescription not like '%omplete%'
and caseStateDescription not like '%eject%'
ORDER BY Id DESC


select a.*, b.* from stash.dataupdatequeue a
inner join stash.dataupdatequeue__storedProcedureParameters b
on a.id = b.dataupdatequeue_Id
--where a.disputeCaseId = 5461
where a.disputeCaseId in (6055, 6056, 6057, 6058)
ORDER BY 1 DESC



ORDER BY 1 DESC


select * from stash.disputecase 
where numeroCaseRef = 20031


select * from stash.disputecase__consumer
ORDER BY 1 DESC

select * from stash.disputecase__consumer__names
where disputecase__consumer_Id = 5472
ORDER BY 1 DESC


select * from stash.disputecase 
where id in (5175,5410)
ORDER BY 1 DESC

5107

select * from stash.disputecase 
where numeroCaseRef = 18305   
ORDER BY 1 DESC

select * from stash.disputecase 
where id > 1341
ORDER BY 1 DESC

select * from stash.disputecase 
where numeroCaseRef = 18305 
ORDER BY 1 DESC


select * from stash.disputecase 
ORDER BY 1 DESC



select TOP 100 * from stash.disputecase__exceptions
--where disputecase_Id = 5433
--order by dateCreated desc
order by disputecase_Id DESC

select * from stash.disputecase__exceptions
where disputecase_Id = 5990
order by dateCreated desc

select * from stash.disputecase 
ORDER BY 1 DESC

select count(*) from stash.disputecase
where id > 1341
and caseStateDescription = 'Awaiting Submission'
ORDER BY 1 ASC

SELECT CAST(createdDate as date) CREATED_DATE, COUNT(id) DISPUTE_COUNT
FROM stash.disputecase
GROUP BY CAST(createdDate as date)
ORDER BY CREATED_DATE DESC

group by dateSubmitted
order by dateSubmitted desc


SELECT * FROM [SmartAgent4].[Stash].[disputecase__exceptions]
ORDER BY disputecase_Id DESC

select top 2000 * from CodeAPI.TraceOutputs
where Message like '%9136032%'
order by time desc

select * from stash.dataupdatequeue ORDER BY 1 DESC
select * from stash.dataupdatequeue__storedProcedureParameters  ORDER BY 4 DESC

select * from stash.disputecase 
where numeroCaseRef = 17251
ORDER BY 1 DESC

select a.*, b.* from stash.dataupdatequeue a
inner join stash.dataupdatequeue__storedProcedureParameters b
on a.id = b.dataupdatequeue_Id
where a.disputeCaseId = 5461
ORDER BY 1 DESC

select * from  [Stash].[slanotifications]
where disputeCaseId = 5107


select * from  [Stash].[audit]
order by Id DESC

select count(detail) COUNT, detail 
from  [Stash].[audit]
GROUP BY detail
ORDER by 2

where disputeCaseId = 51

  -- note - db time is 1hr behind
  UPDATE [Stash].[slanotifications]
  SET alertDate ='2019-04-05T09:57:00.0000000'
  WHERE disputeCaseId in (5129, 5118, 5121, 5175, 5307, 5410)

  (, , , 5175, , 5410)

  SELECT DATEADD(minute, 2, GETDATE())

  select * from [Stash].[slanotifications]
  where disputeCaseId in (5129, 5118, 5121, 5175, 5307, 5410)
  order by 1 desc


select * from setup.ApplicationConfigurationData
where type = 'databases'
{"type":"sql-server", "connectionString": "Data Source=pllwininsql010.cig.local,24212;Initial Catalog=NODDLE_SIT_DB04;User ID=smartagent;Password=PhUZ6ngjVn"}

SELECT TOP 500 * FROM CodeAPI.TraceOutputs ORDER BY Time DESC

update stash.disputecase set caseStateId = 8, caseStateDescription = 'Rejected (Auto)', closedDate = '2018-09-11T10:04:19.403108Z' 
where Id IN (360, 350, 329, 328, 303)

update stash.disputecase set caseStateId = 8, caseStateDescription = 'Rejected (Auto)', closedDate = '2018-09-11T10:04:19.403108Z' 
where Id IN (359, 327, 319, 316, 315, 311, 302)
-- did 169 incorrectly

update stash.disputecase set closedDate = '2018-09-11T10:04:19.403108Z' 
where Id IN (359, 327, 319, 316, 315, 311, 302)
-- did 169 incorrectly

select * from stash.soaprequests
where soapRequestText like '%<DisputeId>423640810</DisputeId>%'
ORDER BY 1 DESC


select top 10 * from stash.soaprequests
where soapRequestText like '%UserEmail%'
and  soapRequestText not like '%yjohn%'
and soapRequestText like '%<CCCDisputeType>6%'
ORDER BY 1 DESC

select * from stash.disputecase 
where caseStateDescription = 'Awaiting Supplier'
ORDER BY 1 DESC


select dc.Id, dc.numeroCaseRef, dc.caseStateId, dc.caseStateDescription,
dsl.Id, ds.scopeType, ds.memberPortId, ds.memberPortFolioNumber, ds.memberPortFolioName, ds.supplierId

FROM [SmartAgent4].[Stash].[disputecase] dc,
[SmartAgent4].[Stash].[disputecase__dataScopeList] dsl,
[SmartAgent4].[Stash].[datascopes] ds

where dc.Id = dsl.disputecase_Id
AND dsl.Id = ds.Id
--AND dc.caseStateDescription = 'Awaiting Supplier'

ORDER BY 1 DESC


dsl.*, dc.* from stash.disputecase dc
INNER JOIN [SmartAgent4].[Stash].[disputecase__dataScopeList] dsl
INNER JOIN [SmartAgent4].[Stash].[datascopes] ds
ON dsl.disputecase_Id = dc.Id,
ON ds.Id = dc.Id
where dc.caseStateDescription = 'Awaiting Supplier'
ORDER BY 1 DESC

/****** Script for SelectTopNRows command from SSMS  ******/
SELECT TOP (1000) * 
  FROM [SmartAgent4].[Stash].[disputecase__exceptions]
  order by disputecase_Id DESC

select * from stash.disputecase 
ORDER BY 1 DESC

select * from stash.disputecase__dataScopeList
where disputecase_Id = 4595
ORDER BY 1 DESC

select * from stash.suppliers
ORDER BY 1 DESC

select * from stash.datascopes
--where supplierId = 214
order by supplierId, idAsInteger

select * from stash.datascopes
where memberPortfolioNumber = '999912'

select * from stash.datascopes
order by memberPortfolioNumber 
where memberPortfolioNumber = '999912'

update stash.datascopes set isActive = 1
where memberPortfolioNumber = 999912 

select * from stash.datascopes
where memberPortfolioNumber = 999912 

-- update for hema 03/04/2019
update stash.datascopes set memberPortfolioNumber = 999901  where memberPortfolioNumber = 66
update stash.datascopes set memberPortfolioNumber = 412335  where memberPortfolioNumber = 112

update stash.datascopes set memberPortfolioNumber = 412335  where memberPortfolioNumber = 112

update stash.datascopes set memberPortfolioNumber = '9999-01'  where memberPortfolioNumber = 999901  



select * from stash.datascopes where memberPortfolioNumber = 112


-- update for hema 03/04/2019
update stash.datascopes set memberPortId = 0 where  memberPortfolioNumber = 999901



select * from stash.datascopes 
where supplierId = 214


9999-01
9999-01


and organisationUnitName = 'Jack Russel Plc (CVAL Batch, SA)'

update stash.datascopes
set organisationId = '1489c490-9e6c-44fd-81db-9d06e938eb83', organisationUnitId = 'd6423278-4f1e-4913-b2bd-40f320e8cce6'
where supplierId = 214
and organisationUnitName = 'Jack Russel Plc (CVAL Batch, SA)'
and Id = '1489@p.id' 

update stash.datascopes
set organisationId = '06C63BA7-AE74-4D7E-BD05-D55A2C3B9C20', organisationUnitId = '7A2917E7-D413-4B01-BA8E-4488C8C7768E'
where supplierId = 214
and Id = '1491@p.id' 


acsOrganisationId	acsOrganisationName	acsOrgUnitID
06C63BA7-AE74-4D7E-BD05-D55A2C3B9C20	

'AF92F32E-356C-4B08-B858-CBE22C27FECF'
'7A2917E7-D413-4B01-BA8E-4488C8C7768E'

1490@p.id
1491@p.id
1492@p.id
1493@p.id
1494@p.id
1495@p.id

Supplier Allocation Error - Search Org Id: 06c63ba7-ae74-4d7e-bd05-d55a2c3b9c20, Search Org Name: Callcredit, Search Org Unit Id: 7a2917e7-d413-4b01-ba8e-4488c8c7768e, Search Org Unit Name: Callcredit Money Laundering

WAS;
organisationId = 'EE56011E-E483-4457-9F35-F7D8CE148C1E'
organisationUnitId = '3913F0D7-B56D-44C2-A4A2-583E01F363CF'
organisationUnitName was 'Jack Russel Plc (CVAL Batch, SA)'
Id = '1489@p.id' 

set organisationId = 'EE56011E-E483-4457-9F35-F7D8CE148C1E', organisationUnitId = '3913F0D7-B56D-44C2-A4A2-583E01F363CF'

CHANGE To:
organisationId = '7f9a5180-b992-485e-84e6-9bf738be0a84'
organisationUnitId = '9bad18a0-4353-44d2-afb2-74eacb2f4e8e'
set organisationId = '7f9a5180-b992-485e-84e6-9bf738be0a84', organisationUnitId = '9bad18a0-4353-44d2-afb2-74eacb2f4e8e'

NEW TO CHANGE TO:
organisationId = '1489C490-9E6C-44FD-81DB-9D06E938EB83'
organisationUnitId = 'D6423278-4F1E-4913-B2BD-40F320E8CCE6'
set organisationId = '1489C490-9E6C-44FD-81DB-9D06E938EB83', organisationUnitId = 'D6423278-4F1E-4913-B2BD-40F320E8CCE6'


update stash.datascopes
set memberPortId = 14522 
where memberPortfolioName = 'Beagle Ltd'

select * from stash.datascopes
where memberPortfolioName = 'Beagle Ltd'


select * from IdentUsers.UserAccounts
where Email like '%conno%'

select * from IdentUsers.UserClaims
where ParentKey like 139

insert into IdentUsers.UserClaims
(ParentKey, Type, Value)
values (139, 'role', 'stash.admin')

where ParentKey like 139


where ETag like '%A3CF4'
s

-- status updates to CK/GINGER
select * from stash.consumerplatformnotifications
where disputeCaseId in (6055, 6056, 6057, 6058)
order by disputeCaseId desc  

select * from stash.consumerplatformnotifications
order by id desc  

select distinct status from stash.consumerplatformnotifications
order by id desc  


select id, caseStateDescription from stash.disputecase 
ORDER BY 1 

select dc_cn.surname, dc.* 
from [Stash].[disputecase__consumer__names] dc_cn, stash.disputecase dc
where dc_cn.disputecase__consumer_Id = dc.Id
--and surname like 'football'
ORDER BY 2 DESC

select distinct sccn.surname
from [Stash].[disputecase__consumer__names] sccn, stash.disputecase dc
where sccn.disputecase__consumer_Id = dc.Id
--and surname like 'football'
ORDER BY 1

select * from stash.disputecase 
WHERE caseStateDescription like '%Triage%'
ORDER BY 1 DESC


select * from IdentUsers.UserAccounts
where username like 'Opt%'

select * from stash.dataupdatequeue
order by 1 desc

UPDATE
IdentUsers.UserAccounts
SET IsAccountVerified = 1 

Select * from IdentUsers.UserClaims
ORDER BY 1 DESC


insert into IdentUsers.UserClaims (ParentKey, Type, Value)

VALUES (116, 'role', 'numerointeractive')

 

insert into IdentUsers.UserClaims (ParentKey, Type, value)

VALUES (116, 'role', 'Agent') 

insert into IdentUsers.UserClaims (ParentKey, Type, value)

VALUES (115, 'name', 'Hemadeepitha Elangovan')




  
CYCLE1;
select * from stash.dataupdatequeue 
WHERE disputeCaseId in (1114)
ORDER BY 1 DESC


select * from stash.dataupdatequeue__storedProcedureParameters  
where dataupdatequeue_Id in (
select id from stash.dataupdatequeue 
WHERE disputeCaseId in
(1114)
)

  select * from Stash.disputecase__exceptions where disputecase_Id = 181 


CYCLE2;

select * from stash.dataupdatequeue 
WHERE disputeCaseId in (191)
ORDER BY 1 DESC


select * from stash.dataupdatequeue__storedProcedureParameters  
where dataupdatequeue_Id in (
select id from stash.dataupdatequeue 
WHERE disputeCaseId in
(101)
)


Check Exceptions;
  select * from Stash.disputecase__exceptions where disputecase_Id = 191 

  select top 1000 * from CodeAPI.TraceOutputs
where message like '%10369464%' 
order by time desc

select top 1000 * from CodeAPI.TraceOutputs
where message like 'IdentifyTargetResource%' 
order by time desc

select top 1000 * from CodeAPI.TraceOutputs
where message like 'IdentifyResidenceAssets%' 
order by time desc

select top 1000 * from CodeAPI.TraceOutputs
where message like 'DeleteAddress%' 
order by time desc

select top 1000 * from CodeAPI.TraceOutputs
where message like 'DeleteResidence%' 
order by time desc

select top 1000 * from CodeAPI.TraceOutputs
where message like 'RemoveAddressLinks%' 
order by time desc  

select top 1000 * from CodeAPI.TraceOutputs
where message like '%9134822%' 
order by time desc  

select top 1000 * from CodeAPI.TraceOutputs
where id = '9CC1840A-92C2-E911-868B-0050569F7B46'

RemoveAddressLinks: Exception in RemoveAddressLinks: ERROR in [CCRMain].[DataAmendInterface].[up_AddressLink_GetResidenceIds]; @AddressLinkId=81282892 @RefNum=3036,Num 50000,Lvl 16,State 1,Line 43,Msg: There is no record with this AddressLinkId    at System.Data.SqlClient.SqlConnection.OnError(SqlException exception, Boolean breakConnection, Action`1 wrapCloseInAction)     at System.Data.SqlClient.SqlInternalConnection.OnError(SqlException exception, Boolean breakConnection, Action`1 wrapCloseInAction)     at System.Data.SqlClient.TdsParser.ThrowExceptionAndWarning(TdsParserStateObject stateObj, Boolean callerHasConnectionLock, Boolean asyncClose)     at System.Data.SqlClient.TdsParser.TryRun(RunBehavior runBehavior, SqlCommand cmdHandler, SqlDataReader dataStream, BulkCopySimpleResultSet bulkCopyHandler, TdsParserStateObject stateObj, Boolean& dataReady)     at System.Data.SqlClient.SqlCommand.FinishExecuteReader(SqlDataReader ds, RunBehavior runBehavior, String resetOptionsString, Boolean isInternal, Boolean forDescribeParameterEncryption, Boolean shouldCacheForAlwaysEncrypted)     at System.Data.SqlClient.SqlCommand.RunExecuteReaderTds(CommandBehavior cmdBehavior, RunBehavior runBehavior, Boolean returnStream, Boolean async, Int32 timeout, Task& task, Boolean asyncWrite, Boolean inRetry, SqlDataReader ds, Boolean describeParameterEncryptionRequest)     at System.Data.SqlClient.SqlCommand.RunExecuteReader(CommandBehavior cmdBehavior, RunBehavior runBehavior, Boolean returnStream, String method, TaskCompletionSource`1 completion, Int32 timeout, Task& task, Boolean& usedCache, Boolean asyncWrite, Boolean inRetry)     at System.Data.SqlClient.SqlCommand.InternalExecuteNonQuery(TaskCompletionSource`1 completion, String methodName, Boolean sendToPipe, Int32 timeout, Boolean& usedCache, Boolean asyncWrite, Boolean inRetry)     at System.Data.SqlClient.SqlCommand.ExecuteNonQuery()     at Numero.CodeAPI.App_.Main.IdentifyTargetResource(Int32 addressLinkId, String refNum, Int32& residenceId, Int32& linkResId) in codify://NoddleWorkflow/Region_Repository:line 1532     at Numero.CodeAPI.App_.Main.RemoveAddressLinks(Int32 addressLinkId, DisputeCase disputeCase) in codify://NoddleWorkflow/Region_Repository:line 1452


select * from stash.disputecase 
ORDER BY 1 DESC


select * from stash.disputetypes

select * from  [Stash].[slanotifications] sla

--where disputeCaseId = 5107
order by 1 desc


select dc.numeroCaseRef, sla.* from  [Stash].[slanotifications] sla
INNER JOIN stash.disputecase dc
	on dc.Id = sla.disputeCaseId
ORDER BY Id DESC


select * from stash.datascopes

update stash.datascopes set organisationId = '1489c490-9e6c-44fd-81db-9d06e938eb83', organisationUnitId = 'd6423278-4f1e-4913-b2bd-40f320e8cce6'
where Id = '1489@p.id' and idAsInteger = 1489