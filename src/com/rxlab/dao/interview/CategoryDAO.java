package com.rxlab.dao.interview;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import com.rxlab.pojo.Category;

public class CategoryDAO {
	private static SessionFactory sessionFactory = getSessionFactory();
	private static ServiceRegistry serviceRegistry;
	
	private static SessionFactory configureSessionFactory() throws HibernateException {
        Configuration configuration = new Configuration();
        configuration.configure();
        serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();        
        sessionFactory = configuration.buildSessionFactory(serviceRegistry);
        return sessionFactory;
    }
	
	public static SessionFactory getSessionFactory() {
        return configureSessionFactory();
    }
	
	
	@SuppressWarnings("unchecked")
	public List<Category> getAllKnowledgeCategories() {
		Session session = sessionFactory.openSession();
    	Transaction tx = null;
    	List<Category> categoryList = null;
    	try {
    		tx = session.beginTransaction();
    		categoryList = (List<Category>)session.createQuery("FROM Category").list();
    		tx.commit();
    		
    	} catch (HibernateException e) {
    		if (tx != null) tx.rollback();
    		e.printStackTrace();
    	} finally {
    		session.close();
    	}
    	return categoryList;
	}
}
