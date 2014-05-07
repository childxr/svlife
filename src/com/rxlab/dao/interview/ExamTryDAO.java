package com.rxlab.dao.interview;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import com.rxlab.pojo.ExamTry;

public class ExamTryDAO {
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
    
    public void addExamTry(ExamTry examtry) {
    	Session session = sessionFactory.openSession();
    	Transaction tx = null;
    	try {
    		tx = session.beginTransaction();
    		session.save(examtry);
    		tx.commit();
    	} catch (HibernateException e) {
    		if (tx != null) tx.rollback();
    		e.printStackTrace();
    	} finally {
    		session.close();
    	}
    }
    
    @SuppressWarnings("unchecked")
    public List<ExamTry> getExamTryByPage(int numPerPage, int count, int pageNum) {
    	Session session = sessionFactory.openSession();
    	Transaction tx = null;
    	List<ExamTry> examList = null;
    	int start = (pageNum - 1) * numPerPage;
		int end = Math.min(pageNum * numPerPage, count);
		List<ExamTry> list = null;
    	try {
    		tx = session.beginTransaction();
			list = (List<ExamTry>) session.createQuery("FROM ExamTry E ORDER BY E.dateCreated DESC").list();
    		if (list != null) {
    			examList = new ArrayList<ExamTry>();
    			if (start < end) examList = list.subList(start, end);
    			else examList = null;
    		}
    		tx.commit();
    		
    	} catch(HibernateException e) {
    		if (tx != null) tx.rollback();
    		e.printStackTrace();
    	} finally {
    		session.close();
    	}
    	return examList;
    }
    
    public int countExamTry() {
    	Session session = sessionFactory.openSession();
    	Transaction tx = null;
    	int count =  0;
    	try {
    		tx = session.beginTransaction();
    		count = ((Long) session.createQuery("select count(*) from ExamTry").iterate().next()).intValue();
    		tx.commit();
    	} catch(HibernateException e) {
    		if (tx != null) tx.rollback();
    		e.printStackTrace();
    	} finally {
    		session.close();
    	}
    	return count;
    }
}
