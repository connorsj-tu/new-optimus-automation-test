USE [Optimus]
GO

DECLARE	@return_value int

EXEC	@return_value = [dbo].[sp_GetSearchdetails]
		@SearchID = N'E3EBAF13-E81E-442C-A973-AB0CCC3DDD16'

SELECT	'Return Value' = @return_value

GO
