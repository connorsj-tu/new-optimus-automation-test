SET QUOTED_IDENTIFIER OFF;

DECLARE @UserName VARCHAR(200) = ?;

DELETE
FROM cmn.WidgetInstance
WHERE WorkspaceID IN
    (SELECT WorkspaceID
     FROM cmn.Workspace
     WHERE UserID =
         (SELECT UserID
          FROM [cmn].[User]
          WHERE UserName = @UserName)
	 AND (Name != 'Default_Workspace') 
	 );

DELETE
FROM cmn.Workspace
WHERE UserID =
    (SELECT UserID
     FROM [cmn].[User]
     WHERE UserName = @UserName)
  AND (Name != 'Default_Workspace');


UPDATE cmn.Workspace
SET IsActive = 1
WHERE UserID =
    (SELECT UserID
     FROM [cmn].[User]
     WHERE UserName = @UserName)
  AND Name = 'Default_Workspace';

UPDATE [cmn].[User] Set Password = '!ENC!letmein123' WHERE UserName = 'Administrator';

UPDATE [cmn].[User] Set TemporaryPassword = 0;

SET QUOTED_IDENTIFIER ON;
