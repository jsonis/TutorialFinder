/**
 * 
 */
package org.jitu.action;

import java.util.List;

import org.jitu.dao.CountryLanguageDao;
import org.jitu.dao.EmployeeDao;

/**
 * @author jsonis
 *
 */
public class EmployeeServiceFinder {

	
	public void addEmployee(String fname,String lname,String sex,int age,String country,String language){
		EmployeeDao employeeDao = new EmployeeDao();
		employeeDao.insertEmployee(fname,lname,sex,age,country,language);
	}
	
	public List<?> getAllCountryLanguage(){
		EmployeeDao employeeDao = new EmployeeDao();
		return employeeDao.getAllEmployees();
	}
	
	
}
