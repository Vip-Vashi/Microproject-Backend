package com.micro.onlinebiddingsys.repoimpl;

import com.micro.onlinebiddingsys.model.Biddings;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional
public class BidderRepoImpl  {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public Biddings saveBidding(Biddings bidding) {
//        if (bidding.getBidId() == 0) {
            entityManager.persist(bidding);
            return bidding;
//        } else {
//            return entityManager.merge(bidding);
//        }
    }

    public Biddings getBiddingById(int id) {
        return entityManager.find(Biddings.class, id);
    }

    @SuppressWarnings("unchecked")
    public List<Biddings> getAllBiddings() {
        return entityManager.createQuery("FROM Biddings").getResultList();
    }

    @Transactional
    public void deleteBidding(int id) {
        Biddings bidding = entityManager.find(Biddings.class, id);
        if (bidding != null) {
            entityManager.remove(bidding);
        }
    }
//    @Transactional
//    public List<Biddings> getBiddingbyProdId(int id) {
//       return entityManager.createQuery("FROM Biddings b WHERE b.product.productId = id").getResultList();
//    }
}