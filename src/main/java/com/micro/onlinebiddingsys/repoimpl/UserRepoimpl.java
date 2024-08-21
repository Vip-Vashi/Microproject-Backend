package com.micro.onlinebiddingsys.repoimpl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.micro.onlinebiddingsys.model.User;
import com.micro.onlinebiddingsys.repository.UserRepo;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class UserRepoimpl implements UserRepo{

    @PersistenceContext
    private EntityManager entityManager;
    
    public User save(User user) {
       entityManager.persist(user); 
       return user;
       }
   
    public User findById(int id) {
        return entityManager.find(User.class, id);
    }

    public User update(User user) {
        entityManager.merge(user);
        return user;
    }
    
    public List<User> findAll() {
        return entityManager.createQuery("SELECT u FROM User u", User.class).getResultList();
    }
 
    public void delete(int id) {
        User user = findById(id);
        if (user != null) {
            entityManager.remove(user);
        }
    }
 
}
