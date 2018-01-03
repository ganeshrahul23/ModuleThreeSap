package com.sapient.test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

import com.sapient.service.Palindrome;

@RunWith(JUnitPlatform.class)
public class PalTest {
	private static Palindrome pal;
	
	@BeforeAll
	public static void beforeAll(){
		pal = new Palindrome();
	}
	
	@AfterAll
	public static void afterAll(){
		pal = null;
	}
	
	@Test
	public void testPal1(){
		assertTrue(pal.checkPal("malayalam"));
	}
	
	@Test
	public void testPal2(){
		assertFalse(pal.checkPal("rama"));
	}
	
	@Test
	public void testPal3(){
		assertFalse(pal.checkPal(null));
	}
	
	@Test
	public void testPal4(){
		assertFalse(pal.checkPal(""));
	}
	
	@Test
	public void testPal5(){
		assertTrue(pal.checkPal("nitin"));
	}
	
	@ParameterizedTest
	@ValueSource(strings={"nitin","mam","hello",""})
	public void testPalAll(String str){
		assertTrue(pal.checkPal(str));
	}
	

}
