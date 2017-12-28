package com.sapient.test;

import org.junit.jupiter.api.Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

import static org.junit.jupiter.api.Assertions.*;

import com.sapient.serice.CalcService;

@RunWith(JUnitPlatform.class)
public class CalcTest {
	
	@Test
	public void seriesTest1(){
		CalcService ser = new CalcService();
		double expected = 10.0d;
		double actual = ser.calcSeries(5, 5, 10);
		assertEquals(expected, actual);				
	}
	
	@Test
	public void seriesTest2(){
		CalcService ser = new CalcService();
		double expected = 7.5d;
		double actual = ser.calcSeries(5, 5, 5);
		assertEquals(expected, actual);				
	}	
	
}
