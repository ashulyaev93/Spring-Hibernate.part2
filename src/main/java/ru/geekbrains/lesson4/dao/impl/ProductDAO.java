package ru.geekbrains.lesson4.dao.impl;

import org.springframework.stereotype.Repository;
import ru.geekbrains.lesson4.entity.Product;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public interface ProductDAO {
    List<Product> findAll();
    void save(Product product);
    Product findById(Long id);
    void update(Product product);
    void delete(Product product);
}

@Repository
class ProductDAOImpl implements ProductDAO {
    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public List < Product > findAll () {
        return entityManager . createQuery ( "from Product" ,
                Product . class ). getResultList ();
    }
    @Override
    public void save ( Product product ) {
        entityManager . persist ( product );
    }
    @Override
    public Product findById ( Long id ) {
        return entityManager . find ( Product . class , id );
    }
    @Override
    public void update ( Product product ) {
        entityManager . merge ( product );
    }
    @Override
    public void delete ( Product product ) {
        entityManager . remove ( product );
    }
}
