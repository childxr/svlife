package com.rxlab.dao.interview;

import java.util.ArrayList;
import java.util.List;

import com.rxlab.pojo.CodeComment;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class CodeCommentDAO {
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
    public List<CodeComment> getCodeCommentByCodeId(int id) {
    	Session session = sessionFactory.openSession();
    	Transaction tx = null;
    	List<CodeComment> codeComment = null;
    	try {
    		tx = session.beginTransaction();
    		codeComment = (List<CodeComment>)session.createSQLQuery("select * from coding_comment where c_id = :id").addEntity(CodeComment.class).setParameter("id", id).list();
    	} catch(HibernateException e) {
    		if (tx != null) tx.rollback();
    		e.printStackTrace();
    	} finally {
    		session.close();
    	}
    	return codeComment;
    }
    
    public void addCodeComment(CodeComment ccomment) {
		Session session = sessionFactory.openSession();
    	Transaction tx = null;
    	try {
    		tx = session.beginTransaction();
    		session.save(ccomment);
    		tx.commit();
    	} catch (HibernateException e) {
    		if (tx != null) tx.rollback();
    		e.printStackTrace();
    	} finally {
    		session.close();
    	}
	}
    
    @SuppressWarnings("unchecked")
    public int countCodeComment(String category) {
    	Session session = sessionFactory.openSession();
    	Transaction tx = null;
    	int count =  0;
    	try {
    		tx = session.beginTransaction();
    		if (category == null) System.out.println("category = "+null);
    		if (category == null) count = ((Long) session.createQuery("select count(*) from CodeComment").iterate().next()).intValue();
    		else{
    			System.out.println("NOT NULL1");
    			List<CodeComment>list = (List<CodeComment>) session.createQuery("FROM CodeComment").list();
    			if (list != null) {
    				ArrayList<CodeComment> commentList = new ArrayList<CodeComment> ();
    				for (CodeComment cc: list) {
    					if (cc.getCode().getCategory().contains(category)) commentList.add(cc);
    				}
    				count = commentList.size();
    			}
    			System.out.println(count);
    		}
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
    public List<CodeComment> listCodeCommentHistoryByPage(int pageNum, int numPerPage, int count, String category) {
    	Session session = sessionFactory.openSession();
    	Transaction tx = null;
    	List<CodeComment> commentList = null;
    	int start = (pageNum - 1) * numPerPage;
		int end = Math.min(pageNum * numPerPage, count);
		//System.out.println(start+" "+end);
		List<CodeComment> list = null;
    	try {
    		tx = session.beginTransaction();
    		if (category == null) {
    			list = (List<CodeComment>) session.createQuery("FROM CodeComment C ORDER BY C.dateCreated DESC").list();
    			if (list != null) {
        			commentList = new ArrayList<CodeComment>();
        			commentList = list.subList(start, end);
        		}
    		}
    		else {
    			list = (List<CodeComment>) session.createQuery("FROM CodeComment C ORDER BY C.dateCreated DESC").list();
    			if (list != null) {
    				System.out.println("NOT NULL2");
    				List<CodeComment>lst = new ArrayList<CodeComment> ();
    				for (CodeComment cc: list) {
    					if (cc.getCode().getCategory().contains(category)) lst.add(cc); 
    				}
    				if (lst != null) {
    					commentList = new ArrayList<CodeComment>();
            			commentList = list.subList(start, end);
    				}
        		}
    		}
    			
    		
    		tx.commit();
    		//System.out.println(commentList.size());
    		//for (CodeComment cc: commentList) System.out.println(cc.getCode().getQuestion());
    	} catch(HibernateException e) {
    		if (tx != null) tx.rollback();
    		e.printStackTrace();
    	} finally {
    		session.close();
    	}
    	return commentList;
    }
}
