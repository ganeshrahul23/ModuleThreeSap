package com.sapient.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

import com.sapient.serice.CalcService;

@RunWith(JUnitPlatform.class)
public class RoundTest {
	
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
	public void roundTest1(){
		//CalcService ser = new CalcService();
		double expected = 56.328;
		double actual = ser.roundToN(56.3278, 3);
		assertEquals(expected, actual);
	}
	
	@Test
	public void roundTest2(){
		//CalcService ser = new CalcService();
		double expected = 56.32;
		double actual = ser.roundToN(56.3248, 2);
		assertEquals(expected, actual);
	}
	
	@Test
	public void roundTest3(){
		//CalcService ser = new CalcService();
		double expected = 56.33;
		double actual = ser.roundToN(56.3278, 2);
		assertEquals(expected, actual);
	}
	
	@Test
	public void roundTest4(){
		//CalcService ser = new CalcService();
		double expected = 56.0;
		double actual = ser.roundToN(56.32768, 0);
		assertEquals(expected, actual);
	}
	
	@Test
	public void roundTest5(){
		//CalcService ser = new CalcService();
		double expected = 57.0;
		double actual = ser.roundToN(56.72768, 0);
		assertEquals(expected, actual);
	}
	
	@Disabled
	public void roundTest6(){
		//CalcService ser = new CalcService();
		double expected = 56.3277;
		double actual = ser.roundToN(56.32768, 4);
		assertEquals(expected, actual);
	}
}
