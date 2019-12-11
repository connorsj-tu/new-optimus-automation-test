	SELECT * FROM stash.disputecase
	ORDER BY id DESC

delete from stash.disputecase

SELECT * FROM 
IdentUsers.UserAccounts
order by 4

UPDATE
IdentUsers.UserAccounts
SET IsAccountVerified = 1

102
79

SELECT * FROM IdentUsers.UserClaims
WHERE ParentKey = 79

SELECT * FROM IdentUsers.UserClaims
WHERE ParentKey = 102

INSERT INTO IdentUsers.UserClaims (ParentKey, Type, Value)
VALUES(102, 'role', 'Agent')

INSERT INTO IdentUsers.UserClaims (ParentKey, Type, Value)
VALUES(102, 'role', 'connect.admin')

INSERT INTO IdentUsers.UserClaims (ParentKey, Type, Value)
VALUES(102, 'role', 'flows.admin')

INSERT INTO IdentUsers.UserClaims (ParentKey, Type, Value)
VALUES(102, 'role', 'numeroInteractive')

INSERT INTO IdentUsers.UserClaims (ParentKey, Type, Value)
VALUES(102, 'role', 'stash.admin')

select * from setup.ApplicationConfigurationData where data like '%vouch%'


SELECT Username FROM 
IdentUsers.UserAccounts
Where Username like 'Optimus%'
