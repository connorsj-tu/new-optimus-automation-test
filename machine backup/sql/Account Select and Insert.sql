
SELECT TOP (1000) *
  FROM [CCRAccount_412335].[dbo].[SharedAccount];

SET IDENTITY_INSERT[dbo].[SharedAccount] ON
insert into [dbo].[SharedAccount]
(AccountId, Member_PortId,Delinquent,WorstPs12,WorstPs24,WorstPsAlltime,DataSupplierType,DataSupplierId,AccountTypeId,AccNumber,OldAccNumber,XfDataSupplierType,XfDataSupplierId,XfAccountTypeId,XfAccNumber,ChAccNumber,LenderType,LenderName,Currency,RunDataFlag,RunModifiedFlag,DetailsDate,RunStatusCreated,RunStatusUpdated,RunStatusClosed,RunStatusRemoved,RunStatusACreated,RunStatusDCreated,UnmatchedActiveFlag,AccountStartDate,AccountEndDate,AccHoldCount,AccountSM,CurrentStatus,AccountOC,OnlineSuppressed,Display,Deleted,CLoadId,CSrcId,ULoadId,USrcId,UProcId,MaxHistSeq,MaxActHistSeq)
VALUES('100000000', '112','FALSE','0','0','0','BK','17','24','00A/120568','0',NULL,NULL,NULL,'0','BLANK','BK','HALIFAX','GBP','FALSE','FALSE','2018-01-01','FALSE','FALSE','FALSE','FALSE','FALSE','FALSE','FALSE','1999-07-30',NULL,'1','FALSE','N','0','FALSE','TRUE','FALSE','654320','1','654320','1',NULL,'2','1')
SET IDENTITY_INSERT[dbo].[SharedAccount] OFF





SELECT TOP (1000) *
  FROM [CCRAccount_412335].[dbo].ShAccFinancials;

SET IDENTITY_INSERT[dbo].ShAccFinancials ON
insert into dbo.ShAccFinancials 
(ShAccFinId, AccountId,Member_PortId,HistSequenceEnd,CreditLimit,OpeningBalance,FinStartDate,FinEndDate,PayStartDate,RepayPeriod,PaymentFrequency,RegularPayment,ExpectedPayment,ActualPayment,PenInterest,EndingBalance,LumpPayment,ActionDate,AccountClass,HistSequenceStart,Deleted,CLoadId  ,CSrcId,ULoadId  ,USrcId,UProcId)
VALUES('100000000', '100000000','112','1','1000','100','2018-07-28',NULL,NULL,'52','M','50','50','50','1',NULL,'150',NULL,'N','','FALSE','654330','1','65433','1','654330')
SET IDENTITY_INSERT[dbo].ShAccFinancials OFF




SELECT TOP (1000) *
  FROM [CCRAccount_412335].[dbo].ShAccHolder;

SET IDENTITY_INSERT[dbo].ShAccHolder ON
insert into dbo.ShAccHolder
(ShAccHolderId,AccountId,Member_PortId,AccSuffix,OldAccSuffix,XfAccSuffix,ChAccSuffix,ResidenceId,AccHldStartDate,AccHldEndDate,AccHldStartId,AccHldEndId,AccHldStatus,DateOfBirth,TransientFlag,AccHoldBalance,RunModifiedFlag,RunStatusCreated,RunStatusUpdated,RunStatusClosed,RunStatusRemoved,MaintActionType,AccountOC,OnlineSuppressed,Display,Deleted,CLoadId,CSrcId,ULoadId,USrcId,UProcId,MatchStatus)
VALUES(
'100000000','100000000','112','1','1',NULL,NULL,'169067725 ','1999-07-30',NULL,'1','2','N','1988-12-18','FALSE','124','FALSE','FALSE','FALSE','FALSE','FALSE',NULL,'0','FALSE','TRUE','FALSE','654330','1','654330','1','654330',NULL
)
SET IDENTITY_INSERT[dbo].ShAccHolder OFF





BEGIN TRANSACTION;

SELECT * FROM [CCRAccount_412335].[dbo].[SharedAccount] 
WHERE CLoadId = '654321'

SELECT * FROM [CCRAccount_412335].[dbo].AccountHistory 
WHERE CLoadId = '654321'

SELECT * FROM [CCRAccount_412335].[dbo].ShAccFinancials 
WHERE CLoadId = '654321'

SELECT * FROM [CCRAccount_412335].[dbo].ShAccHolder 
WHERE CLoadId = '654321'

SELECT * FROM [CCRAccount_412335].[dbo].ShAccHolderDetails 
WHERE CLoadId = '654321'

COMMIT;