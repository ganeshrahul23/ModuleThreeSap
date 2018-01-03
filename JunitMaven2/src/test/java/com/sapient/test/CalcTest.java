package com.sapient.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

import com.sapient.service.CalcService;

@RunWith(JUnitPlatform.class)
public class CalcTest {
	
	private static CalcService ser;
	
	@BeforeAll
	public static void beforeAll(){
		ser = new CalcService();
		System.out.println("Before All");
	}
	
	@AfterAll
	public static void afterAll(){
		ser = null;
		System.out.println("After All");
	}
	
	@Test
	public void seriesTest1(){
		//CalcService ser = new CalcService();
		double expected = 10.0d;
		double actual = ser.calcSeries(5, 5, 10);
		assertEquals(expected, actual);				
	}
	
	@Test
	public void seriesTest2(){
		//CalcService ser = new CalcService();
		double expected = 7.5d;
		double actual = ser.calcSeries(5, 5, 5);
		assertEquals(expected, actual);				
	}	
	
	
	
	
}
