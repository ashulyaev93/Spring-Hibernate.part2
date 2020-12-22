package ru.geekbrains.lesson4.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.geekbrains.lesson4.data.ProductData;
import ru.geekbrains.lesson4.entity.Product;

import java.util.Optional;

@Repository
public interface ProductDataRepository extends JpaRepository<Product, Long> {

    Optional<ProductData> findOneById(Long id);

}