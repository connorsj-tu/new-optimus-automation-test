/****** Script for SelectTopNRows command from SSMS  ******/
SELECT TOP (1000) [acsSearchID]
      ,[acsAuditDateTime]
      ,[acsUserId]
      ,[acsUserName]
      ,[acsUserType]
      ,[acsDBAIUserID]
      ,[acsOrganisationId]
      ,[acsOrganisationName]
      ,[acsOrgUnitID]
      ,[acsOrgUnitType]
      ,[acsOrgUnitName]
      ,[acsDBAIMainSubID]
      ,[acsDBAIUserSubID]
      ,[acsSummarisedBilling]
      ,[acsSearchPurpose]
      ,[acsAccountType]
      ,[acsBalanceLimit]
      ,[acsLoanTerm]
      ,[acsJointApplication]
      ,[acsScoreIncluded]
      ,[acsSecondarySearch]
      ,[acsRecordDeleted]
      ,[acsRecordAmended]
      ,[acsCompanyName]
      ,[acsParentSearchID]
      ,[acsBSBRequested]
      ,[acsReportRequested]
      ,[acsScoreRequested]
      ,[acsAmendedSearch]
      ,[acsRequestVersion]
      ,[acsScorecardTypeID]
      ,[acsAlertLevel]
      ,[acsAlertTriggerType]
      ,[acsAutoSrchAssocDeclAddr]
      ,[acsAutoSrchAssocUndeclAddr]
      ,[acsLinkType]
      ,[acsCIFASSelectiveMatching]
      ,[acsTransientAssociation]
      ,[acsLinkNavID]
      ,[acsSecondaryLinkSearch]
      ,[acsScorecardClassID]
      ,[acsAutoSearchAddrLink]
      ,[acsAutoSearchMax]
      ,[acsAutoSearchOverriddenMax]
      ,[acsSystemVersion]
      ,[acsEntryPoint]
      ,[acsReportComponent]
      ,[acsYourReference]
      ,[acsBSBSearchFilterId]
      ,[acsExcludeOwnData]
      ,[acsCifasPlusFormat]
      ,[acsCifasDMR]
      ,[acsRTRDataRequested]
      ,[acsMultipleScores]
      ,[acsDataDNARequested]
      ,[acsMRN]
      ,[acsDeceased]
  FROM [Audit].[dbo].[tblAuditCreditSearches]
  where acsSearchID in ('C5554AEB-C91E-449E-AB49-B210C83F16B9',
'77D56F08-81DF-48E5-A15F-534FBD0B744E',
'239B5619-B766-4858-89F4-CE335CC8E07F',
'A2C66C5D-ACF3-42F1-9DB3-3E44496E5AC2',
'8DF22FFE-6D11-4AED-864C-393A39B8CE0E',
'FAE51D8B-FE98-48E9-A421-13D7E303423C',
'367E4243-09B6-4615-A452-A2531C956A15',
'ABA18CA3-E01F-49CA-833D-666C3F7B933C'
)


acsOrganisationId	acsOrganisationName	acsOrgUnitID
06C63BA7-AE74-4D7E-BD05-D55A2C3B9C20	

'AF92F32E-356C-4B08-B858-CBE22C27FECF'
'7A2917E7-D413-4B01-BA8E-4488C8C7768E'
