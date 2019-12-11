USE [CCRMain]
GO

DECLARE	@return_value int,
		@LinkResId int,
		@ResId int

EXEC	@return_value = [DataAmendInterface].[up_AddressLink_GetResidenceIds]
		@RefNum = N'81285078',
		@AddressLinkId = 81285078,
		@LinkResId = @LinkResId OUTPUT,
		@ResId = @ResId OUTPUT

SELECT	@LinkResId as N'@LinkResId',
		@ResId as N'@ResId'

SELECT	'Return Value' = @return_value

GO
