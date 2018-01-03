package com.sapient.vo;

public class Account {
	
	private int accID;
	private String custName;
	private double bal;
	
	public Account(int accID, String custName, double bal) {
		super();
		this.accID = accID;
		this.custName = custName;
		this.bal = bal;
	}

	public double getBal() {
		return bal;
	}

	public void setBal(double bal) {
		this.bal = bal;
	}

	public int getAccID() {
		return accID;
	}

	public String getCustName() {
		return custName;
	}
	
}
