package com.micro.onlinebiddingsys.repoimpl;


import com.micro.onlinebiddingsys.model.Seller;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional
public class SellerRepoImpl   {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public Seller saveSeller(Seller seller) {
        if (seller.getSellerId() == 0) {
            entityManager.persist(seller);
            return seller;
        } else {
            return entityManager.merge(seller);
        }
    }
    
    public Seller getSellerById(int id) {
        return entityManager.find(Seller.class, id);
    }

    @SuppressWarnings("unchecked")
    public List<Seller> getAllSellers() {
        return entityManager.createQuery("FROM Seller").getResultList();
    }

    @Transactional
    public void deleteSeller(int id) {
        Seller seller = entityManager.find(Seller.class, id);
        if (seller != null) {
            entityManager.remove(seller);
        }
    }
}