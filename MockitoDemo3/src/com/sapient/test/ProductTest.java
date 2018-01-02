package com.sapient.test;

import name.falgout.jeffrey.testing.junit5.MockitoExtension;

import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.mockito.InOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import com.sapient.dao.IProductDao;
import com.sapient.service.ISer;
import com.sapient.service.NotFoundException;
import com.sapient.service.SerImpl;
import com.sapient.vo.Product;

@ExtendWith(MockitoExtension.class)
@RunWith(JUnitPlatform.class)
public class ProductTest {
	
	@Mock
	IProductDao dao;
	
	@InjectMocks
	ISer ser = new SerImpl();
	
	private static Map<String, Map<Integer, Product>> catMap;
	private static Map<Integer, Product> computerMap;
	private static Map<Integer, Product> mobileMap;
	private static List<String> pSpec1, pSpec2, pSpec3, pSpec4;
	private static Product expected1, expected2;
	
	static Product[] p = new Product[]{
	new Product(1001, "hp", 30000),
	new Product(1002, "acer", 50000),
	new Product(1003, "iPhone", 80000),
	new Product(1004, "Pixel", 60000)};
	
	@BeforeAll
	public static void beforeAll(){	
//		Product[] p = new Product[4];
//		p[0] = new Product(1001, "hp", 30000);
//		p[1] = new Product(1002, "acer", 50000);
//		p[2] = new Product(1003, "iPhone", 80000);
//		p[3] = new Product(1004, "Pixel", 60000);
		
		pSpec1 = Arrays.asList("4gb ram", "1tb hdd", "pentium i5");
		pSpec2 = Arrays.asList("2gb ram", "4tb hdd", "pentium i7");
		pSpec3 = Arrays.asList("2gb ram", "14mp camera", "64gb internal");
		pSpec4 = Arrays.asList("4gb ram", "40mp camera", "42gb internal");
		
//		p[0].setSpecList(pSpec1);
//		p[1].setSpecList(pSpec2);
//		p[2].setSpecList(pSpec3);
//		p[3].setSpecList(pSpec4);
			
		computerMap = new HashMap<>();
		computerMap.put(p[0].getPid(), p[0]);
		computerMap.put(p[1].getPid(), p[1]);
		
		mobileMap = new HashMap<>();
		mobileMap.put(p[2].getPid(), p[2]);
		mobileMap.put(p[3].getPid(), p[3]);
		
		catMap = new HashMap<>();
		catMap.put("Computer", computerMap);
		catMap.put("Mobile", mobileMap);	
	}
	
	@Test
	public void testProduct1() throws NotFoundException{
		when(dao.getCatNProds()).thenReturn(catMap);
		when(dao.getProductSpecs("acer")).thenReturn(pSpec2);
		Product expected = new Product(1002, "acer", 50000);
		expected.setSpecList(pSpec2);
		assertEquals(expected, ser.getProductInfo("Computer", 1002));
		
		InOrder order = Mockito.inOrder(dao);
		order.verify(dao).getCatNProds();
		order.verify(dao).getProductSpecs("acer");
	}
	
	@Test
	public void testProduct2() throws NotFoundException{
		when(dao.getCatNProds()).thenReturn(catMap);
		when(dao.getProductSpecs("hp")).thenReturn(pSpec1);
		Product expected = new Product(1001, "hp", 30000);
		expected.setSpecList(pSpec1);
		assertEquals(expected, ser.getProductInfo("Computer", 1001));
		
		InOrder order = Mockito.inOrder(dao);
		order.verify(dao).getCatNProds();
		order.verify(dao).getProductSpecs("hp");
	}
	
	@Test
	public void testProduct3() throws NotFoundException{
		when(dao.getCatNProds()).thenReturn(catMap);
		assertThrows(NotFoundException.class, () -> ser.getProductInfo("Computer", 1003));
	}
	
	@Test
	public void testProduct4() throws NotFoundException{
		when(dao.getCatNProds()).thenReturn(catMap);
		assertThrows(NotFoundException.class, () -> ser.getProductInfo("Mobile", 1001));
	}
	
	@Test
	public void testProduct5() throws NotFoundException{
		when(dao.getCatNProds()).thenReturn(catMap);
		assertThrows(NotFoundException.class, () -> ser.getProductInfo("asd", 1233));
	}
	
	@Test
	public void testProduct6() throws NotFoundException{
		when(dao.getCatNProds()).thenReturn(catMap);
		when(dao.getProductSpecs("Pixel")).thenReturn(pSpec4);
		Product expected = new Product(1004, "Pixel", 60000);
		expected.setSpecList(pSpec4);
		assertEquals(expected, ser.getProductInfo("Mobile", 1004));
		
		InOrder order = Mockito.inOrder(dao);
		order.verify(dao).getCatNProds();
		order.verify(dao).getProductSpecs("Pixel");
	}
	
	@Test
	public void testProduct7() throws NotFoundException{
		when(dao.getCatNProds()).thenReturn(catMap);
		when(dao.getProductSpecs("iPhone")).thenReturn(pSpec3);
		Product expected = new Product(1003, "iPhone", 80000);
		expected.setSpecList(pSpec3);
		assertEquals(expected, ser.getProductInfo("Mobile", 1003));
		
		InOrder order = Mockito.inOrder(dao);
		order.verify(dao).getCatNProds();
		order.verify(dao).getProductSpecs("iPhone");
	}
	
	
	
}
