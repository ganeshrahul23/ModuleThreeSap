package com.sapient.serice;

public class LoanService {
	public String approveLoan(int age, double income) throws AgeException, IncomeException{
		if(age < 20 || age > 40)
			throw new AgeException("age must be between 20 and 40");
		if(income < 400000)
			throw new IncomeException("Income must be minimum 4 Lakhs");
		return "approved";
	}
}
