package com.sapient.vo;

import java.util.List;

public class Product {
	private int pid;
	private String pname;
	private double price;
	private List<String> specList;
	//String category;
	
	public Product(int pid, String pname, double price) {
		super();
		this.pid = pid;
		this.pname = pname;
		this.price = price;
	}

	public List<String> getSpecList() {
		return specList;
	}

	public void setSpecList(List<String> specList) {
		this.specList = specList;
	}

	public int getPid() {
		return pid;
	}

	public String getPname() {
		return pname;
	}

	public double getPrice() {
		return price;
	}
	
	@Override
	public boolean equals(Object obj) {
		Product other = (Product) obj;		
		boolean bool = (this.pid == other.pid) && (this.pname.equals(other.pname)) && (this.price == other.price) && (this.specList.equals(other.specList));
		return bool;
	}
	
	
}
