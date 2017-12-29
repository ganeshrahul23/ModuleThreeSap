package com.sapient.service;

public class Factory {
	
	public static CalcService getCalcService(){
		CalcService ser = new CalcService();
		return ser;
	}
	
	public static Palindrome getPalindrome(){
		Palindrome pal = new Palindrome();
		return pal;
	}
	
	public static String[] getInput(){
		return new String[]{"amar","vikas","ravi","suresh","manish","shubham","rajendra",
				"keshav","rahul","janit","sai","ganesh","pravin","afsal"};
	}
	
	public static EmpService getEmpService(){
		EmpService emp = new EmpService();
		return emp;
	}
	
}
