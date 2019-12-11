SELECT *



       FROM [dbo].[Account] account



       Inner Join [dbo].[AccountStatus] accountStatus on account.AccountStatusId = accountStatus.AccountStatusId



       Inner Join [dbo].[AccountType] accountType on account.AccountTypeId = accountType.AccountTypeId



       Left Join [dbo].[RepaymentFrequency] repaymentFrequency on account.RepaymentFrequencyId = repaymentFrequency.RepaymentFrequencyId



       WHERE ResidenceId = 219263058
	         AND FileDate >= GetDate() -45