USE [Optimus]
GO

DECLARE	@return_value int

EXEC	@return_value = [dbo].[UP_GetPortfolioDetailsForOptimus]
		@Member_PortId = 817

SELECT	'Return Value' = @return_value

GO

66 - 999901 - Test
112 - 412335 - Halifax Mortgages
274 - 325601 - Tesco Bank
817 - 611010 - MKDP LLP