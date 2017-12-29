package com.sapient.vo;

public class Emp {

	private int eid;
	private String ename;
	private double sal;
	
	public Emp(int eid, String ename, double sal) {
		super();
		this.eid = eid;
		this.ename = ename;
		this.sal = sal;
	}
	
	@Override
	public boolean equals(Object obj) {
		Emp e2 = (Emp) obj;
		if(this.eid == e2.eid && this.ename.equals(e2.ename) && this.sal == e2.sal)
			return true;
		return false;
	}
	public int getEid() {
		return eid;
	}
	public String getEname() {
		return ename;
	}
	public double getSal() {
		return sal;
	}
	
	
			
}
