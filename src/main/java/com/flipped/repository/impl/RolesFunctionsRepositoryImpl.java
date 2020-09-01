/**
 * 
 */
package com.flipped.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.flipped.entity.RolesFunctions;
import com.flipped.repository.RolesFunctionsRepository;

/**
 * @author zz6unp
 *
 */
@Repository
@Transactional
public class RolesFunctionsRepositoryImpl implements RolesFunctionsRepository {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public void create(RolesFunctions rolesFunctions) {
		entityManager.persist(rolesFunctions);

	}

	@Override
	public void update(RolesFunctions rolesFunctions) {
		entityManager.merge(rolesFunctions);

	}

	@Override
	public void delete(Long id) {
		entityManager.remove(findById(id));

	}

	@Override
	public RolesFunctions findById(Long id) {
		return entityManager.find(RolesFunctions.class, id);
	}

	@Override
	public RolesFunctions findByRoleCode(String roleCode) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public RolesFunctions find(String keyword) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<RolesFunctions> findByRoleId(Long roleId) {
		StringBuilder hql = new StringBuilder("select p from RolesFunctions p where p.role.id =:roleId");
		TypedQuery<RolesFunctions> query = entityManager.createQuery(hql.toString(),RolesFunctions.class);
		query.setParameter("roleId", roleId);
		return query.getResultList();
	}

}
