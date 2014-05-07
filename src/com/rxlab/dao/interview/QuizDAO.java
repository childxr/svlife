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

import com.rxlab.pojo.Quiz;

public class QuizDAO {
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
	
	public void addQuiz(Quiz quiz) {
		Session session = sessionFactory.openSession();
    	Transaction tx = null;
    	try {
    		tx = session.beginTransaction();
    		session.save(quiz);
    		tx.commit();
    	} catch (HibernateException e) {
    		if (tx != null) tx.rollback();
    		e.printStackTrace();
    	} finally {
    		session.close();
    	}
	}
	
	
	public int countQuiz(String category) {
		Session session = sessionFactory.openSession();
    	Transaction tx = null;
    	int count =  0;
    	try {
    		tx = session.beginTransaction();
    		if (category == null) count = ((Long) session.createQuery("select count(*) from Quiz").iterate().next()).intValue();
    		else count = ((Long) session.createQuery("select count(*) from Quiz q where q.knowledge.category = :category").setParameter("category", category).iterate().next()).intValue();
    		tx.commit();
    	} catch(HibernateException e) {
    		if (tx != null) tx.rollback();
    		e.printStackTrace();
    	} finally {
    		session.close();
    	}
    	return count;
	}
	
	
	@SuppressWarnings("unchecked")
	public List<Quiz> getAllQuizByPage(String category, int numPerPage, int count, int pageNum) {
		Session session = sessionFactory.openSession();
    	Transaction tx = null;
    	List<Quiz> quizList = null;
    	int start = (pageNum - 1) * numPerPage;
		int end = Math.min(pageNum * numPerPage, count);
		List<Quiz> list = null;
    	try {
    		tx = session.beginTransaction();
    		if (category == null) {
    			list = (List<Quiz>) session.createQuery("FROM Quiz Q ORDER BY Q.timeCreated DESC").list();
    		} else {
    			list = (List<Quiz>) session.createQuery("FROM Quiz Q WHERE Q.knowledge.category = :category ORDER BY Q.timeCreated DESC").setParameter("category", category).list();	
    		}
    		if (list != null) {
    			quizList = new ArrayList<Quiz>();
    			if (start < end) quizList = list.subList(start, end);
    			else quizList = null;
    		}
    		tx.commit();
    		
    	} catch(HibernateException e) {
    		if (tx != null) tx.rollback();
    		e.printStackTrace();
    	} finally {
    		session.close();
    	}
    	return quizList;
	}
}
