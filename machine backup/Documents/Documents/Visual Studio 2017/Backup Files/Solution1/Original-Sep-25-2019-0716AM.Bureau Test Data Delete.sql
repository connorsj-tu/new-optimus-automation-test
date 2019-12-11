--select * from [CCRMain].dbo.PersonAliasSource

BEGIN TRANSACTION;

declare @LoadId varchar(6);
declare @LoadId2 varchar(6);

set @LoadId = '500115';
set @LoadId2 = '500115';

UPDATE [CCRAccount_412335].[dbo].SharedAccount SET Deleted = 1, ULoadId = @LoadId2 Where ULoadId LIKE @LoadId;
UPDATE [CCRAccount_412335].[dbo].AccountHistory SET Deleted = 1, ULoadId = @LoadId2 Where ULoadId LIKE @LoadId;
UPDATE [CCRAccount_412335].[dbo].ShAccFinancials SET Deleted = 1, ULoadId = @LoadId2 Where ULoadId LIKE @LoadId;
UPDATE [CCRAccount_412335].[dbo].ShAccHolder SET Deleted = 1, ULoadId = @LoadId2 Where ULoadId LIKE @LoadId;
UPDATE [CCRAccount_412335].[dbo].ShAccHolderDetails SET Deleted = 1, ULoadId = @LoadId2 Where ULoadId LIKE @LoadId;

UPDATE [CCRMain].[dbo].ER SET Deleted = 1, ULoadId = @LoadId2 Where ULoadId LIKE @LoadId;
UPDATE [CCRMain].[dbo].CCJ SET Deleted = 1, ULoadId = @LoadId2 Where ULoadId LIKE @LoadId;
UPDATE [CCRMain].[dbo].CCJCasePerson SET Deleted = 1, ULoadId = @LoadId2 Where ULoadId LIKE @LoadId;
UPDATE [CCRMain].[dbo].CCJCase SET Deleted = 1, ULoadId = @LoadId2 Where ULoadId LIKE @LoadId;
UPDATE [CCRMain].[dbo].AssociationSource SET Deleted = 1, ULoadId = @LoadId2 Where ULoadId LIKE @LoadId;
UPDATE [CCRMain].[dbo].Association SET Deleted = 1, ULoadId = @LoadId2 Where ULoadId LIKE @LoadId;
UPDATE [CCRMain].[dbo].PersonAliasSource SET Deleted = 1, ULoadId = @LoadId2 Where ULoadId LIKE @LoadId;
UPDATE [CCRMain].[dbo].PersonAlias SET Deleted = 1, ULoadId = @LoadId2 Where ULoadId LIKE @LoadId;
UPDATE [CCRMain].[dbo].AddressLinkSource SET Deleted = 1, ULoadId = @LoadId2 Where ULoadId LIKE @LoadId;
UPDATE [CCRMain].[dbo].AddressLink SET Deleted = 1, ULoadId = @LoadId2 Where ULoadId LIKE @LoadId;
UPDATE [CCRMain].[dbo].Residence SET Deleted = 1, ULoadId = @LoadId2 Where ULoadId LIKE @LoadId;
UPDATE [CCRMain].[dbo].Person SET Deleted = 1, ULoadId = @LoadId2 Where ULoadId LIKE @LoadId;
UPDATE [CCRMain].[dbo].Individual SET Deleted = 1, ULoadId = @LoadId2 Where ULoadId LIKE @LoadId;
UPDATE [CCRMain].[dbo].Domicile SET Deleted = 1, ULoadId = @LoadId2 Where ULoadId LIKE @LoadId;
UPDATE [CCRMain].[dbo].Locality SET Deleted = 1, ULoadId = @LoadId2 Where ULoadId LIKE @LoadId;

COMMIT;

BEGIN TRANSACTION;

DELETE FROM [CCRAccount_412335].[dbo].ShAccHolderDetails WHERE ULoadId LIKE @LoadId;
DELETE FROM [CCRAccount_412335].[dbo].ShAccHolder WHERE ULoadId LIKE @LoadId;
DELETE FROM [CCRAccount_412335].[dbo].ShAccFinancials WHERE ULoadId LIKE @LoadId;
DELETE FROM [CCRAccount_412335].[dbo].AccountHistory WHERE ULoadId LIKE @LoadId;
DELETE FROM [CCRAccount_412335].[dbo].SharedAccount WHERE ULoadId LIKE @LoadId;

DELETE FROM [CCRMain].[dbo].ERSrc WHERE LoadId LIKE @LoadId;
DELETE FROM [CCRMain].[dbo].ER WHERE ULoadId LIKE @LoadId;
DELETE FROM [CCRMain].[dbo].CCJ WHERE ULoadId LIKE @LoadId;
DELETE FROM [CCRMain].[dbo].CCJCasePerson WHERE ULoadId LIKE @LoadId;
DELETE FROM [CCRMain].[dbo].CCJCase WHERE ULoadId LIKE @LoadId;
DELETE FROM [CCRMain].[dbo].AssociationSource WHERE ULoadId LIKE @LoadId;
DELETE FROM [CCRMain].[dbo].Association WHERE ULoadId LIKE @LoadId;
DELETE FROM [CCRMain].[dbo].PersonAliasSource WHERE ULoadId LIKE @LoadId;
DELETE FROM [CCRMain].[dbo].PersonAlias WHERE ULoadId LIKE @LoadId;
DELETE FROM [CCRMain].[dbo].InsolvencyOrderHistory WHERE ULoadId LIKE @LoadId;
DELETE FROM [CCRMain].[dbo].InsolvencyOrderPerson WHERE ULoadId LIKE @LoadId;
DELETE FROM [CCRMain].[dbo].InsolvencyOrderAddress WHERE ULoadId LIKE @LoadId;
DELETE FROM [CCRMain].[dbo].InsolvencyOrder WHERE ULoadId LIKE @LoadId;
DELETE FROM [CCRMain].[dbo].AddressLinkSource WHERE ULoadId LIKE @LoadId;
DELETE FROM [CCRMain].[dbo].AddressLink WHERE ULoadId LIKE @LoadId;
DELETE FROM [CCRMain].[dbo].Residence WHERE ULoadId LIKE @LoadId;
DELETE FROM [CCRMain].[dbo].Person WHERE ULoadId LIKE @LoadId;
DELETE FROM [CCRMain].[dbo].Individual WHERE ULoadId LIKE @LoadId;
DELETE FROM [CCRMain].[dbo].Domicile WHERE ULoadId LIKE @LoadId;
DELETE FROM [CCRMain].[dbo].Locality WHERE ULoadId LIKE @LoadId;

COMMIT;
/*

select max(LocalityId) from dbo.Locality
select max(PersonId) from dbo.Person

select * from dbo.Locality where LocalityId = 1014416

BEGIN
SET IDENTITY_INSERT dbo.Locality ON
insert into dbo.Locality (LocalityId, Locality, Town, Deleted, CLoadId, ULoadId) values (1023259, 'HALIFAX', 'WEST YORKSHIRE', 0, 500000, 500000)
GO

SET IDENTITY_INSERT dbo.Locality OFF
1023259


select * from dbo.Person where PersonId = 155645371
155645371
2147483401

SET IDENTITY_INSERT dbo.Person OFF
insert into dbo.Person (PersonId, TitleId, NameSuffixId, Surname, Forename, Sex, Deleted, CLoadId, CSrcId, ULoadId, USrcId, UProcId, DoBirth, IndividualId)
values (2147483401, 3, 15, 'BOWES', 'JLILY', 'F', 0, 500000, 1, 500000, 1, 500000, '2001-01-18', NULL)

select max(InsolvencyOrderHistoryId) from dbo.InsolvencyOrderHistory
select * from dbo.InsolvencyOrderHistory where InsolvencyOrderHistoryId = 3269132
 3274362
 3269132

 SET IDENTITY_INSERT dbo.InsolvencyOrderHistory ON
insert into dbo.InsolvencyOrderHistory (InsolvencyOrderHistoryId, InsolvencyOrderId, InsolvencyOrderStatusId, CourtId, CaseReference, CaseYear, SequenceNum, CLoadId, CSrcId, ULoadId, USrcId)
values ( 3274362, 1733078, 1, 294, 202804, 2017, 1, 500000, 1, 500000, 1)
 SET IDENTITY_INSERT dbo.InsolvencyOrderHistory OFF


 select max(CCJCaseId) from dbo.CCJCase
select * from dbo.CCJCase where CCJCaseId = 78788003
 dbo.tblCCJCase
CCJCaseId
 78789429
 78788003

  SET IDENTITY_INSERT dbo.CCJCase ON
insert into dbo.CCJCase (CCJCaseId, CourtId, PersonsInvolved, CaseNumber, CCJTypeId, Country, Deleted, CLoadId, CSrcId, ULoadId, USrcId, UProcId, CaseKey, Displayed, HCJ)
values ( 78789429, 123, 'S', 'ABC115', 1, '', 0, 500000, 1, 500000, 1, NULL, 201801020000115, 1, NULL)
 SET IDENTITY_INSERT dbo.CCJCase OFF

  select max(CCJCasePerId) from dbo.CCJCasePerson
select * from dbo.CCJCasePerson where CCJCasePerId = 80008948
 80010378
 80008948

   SET IDENTITY_INSERT dbo.CCJCasePerson ON
insert into dbo.CCJCasePerson (CCJCasePerId, CCJCaseId, ResidenceId, CurrentStatus, CLoadId, CSrcId, ULoadId, USrcId, UProcId, Deleted, Displayed, DefendantId, InputDataHash)
values ( 80010378, 78788003, 219263844, 'JG', 500000, 1, 500000, 1, 500000, 0, 1, 12344321, NULL)
 SET IDENTITY_INSERT dbo.CCJCasePerson OFF


   select max(CCJId) from dbo.CCJ
select * from dbo.CCJ where CCJId = 16072919
 16074426
 16072919

    SET IDENTITY_INSERT dbo.CCJ ON
insert into dbo.CCJ (CCJId, CCJStatus, Title, Forename, Surname, Address, JudgementAmount, FilmNum, ImageNum, CameraNum, Deleted, CLoadId, CSrcId, ULoadId, USrcId, UProcId, CCJCasePerId, JudgeDate, SatCancDate, Displayed, DoBirth)
values (16074430, 'JG', 'MRS', 'LILY', 'BOWES', '4 CLARE COURT, PRESCOTT STREET, HALIFAX, HX1 2QA', 50, 1, 1, 1, 0, 500000, 1, 500000, 1, 500000, 80008948, '2017-01-20', '2018-01-20', 1, '2001-01-18')
 SET IDENTITY_INSERT dbo.CCJ OFF
 commit;

 */

 