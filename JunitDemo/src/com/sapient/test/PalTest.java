package com.sapient.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

import com.sapient.serice.Palindrome;

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
	

}
