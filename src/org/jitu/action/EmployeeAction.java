/**
 * 
 */
package org.jitu.action;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import model.AccountDao;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.SessionAware;
import org.jitu.dao.CountryLanguage;
import org.jitu.dao.EmployeeDao;
import org.jitu.form.Employee;

import com.opensymphony.xwork2.ActionSupport;

/**
 * @author jsonis
 *
 */
public class EmployeeAction extends ActionSupport implements SessionAware,ServletRequestAware{

    private EmployeeServiceFinder employeeServiceFinder = null;
	private static final long serialVersionUID =1l;
	
	private Map<String,Object> session;
	private HttpServletRequest request;
	
	private String fname;
	private String lname;
	private String sex;
	private String country;
	private String language;
	private int age;
	
	private List<Employee> lstEmployee= new ArrayList<Employee>();
	
	
	
	
	/**
	 * @return the country
	 */
	public String getCountry() {
		return country;
	}

	/**
	 * @param country the country to set
	 */
	public void setCountry(String country) {
		this.country = country;
	}

	/**
	 * @return the language
	 */
	public String getLanguage() {
		return language;
	}

	/**
	 * @param language the language to set
	 */
	public void setLanguage(String language) {
		this.language = language;
	}

	/**
	 * @return the lstEmployee
	 */
	public List<Employee> getLstEmployee() {
		return lstEmployee;
	}

	/**
	 * @param lstEmployee the lstEmployee to set
	 */
	public void setLstEmployee(List<Employee> lstEmployee) {
		this.lstEmployee = lstEmployee;
	}

	public String execute(){
		try{
			employeeServiceFinder = new EmployeeServiceFinder();
			List<Employee> employeelst = (List<Employee>) employeeServiceFinder.getAllCountryLanguage();
		
			Iterator itr = employeelst.iterator();
			while(itr.hasNext()){
				Employee emp = (Employee) itr.next();
				System.out.println("@@ best Site:"+emp.toString());
			}
			//System.out.println("@@ best Site:"+lstCountryLanguage.size());
			
			this.session.put("employee",employeelst);
		}catch(Exception e){
			e.printStackTrace();
		}
		return "success";

	}

	/**
	 * @return the session
	 */
	public Map<String, Object> getSession() {
		return session;
	}

	/**
	 * @param session the session to set
	 */
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	/**
	 * @return the request
	 */
	public HttpServletRequest getRequest() {
		return request;
	}

	/**
	 * @param request the request to set
	 */
	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}
	
	public String processEmployee() throws Exception{
		System.out.println("##############Inside process Employee");
		employeeServiceFinder = new EmployeeServiceFinder();
//		this.lstAccounts = accountDao.getAccounts();
//		for(Account account : lstAccounts){
//			if(account.getUsername().trim().equals(this.username)
//					&& account.getPassword().trim().equals(EncryptUtil.md5(this.password)));
//				this.session.put("username", account.getUsername());
//				return SUCCESS;
//		}
		if(this.fname!=null){
			employeeServiceFinder.addEmployee(fname,lname,sex,age,country,language);
			return SUCCESS;
		}else {
			request.setAttribute("message", "username or password is invalid");
			return ERROR;
		}
	}
	



	/**
	 * @return the fname
	 */
	public String getFname() {
		return fname;
	}

	/**
	 * @param fname the fname to set
	 */
	public void setFname(String fname) {
		this.fname = fname;
	}

	/**
	 * @return the lname
	 */
	public String getLname() {
		return lname;
	}

	/**
	 * @param lname the lname to set
	 */
	public void setLname(String lname) {
		this.lname = lname;
	}

	/**
	 * @return the sex
	 */
	public String getSex() {
		return sex;
	}

	/**
	 * @param sex the sex to set
	 */
	public void setSex(String sex) {
		this.sex = sex;
	}

	/**
	 * @return the age
	 */
	public int getAge() {
		return age;
	}

	/**
	 * @param age the age to set
	 */
	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public void setServletRequest(HttpServletRequest arg0) {
		// TODO Auto-generated method stub
		
	}
	
}
