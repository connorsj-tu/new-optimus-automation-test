USE [CCRMain]
GO

DECLARE	@return_value int

EXEC	@return_value = [DataAmendInterface].[up_AddressLink_GatherResidenceDataAssets]
		@RefNum = N'371',
		@ResId = 219264172,
		@LinkResId = 219264173

SELECT	'Return Value' = @return_value

GO
