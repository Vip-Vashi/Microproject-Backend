package com.micro.onlinebiddingsys.repoimpl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.micro.onlinebiddingsys.model.Product;
import com.micro.onlinebiddingsys.model.Winner;
import com.micro.onlinebiddingsys.repository.WinnerRepository;

@Repository
public class WinnerRepositoryImpl implements WinnerRepository{

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public Winner save(Winner winner) {
        entityManager.persist(winner);
        return winner;
    }

    @Transactional
    public Winner update(Winner winner) {
        return entityManager.merge(winner);
    }

    public Winner findById(int id) {
        return entityManager.find(Winner.class, id);
    }

    @Transactional
    public void delete(Winner winner) {
        entityManager.remove(entityManager.contains(winner) ? winner : entityManager.merge(winner));
    }
    
    public List<Winner> findAllWins() {
        String hql = "from Winner";
        Query query = entityManager.createQuery(hql);
        return query.getResultList();
    }

}