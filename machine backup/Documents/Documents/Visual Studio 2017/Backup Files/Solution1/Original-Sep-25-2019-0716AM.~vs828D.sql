USE [CCRMain]
GO

DECLARE	@return_value int

EXEC	@return_value = [DataAmendInterface].[up_AddressLink_ERCheckForResId]
		@RefNum = N'219264179',
		@LinkResId = 219264179

SELECT	'Return Value' = @return_value

GO
