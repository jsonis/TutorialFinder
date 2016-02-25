/**
 * 
 */
package org.jitu.action;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import model.AccountDao;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.SessionAware;

import util.EncryptUtil;

import com.opensymphony.xwork2.ActionSupport;

import entities.Account;

/**
 * @author jsonis
 *
 */
public class AccountAction  extends ActionSupport implements SessionAware,ServletRequestAware{

	private static final long serialVersionUID =1l;
	
	private Map<String,Object> session;
	private HttpServletRequest request;
	
	private AccountDao accountDao = new AccountDao();
	
	private List<Account> lstAccounts;
	
	private String username;
	private String password;
	
	@Override
	public void setServletRequest(HttpServletRequest request) {
		// TODO Auto-generated method stub
		this.request=request;		
	}

	@Override
	public void setSession(Map<String, Object> session) {
		// TODO Auto-generated method stub
		this.session = session;		
	}

	@Override
	public String execute() throws Exception{
		return SUCCESS;
	}
	
	public String processLogin() throws Exception{
//		this.lstAccounts = accountDao.getAccounts();
//		for(Account account : lstAccounts){
//			if(account.getUsername().trim().equals(this.username)
//					&& account.getPassword().trim().equals(EncryptUtil.md5(this.password)));
//				this.session.put("username", account.getUsername());
//				return SUCCESS;
//		}
		if(this.username!=null && this.password!=null && this.username.equalsIgnoreCase("jsonis") && this.password.equals("password")){
			this.session.put("username", "jsonis");
			return SUCCESS;
		}else {
			request.setAttribute("message", "username or password is invalid");
			return ERROR;
		}
	}
	
	public String logout() throws Exception{
		if(this.session.containsKey("username")){
			this.session.remove("username");
		}
		return SUCCESS;
	}
	
	public List<Account> getLstAccounts() {
		return lstAccounts;
	}

	public void setLstAccounts(List<Account> lstAccounts) {
		this.lstAccounts = lstAccounts;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Map<String, Object> getSession() {
		return session;
	}

}
