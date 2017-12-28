package com.sapient.serice;

public class CalcService {
	
	public double calcSeries(int a, int b, int c){
		double res = 0.0;
		res = (a + b + c)/2.0;
		return res;
	}
	
	public double roundToN(double val, int n){
		double res = Math.round(Math.pow(10, n) * val) / Math.pow(10, n);
		return res;
	}
}
