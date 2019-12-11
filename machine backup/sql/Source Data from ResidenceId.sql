declare @ResidenceId varchar(12);

set @ResidenceId = '165347669';



SELECT * 
FROM dbo.tblResidence
WHERE ResidenceId = @ResidenceId

SELECT * FROM dbo.tblPerson
WHERE PersonId IN 
(
	SELECT PersonId
	FROM dbo.tblResidence
	WHERE ResidenceId = @ResidenceId
)

SELECT * FROM dbo.tblIndividual
WHERE IndividualId IN 
(
	SELECT IndividualId FROM dbo.tblPerson
	WHERE PersonId IN 
	(
		SELECT PersonId
		FROM dbo.tblResidence
		WHERE ResidenceId = @ResidenceId
	)
)



SELECT TOP (100000) [InsolvencyOrderId]
      ,[InsolvencyOrderTypeId]
      ,[InsolvencyServiceCaseId]
      ,[ResidenceId]
      ,[OrderDate]
      ,[RestrictionsTypeId]
      ,[RestrictionsStartDate]
      ,[RestrictionsEndDate]
      ,[LineOfBusiness]
      ,[ValueOfDebt]
      ,[ValueOfAssets]
      ,[MaxSequenceNum]
      ,[DischargeDate]
      ,[ProcessId]
      ,[OnlineSuppressed]
  FROM [Primary1].[dbo].[tblInsolvencyOrder]
    ORDER BY 1 DESC

