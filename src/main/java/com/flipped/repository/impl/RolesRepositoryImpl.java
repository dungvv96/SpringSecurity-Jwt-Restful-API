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

import com.flipped.entity.Roles;
import com.flipped.repository.RolesRepository;

/**
 * @author zz6unp
 *
 */
@Repository
@Transactional
public class RolesRepositoryImpl implements RolesRepository{

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public void create(Roles role) {
		entityManager.persist(role);
		
	}

	@Override
	public void update(Roles role) {
		entityManager.merge(role);
		
	}

	@Override
	public void delete(Long id) {
		entityManager.remove(findById(id));
		
	}

	@Override
	public Roles findById(Long id) {
		return entityManager.find(Roles.class, id);
	}

	@Override
	public List<Roles> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Roles findByRoleCode(String roleCode) {
		// TODO Auto-generated method stub
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Roles> find(String keyword) {
		FullTextEntityManager fullTextEntityManager = Search.getFullTextEntityManager(entityManager);
		org.hibernate.search.query.dsl.QueryBuilder queryBuilder = fullTextEntityManager.getSearchFactory()
				.buildQueryBuilder()
				.forEntity(Roles.class)
				.get();
		org.apache.lucene.search.Query query = queryBuilder
				.keyword()
				.onFields("roleCode","roleName","descriptions","status")
				.matching(keyword)
				.createQuery();
		FullTextQuery jpaQuery = fullTextEntityManager.createFullTextQuery(query,Roles.class);
		return jpaQuery.getResultList();
	}

}
