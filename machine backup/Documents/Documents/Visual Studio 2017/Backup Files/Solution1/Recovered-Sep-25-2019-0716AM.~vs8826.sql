USE [Views]
GO
/****** Object:  StoredProcedure [dbo].[up_GetAliasLinkDetails]    Script Date: 11/09/2019 17:27:20 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
ALTER PROCEDURE [dbo].[up_GetAliasLinkDetails]
    @AliasLinkId int
AS
    
set nocount on

/****************************************************************************************
 * Database:    Views
 * Author  :    Ian Southern
 * Date    :    30/08/2011
 * Purpose :    Returns AliasLink information given a AliasId
 *
 * Version History
 * ---------------
 * 1.0.0    30/08/2011  SuF 
 * Created
 ****************************************************************************************/
begin try
    -- standard declarations
    declare @ProcessName sysname, @ProcessMessage varchar(500), @ErrorCode int
    
    -- initialisations
    set @ProcessName = object_name(@@procid)

    set @ProcessMessage = 'Starting'

    --body
    set @ProcessMessage = 'Retrieve AliasLink information given a AliasId'

    SELECT  pa.AliasId
            , p.Forename
            , p.Othername
            , p.Surname
            , p.DoBirth
            , pa.DataSupplierId
            , pa.DataSupplierType
            , pa.Member_PortId
            , pa.CreationDate
            , pa.UpdateDate
    FROM dbo.vwPersonAlias pa
    JOIN dbo.vwPerson p on p.PersonId = pa.PersonLinkId
    WHERE pa.AliasId = @AliasLinkId

    set @ProcessMessage = 'Completed'

end try
begin catch
    -- Catch error and append the job step
    select @ErrorCode = error_number(), @ProcessMessage = '[' + isnull(@ProcessMessage, 'Unknown Step') + '] Exception caught: ' + isnull(error_message(), 'Unknown error')
                                                            + ', line number: ' + isnull(convert(varchar, error_line()), 'Unknown')

    -- Rethrow the error
    raiserror(@ProcessMessage, 16, 1)
end catch

return isnull(@ErrorCode, 0)


SELECT  pa.*
    FROM dbo.vwPersonAlias pa
    JOIN dbo.vwPerson p on p.PersonId = pa.PersonLinkId
    WHERE pa.AliasId = 3463975


	update 
