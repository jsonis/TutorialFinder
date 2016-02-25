/**
 * 
 */
package model;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import entities.Account;
import util.HibernateUtil;

/**
 * @author jsonis
 *
 */
public class AccountDao {

	public List<Account> getAccounts(){
		Session session = HibernateUtil.getSessionfactory().openSession();
		Transaction transaction = null;
		try{
			transaction = session.beginTransaction();
			Query query = session.createQuery("From Account");
			List<Account> lstAccounts = query.list();
			transaction.commit();
			return lstAccounts;			
		}catch(Exception e){
			if(transaction == null){
				transaction.rollback();
			}
		}finally{
			session.close();
		}
		return null;
	}
	
}
