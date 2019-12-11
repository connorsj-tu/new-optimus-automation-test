declare @Surname varchar(12);
declare @Forename varchar(12);
declare @DoBirth DATETIME;


set @Surname = 'FERRARI%';
set @Forename = 'JOHN%'
set @DoBirth = '1944-10-13 00:00:00.000'


SELECT * FROM dbo.tblPerson
where Surname like @Surname
AND Forename like @Forename
AND DoBirth = @DoBirth


SELECT * 
FROM dbo.tblResidence
WHERE PersonId in 
(
	SELECT PersonId FROM dbo.tblPerson
	where Surname like @Surname
	AND Forename like @Forename
	AND DoBirth = @DoBirth
)

SELECT * FROM [Primary1].[dbo].[tblInsolvencyOrder]
WHERE [ResidenceId] IN
(
	SELECT [ResidenceId] 
	FROM dbo.tblResidence
	WHERE PersonId in 
	(
		SELECT PersonId FROM dbo.tblPerson
		where Surname like @Surname
		AND Forename like @Forename
		AND DoBirth = @DoBirth
	)
)


SELECT * FROM tblInsolvencyOrderType
WHERE InsolvencyOrderTypeId IN
(
	SELECT InsolvencyOrderTypeId FROM [Primary1].[dbo].[tblInsolvencyOrder]
	WHERE [ResidenceId] IN
	(
		SELECT [ResidenceId] 
		FROM dbo.tblResidence
		WHERE PersonId in 
		(
			SELECT PersonId FROM dbo.tblPerson
			where Surname like @Surname
			AND Forename like @Forename
			AND DoBirth = @DoBirth
		)
	)
)

SELECT * FROM [tblInsolvencyOrderHistory]
WHERE InsolvencyOrderId IN
(
	SELECT InsolvencyOrderId FROM [Primary1].[dbo].[tblInsolvencyOrder]
	WHERE [ResidenceId] IN
	(
		SELECT [ResidenceId] 
		FROM dbo.tblResidence
		WHERE PersonId in 
		(
			SELECT PersonId FROM dbo.tblPerson
			where Surname like @Surname
			AND Forename like @Forename
			AND DoBirth = @DoBirth
		)
	)
)






SELECT * FROM [Primary1].[dbo].tblPersonAlias
WHERE [PersonId] IN
(
		SELECT PersonId FROM dbo.tblPerson
		where Surname like @Surname
		AND Forename like @Forename
		AND DoBirth = @DoBirth
)

SELECT * FROM [Primary1].[dbo].tblPersonAliasSource
WHERE AliasId IN
(
	SELECT AliasId FROM [Primary1].[dbo].tblPersonAlias
	WHERE [PersonId] IN
	(
			SELECT PersonId FROM dbo.tblPerson
			where Surname like @Surname
			AND Forename like @Forename
			AND DoBirth = @DoBirth
	)
)


