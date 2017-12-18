
package com.tcs.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.tcs.model.Sort;

@Repository
public class SortDAOImpl implements SortDAO {
	
	private static final Logger logger = LoggerFactory.getLogger(SortDAOImpl.class);

	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}

	@Override
	public void saveSortedSequence(Sort p) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(p);
		logger.info("Sorted sequence saved successfully, Sorting Details="+p);
	}

	

	@SuppressWarnings("unchecked")
	@Override
	public List<Sort> listSorts() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Sort> sortsList = session.createQuery("from Sort").list();
		for(Sort p : sortsList){
			logger.info("Sort List::"+p);
		}
		return sortsList;
	}

	
	
}
