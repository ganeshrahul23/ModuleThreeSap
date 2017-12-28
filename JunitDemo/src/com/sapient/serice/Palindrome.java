package com.sapient.serice;

public class Palindrome {
	
	public boolean checkPal(String str){
		boolean res = false;
		if(str == null)
			res = false;
		else if(str.isEmpty())
			res = false;
		else{
			StringBuilder sb = new StringBuilder(str).reverse();
			res = sb.toString().equals(str);
		}
		
		return res;
	}
}
