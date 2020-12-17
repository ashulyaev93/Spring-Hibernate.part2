package ru.geekbrains.lesson4.data;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import ru.geekbrains.lesson4.entity.Product;

@Repository
public interface ProductsPaginationRepository extends PagingAndSortingRepository<Product, Long> {

}
