USE [Optimus]
GO

DECLARE	@return_value int

EXEC	@return_value = [dbo].[UP_GetPortfolioDetailsForOptimus]
		@Member_PortId = 317
		--(496, 1037, 363, 85, 107, 317)

SELECT	'Return Value' = @return_value

GO
