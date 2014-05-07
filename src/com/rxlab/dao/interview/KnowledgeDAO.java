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

import com.rxlab.pojo.Knowledge;

public class KnowledgeDAO {
	
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
	public List<Knowledge> getAllKnowledge() {
    	Session session = sessionFactory.openSession();
    	Transaction tx = null;
    	List<Knowledge> knowledgeList = null;
    	try {
    		tx = session.beginTransaction();
    		knowledgeList = (List<Knowledge>)session.createQuery("FROM Knowledge").list();
    		tx.commit();
    		
    	} catch (HibernateException e) {
    		if (tx != null) tx.rollback();
    		e.printStackTrace();
    	} finally {
    		session.close();
    	}
    	return knowledgeList;
    }
    
    public void addKnowledge(Knowledge knowledge) {
		Session session = sessionFactory.openSession();
    	Transaction tx = null;
    	try {
    		tx = session.beginTransaction();
    		session.save(knowledge);
    		tx.commit();
    	} catch (HibernateException e) {
    		if (tx != null) tx.rollback();
    		e.printStackTrace();
    	} finally {
    		session.close();
    	}
	}
    
    public int countKnowledge(String category) {
    	Session session = sessionFactory.openSession();
    	Transaction tx = null;
    	int count =  0;
    	try {
    		tx = session.beginTransaction();
    		if (category == null) count = ((Long) session.createQuery("select count(*) from Knowledge").iterate().next()).intValue();
    		else count = ((Long) session.createQuery("select count(*) from Knowledge k where k.category = :category").setParameter("category", category).iterate().next()).intValue();
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
	public List<Knowledge> getAllKnowledgeByPage(String category, int numPerPage, int pageNum, int count) {
    	Session session = sessionFactory.openSession();
    	Transaction tx = null;
    	List<Knowledge> knowledgeList = null;
    	int start = (pageNum - 1) * numPerPage;
		int end = Math.min(pageNum * numPerPage, count);
    	System.out.println(count);
    	try {
    		tx = session.beginTransaction();
    		if (category == null) {
    			knowledgeList = (List<Knowledge>) session.createSQLQuery("select * from knowledge where k_id > :start and k_id <= :end").addEntity(Knowledge.class).setParameter("start", start).setParameter("end", end).list();
    		} else {
    			List<Knowledge> list = (List<Knowledge>) session.createSQLQuery("select * from knowledge where category = :category").addEntity(Knowledge.class).setParameter("category", category).list();
    			knowledgeList = new ArrayList<Knowledge>();
    			for (int i = start; i < end; i++) {
    				knowledgeList.add(list.get(i));
    			}
    		}
    		tx.commit();
    	} catch(HibernateException e) {
    		if (tx != null) tx.rollback();
    		e.printStackTrace();
    	} finally {
    		session.close();
    	}
    	return knowledgeList;
    }
    
    
    @SuppressWarnings("unchecked")
	public Knowledge getRandomKnowledge(String category) {
    	Session session = sessionFactory.openSession();
    	Transaction tx = null;
    	Knowledge knowledge = null;
    	List<Knowledge> list = null;
    	try {
    		tx = session.beginTransaction();
    		if (category == null) list = (List<Knowledge>) session.createSQLQuery("select * from knowledge").addEntity(Knowledge.class).list();
    		else list = (List<Knowledge>) session.createSQLQuery("select * from knowledge where category = :category").addEntity(Knowledge.class).setParameter("category",category).list();
    		tx.commit();
    		if (list != null) knowledge = list.get((int)(Math.random()*list.size()));
    	} catch(HibernateException e) {
    		if (tx != null) tx.rollback();
    		e.printStackTrace();
    	} finally {
    		session.close();
    	}
    	return knowledge;
    }
    
    
    @SuppressWarnings("unchecked")
	public Knowledge getKnowledgeById(int id) {
    	Session session = sessionFactory.openSession();
    	Transaction tx = null;
    	Knowledge knowledge = null;
    	try {
    		tx = session.beginTransaction();
    		List<Knowledge> list = (List<Knowledge>)session.createSQLQuery("select * from knowledge where k_id = :id").addEntity(Knowledge.class).setParameter("id", id).list();
    		if (list != null) knowledge = list.get(0);    		
    	} catch(HibernateException e) {
    		if (tx != null) tx.rollback();
    		e.printStackTrace();
    	} finally {
    		session.close();
    	}
    	return knowledge;
    }
}
