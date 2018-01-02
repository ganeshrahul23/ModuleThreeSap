package com.sapient.test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

import com.sapient.serice.Palindrome;

@RunWith(JUnitPlatform.class)
public class ReverseTest {
	private static Palindrome pal;
	private static String[] expected;
	private static String[] input = {"rama","nitin","kayak","no"};
	
	@BeforeAll
	public static void beforeAll(){
		pal = new Palindrome();
		expected = new String[]{"amar","nitin","kayak","on"};
	}
	
	@AfterAll
	public static void afterAll(){
		pal = null;
	}
	
	@Test
	public void testRev1(){
		assertTrue(expected.length == pal.reverseName(input).length);
		
	}
	
	@Test
	public void testRev2(){
		String [] actual = pal.reverseName(input);
		assertArrayEquals(expected, actual);
	}
	
	@Test
	public void testRev3(){
		String [] actual = pal.reverseName(null);
		assertNull(actual);
	}
}
