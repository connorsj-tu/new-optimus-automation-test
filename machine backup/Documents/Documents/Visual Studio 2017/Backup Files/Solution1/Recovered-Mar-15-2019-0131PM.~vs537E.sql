USE [Audit]
GO

DECLARE	@return_value int

EXEC	@return_value = [dbo].[UP_GetSearchDetailsForOptimus]
		@SearchId = N'BCC2CA80-073E-4A33-872B-D4FDBE120A26'

SELECT	'Return Value' = @return_value

GO
