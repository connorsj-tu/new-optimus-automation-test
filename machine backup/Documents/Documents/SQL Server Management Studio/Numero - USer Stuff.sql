SELECT *
  FROM [NODDLE_SIT_DB04].[IdentUsers].[UserAccounts]
  order by 6 DESC

SELECT *
  FROM [NODDLE_SIT_DB04].[IdentUsers].[UserAccounts]
  WHERE Username like '%bryan%'
  order by 4

SELECT *
  FROM [NODDLE_SIT_DB04].[IdentUsers].[UserAccounts]
  WHERE VerificationStorage like '%bryan%'
  order by 4


  SELECT *
  FROM [NODDLE_SIT_DB04].Workforce.Users
  where fullName = 'James Connors'


  SELECT *
  FROM [NODDLE_SIT_DB04].Workforce.Users
  where fullName like '%car%'
    
  UPDATE [NODDLE_SIT_DB04].Workforce.Users
  set subjectId = '64831A97-7ECB-464D-8490-BD0D671AA563'
  where u_id = 'BD94AC63-385D-4C5C-B52E-F2F8166E56F3'

  select * from [NODDLE_SIT_DB04].[IdentUsers].[UserAccounts]
    WHERE Email like '%onnor%'
  order by 4

   SELECT *
  FROM [NODDLE_SIT_DB04].[IdentUsers].[UserAccounts]
  WHERE Email like '%onnor%'
  order by 4

  SELECT *
  FROM [NODDLE_SIT_DB04].[IdentUsers].[UserAccounts]
  WHERE Email like '%hema%'

  Update [NODDLE_SIT_DB04].[IdentUsers].[UserAccounts]
  Set IsAccountVerified = 1
    WHERE VerificationStorage like '%hema%'



SELECT *
  FROM [NODDLE_SIT_DB04].[IdentUsers].[UserAccounts]
  WHERE email like '%onnors%'
  order by 4
  
SELECT * FROM   [IdentUsers].[LinkedAccountClaims]
Where parentkey = 167

SELECT * FROM   [IdentUsers].[LinkedAccountClaims]
Where ProviderName = 'cigad'

SELECT * FROM   [IdentUsers].[LinkedAccountClaims]
order by value


select * from [NODDLE_SIT_DB04].Workforce.PendingUsers