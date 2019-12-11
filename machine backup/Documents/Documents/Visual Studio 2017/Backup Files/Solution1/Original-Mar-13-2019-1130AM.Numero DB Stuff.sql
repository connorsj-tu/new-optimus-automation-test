select * from setup.ApplicationConfigurationData
where type = 'databases'
{"type":"sql-server", "connectionString": "Data Source=pllwininsql010.cig.local,24212;Initial Catalog=NODDLE_SIT_DB04;User ID=smartagent;Password=PhUZ6ngjVn"}

SELECT TOP 500 * FROM CodeAPI.TraceOutputs ORDER BY Time DESC

update stash.disputecase set caseStateId = 8, caseStateDescription = 'Rejected (Auto)', closedDate = '2018-09-11T10:04:19.403108Z' 
where Id IN (360, 350, 329, 328, 303)

update stash.disputecase set caseStateId = 8, caseStateDescription = 'Rejected (Auto)', closedDate = '2018-09-11T10:04:19.403108Z' 
where Id IN (359, 327, 319, 316, 315, 311, 302)
-- did 169 incorrectly

select * from stash.disputecase 
ORDER BY 1 DESC

select id, caseStateDescription from stash.disputecase 
ORDER BY 1 DESC


select * from stash.disputecase 
where caseStateDescription like 'In Triage'
ORDER BY 1 DESC

select * from stash.datascopes
where supplierId = 214
and organisationUnitName = 'Jack Russel Plc (CVAL Batch, SA)'

update stash.datascopes
set organisationId = '7f9a5180-b992-485e-84e6-9bf738be0a84', organisationUnitId = '9bad18a0-4353-44d2-afb2-74eacb2f4e8e'
where supplierId = 214
and organisationUnitName = 'Jack Russel Plc (CVAL Batch, SA)'

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

select * from stash.consumerplatformnotifications
where disputeCaseId in (321, 330, 331, 332, 333, 334, 335)
order by disputeCaseId desc  

select * from stash.consumerplatformnotifications
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

select * from stash.dataupdatequeue ORDER BY 1 DESC

select * from stash.dataupdatequeue ORDER BY 1 DESC
select * from stash.dataupdatequeue__storedProcedureParameters  ORDER BY 4 DESC

select * from stash.dataupdatequeue 
WHERE disputeCaseId in
(288)
ORDER BY 1 DESC

select * from stash.dataupdatequeue 
WHERE disputeCaseId in
(26)
ORDER BY 1 DESC




  
CYCLE1;
select * from stash.dataupdatequeue 
WHERE disputeCaseId in (181)
ORDER BY 1 DESC


select * from stash.dataupdatequeue__storedProcedureParameters  
where dataupdatequeue_Id in (
select id from stash.dataupdatequeue 
WHERE disputeCaseId in
(181)
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
