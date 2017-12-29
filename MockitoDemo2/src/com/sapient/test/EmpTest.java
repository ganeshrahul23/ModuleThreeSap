package com.sapient.test;

import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import com.sapient.dao.IDao;
import com.sapient.service.ISer;
import com.sapient.service.SerImpl;
import com.sapient.vo.Emp;

import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.*;

import name.falgout.jeffrey.testing.junit5.MockitoExtension;

@ExtendWith(MockitoExtension.class)
@RunWith(JUnitPlatform.class)
public class EmpTest {
	
	@Mock
	IDao dao;
	
	@InjectMocks
	ISer ser = new SerImpl();
	
	static List<Emp> idList, nameList, salList, lst; 
	static Emp e1 = new Emp(1001, "ganesh", 9000);
	static Emp e2 = new Emp(1004, "tarun", 19000);
	static Emp e3 = new Emp(1005, "anup", 8000);
	static Emp e4 = new Emp(1002, "shubam", 15000);
	static Emp e5 = new Emp(1008, "jaydeep", 30000);
	
	@BeforeAll
	public static void beforeAll(){				
		idList = new ArrayList<>();
		idList.add(e1);
		idList.add(e4);
		idList.add(e2);
		idList.add(e3);
		idList.add(e5);
		
		nameList = new ArrayList<>();
		nameList.add(e3);
		nameList.add(e1);
		nameList.add(e5);
		nameList.add(e4);
		nameList.add(e2);
		
		salList = new ArrayList<>();
		salList.add(e3);
		salList.add(e1);
		salList.add(e4);
		salList.add(e2);
		salList.add(e5);
		
	}
	
	@BeforeEach
	public void beforeEach(){
		lst = new ArrayList<>();
		lst.add(e1);
		lst.add(e2);
		lst.add(e3);
		lst.add(e4);
		lst.add(e5);
		when(dao.getEmployee()).thenReturn(lst);
	}
	
	@Test
	public void testEmp1(){
		List<Emp> actual = ser.viewEmployee("id");
		assertEquals(idList, actual);
	}
	
	@Test
	public void testEmp2(){
		List<Emp> actual = ser.viewEmployee("id");
		assertTrue(idList.size()==actual.size());
	}
	
	@Test
	public void testEmp3(){
		List<Emp> actual = ser.viewEmployee("name");
		assertEquals(nameList, actual);
	}
	
	@Test
	public void testEmp4(){
		List<Emp> actual = ser.viewEmployee("name");
		assertTrue(nameList.size()==actual.size());
	}
	
	@Test
	public void testEmp5(){
		List<Emp> actual = ser.viewEmployee("salary");
		assertEquals(salList, actual);
	}
	
	@Test
	public void testEmp6(){
		List<Emp> actual = ser.viewEmployee("salary");
		assertTrue(salList.size()==actual.size());
	}
		
}
