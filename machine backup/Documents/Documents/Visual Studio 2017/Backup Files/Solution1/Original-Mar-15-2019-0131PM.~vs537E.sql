USE [Audit]
GO

DECLARE	@return_value int

EXEC	@return_value = [dbo].[UP_GetSearchDetailsForOptimus]
		@SearchId = 41B884AC-6ADC-4513-8682-79C7BD2835A2

SELECT	'Return Value' = @return_value

GO
