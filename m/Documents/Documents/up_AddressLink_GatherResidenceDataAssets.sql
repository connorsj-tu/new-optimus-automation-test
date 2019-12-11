USE [CCRMain]
GO
/****** Object:  StoredProcedure [DataAmendInterface].[up_AddressLink_GatherResidenceDataAssets]    Script Date: 12/07/2019 15:59:38 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO



ALTER PROCEDURE [DataAmendInterface].[up_AddressLink_GatherResidenceDataAssets]
/***********************************************************************************************************************************/
-- PURPOSE        : Given a ResId, this proc will identify all related asset records (SHARE, ER, CCJ etc) and return these in a list.
--                : Columns in the list are AssetId, AssetType

    @RefNum                       VARCHAR(30)        -- Unique reference provided by the calling system
,   @ResId                        INT                -- Source ResidenceId
,   @LinkResId                    INT                -- Target ResidenceId to be deleted
,   @NestLevel                    TINYINT = 0        -- Optional; for repeating the string '-  ' a certain amount of times, used as an indentation prefix for any feedback written
,   @PrintDebug                   BIT     = 0        -- Only ever used to write informational messages to the console
AS
/******************************************************************************************************************************************************************************************************/
--  VERSION HISTORY :
--  1.0.0 2019-03-01 SamS/DavidOC            - Created
--  1.0.1 2019-03-08 SamS                    - Added input param @ResId and Reordered calling of checker procs
--  1.0.2 2019-03-26 SamS				     - Amended to check whether ResId/LinkResId has been logically deleted
/******************************************************************************************************************************************************************************************************/
SET XACT_ABORT, NOCOUNT ON;
DECLARE @OuterTranCount INT = @@TRANCOUNT, @UseTran BIT = 1;

BEGIN TRY;

    SET @RefNum = UPPER(@RefNum);

    DECLARE /* TEMPLATE VARIABLES */@FullObjectName VARCHAR(500), @NestLevelPrefix VARCHAR(500) = REPLICATE('-  ',ISNULL(@NestLevel,0));
    SELECT @FullObjectName = FullObjectName FROM [_Common].[fn_GetObjectNames](DB_NAME(),OBJECT_SCHEMA_NAME(@@PROCID),OBJECT_NAME(@@PROCID));

    /* DEBUG */ IF @PrintDebug = 1 RAISERROR ('%s%s - Proc is %i levels down, with %i active transactions outside. Executed with parameters: @RefNum=%s, @ResId=%i, @LinkResId=%i'
    , 0, 1, @NestLevelPrefix, @FullObjectName, @NestLevel, @OuterTranCount, @LinkResId, @RefNum) WITH NOWAIT;
   
/*****************************************************************************************************************************************************************/
-- check for invalid, NULL or blank arguments
    IF ISNULL(@RefNum,'')   = ''                                   RAISERROR('The @RefNum provided is Blank or NULL'                       , 16, 1) WITH LOG;
	IF ISNULL(@ResId,0)     = 0                                    RAISERROR('The @ResId provided is Zero or NULL'                         , 16, 1) WITH LOG;
    IF ISNULL(@LinkResId,0) = 0                                    RAISERROR('The @LinkResId provided is Zero or NULL'                     , 16, 1) WITH LOG;

    IF NOT EXISTS (SELECT 1 FROM [dbo].[AddressLink] 
                    WHERE [LinkResId] = @LinkResId and Deleted = 0)                RAISERROR('There is no record with this LinkResId'                      , 16, 1) WITH LOG;

	IF NOT EXISTS (SELECT 1 FROM [dbo].[AddressLink] 
                    WHERE [ResId] = @ResId and Deleted = 0)                        RAISERROR('There is no record with this ResId'                          , 16, 1) WITH LOG;

/****************************************************************************************************************************************************/
--  BEGIN MAIN PROCESS...
--  Call check procedures
/****************************************************************************************************************************************************/
	 IF @OuterTranCount = 0 AND @UseTran = 1 BEGIN;  --Move this block as necessary, but as late as possible to reduce transaction duration        
        BEGIN TRANSACTION;
    END;

	DECLARE @RelatedDataAssets TABLE 
	(
		DataAssetId INT,
		DataAssetType VARCHAR(30)
	)

	--INSERT INTO @RelatedDataAssets (DataAssetId, DataAssetType)
 --   EXEC [DataAmendInterface].[up_AddressLink_SHARECheckForResId] @RefNum = @RefNum, @LinkResId = @LinkResId 
 --   /* DEBUG */ IF @PrintDebug = 1 RAISERROR ('Action :- %s SHARE Check:- %i. Performed Sucessfully', 0, 1) WITH NOWAIT;
	
	--IF(SELECT COUNT(*) FROM @RelatedDataAssets) = 0
	--BEGIN
	--	INSERT INTO @RelatedDataAssets (DataAssetId, DataAssetType)
	--	EXEC [DataAmendInterface].[up_AddressLink_AdditionalAddressLinksCheckForResId] @RefNum = @RefNum, @ResId = @ResId, @LinkResId = @LinkResId 
	--	/* DEBUG */ IF @PrintDebug = 1 RAISERROR ('Action :- %s AdditionalAddressLinks Check:- %i. Performed Sucessfully', 0, 1) WITH NOWAIT;
	--END
	
	--IF(SELECT COUNT(*) FROM @RelatedDataAssets) = 0
	--BEGIN
	--	INSERT INTO @RelatedDataAssets (DataAssetId, DataAssetType)
	--	EXEC [DataAmendInterface].[up_AddressLink_ERCheckForResId] @RefNum = @RefNum, @LinkResId = @LinkResId 
	--	/* DEBUG */ IF @PrintDebug = 1 RAISERROR ('Action :- %s ER Check:- %i. Performed Sucessfully', 0, 1) WITH NOWAIT;
	--END
	
	--IF(SELECT COUNT(*) FROM @RelatedDataAssets) = 0
	--BEGIN
	--	INSERT INTO @RelatedDataAssets (DataAssetId, DataAssetType)
	--	EXEC [DataAmendInterface].[up_AddressLink_CIFASCheckForResId] @RefNum = @RefNum, @LinkResId = @LinkResId 
	--	/* DEBUG */ IF @PrintDebug = 1 RAISERROR ('Action :- %s CIFAS Check:- %i. Performed Sucessfully', 0, 1) WITH NOWAIT;
	--END

	--IF(SELECT COUNT(*) FROM @RelatedDataAssets) = 0
	--BEGIN
	--	INSERT INTO @RelatedDataAssets (DataAssetId, DataAssetType)
	--	EXEC [DataAmendInterface].[up_AddressLink_CCJCheckForResId] @RefNum = @RefNum, @LinkResId = @LinkResId 
	--	/* DEBUG */ IF @PrintDebug = 1 RAISERROR ('Action :- %s CCJ Check:- %i. Performed Sucessfully', 0, 1) WITH NOWAIT;
	--END

	--IF(SELECT COUNT(*) FROM @RelatedDataAssets) = 0
	--BEGIN
	--	INSERT INTO @RelatedDataAssets (DataAssetId, DataAssetType)
	--	EXEC [DataAmendInterface].[up_AddressLink_InsolvencyCheckForResId] @RefNum = @RefNum, @LinkResId = @LinkResId 
	--	/* DEBUG */ IF @PrintDebug = 1 RAISERROR ('Action :- %s Insolvency Check:- %i. Performed Sucessfully', 0, 1) WITH NOWAIT;
	--END
	
	--IF(SELECT COUNT(*) FROM @RelatedDataAssets) = 0
	--BEGIN
	--	INSERT INTO @RelatedDataAssets (DataAssetId, DataAssetType)
	--	EXEC [DataAmendInterface].[up_AddressLink_DeceasedCheckForResId] @RefNum = @RefNum, @LinkResId = @LinkResId 
	--	/* DEBUG */ IF @PrintDebug = 1 RAISERROR ('Action :- %s Deceased Check:- %i. Performed Sucessfully', 0, 1) WITH NOWAIT;
	--END

	--IF(SELECT COUNT(*) FROM @RelatedDataAssets) = 0
	--BEGIN
	--	INSERT INTO @RelatedDataAssets (DataAssetId, DataAssetType)
	--	EXEC [DataAmendInterface].[up_AddressLink_AliasCheckForResId] @RefNum = @RefNum, @LinkResId = @LinkResId 
	--	/* DEBUG */ IF @PrintDebug = 1 RAISERROR ('Action :- %s Alias Check:- %i. Performed Sucessfully', 0, 1) WITH NOWAIT;
	--END

	--IF(SELECT COUNT(*) FROM @RelatedDataAssets) = 0
	--BEGIN
	--	INSERT INTO @RelatedDataAssets (DataAssetId, DataAssetType)
	--	EXEC [DataAmendInterface].[up_AddressLink_AssociateCheckForResId] @RefNum = @RefNum, @LinkResId = @LinkResId
	--	/* DEBUG */ IF @PrintDebug = 1 RAISERROR ('Action :- %s Associate Check:- %i. Performed Sucessfully', 0, 1) WITH NOWAIT;
	--END

	SELECT DataAssetId, DataAssetType FROM @RelatedDataAssets

/****************************************************************************************************************************************************/
--  END MAIN PROCESS
/****************************************************************************************************************************************************/



    /* COMMIT CHANGES */ IF @OuterTranCount = 0 AND @UseTran = 1 BEGIN; COMMIT TRANSACTION; END;


END TRY BEGIN CATCH;
    /* ROLLBACK CHANGES */ IF XACT_STATE() <> 0 AND @OuterTranCount = 0 AND @UseTran = 1 BEGIN;
        ROLLBACK TRANSACTION;        
    END;

    DECLARE @ERROR_NUMBER   NVARCHAR(11) = ISNULL(CONVERT(NVARCHAR(11),ERROR_NUMBER()   ),'NULL'), @ERROR_LINE    NVARCHAR(11)   = ISNULL(CONVERT(NVARCHAR(11),ERROR_LINE()     ),'NULL')
           ,@ERROR_SEVERITY NVARCHAR(11) = ISNULL(CONVERT(NVARCHAR(11),ERROR_SEVERITY() ),'NULL'), @ERROR_MESSAGE NVARCHAR(4000) = ISNULL(                     ERROR_MESSAGE()   ,'NULL')
           ,@ERROR_STATE    NVARCHAR(11) = ISNULL(CONVERT(NVARCHAR(11),ERROR_STATE()    ),'NULL'), @Message       NVARCHAR(2048) = '';
           
    IF LEFT(@ERROR_MESSAGE,9) = N'ERROR in '                      /* the error was raised by a child process */
         SET @Message = LEFT(N'ERROR in ' + @FullObjectName + N'; executing child proc: ' + @ERROR_MESSAGE ,2048);
    ELSE SET @Message = LEFT(N'ERROR in ' + @FullObjectName + ';' /* the error originated in this procedure */
/****************************************************************************************************************************************************/
--  Update this section with any PARAMETERS to be included inside error messages :
        + N' @LinkResId='            + ISNULL(CONVERT(VARCHAR(11),@LinkResId)     ,'NULL')
        + N',Num '                   + @ERROR_NUMBER + N',Lvl ' + @ERROR_SEVERITY+ N',State ' + @ERROR_STATE + N',Line ' + @ERROR_LINE + N',Msg: ' + @ERROR_MESSAGE,2048);
/****************************************************************************************************************************************************/
    
    RAISERROR(@Message, 16, @ERROR_STATE) WITH LOG;
END CATCH;


