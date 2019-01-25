SET QUOTED_IDENTIFIER OFF;

DECLARE @UserName VARCHAR(200) = ?;
DECLARE @WorkspaceName VARCHAR(20) = 'Default_Workspace';

DELETE FROM cmn.WidgetInstance
WHERE WorkspaceID IN
    (SELECT WorkspaceID
     FROM cmn.Workspace
     WHERE UserID =
         (SELECT UserID
          FROM [cmn].[User]
          WHERE UserName = @UserName)
	 AND Name = @WorkspaceName);

DELETE
FROM cmn.Workspace
WHERE UserID = 
	(SELECT UserID
	FROM [cmn].[User]
	WHERE UserName = @UserName)
AND Name = @WorkspaceName;

INSERT INTO cmn.Workspace (UserID, Name, Layout, Theme, Icon, IsActive, locked)
VALUES ((SELECT UserID 
				FROM [cmn].[User] 
				WHERE UserName = @UserName), @WorkspaceName, 5, 'standard', 'Workspace_Icon1', 1, 0);

UPDATE cmn.Workspace
SET IsActive = 0
WHERE UserID =
    (SELECT UserID
     FROM [cmn].[User]
     WHERE UserName = @UserName)
  AND Name != 'Default_Workspace';

SET QUOTED_IDENTIFIER ON;
