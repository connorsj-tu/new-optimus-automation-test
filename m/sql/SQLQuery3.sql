SELECT * FROM
[CCRMain].[dbo].[CCJDisputeStaging]


BEGIN TRANSACTION;

declare @LoadId varchar(6);
declare @LoadId2 varchar(6);

set @LoadId = '654321';
set @LoadId2 = '654321';

SELECT * FROM [CCRMain].[dbo].CCJ Where ProcessId = @LoadId;
SELECT * FROM [CCRMain].[dbo].CCJCasePerson Where ProcessId = @LoadId;
SELECT * FROM [CCRMain].[dbo].CCJCase Where ProcessId = @LoadId;