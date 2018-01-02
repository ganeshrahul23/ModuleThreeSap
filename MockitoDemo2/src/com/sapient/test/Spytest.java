package com.sapient.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import static org.junit.jupiter.api.Assertions.*;


@RunWith(JUnitPlatform.class)
public class Spytest {
	
	@Test
	public void m1(){
		List<String> lst = Mockito.mock(List.class);
		lst.add("ram");
		lst.add("tom");
		System.out.println(lst.size());
		assertTrue(lst.size() == 2);
	}
	
	@Test
	public void m2(){
		List<String> lst = Mockito.spy(new ArrayList<>());
		lst.add("ram");
		lst.add("tom");
		System.out.println(lst.size());
		assertTrue(lst.size() == 2);
	}
}
