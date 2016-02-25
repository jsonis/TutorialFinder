/**
 * 
 */
package org.jitu.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.jitu.form.Employee;

import java.sql.*;

/**
 * @author jsonis
 *
 */
public class EmployeeDao {

	String SQL_getAll = "Select employee_id,employee_fname,employee_lname,language,age,country,sex from employee";
	StringBuffer SQL_insert = new StringBuffer("Insert into employee (employee_fname,employee_lname,sex,age,country,language) values(?,?,?,?,?,?)");
	
	public EmployeeDao() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public List<?> getAllEmployees(){
		Connection con = DBConnection.getInstance(); 
		List<Employee> employeelst = new ArrayList<Employee>();
		try {
			Statement stmt   = con.createStatement();
			ResultSet rs     = stmt.executeQuery(SQL_getAll);
			while(rs.next()){
				
				int id=rs.getInt(1);
				String fname= rs.getString(2);
				System.out.println("!!!!Employee:"+id+fname);
				Employee et = new Employee();
				et.setId(id);
				et.setFname(fname);
				et.setLname(rs.getString(3));
				et.setLanguage(rs.getString(4));
				et.setAge(rs.getInt(5));
				et.setCountry(rs.getString(6));
				et.setSex(rs.getString(7));
				employeelst.add(et);
			}
			 
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return employeelst;
	}
	
	public void insertEmployee(String fname,String lname,String sex,int age,String country,String language){
		Connection con = DBConnection.getInstance(); 
//		StringBuffer str_insert = SQL_insert.append("'").append(fname).append("',").append("'").append(lname).append("',").append("'").append(sex).append("',").append(age).append(")");
//		System.out.println("SQL::"+str_insert);
		ResultSet rs = null;
		int insertedRow = 0;
		try {
			PreparedStatement stmt   = con.prepareStatement(SQL_insert.toString());
			stmt.setString(1, fname);
			stmt.setString(2, lname);
			stmt.setString(3, sex);
			stmt.setInt(4, age);
			stmt.setString(5, country);
			stmt.setString(6, language);
			
			insertedRow     = stmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
