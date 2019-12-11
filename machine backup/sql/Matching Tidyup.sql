DELETE
FROM [Primary1].Matching.tblKey1
WHERE ResidenceId in 
( 
	SELECT ResidenceId from [Primary1].Matching.tblKey1
	WHERE MatchKey like 'SK67ER%'
)


DELETE
FROM [Primary1].Matching.tblKey2
WHERE DomicileId in 
( 
	SELECT DomicileId from [Primary1].[dbo].tblDomicile
	WHERE Postcode like 'SK6 7ER%'
)



SELECT * 
FROM [Primary1].Matching.tblKey1
WHERE ResidenceId in 
( 
	SELECT ResidenceId from [Primary1].Matching.tblKey1
	WHERE MatchKey like 'M333EB%'
)


SELECT * 
FROM [Primary1].Matching.tblKey2
WHERE DomicileId in 
( 
	SELECT DomicileId from [Primary1].[dbo].tblDomicile
	WHERE Postcode like 'M33 3EB%'
)



DELETE
FROM [Primary1].Matching.tblKey1
WHERE MatchKey like 'M333EB%'
AND ResidenceId NOT in 
( 
	SELECT ResidenceId from [Primary1].Matching.tblKey1
	WHERE MatchKey like 'M333EB%'
)

DELETE
FROM [Primary1].Matching.tblKey2
WHERE MatchKey like 'M333EB%'
AND DomicileId NOT in 
( 
	SELECT DomicileId from [Primary1].[dbo].tblDomicile
	WHERE Postcode like 'M33 3EB%'
)
 