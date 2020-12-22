package ru.geekbrains.lesson4.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.geekbrains.lesson4.config.AppConfig;
import ru.geekbrains.lesson4.dao.impl.ProductDAO;
import ru.geekbrains.lesson4.data.ProductsRepository;
import ru.geekbrains.lesson4.entity.Product;
import ru.geekbrains.lesson4.entity.User;

public class MainDAO {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);


        ProductsRepository productsRepository = applicationContext.getBean("productsRepository", ProductsRepository.class);

//        productsRepository.save(new Product("New Title 1", new User("Alex")));
//        productsRepository.save(new Product("New Title 2", new User("Alena")));
//        productsRepository.save(new Product("New Title 3", new User("Milena")));
        productsRepository.save(new Product("New Title 5", (long)100,10.0));


        ProductDAO productDAO = applicationContext.getBean("productDAO", ProductDAO.class);
        System.out.println(productDAO.findMinPrice());

        //productDAO.findAll().stream().forEach(System.out::println);


    }

}
