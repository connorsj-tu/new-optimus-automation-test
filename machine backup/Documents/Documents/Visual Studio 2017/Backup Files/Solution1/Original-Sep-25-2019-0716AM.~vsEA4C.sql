USE [Views]
GO

DECLARE	@return_value int

EXEC	@return_value = [dbo].[up_GetAliasLinkDetails]
		@AliasLinkId = 2146232015

SELECT	'Return Value' = @return_value

GO
