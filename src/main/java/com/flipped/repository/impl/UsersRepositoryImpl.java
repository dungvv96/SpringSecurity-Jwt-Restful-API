/**
 * 
 */
package com.flipped.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.flipped.entity.Users;
import com.flipped.repository.UsersRepository;

/**
 * @author zz6unp
 *
 */
@Repository
@Transactional
public class UsersRepositoryImpl implements UsersRepository {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public void create(Users user) {
		entityManager.persist(user);

	}

	@Override
	public void update(Users user) {
		entityManager.merge(user);

	}

	@Override
	public void delete(Long id) {
		entityManager.remove(findById(id));

	}

	@Override
	public Users findById(Long id) {
		return entityManager.find(Users.class, id);
	}

	@Override
	public Users findByUsername(String username) {
		try {
			StringBuilder hql = new StringBuilder("select p from Users p where upper(p.username)=:username");
			TypedQuery<Users> query = entityManager.createQuery(hql.toString(), Users.class);
			query.setParameter("username", username.toUpperCase());
			return query.getSingleResult();
		}catch(NoResultException e) {
			return null;
		}
	}

	@Override
	public Users findByEmail(String email) {
		try {
			StringBuilder hql = new StringBuilder("select p from Users p where upper(p.email)=:email");
			TypedQuery<Users> query = entityManager.createQuery(hql.toString(),Users.class);
			query.setParameter("email", email.toUpperCase());
			return query.getSingleResult();
		}catch(NoResultException e) {
			return null;
		}
	}

	@Override
	public List<Users> find() {
		// TODO Auto-generated method stub
		return null;
	}

}
