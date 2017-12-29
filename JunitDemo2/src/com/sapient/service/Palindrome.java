package com.sapient.service;

public class Palindrome {
	
	Palindrome() {
		
	}
	
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
	
	public String[] reverseName(String[] arr){
		String [] nArr;
		if(arr == null)
			return null;
		else	
		{
			nArr = new String[arr.length];
			StringBuilder sb = null;
			for(int i = 0; i<arr.length; i++){
				sb = new StringBuilder(arr[i]).reverse();
				nArr[i] = sb.toString();
			}
			return nArr;
		}						
	}
}
