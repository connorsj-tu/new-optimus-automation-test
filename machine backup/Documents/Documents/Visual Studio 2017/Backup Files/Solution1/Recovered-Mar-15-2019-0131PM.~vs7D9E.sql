USE [Optimus]
GO

DECLARE	@return_value int

EXEC	@return_value = [dbo].[sp_GetSearchdetails]
		@SearchID = N'41B884AC-6ADC-4513-8682-79C7BD2835A2'

SELECT	'Return Value' = @return_value

GO
