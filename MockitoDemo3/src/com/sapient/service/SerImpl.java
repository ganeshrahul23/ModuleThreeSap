package com.sapient.service;

import java.util.List;
import java.util.Map;

import com.sapient.dao.IProductDao;
import com.sapient.vo.Product;

public class SerImpl implements ISer {
	
	private IProductDao dao;
	
	//Setter is used by Mockito to inject mock instances
	public void setDao(IProductDao dao) {
		this.dao = dao;
	}

	@Override
	public Product getProductInfo(String category, int pid) throws NotFoundException{
		
		Map<String, Map<Integer, Product>> fullProd = dao.getCatNProds();		
		Map<Integer, Product> catProd = null;
		
		if(fullProd.containsKey(category)){
			catProd = fullProd.get(category);
		}else{
			throw new NotFoundException("Category Not Found");
		}
		 
		if(catProd.containsKey(pid)){
			Product prod = catProd.get(pid);
			List<String> spec = dao.getProductSpecs(prod.getPname());
			prod.setSpecList(spec);
			return prod;
		}else{
			throw new NotFoundException("Pid Not Found");
		}					
	}

}
