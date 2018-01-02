package com.sapient.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

import com.sapient.serice.CalcService;

@RunWith(JUnitPlatform.class)
public class CalcTest2 {
	@ParameterizedTest
	@CsvSource({"5,5,10,10.0","5,5,5,7.5"})
	public void testSeries(int a, int b, int c, double expected){
		CalcService ser = new CalcService();
		double actual = ser.calcSeries(a, b, c);
		assertEquals(expected, actual);				
	}		
}
