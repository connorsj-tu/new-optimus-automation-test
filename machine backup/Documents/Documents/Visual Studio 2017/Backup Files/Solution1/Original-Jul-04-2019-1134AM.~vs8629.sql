USE [Optimus]
GO

DECLARE	@return_value int

EXEC	@return_value = [dbo].[UP_GetPortfolioDetailsForOptimus]
		@Member_PortId = 66

SELECT	'Return Value' = @return_value

GO
