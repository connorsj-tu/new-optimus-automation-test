USE [CCRMain]
GO

DECLARE	@return_value int

EXEC	@return_value = [DataAmendInterface].[up_AddressLink_GatherResidenceDataAssets]
		@RefNum = N'378',
		@ResId = 219264138,
		@LinkResId = 219264137


SELECT	'Return Value' = @return_value

GO


  DECLARE		@LinkResId int= 219264138
--SELECT	'Return Value' = @return_value
SELECT * --ShAccHolderId AS DataAssetId, 'SHARE' AS DataAssetType

      FROM BureauPrimary.PrimarySource.dbo.tblShAccHolder --WHERE ResidenceId = @LinkResId AND Display = 1  
