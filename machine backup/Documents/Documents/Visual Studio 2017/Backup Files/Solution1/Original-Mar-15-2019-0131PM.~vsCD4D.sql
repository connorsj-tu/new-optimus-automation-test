USE [CCRTracking]
GO

DECLARE	@return_value int

EXEC	@return_value = [dbo].[up_GetLoadProcesses]

SELECT	'Return Value' = @return_value

GO
