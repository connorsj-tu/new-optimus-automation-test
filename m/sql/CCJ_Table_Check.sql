/****** Script for SelectTopNRows command from SSMS  ******/
SELECT TOP (1000) [PersonId]
      ,[TitleId]
      ,[NameSuffixId]
      ,[Surname]
      ,[Forename]
      ,[Othername]
      ,[Sex]
      ,[DoBirth]
      ,[ProcessId]
      ,[IndividualId]
  FROM [Primary1].[dbo].[tblPerson]
 WHERE Surname = 'MARS' AND [Forename] = 'BECKY'



SELECT * FROM [Primary1].[dbo].[tblResidence]
WHERE PersonId in (

	SELECT [PersonId]
	  FROM [Primary1].[dbo].[tblPerson]
	  WHERE Surname = 'MARS' AND [Forename] = 'BECKY'

)

SELECT * 
FROM [Primary1].[dbo].[tblDomicile]
WHERE DomicileId in (
	SELECT DomicileId FROM [Primary1].[dbo].[tblResidence]
	WHERE PersonId in (

		SELECT [PersonId]
		  FROM [Primary1].[dbo].[tblPerson]
		  WHERE Surname = 'MARS' AND [Forename] = 'BECKY'

	)
)	

SELECT * FROM [Primary1].[dbo].[tblCCJCasePerson]
WHERE ResidenceId in (

	SELECT ResidenceId FROM [Primary1].[dbo].[tblResidence]
	WHERE PersonId in (

		SELECT [PersonId]
		  FROM [Primary1].[dbo].[tblPerson]
		  WHERE Surname = 'MARS' AND [Forename] = 'BECKY'

	)

)

SELECT * FROM [Primary1].[dbo].[tblCCJ]	
WHERE CCJCasePerId IN (

	SELECT CCJCasePerId FROM [Primary1].[dbo].[tblCCJCasePerson]
	WHERE ResidenceId in (

		SELECT ResidenceId FROM [Primary1].[dbo].[tblResidence]
		WHERE PersonId in (

			SELECT [PersonId]
			  FROM [Primary1].[dbo].[tblPerson]
			  WHERE Surname = 'MARS' AND [Forename] = 'BECKY'

		)

	)
)



/****** Script for SelectTopNRows command from SSMS  ******/

SELECT TOP (1000) [PersonId]
      ,[TitleId]
      ,[NameSuffixId]
      ,[Surname]
      ,[Forename]
      ,[Othername]
      ,[Sex]
      ,[DoBirth]
      ,[ProcessId]
      ,[IndividualId]
  FROM [Primary1].[dbo].[tblPerson]
 WHERE Surname = 'FERRARI' AND [Forename] = 'JOHN'



SELECT * FROM [Primary1].[dbo].[tblResidence]
WHERE PersonId in (

	SELECT [PersonId]
	  FROM [Primary1].[dbo].[tblPerson]
	  WHERE Surname = 'FERRARI' AND [Forename] = 'JOHN'

)

SELECT * 
FROM [Primary1].[dbo].[tblDomicile]
WHERE DomicileId in (
	SELECT DomicileId FROM [Primary1].[dbo].[tblResidence]
	WHERE PersonId in (

		SELECT [PersonId]
		  FROM [Primary1].[dbo].[tblPerson]
		  WHERE Surname = 'FERRARI' AND [Forename] = 'JOHN'

	)
)	

SELECT * FROM [Primary1].[dbo].[tblCCJCasePerson]
WHERE ResidenceId in (

	SELECT ResidenceId FROM [Primary1].[dbo].[tblResidence]
	WHERE PersonId in (

		SELECT [PersonId]
		  FROM [Primary1].[dbo].[tblPerson]
		  WHERE Surname = 'FERRARI' AND [Forename] = 'JOHN'

	)

)

SELECT * FROM [Primary1].[dbo].[tblCCJ]	
WHERE CCJCasePerId IN (

	SELECT CCJCasePerId FROM [Primary1].[dbo].[tblCCJCasePerson]
	WHERE ResidenceId in (

		SELECT ResidenceId FROM [Primary1].[dbo].[tblResidence]
		WHERE PersonId in (

			SELECT [PersonId]
			  FROM [Primary1].[dbo].[tblPerson]
			  WHERE Surname = 'FERRARI' AND [Forename] = 'JOHN'

		)

	)
)


update [Primary1].[dbo].[tblCCJ]	
set Address = '17 TOP GEAR LANE X9 9LF'
where Address = '19 TOP GEAR LANE X9 9LF'
and CCJId = 9100496

select * from [Primary1].[dbo].[tblCCJCase]
where CCJCaseId in (
7840890,
7840891,
78787999
)

update [Primary1].[dbo].[tblCCJCase]
set CaseKey = NULL
where CCJCaseId in (
78787999
)


SELECT * FROM [Primary1].[dbo].[tblCCJCasePerson]
where CCJCasePerId in (
8162167,
8162168,
80008944 
)

select * from [Primary1].[dbo].[tblCCJ]	
where CCJId in (
9100495,
9100496,
16072915)