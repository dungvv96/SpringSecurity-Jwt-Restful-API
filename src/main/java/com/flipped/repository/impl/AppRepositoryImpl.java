/**
 * 
 */
package com.flipped.repository.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.search.jpa.FullTextEntityManager;
import org.hibernate.search.jpa.Search;
import org.springframework.stereotype.Repository;

import com.flipped.repository.AppRepository;

/**
 * @author zz6unp
 *
 */
@Repository
public class AppRepositoryImpl implements AppRepository {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public void indexData() {
		try {
			FullTextEntityManager fullTextEntityManager = Search.getFullTextEntityManager(entityManager);
			fullTextEntityManager.createIndexer().startAndWait();
		}catch(Exception e) {
			e.printStackTrace();
		}

	}

}
