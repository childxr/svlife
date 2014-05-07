package com.rxlab.dao.interview;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import com.rxlab.pojo.Code;

public class CodeDAO {
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
	public List<Code> getAllCode(String category) {
    	Session session = sessionFactory.openSession();
    	Transaction tx = null;
    	List<Code> codeList = null;
    	try {
    		tx = session.beginTransaction();
    		if (category == null) codeList = (List<Code>)session.createQuery("FROM Code").list();
    		else codeList = session.createQuery("FROM Code C WHERE C.category like :category").setParameter("category", "%"+category+"%").list();	
    		tx.commit();
    	} catch (HibernateException e) {
    		if (tx != null) tx.rollback();
    		e.printStackTrace();
    	} finally {
    		session.close();
    	}
    	return codeList;
    }
    
    @SuppressWarnings("unchecked")
    public Code getCodeById(int id) {
    	Session session = sessionFactory.openSession();
    	Transaction tx = null;
    	Code code = null;
    	try {
    		tx = session.beginTransaction();
    		List<Code> list = (List<Code>)session.createSQLQuery("select * from coding where c_id = :id").addEntity(Code.class).setParameter("id", id).list();
    		if (list != null) code = list.get(0);    		
    	} catch(HibernateException e) {
    		if (tx != null) tx.rollback();
    		e.printStackTrace();
    	} finally {
    		session.close();
    	}
    	return code;
    }
    
    public void addCode(Code code) {
    	Session session = sessionFactory.openSession();
    	Transaction tx = null;
    	try {
    		tx = session.beginTransaction();
    		session.save(code);
    		tx.commit();
    	} catch (HibernateException e) {
    		if (tx != null) tx.rollback();
    		e.printStackTrace();
    	} finally {
    		session.close();
    	}
    }
}
