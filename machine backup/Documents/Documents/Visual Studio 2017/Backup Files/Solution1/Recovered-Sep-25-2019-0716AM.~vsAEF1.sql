USE [CCRMain]
GO

DECLARE	@return_value int

EXEC	@return_value = [DataAmendInterface].[up_AddressLink_GatherResidenceDataAssets]
		@RefNum = N'371',
		@ResId = 219264229,
		@LinkResId = 219264228

SELECT	'Return Value' = @return_value

GO
