/**
 * 
 */
package com.flipped.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.search.jpa.FullTextEntityManager;
import org.hibernate.search.jpa.FullTextQuery;
import org.hibernate.search.jpa.Search;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.flipped.entity.Functions;
import com.flipped.repository.FunctionsRepository;

/**
 * @author zz6unp
 *
 */
@Repository
@Transactional
public class FunctionsRepositoryImpl implements FunctionsRepository {

	@PersistenceContext
	EntityManager entityManager;
	
	@Override
	public void create(Functions function) {
		entityManager.persist(function);

	}

	@Override
	public void update(Functions function) {
		entityManager.merge(function);

	}

	@Override
	public void delete(Long id) {
		entityManager.remove(findById(id));

	}

	@Override
	public List<Functions> findAll() {
		return null;
	}

	@Override
	public Functions findById(Long id) {
		return entityManager.find(Functions.class, id);
	}

	@Override
	public Functions findByFunctionCode(String functionCode) {
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Functions> find(String keyword) {
		FullTextEntityManager fullTextEntityManager = Search.getFullTextEntityManager(entityManager);
		org.hibernate.search.query.dsl.QueryBuilder queryBuilder = fullTextEntityManager.getSearchFactory()
				.buildQueryBuilder()
				.forEntity(Functions.class)
				.get();
		
		org.apache.lucene.search.Query query = queryBuilder
				.keyword()
				.onFields("functionCode", "functionName", "linkApi", "descriptions")
				.matching(keyword)
				.createQuery();
		FullTextQuery jpaQuery = fullTextEntityManager.createFullTextQuery(query, Functions.class);
		return jpaQuery.getResultList();
	}

}
