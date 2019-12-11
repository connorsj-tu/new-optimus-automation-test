DELETE
FROM [CCRMain].[Matching].[Key1] 
WHERE ResidenceId in 
( 
	SELECT ResidenceId from [CCRMain].[Matching].[Key1] 
	WHERE MatchKey like 'SK67ER%'
)


DELETE
FROM [CCRMain].[Matching].[Key2] 
WHERE DomicileId in 
( 
	SELECT DomicileId from [CCRMain].[dbo].Domicile
	WHERE Postcode like 'SK6 7ER%'
)


SELECT * 
FROM [CCRMain].[Matching].[Key1] 
WHERE ResidenceId in 
( 
	SELECT ResidenceId from [CCRMain].[Matching].[Key1] 
	WHERE MatchKey like 'M333EB%'
)


SELECT * 
FROM [CCRMain].[Matching].[Key2] 
WHERE DomicileId in 
( 
	SELECT DomicileId from [CCRMain].[dbo].Domicile
	WHERE Postcode like 'M33 3EB%'
)

	SELECT TOP 36 * from [CCRMain].[Matching].[Key1] 
	ORDER BY ResidenceId DESC
	WHERE MatchKey like 'M333EB%'