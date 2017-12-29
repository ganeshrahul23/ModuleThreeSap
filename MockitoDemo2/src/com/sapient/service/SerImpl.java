package com.sapient.service;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.sapient.dao.IDao;
import com.sapient.vo.Emp;

public class SerImpl implements ISer {
	
	private IDao dao;

	public void setDao(IDao dao) {
		this.dao = dao;
	}

	@Override
	public List<Emp> viewEmployee(String order) {
		List<Emp> lst = dao.getEmployee();
		Comparator<Emp> comp = null;
		switch (order) 
		{
			case "id": comp = (Emp e1, Emp e2) -> {	Integer i1 = e1.getEid();
													Integer i2 = e2.getEid();
													return i1.compareTo(i2);
												};
							  break;
												
			case "name": comp = (Emp e1, Emp e2) -> {return e1.getEname().compareTo(e2.getEname());};
								break;		
			
			case "salary": comp = (Emp e1, Emp e2) -> {	Double i1 = e1.getSal();
														Double i2 = e2.getSal();
														return i1.compareTo(i2);
													};
								  break;
			default:
				break;
		}
		
		Collections.sort(lst, comp);
		
		return lst;
	}

}
