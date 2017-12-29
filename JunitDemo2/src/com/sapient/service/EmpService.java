package com.sapient.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.sapient.vo.Emp;

public class EmpService {
	private static Connection conn = null;
	
	static{
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "SYSTEM", "sapirnt123");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	EmpService() {

	}
	
	public Emp getEmployee(int eid) throws NotFoundException{
		Emp e = null;
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement("SELECT ename, sal FROM sap_emp WHERE eid=?");
			ps.setInt(1, eid);
			ResultSet rs = ps.executeQuery();
			if (!rs.next() ) {
			    throw new NotFoundException("Not Found");
			}else{
				e = new Emp(eid, rs.getString("ename"), rs.getDouble("sal"));
			}
			conn.close();
			return e;
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return e;

	}
}
