package com.comodo.dao;

import com.comodo.model.User;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

/*
    Created by Dmitriy Laletin 
    on 8:03 PM 5/3/2018 May 2018
*/
@Repository
@Transactional()
public class UserDAOImpl implements UserDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public User save(User user) {
        if(user.getId() != null){
            return entityManager.merge(user);
        } else {
            entityManager.persist(user);
            return user;
        }
    }

    @Override
    public List<User> getAll() {
        CriteriaQuery<User> criteria = entityManager.getCriteriaBuilder().createQuery(User.class);
        criteria.select(criteria.from(User.class));
        return entityManager.createQuery(criteria).getResultList();
    }

    @Override
    public List<User> getAllByFirstName(String firstName) {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<User> criteria = builder.createQuery(User.class);
        Root<User> root = criteria.from( User.class );
        criteria.select(root);
        criteria.where(builder.equal(root.get("firstName"), firstName));
        return entityManager.createQuery(criteria).getResultList();
    }

    @Override
    public List<User> getAllByLastName(String lastName) {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<User> criteria = builder.createQuery(User.class);
        Root<User> root = criteria.from( User.class );
        criteria.select(root);
        criteria.where(builder.equal(root.get("lastName"), lastName));
        return entityManager.createQuery(criteria).getResultList();
    }

    @Override
    public List<User> getAllByGender(String gender) {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<User> criteria = builder.createQuery(User.class);
        Root<User> root = criteria.from( User.class );
        criteria.select(root);
        criteria.where(builder.equal(root.get("gender"), gender));
        return entityManager.createQuery(criteria).getResultList();
    }

    @Override
    public User getById(Long id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public void remove(Long id) {
        User user = getById(id);
        if(user != null) {
            entityManager.remove(user);
        }
    }
}
