select * from setup.ApplicationConfigurationData
where type = 'databases'
{"type":"sql-server", "connectionString": "Data Source=pllwininsql010.cig.local,24212;Initial Catalog=NODDLE_SIT_DB04;User ID=smartagent;Password=PhUZ6ngjVn"}

SELECT TOP 500 * FROM CodeAPI.TraceOutputs ORDER BY Time DESC

update stash.disputecase set caseStateId = 8, caseStateDescription = 'Rejected (Auto)', closedDate = '2018-09-11T10:04:19.403108Z' 
where Id IN (360, 350, 329, 328, 303)

update stash.disputecase set caseStateId = 8, caseStateDescription = 'Rejected (Auto)', closedDate = '2018-09-11T10:04:19.403108Z' 
where Id IN (359, 327, 319, 316, 315, 311, 302)
-- did 169 incorrectly


select * from stash.soaprequests
ORDER BY 1 DESC

select * from stash.disputecase 
ORDER BY 1 DESC

select * from stash.suppliers
ORDER BY 1 DESC

select * from stash.datascopes


where supplierId = 193
where supplierId = 214

Id	idAsInteger	ETag	scopeType	memberPortId	memberPortfolioNumber	memberPortfolioName	organisationId	organisationName	organisationUnitId	organisationUnitName	supplierId	isActive	_stash_changeTime	RulesetVersion
1301@p.id	1301	0x00000000000A68EC	MemberPortfolio	0	316621	Better Mortgages	NULL	NULL	NULL	NULL	193	1	2019-04-02 15:13:42.120	57

-- update for hema 03/04/2019
update stash.datascopes set memberPortfolioNumber = 999901  where memberPortfolioNumber = '9999-01'

update stash.datascopes set memberPortfolioNumber = '9999-01'  where memberPortfolioNumber = 999901  

update stash.datascopes set memberPortfolioNumber = 412335  where memberPortfolioNumber = 112

select * from stash.datascopes where memberPortfolioNumber = 112


-- update for hema 03/04/2019
update stash.datascopes set memberPortId = 0 where  memberPortfolioNumber = 999901



select * from stash.datascopes 
where supplierId = 214


9999-01
9999-01


and organisationUnitName = 'Jack Russel Plc (CVAL Batch, SA)'

update stash.datascopes
set organisationId = '1489C490-9E6C-44FD-81DB-9D06E938EB83', organisationUnitId = '3913F0D7-B56D-44C2-A4A2-583E01F363CF'
where supplierId = 214
and organisationUnitName = 'Callreport Summary Section Tests'

update stash.datascopes
set organisationId = '1489C490-9E6C-44FD-81DB-9D06E938EB83', organisationUnitId = 'D6423278-4F1E-4913-B2BD-40F320E8CCE6'
where supplierId = 214
and Id = '1489@p.id' 



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
