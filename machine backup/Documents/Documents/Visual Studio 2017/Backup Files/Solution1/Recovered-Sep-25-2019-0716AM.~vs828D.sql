USE [CCRMain]
GO

DECLARE	@return_value int

EXEC	@return_value = [DataAmendInterface].[up_AddressLink_ERCheckForResId]
		@RefNum = N'219264181',
		@LinkResId = 219264181

SELECT	'Return Value' = @return_value

GO
