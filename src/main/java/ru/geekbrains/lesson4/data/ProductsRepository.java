package ru.geekbrains.lesson4.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.geekbrains.lesson4.entity.Product;
import ru.geekbrains.lesson4.entity.User;

import java.util.List;

@Repository
public interface ProductsRepository extends JpaRepository<Product, Long> {

    List<Product> findByTitle(String title);
    Product findOneByTitle(String title);

    @Query("select a from Product a where a.user = :user")
    List<Product> findProductByUser(@Param("user") User user);

}
