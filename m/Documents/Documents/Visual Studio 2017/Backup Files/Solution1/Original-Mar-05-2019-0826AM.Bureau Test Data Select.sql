BEGIN TRANSACTION;

declare @LoadId varchar(6);
declare @LoadId2 varchar(6);

set @LoadId = '654321';
set @LoadId2 = '654321';

SELECT * FROM [CCRMain].[dbo].CCJ WHERE ULoadId LIKE @LoadId;
SELECT * FROM [CCRMain].[dbo].CCJCasePerson WHERE ULoadId LIKE @LoadId;
SELECT * FROM [CCRMain].[dbo].CCJCase WHERE ULoadId LIKE @LoadId;


SELECT * FROM [CCRMain].[dbo].ERSrc WHERE LoadId LIKE @LoadId;
SELECT * FROM [CCRMain].[dbo].ER WHERE ULoadId LIKE @LoadId;
SELECT * FROM [CCRMain].[dbo].CCJ WHERE ULoadId LIKE @LoadId;
SELECT * FROM [CCRMain].[dbo].CCJCasePerson WHERE ULoadId LIKE @LoadId;
SELECT * FROM [CCRMain].[dbo].CCJCase WHERE ULoadId LIKE @LoadId;
SELECT * FROM [CCRMain].[dbo].AssociationSource WHERE ULoadId LIKE @LoadId;
SELECT * FROM [CCRMain].[dbo].Association WHERE ULoadId LIKE @LoadId;
SELECT * FROM [CCRMain].[dbo].PersonAliasSource WHERE ULoadId LIKE @LoadId;
SELECT * FROM [CCRMain].[dbo].PersonAlias WHERE ULoadId LIKE @LoadId;
SELECT * FROM [CCRMain].[dbo].InsolvencyOrderPerson WHERE ULoadId LIKE @LoadId;
SELECT * FROM [CCRMain].[dbo].InsolvencyOrderAddress WHERE ULoadId LIKE @LoadId;
SELECT * FROM [CCRMain].[dbo].InsolvencyOrder WHERE ULoadId LIKE @LoadId;
SELECT * FROM [CCRMain].[dbo].AddressLinkSource WHERE ULoadId LIKE @LoadId;
SELECT * FROM [CCRMain].[dbo].AddressLink WHERE ULoadId LIKE @LoadId;
SELECT * FROM [CCRMain].[dbo].Residence WHERE ULoadId LIKE @LoadId;
SELECT * FROM [CCRMain].[dbo].Person WHERE ULoadId LIKE @LoadId;
SELECT * FROM [CCRMain].[dbo].Individual WHERE ULoadId LIKE @LoadId;
SELECT * FROM [CCRMain].[dbo].Domicile WHERE ULoadId LIKE @LoadId;
SELECT * FROM [CCRMain].[dbo].Locality WHERE ULoadId LIKE @LoadId;

COMMIT;



SELECT * FROM [CCRMain].[DataAmendInterface].[JudgmentNoticeOfDisputeAudit]
ORDER BY DateTimeStamp DESC

SELECT * FROM [CCRMain].[DataAmendInterface].[JudgmentSuppressionAudit]
ORDER BY DateTimeStamp DESC


SELECT * FROM [CCRMain].[dbo].[DisputeStaging] ORDER BY DisputeDate DESC
SELECT * FROM [CCRMain].[dbo].[CCJDisputeStaging]
SELECT * FROM [CCRMain].[DataAmendInterface].[JudgmentNoticeOfDisputeAudit] ORDER BY DateTimeStamp DESC



SELECT * FROM [CCRMain].[dbo].[DisputeStaging] ORDER BY DisputeDate DESC
SELECT * FROM [CCRMain].[dbo].[PersonAliasDisputeStaging] ORDER BY AliasId DESC
SELECT * FROM [CCRMain].[DataAmendInterface].[PersonAliasNoticeOfDisputeAudit] ORDER BY DateTimeStamp DESC

SELECT * FROM [CCRMain].[dbo].[DisputeStaging] ORDER BY RefNum DESC
SELECT * FROM [CCRMain].[dbo].[InsolvencyOrderDisputeStaging] ORDER BY InsolvencyOrderId DESC
SELECT * FROM [CCRMain].[DataAmendInterface].[InsolvencyOrderNoticeOfDisputeAudit] Where InsolvencyOrderId like '1712%' ORDER BY InsolvencyOrderId DESC

/****** Script for SelectTopNRows command from SSMS  ******/
SELECT * FROM [CCRMain].[dbo].[CCJDispute]
  ORDER BY 2 DESC



  SELECT * FROM [CCRMain].[dbo].[DisputeStaging] ORDER BY RefNum DESC
SELECT * FROM [CCRMain].[dbo].[AddressLinkDisputeStaging] ORDER BY SourceId DESC
SELECT * FROM [CCRMain].[DataAmendInterface].[PopulationMapAddressLinkNoticeOfDisputeAudit] ORDER BY DateTimeStamp DESC

SELECT * FROM [CCRMain].[dbo].[DisputeStaging] ORDER BY RefNum DESC
SELECT * FROM [CCRMain].[dbo].[ShAccHolderDisputeStaging] ORDER BY SourceId DESC


SELECT * FROM [CCRMain].[dbo].[DisputeStaging] 
WHERE RefNum like 31



SELECT * FROM [CCRMain].[dbo].[DisputeStaging] WHERE RefNum = 68 ORDER BY RefNum DESC
SELECT * FROM [CCRMain].[dbo].[InsolvencyOrderDisputeStaging] WHere InsolvencyOrderId = 1712869 ORDER BY InsolvencyOrderId DESC
SELECT * FROM [CCRMain].[DataAmendInterface].[InsolvencyOrderNoticeOfDisputeAudit] Where InsolvencyOrderId like '1712869' ORDER BY InsolvencyOrderId DESC


SELECT * FROM [CCRMain].[dbo].[DisputeStaging] ORDER BY RefNum DESC
SELECT * FROM [CCRMain].[dbo].[AddressLinkDisputeStaging] ORDER BY SourceId DESC
SELECT * FROM [CCRMain].[DataAmendInterface].[PopulationMapAddressLinkNoticeOfDisputeAudit] ORDER BY SourceId DESC

select count(* )from [CCRMain].[dbo].[DisputeStaging]



select count(* ) from [CCRMain].[DataAmendInterface].[AssociationNoticeOfDisputeAudit]
select count(* ) from [CCRMain].[DataAmendInterface].[AssociationSuppressionAudit]
select count(* ) from [CCRMain].[DataAmendInterface].[ElectoralRollNoticeOfDisputeAudit]
select count(* ) from [CCRMain].[DataAmendInterface].[ElectoralRollSuppressionAudit]
select count(* ) from [CCRMain].[DataAmendInterface].[GRONoticeOfDisputeAudit]
select count(* ) from [CCRMain].[DataAmendInterface].[GROSuppressionAudit]
select count(* ) from [CCRMain].[DataAmendInterface].[HALONoticeOfDisputeAudit]
select count(* ) from [CCRMain].[DataAmendInterface].[HALOSuppressionAudit]
select count(* ) from [CCRMain].[DataAmendInterface].[InsolvencyOrderNoticeOfDisputeAudit]
select count(* ) from [CCRMain].[DataAmendInterface].[InsolvencyOrderSuppressionAudit]
select count(* ) from [CCRMain].[DataAmendInterface].[JudgmentNoticeOfDisputeAudit]
select count(* ) from [CCRMain].[DataAmendInterface].[JudgmentSuppressionAudit]
select count(* ) from [CCRMain].[DataAmendInterface].[PersonAliasNoticeOfDisputeAudit]
select count(* ) from [CCRMain].[DataAmendInterface].[PopulationMapAddressLinkNoticeOfDisputeAudit]
select count(* ) from [CCRMain].[DataAmendInterface].[PopulationMapResidenceNoticeOfDisputeAudit]
select count(* ) from [CCRMain].[dbo].[AddressDispute]
select count(* ) from [CCRMain].[dbo].[AddressDisputeStaging]
select count(* ) from [CCRMain].[dbo].[AddressLinkDispute]
select count(* ) from [CCRMain].[dbo].[AddressLinkDisputeStaging]
select count(* ) from [CCRMain].[dbo].[AssociationDispute]
select count(* ) from [CCRMain].[dbo].[AssociationDisputeStaging]
select count(* ) from [CCRMain].[dbo].[AssociationSuppressionStaging]
select count(* ) from [CCRMain].[dbo].[BAIDispute]
select count(* ) from [CCRMain].[dbo].[BAIDisputeStaging]
select count(* ) from [CCRMain].[dbo].[CCJDispute]
select count(* ) from [CCRMain].[dbo].[CCJDisputeStaging]
select count(* ) from [CCRMain].[dbo].[CCJSuppressionStaging]
select count(* ) from [CCRMain].[dbo].[CifasDispute]
select count(* ) from [CCRMain].[dbo].[CifasDisputeStaging]
select count(* ) from [CCRMain].[dbo].[Dispute]
select count(* ) from [CCRMain].[dbo].[DisputeStaging]
select count(* ) from [CCRMain].[dbo].[ERDispute]
select count(* ) from [CCRMain].[dbo].[ERDisputeStaging]
select count(* ) from [CCRMain].[dbo].[GRODispute]
select count(* ) from [CCRMain].[dbo].[GRODisputeStaging]
select count(* ) from [CCRMain].[dbo].[HALODispute]
select count(* ) from [CCRMain].[dbo].[HALODisputeStaging]
select count(* ) from [CCRMain].[dbo].[InsolvencyOrderDispute]
select count(* ) from [CCRMain].[dbo].[InsolvencyOrderDisputeStaging]
select count(* ) from [CCRMain].[dbo].[InsolvencyOrderSuppressionStaging]
select count(* ) from [CCRMain].[dbo].[NameDispute]
select count(* ) from [CCRMain].[dbo].[NameDisputeStaging]
select count(* ) from [CCRMain].[dbo].[PersonAliasDispute]
select count(* ) from [CCRMain].[dbo].[PersonAliasDisputeStaging]
select count(* ) from [CCRMain].[dbo].[ResidenceDispute]
select count(* ) from [CCRMain].[dbo].[ResidenceDisputeStaging]
select count(* ) from [CCRMain].[dbo].[ShAccHolderDispute]
select count(* ) from [CCRMain].[dbo].[ShAccHolderDisputeStaging]
select count(* ) from [CCRMain].[dbo].[ShAccHolderSuppressionStatus]

DELETE FROM [CCRMain].[dbo].[AddressDispute]

select * from [CCRMain].[DataAmendInterface].[AssociationNoticeOfDisputeAudit]
select * from [CCRMain].[DataAmendInterface].[AssociationSuppressionAudit]
select * from [CCRMain].[DataAmendInterface].[ElectoralRollNoticeOfDisputeAudit]
select * from [CCRMain].[DataAmendInterface].[ElectoralRollSuppressionAudit]
select * from [CCRMain].[DataAmendInterface].[GRONoticeOfDisputeAudit]
select * from [CCRMain].[DataAmendInterface].[GROSuppressionAudit]
select * from [CCRMain].[DataAmendInterface].[HALONoticeOfDisputeAudit]
select * from [CCRMain].[DataAmendInterface].[HALOSuppressionAudit]
select * from [CCRMain].[DataAmendInterface].[InsolvencyOrderNoticeOfDisputeAudit]
select * from [CCRMain].[DataAmendInterface].[InsolvencyOrderSuppressionAudit]
select * from [CCRMain].[DataAmendInterface].[JudgmentNoticeOfDisputeAudit]
select * from [CCRMain].[DataAmendInterface].[JudgmentSuppressionAudit]
select * from [CCRMain].[DataAmendInterface].[PersonAliasNoticeOfDisputeAudit]
select * from [CCRMain].[DataAmendInterface].[PopulationMapAddressLinkNoticeOfDisputeAudit]
select * from [CCRMain].[DataAmendInterface].[PopulationMapResidenceNoticeOfDisputeAudit]
select * from [CCRMain].[dbo].[AddressDispute]
select * from [CCRMain].[dbo].[AddressDisputeStaging]
select * from [CCRMain].[dbo].[AddressLinkDispute]
select * from [CCRMain].[dbo].[AddressLinkDisputeStaging]
select * from [CCRMain].[dbo].[AssociationDispute]
select * from [CCRMain].[dbo].[AssociationDisputeStaging]
select * from [CCRMain].[dbo].[AssociationSuppressionStaging]
select * from [CCRMain].[dbo].[BAIDispute]
select * from [CCRMain].[dbo].[BAIDisputeStaging]
select * from [CCRMain].[dbo].[CCJDispute]
select * from [CCRMain].[dbo].[CCJDisputeStaging]
select * from [CCRMain].[dbo].[CCJSuppressionStaging]
select * from [CCRMain].[dbo].[CifasDispute]
select * from [CCRMain].[dbo].[CifasDisputeStaging]
select * from [CCRMain].[dbo].[Dispute]
select * from [CCRMain].[dbo].[DisputeStaging]
select * from [CCRMain].[dbo].[ERDispute]
select * from [CCRMain].[dbo].[ERDisputeStaging]
select * from [CCRMain].[dbo].[GRODispute]
select * from [CCRMain].[dbo].[GRODisputeStaging]
select * from [CCRMain].[dbo].[HALODispute]
select * from [CCRMain].[dbo].[HALODisputeStaging]
select * from [CCRMain].[dbo].[InsolvencyOrderDispute]
select * from [CCRMain].[dbo].[InsolvencyOrderDisputeStaging]
select * from [CCRMain].[dbo].[InsolvencyOrderSuppressionStaging]
select * from [CCRMain].[dbo].[NameDispute]
select * from [CCRMain].[dbo].[NameDisputeStaging]
select * from [CCRMain].[dbo].[PersonAliasDispute]
select * from [CCRMain].[dbo].[PersonAliasDisputeStaging]
select * from [CCRMain].[dbo].[ResidenceDispute]
select * from [CCRMain].[dbo].[ResidenceDisputeStaging]
select * from [CCRMain].[dbo].[ShAccHolderDispute]
select * from [CCRMain].[dbo].[ShAccHolderDisputeStaging]
select * from [CCRMain].[dbo].[ShAccHolderSuppressionStatus]


DELETE FROM [CCRMain].[dbo].[AddressDisputeStaging]
DELETE FROM [CCRMain].[dbo].[AddressLinkDisputeStaging]
DELETE FROM [CCRMain].[dbo].[AssociationDisputeStaging]
DELETE FROM [CCRMain].[dbo].[AssociationSuppressionStaging]
DELETE FROM [CCRMain].[dbo].[BAIDisputeStaging]
DELETE FROM [CCRMain].[dbo].[CCJDisputeStaging]
DELETE FROM [CCRMain].[dbo].[CCJSuppressionStaging]
DELETE FROM [CCRMain].[dbo].[CifasDisputeStaging]
DELETE FROM [CCRMain].[dbo].[DisputeStaging]
DELETE FROM [CCRMain].[dbo].[ERDisputeStaging]
DELETE FROM [CCRMain].[dbo].[GRODisputeStaging]
DELETE FROM [CCRMain].[dbo].[HALODisputeStaging]
DELETE FROM [CCRMain].[dbo].[InsolvencyOrderDisputeStaging]
DELETE FROM [CCRMain].[dbo].[InsolvencyOrderSuppressionStaging]
DELETE FROM [CCRMain].[dbo].[NameDisputeStaging]
DELETE FROM [CCRMain].[dbo].[PersonAliasDisputeStaging]
DELETE FROM [CCRMain].[dbo].[ResidenceDisputeStaging]
DELETE FROM [CCRMain].[dbo].[ShAccHolderDisputeStaging]

commit;


select * from [CCRMain].[dbo].[ShAccHolderDispute]
