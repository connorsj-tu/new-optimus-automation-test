USE [CCRMain]
GO

DECLARE	@return_value int

EXEC	@return_value = [DataAmendInterface].[up_AddressLink_GatherResidenceDataAssets]
		@RefNum = N'378',
		@ResId = 219264137,
		@LinkResId = 219264138

SELECT	'Return Value' = @return_value

GO
