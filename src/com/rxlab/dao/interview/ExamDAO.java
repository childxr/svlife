package com.rxlab.dao.interview;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import com.rxlab.pojo.Exam;

public class ExamDAO {
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
    
    public void addExam(Exam exam) {
    	Session session = sessionFactory.openSession();
    	Transaction tx = null;
    	try {
    		tx = session.beginTransaction();
    		session.save(exam);
    		tx.commit();
    	} catch (HibernateException e) {
    		if (tx != null) tx.rollback();
    		e.printStackTrace();
    	} finally {
    		session.close();
    	}
    }
    
    
    @SuppressWarnings("unchecked")
    public Exam getExamById(int examId) {
    	Session session = sessionFactory.openSession();
    	Transaction tx = null;
    	Exam exam = null;
    	try {
    		tx = session.beginTransaction();
    		List<Exam> list = (List<Exam>)session.createSQLQuery("select * from exam where e_id = :id").addEntity(Exam.class).setParameter("id", examId).list();
    		if (list != null) exam = list.get(0);    		
    	} catch(HibernateException e) {
    		if (tx != null) tx.rollback();
    		e.printStackTrace();
    	} finally {
    		session.close();
    	}
    	return exam;
    }
    
    public int countExam() {
    	Session session = sessionFactory.openSession();
    	Transaction tx = null;
    	int count =  0;
    	try {
    		tx = session.beginTransaction();
    		count = ((Long) session.createQuery("select count(*) from Exam").iterate().next()).intValue();
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
