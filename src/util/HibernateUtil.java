/**
 * 
 */
package util;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

/**
 * Hibernate Utility class with a convenient method to get Session factory object
 * 
 * @author jsonis
 *
 *	
 */
@SuppressWarnings("deprecation")
public class HibernateUtil {

	private static final SessionFactory sessionfactory;
	
	static{
		try{
			sessionfactory = new AnnotationConfiguration().configure().buildSessionFactory();
		}catch(Throwable ex){
			System.err.println("Initial SessionFactory creation failed" +ex);
			throw new ExceptionInInitializerError(ex);
		}
	}

	public static SessionFactory getSessionfactory() {
		return sessionfactory;
	}
	
}
