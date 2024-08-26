package com.micro.onlinebiddingsys.repoimpl;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;

import java.util.List;

import org.apache.logging.log4j.util.StringBuilderFormattable;
import org.springframework.stereotype.Repository;

import com.micro.onlinebiddingsys.model.Product;
import com.micro.onlinebiddingsys.repository.ProductRepository;
@Transactional
@Repository
public class ProductRepositoryImpl implements ProductRepository{

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public Product save(Product product) {
        entityManager.persist(product);
        return product;
    }

    @Transactional
    public Product update(Product product) {
        return entityManager.merge(product);
    }

    public Product findById(int id) {
        return entityManager.find(Product.class, id);
    }
    
    public List<Product> findAll() {
        String hql = "from Product";
        Query query = entityManager.createQuery(hql);
        return query.getResultList();
    }

    @Transactional
    public void delete(Product product) {
        entityManager.remove(entityManager.contains(product) ? product : entityManager.merge(product));
    }
}