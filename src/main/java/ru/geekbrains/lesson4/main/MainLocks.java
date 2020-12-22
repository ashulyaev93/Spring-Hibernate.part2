package ru.geekbrains.lesson4.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.geekbrains.lesson4.config.AppConfig;
import ru.geekbrains.lesson4.entity.Product;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.LockModeType;
import java.util.List;

public class MainLocks {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);

        EntityManagerFactory entityManagerFactory = applicationContext.getBean("entityManagerFactory", EntityManagerFactory.class);
        EntityManager em = entityManagerFactory.createEntityManager();


        em.getTransaction().begin();

        Product p = new Product();
        p.setName("Apple");
        em.persist(p);

        em.getTransaction().commit();


        em.getTransaction().begin();
        Product product = em.find(Product.class, 1L);

        em.lock(product, LockModeType.OPTIMISTIC);
        em.lock(product, LockModeType.OPTIMISTIC_FORCE_INCREMENT);

        em.lock(product, LockModeType.PESSIMISTIC_READ);
        em.lock(product, LockModeType.PESSIMISTIC_WRITE);
        em.lock(product, LockModeType.PESSIMISTIC_FORCE_INCREMENT);


        product.setName("Orange");
        System.out.println("product = " + product);
        em.flush();
        product.setName("Mango");
        System.out.println("product = " + product);
        em.flush();
        System.out.println("product = " + product);
        em.getTransaction().rollback();

        em.getTransaction().begin();
        product = em.find(Product.class, 1L);
        System.out.println("product = " + product);
        em.getTransaction().commit();


        em.getTransaction().begin();
        Product p2 = new Product();
        p2.setName("Apple");
        em.persist(p2);
        em.getTransaction().commit();


        em.getTransaction().begin();

        int allQuantity = 0;
        List<Product> products = em.createQuery("FROM Product", Product.class)
                .setLockMode(LockModeType.PESSIMISTIC_WRITE)
                .getResultList();

//        for (Product item : products) {
//
//        }

        em.getTransaction().commit();

        em.close();
    }
}
